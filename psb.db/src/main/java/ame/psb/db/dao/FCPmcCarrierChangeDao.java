package ame.psb.db.dao;

import ame.psb.db.FCPmcCarrierChange;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FCPmcCarrierChangeDao {

  private static final String SQL_INS = "INSERT INTO zd_fc_pmc_carrier_change(sfc_bo,batch_id,original_carrier,new_carrier,operation_bo,resource_bo,update_user,update_time,SHOP_ORDER_BO) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_fc_pmc_carrier_change SET batch_id=?,original_carrier=?,new_carrier=?,operation_bo=?,resource_bo=?,update_user=?,update_time=?,SHOP_ORDER_BO = ? WHERE sfc_bo=?";

  private static final String SQL_SEL = "SELECT sfc_bo,batch_id,original_carrier,new_carrier,operation_bo,resource_bo,update_user,update_time,SHOP_ORDER_BO FROM zd_fc_pmc_carrier_change ";

  private final Connection conn;

  public FCPmcCarrierChangeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FCPmcCarrierChange data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getBatchId());
      ps.setString(3, data.getOriginalCarrier());
      ps.setString(4, data.getNewCarrier());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getResourceBo());
      ps.setString(7, data.getUpdateUser());
      DateUtils.setDateTz(ps, 8, data.getUpdateTime());
      ps.setString(9,data.getShopOrderBo());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FCPmcCarrierChange> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FCPmcCarrierChange data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getBatchId());
        ps.setString(3, data.getOriginalCarrier());
        ps.setString(4, data.getNewCarrier());
        ps.setString(5, data.getOperationBo());
        ps.setString(6, data.getResourceBo());
        ps.setString(7, data.getUpdateUser());
        DateUtils.setDateTz(ps, 8, data.getUpdateTime());
        ps.setString(9,data.getShopOrderBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FCPmcCarrierChange data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getBatchId());
      ps.setString(2, data.getOriginalCarrier());
      ps.setString(3, data.getNewCarrier());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getResourceBo());
      ps.setString(6, data.getUpdateUser());
      DateUtils.setDateTz(ps, 7, data.getUpdateTime());
      ps.setString(8,data.getShopOrderBo());
      ps.setString(9, data.getSfcBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<FCPmcCarrierChange> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FCPmcCarrierChange data : dataList) {
        ps.setString(1, data.getBatchId());
        ps.setString(2, data.getOriginalCarrier());
        ps.setString(3, data.getNewCarrier());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getResourceBo());
        ps.setString(6, data.getUpdateUser());
        DateUtils.setDateTz(ps, 7, data.getUpdateTime());
        ps.setString(8,data.getShopOrderBo());
        ps.setString(9, data.getSfcBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_fc_pmc_carrier_change WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      return ps.executeUpdate();
    }
  }

  public List<FCPmcCarrierChange> selectAll() throws SQLException {
    ArrayList<FCPmcCarrierChange> result = new ArrayList<FCPmcCarrierChange>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FCPmcCarrierChange> selectByBatchId(String batchid) throws SQLException {
    ArrayList<FCPmcCarrierChange> result = new ArrayList<FCPmcCarrierChange>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where BATCH_ID =?")) {
      ps.setString(1, batchid);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FCPmcCarrierChange selectByPK(String sfcBo) throws SQLException {
    FCPmcCarrierChange result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }
  public List<FCPmcCarrierChange> selectByPKShopOrderBo(String shopOrderBo) throws SQLException {
    List<FCPmcCarrierChange> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE SHOP_ORDER_BO=?")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs)) ;
      }
      return result;
    }
  }
  private FCPmcCarrierChange convert(ResultSet rs) throws SQLException {
    FCPmcCarrierChange data = new FCPmcCarrierChange();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setBatchId(rs.getString(index++));
    data.setOriginalCarrier(rs.getString(index++));
    data.setNewCarrier(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setShopOrderBo(rs.getString(index++));

    return data;
  }
}
