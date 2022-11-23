package ame.psb.db.dao;

import ame.psb.db.CustomerItemOperationFirstyield;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CustomerItemOperationFirstyieldDao {

  private static final String SQL_INS = "INSERT INTO zr_customer_item_operation_firstyield(customer_item_bo,operation_bo,first_yield,first_good_qty,stdf_total_qty,updated_user,updated_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_customer_item_operation_firstyield SET first_yield=?,first_good_qty=?,stdf_total_qty=?,updated_user=?,updated_time=? WHERE customer_item_bo=? AND operation_bo=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,operation_bo,first_yield,first_good_qty,stdf_total_qty,updated_user,updated_time FROM zr_customer_item_operation_firstyield ";

  private final Connection conn;

  public CustomerItemOperationFirstyieldDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CustomerItemOperationFirstyield data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getOperationBo());
      ps.setBigDecimal(3, data.getFirstYield());
      ps.setInt(4, data.getFirstGoodQty());
      ps.setInt(5, data.getStdfTotalQty());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CustomerItemOperationFirstyield> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CustomerItemOperationFirstyield data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getOperationBo());
        ps.setBigDecimal(3, data.getFirstYield());
        ps.setInt(4, data.getFirstGoodQty());
        ps.setInt(5, data.getStdfTotalQty());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CustomerItemOperationFirstyield data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getFirstYield());
      ps.setInt(2, data.getFirstGoodQty());
      ps.setInt(3, data.getStdfTotalQty());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getCustomerItemBo());
      ps.setString(7, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<CustomerItemOperationFirstyield> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CustomerItemOperationFirstyield data : dataList) {
        ps.setBigDecimal(1, data.getFirstYield());
        ps.setInt(2, data.getFirstGoodQty());
        ps.setInt(3, data.getStdfTotalQty());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getCustomerItemBo());
        ps.setString(7, data.getOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerItemBo, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_customer_item_operation_firstyield WHERE customer_item_bo=? AND operation_bo=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);

      return ps.executeUpdate();
    }
  }

  public List<CustomerItemOperationFirstyield> selectAll() throws SQLException {
    ArrayList<CustomerItemOperationFirstyield> result = new ArrayList<CustomerItemOperationFirstyield>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public CustomerItemOperationFirstyield selectByPK(String customerItemBo, String operationBo)
      throws SQLException {
    CustomerItemOperationFirstyield result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? AND operation_bo=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private CustomerItemOperationFirstyield convert(ResultSet rs) throws SQLException {
    CustomerItemOperationFirstyield data = new CustomerItemOperationFirstyield();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setFirstYield(rs.getBigDecimal(index++));
    data.setFirstGoodQty(rs.getInt(index++));
    data.setStdfTotalQty(rs.getInt(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
