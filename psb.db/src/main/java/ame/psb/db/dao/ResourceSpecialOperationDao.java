package ame.psb.db.dao;

import ame.psb.db.ResourceSpecialOperation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ResourceSpecialOperationDao {

  private static final String SQL_INS = "INSERT INTO zd_resource_special_operation(resource_bo,operation_bo,updated_user,updated_time,state_name) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_resource_special_operation SET updated_user=?,updated_time=?,state_name=? WHERE resource_bo=? AND operation_bo=?";

  private static final String SQL_SEL = "SELECT resource_bo,operation_bo,updated_user,updated_time,state_name FROM zd_resource_special_operation ";

  private final Connection conn;

  public ResourceSpecialOperationDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ResourceSpecialOperation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getStateName());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ResourceSpecialOperation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ResourceSpecialOperation data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getStateName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ResourceSpecialOperation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 2, data.getUpdatedTime());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getResourceBo());
      ps.setString(5, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ResourceSpecialOperation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ResourceSpecialOperation data : dataList) {
        ps.setString(1, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 2, data.getUpdatedTime());
        ps.setString(3, data.getStateName());
        ps.setString(4, data.getResourceBo());
        ps.setString(5, data.getOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resourceBo, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_resource_special_operation WHERE resource_bo=? AND operation_bo=?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, operationBo);

      return ps.executeUpdate();
    }
  }

  public int deleteByRes(String resourceBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_resource_special_operation WHERE resource_bo=? ")) {
      ps.setString(1, resourceBo);

      return ps.executeUpdate();
    }
  }

  public List<ResourceSpecialOperation> selectAll() throws SQLException {
    ArrayList<ResourceSpecialOperation> result = new ArrayList<ResourceSpecialOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ResourceSpecialOperation> selectByRes(String resouce) throws SQLException {
    resouce = "ResourceBO:1020," + resouce;
    ArrayList<ResourceSpecialOperation> result = new ArrayList<ResourceSpecialOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where RESOURCE_BO = ?")) {
      ps.setString(1, resouce);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ResourceSpecialOperation selectByPK(String resourceBo, String operationBo)
      throws SQLException {
    ResourceSpecialOperation result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? AND operation_bo=?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ResourceSpecialOperation convert(ResultSet rs) throws SQLException {
    ResourceSpecialOperation data = new ResourceSpecialOperation();

    int index = 1;
    data.setResourceBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setStateName(rs.getString(index++));

    return data;
  }
}
