package ame.psb.db.dao;

import ame.psb.db.RunSfc;
import ame.psb.db.conf.DB;
import ame.psb.db.conf.Hana;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;

public class RunSfcDaoTest {

  @Test
  public void testInsert() throws SQLException {
    try (Connection conn = DB.create()) {
      RunSfc run = new RunSfc();
      run.setId("0000000000000");
      run.setSfcBo("OP001");
      run.setSfcStepBo("STEP001");
      run.setRunCarrierBo("C0001");
      RunSfcDao dao = new RunSfcDao(conn);
      dao.insert(run);

      run = dao.selectByPK(run.getId());
      Assert.assertNotNull(run);
    }
  }

  @Test
  public void testSelectByCarrier() throws SQLException {
    try (Connection conn = DB.create()) {
      RunSfcDao dao = new RunSfcDao(conn);
      dao.selectByRunCarrier("1512032466668::FOUP::C10").forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByOperation() throws SQLException {
    try (Connection conn = DB.create()) {
      RunSfcDao dao = new RunSfcDao(conn);
      for (RunSfc r : dao.selectByOperation("OperationBO:1002,OP-001,#")) {
        System.out.println(r);
      }
    }
  }

  @Test
  public void testSelectByResource() throws SQLException {
    try (Connection conn = DB.create()) {
      RunSfcDao dao = new RunSfcDao(conn);
      for (RunSfc r : dao.selectByResource("ResourceBO:1002,EQ-0001.C2")) {
        System.out.println(r);
      }
    }
  }

  @Test
  public void testSelectDoneBySfc() throws SQLException {
    try (Connection conn = Hana.createDev()) {
      RunSfcDao dao = new RunSfcDao(conn);
      dao.selectDoneBySfc("SFCBO:1020,W838M001.5").forEach(System.out::println);
      dao.selectDoneBySfc("SFCBO:1020,W838M001.5", "BFP1-COAT").forEach(System.out::println);
    }
  }
}
