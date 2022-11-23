package ame.psb.db.dao;

import ame.psb.db.SmartStorageCarrierPositionRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SmartStorageCarrierPositionRecordDao {

  private static final String SQL_INS = "INSERT INTO zr_smart_storage_carrier_position_record(carrier_bo,position_bo,slot_max_no,updated_user,updated_time) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_smart_storage_carrier_position_record SET position_bo=?,slot_max_no=?,updated_user=?,updated_time=? WHERE carrier_bo=?";

  private static final String SQL_SEL = "SELECT carrier_bo,position_bo,slot_max_no,updated_user,updated_time FROM zr_smart_storage_carrier_position_record ";

  private final Connection conn;

  public SmartStorageCarrierPositionRecordDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SmartStorageCarrierPositionRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCarrierBo());
      ps.setString(2, data.getPositionBo());
      ps.setBigDecimal(3, data.getSlotMaxNo());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SmartStorageCarrierPositionRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SmartStorageCarrierPositionRecord data : dataList) {
        ps.setString(1, data.getCarrierBo());
        ps.setString(2, data.getPositionBo());
        ps.setBigDecimal(3, data.getSlotMaxNo());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SmartStorageCarrierPositionRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getPositionBo());
      ps.setBigDecimal(2, data.getSlotMaxNo());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getCarrierBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<SmartStorageCarrierPositionRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SmartStorageCarrierPositionRecord data : dataList) {
        ps.setString(1, data.getPositionBo());
        ps.setBigDecimal(2, data.getSlotMaxNo());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getCarrierBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String carrierBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_smart_storage_carrier_position_record WHERE carrier_bo=?")) {
      ps.setString(1, carrierBo);

      return ps.executeUpdate();
    }
  }

  public List<SmartStorageCarrierPositionRecord> selectAll() throws SQLException {
    ArrayList<SmartStorageCarrierPositionRecord> result = new ArrayList<SmartStorageCarrierPositionRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SmartStorageCarrierPositionRecord> selectByCarrier(String carrierBo) throws SQLException {
    ArrayList<SmartStorageCarrierPositionRecord> result = new ArrayList<SmartStorageCarrierPositionRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE carrier_bo=?")) {
      ps.setString(1, carrierBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public SmartStorageCarrierPositionRecord selectByPK(String carrierBo) throws SQLException {
    SmartStorageCarrierPositionRecord result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE carrier_bo=?")) {
      ps.setString(1, carrierBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SmartStorageCarrierPositionRecord convert(ResultSet rs) throws SQLException {
    SmartStorageCarrierPositionRecord data = new SmartStorageCarrierPositionRecord();

    int index = 1;
    data.setCarrierBo(rs.getString(index++));
    data.setPositionBo(rs.getString(index++));
    data.setSlotMaxNo(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
