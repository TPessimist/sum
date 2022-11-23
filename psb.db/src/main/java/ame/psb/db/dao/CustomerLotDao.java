package ame.psb.db.dao;

import ame.psb.db.CustomerLot;
import ame.psb.db.ViewCustomerLot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CustomerLotDao {

  private static final String SQL_INS = "INSERT INTO zd_customer_itemset(id,customer_bo,itemset_name,created_time,closed_time,customer_order,itemset_name_orig) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_customer_itemset SET customer_bo=?,itemset_name=?,created_time=?,closed_time=?,customer_order=?,itemset_name_orig=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,customer_bo,itemset_name,created_time,closed_time,customer_order,customer,customer_name,itemset_name_orig FROM view_customer_itemset ";

  private Connection conn;

  public CustomerLotDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewCustomerLot> selectAll() throws SQLException {
    ArrayList<ViewCustomerLot> items = new ArrayList<ViewCustomerLot>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " ORDER BY id")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(convert(rs));
      }
    }
    return items;
  }

  public ViewCustomerLot selectByPK(String id) throws SQLException {
    ViewCustomerLot result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }
    return result;
  }

  public ViewCustomerLot selectByName(String lotName) throws SQLException {
    ViewCustomerLot result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE itemset_name=?")) {
      ps.setString(1, lotName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }
    return result;
  }

  public List<ViewCustomerLot> selectByNamePrefix(String lotName) throws SQLException {
    ArrayList<ViewCustomerLot> result = new ArrayList<ViewCustomerLot>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE itemset_name like ? ORDER BY itemset_name")) {
      ps.setString(1, lotName + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public int insert(CustomerLot itemLot) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, itemLot.getId());
      ps.setString(2, itemLot.getCustomerBo());
      ps.setString(3, itemLot.getItemLotName());
      DateUtils.setDateTz(ps, 4, itemLot.getCreatedTime());
      DateUtils.setDateTz(ps, 5, itemLot.getClosedTime());
      ps.setString(6, itemLot.getCustomerOrder());
      ps.setString(7, itemLot.getItemLotNameOrig());
      return ps.executeUpdate();
    }
  }

  public int update(CustomerLot itemLot) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, itemLot.getCustomerBo());
      ps.setString(2, itemLot.getItemLotName());
      DateUtils.setDateTz(ps, 3, itemLot.getCreatedTime());
      DateUtils.setDateTz(ps, 4, itemLot.getClosedTime());
      ps.setString(5, itemLot.getCustomerOrder());
      ps.setString(6, itemLot.getItemLotNameOrig());
      ps.setString(7, itemLot.getId());
      return ps.executeUpdate();
    }
  }

  private ViewCustomerLot convert(ResultSet rs) throws SQLException {
    ViewCustomerLot result = new ViewCustomerLot();
    result.setId(rs.getString(1));
    result.setCustomerBo(rs.getString(2));
    result.setItemLotName(rs.getString(3));
    result.setCreatedTime(DateUtils.getDateTz(rs, 4));
    result.setClosedTime(DateUtils.getDateTz(rs, 5));
    result.setCustomerOrder(rs.getString(6));
    result.setCustomer(rs.getString(7));
    result.setCustomerName(rs.getString(8));
    result.setItenLotNameOrig(rs.getString(9));
    return result;
  }
}
