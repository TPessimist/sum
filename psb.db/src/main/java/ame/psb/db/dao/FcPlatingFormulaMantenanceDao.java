package ame.psb.db.dao;

import ame.psb.db.FcPlatingFormulaMantenance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FcPlatingFormulaMantenanceDao {

  private static final String SQL_INS = "INSERT INTO fc_plating_formula_mantenance(resource_no,slot_no,slot_name,plating_name,modulus,solution_name,plating_conc,deoxidation_flag,formula_desc,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE fc_plating_formula_mantenance SET modulus=?,solution_name=?,plating_conc=?,deoxidation_flag=?,formula_desc=?,updated_user=?,updated_time=?,slot_name=? WHERE resource_no=? AND slot_no=? AND plating_name=?";

  private static final String SQL_SEL = "SELECT resource_no,slot_no,slot_name,plating_name,modulus,solution_name,plating_conc,deoxidation_flag,formula_desc,updated_user,updated_time FROM fc_plating_formula_mantenance ";

  private final Connection conn;

  public FcPlatingFormulaMantenanceDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FcPlatingFormulaMantenance data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResourceNo());
      ps.setString(2, data.getSlotNo());
      ps.setString(3, data.getSlotName());
      ps.setString(4, data.getPlatingName());
      ps.setBigDecimal(5, data.getModulus());
      ps.setString(6, data.getSolutionName());
      ps.setBigDecimal(7, data.getPlatingConc());
      ps.setBoolean(8, data.isDeoxidationFlag());
      ps.setString(9, data.getFormulaDesc());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FcPlatingFormulaMantenance> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FcPlatingFormulaMantenance data : dataList) {
        ps.setString(1, data.getResourceNo());
        ps.setString(2, data.getSlotNo());

        ps.setString(3, data.getSlotName());
        ps.setString(4, data.getPlatingName());
        ps.setBigDecimal(5, data.getModulus());
        ps.setString(6, data.getSolutionName());
        ps.setBigDecimal(7, data.getPlatingConc());
        ps.setBoolean(8, data.isDeoxidationFlag());
        ps.setString(9, data.getFormulaDesc());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FcPlatingFormulaMantenance data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getModulus());
      ps.setString(2, data.getSolutionName());
      ps.setBigDecimal(3, data.getPlatingConc());
      ps.setBoolean(4, data.isDeoxidationFlag());
      ps.setString(5, data.getFormulaDesc());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getSlotName());

      ps.setString(9, data.getResourceNo());
      ps.setString(10, data.getSlotNo());
      ps.setString(11, data.getPlatingName());

      return ps.executeUpdate();
    }
  }

  public int update(List<FcPlatingFormulaMantenance> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FcPlatingFormulaMantenance data : dataList) {
        ps.setBigDecimal(1, data.getModulus());
        ps.setString(2, data.getSolutionName());
        ps.setBigDecimal(3, data.getPlatingConc());
        ps.setBoolean(4, data.isDeoxidationFlag());
        ps.setString(5, data.getFormulaDesc());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getSlotName());

        ps.setString(9, data.getResourceNo());
        ps.setString(10, data.getSlotNo());
        ps.setString(11, data.getPlatingName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resourceNo, String slotNo, String platingName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM fc_plating_formula_mantenance WHERE resource_no=? AND slot_no=? AND plating_name=?")) {
      ps.setString(1, resourceNo);
      ps.setString(2, slotNo);
      ps.setString(3, platingName);

      return ps.executeUpdate();
    }
  }

  public int delete(String resourceNo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM fc_plating_formula_mantenance WHERE resource_no=?")) {
      ps.setString(1, resourceNo);

      return ps.executeUpdate();
    }
  }

  public List<FcPlatingFormulaMantenance> selectAll() throws SQLException {
    ArrayList<FcPlatingFormulaMantenance> result = new ArrayList<FcPlatingFormulaMantenance>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FcPlatingFormulaMantenance selectByPK(String resourceNo, String slotNo, String platingName)
      throws SQLException {
    FcPlatingFormulaMantenance result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_no=? AND slot_no=? AND plating_name=?")) {
      ps.setString(1, resourceNo);
      ps.setString(2, slotNo);
      ps.setString(3, platingName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<FcPlatingFormulaMantenance> selectByResource(String resource) throws SQLException {
    ArrayList<FcPlatingFormulaMantenance> result = new ArrayList<FcPlatingFormulaMantenance>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_no=? ORDER BY plating_name ASC")) {
      ps.setString(1, resource);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private FcPlatingFormulaMantenance convert(ResultSet rs) throws SQLException {
    FcPlatingFormulaMantenance data = new FcPlatingFormulaMantenance();

    int index = 1;
    data.setResourceNo(rs.getString(index++));
    data.setSlotNo(rs.getString(index++));
    data.setSlotName(rs.getString(index++));
    data.setPlatingName(rs.getString(index++));
    data.setModulus(rs.getBigDecimal(index++));
    data.setSolutionName(rs.getString(index++));
    data.setPlatingConc(rs.getBigDecimal(index++));
    data.setDeoxidationFlag(rs.getBoolean(index++));
    data.setFormulaDesc(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
