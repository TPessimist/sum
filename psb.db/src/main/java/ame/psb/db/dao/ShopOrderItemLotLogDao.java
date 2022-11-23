package ame.psb.db.dao;

import ame.psb.db.ShopOrderCustomerLotLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ShopOrderItemLotLogDao {

  private static final String SQL_INS = "INSERT INTO zr_shop_order_itemset_log(id,shop_order_bo,customer_itemset_bo,root_sfc_bo,curr_seq,dpt_no,lot_type,run_time,run_user) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_SEL = "SELECT id,shop_order_bo,customer_itemset_bo,root_sfc_bo,curr_seq,dpt_no,lot_type,run_time,run_user FROM zr_shop_order_itemset_log ";

  private final Connection conn;

  public ShopOrderItemLotLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ShopOrderCustomerLotLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getShopOrderBo());
      ps.setString(3, data.getCustomerItemLotBo());
      ps.setString(4, data.getRootSfcName());
      ps.setInt(5, data.getCurrSeq());
      ps.setString(6, data.getDptNo());
      ps.setString(7, data.getLotType());
      DateUtils.setDateTz(ps, 8, data.getRunTime());
      ps.setString(9, data.getRunUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ShopOrderCustomerLotLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ShopOrderCustomerLotLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getShopOrderBo());
        ps.setString(3, data.getCustomerItemLotBo());
        ps.setString(4, data.getRootSfcName());
        ps.setInt(5, data.getCurrSeq());
        ps.setString(6, data.getDptNo());
        ps.setString(7, data.getLotType());
        DateUtils.setDateTz(ps, 8, data.getRunTime());
        ps.setString(9, data.getRunUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_shop_order_itemset_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ShopOrderCustomerLotLog> selectAll() throws SQLException {
    ArrayList<ShopOrderCustomerLotLog> result = new ArrayList<ShopOrderCustomerLotLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ShopOrderCustomerLotLog selectByPK(String id) throws SQLException {
    ShopOrderCustomerLotLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ShopOrderCustomerLotLog convert(ResultSet rs) throws SQLException {
    ShopOrderCustomerLotLog data = new ShopOrderCustomerLotLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setCustomerItemLotBo(rs.getString(index++));
    data.setRootSfcName(rs.getString(index++));
    data.setCurrSeq(rs.getInt(index++));
    data.setDptNo(rs.getString(index++));
    data.setLotType(rs.getString(index++));
    data.setRunTime(DateUtils.getDateTz(rs, index++));
    data.setRunUser(rs.getString(index++));

    return data;
  }
}