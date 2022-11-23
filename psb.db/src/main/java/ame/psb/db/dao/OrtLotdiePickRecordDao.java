package ame.psb.db.dao;

import ame.psb.db.OrtLotdiePickRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class OrtLotdiePickRecordDao {

  private static final String SQL_INS = "INSERT INTO zr_ort_lotdie_pick_record(sfc,lot,device,lot_type,content,value,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_ort_lotdie_pick_record SET lot=?,device=?,lot_type=?,content=?,value=?,updated_user=?,updated_time=? WHERE sfc=?";

  private static final String SQL_SEL = "SELECT sfc,lot,device,lot_type,content,value,updated_user,updated_time FROM zr_ort_lotdie_pick_record ";

  private final Connection conn;

  public OrtLotdiePickRecordDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(OrtLotdiePickRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfc());
      ps.setString(2, data.getLot());
      ps.setString(3, data.getDevice());
      ps.setString(4, data.getLotType());
      ps.setString(5, data.getContent());
      ps.setString(6, data.getValue());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<OrtLotdiePickRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (OrtLotdiePickRecord data : dataList) {
        ps.setString(1, data.getSfc());
        ps.setString(2, data.getLot());
        ps.setString(3, data.getDevice());
        ps.setString(4, data.getLotType());
        ps.setString(5, data.getContent());
        ps.setString(6, data.getValue());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(OrtLotdiePickRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getLot());
      ps.setString(2, data.getDevice());
      ps.setString(3, data.getLotType());
      ps.setString(4, data.getContent());
      ps.setString(5, data.getValue());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getSfc());

      return ps.executeUpdate();
    }
  }

  public int update(List<OrtLotdiePickRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (OrtLotdiePickRecord data : dataList) {
        ps.setString(1, data.getLot());
        ps.setString(2, data.getDevice());
        ps.setString(3, data.getLotType());
        ps.setString(4, data.getContent());
        ps.setString(5, data.getValue());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getSfc());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String sfc) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_ort_lotdie_pick_record WHERE sfc=?")) {
      ps.setString(1, sfc);

      return ps.executeUpdate();
    }
  }

  public List<OrtLotdiePickRecord> selectAll() throws SQLException {
    ArrayList<OrtLotdiePickRecord> result = new ArrayList<OrtLotdiePickRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public OrtLotdiePickRecord selectByPK(String sfc) throws SQLException {
    OrtLotdiePickRecord result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc=?")) {
      ps.setString(1, sfc);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<OrtLotdiePickRecord> selectByLotInWeek(String lot, String type, String beginDate,
      String endDate) throws SQLException {
    ArrayList<OrtLotdiePickRecord> result = new ArrayList<OrtLotdiePickRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE lot =? AND content =? AND updated_time >= ? AND updated_time <= ? ")) {
      ps.setString(1, lot);
      ps.setString(2, type);
      ps.setString(3, beginDate);
      ps.setString(4, endDate);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OrtLotdiePickRecord> selectByDeviceAndTime(String device, String beginDate,
      String endDate)
      throws SQLException {
    ArrayList<OrtLotdiePickRecord> result = new ArrayList<OrtLotdiePickRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE device =? and  updated_time >= ? AND updated_time <= ? ")) {
      ps.setString(1, device);
      ps.setString(2, beginDate);
      ps.setString(3, endDate);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OrtLotdiePickRecord> selectInWeek(String beginDate, String endDate)
      throws SQLException {
    ArrayList<OrtLotdiePickRecord> result = new ArrayList<OrtLotdiePickRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE updated_time >= ? AND updated_time <= ? ")) {
      ps.setString(1, beginDate);
      ps.setString(2, endDate);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private OrtLotdiePickRecord convert(ResultSet rs) throws SQLException {
    OrtLotdiePickRecord data = new OrtLotdiePickRecord();

    int index = 1;
    data.setSfc(rs.getString(index++));
    data.setLot(rs.getString(index++));
    data.setDevice(rs.getString(index++));
    data.setLotType(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
