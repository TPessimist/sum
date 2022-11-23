package ame.psb.db.dao;

import ame.psb.db.RunOperationWaferLock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunOperationWaferLockDao {

  private static final String SQL_INS = "INSERT INTO zr_operation_wafer_lock(customer_item_bo,operation_bo,lock_name,lock_msg,ht_result,flag,create_time,unlock_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_operation_wafer_lock SET lock_msg=?,ht_result=?,flag=?,create_time=?,unlock_time=? WHERE customer_item_bo=? AND operation_bo=? AND lock_name=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,operation_bo,lock_name,lock_msg,ht_result,flag,create_time,unlock_time FROM zr_operation_wafer_lock ";

  private final Connection conn;

  public RunOperationWaferLockDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunOperationWaferLock data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getLockName());
      ps.setString(4, data.getLockMsg());
      ps.setString(5, data.getHtResult());
      ps.setString(6, data.getFlag());
      DateUtils.setDateTz(ps, 7, data.getCreateTime());
      DateUtils.setDateTz(ps, 8, data.getUnlockTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunOperationWaferLock> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunOperationWaferLock data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getLockName());
        ps.setString(4, data.getLockMsg());
        ps.setString(5, data.getHtResult());
        ps.setString(6, data.getFlag());
        DateUtils.setDateTz(ps, 7, data.getCreateTime());
        DateUtils.setDateTz(ps, 8, data.getUnlockTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunOperationWaferLock data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getLockMsg());
      ps.setString(2, data.getHtResult());
      ps.setString(3, data.getFlag());
      DateUtils.setDateTz(ps, 4, data.getCreateTime());
      DateUtils.setDateTz(ps, 5, data.getUnlockTime());
      ps.setString(6, data.getCustomerItemBo());
      ps.setString(7, data.getOperationBo());
      ps.setString(8, data.getLockName());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunOperationWaferLock> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunOperationWaferLock data : dataList) {
        ps.setString(1, data.getLockMsg());
        ps.setString(2, data.getHtResult());
        ps.setString(3, data.getFlag());
        DateUtils.setDateTz(ps, 4, data.getCreateTime());
        DateUtils.setDateTz(ps, 5, data.getUnlockTime());
        ps.setString(6, data.getCustomerItemBo());
        ps.setString(7, data.getOperationBo());
        ps.setString(8, data.getLockName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerItemBo, String operationBo, String lockName)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_operation_wafer_lock WHERE customer_item_bo=? AND operation_bo=? AND lock_name=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);
      ps.setString(3, lockName);

      return ps.executeUpdate();
    }
  }

  public List<RunOperationWaferLock> selectAll() throws SQLException {
    ArrayList<RunOperationWaferLock> result = new ArrayList<RunOperationWaferLock>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<RunOperationWaferLock> selectByWaferOperation(String customerItemBo,
      String operationBo) throws SQLException {
    ArrayList<RunOperationWaferLock> result = new ArrayList<RunOperationWaferLock>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? AND operation_bo=? ")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<RunOperationWaferLock> selectLockByName(String content) throws SQLException {
    ArrayList<RunOperationWaferLock> result = new ArrayList<RunOperationWaferLock>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE flag='Y' AND lock_name=? ")) {
      ps.setString(1, content);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public RunOperationWaferLock selectByPK(String customerItemBo, String operationBo,
      String lockName) throws SQLException {
    RunOperationWaferLock result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE customer_item_bo=? AND operation_bo=? AND lock_name=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);
      ps.setString(3, lockName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private RunOperationWaferLock convert(ResultSet rs) throws SQLException {
    RunOperationWaferLock data = new RunOperationWaferLock();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setLockName(rs.getString(index++));
    data.setLockMsg(rs.getString(index++));
    data.setHtResult(rs.getString(index++));
    data.setFlag(rs.getString(index++));
    data.setCreateTime(DateUtils.getDateTz(rs, index++));
    data.setUnlockTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
