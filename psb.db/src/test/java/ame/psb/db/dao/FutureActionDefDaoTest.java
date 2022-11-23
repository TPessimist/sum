package ame.psb.db.dao;

import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class FutureActionDefDaoTest {

  @Test
  public void test() throws SQLException {
    try (Connection conn = DB.create()) {
      FutureActionDefDao dao = new FutureActionDefDao(conn);
      dao.selectAll().forEach(System.out::println);
    }
  }
}
