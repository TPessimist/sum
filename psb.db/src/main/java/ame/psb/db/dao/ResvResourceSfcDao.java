package ame.psb.db.dao;

import ame.psb.db.ResvResourceSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ResvResourceSfcDao {

  private static final String SQL_INS = "INSERT INTO zr_resv_resource_sfc(id,resv_resource_id,state_name,action_name,action_desc,reserve_current,reserve_sfc_bo,reserve_time,buy_off,buy_off_sfc_bo,buy_off_start_time,buy_off_end_time,lock_sfc_bo,operation_bo,device_bo,curr_sfc_bo,curr_operation_bo,curr_device_bo,insp_resource_bo,insp_result,insp_state_name) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_resv_resource_sfc SET resv_resource_id=?,state_name=?,action_name=?,action_desc=?,reserve_current=?,reserve_sfc_bo=?,reserve_time=?,buy_off=?,buy_off_sfc_bo=?,buy_off_start_time=?,buy_off_end_time=?,lock_sfc_bo=?,operation_bo=?,device_bo=?,curr_sfc_bo=?,curr_operation_bo=?,curr_device_bo=?,insp_resource_bo=?,insp_result=?,insp_state_name=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resv_resource_id,state_name,action_name,action_desc,reserve_current,reserve_sfc_bo,reserve_time,buy_off,buy_off_sfc_bo,buy_off_start_time,buy_off_end_time,lock_sfc_bo,operation_bo,device_bo,curr_sfc_bo,curr_operation_bo,curr_device_bo,insp_resource_bo,insp_result,insp_state_name FROM zr_resv_resource_sfc ";

  private final Connection conn;

  public ResvResourceSfcDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ResvResourceSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResvResourceId());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getActionName());
      ps.setString(5, data.getActionDesc());
      ps.setString(6, data.getReserveCurrent());
      ps.setString(7, data.getReserveSfcBo());
      DateUtils.setDateTz(ps, 8, data.getReserveTime());
      ps.setString(9, data.getBuyOff());
      ps.setString(10, data.getBuyOffSfcBo());
      DateUtils.setDateTz(ps, 11, data.getBuyOffStartTime());
      DateUtils.setDateTz(ps, 12, data.getBuyOffEndTime());
      ps.setString(13, data.getLockSfcBo());
      ps.setString(14, data.getOperationBo());
      ps.setString(15, data.getDeviceBo());
      ps.setString(16, data.getCurrSfcBo());
      ps.setString(17, data.getCurrOperationBo());
      ps.setString(18, data.getCurrDeviceBo());
      ps.setString(19, data.getInspResourceBo());
      ps.setString(20, data.getInspResult());
      ps.setString(21, data.getInspStateName());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ResvResourceSfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ResvResourceSfc data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResvResourceId());
        ps.setString(3, data.getStateName());
        ps.setString(4, data.getActionName());
        ps.setString(5, data.getActionDesc());
        ps.setString(6, data.getReserveCurrent());
        ps.setString(7, data.getReserveSfcBo());
        DateUtils.setDateTz(ps, 8, data.getReserveTime());
        ps.setString(9, data.getBuyOff());
        ps.setString(10, data.getBuyOffSfcBo());
        DateUtils.setDateTz(ps, 11, data.getBuyOffStartTime());
        DateUtils.setDateTz(ps, 12, data.getBuyOffEndTime());
        ps.setString(13, data.getLockSfcBo());
        ps.setString(14, data.getOperationBo());
        ps.setString(15, data.getDeviceBo());
        ps.setString(16, data.getCurrSfcBo());
        ps.setString(17, data.getCurrOperationBo());
        ps.setString(18, data.getCurrDeviceBo());
        ps.setString(19, data.getInspResourceBo());
        ps.setString(20, data.getInspResult());
        ps.setString(21, data.getInspStateName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ResvResourceSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResvResourceId());
      ps.setString(2, data.getStateName());
      ps.setString(3, data.getActionName());
      ps.setString(4, data.getActionDesc());
      ps.setString(5, data.getReserveCurrent());
      ps.setString(6, data.getReserveSfcBo());
      DateUtils.setDateTz(ps, 7, data.getReserveTime());
      ps.setString(8, data.getBuyOff());
      ps.setString(9, data.getBuyOffSfcBo());
      DateUtils.setDateTz(ps, 10, data.getBuyOffStartTime());
      DateUtils.setDateTz(ps, 11, data.getBuyOffEndTime());
      ps.setString(12, data.getLockSfcBo());
      ps.setString(13, data.getOperationBo());
      ps.setString(14, data.getDeviceBo());
      ps.setString(15, data.getCurrSfcBo());
      ps.setString(16, data.getCurrOperationBo());
      ps.setString(17, data.getCurrDeviceBo());
      ps.setString(18, data.getInspResourceBo());
      ps.setString(19, data.getInspResult());
      ps.setString(20, data.getInspStateName());
      ps.setString(21, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ResvResourceSfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ResvResourceSfc data : dataList) {
        ps.setString(1, data.getResvResourceId());
        ps.setString(2, data.getStateName());
        ps.setString(3, data.getActionName());
        ps.setString(4, data.getActionDesc());
        ps.setString(5, data.getReserveCurrent());
        ps.setString(6, data.getReserveSfcBo());
        DateUtils.setDateTz(ps, 7, data.getReserveTime());
        ps.setString(8, data.getBuyOff());
        ps.setString(9, data.getBuyOffSfcBo());
        DateUtils.setDateTz(ps, 10, data.getBuyOffStartTime());
        DateUtils.setDateTz(ps, 11, data.getBuyOffEndTime());
        ps.setString(12, data.getLockSfcBo());
        ps.setString(13, data.getOperationBo());
        ps.setString(14, data.getDeviceBo());
        ps.setString(15, data.getCurrSfcBo());
        ps.setString(16, data.getCurrOperationBo());
        ps.setString(17, data.getCurrDeviceBo());
        ps.setString(18, data.getInspResourceBo());
        ps.setString(19, data.getInspResult());
        ps.setString(20, data.getInspStateName());
        ps.setString(21, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_resv_resource_sfc WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ResvResourceSfc> selectAll() throws SQLException {
    ArrayList<ResvResourceSfc> result = new ArrayList<ResvResourceSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ResvResourceSfc selectByPK(String id) throws SQLException {
    ResvResourceSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ResvResourceSfc> selectSwitch() throws SQLException {
    ArrayList<ResvResourceSfc> result = new ArrayList<ResvResourceSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL
                + "WHERE action_name='SWITCH' AND reserve_current = 'Y' AND state_name = 'RESERVE'")) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ResvResourceSfc convert(ResultSet rs) throws SQLException {
    ResvResourceSfc data = new ResvResourceSfc();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResvResourceId(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setActionDesc(rs.getString(index++));
    data.setReserveCurrent(rs.getString(index++));
    data.setReserveSfcBo(rs.getString(index++));
    data.setReserveTime(DateUtils.getDateTz(rs, index++));
    data.setBuyOff(rs.getString(index++));
    data.setBuyOffSfcBo(rs.getString(index++));
    data.setBuyOffStartTime(DateUtils.getDateTz(rs, index++));
    data.setBuyOffEndTime(DateUtils.getDateTz(rs, index++));
    data.setLockSfcBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDeviceBo(rs.getString(index++));
    data.setCurrSfcBo(rs.getString(index++));
    data.setCurrOperationBo(rs.getString(index++));
    data.setCurrDeviceBo(rs.getString(index++));
    data.setInspResourceBo(rs.getString(index++));
    data.setInspResult(rs.getString(index++));
    data.setInspStateName(rs.getString(index++));

    return data;
  }
}
