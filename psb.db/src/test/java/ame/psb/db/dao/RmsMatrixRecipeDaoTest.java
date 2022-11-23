package ame.psb.db.dao;

import ame.psb.db.RmsMatrixRecipe;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class RmsMatrixRecipeDaoTest {

  @Test
  public void testQueryByMatrix() throws SQLException {
    try (Connection conn = DB.create()) {
      RmsMatrixRecipeDao dao = new RmsMatrixRecipeDao(conn);
      dao.selectByMatrix("MatrixBO:00002").forEach(System.out::println);
    }
  }

  @Test
  public void testInsertAndUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      RmsMatrixRecipeDao dao = new RmsMatrixRecipeDao(conn);
      RmsMatrixRecipe data = dao.selectByPK("OperationBO:1020,BFB-WEE,#,1");
      data.setId("0000000000000000");
      dao.insert(data);
      data.setRecipeName("123434");
      dao.update(data);
      System.out.println(dao.selectByPK("0000000000000000"));
    }
  }

  @Test
  public void testDelete() throws SQLException {
    try (Connection conn = DB.create()) {
      RmsMatrixRecipeDao dao = new RmsMatrixRecipeDao(conn);
      dao.delete("0000000000000000");
      System.out.println(dao.selectByPK("0000000000000000"));
    }
  }
}
