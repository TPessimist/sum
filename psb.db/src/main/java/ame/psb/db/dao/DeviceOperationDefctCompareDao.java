package ame.psb.db.dao;

import ame.psb.db.DeviceOperationDefctCompare;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DeviceOperationDefctCompareDao {

  private static final String SQL_INS = "INSERT INTO zd_device_operation_defect_compare(id,device,operation,nc_codes,pervious_operation,pervious_nc_codes,differ_max,differ_min,hold_comment,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_device_operation_defect_compare SET device=?,operation=?,nc_codes=?,pervious_operation=?,pervious_nc_codes=?,differ_max=?,differ_min=?,hold_comment=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,device,operation,nc_codes,pervious_operation,pervious_nc_codes,differ_max,differ_min,hold_comment,updated_user,updated_time FROM zd_device_operation_defect_compare ";

  private final Connection conn;

  public DeviceOperationDefctCompareDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DeviceOperationDefctCompare data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getDevice());
      ps.setString(3, data.getOperation());
      ps.setString(4, data.getNcCodes());
      ps.setString(5, data.getPerviousOperation());
      ps.setString(6, data.getPerviousNcCodes());
      ps.setInt(7, data.getDifferMax());
      ps.setInt(8, data.getDifferMin());
      ps.setString(9, data.getHoldComment());
      ps.setString(10, data.getUpdatedUser());
      ps.setTimestamp(11, new Timestamp(data.getUpdatedTime().getTime()));

      return ps.executeUpdate();
    }
  }

  public int insert(List<DeviceOperationDefctCompare> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DeviceOperationDefctCompare data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getDevice());
        ps.setString(3, data.getOperation());
        ps.setString(4, data.getNcCodes());
        ps.setString(5, data.getPerviousOperation());
        ps.setString(6, data.getPerviousNcCodes());
        ps.setInt(7, data.getDifferMax());
        ps.setInt(8, data.getDifferMin());
        ps.setString(9, data.getHoldComment());
        ps.setString(10, data.getUpdatedUser());
        ps.setTimestamp(11, new Timestamp(data.getUpdatedTime().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DeviceOperationDefctCompare data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDevice());
      ps.setString(2, data.getOperation());
      ps.setString(3, data.getNcCodes());
      ps.setString(4, data.getPerviousOperation());
      ps.setString(5, data.getPerviousNcCodes());
      ps.setInt(6, data.getDifferMax());
      ps.setInt(7, data.getDifferMin());
      ps.setString(8, data.getHoldComment());
      ps.setString(9, data.getUpdatedUser());
      ps.setTimestamp(10, new Timestamp(data.getUpdatedTime().getTime()));
      ps.setString(11, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<DeviceOperationDefctCompare> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DeviceOperationDefctCompare data : dataList) {
        ps.setString(1, data.getDevice());
        ps.setString(2, data.getOperation());
        ps.setString(3, data.getNcCodes());
        ps.setString(4, data.getPerviousOperation());
        ps.setString(5, data.getPerviousNcCodes());
        ps.setInt(6, data.getDifferMax());
        ps.setInt(7, data.getDifferMin());
        ps.setString(8, data.getHoldComment());
        ps.setString(9, data.getUpdatedUser());
        ps.setTimestamp(10, new Timestamp(data.getUpdatedTime().getTime()));
        ps.setString(11, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_device_operation_defect_compare WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  @Deprecated
  public List<DeviceOperationDefctCompare> selectAll() throws SQLException {
    ArrayList<DeviceOperationDefctCompare> result = new ArrayList<DeviceOperationDefctCompare>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<DeviceOperationDefctCompare> selectByDeviceAndOperation(String deviceName,
      String operationName) throws SQLException {
    ArrayList<DeviceOperationDefctCompare> result = new ArrayList<DeviceOperationDefctCompare>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where device=? and operation=? ")) {
      ps.setString(1, deviceName);
      ps.setString(2, operationName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public DeviceOperationDefctCompare selectByPK(String id) throws SQLException {
    DeviceOperationDefctCompare result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private DeviceOperationDefctCompare convert(ResultSet rs) throws SQLException {
    DeviceOperationDefctCompare data = new DeviceOperationDefctCompare();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDevice(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setNcCodes(rs.getString(index++));
    data.setPerviousOperation(rs.getString(index++));
    data.setPerviousNcCodes(rs.getString(index++));
    data.setDifferMax(rs.getInt(index++));
    data.setDifferMin(rs.getInt(index++));
    data.setHoldComment(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(rs.getTimestamp(index++));

    return data;
  }
}
