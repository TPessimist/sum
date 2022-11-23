package ame.psb.db.dao;

import ame.psb.db.HoldBonedSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class HoldBonedSfcDao {

  private static final String SQL_INS = "INSERT INTO zr_hold_boned_sfc(hold_handle,sfc_bo,operation_bo,hold_code,hold_comment,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_hold_boned_sfc SET sfc_bo=?,operation_bo=?,hold_code=?,hold_comment=?,updated_time=? WHERE hold_handle=?";

  private static final String SQL_SEL = "SELECT hold_handle,sfc_bo,operation_bo,hold_code,hold_comment,updated_time FROM zr_hold_boned_sfc ";

  private final Connection conn;

  public HoldBonedSfcDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(HoldBonedSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHoldHandle());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getHoldCode());
      ps.setString(5, data.getHoldComment());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<HoldBonedSfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (HoldBonedSfc data : dataList) {
        ps.setString(1, data.getHoldHandle());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getHoldCode());
        ps.setString(5, data.getHoldComment());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(HoldBonedSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getHoldCode());
      ps.setString(4, data.getHoldComment());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getHoldHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<HoldBonedSfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (HoldBonedSfc data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getHoldCode());
        ps.setString(4, data.getHoldComment());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getHoldHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String holdHandle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_hold_boned_sfc WHERE hold_handle=?")) {
      ps.setString(1, holdHandle);

      return ps.executeUpdate();
    }
  }

  public List<HoldBonedSfc> selectAll() throws SQLException {
    ArrayList<HoldBonedSfc> result = new ArrayList<HoldBonedSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public HoldBonedSfc selectByPK(String holdHandle) throws SQLException {
    HoldBonedSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE hold_handle=?")) {
      ps.setString(1, holdHandle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private HoldBonedSfc convert(ResultSet rs) throws SQLException {
    HoldBonedSfc data = new HoldBonedSfc();

    int index = 1;
    data.setHoldHandle(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setHoldCode(rs.getString(index++));
    data.setHoldComment(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
