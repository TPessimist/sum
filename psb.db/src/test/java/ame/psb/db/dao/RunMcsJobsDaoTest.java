package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.RunMcsJobs;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import org.junit.Test;

public class RunMcsJobsDaoTest {

  @Test
  public void insert() throws Exception {
    Env.initial("app.properties");
    Connection conn = DB.create();
    RunMcsJobs job = new RunMcsJobs();
    job.setCarrierId("FOUP::BEBC0001");
    job.setFromPosition("BSCR02-LP1");
    job.setToPosition("BSCR02-LP2");
    new RunMcsJobsDao(conn).insert(job);
  }

  @Test
  public void testInsert() {
  }

  @Test
  public void update() {
  }

  @Test
  public void testUpdate() {
  }

  @Test
  public void delete() {
  }

  @Test
  public void selectAll() {
  }

  @Test
  public void selectByPK() {
  }
}