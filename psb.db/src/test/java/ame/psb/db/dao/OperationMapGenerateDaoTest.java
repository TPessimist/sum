package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.conf.DB;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import org.junit.Test;

public class OperationMapGenerateDaoTest {

  @Test
  public void testQuery() throws Exception {
    Env.initial("app.properties");
    try (Connection conn = DB.create()) {
      OperationMapGenerateDao dao = new OperationMapGenerateDao(conn);
      // System.out.println(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").setPrettyPrinting().create().toJson(dao.selectAll()));
    }
  }

  @Test
  public void testQueryBinMapCombine() throws Exception {
    Env.initial("app.properties");
    try (Connection conn = DB.create()) {
      SamplingResultDao dao = new SamplingResultDao(conn);
      System.out.println(
          new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").setPrettyPrinting().create()
              .toJson(dao.selectAll()));
    }
  }
}
