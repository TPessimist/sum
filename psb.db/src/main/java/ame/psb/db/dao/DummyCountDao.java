package ame.psb.db.dao;

import ame.psb.db.DummyCount;
import ame.psb.db.ViewDummyCount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class DummyCountDao {

  private static final String SQL_INS = "INSERT INTO zd_dummy_count(id,dummy_plan_bo,current_times,dummy_times,current_count,dummy_count,last_time,state_name) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_dummy_count SET dummy_plan_bo=?,current_times=?,dummy_times=?,current_count=?,dummy_count=?,last_time=?,state_name=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,dummy_plan_bo,resource_bo,item_bo,begin_operation_bo,end_operation_bo,chk_from,chk_to,begin_operation,end_operation,resource_name,item_name,current_times,dummy_times,current_count,dummy_count,last_time,state_name FROM view_dummy_count ";

  private final Connection conn;

  public DummyCountDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DummyCount data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getDummyPlanBo());
      ps.setBigDecimal(3, data.getCurrentTimes());
      ps.setBigDecimal(4, data.getDummyTimes());
      ps.setBigDecimal(5, data.getCurrentCount());
      ps.setBigDecimal(6, data.getDummyCount());
      DateUtils.setDateTz(ps, 7, data.getLastTime());
      ps.setString(8, data.getStateName());

      return ps.executeUpdate();
    }
  }

  public int update(DummyCount data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDummyPlanBo());
      ps.setBigDecimal(2, data.getCurrentTimes());
      ps.setBigDecimal(3, data.getDummyTimes());
      ps.setBigDecimal(4, data.getCurrentCount());
      ps.setBigDecimal(5, data.getDummyCount());
      DateUtils.setDateTz(ps, 6, data.getLastTime());
      ps.setString(7, data.getStateName());
      ps.setString(8, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<DummyCount> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DummyCount data : dataList) {
        ps.setString(1, data.getDummyPlanBo());
        ps.setBigDecimal(2, data.getCurrentTimes());
        ps.setBigDecimal(3, data.getDummyTimes());
        ps.setBigDecimal(4, data.getCurrentCount());
        ps.setBigDecimal(5, data.getDummyCount());
        DateUtils.setDateTz(ps, 6, data.getLastTime());
        ps.setString(7, data.getStateName());
        ps.setString(8, data.getId());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_dummy_count WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int updateState(String dummyPlanBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "update zd_dummy_count set state_Name='N' WHERE dummy_plan_bo=? AND state_Name='Y'")) {
      ps.setString(1, dummyPlanBo);

      return ps.executeUpdate();
    }
  }

  public List<ViewDummyCount> selectAll() throws SQLException {
    ArrayList<ViewDummyCount> result = new ArrayList<ViewDummyCount>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewDummyCount> selectByResource(String resourceBo) throws SQLException {
    ArrayList<ViewDummyCount> result = new ArrayList<ViewDummyCount>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? AND state_Name='Y'")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewDummyCount> selectByResourceAndItem(String resourceBo, String itemBo)
      throws SQLException {
    ArrayList<ViewDummyCount> result = new ArrayList<ViewDummyCount>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? AND item_bo=? AND state_Name='Y'")) {
      ps.setString(1, resourceBo);
      ps.setString(2, itemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewDummyCount selectByDummyPlanBo(String id) throws SQLException {
    ViewDummyCount result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE dummy_plan_bo=? AND state_Name='Y'")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewDummyCount selectByPK(String id) throws SQLException {
    ViewDummyCount result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ViewDummyCount convert(ResultSet rs) throws SQLException {
    ViewDummyCount data = new ViewDummyCount();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDummyPlanBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setBeginOperationBo(rs.getString(index++));
    data.setEndOperationBo(rs.getString(index++));
    data.setChkFrom(DateUtils.getDateTz(rs, index++));
    data.setChkTo(DateUtils.getDateTz(rs, index++));
    data.setBeginOperation(rs.getString(index++));
    data.setEndOperation(rs.getString(index++));
    data.setResourceName(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setCurrentTimes(rs.getBigDecimal(index++));
    data.setDummyTimes(rs.getBigDecimal(index++));
    data.setCurrentCount(rs.getBigDecimal(index++));
    data.setDummyCount(rs.getBigDecimal(index++));
    data.setLastTime(DateUtils.getDateTz(rs, index++));
    data.setStateName(rs.getString(index++));

    return data;
  }
}