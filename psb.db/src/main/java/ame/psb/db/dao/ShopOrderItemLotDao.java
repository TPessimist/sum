package ame.psb.db.dao;

import ame.psb.db.ShopOrderCustomerLot;
import ame.psb.db.ViewShopOrderCustomerLot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ShopOrderItemLotDao {

  private static final String SQL_SEL = "SELECT shop_order_bo,customer_itemset_bo,root_sfc_bo,curr_seq,created_time,shop_order,status_bo,status_description,shop_order_type_bo,order_type,item_bo,item,item_group_bo,planned_router_bo,router,priority,scheduled_start_date,scheduled_comp_date,lot_name,dpt_no,lot_type,customer_bo,customer,customer_order FROM view_shop_order_itemset ";

  private Connection conn;

  public ShopOrderItemLotDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ShopOrderCustomerLot soLot) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "INSERT INTO zd_shop_order_itemset(shop_order_bo,customer_itemset_bo,root_sfc_bo,curr_seq,dpt_no,lot_type) VALUES (?,?,?,?,?,?)")) {
      ps.setString(1, soLot.getShopOrderBo());
      ps.setString(2, soLot.getCustomerItemLotBo());
      ps.setString(3, soLot.getRootSfcName());
      ps.setInt(4, soLot.getCurrSeq());
      ps.setString(5, soLot.getDptNo());
      ps.setString(6, soLot.getLotType());
      return ps.executeUpdate();
    }
  }

  public int updateRootSfcBo(String shopOrderBo, String customerItemLotBo, String rootSfcBo)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_shop_order_itemset SET root_sfc_bo=?,curr_seq=1 WHERE shop_order_bo=? AND customer_itemset_bo=?")) {
      ps.setString(1, rootSfcBo);
      ps.setString(2, shopOrderBo);
      ps.setString(3, customerItemLotBo);
      return ps.executeUpdate();
    }
  }

  public int updateCurrSeq(String shopOrderBo, String customerItemLotBo, int currSeq)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_shop_order_itemset SET curr_seq=? WHERE shop_order_bo=? AND customer_itemset_bo=?")) {
      ps.setInt(1, currSeq);
      ps.setString(2, shopOrderBo);
      ps.setString(3, customerItemLotBo);
      return ps.executeUpdate();
    }
  }

  public List<ViewShopOrderCustomerLot> selectAll() throws SQLException {
    ArrayList<ViewShopOrderCustomerLot> result = new ArrayList<ViewShopOrderCustomerLot>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<ViewShopOrderCustomerLot> selectByShopOrder(String shopOrderBo) throws SQLException {
    ArrayList<ViewShopOrderCustomerLot> result = new ArrayList<ViewShopOrderCustomerLot>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order_bo=? ")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<ViewShopOrderCustomerLot> selectByItemLot(String customerItemLotBo)
      throws SQLException {
    ArrayList<ViewShopOrderCustomerLot> result = new ArrayList<ViewShopOrderCustomerLot>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_itemset_bo=? ")) {
      ps.setString(1, customerItemLotBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<ViewShopOrderCustomerLot> selectByNamePrefix(String shopOrder, String itemLot)
      throws SQLException {
    ArrayList<ViewShopOrderCustomerLot> result = new ArrayList<ViewShopOrderCustomerLot>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE shop_order like ? AND lot_name like ? ")) {
      ps.setString(1, shopOrder == null ? "%" : shopOrder + "%");
      ps.setString(2, itemLot == null ? "%" : itemLot + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<ViewShopOrderCustomerLot> selectByDeviceAndLot(String itemGroupBo, String itemLot)
      throws SQLException {
    ArrayList<ViewShopOrderCustomerLot> result = new ArrayList<ViewShopOrderCustomerLot>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo =? AND lot_name =? ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, itemLot);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<ViewShopOrderCustomerLot> selectByDeviceAndLikeLot(String itemGroupBo, String lotStr)
      throws SQLException {
    ArrayList<ViewShopOrderCustomerLot> result = new ArrayList<ViewShopOrderCustomerLot>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo =? AND lot_name like ? ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, lotStr + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<ViewShopOrderCustomerLot> selectByDevice(String itemGroupBo)
      throws SQLException {
    ArrayList<ViewShopOrderCustomerLot> result = new ArrayList<ViewShopOrderCustomerLot>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo =?")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public ViewShopOrderCustomerLot selectByPK(String shopOrderBo, String customerItemLotBo)
      throws SQLException {
    ViewShopOrderCustomerLot soLot = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE shop_order_bo=? AND customer_itemset_bo=?")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, customerItemLotBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        soLot = convert(rs);
      }
    }
    return soLot;
  }

  private ViewShopOrderCustomerLot convert(ResultSet rs) throws SQLException {
    ViewShopOrderCustomerLot data = new ViewShopOrderCustomerLot();
    data.setShopOrderBo(rs.getString(1));
    data.setCustomerItemLotBo(rs.getString(2));
    data.setRootSfcName(rs.getString(3));
    data.setCurrSeq(rs.getInt(4));
    data.setCreatedTime(DateUtils.getDateTz(rs, 5));

    int i = 6;
    data.setShopOrder(rs.getString(i++));
    data.setStatusBo(rs.getString(i++));
    data.setStatusDescription(rs.getString(i++));
    data.setShopOrderTypeBo(rs.getString(i++));
    data.setOrderType(rs.getString(i++));
    data.setItemBo(rs.getString(i++));
    data.setItem(rs.getString(i++));
    data.setItemGroupBo(rs.getString(i++));
    data.setPlannedRouterBo(rs.getString(i++));
    data.setRouter(rs.getString(i++));
    data.setPriority(rs.getInt(i++));
    data.setScheduledStartDate(DateUtils.getDateTz(rs, i++));
    data.setScheduledCompDate(DateUtils.getDateTz(rs, i++));
    data.setLotName(rs.getString(i++));
    data.setDptNo(rs.getString(i++));               // from SHOP_ORDER_ITEM_SET
    data.setLotType(rs.getString(i++));             // from SHOP_ORDER_ITEM_SET
    data.setCustomerBo(rs.getString(i++));
    data.setCustomer(rs.getString(i++));
    data.setCustomerOrder(rs.getString(i++));
    return data;
  }

}
