package ame.psb.db.dao;

import ame.psb.db.ShopOrderCustomerLotLog;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import org.junit.Test;

public class ShopOrderItemLotLogDaoTest {

  @Test
  public void testQuery() throws Exception {
    try (Connection conn = DB.create()) {
      ShopOrderItemLotDao dao = new ShopOrderItemLotDao(conn);
      ShopOrderItemLotLogDao dao1 = new ShopOrderItemLotLogDao(conn);
      dao1.insert(new ShopOrderCustomerLotLog(
          dao.selectByPK("ShopOrderBO:1020,WE-TEST-2011", "B-XL-2011_1::1518076460896"), ""));
    }
  }
}
