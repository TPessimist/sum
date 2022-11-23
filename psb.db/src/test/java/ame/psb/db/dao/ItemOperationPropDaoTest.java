package ame.psb.db.dao;

import ame.psb.db.ItemOperationProp;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class ItemOperationPropDaoTest {

  @Test
  public void testInsertAndUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      ItemOperationPropDao dao = new ItemOperationPropDao(conn);
      ItemOperationProp data = dao
          .selectByPK("ItemBO:1020,18XSH5000B0BL,A", "OperationBO:1020,BFB-DEV,#",
              "COATER_CHEMICAL");
      data.setItemBo("0000000000000000");
      data.setOperationBo("0000000000000000");
      data.setPropName("0000000000000000");
      dao.insert(data);
      data.setPropValue("123434");
      dao.update(data);
      System.out
          .println(dao.selectByPK("0000000000000000", "0000000000000000", "0000000000000000"));
    }
  }

  @Test
  public void testDelete() throws SQLException {
    try (Connection conn = DB.create()) {
      ItemOperationPropDao dao = new ItemOperationPropDao(conn);
      dao.delete("0000000000000000", "0000000000000000", "0000000000000000");
      System.out
          .println(dao.selectByPK("0000000000000000", "0000000000000000", "0000000000000000"));
    }
  }
}