package ame.psb.db.dao;

import ame.psb.db.ResourceSpecialItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ResourceSpecialItemDao {

  private static final String SQL_INS = "INSERT INTO zd_resource_special_item(resource_bo,item_name,updated_user,updated_time,state_name) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_resource_special_item SET updated_user=?,updated_time=?,state_name=? WHERE resource_bo=? AND item_name=?";

  private static final String SQL_SEL = "SELECT resource_bo,item_name,updated_user,updated_time,state_name FROM zd_resource_special_item ";

  private final Connection conn;

  public ResourceSpecialItemDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ResourceSpecialItem data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getItemName());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getStateName());

      return ps.executeUpdate();
    }

  }

  public int insert(List<ResourceSpecialItem> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ResourceSpecialItem data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getItemName());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getStateName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ResourceSpecialItem data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 2, data.getUpdatedTime());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getResourceBo());
      ps.setString(5, data.getItemName());

      return ps.executeUpdate();
    }
  }

  public int update(List<ResourceSpecialItem> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ResourceSpecialItem data : dataList) {
        ps.setString(1, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 2, data.getUpdatedTime());
        ps.setString(3, data.getStateName());
        ps.setString(4, data.getResourceBo());
        ps.setString(5, data.getItemName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resourceBo, String itemName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_resource_special_item WHERE resource_bo=? AND item_name=?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, itemName);

      return ps.executeUpdate();
    }
  }

  public int deleteByRes(String resourceBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_resource_special_item WHERE resource_bo=? ")) {
      ps.setString(1, resourceBo);

      return ps.executeUpdate();
    }
  }

  public List<ResourceSpecialItem> selectAll() throws SQLException {
    ArrayList<ResourceSpecialItem> result = new ArrayList<ResourceSpecialItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ResourceSpecialItem selectByPK(String resourceBo, String itemName) throws SQLException {
    ResourceSpecialItem result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? AND item_name=?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, itemName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ResourceSpecialItem> selectById(String resouce) throws SQLException {
    resouce = "ResourceBO:1020," + resouce;
    ArrayList<ResourceSpecialItem> result = new ArrayList<ResourceSpecialItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where RESOURCE_BO = ?")) {
      ps.setString(1, resouce);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ResourceSpecialItem convert(ResultSet rs) throws SQLException {
    ResourceSpecialItem data = new ResourceSpecialItem();

    int index = 1;
    data.setResourceBo(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setStateName(rs.getString(index++));

    return data;
  }
}
