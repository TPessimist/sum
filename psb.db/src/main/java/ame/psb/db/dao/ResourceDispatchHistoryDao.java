package ame.psb.db.dao;

import ame.psb.db.ResourceDispatchHistory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ResourceDispatchHistoryDao {

  private static final String SQL_INS = "INSERT INTO zr_resource_dispatch_history(resource_name,updated_time,sfc_name,cr_value,priority,priority_desc,sfc_step_bo) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_resource_dispatch_history SET cr_value=?,priority=?,priority_desc=?,sfc_step_bo=? WHERE resource_name=? AND updated_time=? AND sfc_name=?";

  private static final String SQL_SEL = "SELECT resource_name,updated_time,sfc_name,cr_value,priority,priority_desc,sfc_step_bo FROM zr_resource_dispatch_history ";

  private final Connection conn;

  public ResourceDispatchHistoryDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ResourceDispatchHistory data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResourceName());
      DateUtils.setDateTz(ps, 2, data.getUpdatedTime());
      ps.setString(3, data.getSfcName());
      ps.setBigDecimal(4, data.getCrValue());
      ps.setString(5, data.getPriority());
      ps.setString(6, data.getPriorityDesc());
      ps.setString(7, data.getSfcStepBo());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ResourceDispatchHistory> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ResourceDispatchHistory data : dataList) {
        ps.setString(1, data.getResourceName());
        DateUtils.setDateTz(ps, 2, data.getUpdatedTime());
        ps.setString(3, data.getSfcName());
        ps.setBigDecimal(4, data.getCrValue());
        ps.setString(5, data.getPriority());
        ps.setString(6, data.getPriorityDesc());
        ps.setString(7, data.getSfcStepBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ResourceDispatchHistory data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getCrValue());
      ps.setString(2, data.getPriority());
      ps.setString(3, data.getPriorityDesc());
      ps.setString(4, data.getSfcStepBo());
      ps.setString(5, data.getResourceName());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getSfcName());

      return ps.executeUpdate();
    }
  }

  public int update(List<ResourceDispatchHistory> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ResourceDispatchHistory data : dataList) {
        ps.setBigDecimal(1, data.getCrValue());
        ps.setString(2, data.getPriority());
        ps.setString(3, data.getPriorityDesc());
        ps.setString(4, data.getSfcStepBo());
        ps.setString(5, data.getResourceName());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getSfcName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resourceName, Date updatedTime, String sfcName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_resource_dispatch_history WHERE resource_name=? AND updated_time=? AND sfc_name=?")) {
      ps.setString(1, resourceName);
      DateUtils.setDateTz(ps, 2, updatedTime);
      ps.setString(3, sfcName);

      return ps.executeUpdate();
    }
  }

  public List<ResourceDispatchHistory> selectAll() throws SQLException {
    ArrayList<ResourceDispatchHistory> result = new ArrayList<ResourceDispatchHistory>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public ResourceDispatchHistory selectByPK(String resourceName, Date updatedTime, String sfcName)
      throws SQLException {
    ResourceDispatchHistory result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_name=? AND updated_time=? AND sfc_name=?")) {
      ps.setString(1, resourceName);
      DateUtils.setDateTz(ps, 2, updatedTime);
      ps.setString(3, sfcName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private ResourceDispatchHistory convert(ResultSet rs) throws SQLException {
    ResourceDispatchHistory data = new ResourceDispatchHistory();

    int index = 1;
    data.setResourceName(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setSfcName(rs.getString(index++));
    data.setCrValue(rs.getBigDecimal(index++));
    data.setPriority(rs.getString(index++));
    data.setPriorityDesc(rs.getString(index++));
    data.setSfcStepBo(rs.getString(index++));

    return data;
  }
}
