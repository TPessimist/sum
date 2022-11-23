package ame.psb.db.conf;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class OracleTest {

  @Test
  public void testConnection() throws SQLException {
    Connection conn = Oracle.create();
    System.out.println(conn.isClosed());
    conn.close();
  }

  @Test
  public void testRedis() {
    try (Jedis jedis = RedisPool.getResource()) {
      while (true) {
        for (float i = 0; i <= 99; i += 20) {
          jedis.publish("oht_event", i + "");
          //System.out.println(i);
          Thread.sleep(1000);
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
