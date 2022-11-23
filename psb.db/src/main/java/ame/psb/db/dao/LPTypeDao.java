package ame.psb.db.dao;

import ame.psb.db.LPType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LPTypeDao {

  private static final String SQL_INS = "INSERT INTO erpdata..tblME_PrintInfo(PrinterNameID,BartenderName,Content,Content2,Content3,Flag,EVENT_SOURCE,EVENT_ID,LABEL_ID,PRINT_QTY) VALUES (?,?,?,?,?,?,?,?,?,?)";
  private final Connection conn;

  public LPTypeDao(Connection conn) {
    this.conn = conn;
  }

  /*
   * <CONTAINER_ID> <CONTAINER_NAME> <PRINT_TIME> <PRINT_QTY> <LABEL_ID>
   */
  public int insert(LPType data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getPrinterNameID());
      ps.setString(2, data.getBartenderName());
      ps.setString(3, data.getContent());
      ps.setString(4, data.getContent2());
      ps.setString(5, data.getContent3());
      ps.setString(6, data.getFlag());
      ps.setString(7, data.getEVENTSOURCE());
      ps.setString(8, data.getEVENTID());
      ps.setString(9, data.getLABELID());
      ps.setString(10, data.getPRINTQTY());
      return ps.executeUpdate();
    }
  }
}
