package ame.psb.db.dao;

import ame.psb.db.RunSblResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunSblResultDao {

  private static final String SQL_INS = "INSERT INTO zr_sbl_result(customer_item_bo,sfc_bo,item_group_bo,operation_bo,nc_code,nc_value,wafer_ucl,wafer_lcl,lot_ucl,lot_lcl,updated_user,updated_time,remarks) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_sbl_result SET sfc_bo=?,item_group_bo=?,nc_value=?,wafer_ucl=?,wafer_lcl=?,lot_ucl=?,lot_lcl=?,updated_user=?,updated_time=?,remarks=? WHERE customer_item_bo=? AND operation_bo=? AND nc_code=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,sfc_bo,item_group_bo,operation_bo,nc_code,nc_value,wafer_ucl,wafer_lcl,lot_ucl,lot_lcl,updated_user,updated_time,remarks FROM zr_sbl_result ";

  private final Connection conn;

  public RunSblResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunSblResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getItemGroupBo());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getNcCode());
      ps.setBigDecimal(6, data.getNcValue());
      ps.setBigDecimal(7, data.getWaferUcl());
      ps.setBigDecimal(8, data.getWaferLcl());
      ps.setBigDecimal(9, data.getLotUcl());
      ps.setBigDecimal(10, data.getLotLcl());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
      ps.setString(13, data.getRemarks());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunSblResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunSblResult data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getItemGroupBo());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getNcCode());
        ps.setBigDecimal(6, data.getNcValue());
        ps.setBigDecimal(7, data.getWaferUcl());
        ps.setBigDecimal(8, data.getWaferLcl());
        ps.setBigDecimal(9, data.getLotUcl());
        ps.setBigDecimal(10, data.getLotLcl());
        ps.setString(11, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
        ps.setString(13, data.getRemarks());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunSblResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getItemGroupBo());
      ps.setBigDecimal(3, data.getNcValue());
      ps.setBigDecimal(4, data.getWaferUcl());
      ps.setBigDecimal(5, data.getWaferLcl());
      ps.setBigDecimal(6, data.getLotUcl());
      ps.setBigDecimal(7, data.getLotLcl());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getRemarks());
      ps.setString(11, data.getCustomerItemBo());
      ps.setString(12, data.getOperationBo());
      ps.setString(13, data.getNcCode());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunSblResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunSblResult data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getItemGroupBo());
        ps.setBigDecimal(3, data.getNcValue());
        ps.setBigDecimal(4, data.getWaferUcl());
        ps.setBigDecimal(5, data.getWaferLcl());
        ps.setBigDecimal(6, data.getLotUcl());
        ps.setBigDecimal(7, data.getLotLcl());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getRemarks());
        ps.setString(11, data.getCustomerItemBo());
        ps.setString(12, data.getOperationBo());
        ps.setString(13, data.getNcCode());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerItemBo, String operationBo, String ncCode) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_sbl_result WHERE customer_item_bo=? AND operation_bo=? AND nc_code=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);
      ps.setString(3, ncCode);

      return ps.executeUpdate();
    }
  }

  public int delete(String customerItemBo, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_sbl_result WHERE customer_item_bo=? AND operation_bo=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);

      return ps.executeUpdate();
    }
  }

  public List<RunSblResult> selectAll() throws SQLException {
    ArrayList<RunSblResult> result = new ArrayList<RunSblResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public RunSblResult selectByPK(String customerItemBo, String operationBo, String ncCode)
      throws SQLException {
    RunSblResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE customer_item_bo=? AND operation_bo=? AND nc_code=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);
      ps.setString(3, ncCode);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private RunSblResult convert(ResultSet rs) throws SQLException {
    RunSblResult data = new RunSblResult();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setNcCode(rs.getString(index++));
    data.setNcValue(rs.getBigDecimal(index++));
    data.setWaferUcl(rs.getBigDecimal(index++));
    data.setWaferLcl(rs.getBigDecimal(index++));
    data.setLotUcl(rs.getBigDecimal(index++));
    data.setLotLcl(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setRemarks(rs.getString(index++));

    return data;
  }
}
