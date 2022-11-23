package ame.psb.db.dao;

import ame.psb.db.conf.Hana;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class ResourceOperationPercentDaoTest {

  @Test
  public void selectByResource() {
    try (Connection conn = Hana.createProd()) {
      new ResourceOperationPercentDao(conn).selectByResource("BAOM03").forEach(System.out::println);

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}