package ame.psb.db.dao;

import ame.psb.db.ZdCpLocationData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZdCpLocationDataDao {

  private static final String SQL_INS = "INSERT INTO zd_cp_location_data(uuid,sfc_bo,sfc_name,shop_order_bo,shop_order_name,operation_bo,location_data,location_state,custom1,custom2,updated_user,updated_time,carrier_bo,carrier_name) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_cp_location_data SET sfc_bo=?,sfc_name=?,shop_order_bo=?,shop_order_name=?,operation_bo=?,location_data=?,location_state=?,custom1=?,custom2=?,updated_user=?,updated_time=?,carrier_bo=?,carrier_name=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,sfc_bo,sfc_name,shop_order_bo,shop_order_name,operation_bo,location_data,location_state,custom1,custom2,updated_user,updated_time,carrier_bo,carrier_name FROM zd_cp_location_data ";

  private final Connection conn;

  public ZdCpLocationDataDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdCpLocationData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getSfcName());
      ps.setString(4, data.getShopOrderBo());
      ps.setString(5, data.getShopOrderName());
      ps.setString(6, data.getOperationBo());
      ps.setString(7, data.getLocationData());
      ps.setString(8, data.getLocationState());
      ps.setString(9, data.getCustom1());
      ps.setString(10, data.getCustom2());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
      ps.setString(13, data.getCarrierBo());
      ps.setString(14, data.getCarrierName());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdCpLocationData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdCpLocationData data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getSfcName());
        ps.setString(4, data.getShopOrderBo());
        ps.setString(5, data.getShopOrderName());
        ps.setString(6, data.getOperationBo());
        ps.setString(7, data.getLocationData());
        ps.setString(8, data.getLocationState());
        ps.setString(9, data.getCustom1());
        ps.setString(10, data.getCustom2());
        ps.setString(11, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
        ps.setString(13, data.getCarrierBo());
        ps.setString(14, data.getCarrierName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZdCpLocationData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getSfcName());
      ps.setString(3, data.getShopOrderBo());
      ps.setString(4, data.getShopOrderName());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getLocationData());
      ps.setString(7, data.getLocationState());
      ps.setString(8, data.getCustom1());
      ps.setString(9, data.getCustom2());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
      ps.setString(12, data.getCarrierBo());
      ps.setString(13, data.getCarrierName());
      ps.setString(14, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZdCpLocationData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZdCpLocationData data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getSfcName());
        ps.setString(3, data.getShopOrderBo());
        ps.setString(4, data.getShopOrderName());
        ps.setString(5, data.getOperationBo());
        ps.setString(6, data.getLocationData());
        ps.setString(7, data.getLocationState());
        ps.setString(8, data.getCustom1());
        ps.setString(9, data.getCustom2());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
        ps.setString(12, data.getCarrierBo());
        ps.setString(13, data.getCarrierName());
        ps.setString(14, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_cp_location_data WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<ZdCpLocationData> selectAll() throws SQLException {
    ArrayList<ZdCpLocationData> result = new ArrayList<ZdCpLocationData>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ZdCpLocationData selectByPK(String uuid) throws SQLException {
    ZdCpLocationData result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZdCpLocationData> selectByPKCustom1(String custom1) throws SQLException {
    List<ZdCpLocationData> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE Custom1 =? ORDER BY UPDATED_TIME DESC")) {
      ps.setString(1, custom1);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZdCpLocationData> selectByPKData(String data) throws SQLException {
    List<ZdCpLocationData> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE LOCATION_DATA =? ORDER BY UPDATED_TIME DESC ")) {
      ps.setString(1, data);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZdCpLocationData> selectByPKSfcBo(String sfcBo) throws SQLException {
    List<ZdCpLocationData> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE SFC_BO =? ORDER BY UPDATED_TIME DESC")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZdCpLocationData> selectByPKShopOrderBo(String shopOrderBo) throws SQLException {
    List<ZdCpLocationData> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE SHOP_ORDER_BO =? ORDER BY UPDATED_TIME DESC")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  /*
   * 根据载具查询
   * cc
   * */
  public List<ZdCpLocationData> selectByCarrierBo(String carrierBo) throws SQLException {
    List<ZdCpLocationData> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE carrier_bo =? ORDER BY UPDATED_TIME DESC")) {
      ps.setString(1, carrierBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ZdCpLocationData convert(ResultSet rs) throws SQLException {
    ZdCpLocationData data = new ZdCpLocationData();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setLocationData(rs.getString(index++));
    data.setLocationState(rs.getString(index++));
    data.setCustom1(rs.getString(index++));
    data.setCustom2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setCarrierBo(rs.getString(index++));
    data.setCarrierName(rs.getString(index++));

    return data;
  }
}
