package ame.me.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class NcCodeDaoTest {

  @Test
  public void testSelectAll() throws SQLException {
    try (Connection conn = DB.create()) {
      NcCodeDao dao = new NcCodeDao(conn);
      dao.selectAll(Env.SITE).forEach(System.out::println);
    }
  }

  @Test
  public void testSelectLevelAll() throws SQLException {
    try (Connection conn = DB.create()) {
      NcCodeDao dao = new NcCodeDao(conn);
      dao.selectLevelAll(Env.SITE).forEach(System.out::println);
    }
  }
}
