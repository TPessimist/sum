package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.MtInventory;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.util.Date;
import org.junit.Test;

public class MtInventoryDaoTest {

  @Test
  public void testInsert() throws Exception {
    Env.initial("app.properties");
    long now = System.currentTimeMillis();
    try (Connection conn = DB.create()) {
      MtInventory inv = new MtInventory();
      inv.setInventoryBo("InventoryBO:1020,H4600701060F-003");
      inv.setAvailableTime(new Date(now - 60000));
      inv.setValidFrom(new Date(now - 60000));
      inv.setValidTo(new Date(now + 360000));
      new MtInventoryDao(conn).insert(inv);
    }
  }

}
