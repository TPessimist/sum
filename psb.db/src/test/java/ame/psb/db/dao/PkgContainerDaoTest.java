package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.PkgContainer;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import org.junit.Test;
import uia.utils.dao.Where;

public class PkgContainerDaoTest {

  public void testRepeatableRead() throws Exception {
    Env.initial("app.properties");
    try (Connection conn1 = DB.create()) {
      conn1.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
      conn1.setAutoCommit(false);
      System.out.println(conn1.getMetaData().supportsSelectForUpdate());

      PkgContainerDao dao1 = new PkgContainerDao(conn1);
      PkgContainer ct1 = dao1.selectForUpdate("Q18200001");
      System.out.println("cp1:" + ct1.getPackingUser());
      ct1.setPackingUser("John");
      dao1.update(ct1);
      System.out.println("cp2");

      try (final Connection conn2 = DB.create()) {
        conn2.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        conn2.setAutoCommit(false);

        PkgContainerDao dao2 = new PkgContainerDao(conn2);
        PkgContainer ct2 = dao2.selectByPK("Q18200001");
        System.out.println("cp3:" + ct2.getPackingUser());
        new Thread(() -> {
          ct2.setPackingUser("Mary");
          try {
            System.out.println("cp4-1");
            dao2.update(ct2);
            System.out.println("cp4-2");
            conn2.commit();
            System.out.println("cp4-3");
          } catch (Exception e) {
            System.out.println("cp4:" + e.getMessage());
          }

        }).start();

        Thread.sleep(1000);
        System.out.println("cp5");
        conn1.commit();
        System.out.println("cp6");
        Thread.sleep(1000);
        System.out.println("cp7");
      }
    }
  }

  @Test
  public void test() throws Exception {
    Env.initial("app.properties");
    try (Connection conn = DB.create()) {
      PkgContainerDao dao = new PkgContainerDao(conn);
      Where where = new Where()
          .eq("ITEM_GROUP_BO", "ItemGroupBO:9998,X76001")
          .like("CUSTOMER_ITEMSET_NAMES", "B-XL-2004_1::1517512973071");
      dao.select(where).forEach(System.out::println);
    }
  }


  @Test
  public void test1() throws Exception {
    Env.initial("app.properties");
    try (Connection conn = DB.create()) {

    }
  }
}
