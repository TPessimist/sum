package ame.psb.db.dao;

import ame.psb.db.CpDataUploadLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CpDataUploadLogDao {

  private static final String SQL_INS = "INSERT INTO cp_data_upload_log(customer,file_name,updated_user,updated_time,mail_remind_flag) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE cp_data_upload_log SET file_name=?,updated_user=?,updated_time=?,mail_remind_flag=? WHERE customer=?";

  private static final String SQL_SEL = "SELECT customer,file_name,updated_user,updated_time,mail_remind_flag FROM cp_data_upload_log ";

  private final Connection conn;

  public CpDataUploadLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CpDataUploadLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomer());
      ps.setString(2, data.getFileName());
      ps.setString(3, data.getUpdatedUser());
      ps.setTimestamp(4, new Timestamp(data.getUpdatedTime().getTime()));
      ps.setBoolean(5, data.isMailRemindFlag());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CpDataUploadLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CpDataUploadLog data : dataList) {
        ps.setString(1, data.getCustomer());
        ps.setString(2, data.getFileName());
        ps.setString(3, data.getUpdatedUser());
        ps.setTimestamp(4, new Timestamp(data.getUpdatedTime().getTime()));
        ps.setBoolean(5, data.isMailRemindFlag());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customer, String fileName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM cp_data_upload_log WHERE customer=? AND file_name=?")) {
      ps.setString(1, customer);
      ps.setString(2, fileName);

      return ps.executeUpdate();
    }
  }

  public List<CpDataUploadLog> selectAll() throws SQLException {
    ArrayList<CpDataUploadLog> result = new ArrayList<CpDataUploadLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<CpDataUploadLog> selectByAH017NoMail() throws SQLException {
    ArrayList<CpDataUploadLog> result = new ArrayList<CpDataUploadLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "  WHERE customer = 'AH017' AND FILE_NAME LIKE '%/CP%' AND MAIL_REMIND_FLAG = FALSE")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public CpDataUploadLog selectByPK(String customer, String fileName) throws SQLException {
    CpDataUploadLog result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer=? AND file_name=?")) {
      ps.setString(1, customer);
      ps.setString(2, fileName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public CpDataUploadLog selectByFirstTime(String customer, String fileName) throws SQLException {
    CpDataUploadLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE customer=? AND file_name=? ORDER BY UPDATED_TIME ASC LIMIT 1")) {
      ps.setString(1, customer);
      ps.setString(2, fileName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<CpDataUploadLog> selectByFileName(String customer, String fileName)
      throws SQLException {
    ArrayList<CpDataUploadLog> result = new ArrayList<CpDataUploadLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer=? AND file_name=?")) {
      ps.setString(1, customer);
      ps.setString(2, fileName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private CpDataUploadLog convert(ResultSet rs) throws SQLException {
    CpDataUploadLog data = new CpDataUploadLog();

    int index = 1;
    data.setCustomer(rs.getString(index++));
    data.setFileName(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(rs.getTimestamp(index++));
    data.setMailRemindFlag(rs.getBoolean(index++));

    return data;
  }
}
