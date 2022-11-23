package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.CPEQCSamplingPlan;
import ame.psb.db.conf.DB;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class CPEQCSamplingPlanDaoTest {

  @Test
  void insert() {

    try {
      Env.initialTest();
      CPEQCSamplingPlanDao cpeqcSamplingPlanDao = new CPEQCSamplingPlanDao(DB.create());
      CPEQCSamplingPlan data = new CPEQCSamplingPlan();
      data.setId(UUID.randomUUID().toString());
      data.setEqcSamplingPlanType("EQC_CP_SAMPLING_TYPE_RELATIVE_POSITION");
      data.setItemGroupBo("ItemGroupBO:1020,X68037B");
      data.setLotType("M");
      data.setOperationBo("OperationBO:1020,BFL1-INSP,#");
      data.setBeginQty(BigDecimal.ONE);
      data.setCenterQty(BigDecimal.ONE);
      data.setEndQty(BigDecimal.ONE);
      data.setStatus("ENABLE");
      data.setUpdatedUser("lh");
      data.setUpdatedTime(new Date());
      cpeqcSamplingPlanDao.insert(data);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }



  @Test
  void insert2() {

    try {
      Env.initialTest();
      CPEQCSamplingPlanDao cpeqcSamplingPlanDao = new CPEQCSamplingPlanDao(DB.create());
      CPEQCSamplingPlan data = new CPEQCSamplingPlan();
      data.setId(UUID.randomUUID().toString());
      data.setEqcSamplingPlanType("EQC_CP_SAMPLING_TYPE_ASSIGN_WAFER");
      data.setOperationBo("OperationBO:1020,BFL1-INSP,#");
      data.setShopOrderBo("ShopOrderBO:1020,APB-210720491");
      data.setCustomerItemBo("N162237.804::1626742677015");
      data.setStatus("ENABLE");
      data.setUpdatedUser("lh");
      data.setUpdatedTime(new Date());
      cpeqcSamplingPlanDao.insert(data);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}