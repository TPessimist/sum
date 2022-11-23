package ame.sap.db.dao;

import ame.sap.db.FoDaLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FoDaLogDao {

  private static final String SQL_INS = "INSERT INTO zr_fo_da_log(sfc_name,si_id,wafer_id,wafer_die_qty,file_name,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_fo_da_log SET sfc_name=?,wafer_die_qty=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE si_id=? AND wafer_id=? AND file_name=?";

  private static final String SQL_SEL = "SELECT sfc_name,si_id,wafer_id,wafer_die_qty,file_name,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_fo_da_log ";

  private final Connection conn;

  public FoDaLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FoDaLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcName());
      ps.setString(2, data.getSiId());
      ps.setString(3, data.getWaferId());
      ps.setString(4, data.getWaferDieQty());
      ps.setString(5, data.getFileName());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FoDaLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FoDaLog data : dataList) {
        ps.setString(1, data.getSfcName());
        ps.setString(2, data.getSiId());
        ps.setString(3, data.getWaferId());
        ps.setString(4, data.getWaferDieQty());
        ps.setString(5, data.getFileName());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FoDaLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcName());
      ps.setString(2, data.getWaferDieQty());
      ps.setString(3, data.getReversedField1());
      ps.setString(4, data.getReversedField2());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getSiId());
      ps.setString(8, data.getWaferId());
      ps.setString(9, data.getFileName());

      return ps.executeUpdate();
    }
  }

  public int update(List<FoDaLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FoDaLog data : dataList) {
        ps.setString(1, data.getSfcName());
        ps.setString(2, data.getWaferDieQty());
        ps.setString(3, data.getReversedField1());
        ps.setString(4, data.getReversedField2());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getSiId());
        ps.setString(8, data.getWaferId());
        ps.setString(9, data.getFileName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String siId, String waferId, String fileName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_fo_da_log WHERE si_id=? AND wafer_id=? AND file_name=?")) {
      ps.setString(1, siId);
      ps.setString(2, waferId);
      ps.setString(3, fileName);

      return ps.executeUpdate();
    }
  }

  public List<FoDaLog> selectAll() throws SQLException {
    ArrayList<FoDaLog> result = new ArrayList<FoDaLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FoDaLog selectByPK(String siId, String waferId, String fileName) throws SQLException {
    FoDaLog result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE si_id=? AND wafer_id=? AND file_name=?")) {
      ps.setString(1, siId);
      ps.setString(2, waferId);
      ps.setString(3, fileName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<FoDaLog> selectBySfc(String sfc) throws SQLException { //根据生产批号查记录
    ArrayList<FoDaLog> result = new ArrayList<FoDaLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_name=?  ")) {
      ps.setString(1, sfc);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FoDaLog> selectBySfcAndWafer(String sfc, String wafer)
      throws SQLException { //根据生产批号和晶圆查要消耗的片号
    ArrayList<FoDaLog> result = new ArrayList<FoDaLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_name=? AND SI_ID=? ")) {
      ps.setString(1, sfc);
      ps.setString(2, wafer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private FoDaLog convert(ResultSet rs) throws SQLException {
    FoDaLog data = new FoDaLog();

    int index = 1;
    data.setSfcName(rs.getString(index++));
    data.setSiId(rs.getString(index++));
    data.setWaferId(rs.getString(index++));
    data.setWaferDieQty(rs.getString(index++));
    data.setFileName(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
