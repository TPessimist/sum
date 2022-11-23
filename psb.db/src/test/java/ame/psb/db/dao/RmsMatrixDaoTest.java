package ame.psb.db.dao;

import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class RmsMatrixDaoTest {

  @Test
  public void testSelectAll() throws SQLException {
    try (Connection conn = DB.create()) {
      RmsMatrixDao dao = new RmsMatrixDao(conn);
      dao.selectAll().forEach(System.out::println);
    }
  }
}
