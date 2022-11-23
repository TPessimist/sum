package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.DispatchSfc;
import ame.psb.db.ViewDispatchSfc;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

public class DispatchSfcDaoTest {

  public void testCrazy() throws SQLException {
    try (Connection conn = DB.create()) {
      DispatchSfcDao dao = new DispatchSfcDao(conn);
      List<ViewDispatchSfc> data = dao.selectAll();
      for (ViewDispatchSfc v : data) {
        dao.update(v);
      }
    }
  }

  public void testInsertAndUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      DispatchSfcDao dao = new DispatchSfcDao(conn);
      DispatchSfc data = dao.selectByPK(
          "SFCStepBO:SFCRouterBO:SFCRoutingBO:SFCBO:TEST,B7BEE041.1,RouterBO:TEST,BUMPING_LIGHT_COMBINE,U,1,1,090");
      data.setSfcStepBo("0000000000000000");
      dao.insert(data);
      data.setAssignInstruction("123434");
      dao.update(data);
      System.out.println(dao.selectByPK("0000000000000000"));
    }
  }

  @Test
  public void testQueueTime() throws SQLException {
    try (Connection conn = DB.create()) {
      DispatchSfcDao dao = new DispatchSfcDao(conn);
      Optional<ViewDispatchSfc> opt1 = dao.selectFutureBySfc("SFCBO:TEST,B81FM730.2").stream()
          .filter(ViewDispatchSfc::checkQueueTimeAvaiable)
          .findAny();
      System.out.println(opt1.isPresent());

      Optional<ViewDispatchSfc> opt2 = dao.selectFutureBySfc("SFCBO:TEST,B7CLM149.6").stream()
          .filter(ViewDispatchSfc::checkQueueTimeAvaiable)
          .findAny();
      System.out.println(opt2.isPresent());
    }
  }

  @Test
  public void testSelectWaiting() throws SQLException {
    try (Connection conn = DB.create()) {
      DispatchSfcDao dao = new DispatchSfcDao(conn);
      dao.selectWaitingByOperation("OperationBO:TEST,IQC-SCR,#").forEach(System.out::println);
    }
  }

  @Test
  public void testSelectRunningByOperation() throws SQLException {
    try (Connection conn = DB.create()) {
      DispatchSfcDao dao = new DispatchSfcDao(conn);
      dao.selectRunningByOperation("OperationBO:TEST,IQC-SCR,#").forEach(System.out::println);
    }
  }

  @Test
  public void testSelectRunningByResource() throws SQLException {
    try (Connection conn = DB.create()) {
      DispatchSfcDao dao = new DispatchSfcDao(conn);
      dao.selectRunningByResource("ResourceBO:TEST,BSCR02").forEach(System.out::println);
    }
  }

  @Test
  public void testSelectWaitingByResources() throws Exception {
    Env.initialProd();
    try (Connection conn = DB.create()) {
      String[] resourceBos = new String[]{"ResourceBO:1020,BEXP02", "ResourceBO:1020,BEXP03",
          "ResourceBO:1020,BEXP04"};
      DispatchSfcDao dao = new DispatchSfcDao(conn);
      dao.selectWaitingByResourceBos(resourceBos).forEach(System.out::println);
    }
  }

  @Test
  public void selectCurrentBySfc() throws Exception {
    Env.initialTest();
    try (Connection conn = DB.create()) {
      new DispatchSfcDao(conn).selectCurrentBySfc("SFCBO:1020,BA11D010.1",
          "SFCBO:1020,SB7TQ017.1.29", "SFCBO:1020,SB7TQ017.1.32").forEach(System.out::println);
    }
  }
}
