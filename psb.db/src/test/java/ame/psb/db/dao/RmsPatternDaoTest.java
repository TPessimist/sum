package ame.psb.db.dao;

import ame.psb.db.RmsPattern;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class RmsPatternDaoTest {

  @Test
  public void testInsertAndUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      RmsPatternDao dao = new RmsPatternDao(conn);
      RmsPattern data = dao.selectByPK("OperationBO:1020,EPA-SIA2,#");
      data.setId("0000000000000000");
      dao.insert(data);
      data.setRecipePattern("123434");
      dao.update(data);
    }
  }

  @Test
  public void testDelete() throws SQLException {
    try (Connection conn = DB.create()) {
      RmsPatternDao dao = new RmsPatternDao(conn);
      dao.delete("0000000000000000");
    }
  }
}