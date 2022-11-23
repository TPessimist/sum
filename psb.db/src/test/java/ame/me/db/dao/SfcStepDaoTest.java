package ame.me.db.dao;

import ame.me.db.SfcStep;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

public class SfcStepDaoTest {

  @Test
  public void testPM() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcStepDao dao = new SfcStepDao(conn);
      System.out.println(dao.selectPM("SFCBO:1020,BMIC01", "", "030").getOperationBo());
    }
  }

  @Test
  public void testBySfc() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcStepDao dao = new SfcStepDao(conn);
      List<SfcStep> steps = dao.selectBySfc("SFCBO:1020,S825M001.1");
      for (SfcStep step : steps) {
        System.out.println(step);
      }
    }
  }

  @Test
  public void testBySfcCurrent() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcStepDao dao = new SfcStepDao(conn);
      System.out.println(dao.selectCurrentBySfc("SFCBO:1020,S825M001.1"));
      System.out.println(dao.selectCurrentBySfc("SFCBO:1020,S828M002.7"));
    }
  }

  @Test
  public void testBySfcRunning() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcStepDao dao = new SfcStepDao(conn);
      System.out.println(dao.selectRunningBySfc("SFCBO:1020,S825M001.1"));
    }
  }

  @Test
  public void testBySfcWaiting() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcStepDao dao = new SfcStepDao(conn);
      System.out.println(dao.selectWaitingBySfc("SFCBO:1020,S828M002.7"));
    }
  }
}
