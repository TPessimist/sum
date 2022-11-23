package ame.psb.db.dao;

import ame.psb.db.FcResrcePlatingPrint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FcResrcePlatingPrintDao {

  private static final String SQL_INS = "INSERT INTO fc_resrce_plating_analysis_print(print_id,slot_no,plating_name,item,inventory_ids,suggested_dosage,analysis_user,analysis_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE fc_resrce_plating_analysis_print SET slot_no=?,plating_name=?,item=?,inventory_ids=?,suggested_dosage=?,analysis_user=?,analysis_time=? WHERE print_id=?";

  private static final String SQL_SEL = "SELECT print_id,slot_no,plating_name,item,inventory_ids,suggested_dosage,analysis_user,analysis_time FROM fc_resrce_plating_analysis_print ";

  private final Connection conn;

  public FcResrcePlatingPrintDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FcResrcePlatingPrint data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getPrintId());
      ps.setString(2, data.getSlotNo());
      ps.setString(3, data.getPlatingName());
      ps.setString(4, data.getItem());
      ps.setString(5, data.getInventoryIds());
      ps.setBigDecimal(6, data.getSuggestedDosage());
      ps.setString(7, data.getAnalysisUser());
      ps.setString(8, data.getAnalysisTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FcResrcePlatingPrint> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FcResrcePlatingPrint data : dataList) {
        ps.setString(1, data.getPrintId());
        ps.setString(2, data.getSlotNo());
        ps.setString(3, data.getPlatingName());
        ps.setString(4, data.getItem());
        ps.setString(5, data.getInventoryIds());
        ps.setBigDecimal(6, data.getSuggestedDosage());
        ps.setString(7, data.getAnalysisUser());
        ps.setString(8, data.getAnalysisTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FcResrcePlatingPrint data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSlotNo());
      ps.setString(2, data.getPlatingName());
      ps.setString(3, data.getItem());
      ps.setString(4, data.getInventoryIds());
      ps.setBigDecimal(5, data.getSuggestedDosage());
      ps.setString(6, data.getAnalysisUser());
      ps.setString(7, data.getAnalysisTime());
      ps.setString(8, data.getPrintId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FcResrcePlatingPrint> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FcResrcePlatingPrint data : dataList) {
        ps.setString(1, data.getSlotNo());
        ps.setString(2, data.getPlatingName());
        ps.setString(3, data.getItem());
        ps.setString(4, data.getInventoryIds());
        ps.setBigDecimal(5, data.getSuggestedDosage());
        ps.setString(6, data.getAnalysisUser());
        ps.setString(7, data.getAnalysisTime());
        ps.setString(8, data.getPrintId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String printId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM fc_resrce_plating_analysis_print WHERE print_id=?")) {
      ps.setString(1, printId);

      return ps.executeUpdate();
    }
  }

  public List<FcResrcePlatingPrint> selectAll() throws SQLException {
    ArrayList<FcResrcePlatingPrint> result = new ArrayList<FcResrcePlatingPrint>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FcResrcePlatingPrint selectByPK(String printId) throws SQLException {
    FcResrcePlatingPrint result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE print_id=?")) {
      ps.setString(1, printId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FcResrcePlatingPrint convert(ResultSet rs) throws SQLException {
    FcResrcePlatingPrint data = new FcResrcePlatingPrint();

    int index = 1;
    data.setPrintId(rs.getString(index++));
    data.setSlotNo(rs.getString(index++));
    data.setPlatingName(rs.getString(index++));
    data.setItem(rs.getString(index++));
    data.setInventoryIds(rs.getString(index++));
    data.setSuggestedDosage(rs.getBigDecimal(index++));
    data.setAnalysisUser(rs.getString(index++));
    data.setAnalysisTime(rs.getString(index++));

    return data;
  }
}
