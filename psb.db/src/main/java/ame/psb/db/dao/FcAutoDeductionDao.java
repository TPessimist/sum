package ame.psb.db.dao;

import ame.psb.db.FcAutoDeduction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FcAutoDeductionDao {

  private static final String SQL_INS = "INSERT INTO zr_fc_auto_deduction(sfc_bo,state_name,message,description,remarks,note,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_fc_auto_deduction SET state_name=?,message=?,description=?,remarks=?,note=?,updated_user=?,updated_time=? WHERE sfc_bo=?";

  private static final String SQL_SEL = "SELECT sfc_bo,state_name,message,description,remarks,note,updated_user,updated_time FROM zr_fc_auto_deduction ";

  private final Connection conn;

  public FcAutoDeductionDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FcAutoDeduction data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getStateName());
      ps.setString(3, data.getMessage());
      ps.setString(4, data.getDescription());
      ps.setString(5, data.getRemarks());
      ps.setString(6, data.getNote());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FcAutoDeduction> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FcAutoDeduction data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getStateName());
        ps.setString(3, data.getMessage());
        ps.setString(4, data.getDescription());
        ps.setString(5, data.getRemarks());
        ps.setString(6, data.getNote());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FcAutoDeduction data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getStateName());
      ps.setString(2, data.getMessage());
      ps.setString(3, data.getDescription());
      ps.setString(4, data.getRemarks());
      ps.setString(5, data.getNote());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getSfcBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<FcAutoDeduction> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FcAutoDeduction data : dataList) {
        ps.setString(1, data.getStateName());
        ps.setString(2, data.getMessage());
        ps.setString(3, data.getDescription());
        ps.setString(4, data.getRemarks());
        ps.setString(5, data.getNote());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getSfcBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_fc_auto_deduction WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      return ps.executeUpdate();
    }
  }

  public List<FcAutoDeduction> selectAll() throws SQLException {
    ArrayList<FcAutoDeduction> result = new ArrayList<FcAutoDeduction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FcAutoDeduction selectByPK(String sfcBo) throws SQLException {
    FcAutoDeduction result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<FcAutoDeduction> selectByStateName(String stateName) throws SQLException {
    ArrayList<FcAutoDeduction> result = new ArrayList<FcAutoDeduction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE state_name=?")) {
      ps.setString(1, stateName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private FcAutoDeduction convert(ResultSet rs) throws SQLException {
    FcAutoDeduction data = new FcAutoDeduction();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setMessage(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setRemarks(rs.getString(index++));
    data.setNote(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
