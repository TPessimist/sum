package ame.me.db.dao;

import ame.me.db.Parametric;
import ame.psb.db.conf.DB;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import org.junit.Test;

public class ParametricDaoTest {

  SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Test
  public void testSelectAll() throws SQLException {
    try (Connection conn = DB.create()) {
      ParametricDao dao = new ParametricDao(conn);
      dao.selectAll().forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByPK() throws Exception {
    try (Connection conn = DB.create()) {
      ParametricDao dao = new ParametricDao(conn);
      System.out.println(dao.selectByPk("PA:1006*,1505958917711000921800143").getTransactionId());
    }
  }

  @Test
  public void testInsert() throws Exception {
    try (Connection conn = DB.create()) {
      Parametric pt = new Parametric();
      pt.setCreatedDateTime(this.date.parse("2017-11-30 18:33:33"));
      pt.setCustomerId("1");
      pt.setDcGroupBo("sdf");
      pt.setDiagnostics("dsf");
      pt.setHandle("HT6");
      pt.setTransactionId(new BigDecimal(12));
      pt.setSite("123");
      pt.setParaContextGbo("HT");
      ParametricDao Dao = new ParametricDao(conn);
      Dao.insert(pt);
    }
  }

  @Test
  public void testUpdateByHandle() throws Exception {
    try (Connection conn = DB.create()) {
      ParametricDao dao = new ParametricDao(conn);
      Parametric item = dao.selectByPk("HT");
      item.setCreatedDateTime(this.date.parse("2013-11-2 09:33:33"));
      dao.update(item);
    }
  }

  @Test
  public void testDeleteByHandle() throws Exception {
    try (Connection conn = DB.create()) {
      ParametricDao dao = new ParametricDao(conn);
      dao.delete("HT2");
    }
  }
}
