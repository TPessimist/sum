package ame.psb.db.dao;

import ame.psb.db.QueueTime;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import org.junit.Test;

public class QueueTimeDaoTest {

  @Test
  public void testInsert() throws SQLException {
    try (Connection conn = DB.create()) {
      QueueTime queueTime = new QueueTime();
      queueTime.setId("DEVICE001:IQC-SCR-00001");
      queueTime.setItemGroupBo("ItemGroupBO:TEST,DEVICE001");
      queueTime.setItemBo("ItemBO:TEST,DIE-01");
      queueTime.setBeginOperationBo("OperationBO:TEST,IQC-SCR,#");
      queueTime.setBeginType("MI");
      queueTime.setMinTime(1);
      queueTime.setMaxTime(99);
      QueueTimeDao qtDao = new QueueTimeDao(conn);
      qtDao.isnert(queueTime);
    }
  }

  @Test
  public void testUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      QueueTimeDao qtDao = new QueueTimeDao(conn);
      qtDao.update("DEVICE001:IQC-SCR-00001", 0, 19822, "N", "SYS", new Date());
    }
  }

  @Test
  public void testDelete() throws SQLException {
    try (Connection conn = DB.create()) {
      QueueTimeDao qtDao = new QueueTimeDao(conn);
      qtDao.delete("2");
    }
  }

  @Test
  public void testSelectByPackage() throws SQLException {
    try (Connection conn = DB.create()) {
      QueueTimeDao qtDao = new QueueTimeDao(conn);
      qtDao.selectByPackage("ItemGroupBO:TEST,PACKAGE001").forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByItemGroup() throws SQLException {
    try (Connection conn = DB.create()) {
      QueueTimeDao qtDao = new QueueTimeDao(conn);
      qtDao.selectByItemGroup("ItemGroupBO:TEST,DEVICE001").forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByItem() throws SQLException {
    try (Connection conn = DB.create()) {
      QueueTimeDao qtDao = new QueueTimeDao(conn);
      qtDao.selectByItem("ItemBO:TEST,DIE-01,1.0").forEach(System.out::println);
    }
  }

  @Test
  public void testSelectByOperation() throws SQLException {
    try (Connection conn = DB.create()) {
      QueueTimeDao qtDao = new QueueTimeDao(conn);
      qtDao.selectByOperation("OperationBO:TEST,IQC-SCR,#").forEach(System.out::println);
    }
  }

  @Test
  public void testSelectBeginByItem() throws SQLException {
    try (Connection conn = DB.create()) {
      QueueTimeDao qtDao = new QueueTimeDao(conn);
      qtDao.selectBeginByItem("ItemBO:TEST,DIE-01,1.0", "OperationBO:TEST,IQC-SCR,#", "MI")
          .forEach(System.out::println);
      System.out.println("---------");
      qtDao.selectBeginByItem("ItemBO:TEST,DIE-01,1.0", "OperationBO:TEST,IQC-SCR,#", "MO")
          .forEach(System.out::println);
    }
  }
}
