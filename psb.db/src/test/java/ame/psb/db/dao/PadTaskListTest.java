package ame.psb.db.dao;

import ame.psb.db.ViewPadTaskList;
import ame.psb.db.conf.DB;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class PadTaskListTest {


  @Test
  public void test() throws SQLException {
    try (Connection conn = DB.create()) {
      List<ViewPadTaskList> result = new ArrayList<ViewPadTaskList>();
      PadTaskListDao dao = new PadTaskListDao(conn);
      result = dao.selectByPK("B");
      System.out.println(
          new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-mm-dd hh:mm:ss").create()
              .toJson(result));
    }
  }
}
