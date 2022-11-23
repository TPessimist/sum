package ame.psb.db.dao;

import ame.psb.db.FcResrcePlatingAnalysis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FcResrcePlatingAnalysisDao {

  private static final String SQL_INS = "INSERT INTO fc_resrce_plating_analysis(resource_no,slot_no,slot_name,plating_name,final_value,first_value,analysis_value,suggested_dosage,add_theory_conc,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_INS_CALC = "INSERT INTO fc_resrce_plating_analysis_calc(resource_no,slot_no,slot_name,plating_name,final_value,first_value,analysis_value,suggested_dosage,add_theory_conc,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_INS_HIS = "INSERT INTO fc_resrce_plating_analysis_his(resource_no,slot_no,slot_name,plating_name,final_value,first_value,analysis_value,suggested_dosage,add_theory_conc,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE fc_resrce_plating_analysis SET slot_name=?,final_value=?,first_value=?,analysis_value=?,suggested_dosage=?,add_theory_conc=?,updated_user=?,updated_time=? WHERE resource_no=? AND slot_no=? AND plating_name=?";

  private static final String SQL_UPD1 = "UPDATE fc_resrce_plating_analysis SET work_class=? WHERE resource_no=? AND slot_no=? AND plating_name=?";

  private static final String SQL_UPD2 = "UPDATE fc_resrce_plating_analysis_his SET work_class=? WHERE resource_no=? AND slot_no=? AND plating_name=? AND updated_time=?";

  private static final String SQL_UPD3 = "UPDATE fc_resrce_plating_analysis_calc SET work_class=? WHERE resource_no=? AND slot_no=? AND plating_name=?";

  private static final String SQL_UPD_PRINT = "UPDATE fc_resrce_plating_analysis_calc SET print_id=? WHERE resource_no=? AND slot_no=? AND plating_name=?";
  private static final String SQL_SEL = "SELECT resource_no,slot_no,slot_name,plating_name,final_value,first_value,analysis_value,suggested_dosage,add_theory_conc,updated_user,updated_time FROM fc_resrce_plating_analysis ";

  private static final String SQL_SEL_CALC = "SELECT resource_no,slot_no,slot_name,plating_name,final_value,first_value,analysis_value,suggested_dosage,add_theory_conc,updated_user,updated_time,print_id FROM fc_resrce_plating_analysis_calc ";

  private static final String SQL_SEL_HIS = "SELECT resource_no,slot_no,slot_name,plating_name,final_value,first_value,analysis_value,suggested_dosage,add_theory_conc,updated_user,updated_time FROM fc_resrce_plating_analysis_his ";

  private final Connection conn;

  public FcResrcePlatingAnalysisDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FcResrcePlatingAnalysis data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResourceNo());
      ps.setString(2, data.getSlotNo());
      ps.setString(3, data.getSlotName());
      ps.setString(4, data.getPlatingName());
      ps.setBigDecimal(5, data.getFinalValue());
      ps.setBigDecimal(6, data.getFirstValue());
      ps.setBigDecimal(7, data.getAnalysisValue());
      ps.setBigDecimal(8, data.getSuggestedDosage());
      ps.setBigDecimal(9, data.getAddTheoryConc());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insertCalc(FcResrcePlatingAnalysis data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS_CALC)) {
      ps.setString(1, data.getResourceNo());
      ps.setString(2, data.getSlotNo());
      ps.setString(3, data.getSlotName());
      ps.setString(4, data.getPlatingName());
      ps.setBigDecimal(5, data.getFinalValue());
      ps.setBigDecimal(6, data.getFirstValue());
      ps.setBigDecimal(7, data.getAnalysisValue());
      ps.setBigDecimal(8, data.getSuggestedDosage());
      ps.setBigDecimal(9, data.getAddTheoryConc());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insertHis(FcResrcePlatingAnalysis data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS_HIS)) {
      ps.setString(1, data.getResourceNo());
      ps.setString(2, data.getSlotNo());
      ps.setString(3, data.getSlotName());
      ps.setString(4, data.getPlatingName());
      ps.setBigDecimal(5, data.getFinalValue());
      ps.setBigDecimal(6, data.getFirstValue());
      ps.setBigDecimal(7, data.getAnalysisValue());
      ps.setBigDecimal(8, data.getSuggestedDosage());
      ps.setBigDecimal(9, data.getAddTheoryConc());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FcResrcePlatingAnalysis> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FcResrcePlatingAnalysis data : dataList) {
        ps.setString(1, data.getResourceNo());
        ps.setString(2, data.getSlotNo());
        ps.setString(3, data.getSlotName());
        ps.setString(4, data.getPlatingName());
        ps.setBigDecimal(5, data.getFinalValue());
        ps.setBigDecimal(6, data.getFirstValue());
        ps.setBigDecimal(7, data.getAnalysisValue());
        ps.setBigDecimal(8, data.getSuggestedDosage());
        ps.setBigDecimal(9, data.getAddTheoryConc());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FcResrcePlatingAnalysis data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSlotName());
      ps.setBigDecimal(2, data.getFinalValue());
      ps.setBigDecimal(3, data.getFirstValue());
      ps.setBigDecimal(4, data.getAnalysisValue());
      ps.setBigDecimal(5, data.getSuggestedDosage());
      ps.setBigDecimal(6, data.getAddTheoryConc());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getResourceNo());
      ps.setString(10, data.getSlotNo());
      ps.setString(11, data.getPlatingName());

      return ps.executeUpdate();
    }
  }

  public int update1(String resourceNo, String slotNo,
      String platingName, String workClass) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD1)) {
      ps.setString(1, workClass);
      ps.setString(2, resourceNo);
      ps.setString(3, slotNo);
      ps.setString(4, platingName);

      return ps.executeUpdate();
    }
  }

  public int update2(String resourceNo, String slotNo,
      String platingName, String workClass, Date Date) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD2)) {
      ps.setString(1, workClass);
      ps.setString(2, resourceNo);
      ps.setString(3, slotNo);
      ps.setString(4, platingName);

      DateUtils.setDateTz(ps, 5, Date);
      return ps.executeUpdate();
    }
  }

  public int update3(String resourceNo, String slotNo,
      String platingName, String workClass) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD3)) {
      ps.setString(1, workClass);
      ps.setString(2, resourceNo);
      ps.setString(3, slotNo);
      ps.setString(4, platingName);

      return ps.executeUpdate();
    }
  }

  public int updatePrint(String resourceNo, String slotNo,
      String platingName, String printId) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_PRINT)) {
      ps.setString(1, printId);
      ps.setString(2, resourceNo);
      ps.setString(3, slotNo);
      ps.setString(4, platingName);

      return ps.executeUpdate();
    }
  }

  public int update(List<FcResrcePlatingAnalysis> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FcResrcePlatingAnalysis data : dataList) {
        ps.setString(1, data.getSlotName());
        ps.setBigDecimal(2, data.getFinalValue());
        ps.setBigDecimal(3, data.getFirstValue());
        ps.setBigDecimal(4, data.getAnalysisValue());
        ps.setBigDecimal(5, data.getSuggestedDosage());
        ps.setBigDecimal(6, data.getAddTheoryConc());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
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
        "DELETE FROM fc_resrce_plating_analysis WHERE resource_no=? AND slot_no=? AND plating_name=?")) {
      ps.setString(1, resourceNo);
      ps.setString(2, slotNo);
      ps.setString(3, platingName);

      return ps.executeUpdate();
    }
  }

  public int deleteCalc(String resourceNo, String slotNo, String platingName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM fc_resrce_plating_analysis_calc WHERE resource_no=? AND slot_no=? AND plating_name=?")) {
      ps.setString(1, resourceNo);
      ps.setString(2, slotNo);
      ps.setString(3, platingName);

      return ps.executeUpdate();
    }
  }

  public int delete(String resourceNo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM fc_resrce_plating_analysis WHERE resource_no=?")) {
      ps.setString(1, resourceNo);

      return ps.executeUpdate();
    }
  }

  public List<FcResrcePlatingAnalysis> selectAll() throws SQLException {
    ArrayList<FcResrcePlatingAnalysis> result = new ArrayList<FcResrcePlatingAnalysis>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public FcResrcePlatingAnalysis selectByPK(String resourceNo, String slotNo, String platingName)
      throws SQLException {
    FcResrcePlatingAnalysis result = null;
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

  public FcResrcePlatingAnalysis selectCalcByPK(String resourceNo, String slotNo,
      String platingName) throws SQLException {
    FcResrcePlatingAnalysis result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_CALC + "WHERE resource_no=? AND slot_no=? AND plating_name=?")) {
      ps.setString(1, resourceNo);
      ps.setString(2, slotNo);
      ps.setString(3, platingName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convertCalc(rs);
      }
      return result;
    }
  }

  public List<FcResrcePlatingAnalysis> selectByResource(String resource) throws SQLException {
    ArrayList<FcResrcePlatingAnalysis> result = new ArrayList<FcResrcePlatingAnalysis>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_no=?")) {
      ps.setString(1, resource);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private FcResrcePlatingAnalysis convert(ResultSet rs) throws SQLException {
    FcResrcePlatingAnalysis data = new FcResrcePlatingAnalysis();

    int index = 1;
    data.setResourceNo(rs.getString(index++));
    data.setSlotNo(rs.getString(index++));
    data.setSlotName(rs.getString(index++));
    data.setPlatingName(rs.getString(index++));
    data.setFinalValue(rs.getBigDecimal(index++));
    data.setFirstValue(rs.getBigDecimal(index++));
    data.setAnalysisValue(rs.getBigDecimal(index++));
    data.setSuggestedDosage(rs.getBigDecimal(index++));
    data.setAddTheoryConc(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }

  private FcResrcePlatingAnalysis convertCalc(ResultSet rs) throws SQLException {
    FcResrcePlatingAnalysis data = new FcResrcePlatingAnalysis();

    int index = 1;
    data.setResourceNo(rs.getString(index++));
    data.setSlotNo(rs.getString(index++));
    data.setSlotName(rs.getString(index++));
    data.setPlatingName(rs.getString(index++));
    data.setFinalValue(rs.getBigDecimal(index++));
    data.setFirstValue(rs.getBigDecimal(index++));
    data.setAnalysisValue(rs.getBigDecimal(index++));
    data.setSuggestedDosage(rs.getBigDecimal(index++));
    data.setAddTheoryConc(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setPrintId(rs.getString(index++));

    return data;
  }
}
