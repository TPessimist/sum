package ame.me.db.dao;

import ame.me.db.ResourceType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResourceTypeDao {

  private static final String SQL_SEL = "SELECT handle,change_stamp,site,resource_type,description,created_date_time,modified_date_time FROM resource_type ";

  private final Connection conn;

  public ResourceTypeDao(Connection conn) {
    this.conn = conn;
  }

  public List<ResourceType> selectAll(String site) throws SQLException {
    ArrayList<ResourceType> result = new ArrayList<ResourceType>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? ORDER BY RESOURCE_TYPE")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ResourceType> selectByNamePrefix(String site, String name) throws SQLException {
    ArrayList<ResourceType> result = new ArrayList<ResourceType>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE site=? AND RESOURCE_TYPE like ? ORDER BY RESOURCE_TYPE")) {
      ps.setString(1, site);
      ps.setString(2, name + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }


  public ResourceType selectByPK(String handle) throws SQLException {
    ResourceType result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ResourceType convert(ResultSet rs) throws SQLException {
    ResourceType data = new ResourceType();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setChangeStamp(rs.getBigDecimal(index++));
    data.setSite(rs.getString(index++));
    data.setResourceType(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));
    data.setModifiedDateTime(rs.getTimestamp(index++));

    return data;
  }
}