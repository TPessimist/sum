package ame.psb.db.dao;

import ame.psb.db.PmsCheckList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PmsCheckListDao {

  private static final String SQL_INS = "INSERT INTO z_pms_checklist(handle,site,checklist,description,status_bo,revision,remark,current_revision,check_type,create_user,created_date_time,modify_user,modified_date_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE z_pms_checklist SET site=?,checklist=?,description=?,status_bo=?,revision=?,remark=?,current_revision=?,check_type=?,create_user=?,created_date_time=?,modify_user=?,modified_date_time=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,site,checklist,description,status_bo,revision,remark,current_revision,check_type,create_user,created_date_time,modify_user,modified_date_time FROM z_pms_checklist ";

  private final Connection conn;

  public PmsCheckListDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PmsCheckList data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getChecklist());
      ps.setString(4, data.getDescription());
      ps.setString(5, data.getStatusBo());
      ps.setString(6, data.getRevision());
      ps.setString(7, data.getRemark());
      ps.setString(8, data.getCurrentRevision());
      ps.setString(9, data.getCheckType());
      ps.setString(10, data.getCreateUser());
      ps.setString(11, data.getCreatedDateTime());
      ps.setString(12, data.getModifyUser());
      ps.setString(13, data.getModifiedDateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PmsCheckList> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PmsCheckList data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getSite());
        ps.setString(3, data.getChecklist());
        ps.setString(4, data.getDescription());
        ps.setString(5, data.getStatusBo());
        ps.setString(6, data.getRevision());
        ps.setString(7, data.getRemark());
        ps.setString(8, data.getCurrentRevision());
        ps.setString(9, data.getCheckType());
        ps.setString(10, data.getCreateUser());
        ps.setString(11, data.getCreatedDateTime());
        ps.setString(12, data.getModifyUser());
        ps.setString(13, data.getModifiedDateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PmsCheckList data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSite());
      ps.setString(2, data.getChecklist());
      ps.setString(3, data.getDescription());
      ps.setString(4, data.getStatusBo());
      ps.setString(5, data.getRevision());
      ps.setString(6, data.getRemark());
      ps.setString(7, data.getCurrentRevision());
      ps.setString(8, data.getCheckType());
      ps.setString(9, data.getCreateUser());
      ps.setString(10, data.getCreatedDateTime());
      ps.setString(11, data.getModifyUser());
      ps.setString(12, data.getModifiedDateTime());
      ps.setString(13, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<PmsCheckList> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PmsCheckList data : dataList) {
        ps.setString(1, data.getSite());
        ps.setString(2, data.getChecklist());
        ps.setString(3, data.getDescription());
        ps.setString(4, data.getStatusBo());
        ps.setString(5, data.getRevision());
        ps.setString(6, data.getRemark());
        ps.setString(7, data.getCurrentRevision());
        ps.setString(8, data.getCheckType());
        ps.setString(9, data.getCreateUser());
        ps.setString(10, data.getCreatedDateTime());
        ps.setString(11, data.getModifyUser());
        ps.setString(12, data.getModifiedDateTime());
        ps.setString(13, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM z_pms_checklist WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<PmsCheckList> selectAll(String site) throws SQLException {
    ArrayList<PmsCheckList> result = new ArrayList<PmsCheckList>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? ORDER BY checklist")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PmsCheckList> selectByde(String description) throws SQLException {
    ArrayList<PmsCheckList> result = new ArrayList<PmsCheckList>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE description like ? ORDER BY checklist")) {
      ps.setString(1, description + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PmsCheckList> selectByNamePrefix(String site, String name) throws SQLException {
    ArrayList<PmsCheckList> result = new ArrayList<PmsCheckList>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? AND checklist like ? ORDER BY checklist")) {
      ps.setString(1, site);
      ps.setString(2, name + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public PmsCheckList selectByPK(String handle) throws SQLException {
    PmsCheckList result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PmsCheckList convert(ResultSet rs) throws SQLException {
    PmsCheckList data = new PmsCheckList();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setChecklist(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setRevision(rs.getString(index++));
    data.setRemark(rs.getString(index++));
    data.setCurrentRevision(rs.getString(index++));
    data.setCheckType(rs.getString(index++));
    data.setCreateUser(rs.getString(index++));
    data.setCreatedDateTime(rs.getString(index++));
    data.setModifyUser(rs.getString(index++));
    data.setModifiedDateTime(rs.getString(index++));

    return data;
  }
}