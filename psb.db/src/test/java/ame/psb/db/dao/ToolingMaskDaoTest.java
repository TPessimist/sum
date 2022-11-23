package ame.psb.db.dao;

import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class ToolingMaskDaoTest {

  @Test
  public void test() throws SQLException {
    try (Connection conn = DB.create()) {
      ToolingMaskDao dao = new ToolingMaskDao(conn);
      System.out
          .println(dao.selectByPK("OperationBO:9998,BFP1-EXP,#", "ItemBO:9998,18N001B00WBS,A"));
    }
  }
}
