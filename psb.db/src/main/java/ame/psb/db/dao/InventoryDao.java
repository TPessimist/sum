package ame.psb.db.dao;

import ame.psb.db.Inventory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class InventoryDao {

  private static final String SQL_INS = "INSERT INTO inventory(handle,change_stamp,site,inventory_id,item_bo,inventory_context_gbo,description,qty_on_hand,assy_data_type_bo,usage_count,maximum_usage,status_bo,original_qty,work_center_loc_bo,work_center_loc_res,operation_loc_bo,operation_loc_res,resource_loc_bo,resource_loc_res,shop_order_loc_bo,shop_order_loc_res,shop_order_set_by_erp,receive_date_time,original_user_bo,storage_location_bo,has_been_used,created_date_time,modified_date_time,partition_date,parent_inventory_bo,erp_inventory) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE inventory SET change_stamp=?,site=?,inventory_id=?,item_bo=?,inventory_context_gbo=?,description=?,qty_on_hand=?,assy_data_type_bo=?,usage_count=?,maximum_usage=?,status_bo=?,original_qty=?,work_center_loc_bo=?,work_center_loc_res=?,operation_loc_bo=?,operation_loc_res=?,resource_loc_bo=?,resource_loc_res=?,shop_order_loc_bo=?,shop_order_loc_res=?,shop_order_set_by_erp=?,receive_date_time=?,original_user_bo=?,storage_location_bo=?,has_been_used=?,created_date_time=?,modified_date_time=?,partition_date=?,parent_inventory_bo=?,erp_inventory=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,change_stamp,site,inventory_id,item_bo,inventory_context_gbo,description,qty_on_hand,assy_data_type_bo,usage_count,maximum_usage,status_bo,original_qty,work_center_loc_bo,work_center_loc_res,operation_loc_bo,operation_loc_res,resource_loc_bo,resource_loc_res,shop_order_loc_bo,shop_order_loc_res,shop_order_set_by_erp,receive_date_time,original_user_bo,storage_location_bo,has_been_used,created_date_time,modified_date_time,partition_date,parent_inventory_bo,erp_inventory FROM inventory ";

  private final Connection conn;

  public InventoryDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Inventory data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setBigDecimal(2, data.getChangeStamp());
      ps.setString(3, data.getSite());
      ps.setString(4, data.getInventoryId());
      ps.setString(5, data.getItemBo());
      ps.setString(6, data.getInventoryContextGbo());
      ps.setString(7, data.getDescription());
      ps.setBigDecimal(8, data.getQtyOnHand());
      ps.setString(9, data.getAssyDataTypeBo());
      ps.setBigDecimal(10, data.getUsageCount());
      ps.setBigDecimal(11, data.getMaximumUsage());
      ps.setString(12, data.getStatusBo());
      ps.setBigDecimal(13, data.getOriginalQty());
      ps.setString(14, data.getWorkCenterLocBo());
      ps.setString(15, data.getWorkCenterLocRes());
      ps.setString(16, data.getOperationLocBo());
      ps.setString(17, data.getOperationLocRes());
      ps.setString(18, data.getResourceLocBo());
      ps.setString(19, data.getResourceLocRes());
      ps.setString(20, data.getShopOrderLocBo());
      ps.setString(21, data.getShopOrderLocRes());
      ps.setString(22, data.getShopOrderSetByErp());
      DateUtils.setDateTz(ps, 23, data.getReceiveDateTime());
      ps.setString(24, data.getOriginalUserBo());
      ps.setString(25, data.getStorageLocationBo());
      ps.setString(26, data.getHasBeenUsed());
      DateUtils.setDateTz(ps, 27, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 28, data.getModifiedDateTime());
      DateUtils.setDateTz(ps, 29, data.getPartitionDate());
      ps.setString(30, data.getParentInventoryBo());
      ps.setString(31, data.getErpInventory());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Inventory> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Inventory data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setBigDecimal(2, data.getChangeStamp());
        ps.setString(3, data.getSite());
        ps.setString(4, data.getInventoryId());
        ps.setString(5, data.getItemBo());
        ps.setString(6, data.getInventoryContextGbo());
        ps.setString(7, data.getDescription());
        ps.setBigDecimal(8, data.getQtyOnHand());
        ps.setString(9, data.getAssyDataTypeBo());
        ps.setBigDecimal(10, data.getUsageCount());
        ps.setBigDecimal(11, data.getMaximumUsage());
        ps.setString(12, data.getStatusBo());
        ps.setBigDecimal(13, data.getOriginalQty());
        ps.setString(14, data.getWorkCenterLocBo());
        ps.setString(15, data.getWorkCenterLocRes());
        ps.setString(16, data.getOperationLocBo());
        ps.setString(17, data.getOperationLocRes());
        ps.setString(18, data.getResourceLocBo());
        ps.setString(19, data.getResourceLocRes());
        ps.setString(20, data.getShopOrderLocBo());
        ps.setString(21, data.getShopOrderLocRes());
        ps.setString(22, data.getShopOrderSetByErp());
        DateUtils.setDateTz(ps, 23, data.getReceiveDateTime());
        ps.setString(24, data.getOriginalUserBo());
        ps.setString(25, data.getStorageLocationBo());
        ps.setString(26, data.getHasBeenUsed());
        DateUtils.setDateTz(ps, 27, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 28, data.getModifiedDateTime());
        DateUtils.setDateTz(ps, 29, data.getPartitionDate());
        ps.setString(30, data.getParentInventoryBo());
        ps.setString(31, data.getErpInventory());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Inventory data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getChangeStamp());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getInventoryId());
      ps.setString(4, data.getItemBo());
      ps.setString(5, data.getInventoryContextGbo());
      ps.setString(6, data.getDescription());
      ps.setBigDecimal(7, data.getQtyOnHand());
      ps.setString(8, data.getAssyDataTypeBo());
      ps.setBigDecimal(9, data.getUsageCount());
      ps.setBigDecimal(10, data.getMaximumUsage());
      ps.setString(11, data.getStatusBo());
      ps.setBigDecimal(12, data.getOriginalQty());
      ps.setString(13, data.getWorkCenterLocBo());
      ps.setString(14, data.getWorkCenterLocRes());
      ps.setString(15, data.getOperationLocBo());
      ps.setString(16, data.getOperationLocRes());
      ps.setString(17, data.getResourceLocBo());
      ps.setString(18, data.getResourceLocRes());
      ps.setString(19, data.getShopOrderLocBo());
      ps.setString(20, data.getShopOrderLocRes());
      ps.setString(21, data.getShopOrderSetByErp());
      DateUtils.setDateTz(ps, 22, data.getReceiveDateTime());
      ps.setString(23, data.getOriginalUserBo());
      ps.setString(24, data.getStorageLocationBo());
      ps.setString(25, data.getHasBeenUsed());
      DateUtils.setDateTz(ps, 26, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 27, data.getModifiedDateTime());
      DateUtils.setDateTz(ps, 28, data.getPartitionDate());
      ps.setString(29, data.getParentInventoryBo());
      ps.setString(30, data.getErpInventory());
      ps.setString(31, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<Inventory> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Inventory data : dataList) {
        ps.setBigDecimal(1, data.getChangeStamp());
        ps.setString(2, data.getSite());
        ps.setString(3, data.getInventoryId());
        ps.setString(4, data.getItemBo());
        ps.setString(5, data.getInventoryContextGbo());
        ps.setString(6, data.getDescription());
        ps.setBigDecimal(7, data.getQtyOnHand());
        ps.setString(8, data.getAssyDataTypeBo());
        ps.setBigDecimal(9, data.getUsageCount());
        ps.setBigDecimal(10, data.getMaximumUsage());
        ps.setString(11, data.getStatusBo());
        ps.setBigDecimal(12, data.getOriginalQty());
        ps.setString(13, data.getWorkCenterLocBo());
        ps.setString(14, data.getWorkCenterLocRes());
        ps.setString(15, data.getOperationLocBo());
        ps.setString(16, data.getOperationLocRes());
        ps.setString(17, data.getResourceLocBo());
        ps.setString(18, data.getResourceLocRes());
        ps.setString(19, data.getShopOrderLocBo());
        ps.setString(20, data.getShopOrderLocRes());
        ps.setString(21, data.getShopOrderSetByErp());
        DateUtils.setDateTz(ps, 22, data.getReceiveDateTime());
        ps.setString(23, data.getOriginalUserBo());
        ps.setString(24, data.getStorageLocationBo());
        ps.setString(25, data.getHasBeenUsed());
        DateUtils.setDateTz(ps, 26, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 27, data.getModifiedDateTime());
        DateUtils.setDateTz(ps, 28, data.getPartitionDate());
        ps.setString(29, data.getParentInventoryBo());
        ps.setString(30, data.getErpInventory());
        ps.setString(31, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM inventory WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<Inventory> selectAll() throws SQLException {
    ArrayList<Inventory> result = new ArrayList<Inventory>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Inventory selectByPK(String handle) throws SQLException {
    Inventory result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private Inventory convert(ResultSet rs) throws SQLException {
    Inventory data = new Inventory();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setChangeStamp(rs.getBigDecimal(index++));
    data.setSite(rs.getString(index++));
    data.setInventoryId(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setInventoryContextGbo(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setQtyOnHand(rs.getBigDecimal(index++));
    data.setAssyDataTypeBo(rs.getString(index++));
    data.setUsageCount(rs.getBigDecimal(index++));
    data.setMaximumUsage(rs.getBigDecimal(index++));
    data.setStatusBo(rs.getString(index++));
    data.setOriginalQty(rs.getBigDecimal(index++));
    data.setWorkCenterLocBo(rs.getString(index++));
    data.setWorkCenterLocRes(rs.getString(index++));
    data.setOperationLocBo(rs.getString(index++));
    data.setOperationLocRes(rs.getString(index++));
    data.setResourceLocBo(rs.getString(index++));
    data.setResourceLocRes(rs.getString(index++));
    data.setShopOrderLocBo(rs.getString(index++));
    data.setShopOrderLocRes(rs.getString(index++));
    data.setShopOrderSetByErp(rs.getString(index++));
    data.setReceiveDateTime(DateUtils.getDateTz(rs, index++));
    data.setOriginalUserBo(rs.getString(index++));
    data.setStorageLocationBo(rs.getString(index++));
    data.setHasBeenUsed(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setPartitionDate(DateUtils.getDateTz(rs, index++));
    data.setParentInventoryBo(rs.getString(index++));
    data.setErpInventory(rs.getString(index++));

    return data;
  }
}
