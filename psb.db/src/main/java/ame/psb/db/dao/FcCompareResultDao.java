package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FcCompareResult;
import uia.utils.dao.DateUtils;

public class FcCompareResultDao {

  private static final String SQL_INS = "INSERT INTO zd_fc_compare_result(id,customer_itemset_bo,itemset_name,orig_wafer_id,wafer_id,state_name,sfc_bo,sfc,shop_order_bo,shop_order,customer,device_name,item_name,updated_user,updated_time,reserves1,reserves2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_fc_compare_result SET customer_itemset_bo=?,itemset_name=?,orig_wafer_id=?,wafer_id=?,state_name=?,sfc_bo=?,sfc=?,shop_order_bo=?,shop_order=?,customer=?,device_name=?,item_name=?,updated_user=?,updated_time=?,reserves1=?,reserves2=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,customer_itemset_bo,itemset_name,orig_wafer_id,wafer_id,state_name,sfc_bo,sfc,shop_order_bo,shop_order,customer,device_name,item_name,updated_user,updated_time,reserves1,reserves2 FROM zd_fc_compare_result ";

  private final Connection conn;

  public FcCompareResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FcCompareResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getCustomerItemsetBo());
      ps.setString(3, data.getItemsetName());
      ps.setString(4, data.getOrigWaferId());
      ps.setString(5, data.getWaferId());
      ps.setString(6, data.getStateName());
      ps.setString(7, data.getSfcBo());
      ps.setString(8, data.getSfc());
      ps.setString(9, data.getShopOrderBo());
      ps.setString(10, data.getShopOrder());
      ps.setString(11, data.getCustomer());
      ps.setString(12, data.getDeviceName());
      ps.setString(13, data.getItemName());
      ps.setString(14, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 15, data.getUpdatedTime());
      ps.setString(16, data.getReserves1());
      ps.setString(17, data.getReserves2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FcCompareResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FcCompareResult data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getCustomerItemsetBo());
        ps.setString(3, data.getItemsetName());
        ps.setString(4, data.getOrigWaferId());
        ps.setString(5, data.getWaferId());
        ps.setString(6, data.getStateName());
        ps.setString(7, data.getSfcBo());
        ps.setString(8, data.getSfc());
        ps.setString(9, data.getShopOrderBo());
        ps.setString(10, data.getShopOrder());
        ps.setString(11, data.getCustomer());
        ps.setString(12, data.getDeviceName());
        ps.setString(13, data.getItemName());
        ps.setString(14, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 15, data.getUpdatedTime());
        ps.setString(16, data.getReserves1());
        ps.setString(17, data.getReserves2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FcCompareResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomerItemsetBo());
      ps.setString(2, data.getItemsetName());
      ps.setString(3, data.getOrigWaferId());
      ps.setString(4, data.getWaferId());
      ps.setString(5, data.getStateName());
      ps.setString(6, data.getSfcBo());
      ps.setString(7, data.getSfc());
      ps.setString(8, data.getShopOrderBo());
      ps.setString(9, data.getShopOrder());
      ps.setString(10, data.getCustomer());
      ps.setString(11, data.getDeviceName());
      ps.setString(12, data.getItemName());
      ps.setString(13, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 14, data.getUpdatedTime());
      ps.setString(15, data.getReserves1());
      ps.setString(16, data.getReserves2());
      ps.setString(17, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FcCompareResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FcCompareResult data : dataList) {
        ps.setString(1, data.getCustomerItemsetBo());
        ps.setString(2, data.getItemsetName());
        ps.setString(3, data.getOrigWaferId());
        ps.setString(4, data.getWaferId());
        ps.setString(5, data.getStateName());
        ps.setString(6, data.getSfcBo());
        ps.setString(7, data.getSfc());
        ps.setString(8, data.getShopOrderBo());
        ps.setString(9, data.getShopOrder());
        ps.setString(10, data.getCustomer());
        ps.setString(11, data.getDeviceName());
        ps.setString(12, data.getItemName());
        ps.setString(13, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 14, data.getUpdatedTime());
        ps.setString(15, data.getReserves1());
        ps.setString(16, data.getReserves2());
        ps.setString(17, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_fc_compare_result WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<FcCompareResult> selectAll() throws SQLException {
    ArrayList<FcCompareResult> result = new ArrayList<FcCompareResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FcCompareResult selectByPK(String id) throws SQLException {
    FcCompareResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FcCompareResult convert(ResultSet rs) throws SQLException {
    FcCompareResult data = new FcCompareResult();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setCustomerItemsetBo(rs.getString(index++));
    data.setItemsetName(rs.getString(index++));
    data.setOrigWaferId(rs.getString(index++));
    data.setWaferId(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setCustomer(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setReserves1(rs.getString(index++));
    data.setReserves2(rs.getString(index++));

    return data;
  }
}
