package ame.psb.db.dao;

import ame.psb.db.PmsPlan;
import ame.psb.db.ViewPmsPlan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PmsPlanDao {

  private static final String SQL_INS = "INSERT INTO z_pms_plan(handle,site,resource_bo,resrce,enabled,checklist,revision,check_type,period_value,period_unit,next_execu_time,base_completed,is_warning,create_user,created_date_time,modify_user,modified_date_time,resource_type,tolerance_time,tolerance_unit) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE z_pms_plan SET site=?,resource_bo=?,resrce=?,enabled=?,checklist=?,revision=?,check_type=?,period_value=?,period_unit=?,next_execu_time=?,base_completed=?,is_warning=?,create_user=?,created_date_time=?,modify_user=?,modified_date_time=?,resource_type=?,tolerance_time=?,tolerance_unit=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,site,resource_bo,resrce,enabled,checklist,revision,check_type,period_value,period_unit,next_execu_time,base_completed,is_warning,create_user,created_date_time,modify_user,modified_date_time,resource_type,tolerance_time,tolerance_unit FROM z_pms_plan ";

  private static final String SQL_SEL1 = "SELECT handle,resrce,site,resource_type,enabled,check_list,revision,check_type,period_value,period_unit,job_id,job_status,created_date_time,start_date_time,complete_date_time,next_execu_time FROM view_pms_plan ";

  private final Connection conn;

  public PmsPlanDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PmsPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getResourceBo());
      ps.setString(4, data.getResrce());
      ps.setString(5, data.getEnabled());
      ps.setString(6, data.getChecklist());
      ps.setString(7, data.getRevision());
      ps.setString(8, data.getCheckType());
      ps.setString(9, data.getPeriodValue());
      ps.setString(10, data.getPeriodUnit());
      DateUtils.setDateTz(ps, 11, data.getNextExecuTime());
      ps.setString(12, data.getBaseCompleted());
      ps.setString(13, data.getIsWarning());
      ps.setString(14, data.getCreateUser());
      DateUtils.setDateTz(ps, 15, data.getCreatedDateTime());
      ps.setString(16, data.getModifyUser());
      DateUtils.setDateTz(ps, 17, data.getModifiedDateTime());
      ps.setString(18, data.getResourceType());
      ps.setString(19, data.getToleranceTime());
      ps.setString(20, data.getToleranceUnit());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PmsPlan> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PmsPlan data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getSite());
        ps.setString(3, data.getResourceBo());
        ps.setString(4, data.getResrce());
        ps.setString(5, data.getEnabled());
        ps.setString(6, data.getChecklist());
        ps.setString(7, data.getRevision());
        ps.setString(8, data.getCheckType());
        ps.setString(9, data.getPeriodValue());
        ps.setString(10, data.getPeriodUnit());
        DateUtils.setDateTz(ps, 11, data.getNextExecuTime());
        ps.setString(12, data.getBaseCompleted());
        ps.setString(13, data.getIsWarning());
        ps.setString(14, data.getCreateUser());
        DateUtils.setDateTz(ps, 15, data.getCreatedDateTime());
        ps.setString(16, data.getModifyUser());
        DateUtils.setDateTz(ps, 17, data.getModifiedDateTime());
        ps.setString(18, data.getResourceType());
        ps.setString(19, data.getToleranceTime());
        ps.setString(20, data.getToleranceUnit());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PmsPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSite());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getResrce());
      ps.setString(4, data.getEnabled());
      ps.setString(5, data.getChecklist());
      ps.setString(6, data.getRevision());
      ps.setString(7, data.getCheckType());
      ps.setString(8, data.getPeriodValue());
      ps.setString(9, data.getPeriodUnit());
      DateUtils.setDateTz(ps, 10, data.getNextExecuTime());
      ps.setString(11, data.getBaseCompleted());
      ps.setString(12, data.getIsWarning());
      ps.setString(13, data.getCreateUser());
      DateUtils.setDateTz(ps, 14, data.getCreatedDateTime());
      ps.setString(15, data.getModifyUser());
      DateUtils.setDateTz(ps, 16, data.getModifiedDateTime());
      ps.setString(17, data.getResourceType());
      ps.setString(18, data.getToleranceTime());
      ps.setString(19, data.getToleranceUnit());
      ps.setString(20, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<PmsPlan> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PmsPlan data : dataList) {
        ps.setString(1, data.getSite());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getResrce());
        ps.setString(4, data.getEnabled());
        ps.setString(5, data.getChecklist());
        ps.setString(6, data.getRevision());
        ps.setString(7, data.getCheckType());
        ps.setString(8, data.getPeriodValue());
        ps.setString(9, data.getPeriodUnit());
        ps.setTimestamp(10, new Timestamp(data.getNextExecuTime().getTime()));
        ps.setString(11, data.getBaseCompleted());
        ps.setString(12, data.getIsWarning());
        ps.setString(13, data.getCreateUser());
        ps.setTimestamp(14, new Timestamp(data.getCreatedDateTime().getTime()));
        ps.setString(15, data.getModifyUser());
        ps.setTimestamp(16, new Timestamp(data.getModifiedDateTime().getTime()));
        ps.setString(17, data.getResourceType());
        ps.setString(18, data.getToleranceTime());
        ps.setString(19, data.getToleranceUnit());
        ps.setString(20, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM z_pms_plan WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public PmsPlan selectByPK(String id) throws SQLException {
    PmsPlan data = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        data = convert(rs);
      }
    }
    return data;
  }

  public List<PmsPlan> selectByType(String resourceType, String site) throws SQLException {
    ArrayList<PmsPlan> result = new ArrayList<PmsPlan>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE resource_type =? AND site =?")) {
      ps.setString(1, resourceType);
      ps.setString(2, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PmsPlan> selectByReosouce(String handle) throws SQLException {
    ArrayList<PmsPlan> result = new ArrayList<PmsPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE resource_bo=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public PmsPlan selectCheckPlan(String resourceBo, String checkList, String revision)
      throws SQLException {
    PmsPlan data = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE resource_bo=? AND checklist=? AND revision=?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, checkList);
      ps.setString(3, revision);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        data = convert(rs);
      }
      return data;
    }
  }

  public List<PmsPlan> selectByReosouceAndStatus(String resourceBo) throws SQLException {
    ArrayList<PmsPlan> result = new ArrayList<PmsPlan>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE resource_bo=? AND enabled = 'true' ")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewPmsPlan selectCheckView(String resource, String checklist, String revision,
      String checkType, String resourceType,
      String site) throws SQLException {
    ViewPmsPlan result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + " WHERE resrce=? AND check_list=? AND revision=? AND "
            + " check_type=? AND resource_type=? AND site = ?")) {
      ps.setString(1, resource);
      ps.setString(2, checklist);
      ps.setString(3, revision);
      ps.setString(4, checkType);
      ps.setString(5, resourceType);
      ps.setString(6, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result = convert1(rs);
      }
      return result;
    }
  }

  public PmsPlan selectCheck(String resourceBo, String checklist, String revision, String checkType,
      String resourceType,
      String periodValue, String periodUnit) throws SQLException {
    PmsPlan result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE resource_bo=? AND checklist=? AND revision=? AND "
            + " check_type=? AND resource_type=? AND period_value = ? AND period_unit = ?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, checklist);
      ps.setString(3, revision);
      ps.setString(4, checkType);
      ps.setString(5, resourceType);
      ps.setString(6, periodValue);
      ps.setString(7, periodUnit);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PmsPlan selectByFilter(String resourceBo, String checkList, String revision)
      throws SQLException {
    PmsPlan data = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE RESOURCE_BO=? AND CHECKLIST= ? AND REVISION= ?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, checkList);
      ps.setString(3, revision);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        data = convert(rs);
      }
    }
    return data;
  }

  private PmsPlan convert(ResultSet rs) throws SQLException {
    PmsPlan data = new PmsPlan();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setResrce(rs.getString(index++));
    data.setEnabled(rs.getString(index++));
    data.setChecklist(rs.getString(index++));
    data.setRevision(rs.getString(index++));
    data.setCheckType(rs.getString(index++));
    data.setPeriodValue(rs.getString(index++));
    data.setPeriodUnit(rs.getString(index++));
    data.setNextExecuTime(DateUtils.getDateTz(rs, index++));
    data.setBaseCompleted(rs.getString(index++));
    data.setIsWarning(rs.getString(index++));
    data.setCreateUser(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifyUser(rs.getString(index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setResourceType(rs.getString(index++));
    data.setToleranceTime(rs.getString(index++));
    data.setToleranceUnit(rs.getString(index++));

    return data;
  }

  private ViewPmsPlan convert1(ResultSet rs) throws SQLException {
    ViewPmsPlan data = new ViewPmsPlan();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setResrce(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setResourceType(rs.getString(index++));
    data.setEnabled(rs.getString(index++));
    data.setCheckList(rs.getString(index++));
    data.setRevision(rs.getString(index++));
    data.setCheckType(rs.getString(index++));
    data.setPeriodValue(rs.getString(index++));
    data.setPeriodUnit(rs.getString(index++));
    data.setJobId(rs.getString(index++));
    data.setJobStatus(rs.getString(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));
    data.setStartDateTime(rs.getTimestamp(index++));
    data.setCompleteDateTime(rs.getTimestamp(index++));
    data.setNextExecuTime(rs.getTimestamp(index++));

    return data;
  }
}

