package ame.psb.db.dao;

import ame.psb.db.RmsMatrixRecipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RmsMatrixRecipeDao {

  private static final String SQL_INS = "INSERT INTO zd_rms_matrix_recipe(id,recipe_name,matrix_bo,priority,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_rms_matrix_recipe SET recipe_name=?,matrix_bo=?,priority=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL = "SELECT id,recipe_name,matrix_bo,priority,updated_user,updated_time FROM zd_rms_matrix_recipe ";

  private Connection conn;

  public RmsMatrixRecipeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RmsMatrixRecipe data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getRecipeName());
      ps.setString(3, data.getMatrixBo());
      ps.setInt(4, data.getPriority());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int update(RmsMatrixRecipe data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getRecipeName());
      ps.setString(2, data.getMatrixBo());
      ps.setInt(3, data.getPriority());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getId());

      return ps.executeUpdate();
    }
  }

  public int deleteByMatrix(String matrixBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_rms_matrix_recipe WHERE matrix_bo=?")) {
      ps.setString(1, matrixBo);
      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_rms_matrix_recipe WHERE id=?")) {
      ps.setString(1, id);
      return ps.executeUpdate();
    }
  }

  public RmsMatrixRecipe selectByPK(String id) throws SQLException {
    RmsMatrixRecipe recipe = null;

    PreparedStatement ps = this.conn.prepareStatement(SQL + "WHERE id=?");
    ps.setString(1, id);

    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      recipe = convert(rs);
    }

    return recipe;
  }

  public List<RmsMatrixRecipe> selectByMatrix(String recipeMatrixBo) throws SQLException {
    ArrayList<RmsMatrixRecipe> recipes = new ArrayList<RmsMatrixRecipe>();

    PreparedStatement ps = this.conn.prepareStatement(SQL + "WHERE matrix_bo=? ORDER BY priority");
    ps.setString(1, recipeMatrixBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      recipes.add(convert(rs));
    }

    return recipes;
  }

  private RmsMatrixRecipe convert(ResultSet rs) throws SQLException {
    RmsMatrixRecipe data = new RmsMatrixRecipe();
    data.setId(rs.getString(1));
    data.setRecipeName(rs.getString(2));
    data.setMatrixBo(rs.getString(3));
    data.setPriority(rs.getInt(4));
    data.setUpdatedUser(rs.getString(5));
    data.setUpdatedTime(DateUtils.getDateTz(rs, 6));
    return data;
  }
}
