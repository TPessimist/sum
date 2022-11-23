package ame.psb.db.dao;

import ame.psb.db.DcResult;
import ame.psb.db.ViewDcResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class DcResultDao {

  private static final String SQL_INS = "INSERT INTO zr_dc_result(id,dc_time,sfc_bo,resource_bo,dc_dcop_bo,operation_bo,dc_plan_bo,run_sfc_bo,state_name) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_dc_result SET dc_time=?,sfc_bo=?,resource_bo=?,dc_dcop_bo=?,operation_bo=?,dc_plan_bo=?,run_sfc_bo=?,state_name=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,dc_time,sfc_bo,resource_bo,dc_dcop_bo,operation_bo,dc_plan_bo,run_sfc_bo,state_name,customer_itemset_bo,customer_itemset_name,sfc_name FROM view_dc_result ";

  private final Connection conn;

  public DcResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DcResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      DateUtils.setDateTz(ps, 2, data.getDcTime());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getResourceBo());
      ps.setString(5, data.getDcopBo());
      ps.setString(6, data.getOperationBo());
      ps.setString(7, data.getDcPlanBo());
      ps.setString(8, data.getRunSfcBo());
      ps.setString(9, data.getStateName());

      return ps.executeUpdate();
    }
  }

  public int update(DcResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      DateUtils.setDateTz(ps, 1, data.getDcTime());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getResourceBo());
      ps.setString(4, data.getDcopBo());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getDcPlanBo());
      ps.setString(7, data.getRunSfcBo());
      ps.setString(8, data.getStateName());
      ps.setString(9, data.getId());

      return ps.executeUpdate();
    }
  }

  public List<ViewDcResult> selectBySfc(String sfcBo, String operationBo) throws SQLException {
    ArrayList<ViewDcResult> result = new ArrayList<ViewDcResult>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND operation_bo=? ORDER BY id")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewDcResult selectByDcopNew(String sfc, String dcopBo, String operationBo)
      throws SQLException {
    ViewDcResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE sfc_bo=? and  DC_DCOP_BO=? AND operation_bo=? ORDER BY DC_TIME DESC")) {
      ps.setString(1, sfc);
      ps.setString(2, dcopBo);
      ps.setString(3, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }
    return result;
  }

  public List<ViewDcResult> selectBySfcSfcAndOperationBoAndDcopBo(String sfcBo, String operationBo,
      String dcopBo,
      Date data) throws SQLException {
    ArrayList<ViewDcResult> result = new ArrayList<ViewDcResult>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE sfc_bo=? AND operation_bo=? and  DC_DCOP_BO = ? and DC_TIME between ? and CURRENT_TIMESTAMP  ORDER BY id")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);
      ps.setString(3, dcopBo);
      DateUtils.setDateTz(ps, 4, data);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewDcResult> selectBySfc(String sfcBo, String operationBo, String resourceBo)
      throws SQLException {
    ArrayList<ViewDcResult> result = new ArrayList<ViewDcResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE sfc_bo=? AND operation_bo=? AND resource_bo=? ORDER BY id")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);
      ps.setString(2, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewDcResult> selectBySfcRun(String sfcBo, String runSfcBo) throws SQLException {
    ArrayList<ViewDcResult> result = new ArrayList<ViewDcResult>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND run_sfc_bo=? order by dc_dcop_bo")) {
      ps.setString(1, sfcBo);
      ps.setString(2, runSfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewDcResult> selectByPlan(String dcPlanBo) throws SQLException {
    ArrayList<ViewDcResult> result = new ArrayList<ViewDcResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE dc_plan_bo=?")) {
      ps.setString(1, dcPlanBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewDcResult> selectAll() throws SQLException {
    ArrayList<ViewDcResult> result = new ArrayList<ViewDcResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewDcResult selectByPK(String id) throws SQLException {
    ViewDcResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }
    return result;
  }

  public ViewDcResult selectByPK(String sfcBo, String dcPlanBo) throws SQLException {
    ViewDcResult result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND dc_plan_bo=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, dcPlanBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }
    return result;
  }

  private ViewDcResult convert(ResultSet rs) throws SQLException {
    ViewDcResult data = new ViewDcResult();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDcTime(DateUtils.getDateTz(rs, index++));
    data.setSfcBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setDcopBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDcPlanBo(rs.getString(index++));
    data.setRunSfcBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCustomerItemsetBo(rs.getString(index++));
    data.setCustomerItemsetName(rs.getString(index++));
    data.setSfcName(rs.getString(index++));

    return data;
  }
}