package ame.psb.db.dao;

import ame.psb.db.PkgContainerLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgContainerLogDao {

  private static final String SQL_INS = "INSERT INTO zr_pkg_container_log(handle,action_name,id,container_name,packing_plan_bo,item_group_bo,operation_bo,item_level,container_type,pkg_container_bo,curr_step,state_name,customer_itemset_bo,customer_item_bo,item_bo,good_bad,good_die,bad_die1,bad_die2,dn_no,container_seq_id,customer_itemset_names,customer_item_names,run_time,run_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_SEL = "SELECT handle,action_name,id,container_name,packing_plan_bo,item_group_bo,operation_bo,item_level,container_type,pkg_container_bo,curr_step,state_name,customer_itemset_bo,customer_item_bo,item_bo,good_bad,good_die,bad_die1,bad_die2,dn_no,container_seq_id,customer_itemset_names,customer_item_names,run_time,run_user FROM zr_pkg_container_log ";

  private final Connection conn;

  public PkgContainerLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgContainerLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getActionName());
      ps.setString(3, data.getId());
      ps.setString(4, data.getContainerName());
      ps.setString(5, data.getPackingPlanBo());
      ps.setString(6, data.getItemGroupBo());
      ps.setString(7, data.getOperationBo());
      ps.setString(8, data.getItemLevel());
      ps.setString(9, data.getContainerType());
      ps.setString(10, data.getPkgContainerBo());
      ps.setString(11, data.getBoxStep());
      ps.setString(12, data.getStateName());
      ps.setString(13, data.getCustomerItemLotBo());
      ps.setString(14, data.getCustomerItemBo());
      ps.setString(15, data.getItemBo());
      ps.setString(16, data.getGoodBad());
      ps.setInt(17, data.getGoodDie());
      ps.setInt(18, data.getBadDie1());
      ps.setInt(19, data.getBadDie2());
      ps.setString(20, data.getDnNo());
      ps.setString(21, data.getContainerSeqId());
      ps.setString(22, data.getCustomerItemLotNames());
      ps.setString(23, data.getCustomerItemNames());
      DateUtils.setDateTz(ps, 24, data.getRunTime());
      ps.setString(25, data.getRunUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PkgContainerLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PkgContainerLog data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getActionName());
        ps.setString(3, data.getId());
        ps.setString(4, data.getContainerName());
        ps.setString(5, data.getPackingPlanBo());
        ps.setString(6, data.getItemGroupBo());
        ps.setString(7, data.getOperationBo());
        ps.setString(8, data.getItemLevel());
        ps.setString(9, data.getContainerType());
        ps.setString(10, data.getPkgContainerBo());
        ps.setString(11, data.getBoxStep());
        ps.setString(12, data.getStateName());
        ps.setString(13, data.getCustomerItemLotBo());
        ps.setString(14, data.getCustomerItemBo());
        ps.setString(15, data.getItemBo());
        ps.setString(16, data.getGoodBad());
        ps.setInt(17, data.getGoodDie());
        ps.setInt(18, data.getBadDie1());
        ps.setInt(19, data.getBadDie2());
        ps.setString(20, data.getDnNo());
        ps.setString(21, data.getContainerSeqId());
        ps.setString(22, data.getCustomerItemLotNames());
        ps.setString(23, data.getCustomerItemNames());
        DateUtils.setDateTz(ps, 24, data.getRunTime());
        ps.setString(25, data.getRunUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_container_log WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<PkgContainerLog> selectAll() throws SQLException {
    ArrayList<PkgContainerLog> result = new ArrayList<PkgContainerLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgContainerLog> selectByContainerBo(String containerBo) throws SQLException {
    ArrayList<PkgContainerLog> result = new ArrayList<PkgContainerLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where id = ?")) {
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PkgContainerLog selectByPK(String handle) throws SQLException {
    PkgContainerLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgContainerLog convert(ResultSet rs) throws SQLException {
    PkgContainerLog data = new PkgContainerLog();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setId(rs.getString(index++));
    data.setContainerName(rs.getString(index++));
    data.setPackingPlanBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setItemLevel(rs.getString(index++));
    data.setContainerType(rs.getString(index++));
    data.setPkgContainerBo(rs.getString(index++));
    data.setBoxStep(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCustomerItemLotBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setGoodBad(rs.getString(index++));
    data.setGoodDie(rs.getInt(index++));
    data.setBadDie1(rs.getInt(index++));
    data.setBadDie2(rs.getInt(index++));
    data.setDnNo(rs.getString(index++));
    data.setContainerSeqId(rs.getString(index++));
    data.setCustomerItemLotNames(rs.getString(index++));
    data.setCustomerItemNames(rs.getString(index++));
    data.setRunTime(DateUtils.getDateTz(rs, index++));
    data.setRunUser(rs.getString(index++));

    return data;
  }
}