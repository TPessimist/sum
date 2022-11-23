package ame.psb.db.dao;

import ame.psb.db.ViewPadTaskList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PadTaskListDao {

  private static final String SQL_SEL = "SELECT resrce,resource_type,task_id,task_desc,resource_desc,start_time,NEXT_EXECU_TIME,TOLERANCE_TIME,TOLERANCE_UNIT FROM VIEW_PAD_TASK_LIST ";

  private final Connection conn;

  public PadTaskListDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewPadTaskList> selectByPK(String resource) throws SQLException {
    List<ViewPadTaskList> result = new ArrayList<ViewPadTaskList>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE resrce like  ?  ")) {
      ps.setString(1, "%" + resource + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewPadTaskList convert(ResultSet rs) throws SQLException {
    ViewPadTaskList data = new ViewPadTaskList();

    int index = 1;
    data.setResource(rs.getString(index++));
    data.setResourceType(rs.getString(index++));
    data.setTaskId(rs.getString(index++));
    data.setTaskDesc(rs.getString(index++));
    data.setResourceDesc(rs.getString(index++));
    data.setStartTime(DateUtils.getDateTz(rs, index++));
    data.setNextTime(DateUtils.getDateTz(rs, index++));
    data.setToleranceTime(rs.getInt(index++));
    data.setToleranceUnit(rs.getString(index++));

    return data;
  }
}
