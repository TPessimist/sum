package ame.psb.db.dao;

import ame.psb.db.CustomerItemGradeMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CustomerItemGradeMapDao {

  private static final String SQL_INS = "INSERT INTO zr_customer_item_grade_map(customer_item_bo,grade_id,die_qty,good_bad,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_customer_item_grade_map SET die_qty=?,good_bad=?,updated_user=?,updated_time=? WHERE customer_item_bo=? AND grade_id=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,grade_id,die_qty,good_bad,updated_user,updated_time FROM zr_customer_item_grade_map ";

  private final Connection conn;

  public CustomerItemGradeMapDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CustomerItemGradeMap data) throws SQLException {
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

  public int insert(List<CustomerItemGradeMap> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CustomerItemGradeMap data : dataList) {
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

  public int update(CustomerItemGradeMap data) throws SQLException {
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

  public int update(List<CustomerItemGradeMap> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CustomerItemGradeMap data : dataList) {
        ps.setInt(1, data.getDieQty());
        ps.setString(2, data.getGoodBad());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getCustomerItemBo());
        ps.setString(6, data.getGradeId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerItemBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_customer_item_grade_map WHERE customer_item_bo=? ")) {
      ps.setString(1, customerItemBo);

      return ps.executeUpdate();
    }
  }

  public int delete(String customerItemBo, String gradeId) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_customer_item_grade_map WHERE customer_item_bo=? AND grade_id=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, gradeId);

      return ps.executeUpdate();
    }
  }

  public List<CustomerItemGradeMap> selectAll() throws SQLException {
    ArrayList<CustomerItemGradeMap> result = new ArrayList<CustomerItemGradeMap>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public CustomerItemGradeMap selectByPK(String customerItemBo, String gradeId)
      throws SQLException {
    CustomerItemGradeMap result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? AND grade_id=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, gradeId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public CustomerItemGradeMap selectByPK(String customerItemBo)
      throws SQLException {
    CustomerItemGradeMap result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=?")) {
      ps.setString(1, customerItemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private CustomerItemGradeMap convert(ResultSet rs) throws SQLException {
    CustomerItemGradeMap data = new CustomerItemGradeMap();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setGradeId(rs.getString(index++));
    data.setDieQty(rs.getInt(index++));
    data.setGoodBad(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
