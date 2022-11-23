package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import org.junit.Test;

public class ToolUsageDaoTest {

  @Test
  public void testSelect() throws Exception {
    Env.initial("app.properties");
    try (Connection conn = DB.create()) {
      ToolUsageDao dao = new ToolUsageDao(conn);
      dao.selectActiveByResource("ResourceBO:1020,BDEV04").forEach(System.out::println);
    }
  }

}
