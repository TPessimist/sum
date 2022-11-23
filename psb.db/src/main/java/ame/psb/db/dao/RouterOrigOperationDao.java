package ame.psb.db.dao;

import ame.me.db.RouterOrigOperation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouterOrigOperationDao {

  private static final String SQL_INS = "INSERT INTO router_operation(handle,router_step_bo,operation_bo,max_loop,required_time_in_process,step_type,special_instruction) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE router_operation SET router_step_bo=?,operation_bo=?,max_loop=?,required_time_in_process=?,step_type=?,special_instruction=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,router_step_bo,operation_bo,max_loop,required_time_in_process,step_type,special_instruction FROM router_operation ";

  private final Connection conn;

  public RouterOrigOperationDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RouterOrigOperation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getRouterStepBo());
      ps.setString(3, data.getOperationBo());
      ps.setBigDecimal(4, data.getMaxLoop());
      ps.setBigDecimal(5, data.getRequiredTimeInProcess());
      ps.setString(6, data.getStepType());
      ps.setString(7, data.getSpecialInstruction());

      return ps.executeUpdate();
    }
  }

  public void insertOrUpdate(RouterOrigOperation data) throws SQLException {
    if (null == selectByPK(data.getHandle())) {
      insert(data);
    }

  }

  public int insert(List<RouterOrigOperation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RouterOrigOperation data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getRouterStepBo());
        ps.setString(3, data.getOperationBo());
        ps.setBigDecimal(4, data.getMaxLoop());
        ps.setBigDecimal(5, data.getRequiredTimeInProcess());
        ps.setString(6, data.getStepType());
        ps.setString(7, data.getSpecialInstruction());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RouterOrigOperation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getRouterStepBo());
      ps.setString(2, data.getOperationBo());
      ps.setBigDecimal(3, data.getMaxLoop());
      ps.setBigDecimal(4, data.getRequiredTimeInProcess());
      ps.setString(5, data.getStepType());
      ps.setString(6, data.getSpecialInstruction());
      ps.setString(7, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<RouterOrigOperation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RouterOrigOperation data : dataList) {
        ps.setString(1, data.getRouterStepBo());
        ps.setString(2, data.getOperationBo());
        ps.setBigDecimal(3, data.getMaxLoop());
        ps.setBigDecimal(4, data.getRequiredTimeInProcess());
        ps.setString(5, data.getStepType());
        ps.setString(6, data.getSpecialInstruction());
        ps.setString(7, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM router_operation WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<RouterOrigOperation> selectAll() throws SQLException {
    ArrayList<RouterOrigOperation> result = new ArrayList<RouterOrigOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<RouterOrigOperation> selectByRouter(String routerBo) throws SQLException {
    ArrayList<RouterOrigOperation> result = new ArrayList<RouterOrigOperation>();
    routerBo = "%" + routerBo + "%";
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where ROUTER_STEP_BO LIKE ?")) {
      ps.setString(1, routerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public RouterOrigOperation selectByPK(String handle) throws SQLException {
    RouterOrigOperation result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public RouterOrigOperation selectByRouterStep(String handle) throws SQLException {
    RouterOrigOperation result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE ROUTER_STEP_BO=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private RouterOrigOperation convert(ResultSet rs) throws SQLException {
    RouterOrigOperation data = new RouterOrigOperation();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setRouterStepBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setMaxLoop(rs.getBigDecimal(index++));
    data.setRequiredTimeInProcess(rs.getBigDecimal(index++));
    data.setStepType(rs.getString(index++));
    data.setSpecialInstruction(rs.getString(index++));

    return data;
  }
}
