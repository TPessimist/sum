package ame.psb.db.dao;

import ame.psb.db.ZdIncomingMapConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZdIncomingMapConfigDao {

  private static final String SQL_INS = "INSERT INTO zd_incoming_map_config(device_name,operation,ftp_sub_id,ftp_value,sequence) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_incoming_map_config SET ftp_value=? WHERE device_name=? AND operation=? AND ftp_sub_id=? AND sequence=?";

  private static final String SQL_SEL = "SELECT device_name,operation,ftp_sub_id,ftp_value,sequence FROM zd_incoming_map_config ";

  private final Connection conn;

  public ZdIncomingMapConfigDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdIncomingMapConfig data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getDeviceName());
      ps.setString(2, data.getOperation());
      ps.setString(3, data.getFtpSubId());
      ps.setString(4, data.getFtpValue());
      ps.setInt(5, data.getSequence());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdIncomingMapConfig> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdIncomingMapConfig data : dataList) {
        ps.setString(1, data.getDeviceName());
        ps.setString(2, data.getOperation());
        ps.setString(3, data.getFtpSubId());
        ps.setString(4, data.getFtpValue());
        ps.setInt(5, data.getSequence());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZdIncomingMapConfig data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFtpValue());
      ps.setString(2, data.getDeviceName());
      ps.setString(3, data.getOperation());
      ps.setString(4, data.getFtpSubId());
      ps.setInt(5, data.getSequence());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZdIncomingMapConfig> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZdIncomingMapConfig data : dataList) {
        ps.setString(1, data.getFtpValue());
        ps.setString(2, data.getDeviceName());
        ps.setString(3, data.getOperation());
        ps.setString(4, data.getFtpSubId());
        ps.setInt(5, data.getSequence());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String deviceName, String operation, String ftpSubId, int sequence)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_incoming_map_config WHERE device_name=? AND operation=? AND ftp_sub_id=? AND sequence=?")) {
      ps.setString(1, deviceName);
      ps.setString(2, operation);
      ps.setString(3, ftpSubId);
      ps.setInt(4, sequence);

      return ps.executeUpdate();
    }
  }

  public List<ZdIncomingMapConfig> selectAll() throws SQLException {
    ArrayList<ZdIncomingMapConfig> result = new ArrayList<ZdIncomingMapConfig>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZdIncomingMapConfig selectByPK(String deviceName, String operation, String ftpSubId,
      int sequence)
      throws SQLException {
    ZdIncomingMapConfig result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE device_name=? AND operation=? AND ftp_sub_id=? AND sequence=?")) {
      ps.setString(1, deviceName);
      ps.setString(2, operation);
      ps.setString(3, ftpSubId);
      ps.setInt(4, sequence);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZdIncomingMapConfig> selectByPK(String deviceName, String operation, int sequence)
      throws SQLException {
    ArrayList<ZdIncomingMapConfig> result = new ArrayList<ZdIncomingMapConfig>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE device_name=? AND operation=? AND sequence=?")) {
      ps.setString(1, deviceName);
      ps.setString(2, operation);
      ps.setInt(3, sequence);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ZdIncomingMapConfig convert(ResultSet rs) throws SQLException {
    ZdIncomingMapConfig data = new ZdIncomingMapConfig();

    int index = 1;
    data.setDeviceName(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setFtpSubId(rs.getString(index++));
    data.setFtpValue(rs.getString(index++));
    data.setSequence(rs.getInt(index++));

    return data;
  }
}
