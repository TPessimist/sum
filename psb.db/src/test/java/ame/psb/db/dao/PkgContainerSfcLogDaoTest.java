package ame.psb.db.dao;

import ame.psb.db.PkgContainerSfcLog;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import org.junit.Test;

public class PkgContainerSfcLogDaoTest {

  @Test
  public void test() throws Exception {
    try (Connection conn = DB.create()) {
      PkgContainerSfcDao dao = new PkgContainerSfcDao(conn);
      PkgContainerSfcLogDao dao1 = new PkgContainerSfcLogDao(conn);
      dao1.insert(
          new PkgContainerSfcLog(dao.selectByPK("Q18200001", "SFCBO:9998,B822M002.3.1"), ""));
    }
  }
}
