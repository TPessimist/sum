package ame.psb.db.dao;

import ame.psb.db.DeviceOperationSetting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class DeviceOperationSettingDao {

  private static final String SQL_INS = "INSERT INTO zd_device_operation_setting(item_group_bo,operation_bo,setting_type,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_device_operation_setting SET reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE item_group_bo=? AND operation_bo=? AND setting_type=?";

  private static final String SQL_SEL = "SELECT item_group_bo,operation_bo,setting_type,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_device_operation_setting ";

  private final Connection conn;

  public DeviceOperationSettingDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DeviceOperationSetting data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getSettingType());
      ps.setString(4, data.getReversedField1());
      ps.setString(5, data.getReversedField2());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DeviceOperationSetting> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DeviceOperationSetting data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getSettingType());
        ps.setString(4, data.getReversedField1());
        ps.setString(5, data.getReversedField2());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DeviceOperationSetting data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getReversedField1());
      ps.setString(2, data.getReversedField2());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getItemGroupBo());
      ps.setString(6, data.getOperationBo());
      ps.setString(7, data.getSettingType());

      return ps.executeUpdate();
    }
  }

  public int update(List<DeviceOperationSetting> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DeviceOperationSetting data : dataList) {
        ps.setString(1, data.getReversedField1());
        ps.setString(2, data.getReversedField2());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getItemGroupBo());
        ps.setString(6, data.getOperationBo());
        ps.setString(7, data.getSettingType());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemGroupBo, String operationBo, String settingType)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_device_operation_setting WHERE item_group_bo=? AND operation_bo=? AND setting_type=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, settingType);

      return ps.executeUpdate();
    }
  }

  public List<DeviceOperationSetting> selectAll() throws SQLException {
    ArrayList<DeviceOperationSetting> result = new ArrayList<DeviceOperationSetting>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public DeviceOperationSetting selectByPK(String itemGroupBo, String operationBo,
      String settingType) throws SQLException {
    DeviceOperationSetting result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? AND operation_bo=? AND setting_type=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, settingType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<DeviceOperationSetting> selectByItemGroupBoAndOperation(String itemGroupBo,
      String operationBo) throws SQLException {
    ArrayList<DeviceOperationSetting> result = new ArrayList<DeviceOperationSetting>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? AND operation_bo=? ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<DeviceOperationSetting> selectByItemGroupBo(String itemGroupBo)
      throws SQLException {
    ArrayList<DeviceOperationSetting> result = new ArrayList<DeviceOperationSetting>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? ")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<DeviceOperationSetting> selectByItemGroupBoAndType(String itemGroupBo,
      String settingType) throws SQLException {
    ArrayList<DeviceOperationSetting> result = new ArrayList<DeviceOperationSetting>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? AND setting_type=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, settingType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private DeviceOperationSetting convert(ResultSet rs) throws SQLException {
    DeviceOperationSetting data = new DeviceOperationSetting();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setSettingType(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
