package ame.me.db.dao;

import ame.me.db.SfcStep;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SfcStepDao {

  private static final String SQL_SEL = "SELECT sfc_step_bo,shop_order_bo,shop_order," +
      "sfc_bo,sfc,sfc_routing_bo,sfc_router_bo,sfc_router_seq,sfc_step_seq,router_bo,operation_bo,step_id,"
      +
      "step_pulled_into,done,bypassed,qty_in_queue,qty_in_work,qty_completed,qty_complete_pending,"
      +
      "qty_rejected,times_processed,use_as_rework,local_rework,previously_started,previous_resource_bo,previous_step_id,"
      +
      "date_queued,item_bo,scheduled_comp_date,resource_bo,work_center_bo ";

  private static final String SQL_UPD_WORK = " UPDATE SFC_STEP SET QTY_IN_WORK = ? WHERE HANDLE = ? ";

  private static final String SQL_UPD_QUEUE = " UPDATE SFC_STEP SET QTY_IN_QUEUE = ? WHERE HANDLE = ? ";

  private static final String SQL_UPD_REVERSE = "UPDATE SFC_STEP SET QTY_IN_QUEUE = QTY_COMPLETED, QTY_COMPLETED = 0, DONE ='false' WHERE HANDLE = ? ";

  private static final String SQL_INS = "INSERT INTO WIP.SFC_STEP (HANDLE, SFC_ROUTER_BO, STEP_ID, OPERATION_BO, DONE, BYPASSED, QTY_IN_QUEUE, QTY_IN_WORK, QTY_COMPLETED, QTY_COMPLETE_PENDING, QTY_REJECTED, TIMES_PROCESSED, MAX_LOOP, USE_AS_REWORK, PREVIOUSLY_STARTED, LAST_WORK_CENTER_BO, PREVIOUS_STEP_ID, DATE_QUEUED, REPORTING_STEP, STEP_SEQUENCE, RESOURCE_OR_CENTER_GBO, STATE, REPORTING_CENTER_BO, PREVIOUS_RESOURCE_BO, MULTI_Q_SIGNOFF_NEEDED, STEP_PULLED_INTO, PARTITION_DATE, LOCAL_REWORK, SPECIAL_INSTRUCTION, FUTURE_HOLD_COUNT, ERP_SENT, SCRAP_REPORTING_STEP, ERP_TB_SENT) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


  private Connection conn;

  public SfcStepDao(Connection conn) {
    this.conn = conn;
  }

  public int updateQtyInWork(BigDecimal qty, String handle) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_WORK)) {
      ps.setBigDecimal(1, qty);
      ps.setString(2, handle);
      return ps.executeUpdate();
    }
  }


  public int updateQtyInQueue(BigDecimal qty, String handle) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_QUEUE)) {
      ps.setBigDecimal(1, qty);
      ps.setString(2, handle);
      return ps.executeUpdate();
    }
  }

  public int updateQty(BigDecimal qtyInQueue, BigDecimal qtyInWork, String handle)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "  UPDATE WIP.SFC_STEP SET QTY_IN_QUEUE=?, QTY_IN_WORK=? WHERE HANDLE=?;")) {
      ps.setBigDecimal(1, qtyInQueue);
      ps.setBigDecimal(2, qtyInWork);
      ps.setString(3, handle);
      return ps.executeUpdate();
    }
  }

  public int updateForReverse(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_REVERSE)) {
      ps.setString(1, handle);
      return ps.executeUpdate();
    }
  }


  public SfcStep selectByQtyInWork(String sfcStepBo) throws SQLException {
    SfcStep step = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "FROM sfc_step WHERE sfc_step_bo like ? and qty_in_queue != 0")) {
      ps.setString(1, sfcStepBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        step = convert(rs);
      }
    }
    return step;
  }

  public SfcStep selectByPK(String sfcStepBo) throws SQLException {
    SfcStep step = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "FROM view_sfc_step WHERE sfc_step_bo=?")) {
      ps.setString(1, sfcStepBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        step = convert(rs);
      }
    }
    return step;
  }

  public SfcStep selectByPK(String sfcBo, String operationBo) throws SQLException {
    SfcStep step = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "FROM view_sfc_step WHERE sfc_bo=? AND operation_bo=? ORDER BY sfc_router_seq,sfc_step_seq")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        step = convert(rs);
      }
    }
    return step;
  }

  public SfcStep selectCurrentPMBySfc(String sfcBo) throws SQLException {
    SfcStep step = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "FROM view_sfc_step_pm WHERE sfc_bo=? AND qty_in_queue>0 ORDER BY sfc_step_bo")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        step = convert(rs);
      }
    }
    return step;
  }

  public SfcStep selectPM(String sfcBo, String routerBo, String stepId) throws SQLException {
    SfcStep step = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "FROM view_sfc_step_pm WHERE sfc_bo=? AND router_bo=? AND step_id=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, routerBo);
      ps.setString(3, stepId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        step = convert(rs);
      }
    }
    return step;
  }

  public List<SfcStep> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<SfcStep> result = new ArrayList<SfcStep>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "FROM view_sfc_step WHERE sfc_bo=? ORDER BY sfc_router_seq,sfc_step_seq")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<SfcStep> selectLastStepSfc(String sfcBo) throws SQLException {
    ArrayList<SfcStep> result = new ArrayList<SfcStep>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "FROM view_sfc_step WHERE sfc_bo=? ORDER BY SFC_STEP_SEQ desc LIMIT 1")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<SfcStep> selectBySfc(String sfcBo, String routerBo) throws SQLException {
    ArrayList<SfcStep> result = new ArrayList<SfcStep>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "FROM view_sfc_step WHERE sfc_bo=? AND router_bo=? ORDER BY sfc_router_seq,sfc_step_seq")) {
      ps.setString(1, sfcBo);
      ps.setString(2, routerBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public SfcStep selectTop1ByRouterBo(String routerBo) throws SQLException {
    SfcStep step = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "FROM view_sfc_step WHERE  router_bo=? ORDER BY sfc_router_seq,sfc_step_seq")) {
      ps.setString(1, routerBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        step = convert(rs);
      }
    }
    return step;
  }

  public SfcStep selectCurrentBySfc(String sfcBo) throws SQLException {
    SfcStep dispatch = selectRunningBySfc(sfcBo);
    return dispatch != null ? dispatch : selectWaitingBySfc(sfcBo);
  }

  public SfcStep selectWaitingBySfc(String sfcBo) throws SQLException {
    SfcStep step = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "FROM view_sfc_step_in_queue WHERE sfc_bo=? ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        step = convert(rs);
      }
    }
    return step;
  }

  public SfcStep selectRunningBySfc(String sfcBo) throws SQLException {
    SfcStep step = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "FROM view_sfc_step_in_work WHERE sfc_bo=? ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        step = convert(rs);
      }
    }
    return step;
  }


  public SfcStep selectRunningByShopOrder(String shopOrde) throws SQLException {
    SfcStep step = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "FROM view_sfc_step_in_work WHERE SHOP_ORDER_Bo=? ")) {
      ps.setString(1, shopOrde);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        step = convert(rs);
      }
    }
    return step;
  }


  public List<SfcStep> selectWaitingByOperation(String operationBo) throws SQLException {
    ArrayList<SfcStep> result = new ArrayList<SfcStep>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "FROM view_sfc_step_waiting WHERE operation_bo=? ORDER BY sfc_step_bo")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<SfcStep> selectRunningByOperation(String operationBo) throws SQLException {
    ArrayList<SfcStep> result = new ArrayList<SfcStep>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "FROM view_sfc_step_in_work WHERE operation_bo=? ORDER BY sfc_step_bo")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  private SfcStep convert(ResultSet rs) throws SQLException {
    SfcStep data = new SfcStep();

    int index = 1;
    data.setSfcStepBo(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setSfcRoutingBo(rs.getString(index++));
    data.setSfcRouterBo(rs.getString(index++));
    data.setSfcRouterSeq(rs.getBigDecimal(index++));
    data.setSfcStepSeq(rs.getBigDecimal(index++));
    data.setRouterBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setStepId(rs.getString(index++));
    data.setStepPulledInto(rs.getString(index++));
    data.setDone(rs.getString(index++));
    data.setBypassed(rs.getString(index++));
    data.setQtyInQueue(rs.getBigDecimal(index++));
    data.setQtyInWork(rs.getBigDecimal(index++));
    data.setQtyCompleted(rs.getBigDecimal(index++));
    data.setQtyCompletePending(rs.getBigDecimal(index++));
    data.setQtyRejected(rs.getBigDecimal(index++));
    data.setTimesProcessed(rs.getBigDecimal(index++));
    data.setUseAsRework(rs.getString(index++));
    data.setLocalRework(rs.getString(index++));
    data.setPreviouslyStarted(rs.getString(index++));
    data.setPreviousResourceBo(rs.getString(index++));
    data.setPreviousStepId(rs.getString(index++));
    data.setDateQueued(rs.getTimestamp(index++));
    data.setItemBo(rs.getString(index++));
    data.setScheduledCompDate(rs.getTimestamp(index++));
    data.setResourceBo(rs.getString(index++));
    data.setWorkCenterBo(rs.getString(index++));

    return data;
  }


}
