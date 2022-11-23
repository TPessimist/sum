package ame.me.db.dao;

import ame.me.db.OperationNcCode;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

public class OperationNcCodeDaoTest {

  @Test
  public void testByResourceBo() throws SQLException {
    try (Connection conn = DB.create()) {
      OperationNcCodeDao dao = new OperationNcCodeDao(conn);
      List<OperationNcCode> ncs = dao.select("OperationBO:9998,IQC-OVN,#");
      ncs.forEach(System.out::println);
    }
  }

}
