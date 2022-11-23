package ame.me.db.dao;

import ame.me.db.Item;
import ame.psb.commons.Env;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

public class ItemDaoTest {

  @Test
  public void testSelect() throws Exception {
    Env.initial("app.properties");
    try (Connection conn = DB.create()) {
      ItemDao dao = new ItemDao(conn);
      System.out.println(dao.selectAll(Env.SITE).size());

    }
  }

  @Test
  public void testKissMyItemGroup() throws SQLException {
    try (Connection conn = DB.create()) {
      ItemDao dao = new ItemDao(conn);
      System.out
          .println(dao.kissMyItemGroup("ItemBO:TEST,RT-01,1.0", "ItemGroupBO:TEST,DEVICE002"));
    }
  }

  @Test
  public void testSelectM() throws SQLException {
    try (Connection conn = DB.create()) {
      ItemDao dao = new ItemDao(conn);
      List<Item> items = dao.selectManufactured(Env.SITE);
      System.out.println(items.size());
      // items.forEach(System.out::println);
    }
  }
}
