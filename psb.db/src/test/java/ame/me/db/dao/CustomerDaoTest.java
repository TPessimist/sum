package ame.me.db.dao;

import ame.me.db.Customer;
import ame.psb.commons.Env;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.stream.Collectors;
import org.junit.Test;

public class CustomerDaoTest {

  @Test
  public void testSelectAll() throws SQLException {
    try (Connection conn = DB.create()) {
      CustomerDao dao = new CustomerDao(conn);
      dao.selectAll(Env.SITE).forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByName() throws SQLException {
    try (Connection conn = DB.create()) {
      CustomerDao dao = new CustomerDao(conn);
      dao.selectByNamePrefix(Env.SITE, "Y").forEach(System.out::println);
    }
  }


  @Test
  public void testSelectByName1() throws SQLException {
    try {
      Env.initialTest();
      CustomerDao dao = new CustomerDao(DB.create());
      dao.selectByCustomerGroup("US008", "68")
          .stream().map(Customer::getCustomerName).collect(Collectors.toSet()).forEach(
          System.out::println

      );

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
