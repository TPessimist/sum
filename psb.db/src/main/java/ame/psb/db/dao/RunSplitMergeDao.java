package ame.psb.db.dao;

import ame.psb.db.RunSplitMerge;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunSplitMergeDao {

  private static final String SQL_INS = "INSERT INTO zr_run_split_merge(id,action_name,function_name,bef_source_sfc_bo,bef_target_sfc_bo,bef_source_carrier_bo,bef_target_carrier_bo,bef_source_qty,bef_target_qty,aft_source_sfc_bo,aft_target_sfc_bo,aft_source_carrier_bo,aft_target_carrier_bo,aft_source_qty,aft_target_qty,operation_bo,run_time,run_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_SEL = "SELECT id,action_name,function_name,bef_source_sfc_bo,bef_target_sfc_bo,bef_source_carrier_bo,bef_target_carrier_bo,bef_source_qty,bef_target_qty,aft_source_sfc_bo,aft_target_sfc_bo,aft_source_carrier_bo,aft_target_carrier_bo,aft_source_qty,aft_target_qty,operation_bo,run_time,run_user FROM zr_run_split_merge ";

  private final Connection conn;

  public RunSplitMergeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunSplitMerge data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getActionName());
      ps.setString(3, data.getFunctionName());
      ps.setString(4, data.getBefSourceSfcBo());
      ps.setString(5, data.getBefTargetSfcBo());
      ps.setString(6, data.getBefSourceCarrierBo());
      ps.setString(7, data.getBefTargetCarrierBo());
      ps.setBigDecimal(8, data.getBefSourceQty());
      ps.setBigDecimal(9, data.getBefTargetQty());
      ps.setString(10, data.getAftSourceSfcBo());
      ps.setString(11, data.getAftTargetSfcBo());
      ps.setString(12, data.getAftSourceCarrierBo());
      ps.setString(13, data.getAftTargetCarrierBo());
      ps.setBigDecimal(14, data.getAftSourceQty());
      ps.setBigDecimal(15, data.getAftTargetQty());
      ps.setString(16, data.getOperationBo());
      DateUtils.setDateTz(ps, 17, data.getRunTime());
      ps.setString(18, data.getRunUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunSplitMerge> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunSplitMerge data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getActionName());
        ps.setString(3, data.getFunctionName());
        ps.setString(4, data.getBefSourceSfcBo());
        ps.setString(5, data.getBefTargetSfcBo());
        ps.setString(6, data.getBefSourceCarrierBo());
        ps.setString(7, data.getBefTargetCarrierBo());
        ps.setBigDecimal(8, data.getBefSourceQty());
        ps.setBigDecimal(9, data.getBefTargetQty());
        ps.setString(10, data.getAftSourceSfcBo());
        ps.setString(11, data.getAftTargetSfcBo());
        ps.setString(12, data.getAftSourceCarrierBo());
        ps.setString(13, data.getAftTargetCarrierBo());
        ps.setBigDecimal(14, data.getAftSourceQty());
        ps.setBigDecimal(15, data.getAftTargetQty());
        ps.setString(16, data.getOperationBo());
        DateUtils.setDateTz(ps, 17, data.getRunTime());
        ps.setString(18, data.getRunUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public List<RunSplitMerge> selectAll() throws SQLException {
    ArrayList<RunSplitMerge> result = new ArrayList<RunSplitMerge>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<RunSplitMerge> selectByAction(String sfcBo) throws SQLException {
    ArrayList<RunSplitMerge> result = new ArrayList<RunSplitMerge>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE (bef_source_sfc_bo=? OR aft_target_sfc_bo=? )"
            + " AND (action_name='SPLIT' OR action_name='MERGE'  OR action_name='SHOP_ORDER_RELEASE') ORDER BY run_time")) {
      ps.setString(1, sfcBo);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<RunSplitMerge> selectBySplitMerge(String sfcBo) throws SQLException {
    ArrayList<RunSplitMerge> result = new ArrayList<RunSplitMerge>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE (bef_target_sfc_bo = ? or bef_source_sfc_bo =?) AND action_name='SPLIT_MERGE' ORDER BY run_time")) {
      ps.setString(1, sfcBo);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public RunSplitMerge selectByPK(String id) throws SQLException {
    RunSplitMerge result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private RunSplitMerge convert(ResultSet rs) throws SQLException {
    RunSplitMerge data = new RunSplitMerge();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setFunctionName(rs.getString(index++));
    data.setBefSourceSfcBo(rs.getString(index++));
    data.setBefTargetSfcBo(rs.getString(index++));
    data.setBefSourceCarrierBo(rs.getString(index++));
    data.setBefTargetCarrierBo(rs.getString(index++));
    data.setBefSourceQty(rs.getBigDecimal(index++));
    data.setBefTargetQty(rs.getBigDecimal(index++));
    data.setAftSourceSfcBo(rs.getString(index++));
    data.setAftTargetSfcBo(rs.getString(index++));
    data.setAftSourceCarrierBo(rs.getString(index++));
    data.setAftTargetCarrierBo(rs.getString(index++));
    data.setAftSourceQty(rs.getBigDecimal(index++));
    data.setAftTargetQty(rs.getBigDecimal(index++));
    data.setOperationBo(rs.getString(index++));
    data.setRunTime(DateUtils.getDateTz(rs, index++));
    data.setRunUser(rs.getString(index++));

    return data;
  }
}