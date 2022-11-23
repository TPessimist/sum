package ame.psb.db.dao;

import ame.psb.db.PkgContainerSfc;
import ame.psb.db.conf.Hana;
import java.sql.Connection;
import org.junit.Test;

public class PkgContainerSfcDaoTest {


  @Test
  public void testinsert() {
    try (Connection conn = Hana.createTest()) {
      PkgContainerSfcDao dao = new PkgContainerSfcDao(conn);
      PkgContainerSfc data = new PkgContainerSfc();
      data.setContainerBo("TCONTAINERBO1");
      data.setSfcBo("TSFC");
      data.setGoodBad("G");
      data.setGrades("A");
      data.setDieQty(0);
      data.setCustomerItemName("TWAFERID");
      data.setGoodDie(0);
      data.setBadDie1(0);
      data.setBadDie2(0);
      dao.insert(data);
    } catch (Exception e) {

    }
  }


}
