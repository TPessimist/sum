package ame.psb.db.dao;

import ame.psb.db.SfcEx;
import ame.psb.db.ViewSfcEx;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;
import uia.utils.dao.Where;

public class SfcExDaoTest {

  @Test
  public void testChangeState() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcExDao dao = new SfcExDao(conn);
      dao.changeState("SFCBO:1002,B7AXE024.1", "WAIT", null);
      SfcEx sfc = dao.selectByPK("SFCBO:1002,B7AXE024.1");
      Assert.assertEquals("UNKNOWN", sfc.getStateName());
    }
  }

  @Test
  public void testSelectByPK() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcExDao dao = new SfcExDao(conn);
      ViewSfcEx sfc = dao.selectByPK("SFCBO:TEST,B7B8E032.2");
      System.out.println(sfc);
      System.out.println("  " + sfc.getShopOrderBo());
      System.out.println("  " + sfc.getItemBo());
    }
  }

  @Test
  public void testSelectAll() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcExDao dao = new SfcExDao(conn);
      dao.selectAll().forEach(System.out::println);
    }
  }

  @Test
  public void testSelectWhere() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcExDao dao = new SfcExDao(conn);

      dao.select(new Where())
          .forEach(System.out::println);

      dao.select(new Where().likeBegin("sfc_name", "B").eq("state_name", "WAIT"))
          .forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByCarrier() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcExDao dao = new SfcExDao(conn);
      dao.selectByCarrier("FOUP::C2").forEach(s -> {
        System.out.println(s);
      });
    }
  }

  @Test
  public void testInsert() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcExDao dao = new SfcExDao(conn);
      SfcEx sfc = dao.selectByPK("SFCBO:1002,B7AXE024.1");
      sfc.setSfcBo("12345");
      dao.insert(sfc);
    }
  }

  @Test
  public void testUpdateForSfcMaintain() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcExDao dao = new SfcExDao(conn);
      SfcEx sfc = dao.selectByPK("SFCBO:1020,S83MM001.8");
      sfc.setRemark("leo");
      dao.updateForSfcMaintain(sfc);

    }
  }
}
