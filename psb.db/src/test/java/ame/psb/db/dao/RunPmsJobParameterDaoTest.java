package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.conf.DB;
import org.junit.Test;

public class RunPmsJobParameterDaoTest {

  @Test
  public void selectAutoSfc() throws Exception {
    Env.initialTest();
    new RunPmsJobParameterDao(DB.create()).selectAutoJobs().stream().map(it -> it.sfcName)
        .forEach(System.out::println);
  }
}