package ame.psb.db.dao;

import ame.psb.db.SplitDieContainerCount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SplitDieContainerCountDao {

  private static final String SQL_INS = "INSERT INTO zr_split_die_container_count(customer_device,customer_itemset_name,shop_order_bo,shop_order_name,container_bo,customer,split_die,marking_code,update_user,update_time,reverse_field1,reverse_field2,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_split_die_container_count SET shop_order_name=?,container_bo=?,customer=?,split_die=?,marking_code=?,update_user=?,update_time=?,reverse_field1=?,reverse_field2=?,status=? WHERE customer_device=? AND customer_itemset_name=? AND shop_order_bo=?";

  private static final String SQL_SEL = "SELECT customer_device,customer_itemset_name,shop_order_bo,shop_order_name,container_bo,customer,split_die,marking_code,update_user,update_time,reverse_field1,reverse_field2,status FROM zr_split_die_container_count ";

  private final Connection conn;

  public SplitDieContainerCountDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SplitDieContainerCount data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerDevice());
      ps.setString(2, data.getCustomerItemsetName());
      ps.setString(3, data.getShopOrderBo());
      ps.setString(4, data.getShopOrderName());
      ps.setString(5, data.getContainerBo());
      ps.setString(6, data.getCustomer());
      ps.setString(7, data.getSplitDie());
      ps.setString(8, data.getMarkingCode());
      ps.setString(9, data.getUpdateUser());
      DateUtils.setDateTz(ps, 10, data.getUpdateTime());
      ps.setString(11, data.getReverseField1());
      ps.setString(12, data.getReverseField2());
      ps.setString(13, data.getStatus());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SplitDieContainerCount> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SplitDieContainerCount data : dataList) {
        ps.setString(1, data.getCustomerDevice());
        ps.setString(2, data.getCustomerItemsetName());
        ps.setString(3, data.getShopOrderBo());
        ps.setString(4, data.getShopOrderName());
        ps.setString(5, data.getContainerBo());
        ps.setString(6, data.getCustomer());
        ps.setString(7, data.getSplitDie());
        ps.setString(8, data.getMarkingCode());
        ps.setString(9, data.getUpdateUser());
        DateUtils.setDateTz(ps, 10, data.getUpdateTime());
        ps.setString(11, data.getReverseField1());
        ps.setString(12, data.getReverseField2());
        ps.setString(13, data.getStatus());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SplitDieContainerCount data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getShopOrderName());
      ps.setString(2, data.getContainerBo());
      ps.setString(3, data.getCustomer());
      ps.setString(4, data.getSplitDie());
      ps.setString(5, data.getMarkingCode());
      ps.setString(6, data.getUpdateUser());
      DateUtils.setDateTz(ps, 7, data.getUpdateTime());
      ps.setString(8, data.getReverseField1());
      ps.setString(9, data.getReverseField2());
      ps.setString(10, data.getStatus());
      ps.setString(11, data.getCustomerDevice());
      ps.setString(12, data.getCustomerItemsetName());
      ps.setString(13, data.getShopOrderBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<SplitDieContainerCount> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SplitDieContainerCount data : dataList) {
        ps.setString(1, data.getShopOrderName());
        ps.setString(2, data.getContainerBo());
        ps.setString(3, data.getCustomer());
        ps.setString(4, data.getSplitDie());
        ps.setString(5, data.getMarkingCode());
        ps.setString(6, data.getUpdateUser());
        DateUtils.setDateTz(ps, 7, data.getUpdateTime());
        ps.setString(8, data.getReverseField1());
        ps.setString(9, data.getReverseField2());
        ps.setString(10, data.getStatus());
        ps.setString(11, data.getCustomerDevice());
        ps.setString(12, data.getCustomerItemsetName());
        ps.setString(13, data.getShopOrderBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateStatusByDeviceAndItemsetNameAndshopOrder(String status, String customerDevice,
      String customerItemsetName,
      String shopOrderBo)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_split_die_container_count SET status=? WHERE customer_device=? AND customer_itemset_name=? AND shop_order_bo=?")) {
      ps.setString(1, status);
      ps.setString(2, customerDevice);
      ps.setString(3, customerItemsetName);
      ps.setString(4, shopOrderBo);

      return ps.executeUpdate();
    }
  }

  public int delete(String customerDevice, String customerItemsetName, String shopOrderBo)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_split_die_container_count WHERE customer_device=? AND customer_itemset_name=? AND shop_order_bo=?")) {
      ps.setString(1, customerDevice);
      ps.setString(2, customerItemsetName);
      ps.setString(3, shopOrderBo);

      return ps.executeUpdate();
    }
  }

  public List<SplitDieContainerCount> selectAll() throws SQLException {
    ArrayList<SplitDieContainerCount> result = new ArrayList<SplitDieContainerCount>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public SplitDieContainerCount selectSplitByPK(String customerDevice, String customerItemsetName,
      String shopOrderBo, int splitDieNum) throws SQLException {
    SplitDieContainerCount result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "WHERE customer_device=? AND customer_itemset_name=? AND shop_order_bo=? AND SPLIT_DIE=?")) {
      ps.setString(1, customerDevice);
      ps.setString(2, customerItemsetName);
      ps.setString(3, shopOrderBo);
      ps.setInt(4, splitDieNum);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public SplitDieContainerCount selectByPK(String customerDevice, String customerItemsetName,
      String shopOrderBo) throws SQLException {
    SplitDieContainerCount result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE customer_device=? AND customer_itemset_name=? AND shop_order_bo=?")) {
      ps.setString(1, customerDevice);
      ps.setString(2, customerItemsetName);
      ps.setString(3, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  //根据客户机种查询
  public List<SplitDieContainerCount> selectByCustomerDevice(String customerDevice)
      throws SQLException {
    ArrayList<SplitDieContainerCount> result = new ArrayList<SplitDieContainerCount>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_device=? order by update_time desc ")) {
      ps.setString(1, customerDevice);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  //根据客户机种查询
  public List<SplitDieContainerCount> selectByDeviceAndStatus(String customerDevice, String status)
      throws SQLException {
    ArrayList<SplitDieContainerCount> result = new ArrayList<SplitDieContainerCount>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE customer_device=? and status=? order by update_time desc ")) {
      ps.setString(1, customerDevice);
      ps.setString(2, status);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public SplitDieContainerCount selectByDeviceAndItemsetName(String customerDevice,
      String customerItemsetName)
      throws SQLException {
    SplitDieContainerCount result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE customer_device=? AND customer_itemset_name=? ")) {
      ps.setString(1, customerDevice);
      ps.setString(2, customerItemsetName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SplitDieContainerCount convert(ResultSet rs) throws SQLException {
    SplitDieContainerCount data = new SplitDieContainerCount();

    int index = 1;
    data.setCustomerDevice(rs.getString(index++));
    data.setCustomerItemsetName(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setContainerBo(rs.getString(index++));
    data.setCustomer(rs.getString(index++));
    data.setSplitDie(rs.getString(index++));
    data.setMarkingCode(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setReverseField1(rs.getString(index++));
    data.setReverseField2(rs.getString(index++));
    data.setStatus(rs.getString(index++));

    return data;
  }
}
