package ame.psb.db.conf;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class HanaTest {

  @Test
  public void testEnv() throws Exception {
    Connection conn1 = DB.create();
    System.out.println(conn1);
    conn1.close();
    Connection conn2 = DB.create();
    System.out.println(conn2);
    conn2.close();
  }

  @Test
  public void testConnection() throws SQLException {
    Connection conn1 = Hana.createDev();
    conn1.close();
    Connection conn2 = Hana.createTest();
    conn2.close();
    Connection conn3 = Hana.createProd();
    conn3.close();
  }
}
