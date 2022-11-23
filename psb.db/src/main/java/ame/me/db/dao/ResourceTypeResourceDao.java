package ame.me.db.dao;

import ame.me.db.ResourceTypeResource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResourceTypeResourceDao {

  private static String SQL_SEL = "select HANDLE,RESOURCE_TYPE_BO,RESOURCE_BO from RESOURCE_TYPE_RESOURCE";

  private Connection conn;

  public ResourceTypeResourceDao(Connection conn) {
    this.conn = conn;
  }

  public List<ResourceTypeResource> select(String resourceBo) throws SQLException {
    ArrayList<ResourceTypeResource> result = new ArrayList<ResourceTypeResource>();

    PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where RESOURCE_BO=? order by HANDLE");
    ps.setString(1, resourceBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      result.add(convert(rs));
    }
    rs.close();
    ps.close();

    return result;
  }

  public List<ResourceTypeResource> select(String resourceBo, String endType) throws SQLException {
    ArrayList<ResourceTypeResource> result = new ArrayList<ResourceTypeResource>();

    PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + " where RESOURCE_BO=? and RESOURCE_TYPE_BO like ? order by HANDLE");
    ps.setString(1, resourceBo);
    ps.setString(2, "%" + endType);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      result.add(convert(rs));
    }
    rs.close();
    ps.close();

    return result;
  }

  public ResourceTypeResource selectByPk(String resourceBo, String resourceType)
      throws SQLException {
    ResourceTypeResource result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where RESOURCE_BO=? and RESOURCE_TYPE_BO like ? ")) {
      ps.setString(1, resourceBo);
      ps.setString(2, resourceType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }
    return result;
  }

  public ResourceTypeResource selectByResourceTypeBo(String resourceTypeBo)
      throws SQLException {
    ResourceTypeResource result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where RESOURCE_TYPE_BO = ? ")) {
      ps.setString(1, resourceTypeBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }
    return result;
  }

  private ResourceTypeResource convert(ResultSet rs) throws SQLException {
    ResourceTypeResource rtr = new ResourceTypeResource();
    rtr.setHandle(rs.getString(1));
    rtr.setResourceTypeBo(rs.getString(2));
    rtr.setResourceBo(rs.getString(3));
    return rtr;
  }
}
