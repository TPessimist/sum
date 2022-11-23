package ame.psb.db.dao;

import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class PkgContainerLabelRuleDaoTest {

  @Test
  public void testSelectAll() throws SQLException {
    try (Connection conn = DB.create()) {
      final PkgContainerLabelRuleDao dao = new PkgContainerLabelRuleDao(conn);
      dao.selectAll().forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByItemGroup() throws SQLException {
    try (Connection conn = DB.create()) {
      final PkgContainerLabelRuleDao dao = new PkgContainerLabelRuleDao(conn);
      dao.selectByItemGroup("ItemGroupBO:1020,YHB13004B").forEach(System.out::println);
    }
  }
}
