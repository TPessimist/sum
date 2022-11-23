package ame.psb.db.dao;

import ame.psb.db.FullLotReportResult;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.util.List;
import org.junit.Test;

public class ActivityLogDaoTest {

  @Test
  public void testAll() throws Exception {
    try (Connection conn = DB.create()) {
      ActivityLogDao dao = new ActivityLogDao(conn);
      List<FullLotReportResult> cs = dao.selectBySfcName("B822M002.6");
      cs.forEach(c -> System.out.println(c.runSfcs));
      cs.forEach(c -> System.out.println(c.activityLogs.getActionDetailHandle()));
    }
  }
}
