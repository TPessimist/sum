package ame.psb.db.dao;

import ame.psb.db.PkgLabel;
import ame.psb.db.PkgLabelTag;
import ame.psb.db.PkgTag;
import ame.psb.db.conf.Hana;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class PkgLabelTagDaoTest {

  @Test
  public void test() throws SQLException {
    try (Connection conn = Hana.createTest()) {
      PkgTagDao dao1 = new PkgTagDao(conn);
      PkgLabelDao dao2 = new PkgLabelDao(conn);
      PkgLabelTagDao dao3 = new PkgLabelTagDao(conn);
      for (PkgTag tag : dao1.selectAll()) {
        if (dao2.selectByPK("_TEST_" + tag.getId()) == null) {
          PkgLabel label = new PkgLabel();
          label.setId("_TEST_" + tag.getId());
          label.setLabelName("_TEST_" + tag.getId());
          dao2.insert(label);
          PkgLabelTag lt = new PkgLabelTag();
          lt.setLabelBo(label.getId());
          System.out.println(tag.getId());
          dao3.insert(label.getId(), tag.getId());
        }
      }
    }
  }
}
