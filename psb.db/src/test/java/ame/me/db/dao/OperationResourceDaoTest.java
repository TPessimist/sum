package ame.me.db.dao;

import ame.me.db.OperationResource;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

public class OperationResourceDaoTest {

  @Test
  public void testByResourceBo() throws SQLException {
    try (Connection conn = DB.create()) {
      OperationResourceDao dao = new OperationResourceDao(conn);
      List<OperationResource> ros = dao.selectByResource("ResourceBO:9998,EQ-0001.C1");
      ros.forEach(ro -> System.out.println(ro));
    }
  }

  @Test
  public void testByOperationBo() throws SQLException {
    try (Connection conn = DB.create()) {
      OperationResourceDao dao = new OperationResourceDao(conn);
      List<OperationResource> ros = dao.selectByOperation("OperationBO:1002,OP-001,1.0");
      ros.forEach(ro -> System.out.println(ro));
    }
  }

  @Test
  public void testByOperation() throws SQLException {
    try (Connection conn = DB.create()) {
      OperationResourceDao dao = new OperationResourceDao(conn);
      List<OperationResource> ros = dao.selectByOperationName("OP-001");
      ros.forEach(ro -> System.out.println(ro));
    }
  }
}
