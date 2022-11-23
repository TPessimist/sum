package ame.psb.db.dao;

import ame.psb.db.ShopOrderScheduledCompDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ShopOrderScheduledCompDateDao {

  private static final String SQL_INS = "INSERT INTO zd_shop_order_scheduled_comp_date(shop_order_bo,scheduled_comp_date,update_user,update_time) VALUES (?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_shop_order_scheduled_comp_date SET scheduled_comp_date=?,update_user=?,update_time=? WHERE shop_order_bo=?";

  private static final String SQL_SEL = "SELECT shop_order_bo,scheduled_comp_date,update_user,update_time FROM zd_shop_order_scheduled_comp_date ";

  private final Connection conn;

  public ShopOrderScheduledCompDateDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ShopOrderScheduledCompDate data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getShopOrderBo());
      DateUtils.setDateTz(ps, 2, data.getScheduledCompDate());
      ps.setString(3, data.getUpdateUser());
      DateUtils.setDateTz(ps, 4, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ShopOrderScheduledCompDate> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ShopOrderScheduledCompDate data : dataList) {
        ps.setString(1, data.getShopOrderBo());
        DateUtils.setDateTz(ps, 2, data.getScheduledCompDate());
        ps.setString(3, data.getUpdateUser());
        DateUtils.setDateTz(ps, 4, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ShopOrderScheduledCompDate data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      DateUtils.setDateTz(ps, 1, data.getScheduledCompDate());
      ps.setString(2, data.getUpdateUser());
      DateUtils.setDateTz(ps, 3, data.getUpdateTime());
      ps.setString(4, data.getShopOrderBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ShopOrderScheduledCompDate> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ShopOrderScheduledCompDate data : dataList) {
        DateUtils.setDateTz(ps, 1, data.getScheduledCompDate());
        ps.setString(2, data.getUpdateUser());
        DateUtils.setDateTz(ps, 3, data.getUpdateTime());
        ps.setString(4, data.getShopOrderBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String shopOrderBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_shop_order_scheduled_comp_date WHERE shop_order_bo=?")) {
      ps.setString(1, shopOrderBo);

      return ps.executeUpdate();
    }
  }

  public List<ShopOrderScheduledCompDate> selectAll() throws SQLException {
    ArrayList<ShopOrderScheduledCompDate> result = new ArrayList<ShopOrderScheduledCompDate>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ShopOrderScheduledCompDate selectByPK(String shopOrderBo) throws SQLException {
    ShopOrderScheduledCompDate result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order_bo=?")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ShopOrderScheduledCompDate convert(ResultSet rs) throws SQLException {
    ShopOrderScheduledCompDate data = new ShopOrderScheduledCompDate();

    int index = 1;
    data.setShopOrderBo(rs.getString(index++));
    data.setScheduledCompDate(DateUtils.getDateTz(rs, index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
