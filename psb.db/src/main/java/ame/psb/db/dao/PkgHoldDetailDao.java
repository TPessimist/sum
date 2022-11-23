package ame.psb.db.dao;

import ame.psb.db.PkgHoldDetail;
import ame.psb.db.ViewPkgHold;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class PkgHoldDetailDao {

  private static final String SQL_INS = "INSERT INTO zr_pkg_hold_detail(handle,hold_log_bo,hold_context_g_bo,sfc_bo,original_status,hold_status,released,released_date_time,released_by_bo,release_comments,reason_code_bo) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_pkg_hold_detail SET hold_log_bo=?,hold_context_g_bo=?,sfc_bo=?,original_status=?,hold_status=?,released=?,released_date_time=?,released_by_bo=?,release_comments=?,reason_code_bo=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,hold_log_bo,hold_context_g_bo,sfc_bo,original_status,hold_status,released,released_date_time,released_by_bo,release_comments,reason_code_bo FROM zr_pkg_hold_detail ";

  private static final String VIEW_SQL_SEL = "SELECT handle,hold_log_bo,hold_context_g_bo,sfc_bo,original_status,hold_status,released,released_date_time,released_by_bo,release_comments,reason_code_bo,hold_id,user_bo,comments,date_time FROM view_pkg_hold";

  private final Connection conn;

  public PkgHoldDetailDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgHoldDetail data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getHoldLogBo());
      ps.setString(3, data.getHoldContextGBo());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getOriginalStatus());
      ps.setString(6, data.getHoldStatus());
      ps.setString(7, data.getReleased());
      ps.setString(8, data.getReleasedDateTime());
      ps.setString(9, data.getReleasedByBo());
      ps.setString(10, data.getReleaseComments());
      ps.setString(11, data.getReasonCodeBo());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PkgHoldDetail> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PkgHoldDetail data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getHoldLogBo());
        ps.setString(3, data.getHoldContextGBo());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getOriginalStatus());
        ps.setString(6, data.getHoldStatus());
        ps.setString(7, data.getReleased());
        ps.setString(8, data.getReleasedDateTime());
        ps.setString(9, data.getReleasedByBo());
        ps.setString(10, data.getReleaseComments());
        ps.setString(11, data.getReasonCodeBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PkgHoldDetail data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getHoldLogBo());
      ps.setString(2, data.getHoldContextGBo());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getOriginalStatus());
      ps.setString(5, data.getHoldStatus());
      ps.setString(6, data.getReleased());
      ps.setString(7, data.getReleasedDateTime());
      ps.setString(8, data.getReleasedByBo());
      ps.setString(9, data.getReleaseComments());
      ps.setString(10, data.getReasonCodeBo());
      ps.setString(11, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<PkgHoldDetail> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PkgHoldDetail data : dataList) {
        ps.setString(1, data.getHoldLogBo());
        ps.setString(2, data.getHoldContextGBo());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getOriginalStatus());
        ps.setString(5, data.getHoldStatus());
        ps.setString(6, data.getReleased());
        ps.setString(7, data.getReleasedDateTime());
        ps.setString(8, data.getReleasedByBo());
        ps.setString(9, data.getReleaseComments());
        ps.setString(10, data.getReasonCodeBo());
        ps.setString(11, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_hold_detail WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public int releaseHoldDetailByHandleList(List<String> handleList, String userBo, String comments,
      Date releasedDateTime) throws SQLException {
    String inParam = "";
    for (String handle : handleList) {
      if (!"".equals(inParam)) {
        inParam += ",";
      }
      inParam += "?";
    }
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_pkg_hold_detail SET released='Y',release_comments=?,released_by_bo=?,released_date_time=? WHERE handle IN ("
            + inParam + ")")) {
      ps.setString(1, comments);
      ps.setString(2, userBo);
      DateUtils.setDateTz(ps, 3, releasedDateTime);
      int index = 4;
      for (String handle : handleList) {
        ps.setString(index++, handle);
      }
      return ps.executeUpdate();
    }
  }

  public List<PkgHoldDetail> selectAll() throws SQLException {
    ArrayList<PkgHoldDetail> result = new ArrayList<PkgHoldDetail>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgHoldDetail> selectNotReleasedByHoldContext(String holdContextGbo)
      throws SQLException {
    ArrayList<PkgHoldDetail> result = new ArrayList<PkgHoldDetail>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE released='N' AND HOLD_CONTEXT_G_BO=?")) {
      ps.setString(1, holdContextGbo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public PkgHoldDetail selectSingleNotReleasedByHoldContext(String holdContextGbo)
      throws SQLException {
    PkgHoldDetail result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT TOP 1 * FROM zr_pkg_hold_detail WHERE released='N' AND HOLD_CONTEXT_G_BO=?")) {
      ps.setString(1, holdContextGbo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewPkgHold> select(Where where) throws SQLException {
    ArrayList<ViewPkgHold> result = new ArrayList<ViewPkgHold>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, VIEW_SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
    }
    return result;
  }


  public PkgHoldDetail selectByPK(String handle) throws SQLException {
    PkgHoldDetail result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgHoldDetail convert(ResultSet rs) throws SQLException {
    PkgHoldDetail data = new PkgHoldDetail();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setHoldLogBo(rs.getString(index++));
    data.setHoldContextGBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setOriginalStatus(rs.getString(index++));
    data.setHoldStatus(rs.getString(index++));
    data.setReleased(rs.getString(index++));
    data.setReleasedDateTime(rs.getString(index++));
    data.setReleasedByBo(rs.getString(index++));
    data.setReleaseComments(rs.getString(index++));
    data.setReasonCodeBo(rs.getString(index++));

    return data;
  }

  private ViewPkgHold convertView(ResultSet rs) throws SQLException {
    ViewPkgHold data = new ViewPkgHold();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setHoldLogBo(rs.getString(index++));
    data.setHoldContextGBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setOriginalStatus(rs.getString(index++));
    data.setHoldStatus(rs.getString(index++));
    data.setReleased(rs.getString(index++));
    data.setReleasedDateTime(rs.getString(index++));
    data.setReleasedByBo(rs.getString(index++));
    data.setReleaseComments(rs.getString(index++));
    data.setReasonCodeBo(rs.getString(index++));
    data.setHoldId(rs.getString(index++));
    data.setUserBo(rs.getString(index++));
    data.setComments(rs.getString(index++));
    data.setDateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
