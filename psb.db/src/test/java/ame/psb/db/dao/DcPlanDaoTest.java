package ame.psb.db.dao;

import ame.psb.db.DcPlan;
import ame.psb.db.conf.DB;
import ame.psb.db.conf.Oracle;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class DcPlanDaoTest {

  @Test
  public void test() throws SQLException {
    try (Connection conn = Oracle.create()) {
      DcPlanDao dao = new DcPlanDao(conn);
      System.out.println(dao.selectByPK("b58b9c5b-80eb-49e9-b8a4-7276df8b3ae5"));
    }
  }

  @Test
  public void testInsert() throws SQLException {
    DcPlan data = new DcPlan();

    try (Connection conn = DB.create()) {
      DcPlanDao dao = new DcPlanDao(conn);
      dao.insert(data);

      System.out.println(dao.selectByPK(data.getId()));
    }
  }

  @Test
  public void testInsertAndUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      DcPlanDao dao = new DcPlanDao(conn);
      DcPlan data = dao.selectByPK("01677490-f9c9-4dc2-a091-7deb8974c963");
      data.setId("0000000000000000");
      dao.insert(data);
      data.setDcopBo("123434");
      dao.update(data);
      System.out.println(dao.selectByPK("0000000000000000"));
    }
  }
}
