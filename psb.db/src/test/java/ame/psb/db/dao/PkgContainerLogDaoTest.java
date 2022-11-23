package ame.psb.db.dao;

import ame.psb.db.PkgContainerLog;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import org.junit.Test;

public class PkgContainerLogDaoTest {

  @Test
  public void test() throws Exception {
    try (Connection conn = DB.create()) {
      PkgContainerDao dao = new PkgContainerDao(conn);
      PkgContainerLogDao dao1 = new PkgContainerLogDao(conn);
      dao1.insert(new PkgContainerLog(dao.selectByPK("B18200002"), ""));
    }
  }
}
