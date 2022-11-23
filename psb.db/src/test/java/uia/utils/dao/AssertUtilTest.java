package uia.utils.dao;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AssertUtilTest {

  @Test
  public void testNull() {
    try {
      String x = null;
      AssertUtil.notNull(x, "字符串不能为空");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
    }
  }

  @Test
  public void testEmpty() {

    try {
      List<String> x = null;

      AssertUtil.notEmpty(x, () -> "list不能为空");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
    }

  }

  @Test
  public void testIsError() {
    try {

      AssertUtil.isError(()-> {
        int a = 1+1;
        return  a == 3;
      }, "cc");

      AssertUtil.isError(()-> {
        int a = 1+1;
        return  a == 3;
      }, "cc");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public boolean test123() {
    int a = 1+1;
    return  a == 3;
  }

  @Test
  public void testSubList() {
    try {
      List<String> list = new ArrayList<>();
      list.add("1");
      list.add("2");
      list.add("3");
      list.add("4");
      List<String> list1 = list.subList(1, 3);

      list1.forEach(System.out::println);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  @Test
  public void testNotNull() {

    try {
       AssertUtil.notNull(null, "dd", FileNotFoundException.class);
    }catch (Exception er) {
      er.printStackTrace();
    }

  }

}