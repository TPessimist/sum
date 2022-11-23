package ame.psb.db.dao;

import ame.psb.db.ViewPadListDownloadResult;
import ame.psb.db.conf.DB;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class PadTaskListDownloadTest {


  @Test
  public void test() throws SQLException {
    try (Connection conn = DB.create()) {
      List<ViewPadListDownloadResult> result = new ArrayList<ViewPadListDownloadResult>();
      PadListDownloadDao dao = new PadListDownloadDao(conn);
      result = dao.selectByPK("B", "");
      System.out.println(result.size());
      System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(result));
    }
  }
}
