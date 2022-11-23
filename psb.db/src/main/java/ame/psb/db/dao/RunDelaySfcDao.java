package ame.psb.db.dao;

import ame.psb.db.RunDelaySfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunDelaySfcDao {

  private static final String SQL_INS = "INSERT INTO zr_delay_sfc(sfc_bo,operation_bo,delay_count,state_name,resource_bo,updated_user,created_time,disable_time,move_in_time,comment) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_delay_sfc SET delay_count=?,state_name=?,resource_bo=?,updated_user=?,created_time=?,disable_time=?,move_in_time=?,comment=? WHERE sfc_bo=? AND operation_bo=?";

  private static final String SQL_SEL = "SELECT sfc_bo,operation_bo,delay_count,state_name,resource_bo,updated_user,created_time,disable_time,move_in_time,comment FROM zr_delay_sfc ";

  private final Connection conn;

  public RunDelaySfcDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunDelaySfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getOperationBo());
      ps.setInt(3, data.getDelayCount());
      ps.setString(4, data.getStateName());
      ps.setString(5, data.getResourceBo());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getCreatedTime());
      DateUtils.setDateTz(ps, 8, data.getDisableTime());
      DateUtils.setDateTz(ps, 9, data.getMoveInTime());
      ps.setString(10, data.getComment());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunDelaySfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunDelaySfc data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getOperationBo());
        ps.setInt(3, data.getDelayCount());
        ps.setString(4, data.getStateName());
        ps.setString(5, data.getResourceBo());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getCreatedTime());
        DateUtils.setDateTz(ps, 8, data.getDisableTime());
        DateUtils.setDateTz(ps, 9, data.getMoveInTime());
        ps.setString(10, data.getComment());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunDelaySfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getDelayCount());
      ps.setString(2, data.getStateName());
      ps.setString(3, data.getResourceBo());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getCreatedTime());
      DateUtils.setDateTz(ps, 6, data.getDisableTime());
      DateUtils.setDateTz(ps, 7, data.getMoveInTime());
      ps.setString(8, data.getComment());
      ps.setString(9, data.getSfcBo());
      ps.setString(10, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunDelaySfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunDelaySfc data : dataList) {
        ps.setInt(1, data.getDelayCount());
        ps.setString(2, data.getStateName());
        ps.setString(3, data.getResourceBo());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getCreatedTime());
        DateUtils.setDateTz(ps, 6, data.getDisableTime());
        DateUtils.setDateTz(ps, 7, data.getMoveInTime());
        ps.setString(8, data.getComment());
        ps.setString(9, data.getSfcBo());
        ps.setString(10, data.getOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String sfcBo, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_delay_sfc WHERE sfc_bo=? AND operation_bo=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      return ps.executeUpdate();
    }
  }

  public List<RunDelaySfc> selectAll() throws SQLException {
    ArrayList<RunDelaySfc> result = new ArrayList<RunDelaySfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<RunDelaySfc> selectActiveByResourceBo(String resourceBo) throws SQLException {
    ArrayList<RunDelaySfc> result = new ArrayList<RunDelaySfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where resource_bo=? and state_name='Y' ")) {

      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public RunDelaySfc selectByPK(String sfcBo, String operationBo) throws SQLException {
    RunDelaySfc result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND operation_bo=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private RunDelaySfc convert(ResultSet rs) throws SQLException {
    RunDelaySfc data = new RunDelaySfc();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDelayCount(rs.getInt(index++));
    data.setStateName(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));
    data.setDisableTime(DateUtils.getDateTz(rs, index++));
    data.setMoveInTime(DateUtils.getDateTz(rs, index++));
    data.setComment(rs.getString(index++));

    return data;
  }
}
