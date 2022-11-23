package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.DeviceBuyOffConditionResult;
import uia.utils.dao.DateUtils;

public class DeviceBuyOffConditionResultDao {

  private static final String SQL_INS = "INSERT INTO zr_device_operation_buyoff_condition_result(condition_bo,sfc_bo,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_device_operation_buyoff_condition_result SET reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE condition_bo=? AND sfc_bo=?";

  private static final String SQL_SEL = "SELECT condition_bo,sfc_bo,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_device_operation_buyoff_condition_result ";

  private final Connection conn;

  public DeviceBuyOffConditionResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DeviceBuyOffConditionResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getConditionBo());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getReversedField1());
      ps.setString(4, data.getReversedField2());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DeviceBuyOffConditionResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DeviceBuyOffConditionResult data : dataList) {
        ps.setString(1, data.getConditionBo());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getReversedField1());
        ps.setString(4, data.getReversedField2());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DeviceBuyOffConditionResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getReversedField1());
      ps.setString(2, data.getReversedField2());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getConditionBo());
      ps.setString(6, data.getSfcBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<DeviceBuyOffConditionResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DeviceBuyOffConditionResult data : dataList) {
        ps.setString(1, data.getReversedField1());
        ps.setString(2, data.getReversedField2());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getConditionBo());
        ps.setString(6, data.getSfcBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String conditionBo, String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_device_operation_buyoff_condition_result WHERE condition_bo=? AND sfc_bo=?")) {
      ps.setString(1, conditionBo);
      ps.setString(2, sfcBo);

      return ps.executeUpdate();
    }
  }

  public List<DeviceBuyOffConditionResult> selectAll() throws SQLException {
    ArrayList<DeviceBuyOffConditionResult> result = new ArrayList<DeviceBuyOffConditionResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public DeviceBuyOffConditionResult selectByPK(String conditionBo, String sfcBo)
      throws SQLException {
    DeviceBuyOffConditionResult result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE condition_bo=? AND sfc_bo=?")) {
      ps.setString(1, conditionBo);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<DeviceBuyOffConditionResult> selectByPKConditionBo(String conditionBo)
      throws SQLException {
    List<DeviceBuyOffConditionResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE condition_bo=? ")) {
      ps.setString(1, conditionBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private DeviceBuyOffConditionResult convert(ResultSet rs) throws SQLException {
    DeviceBuyOffConditionResult data = new DeviceBuyOffConditionResult();

    int index = 1;
    data.setConditionBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
