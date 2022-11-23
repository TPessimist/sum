package ame.psb.db.dao;

import ame.psb.db.FailLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FailLogDao {

  private static final String SQL_INS = "INSERT INTO zr_fail_log(id,action,data_log,message_log,content_log,log_user,log_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_fail_log SET action=?,data_log=?,message_log=?,content_log=?,log_user=?,log_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,action,data_log,message_log,content_log,log_user,log_time FROM zr_fail_log ";

  private final Connection conn;

  public FailLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FailLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getAction());
      ps.setString(3, data.getDataLog());
      ps.setString(4, data.getMessageLog());
      ps.setString(5, data.getContentLog());
      ps.setString(6, data.getLogUser());
      DateUtils.setDateTz(ps, 7, data.getLogTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FailLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FailLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getAction());
        ps.setString(3, data.getDataLog());
        ps.setString(4, data.getMessageLog());
        ps.setString(5, data.getContentLog());
        ps.setString(6, data.getLogUser());
        DateUtils.setDateTz(ps, 7, data.getLogTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FailLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getAction());
      ps.setString(2, data.getDataLog());
      ps.setString(3, data.getMessageLog());
      ps.setString(4, data.getContentLog());
      ps.setString(5, data.getLogUser());
      DateUtils.setDateTz(ps, 6, data.getLogTime());
      ps.setString(7, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FailLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FailLog data : dataList) {
        ps.setString(1, data.getAction());
        ps.setString(2, data.getDataLog());
        ps.setString(3, data.getMessageLog());
        ps.setString(4, data.getContentLog());
        ps.setString(5, data.getLogUser());
        DateUtils.setDateTz(ps, 6, data.getLogTime());
        ps.setString(7, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_fail_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<FailLog> selectAll() throws SQLException {
    ArrayList<FailLog> result = new ArrayList<FailLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FailLog selectByPK(String id) throws SQLException {
    FailLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FailLog convert(ResultSet rs) throws SQLException {
    FailLog data = new FailLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setAction(rs.getString(index++));
    data.setDataLog(rs.getString(index++));
    data.setMessageLog(rs.getString(index++));
    data.setContentLog(rs.getString(index++));
    data.setLogUser(rs.getString(index++));
    data.setLogTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
