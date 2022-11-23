package ame.psb.db.dao;

import ame.psb.db.RunMcsJobs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class RunMcsJobsDao {

  private static final String SQL_INS = "INSERT INTO zr_mcs_jobs(id,state_name,carrier_id,action_name,from_position,to_position,priority,watch_time,start_time,end_time,comments,updated_user,updated_time,created_time,created_user,job_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_mcs_jobs SET state_name=?,carrier_id=?,action_name=?,from_position=?,to_position=?,priority=?,watch_time=?,start_time=?,end_time=?,comments=?,updated_user=?,updated_time=?,created_time=?,created_user=?,job_id=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,state_name,carrier_id,action_name,from_position,to_position,priority,watch_time,start_time,end_time,comments,updated_user,updated_time,created_time,created_user,job_id FROM zr_mcs_jobs ";

  private static final String SQL_SEL_TOP1 = "SELECT top 1 id,state_name,carrier_id,action_name,from_position,to_position,priority,watch_time,start_time,end_time,comments,updated_user,updated_time,created_time,created_user,job_id FROM zr_mcs_jobs ";

  private final Connection conn;

  public RunMcsJobsDao(Connection conn) {
    this.conn = conn;
  }

  public int insertSync(RunMcsJobs currentMcsJob) throws Exception {
    RunMcsJobs job = this.selectActiveJobByCarrierForUpdate(currentMcsJob.getCarrierId());
    if (job != null && !currentMcsJob.isLock()) {
      throw new Exception(
          "Current carrier(" + currentMcsJob.getCarrierId() + ") is used " + job.getId());
    }
    return this.insert(currentMcsJob);

  }


  public int insert(RunMcsJobs data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getStateName());
      ps.setString(3, data.getCarrierId());
      ps.setString(4, data.getActionName());
      ps.setString(5, data.getFromPosition());
      ps.setString(6, data.getToPosition());
      ps.setString(7, data.getPriority());
      DateUtils.setDateTz(ps, 8, data.getWatchTime());
      DateUtils.setDateTz(ps, 9, data.getStartTime());
      DateUtils.setDateTz(ps, 10, data.getEndTime());
      ps.setString(11, data.getComments());
      ps.setString(12, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 13, data.getUpdatedTime());
      DateUtils.setDateTz(ps, 14, data.getCreatedTime());
      ps.setString(15, data.getCreatedUser());
      ps.setString(16, data.getJobId());
      return ps.executeUpdate();
    }
  }

  public int insert(List<RunMcsJobs> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunMcsJobs data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getStateName());
        ps.setString(3, data.getCarrierId());
        ps.setString(4, data.getActionName());
        ps.setString(5, data.getFromPosition());
        ps.setString(6, data.getToPosition());
        ps.setString(7, data.getPriority());
        DateUtils.setDateTz(ps, 8, data.getWatchTime());
        DateUtils.setDateTz(ps, 9, data.getStartTime());
        DateUtils.setDateTz(ps, 10, data.getEndTime());
        ps.setString(11, data.getComments());
        ps.setString(12, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 13, data.getUpdatedTime());
        DateUtils.setDateTz(ps, 14, data.getCreatedTime());
        ps.setString(15, data.getCreatedUser());
        ps.setString(16, data.getJobId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunMcsJobs data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getStateName());
      ps.setString(2, data.getCarrierId());
      ps.setString(3, data.getActionName());
      ps.setString(4, data.getFromPosition());
      ps.setString(5, data.getToPosition());
      ps.setString(6, data.getPriority());
      DateUtils.setDateTz(ps, 7, data.getWatchTime());
      DateUtils.setDateTz(ps, 8, data.getStartTime());
      DateUtils.setDateTz(ps, 9, data.getEndTime());
      ps.setString(10, data.getComments());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
      DateUtils.setDateTz(ps, 13, data.getCreatedTime());
      ps.setString(14, data.getCreatedUser());
      ps.setString(15, data.getJobId());
      ps.setString(16, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(RunMcsJobs data, Date lastUpdatedTime) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD + " and updated_time=? ")) {
      ps.setString(1, data.getStateName());
      ps.setString(2, data.getCarrierId());
      ps.setString(3, data.getActionName());
      ps.setString(4, data.getFromPosition());
      ps.setString(5, data.getToPosition());
      ps.setString(6, data.getPriority());
      DateUtils.setDateTz(ps, 7, data.getWatchTime());
      DateUtils.setDateTz(ps, 8, data.getStartTime());
      DateUtils.setDateTz(ps, 9, data.getEndTime());
      ps.setString(10, data.getComments());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
      DateUtils.setDateTz(ps, 13, data.getCreatedTime());
      ps.setString(14, data.getCreatedUser());
      ps.setString(15, data.getJobId());
      ps.setString(16, data.getId());
      DateUtils.setDateTz(ps, 17, lastUpdatedTime);

      return ps.executeUpdate();
    }
  }

  public int update(List<RunMcsJobs> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunMcsJobs data : dataList) {
        ps.setString(1, data.getStateName());
        ps.setString(2, data.getCarrierId());
        ps.setString(3, data.getActionName());
        ps.setString(4, data.getFromPosition());
        ps.setString(5, data.getToPosition());
        ps.setString(6, data.getPriority());
        DateUtils.setDateTz(ps, 7, data.getWatchTime());
        DateUtils.setDateTz(ps, 8, data.getStartTime());
        DateUtils.setDateTz(ps, 9, data.getEndTime());
        ps.setString(10, data.getComments());
        ps.setString(11, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
        DateUtils.setDateTz(ps, 13, data.getCreatedTime());
        ps.setString(14, data.getCreatedUser());
        ps.setString(15, data.getJobId());
        ps.setString(16, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_mcs_jobs WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<RunMcsJobs> selectAll() throws SQLException {
    ArrayList<RunMcsJobs> result = new ArrayList<RunMcsJobs>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<RunMcsJobs> selectNew() throws SQLException {
    ArrayList<RunMcsJobs> result = new ArrayList<RunMcsJobs>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE state_name = 'NEW' ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public RunMcsJobs selectLatestJobByCarrierName(String carrierName) throws SQLException {
    RunMcsJobs result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_TOP1 + "WHERE carrier_id=? and job_id is null order by created_time desc")) {
      ps.setString(1, carrierName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public RunMcsJobs selectByPK(String id) throws SQLException {
    RunMcsJobs result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }



  public RunMcsJobs selectByFromPosition(String carrier, String from) throws SQLException {
    RunMcsJobs result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE carrier_id=? and action_name='MES001' and from_position=? ")) {
      ps.setString(1, carrier);
      ps.setString(2, from);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public RunMcsJobs selectCurrentJobByCarrier(String carrier) throws SQLException {
    RunMcsJobs result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE carrier_id=? and action_name='MES001' order by created_time desc")) {
      ps.setString(1, carrier);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public RunMcsJobs selectByJobId(String jobId) throws SQLException {
    RunMcsJobs result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE job_id=? and action_name='MES001' order by created_time desc")) {
      ps.setString(1, jobId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public RunMcsJobs selectActiveJobByCarrier(String carrier) throws SQLException {
    RunMcsJobs result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE carrier_id=? and action_name='MES001' and state_name in ('NEW', 'WAIT', 'WAIT_REPLY', 'TRANSFERRING') order by created_time desc")) {
      ps.setString(1, carrier);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public RunMcsJobs selectActiveJobByCarrierForUpdate(String carrier) throws SQLException {
    RunMcsJobs result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE carrier_id=? and action_name='MES001' and state_name in ('NEW', 'WAIT', 'WAIT_REPLY', 'TRANSFERRING') order by created_time desc for update wait 10")) {
      ps.setString(1, carrier);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public List<RunMcsJobs> selectAllActiveJob() throws SQLException {
    ArrayList<RunMcsJobs> result = new ArrayList<RunMcsJobs>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE action_name='MES001' and state_name in ('NEW', 'WAIT', 'WAIT_REPLY', 'TRANSFERRING') order by created_time desc")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<RunMcsJobs> selectJobsByCarrier(String carrier, String actionName)
      throws SQLException {
    ArrayList<RunMcsJobs> result = new ArrayList<RunMcsJobs>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE carrier_id=? and action_name=? order by created_time desc")) {
      ps.setString(1, carrier);
      ps.setString(2, actionName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<RunMcsJobs> selectJobsUnderWay(String carrier) throws SQLException {
    ArrayList<RunMcsJobs> result = new ArrayList<RunMcsJobs>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE carrier_id=? and action_name='MES001' and state_name in('WAIT','NEW','TRANSFERRING') order by created_time desc")) {
      ps.setString(1, carrier);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<RunMcsJobs> selectJobsByHistory(String carrierId, String fromPosition,
      String toPosition) throws SQLException {
    List<RunMcsJobs> result = new ArrayList<RunMcsJobs>();
    String sql = SQL_SEL + " WHERE action_name='MES001'";
    if (carrierId != null && !"".equals(carrierId)) {
      sql += " and carrier_id='" + carrierId + "'";
    }
    if (fromPosition != null && !"".equals(fromPosition)) {
      sql += " and from_position='" + fromPosition + "'";
    }
    if (toPosition != null && !"".equals(toPosition)) {
      sql += " and to_position='" + toPosition + "'";
    }
    try (PreparedStatement ps = this.conn.prepareStatement(sql + " order by created_time desc")) {
      System.out.println(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public RunMcsJobs selectActiveJobByLP(String resourceBo) throws SQLException {
    RunMcsJobs result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE TO_POSITION=? and action_name='MES001' and state_name in ('NEW', 'WAIT', 'WAIT_REPLY', 'TRANSFERRING') order by created_time desc")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public List<RunMcsJobs> selectActiveJobByToPosition(String resourceBo) throws SQLException {
    List<RunMcsJobs> result = new ArrayList<RunMcsJobs>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE TO_POSITION=? and action_name='MES001' and state_name in ('NEW', 'WAIT', 'WAIT_REPLY', 'TRANSFERRING') order by created_time desc")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<RunMcsJobs> select(Where where) throws SQLException {
    ArrayList<RunMcsJobs> result = new ArrayList<RunMcsJobs>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<RunMcsJobs> selectAllJob(String carrier, String from, String to) throws SQLException {
    ArrayList<RunMcsJobs> result = new ArrayList<RunMcsJobs>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE action_name='MES001' and (state_name='TRANSFERRING'or state_name='WAIT'or state_name='WAIT_REPLY'or state_name='NEW') and carrier_id =? and from_position=? and to_position=? ")) {
      ps.setString(1, carrier);
      ps.setString(2, from);
      ps.setString(3, to);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<RunMcsJobs> selectWaitJob(String carrier)
      throws SQLException {
    ArrayList<RunMcsJobs> result = new ArrayList<RunMcsJobs>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE action_name='MES001' and (state_name='TRANSFERRING'or state_name='WAIT'or state_name='WAIT_REPLY'or state_name='NEW') and carrier_id =? ")) {
      ps.setString(1, carrier);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<RunMcsJobs> selectAllFailJob(String carrier, String from, String to)
      throws SQLException {
    ArrayList<RunMcsJobs> result = new ArrayList<RunMcsJobs>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE action_name='MES001' and (state_name='FAIL'or state_name='SEND_FAIL'or state_name='CANCEL_BY_MCS') and carrier_id =? and from_position=? and to_position=? ")) {
      ps.setString(1, carrier);
      ps.setString(2, from);
      ps.setString(3, to);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  private RunMcsJobs convert(ResultSet rs) throws SQLException {
    RunMcsJobs data = new RunMcsJobs();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCarrierId(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setFromPosition(rs.getString(index++));
    data.setToPosition(rs.getString(index++));
    data.setPriority(rs.getString(index++));
    data.setWatchTime(DateUtils.getDateTz(rs, index++));
    data.setStartTime(DateUtils.getDateTz(rs, index++));
    data.setEndTime(DateUtils.getDateTz(rs, index++));
    data.setComments(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));
    data.setCreatedUser(rs.getString(index++));
    data.setJobId(rs.getString(index++));

    return data;
  }

}
