package ame.psb.db.dao;

import ame.psb.db.DeviceSetUpOperationBuyOffResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class DeviceSetUpOperationBuyOffResultDao {

  private static final String SQL_INS = "INSERT INTO zd_device_set_up_operation_buyoff_result(item_group_bo,set_up_operation_bo,device_buy_off_result,current_buy_off_sfc_type,CURRENT_BUY_OFF_SFC_TYPE_RESULT,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_device_set_up_operation_buyoff_result SET device_buy_off_result=?,current_buy_off_sfc_type=?,CURRENT_BUY_OFF_SFC_TYPE_RESULT=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE item_group_bo=? AND set_up_operation_bo=?";

  private static final String SQL_SEL = "SELECT item_group_bo,set_up_operation_bo,device_buy_off_result,current_buy_off_sfc_type,CURRENT_BUY_OFF_SFC_TYPE_RESULT,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_device_set_up_operation_buyoff_result ";

  private final Connection conn;

  public DeviceSetUpOperationBuyOffResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DeviceSetUpOperationBuyOffResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getSetUpOperationBo());
      ps.setString(3, data.getDeviceBuyOffResult());
      ps.setString(4, data.getCurrentBuyOffSfcType());
      ps.setString(5, data.getCurrentBuyOffSfcType_result());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DeviceSetUpOperationBuyOffResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DeviceSetUpOperationBuyOffResult data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getSetUpOperationBo());
        ps.setString(3, data.getDeviceBuyOffResult());
        ps.setString(4, data.getCurrentBuyOffSfcType());
        ps.setString(5, data.getCurrentBuyOffSfcType_result());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DeviceSetUpOperationBuyOffResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDeviceBuyOffResult());
      ps.setString(2, data.getCurrentBuyOffSfcType());
      ps.setString(3, data.getCurrentBuyOffSfcType_result());
      ps.setString(4, data.getReversedField1());
      ps.setString(5, data.getReversedField2());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getItemGroupBo());
      ps.setString(9, data.getSetUpOperationBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<DeviceSetUpOperationBuyOffResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DeviceSetUpOperationBuyOffResult data : dataList) {
        ps.setString(1, data.getDeviceBuyOffResult());
        ps.setString(2, data.getCurrentBuyOffSfcType());
        ps.setString(3, data.getCurrentBuyOffSfcType_result());
        ps.setString(4, data.getReversedField1());
        ps.setString(5, data.getReversedField2());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getItemGroupBo());
        ps.setString(9, data.getSetUpOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemGroupBo, String setUpOperationBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_device_set_up_operation_buyoff_result WHERE item_group_bo=? AND set_up_operation_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, setUpOperationBo);

      return ps.executeUpdate();
    }
  }

  public List<DeviceSetUpOperationBuyOffResult> selectAll() throws SQLException {
    ArrayList<DeviceSetUpOperationBuyOffResult> result = new ArrayList<DeviceSetUpOperationBuyOffResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public DeviceSetUpOperationBuyOffResult selectByPK(String itemGroupBo, String setUpOperationBo)
      throws SQLException {
    DeviceSetUpOperationBuyOffResult result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? AND set_up_operation_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, setUpOperationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<DeviceSetUpOperationBuyOffResult> selectByPK(String itemGroupBo) throws SQLException {
    List<DeviceSetUpOperationBuyOffResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE item_group_bo=? ")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<DeviceSetUpOperationBuyOffResult> selectAllByResult(String deviceBuyOffResult)
      throws SQLException {
    List<DeviceSetUpOperationBuyOffResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE device_buy_off_result=? ")) {
      ps.setString(1, deviceBuyOffResult);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private DeviceSetUpOperationBuyOffResult convert(ResultSet rs) throws SQLException {
    DeviceSetUpOperationBuyOffResult data = new DeviceSetUpOperationBuyOffResult();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setSetUpOperationBo(rs.getString(index++));
    data.setDeviceBuyOffResult(rs.getString(index++));
    data.setCurrentBuyOffSfcType(rs.getString(index++));
    data.setCurrentBuyOffSfcType_result(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
