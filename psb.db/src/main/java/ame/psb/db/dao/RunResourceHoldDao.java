package ame.psb.db.dao;

import ame.psb.db.RunResourceHold;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunResourceHoldDao {

  private static final String SQL_INS = "INSERT INTO zr_run_resouce_hold(id,resource_bo,state_name,begin_time,end_time,current_sfclist,memo) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_run_resouce_hold SET resource_bo=?,state_name=?,begin_time=?,end_time=?,current_sfclist=?,memo=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resource_bo,state_name,begin_time,end_time,current_sfclist,memo FROM zr_run_resouce_hold ";

  private final Connection conn;

  public RunResourceHoldDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunResourceHold data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getStateName());
      DateUtils.setDateTz(ps, 4, data.getBeginTime());
      DateUtils.setDateTz(ps, 5, data.getEndTime());
      ps.setString(6, data.getCurrentSfclist());
      ps.setString(7, data.getMemo());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunResourceHold> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunResourceHold data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getStateName());
        DateUtils.setDateTz(ps, 4, data.getBeginTime());
        DateUtils.setDateTz(ps, 5, data.getEndTime());
        ps.setString(6, data.getCurrentSfclist());
        ps.setString(7, data.getMemo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunResourceHold data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getStateName());
      DateUtils.setDateTz(ps, 3, data.getBeginTime());
      DateUtils.setDateTz(ps, 4, data.getEndTime());
      ps.setString(5, data.getCurrentSfclist());
      ps.setString(6, data.getMemo());
      ps.setString(7, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunResourceHold> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunResourceHold data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getStateName());
        DateUtils.setDateTz(ps, 3, data.getBeginTime());
        DateUtils.setDateTz(ps, 4, data.getEndTime());
        ps.setString(5, data.getCurrentSfclist());
        ps.setString(6, data.getMemo());
        ps.setString(7, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_run_resouce_hold WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<RunResourceHold> selectAll() throws SQLException {
    ArrayList<RunResourceHold> result = new ArrayList<RunResourceHold>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public RunResourceHold selectActiveByResourceBo(String resourceBo) throws SQLException {
    RunResourceHold result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where resource_bo=? and state_name='Y' ")) {
      ps.setString(1, resourceBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }


  public RunResourceHold selectByPK(String id) throws SQLException {
    RunResourceHold result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private RunResourceHold convert(ResultSet rs) throws SQLException {
    RunResourceHold data = new RunResourceHold();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setBeginTime(DateUtils.getDateTz(rs, index++));
    data.setEndTime(DateUtils.getDateTz(rs, index++));
    data.setCurrentSfclist(rs.getString(index++));
    data.setMemo(rs.getString(index++));

    return data;
  }
}
