package ame.psb.db.dao;

import ame.psb.db.ViewCustomerItemSfcItem;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class CustomerItemDaoTest {

  @Test
  public void testSelect() throws SQLException {
    try (Connection conn = DB.create()) {
      CustomerItemDao dao = new CustomerItemDao(conn);
      dao.selectByShopOrder("ShopOrderBO:TEST,PSB-TEST008", "S").forEach(System.out::println);
    }
  }

  @Test
  public void testSelect2() throws SQLException {
    try (Connection conn = DB.create()) {
      CustomerItemDao dao = new CustomerItemDao(conn);
      dao.select("B-CL-1030_2::1516327164450", "ShopOrderBO:TEST,HTKS-TESTPRJ-1035", "S")
          .forEach(System.out::println);
    }
  }

  @Test
  public void testSelect3() throws SQLException {
    try (Connection conn = DB.create()) {
      CustomerItemDao dao = new CustomerItemDao(conn);
      dao.selectByItemLot("17AF6320::1512473070359", "S").forEach(System.out::println);
    }
  }

  @Test
  public void testSelect4() throws SQLException {
    try (Connection conn = DB.create()) {
      CustomerItemDao dao = new CustomerItemDao(conn);
      ViewCustomerItemSfcItem item = dao.selectByPK("17AF6320::1512473070359");
      System.out.println(item.getGrossQty());
      System.out.println(item.getGoodQty());
    }
  }

  @Test
  public void testupdate() throws SQLException {
    try (Connection conn = DB.create()) {
      CustomerItemDao dao = new CustomerItemDao(conn);
      ViewCustomerItemSfcItem item = dao.selectByPK("B-XL-3022-12::1521616866287");
      item.setGoodQty(1000);
      dao.update(item);
    }
  }

}
