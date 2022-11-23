package ame.psb.db.dao;

import ame.psb.db.SfcExLog;
import ame.psb.db.ViewSfcEx;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class SfcExLogDaoTest {

  @Test
  public void testSelectByPK() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcExDao dao = new SfcExDao(conn);
      SfcExLogDao dao1 = new SfcExLogDao(conn);
      ViewSfcEx sfc = dao.selectByPK("SFCBO:9998,W821M001.1");
      dao1.insert(new SfcExLog(sfc, ""));
    }
  }
}
