package ame.psb.db.dao;

import ame.psb.db.Mail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MailDao {

  private static final String SQL_SEL = "SELECT handle,modules,time_flag,number_flag FROM zr_mail ";

  private static final String SQL_UPD = "UPDATE zr_mail SET time_flag=?,number_flag=? WHERE handle=? ";

  private final Connection conn;

  public MailDao(Connection conn) {
    this.conn = conn;
  }

  public List<Mail> selectAll() throws SQLException {
    ArrayList<Mail> result = new ArrayList<Mail>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public Mail selectByPK(String handle) throws SQLException {
    Mail result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public int update(Mail data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getTimeFlag());
      ps.setString(2, data.getNumberFlag());
      ps.setString(3, data.getHandle());

      return ps.executeUpdate();
    }
  }

  private Mail convert(ResultSet rs) throws SQLException {
    Mail data = new Mail();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setModules(rs.getString(index++));
    data.setTimeFlag(rs.getString(index++));
    data.setNumberFlag(rs.getString(index++));

    return data;
  }
}