package ame.psb.db.dao;

import ame.psb.db.MoldLocationLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class MoldLocationLogDao {

  private static final String SQL_INS = "INSERT INTO mold_location_log(batch_id,location,table_name,content,log_user,log_time,reserve1,reserve2) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE mold_location_log SET location=?,table_name=?,content=?,log_user=?,log_time=?,reserve1=?,reserve2=? WHERE batch_id=?";

  private static final String SQL_SEL = "SELECT batch_id,location,table_name,content,log_user,log_time,reserve1,reserve2 FROM mold_location_log ";

  private final Connection conn;

  public MoldLocationLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(MoldLocationLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getBatchId());
      ps.setString(2, data.getLocation());
      ps.setString(3, data.getTableName());
      ps.setString(4, data.getContent());
      ps.setString(5, data.getLogUser());
      DateUtils.setDateTz(ps, 6, data.getLogTime());
      ps.setString(7, data.getReserve1());
      ps.setString(8, data.getReserve2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<MoldLocationLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (MoldLocationLog data : dataList) {
        ps.setString(1, data.getBatchId());
        ps.setString(2, data.getLocation());
        ps.setString(3, data.getTableName());
        ps.setString(4, data.getContent());
        ps.setString(5, data.getLogUser());
        DateUtils.setDateTz(ps, 6, data.getLogTime());
        ps.setString(7, data.getReserve1());
        ps.setString(8, data.getReserve2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(MoldLocationLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getLocation());
      ps.setString(2, data.getTableName());
      ps.setString(3, data.getContent());
      ps.setString(4, data.getLogUser());
      DateUtils.setDateTz(ps, 5, data.getLogTime());
      ps.setString(6, data.getReserve1());
      ps.setString(7, data.getReserve2());
      ps.setString(8, data.getBatchId());

      return ps.executeUpdate();
    }
  }

  public int update(List<MoldLocationLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (MoldLocationLog data : dataList) {
        ps.setString(1, data.getLocation());
        ps.setString(2, data.getTableName());
        ps.setString(3, data.getContent());
        ps.setString(4, data.getLogUser());
        DateUtils.setDateTz(ps, 5, data.getLogTime());
        ps.setString(6, data.getReserve1());
        ps.setString(7, data.getReserve2());
        ps.setString(8, data.getBatchId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String batchId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM mold_location_log WHERE batch_id=?")) {
      ps.setString(1, batchId);

      return ps.executeUpdate();
    }
  }

  public List<MoldLocationLog> selectAll() throws SQLException {
    ArrayList<MoldLocationLog> result = new ArrayList<MoldLocationLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public MoldLocationLog selectByPK(String batchId) throws SQLException {
    MoldLocationLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE batch_id=?")) {
      ps.setString(1, batchId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private MoldLocationLog convert(ResultSet rs) throws SQLException {
    MoldLocationLog data = new MoldLocationLog();

    int index = 1;
    data.setBatchId(rs.getString(index++));
    data.setLocation(rs.getString(index++));
    data.setTableName(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setLogUser(rs.getString(index++));
    data.setLogTime(DateUtils.getDateTz(rs, index++));
    data.setReserve1(rs.getString(index++));
    data.setReserve2(rs.getString(index++));

    return data;
  }
}
