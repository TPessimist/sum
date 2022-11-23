package ame.psb.db.conf;

import java.sql.Connection;
import java.sql.SQLException;

public class Hana {

  public static String CONN;

  public static String USER;

  public static String PWD;

  public static int MAX_ROW = 0;

  static {
    try {
      Class.forName("com.sap.db.jdbc.Driver");
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (System.getProperties().get("psb.db.connection") == null) {
      Object env = System.getProperties().get("psb.env");
      if (env == null || "dev".equalsIgnoreCase("" + env)) {
        CONN = "jdbc:sap://10.160.1.52:39015";
        USER = "WIP";
        PWD = "Hdb12345";
      } else if ("test".equalsIgnoreCase("" + env)) {
        CONN = "jdbc:sap://10.160.2.23:31041";
        USER = "WIP";
        PWD = "Sap12345";
      } else if ("prod".equalsIgnoreCase("" + env)) {
        CONN = "jdbc:sap://10.160.2.20:30015";
        USER = "WIP";
        PWD = "Sap12345";
      }
    } else {
      CONN = "" + System.getProperties().get("psb.db.connection");
      USER = "" + System.getProperties().get("psb.db.user");
      PWD = "" + System.getProperties().get("psb.db.pwd");
    }
  }

  /**
   * 取得資料庫連線。
   *
   * @return 結果。
   * @throws SQLException 資料庫發生異常。
   */
  public static Connection create() throws SQLException {
    return java.sql.DriverManager.getConnection(CONN, USER, PWD);
  }

  public static Connection createSpc() throws SQLException {
    return java.sql.DriverManager.getConnection(CONN, "SAPJAVA1", PWD); // HANA SPC
  }

  public static Connection createSpcProd() throws SQLException {
    return java.sql.DriverManager
        .getConnection("jdbc:sap://10.160.2.20:30015", "SAPJAVA1", "Sap12345");
  }

  public static Connection createSpcQas() throws SQLException {
    return java.sql.DriverManager
        .getConnection("jdbc:sap://10.160.2.23:31041", "SAPJAVA1", "Sap12345");
  }

  public static Connection createDev() throws SQLException {
    return java.sql.DriverManager
        .getConnection("jdbc:sap://10.160.1.52:39015", "WIP", "Hdb12345"); // HANA DEV
  }

  public static Connection createTest() throws SQLException {
    return java.sql.DriverManager
        .getConnection("jdbc:sap://10.160.2.23:31041", "WIP", "Sap12345"); // HANA TEST
  }

  public static Connection createProd() throws SQLException {
    return java.sql.DriverManager
        .getConnection("jdbc:sap://10.160.2.20:30015", "WIP", "Sap12345"); // HANA PROD
  }

  public static Connection createProd2() throws SQLException {
    return java.sql.DriverManager
        .getConnection("jdbc:sap://10.160.2.21:30015", "WIP", "Sap12345"); // HANA PROD
  }

  public static Connection createDw() throws SQLException {
    if ("test".equalsIgnoreCase("" + System.getProperties().get("psb.env"))) {
      return java.sql.DriverManager
          .getConnection("jdbc:sap://10.160.2.23:31015", "ERP", "Sap12345"); // HANA DEV

    } else {
      return java.sql.DriverManager
          .getConnection("jdbc:sap://10.160.2.38:30015", "ERP_PROD", "Sap12345prod"); // HANA DEV
    }
  }

  public static Connection createDwQas() throws SQLException {
    return java.sql.DriverManager
        .getConnection("jdbc:sap://10.160.2.23:31015", "ERP", "Sap12345"); // HANA DEV
  }
  //Erp数据库连接
  public static Connection createErp() throws SQLException {
    if ("test".equalsIgnoreCase("" + System.getProperties().get("psb.env"))) {
      return java.sql.DriverManager
          .getConnection("jdbc:sap://192.168.98.241:34044", "KSDWETL", "1234@Com"); // HANA DEV

    } else {
      return java.sql.DriverManager
          .getConnection("jdbc:sap://192.168.98.241:34059", "SAPHANADB", "Deloitte1");// HANA DEV
    }
  }

  public static int getMaxRow() {
    if (MAX_ROW == 0) {
      try {
        MAX_ROW = Integer.parseInt(System.getProperties().get("psb.db.maxrow").toString());
      } catch (Exception ex) {
        //ex.printStackTrace();
        MAX_ROW = 10000;
      }
    }
    return MAX_ROW;
  }

}