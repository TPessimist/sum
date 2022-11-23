package ame.psb.db.dao;

import ame.psb.db.FtTailStorage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FtTailStorageDao {

  private static final String SQL_INS = "INSERT INTO zd_ft_tail_storage(shop_order_bo,sfc_bo,tail_qty,tail_location,tail_customer_device,tail_state,reversed_field1,reversed_field2,updated_time,updated_user) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_ft_tail_storage SET sfc_bo=?,tail_qty=?,tail_location=?,tail_customer_device=?,tail_state=?,reversed_field1=?,reversed_field2=?,updated_time=?,updated_user=? WHERE shop_order_bo=?";

  private static final String SQL_SEL = "SELECT shop_order_bo,sfc_bo,tail_qty,tail_location,tail_customer_device,tail_state,reversed_field1,reversed_field2,updated_time,updated_user FROM zd_ft_tail_storage ";

  private final Connection conn;

  public FtTailStorageDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FtTailStorage data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getShopOrderBo());
      ps.setString(2, data.getSfcBo());
      ps.setBigDecimal(3, data.getTailQty());
      ps.setString(4, data.getTailLocation());
      ps.setString(5, data.getTailCustomerDevice());
      ps.setString(6, data.getTailState());
      ps.setString(7, data.getReversedField1());
      ps.setString(8, data.getReversedField2());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getUpdatedUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FtTailStorage> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FtTailStorage data : dataList) {
        ps.setString(1, data.getShopOrderBo());
        ps.setString(2, data.getSfcBo());
        ps.setBigDecimal(3, data.getTailQty());
        ps.setString(4, data.getTailLocation());
        ps.setString(5, data.getTailCustomerDevice());
        ps.setString(6, data.getTailState());
        ps.setString(7, data.getReversedField1());
        ps.setString(8, data.getReversedField2());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getUpdatedUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FtTailStorage data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setBigDecimal(2, data.getTailQty());
      ps.setString(3, data.getTailLocation());
      ps.setString(4, data.getTailCustomerDevice());
      ps.setString(5, data.getTailState());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getUpdatedUser());
      ps.setString(10, data.getShopOrderBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<FtTailStorage> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FtTailStorage data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setBigDecimal(2, data.getTailQty());
        ps.setString(3, data.getTailLocation());
        ps.setString(4, data.getTailCustomerDevice());
        ps.setString(5, data.getTailState());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getUpdatedUser());
        ps.setString(10, data.getShopOrderBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String shopOrderBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_ft_tail_storage WHERE shop_order_bo=?")) {
      ps.setString(1, shopOrderBo);

      return ps.executeUpdate();
    }
  }

  public List<FtTailStorage> selectAll() throws SQLException {
    ArrayList<FtTailStorage> result = new ArrayList<FtTailStorage>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FtTailStorage> selectByCustomerDevice(String customerDevice) throws SQLException {
    ArrayList<FtTailStorage> result = new ArrayList<FtTailStorage>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "  WHERE TAIL_CUSTOMER_DEVICE = ?  ")) {
      ps.setString(1, customerDevice);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FtTailStorage> selectByCustomerDeviceExcludeShopOrder(String customerDevice,
      String shopOrderBo) throws SQLException {
    ArrayList<FtTailStorage> result = new ArrayList<FtTailStorage>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "  WHERE TAIL_CUSTOMER_DEVICE = ? and SHOP_ORDER_BO != ? and TAIL_STATE = 'ENABLE'  ")) {
      ps.setString(1, customerDevice);
      ps.setString(2, shopOrderBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FtTailStorage> selectByLocation(String location) throws SQLException {
    ArrayList<FtTailStorage> result = new ArrayList<FtTailStorage>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "  WHERE TAIL_LOCATION = ? and TAIL_STATE = 'ENABLE'  ")) {
      ps.setString(1, location);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public FtTailStorage selectByPK(String shopOrderBo) throws SQLException {
    FtTailStorage result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order_bo=?")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FtTailStorage convert(ResultSet rs) throws SQLException {
    FtTailStorage data = new FtTailStorage();

    int index = 1;
    data.setShopOrderBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setTailQty(rs.getBigDecimal(index++));
    data.setTailLocation(rs.getString(index++));
    data.setTailCustomerDevice(rs.getString(index++));
    data.setTailState(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));

    return data;
  }
}
