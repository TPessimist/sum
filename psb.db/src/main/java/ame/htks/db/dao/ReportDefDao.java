package ame.htks.db.dao;

import ame.htks.db.ReportDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportDefDao {

  private static final String SQL_INS = "INSERT INTO zh_report_def(name,desc,comment,sql_string,para,col,seq) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_report_def SET desc=?,comment=?,sql_string=?,para=?,col=?,seq=? WHERE name=?";

  private static final String SQL_SEL = "SELECT name,desc,comment,sql_string,para,col,seq FROM zh_report_def ";

  private final Connection conn;

  public ReportDefDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ReportDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getName());
      ps.setString(2, data.getDesc());
      ps.setString(3, data.getComment());
      ps.setString(4, data.getSqlString());
      ps.setString(5, data.getPara());
      ps.setString(6, data.getCol());
      ps.setInt(7, data.getSeq());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ReportDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ReportDef data : dataList) {
        ps.setString(1, data.getName());
        ps.setString(2, data.getDesc());
        ps.setString(3, data.getComment());
        ps.setString(4, data.getSqlString());
        ps.setString(5, data.getPara());
        ps.setString(6, data.getCol());
        ps.setInt(7, data.getSeq());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ReportDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDesc());
      ps.setString(2, data.getComment());
      ps.setString(3, data.getSqlString());
      ps.setString(4, data.getPara());
      ps.setString(5, data.getCol());
      ps.setInt(6, data.getSeq());
      ps.setString(7, data.getName());

      return ps.executeUpdate();
    }
  }

  public int update(List<ReportDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ReportDef data : dataList) {
        ps.setString(1, data.getDesc());
        ps.setString(2, data.getComment());
        ps.setString(3, data.getSqlString());
        ps.setString(4, data.getPara());
        ps.setString(5, data.getCol());
        ps.setInt(6, data.getSeq());
        ps.setString(7, data.getName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String name) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zh_report_def WHERE name=?")) {
      ps.setString(1, name);

      return ps.executeUpdate();
    }
  }

  public List<ReportDef> selectAll() throws SQLException {
    ArrayList<ReportDef> result = new ArrayList<ReportDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "order by seq")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ReportDef selectByPK(String name) throws SQLException {
    ReportDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE name=?")) {
      ps.setString(1, name);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ReportDef convert(ResultSet rs) throws SQLException {
    ReportDef data = new ReportDef();

    int index = 1;
    data.setName(rs.getString(index++));
    data.setDesc(rs.getString(index++));
    data.setComment(rs.getString(index++));
    data.setSqlString(rs.getString(index++));
    data.setPara(rs.getString(index++));
    data.setCol(rs.getString(index++));
    data.setSeq(rs.getInt(index++));

    return data;
  }
}

