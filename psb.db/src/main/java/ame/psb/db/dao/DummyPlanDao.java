package ame.psb.db.dao;

import ame.psb.db.DummyPlan;
import ame.psb.db.ViewDummyPlan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

/**
 * @author Coffee
 */
public class DummyPlanDao {

  private static final String SQL_INS = "INSERT INTO zd_dummy_plan(id,resource_bo,item_bo,begin_operation_bo,end_operation_bo,chk_from,chk_to,time_value,time_alw,count_value,count_alw,state_name,updated_user,updated_time,sfc_bo,device_bo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_dummy_plan SET resource_bo=?,item_bo=?,begin_operation_bo=?,end_operation_bo=?,chk_from=?,chk_to=?,time_value=?,time_alw=?,count_value=?,count_alw=?,state_name=?,updated_user=?,updated_time=?,sfc_bo=?,device_bo=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resource_bo,item_bo,begin_operation_bo,end_operation_bo,chk_from,chk_to,time_value,time_alw,count_value,count_alw,state_name,begin_operation,end_operation,resource_name,item_name,updated_user,updated_time,sfc_bo,device_bo FROM view_dummy_plan ";

  private final Connection conn;

  public DummyPlanDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DummyPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getItemBo());
      ps.setString(4, data.getBeginOperationBo());
      ps.setString(5, data.getEndOperationBo());
      DateUtils.setDateTz(ps, 6, data.getChkFrom());
      DateUtils.setDateTz(ps, 7, data.getChkTo());
      ps.setBigDecimal(8, data.getTimeValue());
      ps.setBigDecimal(9, data.getTimeAlw());
      ps.setBigDecimal(10, data.getCountValue());
      ps.setBigDecimal(11, data.getCountAlw());
      ps.setString(12, data.getStateName());
      ps.setString(13, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 14, data.getUpdatedTime());
      ps.setString(15, data.getSfcBo());
      ps.setString(16, data.getDeviceBo());

      return ps.executeUpdate();
    }
  }

  public int update(DummyPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getItemBo());
      ps.setString(3, data.getBeginOperationBo());
      ps.setString(4, data.getEndOperationBo());
      DateUtils.setDateTz(ps, 5, data.getChkFrom());
      DateUtils.setDateTz(ps, 6, data.getChkTo());
      ps.setBigDecimal(7, data.getTimeValue());
      ps.setBigDecimal(8, data.getTimeAlw());
      ps.setBigDecimal(9, data.getCountValue());
      ps.setBigDecimal(10, data.getCountAlw());
      ps.setString(11, data.getStateName());
      ps.setString(12, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 13, data.getUpdatedTime());
      ps.setString(14, data.getSfcBo());
      ps.setString(15, data.getDeviceBo());
      ps.setString(16, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<DummyPlan> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DummyPlan data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getItemBo());
        ps.setString(3, data.getBeginOperationBo());
        ps.setString(4, data.getEndOperationBo());
        DateUtils.setDateTz(ps, 5, data.getChkFrom());
        DateUtils.setDateTz(ps, 6, data.getChkTo());
        ps.setBigDecimal(7, data.getTimeValue());
        ps.setBigDecimal(8, data.getTimeAlw());
        ps.setBigDecimal(9, data.getCountValue());
        ps.setBigDecimal(10, data.getCountAlw());
        ps.setString(11, data.getStateName());
        ps.setString(12, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 13, data.getUpdatedTime());
        ps.setString(14, data.getSfcBo());
        ps.setString(15, data.getDeviceBo());
        ps.setString(16, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateState(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_dummy_plan SET state_name='N' WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_dummy_plan WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  /*
   * cc
   * by 不同参数查询
   * */
  public List<ViewDummyPlan> select(Where where) throws SQLException {
    ArrayList<ViewDummyPlan> result = new ArrayList<ViewDummyPlan>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewDummyPlan> selectAll() throws SQLException {
    ArrayList<ViewDummyPlan> result = new ArrayList<ViewDummyPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewDummyPlan selectByPK(String id) throws SQLException {
    ViewDummyPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=? ")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewDummyPlan> selectByResource(String resourceBo) throws SQLException {
    ArrayList<ViewDummyPlan> result = new ArrayList<ViewDummyPlan>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? ORDER BY id")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewDummyPlan> selectByResource(String resourceBo, String itemBo)
      throws SQLException {
    ArrayList<ViewDummyPlan> result = new ArrayList<ViewDummyPlan>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? AND item_bo=? ")) {
      ps.setString(1, resourceBo);
      ps.setString(2, itemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewDummyPlan> selectOnByResource(String resourceBo, String itemBo)
      throws SQLException {
    ArrayList<ViewDummyPlan> result = new ArrayList<ViewDummyPlan>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? AND item_bo=? AND state_name='Y'")) {
      ps.setString(1, resourceBo);
      ps.setString(2, itemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewDummyPlan selectByResourceOpr(String resource, String item, String beginOperation)
      throws SQLException {
    ViewDummyPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE resource_name=? and item_name=? and begin_operation=? and state_name='Y'")) {
      ps.setString(1, resource);
      ps.setString(2, item);
      ps.setString(3, beginOperation);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ViewDummyPlan convert(ResultSet rs) throws SQLException {
    ViewDummyPlan data = new ViewDummyPlan();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setBeginOperationBo(rs.getString(index++));
    data.setEndOperationBo(rs.getString(index++));
    data.setChkFrom(DateUtils.getDateTz(rs, index++));
    data.setChkTo(DateUtils.getDateTz(rs, index++));
    data.setTimeValue(rs.getBigDecimal(index++));
    data.setTimeAlw(rs.getBigDecimal(index++));
    data.setCountValue(rs.getBigDecimal(index++));
    data.setCountAlw(rs.getBigDecimal(index++));
    data.setStateName(rs.getString(index++));
    data.setBeginOperation(rs.getString(index++));
    data.setEndOperation(rs.getString(index++));
    data.setResourceName(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setSfcBo(rs.getString(index++));
    data.setDeviceBo(rs.getString(index++));

    return data;
  }
}
