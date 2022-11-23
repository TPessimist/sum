package ame.psb.db.dao;

import ame.psb.db.PkgLabel;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class PkgLabelDaoTest {

  @Test
  public void testInsertAndUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      PkgLabelDao dao = new PkgLabelDao(conn);
      PkgLabel data = dao.selectByPK("_TEST_PACKING_BAD_DIE1");
      data.setId("0000000000000000");
      dao.insert(data);
      data.setTemplateId("123434");
      dao.update(data);
      System.out.println(dao.selectByPK("0000000000000000"));
    }
  }

  @Test
  public void testDelete() throws SQLException {
    try (Connection conn = DB.create()) {
      PkgLabelDao dao = new PkgLabelDao(conn);
      dao.delete("0000000000000000");
      System.out.println(dao.selectByPK("0000000000000000"));
    }
  }

}