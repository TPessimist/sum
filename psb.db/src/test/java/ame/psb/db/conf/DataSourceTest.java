package ame.psb.db.conf;

import ame.psb.commons.Env;
import java.sql.Connection;
import org.junit.Test;

public class DataSourceTest {

  @Test
  public void getConnection() throws Exception {
    Env.initial("app.properties");
    DataSource.initial("log4j2");
    Connection conn = DataSource.getConnection();
    conn.setAutoCommit(false);
    System.out.println(conn + " " + conn.getAutoCommit());
    conn.close();
    Connection conn1 = DataSource.getConnection();

    System.out.println(conn1 + " " + conn1.getAutoCommit());
    conn1.close();
  }
}