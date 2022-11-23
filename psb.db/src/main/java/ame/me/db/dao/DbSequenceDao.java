package ame.me.db.dao;

import ame.me.db.DbSequence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbSequenceDao {

  private static final String SQL_INS = "INSERT INTO db_sequence(handle,site,sequence_name,value) VALUES (?,?,?,?)";

  private static final String SQL_UPD = "UPDATE db_sequence SET site=?,sequence_name=?,value=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,site,sequence_name,value FROM db_sequence ";

  private final Connection conn;

  public DbSequenceDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DbSequence data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getSequenceName());
      ps.setBigDecimal(4, data.getValue());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DbSequence> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DbSequence data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getSite());
        ps.setString(3, data.getSequenceName());
        ps.setBigDecimal(4, data.getValue());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DbSequence data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSite());
      ps.setString(2, data.getSequenceName());
      ps.setBigDecimal(3, data.getValue());
      ps.setString(4, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<DbSequence> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DbSequence data : dataList) {
        ps.setString(1, data.getSite());
        ps.setString(2, data.getSequenceName());
        ps.setBigDecimal(3, data.getValue());
        ps.setString(4, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM db_sequence WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<DbSequence> selectAll() throws SQLException {
    ArrayList<DbSequence> result = new ArrayList<DbSequence>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public DbSequence selectByPK(String handle) throws SQLException {
    DbSequence result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public DbSequence selectForUpdateByPK(String handle) throws SQLException {
    DbSequence result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=? FOR UPDATE")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private DbSequence convert(ResultSet rs) throws SQLException {
    DbSequence data = new DbSequence();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setSequenceName(rs.getString(index++));
    data.setValue(rs.getBigDecimal(index++));

    return data;
  }
}
