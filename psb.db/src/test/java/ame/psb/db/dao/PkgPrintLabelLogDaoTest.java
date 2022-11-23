package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.PkgPrintLabelLog;
import ame.psb.db.conf.DB;
import java.util.List;
import org.junit.Test;

public class PkgPrintLabelLogDaoTest {

  @Test
  public void selectAll() {
    try {
      Env.initialTest();

      List<PkgPrintLabelLog> t20770869 = new PkgPrintLabelLogDao(DB.create())
          .selectByContainerBo("T20770869");
      System.out.println(t20770869);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void update() {
    try {
      Env.initialTest();

      PkgPrintLabelLogDao pkgPrintLabelLogDao = new PkgPrintLabelLogDao(DB.create());
      List<PkgPrintLabelLog> t20770869 = pkgPrintLabelLogDao
          .selectByContainerBo("T20770869");
      PkgPrintLabelLog pkgPrintLabelLog = t20770869.get(0);
      pkgPrintLabelLog.setNewestPrint("Y");
      pkgPrintLabelLogDao.update(pkgPrintLabelLog);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void insert() {
    try {
      Env.initialTest();
      PkgPrintLabelLogDao pkgPrintLabelLogDao = new PkgPrintLabelLogDao(DB.create());
      List<PkgPrintLabelLog> t20770869 = pkgPrintLabelLogDao
          .selectByContainerBo("T20770869");

      PkgPrintLabelLog pkgPrintLabelLog = t20770869.get(0);
      pkgPrintLabelLog.setId("202206080002");
      pkgPrintLabelLog.setNewestPrint("N");
      pkgPrintLabelLogDao.insert(pkgPrintLabelLog);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void delete() {
    try {
      Env.initialTest();
      int delete = new PkgPrintLabelLogDao(DB.create())
          .delete("9f502663-8c97-45da-878b-f3a3252d8391");

      System.out.println(delete);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}