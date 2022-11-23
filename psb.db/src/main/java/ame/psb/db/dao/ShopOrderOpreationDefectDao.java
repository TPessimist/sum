package ame.psb.db.dao;

import ame.psb.db.ShopOrderOpreationDefect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ShopOrderOpreationDefectDao {

  private static final String SQL_INS = "INSERT INTO zr_shop_order_operation_defect(shop_order_bo,operation_bo,nc_code_bo,nc_value,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_shop_order_operation_defect SET nc_value=?,updated_user=?,updated_time=? WHERE shop_order_bo=? AND operation_bo=? AND nc_code_bo=?";

  private static final String SQL_SEL = "SELECT shop_order_bo,operation_bo,nc_code_bo,nc_value,updated_user,updated_time FROM zr_shop_order_operation_defect ";

  private final Connection conn;

  public ShopOrderOpreationDefectDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ShopOrderOpreationDefect data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getShopOrderBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getNcCodeBo());
      ps.setInt(4, data.getNcValue());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ShopOrderOpreationDefect> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ShopOrderOpreationDefect data : dataList) {
        ps.setString(1, data.getShopOrderBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getNcCodeBo());
        ps.setInt(4, data.getNcValue());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ShopOrderOpreationDefect data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getNcValue());
      ps.setString(2, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
      ps.setString(4, data.getShopOrderBo());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getNcCodeBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ShopOrderOpreationDefect> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ShopOrderOpreationDefect data : dataList) {
        ps.setInt(1, data.getNcValue());
        ps.setString(2, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
        ps.setString(4, data.getShopOrderBo());
        ps.setString(5, data.getOperationBo());
        ps.setString(6, data.getNcCodeBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String shopOrderBo, String operationBo, String ncCodeBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_shop_order_operation_defect WHERE shop_order_bo=? AND operation_bo=? AND nc_code_bo=?")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, operationBo);
      ps.setString(3, ncCodeBo);

      return ps.executeUpdate();
    }
  }

  public List<ShopOrderOpreationDefect> selectAll() throws SQLException {
    ArrayList<ShopOrderOpreationDefect> result = new ArrayList<ShopOrderOpreationDefect>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ShopOrderOpreationDefect> selectByShopOrder(String shopOrderBo) throws SQLException {
    ArrayList<ShopOrderOpreationDefect> result = new ArrayList<ShopOrderOpreationDefect>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order_bo=?")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ShopOrderOpreationDefect selectByPK(String shopOrderBo, String operationBo,
      String ncCodeBo) throws SQLException {
    ShopOrderOpreationDefect result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE shop_order_bo=? AND operation_bo=? AND nc_code_bo=?")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, operationBo);
      ps.setString(3, ncCodeBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ShopOrderOpreationDefect convert(ResultSet rs) throws SQLException {
    ShopOrderOpreationDefect data = new ShopOrderOpreationDefect();

    int index = 1;
    data.setShopOrderBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setNcCodeBo(rs.getString(index++));
    data.setNcValue(rs.getInt(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
