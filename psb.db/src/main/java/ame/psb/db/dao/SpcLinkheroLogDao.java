package ame.psb.db.dao;

import ame.psb.db.SpcLinkheroLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SpcLinkheroLogDao {

  private static final String SQL_INS = "INSERT INTO zr_spc_linkhero_log(id,resultsize,memo,watch_time,watch_user) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_spc_linkhero_log SET resultsize=?,memo=?,watch_time=?,watch_user=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resultsize,memo,watch_time,watch_user FROM zr_spc_linkhero_log ";

  private final Connection conn;

  public SpcLinkheroLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SpcLinkheroLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResultsize());
      ps.setString(3, data.getMemo());
      ps.setTimestamp(4, new Timestamp(data.getWatchTime().getTime()));
      ps.setString(5, data.getWatchUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SpcLinkheroLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SpcLinkheroLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResultsize());
        ps.setString(3, data.getMemo());
        ps.setTimestamp(4, new Timestamp(data.getWatchTime().getTime()));
        ps.setString(5, data.getWatchUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SpcLinkheroLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResultsize());
      ps.setString(2, data.getMemo());
      ps.setTimestamp(3, new Timestamp(data.getWatchTime().getTime()));
      ps.setString(4, data.getWatchUser());
      ps.setString(5, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<SpcLinkheroLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SpcLinkheroLog data : dataList) {
        ps.setString(1, data.getResultsize());
        ps.setString(2, data.getMemo());
        ps.setTimestamp(3, new Timestamp(data.getWatchTime().getTime()));
        ps.setString(4, data.getWatchUser());
        ps.setString(5, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_spc_linkhero_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<SpcLinkheroLog> selectAll() throws SQLException {
    ArrayList<SpcLinkheroLog> result = new ArrayList<SpcLinkheroLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
      ps.setMaxRows(ame.psb.db.conf.Hana.getMaxRow());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SpcLinkheroLog selectByPK(String id) throws SQLException {
    SpcLinkheroLog result = null;
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

  private SpcLinkheroLog convert(ResultSet rs) throws SQLException {
    SpcLinkheroLog data = new SpcLinkheroLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResultsize(rs.getString(index++));
    data.setMemo(rs.getString(index++));
    data.setWatchTime(rs.getTimestamp(index++));
    data.setWatchUser(rs.getString(index++));

    return data;
  }
}
