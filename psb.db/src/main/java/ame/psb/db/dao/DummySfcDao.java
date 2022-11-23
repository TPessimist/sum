package ame.psb.db.dao;

import ame.psb.db.DummySfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

/**
 * @author Coffee
 */
public class DummySfcDao {

  private static final String SQL_INS = "INSERT INTO zr_dummy_sfc(id,dummy_plan_bo,resource_bo,item_bo,begin_operation_bo,end_operation_bo,sfc_bo,create_time,complete_time,state_name) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_dummy_sfc SET dummy_plan_bo=?,resource_bo=?,item_bo=?,begin_operation_bo=?,end_operation_bo=?,sfc_bo=?,create_time=?,complete_time=?,state_name=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,dummy_plan_bo,resource_bo,item_bo,begin_operation_bo,end_operation_bo,sfc_bo,create_time,complete_time,state_name FROM zr_dummy_sfc ";

  private final Connection conn;

  public DummySfcDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DummySfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getDummyPlanBo());
      ps.setString(3, data.getResourceBo());
      ps.setString(4, data.getItemBo());
      ps.setString(5, data.getBeginOperationBo());
      ps.setString(6, data.getEndOperationBo());
      ps.setString(7, data.getSfcBo());
      DateUtils.setDateTz(ps, 8, data.getCreateTime());
      DateUtils.setDateTz(ps, 9, data.getCompleteTime());
      ps.setString(10, data.getStateName());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DummySfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DummySfc data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getDummyPlanBo());
        ps.setString(3, data.getResourceBo());
        ps.setString(4, data.getItemBo());
        ps.setString(5, data.getBeginOperationBo());
        ps.setString(6, data.getEndOperationBo());
        ps.setString(7, data.getSfcBo());
        DateUtils.setDateTz(ps, 8, data.getCreateTime());
        DateUtils.setDateTz(ps, 9, data.getCompleteTime());
        ps.setString(10, data.getStateName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DummySfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDummyPlanBo());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getItemBo());
      ps.setString(4, data.getBeginOperationBo());
      ps.setString(5, data.getEndOperationBo());
      ps.setString(6, data.getSfcBo());
      DateUtils.setDateTz(ps, 7, data.getCreateTime());
      DateUtils.setDateTz(ps, 8, data.getCompleteTime());
      ps.setString(9, data.getStateName());
      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<DummySfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DummySfc data : dataList) {
        ps.setString(1, data.getDummyPlanBo());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getItemBo());
        ps.setString(4, data.getBeginOperationBo());
        ps.setString(5, data.getEndOperationBo());
        ps.setString(6, data.getSfcBo());
        DateUtils.setDateTz(ps, 7, data.getCreateTime());
        DateUtils.setDateTz(ps, 8, data.getCompleteTime());
        ps.setString(9, data.getStateName());
        ps.setString(10, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateState(String dummyPlanBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "update zr_dummy_sfc set state_Name='DONE' WHERE dummy_plan_bo=? AND state_Name='RUN'")) {
      ps.setString(1, dummyPlanBo);

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_dummy_sfc WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<DummySfc> selectAll() throws SQLException {
    ArrayList<DummySfc> result = new ArrayList<DummySfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public DummySfc selectBySfc(String sfcBo, String itemBo, String endOperationBo)
      throws SQLException {
    DummySfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE sfc_bo=? and item_bo=? AND end_operation_bo=? AND state_Name='RUN'")) {
      ps.setString(1, sfcBo);
      ps.setString(2, itemBo);
      ps.setString(3, endOperationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<DummySfc> selectRunByResource(String resourceBo) throws SQLException {
    ArrayList<DummySfc> result = new ArrayList<DummySfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? AND state_Name='RUN'")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public DummySfc selectByDummyPlanBo(String id) throws SQLException {
    DummySfc result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE dummy_plan_bo=? AND state_Name='RUN'")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public DummySfc selectByPK(String id) throws SQLException {
    DummySfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private DummySfc convert(ResultSet rs) throws SQLException {
    DummySfc data = new DummySfc();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDummyPlanBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setBeginOperationBo(rs.getString(index++));
    data.setEndOperationBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setCreateTime(DateUtils.getDateTz(rs, index++));
    data.setCompleteTime(DateUtils.getDateTz(rs, index++));
    data.setStateName(rs.getString(index++));

    return data;
  }
}