package ame.psb.db.dao;

import ame.psb.db.RunSfcItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class RunSfcItemDao {

  private static final String SQL_INS = "INSERT INTO zr_run_sfc_item(id,run_sfc_bo,sfc_bo,customer_item_bo,state_name,begin_time,end_time,run,resource_bo,operation_bo,router_bo,recipe_name,remark,run_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_run_sfc_item SET run_sfc_bo=?,sfc_bo=?,customer_item_bo=?,state_name=?,begin_time=?,end_time=?,run=?,resource_bo=?,operation_bo=?,router_bo=?,recipe_name=?,remark=?,run_user=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,run_sfc_bo,sfc_bo,customer_item_bo,state_name,begin_time,end_time,run,resource_bo,operation_bo,router_bo,recipe_name,remark,run_user FROM zr_run_sfc_item ";

  private Connection conn;

  public RunSfcItemDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunSfcItem run) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, run.getId());
      ps.setString(2, run.getRunSfc());
      ps.setString(3, run.getSfcBo());
      ps.setString(4, run.getCustomerItem());
      ps.setString(5, run.getStateName());
      DateUtils.setDateTz(ps, 6, run.getBeginTime());
      DateUtils.setDateTz(ps, 7, run.getEndTime());
      ps.setString(8, run.getRun());
      ps.setString(9, run.getResourceBo());
      ps.setString(10, run.getOperationBo());
      ps.setString(11, run.getRouterBo());
      ps.setString(12, run.getRecipeName());
      ps.setString(13, run.getRemark());
      ps.setString(14, run.getRunUser());
      return ps.executeUpdate();
    }
  }

  public int update(RunSfcItem run) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, run.getRunSfc());
      ps.setString(2, run.getSfcBo());
      ps.setString(3, run.getCustomerItem());
      ps.setString(4, run.getStateName());
      DateUtils.setDateTz(ps, 5, run.getBeginTime());
      DateUtils.setDateTz(ps, 6, run.getEndTime());
      ps.setString(7, run.getRun());
      ps.setString(10, run.getRouterBo());
      ps.setString(11, run.getRecipeName());
      ps.setString(12, run.getRemark());
      ps.setString(13, run.getRunUser());
      ps.setString(14, run.getId());
      return ps.executeUpdate();
    }
  }

  public RunSfcItem selectByPK(String id) throws SQLException {
    RunSfcItem item = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = convert(rs);
      }
    }
    return item;
  }

  public List<RunSfcItem> selectByRunSfc(String runSfcBo) throws SQLException {
    ArrayList<RunSfcItem> runs = new ArrayList<RunSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE run_sfc_bo=? ORDER BY id")) {
      ps.setString(1, runSfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        runs.add(convert(rs));
      }
    }
    return runs;
  }

  public List<RunSfcItem> selectByOperation(String operationBo) throws SQLException {
    ArrayList<RunSfcItem> runs = new ArrayList<RunSfcItem>();

    PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE operation_bo=? ORDER BY id");
    ps.setString(1, operationBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfcItem> selectByCustmerOperation(String CustomerItemBo, String operationBo)
      throws SQLException {
    ArrayList<RunSfcItem> runs = new ArrayList<RunSfcItem>();

    PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE CUSTOMER_ITEM_BO LIKE ? AND OPERATION_BO = ?");
    ps.setString(1, CustomerItemBo + "%");
    ps.setString(2, operationBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public RunSfcItem selectLastByOperationAndWafer(String operationBo, String customerItembo)
      throws SQLException {
    RunSfcItem result = null;

    PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE operation_bo=? and customer_item_bo=? ORDER BY id desc");
    ps.setString(1, operationBo);
    ps.setString(2, customerItembo);

    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      result = convert(rs);
    }

    return result;
  }

  public RunSfcItem selectRecipeWafer(String operationBo, String customerItembo)
      throws SQLException {
    RunSfcItem result = null;

    PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE operation_bo=? and customer_item_bo=? and RUN_USER != 'SYS' and RECIPE_NAME != '' ORDER BY id desc");
    ps.setString(1, operationBo);
    ps.setString(2, customerItembo);

    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      result = convert(rs);
    }

    return result;
  }

  public List<RunSfcItem> selectByResource(String resourceBo) throws SQLException {
    ArrayList<RunSfcItem> runs = new ArrayList<RunSfcItem>();

    PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_bo=? ORDER BY id");
    ps.setString(1, resourceBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfcItem> selectByResourceAndCustomerItemBo(String resourceBo,
      String customerItemBo) throws SQLException {
    ArrayList<RunSfcItem> runs = new ArrayList<RunSfcItem>();

    PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=?  and customer_item_bo=?  ORDER BY id");
    ps.setString(1, resourceBo);
    ps.setString(2, customerItemBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfcItem> selectBySfcAndOperation(String sfcBo, String operationBo)
      throws SQLException {
    ArrayList<RunSfcItem> runs = new ArrayList<RunSfcItem>();
    PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE sfc_bo=? and operation_bo=? and state_name='FINISH' ORDER BY id");
    ps.setString(1, sfcBo);
    ps.setString(2, operationBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfcItem> selectByResourceAndBeginTime(String resourceBo, Date beginTime)
      throws SQLException {
    ArrayList<RunSfcItem> runs = new ArrayList<RunSfcItem>();

    PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE resource_bo=? and begin_time>?  ORDER BY begin_time DESC ");
    ps.setString(1, resourceBo);
    DateUtils.setDateTz(ps, 2, beginTime);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      runs.add(convert(rs));
    }

    return runs;
  }

  public List<RunSfcItem> select(Where where) throws SQLException {
    List<RunSfcItem> list = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convert(rs));
      }
      return list;
    }
  }

  public int changeState(String id, String stateName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_run_sfc_item SET state_name=? WHERE id=?")) {
      ps.setString(1, stateName);
      ps.setString(2, id);
      return ps.executeUpdate();
    }
  }

  public int changeBeginState(String id, String resourceBo, String stateName, Date beginTime)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_run_sfc_item SET state_name=?,resource_bo=?,begin_time=? WHERE id=?")) {
      ps.setString(1, stateName);
      ps.setString(2, resourceBo);
      DateUtils.setDateTz(ps, 3, beginTime);
      ps.setString(4, id);
      return ps.executeUpdate();
    }
  }

  public int changeEndState(String id, String stateName, Date endTime) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_run_sfc_item SET state_name=?,end_time=? WHERE id=?")) {
      ps.setString(1, stateName);
      DateUtils.setDateTz(ps, 2, endTime);
      ps.setString(3, id);
      return ps.executeUpdate();
    }
  }

  public int updateRemark(String id, String remark, String remarkUser, Date remarkTime)
      throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_run_sfc_item SET remark=? WHERE id=?");
    ps.setString(1, remark);
    ps.setString(2, id);
    return ps.executeUpdate();
  }

  private RunSfcItem convert(ResultSet rs) throws SQLException {
    RunSfcItem data = new RunSfcItem();
    data.setId(rs.getString(1));
    data.setRunSfc(rs.getString(2));
    data.setSfcBo(rs.getString(3));
    data.setCustomerItem(rs.getString(4));
    data.setStateName(rs.getString(5));
    data.setBeginTime(DateUtils.getDateTz(rs, 6));
    data.setEndTime(DateUtils.getDateTz(rs, 7));
    data.setRun(rs.getString(8));
    data.setResourceBo(rs.getString(9));
    data.setOperationBo(rs.getString(10));
    data.setRouterBo(rs.getString(11));
    data.setRecipeName(rs.getString(12));
    data.setRemark(rs.getString(13));
    data.setRunUser(rs.getString(14));
    return data;
  }

}
