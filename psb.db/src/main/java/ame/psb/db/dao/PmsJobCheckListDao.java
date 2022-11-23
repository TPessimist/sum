package ame.psb.db.dao;

import ame.psb.db.PmsJobCheckList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PmsJobCheckListDao {

  private static final String SQL_INS = "INSERT INTO z_pms_job_resource_checklist(handle,site,job_bo,resource_bo,resrce,resource_type,resource_desc,checklist,revision,description,create_user,created_date_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE z_pms_job_resource_checklist SET site=?,job_bo=?,resource_bo=?,resrce=?,resource_type=?,resource_desc=?,checklist=?,revision=?,description=?,create_user=?,created_date_time=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,site,job_bo,resource_bo,resrce,resource_type,resource_desc,checklist,revision,description,create_user,created_date_time FROM z_pms_job_resource_checklist ";

  private final Connection conn;

  public PmsJobCheckListDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PmsJobCheckList data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getJobBo());
      ps.setString(4, data.getResourceBo());
      ps.setString(5, data.getResource());
      ps.setString(6, data.getResourceType());
      ps.setString(7, data.getResourceDesc());
      ps.setString(8, data.getChecklist());
      ps.setString(9, data.getRevision());
      ps.setString(10, data.getDescription());
      ps.setString(11, data.getCreateUser());
      ps.setTimestamp(12, new Timestamp(data.getCreatedDateTime().getTime()));

      return ps.executeUpdate();
    }
  }

  public int insert(List<PmsJobCheckList> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PmsJobCheckList data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getSite());
        ps.setString(3, data.getJobBo());
        ps.setString(4, data.getResourceBo());
        ps.setString(5, data.getResource());
        ps.setString(6, data.getResourceType());
        ps.setString(7, data.getResourceDesc());
        ps.setString(8, data.getChecklist());
        ps.setString(9, data.getRevision());
        ps.setString(10, data.getDescription());
        ps.setString(11, data.getCreateUser());
        ps.setTimestamp(12, new Timestamp(data.getCreatedDateTime().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PmsJobCheckList data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSite());
      ps.setString(2, data.getJobBo());
      ps.setString(3, data.getResourceBo());
      ps.setString(4, data.getResource());
      ps.setString(5, data.getResourceType());
      ps.setString(6, data.getResourceDesc());
      ps.setString(7, data.getChecklist());
      ps.setString(8, data.getRevision());
      ps.setString(9, data.getDescription());
      ps.setString(10, data.getCreateUser());
      ps.setTimestamp(11, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setString(12, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<PmsJobCheckList> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PmsJobCheckList data : dataList) {
        ps.setString(1, data.getSite());
        ps.setString(2, data.getJobBo());
        ps.setString(3, data.getResourceBo());
        ps.setString(4, data.getResource());
        ps.setString(5, data.getResourceType());
        ps.setString(6, data.getResourceDesc());
        ps.setString(7, data.getChecklist());
        ps.setString(8, data.getRevision());
        ps.setString(9, data.getDescription());
        ps.setString(10, data.getCreateUser());
        ps.setTimestamp(11, new Timestamp(data.getCreatedDateTime().getTime()));
        ps.setString(12, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM z_pms_job_resource_checklist WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<PmsJobCheckList> selectAll() throws SQLException {
    ArrayList<PmsJobCheckList> result = new ArrayList<PmsJobCheckList>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<PmsJobCheckList> selectByJobBo(String handle) throws SQLException {
    ArrayList<PmsJobCheckList> result = new ArrayList<PmsJobCheckList>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE job_bo=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public PmsJobCheckList selectByPK(String handle) throws SQLException {
    PmsJobCheckList result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PmsJobCheckList convert(ResultSet rs) throws SQLException {
    PmsJobCheckList data = new PmsJobCheckList();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setJobBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setResource(rs.getString(index++));
    data.setResourceType(rs.getString(index++));
    data.setResourceDesc(rs.getString(index++));
    data.setChecklist(rs.getString(index++));
    data.setRevision(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setCreateUser(rs.getString(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));

    return data;
  }

}