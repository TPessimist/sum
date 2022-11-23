package ame.psb.db.dao;

import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class DummySfcDaoTest {

  @Test
  public void testSelect() throws SQLException {
    try (Connection conn = DB.create()) {
      DummySfcDao dao = new DummySfcDao(conn);
      dao.selectAll().forEach(System.out::println);
      dao.selectRunByResource("ResourceBO:1020,BSCR02").forEach(System.out::println);
    }
  }
}