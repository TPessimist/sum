package ame.psb.db.dao;

import ame.psb.db.RunResourceAlarm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunResourceAlarmDao {

  private static final String SQL_INS = "INSERT INTO zr_run_resource_alarm(id,resource_bo,alarm_id,alarm_content,alarm_time,verify_flag,remark,verify_time,verify_user) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_run_resource_alarm SET resource_bo=?,alarm_id=?,alarm_content=?,alarm_time=?,verify_flag=?,remark=?,verify_time=?,verify_user=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resource_bo,alarm_id,alarm_content,alarm_time,verify_flag,remark,verify_time,verify_user FROM zr_run_resource_alarm ";

  private final Connection conn;

  public RunResourceAlarmDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunResourceAlarm data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getAlarmId());
      ps.setString(4, data.getAlarmContent());
      DateUtils.setDateTz(ps, 5, data.getAlarmTime());
      ps.setString(6, data.getVerifyFlag());
      ps.setString(7, data.getRemark());
      DateUtils.setDateTz(ps, 8, data.getVerifyTime());
      ps.setString(9, data.getVerifyUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunResourceAlarm> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunResourceAlarm data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getAlarmId());
        ps.setString(4, data.getAlarmContent());
        DateUtils.setDateTz(ps, 5, data.getAlarmTime());
        ps.setString(6, data.getVerifyFlag());
        ps.setString(7, data.getRemark());
        DateUtils.setDateTz(ps, 8, data.getVerifyTime());
        ps.setString(9, data.getVerifyUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunResourceAlarm data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getAlarmId());
      ps.setString(3, data.getAlarmContent());
      DateUtils.setDateTz(ps, 4, data.getAlarmTime());
      ps.setString(5, data.getVerifyFlag());
      ps.setString(6, data.getRemark());
      DateUtils.setDateTz(ps, 7, data.getVerifyTime());
      ps.setString(8, data.getVerifyUser());
      ps.setString(9, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunResourceAlarm> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunResourceAlarm data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getAlarmId());
        ps.setString(3, data.getAlarmContent());
        DateUtils.setDateTz(ps, 4, data.getAlarmTime());
        ps.setString(5, data.getVerifyFlag());
        ps.setString(6, data.getRemark());
        DateUtils.setDateTz(ps, 7, data.getVerifyTime());
        ps.setString(8, data.getVerifyUser());
        ps.setString(9, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_run_resource_alarm WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<RunResourceAlarm> selectAll() throws SQLException {
    ArrayList<RunResourceAlarm> result = new ArrayList<RunResourceAlarm>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public RunResourceAlarm selectByPK(String id) throws SQLException {
    RunResourceAlarm result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<RunResourceAlarm> selectByResourceAndFilterTime(String resource,
      Date startTime, Date endTime) throws SQLException {
    ArrayList<RunResourceAlarm> result = new ArrayList<RunResourceAlarm>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " where resource_bo=? and alarm_time between ? and ? ")) {
      ps.setString(1, resource);
      DateUtils.setDateTz(ps, 2, startTime);
      DateUtils.setDateTz(ps, 3, endTime);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private RunResourceAlarm convert(ResultSet rs) throws SQLException {
    RunResourceAlarm data = new RunResourceAlarm();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setAlarmId(rs.getString(index++));
    data.setAlarmContent(rs.getString(index++));
    data.setAlarmTime(DateUtils.getDateTz(rs, index++));
    data.setVerifyFlag(rs.getString(index++));
    data.setRemark(rs.getString(index++));
    data.setVerifyTime(DateUtils.getDateTz(rs, index++));
    data.setVerifyUser(rs.getString(index++));

    return data;
  }
}
