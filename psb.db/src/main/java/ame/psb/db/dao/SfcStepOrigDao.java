package ame.psb.db.dao;

import ame.me.db.SfcStepOrig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SfcStepOrigDao {

  private static final String SQL_INS = "INSERT INTO sfc_step(handle,sfc_router_bo,step_id,operation_bo,done,bypassed,qty_in_queue,qty_in_work,qty_completed,qty_complete_pending,qty_rejected,times_processed,max_loop,use_as_rework,previously_started,last_work_center_bo,previous_step_id,date_queued,reporting_step,step_sequence,resource_or_center_gbo,state,reporting_center_bo,previous_resource_bo,multi_q_signoff_needed,step_pulled_into,partition_date,local_rework,special_instruction,future_hold_count,erp_sent,scrap_reporting_step,erp_tb_sent) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE sfc_step SET sfc_router_bo=?,step_id=?,operation_bo=?,done=?,bypassed=?,qty_in_queue=?,qty_in_work=?,qty_completed=?,qty_complete_pending=?,qty_rejected=?,times_processed=?,max_loop=?,use_as_rework=?,previously_started=?,last_work_center_bo=?,previous_step_id=?,date_queued=?,reporting_step=?,step_sequence=?,resource_or_center_gbo=?,state=?,reporting_center_bo=?,previous_resource_bo=?,multi_q_signoff_needed=?,step_pulled_into=?,partition_date=?,local_rework=?,special_instruction=?,future_hold_count=?,erp_sent=?,scrap_reporting_step=?,erp_tb_sent=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,sfc_router_bo,step_id,operation_bo,done,bypassed,qty_in_queue,qty_in_work,qty_completed,qty_complete_pending,qty_rejected,times_processed,max_loop,use_as_rework,previously_started,last_work_center_bo,previous_step_id,date_queued,reporting_step,step_sequence,resource_or_center_gbo,state,reporting_center_bo,previous_resource_bo,multi_q_signoff_needed,step_pulled_into,partition_date,local_rework,special_instruction,future_hold_count,erp_sent,scrap_reporting_step,erp_tb_sent FROM sfc_step ";

  private final Connection conn;

  public SfcStepOrigDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SfcStepOrig data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getSfcRouterBo());
      ps.setString(3, data.getStepId());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getDone());
      ps.setString(6, data.getBypassed());
      ps.setBigDecimal(7, data.getQtyInQueue());
      ps.setBigDecimal(8, data.getQtyInWork());
      ps.setBigDecimal(9, data.getQtyCompleted());
      ps.setBigDecimal(10, data.getQtyCompletePending());
      ps.setBigDecimal(11, data.getQtyRejected());
      ps.setBigDecimal(12, data.getTimesProcessed());
      ps.setBigDecimal(13, data.getMaxLoop());
      ps.setString(14, data.getUseAsRework());
      ps.setString(15, data.getPreviouslyStarted());
      ps.setString(16, data.getLastWorkCenterBo());
      ps.setString(17, data.getPreviousStepId());
      DateUtils.setDateTz(ps, 18, data.getDateQueued());
      ps.setString(19, data.getReportingStep());
      ps.setBigDecimal(20, data.getStepSequence());
      ps.setString(21, data.getResourceOrCenterGbo());
      ps.setString(22, data.getState());
      ps.setString(23, data.getReportingCenterBo());
      ps.setString(24, data.getPreviousResourceBo());
      ps.setString(25, data.getMultiQSignoffNeeded());
      ps.setString(26, data.getStepPulledInto());
      DateUtils.setDateTz(ps, 27, data.getPartitionDate());
      ps.setString(28, data.getLocalRework());
      ps.setString(29, data.getSpecialInstruction());
      ps.setBigDecimal(30, data.getFutureHoldCount());
      ps.setString(31, data.getErpSent());
      ps.setString(32, data.getScrapReportingStep());
      ps.setString(33, data.getErpTbSent());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SfcStepOrig> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SfcStepOrig data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getSfcRouterBo());
        ps.setString(3, data.getStepId());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getDone());
        ps.setString(6, data.getBypassed());
        ps.setBigDecimal(7, data.getQtyInQueue());
        ps.setBigDecimal(8, data.getQtyInWork());
        ps.setBigDecimal(9, data.getQtyCompleted());
        ps.setBigDecimal(10, data.getQtyCompletePending());
        ps.setBigDecimal(11, data.getQtyRejected());
        ps.setBigDecimal(12, data.getTimesProcessed());
        ps.setBigDecimal(13, data.getMaxLoop());
        ps.setString(14, data.getUseAsRework());
        ps.setString(15, data.getPreviouslyStarted());
        ps.setString(16, data.getLastWorkCenterBo());
        ps.setString(17, data.getPreviousStepId());
        DateUtils.setDateTz(ps, 18, data.getDateQueued());
        ps.setString(19, data.getReportingStep());
        ps.setBigDecimal(20, data.getStepSequence());
        ps.setString(21, data.getResourceOrCenterGbo());
        ps.setString(22, data.getState());
        ps.setString(23, data.getReportingCenterBo());
        ps.setString(24, data.getPreviousResourceBo());
        ps.setString(25, data.getMultiQSignoffNeeded());
        ps.setString(26, data.getStepPulledInto());
        DateUtils.setDateTz(ps, 27, data.getPartitionDate());
        ps.setString(28, data.getLocalRework());
        ps.setString(29, data.getSpecialInstruction());
        ps.setBigDecimal(30, data.getFutureHoldCount());
        ps.setString(31, data.getErpSent());
        ps.setString(32, data.getScrapReportingStep());
        ps.setString(33, data.getErpTbSent());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SfcStepOrig data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcRouterBo());
      ps.setString(2, data.getStepId());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getDone());
      ps.setString(5, data.getBypassed());
      ps.setBigDecimal(6, data.getQtyInQueue());
      ps.setBigDecimal(7, data.getQtyInWork());
      ps.setBigDecimal(8, data.getQtyCompleted());
      ps.setBigDecimal(9, data.getQtyCompletePending());
      ps.setBigDecimal(10, data.getQtyRejected());
      ps.setBigDecimal(11, data.getTimesProcessed());
      ps.setBigDecimal(12, data.getMaxLoop());
      ps.setString(13, data.getUseAsRework());
      ps.setString(14, data.getPreviouslyStarted());
      ps.setString(15, data.getLastWorkCenterBo());
      ps.setString(16, data.getPreviousStepId());
      DateUtils.setDateTz(ps, 17, data.getDateQueued());
      ps.setString(18, data.getReportingStep());
      ps.setBigDecimal(19, data.getStepSequence());
      ps.setString(20, data.getResourceOrCenterGbo());
      ps.setString(21, data.getState());
      ps.setString(22, data.getReportingCenterBo());
      ps.setString(23, data.getPreviousResourceBo());
      ps.setString(24, data.getMultiQSignoffNeeded());
      ps.setString(25, data.getStepPulledInto());
      DateUtils.setDateTz(ps, 26, data.getPartitionDate());
      ps.setString(27, data.getLocalRework());
      ps.setString(28, data.getSpecialInstruction());
      ps.setBigDecimal(29, data.getFutureHoldCount());
      ps.setString(30, data.getErpSent());
      ps.setString(31, data.getScrapReportingStep());
      ps.setString(32, data.getErpTbSent());
      ps.setString(33, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<SfcStepOrig> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SfcStepOrig data : dataList) {
        ps.setString(1, data.getSfcRouterBo());
        ps.setString(2, data.getStepId());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getDone());
        ps.setString(5, data.getBypassed());
        ps.setBigDecimal(6, data.getQtyInQueue());
        ps.setBigDecimal(7, data.getQtyInWork());
        ps.setBigDecimal(8, data.getQtyCompleted());
        ps.setBigDecimal(9, data.getQtyCompletePending());
        ps.setBigDecimal(10, data.getQtyRejected());
        ps.setBigDecimal(11, data.getTimesProcessed());
        ps.setBigDecimal(12, data.getMaxLoop());
        ps.setString(13, data.getUseAsRework());
        ps.setString(14, data.getPreviouslyStarted());
        ps.setString(15, data.getLastWorkCenterBo());
        ps.setString(16, data.getPreviousStepId());
        DateUtils.setDateTz(ps, 17, data.getDateQueued());
        ps.setString(18, data.getReportingStep());
        ps.setBigDecimal(19, data.getStepSequence());
        ps.setString(20, data.getResourceOrCenterGbo());
        ps.setString(21, data.getState());
        ps.setString(22, data.getReportingCenterBo());
        ps.setString(23, data.getPreviousResourceBo());
        ps.setString(24, data.getMultiQSignoffNeeded());
        ps.setString(25, data.getStepPulledInto());
        DateUtils.setDateTz(ps, 26, data.getPartitionDate());
        ps.setString(27, data.getLocalRework());
        ps.setString(28, data.getSpecialInstruction());
        ps.setBigDecimal(29, data.getFutureHoldCount());
        ps.setString(30, data.getErpSent());
        ps.setString(31, data.getScrapReportingStep());
        ps.setString(32, data.getErpTbSent());
        ps.setString(33, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM sfc_step WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<SfcStepOrig> selectAll() throws SQLException {
    ArrayList<SfcStepOrig> result = new ArrayList<SfcStepOrig>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SfcStepOrig> selectBySfcBo(String sfcBo) throws SQLException {
    ArrayList<SfcStepOrig> result = new ArrayList<SfcStepOrig>();
    sfcBo = "%" + sfcBo + ",Router%";
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where SFC_ROUTER_BO like ? ORDER BY to_number(step_id) ASC")) {
      ps.setString(1, sfcBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SfcStepOrig selectByPK(String handle) throws SQLException {
    SfcStepOrig result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SfcStepOrig convert(ResultSet rs) throws SQLException {
    SfcStepOrig data = new SfcStepOrig();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSfcRouterBo(rs.getString(index++));
    data.setStepId(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDone(rs.getString(index++));
    data.setBypassed(rs.getString(index++));
    data.setQtyInQueue(rs.getBigDecimal(index++));
    data.setQtyInWork(rs.getBigDecimal(index++));
    data.setQtyCompleted(rs.getBigDecimal(index++));
    data.setQtyCompletePending(rs.getBigDecimal(index++));
    data.setQtyRejected(rs.getBigDecimal(index++));
    data.setTimesProcessed(rs.getBigDecimal(index++));
    data.setMaxLoop(rs.getBigDecimal(index++));
    data.setUseAsRework(rs.getString(index++));
    data.setPreviouslyStarted(rs.getString(index++));
    data.setLastWorkCenterBo(rs.getString(index++));
    data.setPreviousStepId(rs.getString(index++));
    data.setDateQueued(DateUtils.getDateTz(rs, index++));
    data.setReportingStep(rs.getString(index++));
    data.setStepSequence(rs.getBigDecimal(index++));
    data.setResourceOrCenterGbo(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setReportingCenterBo(rs.getString(index++));
    data.setPreviousResourceBo(rs.getString(index++));
    data.setMultiQSignoffNeeded(rs.getString(index++));
    data.setStepPulledInto(rs.getString(index++));
    data.setPartitionDate(DateUtils.getDateTz(rs, index++));
    data.setLocalRework(rs.getString(index++));
    data.setSpecialInstruction(rs.getString(index++));
    data.setFutureHoldCount(rs.getBigDecimal(index++));
    data.setErpSent(rs.getString(index++));
    data.setScrapReportingStep(rs.getString(index++));
    data.setErpTbSent(rs.getString(index++));

    return data;
  }
}
