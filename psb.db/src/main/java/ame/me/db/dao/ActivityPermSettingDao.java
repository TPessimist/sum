package ame.me.db.dao;

import ame.me.db.ActivityPermSetting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActivityPermSettingDao {

  private static final String SQL_SEL = "SELECT user_or_group_gbo,activity_or_group_gbo,permission,permission_setting FROM view_activity_perm ";

  private final Connection conn;

  public ActivityPermSettingDao(Connection conn) {
    this.conn = conn;
  }

  public List<ActivityPermSetting> selectAll() throws SQLException {
    ArrayList<ActivityPermSetting> result = new ArrayList<ActivityPermSetting>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ActivityPermSetting> selectByActivity(String activityOrGroupGbo) throws SQLException {
    ArrayList<ActivityPermSetting> result = new ArrayList<ActivityPermSetting>();
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

  private ActivityPermSetting convert(ResultSet rs) throws SQLException {
    ActivityPermSetting data = new ActivityPermSetting();

    int index = 1;
    data.setUserOrGroupGbo(rs.getString(index++));
    data.setActivityOrGroupGbo(rs.getString(index++));
    data.setPermission(rs.getString(index++));
    data.setPermissionSetting(rs.getString(index++));

    return data;
  }
}