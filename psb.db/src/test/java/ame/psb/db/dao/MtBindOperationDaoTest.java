package ame.psb.db.dao;

import ame.psb.db.MtBindOperation;
import ame.psb.db.conf.Hana;
import java.sql.SQLException;
import org.junit.Test;

public class MtBindOperationDaoTest {

  @Test
  public void testInsert() throws SQLException {
    MtBindOperation mb = new MtBindOperation();
    mb.setBomComponentItemBo("ItemBO:1020,6-00000000000H,A");
    mb.setStartOperationBo("OperationBO:1020,WSAW-TPM");
    mb.setEndOperationBo("OperationBO:1020,WTR-TTR");
    MtBindOperationDao dao = new MtBindOperationDao(Hana.createTest());
    dao.insert(mb);
  }
}
