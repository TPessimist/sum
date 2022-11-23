package ame.psb.db.dao;

import ame.psb.db.ActivityLog;
import ame.psb.db.FullLotReportResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ActivityLogDao {

  private static final String SQL_INS = "INSERT INTO activity_log(handle,site,change_stamp,action_code,action_detail,action_detail_handle,activity,date_time,crew,user_id,sfc,process_lot,operation,operation_revision,item,item_revision,router,router_revision,step_id,substep,substep_id,resrce,work_center,qty,rework,reporting_center_bo,shop_order_bo,partition_date,lcc_bo,action_span,prev_site,txn_id,created_date_time,modified_date_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE activity_log SET site=?,change_stamp=?,action_code=?,action_detail=?,action_detail_handle=?,activity=?,date_time=?,crew=?,user_id=?,sfc=?,process_lot=?,operation=?,operation_revision=?,item=?,item_revision=?,router=?,router_revision=?,step_id=?,substep=?,substep_id=?,resrce=?,work_center=?,qty=?,rework=?,reporting_center_bo=?,shop_order_bo=?,partition_date=?,lcc_bo=?,action_span=?,prev_site=?,txn_id=?,created_date_time=?,modified_date_time=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,site,change_stamp,action_code,action_detail,action_detail_handle,activity,date_time,crew,user_id,sfc,process_lot,operation,operation_revision,item,item_revision,router,router_revision,step_id,substep,substep_id,resrce,work_center,qty,rework,reporting_center_bo,shop_order_bo,partition_date,lcc_bo,action_span,prev_site,txn_id,created_date_time,modified_date_time FROM activity_log ";

  private static final String SQL_SEL1 = "SELECT sfc,shop_order_bo,operation,rework,resrce,user_id,action_code,date_time,action_detail_handle,router,action_detail FROM activity_log ";

  private final Connection conn;

  public ActivityLogDao(Connection conn) {
    this.conn = conn;
  }

  public List<FullLotReportResult> selectBySfcName(String sfc) throws SQLException {
    ArrayList<FullLotReportResult> result = new ArrayList<FullLotReportResult>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + " WHERE sfc = ? ORDER BY date_time")) {
      ps.setString(1, sfc);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertReport(rs));
      }
    }
    return result;
  }

  public int insert(ActivityLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getSite());
      ps.setBigDecimal(3, data.getChangeStamp());
      ps.setString(4, data.getActionCode());
      ps.setString(5, data.getActionDetail());
      ps.setString(6, data.getActionDetailHandle());
      ps.setString(7, data.getActivity());
      ps.setTimestamp(8, new Timestamp(data.getDateTime().getTime()));
      ps.setString(9, data.getCrew());
      ps.setString(10, data.getUserId());
      ps.setString(11, data.getSfc());
      ps.setString(12, data.getProcessLot());
      ps.setString(13, data.getOperation());
      ps.setString(14, data.getOperationRevision());
      ps.setString(15, data.getItem());
      ps.setString(16, data.getItemRevision());
      ps.setString(17, data.getRouter());
      ps.setString(18, data.getRouterRevision());
      ps.setString(19, data.getStepId());
      ps.setString(20, data.getSubstep());
      ps.setString(21, data.getSubstepId());
      ps.setString(22, data.getResrce());
      ps.setString(23, data.getWorkCenter());
      ps.setBigDecimal(24, data.getQty());
      ps.setString(25, data.getRework());
      ps.setString(26, data.getReportingCenterBo());
      ps.setString(27, data.getShopOrderBo());
      ps.setTimestamp(28, new Timestamp(data.getPartitionDate().getTime()));
      ps.setString(29, data.getLccBo());
      ps.setBigDecimal(30, data.getActionSpan());
      ps.setString(31, data.getPrevSite());
      ps.setString(32, data.getTxnId());
      ps.setTimestamp(33, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setTimestamp(34, new Timestamp(data.getModifiedDateTime().getTime()));

      return ps.executeUpdate();
    }
  }

  public int insert(List<ActivityLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ActivityLog data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getSite());
        ps.setBigDecimal(3, data.getChangeStamp());
        ps.setString(4, data.getActionCode());
        ps.setString(5, data.getActionDetail());
        ps.setString(6, data.getActionDetailHandle());
        ps.setString(7, data.getActivity());
        ps.setTimestamp(8, new Timestamp(data.getDateTime().getTime()));
        ps.setString(9, data.getCrew());
        ps.setString(10, data.getUserId());
        ps.setString(11, data.getSfc());
        ps.setString(12, data.getProcessLot());
        ps.setString(13, data.getOperation());
        ps.setString(14, data.getOperationRevision());
        ps.setString(15, data.getItem());
        ps.setString(16, data.getItemRevision());
        ps.setString(17, data.getRouter());
        ps.setString(18, data.getRouterRevision());
        ps.setString(19, data.getStepId());
        ps.setString(20, data.getSubstep());
        ps.setString(21, data.getSubstepId());
        ps.setString(22, data.getResrce());
        ps.setString(23, data.getWorkCenter());
        ps.setBigDecimal(24, data.getQty());
        ps.setString(25, data.getRework());
        ps.setString(26, data.getReportingCenterBo());
        ps.setString(27, data.getShopOrderBo());
        ps.setTimestamp(28, new Timestamp(data.getPartitionDate().getTime()));
        ps.setString(29, data.getLccBo());
        ps.setBigDecimal(30, data.getActionSpan());
        ps.setString(31, data.getPrevSite());
        ps.setString(32, data.getTxnId());
        ps.setTimestamp(33, new Timestamp(data.getCreatedDateTime().getTime()));
        ps.setTimestamp(34, new Timestamp(data.getModifiedDateTime().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ActivityLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSite());
      ps.setBigDecimal(2, data.getChangeStamp());
      ps.setString(3, data.getActionCode());
      ps.setString(4, data.getActionDetail());
      ps.setString(5, data.getActionDetailHandle());
      ps.setString(6, data.getActivity());
      ps.setTimestamp(7, new Timestamp(data.getDateTime().getTime()));
      ps.setString(8, data.getCrew());
      ps.setString(9, data.getUserId());
      ps.setString(10, data.getSfc());
      ps.setString(11, data.getProcessLot());
      ps.setString(12, data.getOperation());
      ps.setString(13, data.getOperationRevision());
      ps.setString(14, data.getItem());
      ps.setString(15, data.getItemRevision());
      ps.setString(16, data.getRouter());
      ps.setString(17, data.getRouterRevision());
      ps.setString(18, data.getStepId());
      ps.setString(19, data.getSubstep());
      ps.setString(20, data.getSubstepId());
      ps.setString(21, data.getResrce());
      ps.setString(22, data.getWorkCenter());
      ps.setBigDecimal(23, data.getQty());
      ps.setString(24, data.getRework());
      ps.setString(25, data.getReportingCenterBo());
      ps.setString(26, data.getShopOrderBo());
      ps.setTimestamp(27, new Timestamp(data.getPartitionDate().getTime()));
      ps.setString(28, data.getLccBo());
      ps.setBigDecimal(29, data.getActionSpan());
      ps.setString(30, data.getPrevSite());
      ps.setString(31, data.getTxnId());
      ps.setTimestamp(32, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setTimestamp(33, new Timestamp(data.getModifiedDateTime().getTime()));
      ps.setString(34, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<ActivityLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ActivityLog data : dataList) {
        ps.setString(1, data.getSite());
        ps.setBigDecimal(2, data.getChangeStamp());
        ps.setString(3, data.getActionCode());
        ps.setString(4, data.getActionDetail());
        ps.setString(5, data.getActionDetailHandle());
        ps.setString(6, data.getActivity());
        ps.setTimestamp(7, new Timestamp(data.getDateTime().getTime()));
        ps.setString(8, data.getCrew());
        ps.setString(9, data.getUserId());
        ps.setString(10, data.getSfc());
        ps.setString(11, data.getProcessLot());
        ps.setString(12, data.getOperation());
        ps.setString(13, data.getOperationRevision());
        ps.setString(14, data.getItem());
        ps.setString(15, data.getItemRevision());
        ps.setString(16, data.getRouter());
        ps.setString(17, data.getRouterRevision());
        ps.setString(18, data.getStepId());
        ps.setString(19, data.getSubstep());
        ps.setString(20, data.getSubstepId());
        ps.setString(21, data.getResrce());
        ps.setString(22, data.getWorkCenter());
        ps.setBigDecimal(23, data.getQty());
        ps.setString(24, data.getRework());
        ps.setString(25, data.getReportingCenterBo());
        ps.setString(26, data.getShopOrderBo());
        ps.setTimestamp(27, new Timestamp(data.getPartitionDate().getTime()));
        ps.setString(28, data.getLccBo());
        ps.setBigDecimal(29, data.getActionSpan());
        ps.setString(30, data.getPrevSite());
        ps.setString(31, data.getTxnId());
        ps.setTimestamp(32, new Timestamp(data.getCreatedDateTime().getTime()));
        ps.setTimestamp(33, new Timestamp(data.getModifiedDateTime().getTime()));
        ps.setString(34, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM activity_log WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<ActivityLog> selectAll() throws SQLException {
    ArrayList<ActivityLog> result = new ArrayList<ActivityLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ActivityLog selectByPK(String handle) throws SQLException {
    ActivityLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ActivityLog> selectByRecent(Date start, Date end) throws SQLException {
    ArrayList<ActivityLog> result = new ArrayList<ActivityLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE ACTION_CODE = 'SFCREL' AND  PARTITION_DATE between ? and ? ORDER BY PARTITION_DATE")) {
      DateUtils.setDateTz(ps, 1, start);
      DateUtils.setDateTz(ps, 2, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ActivityLog selectByOperationSfc(String operation, String sfc) throws SQLException {
    ActivityLog result = new ActivityLog();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE ACTION_CODE IN (\n"
        + "'START'\n"
        + ")  AND OPERATION = ?  and SFC = ? ORDER BY DATE_TIME desc ")) {
      ps.setString(1, operation);
      ps.setString(2, sfc);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ActivityLog> selectByRecentAA(Date start, Date end) throws SQLException {
    ArrayList<ActivityLog> result = new ArrayList<ActivityLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL +
        " WHERE ACTION_CODE = 'SFCREL' AND exists(SELECT 1 " +
        "               FROM view_sfc_item v  " +
        "              WHERE v.SFC_NAME = SFC  " +
        "                AND v.SHOP_ORDER_BO = SHOP_ORDER_BO " +
        "                AND v.CUSTOMER IN('AA')  )" +
        "                AND  PARTITION_DATE between ? and ? ORDER BY PARTITION_DATE")) {
      DateUtils.setDateTz(ps, 1, start);
      DateUtils.setDateTz(ps, 2, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ActivityLog> selectByRecent77(Date start, Date end) throws SQLException {
    ArrayList<ActivityLog> result = new ArrayList<ActivityLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL +
        " WHERE ACTION_CODE = 'SFCREL' AND exists(SELECT 1 " +
        "               FROM view_sfc_item v  " +
        "              WHERE v.SFC_NAME = SFC  " +
        "                AND v.SHOP_ORDER_BO = SHOP_ORDER_BO " +
        "                AND v.CUSTOMER IN('77')  )" +
        "                AND  PARTITION_DATE between ? and ? ORDER BY PARTITION_DATE")) {
      DateUtils.setDateTz(ps, 1, start);
      DateUtils.setDateTz(ps, 2, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ActivityLog> selectByRecentKR001(Date start, Date end) throws SQLException {
    ArrayList<ActivityLog> result = new ArrayList<ActivityLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL +
        " WHERE ACTION_CODE = 'SFCREL' AND exists(SELECT 1 " +
        "               FROM view_sfc_item v  " +
        "              WHERE v.SFC_NAME = SFC  " +
        "                AND v.SHOP_ORDER_BO = SHOP_ORDER_BO " +
        "                AND v.CUSTOMER IN('KR001')  )" +
        "                AND  PARTITION_DATE between ? and ? ORDER BY PARTITION_DATE")) {
      DateUtils.setDateTz(ps, 1, start);
      DateUtils.setDateTz(ps, 2, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ActivityLog> selectByOperationAndSfcAndCode(String operation, String sfc,
      String shopOrderBo, String actionCode) throws SQLException {
    ArrayList<ActivityLog> result = new ArrayList<ActivityLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE OPERATION = ? and SFC = ? and SHOP_ORDER_BO=? and ACTION_CODE = ? ORDER BY DATE_TIME desc ")) {
      ps.setString(1, operation);
      ps.setString(2, sfc);
      ps.setString(3, shopOrderBo);
      ps.setString(4, actionCode);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ActivityLog convert(ResultSet rs) throws SQLException {
    ActivityLog data = new ActivityLog();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setChangeStamp(rs.getBigDecimal(index++));
    data.setActionCode(rs.getString(index++));
    data.setActionDetail(rs.getString(index++));
    data.setActionDetailHandle(rs.getString(index++));
    data.setActivity(rs.getString(index++));
    data.setDateTime(rs.getTimestamp(index++));
    data.setCrew(rs.getString(index++));
    data.setUserId(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setProcessLot(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setOperationRevision(rs.getString(index++));
    data.setItem(rs.getString(index++));
    data.setItemRevision(rs.getString(index++));
    data.setRouter(rs.getString(index++));
    data.setRouterRevision(rs.getString(index++));
    data.setStepId(rs.getString(index++));
    data.setSubstep(rs.getString(index++));
    data.setSubstepId(rs.getString(index++));
    data.setResrce(rs.getString(index++));
    data.setWorkCenter(rs.getString(index++));
    data.setQty(rs.getBigDecimal(index++));
    data.setRework(rs.getString(index++));
    data.setReportingCenterBo(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setPartitionDate(rs.getTimestamp(index++));
    data.setLccBo(rs.getString(index++));
    data.setActionSpan(rs.getBigDecimal(index++));
    data.setPrevSite(rs.getString(index++));
    data.setTxnId(rs.getString(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));
    data.setModifiedDateTime(rs.getTimestamp(index++));

    return data;
  }

  private FullLotReportResult convertReport(ResultSet rs) throws SQLException {
    FullLotReportResult data = new FullLotReportResult();

    data.activityLogs.setSfc(rs.getString(1));
    data.activityLogs.setShopOrderBo(rs.getString(2));
    data.activityLogs.setOperation(rs.getString(3));
    data.activityLogs.setRework(rs.getString(4));
    data.activityLogs.setResrce(rs.getString(5));
    data.activityLogs.setUserId(rs.getString(6));
    data.activityLogs.setActionCode(rs.getString(7));
    data.activityLogs.setDateTime(DateUtils.getDateTz(rs, 8));
    data.activityLogs.setActionDetailHandle(rs.getString(9));
    data.activityLogs.setRouter(rs.getString(10));
    data.activityLogs.setActionDetail(rs.getString(11));

    return data;
  }
}
