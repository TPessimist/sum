package ame.psb.db.dao;

import ame.psb.db.CustomerItem;
import ame.psb.db.ViewCustomerItemSfcItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CustomerItemDao {

  private static final String SQL_INS = "INSERT INTO zd_customer_item(id,customer_itemset_bo,item_name,item_name_orig,shop_order_bo,good_qty,gross_qty,mark_code,input_defect,input_grade,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_customer_item SET customer_itemset_bo=?,item_name=?,item_name_orig=?,shop_order_bo=?,good_qty=?,gross_qty=?,mark_code=?,input_defect=?,input_grade=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_UPD2 = "UPDATE zd_customer_item SET item_name=?,good_qty=?,gross_qty=? WHERE id=?";

  private static final String SQL_UPD_BACK = "UPDATE ZD_CUSTOMER_ITEM SET ID = ID || '_BACK' , ITEM_NAME = ITEM_NAME || '_BACK' WHERE id = ?";

  private static final String SQL_SEL =
      "SELECT id,customer_itemset_bo,item_name,item_name_orig,shop_order_bo,good_qty,gross_qty,mark_code,input_defect,input_grade,"
          +
          "sfc_bo,item_state_name,item_current_run,sfc_state_name,sfc_current_run,root_sfc_bo,curr_seq,carrier_bo,slot_no,"
          +
          "itemset_name,itemset_name_orig,customer_bo,customer_order,lot_type,dpt_no,shop_order," +
          "sfc_name,device_bo,device_name,package_bo,package_name,product_bo,product_name,customer,sfc_type,batch_no,updated_user,updated_time "
          +
          "FROM view_customer_item ";

  private static final String SQL_SEL2 = "SELECT id,customer_itemset_bo,item_name,item_name_orig,shop_order_bo,good_qty,gross_qty,mark_code,input_defect,input_grade FROM zd_customer_item ";


  private Connection conn;

  public CustomerItemDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CustomerItem item) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, item.getId());
      ps.setString(2, item.getCustomerItemLotBo());
      ps.setString(3, item.getItemName());
      ps.setString(4, item.getItemNameOrig());
      ps.setString(5, item.getShopOrderBo());
      ps.setInt(6, item.getGoodQty());
      ps.setInt(7, item.getGrossQty());
      ps.setString(8, item.getMarkCode());
      ps.setString(9, item.getInputDefect());
      ps.setString(10, item.getInputGrade());
      ps.setString(11, item.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, item.getUpdatedTime());
      return ps.executeUpdate();
    }
  }

  public int insert(List<CustomerItem> items) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CustomerItem item : items) {
        ps.setString(1, item.getId());
        ps.setString(2, item.getCustomerItemLotBo());
        ps.setString(3, item.getItemName());
        ps.setString(4, item.getItemNameOrig());
        ps.setString(5, item.getShopOrderBo());
        ps.setInt(6, item.getGoodQty());
        ps.setInt(7, item.getGrossQty());
        ps.setString(8, item.getMarkCode());
        ps.setString(9, item.getInputDefect());
        ps.setString(10, item.getInputGrade());
        ps.setString(11, item.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, item.getUpdatedTime());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(String id, String inputGrade) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_customer_item SET input_grade=? WHERE id=?");
    ps.setString(1, inputGrade);
    ps.setString(2, id);
    return ps.executeUpdate();
  }

  public int updateItemNameOrigById(String id, String itemNameOrig) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_customer_item SET item_name_orig=? WHERE id=?");
    ps.setString(1, itemNameOrig);
    ps.setString(2, id);
    return ps.executeUpdate();
  }

  public void backFcStrip(String id) throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_BACK);
    ps.setString(1, id);
    ps.executeUpdate();
  }

  public int update(CustomerItem item) throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement(SQL_UPD);
    ps.setString(1, item.getCustomerItemLotBo());
    ps.setString(2, item.getItemName());
    ps.setString(3, item.getItemNameOrig());
    ps.setString(4, item.getShopOrderBo());
    ps.setInt(5, item.getGoodQty());
    ps.setInt(6, item.getGrossQty());
    ps.setString(7, item.getMarkCode());
    ps.setString(8, item.getInputDefect());
    ps.setString(9, item.getInputGrade());
    ps.setString(10, item.getUpdatedUser());
    DateUtils.setDateTz(ps, 11, item.getUpdatedTime());
    ps.setString(12, item.getId());
    return ps.executeUpdate();
  }

  public int updateForMaintain(CustomerItem item) throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement(SQL_UPD2);
    ps.setString(1, item.getItemName());
    ps.setInt(2, item.getGoodQty());
    ps.setInt(3, item.getGrossQty());
    ps.setString(4, item.getId());
    return ps.executeUpdate();
  }

  public ViewCustomerItemSfcItem selectByPKShopOrder(String id, String shopOrder)
      throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE item_name=? and shop_order =?")) {
      ps.setString(1, id);
      ps.setString(2, shopOrder);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectByShopAndWaferNum(String waferNum, String shopOrder)
      throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + " WHERE item_name like ? and shop_order =? and ITEM_NAME_ORIG IS NOT NULL and ITEM_NAME_ORIG != ''")) {
      ps.setString(1, "%" + waferNum);
      ps.setString(2, shopOrder);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectByDeviceBoAndWafer(String deviceBo, String waferId)
      throws SQLException {
    ViewCustomerItemSfcItem result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE device_bo=? and item_name = ?  "
            + "and ITEM_NAME_ORIG IS NOT NULL and  ITEM_NAME_ORIG != '' ")) {
      ps.setString(1, deviceBo);
      ps.setString(2, waferId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public ViewCustomerItemSfcItem selectByPK(String id) throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectByNotClosePK(String id) throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE id=? and SFC_STATE_NAME != 'CLOSE'")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public List<ViewCustomerItemSfcItem> selectByPKSize(String id) throws SQLException {
    List<ViewCustomerItemSfcItem> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
      }
      {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public ViewCustomerItemSfcItem selectByItemNameShopOrder(String id, String shopOrder)
      throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE ITEM_NAME=?  and  shop_order_bo = ? ORDER BY UPDATED_TIME DESC")) {
      ps.setString(1, id);
      ps.setString(2, shopOrder);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectByItemNameSfc(String id, String sfc) throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE ITEM_NAME=?  and  SFC_NAME = ? ORDER BY UPDATED_TIME DESC")) {
      ps.setString(1, id);
      ps.setString(2, sfc);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }


  public ViewCustomerItemSfcItem selectByOrigItemName(String id) throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE  ITEM_NAME_ORIG=? ORDER BY UPDATED_TIME DESC")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectByItemName(String id) throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE ITEM_NAME=? ORDER BY UPDATED_TIME DESC")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectByItemNameAndStateName(String id) throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE ITEM_NAME=? AND sfc_state_name != 'CLOSE' ORDER BY SFC_BO DESC")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectByItemNameAndStateNameForTag(String id) throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE ITEM_NAME=? AND sfc_state_name != 'CLOSE' and gross_qty > 1 ORDER BY SFC_BO DESC")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectByItemNameAndStateNameAndShopOrder(String id,
      String shopOrder) throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE ITEM_NAME=? AND SHOP_ORDER_BO =? AND sfc_state_name != 'CLOSE'  ORDER BY SFC_BO DESC")) {
      ps.setString(1, id);
      ps.setString(2, shopOrder);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public List<ViewCustomerItemSfcItem> selectByItemNameList(String id) throws SQLException {
    List<ViewCustomerItemSfcItem> item = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE ITEM_NAME=? ORDER BY UPDATED_TIME DESC")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        item.add(this.convert(rs));
      }
    }
    return item;
  }


  /**
   * @Param: [id]
   * @return: ame.psb.db.ViewCustomerItemSfcItem
   * @To: 过滤掉首检批号
   */
  public ViewCustomerItemSfcItem selectFCRootSfcByItemName(String id) throws SQLException {
    ViewCustomerItemSfcItem item = null;

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE ITEM_NAME=? and LENGTH(SFC_BO) = '21'and SFC_STATE_NAME = 'WAIT' ORDER BY UPDATED_TIME DESC")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);

      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectFCRootSfcByOrigItemName(String id) throws SQLException {
    ViewCustomerItemSfcItem item = null;

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE ITEM_NAME_ORIG=? and LENGTH(SFC_BO) = '21' and SFC_STATE_NAME = 'WAIT' ORDER BY UPDATED_TIME DESC")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);

      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectFCRootSfcByOrigItemName2(String id) throws SQLException {
    ViewCustomerItemSfcItem item = null;

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE ITEM_NAME_ORIG=? and LENGTH(SFC_BO) = '21' ORDER BY UPDATED_TIME DESC")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);

      }
    }
    return item;
  }

  public ViewCustomerItemSfcItem selectByOrigItemNameAndSfc(String wafer, String sfcBo)
      throws SQLException {
    ViewCustomerItemSfcItem item = null;

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE ITEM_NAME_ORIG=? and SFC_BO=? ")) {
      ps.setString(1, wafer);
      ps.setString(2, sfcBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);

      }
    }
    return item;
  }


  public ViewCustomerItemSfcItem selectByPKWAIT(String id) throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE id=? and sfc_state_name != 'CLOSE'")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }


  // warning: 使用waferID来查询可能会查到已关闭工单的记录
  @Deprecated
  public ViewCustomerItemSfcItem selectByName(String customerItemName, String sfcType)
      throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE item_name=? AND (sfc_type=? OR sfc_type is null)")) {
      ps.setString(1, customerItemName);
      ps.setString(2, sfcType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public List<ViewCustomerItemSfcItem> selectListByName(String customerItemName, String sfcType)
      throws SQLException {
    List<ViewCustomerItemSfcItem> items = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE item_name=? AND (sfc_type=? OR sfc_type is null)")) {
      ps.setString(1, customerItemName);
      ps.setString(2, sfcType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert(rs));
      }
    }
    return items;
  }


  public List<ViewCustomerItemSfcItem> selectListByNameAndDevice(String customerItemName,
      String deviceName) throws SQLException {
    List<ViewCustomerItemSfcItem> items = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE item_name=? AND DEVICE_NAME =? ")) {
      ps.setString(1, customerItemName);
      ps.setString(2, deviceName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert(rs));
      }
    }
    return items;
  }


  public ViewCustomerItemSfcItem selectBySingleName(String customerItemName) throws SQLException {
    ViewCustomerItemSfcItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE item_name=? and SFC_STATE_NAME != 'CLOSE'  ")) {
      ps.setString(1, customerItemName);
      //ps.setString(2, sfcType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public List<ViewCustomerItemSfcItem> selectAll() throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> items = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " ORDER BY id")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert(rs));
      }
    }
    return items;
  }

  public List<ViewCustomerItemSfcItem> selectBySfcBo(String sfcBo) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> items = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE sfc_bo = ? ORDER BY id")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert(rs));
      }
    }
    return items;
  }

  public List<ViewCustomerItemSfcItem> selectBySfcBoDesc(String sfcBo) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> items = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE sfc_bo = ? ORDER BY id DESC ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert(rs));
      }
    }
    return items;
  }

  public List<ViewCustomerItemSfcItem> selectByItemLot(String customerItemLotBo, String sfcType)
      throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> items = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE customer_itemset_bo=? AND (sfc_type=? OR sfc_type is null) ORDER BY shop_order_bo,id")) {
      ps.setString(1, customerItemLotBo);
      ps.setString(2, sfcType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert(rs));
      }
    }
    return items;
  }

  public List<CustomerItem> selectByItemLot2(String customerItemLotBo) throws SQLException {
    ArrayList<CustomerItem> items = new ArrayList<CustomerItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL2 + " WHERE customer_itemset_bo like ?   ORDER BY item_name")) {
      ps.setString(1, customerItemLotBo + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert2(rs));
      }
    }
    return items;
  }

  public List<CustomerItem> selectByItemNameOrig2(String itemNameOrig)
      throws SQLException { //xf20201104add 根据客户waferid查厂内waferid
    ArrayList<CustomerItem> items = new ArrayList<CustomerItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL2 + " WHERE item_name_orig = ?  ")) {
      ps.setString(1, itemNameOrig);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert2(rs));
      }
    }
    return items;
  }

  public CustomerItem selectByItemNameOrig3(String itemNameOrig, String shopOrderBo)
      throws SQLException { //根据原始晶圆编号和工单查询
    CustomerItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL2 + " WHERE item_name_orig = ? AND shop_order_bo = ? ")) {
      ps.setString(1, itemNameOrig);
      ps.setString(2, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert2(rs);
      }
    }
    return item;
  }


  public List<CustomerItem> selectByItemName2(String itemName)
      throws SQLException { //xf20201107add 根据厂内waferid查记录
    ArrayList<CustomerItem> items = new ArrayList<CustomerItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL2 + " WHERE item_name = ?  ")) {
      ps.setString(1, itemName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert2(rs));
      }
    }
    return items;
  }

  public List<CustomerItem> selectByShopOrder(String ShopOrder)
      throws SQLException { //xf20201107add 根据厂内waferid查记录
    ArrayList<CustomerItem> items = new ArrayList<CustomerItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL2 + " WHERE SHOP_ORDER_BO = ?  and mark_code is not null ")) {
      ps.setString(1, ShopOrder);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert2(rs));
      }
    }
    return items;
  }

  public List<CustomerItem> selectByShopOrderBo(String ShopOrder)
      throws SQLException {
    ArrayList<CustomerItem> items = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL2 + " WHERE SHOP_ORDER_BO = ? ORDER  BY item_name")) {
      ps.setString(1, ShopOrder);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert2(rs));
      }
    }
    return items;
  }

  public List<CustomerItem> selectByLot(String itemLotBo) throws SQLException {
    ArrayList<CustomerItem> items = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL2 + " WHERE customer_itemset_bo = ?  ")) {
      ps.setString(1, itemLotBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert2(rs));
      }
    }
    return items;
  }

  public List<CustomerItem> selectByLotAndShopOrder(String itemLotBo, String shopOrderBo)
      throws SQLException {
    ArrayList<CustomerItem> items = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL2 + " WHERE customer_itemset_bo = ?  and shop_order_bo = ? ")) {
      ps.setString(1, itemLotBo);
      ps.setString(2, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert2(rs));
      }
    }
    return items;
  }

  public CustomerItem selectByShopOrderAndItem(String shopOrder, String itemName)
      throws SQLException {
    CustomerItem item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL2 + " WHERE shop_order_bo=? and item_name = ? ")) {
      ps.setString(1, shopOrder);
      ps.setString(2, itemName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert2(rs);
      }
    }
    return item;
  }


  public List<ViewCustomerItemSfcItem> selectByItemset(String customerItemLotBo, String sfcType,
      boolean released) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> items = new ArrayList<ViewCustomerItemSfcItem>();
    String sql = SQL_SEL;
    if (released) {
      sql += " WHERE customer_itemset_bo=? AND (sfc_type=? OR sfc_type is null) AND sfc_bo is not NULL ORDER BY customer_itemset_bo,id";
    } else {
      sql += " WHERE customer_itemset_bo=? AND (sfc_type=? OR sfc_type is null) AND sfc_bo is NULL ORDER BY customer_itemset_bo,id";
    }
    try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
      ps.setString(1, customerItemLotBo);
      ps.setString(2, sfcType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert(rs));
      }
    }
    return items;
  }

  public List<ViewCustomerItemSfcItem> selectByShopOrder(String shopOrderBo, String sfcType)
      throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> items = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE shop_order_bo=? AND (sfc_type=? OR sfc_type is null) ORDER BY customer_itemset_bo,id")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, sfcType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert(rs));
      }
    }
    return items;
  }

  public List<ViewCustomerItemSfcItem> selectByShopOrder2(String shopOrderBo) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> items = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE shop_order_bo=?  ORDER BY customer_itemset_bo,id")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert(rs));
      }
    }
    return items;
  }

  public List<ViewCustomerItemSfcItem> selectByCarrier(String carrierBo) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> items = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE carrier_bo=? ")) {
      ps.setString(1, carrierBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert(rs));
      }
    }
    return items;
  }

  public List<ViewCustomerItemSfcItem> selectByShopOrder(String shopOrderBo, String sfcType,
      boolean released) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> items = new ArrayList<ViewCustomerItemSfcItem>();
    String sql = SQL_SEL;
    if (released) {
      sql += " WHERE shop_order_bo=? AND (sfc_type=? OR sfc_type is null) AND sfc_bo is not NULL ORDER BY customer_itemset_bo,id";
    } else {
      sql += " WHERE shop_order_bo=? AND (sfc_type=? OR sfc_type is null) AND sfc_bo is NULL ORDER BY customer_itemset_bo,id";
    }
    try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, sfcType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert(rs));
      }
    }
    return items;
  }

  public List<ViewCustomerItemSfcItem> select(String customerItemLotBo, String shopOrderBo,
      String sfcType) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> items = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE customer_itemset_bo=? AND shop_order_bo=? AND (sfc_type=? OR sfc_type is null) ORDER BY id")) {
      ps.setString(1, customerItemLotBo);
      ps.setString(2, shopOrderBo);
      ps.setString(3, sfcType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert(rs));
      }
    }
    return items;
  }

  public List<ViewCustomerItemSfcItem> select(String customerItemLotBo, String shopOrderBo,
      String sfcType, boolean released) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> items = new ArrayList<ViewCustomerItemSfcItem>();
    String sql = SQL_SEL;
    if (released) {
      sql += " WHERE customer_itemset_bo=? AND shop_order_bo=? AND (sfc_type=? OR sfc_type is null) AND sfc_bo is not NULL ORDER BY customer_itemset_bo,id";
    } else {
      sql += " WHERE customer_itemset_bo=? AND shop_order_bo=? AND (sfc_type=? OR sfc_type is null) AND sfc_bo is NULL ORDER BY customer_itemset_bo,id";
    }
    try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
      ps.setString(1, customerItemLotBo);
      ps.setString(2, shopOrderBo);
      ps.setString(3, sfcType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert(rs));
      }
    }
    return items;
  }

  public List<ViewCustomerItemSfcItem> selectByRootSfc(String rootSfcBo) throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> items = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE root_sfc_bo=? ORDER BY sfc_bo")) {
      ps.setString(1, rootSfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert(rs));
      }
    }
    return items;
  }

  public List<ViewCustomerItemSfcItem> selectByProductAndLot(String productBo, String itemsetName)
      throws SQLException {
    ArrayList<ViewCustomerItemSfcItem> items = new ArrayList<ViewCustomerItemSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE product_bo=? AND itemset_name=? ORDER BY sfc_bo")) {
      ps.setString(1, productBo);
      ps.setString(2, itemsetName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert(rs));
      }
    }
    return items;
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

  private CustomerItem convert2(ResultSet rs) throws SQLException {
    CustomerItem data = new CustomerItem();
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

    return data;
  }
}
