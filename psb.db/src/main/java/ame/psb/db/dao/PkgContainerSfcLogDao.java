package ame.psb.db.dao;

import ame.psb.db.PkgContainerSfcLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgContainerSfcLogDao {

  private static final String SQL_INS = "INSERT INTO zr_pkg_container_sfc_log(id,container_bo,sfc_bo,good_bad,grades,die_qty,customer_item_name,good_die,bad_die1,bad_die2,run_time,run_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_SEL = "SELECT id,container_bo,sfc_bo,good_bad,grades,die_qty,customer_item_name,good_die,bad_die1,bad_die2,run_time,run_user FROM zr_pkg_container_sfc_log ";

  private final Connection conn;

  public PkgContainerSfcLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgContainerSfcLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getContainerBo());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getGoodBad());
      ps.setString(5, data.getGrades());
      ps.setInt(6, data.getDieQty());
      ps.setString(7, data.getCustomerItemName());
      ps.setInt(8, data.getGoodDie());
      ps.setInt(9, data.getBadDie1());
      ps.setInt(10, data.getBadDie2());
      DateUtils.setDateTz(ps, 11, data.getRunTime());
      ps.setString(12, data.getRunUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PkgContainerSfcLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PkgContainerSfcLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getContainerBo());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getGoodBad());
        ps.setString(5, data.getGrades());
        ps.setInt(6, data.getDieQty());
        ps.setString(7, data.getCustomerItemName());
        ps.setInt(8, data.getGoodDie());
        ps.setInt(9, data.getBadDie1());
        ps.setInt(10, data.getBadDie2());
        DateUtils.setDateTz(ps, 11, data.getRunTime());
        ps.setString(12, data.getRunUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_container_sfc_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<PkgContainerSfcLog> selectAll() throws SQLException {
    ArrayList<PkgContainerSfcLog> result = new ArrayList<PkgContainerSfcLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PkgContainerSfcLog selectByPK(String id) throws SQLException {
    PkgContainerSfcLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgContainerSfcLog convert(ResultSet rs) throws SQLException {
    PkgContainerSfcLog data = new PkgContainerSfcLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setContainerBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setGoodBad(rs.getString(index++));
    data.setGrades(rs.getString(index++));
    data.setDieQty(rs.getInt(index++));
    data.setCustomerItemName(rs.getString(index++));
    data.setGoodDie(rs.getInt(index++));
    data.setBadDie1(rs.getInt(index++));
    data.setBadDie2(rs.getInt(index++));
    data.setRunTime(DateUtils.getDateTz(rs, index++));
    data.setRunUser(rs.getString(index++));

    return data;
  }
}