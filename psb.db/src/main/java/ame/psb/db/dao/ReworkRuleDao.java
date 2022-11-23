package ame.psb.db.dao;

import ame.psb.db.ReworkRule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReworkRuleDao {

  private static final String SQL_INS = "INSERT INTO zd_rework_rule(rework_item,rework_depend,comment,reworktype,updated_user,updated_time,state,rework_rule) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_rework_rule SET comment=?,reworktype=?,updated_user=?,updated_time=?,state=?,rework_rule=? WHERE rework_item=? AND rework_depend=?";

  private static final String SQL_SEL = "SELECT rework_item,rework_depend,comment,reworktype,updated_user,updated_time,state,rework_rule FROM zd_rework_rule ";

  private final Connection conn;

  public ReworkRuleDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ReworkRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getReworkItem());
      ps.setString(2, data.getReworkDepend());
      ps.setString(3, data.getComment());
      ps.setString(4, data.getReworktype());
      ps.setString(5, data.getUpdatedUser());
      ps.setTimestamp(6, new Timestamp(data.getUpdatedTime().getTime()));
      ps.setString(7, data.getState());
      ps.setString(8, data.getReworkRule());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ReworkRule> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ReworkRule data : dataList) {
        ps.setString(1, data.getReworkItem());
        ps.setString(2, data.getReworkDepend());
        ps.setString(3, data.getComment());
        ps.setString(4, data.getReworktype());
        ps.setString(5, data.getUpdatedUser());
        ps.setTimestamp(6, new Timestamp(data.getUpdatedTime().getTime()));
        ps.setString(7, data.getState());
        ps.setString(8, data.getReworkRule());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ReworkRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getComment());
      ps.setString(2, data.getReworktype());
      ps.setString(3, data.getUpdatedUser());
      ps.setTimestamp(4, new Timestamp(data.getUpdatedTime().getTime()));
      ps.setString(5, data.getState());
      ps.setString(6, data.getReworkRule());
      ps.setString(7, data.getReworkItem());
      ps.setString(8, data.getReworkDepend());

      return ps.executeUpdate();
    }
  }

  public int update(List<ReworkRule> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ReworkRule data : dataList) {
        ps.setString(1, data.getComment());
        ps.setString(2, data.getReworktype());
        ps.setString(3, data.getUpdatedUser());
        ps.setTimestamp(4, new Timestamp(data.getUpdatedTime().getTime()));
        ps.setString(5, data.getState());
        ps.setString(6, data.getReworkRule());
        ps.setString(7, data.getReworkItem());
        ps.setString(8, data.getReworkDepend());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String reworkItem, String reworkDepend) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_rework_rule WHERE rework_item=? AND rework_depend=?")) {
      ps.setString(1, reworkItem);
      ps.setString(2, reworkDepend);

      return ps.executeUpdate();
    }
  }

  public List<ReworkRule> selectAll() throws SQLException {
    ArrayList<ReworkRule> result = new ArrayList<ReworkRule>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ReworkRule selectByPK(String reworkItem, String reworkDepend) throws SQLException {
    ReworkRule result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE rework_item=? AND rework_depend=?")) {
      ps.setString(1, reworkItem);
      ps.setString(2, reworkDepend);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ReworkRule selectByItemAndType(String reworkItem, String reworkrule) throws SQLException {
    ReworkRule result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE rework_item=? AND rework_rule=?")) {
      ps.setString(1, reworkItem);
      ps.setString(2, reworkrule);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ReworkRule convert(ResultSet rs) throws SQLException {
    ReworkRule data = new ReworkRule();

    int index = 1;
    data.setReworkItem(rs.getString(index++));
    data.setReworkDepend(rs.getString(index++));
    data.setComment(rs.getString(index++));
    data.setReworktype(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(rs.getTimestamp(index++));
    data.setState(rs.getString(index++));
    data.setReworkRule(rs.getString(index++));

    return data;
  }
}
