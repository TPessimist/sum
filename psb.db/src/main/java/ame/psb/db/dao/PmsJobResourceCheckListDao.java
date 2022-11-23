package ame.psb.db.dao;

import ame.psb.db.PmsJobResourceCheckList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PmsJobResourceCheckListDao {

  private static final String SQL_SEL = "SELECT job_bo,check_type,job_id,job_status,created_date_time,complete_date_time,resource_bo,resrce,resource_type,checklist FROM view_pms_job_resource_checklist ";

  private final Connection conn;

  public PmsJobResourceCheckListDao(Connection conn) {
    this.conn = conn;
  }

  public List<PmsJobResourceCheckList> selectAll() throws SQLException {
    ArrayList<PmsJobResourceCheckList> result = new ArrayList<PmsJobResourceCheckList>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public PmsJobResourceCheckList selectLastCompleteJob(String resrce) throws SQLException {
    PmsJobResourceCheckList pmsJobResourceCheckList = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "where resrce = ? and job_status = 'COMPLETE' order by complete_date_time desc limit 1 ")) {
      ps.setString(1, resrce);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        pmsJobResourceCheckList = convert(rs);
      }
      return pmsJobResourceCheckList;
    }
  }

  public List<PmsJobResourceCheckList> selectNotCompleteJob(String resrce) throws SQLException {
    List<PmsJobResourceCheckList> pjrclist = new ArrayList<PmsJobResourceCheckList>();
    PmsJobResourceCheckList pmsJobResourceCheckList = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where resrce = ? and job_status != 'COMPLETE' ")) {
      ps.setString(1, resrce);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        pmsJobResourceCheckList = convert(rs);
        pjrclist.add(pmsJobResourceCheckList);
      }
      return pjrclist;
    }
  }

  private PmsJobResourceCheckList convert(ResultSet rs) throws SQLException {
    PmsJobResourceCheckList data = new PmsJobResourceCheckList();

    int index = 1;
    data.setJobBo(rs.getString(index++));
    data.setCheckType(rs.getString(index++));
    data.setJobId(rs.getString(index++));
    data.setJobStatus(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setCompleteDateTime(DateUtils.getDateTz(rs, index++));
    data.setResourceBo(rs.getString(index++));
    data.setResrce(rs.getString(index++));
    data.setResourceType(rs.getString(index++));
    data.setChecklist(rs.getString(index++));

    return data;
  }
}

