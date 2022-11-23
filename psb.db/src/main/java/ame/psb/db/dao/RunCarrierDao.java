package ame.psb.db.dao;

import ame.psb.db.RunCarrier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunCarrierDao {

  private static final String SQL_INS = "INSERT INTO zr_run_carrier(id,begin_time,end_time,state_name,carrier_bo,run,resource_bo,operation_bo,item_qty,sfc_qty,router_bo,recipe_name,remark,run_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_SEL = "SELECT id,begin_time,end_time,state_name,carrier_bo,run,resource_bo,operation_bo,item_qty,sfc_qty,router_bo,recipe_name,remark,run_user FROM zr_run_carrier ";

  private Connection conn;

  public RunCarrierDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunCarrier run) throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement(SQL_INS);
    ps.setString(1, run.getId());
    DateUtils.setDateTz(ps, 2, run.getBeginTime());
    DateUtils.setDateTz(ps, 3, run.getEndTime());
    ps.setString(4, run.getStateName());
    ps.setString(5, run.getCarrierBo());
    ps.setString(6, run.getRun());
    ps.setString(7, run.getResourceBo());
    ps.setString(8, run.getOperationBo());
    ps.setInt(9, run.getItemQty());
    ps.setInt(10, run.getSfcQty());
    ps.setString(11, run.getRouterBo());
    ps.setString(12, run.getRecipeName());
    ps.setString(13, run.getRemark());
    ps.setString(14, run.getRunUser());
    return ps.executeUpdate();
  }

  public RunCarrier selectByPK(String id) throws SQLException {
    RunCarrier run = null;

    PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?");
    ps.setString(1, id);

    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      run = convert(rs);
    }

    return run;
  }

  public List<RunCarrier> selectByOperation(String operationBo) throws SQLException {
    ArrayList<RunCarrier> runs = new ArrayList<RunCarrier>();

    PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE operation_bo=? ORDER BY id");
    ps.setString(1, operationBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public RunCarrier selectByResourceAndCarrier(String resourceBo, String carrierBo)
      throws SQLException {
    RunCarrier run = null;
    PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE resource_bo=? AND carrier_bo=? ORDER BY begin_time desc");
    ps.setString(1, resourceBo);
    ps.setString(2, carrierBo);

    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      run = convert(rs);
    }

    return run;
  }

  public List<RunCarrier> selectByResource(String resourceBo) throws SQLException {
    ArrayList<RunCarrier> runs = new ArrayList<RunCarrier>();

    PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_bo=? ORDER BY id");
    ps.setString(1, resourceBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public int changeState(String id, String stateName) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_run_carrier SET state_name=? WHERE id=?");
    ps.setString(1, stateName);
    ps.setString(2, id);
    return ps.executeUpdate();
  }

  public int changeEndState(String id, String stateName, Date endTime) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_run_carrier SET state_name=?,end_time=? WHERE id=?");
    ps.setString(1, stateName);
    DateUtils.setDateTz(ps, 2, endTime);
    ps.setString(3, id);
    return ps.executeUpdate();
  }

  public int updateRemark(String id, String remark, String remarkUser, Date remarkTime)
      throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_run_carrier SET remark=? WHERE id=?");
    ps.setString(1, remark);
    ps.setString(2, id);
    return ps.executeUpdate();
  }

  private RunCarrier convert(ResultSet rs) throws SQLException {
    RunCarrier data = new RunCarrier();
    data.setId(rs.getString(1));
    data.setBeginTime(DateUtils.getDateTz(rs, 2));
    data.setEndTime(DateUtils.getDateTz(rs, 3));
    data.setStateName(rs.getString(4));
    data.setCarrierBo(rs.getString(5));
    data.setRun(rs.getString(6));
    data.setResourceBo(rs.getString(7));
    data.setOperationBo(rs.getString(8));
    data.setItemQty(rs.getInt(9));
    data.setSfcQty(rs.getInt(10));
    data.setRouterBo(rs.getString(11));
    data.setRecipeName(rs.getString(12));
    data.setRemark(rs.getString(13));
    data.setRunUser(rs.getString(14));
    return data;
  }
}
