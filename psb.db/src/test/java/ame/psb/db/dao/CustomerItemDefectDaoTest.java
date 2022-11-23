package ame.psb.db.dao;

import ame.psb.db.CustomerItemDefect;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class CustomerItemDefectDaoTest {

  @Test
  public void testSelectByName() throws SQLException {
    try (Connection conn = DB.create()) {
      CustomerItemDefectDao dao = new CustomerItemDefectDao(conn);
      dao.selectByCustomerItem("123").forEach(System.out::println);

    }
  }

  @Test
  public void testInsertAndUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      CustomerItemDefectDao dao = new CustomerItemDefectDao(conn);
      CustomerItemDefect data = dao
          .selectByPK("W-CL-1047-04::1517423585230", "NCCodeBO:9998,S00001");
      data.setCustomerItemBo("0000000000000000");
      data.setNcCodeBo("0000000000000000");
      dao.insert(data);
      data.setNcValue(123434);
      dao.update(data);
      System.out.println(dao.selectByPK("0000000000000000", "0000000000000000"));
    }
  }
}
