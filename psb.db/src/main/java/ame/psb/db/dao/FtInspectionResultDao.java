package ame.psb.db.dao;

import ame.psb.db.FtInspectionResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FtInspectionResultDao {

  private static final String SQL_INS = "INSERT INTO zd_ft_inspection_result(sfc,reel_id,unique_id,shop_order,total_qty,success_qty,fail_qty,device,device_qty,resource_release,manual_release,content,update_user,update_time,reserve1,reserve2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_ft_inspection_result SET unique_id=?,shop_order=?,total_qty=?,success_qty=?,fail_qty=?,device=?,device_qty=?,resource_release=?,manual_release=?,content=?,update_user=?,update_time=?,reserve1=?,reserve2=? WHERE sfc=? AND reel_id=?";

  private static final String SQL_SEL = "SELECT sfc,reel_id,unique_id,shop_order,total_qty,success_qty,fail_qty,device,device_qty,resource_release,manual_release,content,update_user,update_time,reserve1,reserve2 FROM zd_ft_inspection_result ";

  private final Connection conn;

  public FtInspectionResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FtInspectionResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfc());
      ps.setString(2, data.getReelId());
      ps.setString(3, data.getUniqueId());
      ps.setString(4, data.getShopOrder());
      ps.setInt(5, data.getTotalQty());
      ps.setInt(6, data.getSuccessQty());
      ps.setInt(7, data.getFailQty());
      ps.setString(8, data.getDevice());
      ps.setInt(9, data.getDeviceQty());
      ps.setString(10, data.getResourceRelease());
      ps.setString(11, data.getManualRelease());
      ps.setString(12, data.getContent());
      ps.setString(13, data.getUpdateUser());
      DateUtils.setDateTz(ps, 14, data.getUpdateTime());
      ps.setString(15, data.getReserve1());
      ps.setString(16, data.getReserve2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FtInspectionResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FtInspectionResult data : dataList) {
        ps.setString(1, data.getSfc());
        ps.setString(2, data.getReelId());
        ps.setString(3, data.getUniqueId());
        ps.setString(4, data.getShopOrder());
        ps.setInt(5, data.getTotalQty());
        ps.setInt(6, data.getSuccessQty());
        ps.setInt(7, data.getFailQty());
        ps.setString(8, data.getDevice());
        ps.setInt(9, data.getDeviceQty());
        ps.setString(10, data.getResourceRelease());
        ps.setString(11, data.getManualRelease());
        ps.setString(12, data.getContent());
        ps.setString(13, data.getUpdateUser());
        DateUtils.setDateTz(ps, 14, data.getUpdateTime());
        ps.setString(15, data.getReserve1());
        ps.setString(16, data.getReserve2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FtInspectionResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getUniqueId());
      ps.setString(2, data.getShopOrder());
      ps.setInt(3, data.getTotalQty());
      ps.setInt(4, data.getSuccessQty());
      ps.setInt(5, data.getFailQty());
      ps.setString(6, data.getDevice());
      ps.setInt(7, data.getDeviceQty());
      ps.setString(8, data.getResourceRelease());
      ps.setString(9, data.getManualRelease());
      ps.setString(10, data.getContent());
      ps.setString(11, data.getUpdateUser());
      DateUtils.setDateTz(ps, 12, data.getUpdateTime());
      ps.setString(13, data.getReserve1());
      ps.setString(14, data.getReserve2());
      ps.setString(15, data.getSfc());
      ps.setString(16, data.getReelId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FtInspectionResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FtInspectionResult data : dataList) {
        ps.setString(1, data.getUniqueId());
        ps.setString(2, data.getShopOrder());
        ps.setInt(3, data.getTotalQty());
        ps.setInt(4, data.getSuccessQty());
        ps.setInt(5, data.getFailQty());
        ps.setString(6, data.getDevice());
        ps.setInt(7, data.getDeviceQty());
        ps.setString(8, data.getResourceRelease());
        ps.setString(9, data.getManualRelease());
        ps.setString(10, data.getContent());
        ps.setString(11, data.getUpdateUser());
        DateUtils.setDateTz(ps, 12, data.getUpdateTime());
        ps.setString(13, data.getReserve1());
        ps.setString(14, data.getReserve2());
        ps.setString(15, data.getSfc());
        ps.setString(16, data.getReelId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String sfc, String reelId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_ft_inspection_result WHERE sfc=? AND reel_id=?")) {
      ps.setString(1, sfc);
      ps.setString(2, reelId);

      return ps.executeUpdate();
    }
  }

  public List<FtInspectionResult> selectAll() throws SQLException {
    ArrayList<FtInspectionResult> result = new ArrayList<FtInspectionResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FtInspectionResult selectByPK(String sfc, String reelId) throws SQLException {
    FtInspectionResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc=? AND reel_id=?")) {
      ps.setString(1, sfc);
      ps.setString(2, reelId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  /*
   * @desc by sfc查询
   * */
  public List<FtInspectionResult> selectBySfc(String sfc) throws SQLException {
    ArrayList<FtInspectionResult> result = new ArrayList<FtInspectionResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where sfc=? ")) {
      ps.setString(1, sfc);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  /*
   * @desc by sfc查询
   * */
  public List<FtInspectionResult> selectByUniqueId(String uniqueId) throws SQLException {
    ArrayList<FtInspectionResult> result = new ArrayList<FtInspectionResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where unique_id=? ")) {
      ps.setString(1, uniqueId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public FtInspectionResult selectByUniqueAndReserve2(String uniqueId, String reserve2)
      throws SQLException {
    FtInspectionResult result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE unique_id=? AND reserve2=?")) {
      ps.setString(1, uniqueId);
      ps.setString(2, reserve2);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FtInspectionResult convert(ResultSet rs) throws SQLException {
    FtInspectionResult data = new FtInspectionResult();

    int index = 1;
    data.setSfc(rs.getString(index++));
    data.setReelId(rs.getString(index++));
    data.setUniqueId(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setTotalQty(rs.getInt(index++));
    data.setSuccessQty(rs.getInt(index++));
    data.setFailQty(rs.getInt(index++));
    data.setDevice(rs.getString(index++));
    data.setDeviceQty(rs.getInt(index++));
    data.setResourceRelease(rs.getString(index++));
    data.setManualRelease(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setReserve1(rs.getString(index++));
    data.setReserve2(rs.getString(index++));

    return data;
  }
}
