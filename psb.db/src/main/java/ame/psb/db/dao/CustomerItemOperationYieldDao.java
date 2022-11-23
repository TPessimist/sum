package ame.psb.db.dao;

import ame.psb.db.CustomerItemOperationYield;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerItemOperationYieldDao {

  private static final String SQL_INS = "INSERT INTO zr_customer_item_operation_yield(customer_item_bo,operation_bo,yield,die_qty,bad_qty,good_qty) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_customer_item_operation_yield SET yield=?,die_qty=?,bad_qty=?,good_qty=? WHERE customer_item_bo=? AND operation_bo=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,operation_bo,yield,die_qty,bad_qty,good_qty FROM zr_customer_item_operation_yield ";

  private final Connection conn;

  public CustomerItemOperationYieldDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CustomerItemOperationYield data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getOperationBo());
      ps.setBigDecimal(3, data.getYield());
      ps.setInt(4, data.getDieQty());
      ps.setInt(5, data.getBadQty());
      ps.setInt(6, data.getGoodQty());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CustomerItemOperationYield> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CustomerItemOperationYield data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getOperationBo());
        ps.setBigDecimal(3, data.getYield());
        ps.setInt(4, data.getDieQty());
        ps.setInt(5, data.getBadQty());
        ps.setInt(6, data.getGoodQty());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CustomerItemOperationYield data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getYield());
      ps.setInt(2, data.getDieQty());
      ps.setInt(3, data.getBadQty());
      ps.setInt(4, data.getGoodQty());
      ps.setString(5, data.getCustomerItemBo());
      ps.setString(6, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<CustomerItemOperationYield> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CustomerItemOperationYield data : dataList) {
        ps.setBigDecimal(1, data.getYield());
        ps.setInt(2, data.getDieQty());
        ps.setInt(3, data.getBadQty());
        ps.setInt(4, data.getGoodQty());
        ps.setString(5, data.getCustomerItemBo());
        ps.setString(6, data.getOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerItemBo, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_customer_item_operation_yield WHERE customer_item_bo=? AND operation_bo=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);

      return ps.executeUpdate();
    }
  }

  public List<CustomerItemOperationYield> selectAll() throws SQLException {
    ArrayList<CustomerItemOperationYield> result = new ArrayList<CustomerItemOperationYield>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<CustomerItemOperationYield> selectByCustomerItemBo(String id) throws SQLException {
    ArrayList<CustomerItemOperationYield> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where CUSTOMER_ITEM_BO = ?")) {
      ps.setString(1,id );

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public CustomerItemOperationYield selectByPK(String customerItemBo, String operationBo)
      throws SQLException {
    CustomerItemOperationYield result = null;
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

  private CustomerItemOperationYield convert(ResultSet rs) throws SQLException {
    CustomerItemOperationYield data = new CustomerItemOperationYield();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setYield(rs.getBigDecimal(index++));
    data.setDieQty(rs.getInt(index++));
    data.setBadQty(rs.getInt(index++));
    data.setGoodQty(rs.getInt(index++));

    return data;
  }
}
