package ame.psb.db.dao;

import ame.psb.db.Job37Runtime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class Job37RuntimeDao { //ZH_37_JOB_RUNTIME_TABLE表的DAO层

  private static final String SQL_INS = "INSERT INTO zh_37_job_runtime_table(container_bo,jobid,seq,container_name,label_link,updated_user,updated_time,value,description) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_37_job_runtime_table SET seq=?,container_name=?,label_link=?,updated_user=?,updated_time=?,value=?,description=? WHERE container_bo=? AND jobid=?";

  private static final String SQL_SEL = "SELECT container_bo,jobid,seq,container_name,label_link,updated_user,updated_time,value,description FROM zh_37_job_runtime_table ";

  private final Connection conn;

  public Job37RuntimeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Job37Runtime data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getContainerBo());
      ps.setString(2, data.getJobid());
      ps.setString(3, data.getSeq());
      ps.setString(4, data.getContainerName());
      ps.setString(5, data.getLabelLink());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getValue());
      ps.setString(9, data.getDescription());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Job37Runtime> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Job37Runtime data : dataList) {
        ps.setString(1, data.getContainerBo());
        ps.setString(2, data.getJobid());
        ps.setString(3, data.getSeq());
        ps.setString(4, data.getContainerName());
        ps.setString(5, data.getLabelLink());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getValue());
        ps.setString(9, data.getDescription());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Job37Runtime data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSeq());
      ps.setString(2, data.getContainerName());
      ps.setString(3, data.getLabelLink());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getValue());
      ps.setString(7, data.getDescription());
      ps.setString(8, data.getContainerBo());
      ps.setString(9, data.getJobid());

      return ps.executeUpdate();
    }
  }

  public int update(List<Job37Runtime> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Job37Runtime data : dataList) {
        ps.setString(1, data.getSeq());
        ps.setString(2, data.getContainerName());
        ps.setString(3, data.getLabelLink());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getValue());
        ps.setString(7, data.getDescription());
        ps.setString(8, data.getContainerBo());
        ps.setString(9, data.getJobid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String containerBo, String jobid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zh_37_job_runtime_table WHERE container_bo=? AND jobid=?")) {
      ps.setString(1, containerBo);
      ps.setString(2, jobid);

      return ps.executeUpdate();
    }
  }

  public List<Job37Runtime> selectAll() throws SQLException {
    ArrayList<Job37Runtime> result = new ArrayList<Job37Runtime>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Job37Runtime selectByPK(String containerBo, String jobid) throws SQLException {
    Job37Runtime result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE container_bo=? AND jobid=?")) {
      ps.setString(1, containerBo);
      ps.setString(2, jobid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private Job37Runtime convert(ResultSet rs) throws SQLException {
    Job37Runtime data = new Job37Runtime();

    int index = 1;
    data.setContainerBo(rs.getString(index++));
    data.setJobid(rs.getString(index++));
    data.setSeq(rs.getString(index++));
    data.setContainerName(rs.getString(index++));
    data.setLabelLink(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setValue(rs.getString(index++));
    data.setDescription(rs.getString(index++));

    return data;
  }
}
