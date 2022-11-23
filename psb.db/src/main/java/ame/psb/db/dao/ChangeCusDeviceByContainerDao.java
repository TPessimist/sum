package ame.psb.db.dao;

import ame.psb.db.ChangeCusDeviceByContainer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ChangeCusDeviceByContainerDao {

  private static final String SQL_INS = "INSERT INTO zd_change_cust_device_by_container(id,old_customer_device,new_customer_device,sfc_bo,shop_order_bo,sfc_name,shop_order_name,update_user,update_time,reversed_field1,reversed_field2) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_change_cust_device_by_container SET old_customer_device=?,new_customer_device=?,sfc_bo=?,shop_order_bo=?,sfc_name=?,shop_order_name=?,update_user=?,update_time=?,reversed_field1=?,reversed_field2=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,old_customer_device,new_customer_device,sfc_bo,shop_order_bo,sfc_name,shop_order_name,update_user,update_time,reversed_field1,reversed_field2 FROM zd_change_cust_device_by_container ";

  private final Connection conn;

  public ChangeCusDeviceByContainerDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ChangeCusDeviceByContainer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getOldCustomerDevice());
      ps.setString(3, data.getNewCustomerDevice());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getShopOrderBo());
      ps.setString(6, data.getSfcName());
      ps.setString(7, data.getShopOrderName());
      ps.setString(8, data.getUpdateUser());
      DateUtils.setDateTz(ps, 9, data.getUpdateTime());
      ps.setString(10, data.getReversedField1());
      ps.setString(11, data.getReversedField2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ChangeCusDeviceByContainer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ChangeCusDeviceByContainer data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getOldCustomerDevice());
        ps.setString(3, data.getNewCustomerDevice());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getShopOrderBo());
        ps.setString(6, data.getSfcName());
        ps.setString(7, data.getShopOrderName());
        ps.setString(8, data.getUpdateUser());
        DateUtils.setDateTz(ps, 9, data.getUpdateTime());
        ps.setString(10, data.getReversedField1());
        ps.setString(11, data.getReversedField2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ChangeCusDeviceByContainer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getOldCustomerDevice());
      ps.setString(2, data.getNewCustomerDevice());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getShopOrderBo());
      ps.setString(5, data.getSfcName());
      ps.setString(6, data.getShopOrderName());
      ps.setString(7, data.getUpdateUser());
      DateUtils.setDateTz(ps, 8, data.getUpdateTime());
      ps.setString(9, data.getReversedField1());
      ps.setString(10, data.getReversedField2());
      ps.setString(11, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ChangeCusDeviceByContainer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ChangeCusDeviceByContainer data : dataList) {
        ps.setString(1, data.getOldCustomerDevice());
        ps.setString(2, data.getNewCustomerDevice());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getShopOrderBo());
        ps.setString(5, data.getSfcName());
        ps.setString(6, data.getShopOrderName());
        ps.setString(7, data.getUpdateUser());
        DateUtils.setDateTz(ps, 8, data.getUpdateTime());
        ps.setString(9, data.getReversedField1());
        ps.setString(10, data.getReversedField2());
        ps.setString(11, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_change_cust_device_by_container WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ChangeCusDeviceByContainer> selectAll() throws SQLException {
    ArrayList<ChangeCusDeviceByContainer> result = new ArrayList<ChangeCusDeviceByContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ChangeCusDeviceByContainer selectByPK(String id) throws SQLException {
    ChangeCusDeviceByContainer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ChangeCusDeviceByContainer convert(ResultSet rs) throws SQLException {
    ChangeCusDeviceByContainer data = new ChangeCusDeviceByContainer();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setOldCustomerDevice(rs.getString(index++));
    data.setNewCustomerDevice(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));

    return data;
  }
}
