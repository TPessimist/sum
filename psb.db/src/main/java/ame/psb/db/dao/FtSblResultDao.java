package ame.psb.db.dao;

import ame.psb.db.FtSblResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FtSblResultDao {

  private static final String SQL_INS = "INSERT INTO zr_ft_sbl_result(batch_id,sfc_bo,item_group_bo,operation_bo,sbl_param_bo,sbl_param_desc,sbl_file_sourece,sbl_file_type,sbl_formula,sbl_usl,sbl_lsl,memo,sbl_value,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_ft_sbl_result SET sfc_bo=?,sbl_param_desc=?,sbl_file_sourece=?,sbl_file_type=?,sbl_formula=?,sbl_usl=?,sbl_lsl=?,memo=?,sbl_value=?,updated_user=?,updated_time=? WHERE batch_id=? AND item_group_bo=? AND operation_bo=? AND sbl_param_bo=?";

  private static final String SQL_SEL = "SELECT batch_id,sfc_bo,item_group_bo,operation_bo,sbl_param_bo,sbl_param_desc,sbl_file_sourece,sbl_file_type,sbl_formula,sbl_usl,sbl_lsl,memo,sbl_value,updated_user,updated_time FROM zr_ft_sbl_result ";

  private final Connection conn;

  public FtSblResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FtSblResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getBatchId());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getItemGroupBo());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getSblParamBo());
      ps.setString(6, data.getSblParamDesc());
      ps.setString(7, data.getSblFileSourece());
      ps.setString(8, data.getSblFileType());
      ps.setString(9, data.getSblFormula());
      ps.setBigDecimal(10, data.getSblUsl());
      ps.setBigDecimal(11, data.getSblLsl());
      ps.setString(12, data.getMemo());
      ps.setBigDecimal(13, data.getSblValue());
      ps.setString(14, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 15, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FtSblResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FtSblResult data : dataList) {
        ps.setString(1, data.getBatchId());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getItemGroupBo());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getSblParamBo());
        ps.setString(6, data.getSblParamDesc());
        ps.setString(7, data.getSblFileSourece());
        ps.setString(8, data.getSblFileType());
        ps.setString(9, data.getSblFormula());
        ps.setBigDecimal(10, data.getSblUsl());
        ps.setBigDecimal(11, data.getSblLsl());
        ps.setString(12, data.getMemo());
        ps.setBigDecimal(13, data.getSblValue());
        ps.setString(14, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 15, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FtSblResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getSblParamDesc());
      ps.setString(3, data.getSblFileSourece());
      ps.setString(4, data.getSblFileType());
      ps.setString(5, data.getSblFormula());
      ps.setBigDecimal(6, data.getSblUsl());
      ps.setBigDecimal(7, data.getSblLsl());
      ps.setString(8, data.getMemo());
      ps.setBigDecimal(9, data.getSblValue());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
      ps.setString(12, data.getBatchId());
      ps.setString(13, data.getItemGroupBo());
      ps.setString(14, data.getOperationBo());
      ps.setString(15, data.getSblParamBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<FtSblResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FtSblResult data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getSblParamDesc());
        ps.setString(3, data.getSblFileSourece());
        ps.setString(4, data.getSblFileType());
        ps.setString(5, data.getSblFormula());
        ps.setBigDecimal(6, data.getSblUsl());
        ps.setBigDecimal(7, data.getSblLsl());
        ps.setString(8, data.getMemo());
        ps.setBigDecimal(9, data.getSblValue());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
        ps.setString(12, data.getBatchId());
        ps.setString(13, data.getItemGroupBo());
        ps.setString(14, data.getOperationBo());
        ps.setString(15, data.getSblParamBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String batchId, String itemGroupBo, String operationBo, String sblParamBo)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_ft_sbl_result WHERE batch_id=? AND item_group_bo=? AND operation_bo=? AND sbl_param_bo=?")) {
      ps.setString(1, batchId);
      ps.setString(2, itemGroupBo);
      ps.setString(3, operationBo);
      ps.setString(4, sblParamBo);

      return ps.executeUpdate();
    }
  }

  public List<FtSblResult> selectAll() throws SQLException {
    ArrayList<FtSblResult> result = new ArrayList<FtSblResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<FtSblResult> selectBySfcName(String sfcName) throws SQLException {
    ArrayList<FtSblResult> result = new ArrayList<FtSblResult>();
    sfcName = "SFCBO:1020," + sfcName;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where sfc_bo  = ?")) {
      ps.setString(1, sfcName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public FtSblResult selectBySfcBo(String sfcBo, String sblParamBo, String operationBo)
      throws SQLException {
    FtSblResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "where sfc_bo  = ? and SBL_PARAM_BO = ? and OPERATION_BO = ? ORDER BY  UPDATED_TIME DESC ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, sblParamBo);
      ps.setString(3, operationBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public FtSblResult selectByPK(String batchId, String itemGroupBo, String operationBo,
      String sblParamBo) throws SQLException {
    FtSblResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE batch_id=? AND item_group_bo=? AND operation_bo=? AND sbl_param_bo=?")) {
      ps.setString(1, batchId);
      ps.setString(2, itemGroupBo);
      ps.setString(3, operationBo);
      ps.setString(4, sblParamBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FtSblResult convert(ResultSet rs) throws SQLException {
    FtSblResult data = new FtSblResult();

    int index = 1;
    data.setBatchId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setSblParamBo(rs.getString(index++));
    data.setSblParamDesc(rs.getString(index++));
    data.setSblFileSourece(rs.getString(index++));
    data.setSblFileType(rs.getString(index++));
    data.setSblFormula(rs.getString(index++));
    data.setSblUsl(rs.getBigDecimal(index++));
    data.setSblLsl(rs.getBigDecimal(index++));
    data.setMemo(rs.getString(index++));
    data.setSblValue(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
