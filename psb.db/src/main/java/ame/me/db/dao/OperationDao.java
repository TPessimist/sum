package ame.me.db.dao;

import ame.me.db.Operation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperationDao {

  private static final String SQL_SEL = "SELECT handle," +
      "change_stamp,site,operation,description,type," +
      "special_router_bo,status_bo,resource_type_bo,revision,current_revision," +
      "eff_start_date,eff_end_date,created_date_time,modified_date_time," +
      "pca_dashboard_mode,default_nc_code_bo,failure_tracking_config_bo,resource_bo," +
      "max_loop,required_time_in_process,reporting_step,prev_site," +
      "original_transfer_key,special_instruction,reporting_center_bo,erp_control_key_bo," +
      "erp_work_center_bo FROM operation ";

  private Connection conn;

  public OperationDao(Connection conn) {
    this.conn = conn;
  }

  public List<Operation> selectAll(String site) throws SQLException {
    ArrayList<Operation> result = new ArrayList<Operation>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? ORDER BY operation")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public Operation selectByName(String site, String name) throws SQLException {
    Operation result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? AND operation=? AND current_revision='true' ")) {
      ps.setString(1, site);
      ps.setString(2, name);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }
    return result;
  }

  public Operation selectByPK(String handel) throws SQLException {
    Operation result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE  operation=?  ")) {
      ps.setString(1, handel);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }
    return result;
  }

  public Operation selectByoperation(String operation) throws SQLException {
    Operation result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE OPERATION=? AND current_revision='true'")) {
      ps.setString(1, operation);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }
    return result;
  }

  public List<Operation> selectByNamePrefix(String site, String name) throws SQLException {
    ArrayList<Operation> result = new ArrayList<Operation>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? AND operation like ? ORDER BY operation")) {
      ps.setString(1, site);
      ps.setString(2, name + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  private Operation convert(ResultSet rs) throws SQLException {
    Operation data = new Operation();
    data.setHandle(rs.getString(1));
    data.setChangeStamp(rs.getInt(2));
    data.setSite(rs.getString(3));
    data.setOperation(rs.getString(4));
    data.setDescription(rs.getString(5));
    data.setType(rs.getString(6));
    data.setSpecialRouterBo(rs.getString(7));
    data.setStatusBo(rs.getString(8));
    data.setResourceTypeBo(rs.getString(9));
    data.setRevision(rs.getString(10));
    data.setCurrentRevision(rs.getString(11));
    data.setEffStartDate(rs.getTimestamp(12));
    data.setEffEndDate(rs.getTimestamp(13));
    data.setCreatedDateTime(rs.getTimestamp(14));
    data.setModifiedDateTime(rs.getTimestamp(15));
    data.setPcaDashboardMode(rs.getString(16));
    data.setDefaultNcCodeBo(rs.getString(17));
    data.setFailureTrackingConfigBo(rs.getString(18));
    data.setResourceBo(rs.getString(19));
    data.setMaxLoop(rs.getInt(20));
    data.setRequiredTimeInProcess(rs.getInt(21));
    data.setReportingStep(rs.getString(22));
    data.setPrevSite(rs.getString(23));
    data.setOriginalTransferKey(rs.getString(24));
    data.setSpecialInstruction(rs.getString(25));
    data.setReportingCenterBo(rs.getString(26));
    data.setErpControlKeyBo(rs.getString(27));
    data.setErpWorkCenterBo(rs.getString(28));
    return data;
  }
}
