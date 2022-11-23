package ame.psb.db.dao;

import ame.psb.db.RunSfcItem;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;

public class RunSfcItemDaoTest {

  @Test
  public void testInsert() throws SQLException {
    try (Connection conn = DB.create()) {
      RunSfcItem run = new RunSfcItem();
      run.setId("0000000000");
      run.setRunSfc("101");
      run.setSfcBo("Test");
      run.setCustomerItem("C01");
      RunSfcItemDao dao = new RunSfcItemDao(conn);
      dao.insert(run);

      run = dao.selectByPK(run.getId());
      Assert.assertNotNull(run);
    }
  }

  @Test
  public void testSelectBySfc() throws SQLException {
    try (Connection conn = DB.create()) {
      RunSfcItemDao dao = new RunSfcItemDao(conn);
      dao.selectByRunSfc("1511942166877::SFCBO:TEST,E7BVM001.1").forEach(r -> {
        System.out.println(r.getBeginTime() + ":" + r);
      });
      ;
    }
  }

}
