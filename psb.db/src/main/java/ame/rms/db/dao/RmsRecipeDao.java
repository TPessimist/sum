package ame.rms.db.dao;

import ame.psb.db.conf.Oracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: eclipse_workspace
 * @description: rms recipe
 * @author: qingchun
 * @create: 2020-10-15 14:58
 */
public class RmsRecipeDao implements AutoCloseable {

  private final Connection conn;

  public RmsRecipeDao() throws SQLException {
    this.conn = Oracle.createRms();
  }

  public List<String> queryActiveRecipeByResource(String resourceName) throws SQLException {
    List<String> recipes = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT RECIPE_NAME FROM VIEW_RESOURCE_RECIPE WHERE EQUIPMENT_ID = ?")) {
      ps.setString(1, resourceName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        recipes.add(rs.getString(1));
      }

    }
    return recipes;
  }

  public boolean validateExpRecipe(String recipeName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT RECIPE_NAME FROM VIEW_RESOURCE_RECIPE WHERE RECIPE_NAME = ?")) {
      ps.setString(1, recipeName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        return true;
      }

    }
    return false;
  }


  @Override
  public void close() throws Exception {
    if (this.conn != null) {
      this.conn.close();
    }
  }
}
