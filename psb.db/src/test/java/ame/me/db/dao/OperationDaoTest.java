package ame.me.db.dao;

import ame.me.db.CustomFields;
import ame.psb.commons.Env;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class OperationDaoTest {

  @Test
  public void testSelectAll() throws SQLException {
    try (Connection conn = DB.create()) {
      OperationDao dao = new OperationDao(conn);
      dao.selectAll(Env.SITE).forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByNamePrefix() throws SQLException {
    try (Connection conn = DB.create()) {
      OperationDao dao = new OperationDao(conn);
      dao.selectByNamePrefix(Env.SITE, "PLA1").forEach(System.out::println);
    }
  }

  @Test
  public void testSelectxx() throws SQLException {
    try (Connection conn = DB.create()) {
      OperationDao dao = new OperationDao(conn);
      CustomFieldsDao dao2 = new CustomFieldsDao(conn);
      dao.selectAll(Env.SITE).forEach(o -> {
        CustomFields cfs = new CustomFields();
        try {
          cfs.setHandle(o.getHandle());
          cfs.setAttribute("CYCLE_TIME_TYPE");
          cfs.setValue("120");
          dao2.insert(cfs);

          cfs.setAttribute("OPERATION_TYPE");
          cfs.setValue("P");
          dao2.insert(cfs);

          cfs.setAttribute("RECIPE_TYPE");
          cfs.setValue("M");
          dao2.insert(cfs);
        } catch (Exception e) {
          // TODO Auto-generated catch block
        }
      });
    }
  }
}
