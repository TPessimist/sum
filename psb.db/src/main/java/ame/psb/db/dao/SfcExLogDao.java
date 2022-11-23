package ame.psb.db.dao;

import ame.psb.db.SfcExLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SfcExLogDao {

  private static final String SQL_INS = "INSERT INTO zr_sfc_log(id,action_name,sfc_bo,state_name,current_run,customer_itemset_bo,priority,dpt_no,lot_type,item_qty,customer_itemset_name,remark,curr_seq,sfc_type,run_user,run_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_SEL = "SELECT id,action_name,sfc_bo,state_name,current_run,customer_itemset_bo,priority,dpt_no,lot_type,item_qty,customer_itemset_name,remark,curr_seq,sfc_type,run_user,run_time FROM zr_sfc_log ";

  private final Connection conn;

  public SfcExLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SfcExLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getActionName());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getStateName());
      ps.setString(5, data.getCurrentRun());
      ps.setString(6, data.getCustomerItemLotBo());
      ps.setInt(7, data.getHotLevel());
      ps.setString(8, data.getDptNo());
      ps.setString(9, data.getLotType());
      ps.setInt(10, data.getItemQty());
      ps.setString(11, data.getCustomerItemLotName());
      ps.setString(12, data.getRemark());
      ps.setInt(13, data.getCurrSeq());
      ps.setString(14, data.getSfcType());
      ps.setString(15, data.getRunUser());
      DateUtils.setDateTz(ps, 16, data.getRunTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SfcExLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SfcExLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getActionName());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getStateName());
        ps.setString(5, data.getCurrentRun());
        ps.setString(6, data.getCustomerItemLotBo());
        ps.setInt(7, data.getHotLevel());
        ps.setString(8, data.getDptNo());
        ps.setString(9, data.getLotType());
        ps.setInt(10, data.getItemQty());
        ps.setString(11, data.getCustomerItemLotName());
        ps.setString(12, data.getRemark());
        ps.setInt(13, data.getCurrSeq());
        ps.setString(14, data.getSfcType());
        ps.setString(15, data.getRunUser());
        DateUtils.setDateTz(ps, 16, data.getRunTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_sfc_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<SfcExLog> selectAll() throws SQLException {
    ArrayList<SfcExLog> result = new ArrayList<SfcExLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SfcExLog selectByPK(String id) throws SQLException {
    SfcExLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<SfcExLog> selectByName(String sfcName) throws SQLException {
    ArrayList<SfcExLog> result = new ArrayList<SfcExLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_name=?")) {
      ps.setString(1, sfcName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private SfcExLog convert(ResultSet rs) throws SQLException {
    SfcExLog data = new SfcExLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCurrentRun(rs.getString(index++));
    data.setCustomerItemLotBo(rs.getString(index++));
    data.setHotLevel(rs.getInt(index++));
    data.setDptNo(rs.getString(index++));
    data.setLotType(rs.getString(index++));
    data.setItemQty(rs.getInt(index++));
    data.setCustomerItemLotName(rs.getString(index++));
    data.setRemark(rs.getString(index++));
    data.setCurrSeq(rs.getInt(index++));
    data.setSfcType(rs.getString(index++));
    data.setRunUser(rs.getString(index++));
    data.setRunTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}