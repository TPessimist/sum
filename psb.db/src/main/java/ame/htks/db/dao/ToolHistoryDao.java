package ame.htks.db.dao;

import ame.htks.db.ToolHistory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uia.utils.dao.DateUtils;

public class ToolHistoryDao {

  private static final String SQL_INS = "INSERT INTO zh_tool_history(resource_bo,tool_number_bo,event_datetime,tool_group_bo,qty_limit,qty_current,sfc_bo,sfc_qty,item_bo,operation_bo) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_tool_history SET tool_number_bo=?,event_datetime=?,tool_group_bo=?,qty_limit=?,qty_current=?,sfc_bo=?,sfc_qty=?,item_bo=?,operation_bo=? WHERE resource_bo=?";

  private static final String SQL_SEL = "SELECT resource_bo,tool_number_bo,event_datetime,tool_group_bo,qty_limit,qty_current,sfc_bo,sfc_qty,item_bo,operation_bo FROM zh_tool_history ";
  private static final String SQL_SEL_DIS = "SELECT  DISTINCT ITEM_BO,TOOL_GROUP_BO  FROM zh_tool_history ";

  private final Connection conn;

  public ToolHistoryDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ToolHistory data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getToolNumberBo());
      DateUtils.setDateTz(ps, 3, data.getEventDatetime());
      ps.setString(4, data.getToolGroupBo());
      ps.setBigDecimal(5, data.getQtyLimit());
      ps.setBigDecimal(6, data.getQtyCurrent());
      ps.setString(7, data.getSfcBo());
      ps.setBigDecimal(8, data.getSfcQty());
      ps.setString(9, data.getItemBo());
      ps.setString(10, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ToolHistory> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ToolHistory data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getToolNumberBo());
        DateUtils.setDateTz(ps, 3, data.getEventDatetime());
        ps.setString(4, data.getToolGroupBo());
        ps.setBigDecimal(5, data.getQtyLimit());
        ps.setBigDecimal(6, data.getQtyCurrent());
        ps.setString(7, data.getSfcBo());
        ps.setBigDecimal(8, data.getSfcQty());
        ps.setString(9, data.getItemBo());
        ps.setString(10, data.getOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ToolHistory data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getToolNumberBo());
      DateUtils.setDateTz(ps, 2, data.getEventDatetime());
      ps.setString(3, data.getToolGroupBo());
      ps.setBigDecimal(4, data.getQtyLimit());
      ps.setBigDecimal(5, data.getQtyCurrent());
      ps.setString(6, data.getSfcBo());
      ps.setBigDecimal(7, data.getSfcQty());
      ps.setString(8, data.getItemBo());
      ps.setString(9, data.getOperationBo());
      ps.setString(10, data.getResourceBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ToolHistory> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ToolHistory data : dataList) {
        ps.setString(1, data.getToolNumberBo());
        DateUtils.setDateTz(ps, 2, data.getEventDatetime());
        ps.setString(3, data.getToolGroupBo());
        ps.setBigDecimal(4, data.getQtyLimit());
        ps.setBigDecimal(5, data.getQtyCurrent());
        ps.setString(6, data.getSfcBo());
        ps.setBigDecimal(7, data.getSfcQty());
        ps.setString(8, data.getItemBo());
        ps.setString(9, data.getOperationBo());
        ps.setString(10, data.getResourceBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resourceBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zh_tool_history WHERE resource_bo=?")) {
      ps.setString(1, resourceBo);

      return ps.executeUpdate();
    }
  }

  public List<ToolHistory> selectAll() throws SQLException {
    ArrayList<ToolHistory> result = new ArrayList<ToolHistory>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  public Map<String,String> selectByOperation(String operationBo) throws SQLException {
    Map<String,String> result = new HashMap<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_DIS+"WHERE OPERATION_BO=?")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.put(rs.getString(1),rs.getString(2));
      }
      return result;
    }
  }

  public List<ToolHistory> selectByOperation1(String toolGroupBo,String itemBo,String operationBo) throws SQLException {
    ArrayList<ToolHistory> result = new ArrayList<ToolHistory>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL+"WHERE TOOL_GROUP_BO=? and ITEM_BO= ? and OPERATION_BO = ?")) {
      ps.setString(1, toolGroupBo);
      ps.setString(2, itemBo);
      ps.setString(3, operationBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  public ToolHistory selectBySfcAndOp(String sfcBo, String operationBo) throws SQLException {
    ToolHistory result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE SFC_BO=? AND OPERATION_BO=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ToolHistory convert(ResultSet rs) throws SQLException {
    ToolHistory data = new ToolHistory();

    int index = 1;
    data.setResourceBo(rs.getString(index++));
    data.setToolNumberBo(rs.getString(index++));
    data.setEventDatetime(DateUtils.getDateTz(rs, index++));
    data.setToolGroupBo(rs.getString(index++));
    data.setQtyLimit(rs.getBigDecimal(index++));
    data.setQtyCurrent(rs.getBigDecimal(index++));
    data.setSfcBo(rs.getString(index++));
    data.setSfcQty(rs.getBigDecimal(index++));
    data.setItemBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));

    return data;
  }
}
