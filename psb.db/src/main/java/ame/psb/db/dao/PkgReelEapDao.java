package ame.psb.db.dao;

import ame.psb.db.PkgReelEap;
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
public class PkgReelEapDao {

  private static final String SQL_INS = "INSERT INTO ZR_PKG_REEL_EAP(HANDLE, EQUIPMENT_ID, REEL_ID, WAFER_ID, REEL_SEQ, PICK_BIN, LOT, GOOD_DIE, BAD_DIE, XML, CREATED_TIME, WAFER_SEQ, CONTAINER_BO) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  //private static final String SQL_UPD = "UPDATE ZR_PKG_REEL_EAP SET EQUIPMENT_ID=?,REEL_ID=?,WAFER_ID=?,REEL_SQL=?,PICK_BIN=?,LOT=?,GOOD_DIE=?,BAD_DIE=?,XML=? WHERE HANDLE=?";

  private final Connection conn;

  public PkgReelEapDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgReelEap data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getEquipmentId());
      ps.setString(3, data.getReelId());
      ps.setString(4, data.getWaferId());
      ps.setInt(5, data.getReelSeq());
      ps.setString(6, data.getPickBin());
      ps.setString(7, data.getLot());
      ps.setBigDecimal(8, data.getGoodDie());
      ps.setBigDecimal(9, data.getBadDie());
      ps.setString(10, data.getXml());
      DateUtils.setDateTz(ps, 11, data.getCreatedTime());
      ps.setInt(12, data.getWaferSeq());
      ps.setString(13, data.getContainerBo());
      //------------------------------------------------------------------------------------------------------------------------------------
      return ps.executeUpdate();
    }
  }

  public int insert(List<PkgReelEap> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PkgReelEap data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getEquipmentId());
        ps.setString(3, data.getReelId());
        ps.setString(4, data.getWaferId());
        ps.setInt(5, data.getReelSeq());
        ps.setString(6, data.getPickBin());
        ps.setString(7, data.getLot());
        ps.setBigDecimal(8, data.getGoodDie());
        ps.setBigDecimal(9, data.getBadDie());
        ps.setString(10, data.getXml());
        DateUtils.setDateTz(ps, 11, data.getCreatedTime());
        ps.setInt(12, data.getWaferSeq());
        ps.setString(13, data.getContainerBo());
        //------------------------------------------------------------------------------------------------------------------------------------
        ps.addBatch();
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return ps.executeBatch().length;
    }
  }

  public int deleteByReel(String reelId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM ZR_PKG_REEL_EAP WHERE REEL_ID=?")) {
      ps.setString(1, reelId);
      //------------------------------------------------------------------------------------------------------------------------------------
      return ps.executeUpdate();
    }
  }

  public int updateContainerByReel(String reelId, String containerBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE ZR_PKG_REEL_EAP SET CONTAINER_BO=? WHERE REEL_ID=?")) {
      ps.setString(1, containerBo);
      ps.setString(2, reelId);
      //------------------------------------------------------------------------------------------------------------------------------------
      return ps.executeUpdate();
    }
  }

  public PkgReelEap selectByPK(String handle) throws SQLException {
    PkgReelEap result = null;
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT * FROM ZR_PKG_REEL_EAP WHERE HANDLE = ?")) {
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

  public List<PkgReelEap> selectByReelId(String reelId) throws SQLException {
    ArrayList<PkgReelEap> result = new ArrayList<>();
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT * FROM ZR_PKG_REEL_EAP WHERE REEL_ID = ? ORDER BY WAFER_SEQ")) {
      ps.setString(1, reelId);
      //------------------------------------------------------------------------------------------------------------------------------------
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  public int insertPkg_LabelCheck(String Pkg_Labe) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("INSERT INTO WIP.ZR_PKG_LABELCHECK(LABEL_TEMP_INFO)VALUES(?);")) {
      ps.setString(1, Pkg_Labe);
      //------------------------------------------------------------------------------------------------------------------------------------
      return ps.executeUpdate();
      //_________________________________________________________________________________________________________________________________
    }
  }

  public WaferInfo selectByWafer(String waferId) throws SQLException {
    WaferInfo result = null;
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT TOP 1 * FROM VIEW_CUSTOMER_ITEM WHERE ITEM_NAME = ? AND SFC_TYPE='S'")) {
      ps.setString(1, waferId);
      //------------------------------------------------------------------------------------------------------------------------------------
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convertWaferInfo(rs);
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  public WaferInfo selectByWaferAndSfcState(String waferId)
      throws SQLException { //xf20210221add 用于reelreport打印非关闭的sfc信息
    WaferInfo result = null;
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT TOP 1 * FROM VIEW_CUSTOMER_ITEM WHERE ITEM_NAME = ? AND SFC_TYPE='S' AND SFC_STATE_NAME!='CLOSE' ")) {
      ps.setString(1, waferId);
      //------------------------------------------------------------------------------------------------------------------------------------
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convertWaferInfo(rs);
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return result;
    }
  }

  public Long selectWaferCount(String waferId, String pickBin) throws SQLException {
    Long pkgCount = 0L;
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT CIG.DIE_QTY FROM  ZR_CUSTOMER_ITEM_GRADE CIG INNER JOIN VIEW_CUSTOMER_ITEM CI ON CIG.CUSTOMER_ITEM_BO  = CI.ID WHERE CI.ITEM_NAME = ? AND CI.SFC_TYPE  ='S' AND CIG.GRADE_ID  = ?")) {
      ps.setString(1, waferId);
      ps.setString(2, pickBin);
      //------------------------------------------------------------------------------------------------------------------------------------
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        pkgCount = rs.getLong(1);
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return pkgCount;
    }
  }

  public Long selectPkgCount(String waferId, String pickBin) throws SQLException {
    Long pkgCount = 0L;
    //------------------------------------------------------------------------------------------------------------------------------------
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT SUM(SIG.DIE_QTY) FROM  ZD_SFC_ITEM_GRADE SIG INNER JOIN VIEW_CUSTOMER_ITEM CI ON SIG.CUSTOMER_ITEM_BO  = CI.ID WHERE CI.ITEM_NAME = ? AND CI.SFC_TYPE  ='S' AND SIG.GRADE_ID  = ?")) {
      ps.setString(1, waferId);
      ps.setString(2, pickBin);
      //------------------------------------------------------------------------------------------------------------------------------------
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        pkgCount = rs.getLong(1);
      }
      //------------------------------------------------------------------------------------------------------------------------------------
      return pkgCount;
    }
  }

  private PkgReelEap convert(ResultSet rs) throws SQLException {
    PkgReelEap data = new PkgReelEap();
    //------------------------------------------------------------------------------------------------------------------------------------
    data.setHandle(rs.getString("HANDLE"));
    data.setEquipmentId(rs.getString("EQUIPMENT_ID"));
    data.setReelId(rs.getString("REEL_ID"));
    data.setWaferId(rs.getString("WAFER_ID"));
    data.setReelSeq(rs.getInt("REEL_SEQ"));
    data.setPickBin(rs.getString("PICK_BIN"));
    data.setLot(rs.getString("LOT"));
    data.setGoodDie(rs.getBigDecimal("GOOD_DIE"));
    data.setBadDie(rs.getBigDecimal("BAD_DIE"));
    data.setCreatedTime(WaferStorageDao.getDateTz(rs, "CREATED_TIME"));
    data.setWaferSeq(rs.getInt("WAFER_SEQ"));
    data.setContainerBo(rs.getString("CONTAINER_BO"));
    //------------------------------------------------------------------------------------------------------------------------------------
    return data;
  }

  private WaferInfo convertWaferInfo(ResultSet rs) throws SQLException {
    WaferInfo data = new WaferInfo();
    //------------------------------------------------------------------------------------------------------------------------------------
    data.customerItemBo = rs.getString("ID");
    data.customerItemName = rs.getString("ITEM_NAME");
    data.sfcBo = rs.getString("SFC_BO");
    data.sfcName = rs.getString("SFC_NAME");
    data.deviceBo = rs.getString("DEVICE_BO");
    data.deviceName = rs.getString("DEVICE_NAME");
    //------------------------------------------------------------------------------------------------------------------------------------
    return data;
  }

  public Connection getConnection() {
    return conn;
  }

  public static class WaferInfo {

    public String customerItemBo;
    public String customerItemName;
    public String sfcBo;
    public String sfcName;
    public String deviceBo;
    public String deviceName;
  }

}
