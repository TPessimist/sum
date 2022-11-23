package ame.psb.db.dao;

import ame.psb.db.RunDefect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunDefectDao {

  private static final String SQL_INS = "INSERT INTO zr_run_defect(id,sfc_bo,resource_bo,operation_bo,customer_item_bo,nc_code_bo,nc_value,run_user,run_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_SEL = "SELECT id,sfc_bo,resource_bo,operation_bo,customer_item_bo,nc_code_bo,nc_value,run_user,run_time FROM zr_run_defect ";

  private final Connection conn;

  public RunDefectDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunDefect data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getResourceBo());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getCustomerItemBo());
      ps.setString(6, data.getNcCodeBo());
      ps.setBigDecimal(7, data.getNcValue());
      ps.setString(8, data.getRunUser());
      DateUtils.setDateTz(ps, 9, data.getRunTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunDefect> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunDefect data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getResourceBo());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getCustomerItemBo());
        ps.setString(6, data.getNcCodeBo());
        ps.setBigDecimal(7, data.getNcValue());
        ps.setString(8, data.getRunUser());
        DateUtils.setDateTz(ps, 9, data.getRunTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public List<RunDefect> selectAll() throws SQLException {
    ArrayList<RunDefect> result = new ArrayList<RunDefect>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public RunDefect selectByPK(String id) throws SQLException {
    RunDefect result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private RunDefect convert(ResultSet rs) throws SQLException {
    RunDefect data = new RunDefect();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setNcCodeBo(rs.getString(index++));
    data.setNcValue(rs.getBigDecimal(index++));
    data.setRunUser(rs.getString(index++));
    data.setRunTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}