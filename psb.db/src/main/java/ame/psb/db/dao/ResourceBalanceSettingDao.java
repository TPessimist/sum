package ame.psb.db.dao;

import ame.psb.db.ResourceBalanceSetting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ResourceBalanceSettingDao {

  private static final String SQL_INS = "INSERT INTO zd_resource_balance_setting(prefix_resource,seq,field_name,field_value,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_resource_balance_setting SET field_value=?,updated_user=?,updated_time=? WHERE prefix_resource=? AND seq=? AND field_name=?";

  private static final String SQL_SEL = "SELECT prefix_resource,seq,field_name,field_value,updated_user,updated_time FROM zd_resource_balance_setting ";

  private final Connection conn;

  public ResourceBalanceSettingDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ResourceBalanceSetting data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getPrefixResource());
      ps.setString(2, data.getSeq());
      ps.setString(3, data.getFieldName());
      ps.setString(4, data.getFieldValue());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ResourceBalanceSetting> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ResourceBalanceSetting data : dataList) {
        ps.setString(1, data.getPrefixResource());
        ps.setString(2, data.getSeq());
        ps.setString(3, data.getFieldName());
        ps.setString(4, data.getFieldValue());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ResourceBalanceSetting data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFieldValue());
      ps.setString(2, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
      ps.setString(4, data.getPrefixResource());
      ps.setString(5, data.getSeq());
      ps.setString(6, data.getFieldName());

      return ps.executeUpdate();
    }
  }

  public int update(List<ResourceBalanceSetting> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ResourceBalanceSetting data : dataList) {
        ps.setString(1, data.getFieldValue());
        ps.setString(2, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
        ps.setString(4, data.getPrefixResource());
        ps.setString(5, data.getSeq());
        ps.setString(6, data.getFieldName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String prefixResource, String seq, String fieldName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_resource_balance_setting WHERE prefix_resource=? AND seq=? AND field_name=?")) {
      ps.setString(1, prefixResource);
      ps.setString(2, seq);
      ps.setString(3, fieldName);

      return ps.executeUpdate();
    }
  }

  public List<ResourceBalanceSetting> selectAll() throws SQLException {
    ArrayList<ResourceBalanceSetting> result = new ArrayList<ResourceBalanceSetting>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ResourceBalanceSetting> selectByPrefix(String prefixResource) throws SQLException {
    ArrayList<ResourceBalanceSetting> result = new ArrayList<ResourceBalanceSetting>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE prefix_resource=? order by seq ")) {

      ps.setString(1, prefixResource);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public ResourceBalanceSetting selectByPK(String prefixResource, String seq, String fieldName)
      throws SQLException {
    ResourceBalanceSetting result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE prefix_resource=? AND seq=? AND field_name=?")) {
      ps.setString(1, prefixResource);
      ps.setString(2, seq);
      ps.setString(3, fieldName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private ResourceBalanceSetting convert(ResultSet rs) throws SQLException {
    ResourceBalanceSetting data = new ResourceBalanceSetting();

    int index = 1;
    data.setPrefixResource(rs.getString(index++));
    data.setSeq(rs.getString(index++));
    data.setFieldName(rs.getString(index++));
    data.setFieldValue(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
