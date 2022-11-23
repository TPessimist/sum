package ame.psb.db.dao;

import ame.psb.db.RunGrillBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunGrillBindingDao {

  private static final String SQL_INS = "INSERT INTO zr_grill_binding(id,carrier_id,grill_id,sort_job_id,flag,bind_user,bind_time,unbind_user,unbind_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_grill_binding SET carrier_id=?,grill_id=?,sort_job_id=?,flag=?,bind_user=?,bind_time=?,unbind_user=?,unbind_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,carrier_id,grill_id,sort_job_id,flag,bind_user,bind_time,unbind_user,unbind_time FROM zr_grill_binding ";

  private final Connection conn;

  public RunGrillBindingDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunGrillBinding data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getCarrierId());
      ps.setString(3, data.getGrillId());
      ps.setString(4, data.getSortJobId());
      ps.setString(5, data.getFlag());
      ps.setString(6, data.getBindUser());
      DateUtils.setDateTz(ps, 7, data.getBindTime());
      ps.setString(8, data.getUnbindUser());
      DateUtils.setDateTz(ps, 9, data.getUnbindTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunGrillBinding> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunGrillBinding data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getCarrierId());
        ps.setString(3, data.getGrillId());
        ps.setString(4, data.getSortJobId());
        ps.setString(5, data.getFlag());
        ps.setString(6, data.getBindUser());
        DateUtils.setDateTz(ps, 7, data.getBindTime());
        ps.setString(8, data.getUnbindUser());
        DateUtils.setDateTz(ps, 9, data.getUnbindTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunGrillBinding data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCarrierId());
      ps.setString(2, data.getGrillId());
      ps.setString(3, data.getSortJobId());
      ps.setString(4, data.getFlag());
      ps.setString(5, data.getBindUser());
      DateUtils.setDateTz(ps, 6, data.getBindTime());
      ps.setString(7, data.getUnbindUser());
      DateUtils.setDateTz(ps, 8, data.getUnbindTime());
      ps.setString(9, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunGrillBinding> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunGrillBinding data : dataList) {
        ps.setString(1, data.getCarrierId());
        ps.setString(2, data.getGrillId());
        ps.setString(3, data.getSortJobId());
        ps.setString(4, data.getFlag());
        ps.setString(5, data.getBindUser());
        DateUtils.setDateTz(ps, 6, data.getBindTime());
        ps.setString(7, data.getUnbindUser());
        DateUtils.setDateTz(ps, 8, data.getUnbindTime());
        ps.setString(9, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_grill_binding WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }


  public RunGrillBinding selectByPK(String id) throws SQLException {
    RunGrillBinding result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public RunGrillBinding selectActiveByCarrierId(String carrierId) throws SQLException {
    RunGrillBinding result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE carrier_id =? and flag = 'Y' ")) {
      ps.setString(1, carrierId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public RunGrillBinding selectActiveByGrillId(String grillId) throws SQLException {
    RunGrillBinding result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE grill_id =? and flag = 'Y' ")) {
      ps.setString(1, grillId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  private RunGrillBinding convert(ResultSet rs) throws SQLException {
    RunGrillBinding data = new RunGrillBinding();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setCarrierId(rs.getString(index++));
    data.setGrillId(rs.getString(index++));
    data.setSortJobId(rs.getString(index++));
    data.setFlag(rs.getString(index++));
    data.setBindUser(rs.getString(index++));
    data.setBindTime(DateUtils.getDateTz(rs, index++));
    data.setUnbindUser(rs.getString(index++));
    data.setUnbindTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
