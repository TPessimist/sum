package ame.psb.db.dao;

import ame.psb.db.PmsPlanChange;
import ame.psb.db.ViewPmsPlanChange;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;

public class PmsPlanChangeDaoTest {

  @Test
  public void test1() throws SQLException {

    try (Connection conn = DB.create()) {
      PmsPlanChangeDao dao = new PmsPlanChangeDao(conn);
      PmsPlanChange ppc = new PmsPlanChange();
      ppc.setCheckList("BTIE03-MAINTAIN-YEARLY");
      ppc.setCheckListType("M");
      ppc.setCheckListVersion("A");
      ppc.setPlanningCycle("2");
      ppc.setCycleUnit("D");
      ppc.setResrce("BTIE03");
      ppc.setResourceType("BTIE_GROUP01");
      ppc.setDelayTime(new Date());
      ppc.setRemark("123");
      ppc.setSite("1020");
      int i = dao.insert(ppc);
    }
  }

  @Test
  public void test2() throws SQLException {

    try (Connection conn = DB.create()) {
      PmsPlanChangeDao dao = new PmsPlanChangeDao(conn);
      List<ViewPmsPlanChange> result = new ArrayList<ViewPmsPlanChange>();
      result = dao.selectByResource("BAOI02", "1020");
      System.out.print(result);
    }
  }

  @Test
  public void testQueryByResouceType() throws SQLException {

    try (Connection conn = DB.create()) {
      PmsPlanChangeDao dao = new PmsPlanChangeDao(conn);
      List<ViewPmsPlanChange> result = new ArrayList<ViewPmsPlanChange>();
      result = dao.selectByResourceType("BAOI_GROUP01", "1020");
      System.out.print(result);
    }
  }
}
