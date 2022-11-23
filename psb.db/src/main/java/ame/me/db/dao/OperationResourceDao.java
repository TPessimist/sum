package ame.me.db.dao;

import ame.me.db.OperationResource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperationResourceDao {

  private static final String SQL_SEL = "SELECT operation_bo,resource_bo,operation,resrce,description,type,special_router_bo,operation_status_bo,resrce_status_bo,operation_parent FROM view_operation_resource ";

  private Connection conn;

  public OperationResourceDao(Connection conn) {
    this.conn = conn;
  }

  public List<OperationResource> selectAll() throws SQLException {
    ArrayList<OperationResource> result = new ArrayList<OperationResource>();

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " ORDER BY operation_bo,resource_bo")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }

    return result;
  }

  public OperationResource selectByPK(String operationParent, String resourceBo)
      throws SQLException {
    OperationResource data = null;

    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE resource_bo=? AND operation_parent=? ORDER BY operation_bo")) {
      ps.setString(1, resourceBo);
      ps.setString(2, operationParent);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        data = convert(rs);
      }
    }

    return data;
  }

  public List<OperationResource> selectByResource(String resourceBo) throws SQLException {
    ArrayList<OperationResource> result = new ArrayList<OperationResource>();

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE resource_bo=? ORDER BY operation_bo")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }

    return result;
  }

  public List<OperationResource> selectByOperationName(String operation) throws SQLException {
    ArrayList<OperationResource> result = new ArrayList<OperationResource>();

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE operation=? ORDER BY resource_bo")) {
      ps.setString(1, operation);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }

    return result;
  }

  public List<OperationResource> selectByOperation(String operationBo) throws SQLException {
    ArrayList<OperationResource> result = new ArrayList<OperationResource>();

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE operation_bo=? ORDER BY resource_bo")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }

    return result;
  }

  public List<OperationResource> selectByOperationParent(String operationParent)
      throws SQLException {
    ArrayList<OperationResource> result = new ArrayList<OperationResource>();

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE operation_parent=? ORDER BY resource_bo")) {
      ps.setString(1, operationParent);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }

    return result;
  }

  private OperationResource convert(ResultSet rs) throws SQLException {
    OperationResource or = new OperationResource();
    or.setOperationBo(rs.getString(1));
    or.setResourceBo(rs.getString(2));
    or.setOperation(rs.getString(3));
    or.setResrce(rs.getString(4));
    or.setDescription(rs.getString(5));
    or.setType(rs.getString(6));
    or.setSpecialRouterBo(rs.getString(7));
    or.setOperationStatusBo(rs.getString(8));
    or.setResrceStatusBo(rs.getString(9));
    or.setOperationParent(rs.getString(10));
    return or;
  }
}
