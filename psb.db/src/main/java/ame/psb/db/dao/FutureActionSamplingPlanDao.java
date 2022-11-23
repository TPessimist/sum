package ame.psb.db.dao;

import ame.psb.db.FutureActionSamplingPlan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FutureActionSamplingPlanDao {

  private static final String SQL_INS = "INSERT INTO zd_future_action_sampling_plan(id,future_action_bo,itemset_name,shop_order_bo,sfc_bo,item_name,lot_type,measurement_operation_bo,sampling_ratio_nmrtr,reset_cardinality,sampling_type,begin_qty,center_qty,end_qty,position,interval_qty,dc_group_bo,status,reset_total,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_future_action_sampling_plan SET future_action_bo=?,itemset_name=?,shop_order_bo=?,sfc_bo=?,item_name=?,lot_type=?,measurement_operation_bo=?,sampling_ratio_nmrtr=?,reset_cardinality=?,sampling_type=?,begin_qty=?,center_qty=?,end_qty=?,position=?,interval_qty=?,dc_group_bo=?,status=?,reset_total=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,future_action_bo,itemset_name,shop_order_bo,sfc_bo,item_name,lot_type,measurement_operation_bo,sampling_ratio_nmrtr,reset_cardinality,sampling_type,begin_qty,center_qty,end_qty,position,interval_qty,dc_group_bo,status,reset_total,updated_user,updated_time FROM zd_future_action_sampling_plan ";

  private final Connection conn;

  public FutureActionSamplingPlanDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FutureActionSamplingPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getFutureActionBo());
      ps.setString(3, data.getItemsetName());
      ps.setString(4, data.getShopOrderBo());
      ps.setString(5, data.getSfcBo());
      ps.setString(6, data.getItemName());
      ps.setString(7, data.getLotType());
      ps.setString(8, data.getMeasurementOperationBo());
      ps.setBigDecimal(9, data.getSamplingRatioNmrtr());
      ps.setBigDecimal(10, data.getResetCardinality());
      ps.setString(11, data.getSamplingType());
      ps.setBigDecimal(12, data.getBeginQty());
      ps.setBigDecimal(13, data.getCenterQty());
      ps.setBigDecimal(14, data.getEndQty());
      ps.setString(15, data.getPosition());
      ps.setBigDecimal(16, data.getIntervalQty());
      ps.setString(17, data.getDcGroupBo());
      ps.setString(18, data.getStatus());
      ps.setBigDecimal(19, data.getResetTotal());
      ps.setString(20, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 21, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FutureActionSamplingPlan> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FutureActionSamplingPlan data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getFutureActionBo());
        ps.setString(3, data.getItemsetName());
        ps.setString(4, data.getShopOrderBo());
        ps.setString(5, data.getSfcBo());
        ps.setString(6, data.getItemName());
        ps.setString(7, data.getLotType());
        ps.setString(8, data.getMeasurementOperationBo());
        ps.setBigDecimal(9, data.getSamplingRatioNmrtr());
        ps.setBigDecimal(10, data.getResetCardinality());
        ps.setString(11, data.getSamplingType());
        ps.setBigDecimal(12, data.getBeginQty());
        ps.setBigDecimal(13, data.getCenterQty());
        ps.setBigDecimal(14, data.getEndQty());
        ps.setString(15, data.getPosition());
        ps.setBigDecimal(16, data.getIntervalQty());
        ps.setString(17, data.getDcGroupBo());
        ps.setString(18, data.getStatus());
        ps.setBigDecimal(19, data.getResetTotal());
        ps.setString(20, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 21, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FutureActionSamplingPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFutureActionBo());
      ps.setString(2, data.getItemsetName());
      ps.setString(3, data.getShopOrderBo());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getItemName());
      ps.setString(6, data.getLotType());
      ps.setString(7, data.getMeasurementOperationBo());
      ps.setBigDecimal(8, data.getSamplingRatioNmrtr());
      ps.setBigDecimal(9, data.getResetCardinality());
      ps.setString(10, data.getSamplingType());
      ps.setBigDecimal(11, data.getBeginQty());
      ps.setBigDecimal(12, data.getCenterQty());
      ps.setBigDecimal(13, data.getEndQty());
      ps.setString(14, data.getPosition());
      ps.setBigDecimal(15, data.getIntervalQty());
      ps.setString(16, data.getDcGroupBo());
      ps.setString(17, data.getStatus());
      ps.setBigDecimal(18, data.getResetTotal());
      ps.setString(19, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 20, data.getUpdatedTime());
      ps.setString(21, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FutureActionSamplingPlan> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FutureActionSamplingPlan data : dataList) {
        ps.setString(1, data.getFutureActionBo());
        ps.setString(2, data.getItemsetName());
        ps.setString(3, data.getShopOrderBo());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getItemName());
        ps.setString(6, data.getLotType());
        ps.setString(7, data.getMeasurementOperationBo());
        ps.setBigDecimal(8, data.getSamplingRatioNmrtr());
        ps.setBigDecimal(9, data.getResetCardinality());
        ps.setString(10, data.getSamplingType());
        ps.setBigDecimal(11, data.getBeginQty());
        ps.setBigDecimal(12, data.getCenterQty());
        ps.setBigDecimal(13, data.getEndQty());
        ps.setString(14, data.getPosition());
        ps.setBigDecimal(15, data.getIntervalQty());
        ps.setString(16, data.getDcGroupBo());
        ps.setString(17, data.getStatus());
        ps.setBigDecimal(18, data.getResetTotal());
        ps.setString(19, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 20, data.getUpdatedTime());
        ps.setString(21, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_future_action_sampling_plan WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByFutureAction(String futureActionBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_future_action_sampling_plan WHERE future_action_bo=?")) {
      ps.setString(1, futureActionBo);

      return ps.executeUpdate();
    }
  }

  public List<FutureActionSamplingPlan> selectAll() throws SQLException {
    ArrayList<FutureActionSamplingPlan> result = new ArrayList<FutureActionSamplingPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FutureActionSamplingPlan selectByPK(String id) throws SQLException {
    FutureActionSamplingPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<FutureActionSamplingPlan> selectByFutureActionBo(String futureActionBo)
      throws SQLException {
    ArrayList<FutureActionSamplingPlan> result = new ArrayList<FutureActionSamplingPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE future_action_bo=?")) {
      ps.setString(1, futureActionBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public FutureActionSamplingPlan selectByLotAndOperation(String itemsetName, String lotType,
      String operationBo) throws SQLException {
    FutureActionSamplingPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE itemset_name=? AND lot_type=? AND measurement_operation_bo=? AND status='Y' ORDER BY updated_time DESC ")) {
      ps.setString(1, itemsetName);
      ps.setString(2, lotType);
      ps.setString(3, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FutureActionSamplingPlan selectByShopOrderAndOperation(String shopOrderBo,
      String lotType, String operationBo) throws SQLException {
    FutureActionSamplingPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE shop_order_bo=? AND lot_type=? AND measurement_operation_bo=? AND status='Y' ORDER BY updated_time DESC ")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, lotType);
      ps.setString(3, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FutureActionSamplingPlan selectByWaferAndOperation(String itemName,
      String lotType, String operationBo) throws SQLException {
    FutureActionSamplingPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE item_name=? AND lot_type=? AND measurement_operation_bo=? AND status='Y' ORDER BY updated_time DESC ")) {
      ps.setString(1, itemName);
      ps.setString(2, lotType);
      ps.setString(3, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FutureActionSamplingPlan selectBySfcAndOperation(String sfcBo,
      String lotType, String operationBo) throws SQLException {
    FutureActionSamplingPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE sfc_bo=? AND lot_type=? AND measurement_operation_bo=? AND status='Y' ORDER BY updated_time DESC ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, lotType);
      ps.setString(3, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FutureActionSamplingPlan convert(ResultSet rs) throws SQLException {
    FutureActionSamplingPlan data = new FutureActionSamplingPlan();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setFutureActionBo(rs.getString(index++));
    data.setItemsetName(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setLotType(rs.getString(index++));
    data.setMeasurementOperationBo(rs.getString(index++));
    data.setSamplingRatioNmrtr(rs.getBigDecimal(index++));
    data.setResetCardinality(rs.getBigDecimal(index++));
    data.setSamplingType(rs.getString(index++));
    data.setBeginQty(rs.getBigDecimal(index++));
    data.setCenterQty(rs.getBigDecimal(index++));
    data.setEndQty(rs.getBigDecimal(index++));
    data.setPosition(rs.getString(index++));
    data.setIntervalQty(rs.getBigDecimal(index++));
    data.setDcGroupBo(rs.getString(index++));
    data.setStatus(rs.getString(index++));
    data.setResetTotal(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
