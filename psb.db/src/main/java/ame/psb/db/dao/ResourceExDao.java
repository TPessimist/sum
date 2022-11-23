package ame.psb.db.dao;

import ame.psb.db.ResourceEx;
import ame.psb.db.ViewResourceEx;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ResourceExDao {

  private static final String SQL_INS = "INSERT INTO zd_resource(resource_bo,move_in_count,move_in_max,tarck_in_count,track_in_max,state_name,capability,eap_support,run_type,priority_check,virtual,tooling_binding,move_in_type,move_out_type,track_in_type,track_out_type,down_state_name,updated_user,updated_time,wait_sfc_count,wait_wafer_count,mcs_state_name,eap_state_name,rms_support) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_resource SET move_in_count=?,move_in_max=?,tarck_in_count=?,track_in_max=?,state_name=?,capability=?,eap_support=?,run_type=?,priority_check=?,virtual=?,tooling_binding=?,move_in_type=?,move_out_type=?,track_in_type=?,track_out_type=?,down_state_name=?,updated_user=?,updated_time=?,wait_sfc_count=?,wait_wafer_count=?,mcs_state_name=?,eap_state_name=?,rms_support=? WHERE resource_bo=?";

  private static final String SQL_UPD_LOCK = "UPDATE zd_resource SET move_in_count=?,move_in_max=?,tarck_in_count=?,track_in_max=?,state_name=?,capability=?,eap_support=?,run_type=?,priority_check=?,virtual=?,tooling_binding=?,move_in_type=?,move_out_type=?,track_in_type=?,track_out_type=?,down_state_name=?,updated_user=?,updated_time=?,wait_sfc_count=?,wait_wafer_count=?,mcs_state_name=?,eap_state_name=?,rms_support=? WHERE resource_bo=? and updated_time =?";

  private static final String SQL_UPD_CAP = "UPDATE zd_resource SET capability = ? where resource_bo = ?";

  private static final String SQL_UPD_BIND = "UPDATE zd_resource SET combine_resource = ? where resource_bo = ?";

  private static final String SQL_UPD_EAP = "UPDATE zd_resource SET control_state = ?,oht_flag=?,rms_flag=?,heartbeat=? where resource_bo = ?";

  private static final String SQL_UPD_FC_EAP = "UPDATE zd_resource SET STATE_NAME = ?,DOWN_STATE_NAME=?,UPDATED_USER=?,UPDATED_TIME=? where resource_bo = ?";

  private static final String SQL_SEL =
      "SELECT resource_bo,move_in_count,move_in_max,tarck_in_count,track_in_max,state_name,capability,eap_support,run_type,priority_check,virtual,tooling_binding,move_in_type,move_out_type,track_in_type,track_out_type,down_state_name,updated_user,updated_time,site,resrce,description,status_bo,valid_from,valid_to,pending_status_bo,pending_comments,pending_reason_code_bo,wait_sfc_count,wait_wafer_count,mcs_state_name,eap_state_name,rms_support,"
          + "function_desc,type_desc,combine_resource,control_state,oht_flag,rms_flag,heartbeat,force_deliver_state FROM view_resource ";

  private Connection conn;

  public ResourceExDao(Connection conn) {
    this.conn = conn;
  }

  public ViewResourceEx selectByPK(String resourceBo) throws SQLException {
    ViewResourceEx data = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_bo=?")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        data = this.convert(rs);
      }
    }
    return data;
  }

  public ViewResourceEx selectByBind(String proberBo, String testerBo) throws SQLException {
    ViewResourceEx data = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? and combine_resource=?")) {
      ps.setString(1, proberBo);
      ps.setString(2, testerBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        data = this.convert(rs);
      }
    }
    return data;
  }

  public ViewResourceEx selectByResoutce(String resourceBo, String virtual) throws SQLException {
    ViewResourceEx data = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? AND  VIRTUAL = ? ")) {
      ps.setString(1, resourceBo);
      ps.setString(2, virtual);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        data = this.convert(rs);
      }
    }
    return data;
  }

  public ViewResourceEx selectByPKOrder(String resourceBo) throws SQLException {
    ViewResourceEx data = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? ORDER BY UPDATED_TIME DESC ")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        data = this.convert(rs);
      }
    }
    return data;
  }

  public ViewResourceEx selectByName(String site, String resrce) throws SQLException {
    ViewResourceEx data = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? AND resrce=? ORDER BY resrce")) {
      ps.setString(1, site);
      ps.setString(2, resrce);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        data = this.convert(rs);
      }
    }
    return data;
  }

  public List<ViewResourceEx> selectByNamePrefix(String site, String namePrefix)
      throws SQLException {
    ArrayList<ViewResourceEx> result = new ArrayList<ViewResourceEx>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? AND resrce like ? ORDER BY resrce")) {
      ps.setString(1, site);
      ps.setString(2, namePrefix + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewResourceEx> selectAll(String site) throws SQLException {
    ArrayList<ViewResourceEx> result = new ArrayList<ViewResourceEx>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? ORDER BY resrce")) {
      ps.setMaxRows(0);
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewResourceEx> selectAllProber() throws SQLException {
    ArrayList<ViewResourceEx> result = new ArrayList<ViewResourceEx>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE function_desc = 'PROBER' ORDER BY resrce")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewResourceEx> selectAllTester() throws SQLException {
    ArrayList<ViewResourceEx> result = new ArrayList<ViewResourceEx>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE function_desc = 'TESTER' ORDER BY resrce")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewResourceEx> selectBindResource() throws SQLException {
    ArrayList<ViewResourceEx> result = new ArrayList<ViewResourceEx>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE function_desc = 'PROBER' AND combine_resource IS NOT NULL AND combine_resource != '' ORDER BY resrce")) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewResourceEx> selectLpHelp() throws SQLException {
    ArrayList<ViewResourceEx> result = new ArrayList<ViewResourceEx>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE RESOURCE_BO LIKE '%LP1' OR RESOURCE_BO LIKE '%LP2' OR RESOURCE_BO LIKE '%LP3'  ORDER BY resrce")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewResourceEx> selectTsvResrce() throws SQLException {
    ArrayList<ViewResourceEx> result = new ArrayList<ViewResourceEx>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " V WHERE exists(SELECT 1 FROM  ZD_LOOKUP Z WHERE Z.ID = 'TSV_RESOURCE' AND Z.VALUE = V.RESRCE) ORDER BY resrce")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewResourceEx> selectWithWaitSfcCount(String site) throws SQLException {
    ArrayList<ViewResourceEx> result = new ArrayList<ViewResourceEx>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? and wait_wafer_count <> 0 ORDER BY resrce")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public int insert(ResourceEx resource) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, resource.getResourceBo());
      ps.setInt(2, resource.getMoveInCount());
      ps.setInt(3, resource.getMoveInMax());
      ps.setInt(4, resource.getTrackInCount());
      ps.setInt(5, resource.getTrackInMax());
      ps.setString(6, resource.getStateName());
      ps.setString(7, resource.getCapability());
      ps.setString(8, resource.isEapSupport() ? "Y" : "N");
      ps.setString(9, resource.getRunType());
      ps.setString(10, resource.getPriorityCheck());
      ps.setString(11, resource.getVirtual());
      ps.setString(12, resource.getToolingBinding());
      ps.setString(13, resource.getMoveInType());
      ps.setString(14, resource.getMoveOutType());
      ps.setString(15, resource.getTrackInType());
      ps.setString(16, resource.getTrackOutType());
      ps.setString(17, resource.getDownStateName());
      ps.setString(18, resource.getUpdatedUser());
      DateUtils.setDateTz(ps, 19, resource.getUpdatedTime());
      ps.setInt(20, resource.getWaitSfcCount());
      ps.setInt(21, resource.getWaitWaferCount());
      ps.setString(22, resource.getMcsStateName());
      ps.setString(23, resource.getEapStateName());
      ps.setString(24, resource.isRmsSupport() ? "Y" : "N");
      return ps.executeUpdate();
    }
  }

  public int update(ResourceEx resource) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, resource.getMoveInCount());
      ps.setInt(2, resource.getMoveInMax());
      ps.setInt(3, resource.getTrackInCount());
      ps.setInt(4, resource.getTrackInMax());
      ps.setString(5, resource.getStateName());
      ps.setString(6, resource.getCapability());
      ps.setString(7, resource.isEapSupport() ? "Y" : "N");
      ps.setString(8, resource.getRunType());
      ps.setString(9, resource.getPriorityCheck());
      ps.setString(10, resource.getVirtual());
      ps.setString(11, resource.getToolingBinding());
      ps.setString(12, resource.getMoveInType());
      ps.setString(13, resource.getMoveOutType());
      ps.setString(14, resource.getTrackInType());
      ps.setString(15, resource.getTrackOutType());
      ps.setString(16, resource.getDownStateName());
      ps.setString(17, resource.getUpdatedUser());
      DateUtils.setDateTz(ps, 18, resource.getUpdatedTime());
      ps.setInt(19, resource.getWaitSfcCount());
      ps.setInt(20, resource.getWaitWaferCount());
      ps.setString(21, resource.getMcsStateName());
      ps.setString(22, resource.getEapStateName());
      ps.setString(23, resource.isRmsSupport() ? "Y" : "N");
      ps.setString(24, resource.getResourceBo());

      return ps.executeUpdate();
    }
  }

  public int updatecap(String resource, String capability) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_CAP)) {
      ps.setString(1, capability);
      ps.setString(2, resource);

      return ps.executeUpdate();
    }
  }

  public int updateEqState(String resource, String eqState, String state, String user, String time)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_FC_EAP)) {
      ps.setString(1, eqState);
      ps.setString(2, state);
      ps.setString(3, user);
      ps.setString(4, time);
      ps.setString(5, resource);

      return ps.executeUpdate();
    }
  }

  public int updateBindResource(String resourceBo, String combineResource) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_BIND)) {
      ps.setString(1, combineResource);
      ps.setString(2, resourceBo);

      return ps.executeUpdate();
    }
  }

  public int updateEapState(String resourceBo, String controlState, String ohtFlag, String rmsFlag,
      Date heartBeat) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_EAP)) {
      ps.setString(1, controlState);
      ps.setString(2, ohtFlag);
      ps.setString(3, rmsFlag);
      DateUtils.setDateTz(ps, 4, heartBeat);
      ps.setString(5, resourceBo);

      return ps.executeUpdate();
    }
  }

  public int updateOptimistic(ResourceEx resource, Date lastUpdatedTime) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_LOCK)) {
      ps.setInt(1, resource.getMoveInCount());
      ps.setInt(2, resource.getMoveInMax());
      ps.setInt(3, resource.getTrackInCount());
      ps.setInt(4, resource.getTrackInMax());
      ps.setString(5, resource.getStateName());
      ps.setString(6, resource.getCapability());
      ps.setString(7, resource.isEapSupport() ? "Y" : "N");
      ps.setString(8, resource.getRunType());
      ps.setString(9, resource.getPriorityCheck());
      ps.setString(10, resource.getVirtual());
      ps.setString(11, resource.getToolingBinding());
      ps.setString(12, resource.getMoveInType());
      ps.setString(13, resource.getMoveOutType());
      ps.setString(14, resource.getTrackInType());
      ps.setString(15, resource.getTrackOutType());
      ps.setString(16, resource.getDownStateName());
      ps.setString(17, resource.getUpdatedUser());
      DateUtils.setDateTz(ps, 18, resource.getUpdatedTime());
      ps.setInt(19, resource.getWaitSfcCount());
      ps.setInt(20, resource.getWaitWaferCount());
      ps.setString(21, resource.getMcsStateName());
      ps.setString(22, resource.getEapStateName());
      ps.setString(23, resource.isRmsSupport() ? "Y" : "N");
      ps.setString(24, resource.getResourceBo());
      DateUtils.setDateTz(ps, 25, lastUpdatedTime);

      return ps.executeUpdate();
    }
  }

  public int changeState(String resourceBo, String stateName, String downStateName)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_resource SET state_name=?,down_state_name=?,updated_time=? WHERE resource_bo=?")) {
      ps.setString(1, stateName);
      ps.setString(2, downStateName);
      DateUtils.setDateTz(ps, 3, new Date());
      ps.setString(4, resourceBo);
      return ps.executeUpdate();
    }
  }

  public int updateTrackInCount(String resourceBo, int trackInCount) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_resource SET tarck_in_count=?,updated_time=? WHERE resource_bo=?")) {
      ps.setInt(1, trackInCount);
      DateUtils.setDateTz(ps, 2, new Date());
      ps.setString(3, resourceBo);
      return ps.executeUpdate();
    }
  }

  public int updateResStateFromMcs(String resourceBo, String stateName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_resource SET state_name=?,updated_time=?,updated_user=?  WHERE resource_bo=?")) {
      ps.setString(1, stateName);
      DateUtils.setDateTz(ps, 2, new Date());
      ps.setString(3, "MCS");
      ps.setString(4, resourceBo);
      return ps.executeUpdate();
    }
  }

  public int updateMcsStateFromMcs(String resourceBo, String stateName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_resource SET mcs_state_name=?,updated_time=?,updated_user=?  WHERE resource_bo=?")) {
      ps.setString(1, stateName);
      DateUtils.setDateTz(ps, 2, new Date());
      ps.setString(3, "MCS");
      ps.setString(4, resourceBo);
      return ps.executeUpdate();
    }
  }

  public int updateMcsStateAssignUser(String resourceBo, String stateName, String user)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_resource SET mcs_state_name=?,updated_time=?,updated_user=?  WHERE resource_bo=?")) {
      ps.setString(1, stateName);
      DateUtils.setDateTz(ps, 2, new Date());
      ps.setString(3, user);
      ps.setString(4, resourceBo);
      return ps.executeUpdate();
    }
  }

  public int updateForceDeliverState(String resourceBo, String stateName, String user)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_resource SET force_deliver_state=?,updated_time=?,updated_user=?  WHERE resource_bo=?")) {
      ps.setString(1, stateName);
      DateUtils.setDateTz(ps, 2, new Date());
      ps.setString(3, user);
      ps.setString(4, resourceBo);
      return ps.executeUpdate();
    }
  }

  private ViewResourceEx convert(ResultSet rs) throws SQLException {
    int index = 1;
    ViewResourceEx data = new ViewResourceEx();
    data.setResourceBo(rs.getString(index++));
    data.setMoveInCount(rs.getInt(index++));
    data.setMoveInMax(rs.getInt(index++));
    data.setTrackInCount(rs.getInt(index++));
    data.setTrackInMax(rs.getInt(index++));
    data.setStateName(rs.getString(index++));
    data.setCapability(rs.getString(index++));
    data.setEapSupport("Y".equals(rs.getString(index++)));
    data.setRunType(rs.getString(index++));
    data.setPriorityCheck(rs.getString(index++));
    data.setVirtual(rs.getString(index++));
    data.setToolingBinding(rs.getString(index++));
    data.setMoveInType(rs.getString(index++));
    data.setMoveOutType(rs.getString(index++));
    data.setTrackInType(rs.getString(index++));
    data.setTrackOutType(rs.getString(index++));
    data.setDownStateName(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    data.setSite(rs.getString(index++));
    data.setResourceName(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setValidFrom(DateUtils.getDateTz(rs, index++));
    data.setValidTo(DateUtils.getDateTz(rs, index++));
    data.setPendingStatusBo(rs.getString(index++));
    data.setPendingComments(rs.getString(index++));
    data.setPendingReasonCodeBo(rs.getString(index++));
    data.setWaitSfcCount(rs.getInt(index++));
    data.setWaitWaferCount(rs.getInt(index++));
    data.setMcsStateName(rs.getString(index++));
    data.setEapStateName(rs.getString(index++));
    data.setRmsSupport("Y".equals(rs.getString(index++)));
    data.setFunctionDesc(rs.getString(index++));
    data.setTypeDesc(rs.getString(index++));
    data.setCombineResource(rs.getString(index++));
    data.setControlStatus(rs.getString(index++));
    data.setOhtFlag(rs.getString(index++));
    data.setRmsFlag(rs.getString(index++));
    data.setHeartBeat(DateUtils.getDateTz(rs, index++));
    data.setForceDeliverState(rs.getString(index++));

    return data;
  }

}
