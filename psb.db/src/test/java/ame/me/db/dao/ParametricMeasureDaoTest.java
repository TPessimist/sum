package ame.me.db.dao;

import ame.me.db.ParametricMeasure;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import org.junit.Test;

public class ParametricMeasureDaoTest {

  SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Test
  public void testSelectAll() throws SQLException {
    try (Connection conn = DB.create()) {
      ParametricMeasureDao dao = new ParametricMeasureDao(conn);
      dao.selectAll().forEach(System.out::println);
    }
  }

  @Test
  public void testSelectAllByHandle() throws Exception {
    try (Connection conn = DB.create()) {
      ParametricMeasureDao dao = new ParametricMeasureDao(conn);
      System.out.println(dao.selectByPk("HTTEST").getActual());
    }
  }

  @Test
  public void testInsert() throws Exception {
    try (Connection conn = DB.create()) {
      ParametricMeasure pm = new ParametricMeasure();
      pm.setHandle("HTTEST");
      pm.setMeasureGroup("GROUP");
      pm.setMeasureName("NAME");
      pm.setParametricBo("bo");
      pm.setSequence(213213);
      ParametricMeasureDao Dao = new ParametricMeasureDao(conn);
      Dao.insert(pm);
    }
  }

  @Test
  public void testUpdateByHandle() throws Exception {
    try (Connection conn = DB.create()) {
      ParametricMeasureDao dao = new ParametricMeasureDao(conn);
      ParametricMeasure pm = dao.selectByPk("HTTEST");
      pm.setTestDateTime(date.parse("2012-01-21 09:33:33"));
      dao.update(pm);
    }
  }

  @Test
  public void testDeleteByHandle() throws Exception {
    try (Connection conn = DB.create()) {
      ParametricMeasureDao dao = new ParametricMeasureDao(conn);
      dao.delete("HTTEST");
    }
  }
}
