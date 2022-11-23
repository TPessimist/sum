package ame.psb.db.dao;

import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class RmsMatrixRecipeFactorDaoTest {

  @Test
  public void testQueryByRecipe() throws SQLException {
    try (Connection conn = DB.create()) {
      RmsMatrixRecipeFactorDao dao = new RmsMatrixRecipeFactorDao(conn);
      dao.select("MatrixRecipeBO:OVN:00002").forEach(System.out::println);
    }
  }

}
