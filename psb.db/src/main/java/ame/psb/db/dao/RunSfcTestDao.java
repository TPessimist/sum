package ame.psb.db.dao;

import ame.psb.db.RunSfcTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunSfcTestDao {

  private static final String SQL_INS = "INSERT INTO zr_run_sfc_test(sfc_step_bo,sfc_bo,resource_bo,tester_id,operation_bo,updated_user,updated_time,run_sfc_bo,tester_recipe) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_run_sfc_test SET sfc_bo=?,resource_bo=?,tester_id=?,operation_bo=?,updated_user=?,updated_time=?,tester_recipe=? WHERE sfc_step_bo=? and run_sfc_bo=?";

  private static final String SQL_SEL = "SELECT sfc_step_bo,sfc_bo,resource_bo,tester_id,operation_bo,updated_user,updated_time,run_sfc_bo,tester_recipe FROM zr_run_sfc_test ";

  private final Connection conn;

  public RunSfcTestDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunSfcTest data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcStepBo());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getResourceBo());
      ps.setString(4, data.getTesterId());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getRunSfcBo());
      ps.setString(9, data.getTesterRecipe());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunSfcTest> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunSfcTest data : dataList) {
        ps.setString(1, data.getSfcStepBo());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getResourceBo());
        ps.setString(4, data.getTesterId());
        ps.setString(5, data.getOperationBo());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getRunSfcBo());
        ps.setString(9, data.getTesterRecipe());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunSfcTest data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getTesterId());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getTesterRecipe());
      ps.setString(8, data.getSfcStepBo());
      ps.setString(9, data.getRunSfcBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunSfcTest> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunSfcTest data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getTesterId());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getTesterRecipe());
        ps.setString(8, data.getSfcStepBo());
        ps.setString(9, data.getRunSfcBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String sfcStepBo, String runSfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_run_sfc_test WHERE sfc_step_bo=? and run_sfc_bo=?")) {
      ps.setString(1, sfcStepBo);
      ps.setString(2, runSfcBo);

      return ps.executeUpdate();
    }
  }

  public List<RunSfcTest> selectAll() throws SQLException {
    ArrayList<RunSfcTest> result = new ArrayList<RunSfcTest>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public RunSfcTest selectByPK(String sfcStepBo) throws SQLException {
    RunSfcTest result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_step_bo=?")) {
      ps.setString(1, sfcStepBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public RunSfcTest selectByPK(String sfcStepBo, String runSfcBo) throws SQLException {
    RunSfcTest result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_step_bo=? and run_sfc_bo=?")) {
      ps.setString(1, sfcStepBo);
      ps.setString(2, runSfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  /*
   * cc
   * */
  public RunSfcTest selectByRunSfcBo(String runSfcBo) throws SQLException {
    RunSfcTest result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE run_sfc_bo=?")) {
      ps.setString(1, runSfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  private RunSfcTest convert(ResultSet rs) throws SQLException {
    RunSfcTest data = new RunSfcTest();

    int index = 1;
    data.setSfcStepBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setTesterId(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setRunSfcBo(rs.getString(index++));
    data.setTesterRecipe(rs.getString(index++));
    return data;
  }
}
