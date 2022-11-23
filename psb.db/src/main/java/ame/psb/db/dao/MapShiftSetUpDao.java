package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.MapShiftSetUp;
import uia.utils.dao.DateUtils;

public class MapShiftSetUpDao {

  private static final String SQL_INS = "INSERT INTO zd_map_shift_set_up(id,device_name,operation_name,alignment_flag,sequence,x_coordinate,y_coordinate,symbol_str,updated_user,updated_date_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_map_shift_set_up SET device_name=?,operation_name=?,alignment_flag=?,sequence=?,x_coordinate=?,y_coordinate=?,symbol_str=?,updated_user=?,updated_date_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,device_name,operation_name,alignment_flag,sequence,x_coordinate,y_coordinate,symbol_str,updated_user,updated_date_time FROM zd_map_shift_set_up ";

  private final Connection conn;

  public MapShiftSetUpDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(MapShiftSetUp data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getDeviceName());
      ps.setString(3, data.getOperationName());
      ps.setString(4, data.getAlignmentFlag());
      ps.setInt(5, data.getSequence());
      ps.setInt(6, data.getXCoordinate());
      ps.setInt(7, data.getYCoordinate());
      ps.setString(8, data.getSymbolStr());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedDateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<MapShiftSetUp> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (MapShiftSetUp data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getDeviceName());
        ps.setString(3, data.getOperationName());
        ps.setString(4, data.getAlignmentFlag());
        ps.setInt(5, data.getSequence());
        ps.setInt(6, data.getXCoordinate());
        ps.setInt(7, data.getYCoordinate());
        ps.setString(8, data.getSymbolStr());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedDateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(MapShiftSetUp data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDeviceName());
      ps.setString(2, data.getOperationName());
      ps.setString(3, data.getAlignmentFlag());
      ps.setInt(4, data.getSequence());
      ps.setInt(5, data.getXCoordinate());
      ps.setInt(6, data.getYCoordinate());
      ps.setString(7, data.getSymbolStr());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedDateTime());

      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<MapShiftSetUp> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (MapShiftSetUp data : dataList) {
        ps.setString(1, data.getDeviceName());
        ps.setString(2, data.getOperationName());
        ps.setString(3, data.getAlignmentFlag());
        ps.setInt(4, data.getSequence());
        ps.setInt(5, data.getXCoordinate());
        ps.setInt(6, data.getYCoordinate());
        ps.setString(7, data.getSymbolStr());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedDateTime());

        ps.setString(10, data.getId());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_map_shift_set_up WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByDeviceAndOp(String deviceName, String operation) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "DELETE FROM zd_map_shift_set_up WHERE device_name=? AND operation_name=? ")) {
      ps.setString(1, deviceName);
      ps.setString(2, operation);

      return ps.executeUpdate();
    }
  }

  public List<MapShiftSetUp> selectAll() throws SQLException {
    ArrayList<MapShiftSetUp> result = new ArrayList<MapShiftSetUp>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public MapShiftSetUp selectByPK(String id) throws SQLException {
    MapShiftSetUp result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<MapShiftSetUp> selectByDeviceAndOp(String deviceName, String operation)
      throws SQLException {
    ArrayList<MapShiftSetUp> result = new ArrayList<MapShiftSetUp>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE device_name=? AND operation_name=?")) {
      ps.setString(1, deviceName);
      ps.setString(2, operation);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private MapShiftSetUp convert(ResultSet rs) throws SQLException {
    MapShiftSetUp data = new MapShiftSetUp();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setOperationName(rs.getString(index++));
    data.setAlignmentFlag(rs.getString(index++));
    data.setSequence(rs.getInt(index++));
    data.setXCoordinate(rs.getInt(index++));
    data.setYCoordinate(rs.getInt(index++));
    data.setSymbolStr(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedDateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
