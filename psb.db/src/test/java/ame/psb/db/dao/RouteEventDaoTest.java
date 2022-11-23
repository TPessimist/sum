package ame.psb.db.dao;

import ame.psb.db.RouteEvent;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

public class RouteEventDaoTest {

  @Test
  public void testSelectByPK() throws SQLException {
    try (Connection conn = DB.create()) {
      RouteEventDao dao = new RouteEventDao(conn);
      List<RouteEvent> c = dao.selectLast("SFCBO:1020,E858M002.1", "hold", 10);
      System.out.println(c);
    }
  }
}