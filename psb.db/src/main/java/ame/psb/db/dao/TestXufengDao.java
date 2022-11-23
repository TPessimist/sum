package ame.psb.db.dao;

import ame.psb.db.TestXufeng;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestXufengDao {

  private static final String SQL_INS = "INSERT INTO zr_test_xufeng(id,name,test_column1,test_column2,response,request) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_test_xufeng SET name=?,test_column1=?,test_column2=?,response=?,request=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,name,test_column1,test_column2,response,request FROM zr_test_xufeng ";

  private final Connection conn;

  public TestXufengDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(TestXufeng data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getName());
      ps.setString(3, data.getTestColumn1());
      ps.setString(4, data.getTestColumn2());
      ps.setString(5, data.getResponse());
      ps.setString(6, data.getRequest());

      return ps.executeUpdate();
    }
  }

  public int insert(List<TestXufeng> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (TestXufeng data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getName());
        ps.setString(3, data.getTestColumn1());
        ps.setString(4, data.getTestColumn2());
        ps.setString(5, data.getResponse());
        ps.setString(6, data.getRequest());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(TestXufeng data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getName());
      ps.setString(2, data.getTestColumn1());
      ps.setString(3, data.getTestColumn2());
      ps.setString(4, data.getResponse());
      ps.setString(5, data.getRequest());
      ps.setString(6, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<TestXufeng> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (TestXufeng data : dataList) {
        ps.setString(1, data.getName());
        ps.setString(2, data.getTestColumn1());
        ps.setString(3, data.getTestColumn2());
        ps.setString(4, data.getResponse());
        ps.setString(5, data.getRequest());
        ps.setString(6, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_test_xufeng WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<TestXufeng> selectAll() throws SQLException {
    ArrayList<TestXufeng> result = new ArrayList<TestXufeng>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public TestXufeng selectByPK(String id) throws SQLException {
    TestXufeng result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private TestXufeng convert(ResultSet rs) throws SQLException {
    TestXufeng data = new TestXufeng();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setName(rs.getString(index++));
    data.setTestColumn1(rs.getString(index++));
    data.setTestColumn2(rs.getString(index++));
    data.setResponse(rs.getString(index++));
    data.setRequest(rs.getString(index++));

    return data;
  }
}
