package ame.psb.db.conf;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @program: IDEA
 * @description: redis
 * @author: qingchun
 * @create: 2020-05-28 20:45
 */
public class RedisPool {

  private static final String HOST = "10.160.2.26";
  private static final int PORT = 6379;

  private static JedisPool jedisPool;

  static {
    JedisPoolConfig poolConfig = new JedisPoolConfig();
    poolConfig.setMaxTotal(10);           // 最大连接数
    poolConfig.setMaxIdle(4);              // 最大空闲连接数
    poolConfig.setMaxWaitMillis(10 * 1000);  // 最大等待时间
    poolConfig.setTestOnBorrow(true);       // 检查连接可用性, 确保获取的redis实例可用

    jedisPool = new JedisPool(poolConfig, HOST, PORT);
  }

  public static Jedis getResource() {
    Jedis jedis = jedisPool.getResource();
    String env = System.getProperties().get("psb.env") + "";
    if ("prod".equalsIgnoreCase(env)) {
      jedis.select(0);
    } else if ("test".equalsIgnoreCase(env)) {
      jedis.select(1);
    } else {
      jedis.select(2);
    }
    return jedis;
  }

}
