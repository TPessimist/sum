package ame.psb.db.dao;

import ame.psb.db.SamplingResult;
import ame.psb.db.ViewSamplingResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SamplingResultDao {

  private static final String SQL_INS = "INSERT INTO zr_sampling_result(id,sampling_plan_bo,source_operation_bo,measurement_operation_bo,dc_group_bo,carrier_bo,sfc_bo,customer_bo,item_group_bo,item_bo,lot_type,sampling_type,position,status,dc_plan_bo,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_sampling_result SET sampling_plan_bo=?,measurement_operation_bo=?,dc_group_bo=?,carrier_bo=?,sfc_bo=?,customer_bo=?,item_group_bo=?,item_bo=?,lot_type=?,sampling_type=?,position=?,status=?,dc_plan_bo=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sampling_plan_bo,source_operation_bo,measurement_operation_bo,dc_group_bo,carrier_bo,sfc_bo,customer_bo,item_group_bo,item_bo,lot_type,sampling_type,position,status,dc_plan_bo,updated_time FROM view_sampling_result ";

  private final Connection conn;

  public SamplingResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SamplingResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSamplingPlanBo());
      ps.setString(3, data.getSourceOperationBo());
      ps.setString(4, data.getMeasurementOperationBo());
      ps.setString(5, data.getDcGroupBo());
      ps.setString(6, data.getCarrierBo());
      ps.setString(7, data.getSfcBo());
      ps.setString(8, data.getCustomerBo());
      ps.setString(9, data.getItemGroupBo());
      ps.setString(10, data.getItemBo());
      ps.setString(11, data.getLotType());
      ps.setString(12, data.getSamplingType());
      ps.setString(13, data.getPosition());
      ps.setString(14, data.getStatus());
      ps.setString(15, data.getDcPlanBo());
      DateUtils.setDateTz(ps, 16, new Date());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SamplingResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SamplingResult data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSamplingPlanBo());
        ps.setString(3, data.getSourceOperationBo());
        ps.setString(4, data.getMeasurementOperationBo());
        ps.setString(5, data.getDcGroupBo());
        ps.setString(6, data.getCarrierBo());
        ps.setString(7, data.getSfcBo());
        ps.setString(8, data.getCustomerBo());
        ps.setString(9, data.getItemGroupBo());
        ps.setString(10, data.getItemBo());
        ps.setString(11, data.getLotType());
        ps.setString(12, data.getSamplingType());
        ps.setString(13, data.getPosition());
        ps.setString(14, data.getStatus());
        ps.setString(15, data.getDcPlanBo());
        DateUtils.setDateTz(ps, 16, new Date());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SamplingResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSamplingPlanBo());
      ps.setString(2, data.getMeasurementOperationBo());
      ps.setString(3, data.getDcGroupBo());
      ps.setString(4, data.getCarrierBo());
      ps.setString(5, data.getSfcBo());
      ps.setString(6, data.getCustomerBo());
      ps.setString(7, data.getItemGroupBo());
      ps.setString(8, data.getItemBo());
      ps.setString(9, data.getLotType());
      ps.setString(10, data.getSamplingType());
      ps.setString(11, data.getPosition());
      ps.setString(12, data.getStatus());
      ps.setString(13, data.getDcPlanBo());
      DateUtils.setDateTz(ps, 14, new Date());
      ps.setString(15, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<SamplingResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SamplingResult data : dataList) {
        ps.setString(1, data.getSamplingPlanBo());
        ps.setString(2, data.getMeasurementOperationBo());
        ps.setString(3, data.getDcGroupBo());
        ps.setString(4, data.getCarrierBo());
        ps.setString(5, data.getSfcBo());
        ps.setString(6, data.getCustomerBo());
        ps.setString(7, data.getItemGroupBo());
        ps.setString(8, data.getItemBo());
        ps.setString(9, data.getLotType());
        ps.setString(10, data.getSamplingType());
        ps.setString(11, data.getPosition());
        ps.setString(12, data.getStatus());
        ps.setString(13, data.getDcPlanBo());
        DateUtils.setDateTz(ps, 14, new Date());
        ps.setString(15, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int expire(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_sampling_result SET status='EXPIRED' WHERE id = ? AND status='WAIT'")) {
      ps.setString(1, id);
      return ps.executeUpdate();
    }
  }

  public int expireSfc(String operationBo, String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_sampling_result SET status='EXPIRED' WHERE measurement_operation_bo = ? AND sfc_bo=?  AND status='WAIT'")) {
      ps.setString(1, operationBo);
      ps.setString(2, sfcBo);
      return ps.executeUpdate();
    }
  }

  public int expireCarrier(String operationBo, String carrierBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_sampling_result SET status='EXPIRED' WHERE measurement_operation_bo = ? AND carrier_bo=?  AND status='WAIT'")) {
      ps.setString(1, operationBo);
      ps.setString(1, carrierBo);
      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_sampling_result WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<SamplingResult> selectAll() throws SQLException {
    ArrayList<SamplingResult> result = new ArrayList<SamplingResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewSamplingResult selectByPK(String id) throws SQLException {
    ViewSamplingResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ArrayList<ViewSamplingResult> selectOpSfc(String operationBo, String sfcBo)
      throws SQLException {
    ArrayList<ViewSamplingResult> result = new ArrayList<ViewSamplingResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE measurement_operation_bo=? AND sfc_bo=? AND STATUS='WAIT'")) {
      ps.setObject(1, operationBo);
      ps.setObject(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSamplingResult> selectOpCarrier(String operationBo, String carrierBo)
      throws SQLException {
    ArrayList<ViewSamplingResult> result = new ArrayList<ViewSamplingResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE measurement_operation_bo=? AND carrier_bo=? AND STATUS='WAIT'")) {
      ps.setObject(1, operationBo);
      ps.setObject(2, carrierBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  /*
   * cc
   * */
  public List<ViewSamplingResult> selectOpCarrierCustomer(String operationBo, String carrierBo,
      String customer)
      throws SQLException {
    ArrayList<ViewSamplingResult> result = new ArrayList<ViewSamplingResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "WHERE measurement_operation_bo=? AND carrier_bo=? AND customer_bo=? AND STATUS='WAIT' order by updated_time desc limit 1 ")) {
      ps.setObject(1, operationBo);
      ps.setObject(2, carrierBo);
      ps.setObject(3, customer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ArrayList<ViewSamplingResult> selectOpSfcDc(String operationBo, String sfcBo,
      String dcGroupBo) throws SQLException {
    ArrayList<ViewSamplingResult> result = new ArrayList<ViewSamplingResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE measurement_operation_bo=? AND sfc_bo=? AND dc_group_bo=? AND STATUS='WAIT'")) {
      ps.setObject(1, operationBo);
      ps.setObject(2, sfcBo);
      ps.setObject(3, dcGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSamplingResult> selectOpCarrierDc(String operationBo, String carrierBo,
      String dcGroupBo) throws SQLException {
    ArrayList<ViewSamplingResult> result = new ArrayList<ViewSamplingResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE measurement_operation_bo=? AND carrier_bo=? AND dc_group_bo=? AND STATUS='WAIT'")) {
      ps.setObject(1, operationBo);
      ps.setObject(2, carrierBo);
      ps.setObject(3, dcGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSamplingResult> selectByOperation(String operationBo) throws SQLException {
    ArrayList<ViewSamplingResult> result = new ArrayList<ViewSamplingResult>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE measurement_operation_bo=? AND STATUS='WAIT'")) {
      ps.setObject(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSamplingResult> selectEffectedByOperation(String operationBo)
      throws SQLException {
    ArrayList<ViewSamplingResult> result = new ArrayList<ViewSamplingResult>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE measurement_operation_bo=? AND STATUS <> 'EXPIRED'")) {
      ps.setObject(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSamplingResult> selectEffectedByCarrierBo(String operationBo, String carrierBo)
      throws SQLException {
    ArrayList<ViewSamplingResult> result = new ArrayList<ViewSamplingResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE measurement_operation_bo=? AND STATUS <> 'EXPIRED' and carrier_bo = ?")) {
      ps.setObject(1, operationBo);
      ps.setObject(2, carrierBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSamplingResult> selectEffectedBySfcBo(String operationBo, String sfcBo)
      throws SQLException {
    ArrayList<ViewSamplingResult> result = new ArrayList<ViewSamplingResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE measurement_operation_bo=? AND STATUS <> 'EXPIRED' and sfc_bo = ?")) {
      ps.setObject(1, operationBo);
      ps.setObject(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewSamplingResult selectByDcPlan(String id) throws SQLException {
    ViewSamplingResult result = new ViewSamplingResult();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE dc_plan_bo=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewSamplingResult selectByFiveParam(String dcPlanBo, String carrierBo, String deviceBo,
      String operationBo, String lotType, String samplingPlanBo) throws SQLException {
    ViewSamplingResult result = new ViewSamplingResult();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE dc_plan_bo=? and carrier_bo=? and item_group_bo=? and measurement_operation_bo=? and lot_type=? and sampling_plan_bo=? and status='WAIT' ")) {
      ps.setString(1, dcPlanBo);
      ps.setString(2, carrierBo);
      ps.setString(3, deviceBo);
      ps.setString(4, operationBo);
      ps.setString(5, lotType);
      ps.setString(6, samplingPlanBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ViewSamplingResult convert(ResultSet rs) throws SQLException {
    ViewSamplingResult data = new ViewSamplingResult();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSamplingPlanBo(rs.getString(index++));
    data.setSourceOperationBo(rs.getString(index++));
    data.setMeasurementOperationBo(rs.getString(index++));
    data.setDcGroupBo(rs.getString(index++));
    data.setCarrierBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setCustomerBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setLotType(rs.getString(index++));
    data.setSamplingType(rs.getString(index++));
    data.setPosition(rs.getString(index++));
    data.setStatus(rs.getString(index++));
    data.setDcPlanBo(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}