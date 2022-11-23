package ame.psb.db.dao;

import ame.psb.db.ReworkLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReworkLogDao {

  private static final String SQL_INS = "INSERT INTO zr_rework_log(rework_item,rework_depend,rework_rule_content,updated_user,updated_time) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_rework_log SET rework_depend=?,rework_rule_content=?,updated_user=?,updated_time=? WHERE rework_item=?";

  private static final String SQL_SEL = "SELECT rework_item,rework_depend,rework_rule_content,updated_user,updated_time FROM zr_rework_log ";

  private final Connection conn;

  public ReworkLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ReworkLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getReworkItem());
      ps.setString(2, data.getReworkDepend());
      ps.setString(3, data.getReworkRuleContent());
      ps.setString(4, data.getUpdatedUser());
      ps.setTimestamp(5, new Timestamp(data.getUpdatedTime().getTime()));

      return ps.executeUpdate();
    }
  }

  public int insert(List<ReworkLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ReworkLog data : dataList) {
        ps.setString(1, data.getReworkItem());
        ps.setString(2, data.getReworkDepend());
        ps.setString(3, data.getReworkRuleContent());
        ps.setString(4, data.getUpdatedUser());
        ps.setTimestamp(5, new Timestamp(data.getUpdatedTime().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ReworkLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getReworkDepend());
      ps.setString(2, data.getReworkRuleContent());
      ps.setString(3, data.getUpdatedUser());
      ps.setTimestamp(4, new Timestamp(data.getUpdatedTime().getTime()));
      ps.setString(5, data.getReworkItem());

      return ps.executeUpdate();
    }
  }

  public int update(List<ReworkLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ReworkLog data : dataList) {
        ps.setString(1, data.getReworkDepend());
        ps.setString(2, data.getReworkRuleContent());
        ps.setString(3, data.getUpdatedUser());
        ps.setTimestamp(4, new Timestamp(data.getUpdatedTime().getTime()));
        ps.setString(5, data.getReworkItem());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String reworkItem) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_rework_log WHERE rework_item=?")) {
      ps.setString(1, reworkItem);

      return ps.executeUpdate();
    }
  }

  public List<ReworkLog> selectAll() throws SQLException {
    ArrayList<ReworkLog> result = new ArrayList<ReworkLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ReworkLog selectByPK(String reworkItem) throws SQLException {
    ReworkLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE rework_item=?")) {
      ps.setString(1, reworkItem);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ReworkLog selectLatestByPK(String reworkItem) throws SQLException {
    ReworkLog result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE rework_item=? order by updated_time desc limit 1 ")) {
      ps.setString(1, reworkItem);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ReworkLog convert(ResultSet rs) throws SQLException {
    ReworkLog data = new ReworkLog();

    int index = 1;
    data.setReworkItem(rs.getString(index++));
    data.setReworkDepend(rs.getString(index++));
    data.setReworkRuleContent(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(rs.getTimestamp(index++));

    return data;
  }
}
