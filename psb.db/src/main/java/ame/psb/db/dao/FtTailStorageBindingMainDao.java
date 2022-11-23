package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FtTailStorageBindingMain;
import uia.utils.dao.DateUtils;

public class FtTailStorageBindingMainDao {

  private static final String SQL_INS = "INSERT INTO zd_ft_tail_storage_binding_main(shop_order_bo,shop_order_name,unique_code,unique_code_shop_order,unique_code_shop_order_name,binding_type,reversed_field1,reversed_field2,modify_time,modify_user) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_ft_tail_storage_binding_main SET shop_order_name=?,unique_code_shop_order=?,unique_code_shop_order_name=?,binding_type=?,reversed_field1=?,reversed_field2=?,modify_time=?,modify_user=? WHERE shop_order_bo=? AND unique_code=?";

  private static final String SQL_SEL = "SELECT shop_order_bo,shop_order_name,unique_code,unique_code_shop_order,unique_code_shop_order_name,binding_type,reversed_field1,reversed_field2,modify_time,modify_user FROM zd_ft_tail_storage_binding_main ";

  private final Connection conn;

  public FtTailStorageBindingMainDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FtTailStorageBindingMain data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getShopOrderBo());
      ps.setString(2, data.getShopOrderName());
      ps.setString(3, data.getUniqueCode());
      ps.setString(4, data.getUniqueCodeShopOrder());
      ps.setString(5, data.getUniqueCodeShopOrderName());
      ps.setString(6, data.getBindingType());
      ps.setString(7, data.getReversedField1());
      ps.setString(8, data.getReversedField2());
      DateUtils.setDateTz(ps, 9, data.getModifyTime());
      ps.setString(10, data.getModifyUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FtTailStorageBindingMain> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FtTailStorageBindingMain data : dataList) {
        ps.setString(1, data.getShopOrderBo());
        ps.setString(2, data.getShopOrderName());
        ps.setString(3, data.getUniqueCode());
        ps.setString(4, data.getUniqueCodeShopOrder());
        ps.setString(5, data.getUniqueCodeShopOrderName());
        ps.setString(6, data.getBindingType());
        ps.setString(7, data.getReversedField1());
        ps.setString(8, data.getReversedField2());
        DateUtils.setDateTz(ps, 9, data.getModifyTime());
        ps.setString(10, data.getModifyUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FtTailStorageBindingMain data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getShopOrderName());
      ps.setString(2, data.getUniqueCodeShopOrder());
      ps.setString(3, data.getUniqueCodeShopOrderName());
      ps.setString(4, data.getBindingType());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      DateUtils.setDateTz(ps, 7, data.getModifyTime());
      ps.setString(8, data.getModifyUser());
      ps.setString(9, data.getShopOrderBo());
      ps.setString(10, data.getUniqueCode());

      return ps.executeUpdate();
    }
  }

  public int update(List<FtTailStorageBindingMain> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FtTailStorageBindingMain data : dataList) {
        ps.setString(1, data.getShopOrderName());
        ps.setString(2, data.getUniqueCodeShopOrder());
        ps.setString(3, data.getUniqueCodeShopOrderName());
        ps.setString(4, data.getBindingType());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        DateUtils.setDateTz(ps, 7, data.getModifyTime());
        ps.setString(8, data.getModifyUser());
        ps.setString(9, data.getShopOrderBo());
        ps.setString(10, data.getUniqueCode());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String shopOrderBo, String uniqueCode) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_ft_tail_storage_binding_main WHERE shop_order_bo=? AND unique_code=?")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, uniqueCode);

      return ps.executeUpdate();
    }
  }
  public int delete( String uniqueCode) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
            "DELETE FROM zd_ft_tail_storage_binding_main WHERE unique_code=?")) {
      ps.setString(1, uniqueCode);

      return ps.executeUpdate();
    }
  }

  public List<FtTailStorageBindingMain> selectAll() throws SQLException {
    ArrayList<FtTailStorageBindingMain> result = new ArrayList<FtTailStorageBindingMain>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FtTailStorageBindingMain selectByPK(String shopOrderBo, String uniqueCode)
      throws SQLException {
    FtTailStorageBindingMain result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE shop_order_bo=? AND unique_code=?")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, uniqueCode);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FtTailStorageBindingMain selectByCombined(String shopOrderBo, String uniqueCode)
      throws SQLException {
    FtTailStorageBindingMain result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE shop_order_bo=? AND unique_code=? and binding_type = 'COMBINED'")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, uniqueCode);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FtTailStorageBindingMain selectByBinding(String shopOrderBo, String uniqueCode)
      throws SQLException {
    FtTailStorageBindingMain result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE shop_order_bo=? AND unique_code=? and binding_type = 'BINDING'")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, uniqueCode);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FtTailStorageBindingMain selectByUniqueCode(String uniqueCode)
      throws SQLException {
    FtTailStorageBindingMain result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE unique_code=?")) {
      ps.setString(1, uniqueCode);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FtTailStorageBindingMain selectByShopOrderBo(String shopOrderBo) throws SQLException {
    FtTailStorageBindingMain result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order_bo=? ")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FtTailStorageBindingMain selectByUniqueCodeShopOrderBo(String uniqueCodeShopOrderBo) throws SQLException {
    FtTailStorageBindingMain result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE UNIQUE_CODE_SHOP_ORDER=? ")) {
      ps.setString(1, uniqueCodeShopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }
  private FtTailStorageBindingMain convert(ResultSet rs) throws SQLException {
    FtTailStorageBindingMain data = new FtTailStorageBindingMain();

    int index = 1;
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setUniqueCode(rs.getString(index++));
    data.setUniqueCodeShopOrder(rs.getString(index++));
    data.setUniqueCodeShopOrderName(rs.getString(index++));
    data.setBindingType(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setModifyTime(DateUtils.getDateTz(rs, index++));
    data.setModifyUser(rs.getString(index++));

    return data;
  }
}
