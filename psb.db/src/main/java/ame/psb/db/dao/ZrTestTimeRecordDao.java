package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ZrTestTimeRecord;

public class ZrTestTimeRecordDao {

  private static final String SQL_INS = "INSERT INTO zr_test_time_record(id,cust_code,customer_device,device,tester_type,operation,test_time_per_wafer_hour,test_time_per_wafer,test_time_per_down,createtime,te,requestid) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_test_time_record SET cust_code=?,customer_device=?,device=?,tester_type=?,operation=?,test_time_per_wafer_hour=?,test_time_per_wafer=?,test_time_per_down=?,createtime=?,te=?,requestid=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,cust_code,customer_device,device,tester_type,operation,test_time_per_wafer_hour,test_time_per_wafer,test_time_per_down,createtime,te,requestid FROM zr_test_time_record ";

  private final Connection conn;

  public ZrTestTimeRecordDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZrTestTimeRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getCustCode());
      ps.setString(3, data.getCustomerDevice());
      ps.setString(4, data.getDevice());
      ps.setString(5, data.getTesterType());
      ps.setString(6, data.getOperation());
      ps.setString(7, data.getTestTimePerWaferHour());
      ps.setString(8, data.getTestTimePerWafer());
      ps.setString(9, data.getTestTimePerDown());
      ps.setTimestamp(10, new Timestamp(data.getCreatetime().getTime()));
      ps.setString(11, data.getTe());
      ps.setString(12, data.getRequestid());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZrTestTimeRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZrTestTimeRecord data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getCustCode());
        ps.setString(3, data.getCustomerDevice());
        ps.setString(4, data.getDevice());
        ps.setString(5, data.getTesterType());
        ps.setString(6, data.getOperation());
        ps.setString(7, data.getTestTimePerWaferHour());
        ps.setString(8, data.getTestTimePerWafer());
        ps.setString(9, data.getTestTimePerDown());
        ps.setTimestamp(10, new Timestamp(data.getCreatetime().getTime()));
        ps.setString(11, data.getTe());
        ps.setString(12, data.getRequestid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZrTestTimeRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustCode());
      ps.setString(2, data.getCustomerDevice());
      ps.setString(3, data.getDevice());
      ps.setString(4, data.getTesterType());
      ps.setString(5, data.getOperation());
      ps.setString(6, data.getTestTimePerWaferHour());
      ps.setString(7, data.getTestTimePerWafer());
      ps.setString(8, data.getTestTimePerDown());
      ps.setTimestamp(9, new Timestamp(data.getCreatetime().getTime()));
      ps.setString(10, data.getTe());
      ps.setString(11, data.getRequestid());
      ps.setString(12, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZrTestTimeRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZrTestTimeRecord data : dataList) {
        ps.setString(1, data.getCustCode());
        ps.setString(2, data.getCustomerDevice());
        ps.setString(3, data.getDevice());
        ps.setString(4, data.getTesterType());
        ps.setString(5, data.getOperation());
        ps.setString(6, data.getTestTimePerWaferHour());
        ps.setString(7, data.getTestTimePerWafer());
        ps.setString(8, data.getTestTimePerDown());
        ps.setTimestamp(9, new Timestamp(data.getCreatetime().getTime()));
        ps.setString(10, data.getTe());
        ps.setString(11, data.getRequestid());
        ps.setString(12, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_test_time_record WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ZrTestTimeRecord> selectAll() throws SQLException {
    ArrayList<ZrTestTimeRecord> result = new ArrayList<ZrTestTimeRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ZrTestTimeRecord selectByPK(String id) throws SQLException {
    ZrTestTimeRecord result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZrTestTimeRecord> selectByDeviceAndOper(String clientDevice, String operationName)
      throws SQLException {
    ArrayList<ZrTestTimeRecord> result = new ArrayList<ZrTestTimeRecord>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_device=? AND operation=? ")) {
      ps.setString(1, clientDevice);
      ps.setString(2, operationName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZrTestTimeRecord> selectByDeviceAndType(String clientDevice, String operationName,
      String testerType) throws SQLException {
    ArrayList<ZrTestTimeRecord> result = new ArrayList<ZrTestTimeRecord>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_device=? AND operation=? AND tester_type=?")) {
      ps.setString(1, clientDevice);
      ps.setString(2, operationName);
      ps.setString(3, testerType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZrTestTimeRecord> selectByDeviceOperation(String deviceName, String operationBo)
      throws SQLException {
    ArrayList<ZrTestTimeRecord> result = new ArrayList<ZrTestTimeRecord>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE device=? AND operation=?")) {
      ps.setString(1, deviceName);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ZrTestTimeRecord convert(ResultSet rs) throws SQLException {
    ZrTestTimeRecord data = new ZrTestTimeRecord();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setCustCode(rs.getString(index++));
    data.setCustomerDevice(rs.getString(index++));
    data.setDevice(rs.getString(index++));
    data.setTesterType(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setTestTimePerWaferHour(rs.getString(index++));
    data.setTestTimePerWafer(rs.getString(index++));
    data.setTestTimePerDown(rs.getString(index++));
    data.setCreatetime(rs.getTimestamp(index++));
    data.setTe(rs.getString(index++));
    data.setRequestid(rs.getString(index++));

    return data;
  }
}
