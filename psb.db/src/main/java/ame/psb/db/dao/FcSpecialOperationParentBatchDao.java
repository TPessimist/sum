package ame.psb.db.dao;

import ame.psb.db.FcSpecialOperationParentBatch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FcSpecialOperationParentBatchDao {

  private static final String SQL_INS = "INSERT INTO zr_fc_special_operation_parent_batch(sfc_bo,batch_id,operation,batch_qty,defect_qty,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_fc_special_operation_parent_batch SET operation=?,batch_qty=?,defect_qty=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE sfc_bo=? AND batch_id=?";

  private static final String SQL_SEL = "SELECT sfc_bo,batch_id,operation,batch_qty,defect_qty,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_fc_special_operation_parent_batch ";

  private final Connection conn;

  public FcSpecialOperationParentBatchDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FcSpecialOperationParentBatch data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getBatchId());
      ps.setString(3, data.getOperation());
      ps.setBigDecimal(4, data.getBatchQty());
      ps.setBigDecimal(5, data.getDefectQty());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FcSpecialOperationParentBatch> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FcSpecialOperationParentBatch data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getBatchId());
        ps.setString(3, data.getOperation());
        ps.setBigDecimal(4, data.getBatchQty());
        ps.setBigDecimal(5, data.getDefectQty());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FcSpecialOperationParentBatch data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getOperation());
      ps.setBigDecimal(2, data.getBatchQty());
      ps.setBigDecimal(3, data.getDefectQty());
      ps.setString(4, data.getReversedField1());
      ps.setString(5, data.getReversedField2());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getSfcBo());
      ps.setString(9, data.getBatchId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FcSpecialOperationParentBatch> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FcSpecialOperationParentBatch data : dataList) {
        ps.setString(1, data.getOperation());
        ps.setBigDecimal(2, data.getBatchQty());
        ps.setBigDecimal(3, data.getDefectQty());
        ps.setString(4, data.getReversedField1());
        ps.setString(5, data.getReversedField2());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getSfcBo());
        ps.setString(9, data.getBatchId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateAll(FcSpecialOperationParentBatch data) throws SQLException {
    int result = this.update(data);
    return result == 1 ? result : this.insert(data);
  }

  public int delete(String sfcBo, String batchId) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_fc_special_operation_parent_batch WHERE sfc_bo=? AND batch_id=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, batchId);

      return ps.executeUpdate();
    }
  }

  public List<FcSpecialOperationParentBatch> selectAll() throws SQLException {
    ArrayList<FcSpecialOperationParentBatch> result = new ArrayList<FcSpecialOperationParentBatch>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FcSpecialOperationParentBatch selectByPK(String sfcBo, String batchId)
      throws SQLException {
    FcSpecialOperationParentBatch result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND batch_id=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, batchId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<FcSpecialOperationParentBatch> selectBySfc(String sfcBo) throws SQLException {
    List<FcSpecialOperationParentBatch> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=?  ORDER BY DEFECT_QTY DESC")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private FcSpecialOperationParentBatch convert(ResultSet rs) throws SQLException {
    FcSpecialOperationParentBatch data = new FcSpecialOperationParentBatch();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setBatchId(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setBatchQty(rs.getBigDecimal(index++));
    data.setDefectQty(rs.getBigDecimal(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
