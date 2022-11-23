package ame.psb.db.dao;

import ame.psb.db.RknumLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RknumLogDao {

  private static final String SQL_INS = "INSERT INTO zr_rknum_log(rknum,zzcnlh,charg,licha,bdmng,hsdat,vfdat,content,value) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_rknum_log SET zzcnlh=?,charg=?,licha=?,bdmng=?,hsdat=?,vfdat=?,content=?,value=? WHERE rknum=?";

  private static final String SQL_SEL = "SELECT rknum,zzcnlh,charg,licha,bdmng,hsdat,vfdat,content,value FROM zr_rknum_log ";

  private final Connection conn;

  public RknumLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RknumLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getRknum());
      ps.setString(2, data.getZzcnlh());
      ps.setString(3, data.getCharg());
      ps.setString(4, data.getLicha());
      ps.setBigDecimal(5, data.getBdmng());
      ps.setString(6, data.getHsdat());
      ps.setString(7, data.getVfdat());
      ps.setString(8, data.getContent());
      ps.setString(9, data.getValue());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RknumLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RknumLog data : dataList) {
        ps.setString(1, data.getRknum());
        ps.setString(2, data.getZzcnlh());
        ps.setString(3, data.getCharg());
        ps.setString(4, data.getLicha());
        ps.setBigDecimal(5, data.getBdmng());
        ps.setString(6, data.getHsdat());
        ps.setString(7, data.getVfdat());
        ps.setString(8, data.getContent());
        ps.setString(9, data.getValue());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RknumLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getZzcnlh());
      ps.setString(2, data.getCharg());
      ps.setString(3, data.getLicha());
      ps.setBigDecimal(4, data.getBdmng());
      ps.setString(5, data.getHsdat());
      ps.setString(6, data.getVfdat());
      ps.setString(7, data.getContent());
      ps.setString(8, data.getValue());
      ps.setString(9, data.getRknum());

      return ps.executeUpdate();
    }
  }

  public int update(List<RknumLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RknumLog data : dataList) {
        ps.setString(1, data.getZzcnlh());
        ps.setString(2, data.getCharg());
        ps.setString(3, data.getLicha());
        ps.setBigDecimal(4, data.getBdmng());
        ps.setString(5, data.getHsdat());
        ps.setString(6, data.getVfdat());
        ps.setString(7, data.getContent());
        ps.setString(8, data.getValue());
        ps.setString(9, data.getRknum());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String rknum) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_rknum_log WHERE rknum=?")) {
      ps.setString(1, rknum);

      return ps.executeUpdate();
    }
  }

  public List<RknumLog> selectAll() throws SQLException {
    ArrayList<RknumLog> result = new ArrayList<RknumLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<RknumLog> selectByrknum(String rknum) throws SQLException {
    ArrayList<RknumLog> result = new ArrayList<RknumLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE rknum=?")) {
      ps.setString(1, rknum);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<RknumLog> selectByrknumContent(String rknum, String content) throws SQLException {
    ArrayList<RknumLog> result = new ArrayList<RknumLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE rknum=? and content =?")) {
      ps.setString(1, rknum);
      ps.setString(2, content);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<RknumLog> selectByTest(String content) throws SQLException {
    ArrayList<RknumLog> result = new ArrayList<RknumLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE content=?")) {
      ps.setString(1, content);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public RknumLog selectByrknumTop(String rknum) throws SQLException {
    RknumLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE rknum=?")) {
      ps.setString(1, rknum);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public RknumLog selectByPK(String rknum, String charg, String licha, String zzcnlh)
      throws SQLException {
    RknumLog result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE rknum=? AND charg=? AND licha=? AND zzcnlh=?")) {
      ps.setString(1, rknum);
      ps.setString(2, charg);
      ps.setString(3, licha);
      ps.setString(4, zzcnlh);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public RknumLog selectByPKFlag(String rknum, String charg, String licha, String zzcnlh,
      String content) throws SQLException {
    RknumLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE rknum=? AND charg=? AND licha=? AND zzcnlh=? AND content =? ")) {
      ps.setString(1, rknum);
      ps.setString(2, charg);
      ps.setString(3, licha);
      ps.setString(4, zzcnlh);
      ps.setString(5, content);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private RknumLog convert(ResultSet rs) throws SQLException {
    RknumLog data = new RknumLog();

    int index = 1;
    data.setRknum(rs.getString(index++));
    data.setZzcnlh(rs.getString(index++));
    data.setCharg(rs.getString(index++));
    data.setLicha(rs.getString(index++));
    data.setBdmng(rs.getBigDecimal(index++));
    data.setHsdat(rs.getString(index++));
    data.setVfdat(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setValue(rs.getString(index++));

    return data;
  }
}
