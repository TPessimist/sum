package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class HoldReasonDaoTest {

  @Test
  public void testAll() throws SQLException {
    try (Connection conn = DB.create()) {
      HoldReasonDao dao = new HoldReasonDao(conn);
      dao.selectAll(Env.SITE).forEach(System.out::println);
    }
  }

  @Test
  public void testByPK() throws SQLException {
    try (Connection conn = DB.create()) {
      HoldReasonDao dao = new HoldReasonDao(conn);
      System.out.println(dao.selectByPK(Env.SITE, "HC01"));
    }
  }
}
