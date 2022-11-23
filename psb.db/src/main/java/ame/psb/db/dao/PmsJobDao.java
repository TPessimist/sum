package ame.psb.db.dao;

import ame.psb.db.PmsJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PmsJobDao {

  private static final String SQL_INS = "INSERT INTO z_pms_job(handle,site,check_type,job_id,job_desc,job_status,remark,create_user,created_date_time,modify_user,modified_date_time,start_user,start_date_time,complete_user,complete_date_time,submit_user,submit_review_date_time,review_user,complete_review_date_time,cancel_user,cancel_date_time,create_method,period_unit) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE z_pms_job SET site=?,check_type=?,job_id=?,job_desc=?,job_status=?,remark=?,create_user=?,created_date_time=?,modify_user=?,modified_date_time=?,start_user=?,start_date_time=?,complete_user=?,complete_date_time=?,submit_user=?,submit_review_date_time=?,review_user=?,complete_review_date_time=?,cancel_user=?,cancel_date_time=?,create_method=?,period_unit=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,site,check_type,job_id,job_desc,job_status,remark,create_user,created_date_time,modify_user,modified_date_time,start_user,start_date_time,complete_user,complete_date_time,submit_user,submit_review_date_time,review_user,complete_review_date_time,cancel_user,cancel_date_time,create_method,period_unit FROM z_pms_job ";

  private final Connection conn;

  public PmsJobDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PmsJob data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getCheckType());
      ps.setString(4, data.getJobId());
      ps.setString(5, data.getJobDesc());
      ps.setString(6, data.getJobStatus());
      ps.setString(7, data.getRemark());
      ps.setString(8, data.getCreateUser());
      ps.setTimestamp(9, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setString(10, data.getModifyUser());
      ps.setTimestamp(11, new Timestamp(data.getModifiedDateTime().getTime()));
      ps.setString(12, data.getStartUser());
      ps.setTimestamp(13, new Timestamp(data.getStartDateTime().getTime()));
      ps.setString(14, data.getCompleteUser());
      ps.setTimestamp(15, new Timestamp(data.getCompleteDateTime().getTime()));
      ps.setString(16, data.getSubmitUser());
      ps.setTimestamp(17, new Timestamp(data.getSubmitReviewDateTime().getTime()));
      ps.setString(18, data.getReviewUser());
      ps.setTimestamp(19, new Timestamp(data.getCompleteReviewDateTime().getTime()));
      ps.setString(20, data.getCancelUser());
      ps.setTimestamp(21, new Timestamp(data.getCancelDateTime().getTime()));
      ps.setString(22, data.getCreateMethod());
      ps.setString(23, data.getPeriodUnit());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PmsJob> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PmsJob data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getSite());
        ps.setString(3, data.getCheckType());
        ps.setString(4, data.getJobId());
        ps.setString(5, data.getJobDesc());
        ps.setString(6, data.getJobStatus());
        ps.setString(7, data.getRemark());
        ps.setString(8, data.getCreateUser());
        ps.setTimestamp(9, new Timestamp(data.getCreatedDateTime().getTime()));
        ps.setString(10, data.getModifyUser());
        ps.setTimestamp(11, new Timestamp(data.getModifiedDateTime().getTime()));
        ps.setString(12, data.getStartUser());
        ps.setTimestamp(13, new Timestamp(data.getStartDateTime().getTime()));
        ps.setString(14, data.getCompleteUser());
        ps.setTimestamp(15, new Timestamp(data.getCompleteDateTime().getTime()));
        ps.setString(16, data.getSubmitUser());
        ps.setTimestamp(17, new Timestamp(data.getSubmitReviewDateTime().getTime()));
        ps.setString(18, data.getReviewUser());
        ps.setTimestamp(19, new Timestamp(data.getCompleteReviewDateTime().getTime()));
        ps.setString(20, data.getCancelUser());
        ps.setTimestamp(21, new Timestamp(data.getCancelDateTime().getTime()));
        ps.setString(22, data.getCreateMethod());
        ps.setString(23, data.getPeriodUnit());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PmsJob data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSite());
      ps.setString(2, data.getCheckType());
      ps.setString(3, data.getJobId());
      ps.setString(4, data.getJobDesc());
      ps.setString(5, data.getJobStatus());
      ps.setString(6, data.getRemark());
      ps.setString(7, data.getCreateUser());
      ps.setTimestamp(8, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setString(9, data.getModifyUser());
      ps.setTimestamp(10, new Timestamp(data.getModifiedDateTime().getTime()));
      ps.setString(11, data.getStartUser());
      ps.setTimestamp(12, new Timestamp(data.getStartDateTime().getTime()));
      ps.setString(13, data.getCompleteUser());
      ps.setTimestamp(14, new Timestamp(data.getCompleteDateTime().getTime()));
      ps.setString(15, data.getSubmitUser());
      ps.setTimestamp(16, new Timestamp(data.getSubmitReviewDateTime().getTime()));
      ps.setString(17, data.getReviewUser());
      ps.setTimestamp(18, new Timestamp(data.getCompleteReviewDateTime().getTime()));
      ps.setString(19, data.getCancelUser());
      ps.setTimestamp(20, new Timestamp(data.getCancelDateTime().getTime()));
      ps.setString(21, data.getCreateMethod());
      ps.setString(22, data.getPeriodUnit());
      ps.setString(23, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<PmsJob> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PmsJob data : dataList) {
        ps.setString(1, data.getSite());
        ps.setString(2, data.getCheckType());
        ps.setString(3, data.getJobId());
        ps.setString(4, data.getJobDesc());
        ps.setString(5, data.getJobStatus());
        ps.setString(6, data.getRemark());
        ps.setString(7, data.getCreateUser());
        ps.setTimestamp(8, new Timestamp(data.getCreatedDateTime().getTime()));
        ps.setString(9, data.getModifyUser());
        ps.setTimestamp(10, new Timestamp(data.getModifiedDateTime().getTime()));
        ps.setString(11, data.getStartUser());
        ps.setTimestamp(12, new Timestamp(data.getStartDateTime().getTime()));
        ps.setString(13, data.getCompleteUser());
        ps.setTimestamp(14, new Timestamp(data.getCompleteDateTime().getTime()));
        ps.setString(15, data.getSubmitUser());
        ps.setTimestamp(16, new Timestamp(data.getSubmitReviewDateTime().getTime()));
        ps.setString(17, data.getReviewUser());
        ps.setTimestamp(18, new Timestamp(data.getCompleteReviewDateTime().getTime()));
        ps.setString(19, data.getCancelUser());
        ps.setTimestamp(20, new Timestamp(data.getCancelDateTime().getTime()));
        ps.setString(21, data.getCreateMethod());
        ps.setString(22, data.getPeriodUnit());
        ps.setString(23, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM z_pms_job WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<PmsJob> selectAll() throws SQLException {
    ArrayList<PmsJob> result = new ArrayList<PmsJob>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public PmsJob selectByPK(String handle) throws SQLException {
    PmsJob result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public PmsJob selectByJobId(String jobId) throws SQLException {
    PmsJob result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT modify_user,modified_date_time,start_user,start_date_time,complete_user,"
            + " complete_date_time,submit_user,submit_review_date_time,job_status,job_id,pad_upload_num,handle,create_method  FROM  z_pms_job WHERE job_id=? ")) {
      ps.setString(1, jobId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convertForPad(rs);
      }
      return result;
    }
  }

  public int updateForPad(PmsJob data) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE z_pms_job SET modify_user=?,modified_date_time=?,start_user=?,"
            + " start_date_time=?,complete_user=?,complete_date_time=?,submit_user=?,submit_review_date_time=?,job_status=?,pad_upload_num=?  WHERE job_id=?")) {
      ps.setString(1, data.getModifyUser());
      DateUtils.setDateTz(ps, 2, data.getModifiedDateTime());
      ps.setString(3, data.getStartUser());
      DateUtils.setDateTz(ps, 4, data.getStartDateTime());
      ps.setString(5, data.getCompleteUser());
      DateUtils.setDateTz(ps, 6, data.getCompleteDateTime());
      ps.setString(7, data.getSubmitUser());
      DateUtils.setDateTz(ps, 8, data.getSubmitReviewDateTime());
      ps.setString(9, data.getJobStatus());
      ps.setInt(10, data.getPad_upload_num());
      ps.setString(11, data.getJobId());

      return ps.executeUpdate();
    }
  }


  public List<PmsJob> selectByResourceBo(String resourceBo) throws SQLException {
    List<PmsJob> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT ZJ.HANDLE,ZJ.CREATE_METHOD FROM Z_PMS_JOB ZJ INNER JOIN "
            + "Z_PMS_JOB_RESOURCE_CHECKLIST ZC ON ZJ.HANDLE = ZC.JOB_BO WHERE ZC.RESOURCE_BO =? AND ZJ.JOB_STATUS NOT IN('COMPLETE','CANCEL')")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convertForJob(rs));
      }
      return result;
    }
  }

  private PmsJob convertForPad(ResultSet rs) throws SQLException {
    PmsJob data = new PmsJob();

    int index = 1;
    data.setModifyUser(rs.getString(index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setStartUser(rs.getString(index++));
    data.setStartDateTime(DateUtils.getDateTz(rs, index++));
    data.setCompleteUser(rs.getString(index++));
    data.setCompleteDateTime(DateUtils.getDateTz(rs, index++));
    data.setSubmitUser(rs.getString(index++));
    data.setSubmitReviewDateTime(DateUtils.getDateTz(rs, index++));
    data.setJobStatus(rs.getString(index++));
    data.setJobId(rs.getString(index++));
    data.setPad_upload_num(rs.getInt(index++));
    data.setHandle(rs.getString(index++));
    data.setCreateMethod(rs.getString(index++));
    return data;
  }

  private PmsJob convert(ResultSet rs) throws SQLException {
    PmsJob data = new PmsJob();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setCheckType(rs.getString(index++));
    data.setJobId(rs.getString(index++));
    data.setJobDesc(rs.getString(index++));
    data.setJobStatus(rs.getString(index++));
    data.setRemark(rs.getString(index++));
    data.setCreateUser(rs.getString(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));
    data.setModifyUser(rs.getString(index++));
    data.setModifiedDateTime(rs.getTimestamp(index++));
    data.setStartUser(rs.getString(index++));
    data.setStartDateTime(rs.getTimestamp(index++));
    data.setCompleteUser(rs.getString(index++));
    data.setCompleteDateTime(rs.getTimestamp(index++));
    data.setSubmitUser(rs.getString(index++));
    data.setSubmitReviewDateTime(rs.getTimestamp(index++));
    data.setReviewUser(rs.getString(index++));
    data.setCompleteReviewDateTime(rs.getTimestamp(index++));
    data.setCancelUser(rs.getString(index++));
    data.setCancelDateTime(rs.getTimestamp(index++));
    data.setCreateMethod(rs.getString(index++));
    data.setPeriodUnit(rs.getString(index++));

    return data;
  }

  private PmsJob convertForJob(ResultSet rs) throws SQLException {
    PmsJob data = new PmsJob();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setCreateMethod(rs.getString(index++));

    return data;
  }

}