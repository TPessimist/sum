package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.conf.DB;
import org.junit.Test;

public class FunctionCardControlDaoTest {

  @Test
  public void test1() {
    try {
      Env.initialTest();
      FunctionCardControlDao functionCardControlDao = new FunctionCardControlDao(DB.create());
      System.out.println(functionCardControlDao.isOpen("PACKING_TRAY_STATE"));


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}