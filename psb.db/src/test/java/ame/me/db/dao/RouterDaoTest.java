package ame.me.db.dao;

import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class RouterDaoTest {

  @Test
  public void testSelectAll() throws SQLException {
    try (Connection conn = DB.create()) {
      RouterDao dao = new RouterDao(conn);
      dao.selectAll("TEST").forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByName() throws SQLException {
    try (Connection conn = DB.create()) {
      RouterDao dao = new RouterDao(conn);
      System.out.println(dao.selectByName("TEST", "BUMPING_LIGHT_COMBINE"));
      System.out.println(dao.selectByName("TEST", "BUMPING_LIGHT_COMBINE", "2"));
    }
  }

  @Test
  public void testSelectByNamePrefix() throws SQLException {
    try (Connection conn = DB.create()) {
      RouterDao dao = new RouterDao(conn);
      dao.selectByNamePrefix("TEST", "BUMPING").forEach(System.out::println);
    }
  }
}
