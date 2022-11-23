package ame.psb.db.dao;

import ame.psb.db.DeviceAlarmLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class DeviceAlarmLogDao {

  private static final String SQL_INS = "INSERT INTO zd_device_alarm_log(id,device_code,alarm_code,description,alarm_level,device_type,alarm_report,remarks,note,receive_time,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_device_alarm_log SET device_code=?,alarm_code=?,description=?,alarm_level=?,device_type=?,alarm_report=?,remarks=?,note=?,receive_time=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,device_code,alarm_code,description,alarm_level,device_type,alarm_report,remarks,note,receive_time,updated_user,updated_time FROM zd_device_alarm_log ";

  private final Connection conn;

  public DeviceAlarmLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DeviceAlarmLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getDeviceCode());
      ps.setString(3, data.getAlarmCode());
      ps.setString(4, data.getDescription());
      ps.setString(5, data.getAlarmLevel());
      ps.setString(6, data.getDeviceType());
      ps.setString(7, data.getAlarmReport());
      ps.setString(8, data.getRemarks());
      ps.setString(9, data.getNote());
      DateUtils.setDateTz(ps, 10, data.getReceiveTime());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DeviceAlarmLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DeviceAlarmLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getDeviceCode());
        ps.setString(3, data.getAlarmCode());
        ps.setString(4, data.getDescription());
        ps.setString(5, data.getAlarmLevel());
        ps.setString(6, data.getDeviceType());
        ps.setString(7, data.getAlarmReport());
        ps.setString(8, data.getRemarks());
        ps.setString(9, data.getNote());
        DateUtils.setDateTz(ps, 10, data.getReceiveTime());
        ps.setString(11, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DeviceAlarmLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDeviceCode());
      ps.setString(2, data.getAlarmCode());
      ps.setString(3, data.getDescription());
      ps.setString(4, data.getAlarmLevel());
      ps.setString(5, data.getDeviceType());
      ps.setString(6, data.getAlarmReport());
      ps.setString(7, data.getRemarks());
      ps.setString(8, data.getNote());
      DateUtils.setDateTz(ps, 9, data.getReceiveTime());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
      ps.setString(12, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<DeviceAlarmLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DeviceAlarmLog data : dataList) {
        ps.setString(1, data.getDeviceCode());
        ps.setString(2, data.getAlarmCode());
        ps.setString(3, data.getDescription());
        ps.setString(4, data.getAlarmLevel());
        ps.setString(5, data.getDeviceType());
        ps.setString(6, data.getAlarmReport());
        ps.setString(7, data.getRemarks());
        ps.setString(8, data.getNote());
        DateUtils.setDateTz(ps, 9, data.getReceiveTime());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
        ps.setString(12, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_device_alarm_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<DeviceAlarmLog> selectAll() throws SQLException {
    ArrayList<DeviceAlarmLog> result = new ArrayList<DeviceAlarmLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public DeviceAlarmLog selectByPK(String id) throws SQLException {
    DeviceAlarmLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<DeviceAlarmLog> selectByAlarmCode(String deviceCode, String alarmCode, String flag)
      throws SQLException {
    ArrayList<DeviceAlarmLog> result = new ArrayList<DeviceAlarmLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL
                + "WHERE DEVICE_CODE=? AND ALARM_CODE=? AND ALARM_REPORT=? order by receive_time asc")) {
      ps.setString(1, deviceCode);
      ps.setString(2, alarmCode);
      ps.setString(3, flag);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private DeviceAlarmLog convert(ResultSet rs) throws SQLException {
    DeviceAlarmLog data = new DeviceAlarmLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDeviceCode(rs.getString(index++));
    data.setAlarmCode(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setAlarmLevel(rs.getString(index++));
    data.setDeviceType(rs.getString(index++));
    data.setAlarmReport(rs.getString(index++));
    data.setRemarks(rs.getString(index++));
    data.setNote(rs.getString(index++));
    data.setReceiveTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
