package ame.psb.db.dao;

import ame.psb.db.conf.DB;
import java.sql.Connection;
import org.junit.Test;

public class ShopOrderItemLotDaoTest {

  @Test
  public void testQuery() throws Exception {
    try (Connection conn = DB.create()) {
      ShopOrderItemLotDao dao = new ShopOrderItemLotDao(conn);
      dao.selectAll().forEach(System.out::println);
    }
  }
}
