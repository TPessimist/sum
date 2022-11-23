package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.conf.DB;
import org.junit.Test;

public class PmsResourceSettingDaoTest {

  @Test
  public void selectByType() throws Exception {
    Env.initialTest();
    new PmsResourceSettingDao(DB.create()).selectByType("AUTO").forEach(System.out::println);
  }
}