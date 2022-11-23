package ame.psb.db.dao;

import ame.psb.db.WaferIdCharacterLocation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class WaferIdCharacterLocationDao {

  private static final String SQL_INS = "INSERT INTO zd_waferid_character_location(device_name,seq,customer_lot_character_location,fab_lot_character_location,physical_waferid_character_location,customer_slotno_location,physical_slotno_location,updated_user,updated_time,check_sum_validate,customer_slotno_location_right) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_waferid_character_location SET customer_lot_character_location=?,fab_lot_character_location=?,physical_waferid_character_location=?,customer_slotno_location=?,physical_slotno_location=?,updated_user=?,updated_time=?,check_sum_validate=?,customer_slotno_location_right=? WHERE device_name=? and seq=? ";

  private static final String SQL_SEL = "SELECT device_name,seq,customer_lot_character_location,fab_lot_character_location,physical_waferid_character_location,customer_slotno_location,physical_slotno_location,updated_user,updated_time,check_sum_validate,customer_slotno_location_right FROM zd_waferid_character_location ";

  private final Connection conn;

  public WaferIdCharacterLocationDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(WaferIdCharacterLocation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getDeviceName());
      ps.setInt(2, data.getSeq());
      ps.setString(3, data.getCustomerLotCharacterLocation());
      ps.setString(4, data.getFabLotCharacterLocation());
      ps.setString(5, data.getPhysicalWaferidCharacterLocation());
      ps.setString(6, data.getCustomerSlotnoLocation());
      ps.setString(7, data.getPhysicalSlotnoLocation());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setBoolean(10, data.isCheckSumValidate());
      ps.setString(11, data.getCustomerSlotnoLocationRight());

      return ps.executeUpdate();
    }
  }

  public int insert(List<WaferIdCharacterLocation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (WaferIdCharacterLocation data : dataList) {
        ps.setString(1, data.getDeviceName());
        ps.setInt(2, data.getSeq());
        ps.setString(3, data.getCustomerLotCharacterLocation());
        ps.setString(4, data.getFabLotCharacterLocation());
        ps.setString(5, data.getPhysicalWaferidCharacterLocation());
        ps.setString(6, data.getCustomerSlotnoLocation());
        ps.setString(7, data.getPhysicalSlotnoLocation());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setBoolean(10, data.isCheckSumValidate());
        ps.setString(11, data.getCustomerSlotnoLocationRight());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(WaferIdCharacterLocation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomerLotCharacterLocation());
      ps.setString(2, data.getFabLotCharacterLocation());
      ps.setString(3, data.getPhysicalWaferidCharacterLocation());
      ps.setString(4, data.getCustomerSlotnoLocation());
      ps.setString(5, data.getPhysicalSlotnoLocation());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setBoolean(8, data.isCheckSumValidate());
      ps.setString(9, data.getCustomerSlotnoLocationRight());
      ps.setString(10, data.getDeviceName());
      ps.setInt(11, data.getSeq());

      return ps.executeUpdate();
    }
  }

  public int update(List<WaferIdCharacterLocation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (WaferIdCharacterLocation data : dataList) {
        ps.setString(1, data.getCustomerLotCharacterLocation());
        ps.setString(2, data.getPhysicalWaferidCharacterLocation());
        ps.setString(3, data.getCustomerSlotnoLocation());
        ps.setString(4, data.getPhysicalSlotnoLocation());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setBoolean(7, data.isCheckSumValidate());
        ps.setString(8, data.getCustomerSlotnoLocationRight());
        ps.setString(9, data.getDeviceName());
        ps.setInt(10, data.getSeq());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String deviceName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_waferid_character_location WHERE device_name=? ")) {
      ps.setString(1, deviceName);

      return ps.executeUpdate();
    }
  }

  public WaferIdCharacterLocation selectByPK(String deviceName, int seq) throws SQLException {
    WaferIdCharacterLocation result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE device_name=? and seq=? ")) {
      ps.setString(1, deviceName);
      ps.setInt(2, seq);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public WaferIdCharacterLocation select(String deviceName, int length) throws SQLException {
    List<WaferIdCharacterLocation> results = selectByDevice(deviceName);
    if (results.isEmpty()) {
      return null;
    }
    if (results.size() == 1) {
      return results.get(0);
    }
    return selectByPK(deviceName, length);
  }

  public List<WaferIdCharacterLocation> selectByDevice(String deviceName) throws SQLException {
    ArrayList<WaferIdCharacterLocation> result = new ArrayList<WaferIdCharacterLocation>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE device_name=? order by seq ")) {
      ps.setString(1, deviceName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  private WaferIdCharacterLocation convert(ResultSet rs) throws SQLException {
    WaferIdCharacterLocation data = new WaferIdCharacterLocation();

    int index = 1;
    data.setDeviceName(rs.getString(index++));
    data.setSeq(rs.getInt(index++));
    data.setCustomerLotCharacterLocation(rs.getString(index++));
    data.setFabLotCharacterLocation(rs.getString(index++));
    data.setPhysicalWaferidCharacterLocation(rs.getString(index++));
    data.setCustomerSlotnoLocation(rs.getString(index++));
    data.setPhysicalSlotnoLocation(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setCheckSumValidate(rs.getBoolean(index++));
    data.setCustomerSlotnoLocationRight(rs.getString(index++));

    return data;
  }

  public int selectCountByDeviceName(String deviceTo) throws SQLException {
    String selSql = "select count(1) from zd_waferid_character_location where device_name = ?  ";
    int count = 0;
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, deviceTo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        count = rs.getInt(1);
      }
      return count;
    }
  }

  public List<WaferIdCharacterLocation> select(Where where) throws SQLException {
    ArrayList<WaferIdCharacterLocation> result = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }
}
