package ame.psb.db.dao;

import ame.psb.db.RunInventoryLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunInventoryLogDao {

  private static final String SQL_INS = "INSERT INTO zr_inventory_log(id,inventory_bo,action_name,picked_user,sfc_bo,run_sfc_bo,resource_bo,slot_bo,count,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_inventory_log SET inventory_bo=?,action_name=?,picked_user=?,sfc_bo=?,run_sfc_bo=?,resource_bo=?,slot_bo=?,count=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,inventory_bo,action_name,picked_user,sfc_bo,run_sfc_bo,resource_bo,slot_bo,count,updated_user,updated_time FROM zr_inventory_log ";

  private final Connection conn;

  public RunInventoryLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunInventoryLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getInventoryBo());
      ps.setString(3, data.getActionName());
      ps.setString(4, data.getPickedUser());
      ps.setString(5, data.getSfcBo());
      ps.setString(6, data.getRunSfcBo());
      ps.setString(7, data.getResourceBo());
      ps.setString(8, data.getSlotBo());
      ps.setBigDecimal(9, data.getCount());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunInventoryLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunInventoryLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getInventoryBo());
        ps.setString(3, data.getActionName());
        ps.setString(4, data.getPickedUser());
        ps.setString(5, data.getSfcBo());
        ps.setString(6, data.getRunSfcBo());
        ps.setString(7, data.getResourceBo());
        ps.setString(8, data.getSlotBo());
        ps.setBigDecimal(9, data.getCount());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunInventoryLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getInventoryBo());
      ps.setString(2, data.getActionName());
      ps.setString(3, data.getPickedUser());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getRunSfcBo());
      ps.setString(6, data.getResourceBo());
      ps.setString(7, data.getSlotBo());
      ps.setBigDecimal(8, data.getCount());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
      ps.setString(11, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunInventoryLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunInventoryLog data : dataList) {
        ps.setString(1, data.getInventoryBo());
        ps.setString(2, data.getActionName());
        ps.setString(3, data.getPickedUser());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getRunSfcBo());
        ps.setString(6, data.getResourceBo());
        ps.setString(7, data.getSlotBo());
        ps.setBigDecimal(8, data.getCount());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
        ps.setString(11, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_inventory_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<RunInventoryLog> selectAll() throws SQLException {
    ArrayList<RunInventoryLog> result = new ArrayList<RunInventoryLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public RunInventoryLog selectByPK(String id) throws SQLException {
    RunInventoryLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public List<RunInventoryLog> selectByInventoryBo(String inventoryBo) throws SQLException {
    List<RunInventoryLog> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE INVENTORY_BO=?")) {
      ps.setString(1, inventoryBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<RunInventoryLog> selectByInventoryBoAndAction(String inventoryBo, String actionName)
      throws SQLException {
    List<RunInventoryLog> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE INVENTORY_BO=? AND ACTION_NAME=?")) {
      ps.setString(1, inventoryBo);
      ps.setString(2, actionName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public RunInventoryLog selectByNew(String inventoryBo , String actionName) throws SQLException {
    RunInventoryLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE INVENTORY_BO=? AND ACTION_NAME=? ORDER BY updated_time DESC ")) {
      ps.setString(1, inventoryBo);
      ps.setString(2, actionName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private RunInventoryLog convert(ResultSet rs) throws SQLException {
    RunInventoryLog data = new RunInventoryLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setInventoryBo(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setPickedUser(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setRunSfcBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setSlotBo(rs.getString(index++));
    data.setCount(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
