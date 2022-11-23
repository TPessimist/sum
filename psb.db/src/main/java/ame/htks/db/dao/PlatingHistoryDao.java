package ame.htks.db.dao;

import ame.htks.db.PlatingHistory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PlatingHistoryDao {

  private static final String SQL_INS = "INSERT INTO zh_plating_operation_history(id,inventory_bo,resource_bo,item_bo,qty,action,action_time,action_user,demo,out_weight,real_weight) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_plating_operation_history SET inventory_bo=?,resource_bo=?,item_bo=?,qty=?,action=?,action_time=?,action_user=?,demo=?,out_weight=?,real_weight=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,inventory_bo,resource_bo,item_bo,qty,action,action_time,action_user,demo,out_weight,real_weight FROM zh_plating_operation_history ";

  private final Connection conn;

  public PlatingHistoryDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PlatingHistory data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getInventoryBo());
      ps.setString(3, data.getResourceBo());
      ps.setString(4, data.getItemBo());
      ps.setBigDecimal(5, data.getQty());
      ps.setString(6, data.getAction());
      ps.setTimestamp(7, new Timestamp(data.getActionTime().getTime()));
      ps.setString(8, data.getActionUser());
      ps.setString(9, data.getDemo());
      ps.setBigDecimal(10, data.getOutWeight());
      ps.setBigDecimal(11, data.getRealWeight());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PlatingHistory> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PlatingHistory data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getInventoryBo());
        ps.setString(3, data.getResourceBo());
        ps.setString(4, data.getItemBo());
        ps.setBigDecimal(5, data.getQty());
        ps.setString(6, data.getAction());
        ps.setTimestamp(7, new Timestamp(data.getActionTime().getTime()));
        ps.setString(8, data.getActionUser());
        ps.setString(9, data.getDemo());
        ps.setBigDecimal(10, data.getOutWeight());
        ps.setBigDecimal(11, data.getRealWeight());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PlatingHistory data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getInventoryBo());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getItemBo());
      ps.setBigDecimal(4, data.getQty());
      ps.setString(5, data.getAction());
      ps.setTimestamp(6, new Timestamp(data.getActionTime().getTime()));
      ps.setString(7, data.getActionUser());
      ps.setString(8, data.getDemo());
      ps.setBigDecimal(9, data.getOutWeight());
      ps.setBigDecimal(10, data.getRealWeight());
      ps.setString(11, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<PlatingHistory> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PlatingHistory data : dataList) {
        ps.setString(1, data.getInventoryBo());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getItemBo());
        ps.setBigDecimal(4, data.getQty());
        ps.setString(5, data.getAction());
        ps.setTimestamp(6, new Timestamp(data.getActionTime().getTime()));
        ps.setString(7, data.getActionUser());
        ps.setString(8, data.getDemo());
        ps.setBigDecimal(9, data.getOutWeight());
        ps.setBigDecimal(10, data.getRealWeight());
        ps.setString(11, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zh_plating_operation_history WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<PlatingHistory> selectAll() throws SQLException {
    ArrayList<PlatingHistory> result = new ArrayList<PlatingHistory>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PlatingHistory selectByPK(String id) throws SQLException {
    PlatingHistory result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<PlatingHistory> selectByResource(String resourceBo) throws SQLException {
    ArrayList<PlatingHistory> result = new ArrayList<PlatingHistory>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE RESOURCE_BO=? ORDER BY ACTION_TIME asc")) {
      ps.setString(1, resourceBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private PlatingHistory convert(ResultSet rs) throws SQLException {
    PlatingHistory data = new PlatingHistory();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setInventoryBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setQty(rs.getBigDecimal(index++));
    data.setAction(rs.getString(index++));
    data.setActionTime(rs.getTimestamp(index++));
    data.setActionUser(rs.getString(index++));
    data.setDemo(rs.getString(index++));
    data.setOutWeight(rs.getBigDecimal(index++));
    data.setRealWeight(rs.getBigDecimal(index++));

    return data;
  }
}

