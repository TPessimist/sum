package ame.psb.db.dao;

import ame.psb.db.ZrResourceSwitch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZrResourceSwitchDao {

  private static final String SQL_INS = "INSERT INTO zr_resource_switch(uuid,resource_bo,resource_name,reserve_id,action_code,action_desc,stage_name,stage_desc,switch_device_bo,switch_device_name,switch_operation_bo,switch_operation_name,switch_sfc_bo,switch_sfc_name,reserve_sfc_bo,reserve_sfc_name,reserve_device_bo,reserve_device_name,reserve_operation_bo,reserve_operation_name,buyoff_sfc_bo,buyoff_sfc_name,buyoff_resource_bo,buyoff_resource_name,buyoff_operation_bo,buyoff_operation_name,buyoff_result,before_sfc_bo,before_sfc_name,before_device_bo,before_device_name,before_operation_bo,before_operation_name,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_resource_switch SET resource_bo=?,resource_name=?,reserve_id=?,action_code=?,action_desc=?,stage_name=?,stage_desc=?,switch_device_bo=?,switch_device_name=?,switch_operation_bo=?,switch_operation_name=?,switch_sfc_bo=?,switch_sfc_name=?,reserve_sfc_bo=?,reserve_sfc_name=?,reserve_device_bo=?,reserve_device_name=?,reserve_operation_bo=?,reserve_operation_name=?,buyoff_sfc_bo=?,buyoff_sfc_name=?,buyoff_resource_bo=?,buyoff_resource_name=?,buyoff_operation_bo=?,buyoff_operation_name=?,buyoff_result=?,before_sfc_bo=?,before_sfc_name=?,before_device_bo=?,before_device_name=?,before_operation_bo=?,before_operation_name=?,update_user=?,update_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,resource_bo,resource_name,reserve_id,action_code,action_desc,stage_name,stage_desc,switch_device_bo,switch_device_name,switch_operation_bo,switch_operation_name,switch_sfc_bo,switch_sfc_name,reserve_sfc_bo,reserve_sfc_name,reserve_device_bo,reserve_device_name,reserve_operation_bo,reserve_operation_name,buyoff_sfc_bo,buyoff_sfc_name,buyoff_resource_bo,buyoff_resource_name,buyoff_operation_bo,buyoff_operation_name,buyoff_result,before_sfc_bo,before_sfc_name,before_device_bo,before_device_name,before_operation_bo,before_operation_name,update_user,update_time FROM zr_resource_switch ";

  private final Connection conn;

  public ZrResourceSwitchDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZrResourceSwitch data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getResourceName());
      ps.setString(4, data.getReserveId());
      ps.setString(5, data.getActionCode());
      ps.setString(6, data.getActionDesc());
      ps.setString(7, data.getStageName());
      ps.setString(8, data.getStageDesc());
      ps.setString(9, data.getSwitchDeviceBo());
      ps.setString(10, data.getSwitchDeviceName());
      ps.setString(11, data.getSwitchOperationBo());
      ps.setString(12, data.getSwitchOperationName());
      ps.setString(13, data.getSwitchSfcBo());
      ps.setString(14, data.getSwitchSfcName());
      ps.setString(15, data.getReserveSfcBo());
      ps.setString(16, data.getReserveSfcName());
      ps.setString(17, data.getReserveDeviceBo());
      ps.setString(18, data.getReserveDeviceName());
      ps.setString(19, data.getReserveOperationBo());
      ps.setString(20, data.getReserveOperationName());
      ps.setString(21, data.getBuyoffSfcBo());
      ps.setString(22, data.getBuyoffSfcName());
      ps.setString(23, data.getBuyoffResourceBo());
      ps.setString(24, data.getBuyoffResourceName());
      ps.setString(25, data.getBuyoffOperationBo());
      ps.setString(26, data.getBuyoffOperationName());
      ps.setString(27, data.getBuyoffResult());
      ps.setString(28, data.getBeforeSfcBo());
      ps.setString(29, data.getBeforeSfcName());
      ps.setString(30, data.getBeforeDeviceBo());
      ps.setString(31, data.getBeforeDeviceName());
      ps.setString(32, data.getBeforeOperationBo());
      ps.setString(33, data.getBeforeOperationName());
      ps.setString(34, data.getUpdateUser());
      DateUtils.setDateTz(ps, 35, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZrResourceSwitch> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZrResourceSwitch data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getResourceName());
        ps.setString(4, data.getReserveId());
        ps.setString(5, data.getActionCode());
        ps.setString(6, data.getActionDesc());
        ps.setString(7, data.getStageName());
        ps.setString(8, data.getStageDesc());
        ps.setString(9, data.getSwitchDeviceBo());
        ps.setString(10, data.getSwitchDeviceName());
        ps.setString(11, data.getSwitchOperationBo());
        ps.setString(12, data.getSwitchOperationName());
        ps.setString(13, data.getSwitchSfcBo());
        ps.setString(14, data.getSwitchSfcName());
        ps.setString(15, data.getReserveSfcBo());
        ps.setString(16, data.getReserveSfcName());
        ps.setString(17, data.getReserveDeviceBo());
        ps.setString(18, data.getReserveDeviceName());
        ps.setString(19, data.getReserveOperationBo());
        ps.setString(20, data.getReserveOperationName());
        ps.setString(21, data.getBuyoffSfcBo());
        ps.setString(22, data.getBuyoffSfcName());
        ps.setString(23, data.getBuyoffResourceBo());
        ps.setString(24, data.getBuyoffResourceName());
        ps.setString(25, data.getBuyoffOperationBo());
        ps.setString(26, data.getBuyoffOperationName());
        ps.setString(27, data.getBuyoffResult());
        ps.setString(28, data.getBeforeSfcBo());
        ps.setString(29, data.getBeforeSfcName());
        ps.setString(30, data.getBeforeDeviceBo());
        ps.setString(31, data.getBeforeDeviceName());
        ps.setString(32, data.getBeforeOperationBo());
        ps.setString(33, data.getBeforeOperationName());
        ps.setString(34, data.getUpdateUser());
        DateUtils.setDateTz(ps, 35, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZrResourceSwitch data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getResourceName());
      ps.setString(3, data.getReserveId());
      ps.setString(4, data.getActionCode());
      ps.setString(5, data.getActionDesc());
      ps.setString(6, data.getStageName());
      ps.setString(7, data.getStageDesc());
      ps.setString(8, data.getSwitchDeviceBo());
      ps.setString(9, data.getSwitchDeviceName());
      ps.setString(10, data.getSwitchOperationBo());
      ps.setString(11, data.getSwitchOperationName());
      ps.setString(12, data.getSwitchSfcBo());
      ps.setString(13, data.getSwitchSfcName());
      ps.setString(14, data.getReserveSfcBo());
      ps.setString(15, data.getReserveSfcName());
      ps.setString(16, data.getReserveDeviceBo());
      ps.setString(17, data.getReserveDeviceName());
      ps.setString(18, data.getReserveOperationBo());
      ps.setString(19, data.getReserveOperationName());
      ps.setString(20, data.getBuyoffSfcBo());
      ps.setString(21, data.getBuyoffSfcName());
      ps.setString(22, data.getBuyoffResourceBo());
      ps.setString(23, data.getBuyoffResourceName());
      ps.setString(24, data.getBuyoffOperationBo());
      ps.setString(25, data.getBuyoffOperationName());
      ps.setString(26, data.getBuyoffResult());
      ps.setString(27, data.getBeforeSfcBo());
      ps.setString(28, data.getBeforeSfcName());
      ps.setString(29, data.getBeforeDeviceBo());
      ps.setString(30, data.getBeforeDeviceName());
      ps.setString(31, data.getBeforeOperationBo());
      ps.setString(32, data.getBeforeOperationName());
      ps.setString(33, data.getUpdateUser());
      DateUtils.setDateTz(ps, 34, data.getUpdateTime());
      ps.setString(35, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZrResourceSwitch> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZrResourceSwitch data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getResourceName());
        ps.setString(3, data.getReserveId());
        ps.setString(4, data.getActionCode());
        ps.setString(5, data.getActionDesc());
        ps.setString(6, data.getStageName());
        ps.setString(7, data.getStageDesc());
        ps.setString(8, data.getSwitchDeviceBo());
        ps.setString(9, data.getSwitchDeviceName());
        ps.setString(10, data.getSwitchOperationBo());
        ps.setString(11, data.getSwitchOperationName());
        ps.setString(12, data.getSwitchSfcBo());
        ps.setString(13, data.getSwitchSfcName());
        ps.setString(14, data.getReserveSfcBo());
        ps.setString(15, data.getReserveSfcName());
        ps.setString(16, data.getReserveDeviceBo());
        ps.setString(17, data.getReserveDeviceName());
        ps.setString(18, data.getReserveOperationBo());
        ps.setString(19, data.getReserveOperationName());
        ps.setString(20, data.getBuyoffSfcBo());
        ps.setString(21, data.getBuyoffSfcName());
        ps.setString(22, data.getBuyoffResourceBo());
        ps.setString(23, data.getBuyoffResourceName());
        ps.setString(24, data.getBuyoffOperationBo());
        ps.setString(25, data.getBuyoffOperationName());
        ps.setString(26, data.getBuyoffResult());
        ps.setString(27, data.getBeforeSfcBo());
        ps.setString(28, data.getBeforeSfcName());
        ps.setString(29, data.getBeforeDeviceBo());
        ps.setString(30, data.getBeforeDeviceName());
        ps.setString(31, data.getBeforeOperationBo());
        ps.setString(32, data.getBeforeOperationName());
        ps.setString(33, data.getUpdateUser());
        DateUtils.setDateTz(ps, 34, data.getUpdateTime());
        ps.setString(35, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_resource_switch WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<ZrResourceSwitch> selectAll() throws SQLException {
    ArrayList<ZrResourceSwitch> result = new ArrayList<ZrResourceSwitch>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZrResourceSwitch selectByPK(String uuid) throws SQLException {
    ZrResourceSwitch result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZrResourceSwitch convert(ResultSet rs) throws SQLException {
    ZrResourceSwitch data = new ZrResourceSwitch();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setResourceName(rs.getString(index++));
    data.setReserveId(rs.getString(index++));
    data.setActionCode(rs.getString(index++));
    data.setActionDesc(rs.getString(index++));
    data.setStageName(rs.getString(index++));
    data.setStageDesc(rs.getString(index++));
    data.setSwitchDeviceBo(rs.getString(index++));
    data.setSwitchDeviceName(rs.getString(index++));
    data.setSwitchOperationBo(rs.getString(index++));
    data.setSwitchOperationName(rs.getString(index++));
    data.setSwitchSfcBo(rs.getString(index++));
    data.setSwitchSfcName(rs.getString(index++));
    data.setReserveSfcBo(rs.getString(index++));
    data.setReserveSfcName(rs.getString(index++));
    data.setReserveDeviceBo(rs.getString(index++));
    data.setReserveDeviceName(rs.getString(index++));
    data.setReserveOperationBo(rs.getString(index++));
    data.setReserveOperationName(rs.getString(index++));
    data.setBuyoffSfcBo(rs.getString(index++));
    data.setBuyoffSfcName(rs.getString(index++));
    data.setBuyoffResourceBo(rs.getString(index++));
    data.setBuyoffResourceName(rs.getString(index++));
    data.setBuyoffOperationBo(rs.getString(index++));
    data.setBuyoffOperationName(rs.getString(index++));
    data.setBuyoffResult(rs.getString(index++));
    data.setBeforeSfcBo(rs.getString(index++));
    data.setBeforeSfcName(rs.getString(index++));
    data.setBeforeDeviceBo(rs.getString(index++));
    data.setBeforeDeviceName(rs.getString(index++));
    data.setBeforeOperationBo(rs.getString(index++));
    data.setBeforeOperationName(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
