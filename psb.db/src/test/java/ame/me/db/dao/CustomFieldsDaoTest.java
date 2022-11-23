package ame.me.db.dao;

import ame.psb.db.conf.DB;
import ame.psb.db.conf.Hana;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class CustomFieldsDaoTest {

  @Test
  public void testSelect() throws SQLException {
    try (Connection conn = DB.create()) {
      CustomFieldsDao dao = new CustomFieldsDao(conn);
      System.out.println(dao.select("DcGroupBO:TEST,TETC1-NCG1,A").get("DC_TYPE"));
    }
  }


  @Test
  public void testSelectPrompt() throws SQLException {
    try (Connection conn = Hana.createTest()) {
      CustomFieldsDao dao = new CustomFieldsDao(conn);
      System.out.println(dao.selectPrompt("ResourceBO:1020,BMIC01", "PROMPT"));
    }
  }
}
