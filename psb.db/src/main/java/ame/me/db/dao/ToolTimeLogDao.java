package ame.me.db.dao;

import ame.me.db.ToolTimeLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToolTimeLogDao {

  private static final String SQL_INS = "INSERT INTO tool_time_log(handle,site,resource_bo,tool_number_bo,strt,start_date_time,end_date_time,activity_bo,active,created_date_time,modified_date_time,partition_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE tool_time_log SET site=?,resource_bo=?,tool_number_bo=?,strt=?,start_date_time=?,end_date_time=?,activity_bo=?,active=?,created_date_time=?,modified_date_time=?,partition_date=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,site,resource_bo,tool_number_bo,strt,start_date_time,end_date_time,activity_bo,active,created_date_time,modified_date_time,partition_date FROM tool_time_log ";

  private final Connection conn;

  public ToolTimeLogDao(Connection conn) {
    this.conn = conn;
  }


  public List<ToolTimeLog> selectByTool(String toolNumberBO) throws SQLException {
    ArrayList<ToolTimeLog> result = new ArrayList<ToolTimeLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where tool_number_bo = ? and active = 'true' ")) {
      ps.setString(1, toolNumberBO);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ToolTimeLog> selectActiveByResource(String resourceBo) throws SQLException {
    ArrayList<ToolTimeLog> result = new ArrayList<ToolTimeLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where resource_bo = ? and active = 'true' ")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ToolTimeLog> selectAll() throws SQLException {
    ArrayList<ToolTimeLog> result = new ArrayList<ToolTimeLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ToolTimeLog selectByPK(String handle) throws SQLException {
    ToolTimeLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ToolTimeLog convert(ResultSet rs) throws SQLException {
    ToolTimeLog data = new ToolTimeLog();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setToolNumberBo(rs.getString(index++));
    data.setStrt(rs.getString(index++));
    data.setStartDateTime(rs.getTimestamp(index++));
    data.setEndDateTime(rs.getTimestamp(index++));
    data.setActivityBo(rs.getString(index++));
    data.setActive(rs.getString(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));
    data.setModifiedDateTime(rs.getTimestamp(index++));
    data.setPartitionDate(rs.getTimestamp(index++));

    return data;
  }
}