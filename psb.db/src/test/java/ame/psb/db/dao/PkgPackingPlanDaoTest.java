package ame.psb.db.dao;

import ame.psb.db.PkgPackingPlan;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class PkgPackingPlanDaoTest {

  @Test
  public void testInsertAndUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      PkgPackingPlanDao dao = new PkgPackingPlanDao(conn);
      PkgPackingPlan data = dao.selectByPK("X68005B_C1");
      data.setId("0000000000000000");
      dao.insert(data);
      data.setMaxQty(123434);
      dao.update(data);
      System.out.println(dao.selectByPK("0000000000000000"));
    }
  }

  @Test
  public void testDelete() throws SQLException {
    try (Connection conn = DB.create()) {
      PkgPackingPlanDao dao = new PkgPackingPlanDao(conn);
      dao.delete("0000000000000000");
    }
  }
}