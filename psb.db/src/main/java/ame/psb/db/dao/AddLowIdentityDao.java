package ame.psb.db.dao;

import ame.psb.db.AddLowIdentity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class AddLowIdentityDao {

  private static final String SQL_INS = "INSERT INTO zr_add_low_identity(handle,item_name,sfc_bo,sfc,shop_order_bo,shop_order_name,type,state,updated_user,updated_time,reverse_field2,device,customer_itemset_name) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_add_low_identity SET item_name=?,sfc_bo=?,sfc=?,shop_order_bo=?,shop_order_name=?,type=?,state=?,updated_user=?,updated_time=?,reverse_field2=?,device=?,customer_itemset_name=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,item_name,sfc_bo,sfc,shop_order_bo,shop_order_name,type,state,updated_user,updated_time,reverse_field2,device,customer_itemset_name FROM zr_add_low_identity ";

  private final Connection conn;

  public AddLowIdentityDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(AddLowIdentity data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getItemName());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getSfc());
      ps.setString(5, data.getShopOrderBo());
      ps.setString(6, data.getShopOrderName());
      ps.setString(7, data.getType());
      ps.setString(8, data.getState());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
      ps.setString(11, data.getReverseField2());
      ps.setString(12, data.getDevice());
      ps.setString(13, data.getCustomerItemsetName());

      return ps.executeUpdate();
    }
  }

  public int insert(List<AddLowIdentity> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (AddLowIdentity data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getItemName());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getSfc());
        ps.setString(5, data.getShopOrderBo());
        ps.setString(6, data.getShopOrderName());
        ps.setString(7, data.getType());
        ps.setString(8, data.getState());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
        ps.setString(11, data.getReverseField2());
        ps.setString(12, data.getDevice());
        ps.setString(13, data.getCustomerItemsetName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(AddLowIdentity data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemName());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getSfc());
      ps.setString(4, data.getShopOrderBo());
      ps.setString(5, data.getShopOrderName());
      ps.setString(6, data.getType());
      ps.setString(7, data.getState());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getReverseField2());
      ps.setString(11, data.getDevice());
      ps.setString(12, data.getCustomerItemsetName());
      ps.setString(13, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<AddLowIdentity> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (AddLowIdentity data : dataList) {
        ps.setString(1, data.getItemName());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getSfc());
        ps.setString(4, data.getShopOrderBo());
        ps.setString(5, data.getShopOrderName());
        ps.setString(6, data.getType());
        ps.setString(7, data.getState());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getReverseField2());
        ps.setString(11, data.getDevice());
        ps.setString(12, data.getCustomerItemsetName());
        ps.setString(13, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_add_low_identity WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<AddLowIdentity> selectAll() throws SQLException {
    ArrayList<AddLowIdentity> result = new ArrayList<AddLowIdentity>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public AddLowIdentity selectByPK(String handle) throws SQLException {
    AddLowIdentity result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public AddLowIdentity selectByState(String handle, String state) throws SQLException {
    AddLowIdentity result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE handle=? and state=? ")) {
      ps.setString(1, handle);
      ps.setString(2, state);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<AddLowIdentity> selectByShopOrder(String shopOrderBo) throws SQLException {
    ArrayList<AddLowIdentity> result = new ArrayList<AddLowIdentity>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where shop_order_bo= ?")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public AddLowIdentity selectByItemName(String itemName) throws SQLException {
    AddLowIdentity result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_name=? order by updated_time desc ")) {
      ps.setString(1, itemName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private AddLowIdentity convert(ResultSet rs) throws SQLException {
    AddLowIdentity data = new AddLowIdentity();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setType(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setReverseField2(rs.getString(index++));
    data.setDevice(rs.getString(index++));
    data.setCustomerItemsetName(rs.getString(index++));

    return data;
  }
}
