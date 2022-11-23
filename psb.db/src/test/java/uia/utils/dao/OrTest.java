package uia.utils.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.Test;

public class OrTest implements Or.RuleType {

  @Test
  public void test1() {
    Or or = new Or()
        .eq("c1", "abc")
        .eq("c2", null)
        .between("c3", "123", "456")
        .likeBegin("c4", "abc")
        .likeBegin("c5", null)
        .or(this);
    System.out.println(or.generate());
  }

  @Test
  public void test2() {
    Or or = new Or()
        .eq("c1", "abc")
        .eqOrNull("c2", null)
        .between("c3", "123", "456")
        .likeBegin("c4", "abc")
        .likeBeginOrNull("c5", null)
        .or(this);
    System.out.println(or.generate());
  }

  @Override
  public String getStatement() {
    return "(c6='A')";
  }

  @Override
  public int accpet(PreparedStatement ps, int index) throws SQLException {
    return index;
  }

}
