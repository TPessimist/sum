package ame.psb.db.conf;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;

/**
 * 資料庫。
 *
 * @author Kyle K. Lin
 */
public class Oracle {

  private static OracleConnectionPoolDataSource source;

  static {
    // jdbc:oracle:thin:@//<host>:<port>/<service_name> 
    // jdbc:oracle:thin:@//<host>:<port>:<sid>
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();

      // TODO: 此為簡易設計，需要作調正。
      source = new OracleConnectionPoolDataSource();
      source.setURL("jdbc:oracle:thin:@10.160.1.48:1521:MESDEV");
      source.setDataSourceName("PSBDB Data Source");
      source.setServerName("10.160.1.48");
      source.setPortNumber(1521);
      source.setServiceName("MESDEV");
      source.setUser("WIP");
      source.setPassword("wip");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 取得資料庫連線。
   *
   * @return 結果。
   * @throws SQLException 資料庫發生異常。
   */
  public static Connection create() throws SQLException {
    // return DriverManager.getConnection("jdbc:oracle:thin:@10.160.1.48:1521:MESDEV", "WIP", "wip");
    return source.getConnection();
  }

  public static Connection createRms() throws SQLException {
    return java.sql.DriverManager
        .getConnection("jdbc:oracle:thin:@10.160.1.43:1521:orcl", "RMS", "RMS"); // HANA DEV
  }

}
