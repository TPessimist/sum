package ame.me.db.dao;

import ame.psb.db.conf.Hana;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class UserCertDaoTest {

  @Test
  public void testSelectAll() throws SQLException {
    try (Connection conn = Hana.createDev()) {
      UserCertDao dao = new UserCertDao(conn);
      dao.selectByUser("UserBO:1020,12827").forEach(System.out::println);
    }
  }

}
