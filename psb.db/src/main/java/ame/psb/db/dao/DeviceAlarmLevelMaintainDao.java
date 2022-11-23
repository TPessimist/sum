package ame.psb.db.dao;

import ame.psb.db.DeviceAlarmLevelMaintain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class DeviceAlarmLevelMaintainDao {

  private static final String SQL_INS = "INSERT INTO zd_device_alarm_level_maintain(alarm_level,description,check_cycle,check_times,handle_user,handle_mode,upgrade_condition,remarks,note,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_device_alarm_level_maintain SET description=?,check_cycle=?,check_times=?,handle_user=?,handle_mode=?,upgrade_condition=?,remarks=?,note=?,updated_user=?,updated_time=? WHERE alarm_level=?";

  private static final String SQL_SEL = "SELECT alarm_level,description,check_cycle,check_times,handle_user,handle_mode,upgrade_condition,remarks,note,updated_user,updated_time FROM zd_device_alarm_level_maintain ";

  private final Connection conn;

  public DeviceAlarmLevelMaintainDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DeviceAlarmLevelMaintain data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getAlarmLevel());
      ps.setString(2, data.getDescription());
      ps.setBigDecimal(3, data.getCheckCycle());
      ps.setBigDecimal(4, data.getCheckTimes());
      ps.setString(5, data.getHandleUser());
      ps.setString(6, data.getHandleMode());
      ps.setString(7, data.getUpgradeCondition());
      ps.setString(8, data.getRemarks());
      ps.setString(9, data.getNote());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DeviceAlarmLevelMaintain> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DeviceAlarmLevelMaintain data : dataList) {
        ps.setString(1, data.getAlarmLevel());
        ps.setString(2, data.getDescription());
        ps.setBigDecimal(3, data.getCheckCycle());
        ps.setBigDecimal(4, data.getCheckTimes());
        ps.setString(5, data.getHandleUser());
        ps.setString(6, data.getHandleMode());
        ps.setString(7, data.getUpgradeCondition());
        ps.setString(8, data.getRemarks());
        ps.setString(9, data.getNote());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DeviceAlarmLevelMaintain data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDescription());
      ps.setBigDecimal(2, data.getCheckCycle());
      ps.setBigDecimal(3, data.getCheckTimes());
      ps.setString(4, data.getHandleUser());
      ps.setString(5, data.getHandleMode());
      ps.setString(6, data.getUpgradeCondition());
      ps.setString(7, data.getRemarks());
      ps.setString(8, data.getNote());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
      ps.setString(11, data.getAlarmLevel());

      return ps.executeUpdate();
    }
  }

  public int update(List<DeviceAlarmLevelMaintain> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DeviceAlarmLevelMaintain data : dataList) {
        ps.setString(1, data.getDescription());
        ps.setBigDecimal(2, data.getCheckCycle());
        ps.setBigDecimal(3, data.getCheckTimes());
        ps.setString(4, data.getHandleUser());
        ps.setString(5, data.getHandleMode());
        ps.setString(6, data.getUpgradeCondition());
        ps.setString(7, data.getRemarks());
        ps.setString(8, data.getNote());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
        ps.setString(11, data.getAlarmLevel());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String alarmLevel) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_device_alarm_level_maintain WHERE alarm_level=?")) {
      ps.setString(1, alarmLevel);

      return ps.executeUpdate();
    }
  }

  public List<DeviceAlarmLevelMaintain> selectAll() throws SQLException {
    ArrayList<DeviceAlarmLevelMaintain> result = new ArrayList<DeviceAlarmLevelMaintain>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public DeviceAlarmLevelMaintain selectByPK(String alarmLevel) throws SQLException {
    DeviceAlarmLevelMaintain result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE alarm_level=?")) {
      ps.setString(1, alarmLevel);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private DeviceAlarmLevelMaintain convert(ResultSet rs) throws SQLException {
    DeviceAlarmLevelMaintain data = new DeviceAlarmLevelMaintain();

    int index = 1;
    data.setAlarmLevel(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setCheckCycle(rs.getBigDecimal(index++));
    data.setCheckTimes(rs.getBigDecimal(index++));
    data.setHandleUser(rs.getString(index++));
    data.setHandleMode(rs.getString(index++));
    data.setUpgradeCondition(rs.getString(index++));
    data.setRemarks(rs.getString(index++));
    data.setNote(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
