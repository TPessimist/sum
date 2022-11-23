package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ZdWarningDevice;
import uia.utils.dao.DateUtils;

public class ZdWarningDeviceDao {

  private static final String SQL_INS = "INSERT INTO zd_warning_device(device_name,operation_name,sfc,approved,reverse_field1,reverse_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_warning_device SET sfc=?,approved=?,reverse_field1=?,reverse_field2=?,updated_user=?,updated_time=? WHERE device_name=? AND operation_name=?";

  private static final String SQL_SEL = "SELECT device_name,operation_name,sfc,approved,reverse_field1,reverse_field2,updated_user,updated_time FROM zd_warning_device ";

  private final Connection conn;

  public ZdWarningDeviceDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdWarningDevice data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getDeviceName());
      ps.setString(2, data.getOperationName());
      ps.setString(3, data.getSfc());
      ps.setBoolean(4, data.getApproved());
      ps.setString(5, data.getReverseField1());
      ps.setString(6, data.getReverseField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdWarningDevice> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdWarningDevice data : dataList) {
        ps.setString(1, data.getDeviceName());
        ps.setString(2, data.getOperationName());
        ps.setString(3, data.getSfc());
        ps.setBoolean(4, data.getApproved());
        ps.setString(5, data.getReverseField1());
        ps.setString(6, data.getReverseField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZdWarningDevice data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfc());
      ps.setBoolean(2, data.getApproved());
      ps.setString(3, data.getReverseField1());
      ps.setString(4, data.getReverseField2());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getDeviceName());
      ps.setString(8, data.getOperationName());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZdWarningDevice> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZdWarningDevice data : dataList) {
        ps.setString(1, data.getSfc());
        ps.setBoolean(2, data.getApproved());
        ps.setString(3, data.getReverseField1());
        ps.setString(4, data.getReverseField2());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getDeviceName());
        ps.setString(8, data.getOperationName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String deviceName, String operationName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_warning_device WHERE device_name=? AND operation_name=?")) {
      ps.setString(1, deviceName);
      ps.setString(2, operationName);

      return ps.executeUpdate();
    }
  }

  public List<ZdWarningDevice> selectAll() throws SQLException {
    ArrayList<ZdWarningDevice> result = new ArrayList<ZdWarningDevice>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZdWarningDevice selectByPK(String deviceName, String operationName) throws SQLException {
    ZdWarningDevice result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE device_name=? AND operation_name=?")) {
      ps.setString(1, deviceName);
      ps.setString(2, operationName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }
  public List<ZdWarningDevice> selectByPKDeviceNameAndoperationName(String deviceName, String operationName) throws SQLException {
    List<ZdWarningDevice> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE device_name=? AND operation_name=?")) {
      ps.setString(1, deviceName);
      ps.setString(2, operationName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  public ZdWarningDevice selectByPKByDeviceNameAndSfcAndOperation(String deviceName,String sfc, String operationName) throws SQLException {
    ZdWarningDevice result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE device_name=? and sfc = ? AND operation_name=?")) {
      ps.setString(1, deviceName);
      ps.setString(2, operationName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }
  public List<ZdWarningDevice> selectByPKSfc(String sfc) throws SQLException {
    List<ZdWarningDevice> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc = ?")) {
      ps.setString(1, sfc);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ZdWarningDevice convert(ResultSet rs) throws SQLException {
    ZdWarningDevice data = new ZdWarningDevice();

    int index = 1;
    data.setDeviceName(rs.getString(index++));
    data.setOperationName(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setApproved(rs.getBoolean(index++));
    data.setReverseField1(rs.getString(index++));
    data.setReverseField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
