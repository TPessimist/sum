package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ZrRunFCBatch;
import uia.utils.dao.DateUtils;

public class ZrRunFCBatchDao {

  private static final String SQL_INS = "INSERT INTO zr_run_fc_batch(batch_id,operation_bo,operation_name,shop_order_bo,shop_order_name,final_batch,run_time,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_run_fc_batch SET operation_name=?,shop_order_bo=?,shop_order_name=?,final_batch=?,run_time=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE batch_id=? AND operation_bo=?";

  private static final String SQL_SEL = "SELECT batch_id,operation_bo,operation_name,shop_order_bo,shop_order_name,final_batch,run_time,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_run_fc_batch ";

  private final Connection conn;

  public ZrRunFCBatchDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZrRunFCBatch data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getBatchId());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getOperationName());
      ps.setString(4, data.getShopOrderBo());
      ps.setString(5, data.getShopOrderName());
      ps.setString(6, data.getFinalBatch());
      DateUtils.setDateTz(ps, 7, data.getRunTime());
      ps.setString(8, data.getReversedField1());
      ps.setString(9, data.getReversedField2());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZrRunFCBatch> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZrRunFCBatch data : dataList) {
        ps.setString(1, data.getBatchId());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getOperationName());
        ps.setString(4, data.getShopOrderBo());
        ps.setString(5, data.getShopOrderName());
        ps.setString(6, data.getFinalBatch());
        DateUtils.setDateTz(ps, 7, data.getRunTime());
        ps.setString(8, data.getReversedField1());
        ps.setString(9, data.getReversedField2());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZrRunFCBatch data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getOperationName());
      ps.setString(2, data.getShopOrderBo());
      ps.setString(3, data.getShopOrderName());
      ps.setString(4, data.getFinalBatch());
      DateUtils.setDateTz(ps, 5, data.getRunTime());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getBatchId());
      ps.setString(11, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZrRunFCBatch> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZrRunFCBatch data : dataList) {
        ps.setString(1, data.getOperationName());
        ps.setString(2, data.getShopOrderBo());
        ps.setString(3, data.getShopOrderName());
        ps.setString(4, data.getFinalBatch());
        DateUtils.setDateTz(ps, 5, data.getRunTime());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getBatchId());
        ps.setString(11, data.getOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String batchId, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_run_fc_batch WHERE batch_id=? AND operation_bo=?")) {
      ps.setString(1, batchId);
      ps.setString(2, operationBo);

      return ps.executeUpdate();
    }
  }

  public List<ZrRunFCBatch> selectAll() throws SQLException {
    ArrayList<ZrRunFCBatch> result = new ArrayList<ZrRunFCBatch>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZrRunFCBatch selectByPK(String batchId, String operationBo) throws SQLException {
    ZrRunFCBatch result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE batch_id=? AND operation_bo=?")) {
      ps.setString(1, batchId);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZrRunFCBatch> selectByShopOrder(String shopOrderBo, String operationBo)
      throws SQLException {
    ArrayList<ZrRunFCBatch> result = new ArrayList<ZrRunFCBatch>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE SHOP_ORDER_BO =? AND operation_bo=?")) {


      ps.setString(1, shopOrderBo);
      ps.setString(2, operationBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ZrRunFCBatch convert(ResultSet rs) throws SQLException {
    ZrRunFCBatch data = new ZrRunFCBatch();

    int index = 1;
    data.setBatchId(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setOperationName(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setFinalBatch(rs.getString(index++));
    data.setRunTime(DateUtils.getDateTz(rs, index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
