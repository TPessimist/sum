package ame.psb.db.dao;

import ame.psb.db.WaferMembranceType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: helios
 * @DATE: 2020/09/22
 * @description:
 */
public class WaferMembranceTypeDao {

  private final Connection conn;

  public WaferMembranceTypeDao(Connection conn) {
    this.conn = conn;
  }

  public List<WaferMembranceType> selectAll() throws SQLException {
    ArrayList<WaferMembranceType> result = new ArrayList<WaferMembranceType>();
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT * FROM ZD_WAFER_MEMBRANCE_TYPE")) {
      ResultSet rs = ps.executeQuery();
      //------------------------------------------------------------------------------------------------------------------------------------
      while (rs.next()) {
        result.add(convert(rs));
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  public WaferMembranceType selectByPK(String ID) throws SQLException {
    WaferMembranceType result = null;
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT * FROM ZD_WAFER_MEMBRANCE_TYPE WHERE ID=?")) {
      ps.setString(1, ID);
      ResultSet rs = ps.executeQuery();
      //------------------------------------------------------------------------------------------------------------------------------------
      if (rs.next()) {
        result = convert(rs);
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  public int update(List<WaferMembranceType> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE ZD_WAFER_MEMBRANCE_TYPE SET HOLD_DAY=?, AHEAD_DAY=?, MAIL_TO=? WHERE ID=?")) {
      for (WaferMembranceType data : dataList) {
        ps.setInt(1, data.getHoldDay());
        ps.setInt(2, data.getAheadDay());
        ps.setString(3, data.getMailTo());
        ps.setString(4, data.getId());
        //------------------------------------------------------------------------------------------------------------------------------------
        ps.addBatch();
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return ps.executeBatch().length;
    }
  }

  private WaferMembranceType convert(ResultSet rs) throws SQLException {
    WaferMembranceType data = new WaferMembranceType();
    //------------------------------------------------------------------------------------------------------------------------------------
    data.setId(rs.getString("ID"));
    data.setTypeName(rs.getString("TYPE_NAME"));
    data.setHoldDay(rs.getInt("HOLD_DAY"));
    data.setAheadDay(rs.getInt("AHEAD_DAY"));
    data.setMailTo(rs.getString("MAIL_TO"));
    data.setCreatedTime(WaferStorageDao.getDateTz(rs, "CREATED_TIME"));
    data.setUpdatedTime(WaferStorageDao.getDateTz(rs, "UPDATED_TIME"));
    //------------------------------------------------------------------------------------------------------------------------------------
    return data;
  }
}
