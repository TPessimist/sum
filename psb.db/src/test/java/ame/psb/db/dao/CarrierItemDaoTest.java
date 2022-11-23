package ame.psb.db.dao;

import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class CarrierItemDaoTest {

  @Test
  public void testSelect() throws SQLException {
    try (Connection conn = DB.create()) {
      CarrierItemDao dao = new CarrierItemDao(conn);
      dao.selectByCarrier("FOUP::C2").forEach(System.out::println);
    }
  }
}
