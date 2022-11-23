package ame.psb.db.dao;

import ame.psb.db.SfcMemo;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import org.junit.Test;

public class SfcMemoDaoTest {

  @Test
  public void testInsert() throws Exception {
    SfcMemo memo = new SfcMemo();
    memo.setSfcBo("SFCBO:1020,123.2");
    memo.setSfc("123.4");
    memo.setOwner("TEST");
    memo.setMemo("TEST INFO");

    try (Connection conn = DB.create()) {
      SfcMemoDao dao = new SfcMemoDao(conn);
      dao.insert(memo);
    }
  }

  @Test
  public void testQuery() throws Exception {
    try (Connection conn = DB.create()) {
      SfcMemoDao dao = new SfcMemoDao(conn);
      System.out.println(dao.selectBySfcName("123.2").size());
      System.out.println(dao.selectBySfcParent("123").size());
    }
  }

}
