package ame.psb.db.dao;

import ame.psb.db.TransferSfcRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class TransferSfcRecordDao {

  private static final String SQL_INS = "INSERT INTO zr_transfer_sfc_record(id,sfc_bo,area,user_id,item_qty,operation_bo,created_time,created_user) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_transfer_sfc_record SET sfc_bo=?,area=?,user_id=?,item_qty=?,operation_bo=?,created_time=?,created_user=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sfc_bo,area,user_id,item_qty,operation_bo,created_time,created_user FROM zr_transfer_sfc_record ";

  private final Connection conn;

  public TransferSfcRecordDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(TransferSfcRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getArea());
      ps.setString(4, data.getUserId());
      ps.setInt(5, data.getItemQty());
      ps.setString(6, data.getOperationBo());
      DateUtils.setDateTz(ps, 7, data.getCreatedTime());
      ps.setString(8, data.getCreatedUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<TransferSfcRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (TransferSfcRecord data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getArea());
        ps.setString(4, data.getUserId());
        ps.setInt(5, data.getItemQty());
        ps.setString(6, data.getOperationBo());
        DateUtils.setDateTz(ps, 7, data.getCreatedTime());
        ps.setString(8, data.getCreatedUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(TransferSfcRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getArea());
      ps.setString(3, data.getUserId());
      ps.setInt(4, data.getItemQty());
      ps.setString(5, data.getOperationBo());
      DateUtils.setDateTz(ps, 6, data.getCreatedTime());
      ps.setString(7, data.getCreatedUser());
      ps.setString(8, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<TransferSfcRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (TransferSfcRecord data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getArea());
        ps.setString(3, data.getUserId());
        ps.setInt(4, data.getItemQty());
        ps.setString(5, data.getOperationBo());
        DateUtils.setDateTz(ps, 6, data.getCreatedTime());
        ps.setString(7, data.getCreatedUser());
        ps.setString(8, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_transfer_sfc_record WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<TransferSfcRecord> selectAll() throws SQLException {
    ArrayList<TransferSfcRecord> result = new ArrayList<TransferSfcRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public TransferSfcRecord selectByPK(String id) throws SQLException {
    TransferSfcRecord result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public List<TransferSfcRecord> selectForCheck(String sfcBo, String operationBo, String area,
      Date dateQueued) throws SQLException {
    List<TransferSfcRecord> results = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE sfc_bo=? and operation_bo=? and area=? and created_time>? ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);
      ps.setString(3, area);
      DateUtils.setDateTz(ps, 4, dateQueued);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        results.add(this.convert(rs));
      }
      return results;
    }
  }


  private TransferSfcRecord convert(ResultSet rs) throws SQLException {
    TransferSfcRecord data = new TransferSfcRecord();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setArea(rs.getString(index++));
    data.setUserId(rs.getString(index++));
    data.setItemQty(rs.getInt(index++));
    data.setOperationBo(rs.getString(index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));
    data.setCreatedUser(rs.getString(index++));

    return data;
  }
}
