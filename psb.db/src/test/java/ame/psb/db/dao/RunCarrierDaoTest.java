package ame.psb.db.dao;

import ame.psb.db.RunCarrier;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;

public class RunCarrierDaoTest {

  @Test
  public void testInsert() throws SQLException {
    try (Connection conn = DB.create()) {
      RunCarrier run = new RunCarrier();
      run.setId("000000000000");
      run.setCarrierBo("CARRIER_NAME01");
      RunCarrierDao dao = new RunCarrierDao(conn);
      dao.insert(run);

      run = dao.selectByPK(run.getId());
      Assert.assertNotNull(run);
    }
  }

  @Test
  public void testSelectByPK() throws SQLException {
    try (Connection conn = DB.create()) {
      RunCarrierDao dao = new RunCarrierDao(conn);
      RunCarrier c = dao.selectByPK("1512119999052::FOUP::C18");
      System.out.println(c);
    }
  }

}
