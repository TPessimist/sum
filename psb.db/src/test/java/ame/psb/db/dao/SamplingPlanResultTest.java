package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.conf.DB;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import org.junit.Test;

public class SamplingPlanResultTest {

  @Test
  public void testSelect() throws Exception {
    Env.initial("app.properties");
    try (Connection conn = DB.create()) {
      SamplingResultDao dao = new SamplingResultDao(conn);
      dao.selectEffectedByOperation("OperationBO:TEST,IQC-OVN,#").forEach(this::printJson);

    }
  }

  public void printJson(Object o) {
    System.out.println(new GsonBuilder()
        .serializeNulls()
        .setPrettyPrinting()
        .setDateFormat("yyyy-MM-dd HH:mm:ss")
        .create()
        .toJson(o));
  }
}
