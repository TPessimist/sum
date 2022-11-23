package ame.psb.db.dao;

import ame.psb.db.HoldSfc;
import ame.psb.db.conf.DB;
import ame.psb.db.conf.Hana;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import uia.utils.dao.Where;

public class HoldSfcDaoTest {

  @Test
  public void testSelect() throws SQLException {
    try (Connection conn = Hana.createTest()) {
      HoldSfcDao dao = new HoldSfcDao(conn);
      // dao.select(new Where().like("SFC_NAME", "B812M35", "%")).forEach(System.out::println);
      //dao.select(new Where().likeBegin("REASON_CODE_BO", "%FTLD")).forEach(System.out::println);
      dao.select(new Where().in("sfc_bo", "SFCBO:1020,B82NM001.1", "SFCBO:1020,E974M094.1"))
          .forEach(System.out::println);
    }
  }

  @Test
  public void testSelectSfc() throws SQLException {
    try (Connection conn = DB.create()) {
      HoldSfcDao dao = new HoldSfcDao(conn);
      System.out.println(dao.selectBySfc("SFCBO:TEST,E7CTM031.10"));
    }
  }

  @Test
  public void testSelectByRelease() throws SQLException {
    try (Connection conn = DB.create()) {
      HoldSfcDao dao = new HoldSfcDao(conn);
      dao.selectByRelease("e90a3353-304c-4365-8fa6-e6ea9ea667c7").forEach(System.out::println);
    }
  }

  @Test
  public void testInsertAndUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      HoldSfc data = new HoldSfc();
      HoldSfcDao dao = new HoldSfcDao(conn);
      data.setHoldDetailBo("0000000000000000");
      dao.insert(data);
      data.setRunSfcBo("123434");
      dao.update(data);
      dao.selectByRelease("0000000000000000").forEach(System.out::println);
    }
  }
}
