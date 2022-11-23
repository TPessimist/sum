package ame.psb.db.dao;

import ame.psb.db.ResourcePromptFields;
import ame.psb.db.conf.Hana;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;

public class ResourcePromptFieldsDaoTest {


  @Test
  public void testInsert() {

    try {
      Connection conn = Hana.createTest();

      ResourcePromptFields data = new ResourcePromptFields();

      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS");//设置日期格式
      Date currentDate = new Date();
      String currentTime = df.format(new Date());// new Date()为获取当前系统时间

      System.out.println(currentDate);

      data.setId("BMIC01|" + currentTime);
      data.setSubid("DEVICE");
      data.setValue("X68005B");
      data.setGroupId("1");
      data.setGroupName("ResourceBO:1020,BMIC01");
      data.setPromptUser("LiHao");
      data.setPromptTime(currentDate);

      ResourcePromptFieldsDao dao = new ResourcePromptFieldsDao(conn);
      dao.insert(data);


    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Test
  public void TestSelectPreDevice() {
    Connection conn;
    try {
      conn = Hana.createTest();
      ResourcePromptFieldsDao dao = new ResourcePromptFieldsDao(conn);

      ResourcePromptFields r = dao.selectPreDevice("BMIC01");
      System.out.println(r.getValue());

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }


}
