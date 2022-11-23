package ame.me.db.dao;

import ame.me.db.ZhNpiFactor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZhNpiFactorDao {

  private static final String SQL_INS = "INSERT INTO zh_npi_factor(factor,description,factor_type,default_value,range,attached_to_gbo,seq,updated_user,updated_time,validator) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_npi_factor SET description=?,factor_type=?,default_value=?,range=?,attached_to_gbo=?,seq=?,updated_user=?,updated_time=?,validator=? WHERE factor=?";

  private static final String SQL_SEL = "SELECT factor,description,factor_type,default_value,range,attached_to_gbo,seq,updated_user,updated_time,validator FROM zh_npi_factor ";

  private final Connection conn;

  public ZhNpiFactorDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZhNpiFactor data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getFactor());
      ps.setString(2, data.getDescription());
      ps.setString(3, data.getFactorType());
      ps.setString(4, data.getDefaultValue());
      ps.setString(5, data.getRange());
      ps.setString(6, data.getAttachedToGbo());
      ps.setString(7, data.getSeq());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getValidator());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZhNpiFactor> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZhNpiFactor data : dataList) {
        ps.setString(1, data.getFactor());
        ps.setString(2, data.getDescription());
        ps.setString(3, data.getFactorType());
        ps.setString(4, data.getDefaultValue());
        ps.setString(5, data.getRange());
        ps.setString(6, data.getAttachedToGbo());
        ps.setString(7, data.getSeq());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getValidator());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZhNpiFactor data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDescription());
      ps.setString(2, data.getFactorType());
      ps.setString(3, data.getDefaultValue());
      ps.setString(4, data.getRange());
      ps.setString(5, data.getAttachedToGbo());
      ps.setString(6, data.getSeq());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getValidator());
      ps.setString(10, data.getFactor());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZhNpiFactor> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZhNpiFactor data : dataList) {
        ps.setString(1, data.getDescription());
        ps.setString(2, data.getFactorType());
        ps.setString(3, data.getDefaultValue());
        ps.setString(4, data.getRange());
        ps.setString(5, data.getAttachedToGbo());
        ps.setString(6, data.getSeq());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getValidator());
        ps.setString(10, data.getFactor());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String factor) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zh_npi_factor WHERE factor=?")) {
      ps.setString(1, factor);

      return ps.executeUpdate();
    }
  }

  public List<ZhNpiFactor> selectAll() throws SQLException {
    ArrayList<ZhNpiFactor> result = new ArrayList<ZhNpiFactor>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZhNpiFactor selectByPK(String factor) throws SQLException {
    ZhNpiFactor result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE factor=?")) {
      ps.setString(1, factor);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZhNpiFactor> selectFTAll() throws SQLException {
    List<ZhNpiFactor> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ATTACHED_TO_GBO = 'FT' ORDER BY SEQ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ZhNpiFactor convert(ResultSet rs) throws SQLException {
    ZhNpiFactor data = new ZhNpiFactor();

    int index = 1;
    data.setFactor(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setFactorType(rs.getString(index++));
    data.setDefaultValue(rs.getString(index++));
    data.setRange(rs.getString(index++));
    data.setAttachedToGbo(rs.getString(index++));
    data.setSeq(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setValidator(rs.getString(index++));

    return data;
  }
}
