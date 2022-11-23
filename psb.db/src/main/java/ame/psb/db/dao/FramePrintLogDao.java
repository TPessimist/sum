package ame.psb.db.dao;

import ame.psb.db.FramePrintLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FramePrintLogDao {

  private static final String SQL_INS = "INSERT INTO zr_frame_print_log(id,sfc,seq,inventory_id,first_strip_id,last_strip_id,strip_qty,die_qty,resrce,frame_item_bo,frame_item,frame_item_revision,frame_model,frame_spec,single_qty,process_time,create_time,strip_id,frame_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_frame_print_log SET sfc=?,seq=?,inventory_id=?,first_strip_id=?,last_strip_id=?,strip_qty=?,die_qty=?,resrce=?,frame_item_bo=?,frame_item=?,frame_item_revision=?,frame_model=?,frame_spec=?,single_qty=?,process_time=?,create_time=?,strip_id=?,frame_id WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sfc,seq,inventory_id,first_strip_id,last_strip_id,strip_qty,die_qty,resrce,frame_item_bo,frame_item,frame_item_revision,frame_model,frame_spec,single_qty,process_time,create_time,strip_id,frame_id FROM zr_frame_print_log ";

  private final Connection conn;

  public FramePrintLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FramePrintLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfc());
      ps.setString(3, data.getSeq());
      ps.setString(4, data.getInventoryId());
      ps.setString(5, data.getFirstStripId());
      ps.setString(6, data.getLastStripId());
      ps.setString(7, data.getStripQty());
      ps.setString(8, data.getDieQty());
      ps.setString(9, data.getResrce());
      ps.setString(10, data.getFrameItemBo());
      ps.setString(11, data.getFrameItem());
      ps.setString(12, data.getFrameItemRevision());
      ps.setString(13, data.getFrameModel());
      ps.setString(14, data.getFrameSpec());
      ps.setString(15, data.getSingleQty());
      DateUtils.setDateTz(ps, 16, data.getProcessTime());
      DateUtils.setDateTz(ps, 17, data.getCreateTime());
      ps.setString(18, data.getStripId());
      ps.setString(19, data.getFrameId());
      return ps.executeUpdate();
    }
  }

  public int insert(List<FramePrintLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FramePrintLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfc());
        ps.setString(3, data.getSeq());
        ps.setString(4, data.getInventoryId());
        ps.setString(5, data.getFirstStripId());
        ps.setString(6, data.getLastStripId());
        ps.setString(7, data.getStripQty());
        ps.setString(8, data.getDieQty());
        ps.setString(9, data.getResrce());
        ps.setString(10, data.getFrameItemBo());
        ps.setString(11, data.getFrameItem());
        ps.setString(12, data.getFrameItemRevision());
        ps.setString(13, data.getFrameModel());
        ps.setString(14, data.getFrameSpec());
        ps.setString(15, data.getSingleQty());
        DateUtils.setDateTz(ps, 16, data.getProcessTime());
        DateUtils.setDateTz(ps, 17, data.getCreateTime());
        ps.setString(18, data.getStripId());
        ps.setString(19, data.getFrameId());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FramePrintLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfc());
      ps.setString(2, data.getSeq());
      ps.setString(3, data.getInventoryId());
      ps.setString(4, data.getFirstStripId());
      ps.setString(5, data.getLastStripId());
      ps.setString(6, data.getStripQty());
      ps.setString(7, data.getDieQty());
      ps.setString(8, data.getResrce());
      ps.setString(9, data.getFrameItemBo());
      ps.setString(10, data.getFrameItem());
      ps.setString(11, data.getFrameItemRevision());
      ps.setString(12, data.getFrameModel());
      ps.setString(13, data.getFrameSpec());
      ps.setString(14, data.getSingleQty());
      DateUtils.setDateTz(ps, 15, data.getProcessTime());
      DateUtils.setDateTz(ps, 16, data.getCreateTime());
      ps.setString(17, data.getId());
      ps.setString(18, data.getStripId());
      ps.setString(19, data.getFrameId());
      return ps.executeUpdate();
    }
  }

  public int update(List<FramePrintLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FramePrintLog data : dataList) {
        ps.setString(1, data.getSfc());
        ps.setString(2, data.getSeq());
        ps.setString(3, data.getInventoryId());
        ps.setString(4, data.getFirstStripId());
        ps.setString(5, data.getLastStripId());
        ps.setString(6, data.getStripQty());
        ps.setString(7, data.getDieQty());
        ps.setString(8, data.getResrce());
        ps.setString(9, data.getFrameItemBo());
        ps.setString(10, data.getFrameItem());
        ps.setString(11, data.getFrameItemRevision());
        ps.setString(12, data.getFrameModel());
        ps.setString(13, data.getFrameSpec());
        ps.setString(14, data.getSingleQty());
        DateUtils.setDateTz(ps, 15, data.getProcessTime());
        DateUtils.setDateTz(ps, 16, data.getCreateTime());
        ps.setString(17, data.getId());
        ps.setString(18, data.getStripId());
        ps.setString(19, data.getFrameId());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_frame_print_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<FramePrintLog> selectAll() throws SQLException {
    ArrayList<FramePrintLog> result = new ArrayList<FramePrintLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FramePrintLog selectByPK(String id) throws SQLException {
    FramePrintLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FramePrintLog selectByFrameId(String frameId) throws SQLException {
    FramePrintLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE inventory_id=?")) {
      ps.setString(1, frameId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public int getMaxSequence(String sfc) throws SQLException {
    Integer result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT MAX(seq) AS SEQ FROM ZR_FRAME_PRINT_LOG WHERE sfc = ?")) {
      ps.setString(1, sfc);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = rs.getInt(1);
      }
      return result == null ? 0 : result;
    }
  }

  private FramePrintLog convert(ResultSet rs) throws SQLException {
    FramePrintLog data = new FramePrintLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setSeq(rs.getString(index++));
    data.setInventoryId(rs.getString(index++));
    data.setFirstStripId(rs.getString(index++));
    data.setLastStripId(rs.getString(index++));
    data.setStripQty(rs.getString(index++));
    data.setDieQty(rs.getString(index++));
    data.setResrce(rs.getString(index++));
    data.setFrameItemBo(rs.getString(index++));
    data.setFrameItem(rs.getString(index++));
    data.setFrameItemRevision(rs.getString(index++));
    data.setFrameModel(rs.getString(index++));
    data.setFrameSpec(rs.getString(index++));
    data.setSingleQty(rs.getString(index++));
    data.setProcessTime(DateUtils.getDateTz(rs, index++));
    data.setCreateTime(DateUtils.getDateTz(rs, index++));
    data.setStripId(rs.getString(index++));
    data.setFrameId(rs.getString(index++));
    return data;
  }
}
