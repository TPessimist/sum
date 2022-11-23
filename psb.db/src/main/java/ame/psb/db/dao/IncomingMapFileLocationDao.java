package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.IncomingMapFileLocation;
import uia.utils.dao.DateUtils;

public class IncomingMapFileLocationDao {

  private static final String SQL_INS = "INSERT INTO zd_incoming_map_file_location(id,device_name,operation_name,map_file_lot_location,orig_wafer_lot_location,map_file_id_location_left,map_file_id_location_right,orig_wafer_id_location,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_incoming_map_file_location SET device_name=?,operation_name=?,map_file_lot_location=?,orig_wafer_lot_location=?,map_file_id_location_left=?,map_file_id_location_right=?,orig_wafer_id_location=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,device_name,operation_name,map_file_lot_location,orig_wafer_lot_location,map_file_id_location_left,map_file_id_location_right,orig_wafer_id_location,updated_user,updated_time FROM zd_incoming_map_file_location ";

  private final Connection conn;

  public IncomingMapFileLocationDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(IncomingMapFileLocation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getDeviceName());
      ps.setString(3, data.getOperationName());
      ps.setString(4, data.getMapFileLotLocation());
      ps.setString(5, data.getOrigWaferLotLocation());
      ps.setString(6, data.getMapFileIdLocationLeft());
      ps.setString(7, data.getMapFileIdLocationRight());
      ps.setString(8, data.getOrigWaferIdLocation());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<IncomingMapFileLocation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (IncomingMapFileLocation data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getDeviceName());
        ps.setString(3, data.getOperationName());
        ps.setString(4, data.getMapFileLotLocation());
        ps.setString(5, data.getOrigWaferLotLocation());
        ps.setString(6, data.getMapFileIdLocationLeft());
        ps.setString(7, data.getMapFileIdLocationRight());

        ps.setString(8, data.getOrigWaferIdLocation());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(IncomingMapFileLocation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDeviceName());
      ps.setString(2, data.getOperationName());
      ps.setString(3, data.getMapFileLotLocation());
      ps.setString(4, data.getOrigWaferLotLocation());
      ps.setString(5, data.getMapFileIdLocationLeft());
      ps.setString(6, data.getMapFileIdLocationRight());

      ps.setString(7, data.getOrigWaferIdLocation());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<IncomingMapFileLocation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (IncomingMapFileLocation data : dataList) {
        ps.setString(1, data.getDeviceName());
        ps.setString(2, data.getOperationName());
        ps.setString(3, data.getMapFileLotLocation());
        ps.setString(4, data.getOrigWaferLotLocation());
        ps.setString(5, data.getMapFileIdLocationLeft());
        ps.setString(6, data.getMapFileIdLocationRight());

        ps.setString(7, data.getOrigWaferIdLocation());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_incoming_map_file_location WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByDevice(String deviceName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_incoming_map_file_location WHERE device_name=?")) {
      ps.setString(1, deviceName);

      return ps.executeUpdate();
    }
  }

  public List<IncomingMapFileLocation> selectAll() throws SQLException {
    ArrayList<IncomingMapFileLocation> result = new ArrayList<IncomingMapFileLocation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public IncomingMapFileLocation selectByPK(String id) throws SQLException {
    IncomingMapFileLocation result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<IncomingMapFileLocation> selectByDevice(String deviceName) throws SQLException {
    ArrayList<IncomingMapFileLocation> result = new ArrayList<IncomingMapFileLocation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE device_name=?")) {
      ps.setString(1, deviceName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<IncomingMapFileLocation> selectByDeviceAndOperation(String deviceName,
      String operationName) throws SQLException {
    ArrayList<IncomingMapFileLocation> result = new ArrayList<IncomingMapFileLocation>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE device_name=? AND operation_name=? ")) {
      ps.setString(1, deviceName);
      ps.setString(2, operationName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private IncomingMapFileLocation convert(ResultSet rs) throws SQLException {
    IncomingMapFileLocation data = new IncomingMapFileLocation();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setOperationName(rs.getString(index++));
    data.setMapFileLotLocation(rs.getString(index++));
    data.setOrigWaferLotLocation(rs.getString(index++));
    data.setMapFileIdLocationLeft(rs.getString(index++));
    data.setMapFileIdLocationRight(rs.getString(index++));

    data.setOrigWaferIdLocation(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
