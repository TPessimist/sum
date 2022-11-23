package ame.psb.db.dao;

import ame.psb.db.TagRuntime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagRuntimeDao {

  private static final String SQL_INS = "INSERT INTO zh_tag_runtime_table(customer_id,package_type,dept,factor,factor_list,seq) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_tag_runtime_table SET seq=? WHERE customer_id=? AND package_type=? AND dept=? AND factor=? AND factor_list=?";

  private static final String SQL_SEL = "SELECT customer_id,package_type,dept,factor,factor_list,seq FROM zh_tag_runtime_table ";

  private final Connection conn;

  public TagRuntimeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(TagRuntime data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerId());
      ps.setString(2, data.getPackageType());
      ps.setString(3, data.getDept());
      ps.setString(4, data.getFactor());
      ps.setString(5, data.getFactorList());
      ps.setString(6, data.getSeq());

      return ps.executeUpdate();
    }
  }

  public int insert(List<TagRuntime> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (TagRuntime data : dataList) {
        ps.setString(1, data.getCustomerId());
        ps.setString(2, data.getPackageType());
        ps.setString(3, data.getDept());
        ps.setString(4, data.getFactor());
        ps.setString(5, data.getFactorList());
        ps.setString(6, data.getSeq());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(TagRuntime data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSeq());
      ps.setString(2, data.getCustomerId());
      ps.setString(3, data.getPackageType());
      ps.setString(4, data.getDept());
      ps.setString(5, data.getFactor());
      ps.setString(6, data.getFactorList());

      return ps.executeUpdate();
    }
  }

  public int update(List<TagRuntime> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (TagRuntime data : dataList) {
        ps.setString(1, data.getSeq());
        ps.setString(2, data.getCustomerId());
        ps.setString(3, data.getPackageType());
        ps.setString(4, data.getDept());
        ps.setString(5, data.getFactor());
        ps.setString(6, data.getFactorList());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerId, String packageType, String dept, String factor,
      String factorList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zh_tag_runtime_table WHERE customer_id=? AND package_type=? AND dept=? AND factor=? AND factor_list=?")) {
      ps.setString(1, customerId);
      ps.setString(2, packageType);
      ps.setString(3, dept);
      ps.setString(4, factor);
      ps.setString(5, factorList);

      return ps.executeUpdate();
    }
  }

  public List<TagRuntime> selectAll() throws SQLException {
    ArrayList<TagRuntime> result = new ArrayList<TagRuntime>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public TagRuntime selectByPK(String customerId, String packageType, String dept, String factor,
      String factorList) throws SQLException {
    TagRuntime result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE customer_id=? AND package_type=? AND dept=? AND factor=? AND factor_list=?")) {
      ps.setString(1, customerId);
      ps.setString(2, packageType);
      ps.setString(3, dept);
      ps.setString(4, factor);
      ps.setString(5, factorList);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private TagRuntime convert(ResultSet rs) throws SQLException {
    TagRuntime data = new TagRuntime();

    int index = 1;
    data.setCustomerId(rs.getString(index++));
    data.setPackageType(rs.getString(index++));
    data.setDept(rs.getString(index++));
    data.setFactor(rs.getString(index++));
    data.setFactorList(rs.getString(index++));
    data.setSeq(rs.getString(index++));

    return data;
  }
}
