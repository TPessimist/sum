package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.IssueRecipe;
import uia.utils.dao.DateUtils;

public class IssueRecipeDao {

  private static final String SQL_INS = "INSERT INTO zr_issue_recipe(id,customer_device,customer_lot,operation_bo,device_name,sfc_bo,item_name,tool_number_bo,recipe_name,updated_user,updated_time,request_id,active,BOARD_ID,TEST_MODLE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_issue_recipe SET customer_device=?,customer_lot=?,operation_bo=?,device_name=?,sfc_bo=?,item_name=?,tool_number_bo=?,recipe_name=?,updated_user=?,updated_time=?,request_id=?,active=?,BOARD_ID=?,TEST_MODLE=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,customer_device,customer_lot,operation_bo,device_name,sfc_bo,item_name,tool_number_bo,recipe_name,updated_user,updated_time,request_id,active,BOARD_ID,TEST_MODLE FROM zr_issue_recipe ";

  private final Connection conn;

  public IssueRecipeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(IssueRecipe data) throws SQLException {
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
      ps.setString(13, data.getActive());
      ps.setString(14, data.getBoardId());
      ps.setString(15, data.getTestModle());

      return ps.executeUpdate();
    }
  }

  public int insert(List<IssueRecipe> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (IssueRecipe data : dataList) {
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
        ps.setString(13, data.getActive());
        ps.setString(14, data.getBoardId());
        ps.setString(15, data.getTestModle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(IssueRecipe data) throws SQLException {
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
      ps.setString(12, data.getActive());
      ps.setString(13, data.getBoardId());
      ps.setString(14, data.getTestModle());
      ps.setString(15, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<IssueRecipe> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (IssueRecipe data : dataList) {
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
        ps.setString(12, data.getActive());
        ps.setString(13, data.getBoardId());
        ps.setString(14, data.getTestModle());
        ps.setString(15, data.getId());

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

  public List<IssueRecipe> selectAll() throws SQLException {
    ArrayList<IssueRecipe> result = new ArrayList<IssueRecipe>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public IssueRecipe selectByPK(String id) throws SQLException {
    IssueRecipe result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<IssueRecipe> selectByRequestId(String requestId) throws SQLException {
    List<IssueRecipe> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE request_id=?")) {
      ps.setString(1, requestId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private IssueRecipe convert(ResultSet rs) throws SQLException {
    IssueRecipe data = new IssueRecipe();

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
    data.setActive(rs.getString(index++));
    data.setBoardId(rs.getString(index++));
    data.setTestModle(rs.getString(index++));
    return data;
  }
}
