package ame.psb.db.dao;

import ame.psb.db.ResourceProductionPlan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ResourceProductionPlanDao {

  private static final String SQL_INS = "INSERT INTO zd_resource_production_plan(id,resource_bo,loadport,state_name,sequence,carrier_bo,sfc_bo,sfc_step_bo,operation_bo,remark,updated_time,created_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_resource_production_plan SET resource_bo=?,loadport=?,state_name=?,sequence=?,carrier_bo=?,sfc_bo=?,sfc_step_bo=?,operation_bo=?,remark=?,updated_time=?,created_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resource_bo,loadport,state_name,sequence,carrier_bo,sfc_bo,sfc_step_bo,operation_bo,remark,updated_time,created_time FROM zd_resource_production_plan ";

  private final Connection conn;

  public ResourceProductionPlanDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ResourceProductionPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getLoadport());
      ps.setString(4, data.getStateName());
      ps.setInt(5, data.getSequence());
      ps.setString(6, data.getCarrierBo());
      ps.setString(7, data.getSfcBo());
      ps.setString(8, data.getSfcStepBo());
      ps.setString(9, data.getOperationBo());
      ps.setString(10, data.getRemark());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
      DateUtils.setDateTz(ps, 12, data.getCreatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ResourceProductionPlan> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ResourceProductionPlan data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getLoadport());
        ps.setString(4, data.getStateName());
        ps.setInt(5, data.getSequence());
        ps.setString(6, data.getCarrierBo());
        ps.setString(7, data.getSfcBo());
        ps.setString(8, data.getSfcStepBo());
        ps.setString(9, data.getOperationBo());
        ps.setString(10, data.getRemark());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
        DateUtils.setDateTz(ps, 12, data.getCreatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ResourceProductionPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getLoadport());
      ps.setString(3, data.getStateName());
      ps.setInt(4, data.getSequence());
      ps.setString(5, data.getCarrierBo());
      ps.setString(6, data.getSfcBo());
      ps.setString(7, data.getSfcStepBo());
      ps.setString(8, data.getOperationBo());
      ps.setString(9, data.getRemark());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
      DateUtils.setDateTz(ps, 11, data.getCreatedTime());
      ps.setString(12, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ResourceProductionPlan> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ResourceProductionPlan data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getLoadport());
        ps.setString(3, data.getStateName());
        ps.setInt(4, data.getSequence());
        ps.setString(5, data.getCarrierBo());
        ps.setString(6, data.getSfcBo());
        ps.setString(7, data.getSfcStepBo());
        ps.setString(8, data.getOperationBo());
        ps.setString(9, data.getRemark());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
        DateUtils.setDateTz(ps, 11, data.getCreatedTime());
        ps.setString(12, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_resource_production_plan WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ResourceProductionPlan> selectAll() throws SQLException {
    ArrayList<ResourceProductionPlan> result = new ArrayList<ResourceProductionPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ResourceProductionPlan> selectByResourceBo(String resourceBo) throws SQLException {
    ArrayList<ResourceProductionPlan> result = new ArrayList<ResourceProductionPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where resource_bo=? ")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ResourceProductionPlan selectByPK(String id) throws SQLException {
    ResourceProductionPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ResourceProductionPlan convert(ResultSet rs) throws SQLException {
    ResourceProductionPlan data = new ResourceProductionPlan();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setLoadport(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setSequence(rs.getInt(index++));
    data.setCarrierBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setSfcStepBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setRemark(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
