package ame.psb.db.dao;

import ame.psb.db.RunFile;
import ame.psb.db.conf.Hana;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;
import org.junit.Test;

public class RunFileTest {

  @Test
  public void testInsert() throws IOException, SQLException {
    File file = new File("/Users/jiqingchun/Downloads/TSK_COMPATE_MODEL.xlsx");

    InputStream input = new FileInputStream(file);

    byte[] bytes = new byte[input.available()];

    input.read(bytes);
    input.close();
    RunFile rf = new RunFile();
    rf.setBinary(bytes);
    rf.setComments("");
    rf.setFileName(file.getName());
    rf.setId(UUID.randomUUID().toString());
    rf.setUpdatedTime(new Date());
    rf.setUpdatedUser("administrator");
    RunFileDao d = new RunFileDao(Hana.createProd());
    d.insert(rf);
  }

  @Test
  public void testSelect() throws Exception {
    try {
      RunFileDao d = new RunFileDao(Hana.createTest());
      RunFile rf = d.selectByPK("94d70533-b6ab-4273-b897-a388cf577f81");
      rf.setUpdatedTime(new Date());
      d.update(rf);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
