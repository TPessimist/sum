package ame.psb.db.dao;

import ame.psb.db.RunSfc;
import uia.utils.dao.DateUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RunSfcDao {

  private static final String SQL_INS = "INSERT INTO zr_run_sfc(id,sfc_step,sfc_bo,run_carrier_bo,state_name,begin_time,end_time,run,resource_bo,operation_bo,item_qty,sfc_qty,router_bo,recipe_name,remark,run_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_run_sfc SET sfc_step=?,sfc_bo=?,run_carrier_bo=?,state_name=?,begin_time=?,end_time=?,run=?,resource_bo=?,operation_bo=?,item_qty=?,sfc_qty=?,router_bo=?,recipe_name=?,remark=?,run_user=? WHERE id=? ";

  private static final String SQL_SEL = "SELECT id,sfc_step,sfc_bo,run_carrier_bo,state_name,begin_time,end_time,run,resource_bo,operation_bo,item_qty,sfc_qty,router_bo,recipe_name,remark,run_user FROM zr_run_sfc ";

  private static final String SQL_SEL_TOP1 = "SELECT TOP 1 id,sfc_step,sfc_bo,run_carrier_bo,state_name,begin_time,end_time,run,resource_bo,operation_bo,item_qty,sfc_qty,router_bo,recipe_name,remark,run_user FROM zr_run_sfc ";


  private Connection conn;

  public RunSfcDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunSfc run) throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement(SQL_INS);
    ps.setString(1, run.getId());
    ps.setString(2, run.getSfcStepBo());
    ps.setString(3, run.getSfcBo());
    ps.setString(4, run.getRunCarrierBo());
    ps.setString(5, run.getStateName());
    DateUtils.setDateTz(ps, 6, run.getBeginTime());
    DateUtils.setDateTz(ps, 7, run.getEndTime());
    ps.setString(8, run.getRun());
    ps.setString(9, run.getResourceBo());
    ps.setString(10, run.getOperationBo());
    ps.setInt(11, run.getItemQty());
    ps.setInt(12, run.getSfcQty());
    ps.setString(13, run.getRouterBo());
    ps.setString(14, run.getRecipeName());
    ps.setString(15, run.getRemark());
    ps.setString(16, run.getRunUser());
    return ps.executeUpdate();
  }

  public int update(RunSfc run) throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement(SQL_UPD);
    ps.setString(1, run.getSfcStepBo());
    ps.setString(2, run.getSfcBo());
    ps.setString(3, run.getRunCarrierBo());
    ps.setString(4, run.getStateName());
    DateUtils.setDateTz(ps, 5, run.getBeginTime());
    DateUtils.setDateTz(ps, 6, run.getEndTime());
    ps.setString(7, run.getRun());
    ps.setString(8, run.getResourceBo());
    ps.setString(9, run.getOperationBo());
    ps.setInt(10, run.getItemQty());
    ps.setInt(11, run.getSfcQty());
    ps.setString(12, run.getRouterBo());
    ps.setString(13, run.getRecipeName());
    ps.setString(14, run.getRemark());
    ps.setString(15, run.getRunUser());
    ps.setString(16, run.getId());
    return ps.executeUpdate();
  }

  public RunSfc selectByPK(String id) throws SQLException {
    RunSfc run = null;

    PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?");
    ps.setString(1, id);

    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      run = convert(rs);
    }

    return run;
  }

//  /*
//   * cc
//   * */
//  public RunSfc selectRecipeIdBySfc(String sfcBo) throws SQLException {
//    RunSfc run = null;
//    PreparedStatement ps = this.conn
//        .prepareStatement("SELECT * FROM zr_run_sfc z "
//            + "INNER JOIN SFC vs ON z.SFC_BO = vs.HANDLE "
//            + "INNER JOIN ZR_WAFER_STORAGE r ON vs.SFC = r.SFC "
//            + "WHERE z.OPERATION_BO LIKE '%WTR-TTR%' AND r.SFC = ? ");
//    ps.setString(1, sfcBo);
//
//    ResultSet rs = ps.executeQuery();
//    if (rs.next()) {
//      run = convert(rs);
//    }
//    return run;
//  }

  public List<RunSfc> selectAll() throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();
    PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "ORDER BY id");

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public boolean rework(String sfcStepBo) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_step=? ORDER BY begin_time desc");
    ps.setString(1, sfcStepBo);

    ResultSet rs = ps.executeQuery();
    return rs.next();
  }

  public List<RunSfc> selectByStep(String sfcStepBo) throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();

    PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_step=? ORDER BY begin_time desc");
    ps.setString(1, sfcStepBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfc> selectBySfcBo(String sfcBo) throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();

    PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? ORDER BY begin_time desc");
    ps.setString(1, sfcBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfc> selectByRunCarrier(String runCarrierBo) throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();

    PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE run_carrier_bo=? ORDER BY id");
    ps.setString(1, runCarrierBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfc> selectByOperation(String operationBo) throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();

    PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE operation_bo=? ORDER BY id");
    ps.setString(1, operationBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfc> selectByOperationTime(String resourceBo, String operationBo, Date beginTime,
      Date endTime) throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();

    PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE RESOURCE_BO =? and OPERATION_BO = ? and  END_TIME BETWEEN ? AND ?");
    ps.setString(1, resourceBo);
    ps.setString(2, operationBo);
    DateUtils.setDateTz(ps, 3, beginTime);
    DateUtils.setDateTz(ps, 4, endTime);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfc> selectDoneBySfc(String sfcBo) throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();

    PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? ORDER BY begin_time");
    ps.setString(1, sfcBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfc> selectDoneBySfc(String sfcBo, String operationBo) throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();

    PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND operation_bo=? ORDER BY begin_time desc");
    ps.setString(1, sfcBo);
    ps.setString(2, operationBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfc> selectRecipeBySfc(String sfcBo, String operationBo) throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();

    PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE sfc_bo=? AND operation_bo=? AND RECIPE_NAME IS NOT NULL AND RECIPE_NAME != '' ORDER BY begin_time desc");
    ps.setString(1, sfcBo);
    ps.setString(2, operationBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfc> selectByResource(String resourceBo) throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();

    PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_bo=? ORDER BY id");
    ps.setString(1, resourceBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfc> selectToByResourceAndOperationBoAndEndTimeDesc(String resourceBo,
      String operationBo) throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();

    PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_TOP1 + "WHERE resource_bo=? and operation_bo = ? ORDER BY END_TIME DESC");
    ps.setString(1, resourceBo);
    ps.setString(2, operationBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfc> selectByResourceAndTime(String resourceBo, Date start, Date end)
      throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();

    PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE resource_bo=? and BEGIN_TIME between ? and ?  ORDER BY begin_time");
    ps.setString(1, resourceBo);
    DateUtils.setDateTz(ps, 2, start);
    DateUtils.setDateTz(ps, 3, end);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfc> selectByOperationAndTime(String operationBo, Date start, Date end)
      throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();

    PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE replace(operation_bo,',A',',#') =? and BEGIN_TIME between ? and ?  ORDER BY begin_time");
    ps.setString(1, operationBo);
    DateUtils.setDateTz(ps, 2, start);
    DateUtils.setDateTz(ps, 3, end);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfc> selectByCP(Date start, Date end) throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();

    PreparedStatement ps = this.conn.prepareStatement(SQL_SEL +
        " WHERE (OPERATION_BO LIKE '%WCP%TEST%' OR OPERATION_BO LIKE '%FCP%TEST%' OR OPERATION_BO LIKE '%WPT%TEST%') "
        +
        "   AND STATE_NAME = 'RUN_FINISH' " +
        "   AND BEGIN_TIME IS NOT NULL " +
        "   AND (BEGIN_TIME BETWEEN ? AND ?) " +
        "   AND ADD_SECONDS(END_TIME, 60 * 60 * 8 + 60 * 30) <= CURRENT_TIMESTAMP " +
        " ORDER BY BEGIN_TIME DESC ");
    DateUtils.setDateTz(ps, 1, start);
    DateUtils.setDateTz(ps, 2, end);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfc> selectByOperationAndEndTime(String operationBo, Date start, Date end)
      throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();

    PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "WHERE replace(operation_bo,',A',',#') =? and END_TIME between ? and ?  ORDER BY begin_time");
    ps.setString(1, operationBo);
    DateUtils.setDateTz(ps, 2, start);
    DateUtils.setDateTz(ps, 3, end);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfc> selectByCPAndEndTime(Date start, Date end) throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();

    PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "WHERE OPERATION_BO LIKE '%CP%TEST%' and END_TIME between ? and ?  ORDER BY begin_time");
				/*SQL_SEL + " Z WHERE replace(Z.operation_bo,',A',',#') ='OperationBO:1020,WCP2-TEST,#' "+
				    " AND exists(SELECT 1 "+
		            "   FROM view_sfc_item v "+
		            "  WHERE v.DEVICE_NAME = 'XBB32011' "+
		            "    AND v.SFC_BO = z.SFC_BO) "+
		            "    AND (ADD_SECONDS(Z.END_TIME, 60 * 60 * 8) BETWEEN TO_TIMESTAMP('2020-08-01 00:00:00')  AND TO_TIMESTAMP('2021-01-31 23:59:59')) ");*/

    DateUtils.setDateTz(ps, 1, start);
    DateUtils.setDateTz(ps, 2, end);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfc> selectBySfcAndOperation(String sfcBo, String operationBo)
      throws SQLException {
    ArrayList<RunSfc> runs = new ArrayList<RunSfc>();

    PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE  sfc_Bo = ? and operation_Bo = ?  ORDER BY begin_time");
    ps.setString(1, sfcBo);
    ps.setString(2, operationBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public int changeState(String id, String stateName) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_run_sfc SET state_name=? WHERE id=?");
    ps.setString(1, stateName);
    ps.setString(2, id);
    return ps.executeUpdate();
  }

  public int changeEndState(String id, String stateName, Date endTime) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_run_sfc SET state_name=?,end_time=? WHERE id=?");
    ps.setString(1, stateName);
    DateUtils.setDateTz(ps, 2, endTime);
    ps.setString(3, id);
    return ps.executeUpdate();
  }

  public int changeStateByRunCarrier(String runCarrierBo, String stateName) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_run_sfc SET state_name=? WHERE run_carrier_bo=?");
    ps.setString(1, stateName);
    ps.setString(2, runCarrierBo);
    return ps.executeUpdate();
  }

  public int updateRemark(String id, String remark, String remarkUser, Date remarkTime)
      throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement("UPDATE zr_run_sfc SET remark=? WHERE id=?");
    ps.setString(1, remark);
    ps.setString(2, id);
    return ps.executeUpdate();
  }

  private RunSfc convert(ResultSet rs) throws SQLException {
    RunSfc data = new RunSfc();
    data.setId(rs.getString(1));
    data.setSfcStepBo(rs.getString(2));
    data.setSfcBo(rs.getString(3));
    data.setRunCarrierBo(rs.getString(4));
    data.setStateName(rs.getString(5));
    data.setBeginTime(DateUtils.getDateTz(rs, 6));
    data.setEndTime(DateUtils.getDateTz(rs, 7));
    data.setRun(rs.getString(8));
    data.setResourceBo(rs.getString(9));
    data.setOperationBo(rs.getString(10));
    data.setItemQty(rs.getInt(11));
    data.setSfcQty(rs.getInt(12));
    data.setRouterBo(rs.getString(13));
    data.setRecipeName(rs.getString(14));
    data.setRemark(rs.getString(15));
    data.setRunUser(rs.getString(16));
    return data;
  }

}
