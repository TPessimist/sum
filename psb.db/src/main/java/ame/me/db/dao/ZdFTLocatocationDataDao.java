package ame.me.db.dao;

import ame.me.db.ZdFTLocatocationData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class ZdFTLocatocationDataDao {

  private static final String SQL_INS = "INSERT INTO zd_ft_location_data(shop_order_bo,shop_order_name,location_data,location_state,custom1,custom2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_ft_location_data SET shop_order_name=?,location_state=?,custom1=?,custom2=?,updated_user=?,updated_time=? WHERE shop_order_bo=? AND location_data=?";

  private static final String SQL_UPD_LOCATION = "UPDATE zd_ft_location_data SET shop_order_name=?,location_data =?,location_state=?,custom1=?,custom2=?,updated_user=?,updated_time=? WHERE shop_order_bo=?";

  private static final String SQL_SEL = "SELECT shop_order_bo,shop_order_name,location_data,location_state,custom1,custom2,updated_user,updated_time FROM zd_ft_location_data ";

  private final Connection conn;

  public ZdFTLocatocationDataDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdFTLocatocationData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getShopOrderBo());
      ps.setString(2, data.getShopOrderName());
      ps.setString(3, data.getLocationData());
      ps.setString(4, data.getLocationState());
      ps.setString(5, data.getCustom1());
      ps.setString(6, data.getCustom2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdFTLocatocationData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdFTLocatocationData data : dataList) {
        ps.setString(1, data.getShopOrderBo());
        ps.setString(2, data.getShopOrderName());
        ps.setString(3, data.getLocationData());
        ps.setString(4, data.getLocationState());
        ps.setString(5, data.getCustom1());
        ps.setString(6, data.getCustom2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZdFTLocatocationData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getShopOrderName());
      ps.setString(2, data.getLocationState());
      ps.setString(3, data.getCustom1());
      ps.setString(4, data.getCustom2());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getShopOrderBo());
      ps.setString(8, data.getLocationData());

      return ps.executeUpdate();
    }
  }

  public int update1(ZdFTLocatocationData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_LOCATION)) {
      ps.setString(1, data.getShopOrderName());
      ps.setString(2, data.getLocationData());
      ps.setString(3, data.getLocationState());
      ps.setString(4, data.getCustom1());
      ps.setString(5, data.getCustom2());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getShopOrderBo());

      return ps.executeUpdate();
    }
  }

  public int updateLocation(ZdFTLocatocationData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_ft_location_data SET location_data =?,updated_user=?,updated_time=? WHERE shop_order_bo=?")) {
      ps.setString(1, data.getLocationData());
      ps.setString(2, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
      ps.setString(4, data.getShopOrderBo());
      return ps.executeUpdate();
    }
  }

  public int updateLocationCustom1(ZdFTLocatocationData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_ft_location_data SET Custom1 =?,updated_user=?,updated_time=? WHERE shop_order_bo=?")) {
      ps.setString(1, data.getCustom1());
      ps.setString(2, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
      ps.setString(4, data.getShopOrderBo());
      return ps.executeUpdate();
    }
  }

  public int update(List<ZdFTLocatocationData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZdFTLocatocationData data : dataList) {
        ps.setString(1, data.getShopOrderName());
        ps.setString(2, data.getLocationState());
        ps.setString(3, data.getCustom1());
        ps.setString(4, data.getCustom2());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getShopOrderBo());
        ps.setString(8, data.getLocationData());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String shopOrderBo, String locationData) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_ft_location_data WHERE shop_order_bo=? AND location_data=?")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, locationData);

      return ps.executeUpdate();
    }
  }

  public List<ZdFTLocatocationData> selectAll() throws SQLException {
    ArrayList<ZdFTLocatocationData> result = new ArrayList<ZdFTLocatocationData>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZdFTLocatocationData selectByPK(String shopOrderBo, String locationData)
      throws SQLException {
    ZdFTLocatocationData result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE shop_order_bo=? AND location_data=?")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, locationData);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZdFTLocatocationData> selectByLocationData(String locationData)
      throws SQLException {
    List<ZdFTLocatocationData> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE  location_data=?")) {
      ps.setString(1, locationData);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ZdFTLocatocationData selectByShopOrder(String shopOrderBo) throws SQLException {
    ZdFTLocatocationData result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order_bo=? ")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZdFTLocatocationData> select(Where where) throws SQLException {
    List<ZdFTLocatocationData> list = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convert(rs));
      }
      return list;
    }
  }

  private ZdFTLocatocationData convert(ResultSet rs) throws SQLException {
    ZdFTLocatocationData data = new ZdFTLocatocationData();

    int index = 1;
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setLocationData(rs.getString(index++));
    data.setLocationState(rs.getString(index++));
    data.setCustom1(rs.getString(index++));
    data.setCustom2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
