package ame.psb.db.dao;

import ame.psb.db.FullLotReportResult;
import ame.psb.db.SfcItem;
import ame.psb.db.ViewCustomerItemSfcItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SfcItemDao {

  private static final String SQL_INS = "INSERT INTO zd_sfc_item(sfc_bo,customer_item_bo,state_name,current_run,carrier_bo,slot_no,die_qty,batch_no,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_SEL =
      "SELECT id,customer_itemset_bo,item_name,item_name_orig,shop_order_bo,good_qty,gross_qty,mark_code,input_defect,input_grade,"
          +
          "sfc_bo,item_state_name,item_current_run,sfc_state_name,sfc_current_run,root_sfc_bo,curr_seq,carrier_bo,slot_no,"
          +
          "itemset_name,itemset_name_orig,customer_bo,customer_order,lot_type,dpt_no,shop_order," +
          "sfc_name,device_bo,device_name,package_bo,package_name,product_bo,product_name,customer,sfc_type,batch_no,updated_user,updated_time "
          +
          "FROM view_sfc_item ";

  private static final String SQL_SEL_WAFER = "SELECT id,gross_qty,resource_bo,recipe_name,run_user,action_code,date_time,customer_item_bo FROM view_full_lot_report_wafer";

  private static final String SQL_SEL_VIEW = "SELECT ID, CUSTOMER_ITEMSET_BO, ITEM_NAME, ITEM_NAME_ORIG, SHOP_ORDER_BO, GROSS_QTY, GOOD_QTY, MARK_CODE, INPUT_DEFECT, INPUT_GRADE, SFC_BO, CARRIER_BO, SLOT_NO, ITEM_STATE_NAME, ITEM_CURRENT_RUN, SFC_STATE_NAME, SFC_CURRENT_RUN, ROOT_SFC_BO, CURR_SEQ, ITEMSET_NAME, ITEMSET_NAME_ORIG, CUSTOMER_BO, CUSTOMER_ORDER, LOT_TYPE, DPT_NO, SHOP_ORDER, SFC_NAME, DEVICE_BO, DEVICE_NAME, PACKAGE_BO, PACKAGE_NAME, PRODUCT_BO, PRODUCT_NAME, CUSTOMER, SFC_TYPE, BATCH_NO, UPDATED_TIME, UPDATED_USER FROM VIEW_SFC_ITEM";

  private static final String SQL_SEL_UPDATE_ITEM_NAME = "update ZD_CUSTOMER_ITEM set item_name = item_name || '_BACK' where id = ? ";


  private Connection conn;

  public SfcItemDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SfcItem data) throws SQLException {
    if (this.selectByPK(data.getSfcBo(), data.getCustomerItemBo()) != null) {
      return 0;
    }
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getCustomerItemBo());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getCurrentRun());
      ps.setString(5, data.getCarrierBo());
      ps.setInt(6, data.getSlotNo());
      ps.setInt(7, data.getDieQty());
      ps.setString(8, data.getBatchNo());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int delete(String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_sfc_item WHERE sfc_bo=? ")) {
      ps.setString(1, sfcBo);
      return ps.executeUpdate();
    }
  }

  public int delete(String sfcBo, String customerItemBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_sfc_item WHERE sfc_bo=? AND customer_item_bo=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, customerItemBo);
      return ps.executeUpdate();
    }
  }

  //SQL_SEL_UPDATE_ITEM_NAME

  public int updateItemName(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_UPDATE_ITEM_NAME)) {
      ps.setString(1, id);
      return ps.executeUpdate();
    }
  }

  public int changeCarrier(String sfcBo, String carrierBo, String updatedUser, Date updatedTime)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_sfc_item SET carrier_bo=?,updated_user=?,updated_time=? WHERE sfc_bo=?")) {
      ps.setString(1, carrierBo);
      ps.setString(2, updatedUser);
      DateUtils.setDateTz(ps, 3, updatedTime);
      ps.setString(4, sfcBo);
      return ps.executeUpdate();
    }
  }

  @Deprecated
  public int changeCarrier(String sfcBo, String carrierBo, int toSlotNo, String updatedUser,
      Date updatedTime) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_sfc_item SET carrier_bo=?,slot_no=?,updated_user=?,updated_time=? WHERE sfc_bo=?")) {
      ps.setString(1, carrierBo);
      ps.setInt(2, toSlotNo);
      ps.setString(3, updatedUser);
      DateUtils.setDateTz(ps, 4, updatedTime);
      ps.setString(5, sfcBo);
      return ps.executeUpdate();
    }
  }


  /**
   * @Param: [sfcBo, originalCarrierBo, carrierBo, updatedUser, updatedTime]
   * @return: int
   * @To: 换载具时slot递增
   */
  public int changeCarrierByCarrier(String sfcBo, String originalCarrierBo, String carrierBo,
      String updatedUser, Date updatedTime) throws SQLException {
    List<ViewCustomerItemSfcItem> sfcItemsExists = selectByCarrier(carrierBo);
    List<ViewCustomerItemSfcItem> sfcItemsNew = selectByCarrier(originalCarrierBo);

    int toSlotNo = sfcItemsExists.size();
    for (ViewCustomerItemSfcItem sfcItem : sfcItemsNew) {
      toSlotNo++;
      try (PreparedStatement ps = this.conn.prepareStatement(
          "UPDATE zd_sfc_item SET carrier_bo=?,slot_no=?,updated_user=?,updated_time=? WHERE sfc_bo=? and CUSTOMER_ITEM_BO = ?")) {
        ps.setString(1, carrierBo);
        ps.setInt(2, toSlotNo);
        ps.setString(3, updatedUser);
        DateUtils.setDateTz(ps, 4, updatedTime);
        ps.setString(5, sfcBo);
        ps.setString(6, sfcItem.getId());
        ps.executeUpdate();
      }
    }
    return toSlotNo;
  }

  /**
   * @Param: [sfcBo, sfc, carrierBo, updatedUser, updatedTime]
   * @return: int
   * @To:
   */
  public int changeCarrierBySfc(String sfcBo, String carrierBo, String updatedUser,
      Date updatedTime) throws SQLException {
    List<ViewCustomerItemSfcItem> sfcItemsExists = selectByCarrier(carrierBo);
    List<ViewCustomerItemSfcItem> sfcItemsNew = selectBySfc(sfcBo);

    int toSlotNo = sfcItemsExists.size();
    for (ViewCustomerItemSfcItem sfcItem : sfcItemsNew) {
      toSlotNo++;
      try (PreparedStatement ps = this.conn.prepareStatement(
          "UPDATE zd_sfc_item SET carrier_bo=?,slot_no=?,updated_user=?,updated_time=? WHERE sfc_bo=? and CUSTOMER_ITEM_BO = ?")) {
        ps.setString(1, carrierBo);
        ps.setInt(2, toSlotNo);
        ps.setString(3, updatedUser);
        DateUtils.setDateTz(ps, 4, updatedTime);
        ps.setString(5, sfcBo);
        ps.setString(6, sfcItem.getId());
        ps.executeUpdate();
      }
    }
    return toSlotNo;
  }

  public int moveTo(String sfcBo, String customerItemBo, String toSfcBo, int toSlotNo)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_sfc_item SET sfc_bo=?,carrier_bo=NULL,slot_no=? WHERE customer_item_bo=? and sfc_bo=?")) {
      ps.setString(1, toSfcBo);
      ps.setInt(2, toSlotNo);
      ps.setString(3, customerItemBo);
      ps.setString(4, sfcBo);
      return ps.executeUpdate();
    }
  }

  public int moveTo(String sfcBo, String customerItemBo, String toSfcBo, int toSlotNo,
      String toCarrierBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_sfc_item SET sfc_bo=?,carrier_bo=?,slot_no=? WHERE customer_item_bo=? and sfc_bo=?")) {
      ps.setString(1, toSfcBo);
      ps.setString(2, toCarrierBo);
      ps.setInt(3, toSlotNo);
      ps.setString(4, customerItemBo);
      ps.setString(5, sfcBo);
      return ps.executeUpdate();
    }
  }

  public ViewCustomerItemSfcItem selectByPK(String sfcBo, String customerItemBo)
      throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=? AND sfc_bo=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectByName(String sfcBo, String itemName) throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_name=? AND sfc_bo=?")) {
      ps.setString(1, itemName);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectByAccurateWafer(String shopOrderBo, String itemName)
      throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_name=? AND shop_order_bo=? AND SFC_TYPE = 'S' ")) {
      ps.setString(1, itemName);
      ps.setString(2, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectByAccurateOrigWafer(String shopOrderBo, String itemNameOrig)
      throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE item_name_orig=? AND shop_order_bo=? AND SFC_TYPE = 'S' ")) {
      ps.setString(1, itemNameOrig);
      ps.setString(2, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  /*  *//*
   * cc
   * 用户判断良率维护的晶圆
   * *//*
  public ViewCustomerItemSfcItem selectSpecByParam(String itemName, String deviceBo)
      throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE item_name=? AND device_bo=? and sfc_state_name !='CLOSE' ")) {
      ps.setString(1, itemName);
      ps.setString(2, deviceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }*/

  public ViewCustomerItemSfcItem selectByLikeName(String sfcBo, String itemName)
      throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_name like ? AND sfc_bo=?")) {
      ps.setString(1, itemName + "%");
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectByNameOrig(String sfcBo, String itemNameOrig)
      throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_name_orig=? AND sfc_bo=?")) {
      ps.setString(1, itemNameOrig);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectByItemName(String itemName, String carrierId)
      throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_name=? AND carrier_bo like ?")) {
      ps.setString(1, itemName);
      ps.setString(2, "%" + carrierId + "%");

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectByItemNameSlotNo(String itemName) throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ITEM_NAME =? AND SLOT_NO != 0")) {
      ps.setString(1, itemName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectByItemNameSlotNoSfcState(String itemName)
      throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE ITEM_NAME =? AND SLOT_NO != 0 AND SFC_STATE_NAME !='CLOSE' ")) {
      ps.setString(1, itemName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public List<ViewCustomerItemSfcItem> selectByItemNameAndSlotNoAndSfcState(String itemName)
      throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE ITEM_NAME =? AND SLOT_NO != 0 AND SFC_STATE_NAME !='CLOSE' ")) {
      ps.setString(1, itemName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public ViewCustomerItemSfcItem selectForFun(String customerItemBo) throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id=? ORDER BY sfc_bo")) {
      ps.setString(1, customerItemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public List<ViewCustomerItemSfcItem> selectByItemName(String ItemName) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_name=? ORDER BY sfc_bo desc")) {
      ps.setString(1, ItemName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectByCustomer(String customer) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer=? ORDER BY UPDATED_TIME DESC LIMIT 1")) {
      ps.setString(1, customer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectByDevice(String deviceName) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE device_name=? ORDER BY UPDATED_TIME DESC LIMIT 1")) {
      ps.setString(1, deviceName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectByItemAndCustomer(String ItemName, String customer)
      throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_name=? AND customer=? ORDER BY sfc_bo desc")) {
      ps.setString(1, ItemName);
      ps.setString(2, customer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectStripList(String shopOrderName, String batchId,
      String stripId, String fcdaBatchId) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    String whereSql = "";
    if (!shopOrderName.isEmpty()) {
      whereSql += " Where shop_order = '" + shopOrderName + "'";
    }
    if (!batchId.isEmpty()) {
      if (whereSql.isEmpty()) {
        whereSql +=
            " Where SFC_NAME IN(SELECT DISTINCT v.sfc_name FROM view_sfc v WHERE v.BATCH_ID = '"
                + batchId + "') ";
      } else {
        whereSql +=
            " AND SFC_NAME IN(SELECT DISTINCT v.sfc_name FROM view_sfc v WHERE v.BATCH_ID = '"
                + batchId + "') ";
      }
    }
    if (!stripId.isEmpty()) {
      if (whereSql.isEmpty()) {
        whereSql += " Where item_name = '" + stripId + "'";
      } else {
        whereSql += " And item_name = '" + stripId + "'";
      }
    }
    if (!fcdaBatchId.isEmpty()) {
      if (whereSql.isEmpty()) {
        whereSql +=
            " Where SFC_BO IN (SELECT z.SFC_BO FROM ZD_SHOP_ORDER_BATCH z WHERE z.BATCH_ID = '"
                + fcdaBatchId + "' OR z.REVERSE_FIELD2 LIKE '" + fcdaBatchId + "=>%') ";
      } else {
        whereSql +=
            " AND SFC_BO IN (SELECT z.SFC_BO FROM ZD_SHOP_ORDER_BATCH z WHERE z.BATCH_ID = '"
                + fcdaBatchId + "' OR z.REVERSE_FIELD2 LIKE '" + fcdaBatchId + "=>%') ";
      }
    }
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + whereSql)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectShopStrip(String shopOrder) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE item_name not LIKE ITEMSET_NAME||'%' AND shop_order = ? order by item_name asc ")) {
      ps.setString(1, shopOrder);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectByItemNameOrig(String ItemNameOrig)
      throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_name_orig=? ORDER BY sfc_bo desc")) {
      ps.setString(1, ItemNameOrig);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectByOrigAndDevice(String ItemNameOrig, String deviceName)
      throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE item_name_orig=? AND device_name=? ORDER BY sfc_bo desc")) {
      ps.setString(1, ItemNameOrig);
      ps.setString(2, deviceName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectByWaferId(String waferId) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_name like ? ORDER BY sfc_bo desc")) {
      ps.setString(1, waferId + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectByCarrier(String carrierBo) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE carrier_bo=? ORDER BY shop_order_bo,sfc_bo,item_state_name,id")) {
      ps.setString(1, carrierBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectByShopOrder(String shopOrder) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order=? ")) {
      ps.setString(1, shopOrder);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectByShopOrder(String shopOrder, String stateName)
      throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order=? ")) {
      ps.setString(1, shopOrder);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectByShopOrderAndSfcType(String shopOrder, String sfcType)
      throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT distinct customer,item_name,gross_qty,itemset_name FROM view_sfc_item WHERE shop_order=? and sfc_type = ?  AND locate(ITEM_NAME ,ITEMSET_NAME)>0")) {
      ps.setString(1, shopOrder);
      ps.setString(2, sfcType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert2(rs));
      }
    }
    return result;
  }


  public List<ViewCustomerItemSfcItem> selectByShopOrderAndLot(String shopOrder, String lot)
      throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    lot = "%" + lot + "%";
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE shop_order=? and item_name like ? and sfc_type = 'S' ")) {
      ps.setString(1, shopOrder);
      ps.setString(2, lot);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public ViewCustomerItemSfcItem selectByShopOrderAndItem(String shopOrder, String itemName)
      throws SQLException {
    ViewCustomerItemSfcItem result = new ViewCustomerItemSfcItem();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE shop_order_bo=? and item_name = ?  AND CARRIER_BO IS null ")) {
      ps.setString(1, shopOrder);
      ps.setString(2, itemName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public ViewCustomerItemSfcItem selectByShopOrderAndItemName(String shopOrder, String itemName)
      throws SQLException {
    ViewCustomerItemSfcItem result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE shop_order_bo=? and item_name = ?  ")) {
      ps.setString(1, shopOrder);
      ps.setString(2, itemName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectByFCShopOrderAndLot(String shopOrder, String lot)
      throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    lot = "%" + lot + "%";
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE shop_order=? and item_name not like ? and sfc_type = 'S' ")) {
      ps.setString(1, shopOrder);
      ps.setString(2, lot);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public ViewCustomerItemSfcItem selectBySlotNo(String sfcBo) throws SQLException {
    ViewCustomerItemSfcItem result = new ViewCustomerItemSfcItem();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? ORDER BY SLOT_NO DESC")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? ORDER BY item_state_name,id asc")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectBySfcAndState(String sfcBo)
      throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE sfc_bo=? and sfc_state_name !='CLOSE' ORDER BY item_state_name,id asc")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public ViewCustomerItemSfcItem selectBySfcAndItem(String sfcBo, String itemName)
      throws SQLException {
    ViewCustomerItemSfcItem result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE sfc_bo=?  and  item_name = ? ORDER BY item_state_name,id desc")) {
      ps.setString(1, sfcBo);
      ps.setString(2, itemName);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectBySfc1(String sfcBo) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? ORDER BY item_state_name,id ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectAscBySfc(String sfcBo) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? ORDER BY item_state_name,id asc")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectBySfcAndCarrier(String sfcBo,String carrierBo) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND carrier_Bo =? ORDER BY id asc ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, carrierBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }


  public List<ViewCustomerItemSfcItem> selectBySfcOrderByWaferId(String sfcBo) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? ORDER BY id asc")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }


  public List<ViewCustomerItemSfcItem> selectByWafer(String id) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id=? ORDER BY id asc,sfc_bo asc")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }


  public List<ViewCustomerItemSfcItem> selectUnPackBySfc(String sfcBo) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE sfc_bo=?   and carrier_bo is null ORDER BY item_state_name,id desc")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectByItemSetName(String ItemSetName) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE itemset_name=? ORDER BY item_state_name,id desc")) {
      ps.setString(1, ItemSetName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectByLotAndDevice(String ItemSetName, String deviceName)
      throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE itemset_name=? AND device_name=? ORDER BY item_state_name,id desc")) {
      ps.setString(1, ItemSetName);
      ps.setString(2, deviceName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public int resetBySfc(String sfcBo, String updatedUser, Date updatedTime) throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_sfc_item SET state_name='WAIT',current_run=null,updated_user=?,updated_time=? WHERE sfc_bo=?");
    ps.setString(1, updatedUser);
    DateUtils.setDateTz(ps, 2, updatedTime);
    ps.setString(3, sfcBo);
    return ps.executeUpdate();
  }

  public int changeStateBySfc(String sfcBo, String stateName, String updatedUser, Date updatedTime)
      throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_sfc_item SET state_name=?,updated_user=?,updated_time=? WHERE sfc_bo=?");
    ps.setString(1, stateName);
    ps.setString(2, updatedUser);
    DateUtils.setDateTz(ps, 3, updatedTime);
    ps.setString(4, sfcBo);
    return ps.executeUpdate();
  }

  public int changeState(String customerItemBo, String sfcBo, String stateName, String updatedUser,
      Date updatedTime) throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_sfc_item SET state_name=?,updated_user=?,updated_time=? WHERE sfc_bo=? AND customer_item_bo=?");
    ps.setString(1, stateName);
    ps.setString(2, updatedUser);
    DateUtils.setDateTz(ps, 3, updatedTime);
    ps.setString(4, sfcBo);
    ps.setString(5, customerItemBo);
    return ps.executeUpdate();
  }

  public int changeState(String customerItemBo, String sfcBo, String stateName, String run,
      String updatedUser, Date updatedTime) throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_sfc_item SET state_name=?,current_run=?,updated_user=?,updated_time=? WHERE sfc_bo=? AND customer_item_bo=?");
    ps.setString(1, stateName);
    ps.setString(2, run);
    ps.setString(3, updatedUser);
    DateUtils.setDateTz(ps, 4, updatedTime);
    ps.setString(5, sfcBo);
    ps.setString(6, customerItemBo);
    return ps.executeUpdate();
  }

  public int updateCarrier(String sfcBo, String carrierBo) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_sfc_item SET carrier_bo=? WHERE sfc_bo=?");
    ps.setString(1, carrierBo);
    ps.setString(2, sfcBo);
    return ps.executeUpdate();
  }

  public List<FullLotReportResult> selectBySfcBoWafer(String id) throws SQLException {
    ArrayList<FullLotReportResult> result = new ArrayList<FullLotReportResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_WAFER + " WHERE ID = ? ")) {
      ps.setString(1, id);
      //  ps.setString(2, id);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convertReportWafer(rs));
      }
    }
    return result;
  }

  public List<ViewCustomerItemSfcItem> selectByCarrierNameAndCustomerItemBo(String carrierName,
      String customerItemBo) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> result = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE CARRIER_BO =? and ID = ?")) {
      ps.setString(1, carrierName);
      ps.setString(2, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  private ViewCustomerItemSfcItem convert(ResultSet rs) throws SQLException {
    ViewCustomerItemSfcItem data = new ViewCustomerItemSfcItem();
    data.setId(rs.getString(1));
    data.setCustomerItemLotBo(rs.getString(2));
    data.setItemName(rs.getString(3));
    data.setItemNameOrig(rs.getString(4));
    data.setShopOrderBo(rs.getString(5));
    data.setGoodQty(rs.getInt(6));
    data.setGrossQty(rs.getInt(7));
    data.setMarkCode(rs.getString(8));
    data.setInputDefect(rs.getString(9));
    data.setInputGrade(rs.getString(10));

    int index = 11;

    data.setSfcBo(rs.getString(index++));
    data.setItemStateName(rs.getString(index++));
    data.setItemCurrentRun(rs.getString(index++));
    data.setSfcStateName(rs.getString(index++));
    data.setSfcCurrentRun(rs.getString(index++));
    data.setRootSfcBo(rs.getString(index++));
    if (rs.getObject(index) != null) {
      data.setCurrSeq(rs.getLong(index));
    }
    index++;
    data.setCarrierBo(rs.getString(index++));
    data.setSlotNo(rs.getInt(index++));
    data.setItemLotName(rs.getString(index++));
    data.setItemLotNameOrig(rs.getString(index++));
    data.setCustomerBo(rs.getString(index++));
    data.setCustomerOrder(rs.getString(index++));
    data.setLotType(rs.getString(index++));
    data.setDptNo(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));

    data.setSfcName(rs.getString(index++));
    data.setDeviceBo(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setPackageBo(rs.getString(index++));
    data.setPackageName(rs.getString(index++));
    data.setProductBo(rs.getString(index++));
    data.setProductName(rs.getString(index++));
    data.setCustomerName(rs.getString(index++));
    data.setSfcType(rs.getString(index++));
    data.setBatchNo(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }

  private ViewCustomerItemSfcItem convert2(ResultSet rs) throws SQLException {
    ViewCustomerItemSfcItem data = new ViewCustomerItemSfcItem();
    data.setCustomerName(rs.getString(1));
    data.setItemName(rs.getString(2));
    data.setGrossQty(rs.getInt(3));
    data.setItemLotName(rs.getString(4));

    return data;
  }


  private FullLotReportResult convertReportWafer(ResultSet rs) throws SQLException {
    FullLotReportResult data = new FullLotReportResult();

    data.runSfcs.setId(rs.getString(1));
    data.viewSfcItem.setGrossQty(rs.getInt(2));
    data.runSfcItem.setResourceBo(rs.getString(3));
    data.runSfcs.setRecipeName(rs.getString(4));
    data.runSfcs.setRunUser(rs.getString(5));
    data.activityLogs.setActionCode(rs.getString(6));
    data.runSfcItem.setDateTime(DateUtils.getDateTz(rs, 7));
    data.runSfcItem.setCustomerItemBo(rs.getString(8));

    return data;
  }
}
