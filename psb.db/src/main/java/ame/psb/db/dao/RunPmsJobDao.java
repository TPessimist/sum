package ame.psb.db.dao;

import ame.psb.db.RunPmsJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunPmsJobDao {

  private static final String SQL_INS = "INSERT INTO zr_pms_job(job_id,checklist,check_type,resource_bo,job_desc,job_status,remark,create_user,created_date_time,modify_user,modified_date_time,complete_user,complete_date_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_pms_job SET checklist=?,check_type=?,resource_bo=?,job_desc=?,job_status=?,remark=?,create_user=?,created_date_time=?,modify_user=?,modified_date_time=?,complete_user=?,complete_date_time=? WHERE job_id=?";

  private static final String SQL_SEL = "SELECT job_id,checklist,check_type,resource_bo,job_desc,job_status,remark,create_user,created_date_time,modify_user,modified_date_time,complete_user,complete_date_time FROM zr_pms_job ";

  private final Connection conn;

  public RunPmsJobDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunPmsJob data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getJobId());
      ps.setString(2, data.getChecklist());
      ps.setString(3, data.getCheckType());
      ps.setString(4, data.getResourceBo());
      ps.setString(5, data.getJobDesc());
      ps.setString(6, data.getJobStatus());
      ps.setString(7, data.getRemark());
      ps.setString(8, data.getCreateUser());
      DateUtils.setDateTz(ps, 9, data.getCreatedDateTime());
      ps.setString(10, data.getModifyUser());
      DateUtils.setDateTz(ps, 11, data.getModifiedDateTime());
      ps.setString(12, data.getCompleteUser());
      DateUtils.setDateTz(ps, 13, data.getCompleteDateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunPmsJob> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunPmsJob data : dataList) {
        ps.setString(1, data.getJobId());
        ps.setString(2, data.getChecklist());
        ps.setString(3, data.getCheckType());
        ps.setString(4, data.getResourceBo());
        ps.setString(5, data.getJobDesc());
        ps.setString(6, data.getJobStatus());
        ps.setString(7, data.getRemark());
        ps.setString(8, data.getCreateUser());
        DateUtils.setDateTz(ps, 9, data.getCreatedDateTime());
        ps.setString(10, data.getModifyUser());
        DateUtils.setDateTz(ps, 11, data.getModifiedDateTime());
        ps.setString(12, data.getCompleteUser());
        DateUtils.setDateTz(ps, 13, data.getCompleteDateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunPmsJob data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getChecklist());
      ps.setString(2, data.getCheckType());
      ps.setString(3, data.getResourceBo());
      ps.setString(4, data.getJobDesc());
      ps.setString(5, data.getJobStatus());
      ps.setString(6, data.getRemark());
      ps.setString(7, data.getCreateUser());
      DateUtils.setDateTz(ps, 8, data.getCreatedDateTime());
      ps.setString(9, data.getModifyUser());
      DateUtils.setDateTz(ps, 10, data.getModifiedDateTime());
      ps.setString(11, data.getCompleteUser());
      DateUtils.setDateTz(ps, 12, data.getCompleteDateTime());
      ps.setString(13, data.getJobId());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunPmsJob> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunPmsJob data : dataList) {
        ps.setString(1, data.getChecklist());
        ps.setString(2, data.getCheckType());
        ps.setString(3, data.getResourceBo());
        ps.setString(4, data.getJobDesc());
        ps.setString(5, data.getJobStatus());
        ps.setString(6, data.getRemark());
        ps.setString(7, data.getCreateUser());
        DateUtils.setDateTz(ps, 8, data.getCreatedDateTime());
        ps.setString(9, data.getModifyUser());
        DateUtils.setDateTz(ps, 10, data.getModifiedDateTime());
        ps.setString(11, data.getCompleteUser());
        DateUtils.setDateTz(ps, 12, data.getCompleteDateTime());
        ps.setString(13, data.getJobId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String jobId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pms_job WHERE job_id=?")) {
      ps.setString(1, jobId);

      return ps.executeUpdate();
    }
  }

  public List<RunPmsJob> selectAll() throws SQLException {
    ArrayList<RunPmsJob> result = new ArrayList<RunPmsJob>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public RunPmsJob selectByPK(String jobId) throws SQLException {
    RunPmsJob result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE job_id=?")) {
      ps.setString(1, jobId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public RunPmsJob selectLastCompleteJob(String resourceBo, String checklist) throws SQLException {
    RunPmsJob runPmsJob = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "where resource_bo = ? and job_status = 'DONE' and checklist=? order by complete_date_time desc limit 1 ")) {
      ps.setString(1, resourceBo);
      ps.setString(2, checklist);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        runPmsJob = this.convert(rs);
      }
      return runPmsJob;
    }
  }

  public List<RunPmsJob> selectResAndCheckList(String resourceBo, String checklist)
      throws SQLException {
    ArrayList<RunPmsJob> result = new ArrayList<RunPmsJob>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "where resource_bo = ? and checklist=? order by job_id desc ")) {
      ps.setString(1, resourceBo);
      ps.setString(2, checklist);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  /*
   * cc
   * created_date_time
   * */
  public RunPmsJob selectByResourceAndCheckList(String resourceBo, String checklist)
      throws SQLException {
    RunPmsJob runPmsJob = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "where resource_bo = ? and checklist=? order by job_id desc limit 1 ")) {
      ps.setString(1, resourceBo);
      ps.setString(2, checklist);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        runPmsJob = this.convert(rs);
      }
      return runPmsJob;
    }
  }


  private RunPmsJob convert(ResultSet rs) throws SQLException {
    RunPmsJob data = new RunPmsJob();

    int index = 1;
    data.setJobId(rs.getString(index++));
    data.setChecklist(rs.getString(index++));
    data.setCheckType(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setJobDesc(rs.getString(index++));
    data.setJobStatus(rs.getString(index++));
    data.setRemark(rs.getString(index++));
    data.setCreateUser(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifyUser(rs.getString(index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setCompleteUser(rs.getString(index++));
    data.setCompleteDateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
