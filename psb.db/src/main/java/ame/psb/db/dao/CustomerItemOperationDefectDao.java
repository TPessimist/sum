package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.CustomerItemOperationDefect;
import ame.psb.db.ViewCustomerItemDefect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CustomerItemOperationDefectDao {

  private static final String SQL_INS = "INSERT INTO zr_customer_item_operation_defect(customer_item_bo,operation_bo,nc_code_bo,nc_value,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_customer_item_operation_defect SET nc_value=?,updated_user=?,updated_time=? WHERE customer_item_bo=? AND operation_bo=? AND nc_code_bo=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,operation_bo,nc_code_bo,nc_value,updated_user,updated_time FROM zr_customer_item_operation_defect ";

  private static final String SQL_SEL_ORIG = "SELECT a.customer_item_bo,a.operation_bo, a.nc_code_bo,a.nc_value,b.description, a.updated_time FROM  zr_customer_item_operation_defect a INNER JOIN NC_CODE b ON a.NC_CODE_BO = b.HANDLE ";

  private static final String SQL_SEL_OPE = "SELECT a.customer_item_bo, a.nc_code_bo,a.nc_value,b.description FROM  zr_customer_item_operation_defect a INNER JOIN NC_CODE b ON a.NC_CODE_BO = b.HANDLE ";


  private final Connection conn;

  public CustomerItemOperationDefectDao(Connection conn) {
    this.conn = conn;
  }

  public int insertOrUpdate(CustomerItemOperationDefect data) throws SQLException {
    CustomerItemOperationDefect customerItemOperationDefect = selectByPK(data.getCustomerItemBo(),
        data.getOperationBo(), data.getNcCodeBo());
    if (null == customerItemOperationDefect) {
      return insert(data);
    } else {
      return update(data);
    }
  }


  public int insert(CustomerItemOperationDefect data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getNcCodeBo());
      ps.setBigDecimal(4, data.getNcValue());
      ps.setString(5, data.getUpdatedUser());
      ps.setTimestamp(6, new Timestamp(data.getUpdatedTime().getTime()));

      return ps.executeUpdate();
    }
  }


  public int insert(List<CustomerItemOperationDefect> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CustomerItemOperationDefect data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getNcCodeBo());
        ps.setBigDecimal(4, data.getNcValue());
        ps.setString(5, data.getUpdatedUser());
        ps.setTimestamp(6, new Timestamp(data.getUpdatedTime().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CustomerItemOperationDefect data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getNcValue());
      ps.setString(2, data.getUpdatedUser());
      ps.setTimestamp(3, new Timestamp(data.getUpdatedTime().getTime()));
      ps.setString(4, data.getCustomerItemBo());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getNcCodeBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<CustomerItemOperationDefect> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CustomerItemOperationDefect data : dataList) {
        ps.setBigDecimal(1, data.getNcValue());
        ps.setString(2, data.getUpdatedUser());
        ps.setTimestamp(3, new Timestamp(data.getUpdatedTime().getTime()));
        ps.setString(4, data.getCustomerItemBo());
        ps.setString(5, data.getOperationBo());
        ps.setString(6, data.getNcCodeBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerItemBo, String operationBo, String ncCodeBo)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_customer_item_operation_defect WHERE customer_item_bo=? AND operation_bo=? AND nc_code_bo=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);
      ps.setString(3, ncCodeBo);

      return ps.executeUpdate();
    }
  }

  public int delete(String customerItemBo, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_customer_item_operation_defect WHERE customer_item_bo=? AND operation_bo=? ")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);

      return ps.executeUpdate();
    }
  }

  public List<CustomerItemOperationDefect> selectAll() throws SQLException {
    ArrayList<CustomerItemOperationDefect> result = new ArrayList<CustomerItemOperationDefect>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<CustomerItemOperationDefect> selectByBatchId(String batchId, String operationBo)
      throws SQLException {
    ArrayList<CustomerItemOperationDefect> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_ORIG + "WHERE customer_item_bo=? and operation_Bo = ? ORDER BY nc_code_bo")) {
      ps.setString(1, batchId);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewCustomerItemDefect> selectByItemAndOperation(String id, String operationBo)
      throws SQLException {
    ArrayList<ViewCustomerItemDefect> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_OPE + "WHERE customer_item_bo=? and operation_Bo = ? ORDER BY nc_code_bo")) {
      ps.setString(1, id);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert2(rs));
      }
      return result;
    }
  }

  public List<ViewCustomerItemDefect> selectByItemInOperation(String id) throws SQLException {
    ArrayList<ViewCustomerItemDefect> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_OPE
            + "WHERE customer_item_bo=? and operation_Bo in('OperationBO:1020,CBG-BGT,#','OperationBO:1020,CBG-WMI,#','OperationBO:1020,CDS-2OI,#') ORDER BY nc_code_bo")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert2(rs));
      }
      return result;
    }
  }

  public CustomerItemOperationDefect selectByPK(String customerItemBo, String operationBo,
      String ncCodeBo) throws SQLException {
    CustomerItemOperationDefect result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE customer_item_bo=? AND operation_bo=? AND nc_code_bo=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);
      ps.setString(3, ncCodeBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<CustomerItemOperationDefect> selectOperationDefect(String customerItemBo,
      String operationBo) throws SQLException {
    ArrayList<CustomerItemOperationDefect> result = new ArrayList<CustomerItemOperationDefect>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? AND operation_bo=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<CustomerItemOperationDefect> selectCustomerItemDefect(String customerItemBo)
      throws SQLException {
    ArrayList<CustomerItemOperationDefect> result = new ArrayList<CustomerItemOperationDefect>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE customer_item_bo=? ")) {
      ps.setString(1, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  private CustomerItemOperationDefect convert(ResultSet rs) throws SQLException {
    CustomerItemOperationDefect data = new CustomerItemOperationDefect();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setNcCodeBo(rs.getString(index++));
    data.setNcValue(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(rs.getTimestamp(index++));

    return data;
  }

  private ViewCustomerItemDefect convert2(ResultSet rs) throws SQLException {
    ViewCustomerItemDefect data = new ViewCustomerItemDefect();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setNcCodeBo(rs.getString(index++));
    data.setNcValue(rs.getInt(index++));
    data.setDescription(rs.getString(index++));
    data.setNcCode(Env.trimHandle(data.getNcCodeBo()));
    return data;
  }

}
