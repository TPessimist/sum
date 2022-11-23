package ame.psb.db.dao;

import ame.psb.db.ShopOrderWodataConvert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ShopOrderWodataConvertDao {

  private static final String SQL_INS = "INSERT INTO zr_shop_order_wodata_convert(shop_order_bo,convert_type,state_name,message,description,remarks,note,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_shop_order_wodata_convert SET state_name=?,message=?,description=?,remarks=?,note=?,updated_user=?,updated_time=? WHERE shop_order_bo=? AND convert_type=?";

  private static final String SQL_SEL = "SELECT shop_order_bo,convert_type,state_name,message,description,remarks,note,updated_user,updated_time FROM zr_shop_order_wodata_convert ";

  private final Connection conn;

  public ShopOrderWodataConvertDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ShopOrderWodataConvert data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getShopOrderBo());
      ps.setString(2, data.getConvertType());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getMessage());
      ps.setString(5, data.getDescription());
      ps.setString(6, data.getRemarks());
      ps.setString(7, data.getNote());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ShopOrderWodataConvert> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ShopOrderWodataConvert data : dataList) {
        ps.setString(1, data.getShopOrderBo());
        ps.setString(2, data.getConvertType());
        ps.setString(3, data.getStateName());
        ps.setString(4, data.getMessage());
        ps.setString(5, data.getDescription());
        ps.setString(6, data.getRemarks());
        ps.setString(7, data.getNote());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ShopOrderWodataConvert data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getStateName());
      ps.setString(2, data.getMessage());
      ps.setString(3, data.getDescription());
      ps.setString(4, data.getRemarks());
      ps.setString(5, data.getNote());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getShopOrderBo());
      ps.setString(9, data.getConvertType());

      return ps.executeUpdate();
    }
  }

  public int update(List<ShopOrderWodataConvert> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ShopOrderWodataConvert data : dataList) {
        ps.setString(1, data.getStateName());
        ps.setString(2, data.getMessage());
        ps.setString(3, data.getDescription());
        ps.setString(4, data.getRemarks());
        ps.setString(5, data.getNote());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getShopOrderBo());
        ps.setString(9, data.getConvertType());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String shopOrderBo, String convertType) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_shop_order_wodata_convert WHERE shop_order_bo=? AND convert_type=?")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, convertType);

      return ps.executeUpdate();
    }
  }

  public List<ShopOrderWodataConvert> selectAll() throws SQLException {
    ArrayList<ShopOrderWodataConvert> result = new ArrayList<ShopOrderWodataConvert>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ShopOrderWodataConvert selectByPK(String shopOrderBo, String convertType)
      throws SQLException {
    ShopOrderWodataConvert result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE shop_order_bo=? AND convert_type=?")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, convertType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ShopOrderWodataConvert selectLatestShopOrder(String convertType) throws SQLException {
    ShopOrderWodataConvert result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE state_name = 'WAIT' and convert_type =? ORDER BY updated_time desc")) {
      ps.setString(1, convertType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ShopOrderWodataConvert convert(ResultSet rs) throws SQLException {
    ShopOrderWodataConvert data = new ShopOrderWodataConvert();

    int index = 1;
    data.setShopOrderBo(rs.getString(index++));
    data.setConvertType(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setMessage(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setRemarks(rs.getString(index++));
    data.setNote(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
