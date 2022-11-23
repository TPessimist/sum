package ame.psb.db.dao;

import ame.psb.db.ActivityGroupJoinActivityResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ActivityGroupDao {

  private static final String SELECT_SQL =
      "SELECT A.DESCRIPTION,B.ACTIVITY_GROUP_BO,A.CREATED_DATE_TIME,A.MODIFIED_DATE_TIME,A.HANDLE  FROM ACTIVITY_GROUP A LEFT JOIN ACTIVITY_GROUP_ACTIVITY B ON  A.HANDLE = B.ACTIVITY_OR_GROUP_GBO GROUP BY B.ACTIVITY_GROUP_BO ,A.DESCRIPTION,\n"
          + "A.CREATED_DATE_TIME,A.MODIFIED_DATE_TIME,A.HANDLE";


  private static final String UPDATE_SQL = "UPDATE ACTIVITY_GROUP SET CREATED_DATE_TIME = ?, MODIFIED_DATE_TIME = ?";
  private final Connection conn;

  public ActivityGroupDao(Connection conn) {
    this.conn = conn;
  }

  public List<ActivityGroupJoinActivityResult> getNeedSortItems() throws Exception {
    ArrayList<ActivityGroupJoinActivityResult> result = new ArrayList<ActivityGroupJoinActivityResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SELECT_SQL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertReport(rs));
      }

    }
    return result;
  }

  public void updateActivityGroupTime(String createTime, String modifiedTime, String handle)
      throws Exception {
    try (PreparedStatement ps = this.conn.prepareStatement(UPDATE_SQL + "WHERE HANDLE = ?")) {

      ps.setString(1, createTime);
      ps.setString(2, modifiedTime);
      ps.setString(3, handle);
      ps.executeUpdate();

    }
  }


  private ActivityGroupJoinActivityResult convertReport(ResultSet rs) throws SQLException {
    ActivityGroupJoinActivityResult data = new ActivityGroupJoinActivityResult();
//
//    data.activityLogs.setSfc(rs.getString(1));
//    data.activityLogs.setShopOrderBo(rs.getString(2));
//    data.activityLogs.setOperation(rs.getString(3));
//    data.activityLogs.setRework(rs.getString(4));
//    data.activityLogs.setResrce(rs.getString(5));
//    data.activityLogs.setUserId(rs.getString(6));
//    data.activityLogs.setActionCode(rs.getString(7));
//    data.activityLogs.setDateTime(DateUtils.getDateTz(rs, 8));
//    data.activityLogs.setActionDetailHandle(rs.getString(9));
//    data.activityLogs.setRouter(rs.getString(10));
//    data.activityLogs.setActionDetail(rs.getString(11));
//
    data.setDescription(rs.getString(1));
    data.setActivityGroupBo(rs.getString(2));
    data.setCrateDateTime(DateUtils.getDateTz(rs, 3));
    data.setCrateDateTime(DateUtils.getDateTz(rs, 4));
    data.setHandle(rs.getString(5));
    return data;
  }

}
