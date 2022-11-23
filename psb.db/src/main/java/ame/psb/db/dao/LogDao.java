package ame.psb.db.dao;

import ame.psb.db.ConfigLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import uia.utils.dao.DateUtils;

public class LogDao {

  private final Connection conn;

  public LogDao(Connection conn) {
    this.conn = conn;
  }

  public int log(String batchId, String user, Date time, String table, String... kvList) {
    if (kvList.length % 2 != 0) {
      return -1;
    }

    TreeMap<String, String> data = new TreeMap<String, String>();
    for (int i = 0; i < kvList.length; i += 2) {
      data.put(kvList[i], kvList[i + 1]);
    }

    /**
     PreparedStatement ps = this.conn.prepareStatement("INSERT INTO ?(?,?,?,?) VALUES(?,?,?,?)");
     ps.setString(1, batchId);
     ps.setString(2, user);
     DateUtils.setDateTz(ps, 3, time);
     ps.setString(4, table);
     ps.setString(5, new Gson().toJson(data));
     return ps.executeUpdate();
     */
    return 0;
  }

  public int log(ConfigLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "INSERT INTO zd_config_log(batch_id,log_user,log_time,table_name,content) VALUES(?,?,?,?,?)")) {
      ps.setString(1, data.getBatchId());
      ps.setString(2, data.getLogUser());
      DateUtils.setDateTz(ps, 3, data.getLogDateTime());
      ps.setString(4, data.getTableName());
      ps.setString(5, data.getContent());

      return ps.executeUpdate();
    }
  }

  public int update(String tableName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE  ZD_CONFIG_LOG SET LOG_USER = 'DONE' WHERE TABLE_NAME = ?")) {
      ps.setString(1, tableName);
      return ps.executeUpdate();
    }
  }

  public int log(List<ConfigLog> data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "INSERT INTO zd_config_log(batch_id,log_user,log_time,table_name,content) VALUES(?,?,?,?,?)")) {
      for (ConfigLog log : data) {
        ps.setString(1, log.getBatchId());
        ps.setString(2, log.getLogUser());
        DateUtils.setDateTz(ps, 3, log.getLogDateTime());
        ps.setString(4, log.getTableName());
        ps.setString(5, log.getContent());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public List<String> selectInStockFail() throws SQLException {
    List<String> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT * FROM ZD_CONFIG_LOG WHERE BATCH_ID = 'ZD_INSTOCK_CONTAINER' AND LOG_USER = 'ERROR' ")) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(rs.getString(2));
      }
    }
    return result;
  }
}
