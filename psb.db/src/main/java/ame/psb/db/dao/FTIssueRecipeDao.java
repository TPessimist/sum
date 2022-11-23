package ame.psb.db.dao;

import ame.psb.db.FTIssueRecipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class FTIssueRecipeDao {

  private static final String SQL_INS = "INSERT INTO zr_ft_issue_recipe(id,customer_device,customer_lot,operation_bo,device_name,equipment,process,sfc_bo,recipe_name,test_program,updated_user,updated_time,request_id,active) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_ft_issue_recipe SET customer_device=?,customer_lot=?,operation_bo=?,device_name=?,equipment=?,process=?,sfc_bo=?,recipe_name=?,test_program=?,updated_user=?,updated_time=?,request_id=?,active=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,customer_device,customer_lot,operation_bo,device_name,equipment,process,sfc_bo,recipe_name,test_program,updated_user,updated_time,request_id,active FROM zr_ft_issue_recipe ";

  private final Connection conn;

  public FTIssueRecipeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FTIssueRecipe data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getCustomerDevice());
      ps.setString(3, data.getCustomerLot());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getDeviceName());
      ps.setString(6, data.getEquipment());
      ps.setString(7, data.getProcess());
      ps.setString(8, data.getSfcBo());
      ps.setString(9, data.getRecipeName());
      ps.setString(10, data.getTestProgram());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
      ps.setString(13, data.getRequestId());
      ps.setString(14, data.getActive());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FTIssueRecipe> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FTIssueRecipe data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getCustomerDevice());
        ps.setString(3, data.getCustomerLot());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getDeviceName());
        ps.setString(6, data.getEquipment());
        ps.setString(7, data.getProcess());
        ps.setString(8, data.getSfcBo());
        ps.setString(9, data.getRecipeName());
        ps.setString(10, data.getTestProgram());
        ps.setString(11, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
        ps.setString(13, data.getRequestId());
        ps.setString(14, data.getActive());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FTIssueRecipe data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomerDevice());
      ps.setString(2, data.getCustomerLot());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getDeviceName());
      ps.setString(5, data.getEquipment());
      ps.setString(6, data.getProcess());
      ps.setString(7, data.getSfcBo());
      ps.setString(8, data.getRecipeName());
      ps.setString(9, data.getTestProgram());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
      ps.setString(12, data.getRequestId());
      ps.setString(13, data.getActive());
      ps.setString(14, data.getId());

      return ps.executeUpdate();
    }
  }

  public List<FTIssueRecipe> select(Where where) throws SQLException {
    ArrayList<FTIssueRecipe> results = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        results.add(this.convert(rs));
      }
      return results;
    }
  }

  public List<FTIssueRecipe> selectBySfc(String sfcBo, String operationBo)
      throws SQLException {
    Where where = new Where()
        .eq("ACTIVE", "Y")
        .eq("SFC_BO", sfcBo)
        .eq("operation_bo", operationBo)
        .orderBy("UPDATED_TIME DESC");
    return this.select(where);
  }

  public List<FTIssueRecipe> selectByDevice(String device, String testerType, String operationBo)
      throws SQLException {
    Where where = new Where()
        .eq("ACTIVE", "Y")
        .eqOrNull("sfc_bo", null)
        .eq("device_name", device)
        .eq("equipment", testerType)
        .eq("operation_bo", operationBo)
        .orderBy("UPDATED_TIME DESC");
    return this.select(where);
  }

  public int update(List<FTIssueRecipe> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FTIssueRecipe data : dataList) {
        ps.setString(1, data.getCustomerDevice());
        ps.setString(2, data.getCustomerLot());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getDeviceName());
        ps.setString(5, data.getEquipment());
        ps.setString(6, data.getProcess());
        ps.setString(7, data.getSfcBo());
        ps.setString(8, data.getRecipeName());
        ps.setString(9, data.getTestProgram());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
        ps.setString(12, data.getRequestId());
        ps.setString(13, data.getActive());
        ps.setString(14, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_ft_issue_recipe WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<FTIssueRecipe> selectAll() throws SQLException {
    ArrayList<FTIssueRecipe> result = new ArrayList<FTIssueRecipe>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public FTIssueRecipe selectByPK(String id) throws SQLException {
    FTIssueRecipe result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private FTIssueRecipe convert(ResultSet rs) throws SQLException {
    FTIssueRecipe data = new FTIssueRecipe();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setCustomerDevice(rs.getString(index++));
    data.setCustomerLot(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setEquipment(rs.getString(index++));
    data.setProcess(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setRecipeName(rs.getString(index++));
    data.setTestProgram(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setRequestId(rs.getString(index++));
    data.setActive(rs.getString(index++));

    return data;
  }
}
