package ame.psb.db.dao;

import ame.psb.db.ViewOperationCfs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperationCfsDao {

  private static final String SQL_SEL = "SELECT operation_bo,site,operation,operation_parent,description,type,special_router_bo,status_bo,resource_type_bo,revision,operation_type,cycle_time_type,recipe_type,stage,packing_source,pre_tool_operation,current_revision FROM view_operation_cfs ";

  private final Connection conn;

  public OperationCfsDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewOperationCfs> selectAll() throws SQLException {
    ArrayList<ViewOperationCfs> result = new ArrayList<ViewOperationCfs>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public ViewOperationCfs selectByPK(String operationBo) throws SQLException {
    ViewOperationCfs result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE operation_bo=?")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public ViewOperationCfs selectByParent(String operationParent) throws SQLException {
    ViewOperationCfs result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE operation_parent=? AND current_revision='true'")) {
      ps.setString(1, operationParent);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public List<ViewOperationCfs> selectByResourceBo(String resourceBo) throws SQLException {
    ArrayList<ViewOperationCfs> result = new ArrayList<ViewOperationCfs>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE operation_parent in (select operation_parent from view_operation_resource WHERE resource_bo=?   ) AND current_revision='true'")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ViewOperationCfs> selectAllPkg(String site) throws SQLException {
    ArrayList<ViewOperationCfs> result = new ArrayList<ViewOperationCfs>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE site=? AND operation_type in ('I','B','C') ORDER BY operation")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ViewOperationCfs> selectByOperation(String operation, String site)
      throws SQLException {
    ArrayList<ViewOperationCfs> result = new ArrayList<ViewOperationCfs>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE  site=? AND operation like ? AND operation_type in('I','B','C') ORDER BY operation")) {
      ps.setString(1, site);
      ps.setString(2, operation + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public ViewOperationCfs selectByOperationType(String operation, String type) throws SQLException {
    ViewOperationCfs result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE  operation = ? AND operation_type = ? ORDER BY operation")) {
      ps.setString(1, operation);
      ps.setString(2, type);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private ViewOperationCfs convert(ResultSet rs) throws SQLException {
    ViewOperationCfs data = new ViewOperationCfs();

    int index = 1;
    data.setOperationBo(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setOperationParent(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setType(rs.getString(index++));
    data.setSpecialRouterBo(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setResourceTypeBo(rs.getString(index++));
    data.setRevision(rs.getString(index++));
    data.setOperationType(rs.getString(index++));
    data.setCycleTimeType(rs.getString(index++));
    data.setRecipeType(rs.getString(index++));
    data.setStage(rs.getString(index++));
    data.setPackingSource(rs.getString(index++));
    data.setPrecheckToolOperation(rs.getString(index++));
    data.setCurrentRevision(rs.getString(index++));

    return data;
  }
}
