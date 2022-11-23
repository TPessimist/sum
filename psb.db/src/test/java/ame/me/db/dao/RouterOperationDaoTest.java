package ame.me.db.dao;

import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class RouterOperationDaoTest {

  @Test
  public void testByRouter() throws SQLException {
    try (Connection conn = DB.create()) {
      RouterOperationDao dao = new RouterOperationDao(conn);
      dao.selectByRouter("RouterBO:TEST,BUMPING_LIGHT_COMBINE,U,1").forEach(System.out::println);
    }
  }

}
