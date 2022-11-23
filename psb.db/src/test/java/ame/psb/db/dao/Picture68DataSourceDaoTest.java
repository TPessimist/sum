package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.Picture68DataSource;
import ame.psb.db.ViewCustomerItemSfcItem;
import ame.psb.db.conf.DB;
import ame.psb.db.conf.Hana;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

public class Picture68DataSourceDaoTest extends TestCase {


  @Test
  public void test1() {
    try {
      Env.initialProd();
      Picture68DataSourceDao dataSourceDao = new Picture68DataSourceDao(Hana.createTest());
      SfcItemDao sfcItemDao = new SfcItemDao(DB.create());

      List<ViewCustomerItemSfcItem> sfcItemList = sfcItemDao.selectBySfc("SFCBO:1020,BB5MM003.1");
      for (int i = 0; i < sfcItemList.size(); i++) {
        ViewCustomerItemSfcItem viewCustomerItemSfcItem = sfcItemList.get(i);
        Picture68DataSource picture68DataSource = new Picture68DataSource();
        picture68DataSource.setCustomerItemBo(viewCustomerItemSfcItem.getId());
        picture68DataSource.setCustomerItemsetBo(viewCustomerItemSfcItem.getCustomerItemLotBo());
        picture68DataSource.setFrequency(BigDecimal.ZERO);
        picture68DataSource.setDeviceName(viewCustomerItemSfcItem.getDeviceName());
        picture68DataSource.setFilePath(
            "\\\\10.160.1.11\\FileServer\\BumpAOI\\BAOI10\\8-X68E41B-SHD03\\Setup1\\N368753.8SC\\"
                + String.format("%02d", viewCustomerItemSfcItem.getSlotNo()) + "\\");
        picture68DataSource.setReversedField1("");
        picture68DataSource.setReversedField2("");
        picture68DataSource.setUpdatedUser("");
        picture68DataSource.setUpdatedTime(new Date());
        dataSourceDao.insert(picture68DataSource);
      }


    } catch (Exception e) {
      e.printStackTrace();
    } finally {
    }
  }

}