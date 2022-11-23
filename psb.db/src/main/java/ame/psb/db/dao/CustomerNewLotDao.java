package ame.psb.db.dao;

import ame.psb.db.CustomerNewLot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CustomerNewLotDao {

  private static final String SQL_INS = "INSERT INTO zr_customer_new_lot(id,shop_order_bo,customer_itemset_bo,operation_bo,die_qty,new_lot,state,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_customer_new_lot SET shop_order_bo=?,customer_itemset_bo=?,operation_bo=?,die_qty=?,new_lot=?,state=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,shop_order_bo,customer_itemset_bo,operation_bo,die_qty,new_lot,state,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_customer_new_lot ";

  private final Connection conn;

  public CustomerNewLotDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CustomerNewLot data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getShopOrderBo());
      ps.setString(3, data.getCustomerItemsetBo());
      ps.setString(4, data.getOperationBo());
      ps.setBigDecimal(5, data.getDieQty());
      ps.setString(6, data.getNewLot());
      ps.setString(7, data.getState());
      ps.setString(8, data.getReversedField1());
      ps.setString(9, data.getReversedField2());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CustomerNewLot> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CustomerNewLot data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getShopOrderBo());
        ps.setString(3, data.getCustomerItemsetBo());
        ps.setString(4, data.getOperationBo());
        ps.setBigDecimal(5, data.getDieQty());
        ps.setString(6, data.getNewLot());
        ps.setString(7, data.getState());
        ps.setString(8, data.getReversedField1());
        ps.setString(9, data.getReversedField2());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CustomerNewLot data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getShopOrderBo());
      ps.setString(2, data.getCustomerItemsetBo());
      ps.setString(3, data.getOperationBo());
      ps.setBigDecimal(4, data.getDieQty());
      ps.setString(5, data.getNewLot());
      ps.setString(6, data.getState());
      ps.setString(7, data.getReversedField1());
      ps.setString(8, data.getReversedField2());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
      ps.setString(11, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<CustomerNewLot> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CustomerNewLot data : dataList) {
        ps.setString(1, data.getShopOrderBo());
        ps.setString(2, data.getCustomerItemsetBo());
        ps.setString(3, data.getOperationBo());
        ps.setBigDecimal(4, data.getDieQty());
        ps.setString(5, data.getNewLot());
        ps.setString(6, data.getState());
        ps.setString(7, data.getReversedField1());
        ps.setString(8, data.getReversedField2());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
        ps.setString(11, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_customer_new_lot WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<CustomerNewLot> selectAll() throws SQLException {
    ArrayList<CustomerNewLot> result = new ArrayList<CustomerNewLot>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public CustomerNewLot selectByPK(String id) throws SQLException {
    CustomerNewLot result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public List<CustomerNewLot> selectByLotAndNewLot(String customerIemSetBo, String newLot)
      throws SQLException {
    ArrayList<CustomerNewLot> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE CUSTOMER_ITEMSET_BO = ? AND NEW_LOT = ? ")) {
      ps.setString(1, customerIemSetBo);
      ps.setString(2, newLot);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public CustomerNewLot selectByShopOrderAndOperation(String shopOrderBo, String operationBo)
      throws SQLException {
    CustomerNewLot result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE SHOP_ORDER_BO = ? AND OPERATION_BO = ? AND REVERSED_FIELD1 = 'MTK_NEW_LOT' ")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public CustomerNewLot selectByShopOrderAndItemSetAndOperation(String shopOrderBo,
      String customerItemSetBo, String operationBo) throws SQLException {
    CustomerNewLot result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE SHOP_ORDER_BO = ? AND CUSTOMER_ITEMSET_BO = ? AND OPERATION_BO = ? AND REVERSED_FIELD1 = 'MTK_NEW_LOT' ")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, customerItemSetBo);
      ps.setString(3, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public CustomerNewLot selectMtkWaitInfo() throws SQLException {
    CustomerNewLot result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE REVERSED_FIELD1 = 'MTK_NEW_LOT' AND STATE = 'WAIT' ORDER BY UPDATED_TIME ASC ")) {

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private CustomerNewLot convert(ResultSet rs) throws SQLException {
    CustomerNewLot data = new CustomerNewLot();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setCustomerItemsetBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDieQty(rs.getBigDecimal(index++));
    data.setNewLot(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
