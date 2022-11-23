package ame.psb.db.dao;

import ame.psb.db.ZrIssueRecipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class ZrIssueRecipeDao {

  private static final String SQL_INS = "INSERT INTO zr_issue_recipe(id,customer_device,customer_lot,operation_bo,device_name,sfc_bo,item_name,tool_number_bo,recipe_name,updated_user,updated_time,request_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_issue_recipe SET customer_device=?,customer_lot=?,operation_bo=?,device_name=?,sfc_bo=?,item_name=?,tool_number_bo=?,recipe_name=?,updated_user=?,updated_time=?,request_id=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,customer_device,customer_lot,operation_bo,device_name,sfc_bo,item_name,tool_number_bo,recipe_name,updated_user,updated_time,request_id FROM zr_issue_recipe ";

  private final Connection conn;

  public ZrIssueRecipeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZrIssueRecipe data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getCustomerDevice());
      ps.setString(3, data.getCustomerLot());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getDeviceName());
      ps.setString(6, data.getSfcBo());
      ps.setString(7, data.getItemName());
      ps.setString(8, data.getToolNumberBo());
      ps.setString(9, data.getRecipeName());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
      ps.setString(12, data.getRequestId());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZrIssueRecipe> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZrIssueRecipe data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getCustomerDevice());
        ps.setString(3, data.getCustomerLot());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getDeviceName());
        ps.setString(6, data.getSfcBo());
        ps.setString(7, data.getItemName());
        ps.setString(8, data.getToolNumberBo());
        ps.setString(9, data.getRecipeName());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
        ps.setString(12, data.getRequestId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZrIssueRecipe data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomerDevice());
      ps.setString(2, data.getCustomerLot());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getDeviceName());
      ps.setString(5, data.getSfcBo());
      ps.setString(6, data.getItemName());
      ps.setString(7, data.getToolNumberBo());
      ps.setString(8, data.getRecipeName());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
      ps.setString(11, data.getRequestId());
      ps.setString(12, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZrIssueRecipe> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZrIssueRecipe data : dataList) {
        ps.setString(1, data.getCustomerDevice());
        ps.setString(2, data.getCustomerLot());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getDeviceName());
        ps.setString(5, data.getSfcBo());
        ps.setString(6, data.getItemName());
        ps.setString(7, data.getToolNumberBo());
        ps.setString(8, data.getRecipeName());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
        ps.setString(11, data.getRequestId());
        ps.setString(12, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_issue_recipe WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ZrIssueRecipe> selectAll() throws SQLException {
    ArrayList<ZrIssueRecipe> result = new ArrayList<ZrIssueRecipe>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ZrIssueRecipe> selectByCustomerItemBoAndOperationBo(String customerItemBo,
      String operationBo) throws SQLException {
    Where where = new Where()
        .eq("ITEM_NAME", customerItemBo)
        .eq("OPERATION_BO", operationBo);
    return this.select(where);
  }

  public List<ZrIssueRecipe> selectActiveByCustomerItemBoAndOperationBo(String customerItemBo,
      String operationBo) throws SQLException {
    Where where = new Where()
        .eq("ITEM_NAME", customerItemBo)
        .eq("OPERATION_BO", operationBo)
        .eq("ACTIVE", "Y");
    return this.select(where);
  }


  public ZrIssueRecipe selectByPK(String id) throws SQLException {
    ZrIssueRecipe result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }
  

  public List<ZrIssueRecipe> select(Where where) throws SQLException {
    ArrayList<ZrIssueRecipe> result = new ArrayList<ZrIssueRecipe>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  private ZrIssueRecipe convert(ResultSet rs) throws SQLException {
    ZrIssueRecipe data = new ZrIssueRecipe();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setCustomerDevice(rs.getString(index++));
    data.setCustomerLot(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setToolNumberBo(rs.getString(index++));
    data.setRecipeName(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setRequestId(rs.getString(index++));

    return data;
  }
}