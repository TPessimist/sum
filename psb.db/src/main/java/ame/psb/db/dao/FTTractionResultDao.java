package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FTTractionResult;
import uia.utils.dao.DateUtils;

public class FTTractionResultDao {

  private static final String SQL_INS = "INSERT INTO zd_ft_traction_result(sfc_bo,sfc,shop_order_bo,shop_order_name,result,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_ft_traction_result SET sfc=?,shop_order_bo=?,shop_order_name=?,result=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE sfc_bo=?";

  private static final String SQL_SEL = "SELECT sfc_bo,sfc,shop_order_bo,shop_order_name,result,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_ft_traction_result ";

  private final Connection conn;

  public FTTractionResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FTTractionResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getSfc());
      ps.setString(3, data.getShopOrderBo());
      ps.setString(4, data.getShopOrderName());
      ps.setString(5, data.getResult());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FTTractionResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FTTractionResult data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getSfc());
        ps.setString(3, data.getShopOrderBo());
        ps.setString(4, data.getShopOrderName());
        ps.setString(5, data.getResult());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FTTractionResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfc());
      ps.setString(2, data.getShopOrderBo());
      ps.setString(3, data.getShopOrderName());
      ps.setString(4, data.getResult());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getSfcBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<FTTractionResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FTTractionResult data : dataList) {
        ps.setString(1, data.getSfc());
        ps.setString(2, data.getShopOrderBo());
        ps.setString(3, data.getShopOrderName());
        ps.setString(4, data.getResult());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getSfcBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_ft_traction_result WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      return ps.executeUpdate();
    }
  }

  public List<FTTractionResult> selectAll() throws SQLException {
    ArrayList<FTTractionResult> result = new ArrayList<FTTractionResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FTTractionResult selectByPK(String sfcBo) throws SQLException {
    FTTractionResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<FTTractionResult> selectByShopOrderBo(String shopOrderBo) throws SQLException {
    List<FTTractionResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE SHOP_ORDER_BO=?")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private FTTractionResult convert(ResultSet rs) throws SQLException {
    FTTractionResult data = new FTTractionResult();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setResult(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
