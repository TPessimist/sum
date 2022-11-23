package ame.psb.db.dao;

import ame.psb.db.ViewBom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewBomDao {

  private static final String SQL_SEL = "SELECT bom_bo,component_gbo,sequence,qty,operation_bo,description FROM view_bom ";

  private final Connection conn;

  public ViewBomDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewBom> selectAll() throws SQLException {
    ArrayList<ViewBom> result = new ArrayList<ViewBom>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ViewBom> selectByItem(String item) throws SQLException {
    ArrayList<ViewBom> result = new ArrayList<ViewBom>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where bom_bo = ? order by sequence")) {
      ps.setString(1, item);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewBom> selectByOperation(String operation) throws SQLException {
    ArrayList<ViewBom> result = new ArrayList<ViewBom>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where operation_bo = ? order by sequence")) {
      ps.setString(1, operation);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewBom convert(ResultSet rs) throws SQLException {
    ViewBom data = new ViewBom();

    int index = 1;
    data.setBomBo(rs.getString(index++));
    data.setComponentGbo(rs.getString(index++));
    data.setSequence(rs.getBigDecimal(index++));
    data.setQty(rs.getBigDecimal(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDescription(rs.getString(index++));

    return data;
  }
}
