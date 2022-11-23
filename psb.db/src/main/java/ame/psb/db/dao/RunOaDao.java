package ame.psb.db.dao;

import ame.psb.db.RunOa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunOaDao {

  private static final String SQL_INS = "INSERT INTO zr_run_oa(oa_id,action_name,action_content,updated_user,updated_time,state_name,sfcs) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_run_oa SET action_name=?,action_content=?,updated_user=?,updated_time=?,state_name=?,sfcs=? WHERE oa_id=?"; //,sfcs=?

  private static final String SQL_UPD_STATE = "UPDATE zr_run_oa SET state_name=? WHERE oa_id=?"; //,sfcs=?

  private static final String SQL_UPD_STATE_AND_UPDATE = "UPDATE zr_run_oa SET state_name=?, updated_time=? WHERE oa_id=?"; //,sfcs=?

  private static final String SQL_SEL = "SELECT oa_id,action_name,action_content,updated_user,updated_time,state_name,sfcs FROM zr_run_oa ";

  private final Connection conn;

  public RunOaDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunOa data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getOaId());
      ps.setString(2, data.getActionName());
      ps.setString(3, data.getActionContent());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getStateName());
      ps.setString(7, data.getSfcs());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunOa> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunOa data : dataList) {
        ps.setString(1, data.getOaId());
        ps.setString(2, data.getActionName());
        ps.setString(3, data.getActionContent());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getStateName());
        ps.setString(7, data.getSfcs());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunOa data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getActionName());
      ps.setString(2, data.getActionContent());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getStateName());
      ps.setString(6, data.getSfcs());
      ps.setString(7, data.getOaId());
      return ps.executeUpdate();
    }
  }

  /*
   * cc
   * 根据oa_id更新state_name
   * */
  public int updateState(RunOa data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_STATE)) {
      ps.setString(1, data.getStateName());
      ps.setString(2, data.getOaId());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunOa> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunOa data : dataList) {
        ps.setString(1, data.getActionName());
        ps.setString(2, data.getActionContent());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getStateName());
        ps.setString(6, data.getOaId());
        ps.setString(7, data.getSfcs());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String oaId) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_run_oa WHERE oa_id=?")) {
      ps.setString(1, oaId);

      return ps.executeUpdate();
    }
  }

  public List<RunOa> selectAll() throws SQLException {
    ArrayList<RunOa> result = new ArrayList<RunOa>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<RunOa> selectRunOaRecordByOAId(String oaId) throws SQLException {
    ArrayList<RunOa> result = new ArrayList<RunOa>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE  oa_id=?")) {

      ps.setString(1, oaId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public RunOa selectByPK(String oaId) throws SQLException {
    RunOa result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE oa_id=?")) {
      ps.setString(1, oaId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  /*
   * cc
   * 根据actionName和sfc查询
   * */
  public RunOa selectByActionNameAndSfc(String actionName, String sfcs) throws SQLException {
    RunOa result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE ACTION_NAME=? and sfcs = ? order by updated_time desc ")) {
      ps.setString(1, actionName);
      ps.setString(2, sfcs);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<RunOa> selectByActionNameAndSfcs(String actionName, String sfcBo)
      throws SQLException {
    List<RunOa> result = new ArrayList<RunOa>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE ACTION_NAME=? and sfcs = ? order by updated_time desc ")) {
      ps.setString(1, actionName);
      ps.setString(2, sfcBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public RunOa selectByActionNameAndSfcAndStateName(String actionName, String sfcs,
      String stateName) throws SQLException {
    RunOa result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ACTION_NAME=? and sfcs = ? and state_name = ?  ")) {
      ps.setString(1, actionName);
      ps.setString(2, sfcs);
      ps.setString(3, stateName);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private RunOa convert(ResultSet rs) throws SQLException {
    RunOa data = new RunOa();

    int index = 1;
    data.setOaId(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setActionContent(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setStateName(rs.getString(index++));
    data.setSfcs(rs.getString(index++));

    return data;
  }
}
