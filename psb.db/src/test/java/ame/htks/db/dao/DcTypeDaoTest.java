package ame.htks.db.dao;

import ame.htks.db.DcType;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

public class DcTypeDaoTest {

  @Test
  public void testAll() throws SQLException {
    try (Connection conn = DB.create()) {
      DcTypeDao dao = new DcTypeDao(conn);
      List<DcType> zdh = dao.selectAll();
      zdh.forEach(c -> System.out.println(c.getTypeId()));
    }
  }

  @Test
  public void testInsert() throws SQLException {
    try (Connection conn = DB.create()) {
      DcTypeDao dao = new DcTypeDao(conn);
      for (int i = 1001; i <= 1005; i++) {
        DcType c = new DcType();
        c.setTypeId("DC" + i);
        dao.insert(c);
      }
    }
  }

}
