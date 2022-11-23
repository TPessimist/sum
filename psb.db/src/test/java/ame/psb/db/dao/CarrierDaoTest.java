package ame.psb.db.dao;

import ame.psb.db.Carrier;
import ame.psb.db.conf.DB;
import ame.psb.db.conf.Hana;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CarrierDaoTest {

  @Test
  public void testSearch() throws SQLException {
    try (Connection conn = Hana.createDev()) {
      CarrierDao dao = new CarrierDao(conn);
      System.out.println(dao.selectByPK("FOUP::BEBC0001"));
      dao.selectAll().forEach(System.out::println);
    }
  }

  @Test
  public void testChangeState() throws SQLException {
    try (Connection conn = DB.create()) {
      CarrierDao dao = new CarrierDao(conn);
      dao.changeState("C2", "INITIAL", null);

      Carrier c = dao.selectByPK("C2");
      Assert.assertEquals("INITIAL", c.getStateName());
    }
  }

  @Test
  public void testInsert() throws SQLException {
    try (Connection conn = DB.create()) {
      CarrierDao dao = new CarrierDao(conn);
      for (int i = 1001; i <= 9999; i++) {
        Carrier c = new Carrier();
        c.setCarrierName("HTC" + i);
        c.setCarrierType("FOUP");
        c.setStateName("WAIT");
        dao.insert(c);
      }
    }
  }

  @Test
  public void testAll() throws SQLException {
    try (Connection conn = DB.create()) {
      CarrierDao dao = new CarrierDao(conn);
      List<Carrier> cs = dao.selectAll();
      cs.forEach(c -> System.out.println(c.getId()));
    }
  }

  @Test
  public void testSelectBySfc() throws SQLException {
    try (Connection conn = DB.create()) {
      CarrierDao dao = new CarrierDao(conn);
      Carrier cs = dao.selectBySfc("SFCBO:1020,S84PM001.10");
      Assert.assertNotNull(cs);
    }
  }

  @Test
  public void testTx() throws Exception {
    try (Connection conn = DB.create()) {
      conn.setAutoCommit(false);
      CarrierDao dao = new CarrierDao(conn);

      System.out.println("1:" + dao.selectByPK("FOUP::00"));

      Carrier c = new Carrier();
      c.setCarrierName("00");
      c.setCarrierType("FOUP");
      c.setStateName("WAIT");
      dao.insert(c);
      System.out.println("2" + dao.selectByPK("FOUP::00"));

      Thread.sleep(30000);
      System.out.println("2" + dao.selectByPK("FOUP::00"));
      conn.rollback();
      System.out.println("3" + dao.selectByPK("FOUP::00"));
    }
  }
}
