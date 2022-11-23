package ame.psb.db.dao;

import ame.psb.db.RunMtSfc;
import ame.psb.db.ViewRunMtSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunMtSfcDao {

  private static final String SQL_INS = "INSERT INTO zr_run_mt_sfc(id,state_name,begin_time,end_time,sfc_step_bo,sfc_bo,bom_component_bo,run,resource_bo,operation_bo,router_bo,inventory_bo,material_qty,run_user,bom_component_item_bo,slot_name,plan_qty,run_sfc_bo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_run_mt_sfc SET state_name=?,begin_time=?,end_time=?,sfc_step_bo=?,sfc_bo=?,bom_component_bo=?,run=?,resource_bo=?,operation_bo=?,router_bo=?,inventory_bo=?,material_qty=?,run_user=?,bom_component_item_bo=?,slot_name=?,plan_qty=?,run_sfc_bo=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,state_name,begin_time,end_time,sfc_step_bo,sfc_bo,bom_component_bo,run,resource_bo,operation_bo,router_bo,inventory_bo,material_qty,run_user,bom_component_item_bo,slot_name,plan_qty,run_sfc_bo,resource_name,sfc_name,product_bo,inventory_id,item_bo,item_name FROM view_run_mt_sfc ";

  private final Connection conn;

  public RunMtSfcDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunMtSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getStateName());
      DateUtils.setDateTz(ps, 3, data.getBeginTime());
      DateUtils.setDateTz(ps, 4, data.getEndTime());
      ps.setString(5, data.getSfcStepBo());
      ps.setString(6, data.getSfcBo());
      ps.setString(7, data.getBomComponentBo());
      ps.setString(8, data.getRun());
      ps.setString(9, data.getResourceBo());
      ps.setString(10, data.getOperationBo());
      ps.setString(11, data.getRouterBo());
      ps.setString(12, data.getInventoryBo());
      ps.setBigDecimal(13, data.getMaterialQty());
      ps.setString(14, data.getRunUser());
      ps.setString(15, data.getBomComponentItemBo());
      ps.setString(16, data.getSlotName());
      ps.setBigDecimal(17, data.getPlanQty());
      ps.setString(18, data.getRunSfcBo());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunMtSfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunMtSfc data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getStateName());
        DateUtils.setDateTz(ps, 3, data.getBeginTime());
        DateUtils.setDateTz(ps, 4, data.getEndTime());
        ps.setString(5, data.getSfcStepBo());
        ps.setString(6, data.getSfcBo());
        ps.setString(7, data.getBomComponentBo());
        ps.setString(8, data.getRun());
        ps.setString(9, data.getResourceBo());
        ps.setString(10, data.getOperationBo());
        ps.setString(11, data.getRouterBo());
        ps.setString(12, data.getInventoryBo());
        ps.setBigDecimal(13, data.getMaterialQty());
        ps.setString(14, data.getRunUser());
        ps.setString(15, data.getBomComponentItemBo());
        ps.setString(16, data.getSlotName());
        ps.setBigDecimal(17, data.getPlanQty());
        ps.setString(18, data.getRunSfcBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunMtSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getStateName());
      DateUtils.setDateTz(ps, 2, data.getBeginTime());
      DateUtils.setDateTz(ps, 3, data.getEndTime());
      ps.setString(4, data.getSfcStepBo());
      ps.setString(5, data.getSfcBo());
      ps.setString(6, data.getBomComponentBo());
      ps.setString(7, data.getRun());
      ps.setString(8, data.getResourceBo());
      ps.setString(9, data.getOperationBo());
      ps.setString(10, data.getRouterBo());
      ps.setString(11, data.getInventoryBo());
      ps.setBigDecimal(12, data.getMaterialQty());
      ps.setString(13, data.getRunUser());
      ps.setString(14, data.getBomComponentItemBo());
      ps.setString(15, data.getSlotName());
      ps.setBigDecimal(16, data.getPlanQty());
      ps.setString(17, data.getRunSfcBo());
      ps.setString(18, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunMtSfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunMtSfc data : dataList) {
        ps.setString(1, data.getStateName());
        DateUtils.setDateTz(ps, 2, data.getBeginTime());
        DateUtils.setDateTz(ps, 3, data.getEndTime());
        ps.setString(4, data.getSfcStepBo());
        ps.setString(5, data.getSfcBo());
        ps.setString(6, data.getBomComponentBo());
        ps.setString(7, data.getRun());
        ps.setString(8, data.getResourceBo());
        ps.setString(9, data.getOperationBo());
        ps.setString(10, data.getRouterBo());
        ps.setString(11, data.getInventoryBo());
        ps.setBigDecimal(12, data.getMaterialQty());
        ps.setString(13, data.getRunUser());
        ps.setString(14, data.getBomComponentItemBo());
        ps.setString(15, data.getSlotName());
        ps.setBigDecimal(16, data.getPlanQty());
        ps.setString(17, data.getRunSfcBo());
        ps.setString(18, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_run_mt_sfc WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ViewRunMtSfc> selectAll() throws SQLException {
    ArrayList<ViewRunMtSfc> result = new ArrayList<ViewRunMtSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewRunMtSfc> selectBySfc(String sfcBo, Date begin, Date end) throws SQLException {
    ArrayList<ViewRunMtSfc> result = new ArrayList<ViewRunMtSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE sfc_bo=? AND begin_time BETWEEN ? AND ? ORDER BY begin_time,item_bo")) {
      ps.setString(1, sfcBo);
      DateUtils.setDateTz(ps, 2, begin);
      DateUtils.setDateTz(ps, 3, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewRunMtSfc> selectByResource(String resourceBo, Date begin, Date end)
      throws SQLException {
    ArrayList<ViewRunMtSfc> result = new ArrayList<ViewRunMtSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE resource_bo=? AND begin_time BETWEEN ? AND ? ORDER BY begin_time,item_bo,sfc_bo")) {
      ps.setString(1, resourceBo);
      DateUtils.setDateTz(ps, 2, begin);
      DateUtils.setDateTz(ps, 3, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewRunMtSfc> selectByResourceAndSfc(String resourceBo, String sfcName, Date begin,
      Date end) throws SQLException {
    ArrayList<ViewRunMtSfc> result = new ArrayList<ViewRunMtSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE resource_bo=? AND sfc_name=? AND begin_time BETWEEN ? AND ? ORDER BY begin_time")) {
      ps.setString(1, resourceBo);
      ps.setString(2, sfcName);
      DateUtils.setDateTz(ps, 3, begin);
      DateUtils.setDateTz(ps, 4, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewRunMtSfc> selectByItem(String itemBo, Date begin, Date end) throws SQLException {
    ArrayList<ViewRunMtSfc> result = new ArrayList<ViewRunMtSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE item_bo=? AND begin_time BETWEEN ? AND ? ORDER BY begin_time,sfc_bo")) {
      ps.setString(1, itemBo);
      DateUtils.setDateTz(ps, 2, begin);
      DateUtils.setDateTz(ps, 3, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewRunMtSfc> selectByInventory(String inventoryBo, Date begin, Date end)
      throws SQLException {
    ArrayList<ViewRunMtSfc> result = new ArrayList<ViewRunMtSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE inventory_bo=? AND begin_time BETWEEN ? AND ? ORDER BY begin_time,sfc_bo")) {
      ps.setString(1, inventoryBo);
      DateUtils.setDateTz(ps, 2, begin);
      DateUtils.setDateTz(ps, 3, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewRunMtSfc> selectBomByOperationAndRunSfc(String operationBo, String runSfcBo,
      String bomComponentItemBo) throws SQLException {
    ArrayList<ViewRunMtSfc> result = new ArrayList<ViewRunMtSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + " WHERE operation_bo=? AND run_sfc_bo=? AND bom_component_item_bo=?")) {
      ps.setString(1, operationBo);
      ps.setString(2, runSfcBo);
      ps.setString(3, bomComponentItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewRunMtSfc selectByPK(String id) throws SQLException {
    ViewRunMtSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewRunMtSfc> selectByOperationAndSfc(String runsfcBo) throws SQLException {
    ArrayList<ViewRunMtSfc> result = new ArrayList<ViewRunMtSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE run_sfc_bo = ? ")) {
      ps.setString(1, runsfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewRunMtSfc convert(ResultSet rs) throws SQLException {
    ViewRunMtSfc data = new ViewRunMtSfc();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setBeginTime(DateUtils.getDateTz(rs, index++));
    data.setEndTime(DateUtils.getDateTz(rs, index++));
    data.setSfcStepBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setBomComponentBo(rs.getString(index++));
    data.setRun(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setRouterBo(rs.getString(index++));
    data.setInventoryBo(rs.getString(index++));
    data.setMaterialQty(rs.getBigDecimal(index++));
    data.setRunUser(rs.getString(index++));
    data.setBomComponentItemBo(rs.getString(index++));
    data.setSlotName(rs.getString(index++));
    data.setPlanQty(rs.getBigDecimal(index++));
    data.setRunSfcBo(rs.getString(index++));

    data.setResourceName(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setProductBo(rs.getString(index++));
    data.setInventoryId(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    return data;
  }
}
