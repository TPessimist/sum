package uia.utils.dao;

public class IdUtils {

  private static int seq;

  public static String id() {
    return String.format("%s:%04d",
        System.currentTimeMillis(),
        no());
  }

  public static String id(String prefix, String postfix) {
    if (prefix == null) {
      prefix = "";
    }
    if (postfix == null) {
      postfix = "";
    }
    return String.format("%s%s.%04d%s",
        prefix,
        System.currentTimeMillis(),
        no(),
        postfix);
  }

  private static synchronized int no() {
    int n = ++seq;
    seq = seq % 1000;
    return n;
  }
}
