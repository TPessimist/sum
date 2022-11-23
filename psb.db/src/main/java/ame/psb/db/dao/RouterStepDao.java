package ame.psb.db.dao;

import ame.me.db.RouterStep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouterStepDao {

  private static final String SQL_INS = "INSERT INTO router_step(handle,router_bo,step_id,description,rework,queue_decision_type,router_comp_gbo,reporting_step,sequence,reporting_center_bo,tabular_step_type,scrap_reporting_step,is_last_reporting_step,erp_sequence,erp_control_key_bo,erp_work_center_bo,erp_inspection_complete) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE router_step SET router_bo=?,step_id=?,description=?,rework=?,queue_decision_type=?,router_comp_gbo=?,reporting_step=?,sequence=?,reporting_center_bo=?,tabular_step_type=?,scrap_reporting_step=?,is_last_reporting_step=?,erp_sequence=?,erp_control_key_bo=?,erp_work_center_bo=?,erp_inspection_complete=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,router_bo,step_id,description,rework,queue_decision_type,router_comp_gbo,reporting_step,sequence,reporting_center_bo,tabular_step_type,scrap_reporting_step,is_last_reporting_step,erp_sequence,erp_control_key_bo,erp_work_center_bo,erp_inspection_complete FROM router_step ";

  private final Connection conn;

  public RouterStepDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RouterStep data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getRouterBo());
      ps.setString(3, data.getStepId());
      ps.setString(4, data.getDescription());
      ps.setString(5, data.getRework());
      ps.setString(6, data.getQueueDecisionType());
      ps.setString(7, data.getRouterCompGbo());
      ps.setString(8, data.getReportingStep());
      ps.setBigDecimal(9, data.getSequence());
      ps.setString(10, data.getReportingCenterBo());
      ps.setString(11, data.getTabularStepType());
      ps.setString(12, data.getScrapReportingStep());
      ps.setString(13, data.getIsLastReportingStep());
      ps.setString(14, data.getErpSequence());
      ps.setString(15, data.getErpControlKeyBo());
      ps.setString(16, data.getErpWorkCenterBo());
      ps.setString(17, data.getErpInspectionComplete());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RouterStep> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RouterStep data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getRouterBo());
        ps.setString(3, data.getStepId());
        ps.setString(4, data.getDescription());
        ps.setString(5, data.getRework());
        ps.setString(6, data.getQueueDecisionType());
        ps.setString(7, data.getRouterCompGbo());
        ps.setString(8, data.getReportingStep());
        ps.setBigDecimal(9, data.getSequence());
        ps.setString(10, data.getReportingCenterBo());
        ps.setString(11, data.getTabularStepType());
        ps.setString(12, data.getScrapReportingStep());
        ps.setString(13, data.getIsLastReportingStep());
        ps.setString(14, data.getErpSequence());
        ps.setString(15, data.getErpControlKeyBo());
        ps.setString(16, data.getErpWorkCenterBo());
        ps.setString(17, data.getErpInspectionComplete());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RouterStep data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getRouterBo());
      ps.setString(2, data.getStepId());
      ps.setString(3, data.getDescription());
      ps.setString(4, data.getRework());
      ps.setString(5, data.getQueueDecisionType());
      ps.setString(6, data.getRouterCompGbo());
      ps.setString(7, data.getReportingStep());
      ps.setBigDecimal(8, data.getSequence());
      ps.setString(9, data.getReportingCenterBo());
      ps.setString(10, data.getTabularStepType());
      ps.setString(11, data.getScrapReportingStep());
      ps.setString(12, data.getIsLastReportingStep());
      ps.setString(13, data.getErpSequence());
      ps.setString(14, data.getErpControlKeyBo());
      ps.setString(15, data.getErpWorkCenterBo());
      ps.setString(16, data.getErpInspectionComplete());
      ps.setString(17, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<RouterStep> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RouterStep data : dataList) {
        ps.setString(1, data.getRouterBo());
        ps.setString(2, data.getStepId());
        ps.setString(3, data.getDescription());
        ps.setString(4, data.getRework());
        ps.setString(5, data.getQueueDecisionType());
        ps.setString(6, data.getRouterCompGbo());
        ps.setString(7, data.getReportingStep());
        ps.setBigDecimal(8, data.getSequence());
        ps.setString(9, data.getReportingCenterBo());
        ps.setString(10, data.getTabularStepType());
        ps.setString(11, data.getScrapReportingStep());
        ps.setString(12, data.getIsLastReportingStep());
        ps.setString(13, data.getErpSequence());
        ps.setString(14, data.getErpControlKeyBo());
        ps.setString(15, data.getErpWorkCenterBo());
        ps.setString(16, data.getErpInspectionComplete());
        ps.setString(17, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM router_step WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<RouterStep> selectAll() throws SQLException {
    ArrayList<RouterStep> result = new ArrayList<RouterStep>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<RouterStep> selectByRouterBo(String routerBo) throws SQLException {
    ArrayList<RouterStep> result = new ArrayList<RouterStep>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where ROUTER_BO = ? ")) {
      ps.setString(1, routerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public RouterStep selectByPK(String handle) throws SQLException {
    RouterStep result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private RouterStep convert(ResultSet rs) throws SQLException {
    RouterStep data = new RouterStep();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setRouterBo(rs.getString(index++));
    data.setStepId(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setRework(rs.getString(index++));
    data.setQueueDecisionType(rs.getString(index++));
    data.setRouterCompGbo(rs.getString(index++));
    data.setReportingStep(rs.getString(index++));
    data.setSequence(rs.getBigDecimal(index++));
    data.setReportingCenterBo(rs.getString(index++));
    data.setTabularStepType(rs.getString(index++));
    data.setScrapReportingStep(rs.getString(index++));
    data.setIsLastReportingStep(rs.getString(index++));
    data.setErpSequence(rs.getString(index++));
    data.setErpControlKeyBo(rs.getString(index++));
    data.setErpWorkCenterBo(rs.getString(index++));
    data.setErpInspectionComplete(rs.getString(index++));

    return data;
  }
}
