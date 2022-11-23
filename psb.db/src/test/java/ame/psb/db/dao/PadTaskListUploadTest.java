package ame.psb.db.dao;

import ame.psb.db.PmsJob;
import ame.psb.db.PmsJobCheckListParameter;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class PadTaskListUploadTest {


  @Test
  public void testSelectForPad() throws SQLException {
    try (Connection conn = DB.create()) {
      PmsJobCheckListParameter result = new PmsJobCheckListParameter();
      PmsJobCheckListParameterDao dao = new PmsJobCheckListParameterDao(conn);
      result = dao
          .selectForPad("48945BE61AD34B5B8818862705221C86", "672B16017FAF4B4E9217A4D9771FAF0F",
              "10");
      System.out.println(result);
    }
  }

  @Test
  public void testSelectForPadUpdate() throws SQLException {
    try (Connection conn = DB.create()) {
      PmsJob result = new PmsJob();
      PmsJobDao dao = new PmsJobDao(conn);
      result = dao.selectByJobId("201806280013");
        	/*result.setPad_upload_num(1);
        	dao.updateForPad(result);*/
      System.out.println(result.getPad_upload_num());
    }
  }
}
