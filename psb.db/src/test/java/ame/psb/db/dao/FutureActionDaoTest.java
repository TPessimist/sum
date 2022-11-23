package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.FutureAction;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;

public class FutureActionDaoTest {

  @Test
  public void testSelectByCustomer() throws SQLException {
    try (Connection conn = DB.create()) {
      FutureActionDao dao = new FutureActionDao(conn);
      dao.selectByCustomer("CustomerBO:TEST,GC").forEach(System.out::println);
      dao.selectByCustomer("CustomerBO:TEST,GC", "OperationBO:TEST,IQC-OVN,#")
          .forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByItemGroup() throws SQLException {
    try (Connection conn = DB.create()) {
      FutureActionDao dao = new FutureActionDao(conn);
      dao.selectByItemGroup("ItemGroupBO:TEST,DEVICE001").forEach(System.out::println);
      dao.selectByItemGroup("ItemGroupBO:TEST,DEVICE001", "OperationBO:TEST,IQC-OVN,#")
          .forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByItem() throws SQLException {
    try (Connection conn = DB.create()) {
      FutureActionDao dao = new FutureActionDao(conn);
      dao.selectByItem("ItemBO:TEST,DIE-01,1.0").forEach(System.out::println);
      dao.selectByItem("ItemBO:TEST,DIE-01,1.0", "OperationBO:TEST,IQC-OVN,#")
          .forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByShopOrder() throws SQLException {
    try (Connection conn = DB.create()) {
      FutureActionDao dao = new FutureActionDao(conn);
      dao.selectByShopOrder("ShopOrderBO:TEST,PSB-TEST002,1.0").forEach(System.out::println);
      dao.selectByShopOrder("ShopOrderBO:TEST,PSB-TEST002,1.0", "OperationBO:TEST,IQC-OVN,#")
          .forEach(System.out::println);
    }
  }

  @Test
  public void testSelectBySfc() throws SQLException {
    try (Connection conn = DB.create()) {
      FutureActionDao dao = new FutureActionDao(conn);
      dao.selectBySfc("SFCBO:TEST,B7BEE046.13").forEach(System.out::println);
      dao.selectBySfc("SFCBO:TEST,B7BEE046.13", "OperationBO:TEST,IQC-OVN,#")
          .forEach(System.out::println);
    }
  }

  @Test
  public void testInsertAndUpdate() throws SQLException {
    try {
      Env.initial("app.properties");
      Connection conn = DB.create();

      List<String> sfcList = new ArrayList<>();
      sfcList.add("SFCBO:1020,B99HM002.1");
      sfcList.add("SFCBO:1020,B99CM058.2");
      sfcList.add("SFCBO:1020,B99JM021.1");
      sfcList.add("SFCBO:1020,B98TQ063.1");
      sfcList.add("SFCBO:1020,B99LM080.1");
      sfcList.add("SFCBO:1020,B99GM024.1");
      sfcList.add("SFCBO:1020,B98KQ014.1");
      sfcList.add("SFCBO:1020,B99HQ018.2");
      sfcList.add("SFCBO:1020,B99HQ018.1");
      sfcList.add("SFCBO:1020,B99LM009.1");
      sfcList.add("SFCBO:1020,B99LM010.1");
      sfcList.add("SFCBO:1020,B99LM011.1");
      sfcList.add("SFCBO:1020,B99LM022.2");
      sfcList.add("SFCBO:1020,B99LM009.1");

      FutureActionDao dao = new FutureActionDao(conn);
      FutureAction data = dao.selectByPK("fbab0b08-3de9-4251-81c1-10b605bf4fef");
      for (String sfc : sfcList) {
        data.setId(UUID.randomUUID().toString());
        data.setSfcBo(sfc);
        dao.insert(data);
      }

      System.out.println("1");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
