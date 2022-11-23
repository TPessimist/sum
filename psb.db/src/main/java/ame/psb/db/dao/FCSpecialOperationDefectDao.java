package ame.psb.db.dao;

import ame.psb.db.FCSpecialOperationDefect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FCSpecialOperationDefectDao {

  private static final String SQL_INS = "INSERT INTO zr_fc_special_operation_defect(batch_id,current_operation,latest_special_operation,batch_good_die_qty,batch_bad_die_qty,batch_strip_qty,batch_good_strip_qty,batch_sfc_qty,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_fc_special_operation_defect SET current_operation=?,batch_good_die_qty=?,batch_bad_die_qty=?,batch_strip_qty=?,batch_good_strip_qty=?,batch_sfc_qty=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE batch_id=? AND latest_special_operation=?";

  private static final String SQL_SEL = "SELECT batch_id,current_operation,latest_special_operation,batch_good_die_qty,batch_bad_die_qty,batch_strip_qty,batch_good_strip_qty,batch_sfc_qty,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_fc_special_operation_defect ";

  private final Connection conn;

  public FCSpecialOperationDefectDao(Connection conn) {
    this.conn = conn;
  }

  public int insertOrUpdate(FCSpecialOperationDefect data) throws SQLException {
    FCSpecialOperationDefect fcSpecialOperationDefect = selectByPK(data.getBatchId(),
        data.getLatestSpecialOperation());
    if (null != fcSpecialOperationDefect) {
      return update(data);
    } else {
      return insert(data);
    }
  }


  public int insert(FCSpecialOperationDefect data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getBatchId());
      ps.setString(2, data.getCurrentOperation());
      ps.setString(3, data.getLatestSpecialOperation());
      ps.setBigDecimal(4, data.getBatchGoodDieQty());
      ps.setBigDecimal(5, data.getBatchBadDieQty());
      ps.setBigDecimal(6, data.getBatchStripQty());
      ps.setBigDecimal(7, data.getBatchGoodStripQty());
      ps.setBigDecimal(8, data.getBatchSfcQty());
      ps.setString(9, data.getReversedField1());
      ps.setString(10, data.getReversedField2());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FCSpecialOperationDefect> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FCSpecialOperationDefect data : dataList) {
        ps.setString(1, data.getBatchId());
        ps.setString(2, data.getCurrentOperation());
        ps.setString(3, data.getLatestSpecialOperation());
        ps.setBigDecimal(4, data.getBatchGoodDieQty());
        ps.setBigDecimal(5, data.getBatchBadDieQty());
        ps.setBigDecimal(6, data.getBatchStripQty());
        ps.setBigDecimal(7, data.getBatchGoodStripQty());
        ps.setBigDecimal(8, data.getBatchSfcQty());
        ps.setString(9, data.getReversedField1());
        ps.setString(10, data.getReversedField2());
        ps.setString(11, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FCSpecialOperationDefect data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCurrentOperation());
      ps.setBigDecimal(2, data.getBatchGoodDieQty());
      ps.setBigDecimal(3, data.getBatchBadDieQty());
      ps.setBigDecimal(4, data.getBatchStripQty());
      ps.setBigDecimal(5, data.getBatchGoodStripQty());
      ps.setBigDecimal(6, data.getBatchSfcQty());
      ps.setString(7, data.getReversedField1());
      ps.setString(8, data.getReversedField2());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
      ps.setString(11, data.getBatchId());
      ps.setString(12, data.getLatestSpecialOperation());

      return ps.executeUpdate();
    }
  }

  public int update(List<FCSpecialOperationDefect> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FCSpecialOperationDefect data : dataList) {
        ps.setString(1, data.getCurrentOperation());
        ps.setBigDecimal(2, data.getBatchGoodDieQty());
        ps.setBigDecimal(3, data.getBatchBadDieQty());
        ps.setBigDecimal(4, data.getBatchStripQty());
        ps.setBigDecimal(5, data.getBatchGoodStripQty());
        ps.setBigDecimal(6, data.getBatchSfcQty());
        ps.setString(7, data.getReversedField1());
        ps.setString(8, data.getReversedField2());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
        ps.setString(11, data.getBatchId());
        ps.setString(12, data.getLatestSpecialOperation());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String batchId, String latestSpecialOperation) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_fc_special_operation_defect WHERE batch_id=? AND latest_special_operation=?")) {
      ps.setString(1, batchId);
      ps.setString(2, latestSpecialOperation);

      return ps.executeUpdate();
    }
  }

  public List<FCSpecialOperationDefect> selectAll() throws SQLException {
    ArrayList<FCSpecialOperationDefect> result = new ArrayList<FCSpecialOperationDefect>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FCSpecialOperationDefect selectByFCDABatchIdAndLastOperation(String batchId)
      throws SQLException {
    FCSpecialOperationDefect result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE batch_id=? AND latest_special_operation in  ('OperationBO:1020,CPKGS-4OI,#','OperationBO:1020,CTF2-FS,#') ")) {
      ps.setString(1, batchId);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public FCSpecialOperationDefect selectByPK(String batchId, String latestSpecialOperation)
      throws SQLException {
    FCSpecialOperationDefect result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE batch_id=? AND latest_special_operation=?")) {
      ps.setString(1, batchId);
      ps.setString(2, latestSpecialOperation);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FCSpecialOperationDefect convert(ResultSet rs) throws SQLException {
    FCSpecialOperationDefect data = new FCSpecialOperationDefect();

    int index = 1;
    data.setBatchId(rs.getString(index++));
    data.setCurrentOperation(rs.getString(index++));
    data.setLatestSpecialOperation(rs.getString(index++));
    data.setBatchGoodDieQty(rs.getBigDecimal(index++));
    data.setBatchBadDieQty(rs.getBigDecimal(index++));
    data.setBatchStripQty(rs.getBigDecimal(index++));
    data.setBatchGoodStripQty(rs.getBigDecimal(index++));
    data.setBatchSfcQty(rs.getBigDecimal(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
