package ame.htks.db.dao;

import ame.htks.db.ToolMaintainLog;
import ame.htks.db.ViewTool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ToolMaintainLogDao {

  private static final String SQL_INS = "INSERT INTO zh_tool_maintain_log(uuid,tool_number_bo,current_status,last_update_flag,comments,update_usr,update_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_tool_maintain_log SET tool_number_bo=?,current_status=?,last_update_flag=?,comments=?,update_usr=?,update_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,tool_number_bo,current_status,last_update_flag,comments,update_usr,update_time FROM zh_tool_maintain_log ";

  private static final String SQL_SEL_VIEW = "SELECT tool_number_bo,tool_number,status_bo,tool_group_bo,description,calibration_type,calibration_Date,exp_date,tool_limit_times,tool_usage,sum_limit_times,sum_usage,update_user,event_datetime,current_status,comments,update_time,limit_clean_day_time FROM view_tool ";
  private final Connection conn;

  public ToolMaintainLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ToolMaintainLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getToolNumberBo());
      ps.setString(3, data.getCurrentStatus());
      ps.setString(4, data.getLastUpdateFlag());
      ps.setString(5, data.getComments());
      ps.setString(6, data.getUpdateUsr());
      DateUtils.setDateTz(ps, 7, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ToolMaintainLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ToolMaintainLog data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getToolNumberBo());
        ps.setString(3, data.getCurrentStatus());
        ps.setString(4, data.getLastUpdateFlag());
        ps.setString(5, data.getComments());
        ps.setString(6, data.getUpdateUsr());
        DateUtils.setDateTz(ps, 7, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ToolMaintainLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getToolNumberBo());
      ps.setString(2, data.getCurrentStatus());
      ps.setString(3, data.getLastUpdateFlag());
      ps.setString(4, data.getComments());
      ps.setString(5, data.getUpdateUsr());
      DateUtils.setDateTz(ps, 6, data.getUpdateTime());
      ps.setString(7, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public ToolMaintainLog selectCurrentLog(String toolNumber) throws SQLException {
    ToolMaintainLog result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE tool_number_bo=? and last_update_flag = true")) {
      ps.setString(1, toolNumber);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public List<ToolMaintainLog> selectAllLog(String toolNumber) throws SQLException {
    ArrayList<ToolMaintainLog> result = new ArrayList<ToolMaintainLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE tool_number_bo=? order by update_time desc limit 50")) {
      ps.setString(1, toolNumber);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public ViewTool selectCurrent(String toolNumberBo) throws SQLException {
    ViewTool result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_VIEW + "WHERE tool_number_bo=?  ")) {
      ps.setString(1, toolNumberBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convertView(rs);
      }
      return result;
    }
  }

  public ArrayList<ViewTool> selectByToolGroup(String toolGroupBo) throws SQLException {
    ArrayList<ViewTool> result = new ArrayList<ViewTool>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_VIEW + "WHERE tool_group_bo=?  ")) {
      ps.setString(1, toolGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convertView(rs));
      }
      return result;
    }
  }

  public ArrayList<ViewTool> selectAllTooling() throws SQLException {
    ArrayList<ViewTool> result = new ArrayList<ViewTool>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_VIEW)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convertView(rs));
      }
      return result;
    }
  }

  public int update(List<ToolMaintainLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ToolMaintainLog data : dataList) {
        ps.setString(1, data.getToolNumberBo());
        ps.setString(2, data.getCurrentStatus());
        ps.setString(3, data.getLastUpdateFlag());
        ps.setString(4, data.getComments());
        ps.setString(5, data.getUpdateUsr());
        DateUtils.setDateTz(ps, 6, data.getUpdateTime());
        ps.setString(7, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zh_tool_maintain_log WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<ToolMaintainLog> selectAll() throws SQLException {
    ArrayList<ToolMaintainLog> result = new ArrayList<ToolMaintainLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public ToolMaintainLog selectByPK(String uuid) throws SQLException {
    ToolMaintainLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private ToolMaintainLog convert(ResultSet rs) throws SQLException {
    ToolMaintainLog data = new ToolMaintainLog();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setToolNumberBo(rs.getString(index++));
    data.setCurrentStatus(rs.getString(index++));
    data.setLastUpdateFlag(rs.getString(index++));
    data.setComments(rs.getString(index++));
    data.setUpdateUsr(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }

  private ViewTool convertView(ResultSet rs) throws SQLException {
    ViewTool data = new ViewTool();

    int index = 1;
    data.setToolNumberBo(rs.getString(index++));
    data.setToolNumber(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setToolGroupBo(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setCalibrationType(rs.getString(index++));
    data.setCalibrationDate(DateUtils.getDateTz(rs, index++));
    data.setExpDate(DateUtils.getDateTz(rs, index++));
    data.setToolLimitTimes(rs.getBigDecimal(index++));
    data.setToolUsage(rs.getBigDecimal(index++));
    data.setSumLimitTimes(rs.getBigDecimal(index++));
    data.setSumUsage(rs.getBigDecimal(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setEventDatetime(DateUtils.getDateTz(rs, index++));
    data.setCurrentStatus(rs.getString(index++));
    data.setComments(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setLimitCleanDayTime(rs.getBigDecimal(index++));

    return data;
  }
}
