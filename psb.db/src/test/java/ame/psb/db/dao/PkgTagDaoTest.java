package ame.psb.db.dao;

import ame.psb.db.Carrier;
import ame.psb.db.PkgTag;
import ame.psb.db.PkgTagFactor;
import ame.psb.db.conf.DB;
import ame.psb.db.conf.Hana;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class PkgTagDaoTest {

  @Test
  public void test() throws SQLException {
    try (Connection conn = Hana.createTest()) {
      PkgTagDao dao1 = new PkgTagDao(conn);
      PkgTagFactorDao dao2 = new PkgTagFactorDao(conn);
      for (PkgTagFactor factor : dao2.selectAll()) {
        if (dao1.selectByPK(factor.getTagBo()) == null) {
          PkgTag tag = new PkgTag();
          tag.setId(factor.getTagBo());
          tag.setValuePattern("{$" + factor.getTagFactorDefBo() + "}");
          tag.setValueType("P");
          dao1.insert(tag);
        }
      }
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
      Carrier cs = dao.selectBySfc("SFCBO:1002,10022");
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

  @Test
  public void testInsertAndUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      PkgTagDao dao = new PkgTagDao(conn);
      PkgTag data = dao.selectByPK("37_CITY");
      data.setId("0000000000000000");
      dao.insert(data);
      data.setValueScript("123434");
      dao.update(data);
      System.out.println(dao.selectByPK("0000000000000000"));
    }
  }

  @Test
  public void testDelete() throws SQLException {
    try (Connection conn = DB.create()) {
      PkgTagDao dao = new PkgTagDao(conn);
      dao.delete("0000000000000000");
    }
  }
}
