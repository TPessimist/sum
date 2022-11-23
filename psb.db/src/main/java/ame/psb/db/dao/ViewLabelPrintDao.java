package ame.psb.db.dao;

import ame.psb.db.ViewLabelPrint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewLabelPrintDao {


  private static final String SQL_SEL = "SELECT zzykhh,wadat,box_id,good_bad FROM view_label_print ";

  private final Connection conn;

  public ViewLabelPrintDao(Connection conn) {
    this.conn = conn;
  }


  public List<ViewLabelPrint> selectAll() throws SQLException {
    ArrayList<ViewLabelPrint> result = new ArrayList<ViewLabelPrint>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ViewLabelPrint> selectByPK(String zzykhh, String date, String gb)
      throws SQLException {
    ArrayList<ViewLabelPrint> result = new ArrayList<ViewLabelPrint>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE zzykhh=? AND wadat=? AND good_bad=? ")) {
      ps.setString(1, zzykhh);
      ps.setString(2, date);
      ps.setString(3, gb);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewLabelPrint convert(ResultSet rs) throws SQLException {
    ViewLabelPrint data = new ViewLabelPrint();

    int index = 1;
    data.setZzykhh(rs.getString(index++));
    data.setWadat(rs.getString(index++));
    data.setBoxId(rs.getString(index++));
    data.setGoodBad(rs.getString(index++));

    return data;
  }
}
