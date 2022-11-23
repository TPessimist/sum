package ame.sap.db.dao;

import ame.psb.db.FtAT34SelfCheckLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FtAT34SelfCheckLogDao {

  private static final String SQL_INS = "INSERT INTO zr_ft_at34_self_check_log(id,shop_order_name,response_code,response_message,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_ft_at34_self_check_log SET shop_order_name=?,response_code=?,response_message=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,shop_order_name,response_code,response_message,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_ft_at34_self_check_log ";

  private final Connection conn;

  public FtAT34SelfCheckLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FtAT34SelfCheckLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getShopOrderName());
      ps.setString(3, data.getResponseCode());
      ps.setString(4, data.getResponseMessage());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FtAT34SelfCheckLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FtAT34SelfCheckLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getShopOrderName());
        ps.setString(3, data.getResponseCode());
        ps.setString(4, data.getResponseMessage());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FtAT34SelfCheckLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getShopOrderName());
      ps.setString(2, data.getResponseCode());
      ps.setString(3, data.getResponseMessage());
      ps.setString(4, data.getReversedField1());
      ps.setString(5, data.getReversedField2());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FtAT34SelfCheckLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FtAT34SelfCheckLog data : dataList) {
        ps.setString(1, data.getShopOrderName());
        ps.setString(2, data.getResponseCode());
        ps.setString(3, data.getResponseMessage());
        ps.setString(4, data.getReversedField1());
        ps.setString(5, data.getReversedField2());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_ft_at34_self_check_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<FtAT34SelfCheckLog> selectAll() throws SQLException {
    ArrayList<FtAT34SelfCheckLog> result = new ArrayList<FtAT34SelfCheckLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FtAT34SelfCheckLog> selectByShopOrderName(String x) throws SQLException {
    ArrayList<FtAT34SelfCheckLog> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where shop_order_name = ?")) {
      ps.setString(1, x);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<FtAT34SelfCheckLog> selectByShopOrderNameAndCode(String sp, String code)
      throws SQLException {
    ArrayList<FtAT34SelfCheckLog> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where shop_order_name = ? and RESPONSE_CODE = ?")) {
      ps.setString(1, sp);
      ps.setString(2, code);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FtAT34SelfCheckLog selectByPK(String id) throws SQLException {
    FtAT34SelfCheckLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FtAT34SelfCheckLog convert(ResultSet rs) throws SQLException {
    FtAT34SelfCheckLog data = new FtAT34SelfCheckLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setResponseCode(rs.getString(index++));
    data.setResponseMessage(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
