package ame.me.db.dao;

import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class DcParameterDaoTest {

  @Test
  public void testSelect() throws SQLException {
    try (Connection conn = DB.create()) {
      DcParameterDao dao = new DcParameterDao(conn);
      dao.selectByGroup("DcGroupBO:TEST,TETC1-NCG1,A").forEach(System.out::println);
    }
  }
}
