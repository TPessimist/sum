package ame.psb.db.dao;

import ame.psb.db.RunResource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunResourceDao {

  private static final String SQL_INS = "INSERT INTO zr_run_resource(id,resource_bo,event_name,event_user,event_begin_time,event_end_time,prev_state_name,next_state_name,fault_matter,fault_cause,fault_resolve,hold_reason) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_run_resource SET resource_bo=?,event_name=?,event_user=?,event_begin_time=?,event_end_time=?,prev_state_name=?,next_state_name=?,fault_matter=?,fault_cause=?,fault_resolve=?,hold_reason=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resource_bo,event_name,event_user,event_begin_time,event_end_time,prev_state_name,next_state_name,fault_matter,fault_cause,fault_resolve,hold_reason FROM zr_run_resource ";

  private final Connection conn;

  public RunResourceDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunResource data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getEventName());
      ps.setString(4, data.getEventUser());
      DateUtils.setDateTz(ps, 5, data.getEventBeginTime());
      DateUtils.setDateTz(ps, 6, data.getEventEndTime());
      ps.setString(7, data.getPrevStateName());
      ps.setString(8, data.getNextStateName());
      ps.setString(9, data.getFaultMatter());
      ps.setString(10, data.getFaultCause());
      ps.setString(11, data.getFaultResolve());
      ps.setString(12, data.getHoldReason());
      return ps.executeUpdate();
    }
  }

  public int insert(List<RunResource> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunResource data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getEventName());
        ps.setString(4, data.getEventUser());
        DateUtils.setDateTz(ps, 5, data.getEventBeginTime());
        DateUtils.setDateTz(ps, 6, data.getEventEndTime());
        ps.setString(7, data.getPrevStateName());
        ps.setString(8, data.getNextStateName());
        ps.setString(9, data.getFaultMatter());
        ps.setString(10, data.getFaultCause());
        ps.setString(11, data.getFaultResolve());
        ps.setString(12, data.getHoldReason());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunResource data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getEventName());
      ps.setString(3, data.getEventUser());
      DateUtils.setDateTz(ps, 4, data.getEventBeginTime());
      DateUtils.setDateTz(ps, 5, data.getEventEndTime());
      ps.setString(6, data.getPrevStateName());
      ps.setString(7, data.getNextStateName());
      ps.setString(8, data.getFaultMatter());
      ps.setString(9, data.getFaultCause());
      ps.setString(10, data.getFaultResolve());
      ps.setString(11, data.getHoldReason());
      ps.setString(12, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunResource> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunResource data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getEventName());
        ps.setString(3, data.getEventUser());
        DateUtils.setDateTz(ps, 4, data.getEventBeginTime());
        DateUtils.setDateTz(ps, 5, data.getEventEndTime());
        ps.setString(6, data.getPrevStateName());
        ps.setString(7, data.getNextStateName());
        ps.setString(8, data.getFaultMatter());
        ps.setString(9, data.getFaultCause());
        ps.setString(10, data.getFaultResolve());
        ps.setString(11, data.getHoldReason());
        ps.setString(12, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public List<RunResource> selectAll() throws SQLException {
    ArrayList<RunResource> result = new ArrayList<RunResource>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public RunResource selectByPK(String id) throws SQLException {
    RunResource result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public RunResource selectTop(String resourceBo) throws SQLException {
    RunResource result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? ORDER BY event_begin_time DESC")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<RunResource> selectByResource(String resourceBo) throws SQLException {
    ArrayList<RunResource> result = new ArrayList<RunResource>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? ORDER BY event_begin_time")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<RunResource> selectByResourceAndTime(String resourceBo, Date begin, Date end)
      throws SQLException {
    ArrayList<RunResource> result = new ArrayList<RunResource>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE resource_bo=? and event_begin_time between ? and ? ORDER BY event_begin_time")) {
      ps.setString(1, resourceBo);
      DateUtils.setDateTz(ps, 2, begin);
      DateUtils.setDateTz(ps, 3, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private RunResource convert(ResultSet rs) throws SQLException {
    RunResource data = new RunResource();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setEventName(rs.getString(index++));
    data.setEventUser(rs.getString(index++));
    data.setEventBeginTime(DateUtils.getDateTz(rs, index++));
    data.setEventEndTime(DateUtils.getDateTz(rs, index++));
    data.setPrevStateName(rs.getString(index++));
    data.setNextStateName(rs.getString(index++));
    data.setFaultMatter(rs.getString(index++));
    data.setFaultCause(rs.getString(index++));
    data.setFaultResolve(rs.getString(index++));
    data.setHoldReason(rs.getString(index++));

    return data;
  }
}
