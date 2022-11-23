package ame.psb.db.dao;

import ame.psb.db.MtFeederLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class MtFeederLogDao {

  private static final String SQL_INS = "INSERT INTO zr_mt_feeder_log(id,action_name,inventory_bo,change_qty,feed_qty,available_qty,resource_bo,slot_name,valid_to,qty_strict,run_time,run_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_SEL = "SELECT id,action_name,inventory_bo,change_qty,feed_qty,available_qty,resource_bo,slot_name,valid_to,qty_strict,run_time,run_user FROM zr_mt_feeder_log ";

  private final Connection conn;

  public MtFeederLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(MtFeederLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getActionName());
      ps.setString(3, data.getInventoryBo());
      ps.setBigDecimal(4, data.getChangeQty());
      ps.setBigDecimal(5, data.getFeedQty());
      ps.setBigDecimal(6, data.getAvailableQty());
      ps.setString(7, data.getResourceBo());
      ps.setString(8, data.getSlotName());
      DateUtils.setDateTz(ps, 9, data.getValidTo());
      ps.setString(10, data.getQtyStrict());
      DateUtils.setDateTz(ps, 11, data.getRunTime());
      ps.setString(12, data.getRunUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<MtFeederLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (MtFeederLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getActionName());
        ps.setString(3, data.getInventoryBo());
        ps.setBigDecimal(4, data.getChangeQty());
        ps.setBigDecimal(5, data.getFeedQty());
        ps.setBigDecimal(6, data.getAvailableQty());
        ps.setString(7, data.getResourceBo());
        ps.setString(8, data.getSlotName());
        DateUtils.setDateTz(ps, 9, data.getValidTo());
        ps.setString(10, data.getQtyStrict());
        DateUtils.setDateTz(ps, 11, data.getRunTime());
        ps.setString(12, data.getRunUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_mt_feeder_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<MtFeederLog> selectAll() throws SQLException {
    ArrayList<MtFeederLog> result = new ArrayList<MtFeederLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public MtFeederLog selectByPK(String id) throws SQLException {
    MtFeederLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private MtFeederLog convert(ResultSet rs) throws SQLException {
    MtFeederLog data = new MtFeederLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setInventoryBo(rs.getString(index++));
    data.setChangeQty(rs.getBigDecimal(index++));
    data.setFeedQty(rs.getBigDecimal(index++));
    data.setAvailableQty(rs.getBigDecimal(index++));
    data.setResourceBo(rs.getString(index++));
    data.setSlotName(rs.getString(index++));
    data.setValidTo(DateUtils.getDateTz(rs, index++));
    data.setQtyStrict(rs.getString(index++));
    data.setRunTime(DateUtils.getDateTz(rs, index++));
    data.setRunUser(rs.getString(index++));

    return data;
  }
}