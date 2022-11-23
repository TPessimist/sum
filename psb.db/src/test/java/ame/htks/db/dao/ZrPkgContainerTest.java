package ame.htks.db.dao;

import ame.htks.db.DcType;
import ame.psb.commons.Env;
import ame.psb.db.PkgContainer;
import ame.psb.db.conf.DB;
import ame.psb.db.dao.PkgContainerDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.junit.Test;

public class ZrPkgContainerTest {

  @Test
  public void testAll() throws SQLException {
    try (Connection conn = DB.create()) {
      DcTypeDao dao = new DcTypeDao(conn);
      List<DcType> zdh = dao.selectAll();
      zdh.forEach(c -> System.out.println(c.getTypeId()));
    }
  }

  @Test
  public void testInsert() throws Exception {
    Env.initial("app.properties");
    try (Connection conn = DB.create()) {
      PkgContainerDao dao = new PkgContainerDao(conn);
      PkgContainer c = new PkgContainer();
      c.setBadDie1(0);
      c.setBadDie2(0);
      c.setBatchId("");
      c.setBoxStep("");
      c.setContainerName("");
      c.setContainerSeqId("");
      c.setContainerType("");
      //c.setCustomerItemBo("");
      c.setCustomerItemLotBo("");
      c.setCustomerItemLotNames("");
      c.setCustomerItemNames("");
      c.setDnNo("");
      c.setGoodBad("G");
      c.setGoodDie(0);
      c.setId("test1");
      c.setItemBo("");
      c.setItemGroupBo("");
      c.setItemLevel("");
      c.setOperationBo("");
      c.setPackingPlanBo("");
      c.setPackingTime(new Date());
      c.setPackingUser("LH");
      c.setPkgContainerBo("");
      c.setStateName("");
      dao.insert(c);

    }
  }
}
