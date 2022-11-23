package ame.psb.db.dao;

import ame.psb.db.DeviceBuyOffWLPResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class DeviceBuyOffWLPResultDao {


  private static final String SQL_INS = "INSERT INTO zr_device_buyoff_wlp_result(id,item_group_bo,opertion_bo,sfc_bo,param_bo,param_value,reversed_field1,reversed_field2,updated_user,updated_time,npi_position,pe_position) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_device_buyoff_wlp_result SET item_group_bo=?,opertion_bo=?,sfc_bo=?,param_bo=?,param_value=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=?,npi_position=?,pe_position=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,item_group_bo,opertion_bo,sfc_bo,param_bo,param_value,reversed_field1,reversed_field2,updated_user,updated_time,npi_position,pe_position FROM zr_device_buyoff_wlp_result ";


  private final Connection conn;

  public DeviceBuyOffWLPResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DeviceBuyOffWLPResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getItemGroupBo());
      ps.setString(3, data.getOpertionBo());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getParamBo());
      ps.setString(6, data.getParamValue());
      ps.setString(7, data.getReversedField1());
      ps.setString(8, data.getReversedField2());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
      ps.setString(11, data.getNpiPosition());
      ps.setString(12, data.getPePosition());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DeviceBuyOffWLPResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DeviceBuyOffWLPResult data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getItemGroupBo());
        ps.setString(3, data.getOpertionBo());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getParamBo());
        ps.setString(6, data.getParamValue());
        ps.setString(7, data.getReversedField1());
        ps.setString(8, data.getReversedField2());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
        ps.setString(11, data.getNpiPosition());
        ps.setString(12, data.getPePosition());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DeviceBuyOffWLPResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getOpertionBo());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getParamBo());
      ps.setString(5, data.getParamValue());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getNpiPosition());
      ps.setString(11, data.getPePosition());
      ps.setString(12, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<DeviceBuyOffWLPResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DeviceBuyOffWLPResult data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getOpertionBo());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getParamBo());
        ps.setString(5, data.getParamValue());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getNpiPosition());
        ps.setString(11, data.getPePosition());
        ps.setString(12, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_device_buyoff_wlp_result WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<DeviceBuyOffWLPResult> selectAll() throws SQLException {
    ArrayList<DeviceBuyOffWLPResult> result = new ArrayList<DeviceBuyOffWLPResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public DeviceBuyOffWLPResult selectByPK(String id) throws SQLException {
    DeviceBuyOffWLPResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<DeviceBuyOffWLPResult> selectByPKItemGroupBo(String itemGroupBo, String sfcBo,
      String opertionBo) throws SQLException {
    List<DeviceBuyOffWLPResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO=? and SFC_BO =? and OPERTION_BO =?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, sfcBo);
      ps.setString(3, opertionBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<DeviceBuyOffWLPResult> selectByPKItemGroupBo(String itemGroupBo) throws SQLException {
    List<DeviceBuyOffWLPResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO=? ")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<DeviceBuyOffWLPResult> selectByPKItemGroupBo(String itemGroupBo, String opertionBo)
      throws SQLException {
    List<DeviceBuyOffWLPResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO=? and OPERTION_BO =?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, opertionBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<DeviceBuyOffWLPResult> selectByPKItemGroupBoParamBo(String itemGroupBo,
      String opertionBo, String paramBo) throws SQLException {
    List<DeviceBuyOffWLPResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO=? and OPERTION_BO =? and param_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, opertionBo);
      ps.setString(3, paramBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public DeviceBuyOffWLPResult selectByDeviceAndSfcAndOperationAndParam(String itemGroupBo,
      String opertionBo, String sfcBo, String paramBo) throws SQLException {
    DeviceBuyOffWLPResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "WHERE ITEM_GROUP_BO=? and OPERTION_BO =? and sfc_bo=? and param_bo=? order by updated_time desc")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, opertionBo);
      ps.setString(3, sfcBo);
      ps.setString(4, paramBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private DeviceBuyOffWLPResult convert(ResultSet rs) throws SQLException {
    DeviceBuyOffWLPResult data = new DeviceBuyOffWLPResult();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOpertionBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setParamBo(rs.getString(index++));
    data.setParamValue(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setNpiPosition(rs.getString(index++));
    data.setPePosition(rs.getString(index++));

    return data;
  }
}
