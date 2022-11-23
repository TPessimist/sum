package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.PmsPlan;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

public class PmsPlanDaoTest {

  @Test
  public void test1() throws SQLException {
    try (Connection conn = DB.create()) {
      PmsPlanDao dao = new PmsPlanDao(conn);
      String resource = "BAOI01";
      String ResourceBo;
      ResourceBo = Env.genHandle("ResourceBo", resource);
      List<PmsPlan> PP = dao.selectByReosouce("ResourceBO:1020,BAOI01");

    }
  }

  @Test
  public void test2() throws SQLException {
    try (Connection conn = DB.create()) {
      PmsPlanDao dao = new PmsPlanDao(conn);
      String resource = "BAOI01";
      String ResourceBo;
      ResourceBo = Env.genHandle("ResourceBo", resource);
      List<PmsPlan> PP = dao.selectByType("BAOI_GROUP01", "1020");

      for (int i = 0; i < PP.size(); i++) {
        System.out.println(PP.get(i).getModifiedDateTime());
      }

    }
  }

  @Test
  public void test3() throws SQLException {
    try (Connection conn = DB.create()) {
      PmsPlanDao dao = new PmsPlanDao(conn);
      String resource = "BAOI02";
      String ResourceBo;
      ResourceBo = Env.genHandle("ResourceBo", resource);
      PmsPlan PP = dao
          .selectCheck("ResourceBO:1020,BAOI02", "D1", "B", "D", "BAOI_GROUP01", "2", "D");
      System.out.print(PP.getHandle());
    }
  }
}
