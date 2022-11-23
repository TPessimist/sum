package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PadListUploadDao {

  private final Connection conn;

  public PadListUploadDao(Connection conn) {
    this.conn = conn;
  }

  public List<String> selectPmsJobByJobId(String taskId) throws SQLException {
    ArrayList<String> list = new ArrayList<String>();
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT handle,job_status FROM Z_PMS_JOB WHERE job_id =  ?  ")) {
      ps.setString(1, taskId);

      ResultSet rs = ps.executeQuery();
      String handle = null;
      String jobStatus = null;
      if (rs.next()) {
        handle = rs.getString(1);
        jobStatus = rs.getString(2);
      }

      list.add(handle);
      list.add(jobStatus);
      return list;
    }
  }

  public String selectPmsJobResourceByReourceType(String resourceType, String jobBo)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT handle FROM Z_PMS_JOB_RESOURCE_CHECKLIST WHERE resource_type = ? AND job_bo =  ?  ")) {
      ps.setString(1, resourceType);
      ps.setString(2, jobBo);
      String handle = null;

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        handle = rs.getString(1);
      }
      return handle;
    }
  }

}
