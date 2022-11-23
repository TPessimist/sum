package ame.psb.db.dao;

import ame.psb.db.SwearClockOnRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SwearClockOnRecordDao {

  private static final String SQL_INS = "INSERT INTO zr_swear_clock_on_record(uuid,card_number,job_number,clock_time,code,message,ip) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_swear_clock_on_record SET card_number=?,job_number=?,clock_time=?,code=?,message=?,ip=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,card_number,job_number,clock_time,code,message,ip FROM zr_swear_clock_on_record ";

  private final Connection conn;

  public SwearClockOnRecordDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SwearClockOnRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getCardNumber());
      ps.setString(3, data.getJobNumber());
      DateUtils.setDateTz(ps, 4, data.getClockTime());
      ps.setString(5, data.getCode());
      ps.setString(6, data.getMessage());
      ps.setString(7, data.getIp());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SwearClockOnRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SwearClockOnRecord data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getCardNumber());
        ps.setString(3, data.getJobNumber());
        DateUtils.setDateTz(ps, 4, data.getClockTime());
        ps.setString(5, data.getCode());
        ps.setString(6, data.getMessage());
        ps.setString(7, data.getIp());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SwearClockOnRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCardNumber());
      ps.setString(2, data.getJobNumber());
      DateUtils.setDateTz(ps, 3, data.getClockTime());
      ps.setString(4, data.getCode());
      ps.setString(5, data.getMessage());
      ps.setString(6, data.getIp());
      ps.setString(7, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<SwearClockOnRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SwearClockOnRecord data : dataList) {
        ps.setString(1, data.getCardNumber());
        ps.setString(2, data.getJobNumber());
        DateUtils.setDateTz(ps, 3, data.getClockTime());
        ps.setString(4, data.getCode());
        ps.setString(5, data.getMessage());
        ps.setString(6, data.getIp());
        ps.setString(7, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_swear_clock_on_record WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<SwearClockOnRecord> selectAll() throws SQLException {
    ArrayList<SwearClockOnRecord> result = new ArrayList<SwearClockOnRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SwearClockOnRecord selectByPK(String uuid) throws SQLException {
    SwearClockOnRecord result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SwearClockOnRecord convert(ResultSet rs) throws SQLException {
    SwearClockOnRecord data = new SwearClockOnRecord();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setCardNumber(rs.getString(index++));
    data.setJobNumber(rs.getString(index++));
    data.setClockTime(DateUtils.getDateTz(rs, index++));
    data.setCode(rs.getString(index++));
    data.setMessage(rs.getString(index++));
    data.setIp(rs.getString(index++));

    return data;
  }
}
