package ame.psb.db.dao;

import ame.psb.db.ResourceTypeResource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResourceTypeResourceDao {

  private static final String SQL_INS = "INSERT INTO resource_type_resource(handle,resource_type_bo,resource_bo) VALUES (?,?,?)";

  private static final String SQL_UPD = "UPDATE resource_type_resource SET resource_type_bo=?,resource_bo=? WHERE handle=?";

  private static final String SQL_UPD_BY_RSB = "UPDATE resource_type_resource SET handle = ?, resource_type_bo=?,resource_bo=? WHERE resource_bo=?";

  private static final String SQL_SEL = "SELECT handle,resource_type_bo,resource_bo FROM resource_type_resource ";

  private final Connection conn;

  public ResourceTypeResourceDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ResourceTypeResource data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getResourceTypeBo());
      ps.setString(3, data.getResourceBo());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ResourceTypeResource> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ResourceTypeResource data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getResourceTypeBo());
        ps.setString(3, data.getResourceBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ResourceTypeResource data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceTypeBo());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<ResourceTypeResource> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ResourceTypeResource data : dataList) {
        ps.setString(1, data.getResourceTypeBo());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM resource_type_resource WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<ResourceTypeResource> selectAll() throws SQLException {
    ArrayList<ResourceTypeResource> result = new ArrayList<ResourceTypeResource>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ResourceTypeResource> selectByResourceType(String resourceTypeBo)
      throws SQLException {
    ArrayList<ResourceTypeResource> result = new ArrayList<ResourceTypeResource>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where resource_type_bo = ? ")) {

      ps.setString(1, resourceTypeBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public ResourceTypeResource selectByPK(String handle) throws SQLException {
    ResourceTypeResource result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public ResourceTypeResource selectByResourceBo(String resource_bo) throws SQLException {
    ResourceTypeResource result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_bo=?")) {
      ps.setString(1, resource_bo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public int updateByResourceBo(ResourceTypeResource data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_BY_RSB)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getResourceTypeBo());
      ps.setString(3, data.getResourceBo());
      ps.setString(4, data.getResourceBo());

      return ps.executeUpdate();
    }
  }

  private ResourceTypeResource convert(ResultSet rs) throws SQLException {
    ResourceTypeResource data = new ResourceTypeResource();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setResourceTypeBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));

    return data;
  }
}
