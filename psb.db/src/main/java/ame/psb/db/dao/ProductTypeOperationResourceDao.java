package ame.psb.db.dao;

import ame.psb.db.ProductTypeOperationResource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ProductTypeOperationResourceDao {

  private static final String SQL_INS = "INSERT INTO zd_product_type_operation_resource(product_type,operation_bo,resource_bo,seq,item_group_bo,updated_user,updated_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_product_type_operation_resource SET operation_bo=?,resource_bo=?,seq=?,item_group_bo=?,updated_user=?,updated_time=? WHERE product_type=?";

  private static final String SQL_SEL = "SELECT product_type,operation_bo,resource_bo,seq,item_group_bo,updated_user,updated_time FROM zd_product_type_operation_resource ";

  private final Connection conn;

  public ProductTypeOperationResourceDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ProductTypeOperationResource data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getProductType());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getResourceBo());
      ps.setBigDecimal(4, data.getSeq());
      ps.setString(5, data.getItemGroupBo());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ProductTypeOperationResource> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ProductTypeOperationResource data : dataList) {
        ps.setString(1, data.getProductType());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getResourceBo());
        ps.setBigDecimal(4, data.getSeq());
        ps.setString(5, data.getItemGroupBo());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ProductTypeOperationResource data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getOperationBo());
      ps.setString(2, data.getResourceBo());
      ps.setBigDecimal(3, data.getSeq());
      ps.setString(4, data.getItemGroupBo());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getProductType());

      return ps.executeUpdate();
    }
  }

  public int update(List<ProductTypeOperationResource> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ProductTypeOperationResource data : dataList) {
        ps.setString(1, data.getOperationBo());
        ps.setString(2, data.getResourceBo());
        ps.setBigDecimal(3, data.getSeq());
        ps.setString(4, data.getItemGroupBo());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getProductType());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String productType) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_product_type_operation_resource WHERE product_type=?")) {
      ps.setString(1, productType);

      return ps.executeUpdate();
    }
  }

  public int delete(String productType, String OperationBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_product_type_operation_resource WHERE product_type=? and operation_bo = ?")) {
      ps.setString(1, productType);
      ps.setString(2, OperationBo);

      return ps.executeUpdate();
    }
  }

  public int delete(ProductTypeOperationResource productTypeOperationResource) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_product_type_operation_resource WHERE PRODUCT_TYPE = ? AND OPERATION_BO =? AND RESOURCE_BO =?")) {
      ps.setString(1, productTypeOperationResource.getProductType());
      ps.setString(2, productTypeOperationResource.getOperationBo());
      ps.setString(3, productTypeOperationResource.getResourceBo());

      return ps.executeUpdate();
    }
  }

  public List<ProductTypeOperationResource> selectAll() throws SQLException {
    ArrayList<ProductTypeOperationResource> result = new ArrayList<ProductTypeOperationResource>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ProductTypeOperationResource> selectByPtAndOpera(String productType,
      String OperationBo) throws SQLException {
    ArrayList<ProductTypeOperationResource> result = new ArrayList<ProductTypeOperationResource>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE product_type=? and operation_bo = ?")) {
      ps.setString(1, productType);
      ps.setString(2, OperationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ProductTypeOperationResource> selectByResourceBo(String resourceBo)
      throws SQLException {
    ArrayList<ProductTypeOperationResource> result = new ArrayList<ProductTypeOperationResource>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_bo=? ")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public ProductTypeOperationResource selectByPK(String productType) throws SQLException {
    ProductTypeOperationResource result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE product_type=?")) {
      ps.setString(1, productType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private ProductTypeOperationResource convert(ResultSet rs) throws SQLException {
    ProductTypeOperationResource data = new ProductTypeOperationResource();

    int index = 1;
    data.setProductType(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setSeq(rs.getBigDecimal(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
