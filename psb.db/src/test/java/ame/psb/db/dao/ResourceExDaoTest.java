package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.ResourceEx;
import ame.psb.db.conf.DB;
import ame.psb.db.conf.Hana;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import org.junit.Test;

public class ResourceExDaoTest {

  @Test
  public void testAll() throws Exception {
    try (Connection conn = DB.create()) {
      ResourceExDao dao = new ResourceExDao(conn);
      dao.selectAll(Env.SITE).forEach(System.out::println);
    }
  }

  @Test
  public void testByPK() throws Exception {
    try (Connection conn = DB.create()) {
      ResourceExDao dao = new ResourceExDao(conn);
      System.out.println(dao.selectByPK("ResourceBO:1020,BAOI01"));
    }
  }

  @Test
  public void testByName() throws Exception {
    try (Connection conn = DB.create()) {
      ResourceExDao dao = new ResourceExDao(conn);
      System.out.println(dao.selectByName(Env.SITE, "BAOI01"));
    }
  }

  @Test
  public void testByNamePrefix() throws Exception {
    try (Connection conn = DB.create()) {
      ResourceExDao dao = new ResourceExDao(conn);
      dao.selectByNamePrefix(Env.SITE, "BA").forEach(System.out::println);
    }
  }

  @Test
  public void testChangeState() throws Exception {
    try (Connection conn = DB.create()) {
      ResourceExDao dao = new ResourceExDao(conn);
      dao.changeState("ResourceBO:1002,DEFAULT", "WAITING", null);
    }
  }

  @Test
  public void updateOptimistic() {
    try (Connection conn = Hana.createTest()) {
      ResourceExDao dao = new ResourceExDao(conn);
      ResourceEx ex = dao.selectByPK("ResourceBO:1020,BEXP05LP2");
      Date a = ex.getUpdatedTime();
      ex.setUpdatedTime(new Date());
      ex.setWaitSfcCount(100);
      dao.updateOptimistic(ex, a);
      //dao.changeState("ResourceBO:1002,DEFAULT", "WAITING", null);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testUpdateEapState() throws Exception {
    Env.initial("app.properties");
    try (Connection conn = DB.create()) {
      ResourceExDao dao = new ResourceExDao(conn);
      System.out.println(dao.selectByPK("ResourceBO:1020,BSCR05").heartBeatValid());
      //dao.updateEapState("ResourceBO:1020,BSCR05", "LOCAL", "Y", "Y", new Date());
    }
  }
}
