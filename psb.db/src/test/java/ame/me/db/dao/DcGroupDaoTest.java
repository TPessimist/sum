package ame.me.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class DcGroupDaoTest {

  @Test
  public void testSelectAll() throws SQLException {
    try (Connection conn = DB.create()) {
      DcGroupDao dao = new DcGroupDao(conn);
      dao.selectAll(Env.SITE).forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByName() throws SQLException {
    try (Connection conn = DB.create()) {
      DcGroupDao dao = new DcGroupDao(conn);
      System.out.println(dao.selectByName(Env.SITE, "TETC1-NCG1"));
      System.out.println(dao.selectByPK("DcGroupBO:TEST,TETC1-NCG1,A"));
    }
  }
}
