package ame.psb.db.dao;

import ame.psb.db.ViewSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class ViewSfcDao {

  private static final String SQL_SEL = "SELECT sfc_bo,sfc_name,state_name,current_run,customer_itemset_bo,priority,dpt_no,lot_type,item_qty,shop_order_bo,shop_order_name,item_bo,item_name,device_bo,device_name,package_bo,package_name,router_bo,router_name,sfc_qty,customer,status_bo,customer_itemset_name,remark,customer_itemset_name_orig,carrier_bo,carrier_name,carrier_state_name,curr_seq,sfc_type,created_date_time FROM view_sfc ";

  private final Connection conn;

  public ViewSfcDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewSfc> selectAll() throws SQLException {
    ArrayList<ViewSfc> result = new ArrayList<ViewSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSfc> selectByCarrier(String carriername) throws SQLException {
    ArrayList<ViewSfc> result = new ArrayList<ViewSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where carrier_name = ? ")) {
      ps.setString(1, carriername);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSfc> selectBySfc(String sfc) throws SQLException {
    ArrayList<ViewSfc> result = new ArrayList<ViewSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where sfc_bo = ?")) {
      ps.setString(1, sfc);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewSfc selectBySfcBo(String sfc) throws SQLException {
    ViewSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where sfc_bo = ?")) {
      ps.setString(1, sfc);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewSfc> selectByShodOrder(String ShodOrder) throws SQLException {
    ArrayList<ViewSfc> result = new ArrayList<ViewSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where SHOP_ORDER_BO = ?")) {
      ps.setString(1, ShodOrder);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSfc> selectByCustomerBo(String CustomerBo) throws SQLException {
    ArrayList<ViewSfc> result = new ArrayList<ViewSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where customer_itemset_name = ?")) {
      ps.setString(1, CustomerBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public String selectByDevice(String deviceName) throws SQLException {
    String result = "";
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT DISTINCT customer FROM view_sfc WHERE device_name = ?")) {
      ps.setString(1, deviceName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = rs.getString(1);
      }
      return result;
    }
  }

  public List<ViewSfc> select(Where where) throws SQLException {
    List<ViewSfc> list = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convert(rs));
      }
      return list;
    }
  }

  private ViewSfc convert(ResultSet rs) throws SQLException {
    ViewSfc data = new ViewSfc();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCurrentRun(rs.getString(index++));
    data.setCustomerItemsetBo(rs.getString(index++));
    data.setPriority(rs.getBigDecimal(index++));
    data.setDptNo(rs.getString(index++));
    data.setLotType(rs.getString(index++));
    data.setItemQty(rs.getBigDecimal(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setDeviceBo(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setPackageBo(rs.getString(index++));
    data.setPackageName(rs.getString(index++));
    data.setRouterBo(rs.getString(index++));
    data.setRouterName(rs.getString(index++));
    data.setSfcQty(rs.getBigDecimal(index++));
    data.setCustomer(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setCustomerItemsetName(rs.getString(index++));
    data.setRemark(rs.getString(index++));
    data.setCustomerItemsetNameOrig(rs.getString(index++));
    data.setCarrierBo(rs.getString(index++));
    data.setCarrierName(rs.getString(index++));
    data.setCarrierStateName(rs.getString(index++));
    data.setCurrSeq(rs.getBigDecimal(index++));
    data.setSfcType(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
