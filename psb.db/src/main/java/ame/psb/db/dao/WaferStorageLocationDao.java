package ame.psb.db.dao;

import ame.psb.db.WaferStorageLocation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

/**
 * @author: helios
 * @DATE: 2020/09/22
 * @description:
 */
public class WaferStorageLocationDao {

  private final Connection conn;

  public WaferStorageLocationDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(List<WaferStorageLocation> dataList, Integer level) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "INSERT INTO ZD_WAFER_STORAGE_LOCATION(HANDLE,CODE,LEVEL,PARENT,CREATED_TIME,UPDATED_TIME) VALUES (?,?,?,?,?,?)")) {
      for (WaferStorageLocation data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getCode());
        ps.setInt(3, level);
        ps.setString(4, data.getParent());
        DateUtils.setDateTz(ps, 5, data.getCreatedTime());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        //------------------------------------------------------------------------------------------------------------------------------------
        ps.addBatch();
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return ps.executeBatch().length;
    }
  }

  public int update(List<WaferStorageLocation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE ZD_WAFER_STORAGE_LOCATION SET CODE=?, UPDATED_TIME=? WHERE HANDLE=?")) {
      for (WaferStorageLocation data : dataList) {
        ps.setString(1, data.getCode());
        DateUtils.setDateTz(ps, 2, data.getUpdatedTime());
        ps.setString(3, data.getHandle());
        //------------------------------------------------------------------------------------------------------------------------------------
        ps.addBatch();
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return ps.executeBatch().length;
    }
  }

  public int deleteByPK(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM ZD_WAFER_STORAGE_LOCATION WHERE HANDLE=?")) {
      ps.setString(1, handle);
      //------------------------------------------------------------------------------------------------------------------------------------
      return ps.executeUpdate();
    }
  }

  public int deleteByParent(String parent) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM ZD_WAFER_STORAGE_LOCATION WHERE PARENT=?")) {
      ps.setString(1, parent);
      //------------------------------------------------------------------------------------------------------------------------------------
      return ps.executeUpdate();
    }
  }

  public int deleteByParent(List<WaferStorageLocation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM ZD_WAFER_STORAGE_LOCATION WHERE PARENT=?")) {
      for (WaferStorageLocation data : dataList) {
        ps.setString(1, data.getHandle());
        //------------------------------------------------------------------------------------------------------------------------------------
        ps.addBatch();
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return ps.executeBatch().length;
    }
  }

  public List<WaferStorageLocation> selectByParent(String parent) throws SQLException {
    ArrayList<WaferStorageLocation> result = new ArrayList<WaferStorageLocation>();
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT * FROM ZD_WAFER_STORAGE_LOCATION WHERE PARENT=?")) {
      ps.setString(1, parent);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  public List<WaferStorageLocation> selectListByLevel(Integer level) throws SQLException {
    ArrayList<WaferStorageLocation> result = new ArrayList<WaferStorageLocation>();
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT * FROM ZD_WAFER_STORAGE_LOCATION WHERE LEVEL=?")) {
      ps.setInt(1, level);
      //------------------------------------------------------------------------------------------------------------------------------------
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  public List<WaferStorageLocation> selectByParentAndPosition(String parent, String code)
      throws SQLException { //除去已经被使用的槽位
    ArrayList<WaferStorageLocation> result = new ArrayList<WaferStorageLocation>();
    String sql = "SELECT * FROM ZD_WAFER_STORAGE_LOCATION WHERE PARENT=? ";

    if (code != null && !code.equals("")) {
      String[] codeArr = code.split(",");
      for (int i = 0; i < codeArr.length; i++) {
        sql = sql + " AND CODE !=" + codeArr[i] + " ";
      }
    }

    try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
      ps.setString(1, parent);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  public List<WaferStorageLocation> selectListByCodeLevel(String code, Integer level)
      throws SQLException {
    ArrayList<WaferStorageLocation> result = new ArrayList<WaferStorageLocation>();
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT * FROM ZD_WAFER_STORAGE_LOCATION WHERE CODE=? AND LEVEL=?")) {
      ps.setString(1, code);
      ps.setInt(2, level);
      //------------------------------------------------------------------------------------------------------------------------------------
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  public WaferStorageLocation selectByPK(String handle) throws SQLException {
    WaferStorageLocation result = null;
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT * FROM ZD_WAFER_STORAGE_LOCATION WHERE HANDLE=?")) {
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

  public WaferStorageLocation selectOneByCodeLevel(String code, Integer level) throws SQLException {
    WaferStorageLocation result = null;
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT * FROM ZD_WAFER_STORAGE_LOCATION WHERE CODE=? AND LEVEL=?")) {
      ps.setString(1, code);
      ps.setInt(2, level);
      //------------------------------------------------------------------------------------------------------------------------------------
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  private WaferStorageLocation convert(ResultSet rs) throws SQLException {
    WaferStorageLocation data = new WaferStorageLocation();
    //------------------------------------------------------------------------------------------------------------------------------------
    data.setHandle(rs.getString("HANDLE"));
    data.setCode(rs.getString("CODE"));
    data.setLevel(rs.getInt("LEVEL"));
    data.setParent(rs.getString("PARENT"));
    data.setCreatedTime(WaferStorageDao.getDateTz(rs, "CREATED_TIME"));
    data.setUpdatedTime(WaferStorageDao.getDateTz(rs, "UPDATED_TIME"));
    //------------------------------------------------------------------------------------------------------------------------------------
    return data;
  }
}
