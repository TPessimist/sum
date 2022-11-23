package ame.psb.db.dao;

import ame.psb.db.DeviceAlarmDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class DeviceAlarmDefDao { //定义报警类型

  private static final String SQL_INS = "INSERT INTO zd_device_alarm_def(device_code,alarm_code,description,english_description,alarm_level,device_type,handle_method,remarks,note,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_device_alarm_def SET description=?,english_description=?,alarm_level=?,device_type=?,handle_method=?,remarks=?,note=?,updated_user=?,updated_time=? WHERE device_code=? AND alarm_code=?";

  private static final String SQL_SEL = "SELECT device_code,alarm_code,description,english_description,alarm_level,device_type,handle_method,remarks,note,updated_user,updated_time FROM zd_device_alarm_def ";

  private final Connection conn;

  public DeviceAlarmDefDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DeviceAlarmDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getDeviceCode());
      ps.setString(2, data.getAlarmCode());
      ps.setString(3, data.getDescription());
      ps.setString(4, data.getEnglishDescription());
      ps.setString(5, data.getAlarmLevel());
      ps.setString(6, data.getDeviceType());
      ps.setString(7, data.getHandleMethod());
      ps.setString(8, data.getRemarks());
      ps.setString(9, data.getNote());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DeviceAlarmDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DeviceAlarmDef data : dataList) {
        ps.setString(1, data.getDeviceCode());
        ps.setString(2, data.getAlarmCode());
        ps.setString(3, data.getDescription());
        ps.setString(4, data.getEnglishDescription());
        ps.setString(5, data.getAlarmLevel());
        ps.setString(6, data.getDeviceType());
        ps.setString(7, data.getHandleMethod());
        ps.setString(8, data.getRemarks());
        ps.setString(9, data.getNote());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DeviceAlarmDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDescription());
      ps.setString(2, data.getEnglishDescription());
      ps.setString(3, data.getAlarmLevel());
      ps.setString(4, data.getDeviceType());
      ps.setString(5, data.getHandleMethod());
      ps.setString(6, data.getRemarks());
      ps.setString(7, data.getNote());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getDeviceCode());
      ps.setString(11, data.getAlarmCode());

      return ps.executeUpdate();
    }
  }

  public int update(List<DeviceAlarmDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DeviceAlarmDef data : dataList) {
        ps.setString(1, data.getDescription());
        ps.setString(2, data.getEnglishDescription());
        ps.setString(3, data.getAlarmLevel());
        ps.setString(4, data.getDeviceType());
        ps.setString(5, data.getHandleMethod());
        ps.setString(6, data.getRemarks());
        ps.setString(7, data.getNote());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getDeviceCode());
        ps.setString(11, data.getAlarmCode());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String deviceCode, String alarmCode) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_device_alarm_def WHERE device_code=? AND alarm_code=?")) {
      ps.setString(1, deviceCode);
      ps.setString(2, alarmCode);

      return ps.executeUpdate();
    }
  }

  public List<DeviceAlarmDef> selectAll() throws SQLException {
    ArrayList<DeviceAlarmDef> result = new ArrayList<DeviceAlarmDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public DeviceAlarmDef selectByPK(String deviceCode, String alarmCode) throws SQLException {
    DeviceAlarmDef result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE device_code=? AND alarm_code=?")) {
      ps.setString(1, deviceCode);
      ps.setString(2, alarmCode);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public DeviceAlarmDef selectByAlarmCode(String alarmCode) throws SQLException { //按照报警代码找到记录
    DeviceAlarmDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE alarm_code=?")) {
      ps.setString(1, alarmCode);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<DeviceAlarmDef> selectByDeviceCode(String deviceCode)
      throws SQLException { //按照设备代码找到记录
    ArrayList<DeviceAlarmDef> result = new ArrayList<DeviceAlarmDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE device_code=?")) {
      ps.setString(1, deviceCode);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private DeviceAlarmDef convert(ResultSet rs) throws SQLException {
    DeviceAlarmDef data = new DeviceAlarmDef();

    int index = 1;
    data.setDeviceCode(rs.getString(index++));
    data.setAlarmCode(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setEnglishDescription(rs.getString(index++));
    data.setAlarmLevel(rs.getString(index++));
    data.setDeviceType(rs.getString(index++));
    data.setHandleMethod(rs.getString(index++));
    data.setRemarks(rs.getString(index++));
    data.setNote(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
