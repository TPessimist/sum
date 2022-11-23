package ame.psb.db.conf;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DataSource {

  public static DruidDataSource ds;

  public static void initial(String logType) throws Exception {
    if (ds == null) {
      synchronized (DataSource.class) {
        if (ds == null) {
          System.setProperty("druid.logType", logType);
          Map<String, String> druidMap = new HashMap<String, String>();
          druidMap.put(DruidDataSourceFactory.PROP_URL, Hana.CONN);
          druidMap.put(DruidDataSourceFactory.PROP_DRIVERCLASSNAME, "com.sap.db.jdbc.Driver");
          druidMap.put(DruidDataSourceFactory.PROP_USERNAME, Hana.USER);
          druidMap.put(DruidDataSourceFactory.PROP_PASSWORD, Hana.PWD);
          druidMap.put(DruidDataSourceFactory.PROP_INITIALSIZE, "10");
          druidMap.put(DruidDataSourceFactory.PROP_MAXACTIVE, "100");
          druidMap.put(DruidDataSourceFactory.PROP_MAXWAIT, "5000");
          druidMap.put(DruidDataSourceFactory.PROP_LOGABANDONED, "true");
          druidMap.put(DruidDataSourceFactory.PROP_REMOVEABANDONED, "true");
          druidMap.put(DruidDataSourceFactory.PROP_REMOVEABANDONEDTIMEOUT, "3600");
          druidMap.put(DruidDataSourceFactory.PROP_TIMEBETWEENEVICTIONRUNSMILLIS, "60000");
          druidMap.put(DruidDataSourceFactory.PROP_MINEVICTABLEIDLETIMEMILLIS, "300000");
          druidMap.put(DruidDataSourceFactory.PROP_VALIDATIONQUERY, "select 1 from dummy");
          druidMap.put(DruidDataSourceFactory.PROP_TESTWHILEIDLE, "true");
          druidMap.put(DruidDataSourceFactory.PROP_TESTONBORROW, "false");
          druidMap.put(DruidDataSourceFactory.PROP_TESTONRETURN, "false");
          druidMap.put(DruidDataSourceFactory.PROP_FILTERS, "stat,slf4j");
          druidMap.put(DruidDataSourceFactory.PROP_POOLPREPAREDSTATEMENTS, "true");
          druidMap.put(DruidDataSourceFactory.PROP_MAXOPENPREPAREDSTATEMENTS, "50");
          ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(druidMap);
        }
      }
    }
  }

  public static Connection getConnection() throws SQLException {
    return new DB.ConnectionProxy(ds.getConnection());
  }

  public static void close() {
    if (ds == null) {
      return;
    }
    ds.close();
  }
}
