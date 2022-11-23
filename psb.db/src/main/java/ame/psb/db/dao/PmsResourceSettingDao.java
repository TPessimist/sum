package ame.psb.db.dao;

import ame.psb.db.PmsResourceSetting;
import ame.psb.db.ViewPmsResourceSetting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PmsResourceSettingDao {

  private static final String SQL_INS = "INSERT INTO zd_pms_resource_setting(handle,seq,resource_bo,resrce,enabled,checklist,period_value,period_unit,tolerance_time,tolerance_unit,next_execute_time,base_on_completed,warning_setting,job_id,created_user,created_date_time,modify_user,modified_date_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_pms_resource_setting SET seq=?,resource_bo=?,resrce=?,enabled=?,checklist=?,period_value=?,period_unit=?,tolerance_time=?,tolerance_unit=?,next_execute_time=?,base_on_completed=?,warning_setting=?,job_id=?,created_user=?,created_date_time=?,modify_user=?,modified_date_time=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,seq,resource_bo,resrce,enabled,checklist,period_value,period_unit,tolerance_time,tolerance_unit,next_execute_time,base_on_completed,warning_setting,job_id,created_user,created_date_time,modify_user,modified_date_time FROM zd_pms_resource_setting ";

  private static final String SQL_SEL_VIEW = "SELECT handle,seq,resource_bo,resrce,enabled,checklist,period_value,period_unit,tolerance_time,tolerance_unit,next_execute_time,base_on_completed,warning_setting,job_id,created_user,created_date_time,modify_user,modified_date_time,description,remark,check_type FROM VIEW_PMS_RESOURCE_SETTING ";

  private final Connection conn;

  public PmsResourceSettingDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PmsResourceSetting data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setInt(2, data.getSeq());
      ps.setString(3, data.getResourceBo());
      ps.setString(4, data.getResrce());
      ps.setBoolean(5, data.isEnabled());
      ps.setString(6, data.getChecklist());
      ps.setString(7, data.getPeriodValue());
      ps.setString(8, data.getPeriodUnit());
      ps.setString(9, data.getToleranceTime());
      ps.setString(10, data.getToleranceUnit());
      DateUtils.setDateTz(ps, 11, data.getNextExecuteTime());
      ps.setBoolean(12, data.isBaseOnCompleted());
      ps.setString(13, data.getWarningSetting());
      ps.setString(14, data.getJobId());
      ps.setString(15, data.getCreatedUser());
      DateUtils.setDateTz(ps, 16, data.getCreatedDateTime());
      ps.setString(17, data.getModifyUser());
      DateUtils.setDateTz(ps, 18, data.getModifiedDateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PmsResourceSetting> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PmsResourceSetting data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setInt(2, data.getSeq());
        ps.setString(3, data.getResourceBo());
        ps.setString(4, data.getResrce());
        ps.setBoolean(5, data.isEnabled());
        ps.setString(6, data.getChecklist());
        ps.setString(7, data.getPeriodValue());
        ps.setString(8, data.getPeriodUnit());
        ps.setString(9, data.getToleranceTime());
        ps.setString(10, data.getToleranceUnit());
        DateUtils.setDateTz(ps, 11, data.getNextExecuteTime());
        ps.setBoolean(12, data.isBaseOnCompleted());
        ps.setString(13, data.getWarningSetting());
        ps.setString(14, data.getJobId());
        ps.setString(15, data.getCreatedUser());
        DateUtils.setDateTz(ps, 16, data.getCreatedDateTime());
        ps.setString(17, data.getModifyUser());
        DateUtils.setDateTz(ps, 18, data.getModifiedDateTime());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PmsResourceSetting data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getSeq());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getResrce());
      ps.setBoolean(4, data.isEnabled());
      ps.setString(5, data.getChecklist());
      ps.setString(6, data.getPeriodValue());
      ps.setString(7, data.getPeriodUnit());
      ps.setString(8, data.getToleranceTime());
      ps.setString(9, data.getToleranceUnit());
      DateUtils.setDateTz(ps, 10, data.getNextExecuteTime());
      ps.setBoolean(11, data.isBaseOnCompleted());
      ps.setString(12, data.getWarningSetting());
      ps.setString(13, data.getJobId());
      ps.setString(14, data.getCreatedUser());
      DateUtils.setDateTz(ps, 15, data.getCreatedDateTime());
      ps.setString(16, data.getModifyUser());
      DateUtils.setDateTz(ps, 17, data.getModifiedDateTime());
      ps.setString(18, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int updateJobId(PmsResourceSetting data) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("update zd_pms_resource_setting set job_id = ? where handle=? ")) {
      ps.setString(1, data.getJobId());
      ps.setString(2, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<PmsResourceSetting> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PmsResourceSetting data : dataList) {
        ps.setInt(1, data.getSeq());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getResrce());
        ps.setBoolean(4, data.isEnabled());
        ps.setString(5, data.getChecklist());
        ps.setString(6, data.getPeriodValue());
        ps.setString(7, data.getPeriodUnit());
        ps.setString(8, data.getToleranceTime());
        ps.setString(9, data.getToleranceUnit());
        DateUtils.setDateTz(ps, 10, data.getNextExecuteTime());
        ps.setBoolean(11, data.isBaseOnCompleted());
        ps.setString(12, data.getWarningSetting());
        ps.setString(13, data.getJobId());
        ps.setString(14, data.getCreatedUser());
        DateUtils.setDateTz(ps, 15, data.getCreatedDateTime());
        ps.setString(16, data.getModifyUser());
        DateUtils.setDateTz(ps, 17, data.getModifiedDateTime());
        ps.setString(18, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_pms_resource_setting WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<ViewPmsResourceSetting> selectAll() throws SQLException {
    ArrayList<ViewPmsResourceSetting> result = new ArrayList<ViewPmsResourceSetting>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_VIEW)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ViewPmsResourceSetting> selectByType(String checkType) throws SQLException {
    ArrayList<ViewPmsResourceSetting> result = new ArrayList<ViewPmsResourceSetting>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_VIEW + " where check_type = ? ")) {

      ps.setString(1, checkType);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public List<ViewPmsResourceSetting> selectByResourceBo(String resourceBo) throws SQLException {
    ArrayList<ViewPmsResourceSetting> result = new ArrayList<ViewPmsResourceSetting>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_VIEW + " where resource_bo = ?")) {

      ps.setString(1, resourceBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public ViewPmsResourceSetting selectByPK(String handle) throws SQLException {
    ViewPmsResourceSetting result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_VIEW + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public ViewPmsResourceSetting selectByResourceAndChecklist(String resourceBo, String checklist)
      throws SQLException {
    ViewPmsResourceSetting result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_VIEW + "WHERE resource_bo=? and checklist=? ")) {
      ps.setString(1, resourceBo);
      ps.setString(2, checklist);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private ViewPmsResourceSetting convert(ResultSet rs) throws SQLException {
    ViewPmsResourceSetting data = new ViewPmsResourceSetting();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSeq(rs.getInt(index++));
    data.setResourceBo(rs.getString(index++));
    data.setResrce(rs.getString(index++));
    data.setEnabled(rs.getBoolean(index++));
    data.setChecklist(rs.getString(index++));
    data.setPeriodValue(rs.getString(index++));
    data.setPeriodUnit(rs.getString(index++));
    data.setToleranceTime(rs.getString(index++));
    data.setToleranceUnit(rs.getString(index++));
    data.setNextExecuteTime(DateUtils.getDateTz(rs, index++));
    data.setBaseOnCompleted(rs.getBoolean(index++));
    data.setWarningSetting(rs.getString(index++));
    data.setJobId(rs.getString(index++));
    data.setCreatedUser(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifyUser(rs.getString(index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setDescription(rs.getString(index++));
    data.setRemark(rs.getString(index++));
    data.setCheckType(rs.getString(index++));

    return data;
  }
}
