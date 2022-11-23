package ame.psb.db.dao;

import ame.psb.db.WaferStorage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import uia.utils.dao.DateUtils;

/**
 * @author: helios
 * @DATE: 2020/09/22
 * @description:
 */
public class WaferStorageDao {

  private final Connection conn;

  public WaferStorageDao(Connection conn) {
    this.conn = conn;
  }

  public static Date getDateTz(ResultSet rs, String column) throws SQLException {
    if (rs.getObject(column) == null) {
      return null;
    }//if
    //------------------------------------------------------------------------------------------------------------------------------------
    return new Date(rs.getTimestamp(column).getTime() + TimeZone.getDefault().getRawOffset());
  }

  public static int toInt(String str) {
    if (str == null || str.trim().equals("")) {
      return 0;
    }
    //------------------------------------------------------------------------------------------------------------------------------------
    try {
      return Integer.parseInt(str);
    } catch (Exception e) {
    }//try
    //------------------------------------------------------------------------------------------------------------------------------------
    return 0;
  }

  public static Date getDateByDay(Date date, int count) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DAY_OF_MONTH, count);
    //------------------------------------------------------------------------------------------------------------------------------------
    return calendar.getTime();
  }

  public static String space(String str, char spacer, int slotter) {
    if (str == null || str.equals("")) {
      return "";
    }
    //------------------------------------------------------------------------------------------------------------------------------------
    if (str.length() >= slotter) {
      return str;
    } else {
      String result = str;
      slotter = slotter - str.length();
      for (int i = 0; i < slotter; i++) {
        result = spacer + result;
      }
      return result;
    }//if
  }

  public static String formatDate(Date date) {
    if (date != null) {
      return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
    return "";
  }

  public static String formatDateShort(Date date) {
    if (date != null) {
      return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    return "";
  }

  public int insert(List<WaferStorage> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "INSERT INTO ZR_WAFER_STORAGE(HANDLE,SFC,DEVICE_NAME,CUSTOMER,WAFER_ID,BALANCE_QTY,FILM_TIME,EXPIRE_TIME,MEMBRANCE_TYPE,STORAGE_LOCATION_1,STORAGE_LOCATION_2,STORAGE_LOCATION_3,CREATED_USER,CREATED_TIME,CLAIMED_USER,CLAIMED_TIME) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
      for (WaferStorage data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getSfc());
        ps.setString(3, data.getDeviceName());
        ps.setString(4, data.getCustomer());
        ps.setString(5, data.getWaferId());
        ps.setBigDecimal(6, data.getBalanceQty());
        DateUtils.setDateTz(ps, 7, data.getFilmTime());
        DateUtils.setDateTz(ps, 8, data.getExpireTime());
        ps.setString(9, data.getMembranceType());
        ps.setString(10, data.getStorageLocation1());
        ps.setString(11, data.getStorageLocation2());
        ps.setString(12, data.getStorageLocation3());
        ps.setString(13, data.getCreatedUser());
        DateUtils.setDateTz(ps, 14, data.getCreatedTime());
        ps.setString(15, data.getClaimedUser());
        DateUtils.setDateTz(ps, 16, data.getClaimedTime());
        //------------------------------------------------------------------------------------------------------------------------------------
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }

  }

  public int update(List<WaferStorage> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE ZR_WAFER_STORAGE SET WAFER_ID=?, BALANCE_QTY=?, EXPIRE_TIME=?, MEMBRANCE_TYPE=?,STORAGE_LOCATION_1=?,STORAGE_LOCATION_2=?,STORAGE_LOCATION_3=?,CLAIMED_USER=?,CLAIMED_TIME=? WHERE HANDLE=?")) {
      for (WaferStorage data : dataList) {
        ps.setString(1, data.getWaferId());
        ps.setBigDecimal(2, data.getBalanceQty());
        DateUtils.setDateTz(ps, 3, data.getExpireTime());
        ps.setString(4, data.getMembranceType());
        ps.setString(5, data.getStorageLocation1());
        ps.setString(6, data.getStorageLocation2());
        ps.setString(7, data.getStorageLocation3());
        ps.setString(8, data.getClaimedUser());
        DateUtils.setDateTz(ps, 9, data.getClaimedTime());
        ps.setString(10, data.getHandle());
        //------------------------------------------------------------------------------------------------------------------------------------
        ps.addBatch();
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return ps.executeBatch().length;
    }
  }

  public int deleteByPK(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM ZR_WAFER_STORAGE WHERE HANDLE=?")) {
      ps.setString(1, handle);
      //------------------------------------------------------------------------------------------------------------------------------------
      return ps.executeUpdate();
    }
  }

  public int deleteList(List<String> handleList) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM ZR_WAFER_STORAGE WHERE HANDLE=?")) {
      for (String handle : handleList) {
        ps.setString(1, handle);
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return ps.executeUpdate();
    }
  }

  public WaferStorage selectByPK(String handle) throws SQLException {
    WaferStorage result = null;
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT * FROM ZR_WAFER_STORAGE WHERE HANDLE=?")) {
      ps.setString(1, handle);
      //------------------------------------------------------------------------------------------------------------------------------------
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  /*
   * cc
   * sfc,waferId
   * */
  public List<WaferStorage> selectBySfcAndWaferId(String sfc, String waferId) throws SQLException {
    ArrayList<WaferStorage> result = new ArrayList<WaferStorage>();
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT * FROM ZR_WAFER_STORAGE WHERE SFC=? and WAFER_Id=? ")) {
      ps.setString(1, sfc);
      ps.setString(2, waferId);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  public List<WaferStorage> selectBySfc(String keyword) throws SQLException {
    ArrayList<WaferStorage> result = new ArrayList<WaferStorage>();
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT * FROM ZR_WAFER_STORAGE WHERE SFC=? OR DEVICE_NAME=?")) {
      ps.setString(1, keyword);
      ps.setString(2, keyword);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }


  public List<WaferStorage> selectByDeviceName(String deviceName) throws SQLException {
    ArrayList<WaferStorage> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT * FROM ZR_WAFER_STORAGE" + " where DEVICE_NAME = ? and CLAIMED_USER IS NULL ")) {
      ps.setString(1, deviceName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<WaferStorage> selectByTypeExpireDate(String membraneType, Date expireDate)
      throws SQLException {
    ArrayList<WaferStorage> result = new ArrayList<WaferStorage>();
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT * FROM ZR_WAFER_STORAGE WHERE MEMBRANCE_TYPE=? AND CLAIMED_TIME IS NULL AND EXPIRE_TIME <= ?")) {
      ps.setString(1, membraneType);
      DateUtils.setDateTz(ps, 2, expireDate);
      //------------------------------------------------------------------------------------------------------------------------------------
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  public List<WaferStorage> selectByDevice(String deviceName) throws SQLException {
    ArrayList<WaferStorage> result = new ArrayList<WaferStorage>();
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT * FROM ZR_WAFER_STORAGE WHERE DEVICE_NAME =? AND CLAIMED_TIME IS NULL")) {
      ps.setString(1, deviceName);
      //------------------------------------------------------------------------------------------------------------------------------------
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  public WaferStorage selectOneByLocation(String storageLocation1) throws SQLException {
    WaferStorage result = null;
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT * FROM ZR_WAFER_STORAGE WHERE STORAGE_LOCATION_1=? AND CLAIMED_TIME IS NULL")) {
      ps.setString(1, storageLocation1);
      //------------------------------------------------------------------------------------------------------------------------------------
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  public WaferStorage selectOneByLocation(String storageLocation1, String storageLocation2)
      throws SQLException {
    WaferStorage result = null;
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT * FROM ZR_WAFER_STORAGE WHERE STORAGE_LOCATION_1=? AND STORAGE_LOCATION_2=? AND CLAIMED_TIME IS NULL")) {
      ps.setString(1, storageLocation1);
      ps.setString(2, storageLocation2);
      //------------------------------------------------------------------------------------------------------------------------------------
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  public WaferStorage selectOneByLocation(String storageLocation1, String storageLocation2,
      String storageLocation3) throws SQLException {
    WaferStorage result = null;
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT * FROM ZR_WAFER_STORAGE WHERE STORAGE_LOCATION_1=? AND STORAGE_LOCATION_2=? AND STORAGE_LOCATION_3=? AND CLAIMED_TIME IS NULL")) {
      ps.setString(1, storageLocation1);
      ps.setString(2, storageLocation2);
      ps.setString(3, storageLocation3);
      //------------------------------------------------------------------------------------------------------------------------------------
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  public Date getOperationEndDate(String sfc, String operation) throws SQLException {
    Date result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT TOP 1 DATE_TIME FROM PRODUCTION_LOG WHERE SFC=? AND OPERATION=? ORDER BY DATE_TIME DESC")) {
      ps.setString(1, sfc);
      ps.setString(2, operation);
      //------------------------------------------------------------------------------------------------------------------------------------
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result = rs.getTimestamp("DATE_TIME");
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  public SfcInfo selectSfcInfo(String sfc) throws SQLException {
    SfcInfo result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT TOP 1 * FROM VIEW_SFC_ITEM WHERE SFC_NAME=?")) {
      ps.setString(1, sfc);
      //------------------------------------------------------------------------------------------------------------------------------------
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result = convertSfcInfo(rs);
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  private WaferStorage convert(ResultSet rs) throws SQLException {
    WaferStorage data = new WaferStorage();
    //------------------------------------------------------------------------------------------------------------------------------------
    data.setHandle(rs.getString("HANDLE"));
    data.setSfc(rs.getString("SFC"));
    data.setCustomer(rs.getString("CUSTOMER"));
    data.setDeviceName(rs.getString("DEVICE_NAME"));
    data.setWaferId(rs.getString("WAFER_ID"));
    data.setBalanceQty(rs.getBigDecimal("BALANCE_QTY"));
    data.setFilmTime(getDateTz(rs, "FILM_TIME"));
    data.setExpireTime(getDateTz(rs, "EXPIRE_TIME"));
    data.setMembranceType(rs.getString("MEMBRANCE_TYPE"));
    data.setStorageLocation1(rs.getString("STORAGE_LOCATION_1"));
    data.setStorageLocation2(rs.getString("STORAGE_LOCATION_2"));
    data.setStorageLocation3(rs.getString("STORAGE_LOCATION_3"));
    data.setCreatedUser(rs.getString("CREATED_USER"));
    data.setCreatedTime(getDateTz(rs, "CREATED_TIME"));
    data.setClaimedUser(rs.getString("CLAIMED_USER"));
    data.setClaimedTime(getDateTz(rs, "CLAIMED_TIME"));
    //------------------------------------------------------------------------------------------------------------------------------------
    return data;
  }

  private SfcInfo convertSfcInfo(ResultSet rs) throws SQLException {
    SfcInfo sfcInfo = new SfcInfo();
    //------------------------------------------------------------------------------------------------------------------------------------
    sfcInfo.customer = rs.getString("CUSTOMER");
    sfcInfo.sfcName = rs.getString("SFC_NAME");
    sfcInfo.deviceName = rs.getString("DEVICE_NAME");
    //------------------------------------------------------------------------------------------------------------------------------------
    return sfcInfo;
  }

  public static class SfcInfo {

    public String customer;
    public String sfcName;
    public String deviceName;
    public Date filmTime;
  }
}
