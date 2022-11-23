package ame.me.db.dao;

import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class SfcBomComponentDaoTest {

  @Test
  public void testByRouter() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcBomComponentDao dao = new SfcBomComponentDao(conn);
      dao.selectBySfc("").forEach(System.out::println);
    }
  }

}
