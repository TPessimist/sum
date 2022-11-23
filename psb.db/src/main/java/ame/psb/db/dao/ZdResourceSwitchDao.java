package ame.psb.db.dao;

import ame.psb.db.ZdResourceSwitch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZdResourceSwitchDao {

  private static final String SQL_INS = "INSERT INTO zd_resource_switch(resource_bo,resource_name,reserve_id,stage_name,stage_desc,switch_device_bo,switch_device_name,switch_operation_bo,switch_operation_name,switch_sfc_bo,switch_sfc_name,reserve_sfc_bo,reserve_sfc_name,reserve_device_bo,reserve_device_name,reserve_operation_bo,reserve_operation_name,buyoff_sfc_bo,buyoff_sfc_name,buyoff_resource_bo,buyoff_resource_name,buyoff_operation_bo,buyoff_operation_name,buyoff_result,before_sfc_bo,before_sfc_name,before_device_bo,before_device_name,before_operation_bo,before_operation_name,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_resource_switch SET resource_name=?,reserve_id=?,stage_name=?,stage_desc=?,switch_device_bo=?,switch_device_name=?,switch_operation_bo=?,switch_operation_name=?,switch_sfc_bo=?,switch_sfc_name=?,reserve_sfc_bo=?,reserve_sfc_name=?,reserve_device_bo=?,reserve_device_name=?,reserve_operation_bo=?,reserve_operation_name=?,buyoff_sfc_bo=?,buyoff_sfc_name=?,buyoff_resource_bo=?,buyoff_resource_name=?,buyoff_operation_bo=?,buyoff_operation_name=?,buyoff_result=?,before_sfc_bo=?,before_sfc_name=?,before_device_bo=?,before_device_name=?,before_operation_bo=?,before_operation_name=?,update_user=?,update_time=? WHERE resource_bo=?";

  private static final String SQL_SEL = "SELECT resource_bo,resource_name,reserve_id,stage_name,stage_desc,switch_device_bo,switch_device_name,switch_operation_bo,switch_operation_name,switch_sfc_bo,switch_sfc_name,reserve_sfc_bo,reserve_sfc_name,reserve_device_bo,reserve_device_name,reserve_operation_bo,reserve_operation_name,buyoff_sfc_bo,buyoff_sfc_name,buyoff_resource_bo,buyoff_resource_name,buyoff_operation_bo,buyoff_operation_name,buyoff_result,before_sfc_bo,before_sfc_name,before_device_bo,before_device_name,before_operation_bo,before_operation_name,update_user,update_time FROM zd_resource_switch ";

  private final Connection conn;

  public ZdResourceSwitchDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdResourceSwitch data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getResourceName());
      ps.setString(3, data.getReserveId());
      ps.setString(4, data.getStageName());
      ps.setString(5, data.getStageDesc());
      ps.setString(6, data.getSwitchDeviceBo());
      ps.setString(7, data.getSwitchDeviceName());
      ps.setString(8, data.getSwitchOperationBo());
      ps.setString(9, data.getSwitchOperationName());
      ps.setString(10, data.getSwitchSfcBo());
      ps.setString(11, data.getSwitchSfcName());
      ps.setString(12, data.getReserveSfcBo());
      ps.setString(13, data.getReserveSfcName());
      ps.setString(14, data.getReserveDeviceBo());
      ps.setString(15, data.getReserveDeviceName());
      ps.setString(16, data.getReserveOperationBo());
      ps.setString(17, data.getReserveOperationName());
      ps.setString(18, data.getBuyoffSfcBo());
      ps.setString(19, data.getBuyoffSfcName());
      ps.setString(20, data.getBuyoffResourceBo());
      ps.setString(21, data.getBuyoffResourceName());
      ps.setString(22, data.getBuyoffOperationBo());
      ps.setString(23, data.getBuyoffOperationName());
      ps.setString(24, data.getBuyoffResult());
      ps.setString(25, data.getBeforeSfcBo());
      ps.setString(26, data.getBeforeSfcName());
      ps.setString(27, data.getBeforeDeviceBo());
      ps.setString(28, data.getBeforeDeviceName());
      ps.setString(29, data.getBeforeOperationBo());
      ps.setString(30, data.getBeforeOperationName());
      ps.setString(31, data.getUpdateUser());
      DateUtils.setDateTz(ps, 32, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdResourceSwitch> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdResourceSwitch data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getResourceName());
        ps.setString(3, data.getReserveId());
        ps.setString(4, data.getStageName());
        ps.setString(5, data.getStageDesc());
        ps.setString(6, data.getSwitchDeviceBo());
        ps.setString(7, data.getSwitchDeviceName());
        ps.setString(8, data.getSwitchOperationBo());
        ps.setString(9, data.getSwitchOperationName());
        ps.setString(10, data.getSwitchSfcBo());
        ps.setString(11, data.getSwitchSfcName());
        ps.setString(12, data.getReserveSfcBo());
        ps.setString(13, data.getReserveSfcName());
        ps.setString(14, data.getReserveDeviceBo());
        ps.setString(15, data.getReserveDeviceName());
        ps.setString(16, data.getReserveOperationBo());
        ps.setString(17, data.getReserveOperationName());
        ps.setString(18, data.getBuyoffSfcBo());
        ps.setString(19, data.getBuyoffSfcName());
        ps.setString(20, data.getBuyoffResourceBo());
        ps.setString(21, data.getBuyoffResourceName());
        ps.setString(22, data.getBuyoffOperationBo());
        ps.setString(23, data.getBuyoffOperationName());
        ps.setString(24, data.getBuyoffResult());
        ps.setString(25, data.getBeforeSfcBo());
        ps.setString(26, data.getBeforeSfcName());
        ps.setString(27, data.getBeforeDeviceBo());
        ps.setString(28, data.getBeforeDeviceName());
        ps.setString(29, data.getBeforeOperationBo());
        ps.setString(30, data.getBeforeOperationName());
        ps.setString(31, data.getUpdateUser());
        DateUtils.setDateTz(ps, 32, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZdResourceSwitch data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceName());
      ps.setString(2, data.getReserveId());
      ps.setString(3, data.getStageName());
      ps.setString(4, data.getStageDesc());
      ps.setString(5, data.getSwitchDeviceBo());
      ps.setString(6, data.getSwitchDeviceName());
      ps.setString(7, data.getSwitchOperationBo());
      ps.setString(8, data.getSwitchOperationName());
      ps.setString(9, data.getSwitchSfcBo());
      ps.setString(10, data.getSwitchSfcName());
      ps.setString(11, data.getReserveSfcBo());
      ps.setString(12, data.getReserveSfcName());
      ps.setString(13, data.getReserveDeviceBo());
      ps.setString(14, data.getReserveDeviceName());
      ps.setString(15, data.getReserveOperationBo());
      ps.setString(16, data.getReserveOperationName());
      ps.setString(17, data.getBuyoffSfcBo());
      ps.setString(18, data.getBuyoffSfcName());
      ps.setString(19, data.getBuyoffResourceBo());
      ps.setString(20, data.getBuyoffResourceName());
      ps.setString(21, data.getBuyoffOperationBo());
      ps.setString(22, data.getBuyoffOperationName());
      ps.setString(23, data.getBuyoffResult());
      ps.setString(24, data.getBeforeSfcBo());
      ps.setString(25, data.getBeforeSfcName());
      ps.setString(26, data.getBeforeDeviceBo());
      ps.setString(27, data.getBeforeDeviceName());
      ps.setString(28, data.getBeforeOperationBo());
      ps.setString(29, data.getBeforeOperationName());
      ps.setString(30, data.getUpdateUser());
      DateUtils.setDateTz(ps, 31, data.getUpdateTime());
      ps.setString(32, data.getResourceBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZdResourceSwitch> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZdResourceSwitch data : dataList) {
        ps.setString(1, data.getResourceName());
        ps.setString(2, data.getReserveId());
        ps.setString(3, data.getStageName());
        ps.setString(4, data.getStageDesc());
        ps.setString(5, data.getSwitchDeviceBo());
        ps.setString(6, data.getSwitchDeviceName());
        ps.setString(7, data.getSwitchOperationBo());
        ps.setString(8, data.getSwitchOperationName());
        ps.setString(9, data.getSwitchSfcBo());
        ps.setString(10, data.getSwitchSfcName());
        ps.setString(11, data.getReserveSfcBo());
        ps.setString(12, data.getReserveSfcName());
        ps.setString(13, data.getReserveDeviceBo());
        ps.setString(14, data.getReserveDeviceName());
        ps.setString(15, data.getReserveOperationBo());
        ps.setString(16, data.getReserveOperationName());
        ps.setString(17, data.getBuyoffSfcBo());
        ps.setString(18, data.getBuyoffSfcName());
        ps.setString(19, data.getBuyoffResourceBo());
        ps.setString(20, data.getBuyoffResourceName());
        ps.setString(21, data.getBuyoffOperationBo());
        ps.setString(22, data.getBuyoffOperationName());
        ps.setString(23, data.getBuyoffResult());
        ps.setString(24, data.getBeforeSfcBo());
        ps.setString(25, data.getBeforeSfcName());
        ps.setString(26, data.getBeforeDeviceBo());
        ps.setString(27, data.getBeforeDeviceName());
        ps.setString(28, data.getBeforeOperationBo());
        ps.setString(29, data.getBeforeOperationName());
        ps.setString(30, data.getUpdateUser());
        DateUtils.setDateTz(ps, 31, data.getUpdateTime());
        ps.setString(32, data.getResourceBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resourceBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_resource_switch WHERE resource_bo=?")) {
      ps.setString(1, resourceBo);

      return ps.executeUpdate();
    }
  }

  public List<ZdResourceSwitch> selectAll() throws SQLException {
    ArrayList<ZdResourceSwitch> result = new ArrayList<ZdResourceSwitch>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZdResourceSwitch selectByPK(String resourceBo) throws SQLException {
    ZdResourceSwitch result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_bo=?")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ZdResourceSwitch selectByReserveSfcBo(String reserveSfcBo) throws SQLException {
    ZdResourceSwitch result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE reserve_sfc_bo=?")) {
      ps.setString(1, reserveSfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ZdResourceSwitch selectByBuyoffSfcBo(String buyoffSfcBo) throws SQLException {
    ZdResourceSwitch result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE buyoff_sfc_bo=?")) {
      ps.setString(1, buyoffSfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public ZdResourceSwitch selectByResourceName(String resourceName) throws SQLException {
    ZdResourceSwitch result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_name=?")) {
      ps.setString(1, resourceName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZdResourceSwitch convert(ResultSet rs) throws SQLException {
    ZdResourceSwitch data = new ZdResourceSwitch();

    int index = 1;
    data.setResourceBo(rs.getString(index++));
    data.setResourceName(rs.getString(index++));
    data.setReserveId(rs.getString(index++));
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
