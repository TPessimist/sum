package ame.psb.db.dao;

import ame.psb.db.RecordReserveJumpOa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RecordReserveJumpOaDao {

  private static final String SQL_INS = "INSERT INTO zr_record_reserve_jump_oa(sfcbo,custom_item,shop_order,oa_id,wafer_id,start_op,end_op,create_time,update_time,jump_state,oa_state,update_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_record_reserve_jump_oa SET sfcbo=?,custom_item=?,shop_order=?,wafer_id=?,start_op=?,end_op=?,create_time=?,update_time=?,jump_state=?,oa_state=?,update_user=? WHERE oa_id=?";

  private static final String SQL_SEL = "SELECT sfcbo,custom_item,shop_order,oa_id,wafer_id,start_op,end_op,create_time,update_time,jump_state,oa_state,update_user FROM zr_record_reserve_jump_oa ";

  private final Connection conn;

  public RecordReserveJumpOaDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RecordReserveJumpOa data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcbo());
      ps.setString(2, data.getCustomItem());
      ps.setString(3, data.getShopOrder());
      ps.setString(4, data.getOaId());
      ps.setString(5, data.getWaferId());
      ps.setString(6, data.getStartOp());
      ps.setString(7, data.getEndOp());
      DateUtils.setDateTz(ps, 8, data.getCreateTime());
      DateUtils.setDateTz(ps, 9, data.getUpdateTime());
      ps.setString(10, data.getJumpState());
      ps.setString(11, data.getOaState());
      ps.setString(12, data.getUpdateUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RecordReserveJumpOa> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RecordReserveJumpOa data : dataList) {
        ps.setString(1, data.getSfcbo());
        ps.setString(2, data.getCustomItem());
        ps.setString(3, data.getShopOrder());
        ps.setString(4, data.getOaId());
        ps.setString(5, data.getWaferId());
        ps.setString(6, data.getStartOp());
        ps.setString(7, data.getEndOp());
        DateUtils.setDateTz(ps, 8, data.getCreateTime());
        DateUtils.setDateTz(ps, 9, data.getUpdateTime());
        ps.setString(10, data.getJumpState());
        ps.setString(11, data.getOaState());
        ps.setString(12, data.getUpdateUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RecordReserveJumpOa data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcbo());
      ps.setString(2, data.getCustomItem());
      ps.setString(3, data.getShopOrder());
      ps.setString(4, data.getWaferId());
      ps.setString(5, data.getStartOp());
      ps.setString(6, data.getEndOp());
      DateUtils.setDateTz(ps, 7, data.getCreateTime());
      DateUtils.setDateTz(ps, 8, data.getUpdateTime());
      ps.setString(9, data.getJumpState());
      ps.setString(10, data.getOaState());
      ps.setString(11, data.getUpdateUser());
      ps.setString(12, data.getOaId());

      return ps.executeUpdate();
    }
  }

  public int update(List<RecordReserveJumpOa> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RecordReserveJumpOa data : dataList) {
        ps.setString(1, data.getSfcbo());
        ps.setString(2, data.getCustomItem());
        ps.setString(3, data.getShopOrder());
        ps.setString(4, data.getWaferId());
        ps.setString(5, data.getStartOp());
        ps.setString(6, data.getEndOp());
        DateUtils.setDateTz(ps, 7, data.getCreateTime());
        DateUtils.setDateTz(ps, 8, data.getUpdateTime());
        ps.setString(9, data.getJumpState());
        ps.setString(10, data.getOaState());
        ps.setString(11, data.getUpdateUser());
        ps.setString(12, data.getOaId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String oaId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_record_reserve_jump_oa WHERE oa_id=?")) {
      ps.setString(1, oaId);

      return ps.executeUpdate();
    }
  }

  public List<RecordReserveJumpOa> selectAll() throws SQLException {
    ArrayList<RecordReserveJumpOa> result = new ArrayList<RecordReserveJumpOa>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public RecordReserveJumpOa selectByPK(String oaId) throws SQLException {
    RecordReserveJumpOa result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE oa_id=?")) {
      ps.setString(1, oaId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<RecordReserveJumpOa> selectBySfcBoAndWaferId(String sfcBo, String waferId,
      String oaState) throws SQLException {
    ArrayList<RecordReserveJumpOa> result = new ArrayList<RecordReserveJumpOa>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE sfcbo =? and wafer_id =? and jump_state = ?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, waferId);
      ps.setString(3, oaState);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<RecordReserveJumpOa> selectByCustItem(String custItem)
      throws SQLException {
    ArrayList<RecordReserveJumpOa> result = new ArrayList<RecordReserveJumpOa>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE custom_item =?")) {
      ps.setString(1, custItem);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<RecordReserveJumpOa> selectByShopOrderBo(String shopOrderBo)
      throws SQLException {
    ArrayList<RecordReserveJumpOa> result = new ArrayList<RecordReserveJumpOa>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE shop_order =?")) {
      ps.setString(1, shopOrderBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<RecordReserveJumpOa> selectBySfcBo(String sfcBo) throws SQLException {
    ArrayList<RecordReserveJumpOa> result = new ArrayList<RecordReserveJumpOa>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE sfcbo =?")) {
      ps.setString(1, sfcBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private RecordReserveJumpOa convert(ResultSet rs) throws SQLException {
    RecordReserveJumpOa data = new RecordReserveJumpOa();

    int index = 1;
    data.setSfcbo(rs.getString(index++));
    data.setCustomItem(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setOaId(rs.getString(index++));
    data.setWaferId(rs.getString(index++));
    data.setStartOp(rs.getString(index++));
    data.setEndOp(rs.getString(index++));
    data.setCreateTime(DateUtils.getDateTz(rs, index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setJumpState(rs.getString(index++));
    data.setOaState(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));

    return data;
  }
}
