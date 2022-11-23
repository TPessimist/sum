package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.conf.DB;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import org.junit.Test;
import uia.utils.dao.Where;

public class SamplingPlanDaoTest {

  @Test
  public void testSelect() throws Exception {
    Env.initial("app.properties");
    try (Connection conn = DB.create()) {
      SamplingPlanDao dao = new SamplingPlanDao(conn);
      dao.select(new Where().like("CUSTOMER_BO", "30")).forEach(this::printJson);

    }
  }

  @Test
  public void testEqSelect() throws Exception {
    Env.initial("app.properties");
    try (Connection conn = DB.create()) {
      SamplingPlanDao dao = new SamplingPlanDao(conn);
      dao.select(new Where().eq("MEASUREMENT_OPERATION", "FV-MIC2")
          .eq("CUSTOMER_NAME", "YA19")).forEach(this::printJson);

    }
  }

  @Test
  public void testSelect1() throws Exception {
    Env.initial("app.properties");
    try (Connection conn = DB.create()) {
      SamplingPlanDao dao = new SamplingPlanDao(conn);
      dao.select("E", "OperationBO:TEST,BETCHPB-BH,#", "33").forEach(this::printJson);
    }
  }

  @Test
  public void testSelect2() throws Exception {
    Env.initial("app.properties");
    try (Connection conn = DB.create()) {
      SamplingPlanDao dao = new SamplingPlanDao(conn);
      dao.select("E", "OperationBO:TEST,BETCHPB-BH,#", "33", "ItemGroupBO:TEST,X37046B",
          "ItemBO:TEST,18A301M0030CF,A").forEach(this::printJson);
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
