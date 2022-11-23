package ame.psb.db.dao;

import ame.me.db.dao.RouterOperationDao;
import ame.psb.db.ItemOperation;
import ame.psb.db.ViewItemOperation;
import ame.psb.db.conf.DB;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

public class ItemOperationDaoTest {

  @Test
  public void testSelect() throws SQLException {
    String base = "OperationBO:TEST,IQC-SCR,#";

    try (Connection conn = DB.create()) {
      final RouterOperationDao dao = new RouterOperationDao(conn);
      dao.selectByRouter("RouterBO:TEST,BUMPING_LIGHT_COMBINE,U,1").forEach(o -> {
        System.out.println(o.getOperationParent() + ":" + base.equals(o.getOperationParent()));
      });
    }
  }

  @Test
  public void testSelectByItem() throws SQLException {
    try (Connection conn = DB.create()) {
      final ItemOperationDao dao = new ItemOperationDao(conn);
      List<ViewItemOperation> ios = dao.selectByItem("ItemBO:TEST,DIE-001,1.0");
      for (ViewItemOperation io : ios) {
        io.setYieldSfc(new BigDecimal("99.15"));
        io.setYieldSfcItem(new BigDecimal("99.51"));
        dao.update(io);
      }
    }
  }

  @Test
  public void testInsertAndUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      ItemOperationDao dao = new ItemOperationDao(conn);
      ItemOperation data = dao
          .selectByPK("ItemBO:1020,18A101M10CF,A", "OperationBO:1020,EPKG-OQC,#");
      data.setItemBo("0000000000000000");
      data.setOperationBo("0000000000000000");
      dao.insert(data);
      data.setCycleTime(123434);
      dao.update(data);
      System.out.println(dao.selectByPK("0000000000000000", "0000000000000000"));
    }
  }
}
