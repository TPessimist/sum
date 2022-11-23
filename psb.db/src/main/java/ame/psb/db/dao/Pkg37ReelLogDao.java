package ame.psb.db.dao;

import ame.psb.db.Pkg37ReelLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class Pkg37ReelLogDao {

  private static final String SQL_INS = "INSERT INTO zr_pkg_37_reel_log(handle,action_name,reel_id,sfc_bo,state_name,job_id,reel_seq,die_qty,resource_bo,reversed_field1,reversed_field2,run_user,run_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_pkg_37_reel_log SET action_name=?,reel_id=?,sfc_bo=?,state_name=?,job_id=?,reel_seq=?,die_qty=?,resource_bo=?,reversed_field1=?,reversed_field2=?,run_user=?,run_time=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,action_name,reel_id,sfc_bo,state_name,job_id,reel_seq,die_qty,resource_bo,reversed_field1,reversed_field2,run_user,run_time FROM zr_pkg_37_reel_log ";

  private final Connection conn;

  public Pkg37ReelLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Pkg37ReelLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getActionName());
      ps.setString(3, data.getReelId());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getStateName());
      ps.setString(6, data.getJobId());
      ps.setBigDecimal(7, data.getReelSeq());
      ps.setBigDecimal(8, data.getDieQty());
      ps.setString(9, data.getResourceBo());
      ps.setString(10, data.getReversedField1());
      ps.setString(11, data.getReversedField2());
      ps.setString(12, data.getRunUser());
      DateUtils.setDateTz(ps, 13, data.getRunTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Pkg37ReelLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Pkg37ReelLog data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getActionName());
        ps.setString(3, data.getReelId());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getStateName());
        ps.setString(6, data.getJobId());
        ps.setBigDecimal(7, data.getReelSeq());
        ps.setBigDecimal(8, data.getDieQty());
        ps.setString(9, data.getResourceBo());
        ps.setString(10, data.getReversedField1());
        ps.setString(11, data.getReversedField2());
        ps.setString(12, data.getRunUser());
        DateUtils.setDateTz(ps, 13, data.getRunTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Pkg37ReelLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getActionName());
      ps.setString(2, data.getReelId());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getStateName());
      ps.setString(5, data.getJobId());
      ps.setBigDecimal(6, data.getReelSeq());
      ps.setBigDecimal(7, data.getDieQty());
      ps.setString(8, data.getResourceBo());
      ps.setString(9, data.getReversedField1());
      ps.setString(10, data.getReversedField2());
      ps.setString(11, data.getRunUser());
      DateUtils.setDateTz(ps, 12, data.getRunTime());
      ps.setString(13, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<Pkg37ReelLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Pkg37ReelLog data : dataList) {
        ps.setString(1, data.getActionName());
        ps.setString(2, data.getReelId());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getStateName());
        ps.setString(5, data.getJobId());
        ps.setBigDecimal(6, data.getReelSeq());
        ps.setBigDecimal(7, data.getDieQty());
        ps.setString(8, data.getResourceBo());
        ps.setString(9, data.getReversedField1());
        ps.setString(10, data.getReversedField2());
        ps.setString(11, data.getRunUser());
        DateUtils.setDateTz(ps, 12, data.getRunTime());
        ps.setString(13, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_37_reel_log WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<Pkg37ReelLog> selectAll() throws SQLException {
    ArrayList<Pkg37ReelLog> result = new ArrayList<Pkg37ReelLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Pkg37ReelLog selectByPK(String handle) throws SQLException {
    Pkg37ReelLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public Pkg37ReelLog selectByReelId(String reelId) throws SQLException {
    Pkg37ReelLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE reel_Id=?")) {
      ps.setString(1, reelId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private Pkg37ReelLog convert(ResultSet rs) throws SQLException {
    Pkg37ReelLog data = new Pkg37ReelLog();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setReelId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setJobId(rs.getString(index++));
    data.setReelSeq(rs.getBigDecimal(index++));
    data.setDieQty(rs.getBigDecimal(index++));
    data.setResourceBo(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setRunUser(rs.getString(index++));
    data.setRunTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
