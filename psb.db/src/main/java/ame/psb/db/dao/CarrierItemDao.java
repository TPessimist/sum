package ame.psb.db.dao;

import ame.psb.db.ViewCarrierItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarrierItemDao {

  private static final String SQL_SEL = "SELECT carrier_bo,carrier_name,slot_no,customer_item_bo,customer_item_name,customer_item_name_orig,customer_itemset_bo,customer_itemset_name,customer_bo,sfc_bo,sfc_name,shop_order_bo,shop_order_name,carrier_type,carrier_state_name,carrier_current_run,sfc_state_name,sfc_current_run,sfc_item_state_name,sfc_item_current_run,operation_bo,mark_code,gross_qty,good_qty FROM view_carrier_item ";

  private Connection conn;

  public CarrierItemDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewCarrierItem> selectByCarrier(String carrierBo) throws SQLException {
    ArrayList<ViewCarrierItem> result = new ArrayList<ViewCarrierItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE carrier_bo=?")) {
      ps.setString(1, carrierBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  private ViewCarrierItem convert(ResultSet rs) throws SQLException {
    ViewCarrierItem data = new ViewCarrierItem();
    data.setCarrierBo(rs.getString(1));
    data.setCarrierName(rs.getString(2));
    data.setSlotNo(rs.getInt(3));
    data.setCustomerItemBo(rs.getString(4));
    data.setCustomerItemName(rs.getString(5));
    data.setCustomerItemNameOrig(rs.getString(6));
    data.setCustomerItemLotBo(rs.getString(7));
    data.setCustomerItemLotName(rs.getString(8));
    data.setCustomerBo(rs.getString(9));
    data.setSfcBo(rs.getString(10));
    data.setSfcName(rs.getString(11));
    data.setShopOrderBo(rs.getString(12));
    data.setShopOrderName(rs.getString(13));
    data.setCarrierType(rs.getString(14));
    data.setCarrierStateName(rs.getString(15));
    data.setCarrierCurrentRun(rs.getString(16));
    data.setSfcStateName(rs.getString(17));
    data.setSfcCurrentRun(rs.getString(18));
    data.setSfcItemStateName(rs.getString(19));
    data.setSfcItemCurrentRun(rs.getString(20));
    data.setOperationBo(rs.getString(21));
    data.setMarkCode(rs.getString(22));
    data.setGrossQty(rs.getInt(23));
    data.setGoodQty(rs.getInt(24));
    return data;
  }
}
