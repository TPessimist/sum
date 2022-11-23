package ame.psb.db.dao;

import ame.psb.db.PkgHoldLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgHoldLogDao {

  private static final String SQL_INS = "INSERT INTO zr_pkg_hold_log(handle,site,hold_id,user_bo,comments,date_time,expected_release_date_time,created_date_time,modified_date_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_pkg_hold_log SET site=?,hold_id=?,user_bo=?,comments=?,date_time=?,expected_release_date_time=?,created_date_time=?,modified_date_time=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,site,hold_id,user_bo,comments,date_time,expected_release_date_time,created_date_time,modified_date_time FROM zr_pkg_hold_log ";

  private final Connection conn;

  public PkgHoldLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgHoldLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getSite());
      ps.setBigDecimal(3, data.getHoldId());
      ps.setString(4, data.getUserBo());
      ps.setString(5, data.getComments());
      DateUtils.setDateTz(ps, 6, data.getDateTime());
      DateUtils.setDateTz(ps, 7, data.getExpectedReleaseDateTime());
      DateUtils.setDateTz(ps, 8, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 9, data.getModifiedDateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PkgHoldLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PkgHoldLog data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getSite());
        ps.setBigDecimal(3, data.getHoldId());
        ps.setString(4, data.getUserBo());
        ps.setString(5, data.getComments());
        DateUtils.setDateTz(ps, 6, data.getDateTime());
        DateUtils.setDateTz(ps, 7, data.getExpectedReleaseDateTime());
        DateUtils.setDateTz(ps, 8, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 9, data.getModifiedDateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PkgHoldLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSite());
      ps.setBigDecimal(2, data.getHoldId());
      ps.setString(3, data.getUserBo());
      ps.setString(4, data.getComments());
      DateUtils.setDateTz(ps, 5, data.getDateTime());
      DateUtils.setDateTz(ps, 6, data.getExpectedReleaseDateTime());
      DateUtils.setDateTz(ps, 7, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 8, data.getModifiedDateTime());
      ps.setString(9, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<PkgHoldLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PkgHoldLog data : dataList) {
        ps.setString(1, data.getSite());
        ps.setBigDecimal(2, data.getHoldId());
        ps.setString(3, data.getUserBo());
        ps.setString(4, data.getComments());
        DateUtils.setDateTz(ps, 5, data.getDateTime());
        DateUtils.setDateTz(ps, 6, data.getExpectedReleaseDateTime());
        DateUtils.setDateTz(ps, 7, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 8, data.getModifiedDateTime());
        ps.setString(9, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_hold_log WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<PkgHoldLog> selectAll() throws SQLException {
    ArrayList<PkgHoldLog> result = new ArrayList<PkgHoldLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PkgHoldLog selectByPK(String handle) throws SQLException {
    PkgHoldLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgHoldLog convert(ResultSet rs) throws SQLException {
    PkgHoldLog data = new PkgHoldLog();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setHoldId(rs.getBigDecimal(index++));
    data.setUserBo(rs.getString(index++));
    data.setComments(rs.getString(index++));
    data.setDateTime(DateUtils.getDateTz(rs, index++));
    data.setExpectedReleaseDateTime(DateUtils.getDateTz(rs, index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
