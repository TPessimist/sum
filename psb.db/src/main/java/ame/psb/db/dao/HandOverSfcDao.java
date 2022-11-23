package ame.psb.db.dao;

import ame.psb.db.HandOverSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class HandOverSfcDao {

  private static final String SQL_INS = "INSERT INTO zr_hand_over_sfc(id,sfc_bo,state_name,pervious_state_name,flag,updated_user,updated_time,item_qty,wafer_list,customer_itemset,operation,nums,computer_ip) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_hand_over_sfc SET sfc_bo=?,state_name=?,pervious_state_name=?,flag=?,updated_user=?,updated_time=?,item_qty=?,wafer_list=?,customer_itemset=?,operation=?,nums=?,computer_ip=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sfc_bo,state_name,pervious_state_name,flag,updated_user,updated_time,item_qty,wafer_list,customer_itemset,operation,nums,computer_ip FROM zr_hand_over_sfc ";

  private final Connection conn;

  public HandOverSfcDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(HandOverSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getPerviousStateName());
      ps.setString(5, data.getFlag());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setInt(8, data.getItemQty());
      ps.setString(9, data.getWaferList());
      ps.setString(10, data.getCustomerItemSet());
      ps.setString(11, data.getOperation());
      ps.setInt(12, data.getNums());
      ps.setString(13, data.getComputerIp());
      return ps.executeUpdate();
    }
  }

  public int insert(List<HandOverSfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (HandOverSfc data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getStateName());
        ps.setString(4, data.getPerviousStateName());
        ps.setString(5, data.getFlag());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setInt(8, data.getItemQty());
        ps.setString(9, data.getWaferList());
        ps.setString(10, data.getCustomerItemSet());
        ps.setString(11, data.getOperation());
        ps.setInt(12, data.getNums());
        ps.setString(13, data.getComputerIp());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(HandOverSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getStateName());
      ps.setString(3, data.getPerviousStateName());
      ps.setString(4, data.getFlag());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setInt(7, data.getItemQty());
      ps.setString(8, data.getWaferList());
      ps.setString(9, data.getCustomerItemSet());
      ps.setString(10, data.getOperation());
      ps.setInt(11, data.getNums());
      ps.setString(12, data.getComputerIp());
      ps.setString(13, data.getId());

      return ps.executeUpdate();
    }
  }

  public int updateComputerIp(String computerIp, String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_hand_over_sfc SET computer_ip=? WHERE id=?")) {
      ps.setString(1, computerIp);
      ps.setString(2, id);

      return ps.executeUpdate();
    }
  }

  public int update(List<HandOverSfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (HandOverSfc data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getStateName());
        ps.setString(3, data.getPerviousStateName());
        ps.setString(4, data.getFlag());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setInt(7, data.getItemQty());
        ps.setString(8, data.getWaferList());
        ps.setString(9, data.getCustomerItemSet());
        ps.setString(10, data.getOperation());
        ps.setInt(11, data.getNums());
        ps.setString(12, data.getComputerIp());
        ps.setString(13, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_hand_over_sfc WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<HandOverSfc> selectAll() throws SQLException {
    ArrayList<HandOverSfc> result = new ArrayList<HandOverSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<HandOverSfc> selectActive() throws SQLException {
    ArrayList<HandOverSfc> result = new ArrayList<HandOverSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE flag = 'Y' ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public HandOverSfc selectActiveBySfc(String sfcBo) throws SQLException {
    HandOverSfc result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? and flag = 'Y' ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<HandOverSfc> selectActivesBySfc(String sfcBo) throws SQLException {
    List<HandOverSfc> result = new ArrayList<HandOverSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? and flag = 'Y' ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public HandOverSfc selectByPK(String id) throws SQLException {
    HandOverSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<HandOverSfc> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<HandOverSfc> result = new ArrayList<HandOverSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? and  flag = 'N' ORDER BY updated_time asc")) {
      ps.setString(1, sfcBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public HandOverSfc selectPreviousState(String sfcBo, int nums) throws SQLException {
    HandOverSfc result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? and state_name = 'DELIVER' and nums =?")) {
      ps.setString(1, sfcBo);
      ps.setInt(2, nums);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public HandOverSfc selectPreviousOperation(String sfcBo, int nums) throws SQLException {
    HandOverSfc result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE sfc_bo=? and pervious_state_name = 'RECEIVE' and nums =?")) {
      ps.setString(1, sfcBo);
      ps.setInt(2, nums);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<HandOverSfc> selectForCheck(String sfcBo, String operationBo) throws SQLException {
    ArrayList<HandOverSfc> result = new ArrayList<HandOverSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE sfc_bo=? and pervious_state_name = 'RECEIVE' and OPERATION =?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<HandOverSfc> selectCheckLimit(String sfcBo, String operation) throws SQLException {
    ArrayList<HandOverSfc> result = new ArrayList<HandOverSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE sfc_bo=? and STATE_NAME = 'WAIT' and pervious_state_name = 'RECEIVE' and OPERATION =?"
        + " and (ADD_SECONDS(UPDATED_TIME,60*60*8)  " +
        "             BETWEEN ADD_DAYS(CURRENT_TIMESTAMP,-7)  " +
        "           AND CURRENT_TIMESTAMP)")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operation);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<HandOverSfc> selectCheckLimit2(String sfcBo, String operation) throws SQLException {
    ArrayList<HandOverSfc> result = new ArrayList<HandOverSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? and STATE_NAME = 'DELIVER' and OPERATION =?"
            + " and (ADD_SECONDS(UPDATED_TIME,60*60*8)  " +
            "             BETWEEN ADD_SECONDS(CURRENT_TIMESTAMP,-10)  " +
            "           AND ADD_SECONDS(CURRENT_TIMESTAMP,10))")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operation);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<HandOverSfc> selectReceiveSfc(String sfcBo, String operation) throws SQLException {
    ArrayList<HandOverSfc> result = new ArrayList<HandOverSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? and STATE_NAME = 'RECEIVE' and OPERATION =? "
            + " and (ADD_SECONDS(UPDATED_TIME,60*60*8)  " +
            "             BETWEEN ADD_SECONDS(CURRENT_TIMESTAMP,-10)  " +
            "           AND ADD_SECONDS(CURRENT_TIMESTAMP,10))")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operation);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<HandOverSfc> selectAllBySfc(String sfcBo) throws SQLException {
    ArrayList<HandOverSfc> result = new ArrayList<HandOverSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? ORDER BY updated_time asc")) {
      ps.setString(1, sfcBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private HandOverSfc convert(ResultSet rs) throws SQLException {
    HandOverSfc data = new HandOverSfc();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setPerviousStateName(rs.getString(index++));
    data.setFlag(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setItemQty(rs.getInt(index++));
    data.setWaferList(rs.getString(index++));
    data.setCustomerItemSet(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setNums(rs.getInt(index++));
    data.setComputerIp(rs.getString(index++));
    return data;
  }
}
