package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class PackageDaoTest {

  @Test
  public void testSelectAll() throws SQLException {
    try (Connection conn = DB.create()) {
      final PackageDao dao = new PackageDao(conn);
      dao.selectAll(Env.SITE).forEach(System.out::println);
    }
  }
}
