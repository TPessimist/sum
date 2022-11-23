package ame.psb.db.dao;

import ame.psb.db.SpcAlarmDataMaster;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpcAlarmDataMasterDao {

  private static final String SQL_INS = "INSERT INTO zr_spc_alarm_data_master(id,sfc,process_flag,request_id,function) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_spc_alarm_data_master SET sfc=?,process_flag=?,request_id=?,function=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sfc,process_flag,request_id,function FROM zr_spc_alarm_data_master ";

  private final Connection conn;

  public SpcAlarmDataMasterDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SpcAlarmDataMaster data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfc());
      ps.setString(3, data.getProcessFlag());
      ps.setString(4, data.getRequestId());
      ps.setString(5, data.getFunction());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SpcAlarmDataMaster> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SpcAlarmDataMaster data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfc());
        ps.setString(3, data.getProcessFlag());
        ps.setString(4, data.getRequestId());
        ps.setString(5, data.getFunction());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SpcAlarmDataMaster data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfc());
      ps.setString(2, data.getProcessFlag());
      ps.setString(3, data.getRequestId());
      ps.setString(4, data.getFunction());
      ps.setString(5, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<SpcAlarmDataMaster> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SpcAlarmDataMaster data : dataList) {
        ps.setString(1, data.getSfc());
        ps.setString(2, data.getProcessFlag());
        ps.setString(3, data.getRequestId());
        ps.setString(4, data.getFunction());
        ps.setString(5, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_spc_alarm_data_master WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<SpcAlarmDataMaster> selectAll() throws SQLException {
    ArrayList<SpcAlarmDataMaster> result = new ArrayList<SpcAlarmDataMaster>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SpcAlarmDataMaster> selectNoProcessBysfc(String sfcName) throws SQLException {
    ArrayList<SpcAlarmDataMaster> result = new ArrayList<SpcAlarmDataMaster>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE ( process_flag <> 'Y' or process_flag is null  ) and sfc =?")) {
      ps.setString(1, sfcName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SpcAlarmDataMaster> selectFlagNullBysfc(String sfcName) throws SQLException {
    ArrayList<SpcAlarmDataMaster> result = new ArrayList<SpcAlarmDataMaster>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE  process_flag is null  and sfc =?")) {
      ps.setString(1, sfcName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public SpcAlarmDataMaster selectByPK(String id) throws SQLException {
    SpcAlarmDataMaster result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SpcAlarmDataMaster convert(ResultSet rs) throws SQLException {
    SpcAlarmDataMaster data = new SpcAlarmDataMaster();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setProcessFlag(rs.getString(index++));
    data.setRequestId(rs.getString(index++));
    data.setFunction(rs.getString(index++));

    return data;
  }
}

