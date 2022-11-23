package ame.psb.db.dao;

import ame.psb.db.CustomerItemOperationSoftbin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CustomerItemOperationSoftbinDao {

  private static final String SQL_INS = "INSERT INTO zr_customer_item_operation_softbin(customer_item_bo,operation_bo,soft_bin,soft_bin_qty,stdf_total_qty,soft_bin_yield,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_customer_item_operation_softbin SET soft_bin_qty=?,stdf_total_qty=?,soft_bin_yield=?,updated_user=?,updated_time=? WHERE customer_item_bo=? AND operation_bo=? AND soft_bin=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,operation_bo,soft_bin,soft_bin_qty,stdf_total_qty,soft_bin_yield,updated_user,updated_time FROM zr_customer_item_operation_softbin ";

  private final Connection conn;

  public CustomerItemOperationSoftbinDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CustomerItemOperationSoftbin data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getSoftBin());
      ps.setInt(4, data.getSoftBinQty());
      ps.setInt(5, data.getStdfTotalQty());
      ps.setBigDecimal(6, data.getSoftBinYield());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CustomerItemOperationSoftbin> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CustomerItemOperationSoftbin data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getSoftBin());
        ps.setInt(4, data.getSoftBinQty());
        ps.setInt(5, data.getStdfTotalQty());
        ps.setBigDecimal(6, data.getSoftBinYield());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CustomerItemOperationSoftbin data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getSoftBinQty());
      ps.setInt(2, data.getStdfTotalQty());
      ps.setBigDecimal(3, data.getSoftBinYield());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getCustomerItemBo());
      ps.setString(7, data.getOperationBo());
      ps.setString(8, data.getSoftBin());

      return ps.executeUpdate();
    }
  }

  public int update(List<CustomerItemOperationSoftbin> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CustomerItemOperationSoftbin data : dataList) {
        ps.setInt(1, data.getSoftBinQty());
        ps.setInt(2, data.getStdfTotalQty());
        ps.setBigDecimal(3, data.getSoftBinYield());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getCustomerItemBo());
        ps.setString(7, data.getOperationBo());
        ps.setString(8, data.getSoftBin());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerItemBo, String operationBo, String softBin) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_customer_item_operation_softbin WHERE customer_item_bo=? AND operation_bo=? AND soft_bin=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);
      ps.setString(3, softBin);

      return ps.executeUpdate();
    }
  }

  public List<CustomerItemOperationSoftbin> selectAll() throws SQLException {
    ArrayList<CustomerItemOperationSoftbin> result = new ArrayList<CustomerItemOperationSoftbin>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<CustomerItemOperationSoftbin> selectByCustomerItemAndOperationBo(String customerItemBo, String operationBo) throws SQLException {
    ArrayList<CustomerItemOperationSoftbin> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where customer_item_bo = ? AND operation_bo=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<CustomerItemOperationSoftbin> selectByCustomerItemBo(String customerItemBo) throws SQLException {
    ArrayList<CustomerItemOperationSoftbin> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where customer_item_bo = ?")) {
      ps.setString(1, customerItemBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public CustomerItemOperationSoftbin selectByPK(String customerItemBo, String operationBo,
      String softBin) throws SQLException {
    CustomerItemOperationSoftbin result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? AND operation_bo=? AND soft_bin=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);
      ps.setString(3, softBin);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private CustomerItemOperationSoftbin convert(ResultSet rs) throws SQLException {
    CustomerItemOperationSoftbin data = new CustomerItemOperationSoftbin();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setSoftBin(rs.getString(index++));
    data.setSoftBinQty(rs.getInt(index++));
    data.setStdfTotalQty(rs.getInt(index++));
    data.setSoftBinYield(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
