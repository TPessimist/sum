package uia.utils.dao;

import ame.psb.db.conf.DB;
import ame.psb.db.conf.Hana;
import ame.psb.db.conf.Oracle;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class DatabaseTest {

  @Test
  public void testSelectTableNames() throws SQLException {
    try (Connection conn = Hana.create()) {
      Database db = new Database(conn);
      db.selectTableNames("Z_").forEach(t -> System.out.println(t));
    }
  }

  @Test
  public void testSelectViewNames() throws SQLException {
    try (Connection conn = DB.create()) {
      Database db = new Database(conn);
      db.selectViewNames("VIEW_").forEach(t -> System.out.println(t));
    }
  }

  @Test
  public void testSelectView() throws SQLException {
    try (Connection conn = Oracle.create()) {
      Database db = new Database(conn);
      TableType table = db.selectTable("VIEW_SFC");
      System.out.println(table.getTableName());
      table.getColumns().forEach(System.out::println);
      System.out.println(table.generateInsertSQL());
      System.out.println(table.generateUpdateSQL());
      System.out.println(table.generateSelectSQL());
    }
  }

  @Test
  public void testSelectTable() throws SQLException {
    try (Connection conn = Hana.createDev()) {
      Database db = new Database(conn);
      TableType table = db.selectTable("Z_PMS_JOB");
      System.out.println(table.getTableName());
      table.getColumns().forEach(System.out::println);
      System.out.println(table.generateInsertSQL());
      System.out.println(table.generateUpdateSQL());
      System.out.println(table.generateSelectSQL());
    }
    /**
     System.out.println("---------------------------");
     try (Connection conn = Oracle.create()) {
     Database db = new Database(conn);
     TableType table = db.selectTable("ZD_SFC");
     System.out.println(table.getTableName());
     table.getColumns().forEach(System.out::println);
     System.out.println(table.generateInsertSQL());
     System.out.println(table.generateUpdateSQL());
     System.out.println(table.generateSelectSQL());
     }
     */
  }
}
