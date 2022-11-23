package ame.me.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class ShopOrderDaoTest {

  @Test
  public void testSelectAll() throws Exception {
    Env.initial("app.properties");
    try (Connection conn = DB.create()) {
      ShopOrderDao dao = new ShopOrderDao(conn);
      dao.selectAll(Env.SITE).forEach(System.out::println);
    }
  }

  @Test
  public void testSelectLevelAll() throws SQLException {
    try (Connection conn = DB.create()) {
      ShopOrderDao dao = new ShopOrderDao(conn);
      System.out.println(dao.selectByName(Env.SITE, "PSB-TEST009"));
    }
  }
}
