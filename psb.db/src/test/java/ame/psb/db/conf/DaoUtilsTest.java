package ame.psb.db.conf;

import java.util.TimeZone;
import org.junit.Test;

public class DaoUtilsTest {

  @Test
  public void test() {
    System.out.println(TimeZone.getDefault().getRawOffset() == 8 * 60 * 60 * 1000);
  }
}
