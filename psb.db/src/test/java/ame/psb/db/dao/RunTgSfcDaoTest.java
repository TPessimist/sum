package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.conf.Hana;
import java.sql.Connection;
import java.util.Date;
import org.junit.Test;

public class RunTgSfcDaoTest {

  @Test
  public void testSelectBySfc() throws Exception {
    Date begin = new Date(System.currentTimeMillis() - 86400000 * 10);
    Date end = new Date(System.currentTimeMillis());

    try (Connection conn = Hana.createDev()) {
      RunTgSfcDao dao = new RunTgSfcDao(conn);
      dao.selectBySfc("SFCBO:1020,W83CM001.3", begin, end).forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByResource() throws Exception {
    Date begin = new Date(System.currentTimeMillis() - 86400000 * 10);
    Date end = new Date(System.currentTimeMillis());

    try (Connection conn = Hana.createDev()) {
      RunTgSfcDao dao = new RunTgSfcDao(conn);
      dao.selectByResource("ResourceBO:1020,BDEV04", begin, end).forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByToolNumber() throws Exception {
    Env.initial("app.properties");
    Date begin = new Date(System.currentTimeMillis() - 86400000 * 10);
    Date end = new Date(System.currentTimeMillis());

    try (Connection conn = Hana.createDev()) {
      RunTgSfcDao dao = new RunTgSfcDao(conn);
      dao.selectByToolNumber("ToolNumberBO:1020,JQC1", begin, end).forEach(System.out::println);
    }
  }
}
