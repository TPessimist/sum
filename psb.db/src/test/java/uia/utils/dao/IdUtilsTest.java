package uia.utils.dao;

import org.junit.Test;

public class IdUtilsTest {

  @Test
  public void testId() throws Exception {
    new Thread(() -> {
      for (int i = 0; i < 1004; i++) {
        System.out.println(IdUtils.id("BO1:", null));
      }
    }).start();
    new Thread(() -> {
      for (int i = 0; i < 1004; i++) {
        System.out.println(IdUtils.id("BO2:", ":ABC"));
      }
    }).start();
    new Thread(() -> {
      for (int i = 0; i < 1004; i++) {
        System.out.println(IdUtils.id(null, "DEF"));
      }
    }).start();

    Thread.sleep(4000);
  }
}
