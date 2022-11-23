package ame.psb.db.dao;

import ame.psb.db.SfcItemGrade;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class SfcItemGradeDaoTest {

  @Test
  public void testInsertAndUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcItemGradeDao dao = new SfcItemGradeDao(conn);
      SfcItemGrade data = dao
          .selectByPK("SFCBO:9998,B822M002.3.1", "B-XL-2004-03::1517512973086", "A");
      data.setSfcBo("0000000000000000");
      data.setCustomerItemBo("0000000000000000");
      data.setGradeId("A");
      dao.insert(data);
      data.setDieQty(123434);
      dao.update(data);
    }
  }

  @Test
  public void testDelete() throws SQLException {
    try (Connection conn = DB.create()) {
      SfcItemGradeDao dao = new SfcItemGradeDao(conn);
      dao.delete("0000000000000000", "0000000000000000", "A");
    }
  }
}