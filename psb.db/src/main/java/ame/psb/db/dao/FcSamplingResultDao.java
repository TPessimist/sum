package ame.psb.db.dao;

import ame.psb.db.FcSamplingResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FcSamplingResultDao {

  private static final String SQL_INS = "INSERT INTO zr_fc_sampling_result(id,batch_id,split_operation_bo,nc_code,sfc_name,sampling_job,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_fc_sampling_result SET batch_id=?,split_operation_bo=?,nc_code=?,sfc_name=?,sampling_job=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,batch_id,split_operation_bo,nc_code,sfc_name,sampling_job,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_fc_sampling_result ";

  private final Connection conn;

  public FcSamplingResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FcSamplingResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getBatchId());
      ps.setString(3, data.getSplitOperationBo());
      ps.setString(4, data.getNcCode());
      ps.setString(5, data.getSfcName());
      ps.setString(6, data.getSamplingJob());
      ps.setString(7, data.getReversedField1());
      ps.setString(8, data.getReversedField2());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FcSamplingResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FcSamplingResult data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getBatchId());
        ps.setString(3, data.getSplitOperationBo());
        ps.setString(4, data.getNcCode());
        ps.setString(5, data.getSfcName());
        ps.setString(6, data.getSamplingJob());
        ps.setString(7, data.getReversedField1());
        ps.setString(8, data.getReversedField2());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FcSamplingResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getBatchId());
      ps.setString(2, data.getSplitOperationBo());
      ps.setString(3, data.getNcCode());
      ps.setString(4, data.getSfcName());
      ps.setString(5, data.getSamplingJob());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FcSamplingResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FcSamplingResult data : dataList) {
        ps.setString(1, data.getBatchId());
        ps.setString(2, data.getSplitOperationBo());
        ps.setString(3, data.getNcCode());
        ps.setString(4, data.getSfcName());
        ps.setString(5, data.getSamplingJob());
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
        .prepareStatement("DELETE FROM zr_fc_sampling_result WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<FcSamplingResult> selectAll() throws SQLException {
    ArrayList<FcSamplingResult> result = new ArrayList<FcSamplingResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FcSamplingResult> selectByFcSamplingResult(FcSamplingResult data)
      throws SQLException {
    ArrayList<FcSamplingResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " where  BATCH_ID = ? AND SPLIT_OPERATION_BO = ? AND NC_CODE = ? AND SAMPLING_JOB = ? ")) {
      ps.setString(1, data.getBatchId());
      ps.setString(2, data.getSplitOperationBo());
      ps.setString(3, data.getNcCode());
      ps.setString(4, data.getSamplingJob());

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FcSamplingResult selectByPK(String id) throws SQLException {
    FcSamplingResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<FcSamplingResult> selectByBatchIdAndOperation(String batchId, String operationBo)
      throws SQLException {
    ArrayList<FcSamplingResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where batch_id = ? and split_operation_bo = ?")) {

      ps.setString(1, batchId);
      ps.setString(2, operationBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private FcSamplingResult convert(ResultSet rs) throws SQLException {
    FcSamplingResult data = new FcSamplingResult();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setBatchId(rs.getString(index++));
    data.setSplitOperationBo(rs.getString(index++));
    data.setNcCode(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setSamplingJob(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
