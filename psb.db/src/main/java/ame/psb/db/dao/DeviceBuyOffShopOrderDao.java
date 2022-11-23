package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.DeviceBuyOffShopOrder;
import uia.utils.dao.DateUtils;

public class DeviceBuyOffShopOrderDao {

  private static final String SQL_INS = "INSERT INTO zr_device_buyoff_shop_order(item_group_bo,shop_order_bo,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_device_buyoff_shop_order SET item_group_bo=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE shop_order_bo=?";

  private static final String SQL_SEL = "SELECT item_group_bo,shop_order_bo,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_device_buyoff_shop_order ";

  private final Connection conn;

  public DeviceBuyOffShopOrderDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DeviceBuyOffShopOrder data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getShopOrderBo());
      ps.setString(3, data.getReversedField1());
      ps.setString(4, data.getReversedField2());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DeviceBuyOffShopOrder> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DeviceBuyOffShopOrder data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getShopOrderBo());
        ps.setString(3, data.getReversedField1());
        ps.setString(4, data.getReversedField2());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DeviceBuyOffShopOrder data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getReversedField1());
      ps.setString(3, data.getReversedField2());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getShopOrderBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<DeviceBuyOffShopOrder> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DeviceBuyOffShopOrder data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getReversedField1());
        ps.setString(3, data.getReversedField2());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getShopOrderBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String shopOrderBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_device_buyoff_shop_order WHERE shop_order_bo=?")) {
      ps.setString(1, shopOrderBo);

      return ps.executeUpdate();
    }
  }

  public List<DeviceBuyOffShopOrder> selectAll() throws SQLException {
    ArrayList<DeviceBuyOffShopOrder> result = new ArrayList<DeviceBuyOffShopOrder>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public DeviceBuyOffShopOrder selectByPK(String shopOrderBo) throws SQLException {
    DeviceBuyOffShopOrder result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order_bo=?")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<DeviceBuyOffShopOrder> selectByPKByItemGroupBo(String itemGroupBo)
      throws SQLException {
    List<DeviceBuyOffShopOrder> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO=?")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public DeviceBuyOffShopOrder selectByPKByItemGroupBo(String itemGroupBo, String shopOrderBo)
      throws SQLException {
    DeviceBuyOffShopOrder result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO=? and shop_order_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, shopOrderBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private DeviceBuyOffShopOrder convert(ResultSet rs) throws SQLException {
    DeviceBuyOffShopOrder data = new DeviceBuyOffShopOrder();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
