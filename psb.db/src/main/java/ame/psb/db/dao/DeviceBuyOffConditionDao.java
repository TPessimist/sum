package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.DeviceBuyOffCondition;
import uia.utils.dao.DateUtils;

public class DeviceBuyOffConditionDao {

  private static final String SQL_INS = "INSERT INTO zd_device_operation_buyoff_condition(id,item_group_bo,operation_bo,sfc_type,sfc_qty,state_name,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_device_operation_buyoff_condition SET item_group_bo=?,operation_bo=?,sfc_type=?,sfc_qty=?,state_name=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,item_group_bo,operation_bo,sfc_type,sfc_qty,state_name,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_device_operation_buyoff_condition ";

  private final Connection conn;

  public DeviceBuyOffConditionDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DeviceBuyOffCondition data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getItemGroupBo());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getSfcType());
      ps.setBigDecimal(5, data.getSfcQty());
      ps.setString(6, data.getStateName());
      ps.setString(7, data.getReversedField1());
      ps.setString(8, data.getReversedField2());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DeviceBuyOffCondition> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DeviceBuyOffCondition data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getItemGroupBo());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getSfcType());
        ps.setBigDecimal(5, data.getSfcQty());
        ps.setString(6, data.getStateName());
        ps.setString(7, data.getReversedField1());
        ps.setString(8, data.getReversedField2());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DeviceBuyOffCondition data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getSfcType());
      ps.setBigDecimal(4, data.getSfcQty());
      ps.setString(5, data.getStateName());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<DeviceBuyOffCondition> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DeviceBuyOffCondition data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getSfcType());
        ps.setBigDecimal(4, data.getSfcQty());
        ps.setString(5, data.getStateName());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_device_operation_buyoff_condition WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<DeviceBuyOffCondition> selectAll() throws SQLException {
    ArrayList<DeviceBuyOffCondition> result = new ArrayList<DeviceBuyOffCondition>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public DeviceBuyOffCondition selectByPK(String id) throws SQLException {
    DeviceBuyOffCondition result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public DeviceBuyOffCondition selectByPK(String itemGroupBo, String operationBo, String sfcType) throws SQLException {
    DeviceBuyOffCondition result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO=? and OPERATION_BO = ? and SFC_TYPE= ?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, sfcType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }
  public List<DeviceBuyOffCondition> selectByPKByItemGroup(String itemGroupBo, String operationBo) throws SQLException {
    List<DeviceBuyOffCondition> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO=? and OPERATION_BO = ?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  public List<DeviceBuyOffCondition> selectByPKByItemGroup(String itemGroupBo) throws SQLException {
    List<DeviceBuyOffCondition> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO=? ")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  private DeviceBuyOffCondition convert(ResultSet rs) throws SQLException {
    DeviceBuyOffCondition data = new DeviceBuyOffCondition();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setSfcType(rs.getString(index++));
    data.setSfcQty(rs.getBigDecimal(index++));
    data.setStateName(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
