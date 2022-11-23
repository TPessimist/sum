package uia.utils.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.Test;

public class WhereTest implements Where.RuleType {

  @Test
  public void test1() {
    Where where = new Where()
        .eq("c1", "abc")
        .eq("c2", null)
        .between("c3", "123", "456")
        .likeBegin("c4", "abc")
        .likeBegin("c5", null)
        .where(this);
    System.out.println(where.generate());
  }

  @Test
  public void test2() {
    Where where = new Where()
        .eq("c1", "abc")
        .eqOrNull("c2", null)
        .between("c3", "123", "456")
        .likeBegin("c4", "abc")
        .likeBeginOrNull("c5", null)
        .where(this);
    System.out.println(where.generate());
  }

  @Override
  public String getStatement() {
    return "(c6='A')";
  }


  @Test
  public void W() {

    try {
      ex2();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @Test
  public void ex2() throws Exception {
    int x = 12 / 0;

    System.out.println("00");

  }

  @Override
  public int accpet(PreparedStatement ps, int index) throws SQLException {
    return index;
  }

}
