package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.DispatchSfc;
import ame.psb.db.QueryFTFifoResult;
import ame.psb.db.ViewDispatchSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class DispatchSfcDao {

  private static final String SQL_INS = "INSERT INTO zr_dispatch_sfc(sfc_step_bo,state_name,dpt_no,lot_type,in_time,out_time,in_min_time,in_max_time,out_min_time,out_max_time,hot_level,rework,queue_time_flag,hold_flag,cycle_time,recipe_type,recipe_name,capability,assign_recipe_name,assign_resources,track_in_count,track_out_count,assign_instruction,sfc_bo,cycle_time_total,hot_level_flag,hot_level_reason,receive_date_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_dispatch_sfc SET state_name=?,dpt_no=?,lot_type=?,in_time=?,out_time=?,in_min_time=?,in_max_time=?,out_min_time=?,out_max_time=?,hot_level=?,rework=?,queue_time_flag=?,hold_flag=?,cycle_time=?,recipe_type=?,recipe_name=?,capability=?,assign_recipe_name=?,assign_resources=?,track_in_count=?,track_out_count=?,assign_instruction=?,sfc_bo=?,cycle_time_total=?,hot_level_flag=?,hot_level_reason=?,receive_date_time=? WHERE sfc_step_bo=?";

  private static final String SQL_SEL = "SELECT sfc_step_bo,state_name,dpt_no,lot_type,in_time,out_time,in_min_time,in_max_time,out_min_time,out_max_time,hot_level,rework,queue_time_flag,hold_flag,cycle_time,recipe_type,recipe_name,capability,assign_recipe_name,assign_resources,assign_instruction,track_in_count,track_out_count,cycle_time_total,hot_level_flag,hot_level_reason,receive_date_time,shop_order_bo,shop_order,sfc_bo,sfc,sfc_router_bo,sfc_router_seq,sfc_step_seq,router_bo,operation_bo,done,bypassed,qty_in_queue,qty_in_work,qty_completed,qty_complete_pending,qty_rejected,previously_started,previous_step_id,previous_resource_bo,date_queued,item_bo,scheduled_comp_date,planned_comp_date,resource_bo,work_center_bo,item_group_bo,planned_start_date,scheduled_start_date,sfc_state_name,current_run,customer_itemset_bo,priority,item_qty,item_name,device_bo,device_name,package_bo,package_name,router_name,sfc_qty,customer,status_bo,customer_itemset_name,remark,customer_itemset_name_orig,carrier_bo,carrier_name,carrier_state_name,curr_seq,sfc_type,created_date_time,resource_slot_id,batch_id,bumping_sod,wlp_sod,cp_sod,fc_sod ";

  // private static final String SQL_CYCLE_TIME_SUM_MAIN = "SELECT SUM(cycle_time)
  // cycle_time FROM view_dispatch_sfc WHERE sfc_bo=? AND sfc_router_seq=1 AND
  // done='false' AND bypassed='false' GROUP BY sfc_bo";

  private static final String SQL_CYCLE_TIME_SUM_MAIN = "SELECT SUM(d.cycle_time) cycle_time FROM zr_dispatch_sfc d,sfc_step s WHERE d.sfc_step_bo=s.handle AND d.sfc_bo=? AND s.done='false' AND s.bypassed='false' GROUP BY d.sfc_bo";

  // private static final String SQL_CYCLE_TIME_SUM_ALL = "SELECT SUM(cycle_time)
  // cycle_time FROM view_dispatch_sfc WHERE sfc_bo=? AND done='false' AND
  // bypassed='false' GROUP BY sfc_bo";

  private static final String SQL_WCP = "SELECT DISTINCT OPERATION_BO FROM VIEW_DISPATCH_SFC WHERE SHOP_ORDER_BO = ? AND STATE_NAME = 'WAIT' AND SFC_TYPE = 'S' AND OPERATION_BO LIKE 'OperationBO:1020,WCP%';";

  private static final String SQL_FT_FIFO_WAITING =
      "SELECT A.SFC,A.DATE_QUEUED,A.SHOP_ORDER,A.OPERATION_BO,B.LOCATION_DATA,A.SFC_STATE_NAME,C.DESCRIPTION,D.STATE FROM view_dispatch_sfc_waiting A \n"
          + "LEFT JOIN zd_ft_location_data B ON A.SHOP_ORDER_BO = B.SHOP_ORDER_BO "
          + " LEFT JOIN OPERATION C ON replace(A.OPERATION_BO,'#','A') =  C.HANDLE "
          + "  LEFT JOIN ZR_CANCEL_SFC D ON A.SHOP_ORDER = D.SHOP_ORDER_NAME "
          + " WHERE A.OPERATION_BO = ? AND A.CUSTOMER = ? AND A.DEVICE_NAME = ? ORDER BY A.DATE_QUEUED DESC";

  private static final String SQL_FT_FIFO_RUNNING =
      "SELECT A.SFC,A.DATE_QUEUED,A.SHOP_ORDER,A.OPERATION_BO,B.LOCATION_DATA,A.SFC_STATE_NAME,C.DESCRIPTION,D.STATE FROM view_dispatch_sfc_running A \n"
          + "LEFT JOIN zd_ft_location_data B ON A.SHOP_ORDER_BO = B.SHOP_ORDER_BO "
          + " LEFT JOIN OPERATION C ON replace(A.OPERATION_BO,'#','A') =  C.HANDLE "
          + "  LEFT JOIN ZR_CANCEL_SFC D ON A.SHOP_ORDER = D.SHOP_ORDER_NAME "
          + " WHERE A.OPERATION_BO = ? AND A.CUSTOMER = ? AND A.DEVICE_NAME = ? ORDER BY A.DATE_QUEUED DESC";
  private Connection conn;

  public DispatchSfcDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DispatchSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcStepBo());
      ps.setString(2, data.getStateName());
      ps.setString(3, data.getDptNo());
      ps.setString(4, data.getLotType());
      DateUtils.setDateTz(ps, 5, data.getInTime());
      DateUtils.setDateTz(ps, 6, data.getOutTime());
      DateUtils.setDateTz(ps, 7, data.getInMinTime());
      DateUtils.setDateTz(ps, 8, data.getInMaxTime());
      DateUtils.setDateTz(ps, 9, data.getOutMinTime());
      DateUtils.setDateTz(ps, 10, data.getOutMaxTime());
      ps.setInt(11, data.getHotLevel());
      ps.setString(12, data.getRework());
      ps.setString(13, data.getQueueTimeFlag());
      ps.setString(14, data.getHoldFlag());
      ps.setInt(15, data.getCycleTime());
      ps.setString(16, data.getRecipeType());
      ps.setString(17, data.getRecipeName());
      ps.setString(18, data.getCapability());
      ps.setString(19, data.getAssignRecipeName());
      ps.setString(20, data.getAssignResources());
      ps.setInt(21, data.getTrackInCount());
      ps.setInt(22, data.getTrackOutCount());
      ps.setString(23, data.getAssignInstruction());
      ps.setString(24, data.getSfcBo());
      ps.setInt(25, data.getCycleTimeTotal());
      ps.setString(26, data.getHotLevelFlag());
      ps.setString(27, data.getHotLevelReason());
      DateUtils.setDateTz(ps, 28, data.getReceiveDateTime());
      return ps.executeUpdate();
    }
  }

  public int insert(List<DispatchSfc> data) throws SQLException {
    if (data.size() == 0) {
      return 0;
    }
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DispatchSfc disp : data) {
        ps.setString(1, disp.getSfcStepBo());
        ps.setString(2, disp.getStateName());
        ps.setString(3, disp.getDptNo());
        ps.setString(4, disp.getLotType());
        DateUtils.setDateTz(ps, 5, disp.getInTime());
        DateUtils.setDateTz(ps, 6, disp.getOutTime());
        DateUtils.setDateTz(ps, 7, disp.getInMinTime());
        DateUtils.setDateTz(ps, 8, disp.getInMaxTime());
        DateUtils.setDateTz(ps, 9, disp.getOutMinTime());
        DateUtils.setDateTz(ps, 10, disp.getOutMaxTime());
        ps.setInt(11, disp.getHotLevel());
        ps.setString(12, disp.getRework());
        ps.setString(13, disp.getQueueTimeFlag());
        ps.setString(14, disp.getHoldFlag());
        ps.setInt(15, disp.getCycleTime());
        ps.setString(16, disp.getRecipeType());
        ps.setString(17, disp.getRecipeName());
        ps.setString(18, disp.getCapability());
        ps.setString(19, disp.getAssignRecipeName());
        ps.setString(20, disp.getAssignResources());
        ps.setInt(21, disp.getTrackInCount());
        ps.setInt(22, disp.getTrackOutCount());
        ps.setString(23, disp.getAssignInstruction());
        ps.setString(24, disp.getSfcBo());
        ps.setInt(25, disp.getCycleTimeTotal());
        ps.setString(26, disp.getHotLevelFlag());
        ps.setString(27, disp.getHotLevelReason());
        DateUtils.setDateTz(ps, 28, disp.getReceiveDateTime());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DispatchSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getStateName());
      ps.setString(2, data.getDptNo());
      ps.setString(3, data.getLotType());
      DateUtils.setDateTz(ps, 4, data.getInTime());
      DateUtils.setDateTz(ps, 5, data.getOutTime());
      DateUtils.setDateTz(ps, 6, data.getInMinTime());
      DateUtils.setDateTz(ps, 7, data.getInMaxTime());
      DateUtils.setDateTz(ps, 8, data.getOutMinTime());
      DateUtils.setDateTz(ps, 9, data.getOutMaxTime());
      ps.setInt(10, data.getHotLevel());
      ps.setString(11, data.getRework());
      ps.setString(12, data.getQueueTimeFlag());
      ps.setString(13, data.getHoldFlag());
      ps.setInt(14, data.getCycleTime());
      ps.setString(15, data.getRecipeType());
      ps.setString(16, data.getRecipeName());
      ps.setString(17, data.getCapability());
      ps.setString(18, data.getAssignRecipeName());
      ps.setString(19, data.getAssignResources());
      ps.setInt(20, data.getTrackInCount());
      ps.setInt(21, data.getTrackOutCount());
      ps.setString(22, data.getAssignInstruction());
      ps.setString(23, data.getSfcBo());
      ps.setInt(24, data.getCycleTimeTotal());
      ps.setString(25, data.getHotLevelFlag());
      ps.setString(26, data.getHotLevelReason());
      DateUtils.setDateTz(ps, 27, data.getReceiveDateTime());
      ps.setString(28, data.getSfcStepBo());
      return ps.executeUpdate();
    }
  }

  public int updateTime(DispatchSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_dispatch_sfc SET  IN_TIME =?,OUT_TIME =? ,IN_MIN_TIME=? , IN_MAX_TIME =? ,OUT_MIN_TIME =? , OUT_MAX_TIME =? ,queue_time_flag=? WHERE sfc_step_bo=?")) {
      DateUtils.setDateTz(ps, 1, data.getInTime());
      DateUtils.setDateTz(ps, 2, data.getOutTime());
      DateUtils.setDateTz(ps, 3, data.getInMinTime());
      DateUtils.setDateTz(ps, 4, data.getInMaxTime());
      DateUtils.setDateTz(ps, 5, data.getOutMinTime());
      DateUtils.setDateTz(ps, 6, data.getOutMaxTime());
      ps.setString(7, data.getQueueTimeFlag());
      ps.setString(8, data.getSfcStepBo());
      return ps.executeUpdate();
    }
  }

  public int update(List<DispatchSfc> data) throws SQLException {
    if (data.size() == 0) {
      return 0;
    }
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DispatchSfc disp : data) {
        ps.setString(1, disp.getStateName());
        ps.setString(2, disp.getDptNo());
        ps.setString(3, disp.getLotType());
        DateUtils.setDateTz(ps, 4, disp.getInTime());
        DateUtils.setDateTz(ps, 5, disp.getOutTime());
        DateUtils.setDateTz(ps, 6, disp.getInMinTime());
        DateUtils.setDateTz(ps, 7, disp.getInMaxTime());
        DateUtils.setDateTz(ps, 8, disp.getOutMinTime());
        DateUtils.setDateTz(ps, 9, disp.getOutMaxTime());
        ps.setInt(10, disp.getHotLevel());
        ps.setString(11, disp.getRework());
        ps.setString(12, disp.getQueueTimeFlag());
        ps.setString(13, disp.getHoldFlag());
        ps.setInt(14, disp.getCycleTime());
        ps.setString(15, disp.getRecipeType());
        ps.setString(16, disp.getRecipeName());
        ps.setString(17, disp.getCapability());
        ps.setString(18, disp.getAssignRecipeName());
        ps.setString(19, disp.getAssignResources());
        ps.setInt(20, disp.getTrackInCount());
        ps.setInt(21, disp.getTrackOutCount());
        ps.setString(22, disp.getAssignInstruction());
        ps.setString(23, disp.getSfcBo());
        ps.setInt(24, disp.getCycleTimeTotal());
        ps.setString(25, disp.getHotLevelFlag());
        ps.setString(26, disp.getHotLevelReason());
        DateUtils.setDateTz(ps, 27, disp.getReceiveDateTime());
        ps.setString(28, disp.getSfcStepBo());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int clearQueueTime(String sfcStepBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_dispatch_sfc SET in_min_time=null,in_max_time=null,out_min_time=null,out_max_time=null WHERE sfc_step_bo=?")) {
      ps.setString(1, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public int clearQueueTimeUpdateLevel(String sfcStepBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_dispatch_sfc SET in_min_time=null,in_max_time=null,out_min_time=null,out_max_time=null,hot_level=2 WHERE sfc_step_bo=?")) {
      ps.setString(1, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public int updateRecipe(String sfcStepBo, String recipeName, String recipeType)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_dispatch_sfc SET RECIPE_NAME = ?,RECIPE_TYPE =?  WHERE sfc_step_bo=?")) {
      ps.setString(1, recipeName);
      ps.setString(2, recipeType);
      ps.setString(3, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public int updateRecipe(List<ViewDispatchSfc> data) throws SQLException {
    if (data.size() == 0) {
      return 0;
    }
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_dispatch_sfc SET RECIPE_NAME = ?,RECIPE_TYPE =?  WHERE sfc_step_bo=?")) {
      for (ViewDispatchSfc disp : data) {
        ps.setString(1, disp.getRecipeName());
        ps.setString(2, disp.getRecipeType());
        ps.setString(3, disp.getSfcStepBo());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateAssignResources(String assignResources, String sfcStepBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE ZR_DISPATCH_SFC SET  ASSIGN_RESOURCES = ? WHERE SFC_STEP_BO = ?")) {
      ps.setString(1, assignResources);
      ps.setString(2, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public int updateCapability(String sfcStepBo, String capability) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_dispatch_sfc SET capability=? WHERE sfc_step_bo=?")) {
      ps.setString(1, capability);
      ps.setString(2, sfcStepBo);
      return ps.executeUpdate();
    }
  }


  public int updateQueueTimeFlag(String sfcStepBo, String queueTimeFlag) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_dispatch_sfc SET queue_time_flag=? WHERE sfc_step_bo=?")) {
      ps.setString(1, queueTimeFlag);
      ps.setString(2, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public int updateHoldFlag(String sfcStepBo, String queueTimeFlag) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_dispatch_sfc SET hold_flag=? WHERE sfc_step_bo=?")) {
      ps.setString(1, queueTimeFlag);
      ps.setString(2, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public int updateHotLevel(String sfcStepBo, String hotLevel) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_dispatch_sfc SET hot_level=? WHERE sfc_step_bo=?")) {
      ps.setString(1, hotLevel);
      ps.setString(2, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public int updateHotLevelBySfc(String sfcBo, String hotLevel) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_dispatch_sfc SET hot_level=? WHERE sfc_bo=?")) {
      ps.setString(1, hotLevel);
      ps.setString(2, sfcBo);
      return ps.executeUpdate();
    }
  }

  public int updateRework(String sfcStepBo, boolean rework) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_dispatch_sfc SET rework=? WHERE sfc_step_bo=?")) {
      ps.setString(1, rework ? "Y" : "N");
      ps.setString(2, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public int updateRecipeType(String sfcStepBo, String recipeType) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_dispatch_sfc SET RECIPE_TYPE=? WHERE sfc_step_bo=?")) {
      ps.setString(1, recipeType);
      ps.setString(2, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public int changeState(String sfcStepBo, String stateName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_dispatch_sfc SET state_name=? WHERE sfc_step_bo=?")) {
      ps.setString(1, stateName);
      ps.setString(2, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public int changeQueueTimeFlag(String sfcStepBo, String stateName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_dispatch_sfc SET QUEUE_TIME_FLAG=? WHERE sfc_step_bo=?")) {
      ps.setString(1, stateName);
      ps.setString(2, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public int resetQueueTime(String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_dispatch_sfc SET in_min_time=null,in_max_time=null,out_min_time=null,out_max_time=null WHERE sfc_bo=? ")) {
      ps.setString(1, sfcBo);
      return ps.executeUpdate();
    }
  }

  public int changeState(String sfcStepBo, String stateName, Date outTime) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "UPDATE zr_dispatch_sfc SET state_name=?,out_time=? WHERE sfc_step_bo=?")) {
      ps.setString(1, stateName);
      DateUtils.setDateTz(ps, 2, outTime);
      ps.setString(3, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public int updateCycleTime(String sfcStepBo, int cycleTime) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_dispatch_sfc SET cycle_time=? WHERE sfc_step_bo=?")) {
      ps.setInt(1, cycleTime);
      ps.setString(2, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public int addTrackInCount(String sfcStepBo, int add) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_dispatch_sfc SET track_in_count=track_in_count+(" + add
            + ") WHERE sfc_step_bo=?")) {
      ps.setString(1, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public int addTrackOutCount(String sfcStepBo, int add) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_dispatch_sfc SET track_out_count=track_out_count+(" + add
            + ") WHERE sfc_step_bo=?")) {
      ps.setString(1, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public int cancelPriorityCheck(String sfcStepBo, String reason) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_dispatch_sfc SET hot_level_flag='N', hot_level_reason=? WHERE sfc_step_bo=?")) {
      ps.setString(1, reason);
      ps.setString(2, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public int enablePriorityCheck(String sfcStepBo, String reason) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_dispatch_sfc SET hot_level_flag='Y', hot_level_reason=? WHERE sfc_step_bo=?")) {
      ps.setString(1, reason);
      ps.setString(2, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public List<ViewDispatchSfc> selectByReason(String reason) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "FROM view_dispatch_sfc_waiting WHERE hot_level_reason=? ")) {
      ps.setString(1, reason);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public int receive(String sfcStepBo, Date date) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_dispatch_sfc SET receive_date_time=? WHERE sfc_step_bo=?")) {
      DateUtils.setDateTz(ps, 1, date);
      ps.setString(2, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public List<ViewDispatchSfc> selectByPKList(String sfcBo, String operationBo)
      throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "FROM view_dispatch_sfc WHERE sfc_bo=? AND operation_bo=? ORDER BY sfc_step_bo")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectAll() throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "FROM view_dispatch_sfc")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;

  }

  public ViewDispatchSfc selectByPK(String sfcStepBo) throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "FROM view_dispatch_sfc WHERE sfc_step_bo=?")) {
      ps.setString(1, sfcStepBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }

  /*
   * cc
   * */
  public ViewDispatchSfc selectByPK2(String sfcBo, String operationBo) throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "FROM view_dispatch_sfc WHERE sfc_bo=? AND operation_bo=? ORDER BY sfc_step_bo")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }

  /*
   * selectBySfcBo
   * cc
   * */
  public ViewDispatchSfc selectBySfcBo(String sfcBo) throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "FROM view_dispatch_sfc WHERE sfc_bo=? ORDER BY sfc_step_bo")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }


  public ViewDispatchSfc selectByPKsfcBoAndsfcStepSeq(String sfcBo, String sfcStepSeq)
      throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "FROM view_dispatch_sfc WHERE sfc_bo = ? and  SFC_STEP_SEQ = ?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, sfcStepSeq);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }

  public ViewDispatchSfc selectByPKOrderByInTime(String sfcBo, String operationBo)
      throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "FROM view_dispatch_sfc WHERE sfc =? AND operation_bo=? ORDER BY IN_TIME DESC")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }

  public ViewDispatchSfc selectBySfcBoPKOrderByInTime(String sfcBo, String operationBo)
      throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "FROM view_dispatch_sfc WHERE sfc_bo =? AND operation_bo=? ORDER BY IN_TIME DESC")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }

  public ViewDispatchSfc selectByWaferResource(String wafer, String resourceBo)
      throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "FROM view_dispatch_sfc WHERE CUSTOMER_ITEMSET_NAME =? AND PREVIOUS_RESOURCE_BO=? ORDER BY IN_TIME DESC")) {
      ps.setString(1, wafer);
      ps.setString(2, resourceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }


  public ViewDispatchSfc selectByPK(String sfcBo, String operationBo) throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "FROM view_dispatch_sfc WHERE sfc_bo=? AND operation_bo=? ORDER BY sfc_step_bo")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }

  public ViewDispatchSfc selectBySfcAndIsp(String sfcBo) throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "FROM view_dispatch_sfc WHERE sfc_bo=? AND operation_bo in('OperationBO:1020,WTR-ISP,#','OperationBO:1020,FTR-ISP,#','OperationBO:1020,WTR-EQC-TR,#') "
            + "ORDER BY sfc_step_bo")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }

  public List<ViewDispatchSfc> selectByLimited(Date start, Date end) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "FROM view_dispatch_sfc WHERE OPERATION_BO = 'OperationBO:1020,WCP-ISP,#' AND STATE_NAME = 'RUN_FINISH' "
            + "AND OUT_TIME IS NOT NULL  AND (OUT_TIME BETWEEN ? AND ?) ORDER BY OUT_TIME")) {
      DateUtils.setDateTz(ps, 1, start);
      DateUtils.setDateTz(ps, 2, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ViewDispatchSfc> selectByCustLot(String custLot) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "FROM view_dispatch_sfc WHERE CUSTOMER_ITEMSET_NAME =?")) {
      ps.setString(1, custLot);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public int deleteByPK(String sfcStepBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("delete from zr_dispatch_sfc WHERE sfc_step_bo=?")) {
      ps.setString(1, sfcStepBo);
      return ps.executeUpdate();
    }
  }

  public List<ViewDispatchSfc> selectByCP(Date start, Date end) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "FROM view_dispatch_sfc "
            + "WHERE (OPERATION_BO LIKE '%WCP%TEST%' OR OPERATION_BO LIKE '%FCP%TEST%')"
            + " AND STATE_NAME = 'RUN_FINISH' "
            + " AND IN_TIME IS NOT NULL "
            + " AND (IN_TIME BETWEEN ? AND ?) "
            + " ORDER BY IN_TIME desc ")) {
      DateUtils.setDateTz(ps, 1, start);
      DateUtils.setDateTz(ps, 2, end);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "FROM view_dispatch_sfc WHERE sfc_bo=? ORDER BY sfc_router_seq,sfc_step_seq")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectByShopOrderAndOperationBo(String shopOrderBo,
      String operationBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "FROM VIEW_DISPATCH_SFC WHERE SHOP_ORDER_BO = ? and OPERATION_BO = ? ")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectByShopOrderBo(String shopOrderBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "FROM view_dispatch_sfc WHERE shop_order_bo = ? ")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectByShopOrderBoStateFinish(String shopOrderBo,
      String operationBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "FROM view_dispatch_sfc WHERE shop_order_bo = ? AND operation_bo=? AND STATE_NAME = 'FINISH' ")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectByShopOrderOP(String shopOrderBo,
      String operationBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "FROM view_dispatch_sfc WHERE shop_order_bo = ? AND operation_bo=? order by out_time ")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectByShopOrderBoStateRunFinish(String shopOrderBo,
      String operationBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "FROM view_dispatch_sfc WHERE shop_order_bo = ? AND operation_bo=? AND STATE_NAME = 'RUN_FINISH' ")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectBySfcWithoutRWK(String sfcBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "FROM view_dispatch_sfc WHERE sfc_bo=? and sfc_router_seq = 1 ORDER BY sfc_router_seq,sfc_step_seq")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectFutureBySfc(String sfcBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "FROM view_dispatch_sfc WHERE sfc_bo=? AND done<>'true' AND sfc_router_seq=1 ORDER BY sfc_router_seq,sfc_step_seq")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public ViewDispatchSfc selectNextByStep(int step, String sfcBo) throws SQLException {
    ViewDispatchSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "FROM view_dispatch_sfc WHERE sfc_bo=? AND SFC_STEP_SEQ>? ORDER BY sfc_router_seq,sfc_step_seq")) {
      ps.setString(1, sfcBo);
      ps.setInt(2, step);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  /*
   * cc
   * 根据指定站点查找上一站点
   * */
  public ViewDispatchSfc selectPreviousByStep(int step, String sfcBo) throws SQLException {
    ViewDispatchSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "FROM view_dispatch_sfc WHERE sfc_bo=? AND SFC_STEP_SEQ<? ORDER BY sfc_router_seq,sfc_step_seq desc limit '1' ")) {
      ps.setString(1, sfcBo);
      ps.setInt(2, step);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public ViewDispatchSfc selectNextByStepAndRouter(String sfcBo, int routerSeq, int stepSeq)
      throws SQLException { //通过生产批号、路径序号、站点序号获取下一个站点
    ViewDispatchSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "FROM view_dispatch_sfc WHERE sfc_bo=? AND sfc_router_seq=? AND SFC_STEP_SEQ>? ORDER BY sfc_router_seq,sfc_step_seq")) {
      ps.setString(1, sfcBo);
      ps.setInt(2, routerSeq);
      ps.setInt(3, stepSeq);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public ViewDispatchSfc selectByStep(int step, String sfcBo) throws SQLException {
    ViewDispatchSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "FROM view_dispatch_sfc WHERE sfc_bo=? AND SFC_STEP_SEQ=?")) {
      ps.setString(1, sfcBo);
      ps.setInt(2, step);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectBySfc(String sfcBo, int sfcRouterSeq) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "FROM view_dispatch_sfc WHERE sfc_bo=? AND sfc_router_seq=? ORDER BY sfc_step_seq")) {
      ps.setString(1, sfcBo);
      ps.setInt(2, sfcRouterSeq);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectDoneBySfc(String sfcBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "FROM view_dispatch_sfc WHERE sfc_bo=? AND done='true' ORDER BY date_queued DESC")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectByItemGroupBoAndOperationBo(String itemGroupBo,
      String operationBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "FROM view_dispatch_sfc WHERE ITEM_GROUP_BO=? AND OPERATION_BO=? ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectOnlineWaitingByItemGroup(String itemGroupBo)
      throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "FROM view_dispatch_sfc_waiting WHERE ITEM_GROUP_BO=?  ORDER BY sfc_step_seq DESC")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectOnlineRunningByItemGroup(String itemGroupBo)
      throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "FROM view_dispatch_sfc_running WHERE ITEM_GROUP_BO=?  ORDER BY sfc_step_seq DESC")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public ViewDispatchSfc selectLastDoneBySfc(String sfcBo) throws SQLException {
    ViewDispatchSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "FROM view_dispatch_sfc WHERE sfc_bo=? AND done='Y' ORDER BY date_queued DESC")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        this.convert(rs);
      }
    }
    return result;
  }

  public ViewDispatchSfc selectFutureBySfcBoAndOperation(String sfcBo, String operationBo)
      throws SQLException {
    ViewDispatchSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "FROM view_dispatch_sfc WHERE sfc_bo=? AND operation_bo=? ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }


  public ViewDispatchSfc selectBeforeBySfc(String sfcBo) throws SQLException {
    ViewDispatchSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "FROM view_dispatch_sfc WHERE sfc_bo=? AND state_name = 'RUN_FINISH' ORDER BY in_time DESC ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectRunningByItemGroup(String itemGroup, String operation)
      throws SQLException {
    List<ViewDispatchSfc> dispatch = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "FROM view_dispatch_sfc_running WHERE ITEM_GROUP_BO =?  and OPERATION_BO = ? and STATE_NAME NOT IN ('RUN_HOLD')")) {
      ps.setString(1, itemGroup);
      ps.setString(2, operation);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        dispatch.add(this.convert(rs));
      }
    }
    return dispatch;
  }

  public List<ViewDispatchSfc> selectWaitingByItemGroup(String itemGroup, String operation)
      throws SQLException {
    List<ViewDispatchSfc> dispatch = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "FROM view_dispatch_sfc_waiting WHERE ITEM_GROUP_BO =?  and OPERATION_BO = ? and SFC_STATE_NAME NOT IN ('HOLD','RESERVE_OUT','OUT')")) {
      ps.setString(1, itemGroup);
      ps.setString(2, operation);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        dispatch.add(this.convert(rs));
      }
    }
    return dispatch;
  }

  public List<ViewDispatchSfc> selectRunningByDeviceAndOperationAndCust(String itemGroupBo,
      String operationBo, String customer) throws SQLException {
    List<ViewDispatchSfc> dispatch = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "FROM view_dispatch_sfc_running WHERE ITEM_GROUP_BO = ? AND OPERATION_BO = ? AND CUSTOMER = ? AND STATE_NAME NOT IN ('RUN_HOLD')")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, customer);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        dispatch.add(this.convert(rs));
      }
    }
    return dispatch;
  }

  public List<ViewDispatchSfc> selectWaitingByDeviceAndOperationAndCust(String itemGroup,
      String operation, String customer) throws SQLException {
    List<ViewDispatchSfc> dispatch = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "FROM view_dispatch_sfc_waiting WHERE ITEM_GROUP_BO = ? AND OPERATION_BO = ? AND CUSTOMER = ? AND SFC_STATE_NAME NOT IN ('HOLD','RESERVE_OUT','OUT')")) {
      ps.setString(1, itemGroup);
      ps.setString(2, operation);
      ps.setString(3, customer);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        dispatch.add(this.convert(rs));
      }
    }
    return dispatch;
  }

  public List<ViewDispatchSfc> selectWaitingByShopOrder(String ShopOrder, String operation)
      throws SQLException {
    List<ViewDispatchSfc> dispatch = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "FROM view_dispatch_sfc_waiting WHERE SHOP_ORDER_BO =?  and OPERATION_BO = ? ")) {
      ps.setString(1, ShopOrder);
      ps.setString(2, operation);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        dispatch.add(this.convert(rs));
      }
    }
    return dispatch;
  }

  public List<ViewDispatchSfc> selectRunningByShopOrder(String ShopOrder, String operation)
      throws SQLException {
    List<ViewDispatchSfc> dispatch = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "FROM view_dispatch_sfc_running WHERE SHOP_ORDER_BO=?   and OPERATION_BO = ?  ")) {
      ps.setString(1, ShopOrder);
      ps.setString(2, operation);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        dispatch.add(this.convert(rs));
      }
    }
    return dispatch;
  }

  public ViewDispatchSfc selectCurrentBySfc(String sfcBo) throws SQLException {
    ViewDispatchSfc dispatch = this.selectRunningBySfc(sfcBo);
    return dispatch != null ? dispatch : this.selectWaitingBySfc(sfcBo);
  }

  public List<ViewDispatchSfc> selectCurrentBySfc(String... sfcBos) throws SQLException {
    List<ViewDispatchSfc> dispatchs = new ArrayList<>();
    Where where = new Where().in("SFC_BO", (Object[]) sfcBos);
    try (PreparedStatement ps = where.prepareStatement(conn,
        SQL_SEL + "FROM view_dispatch_sfc_waiting ")) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        dispatchs.add(this.convert(rs));
      }
    }
    try (PreparedStatement ps = where.prepareStatement(conn,
        SQL_SEL + "FROM view_dispatch_sfc_running ")) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        dispatchs.add(this.convert(rs));
      }
    }
    return dispatchs;
  }

  public ViewDispatchSfc selectCurrentBySfcoperation(String sfcBo, String operation)
      throws SQLException {
    ViewDispatchSfc dispatch = this.selectRunningBySfcOperation(sfcBo, operation);
    return dispatch != null ? dispatch : this.selectWaitingBySfcOperation(sfcBo, operation);
  }

  public ViewDispatchSfc selectRunningBySfcOperation(String sfcBo, String operation)
      throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "FROM view_dispatch_sfc_running WHERE sfc_bo=? and OPERATION_BO = ? ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operation);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }

  public ViewDispatchSfc selectWaitingBySfcOperation(String sfcBo, String operation)
      throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "FROM view_dispatch_sfc_waiting WHERE sfc_bo=?   and OPERATION_BO = ? ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operation);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }

  public ViewDispatchSfc selectRunningBySfc(String sfcBo) throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "FROM view_dispatch_sfc_running WHERE sfc_bo=? ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }

  public ViewDispatchSfc selectFirst(String sfcBo) throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "FROM view_dispatch_sfc WHERE sfc_bo=? AND date_queued is not null ORDER BY date_queued")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }

  public ViewDispatchSfc selectBySfcSeq(String sfcBo) throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "FROM view_dispatch_sfc WHERE sfc_bo=? ORDER BY SFC_STEP_SEQ desc")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }

  public ViewDispatchSfc selectLast(String sfcBo) throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "FROM view_dispatch_sfc WHERE sfc_bo=? AND date_queued is not null ORDER BY date_queued desc")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }

  public List<ViewDispatchSfc> selectWaitingByCarrier(String carrierName) throws SQLException {
    List<ViewDispatchSfc> dispatch = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "FROM view_dispatch_sfc_waiting WHERE  CARRIER_NAME = ?  ")) {
      ps.setString(1, carrierName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch.add(this.convert(rs));
      }
    }
    return dispatch;
  }

  public List<ViewDispatchSfc> selectRunningByCarrier(String carrierName) throws SQLException {
    List<ViewDispatchSfc> dispatch = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "FROM view_dispatch_sfc_running WHERE CARRIER_NAME = ?  ")) {
      ps.setString(1, carrierName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        dispatch.add(this.convert(rs));
      }
    }
    return dispatch;
  }

  public List<ViewDispatchSfc> selectRunningByCP() throws SQLException {
    List<ViewDispatchSfc> dispatch = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "FROM view_dispatch_sfc_running WHERE OPERATION_BO LIKE '%WCP%TEST%' OR OPERATION_BO LIKE '%FCP%TEST%' ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        dispatch.add(this.convert(rs));
      }
    }
    return dispatch;
  }

  public List<ViewDispatchSfc> selectCurrentByCarrier(String carrierName) throws SQLException {
    List<ViewDispatchSfc> dispatch = this.selectRunningByCarrier(carrierName);
    return dispatch.size() != 0 ? dispatch : this.selectWaitingByCarrier(carrierName);
  }

  public ViewDispatchSfc selectWaitingBySfc(String sfcBo) throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "FROM view_dispatch_sfc_waiting WHERE sfc_bo=? ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }

  //根据载具查询对应的信息
  public List<ViewDispatchSfc> selectWaitingBycarrierName(String carrierName) throws SQLException {
    List<ViewDispatchSfc> dispatch = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "FROM view_dispatch_sfc_waiting WHERE CARRIER_NAME = ? ")) {
      ps.setString(1, carrierName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        dispatch.add(this.convert(rs));
      }
    }
    return dispatch;
  }

  public ViewDispatchSfc selectBySfcAndOperationBo(String sfcBo, String operationBo)
      throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "FROM view_dispatch_sfc WHERE sfc_bo=? and OPERATION_BO = ? ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }

  public ViewDispatchSfc selectWaitingBySfcAndOperationBo(String sfcBo, String operationBo)
      throws SQLException {
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "FROM view_dispatch_sfc_waiting WHERE sfc_bo=? and OPERATION_BO = ? ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        dispatch = this.convert(rs);
      }
    }
    return dispatch;
  }

  // MARK add
  public ArrayList<ViewDispatchSfc> selectWaitingByOperationAndItem(String itemBo,
      String operationBo)
      throws SQLException {
    ArrayList<ViewDispatchSfc> dispatchSfcs = new ArrayList<ViewDispatchSfc>();
    ViewDispatchSfc dispatch = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "FROM view_dispatch_sfc_waiting WHERE item_bo=?  and operation_bo=?  and sfc_type = 'S' and SFC_STATE_NAME = 'WAIT'")) {
      ps.setString(1, itemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        dispatch = this.convert(rs);
        dispatchSfcs.add(dispatch);

      }
    }
    return dispatchSfcs;
  }

  public ArrayList<ViewDispatchSfc> selectWaitingOutQueueTime() throws SQLException {
    ArrayList<ViewDispatchSfc> dispatchSfcs = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "FROM view_dispatch_sfc_waiting WHERE queue_time_flag <> 'N' AND IN_MAX_TIME IS NOT NULL AND IN_MAX_TIME < ADD_SECONDS(CURRENT_TIMESTAMP, -8*60*60) ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        dispatchSfcs.add(this.convert(rs));
      }
    }
    return dispatchSfcs;
  }

  public List<ViewDispatchSfc> selectWaitingByOperation(String operationBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "FROM view_dispatch_sfc_waiting WHERE operation_bo=?  ORDER BY sfc_bo")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  //todo 查出所有当前在CFT-TEST站点，并且状态不为hold的批次
  public List<ViewDispatchSfc> selectWaitingByOperationAndState(String operationBo)
      throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL
                + "FROM view_dispatch_sfc_waiting WHERE operation_bo=? and sfc_state_name not in ('HOLD','RUN_HOLD') ORDER BY created_date_time desc ")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  //todo 查出所有当前在CFT-TEST站点，并且状态不为hold的批次
  public List<ViewDispatchSfc> selectRunningByOperationAndState(String operationBo)
      throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL
                + "FROM view_dispatch_sfc_running WHERE operation_bo=? and sfc_state_name not in ('HOLD','RUN_HOLD') ORDER BY created_date_time desc ")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectWaitingByShopOrderBO(String shopOrderBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "FROM view_dispatch_sfc_waiting WHERE SHOP_ORDER_BO=?  ORDER BY sfc_bo")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectWaitingByResourceBo(String resourceBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "SELECT   sfc_step_bo,state_name,dpt_no,lot_type,in_time,out_time,in_min_time,in_max_time,out_min_time,out_max_time,hot_level,rework,queue_time_flag,hold_flag,cycle_time,recipe_type,recipe_name,capability,assign_recipe_name,assign_resources,assign_instruction,track_in_count,track_out_count,cycle_time_total,hot_level_flag,hot_level_reason,receive_date_time,shop_order_bo,shop_order,sfc_bo,sfc,sfc_router_bo,sfc_router_seq,sfc_step_seq,router_bo,a.operation_bo,done,bypassed,qty_in_queue,qty_in_work,qty_completed,qty_complete_pending,qty_rejected,previously_started,previous_step_id,previous_resource_bo,date_queued,item_bo,scheduled_comp_date,planned_comp_date,a.resource_bo,work_center_bo,item_group_bo,planned_start_date,scheduled_start_date,sfc_state_name,current_run,customer_itemset_bo,priority,item_qty,item_name,device_bo,device_name,package_bo,package_name,router_name,sfc_qty,customer,status_bo,customer_itemset_name,remark,customer_itemset_name_orig,carrier_bo,carrier_name,carrier_state_name,curr_seq,sfc_type,created_date_time,resource_slot_id,batch_id,bumping_sod,wlp_sod,cp_sod,fc_sod  \n"
                +
                "FROM view_dispatch_sfc_waiting A INNER JOIN VIEW_OPERATION_RESOURCE B ON A.OPERATION_BO  = B.OPERATION_PARENT WHERE b.resource_bo=? ORDER BY sfc_bo ")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectWaitingByResourceBos(String[] resourceBos)
      throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    StringBuilder temp = new StringBuilder();
    for (int i = 0; i < resourceBos.length; i++) {
      temp.append("?,");
    }
    String sql =
        "SELECT distinct sfc_step_bo,state_name,dpt_no,lot_type,in_time,out_time,in_min_time,in_max_time,out_min_time,out_max_time,hot_level,rework,queue_time_flag,hold_flag,cycle_time,recipe_type,recipe_name,capability,assign_recipe_name,assign_resources,assign_instruction,track_in_count,track_out_count,cycle_time_total,hot_level_flag,hot_level_reason,receive_date_time,shop_order_bo,shop_order,sfc_bo,sfc,sfc_router_bo,sfc_router_seq,sfc_step_seq,router_bo,a.operation_bo,done,bypassed,qty_in_queue,qty_in_work,qty_completed,qty_complete_pending,qty_rejected,previously_started,previous_step_id,previous_resource_bo,date_queued,item_bo,scheduled_comp_date,planned_comp_date,a.resource_bo,work_center_bo,item_group_bo,planned_start_date,scheduled_start_date,sfc_state_name,current_run,customer_itemset_bo,priority,item_qty,item_name,device_bo,device_name,package_bo,package_name,router_name,sfc_qty,customer,status_bo,customer_itemset_name,remark,customer_itemset_name_orig,carrier_bo,carrier_name,carrier_state_name,curr_seq,sfc_type,created_date_time,resource_slot_id,batch_id,bumping_sod,wlp_sod,cp_sod,fc_sod "
            +
            " FROM view_dispatch_sfc_waiting A INNER JOIN VIEW_OPERATION_RESOURCE B ON A.OPERATION_BO  = B.OPERATION_PARENT WHERE b.resource_bo in ("
            + temp.substring(0, temp.length() - 1) + " )  ORDER BY sfc_bo";
    try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
      for (int i = 0; i < resourceBos.length; i++) {
        ps.setString(i + 1, resourceBos[i]);
      }
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectWaitingByOperationAndItemGroupBo(String operationBo,
      String itemGroupBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "FROM VIEW_DISPATCH_SFC_WAITING_NO_PKG WHERE operation_bo=? and item_group_bo=?  ORDER BY sfc_bo")) {
      ps.setString(1, operationBo);
      ps.setString(2, itemGroupBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectAllWaiting() throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "FROM view_dispatch_sfc_waiting ORDER BY operation_bo ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectAllRunning() throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "FROM view_dispatch_sfc_running ORDER BY operation_bo ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectRunningByResource(String resourceBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "FROM view_dispatch_sfc_running WHERE resource_bo=? ORDER BY sfc_bo")) {

      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectRunningWipByResource(String resourceBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "SELECT   sfc_step_bo,state_name,dpt_no,lot_type,in_time,out_time,in_min_time,in_max_time,out_min_time,out_max_time,hot_level,rework,queue_time_flag,hold_flag,cycle_time,recipe_type,recipe_name,capability,assign_recipe_name,assign_resources,assign_instruction,track_in_count,track_out_count,cycle_time_total,hot_level_flag,hot_level_reason,receive_date_time,shop_order_bo,shop_order,sfc_bo,sfc,sfc_router_bo,sfc_router_seq,sfc_step_seq,router_bo,a.operation_bo,done,bypassed,qty_in_queue,qty_in_work,qty_completed,qty_complete_pending,qty_rejected,previously_started,previous_step_id,previous_resource_bo,date_queued,item_bo,scheduled_comp_date,planned_comp_date,a.resource_bo,work_center_bo,item_group_bo,planned_start_date,scheduled_start_date,sfc_state_name,current_run,customer_itemset_bo,priority,item_qty,item_name,device_bo,device_name,package_bo,package_name,router_name,sfc_qty,customer,status_bo,customer_itemset_name,remark,customer_itemset_name_orig,carrier_bo,carrier_name,carrier_state_name,curr_seq,sfc_type,created_date_time,resource_slot_id,batch_id,bumping_sod,wlp_sod,cp_sod,fc_sod  \n"
                +
                "FROM view_dispatch_sfc_running A INNER JOIN VIEW_OPERATION_RESOURCE B ON A.OPERATION_BO  = B.OPERATION_PARENT WHERE b.resource_bo=? ORDER BY sfc_bo ")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectRunningByResourceNoRunHold(String resourceBo)
      throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "FROM view_dispatch_sfc_running WHERE resource_bo=? and STATE_NAME NOT IN ('RUN_HOLD') ORDER BY sfc_bo")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDispatchSfc> selectRunningByOperation(String operationBo) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "FROM view_dispatch_sfc_running WHERE operation_bo=? ORDER BY sfc_bo")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<String> selectWCP(String shoporderBo) throws SQLException {
    ArrayList<String> result = new ArrayList<String>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_WCP)) {
      ps.setString(1, shoporderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(rs.getString(1));
      }
    }
    return result;
  }


  public int predispatch(String sfcsteps) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE ZR_DISPATCH_SFC SET HOT_LEVEL = 0 where sfc_step_bo = ?")) {
      ps.setString(1, sfcsteps);

      return ps.executeUpdate();
    }
  }

  public int revisenRecipe(String sfcsteps, String recipeName, String capability)
      throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "UPDATE ZR_DISPATCH_SFC SET RECIPE_NAME =? , CAPABILITY =? where sfc_step_bo = ?")) {
      ps.setString(1, recipeName);
      ps.setString(2, capability);
      ps.setString(3, sfcsteps);

      return ps.executeUpdate();
    }
  }

  public int cancelpredispatch(String sfcsteps) throws SQLException {
    ArrayList<ViewDispatchSfc> result = new ArrayList<ViewDispatchSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE ZR_DISPATCH_SFC SET HOT_LEVEL = 5 where sfc_step_bo = ?")) {
      ps.setString(1, sfcsteps);
      return ps.executeUpdate();
    }
  }

  /**
   * 計算剩餘工藝總時間，秒。
   *
   * @param sfcBo SFC 編號。
   * @return 剩餘工藝總時間。
   * @throws SQLException 資料庫讀取錯誤。
   */
  public int calculateCycleTime(String sfcBo) throws SQLException {
    int cycleTime = 0;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_CYCLE_TIME_SUM_MAIN)) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        cycleTime = rs.getInt(1);
      }
    }
    return cycleTime;
  }

  public List<QueryFTFifoResult> queryFtFifoDispatchWaiting(String device, String customer,
      String operation)
      throws SQLException {
    List<QueryFTFifoResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_FT_FIFO_WAITING)) {
      ps.setString(1, operation);
      ps.setString(2, customer);
      ps.setString(3, device);

      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        result.add(this.convert2(rs));
      }
      return result;
    }
  }

  public List<QueryFTFifoResult> queryFtFifoDispatchRunning(String device, String customer,
      String operation)
      throws SQLException {
    List<QueryFTFifoResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_FT_FIFO_RUNNING)) {
      ps.setString(1, operation);
      ps.setString(2, customer);
      ps.setString(3, device);

      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        result.add(this.convert2(rs));
      }
      return result;
    }
  }

  // SELECT A.SFC,A.DATE_QUEUED,A.SHOP_ORDER,A.OPERATION_BO,B.LOCATION_DATA,A.SFC_STATE_NAME,C.DESCRIPTION,D.STATE FROM view_dispatch_sfc_waiting A
  //LEFT JOIN zd_ft_location_data B ON A.SHOP_ORDER_BO = B.SHOP_ORDER_BO
  // LEFT JOIN OPERATION C ON replace(A.OPERATION_BO,'#','A') =  C.HANDLE
  //  LEFT JOIN ZR_CANCEL_SFC D ON A.SHOP_ORDER = D.SHOP_ORDER_NAME

  private QueryFTFifoResult convert2(ResultSet rs) throws SQLException {
    QueryFTFifoResult result = new QueryFTFifoResult();
    int index = 1;
    result.setSfc(rs.getString(index++));
    result.setDateQuequed(DateUtils.getDateTz(rs, index++));
    result.setShopOrder(rs.getString(index++));
    result.setOperationBo(rs.getString(index++));
    result.setLocation(rs.getString(index++));
    result.setSfcStateName(rs.getString(index++));
    result.setDescription(rs.getString(index++));
    result.setState(rs.getString(index++));
    return result;
  }


  // 2.	UPDATE ZR_DISPATCH_SFC SET PRIORITY = '3' WHERE SFC_BO IN（SFCBO:1020, || EXCEL里面的SFC）
  public int updatePriority2(List<String> sfcBos) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "UPDATE ZR_DISPATCH_SFC SET HOT_LEVEL = '3' WHERE SFC_BO = ?")) {
      for (String sfc : sfcBos) {
        ps.setString(1, Env.genSfcBo(sfc));
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }


  private ViewDispatchSfc convert(ResultSet rs) throws SQLException {
    ViewDispatchSfc result = new ViewDispatchSfc();
    int index = 1;
    result.setSfcStepBo(rs.getString(index++));
    result.setStateName(rs.getString(index++));
    result.setDptNo(rs.getString(index++));
    result.setLotType(rs.getString(index++));
    result.setInTime(DateUtils.getDateTz(rs, index++));
    result.setOutTime(DateUtils.getDateTz(rs, index++));
    result.setInMinTime(DateUtils.getDateTz(rs, index++));
    result.setInMaxTime(DateUtils.getDateTz(rs, index++));
    result.setOutMinTime(DateUtils.getDateTz(rs, index++));
    result.setOutMaxTime(DateUtils.getDateTz(rs, index++));
    result.setHotLevel(rs.getInt(index++));
    result.setRework(rs.getString(index++));
    result.setQueueTimeFlag(rs.getString(index++));
    result.setHoldFlag(rs.getString(index++));
    result.setCycleTime(rs.getInt(index++));
    result.setRecipeType(rs.getString(index++));
    result.setRecipeName(rs.getString(index++));
    result.setCapability(rs.getString(index++));
    result.setAssignRecipeName(rs.getString(index++));
    result.setAssignResources(rs.getString(index++));
    result.setAssignInstruction(rs.getString(index++));
    result.setTrackInCount(rs.getInt(index++));
    result.setTrackOutCount(rs.getInt(index++));
    result.setCycleTimeTotal(rs.getInt(index++));
    result.setHotLevelFlag(rs.getString(index++));
    result.setHotLevelReason(rs.getString(index++));
    result.setReceiveDateTime(DateUtils.getDateTz(rs, index++));

    result.setShopOrderBo(rs.getString(index++));
    result.setShopOrder(rs.getString(index++));
    result.setSfcBo(rs.getString(index++));
    result.setSfc(rs.getString(index++));
    result.setSfcRouterBo(rs.getString(index++));
    result.setSfcRouterSeq(rs.getInt(index++));
    result.setSfcStepSeq(rs.getInt(index++));
    result.setRouterBo(rs.getString(index++));
    result.setOperationBo(rs.getString(index++));
    result.setDone(rs.getString(index++));
    result.setBypassed(rs.getString(index++));
    result.setQtyInQueue(rs.getInt(index++));
    result.setQtyInWork(rs.getInt(index++));
    result.setQtyCompleted(rs.getInt(index++));
    result.setQtyCompletePending(rs.getInt(index++));
    result.setQtyRejected(rs.getInt(index++));
    result.setPreviouslyStarted(rs.getString(index++));
    result.setPreviousStepId(rs.getString(index++));
    result.setPreviousResourceBo(rs.getString(index++));
    result.setDateQueued(DateUtils.getDateTz(rs, index++));
    result.setItemBo(rs.getString(index++));
    result.setScheduledCompDate(DateUtils.getDateTz(rs, index++));
    result.setPlanCompDate(DateUtils.getDateTz(rs, index++));
    result.setResourceBo(rs.getString(index++));
    result.setWorkCenterBo(rs.getString(index++));
    result.setItemGroupBo(rs.getString(index++));
    result.setPlannedStartDate(DateUtils.getDateTz(rs, index++));
    result.setScheduledStartDate(DateUtils.getDateTz(rs, index++));
    result.setSfcStateName(rs.getString(index++));
    result.setCurrentRun(rs.getString(index++));
    result.setCustomerItemLotBo(rs.getString(index++));
    result.setPriority(rs.getInt(index++));
    result.setItemQty(rs.getInt(index++));
    result.setItemName(rs.getString(index++));
    result.setDeviceBo(rs.getString(index++));
    result.setDeviceName(rs.getString(index++));
    result.setPackageBo(rs.getString(index++));
    result.setPackageName(rs.getString(index++));
    result.setRouterName(rs.getString(index++));
    result.setSfcQty(rs.getInt(index++));
    result.setCustomer(rs.getString(index++));
    result.setStatusBo(rs.getString(index++));
    result.setCustomerItemLotName(rs.getString(index++));
    result.setRemark(rs.getString(index++));
    result.setCustomerItemLotNameOrig(rs.getString(index++));
    result.setCarrierBo(rs.getString(index++));
    result.setCarrierName(rs.getString(index++));
    result.setCarrierStateName(rs.getString(index++));
    result.setCurrSeq(rs.getInt(index++));
    result.setSfcType(rs.getString(index++));
    result.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    result.setResourceSlotId(rs.getString(index++));
    result.setBatchId(rs.getString(index++));
    result.setBumpingSod(DateUtils.getDateTz(rs, index++));
    result.setWlpSod(DateUtils.getDateTz(rs, index++));
    result.setCpSod(DateUtils.getDateTz(rs, index++));
    result.setFcSod(DateUtils.getDateTz(rs, index++));

    return result;
  }

}
