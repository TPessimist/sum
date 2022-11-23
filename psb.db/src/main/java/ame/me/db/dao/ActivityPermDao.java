package ame.me.db.dao;

import ame.me.db.ActivityPerm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActivityPermDao {

  private static final String SQL_SEL = "SELECT handle,change_stamp,user_or_group_gbo,activity_or_group_gbo,created_date_time,modified_date_time FROM activity_perm ";

  private final Connection conn;

  public ActivityPermDao(Connection conn) {
    this.conn = conn;
  }

  public List<ActivityPerm> selectAll() throws SQLException {
    ArrayList<ActivityPerm> result = new ArrayList<ActivityPerm>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ActivityPerm selectByPK(String handle) throws SQLException {
    ActivityPerm result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ActivityPerm> selectByActivity(String activityOrGroupGbo) throws SQLException {
    ArrayList<ActivityPerm> result = new ArrayList<ActivityPerm>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE activity_or_group_gbo=?")) {

      ps.setString(1, activityOrGroupGbo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ActivityPerm convert(ResultSet rs) throws SQLException {
    ActivityPerm data = new ActivityPerm();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setChangeStamp(rs.getBigDecimal(index++));
    data.setUserOrGroupGbo(rs.getString(index++));
    data.setActivityOrGroupGbo(rs.getString(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));
    data.setModifiedDateTime(rs.getTimestamp(index++));

    return data;
  }
}