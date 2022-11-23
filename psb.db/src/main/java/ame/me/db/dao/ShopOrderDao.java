package ame.me.db.dao;

import ame.me.db.ShopOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ShopOrderDao {

  private static final String SQL_INS = "INSERT INTO shop_order(handle,change_stamp,site,shop_order,status_bo,priority,planned_work_center_bo,planned_item_bo,planned_bom_bo,planned_router_bo,item_bo,bom_bo,router_bo,qty_to_build,qty_ordered,qty_released,released_date,planned_start_date,planned_comp_date,scheduled_start_date,scheduled_comp_date,actual_start_date,actual_comp_date,qty_done,qty_scrapped,created_date_time,modified_date_time,customer,customer_order,rma_sfc_data_type_bo,rma_shop_order_data_type_bo,original_status_bo,transfer_site,transfer_type,lcc_bo,shop_order_type_bo,hold_id,end_unit_number,req_serial_change,collect_parent_serial,batch_number,erp_order,erp_production_version,erp_unit_of_measure,partition_date,inspection_lot,inspection_group_size,erp_putaway_storloc,warehouse_number) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE shop_order SET change_stamp=?,site=?,shop_order=?,status_bo=?,priority=?,planned_work_center_bo=?,planned_item_bo=?,planned_bom_bo=?,planned_router_bo=?,item_bo=?,bom_bo=?,router_bo=?,qty_to_build=?,qty_ordered=?,qty_released=?,released_date=?,planned_start_date=?,planned_comp_date=?,scheduled_start_date=?,scheduled_comp_date=?,actual_start_date=?,actual_comp_date=?,qty_done=?,qty_scrapped=?,created_date_time=?,modified_date_time=?,customer=?,customer_order=?,rma_sfc_data_type_bo=?,rma_shop_order_data_type_bo=?,original_status_bo=?,transfer_site=?,transfer_type=?,lcc_bo=?,shop_order_type_bo=?,hold_id=?,end_unit_number=?,req_serial_change=?,collect_parent_serial=?,batch_number=?,erp_order=?,erp_production_version=?,erp_unit_of_measure=?,partition_date=?,inspection_lot=?,inspection_group_size=?,erp_putaway_storloc=?,warehouse_number=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,change_stamp,site,shop_order,status_bo,priority,planned_work_center_bo,planned_item_bo,planned_bom_bo,planned_router_bo,item_bo,bom_bo,router_bo,qty_to_build,qty_ordered,qty_released,released_date,planned_start_date,planned_comp_date,scheduled_start_date,scheduled_comp_date,actual_start_date,actual_comp_date,qty_done,qty_scrapped,created_date_time,modified_date_time,customer,customer_order,rma_sfc_data_type_bo,rma_shop_order_data_type_bo,original_status_bo,transfer_site,transfer_type,lcc_bo,shop_order_type_bo,hold_id,end_unit_number,req_serial_change,collect_parent_serial,batch_number,erp_order,erp_production_version,erp_unit_of_measure,partition_date,inspection_lot,inspection_group_size,erp_putaway_storloc,warehouse_number FROM shop_order ";

  private final Connection conn;

  public ShopOrderDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ShopOrder data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setBigDecimal(2, data.getChangeStamp());
      ps.setString(3, data.getSite());
      ps.setString(4, data.getShopOrder());
      ps.setString(5, data.getStatusBo());
      ps.setInt(6, data.getPriority());
      ps.setString(7, data.getPlannedWorkCenterBo());
      ps.setString(8, data.getPlannedItemBo());
      ps.setString(9, data.getPlannedBomBo());
      ps.setString(10, data.getPlannedRouterBo());
      ps.setString(11, data.getItemBo());
      ps.setString(12, data.getBomBo());
      ps.setString(13, data.getRouterBo());
      ps.setBigDecimal(14, data.getQtyToBuild());
      ps.setBigDecimal(15, data.getQtyOrdered());
      ps.setBigDecimal(16, data.getQtyReleased());
      ps.setTimestamp(17, new Timestamp(data.getReleasedDate().getTime()));
      ps.setTimestamp(18, new Timestamp(data.getPlannedStartDate().getTime()));
      ps.setTimestamp(19, new Timestamp(data.getPlannedCompDate().getTime()));
      ps.setTimestamp(20, new Timestamp(data.getScheduledStartDate().getTime()));
      ps.setTimestamp(21, new Timestamp(data.getScheduledCompDate().getTime()));
      ps.setTimestamp(22, new Timestamp(data.getActualStartDate().getTime()));
      ps.setTimestamp(23, new Timestamp(data.getActualCompDate().getTime()));
      ps.setBigDecimal(24, data.getQtyDone());
      ps.setBigDecimal(25, data.getQtyScrapped());
      ps.setTimestamp(26, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setTimestamp(27, new Timestamp(data.getModifiedDateTime().getTime()));
      ps.setString(28, data.getCustomer());
      ps.setString(29, data.getCustomerOrder());
      ps.setString(30, data.getRmaSfcDataTypeBo());
      ps.setString(31, data.getRmaShopOrderDataTypeBo());
      ps.setString(32, data.getOriginalStatusBo());
      ps.setString(33, data.getTransferSite());
      ps.setString(34, data.getTransferType());
      ps.setString(35, data.getLccBo());
      ps.setString(36, data.getShopOrderTypeBo());
      ps.setBigDecimal(37, data.getHoldId());
      ps.setString(38, data.getEndUnitNumber());
      ps.setString(39, data.getReqSerialChange());
      ps.setString(40, data.getCollectParentSerial());
      ps.setString(41, data.getBatchNumber());
      ps.setString(42, data.getErpOrder());
      ps.setString(43, data.getErpProductionVersion());
      ps.setString(44, data.getErpUnitOfMeasure());
      ps.setTimestamp(45, new Timestamp(data.getPartitionDate().getTime()));
      ps.setString(46, data.getInspectionLot());
      ps.setBigDecimal(47, data.getInspectionGroupSize());
      ps.setString(48, data.getErpPutawayStorloc());
      ps.setString(49, data.getWarehouseNumber());

      return ps.executeUpdate();
    }
  }

  public int update(ShopOrder data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getChangeStamp());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getShopOrder());
      ps.setString(4, data.getStatusBo());
      ps.setInt(5, data.getPriority());
      ps.setString(6, data.getPlannedWorkCenterBo());
      ps.setString(7, data.getPlannedItemBo());
      ps.setString(8, data.getPlannedBomBo());
      ps.setString(9, data.getPlannedRouterBo());
      ps.setString(10, data.getItemBo());
      ps.setString(11, data.getBomBo());
      ps.setString(12, data.getRouterBo());
      ps.setBigDecimal(13, data.getQtyToBuild());
      ps.setBigDecimal(14, data.getQtyOrdered());
      ps.setBigDecimal(15, data.getQtyReleased());
      ps.setTimestamp(16, new Timestamp(data.getReleasedDate().getTime()));
      ps.setTimestamp(17, new Timestamp(data.getPlannedStartDate().getTime()));
      ps.setTimestamp(18, new Timestamp(data.getPlannedCompDate().getTime()));
      ps.setTimestamp(19, new Timestamp(data.getScheduledStartDate().getTime()));
      ps.setTimestamp(20, new Timestamp(data.getScheduledCompDate().getTime()));
      ps.setTimestamp(21, new Timestamp(data.getActualStartDate().getTime()));
      ps.setTimestamp(22, new Timestamp(data.getActualCompDate().getTime()));
      ps.setBigDecimal(23, data.getQtyDone());
      ps.setBigDecimal(24, data.getQtyScrapped());
      ps.setTimestamp(25, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setTimestamp(26, new Timestamp(data.getModifiedDateTime().getTime()));
      ps.setString(27, data.getCustomer());
      ps.setString(28, data.getCustomerOrder());
      ps.setString(29, data.getRmaSfcDataTypeBo());
      ps.setString(30, data.getRmaShopOrderDataTypeBo());
      ps.setString(31, data.getOriginalStatusBo());
      ps.setString(32, data.getTransferSite());
      ps.setString(33, data.getTransferType());
      ps.setString(34, data.getLccBo());
      ps.setString(35, data.getShopOrderTypeBo());
      ps.setBigDecimal(36, data.getHoldId());
      ps.setString(37, data.getEndUnitNumber());
      ps.setString(38, data.getReqSerialChange());
      ps.setString(39, data.getCollectParentSerial());
      ps.setString(40, data.getBatchNumber());
      ps.setString(41, data.getErpOrder());
      ps.setString(42, data.getErpProductionVersion());
      ps.setString(43, data.getErpUnitOfMeasure());
      ps.setTimestamp(44, new Timestamp(data.getPartitionDate().getTime()));
      ps.setString(45, data.getInspectionLot());
      ps.setBigDecimal(46, data.getInspectionGroupSize());
      ps.setString(47, data.getErpPutawayStorloc());
      ps.setString(48, data.getWarehouseNumber());
      ps.setString(49, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public List<ShopOrder> selectAll(String site) throws SQLException {
    ArrayList<ShopOrder> result = new ArrayList<ShopOrder>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? ORDER BY modified_date_time desc ")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ShopOrder> selectByItemBo(String itemBo) throws SQLException {
    ArrayList<ShopOrder> result = new ArrayList<ShopOrder>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ITEM_BO=? and STATUS_BO <> 'StatusBO:1020,503' ")) {
      ps.setString(1, itemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ShopOrder selectByPK(String shopOrderBo) throws SQLException {
    ShopOrder result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ShopOrder selectByName(String site, String shopOrderName) throws SQLException {
    ShopOrder result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? AND shop_order=?")) {
      ps.setString(1, site);
      ps.setString(2, shopOrderName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ShopOrder selectByShopOrder(String handle) throws SQLException {
    ShopOrder result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ShopOrder> selectByCustomer(String customer) throws SQLException {
    List<ShopOrder> result = new ArrayList<ShopOrder>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer=? AND ACTUAL_COMP_DATE IS null ")) {
      ps.setString(1, customer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ShopOrder convert(ResultSet rs) throws SQLException {
    ShopOrder data = new ShopOrder();

    data.setHandle(rs.getString(1));
    data.setChangeStamp(rs.getBigDecimal(2));
    data.setSite(rs.getString(3));
    data.setShopOrder(rs.getString(4));
    data.setStatusBo(rs.getString(5));
    data.setPriority(rs.getInt(6));
    data.setPlannedWorkCenterBo(rs.getString(7));
    data.setPlannedItemBo(rs.getString(8));
    data.setPlannedBomBo(rs.getString(9));
    data.setPlannedRouterBo(rs.getString(10));
    data.setItemBo(rs.getString(11));
    data.setBomBo(rs.getString(12));
    data.setRouterBo(rs.getString(13));
    data.setQtyToBuild(rs.getBigDecimal(14));
    data.setQtyOrdered(rs.getBigDecimal(15));
    data.setQtyReleased(rs.getBigDecimal(16));
    data.setReleasedDate(rs.getTimestamp(17));
    data.setPlannedStartDate(rs.getTimestamp(18));
    data.setPlannedCompDate(rs.getTimestamp(19));
    data.setScheduledStartDate(rs.getTimestamp(20));
    data.setScheduledCompDate(rs.getTimestamp(21));
    data.setActualStartDate(rs.getTimestamp(22));
    data.setActualCompDate(rs.getTimestamp(23));
    data.setQtyDone(rs.getBigDecimal(24));
    data.setQtyScrapped(rs.getBigDecimal(25));
    data.setCreatedDateTime(rs.getTimestamp(26));
    data.setModifiedDateTime(rs.getTimestamp(27));
    data.setCustomer(rs.getString(28));
    data.setCustomerOrder(rs.getString(29));
    data.setRmaSfcDataTypeBo(rs.getString(30));
    data.setRmaShopOrderDataTypeBo(rs.getString(31));
    data.setOriginalStatusBo(rs.getString(32));
    data.setTransferSite(rs.getString(33));
    data.setTransferType(rs.getString(34));
    data.setLccBo(rs.getString(35));
    data.setShopOrderTypeBo(rs.getString(36));
    data.setHoldId(rs.getBigDecimal(37));
    data.setEndUnitNumber(rs.getString(38));
    data.setReqSerialChange(rs.getString(39));
    data.setCollectParentSerial(rs.getString(40));
    data.setBatchNumber(rs.getString(41));
    data.setErpOrder(rs.getString(42));
    data.setErpProductionVersion(rs.getString(43));
    data.setErpUnitOfMeasure(rs.getString(44));
    data.setPartitionDate(rs.getTimestamp(45));
    data.setInspectionLot(rs.getString(46));
    data.setInspectionGroupSize(rs.getBigDecimal(47));
    data.setErpPutawayStorloc(rs.getString(48));
    data.setWarehouseNumber(rs.getString(49));

    return data;
  }
}
