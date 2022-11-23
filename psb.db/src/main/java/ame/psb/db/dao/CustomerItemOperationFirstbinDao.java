package ame.psb.db.dao;

import ame.psb.db.CustomerItemOperationFirstbin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CustomerItemOperationFirstbinDao {

  private static final String SQL_INS = "INSERT INTO zr_customer_item_operation_firstbin(customer_item_bo,operation_bo,first_bin,first_bin_qty,stdf_total_qty,first_bin_yield,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_customer_item_operation_firstbin SET first_bin_qty=?,stdf_total_qty=?,first_bin_yield=?,updated_user=?,updated_time=? WHERE customer_item_bo=? AND operation_bo=? AND first_bin=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,operation_bo,first_bin,first_bin_qty,stdf_total_qty,first_bin_yield,updated_user,updated_time FROM zr_customer_item_operation_firstbin ";

  private final Connection conn;

  public CustomerItemOperationFirstbinDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CustomerItemOperationFirstbin data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getFirstBin());
      ps.setInt(4, data.getFirstBinQty());
      ps.setInt(5, data.getStdfTotalQty());
      ps.setBigDecimal(6, data.getFirstBinYield());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CustomerItemOperationFirstbin> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CustomerItemOperationFirstbin data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getFirstBin());
        ps.setInt(4, data.getFirstBinQty());
        ps.setInt(5, data.getStdfTotalQty());
        ps.setBigDecimal(6, data.getFirstBinYield());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CustomerItemOperationFirstbin data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getFirstBinQty());
      ps.setInt(2, data.getStdfTotalQty());
      ps.setBigDecimal(3, data.getFirstBinYield());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getCustomerItemBo());
      ps.setString(7, data.getOperationBo());
      ps.setString(8, data.getFirstBin());

      return ps.executeUpdate();
    }
  }

  public int update(List<CustomerItemOperationFirstbin> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CustomerItemOperationFirstbin data : dataList) {
        ps.setInt(1, data.getFirstBinQty());
        ps.setInt(2, data.getStdfTotalQty());
        ps.setBigDecimal(3, data.getFirstBinYield());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getCustomerItemBo());
        ps.setString(7, data.getOperationBo());
        ps.setString(8, data.getFirstBin());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerItemBo, String operationBo, String firstBin)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_customer_item_operation_firstbin WHERE customer_item_bo=? AND operation_bo=? AND first_bin=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);
      ps.setString(3, firstBin);

      return ps.executeUpdate();
    }
  }

  public List<CustomerItemOperationFirstbin> selectAll() throws SQLException {
    ArrayList<CustomerItemOperationFirstbin> result = new ArrayList<CustomerItemOperationFirstbin>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public CustomerItemOperationFirstbin selectByPK(String customerItemBo, String operationBo,
      String firstBin) throws SQLException {
    CustomerItemOperationFirstbin result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE customer_item_bo=? AND operation_bo=? AND first_bin=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);
      ps.setString(3, firstBin);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private CustomerItemOperationFirstbin convert(ResultSet rs) throws SQLException {
    CustomerItemOperationFirstbin data = new CustomerItemOperationFirstbin();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setFirstBin(rs.getString(index++));
    data.setFirstBinQty(rs.getInt(index++));
    data.setStdfTotalQty(rs.getInt(index++));
    data.setFirstBinYield(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
