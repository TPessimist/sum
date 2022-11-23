package ame.me.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.SamplingSkipPlan;
import ame.psb.db.conf.DB;
import ame.psb.db.dao.SamplingSkipPlanDao;
import java.util.Date;
import org.junit.Test;

public class SamplingSkipPlanTest {


  @Test
  public void testInsert() {
    try {
      Env.initial("app.properties");
      SamplingSkipPlanDao dao = new SamplingSkipPlanDao(DB.create());
      SamplingSkipPlan p = new SamplingSkipPlan();
      p.setCheckRule("FIRST");
      p.setProcessOperationBo("OperationBO:1020,BPB-PLAT,A");
      p.setInspOperationBo("OperationBO:1020,BFI-AOI_3D,A");
      p.setGroupSize("6");
      p.setUpdatedUser("lihao");
      p.setUpdatedTime(new Date());

      dao.insert(p);

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


  }

}
