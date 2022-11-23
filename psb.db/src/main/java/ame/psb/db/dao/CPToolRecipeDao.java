package ame.psb.db.dao;

import ame.psb.db.CPToolRecipe;
import ame.psb.db.TestBoard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class CPToolRecipeDao {

  private static final String SQL_INS = "INSERT INTO zd_cp_tool_recipe(item_group_bo,operation_bo,tool_number_bo,recipe_name,state_name,updated_user,updated_date_time,BOARD_ID,TEST_MODLE) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_cp_tool_recipe SET recipe_name=?,state_name=?,updated_user=?,updated_date_time=?, BOARD_ID=?,TEST_MODLE=? WHERE item_group_bo=? AND operation_bo=? AND tool_number_bo=?";

  private static final String SQL_SEL = "SELECT item_group_bo,operation_bo,tool_number_bo,recipe_name,state_name,updated_user,updated_date_time,BOARD_ID,TEST_MODLE FROM zd_cp_tool_recipe ";

  private final Connection conn;

  public CPToolRecipeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CPToolRecipe data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getToolNumberBo());
      ps.setString(4, data.getRecipeName());
      ps.setString(5, data.getStateName());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedDateTime());
      ps.setString(8, data.getBoardId());
      ps.setString(9, data.getTestModle());
      return ps.executeUpdate();
    }
  }

  public int insert(List<CPToolRecipe> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CPToolRecipe data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getToolNumberBo());
        ps.setString(4, data.getRecipeName());
        ps.setString(5, data.getStateName());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedDateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CPToolRecipe data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getRecipeName());
      ps.setString(2, data.getStateName());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedDateTime());
      ps.setString(5, data.getBoardId());
      ps.setString(6, data.getTestModle());
      ps.setString(7, data.getItemGroupBo());
      ps.setString(8, data.getOperationBo());
      ps.setString(9, data.getToolNumberBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<CPToolRecipe> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CPToolRecipe data : dataList) {
        ps.setString(1, data.getRecipeName());
        ps.setString(2, data.getStateName());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedDateTime());
        ps.setString(5, data.getBoardId());
        ps.setString(6, data.getTestModle());
        ps.setString(7, data.getItemGroupBo());
        ps.setString(8, data.getOperationBo());
        ps.setString(9, data.getToolNumberBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemGroupBo, String operationBo, String toolNumberBo)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_cp_tool_recipe WHERE item_group_bo=? AND operation_bo=? AND tool_number_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, toolNumberBo);

      return ps.executeUpdate();
    }
  }

  public int deleteByDeviceAndOperation(String itemGroupBo, String operationBo)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_cp_tool_recipe WHERE item_group_bo=? AND operation_bo=? ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      return ps.executeUpdate();
    }
  }

  public List<CPToolRecipe> selectAll() throws SQLException {
    ArrayList<CPToolRecipe> result = new ArrayList<CPToolRecipe>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<CPToolRecipe> selectByDeviceAndOperation(String itemGroupBo, String operationBo)
      throws SQLException {
    ArrayList<CPToolRecipe> result = new ArrayList<CPToolRecipe>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? AND operation_bo=? ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<CPToolRecipe> selectActiveByDeviceAndOperation(String itemGroupBo, String operationBo)
      throws SQLException {
    ArrayList<CPToolRecipe> result = new ArrayList<CPToolRecipe>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE item_group_bo=? AND operation_bo=? AND state_name = 'Y' ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<CPToolRecipe> selectAll(Where where) throws SQLException {
    ArrayList<CPToolRecipe> result = new ArrayList<CPToolRecipe>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<CPToolRecipe> selectByDevice(String itemGroupBo) throws SQLException {
    ArrayList<CPToolRecipe> result = new ArrayList<CPToolRecipe>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE item_group_bo=? ")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public CPToolRecipe selectByPK(String itemGroupBo, String operationBo, String toolNumberBo)
      throws SQLException {
    CPToolRecipe result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? AND operation_bo=? AND tool_number_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, toolNumberBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private CPToolRecipe convert(ResultSet rs) throws SQLException {
    CPToolRecipe data = new CPToolRecipe();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setToolNumberBo(rs.getString(index++));
    data.setRecipeName(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setBoardId(rs.getString(index++));
    data.setTestModle(rs.getString(index++));

    return data;
  }
}
