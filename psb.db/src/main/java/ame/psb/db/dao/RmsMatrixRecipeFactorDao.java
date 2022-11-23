package ame.psb.db.dao;

import ame.psb.db.RmsMatrixRecipeFactor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RmsMatrixRecipeFactorDao {

  private static final String SQL_INS = "INSERT INTO zd_rms_matrix_recipe_factor(matrix_recipe_bo,seq_no,matrix_factor_def_bo,driver_args) VALUES (?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_rms_matrix_recipe_factor SET matrix_factor_def_bo=?,driver_args=? WHERE matrix_recipe_bo=? AND seq_no=?";

  private static final String SQL_SEL = "SELECT matrix_recipe_bo,seq_no,matrix_factor_def_bo,driver_args FROM zd_rms_matrix_recipe_factor ";

  private Connection conn;

  public RmsMatrixRecipeFactorDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RmsMatrixRecipeFactor data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getMatrixRecipeBo());
      ps.setInt(2, data.getSeqNo());
      ps.setString(3, data.getMatrixFactorDefBo());
      ps.setString(4, data.getDriverArgs());

      return ps.executeUpdate();
    }
  }

  public int update(RmsMatrixRecipeFactor data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getMatrixFactorDefBo());
      ps.setString(2, data.getDriverArgs());
      ps.setString(3, data.getMatrixRecipeBo());
      ps.setInt(4, data.getSeqNo());

      return ps.executeUpdate();
    }
  }

  public int deleteByRecipe(String recipeBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_rms_matrix_recipe_factor WHERE matrix_recipe_bo=?")) {
      ps.setString(1, recipeBo);
      return ps.executeUpdate();
    }
  }

  public int deleteByMatrix(String matrixBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_rms_matrix_recipe_factor WHERE matrix_recipe_bo in (SELECT id FROM zd_rms_matrix_recipe WHERE matrix_bo=?)")) {
      ps.setString(1, matrixBo);
      return ps.executeUpdate();
    }
  }

  /**
   * 搜尋所有 Recipe Factor 定義。
   *
   * @return 所有 Recipe Factor 定義。
   * @throws SQLException
   */
  public List<RmsMatrixRecipeFactor> select(String recipeBo) throws SQLException {
    ArrayList<RmsMatrixRecipeFactor> result = new ArrayList<RmsMatrixRecipeFactor>();

    PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE matrix_recipe_bo=? ORDER BY seq_no");
    ps.setString(1, recipeBo);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      result.add(convert(rs));
    }

    return result;
  }

  public List<RmsMatrixRecipeFactor> selectForTest() throws SQLException {
    ArrayList<RmsMatrixRecipeFactor> result = new ArrayList<RmsMatrixRecipeFactor>();

    PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE matrix_recipe_bo like 'TEST%' ORDER BY matrix_recipe_bo");

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      result.add(convert(rs));
    }

    return result;
  }

  private RmsMatrixRecipeFactor convert(ResultSet rs) throws SQLException {
    RmsMatrixRecipeFactor data = new RmsMatrixRecipeFactor();
    data.setMatrixRecipeBo(rs.getString(1));
    data.setSeqNo(rs.getInt(2));
    data.setMatrixFactorDefBo(rs.getString(3));
    data.setDriverArgs(rs.getString(4));
    return data;
  }
}
