package ame.psb.db.dao;

import ame.psb.db.FtFailureRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FtFailureRecordDao {

  private static final String SQL_INS = "INSERT INTO zd_ft_failure_record (id,sfc_step_bo,action_name,state_name,sfc_bo,shop_order_bo,operation_bo,update_user,update_time,content1,content2 ) VALUES (?,?,?,?,?,?,?,?,?,?,?) ";

  private static final String SQL_SEL = "SELECT id,sfc_step_bo,action_name,state_name,sfc_bo,shop_order_bo,operation_bo,update_user,update_time,content1,content2 FROM zd_ft_failure_record ";

  private static final String SQL_UPD = "UPDATE zd_ft_failure_record SET sfc_step_bo=?,action_name=?,state_name=?,sfc_bo=?,shop_order_bo=?,operation_bo=?,update_user=?,update_time=?,content1=?,content2=? WHERE id=?";

  private final Connection conn;

  public FtFailureRecordDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FtFailureRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcStepBo());
      ps.setString(3, data.getActionName());
      ps.setString(4, data.getStateName());
      ps.setString(5, data.getSfcBo());
      ps.setString(6, data.getShopOrderBo());
      ps.setString(7, data.getOperationBo());
      ps.setString(8, data.getUpdateUser());
      DateUtils.setDateTz(ps, 9, data.getUpdateTime());
      ps.setString(10, data.getContent1());
      ps.setString(11, data.getContent2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FtFailureRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FtFailureRecord data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfcStepBo());
        ps.setString(3, data.getActionName());
        ps.setString(4, data.getStateName());
        ps.setString(5, data.getSfcBo());
        ps.setString(6, data.getShopOrderBo());
        ps.setString(7, data.getOperationBo());
        ps.setString(8, data.getUpdateUser());
        DateUtils.setDateTz(ps, 9, data.getUpdateTime());
        ps.setString(10, data.getContent1());
        ps.setString(11, data.getContent2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FtFailureRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcStepBo());
      ps.setString(2, data.getActionName());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getShopOrderBo());
      ps.setString(6, data.getOperationBo());
      ps.setString(7, data.getUpdateUser());
      DateUtils.setDateTz(ps, 8, data.getUpdateTime());
      ps.setString(9, data.getContent1());
      ps.setString(10, data.getContent2());
      ps.setString(11, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FtFailureRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FtFailureRecord data : dataList) {
        ps.setString(1, data.getSfcStepBo());
        ps.setString(2, data.getActionName());
        ps.setString(3, data.getStateName());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getShopOrderBo());
        ps.setString(6, data.getOperationBo());
        ps.setString(7, data.getUpdateUser());
        DateUtils.setDateTz(ps, 8, data.getUpdateTime());
        ps.setString(9, data.getContent1());
        ps.setString(10, data.getContent2());
        ps.setString(11, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public List<FtFailureRecord> selectAll() throws SQLException {
    ArrayList<FtFailureRecord> result = new ArrayList<FtFailureRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FtFailureRecord> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<FtFailureRecord> result = new ArrayList<FtFailureRecord>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "Where sfc_bo = ? and STATE_NAME = 'ENABLE'")) {
      ps.setString(1, sfcBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FtFailureRecord> selectBySfcAndAction(String sfcBo, String actionName)
      throws SQLException {
    ArrayList<FtFailureRecord> result = new ArrayList<FtFailureRecord>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "Where sfc_bo=? and action_name=? and STATE_NAME='ENABLE'")) {
      ps.setString(1, sfcBo);
      ps.setString(2, actionName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public FtFailureRecord selectByPK(String sfcStepBo, String actionName, String stateName)
      throws SQLException {
    FtFailureRecord result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE sfc_step_bo=? and action_name=? and state_name=?")) {
      ps.setString(1, sfcStepBo);
      ps.setString(2, actionName);
      ps.setString(3, stateName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FtFailureRecord convert(ResultSet rs) throws SQLException {
    FtFailureRecord data = new FtFailureRecord();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcStepBo(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setContent1(rs.getString(index++));
    data.setContent2(rs.getString(index++));

    return data;
  }
}
