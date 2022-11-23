package ame.me.db.dao;

import ame.me.db.InventoryDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDetailDao {

  private static final String SQL_SEL = "SELECT " +
      "handle,change_stamp,site,inventory_id,item_bo,inventory_context_gbo,description,qty_on_hand,"
      +
      "assy_data_type_bo,usage_count,maximum_usage,status_bo,original_qty," +
      "work_center_loc_bo,work_center_loc_res,operation_loc_bo,operation_loc_res," +
      "resource_loc_bo,resource_loc_res,shop_order_loc_bo,shop_order_loc_res,shop_order_set_by_erp,"
      +
      "original_user_bo,storage_location_bo,has_been_used," +
      "receive_date_time,created_date_time,modified_date_time," +
      "partition_date,parent_inventory_bo,erp_inventory," +
      "sup_sn,prd_date,eff_date FROM view_inventory ";

  private Connection conn;

  public InventoryDetailDao(Connection conn) {
    this.conn = conn;
  }

  public InventoryDetail selectByPK(String inventoryBo) throws SQLException {
    InventoryDetail result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE handle=?")) {
      ps.setString(1, inventoryBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }
    return result;
  }

  public InventoryDetail selectById(String inventoryId) throws SQLException {
    InventoryDetail result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE inventory_id=?")) {
      ps.setString(1, inventoryId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }
    return result;
  }

  public List<InventoryDetail> selectAll() throws SQLException {
    ArrayList<InventoryDetail> result = new ArrayList<InventoryDetail>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " ORDER BY handle")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<InventoryDetail> selectByItem(String itemBo) throws SQLException {
    ArrayList<InventoryDetail> result = new ArrayList<InventoryDetail>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE item_bo=? ORDER BY handle")) {
      ps.setString(1, itemBo);
      //
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<InventoryDetail> selectByItem(String itemBo, String statusBo) throws SQLException {
    ArrayList<InventoryDetail> result = new ArrayList<InventoryDetail>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE item_bo=? AND status_bo=? ORDER BY handle")) {
      ps.setString(1, itemBo);
      ps.setString(2, statusBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<InventoryDetail> select(String shopOrderLocBo, String supSn) throws SQLException {
    ArrayList<InventoryDetail> result = new ArrayList<InventoryDetail>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE shop_order_loc_bo=? AND sup_sn=?")) {
      ps.setString(1, shopOrderLocBo);
      ps.setString(2, supSn);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<InventoryDetail> selectByShopOrder(String shopOrderLocBo) throws SQLException {
    ArrayList<InventoryDetail> result = new ArrayList<InventoryDetail>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE shop_order_loc_bo=?")) {
      ps.setString(1, shopOrderLocBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<InventoryDetail> selectBySupSn(String supSn) throws SQLException {
    ArrayList<InventoryDetail> result = new ArrayList<InventoryDetail>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE sup_sn=?")) {
      ps.setString(1, supSn);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<InventoryDetail> selectPickItem(String itemBo) throws SQLException {
    ArrayList<InventoryDetail> result = new ArrayList<InventoryDetail>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE item_bo=? AND status_bo='StatusBO:1020,1002' AND qty_on_hand > 0 ORDER BY inventory_id asc")) {
      ps.setString(1, itemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  private InventoryDetail convert(ResultSet rs) throws SQLException {
    InventoryDetail data = new InventoryDetail();
    data.setHandle(rs.getString(1));
    data.setChangeStamp(rs.getInt(2));
    data.setSite(rs.getString(3));
    data.setInventoryId(rs.getString(4));
    data.setItemBo(rs.getString(5));
    data.setInventoryContextGbo(rs.getString(6));
    data.setDescription(rs.getString(7));
    data.setQtyOnHand(rs.getBigDecimal(8));
    data.setAssyDataTypeBo(rs.getString(9));
    data.setUsageCount(rs.getBigDecimal(10));
    data.setMaximumUsage(rs.getBigDecimal(11));
    data.setStatusBo(rs.getString(12));
    data.setOriginalQty(rs.getBigDecimal(13));
    data.setWorkCenterLocBo(rs.getString(14));
    data.setWorkCenterLocRes(rs.getString(15));
    data.setOperationLocBo(rs.getString(16));
    data.setOperationLocRes(rs.getString(17));
    data.setResourceLocBo(rs.getString(18));
    data.setResourceLocRes(rs.getString(19));
    data.setShopOrderLocBo(rs.getString(20));
    data.setShopOrderLocRes(rs.getString(21));
    data.setShopOrderSetByErp(rs.getString(22));
    data.setOriginalUserBo(rs.getString(23));
    data.setStorageLocationBo(rs.getString(24));
    data.setHasBeenUsed(rs.getString(25));
    data.setReceiveDateTime(rs.getTimestamp(26));
    data.setCreatedDateTime(rs.getTimestamp(27));
    data.setModifiedDateTime(rs.getTimestamp(28));
    data.setPartitionDate(rs.getTimestamp(29));
    data.setParentInventoryBo(rs.getString(30));
    data.setErpInventory(rs.getString(31));
    data.setSupSn(rs.getString(32));
    data.setPrdDate(rs.getString(33));
    data.setEffDate(rs.getString(34));
    return data;
  }
}
