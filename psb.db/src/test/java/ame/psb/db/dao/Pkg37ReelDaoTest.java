package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.Pkg37Reel;
import ame.psb.db.conf.DB;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import org.junit.Test;

public class Pkg37ReelDaoTest {

  @Test
  public void test1() {
    try {
      Env.initialTest();
      Connection conn = DB.create();
      Pkg37ReelDao pkg37ReelDao = new Pkg37ReelDao(conn);
      Pkg37Reel pkg37Reel = new Pkg37Reel();
      pkg37Reel.setReelId("SSB6GM044-R92");
      pkg37Reel.setSfcBo("SB6GM044.1");
      pkg37Reel.setStateName("LOAD_STATE");
      pkg37Reel.setJobId("359492.1");
      pkg37Reel.setReelSeq(new BigDecimal(1));
      pkg37Reel.setDieQty(new BigDecimal(30));
      pkg37Reel.setReversedField1("");
      pkg37Reel.setReversedField2("");
      pkg37Reel.setUpdatedUser("lihao");
      pkg37Reel.setUpdatedTime(new Date());
      pkg37ReelDao.insert(pkg37Reel);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}