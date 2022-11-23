package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FTShopOrderSampleLog;
import uia.utils.dao.DateUtils;

public class FTShopOrderSampleLogDao {

  private static final String SQL_INS = "INSERT INTO zr_ft_shop_order_sample_log(uuid,shop_order,tester_type,handler_type,test_time,site_count,uph,silicon_rev,reversed_field1,reversed_field2,create_user,create_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_ft_shop_order_sample_log SET shop_order=?,tester_type=?,handler_type=?,test_time=?,site_count=?,uph=?,silicon_rev=?,reversed_field1=?,reversed_field2=?,create_user=?,create_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,shop_order,tester_type,handler_type,test_time,site_count,uph,silicon_rev,reversed_field1,reversed_field2,create_user,create_time FROM zr_ft_shop_order_sample_log ";

  private final Connection conn;

  public FTShopOrderSampleLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FTShopOrderSampleLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getShopOrder());
      ps.setString(3, data.getTesterType());
      ps.setString(4, data.getHandlerType());
      ps.setString(5, data.getTestTime());
      ps.setString(6, data.getSiteCount());
      ps.setString(7, data.getUph());
      ps.setString(8, data.getSiliconRev());
      ps.setString(9, data.getReversedField1());
      ps.setString(10, data.getReversedField2());
      ps.setString(11, data.getCreateUser());
      DateUtils.setDateTz(ps, 12, data.getCreateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FTShopOrderSampleLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FTShopOrderSampleLog data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getShopOrder());
        ps.setString(3, data.getTesterType());
        ps.setString(4, data.getHandlerType());
        ps.setString(5, data.getTestTime());
        ps.setString(6, data.getSiteCount());
        ps.setString(7, data.getUph());
        ps.setString(8, data.getSiliconRev());
        ps.setString(9, data.getReversedField1());
        ps.setString(10, data.getReversedField2());
        ps.setString(11, data.getCreateUser());
        DateUtils.setDateTz(ps, 12, data.getCreateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FTShopOrderSampleLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getShopOrder());
      ps.setString(2, data.getTesterType());
      ps.setString(3, data.getHandlerType());
      ps.setString(4, data.getTestTime());
      ps.setString(5, data.getSiteCount());
      ps.setString(6, data.getUph());
      ps.setString(7, data.getSiliconRev());
      ps.setString(8, data.getReversedField1());
      ps.setString(9, data.getReversedField2());
      ps.setString(10, data.getCreateUser());
      DateUtils.setDateTz(ps, 11, data.getCreateTime());
      ps.setString(12, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<FTShopOrderSampleLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FTShopOrderSampleLog data : dataList) {
        ps.setString(1, data.getShopOrder());
        ps.setString(2, data.getTesterType());
        ps.setString(3, data.getHandlerType());
        ps.setString(4, data.getTestTime());
        ps.setString(5, data.getSiteCount());
        ps.setString(6, data.getUph());
        ps.setString(7, data.getSiliconRev());
        ps.setString(8, data.getReversedField1());
        ps.setString(9, data.getReversedField2());
        ps.setString(10, data.getCreateUser());
        DateUtils.setDateTz(ps, 11, data.getCreateTime());
        ps.setString(12, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_ft_shop_order_sample_log WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<FTShopOrderSampleLog> selectAll() throws SQLException {
    ArrayList<FTShopOrderSampleLog> result = new ArrayList<FTShopOrderSampleLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FTShopOrderSampleLog selectByPK(String uuid) throws SQLException {
    FTShopOrderSampleLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FTShopOrderSampleLog convert(ResultSet rs) throws SQLException {
    FTShopOrderSampleLog data = new FTShopOrderSampleLog();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setTesterType(rs.getString(index++));
    data.setHandlerType(rs.getString(index++));
    data.setTestTime(rs.getString(index++));
    data.setSiteCount(rs.getString(index++));
    data.setUph(rs.getString(index++));
    data.setSiliconRev(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setCreateUser(rs.getString(index++));
    data.setCreateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
