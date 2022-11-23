package ame.psb.db.dao;

import ame.psb.db.CustomerItemGrade;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class CustomerItemGradeDaoTest {

  @Test
  public void testInsertAndUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      CustomerItemGradeDao dao = new CustomerItemGradeDao(conn);
      CustomerItemGrade data = dao.selectByPK("W-CL-1047-04::1517423585230", "A");
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
      CustomerItemGradeDao dao = new CustomerItemGradeDao(conn);
      dao.delete("0000000000000000");
    }
  }

}