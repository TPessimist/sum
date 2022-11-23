package ame.psb.db.dao;

import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class RmsPatternFactorDefDaoTest {

  @Test
  public void testQueryAll() throws SQLException {
    try (Connection conn = DB.create()) {
      RmsPatternFactorDefDao dao = new RmsPatternFactorDefDao(conn);
      dao.selectAll().values().forEach(System.out::println);
    }
  }

}
