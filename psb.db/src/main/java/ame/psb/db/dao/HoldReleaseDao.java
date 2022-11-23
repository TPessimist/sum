package ame.psb.db.dao;

import ame.psb.db.HoldRelease;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class HoldReleaseDao {

  private static final String SQL_INS = "INSERT INTO zr_hold_release(id,plan_name,plan_time,state_name,oa,release_type,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_hold_release SET plan_name=?,plan_time=?,state_name=?,oa=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,plan_name,plan_time,state_name,oa,oa_form_no,updated_user,updated_time FROM zr_hold_release ";

  private static final String SQL_SEL_REL_STA = "SELECT HRSI.HOLD_RELEASE_BO, HR.STATE_NAME FROM ZR_HOLD_RELEASE_SFC_ITEM HRSI INNER JOIN ZR_HOLD_RELEASE HR ON HRSI.HOLD_RELEASE_BO = HR.ID WHERE HRSI.SFC_BO = ? AND HR.STATE_NAME = ? GROUP BY HRSI.HOLD_RELEASE_BO, HR.STATE_NAME ";

  private final Connection conn;

  public HoldReleaseDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(HoldRelease data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getPlanName());
      DateUtils.setDateTz(ps, 3, data.getPlanTime());
      ps.setString(4, data.getStateName());
      ps.setString(5, data.getOa());
      ps.setString(6, data.getReleaseType());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int update(HoldRelease data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getPlanName());
      DateUtils.setDateTz(ps, 2, data.getPlanTime());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getOa());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getId());

      return ps.executeUpdate();
    }
  }

  public int updateStatus(String holdReleaseBo, String stateName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_hold_release SET state_name=? WHERE id=?")) {
      ps.setString(1, stateName);
      ps.setString(2, holdReleaseBo);

      return ps.executeUpdate();
    }
  }

  public List<HoldRelease> selectAll() throws SQLException {
    ArrayList<HoldRelease> result = new ArrayList<HoldRelease>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_REL_STA)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public HoldRelease selectHoldReleaseBySfc(String sfcBo, String stateName) throws SQLException {
    HoldRelease result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_REL_STA)) {
      ps.setString(1, sfcBo);
      ps.setString(2, stateName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert1(rs);
      }
      return result;
    }
  }

  public HoldRelease selectRunningHoldReleaseBySfc(String sfcBo) throws SQLException {
    HoldRelease result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT HRSI.HOLD_RELEASE_BO, HR.STATE_NAME FROM ZR_HOLD_RELEASE_SFC_ITEM HRSI INNER JOIN ZR_HOLD_RELEASE HR ON HRSI.HOLD_RELEASE_BO = HR.ID WHERE HRSI.SFC_BO = ? AND HR.STATE_NAME IN('SIGNING','SIGNED','EDIT') GROUP BY HRSI.HOLD_RELEASE_BO, HR.STATE_NAME ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert1(rs);
      }
      return result;
    }
  }

  public HoldRelease selectByPK(String id) throws SQLException {
    HoldRelease result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_hold_release WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  private HoldRelease convert(ResultSet rs) throws SQLException {
    HoldRelease data = new HoldRelease();

    data.setId(rs.getString(1));
    data.setPlanName(rs.getString(2));
    data.setPlanTime(DateUtils.getDateTz(rs, 3));
    data.setStateName(rs.getString(4));
    data.setOa(rs.getString(5));
    data.setOaFormNo(rs.getString(6));
    data.setUpdatedUser(rs.getString(7));
    data.setUpdatedTime(DateUtils.getDateTz(rs, 8));

    return data;
  }

  private HoldRelease convert1(ResultSet rs) throws SQLException {
    HoldRelease data = new HoldRelease();

    data.setId(rs.getString(1));
    data.setStateName(rs.getString(2));

    return data;
  }
}
