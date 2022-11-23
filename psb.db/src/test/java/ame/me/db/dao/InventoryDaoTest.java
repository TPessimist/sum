package ame.me.db.dao;

import ame.me.db.InventoryDetail;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

public class InventoryDaoTest {

  @Test
  public void testByShopOrder() throws SQLException {
    try (Connection conn = DB.create()) {
      InventoryDetailDao dao = new InventoryDetailDao(conn);
      List<InventoryDetail> ros = dao.selectByShopOrder("ShopOrderBO:TEST,HTKS-SO-1003");
      ros.forEach(System.out::println);
    }
  }

  @Test
  public void testBySupSn() throws SQLException {
    try (Connection conn = DB.create()) {
      InventoryDetailDao dao = new InventoryDetailDao(conn);
      List<InventoryDetail> ros = dao.selectBySupSn("PSB-L001");
      ros.forEach(System.out::println);
    }
  }
}
