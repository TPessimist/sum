package ame.psb.db.dao;

import ame.psb.db.SODUpdateDetail;
import ame.psb.db.ShopOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ShopOrderDao {

  private static final String SQL_SEL = "SELECT handle,change_stamp,site,shop_order,status_bo,priority,planned_work_center_bo,planned_item_bo,planned_bom_bo,planned_router_bo,item_bo,bom_bo,router_bo,qty_to_build,qty_ordered,qty_released,released_date,planned_start_date,planned_comp_date,scheduled_start_date,scheduled_comp_date,actual_start_date,actual_comp_date,qty_done,qty_scrapped,created_date_time,modified_date_time,customer,customer_order,rma_sfc_data_type_bo,rma_shop_order_data_type_bo,original_status_bo,transfer_site,transfer_type,lcc_bo,shop_order_type_bo,hold_id,end_unit_number,req_serial_change,collect_parent_serial,batch_number,erp_order,erp_production_version,erp_unit_of_measure,partition_date,inspection_lot,inspection_group_size,erp_putaway_storloc,warehouse_number FROM shop_order ";
  private final Connection conn;
  private String SQL_UPT_PLAN = "UPDATE SHOP_ORDER SET PLANNED_COMP_DATE = ? WHERE HANDLE = ?";
  private String SQL_UPT_SCHE = "UPDATE SHOP_ORDER SET SCHEDULED_COMP_DATE = ? WHERE HANDLE = ?";
  private String SQL_UPT_SCHE_START = "UPDATE SHOP_ORDER SET SCHEDULED_START_DATE = ? WHERE HANDLE = ?";

  public ShopOrderDao(Connection conn) {
    this.conn = conn;
  }

  public List<ShopOrder> selectAll() throws SQLException {
    ArrayList<ShopOrder> result = new ArrayList<ShopOrder>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  @Deprecated
  public ShopOrder select(String id) throws SQLException {
    ShopOrder result = new ShopOrder();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where handle = ? ")) {
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ShopOrder selectByPK(String id) throws SQLException {
    ShopOrder result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where handle = ? ")) {
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ShopOrder> selectByPKItemBo(String itemBo) throws SQLException {
    List<ShopOrder> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where ITEM_BO = ? ")) {
      ps.setString(1, itemBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public int updatePlan(ShopOrder shoporder) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPT_PLAN)) {
      ps.setTimestamp(1, new Timestamp(shoporder.getPlannedCompDate().getTime() - 28800000));
      ps.setString(2, shoporder.getHandle());

      return ps.executeUpdate();
    }
  }

  public int updateSche(ShopOrder shoporder) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPT_SCHE)) {
      ps.setTimestamp(1, new Timestamp(shoporder.getScheduledCompDate().getTime() - 28800000));
      ps.setString(2, shoporder.getHandle());

      return ps.executeUpdate();
    }
  }

  public int updateScheStart(ShopOrder shoporder) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPT_SCHE_START)) {
      ps.setTimestamp(1, new Timestamp(shoporder.getScheduledStartDate().getTime() - 28800000));
      ps.setString(2, shoporder.getHandle());

      return ps.executeUpdate();
    }
  }

  public int updateState(String shopOrderBo, String statusBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE SHOP_ORDER SET status_bo = ? WHERE HANDLE = ? ")) {
      ps.setString(1, statusBo);
      ps.setString(2, shopOrderBo);

      return ps.executeUpdate();
    }
  }

  //
  //3.	UPDATE  SHOP_ORDER  SET SCHEDULED_COMP_DATE = 'EXCEL里面的SOD'  WHERE HANDLE IN (SELECT SHOP_ORDER_BO FROM VIEW_SFC WHERE SFC_NAME IN (EXCEL里面的SFC))
  public int updateSod(List<SODUpdateDetail> details) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "UPDATE  SHOP_ORDER  SET SCHEDULED_COMP_DATE = ? WHERE HANDLE = (SELECT SHOP_ORDER_BO FROM VIEW_SFC WHERE SFC_NAME = ?)")) {
      for (SODUpdateDetail detail : details) {
        // ps.setString(1, detail.getSod());
        DateUtils.setDateTz(ps, 1, detail.getSod());
        ps.setString(2, detail.getSfc());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  private ShopOrder convert(ResultSet rs) throws SQLException {
    ShopOrder data = new ShopOrder();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setChangeStamp(rs.getBigDecimal(index++));
    data.setSite(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setPriority(rs.getBigDecimal(index++));
    data.setPlannedWorkCenterBo(rs.getString(index++));
    data.setPlannedItemBo(rs.getString(index++));
    data.setPlannedBomBo(rs.getString(index++));
    data.setPlannedRouterBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setBomBo(rs.getString(index++));
    data.setRouterBo(rs.getString(index++));
    data.setQtyToBuild(rs.getBigDecimal(index++));
    data.setQtyOrdered(rs.getBigDecimal(index++));
    data.setQtyReleased(rs.getBigDecimal(index++));
    data.setReleasedDate(DateUtils.getDateTz(rs, index++));
    data.setPlannedStartDate(DateUtils.getDateTz(rs, index++));
    data.setPlannedCompDate(DateUtils.getDateTz(rs, index++));
    data.setScheduledStartDate(DateUtils.getDateTz(rs, index++));
    data.setScheduledCompDate(DateUtils.getDateTz(rs, index++));
    data.setActualStartDate(DateUtils.getDateTz(rs, index++));
    data.setActualCompDate(DateUtils.getDateTz(rs, index++));
    data.setQtyDone(rs.getBigDecimal(index++));
    data.setQtyScrapped(rs.getBigDecimal(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setCustomer(rs.getString(index++));
    data.setCustomerOrder(rs.getString(index++));
    data.setRmaSfcDataTypeBo(rs.getString(index++));
    data.setRmaShopOrderDataTypeBo(rs.getString(index++));
    data.setOriginalStatusBo(rs.getString(index++));
    data.setTransferSite(rs.getString(index++));
    data.setTransferType(rs.getString(index++));
    data.setLccBo(rs.getString(index++));
    data.setShopOrderTypeBo(rs.getString(index++));
    data.setHoldId(rs.getBigDecimal(index++));
    data.setEndUnitNumber(rs.getString(index++));
    data.setReqSerialChange(rs.getString(index++));
    data.setCollectParentSerial(rs.getString(index++));
    data.setBatchNumber(rs.getString(index++));
    data.setErpOrder(rs.getString(index++));
    data.setErpProductionVersion(rs.getString(index++));
    data.setErpUnitOfMeasure(rs.getString(index++));
    data.setPartitionDate(DateUtils.getDateTz(rs, index++));
    data.setInspectionLot(rs.getString(index++));
    data.setInspectionGroupSize(rs.getBigDecimal(index++));
    data.setErpPutawayStorloc(rs.getString(index++));
    data.setWarehouseNumber(rs.getString(index++));

    return data;
  }
}
