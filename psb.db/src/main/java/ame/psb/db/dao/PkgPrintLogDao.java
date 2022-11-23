package ame.psb.db.dao;

import ame.psb.db.PkgPrintLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgPrintLogDao {

  private static final String SQL_SEL = "SELECT container_bo,print_user,print_user_group,print_time FROM zr_pkg_print_log ";
  private static final String SQL_INS = "INSERT INTO zr_pkg_print_log(container_bo,print_user,print_user_group,print_time) VALUES (?,?,?,?)";


  private final Connection conn;

  public PkgPrintLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgPrintLog log) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, log.getContainerBo());
      ps.setString(2, log.getPrintUser());
      ps.setString(3, log.getPrintUserGroup());
      DateUtils.setDateTz(ps, 4, log.getPrintTime());
      return ps.executeUpdate();
    }
  }

  public List<PkgPrintLog> selectAll() throws SQLException {
    ArrayList<PkgPrintLog> result = new ArrayList<PkgPrintLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgPrintLog> selectByContainer(String containerBo, String group) throws SQLException {
    ArrayList<PkgPrintLog> result = new ArrayList<PkgPrintLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE container_bo=? AND print_user_group =?")) {
      ps.setString(1, containerBo);
      ps.setString(2, group);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private PkgPrintLog convert(ResultSet rs) throws SQLException {
    PkgPrintLog data = new PkgPrintLog();

    int index = 1;
    data.setContainerBo(rs.getString(index++));
    data.setPrintUser(rs.getString(index++));
    data.setPrintUserGroup(rs.getString(index++));
    data.setPrintTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
