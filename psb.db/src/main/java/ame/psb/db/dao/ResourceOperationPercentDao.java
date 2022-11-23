package ame.psb.db.dao;

import ame.psb.db.ResourceOperationPercent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResourceOperationPercentDao {

  private static final String SQL_INS = "INSERT INTO zd_resource_operation_percent(resource_id,operation,calc_hour,percent,comment) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_resource_operation_percent SET calc_hour=?,percent=?,comment=? WHERE resource_id=? AND operation=?";

  private static final String SQL_SEL = "SELECT resource_id,operation,calc_hour,percent,comment FROM zd_resource_operation_percent ";

  private final Connection conn;

  public ResourceOperationPercentDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ResourceOperationPercent data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResourceId());
      ps.setString(2, data.getOperation());
      ps.setString(3, data.getCalcHour());
      ps.setString(4, data.getPercent());
      ps.setString(5, data.getComment());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ResourceOperationPercent> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ResourceOperationPercent data : dataList) {
        ps.setString(1, data.getResourceId());
        ps.setString(2, data.getOperation());
        ps.setString(3, data.getCalcHour());
        ps.setString(4, data.getPercent());
        ps.setString(5, data.getComment());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ResourceOperationPercent data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCalcHour());
      ps.setString(2, data.getPercent());
      ps.setString(3, data.getComment());
      ps.setString(4, data.getResourceId());
      ps.setString(5, data.getOperation());

      return ps.executeUpdate();
    }
  }

  public int update(List<ResourceOperationPercent> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ResourceOperationPercent data : dataList) {
        ps.setString(1, data.getCalcHour());
        ps.setString(2, data.getPercent());
        ps.setString(3, data.getComment());
        ps.setString(4, data.getResourceId());
        ps.setString(5, data.getOperation());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resourceId, String operation) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_resource_operation_percent WHERE resource_id=? AND operation=?")) {
      ps.setString(1, resourceId);
      ps.setString(2, operation);

      return ps.executeUpdate();
    }
  }

  public List<ResourceOperationPercent> selectAll() throws SQLException {
    ArrayList<ResourceOperationPercent> result = new ArrayList<ResourceOperationPercent>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ResourceOperationPercent> selectByResource(String resourceName) throws SQLException {
    ArrayList<ResourceOperationPercent> result = new ArrayList<ResourceOperationPercent>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where resource_id = ? ")) {
      ps.setString(1, resourceName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public ResourceOperationPercent selectByPK(String resourceId, String operation)
      throws SQLException {
    ResourceOperationPercent result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_id=? AND operation=?")) {
      ps.setString(1, resourceId);
      ps.setString(2, operation);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private ResourceOperationPercent convert(ResultSet rs) throws SQLException {
    ResourceOperationPercent data = new ResourceOperationPercent();

    int index = 1;
    data.setResourceId(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setCalcHour(rs.getString(index++));
    data.setPercent(rs.getString(index++));
    data.setComment(rs.getString(index++));

    return data;
  }
}
