package ame.psb.db.dao;

import ame.psb.db.ToolUsage;
import ame.psb.db.ViewToolUsage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ToolUsageDao {

  private static final String SQL_SEL_ACTIVE = "SELECT handle,tool_number_bo,tool_limit_times,tool_usage,event_datetime,tool_number,tool_description,resource_bo,start_date_time,end_date_time,active FROM view_tool_usage_active ";

  private static final String SQL_SEL = "SELECT tool_number_bo,tool_limit_times,tool_usage,event_datetime FROM zh_tool_usage ";

  private final Connection conn;

  public ToolUsageDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewToolUsage> selectActiveByResource(String resourceBo) throws SQLException {
    ArrayList<ViewToolUsage> result = new ArrayList<ViewToolUsage>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_ACTIVE + "WHERE resource_bo=? ORDER BY handle")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ToolUsage> selectAll() throws SQLException {
    ArrayList<ToolUsage> result = new ArrayList<ToolUsage>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert1(rs));
      }
      return result;
    }
  }

  public ToolUsage selectByPK(String toolNumberBo) throws SQLException {
    ToolUsage result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE tool_number_bo=?")) {
      ps.setString(1, toolNumberBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert1(rs);
      }
      return result;
    }
  }

  public ViewToolUsage selectByToolNumber(String toolNumberBo) throws SQLException {
    ViewToolUsage result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE tool_number_bo=?")) {
      ps.setString(1, toolNumberBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convertUsage(rs);
      }
      return result;
    }
  }

  private ToolUsage convert1(ResultSet rs) throws SQLException {
    ToolUsage data = new ToolUsage();

    int index = 1;
    data.setToolNumberBo(rs.getString(index++));
    data.setToolLimitTimes(rs.getBigDecimal(index++));
    data.setToolUsage(rs.getBigDecimal(index++));
    data.setEventDatetime(DateUtils.getDateTz(rs, index++));

    return data;
  }

  private ViewToolUsage convert(ResultSet rs) throws SQLException {
    ViewToolUsage data = new ViewToolUsage();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setToolNumberBo(rs.getString(index++));
    data.setToolLimitTimes(rs.getInt(index++));
    data.setToolUsage(rs.getInt(index++));
    data.setEventDatetime(DateUtils.getDateTz(rs, index++));
    data.setToolNumber(rs.getString(index++));
    data.setToolDescription(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setStartDateTime(DateUtils.getDateTz(rs, index++));
    data.setEndDateTime(DateUtils.getDateTz(rs, index++));
    data.setActive(rs.getString(index++));

    return data;
  }

  private ViewToolUsage convertUsage(ResultSet rs) throws SQLException {
    ViewToolUsage data = new ViewToolUsage();

    int index = 1;
    data.setToolNumberBo(rs.getString(index++));
    data.setToolLimitTimes(rs.getInt(index++));
    data.setToolUsage(rs.getInt(index++));
    data.setEventDatetime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
