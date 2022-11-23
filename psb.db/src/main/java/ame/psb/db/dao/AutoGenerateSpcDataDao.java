package ame.psb.db.dao;

import ame.psb.db.AutoGenerateSpcData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class AutoGenerateSpcDataDao {

  private static final String SQL_INS = "INSERT INTO zd_auto_generate_spc_data(shop_order_bo,shop_order_name,dcop_bo,cycle_time,remarks1,remarks2,remarks3,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_auto_generate_spc_data SET shop_order_bo =? , shop_order_name=?,dcop_bo=?,cycle_time=?,remarks1=?,remarks2=?,remarks3=?,updated_user=?,updated_time=? WHERE shop_order_bo=? and  dcop_bo = ?";

  private static final String SQL_SEL = "SELECT shop_order_bo,shop_order_name,dcop_bo,cycle_time,remarks1,remarks2,remarks3,updated_user,updated_time FROM zd_auto_generate_spc_data ";

  private final Connection conn;

  public AutoGenerateSpcDataDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(AutoGenerateSpcData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getShopOrderBo());
      ps.setString(2, data.getShopOrderName());
      ps.setString(3, data.getDcopBo());
      ps.setBigDecimal(4, data.getCycleTime());
      ps.setString(5, data.getRemarks1());
      ps.setString(6, data.getRemarks2());
      ps.setString(7, data.getRemarks3());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<AutoGenerateSpcData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (AutoGenerateSpcData data : dataList) {
        ps.setString(1, data.getShopOrderBo());
        ps.setString(2, data.getShopOrderName());
        ps.setString(3, data.getDcopBo());
        ps.setBigDecimal(4, data.getCycleTime());
        ps.setString(5, data.getRemarks1());
        ps.setString(6, data.getRemarks2());
        ps.setString(7, data.getRemarks3());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getShopOrderBo());
        ps.setString(11, data.getDcopBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(AutoGenerateSpcData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getShopOrderBo());
      ps.setString(2, data.getShopOrderName());
      ps.setString(3, data.getDcopBo());
      ps.setBigDecimal(4, data.getCycleTime());
      ps.setString(5, data.getRemarks1());
      ps.setString(6, data.getRemarks2());
      ps.setString(7, data.getRemarks3());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getShopOrderBo());
      ps.setString(11, data.getDcopBo());
      return ps.executeUpdate();
    }
  }

  public int update(List<AutoGenerateSpcData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (AutoGenerateSpcData data : dataList) {
        ps.setString(1, data.getShopOrderBo());
        ps.setString(2, data.getShopOrderName());
        ps.setString(3, data.getDcopBo());
        ps.setBigDecimal(4, data.getCycleTime());
        ps.setString(5, data.getRemarks1());
        ps.setString(6, data.getRemarks2());
        ps.setString(7, data.getRemarks3());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String shopOrderBo, String dcopBo, String remarks1) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_auto_generate_spc_data WHERE shop_order_bo=? and dcop_Bo = ? and remarks1 = ? ")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, dcopBo);
      ps.setString(3, remarks1);

      return ps.executeUpdate();
    }
  }

  public List<AutoGenerateSpcData> selectAll() throws SQLException {
    ArrayList<AutoGenerateSpcData> result = new ArrayList<AutoGenerateSpcData>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<AutoGenerateSpcData> selectByPK(String shopOrderBo) throws SQLException {
    List<AutoGenerateSpcData> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order_bo=?")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<AutoGenerateSpcData> selectByShopOrderBoAndDcopBo(String shopOrderBo, String dcopBo)
      throws SQLException {
    List<AutoGenerateSpcData> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE shop_order_bo=? and dcop_Bo = ? ")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, dcopBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<AutoGenerateSpcData> deleteByShopOrderBoAndDcopBo(String shopOrderBo, String dcopBo,
      String remarks1) throws SQLException {
    List<AutoGenerateSpcData> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE shop_order_bo=? and dcop_Bo = ? and remarks1 = ?")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, dcopBo);
      ps.setString(3, remarks1);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private AutoGenerateSpcData convert(ResultSet rs) throws SQLException {
    AutoGenerateSpcData data = new AutoGenerateSpcData();

    int index = 1;
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setDcopBo(rs.getString(index++));
    data.setCycleTime(rs.getBigDecimal(index++));
    data.setRemarks1(rs.getString(index++));
    data.setRemarks2(rs.getString(index++));
    data.setRemarks3(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
