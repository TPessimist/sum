package ame.psb.db.dao;

import ame.psb.db.CustomerItemGrade;
import ame.psb.db.ViewCustomerItemGrade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CustomerItemGradeDao {

  private static final String SQL_INS = "INSERT INTO zr_customer_item_grade(customer_item_bo,grade_id,die_qty,good_bad,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_customer_item_grade SET die_qty=?,good_bad=?,updated_user=?,updated_time=? WHERE customer_item_bo=? AND grade_id=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,grade_id,die_qty,good_bad,updated_user,updated_time FROM zr_customer_item_grade ";

  private static final String VIEW_SEL = "SELECT customer_item_bo,grade_id,die_qty,good_bad,sfc_bo,sfc_name,customer_item_name FROM view_customer_item_grade ";

  private static final String VIEW_SEL_SHOP = "SELECT customer_item_bo,grade_id,die_qty,good_bad,sfc_bo,sfc_name,customer_item_name FROM VIEW_CUSTOMER_ITEM_GRADE_SHOPORDER ";


  private final Connection conn;

  public CustomerItemGradeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CustomerItemGrade data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getGradeId());
      ps.setInt(3, data.getDieQty());
      ps.setString(4, data.getGoodBad());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CustomerItemGrade> items) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CustomerItemGrade data : items) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getGradeId());
        ps.setInt(3, data.getDieQty());
        ps.setString(4, data.getGoodBad());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CustomerItemGrade data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getDieQty());
      ps.setString(2, data.getGoodBad());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getCustomerItemBo());
      ps.setString(6, data.getGradeId());

      return ps.executeUpdate();
    }
  }

  public int delete(String customerItemBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_customer_item_grade WHERE customer_item_bo=? ")) {
      ps.setString(1, customerItemBo);

      return ps.executeUpdate();
    }
  }

  public int delete(String customerItemBo, String gradeId) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_customer_item_grade WHERE customer_item_bo=? AND grade_id=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, gradeId);

      return ps.executeUpdate();
    }
  }

  public CustomerItemGrade selectByPK(String customerItemBo, String gradeId) throws SQLException {
    CustomerItemGrade result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? AND grade_id=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, gradeId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public void selectOrInsert(CustomerItemGrade data) throws SQLException {

    CustomerItemGrade grade = this.selectByPK(data.getCustomerItemBo(), data.getGradeId());
    if (null == grade) {
      this.insert(data);
    } else {
      this.update(data);
    }
  }


  public ViewCustomerItemGrade selectByCustomerItemNameAndGrade(String waferid, String grade)
      throws SQLException {
    ViewCustomerItemGrade result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(VIEW_SEL
        + "WHERE customer_item_name =? and grade_id = ? ORDER BY customer_item_bo,grade_id")) {
      ps.setString(1, waferid);
      ps.setString(2, grade);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convertView(rs);
      }
      return result;
    }
  }

  public ViewCustomerItemGrade selectByCustomerItemNameAndGrade(String waferid, String shopOrder,
      String grade) throws SQLException {
    ViewCustomerItemGrade result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(VIEW_SEL
        + "WHERE customer_item_name =? and shop_order_bo = ? and grade_id = ? ORDER BY customer_item_bo,grade_id")) {
      ps.setString(1, waferid);
      ps.setString(2, shopOrder);
      ps.setString(3, grade);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convertView(rs);
      }
      return result;
    }
  }

  public ViewCustomerItemGrade selectByCustomerItemBoAndGrade(String waferid, String grade)
      throws SQLException {
    ViewCustomerItemGrade result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(VIEW_SEL
        + "WHERE customer_item_bo =? and grade_id = ? ORDER BY customer_item_bo,grade_id")) {
      ps.setString(1, waferid);
      ps.setString(2, grade);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convertView(rs);
      }
      return result;
    }
  }


  public ArrayList<ViewCustomerItemGrade> selectByShopOrderAndGrade(String sp, String grade)
      throws SQLException {
    ArrayList<ViewCustomerItemGrade> result = new ArrayList<>();

    try (PreparedStatement ps = this.conn.prepareStatement(VIEW_SEL_SHOP
        + "WHERE SHOP_ORDER_BO = ? and grade_id = ? ORDER BY customer_item_bo,grade_id")) {
      ps.setString(1, sp);
      ps.setString(2, grade);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewCustomerItemGrade> selectByShopOrder(String shopOrderBo) throws SQLException {
    ArrayList<ViewCustomerItemGrade> result = new ArrayList<>();

    try (PreparedStatement ps = this.conn.prepareStatement(
        VIEW_SEL_SHOP + "WHERE shop_order_bo = ?  ORDER BY customer_item_bo,grade_id")) {
      ps.setString(1, shopOrderBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }


  public List<ViewCustomerItemGrade> selectByWaferAndGB(String waferid, String gb)
      throws SQLException {
    ArrayList<ViewCustomerItemGrade> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(VIEW_SEL
        + "WHERE customer_item_bo=? and good_bad = ? ORDER BY customer_item_bo,grade_id")) {
      ps.setString(1, waferid);
      ps.setString(2, gb);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convertView(rs));
      }
      return result;
    }
  }

  public List<ViewCustomerItemGrade> selectBySfcAndGrade(String sfcBo, String grade)
      throws SQLException {
    ArrayList<ViewCustomerItemGrade> result = new ArrayList<ViewCustomerItemGrade>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        VIEW_SEL + "WHERE sfc_bo=?  and grade_id = ? ORDER BY customer_item_bo,grade_id")) {
      ps.setString(1, sfcBo);
      ps.setString(2, grade);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convertView(rs));
      }
      return result;
    }
  }

  public List<ViewCustomerItemGrade> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<ViewCustomerItemGrade> result = new ArrayList<ViewCustomerItemGrade>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(VIEW_SEL + "WHERE sfc_bo=?   ORDER BY customer_item_bo,grade_id")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convertView(rs));
      }
      return result;
    }
  }

  public List<ViewCustomerItemGrade> selectBySfcAndItemName(String sfcBo, String itemName)
      throws SQLException {
    ArrayList<ViewCustomerItemGrade> result = new ArrayList<ViewCustomerItemGrade>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        VIEW_SEL + "WHERE sfc_bo=? AND customer_item_name=? ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, itemName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convertView(rs));
      }
      return result;
    }
  }

  public List<CustomerItemGrade> selectByCustomerItem(String customerItemBo) throws SQLException {
    ArrayList<CustomerItemGrade> result = new ArrayList<CustomerItemGrade>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? ORDER BY grade_id")) {
      ps.setString(1, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<CustomerItemGrade> selectByItemQty(String customerItemBo, String goodBad)
      throws SQLException {
    ArrayList<CustomerItemGrade> result = new ArrayList<CustomerItemGrade>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo = ? and good_bad = ? ")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, goodBad);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  private CustomerItemGrade convert(ResultSet rs) throws SQLException {
    CustomerItemGrade data = new CustomerItemGrade();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setGradeId(rs.getString(index++));
    data.setDieQty(rs.getInt(index++));
    data.setGoodBad(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }

  private ViewCustomerItemGrade convertView(ResultSet rs) throws SQLException {
    ViewCustomerItemGrade data = new ViewCustomerItemGrade();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setGradeId(rs.getString(index++));
    data.setDieQty(rs.getInt(index++));
    data.setGoodBad(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setCustomerItemName(rs.getString(index++));

    return data;
  }
}
