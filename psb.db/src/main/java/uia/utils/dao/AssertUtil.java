package uia.utils.dao;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.function.Supplier;
import javax.annotation.Nullable;

/**
 * @author: lihao
 * @DATE: 2020/10/21
 * @description:
 */
public class AssertUtil {


  /**
   * @Param: [object, message]
   * @return: void
   * @To: 为空时报错
   */
  public static void notNull(@Nullable Object object, String message) throws Exception {
    if (object == null) {
      throw new Exception(message);
    }
  }

  public static void notNull(@Nullable Object object, String message,
      Class<? extends Exception> claz) throws Exception {
    if (object == null) {
      Constructor<? extends Exception> declaredConstructor = claz
          .getDeclaredConstructor(String.class);
      throw declaredConstructor.newInstance(message);
    }
  }

  public static void notStrictNull(@Nullable Object object, String message) throws Exception {
    if (object == null) {
      throw new Exception(message);
    }
    if ("".equals(object.toString())) {
      throw new Exception(message);
    }
  }


  /**
   * @Param: [object, message]
   * @return: void
   * @To: 非空时报错
   */
  public static void isNull(@Nullable Object object, String message) throws Exception {
    if (object != null) {
      throw new Exception(message);
    }
  }

  public static void notEmpty(@Nullable Collection<?> collection, Supplier<String> messageSupplier)
      throws Exception {
    if (collection == null || collection.isEmpty()) {
      throw new Exception(messageSupplier.get());
    }
  }

  /**
   * @Param: [object, message]
   * @return: void
   * @To: 为空时报错
   */
  public static void notEmpty(@Nullable Collection<?> collection, String message) throws Exception {
    if (collection == null || collection.isEmpty()) {
      throw new Exception(message);
    }
  }

  /**
   * @Param: [object, message]
   * @return: void
   * @To: 非空时报错
   */
  public static void isEmpty(@Nullable Collection<?> collection, String message) throws Exception {
    if (collection != null && !collection.isEmpty()) {
      throw new Exception(message);
    }
  }

  /*
   * @Description: 传入表达式, 表达式判断返回false则抛出exception
   * @Param: lambda
   * @return:
   * @Author: li hao
   * @Date:
   */
  public static void isError(Supplier<Boolean> predicate, String message)
      throws Exception {
    if (predicate.get()) {
      throw new Exception(message);
    }
  }

  /*
   * @Description: 传入表达式, 表达式判断返回false则抛出exception
   * @Param: lambda
   * @return:
   * @Author: li hao
   * @Date:
   */
  public static void isError(boolean bool, String message)
      throws Exception {
    if (bool) {
      throw new Exception(message);
    }
  }


}
