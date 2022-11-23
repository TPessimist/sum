package ame.psb.db.dao;

import ame.psb.db.ViewRunTgSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunTgSfcDao {

  private static final String SQL_SEL = "SELECT resource_bo,tool_number_bo,event_datetime,tool_group_bo,qty_limit,qty_current,sfc_bo,item_bo,operation_bo,resource_name,sfc_name,tool_number FROM view_run_tg_sfc ";

  private final Connection conn;

  public RunTgSfcDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewRunTgSfc> selectBySfc(String sfcBo, Date begin, Date end) throws SQLException {
    ArrayList<ViewRunTgSfc> result = new ArrayList<ViewRunTgSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE sfc_bo=? AND event_datetime BETWEEN ? AND ? ORDER BY event_datetime,tool_number_bo")) {
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

  public List<ViewRunTgSfc> selectByResource(String resourceBo, Date begin, Date end)
      throws SQLException {
    ArrayList<ViewRunTgSfc> result = new ArrayList<ViewRunTgSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE resource_bo=? AND event_datetime BETWEEN ? AND ? ORDER BY event_datetime,tool_number_bo,sfc_bo")) {
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

  public List<ViewRunTgSfc> selectByToolNumber(String toolNumberbBo, Date begin, Date end)
      throws SQLException {
    ArrayList<ViewRunTgSfc> result = new ArrayList<ViewRunTgSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE tool_number_bo=? AND event_datetime BETWEEN ? AND ? ORDER BY event_datetime,sfc_bo")) {
      ps.setString(1, toolNumberbBo);
      DateUtils.setDateTz(ps, 2, begin);
      DateUtils.setDateTz(ps, 3, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewRunTgSfc> selectBySfcBoAndOperation(String sfcBo, String operationBo)
      throws SQLException {
    ArrayList<ViewRunTgSfc> result = new ArrayList<ViewRunTgSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE sfc_bo=? AND operation_bo = ?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewRunTgSfc convert(ResultSet rs) throws SQLException {
    ViewRunTgSfc data = new ViewRunTgSfc();

    int index = 1;
    data.setResourceBo(rs.getString(index++));
    data.setToolNumberBo(rs.getString(index++));
    data.setEventDatetime(DateUtils.getDateTz(rs, index++));
    data.setToolGroupBo(rs.getString(index++));
    data.setQtyLimit(rs.getBigDecimal(index++));
    data.setQtyCurrent(rs.getBigDecimal(index++));
    data.setSfcBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setResourceName(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setToolNumber(rs.getString(index++));

    return data;
  }
}
