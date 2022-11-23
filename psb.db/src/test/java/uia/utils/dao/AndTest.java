package uia.utils.dao;

import ame.psb.commons.Env;
import ame.psb.db.TestXufeng;
import ame.psb.db.Ts81MarkingCodeRecord;
import ame.psb.db.conf.DB;
import ame.psb.db.dao.TestXufengDao;
import ame.psb.db.dao.Ts81MarkingCodeRecordDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.Test;

public class AndTest implements And.RuleType {

  @Test
  public void test1() {
    And and = new And()
        .eq("c1", "abc")
        .eq("c2", null)
        .between("c3", "123", "456")
        .likeBegin("c4", "abc")
        .likeBegin("c5", null)
        .and(this);
    System.out.println(and.generate());
  }

  @Test
  public void test2() {
    And and = new And()
        .eq("c1", "abc")
        .eqOrNull("c2", null)
        .between("c3", "123", "456")
        .likeBegin("c4", "abc")
        .likeBeginOrNull("c5", null)
        .and(this);
    System.out.println(and.generate());
  }


  @Test
  public void test3() {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");//设置日期格式
    System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
  }

  @Test
  public void test4() {
    System.out.println("=>" + new A().x + "c");
    System.out.println(new A().x == "");
    System.out.println("=>" + new A().y);
    System.out.println("=>" + new A().z);
    System.out.println("".equals(new A().x));
    System.out.println(new A().x.equals(""));
  }

  @Override
  public String getStatement() {
    return "(c6='A')";
  }

  @Override
  public int accpet(PreparedStatement ps, int index) throws SQLException {
    return index;
  }

  @Test
  public void test5() throws Exception {
    Env.initialTest();
    try (Connection conn = DB.create()) {
      Ts81MarkingCodeRecordDao recordDao = new Ts81MarkingCodeRecordDao(conn);
      TestXufengDao testXufengDao = new TestXufengDao(conn);
      List<TestXufeng> testXufengs = testXufengDao.selectAll();
      for (TestXufeng testXufeng : testXufengs) {
        Ts81MarkingCodeRecord record = new Ts81MarkingCodeRecord();
        record.setUuid(UUID.randomUUID().toString());
        record.setShopOrder(testXufeng.getId());
        record.setMarkingCode(testXufeng.getName());
        record.setUpdatedTime(new Date());
        record.setUpdatedUser("SYS");
        recordDao.insert(record);
      }

    }


  }

  static class A {

    public String x;
    public int y;
    public char z;
  }

}
