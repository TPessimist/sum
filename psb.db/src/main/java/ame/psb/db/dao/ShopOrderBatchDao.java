package ame.psb.db.dao;

import ame.psb.db.ShopOrderBatch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import uia.utils.dao.DateUtils;

public class ShopOrderBatchDao {

  private static final String SQL_INS = "INSERT INTO zd_shop_order_batch(shop_order_bo,batch_id,sfc_bo,finish_flag,reverse_field1,reverse_field2,update_user,update_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_shop_order_batch SET finish_flag=?,reverse_field1=?,reverse_field2=?,update_user=?,update_time=? WHERE shop_order_bo=? AND batch_id=? AND sfc_bo=?";

  private static final String SQL_UPD_BY_SFC = "UPDATE zd_shop_order_batch SET finish_flag=?,reverse_field1=?,reverse_field2=?,update_user=?,update_time=?, batch_id = ? WHERE sfc_bo = ?";

  private static final String SQL_UPD_BY_SFC1 = "UPDATE zd_shop_order_batch SET finish_flag=?,reverse_field1=?,reverse_field2=?,update_user=?,update_time=?, batch_id = ?, SHOP_ORDER_BO = ?  WHERE sfc_bo = ?";

  private static final String SQL_SEL = "SELECT shop_order_bo,batch_id,sfc_bo,finish_flag,reverse_field1,reverse_field2,update_user,update_time FROM zd_shop_order_batch ";

  private static final String SQL_SEL_VIEW = "SELECT shop_order_bo,batch_id,sfc_bo,finish_flag,reverse_field1,reverse_field2,update_user,update_time,CARRIER_BO FROM VIEW_SHOP_ORDER_BATCH_CARRIER ";


  private final Connection conn;

  public ShopOrderBatchDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ShopOrderBatch data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getShopOrderBo());
      ps.setString(2, data.getBatchId());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getFinishFlag());
      ps.setString(5, data.getReverseField1());
      ps.setString(6, data.getReverseField2());
      ps.setString(7, data.getUpdateUser());
      DateUtils.setDateTz(ps, 8, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ShopOrderBatch> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ShopOrderBatch data : dataList) {
        ps.setString(1, data.getShopOrderBo());
        ps.setString(2, data.getBatchId());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getFinishFlag());
        ps.setString(5, data.getReverseField1());
        ps.setString(6, data.getReverseField2());
        ps.setString(7, data.getUpdateUser());
        DateUtils.setDateTz(ps, 8, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ShopOrderBatch data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFinishFlag());
      ps.setString(2, data.getReverseField1());
      ps.setString(3, data.getReverseField2());
      ps.setString(4, data.getUpdateUser());
      DateUtils.setDateTz(ps, 5, data.getUpdateTime());
      ps.setString(6, data.getShopOrderBo());
      ps.setString(7, data.getBatchId());
      ps.setString(8, data.getSfcBo());

      return ps.executeUpdate();
    }
  }

  public int updateBySfc(ShopOrderBatch data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_BY_SFC)) {
      ps.setString(1, data.getFinishFlag());
      ps.setString(2, data.getReverseField1());
      ps.setString(3, data.getReverseField2());
      ps.setString(4, data.getUpdateUser());
      DateUtils.setDateTz(ps, 5, data.getUpdateTime());
      ps.setString(6, data.getBatchId());
      ps.setString(7, data.getSfcBo());

      return ps.executeUpdate();
    }
  }

  public int updateBySfc1(ShopOrderBatch data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_BY_SFC1)) {
      ps.setString(1, data.getFinishFlag());
      ps.setString(2, data.getReverseField1());
      ps.setString(3, data.getReverseField2());
      ps.setString(4, data.getUpdateUser());
      DateUtils.setDateTz(ps, 5, data.getUpdateTime());
      ps.setString(6, data.getBatchId());
      ps.setString(7, data.getShopOrderBo());
      ps.setString(8, data.getSfcBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ShopOrderBatch> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ShopOrderBatch data : dataList) {
        ps.setString(1, data.getFinishFlag());
        ps.setString(2, data.getReverseField1());
        ps.setString(3, data.getReverseField2());
        ps.setString(4, data.getUpdateUser());
        DateUtils.setDateTz(ps, 5, data.getUpdateTime());
        ps.setString(6, data.getShopOrderBo());
        ps.setString(7, data.getBatchId());
        ps.setString(8, data.getSfcBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String shopOrderBo, String batchId, String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_shop_order_batch WHERE shop_order_bo=? AND batch_id=? AND sfc_bo=?")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, batchId);
      ps.setString(3, sfcBo);

      return ps.executeUpdate();
    }
  }

  public List<ShopOrderBatch> selectAll() throws SQLException {
    ArrayList<ShopOrderBatch> result = new ArrayList<ShopOrderBatch>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public List<ShopOrderBatch> selectBySfcNameOrBatchId(String sfcName, String batchId)
      throws SQLException {
    ArrayList<ShopOrderBatch> result = new ArrayList<>();
    PreparedStatement ps;
    if ("".equals(sfcName)) {
      ps = this.conn.prepareStatement(SQL_SEL_VIEW + "where batch_id = ?");
      ps.setString(1, batchId);
    } else if ("".equals(batchId)) {
      ps = this.conn.prepareStatement(SQL_SEL_VIEW + "where REVERSE_FIELD1 = ?");
      ps.setString(1, "SFCBO:1020," + sfcName);
    } else {
      ps = this.conn.prepareStatement(SQL_SEL_VIEW + "where REVERSE_FIELD1 = ? and batch_id = ?");
      ps.setString(1, "SFCBO:1020," + sfcName);
      ps.setString(2, batchId);
    }
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      result.add(this.convertView(rs));
    }
    ps.close();
    return result;

  }

  public List<ShopOrderBatch> selectByShopOrderAll() throws SQLException {
    ArrayList<ShopOrderBatch> result = new ArrayList<ShopOrderBatch>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where FINISH_FLAG IS NOT NULL")) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ShopOrderBatch> selectByShopOrderId(String shopOrderBo) throws SQLException {
    ArrayList<ShopOrderBatch> result = new ArrayList<ShopOrderBatch>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where SHOP_ORDER_BO = ? AND  FINISH_FLAG IS NOT NULL")) {
      ps.setString(1, shopOrderBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ShopOrderBatch> selectByShopOrder(String shopOrderBo) throws SQLException {
    ArrayList<ShopOrderBatch> result = new ArrayList<ShopOrderBatch>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where SHOP_ORDER_BO = ?")) {
      ps.setString(1, shopOrderBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ShopOrderBatch> selectFcdaBatchByShopOrder(String shopOrderBo) throws SQLException {
    ArrayList<ShopOrderBatch> result = new ArrayList<ShopOrderBatch>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " where SHOP_ORDER_BO = ? AND ((BATCH_ID IS NOT NULL AND BATCH_ID != '') OR "
            + "(REVERSE_FIELD2 IS NOT NULL AND REVERSE_FIELD2 != '')) ORDER BY UPDATE_TIME")) {
      ps.setString(1, shopOrderBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ShopOrderBatch> selectBySfcBo(String sfcBo) throws SQLException {
    ArrayList<ShopOrderBatch> result = new ArrayList<ShopOrderBatch>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where SFC_BO = ?")) {
      ps.setString(1, sfcBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public ShopOrderBatch selectByPK(String sfcBo) throws SQLException {
    ShopOrderBatch result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public ShopOrderBatch selectBySfc(String shopOrder, String sfcBo) throws SQLException {
    ShopOrderBatch result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE SHOP_ORDER_BO = ? and sfc_bo=?")) {
      ps.setString(1, shopOrder);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public ShopOrderBatch selectBySfc(String sfcBo) throws SQLException {
    ShopOrderBatch result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE SHOP_ORDER_BO = ? and sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public ShopOrderBatch selectByBatch(String Batch) throws SQLException {
    ShopOrderBatch result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE batch_id=?")) {
      ps.setString(1, Batch);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public List<ShopOrderBatch> selectListByFCDABatchId(String batchId) throws SQLException {
    List<ShopOrderBatch> result = selectListByBatch(batchId);
    if (result.size() == 0) {
      result = selectListByReverse2(batchId);
    }
    return result;
  }

  public List<ShopOrderBatch> selectListByBatch(String Batch) throws SQLException {
    List<ShopOrderBatch> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE batch_id=?")) {
      ps.setString(1, Batch);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ShopOrderBatch> selectListByReverse2(String Batch) throws SQLException {
    List<ShopOrderBatch> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE reverse_field2 like ?")) {
      ps.setString(1, Batch + "=>%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public ShopOrderBatch selectByReverse2(String Batch) throws SQLException {
    ShopOrderBatch result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE reverse_field2 like ?")) {
      ps.setString(1, Batch + "%");

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public ShopOrderBatch selectByPK(String shopOrderBo, String batchId, String sfcBo)
      throws SQLException {
    ShopOrderBatch result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE shop_order_bo=? AND batch_id=? AND sfc_bo=?")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, batchId);
      ps.setString(3, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public boolean isBatchFinished(String shopOrderBo) throws SQLException {
    List<ShopOrderBatch> shopOrderBatches = this.selectByShopOrder(shopOrderBo);
    List<ShopOrderBatch> result = shopOrderBatches.stream()
        .filter(shopOrderBatch -> "Y".equals(shopOrderBatch.getFinishFlag()))
        .collect(Collectors.toList());
    return result.size() > 0;
  }


  public List<String> selectBatchIdList(String sfcBo) throws SQLException {
    List<String> result = new ArrayList<>();
    ShopOrderBatch shopOrderBatch = selectByPK(sfcBo);
    if (null != shopOrderBatch) {
      String reverseField2 = shopOrderBatch.getReverseField2();
      String batchId = shopOrderBatch.getBatchId();
      result.add(batchId);
      if (null != reverseField2 && reverseField2.contains("=>")) {
        result.add(reverseField2.split("=>")[0]);
      }
    }
    return result;
  }


  private ShopOrderBatch convert(ResultSet rs) throws SQLException {
    ShopOrderBatch data = new ShopOrderBatch();

    int index = 1;
    data.setShopOrderBo(rs.getString(index++));
    data.setBatchId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setFinishFlag(rs.getString(index++));
    data.setReverseField1(rs.getString(index++));
    data.setReverseField2(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }

  private ShopOrderBatch convertView(ResultSet rs) throws SQLException {
    ShopOrderBatch data = new ShopOrderBatch();

    int index = 1;
    data.setShopOrderBo(rs.getString(index++));
    data.setBatchId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setFinishFlag(rs.getString(index++));
    data.setReverseField1(rs.getString(index++));
    data.setReverseField2(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setCarrierBo(rs.getString(index++));

    return data;
  }
}
