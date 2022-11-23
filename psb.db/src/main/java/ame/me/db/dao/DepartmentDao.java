package ame.me.db.dao;

import ame.psb.db.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {

  private static final String SQL_SEL = "SELECT id,subid,value,group_name FROM zd_department";

  private final Connection conn;

  public DepartmentDao(Connection conn) {
    this.conn = conn;
  }

  public List<Department> selectAll() throws SQLException {
    ArrayList<Department> result = new ArrayList<Department>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public Department selectbyvalue(String value) throws SQLException {
    Department result = new Department();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE value = ? ")) {
      ps.setString(1, value);
      ResultSet rs = ps.executeQuery();
      result = convert(rs);
      return result;
    }
  }

  private Department convert(ResultSet rs) throws SQLException {
    Department data = new Department();

    data.setId(rs.getString(1));
    data.setSubid(rs.getString(2));
    data.setValue(rs.getString(3));
    data.setGroupname(rs.getString(4));
    return data;

  }
}