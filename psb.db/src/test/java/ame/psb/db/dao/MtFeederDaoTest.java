package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.ViewMtFeeder;
import ame.psb.db.conf.DB;
import java.util.Date;
import org.junit.Test;

public class MtFeederDaoTest {

  @Test
  public void select() {
    try {
      Env.initialTest();
      MtFeederDao mtFeederDao = new MtFeederDao(DB.create());
      ViewMtFeeder viewMtFeeder = mtFeederDao
          .selectByPK("1634367828223::05c72592-9a42-468e-a477-39091869512e");

      System.out.println(viewMtFeeder);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  @Test
  public void update() {
    try {
      Env.initialTest();
      MtFeederDao mtFeederDao = new MtFeederDao(DB.create());
      ViewMtFeeder viewMtFeeder = mtFeederDao
          .selectByPK("1634367828223::05c72592-9a42-468e-a477-39091869512e");

      viewMtFeeder.setLifeTime(new Date());
      mtFeederDao.update(viewMtFeeder);

      System.out.println(viewMtFeeder);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void insert() {
    try {
      Env.initialTest();
      MtFeederDao mtFeederDao = new MtFeederDao(DB.create());
      ViewMtFeeder viewMtFeeder = mtFeederDao
          .selectByPK("1634367828223::05c72592-9a42-468e-a477-39091869512e");
      viewMtFeeder.setId("1634367828223::05c72592-9a42-468e-a477-39091869512f");
      mtFeederDao.insert(viewMtFeeder);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void delete() {
    try {
      Env.initialTest();
      MtFeederDao mtFeederDao = new MtFeederDao(DB.create());
      mtFeederDao.delete("1634367828223::05c72592-9a42-468e-a477-39091869512f");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}