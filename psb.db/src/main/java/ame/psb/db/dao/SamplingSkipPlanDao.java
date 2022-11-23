package ame.psb.db.dao;

import ame.psb.db.SamplingSkipPlan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SamplingSkipPlanDao {

  private static final String SQL_INS = "INSERT INTO zd_sampling_skip_plan(id,process_operation_bo,insp_operation_bo,group_size,updated_user,updated_time,check_rule,state) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_sampling_skip_plan SET id=?,group_size=?,updated_user=?,updated_time=?,check_rule=?,state=? WHERE process_operation_bo=? AND insp_operation_bo=?";

  private static final String SQL_SEL = "SELECT id,process_operation_bo,insp_operation_bo,group_size,updated_user,updated_time,check_rule,state FROM zd_sampling_skip_plan ";

  private final Connection conn;

  public SamplingSkipPlanDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SamplingSkipPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getProcessOperationBo());
      ps.setString(3, data.getInspOperationBo());
      ps.setString(4, data.getGroupSize());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getCheckRule());
      ps.setString(8, data.getState());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SamplingSkipPlan> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SamplingSkipPlan data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getProcessOperationBo());
        ps.setString(3, data.getInspOperationBo());
        ps.setString(4, data.getGroupSize());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getCheckRule());
        ps.setString(8, data.getState());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SamplingSkipPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getGroupSize());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getCheckRule());
      ps.setString(6, data.getState());
      ps.setString(7, data.getProcessOperationBo());
      ps.setString(8, data.getInspOperationBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<SamplingSkipPlan> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SamplingSkipPlan data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getGroupSize());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getCheckRule());
        ps.setString(6, data.getState());
        ps.setString(7, data.getProcessOperationBo());
        ps.setString(8, data.getInspOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String processOperationBo, String inspOperationBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_sampling_skip_plan WHERE process_operation_bo=? AND insp_operation_bo=?")) {
      ps.setString(1, processOperationBo);
      ps.setString(2, inspOperationBo);

      return ps.executeUpdate();
    }
  }

  public List<SamplingSkipPlan> selectAll() throws SQLException {
    ArrayList<SamplingSkipPlan> result = new ArrayList<SamplingSkipPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SamplingSkipPlan selectByPK(String processOperationBo, String inspOperationBo)
      throws SQLException {
    SamplingSkipPlan result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE process_operation_bo=? AND insp_operation_bo=?")) {
      ps.setString(1, processOperationBo);
      ps.setString(2, inspOperationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public List<SamplingSkipPlan> selectByCurrentOperation(String processOperationBo)
      throws SQLException {
    ArrayList<SamplingSkipPlan> result = new ArrayList<SamplingSkipPlan>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE PROCESS_OPERATION_BO = ? ")) {
      ps.setString(1, processOperationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SamplingSkipPlan> selectByInspOperation(String inspOperationBo) throws SQLException {
    ArrayList<SamplingSkipPlan> result = new ArrayList<SamplingSkipPlan>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE INSP_OPERATION_BO = ? ")) {
      ps.setString(1, inspOperationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  private SamplingSkipPlan convert(ResultSet rs) throws SQLException {
    SamplingSkipPlan data = new SamplingSkipPlan();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setProcessOperationBo(rs.getString(index++));
    data.setInspOperationBo(rs.getString(index++));
    data.setGroupSize(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setCheckRule(rs.getString(index++));
    data.setState(rs.getString(index++));

    return data;
  }
}
