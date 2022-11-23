package ame.psb.db.dao;

import ame.psb.db.conf.DB;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import org.junit.Test;

public class DummyCountDaoTest {

  @Test
  public void testSelect() throws SQLException {
    try (Connection conn = DB.create()) {
      DummyCountDao dao = new DummyCountDao(conn);
      dao.selectAll().forEach(System.out::println);
      dao.selectByResource("ResourceBO:1020,BSCR02").forEach(System.out::println);
    }
  }

  @Test
  public void testSelectAndUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      DummyCountDao dao = new DummyCountDao(conn);
      dao.selectAll().forEach(c -> {
        try {
          // c.setLastTime(new Date(new Date().getTime() - 60 * 60 * 1000L));
          c.setLastTime(new Date(new Date().getTime()));
          c.setDummyTimes(new BigDecimal(60));
          c.setDummyCount(new BigDecimal(4));
          dao.update(c);
        } catch (Exception ex) {

        }
      });
    }
  }
}