package ame.me.db.dao;

import ame.psb.db.conf.Hana;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class CertReqUserDaoTest {

  @Test
  public void testSelectAll() throws SQLException {
    try (Connection conn = Hana.createDev()) {
      CertReqUserDao dao = new CertReqUserDao(conn);
      dao.selectCertified("ResourceBO:1020,EOVN07", "UserBO:1020,12827")
          .forEach(System.out::println);
    }
  }

}
