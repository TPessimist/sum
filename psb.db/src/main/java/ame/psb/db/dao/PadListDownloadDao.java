package ame.psb.db.dao;

import ame.psb.db.ViewPadListDownloadResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PadListDownloadDao {

  private static final String SQL_SEL = "SELECT TASK_ID,RESOURCE_TYPE,TASK_STEP_ID,TASK_STEP_DESC,UP_CONTROL,DOWN_CONTROL,UP_WARN,DOWN_WARN,FORMAT,UNIT,PIC_LINK FROM VIEW_PAD_TASK_LIST_DOWNLOAD ";

  private final Connection conn;

  public PadListDownloadDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewPadListDownloadResult> selectByPK(String taskId, String resourceType)
      throws SQLException {
    List<ViewPadListDownloadResult> result = new ArrayList<ViewPadListDownloadResult>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE task_id = ? AND resource_type = ? ")) {
      ps.setString(1, taskId);
      ps.setString(2, resourceType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewPadListDownloadResult convert(ResultSet rs) throws SQLException {
    ViewPadListDownloadResult data = new ViewPadListDownloadResult();

    int index = 3;
    data.setTaskStepId(rs.getString(index++));
    data.setTaskStepDesc(rs.getString(index++));
    data.setUpControl(rs.getString(index++));
    data.setDownControl(rs.getString(index++));
    data.setUpWarn(rs.getString(index++));
    data.setDownWarn(rs.getString(index++));
    data.setFormat(rs.getString(index++));
    data.setUnit(rs.getString(index++));
    data.setPicLink(rs.getString(index++));

    return data;
  }
}
