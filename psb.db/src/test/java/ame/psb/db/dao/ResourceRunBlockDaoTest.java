package ame.psb.db.dao;

import ame.psb.db.ResourceRunBlock;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import org.junit.Test;

public class ResourceRunBlockDaoTest {

  @Test
  public void testAll() throws SQLException {
    try (Connection conn = DB.create()) {
      ResourceRunBlockDao dao = new ResourceRunBlockDao(conn);
      dao.selectAll().forEach(b -> {
        System.out.println(b);
        b.setBeginTime(new Date(System.currentTimeMillis() + 600000));
        b.setEndTime(new Date(System.currentTimeMillis() + 1600000));
        try {
          dao.update(b);
        } catch (Exception e) {
          // TODO Auto-generated catch block
        }
      });
    }
  }

  @Test
  public void testByPK() throws SQLException {
    try (Connection conn = DB.create()) {
      ResourceRunBlockDao dao = new ResourceRunBlockDao(conn);
      System.out.println(dao.selectByPK("1"));
    }
  }

  @Test
  public void testByResource() throws SQLException {
    try (Connection conn = DB.create()) {
      ResourceRunBlockDao dao = new ResourceRunBlockDao(conn);
      dao.selectByResource("BS").forEach(System.out::println);
    }
  }

  @Test
  public void testOnlineByResource() throws SQLException {
    try (Connection conn = DB.create()) {
      ResourceRunBlockDao dao = new ResourceRunBlockDao(conn);
      dao.selectOnlineByResource("ResourceBO:TEST,BSCR03").forEach(System.out::println);
    }
  }

  @Test
  public void testInsertAndUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      ResourceRunBlockDao dao = new ResourceRunBlockDao(conn);
      ResourceRunBlock data = dao.selectByPK("a20180128a01335");
      data.setId("0000000000000000");
      dao.insert(data);
      data.setPackageBo("123434");
      dao.update(data);
      System.out.println(dao.selectByPK("0000000000000000"));
    }
  }
}
