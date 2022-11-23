package ame.psb.db.dao;

import ame.psb.db.DeviceBuyOffBumpingResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import uia.utils.dao.DateUtils;

public class DeviceBuyOffBumpingResultDao {

  private static final String SQL_INS = "INSERT INTO zr_device_buyoff_bumping_result(id,item_group_bo,opertion_bo,sfc_bo,dcop_group_bo,dcop_value,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_device_buyoff_bumping_result SET item_group_bo=?,opertion_bo=?,sfc_bo=?,dcop_group_bo=?,dcop_value=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,item_group_bo,opertion_bo,sfc_bo,dcop_group_bo,dcop_value,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_device_buyoff_bumping_result ";

  private final Connection conn;

  public DeviceBuyOffBumpingResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DeviceBuyOffBumpingResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getItemGroupBo());
      ps.setString(3, data.getOpertionBo());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getDcopGroupBo());
      ps.setString(6, data.getDcopValue());
      ps.setString(7, data.getReversedField1());
      ps.setString(8, data.getReversedField2());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DeviceBuyOffBumpingResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DeviceBuyOffBumpingResult data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getItemGroupBo());
        ps.setString(3, data.getOpertionBo());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getDcopGroupBo());
        ps.setString(6, data.getDcopValue());
        ps.setString(7, data.getReversedField1());
        ps.setString(8, data.getReversedField2());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DeviceBuyOffBumpingResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getOpertionBo());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getDcopGroupBo());
      ps.setString(5, data.getDcopValue());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<DeviceBuyOffBumpingResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DeviceBuyOffBumpingResult data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getOpertionBo());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getDcopGroupBo());
        ps.setString(5, data.getDcopValue());
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
        .prepareStatement("DELETE FROM zr_device_buyoff_bumping_result WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<DeviceBuyOffBumpingResult> selectAll() throws SQLException {
    ArrayList<DeviceBuyOffBumpingResult> result = new ArrayList<DeviceBuyOffBumpingResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public DeviceBuyOffBumpingResult selectByPK(String id) throws SQLException {
    DeviceBuyOffBumpingResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }
  public List<DeviceBuyOffBumpingResult> selectByPK(String sfcBO, String opertionBo)
      throws SQLException {
    List<DeviceBuyOffBumpingResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo =? and OPERTION_BO = ? ")) {
      ps.setString(1, sfcBO);
      ps.setString(2, opertionBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  public List<DeviceBuyOffBumpingResult> selectByPKByItemGroupBoAndOpertionBo(String itemGroupBo, String opertionBo)
      throws SQLException {
    List<DeviceBuyOffBumpingResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO =? and OPERTION_BO = ? ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, opertionBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  public List<DeviceBuyOffBumpingResult> selectByPKByitemGroupBoAndopertionBo(String itemGroupBo, String opertionBo)
      throws SQLException {
    List<DeviceBuyOffBumpingResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO =? and OPERTION_BO = ? ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, opertionBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  public DeviceBuyOffBumpingResult selectByPK(String sfcBO, String opertionBo, String dcopGroupBo)
      throws SQLException {
    DeviceBuyOffBumpingResult result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo =? and OPERTION_BO = ? and DCOP_GROUP_BO = ?")) {
      ps.setString(1, sfcBO);
      ps.setString(2, opertionBo);
      ps.setString(3, dcopGroupBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }
  public List<DeviceBuyOffBumpingResult> selectByPKItemGroupBo(String itemGroupBo)
      throws SQLException {
    List<DeviceBuyOffBumpingResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO = ?")) {
      ps.setString(1, itemGroupBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  private DeviceBuyOffBumpingResult convert(ResultSet rs) throws SQLException {
    DeviceBuyOffBumpingResult data = new DeviceBuyOffBumpingResult();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOpertionBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setDcopGroupBo(rs.getString(index++));
    data.setDcopValue(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
