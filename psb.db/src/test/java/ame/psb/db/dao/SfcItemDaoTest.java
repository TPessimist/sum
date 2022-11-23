package ame.psb.db.dao;

import ame.psb.db.FullLotReportResult;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

public class SfcItemDaoTest {

  @Test
  public void testSelect() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcItemDao dao = new SfcItemDao(conn);
      System.out.println(dao.selectByPK("SFCBO:TEST,B7BEE042.1", "PSB-L001-W01::1510628689763"));
      dao.selectBySfc("SFCBO:TEST,B7BEE042.1").forEach(System.out::println);
    }
  }

  @Test
  public void testSelectBySfcBoIn() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcItemDao dao = new SfcItemDao(conn);
      List<FullLotReportResult> cs = dao.selectBySfcBoWafer("1522140118509::SFCBO:1020,B83PM002.1");
      cs.forEach(c -> System.out.println(c.runSfcs));
      cs.forEach(c -> System.out.println(c.activityLogs.getActionCode()));
    }
  }

}
