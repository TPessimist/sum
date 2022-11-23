package ame.psb.db.dao;

import ame.psb.db.CarrierReel;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CarrierReelDao {

  private static final String SQL_INS = "INSERT INTO zd_carrier_reel(carrier_bo,slot_no,reel_id,CONTAINER_NAME, QR_CODE,state_name,reserve_field1,reserve_field2,CREATED_USER, CREATED_TIME,updated_user,updated_time,dn) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_carrier_reel SET reel_id=?,CONTAINER_NAME=?, QR_CODE=?,state_name=?,reserve_field1=?,reserve_field2=?,CREATED_USER=?, CREATED_TIME=?,updated_user=?,updated_time=?,dn=? WHERE carrier_bo=? AND slot_no=?";

  private static final String SQL_SEL = "SELECT carrier_bo,slot_no,reel_id,CONTAINER_NAME, QR_CODE,state_name,reserve_field1,reserve_field2,CREATED_USER, CREATED_TIME,updated_user,updated_time,dn FROM zd_carrier_reel ";

  private final Connection conn;

  public CarrierReelDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CarrierReel data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCarrierBo());
      ps.setBigDecimal(2, data.getSlotNo());
      ps.setString(3, data.getReelId());
      ps.setString(4, data.getContainerName());
      ps.setString(5, data.getQrCode());
      ps.setString(6, data.getStateName());
      ps.setString(7, data.getReserveField1());
      ps.setString(8, data.getReserveField2());
      ps.setString(9, data.getCreatedUser());
      DateUtils.setDateTz(ps, 10, data.getCreatedTime());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
      ps.setString(13, data.getDn());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CarrierReel> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CarrierReel data : dataList) {
        ps.setString(1, data.getCarrierBo());
        ps.setBigDecimal(2, data.getSlotNo());
        ps.setString(3, data.getReelId());
        ps.setString(4, data.getContainerName());
        ps.setString(5, data.getQrCode());
        ps.setString(6, data.getStateName());
        ps.setString(7, data.getReserveField1());
        ps.setString(8, data.getReserveField2());
        ps.setString(9, data.getCreatedUser());
        DateUtils.setDateTz(ps, 10, data.getCreatedTime());
        ps.setString(11, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
        ps.setString(13, data.getDn());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CarrierReel data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getReelId());
      ps.setString(2, data.getContainerName());
      ps.setString(3, data.getQrCode());
      ps.setString(4, data.getStateName());
      ps.setString(5, data.getReserveField1());
      ps.setString(6, data.getReserveField2());
      ps.setString(7, data.getCreatedUser());
      DateUtils.setDateTz(ps, 8, data.getCreatedTime());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
      ps.setString(11, data.getDn());
      ps.setString(12, data.getCarrierBo());
      ps.setBigDecimal(13, data.getSlotNo());

      return ps.executeUpdate();
    }
  }

  public int update(List<CarrierReel> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CarrierReel data : dataList) {
        ps.setString(1, data.getReelId());
        ps.setString(2, data.getContainerName());
        ps.setString(3, data.getQrCode());
        ps.setString(4, data.getStateName());
        ps.setString(5, data.getReserveField1());
        ps.setString(6, data.getReserveField2());
        ps.setString(7, data.getCreatedUser());
        DateUtils.setDateTz(ps, 8, data.getCreatedTime());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
        ps.setString(11, data.getDn());
        ps.setString(12, data.getCarrierBo());
        ps.setBigDecimal(13, data.getSlotNo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String carrierBo, BigDecimal slotNo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_carrier_reel WHERE carrier_bo=? AND slot_no=?")) {
      ps.setString(1, carrierBo);
      ps.setBigDecimal(2, slotNo);

      return ps.executeUpdate();
    }
  }

  public int deleteByCarrier(String carrierBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_carrier_reel WHERE carrier_bo=? ")) {
      ps.setString(1, carrierBo);

      return ps.executeUpdate();
    }
  }

  public int deleteByReelId(String reelId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_carrier_reel WHERE reel_id=? ")) {
      ps.setString(1, reelId);

      return ps.executeUpdate();
    }
  }

  public List<CarrierReel> selectAll() throws SQLException {
    ArrayList<CarrierReel> result = new ArrayList<CarrierReel>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public CarrierReel selectByPK(String carrierBo, BigDecimal slotNo) throws SQLException {
    CarrierReel result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE carrier_bo=? AND slot_no=?")) {
      ps.setString(1, carrierBo);
      ps.setBigDecimal(2, slotNo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public CarrierReel selectByReelIdAndSlotNo(String reelId, BigDecimal slotNo) throws SQLException {
    CarrierReel result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE reel_id=? AND slot_no=?")) {
      ps.setString(1, reelId);
      ps.setBigDecimal(2, slotNo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<CarrierReel> selectByCarrier(String carrierBo) throws SQLException {
    ArrayList<CarrierReel> result = new ArrayList<CarrierReel>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE carrier_bo=?")) {
      ps.setString(1, carrierBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public CarrierReel selectByReel(String reelId) throws SQLException {
    CarrierReel result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE reel_id=?")) {
      ps.setString(1, reelId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public CarrierReel selectByCarrierAndReel(String carrierBo, String reelId) throws SQLException {
    CarrierReel result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE carrier_bo=? AND reel_id=?")) {
      ps.setString(1, carrierBo);
      ps.setString(2, reelId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<CarrierReel> selectByCarrierOrderSlot(String carrierBo) throws SQLException {
    ArrayList<CarrierReel> result = new ArrayList<CarrierReel>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE carrier_bo=? ORDER BY slot_no ASC ")) {
      ps.setString(1, carrierBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private CarrierReel convert(ResultSet rs) throws SQLException {
    CarrierReel data = new CarrierReel();

    int index = 1;
    data.setCarrierBo(rs.getString(index++));
    data.setSlotNo(rs.getBigDecimal(index++));
    data.setReelId(rs.getString(index++));
    data.setContainerName(rs.getString(index++));
    data.setQrCode(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setReserveField1(rs.getString(index++));
    data.setReserveField2(rs.getString(index++));
    data.setCreatedUser(rs.getString(index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setDn(rs.getString(index++));

    return data;
  }
}
