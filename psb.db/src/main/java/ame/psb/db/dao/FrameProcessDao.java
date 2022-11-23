package ame.psb.db.dao;

import ame.psb.db.FrameProcess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class FrameProcessDao {

  private static final String SQL_INS = "INSERT INTO zr_frame_process(id,shop_order,sfc,operation,device,sfc_qty,resrce,frame_item_bo,frame_item,frame_item_revision,frame_model,frame_spec,compensation_value,single_qty,origin_strip_qty,needed_strip_qty,reprint_strip_qty,process_start_date,process_complete_date,process_status,create_user,create_time,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_frame_process SET shop_order=?,sfc=?,operation=?,device=?,sfc_qty=?,resrce=?,frame_item_bo=?,frame_item=?,frame_item_revision=?,frame_model=?,frame_spec=?,compensation_value=?,single_qty=?,origin_strip_qty=?,needed_strip_qty=?,reprint_strip_qty=?,process_start_date=?,process_complete_date=?,process_status=?,create_user=?,create_time=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,shop_order,sfc,operation,device,sfc_qty,resrce,frame_item_bo,frame_item,frame_item_revision,frame_model,frame_spec,compensation_value,single_qty,origin_strip_qty,needed_strip_qty,reprint_strip_qty,process_start_date,process_complete_date,process_status,create_user,create_time,updated_user,updated_time FROM zr_frame_process ";

  private final Connection conn;

  public FrameProcessDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FrameProcess data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getShopOrder());
      ps.setString(3, data.getSfc());
      ps.setString(4, data.getOperation());
      ps.setString(5, data.getDevice());
      ps.setString(6, data.getSfcQty());
      ps.setString(7, data.getResrce());
      ps.setString(8, data.getFrameItemBo());
      ps.setString(9, data.getFrameItem());
      ps.setString(10, data.getFrameItemRevision());
      ps.setString(11, data.getFrameModel());
      ps.setString(12, data.getFrameSpec());
      ps.setString(13, data.getCompensationValue());
      ps.setString(14, data.getSingleQty());
      ps.setString(15, data.getOriginStripQty());
      ps.setString(16, data.getNeededStripQty());
      ps.setString(17, data.getReprintStripQty());
      DateUtils.setDateTz(ps, 18, data.getProcessStartDate());
      DateUtils.setDateTz(ps, 19, data.getProcessCompleteDate());
      ps.setString(20, data.getProcessStatus());
      ps.setString(21, data.getCreateUser());
      DateUtils.setDateTz(ps, 22, data.getCreateTime());
      ps.setString(23, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 24, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FrameProcess> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FrameProcess data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getShopOrder());
        ps.setString(3, data.getSfc());
        ps.setString(4, data.getOperation());
        ps.setString(5, data.getDevice());
        ps.setString(6, data.getSfcQty());
        ps.setString(7, data.getResrce());
        ps.setString(8, data.getFrameItemBo());
        ps.setString(9, data.getFrameItem());
        ps.setString(10, data.getFrameItemRevision());
        ps.setString(11, data.getFrameModel());
        ps.setString(12, data.getFrameSpec());
        ps.setString(13, data.getCompensationValue());
        ps.setString(14, data.getSingleQty());
        ps.setString(15, data.getOriginStripQty());
        ps.setString(16, data.getNeededStripQty());
        ps.setString(17, data.getReprintStripQty());
        DateUtils.setDateTz(ps, 18, data.getProcessStartDate());
        DateUtils.setDateTz(ps, 19, data.getProcessCompleteDate());
        ps.setString(20, data.getProcessStatus());
        ps.setString(21, data.getCreateUser());
        DateUtils.setDateTz(ps, 22, data.getCreateTime());
        ps.setString(23, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 24, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FrameProcess data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getShopOrder());
      ps.setString(2, data.getSfc());
      ps.setString(3, data.getOperation());
      ps.setString(4, data.getDevice());
      ps.setString(5, data.getSfcQty());
      ps.setString(6, data.getResrce());
      ps.setString(7, data.getFrameItemBo());
      ps.setString(8, data.getFrameItem());
      ps.setString(9, data.getFrameItemRevision());
      ps.setString(10, data.getFrameModel());
      ps.setString(11, data.getFrameSpec());
      ps.setString(12, data.getCompensationValue());
      ps.setString(13, data.getSingleQty());
      ps.setString(14, data.getOriginStripQty());
      ps.setString(15, data.getNeededStripQty());
      ps.setString(16, data.getReprintStripQty());
      DateUtils.setDateTz(ps, 17, data.getProcessStartDate());
      DateUtils.setDateTz(ps, 18, data.getProcessCompleteDate());
      ps.setString(19, data.getProcessStatus());
      ps.setString(20, data.getCreateUser());
      DateUtils.setDateTz(ps, 21, data.getCreateTime());
      ps.setString(22, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 23, data.getUpdatedTime());
      ps.setString(24, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FrameProcess> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FrameProcess data : dataList) {
        ps.setString(1, data.getShopOrder());
        ps.setString(2, data.getSfc());
        ps.setString(3, data.getOperation());
        ps.setString(4, data.getDevice());
        ps.setString(5, data.getSfcQty());
        ps.setString(6, data.getResrce());
        ps.setString(7, data.getFrameItemBo());
        ps.setString(8, data.getFrameItem());
        ps.setString(9, data.getFrameItemRevision());
        ps.setString(10, data.getFrameModel());
        ps.setString(11, data.getFrameSpec());
        ps.setString(12, data.getCompensationValue());
        ps.setString(13, data.getSingleQty());
        ps.setString(14, data.getOriginStripQty());
        ps.setString(15, data.getNeededStripQty());
        ps.setString(16, data.getReprintStripQty());
        DateUtils.setDateTz(ps, 17, data.getProcessStartDate());
        DateUtils.setDateTz(ps, 18, data.getProcessCompleteDate());
        ps.setString(19, data.getProcessStatus());
        ps.setString(20, data.getCreateUser());
        DateUtils.setDateTz(ps, 21, data.getCreateTime());
        ps.setString(22, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 23, data.getUpdatedTime());
        ps.setString(24, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int resetReprintQty(String resrce) throws SQLException {
    String sql = "UPDATE zr_frame_process set reprint_strip_qty = 0 where resrce = ? and reprint_strip_qty > 0";
    try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
      ps.setString(1, resrce);
      return ps.executeUpdate();
    }
  }

  public int deductNeededStripQty(String resrce, int qty, String sfc) throws SQLException {
    String sql = "UPDATE zr_frame_process SET needed_strip_qty = needed_strip_qty - ? WHERE resrce = ? and sfc = ? AND needed_strip_qty >= ?";
    try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
      ps.setInt(1, qty);
      ps.setString(2, resrce);
      ps.setString(3, sfc);
      ps.setInt(4, qty);

      return ps.executeUpdate();
    }
  }

  public int updateStatus(String id, String sfc, String status) throws SQLException {
    String sql = "UPDATE zr_frame_process SET PROCESS_STATUS = ? WHERE sfc = ? and id = ?";
    try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
      ps.setString(1, status);
      ps.setString(2, sfc);
      ps.setString(3, id);
      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_frame_process WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<FrameProcess> selectAll() throws SQLException {
    ArrayList<FrameProcess> result = new ArrayList<FrameProcess>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FrameProcess> select(Where where) throws SQLException {
    ArrayList<FrameProcess> result = new ArrayList<FrameProcess>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public FrameProcess selectByPK(String id) throws SQLException {
    FrameProcess result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FrameProcess convert(ResultSet rs) throws SQLException {
    FrameProcess data = new FrameProcess();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setDevice(rs.getString(index++));
    data.setSfcQty(rs.getString(index++));
    data.setResrce(rs.getString(index++));
    data.setFrameItemBo(rs.getString(index++));
    data.setFrameItem(rs.getString(index++));
    data.setFrameItemRevision(rs.getString(index++));
    data.setFrameModel(rs.getString(index++));
    data.setFrameSpec(rs.getString(index++));
    data.setCompensationValue(rs.getString(index++));
    data.setSingleQty(rs.getString(index++));
    data.setOriginStripQty(rs.getString(index++));
    data.setNeededStripQty(rs.getString(index++));
    data.setReprintStripQty(rs.getString(index++));
    data.setProcessStartDate(DateUtils.getDateTz(rs, index++));
    data.setProcessCompleteDate(DateUtils.getDateTz(rs, index++));
    data.setProcessStatus(rs.getString(index++));
    data.setCreateUser(rs.getString(index++));
    data.setCreateTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
