package ame.psb.db.dao;

import ame.psb.db.SpcAlarm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SpcAlarmDao {

  private static final String SQL_INS = "INSERT INTO zr_spc_alarm(id,sfc_bo,created_date_time) VALUES (?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_spc_alarm SET sfc_bo=?,created_date_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sfc_bo,created_date_time FROM zr_spc_alarm ";

  private final Connection conn;

  public SpcAlarmDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SpcAlarm data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcBo());
      ps.setTimestamp(3, new Timestamp(data.getCreatedDateTime().getTime()));

      return ps.executeUpdate();
    }
  }

  public int insert(List<SpcAlarm> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SpcAlarm data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfcBo());
        ps.setTimestamp(3, new Timestamp(data.getCreatedDateTime().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SpcAlarm data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setTimestamp(2, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setString(3, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<SpcAlarm> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SpcAlarm data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setTimestamp(2, new Timestamp(data.getCreatedDateTime().getTime()));
        ps.setString(3, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_spc_alarm WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<SpcAlarm> selectAll() throws SQLException {
    ArrayList<SpcAlarm> result = new ArrayList<SpcAlarm>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
      ps.setMaxRows(ame.psb.db.conf.Hana.getMaxRow());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SpcAlarm selectByPK(String id) throws SQLException {
    SpcAlarm result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ps.setMaxRows(ame.psb.db.conf.Hana.getMaxRow());
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SpcAlarm convert(ResultSet rs) throws SQLException {
    SpcAlarm data = new SpcAlarm();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));

    return data;
  }
}
