package ame.psb.db.conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 資料庫。
 *
 * @author qc
 */
public class SqlServer {

  static {
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static Connection create() throws SQLException {
    return DriverManager
        .getConnection("jdbc:sqlserver://10.160.1.151:1433;databaseName=erpbase", "sa", "ksxtDB");
  }

}
