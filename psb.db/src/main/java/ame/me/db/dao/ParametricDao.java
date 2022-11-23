package ame.me.db.dao;

import ame.me.db.Parametric;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ParametricDao {

  private static final String SQL_INS = "INSERT INTO parametric(handle,transaction_id,site,para_context_gbo,type,start_time,stop_time,resource_bo,work_center_bo,user_bo,customer_id,item_bo,operation_bo,router_bo,router_sequence,lot_id,program_id,program_rev,test_status,test_passed,shift_id,shop_order,test_plan_bo,dc_group_bo,diagnostics,times_processed,setup_time_ms,unload_time_ms,tester_hw_rev,tester_test_seq,tester_test_seq_rev,tester_type,prev_site,elapsed_time,original_transfer_key,original_sfc_bo,created_date_time,modified_date_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE parametric SET transaction_id=?,site=?,para_context_gbo=?,type=?,start_time=?,stop_time=?,resource_bo=?,work_center_bo=?,user_bo=?,customer_id=?,item_bo=?,operation_bo=?,router_bo=?,router_sequence=?,lot_id=?,program_id=?,program_rev=?,test_status=?,test_passed=?,shift_id=?,shop_order=?,test_plan_bo=?,dc_group_bo=?,diagnostics=?,times_processed=?,setup_time_ms=?,unload_time_ms=?,tester_hw_rev=?,tester_test_seq=?,tester_test_seq_rev=?,tester_type=?,prev_site=?,elapsed_time=?,original_transfer_key=?,original_sfc_bo=?,created_date_time=?,modified_date_time=? WHERE handle=? ";

  private static final String SQL_SEL = "SELECT handle,transaction_id,site,para_context_gbo,type,start_time,stop_time,resource_bo,work_center_bo,user_bo,customer_id,item_bo,operation_bo,router_bo,router_sequence,lot_id,program_id,program_rev,test_status,test_passed,shift_id,shop_order,test_plan_bo,dc_group_bo,diagnostics,times_processed,setup_time_ms,unload_time_ms,tester_hw_rev,tester_test_seq,tester_test_seq_rev,tester_type,prev_site,elapsed_time,original_transfer_key,original_sfc_bo,created_date_time,modified_date_time FROM parametric ";

  private static final String SQL_DEL = "DELETE FROM parametric WHERE handle=? ";

  private final Connection conn;

  public ParametricDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Parametric data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setBigDecimal(2, data.getTransactionId());
      ps.setString(3, data.getSite());
      ps.setString(4, data.getParaContextGbo());
      ps.setString(5, data.getType());
      ps.setTimestamp(6,
          data.getStartTime() == null ? null : new Timestamp(data.getStartTime().getTime()));
      ps.setTimestamp(7,
          data.getStopTime() == null ? null : new Timestamp(data.getStopTime().getTime()));
      ps.setString(8, data.getResourceBo());
      ps.setString(9, data.getWorkCenterBo());
      ps.setString(10, data.getUserBo());
      ps.setString(11, data.getCustomerId());
      ps.setString(12, data.getItemBo());
      ps.setString(13, data.getOperationBo());
      ps.setString(14, data.getRouterBo());
      if (data.getRouterSequence() != null && data.getRouterSequence() > 0) {
        ps.setInt(15, data.getRouterSequence());
      } else {
        ps.setNull(15, Types.INTEGER);
      }
      ps.setString(16, data.getLotId());
      ps.setString(17, data.getProgramId());
      ps.setString(18, data.getProgramRev());
      ps.setString(19, data.getTestStatus());
      ps.setString(20, data.getTestPassed());
      ps.setString(21, data.getShiftId());
      ps.setString(22, data.getShopOrder());
      ps.setString(23, data.getTestPlanBo());
      ps.setString(24, data.getDcGroupBo());
      ps.setString(25, data.getDiagnostics());
      if (data.getTimesProcessed() != null && data.getTimesProcessed() > 0) {
        ps.setInt(26, data.getTimesProcessed());
      } else {
        ps.setNull(26, Types.INTEGER);
      }
      if (data.getSetupTimeMs() != null && data.getSetupTimeMs() > 0) {
        ps.setInt(27, data.getSetupTimeMs());
      } else {
        ps.setNull(27, Types.INTEGER);
      }
      if (data.getUnloadTimeMs() != null && data.getUnloadTimeMs() > 0) {
        ps.setInt(28, data.getUnloadTimeMs());
      } else {
        ps.setNull(28, Types.INTEGER);
      }
      ps.setString(29, data.getTesterHwRev());
      ps.setString(30, data.getTesterTestSeq());
      ps.setString(31, data.getTesterTestSeqRev());
      ps.setString(32, data.getTesterType());
      ps.setString(33, data.getPrevSite());
      if (data.getElapsedTime() != null && data.getElapsedTime() > 0) {
        ps.setInt(34, data.getElapsedTime());
      } else {
        ps.setNull(34, Types.INTEGER);
      }
      ps.setString(35, data.getOriginalTransferKey());
      ps.setString(36, data.getOriginalSfcBo());
      ps.setTimestamp(37, data.getCreatedDateTime() == null ? null
          : new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setTimestamp(38, data.getModifiedDateTime() == null ? null
          : new Timestamp(data.getModifiedDateTime().getTime()));

      return ps.executeUpdate();
    }
  }

  public int update(Parametric data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {

      ps.setBigDecimal(1, data.getTransactionId());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getParaContextGbo());
      ps.setString(4, data.getType());
      ps.setTimestamp(5,
          data.getStartTime() == null ? null : new Timestamp(data.getStartTime().getTime()));
      ps.setTimestamp(6,
          data.getStopTime() == null ? null : new Timestamp(data.getStopTime().getTime()));
      ps.setString(7, data.getResourceBo());
      ps.setString(8, data.getWorkCenterBo());
      ps.setString(9, data.getUserBo());
      ps.setString(10, data.getCustomerId());
      ps.setString(11, data.getItemBo());
      ps.setString(12, data.getOperationBo());
      ps.setString(13, data.getRouterBo());
      ps.setInt(14, data.getRouterSequence());
      ps.setString(15, data.getLotId());
      ps.setString(16, data.getProgramId());
      ps.setString(17, data.getProgramRev());
      ps.setString(18, data.getTestStatus());
      ps.setString(19, data.getTestPassed());
      ps.setString(20, data.getShiftId());
      ps.setString(21, data.getShopOrder());
      ps.setString(22, data.getTestPlanBo());
      ps.setString(23, data.getDcGroupBo());
      ps.setString(24, data.getDiagnostics());
      ps.setInt(25, data.getTimesProcessed());
      ps.setInt(26, data.getSetupTimeMs());
      ps.setInt(27, data.getUnloadTimeMs());
      ps.setString(28, data.getTesterHwRev());
      ps.setString(29, data.getTesterTestSeq());
      ps.setString(30, data.getTesterTestSeqRev());
      ps.setString(31, data.getTesterType());
      ps.setString(32, data.getPrevSite());
      ps.setInt(33, data.getElapsedTime());
      ps.setString(34, data.getOriginalTransferKey());
      ps.setString(35, data.getOriginalSfcBo());
      ps.setTimestamp(36, data.getCreatedDateTime() == null ? null
          : new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setTimestamp(37, data.getModifiedDateTime() == null ? null
          : new Timestamp(data.getModifiedDateTime().getTime()));
      ps.setString(38, data.getHandle());
      return ps.executeUpdate();
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_DEL)) {
      ps.setString(1, handle);
      return ps.executeUpdate();
    }
  }

  public List<Parametric> selectAll() throws SQLException {
    ArrayList<Parametric> result = new ArrayList<Parametric>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public Parametric selectByPk(String handle) throws Exception {
    Parametric result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE handle=? ")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private Parametric convert(ResultSet rs) throws SQLException {
    Parametric data = new Parametric();

    data.setHandle(rs.getString(1));
    data.setTransactionId(rs.getBigDecimal(2));
    data.setSite(rs.getString(3));
    data.setParaContextGbo(rs.getString(4));
    data.setType(rs.getString(5));
    data.setStartTime(rs.getTimestamp(6));
    data.setStopTime(rs.getTimestamp(7));
    data.setResourceBo(rs.getString(8));
    data.setWorkCenterBo(rs.getString(9));
    data.setUserBo(rs.getString(10));
    data.setCustomerId(rs.getString(11));
    data.setItemBo(rs.getString(12));
    data.setOperationBo(rs.getString(13));
    data.setRouterBo(rs.getString(14));
    data.setRouterSequence(rs.getInt(15));
    data.setLotId(rs.getString(16));
    data.setProgramId(rs.getString(17));
    data.setProgramRev(rs.getString(18));
    data.setTestStatus(rs.getString(19));
    data.setTestPassed(rs.getString(20));
    data.setShiftId(rs.getString(21));
    data.setShopOrder(rs.getString(22));
    data.setTestPlanBo(rs.getString(23));
    data.setDcGroupBo(rs.getString(24));
    data.setDiagnostics(rs.getString(25));
    data.setTimesProcessed(rs.getInt(26));
    data.setSetupTimeMs(rs.getInt(27));
    data.setUnloadTimeMs(rs.getInt(28));
    data.setTesterHwRev(rs.getString(29));
    data.setTesterTestSeq(rs.getString(30));
    data.setTesterTestSeqRev(rs.getString(31));
    data.setTesterType(rs.getString(32));
    data.setPrevSite(rs.getString(33));
    data.setElapsedTime(rs.getInt(34));
    data.setOriginalTransferKey(rs.getString(35));
    data.setOriginalSfcBo(rs.getString(36));
    data.setCreatedDateTime(rs.getTimestamp(37));
    data.setModifiedDateTime(rs.getTimestamp(38));

    return data;
  }
}
