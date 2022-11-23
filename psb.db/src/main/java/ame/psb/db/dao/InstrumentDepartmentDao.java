package ame.psb.db.dao;

import ame.psb.db.InstrumentDepartment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class InstrumentDepartmentDao {

  private static final String SQL_INS = "INSERT INTO zd_instrument_department(devision,department,description,value,update_time,update_user) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_instrument_department SET description=?,value=?,update_time=?,update_user=? WHERE devision=? AND department=?";

  private static final String SQL_SEL = "SELECT devision,department,description,value,update_time,update_user FROM zd_instrument_department ";

  private final Connection conn;

  public InstrumentDepartmentDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(InstrumentDepartment data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getDevision());
      ps.setString(2, data.getDepartment());
      ps.setString(3, data.getDescription());
      ps.setString(4, data.getValue());
      DateUtils.setDateTz(ps, 5, data.getUpdateTime());
      ps.setString(6, data.getUpdateUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<InstrumentDepartment> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (InstrumentDepartment data : dataList) {
        ps.setString(1, data.getDevision());
        ps.setString(2, data.getDepartment());
        ps.setString(3, data.getDescription());
        ps.setString(4, data.getValue());
        DateUtils.setDateTz(ps, 5, data.getUpdateTime());
        ps.setString(6, data.getUpdateUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(InstrumentDepartment data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDescription());
      ps.setString(2, data.getValue());
      DateUtils.setDateTz(ps, 3, data.getUpdateTime());
      ps.setString(4, data.getUpdateUser());
      ps.setString(5, data.getDevision());
      ps.setString(6, data.getDepartment());

      return ps.executeUpdate();
    }
  }

  public int update(List<InstrumentDepartment> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (InstrumentDepartment data : dataList) {
        ps.setString(1, data.getDescription());
        ps.setString(2, data.getValue());
        DateUtils.setDateTz(ps, 3, data.getUpdateTime());
        ps.setString(4, data.getUpdateUser());
        ps.setString(5, data.getDevision());
        ps.setString(6, data.getDepartment());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String devision, String department) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_instrument_department WHERE devision=? AND department=?")) {
      ps.setString(1, devision);
      ps.setString(2, department);

      return ps.executeUpdate();
    }
  }

  public List<InstrumentDepartment> selectAll() throws SQLException {
    ArrayList<InstrumentDepartment> result = new ArrayList<InstrumentDepartment>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public InstrumentDepartment selectByPK(String devision, String department) throws SQLException {
    InstrumentDepartment result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE devision=? AND department=?")) {
      ps.setString(1, devision);
      ps.setString(2, department);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<InstrumentDepartment> selectByDevision(String devision) throws SQLException {//事业部的区域
    ArrayList<InstrumentDepartment> result = new ArrayList<InstrumentDepartment>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE devision=? ")) {
      ps.setString(1, devision);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private InstrumentDepartment convert(ResultSet rs) throws SQLException {
    InstrumentDepartment data = new InstrumentDepartment();

    int index = 1;
    data.setDevision(rs.getString(index++));
    data.setDepartment(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setUpdateUser(rs.getString(index++));

    return data;
  }
}
