package ame.psb.db.dao;

import ame.psb.db.RunJump;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunJumpDao {

  private static final String SQL_INS = "INSERT INTO zr_run_jump(id,run_sfc_bo,current_step_bo,next_step_bo,create_user,create_time,comment) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_SEL = "SELECT id,run_sfc_bo,current_step_bo,next_step_bo,create_user,create_time,comment FROM zr_run_jump ";

  private final Connection conn;

  public RunJumpDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunJump data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getRunSfcBo());
      ps.setString(3, data.getCurrentStepBo());
      ps.setString(4, data.getNextStepBo());
      ps.setString(5, data.getCreateUser());
      DateUtils.setDateTz(ps, 6, data.getCreateTime());
      ps.setString(7, data.getComment());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunJump> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunJump data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getRunSfcBo());
        ps.setString(3, data.getCurrentStepBo());
        ps.setString(4, data.getNextStepBo());
        ps.setString(5, data.getCreateUser());
        DateUtils.setDateTz(ps, 6, data.getCreateTime());
        ps.setString(7, data.getComment());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_run_jump WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<RunJump> selectAll() throws SQLException {
    ArrayList<RunJump> result = new ArrayList<RunJump>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public RunJump selectByPK(String id) throws SQLException {
    RunJump result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public List<RunJump> selectBySfcBo(String sfcBo) throws SQLException {
    ArrayList<RunJump> result = new ArrayList<RunJump>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE run_sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<RunJump> selectBySfcBoOrder(String sfcBo) throws SQLException {
    ArrayList<RunJump> result = new ArrayList<RunJump>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE run_sfc_bo=? ORDER BY create_time")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  private RunJump convert(ResultSet rs) throws SQLException {
    RunJump data = new RunJump();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setRunSfcBo(rs.getString(index++));
    data.setCurrentStepBo(rs.getString(index++));
    data.setNextStepBo(rs.getString(index++));
    data.setCreateUser(rs.getString(index++));
    data.setCreateTime(DateUtils.getDateTz(rs, index++));
    data.setComment(rs.getString(index++));

    return data;
  }
}