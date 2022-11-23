package ame.psb.db.dao;

import ame.psb.db.ReserveToolUsage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ReserveToolUsageDao {

  private static final String SQL_INS = "INSERT INTO zr_reserve_tool_usage(id,customer_item_bo,tool_group_bo,sfc_bo,start_operation_bo,end_operation_bo,usage,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_reserve_tool_usage SET customer_item_bo=?,tool_group_bo=?,sfc_bo=?,start_operation_bo=?,end_operation_bo=?,usage=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,customer_item_bo,tool_group_bo,sfc_bo,start_operation_bo,end_operation_bo,usage,updated_time FROM zr_reserve_tool_usage ";

  private final Connection conn;

  public ReserveToolUsageDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ReserveToolUsage data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getCustomerItemBo());
      ps.setString(3, data.getToolGroupBo());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getStartOperationBo());
      ps.setString(6, data.getEndOperationBo());
      ps.setInt(7, data.getUsage());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ReserveToolUsage> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ReserveToolUsage data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getCustomerItemBo());
        ps.setString(3, data.getToolGroupBo());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getStartOperationBo());
        ps.setString(6, data.getEndOperationBo());
        ps.setInt(7, data.getUsage());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ReserveToolUsage data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getToolGroupBo());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getStartOperationBo());
      ps.setString(5, data.getEndOperationBo());
      ps.setInt(6, data.getUsage());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ReserveToolUsage> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ReserveToolUsage data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getToolGroupBo());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getStartOperationBo());
        ps.setString(5, data.getEndOperationBo());
        ps.setInt(6, data.getUsage());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_reserve_tool_usage WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ReserveToolUsage> selectAll() throws SQLException {
    ArrayList<ReserveToolUsage> result = new ArrayList<ReserveToolUsage>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ReserveToolUsage> selectByToolGroup(String toolGroupBo) throws SQLException {
    ArrayList<ReserveToolUsage> result = new ArrayList<ReserveToolUsage>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where tool_group_bo=?")) {
      ps.setString(1, toolGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ReserveToolUsage> selectByWaferAndEndOperation(String customerItemBo,
      String endOperationBo)
      throws SQLException {
    ArrayList<ReserveToolUsage> result = new ArrayList<ReserveToolUsage>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where customer_item_bo=? and end_operation_bo=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, endOperationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ReserveToolUsage selectByPK(String id) throws SQLException {
    ReserveToolUsage result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ReserveToolUsage convert(ResultSet rs) throws SQLException {
    ReserveToolUsage data = new ReserveToolUsage();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setToolGroupBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setStartOperationBo(rs.getString(index++));
    data.setEndOperationBo(rs.getString(index++));
    data.setUsage(rs.getInt(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
