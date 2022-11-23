package ame.psb.db.dao;

import ame.psb.db.ViewSamplingSkipResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ViewSamplingSkipResultDao {

  private static final String SQL_SEL = "SELECT SAMPLING_PLAN_GROUP,SAMPLING_PLAN_GROUP_SEQ,RESOURCE_BO,SFC_BO,SAMPLING_PLAN_ID,UPDATED_USER,UPDATED_TIME,PROCESS_OPERATION_BO,INSP_OPERATION_BO FROM VIEW_SAMPLING_SKIP_RESULT ";

  private final Connection conn;

  public ViewSamplingSkipResultDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewSamplingSkipResult> selectById(String SFC) throws SQLException {
    ArrayList<ViewSamplingSkipResult> result = new ArrayList<ViewSamplingSkipResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE SFC_BO =? ")) {
      ps.setString(1, SFC);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ViewSamplingSkipResult> selectByGroup(String ID) throws SQLException {
    ArrayList<ViewSamplingSkipResult> result = new ArrayList<ViewSamplingSkipResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE SAMPLING_PLAN_GROUP =? ORDER BY SAMPLING_PLAN_GROUP,SAMPLING_PLAN_GROUP_SEQ ")) {
      ps.setString(1, ID);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  private ViewSamplingSkipResult convert(ResultSet rs) throws SQLException {
    ViewSamplingSkipResult data = new ViewSamplingSkipResult();

    int index = 1;
    data.setSamplingPlanGroup(rs.getString(index++));
    data.setSamplingPlanGroupSeq(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setSamplingPlanId(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(rs.getDate(index++));
    data.setProcessOperationBo(rs.getString(index++));
    data.setInspOperationBo(rs.getString(index++));

    return data;
  }
}
