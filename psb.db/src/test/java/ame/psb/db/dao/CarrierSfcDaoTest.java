package ame.psb.db.dao;

import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import org.junit.Test;

public class CarrierSfcDaoTest {

  @Test
  public void testTx() throws SQLException {
    try (Connection conn = DB.create()) {
      conn.setAutoCommit(false);
      CarrierSfcDao dao = new CarrierSfcDao(conn);
      dao.insert("FOUP::C4", "12345", "SYS", new Date());
      System.out.println(dao.selectCarrier("12345"));

      PreparedStatement ps1 = conn
          .prepareStatement("select sfc_bo from zd_carrier_sfc where sfc_bo='12345'");
      System.out.println(ps1.executeQuery().next());

      PreparedStatement ps2 = conn.prepareStatement(
          "select c.id,i.sfc_bo from zd_carrier c, zd_carrier_sfc i where c.id=i.carrier_bo and i.sfc_bo='12345'");
      System.out.println(ps2.executeQuery().next());

      PreparedStatement ps3 = conn
          .prepareStatement("select id,sfc_bo from view_aaa where sfc_bo='12345'");
      System.out.println(ps3.executeQuery().next());

      conn.rollback();

      PreparedStatement ps4 = conn
          .prepareStatement("select sfc_bo from zd_carrier_sfc where sfc_bo='12345'");
      System.out.println(ps4.executeQuery().next());

      PreparedStatement ps5 = conn.prepareStatement(
          "select c.id,i.sfc_bo from zd_carrier c, zd_carrier_sfc i where c.id=i.carrier_bo and i.sfc_bo='12345'");
      System.out.println(ps5.executeQuery().next());

      PreparedStatement ps6 = conn
          .prepareStatement("select id,sfc_bo from view_aaa where sfc_bo='12345'");
      System.out.println(ps6.executeQuery().next());
    }
  }
}
