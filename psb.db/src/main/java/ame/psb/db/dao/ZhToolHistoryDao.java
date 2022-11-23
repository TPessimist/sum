package ame.psb.db.dao;

import ame.psb.db.ZhToolHistory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZhToolHistoryDao {

  private static final String SQL_INS = "INSERT INTO zh_tool_history(resource_bo,tool_number_bo,event_datetime,tool_group_bo,qty_limit,qty_current,sfc_bo,sfc_qty,item_bo,operation_bo) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_tool_history SET tool_group_bo=?,qty_limit=?,qty_current=?,sfc_bo=?,sfc_qty=?,item_bo=?,operation_bo=? WHERE resource_bo=? AND tool_number_bo=? AND event_datetime=?";

  private static final String SQL_SEL = "SELECT resource_bo,tool_number_bo,event_datetime,tool_group_bo,qty_limit,qty_current,sfc_bo,sfc_qty,item_bo,operation_bo FROM zh_tool_history ";

  private final Connection conn;

  public ZhToolHistoryDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZhToolHistory data) throws SQLException {
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

  public int insert(List<ZhToolHistory> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZhToolHistory data : dataList) {
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

  public int update(ZhToolHistory data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getToolGroupBo());
      ps.setBigDecimal(2, data.getQtyLimit());
      ps.setBigDecimal(3, data.getQtyCurrent());
      ps.setString(4, data.getSfcBo());
      ps.setBigDecimal(5, data.getSfcQty());
      ps.setString(6, data.getItemBo());
      ps.setString(7, data.getOperationBo());
      ps.setString(8, data.getResourceBo());
      ps.setString(9, data.getToolNumberBo());
      DateUtils.setDateTz(ps, 10, data.getEventDatetime());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZhToolHistory> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZhToolHistory data : dataList) {
        ps.setString(1, data.getToolGroupBo());
        ps.setBigDecimal(2, data.getQtyLimit());
        ps.setBigDecimal(3, data.getQtyCurrent());
        ps.setString(4, data.getSfcBo());
        ps.setBigDecimal(5, data.getSfcQty());
        ps.setString(6, data.getItemBo());
        ps.setString(7, data.getOperationBo());
        ps.setString(8, data.getResourceBo());
        ps.setString(9, data.getToolNumberBo());
        DateUtils.setDateTz(ps, 10, data.getEventDatetime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resourceBo, String toolNumberBo, Date eventDatetime)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zh_tool_history WHERE resource_bo=? AND tool_number_bo=? AND event_datetime=?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, toolNumberBo);
      DateUtils.setDateTz(ps, 3, eventDatetime);
      return ps.executeUpdate();
    }
  }

  public List<ZhToolHistory> selectBySfcBoAndResourceBo(String resourceBo, String sfcBo, Date start,
      Date end) throws SQLException {
    ArrayList<ZhToolHistory> result = new ArrayList<ZhToolHistory>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE resource_bo=? AND sfc_bo=? AND event_datetime between ? AND ? order by event_datetime")) {
      ps.setString(1, resourceBo);
      ps.setString(2, sfcBo);
      DateUtils.setDateTz(ps, 3, start);
      DateUtils.setDateTz(ps, 4, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ZhToolHistory selectBySfcOperation(String resourceBo, String sfcBo, String operation)
      throws SQLException {
    ZhToolHistory result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE RESOURCE_BO =? AND SFC_BO = ? AND  OPERATION_BO = ? order by event_datetime DESC")) {
      ps.setString(1, resourceBo);
      ps.setString(2, sfcBo);
      ps.setString(3, operation);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = new ZhToolHistory();
        result = convert(rs);
      }
      return result;
    }
  }

  public ZhToolHistory selectByPK(String resourceBo, String toolNumberBo, Date eventDatetime)
      throws SQLException {
    ZhToolHistory result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE resource_bo=? AND tool_number_bo=? AND event_datetime=?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, toolNumberBo);
      DateUtils.setDateTz(ps, 3, eventDatetime);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = new ZhToolHistory();
        result = convert(rs);
      }
      return result;
    }
  }

  private ZhToolHistory convert(ResultSet rs) throws SQLException {
    ZhToolHistory data = new ZhToolHistory();

    int index = 1;
    data.setResourceBo(rs.getString(index++));
    data.setToolNumberBo(rs.getString(index++));
    data.setEventDatetime(rs.getTimestamp(index++));
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