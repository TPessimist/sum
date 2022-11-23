package ame.psb.db.dao;

import ame.psb.db.ViewSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.RunCancelSfcLog;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class RunCancelSfcLogDao {

  private static final String SQL_INS = "INSERT INTO zr_run_cancel_log(uuid,item_group_bo,item_group_name,item_bo,item_name,shop_order_bo,shop_order_name,state,describe,reversed_field1,reversed_field2,modify_user,modify_time,created_user,created_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_run_cancel_log SET item_group_bo=?,item_group_name=?,item_bo=?,item_name=?,shop_order_bo=?,shop_order_name=?,state=?,describe=?,reversed_field1=?,reversed_field2=?,modify_user=?,modify_time=?,created_user=?,created_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,item_group_bo,item_group_name,item_bo,item_name,shop_order_bo,shop_order_name,state,describe,reversed_field1,reversed_field2,modify_user,modify_time,created_user,created_time FROM zr_run_cancel_log ";

  private final Connection conn;

  public RunCancelSfcLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunCancelSfcLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getItemGroupBo());
      ps.setString(3, data.getItemGroupName());
      ps.setString(4, data.getItemBo());
      ps.setString(5, data.getItemName());
      ps.setString(6, data.getShopOrderBo());
      ps.setString(7, data.getShopOrderName());
      ps.setString(8, data.getState());
      ps.setString(9, data.getDescribe());
      ps.setString(10, data.getReversedField1());
      ps.setString(11, data.getReversedField2());
      ps.setString(12, data.getModifyUser());
      DateUtils.setDateTz(ps, 13, data.getModifyTime());
      ps.setString(14, data.getCreatedUser());
      DateUtils.setDateTz(ps, 15, data.getCreatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunCancelSfcLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunCancelSfcLog data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getItemGroupBo());
        ps.setString(3, data.getItemGroupName());
        ps.setString(4, data.getItemBo());
        ps.setString(5, data.getItemName());
        ps.setString(6, data.getShopOrderBo());
        ps.setString(7, data.getShopOrderName());
        ps.setString(8, data.getState());
        ps.setString(9, data.getDescribe());
        ps.setString(10, data.getReversedField1());
        ps.setString(11, data.getReversedField2());
        ps.setString(12, data.getModifyUser());
        DateUtils.setDateTz(ps, 13, data.getModifyTime());
        ps.setString(14, data.getCreatedUser());
        DateUtils.setDateTz(ps, 15, data.getCreatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunCancelSfcLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getItemGroupName());
      ps.setString(3, data.getItemBo());
      ps.setString(4, data.getItemName());
      ps.setString(5, data.getShopOrderBo());
      ps.setString(6, data.getShopOrderName());
      ps.setString(7, data.getState());
      ps.setString(8, data.getDescribe());
      ps.setString(9, data.getReversedField1());
      ps.setString(10, data.getReversedField2());
      ps.setString(11, data.getModifyUser());
      DateUtils.setDateTz(ps, 12, data.getModifyTime());
      ps.setString(13, data.getCreatedUser());
      DateUtils.setDateTz(ps, 14, data.getCreatedTime());
      ps.setString(15, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunCancelSfcLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunCancelSfcLog data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getItemGroupName());
        ps.setString(3, data.getItemBo());
        ps.setString(4, data.getItemName());
        ps.setString(5, data.getShopOrderBo());
        ps.setString(6, data.getShopOrderName());
        ps.setString(7, data.getState());
        ps.setString(8, data.getDescribe());
        ps.setString(9, data.getReversedField1());
        ps.setString(10, data.getReversedField2());
        ps.setString(11, data.getModifyUser());
        DateUtils.setDateTz(ps, 12, data.getModifyTime());
        ps.setString(13, data.getCreatedUser());
        DateUtils.setDateTz(ps, 14, data.getCreatedTime());
        ps.setString(15, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_run_cancel_log WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<RunCancelSfcLog> selectAll() throws SQLException {
    ArrayList<RunCancelSfcLog> result = new ArrayList<RunCancelSfcLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<RunCancelSfcLog> select(Where where) throws SQLException {
    List<RunCancelSfcLog> list = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convert(rs));
      }
      return list;
    }
  }

  public RunCancelSfcLog selectByPK(String uuid) throws SQLException {
    RunCancelSfcLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private RunCancelSfcLog convert(ResultSet rs) throws SQLException {
    RunCancelSfcLog data = new RunCancelSfcLog();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setItemGroupName(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setDescribe(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setModifyUser(rs.getString(index++));
    data.setModifyTime(DateUtils.getDateTz(rs, index++));
    data.setCreatedUser(rs.getString(index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
