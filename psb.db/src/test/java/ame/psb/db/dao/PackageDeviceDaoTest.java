package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class PackageDeviceDaoTest {

  @Test
  public void testSelectAll() throws SQLException {
    try (Connection conn = DB.create()) {
      PackageDeviceDao dao = new PackageDeviceDao(conn);
      dao.selectAll(Env.SITE).forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByDevice() throws SQLException {
    try (Connection conn = DB.create()) {
      PackageDeviceDao dao = new PackageDeviceDao(conn);
      System.out.println(dao.selectByDevice("ItemGroupBO:TEST,DEVICE003"));
      System.out.println(dao.selectByDeviceName(Env.SITE, "DEVICE004"));
    }
  }
}
