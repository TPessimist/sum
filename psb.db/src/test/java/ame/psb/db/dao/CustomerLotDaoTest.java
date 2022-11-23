package ame.psb.db.dao;

import ame.psb.db.CustomerLot;
import ame.psb.db.ViewCustomerLot;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.junit.Test;

public class CustomerLotDaoTest {

  @Test
  public void testInsert() throws SQLException {
    CustomerLot lot = new CustomerLot();

    //lot.setId("1509355484900:TEST-L104");
    lot.setItemLotName("TEST-L104");
    lot.setCreatedTime(new Date());
    try (Connection conn = DB.create()) {
      CustomerLotDao lotDao = new CustomerLotDao(conn);

      lotDao.insert(lot);
    }
  }

  @Test
  public void testSelectByName() throws SQLException {
    try (Connection conn = DB.create()) {
      CustomerLotDao lotDao = new CustomerLotDao(conn);
      //Assert.assertNotNull(lotDao.selectByName("TEST-L101"));
      CustomerLot c = lotDao.selectByName("CL-01");
      ;
      System.out.println(c.getId());

    }
  }

  @Test
  public void testSelect() throws SQLException {
    try (Connection conn = DB.create()) {
      CustomerLotDao dao = new CustomerLotDao(conn);
      List<ViewCustomerLot> cs = dao.selectAll();

      cs.forEach(c -> System.out.println(c.getId()));
    }
  }
}
