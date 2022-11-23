package ame.psb.db.dao;

import ame.psb.db.SamplingSkipLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SamplingSkipLogDao {

  private static final String SQL_INS = "INSERT INTO zr_sampling_skip_log(sampling_plan_group,sampling_plan_group_seq,resource_bo,sfc_bo,sampling_plan_id,updated_user,updated_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_sampling_skip_log SET resource_bo=?,sfc_bo=?,sampling_plan_id=?,updated_user=?,updated_time=? WHERE sampling_plan_group=? AND sampling_plan_group_seq=?";

  private static final String SQL_SEL = "SELECT sampling_plan_group,sampling_plan_group_seq,resource_bo,sfc_bo,sampling_plan_id,updated_user,updated_time FROM zr_sampling_skip_log ";


  private static final String SQL_SEL_TOP = "SELECT top ? sampling_plan_group,sampling_plan_group_seq,resource_bo,sfc_bo,sampling_plan_id,updated_user,updated_time FROM zr_sampling_skip_log ";


  private final Connection conn;

  public SamplingSkipLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SamplingSkipLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSamplingPlanGroup());
      ps.setString(2, data.getSamplingPlanGroupSeq());
      ps.setString(3, data.getResourceBo());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getSamplingPlanId());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SamplingSkipLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SamplingSkipLog data : dataList) {
        ps.setString(1, data.getSamplingPlanGroup());
        ps.setString(2, data.getSamplingPlanGroupSeq());
        ps.setString(3, data.getResourceBo());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getSamplingPlanId());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SamplingSkipLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getSamplingPlanId());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getSamplingPlanGroup());
      ps.setString(7, data.getSamplingPlanGroupSeq());

      return ps.executeUpdate();
    }
  }

  public int update(List<SamplingSkipLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SamplingSkipLog data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getSamplingPlanId());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getSamplingPlanGroup());
        ps.setString(7, data.getSamplingPlanGroupSeq());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String samplingPlanGroup, String samplingPlanGroupSeq) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_sampling_skip_log WHERE sampling_plan_group=? AND sampling_plan_group_seq=?")) {
      ps.setString(1, samplingPlanGroup);
      ps.setString(2, samplingPlanGroupSeq);

      return ps.executeUpdate();
    }
  }

  public List<SamplingSkipLog> selectAll() throws SQLException {
    ArrayList<SamplingSkipLog> result = new ArrayList<SamplingSkipLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<SamplingSkipLog> selectBySfcAndPlan(String sfcBo, String planId) throws SQLException {
    ArrayList<SamplingSkipLog> result = new ArrayList<SamplingSkipLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE SFC_BO = ? AND SAMPLING_PLAN_ID = ? order by updated_time asc ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, planId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SamplingSkipLog> selectBySfcAndPlanAndResource(String sfcBo, String planId,
      String resource) throws SQLException {
    ArrayList<SamplingSkipLog> result = new ArrayList<SamplingSkipLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE SFC_BO = ? AND SAMPLING_PLAN_ID = ? and RESOURCE_BO = ? order by updated_time asc ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, planId);
      ps.setString(3, resource);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<SamplingSkipLog> selectBySamplingPlanAndResource(String resourceBo,
      String samplingPlanid) throws SQLException {
    ArrayList<SamplingSkipLog> result = new ArrayList<SamplingSkipLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE Resource_Bo = ? and SAMPLING_PLAN_ID = ? ")) {
      ps.setString(1, resourceBo);
      ps.setString(2, samplingPlanid);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SamplingSkipLog> selectByGroup(String samplingGroup) throws SQLException {
    ArrayList<SamplingSkipLog> result = new ArrayList<SamplingSkipLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE SAMPLING_PLAN_GROUP = ? ")) {
      ps.setString(1, samplingGroup);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SamplingSkipLog> selectTopBySamplingPlanAndResource(int count,
      String resourceBo, String samplingPlanid) throws SQLException {
    ArrayList<SamplingSkipLog> result = new ArrayList<SamplingSkipLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_TOP
        + " WHERE Resource_Bo = ? and SAMPLING_PLAN_ID = ? order by updated_time desc ")) {

      ps.setInt(1, count);
      ps.setString(2, resourceBo);
      ps.setString(3, samplingPlanid);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SamplingSkipLog selectByPK(String samplingPlanGroup, String samplingPlanGroupSeq)
      throws SQLException {
    SamplingSkipLog result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sampling_plan_group=? AND sampling_plan_group_seq=?")) {
      ps.setString(1, samplingPlanGroup);
      ps.setString(2, samplingPlanGroupSeq);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SamplingSkipLog convert(ResultSet rs) throws SQLException {
    SamplingSkipLog data = new SamplingSkipLog();

    int index = 1;
    data.setSamplingPlanGroup(rs.getString(index++));
    data.setSamplingPlanGroupSeq(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setSamplingPlanId(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
