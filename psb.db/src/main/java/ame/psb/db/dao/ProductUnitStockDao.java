package ame.psb.db.dao;

import ame.psb.db.ProductUnitStock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ProductUnitStockDao {

  private static final String SQL_INS = "INSERT INTO zd_product_unit_stock(product,unit_stock,update_time,update_user,description,remarks,note) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_product_unit_stock SET unit_stock=?,update_time=?,update_user=?,description=?,remarks=?,note=? WHERE product=?";

  private static final String SQL_SEL = "SELECT product,unit_stock,update_time,update_user,description,remarks,note FROM zd_product_unit_stock ";

  private final Connection conn;

  public ProductUnitStockDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ProductUnitStock data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getProduct());
      ps.setBigDecimal(2, data.getUnitStock());
      DateUtils.setDateTz(ps, 3, data.getUpdateTime());
      ps.setString(4, data.getUpdateUser());
      ps.setString(5, data.getDescription());
      ps.setString(6, data.getRemarks());
      ps.setString(7, data.getNote());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ProductUnitStock> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ProductUnitStock data : dataList) {
        ps.setString(1, data.getProduct());
        ps.setBigDecimal(2, data.getUnitStock());
        DateUtils.setDateTz(ps, 3, data.getUpdateTime());
        ps.setString(4, data.getUpdateUser());
        ps.setString(5, data.getDescription());
        ps.setString(6, data.getRemarks());
        ps.setString(7, data.getNote());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ProductUnitStock data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getUnitStock());
      DateUtils.setDateTz(ps, 2, data.getUpdateTime());
      ps.setString(3, data.getUpdateUser());
      ps.setString(4, data.getDescription());
      ps.setString(5, data.getRemarks());
      ps.setString(6, data.getNote());
      ps.setString(7, data.getProduct());

      return ps.executeUpdate();
    }
  }

  public int update(List<ProductUnitStock> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ProductUnitStock data : dataList) {
        ps.setBigDecimal(1, data.getUnitStock());
        DateUtils.setDateTz(ps, 2, data.getUpdateTime());
        ps.setString(3, data.getUpdateUser());
        ps.setString(4, data.getDescription());
        ps.setString(5, data.getRemarks());
        ps.setString(6, data.getNote());
        ps.setString(7, data.getProduct());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String product) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_product_unit_stock WHERE product=?")) {
      ps.setString(1, product);

      return ps.executeUpdate();
    }
  }

  public List<ProductUnitStock> selectAll() throws SQLException {
    ArrayList<ProductUnitStock> result = new ArrayList<ProductUnitStock>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ProductUnitStock selectByPK(String product) throws SQLException {
    ProductUnitStock result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE product=?")) {
      ps.setString(1, product);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ProductUnitStock convert(ResultSet rs) throws SQLException {
    ProductUnitStock data = new ProductUnitStock();

    int index = 1;
    data.setProduct(rs.getString(index++));
    data.setUnitStock(rs.getBigDecimal(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setUpdateUser(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setRemarks(rs.getString(index++));
    data.setNote(rs.getString(index++));

    return data;
  }
}
