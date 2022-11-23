package ame.psb.db.dao;

import ame.psb.db.PmsPlanChange;
import ame.psb.db.ViewPmsPlanChange;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class PmsPlanChangeDao {

  private static final String SQL_INS = "INSERT INTO z_pms_plan_change(id,resource_type,check_list,check_list_version,check_list_type,planning_cycle,cycle_unit,delay_time,remark,status,update_user,update_time,site,resrce) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE z_pms_plan_change SET resource_type=?,check_list=?,check_list_version=?,check_list_type=?,planning_cycle=?,cycle_unit=?,delay_time=?,remark=?,status=?,update_user=?,update_time=?,site=?,resrce=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resrce,site,resource_type,enabled,check_list,check_list_version,check_list_type,planning_cycle,cycle_unit,remark,status,update_user,update_time,job_id,job_status,start_date_time,next_execu_time,delay_time FROM view_pms_plan_change ";

  private final Connection conn;

  public PmsPlanChangeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PmsPlanChange data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceType());
      ps.setString(3, data.getCheckList());
      ps.setString(4, data.getCheckListVersion());
      ps.setString(5, data.getCheckListType());
      ps.setString(6, data.getPlanningCycle());
      ps.setString(7, data.getCycleUnit());
      DateUtils.setDateTz(ps, 8, data.getDelayTime());
      ps.setString(9, data.getRemark());
      ps.setString(10, data.getStatus());
      ps.setString(11, data.getUpdateUser());
      DateUtils.setDateTz(ps, 12, data.getUpdateTime());
      ps.setString(13, data.getSite());
      ps.setString(14, data.getResrce());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PmsPlanChange> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PmsPlanChange data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResourceType());
        ps.setString(3, data.getCheckList());
        ps.setString(4, data.getCheckListVersion());
        ps.setString(5, data.getCheckListType());
        ps.setString(6, data.getPlanningCycle());
        ps.setString(7, data.getCycleUnit());
        DateUtils.setDateTz(ps, 8, data.getDelayTime());
        ps.setString(9, data.getRemark());
        ps.setString(10, data.getStatus());
        ps.setString(11, data.getUpdateUser());
        DateUtils.setDateTz(ps, 12, data.getUpdateTime());
        ps.setString(13, data.getSite());
        ps.setString(14, data.getResrce());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PmsPlanChange data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceType());
      ps.setString(2, data.getCheckList());
      ps.setString(3, data.getCheckListVersion());
      ps.setString(4, data.getCheckListType());
      ps.setString(5, data.getPlanningCycle());
      ps.setString(6, data.getCycleUnit());
      DateUtils.setDateTz(ps, 7, data.getDelayTime());
      ps.setString(8, data.getRemark());
      ps.setString(9, data.getStatus());
      ps.setString(10, data.getUpdateUser());
      DateUtils.setDateTz(ps, 11, data.getUpdateTime());
      ps.setString(12, data.getSite());
      ps.setString(13, data.getResrce());
      ps.setString(14, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<PmsPlanChange> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PmsPlanChange data : dataList) {
        ps.setString(1, data.getResourceType());
        ps.setString(2, data.getCheckList());
        ps.setString(3, data.getCheckListVersion());
        ps.setString(4, data.getCheckListType());
        ps.setString(5, data.getPlanningCycle());
        ps.setString(6, data.getCycleUnit());
        DateUtils.setDateTz(ps, 7, data.getDelayTime());
        ps.setString(8, data.getRemark());
        ps.setString(9, data.getStatus());
        ps.setString(10, data.getUpdateUser());
        DateUtils.setDateTz(ps, 11, data.getUpdateTime());
        ps.setString(12, data.getSite());
        ps.setString(13, data.getResrce());
        ps.setString(14, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }


  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM z_pms_plan_change WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ViewPmsPlanChange> selectByResource(String resource, String site)
      throws SQLException {
    ArrayList<ViewPmsPlanChange> result = new ArrayList<ViewPmsPlanChange>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE resrce=? AND site=?")) {
      ps.setString(1, resource);
      ps.setString(2, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ViewPmsPlanChange> selectByResourceType(String resourceType, String site)
      throws SQLException {
    ArrayList<ViewPmsPlanChange> result = new ArrayList<ViewPmsPlanChange>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE resource_Type=? AND site=?")) {
      ps.setString(1, resourceType);
      ps.setString(2, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewPmsPlanChange> select(Where where) throws SQLException {
    ArrayList<ViewPmsPlanChange> result = new ArrayList<ViewPmsPlanChange>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewPmsPlanChange selectByPK(String id) throws SQLException {
    ViewPmsPlanChange data = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        data = convert(rs);
      }
    }
    return data;
  }

  public List<ViewPmsPlanChange> selectCheck(String resource, String checklist, String revision,
      String checkType, String resourceType,
      String site) throws SQLException {
    ArrayList<ViewPmsPlanChange> result = new ArrayList<ViewPmsPlanChange>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE resrce=? AND check_list=? AND check_list_version=? AND "
            + " check_list_type=? AND resource_type=? AND site = ?")) {
      ps.setString(1, resource);
      ps.setString(2, checklist);
      ps.setString(3, revision);
      ps.setString(4, checkType);
      ps.setString(5, resourceType);
      ps.setString(6, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewPmsPlanChange convert(ResultSet rs) throws SQLException {
    ViewPmsPlanChange data = new ViewPmsPlanChange();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResrce(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setResourceType(rs.getString(index++));
    data.setEnabled(rs.getString(index++));
    data.setCheckList(rs.getString(index++));
    data.setCheckListVersion(rs.getString(index++));
    data.setCheckListType(rs.getString(index++));
    data.setPlanningCycle(rs.getString(index++));
    data.setCycleUnit(rs.getString(index++));
    data.setRemark(rs.getString(index++));
    data.setStatus(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setJobId(rs.getString(index++));
    data.setJobStatus(rs.getString(index++));
    data.setStartDateTime(DateUtils.getDateTz(rs, index++));
    data.setNextExecuTime(DateUtils.getDateTz(rs, index++));
    data.setDelayTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
