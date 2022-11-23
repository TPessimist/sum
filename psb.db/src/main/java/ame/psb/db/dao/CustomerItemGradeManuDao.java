package ame.psb.db.dao;

import ame.psb.db.CustomerItemGradeManu;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CustomerItemGradeManuDao {

  private static final String SQL_INS = "INSERT INTO zr_customer_item_grade_manu(customer_item_bo,grade_id,die_qty,good_bad,batch_flag,updated_user,updated_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_customer_item_grade_manu SET die_qty=?,good_bad=?,batch_flag=?,updated_user=?,updated_time=? WHERE customer_item_bo=? AND grade_id=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,grade_id,die_qty,good_bad,batch_flag,updated_user,updated_time FROM zr_customer_item_grade_manu ";

  private final Connection conn;

  public CustomerItemGradeManuDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CustomerItemGradeManu data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getGradeId());
      ps.setBigDecimal(3, new BigDecimal(data.getDieQty()));
      ps.setString(4, data.getGoodBad());
      ps.setString(5, data.getBatchFlag());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CustomerItemGradeManu> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CustomerItemGradeManu data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getGradeId());
        ps.setBigDecimal(3, new BigDecimal(data.getDieQty()));
        ps.setString(4, data.getGoodBad());
        ps.setString(5, data.getBatchFlag());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CustomerItemGradeManu data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, new BigDecimal(data.getDieQty()));
      ps.setString(2, data.getGoodBad());
      ps.setString(3, data.getBatchFlag());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getCustomerItemBo());
      ps.setString(7, data.getGradeId());

      return ps.executeUpdate();
    }
  }

  public int update(List<CustomerItemGradeManu> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CustomerItemGradeManu data : dataList) {
        ps.setBigDecimal(1, new BigDecimal(data.getDieQty()));
        ps.setString(2, data.getGoodBad());
        ps.setString(3, data.getBatchFlag());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getCustomerItemBo());
        ps.setString(7, data.getGradeId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerItemBo, String gradeId) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_customer_item_grade_manu WHERE customer_item_bo=? AND grade_id=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, gradeId);

      return ps.executeUpdate();
    }
  }

  public List<CustomerItemGradeManu> selectAll() throws SQLException {
    ArrayList<CustomerItemGradeManu> result = new ArrayList<CustomerItemGradeManu>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<CustomerItemGradeManu> selectByBath(String batgFlag) throws SQLException {

    List<CustomerItemGradeManu> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE batch_flag = ?")) {
      ps.setString(1, batgFlag);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public CustomerItemGradeManu selectByPK(String customerItemBo, String gradeId)
      throws SQLException {
    CustomerItemGradeManu result = null;
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

  private CustomerItemGradeManu convert(ResultSet rs) throws SQLException {
    CustomerItemGradeManu data = new CustomerItemGradeManu();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setGradeId(rs.getString(index++));
    data.setDieQty(rs.getBigDecimal(index++));
    data.setGoodBad(rs.getString(index++));
    data.setBatchFlag(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
