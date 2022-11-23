package ame.psb.db.dao;

import ame.psb.db.FCBatchOperationDefect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class FCBatchOperationDefectDao {

  private static final String SQL_INS = "INSERT INTO zr_fc_batch_operation_defect(batch_id,operation_bo,nc_code_bo,nc_value,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_fc_batch_operation_defect SET nc_value=?,updated_user=?,updated_time=? WHERE batch_id=? AND operation_bo=? AND nc_code_bo=?";

  private static final String SQL_SEL = "SELECT batch_id,operation_bo,nc_code_bo,nc_value,updated_user,updated_time FROM zr_fc_batch_operation_defect ";

  private final Connection conn;

  public FCBatchOperationDefectDao(Connection conn) {
    this.conn = conn;
  }

  public int insertOrUpdate(FCBatchOperationDefect data) throws SQLException {
    FCBatchOperationDefect fcBatchOperationDefect = this
        .selectByPK(data.getBatchId(), data.getOperationBo(), data.getNcCodeBo());
    if (null == fcBatchOperationDefect) {
      return this.insert(data);
    } else {
      return this.update(data);
    }

  }

  public int insert(FCBatchOperationDefect data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getBatchId());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getNcCodeBo());
      ps.setBigDecimal(4, data.getNcValue());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FCBatchOperationDefect> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FCBatchOperationDefect data : dataList) {
        ps.setString(1, data.getBatchId());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getNcCodeBo());
        ps.setBigDecimal(4, data.getNcValue());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FCBatchOperationDefect data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getNcValue());
      ps.setString(2, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
      ps.setString(4, data.getBatchId());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getNcCodeBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<FCBatchOperationDefect> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FCBatchOperationDefect data : dataList) {
        ps.setBigDecimal(1, data.getNcValue());
        ps.setString(2, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
        ps.setString(4, data.getBatchId());
        ps.setString(5, data.getOperationBo());
        ps.setString(6, data.getNcCodeBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String batchId, String operationBo, String ncCodeBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_fc_batch_operation_defect WHERE batch_id=? AND operation_bo=? AND nc_code_bo=?")) {
      ps.setString(1, batchId);
      ps.setString(2, operationBo);
      ps.setString(3, ncCodeBo);

      return ps.executeUpdate();
    }
  }

  public List<FCBatchOperationDefect> selectAll() throws SQLException {
    ArrayList<FCBatchOperationDefect> result = new ArrayList<FCBatchOperationDefect>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<FCBatchOperationDefect> selectScrapByBatchAndOperation(String batchId,
      String OperationBo) throws SQLException {
    String[] defects = {"FRAMESHAPEERRORSCRAPDIEQTY", "UPLOOKSCRAPDIEQTY", "MISSINGSCRAPDIEQTY"};
    Where where = new Where()
        .eq("BATCH_ID", batchId)
        .eq("OPERATION_BO", OperationBo)
        .in("NC_CODE_BO", defects);
    return this.select(where);
  }

  public List<FCBatchOperationDefect> select(Where where) throws SQLException {
    ArrayList<FCBatchOperationDefect> result = new ArrayList<FCBatchOperationDefect>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public FCBatchOperationDefect selectByPK(String batchId, String operationBo, String ncCodeBo)
      throws SQLException {
    FCBatchOperationDefect result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE batch_id=? AND operation_bo=? AND nc_code_bo=?")) {
      ps.setString(1, batchId);
      ps.setString(2, operationBo);
      ps.setString(3, ncCodeBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public FCBatchOperationDefect selectByLatest(String batchId, String ncCodeBo)
      throws SQLException {
    FCBatchOperationDefect result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE batch_id=? AND nc_code_bo=? order by UPDATED_TIME desc")) {
      ps.setString(1, batchId);
      ps.setString(2, ncCodeBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private FCBatchOperationDefect convert(ResultSet rs) throws SQLException {
    FCBatchOperationDefect data = new FCBatchOperationDefect();

    int index = 1;
    data.setBatchId(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setNcCodeBo(rs.getString(index++));
    data.setNcValue(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
