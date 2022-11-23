package ame.psb.db.dao;

import ame.psb.db.Instrument;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class InstrumentDao { //ZD_INSTRUMENT表的dao层

  private static final String SQL_INS = "INSERT INTO zd_instrument(uuid,category,name,code,description,created_date_time,modified_date_time,value,comment,remarks,note) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_instrument SET category=?,name=?,code=?,description=?,created_date_time=?,modified_date_time=?,value=?,comment=?,remarks=?,note=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,category,name,code,description,created_date_time,modified_date_time,value,comment,remarks,note FROM zd_instrument ";

  private final Connection conn;

  public InstrumentDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Instrument data) throws SQLException { //单条插入
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getCategory());
      ps.setString(3, data.getName());
      ps.setString(4, data.getCode());
      ps.setString(5, data.getDescription());
      DateUtils.setDateTz(ps, 6, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 7, data.getModifiedDateTime());
      ps.setString(8, data.getValue());
      ps.setString(9, data.getComment());
      ps.setString(10, data.getRemarks());
      ps.setString(11, data.getNote());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Instrument> dataList) throws SQLException { //多条插入
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Instrument data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getCategory());
        ps.setString(3, data.getName());
        ps.setString(4, data.getCode());
        ps.setString(5, data.getDescription());
        DateUtils.setDateTz(ps, 6, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 7, data.getModifiedDateTime());
        ps.setString(8, data.getValue());
        ps.setString(9, data.getComment());
        ps.setString(10, data.getRemarks());
        ps.setString(11, data.getNote());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Instrument data) throws SQLException { //单条更新
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCategory());
      ps.setString(2, data.getName());
      ps.setString(3, data.getCode());
      ps.setString(4, data.getDescription());
      DateUtils.setDateTz(ps, 5, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 6, data.getModifiedDateTime());
      ps.setString(7, data.getValue());
      ps.setString(8, data.getComment());
      ps.setString(9, data.getRemarks());
      ps.setString(10, data.getNote());
      ps.setString(11, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<Instrument> dataList) throws SQLException { //多条更新
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Instrument data : dataList) {
        ps.setString(1, data.getCategory());
        ps.setString(2, data.getName());
        ps.setString(3, data.getCode());
        ps.setString(4, data.getDescription());
        DateUtils.setDateTz(ps, 5, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 6, data.getModifiedDateTime());
        ps.setString(7, data.getValue());
        ps.setString(8, data.getComment());
        ps.setString(9, data.getRemarks());
        ps.setString(10, data.getNote());
        ps.setString(11, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException { //根据主键删除
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_instrument WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<Instrument> selectAll() throws SQLException { //查询全部记录
    ArrayList<Instrument> result = new ArrayList<Instrument>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Instrument selectByPK(String uuid) throws SQLException { //根据主键查询
    Instrument result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<Instrument> selectByCode(String code) throws SQLException { //弹窗-根据类别代码查询
    ArrayList<Instrument> result = new ArrayList<Instrument>();

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE code=?")) {
      ps.setString(1, code);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  private Instrument convert(ResultSet rs) throws SQLException {
    Instrument data = new Instrument();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setCategory(rs.getString(index++));
    data.setName(rs.getString(index++));
    data.setCode(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setValue(rs.getString(index++));
    data.setComment(rs.getString(index++));
    data.setRemarks(rs.getString(index++));
    data.setNote(rs.getString(index++));

    return data;
  }
}
