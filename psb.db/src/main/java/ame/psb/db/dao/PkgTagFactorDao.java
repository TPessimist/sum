package ame.psb.db.dao;

import ame.psb.db.PkgTagFactor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PkgTagFactorDao {

  private static final String SQL_INS = "INSERT INTO zd_pkg_tag_factor(tag_bo,tag_factor_def_bo,driver_args,script) VALUES (?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_pkg_tag_factor SET driver_args=?,script=? WHERE tag_bo=? AND tag_factor_def_bo=?";

  private static final String SQL_SEL = "SELECT tag_bo,tag_factor_def_bo,driver_args,script FROM zd_pkg_tag_factor ";

  private final Connection conn;

  public PkgTagFactorDao(Connection conn) {
    this.conn = conn;
  }

  public List<PkgTagFactor> selectAll() throws SQLException {
    ArrayList<PkgTagFactor> result = new ArrayList<PkgTagFactor>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public int insert(PkgTagFactor data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getTagBo());
      ps.setString(2, data.getTagFactorDefBo());
      ps.setString(3, data.getDriverArgs());
      ps.setString(4, data.getScript());

      return ps.executeUpdate();
    }
  }

  public int update(PkgTagFactor data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDriverArgs());
      ps.setString(2, data.getScript());
      ps.setString(3, data.getTagBo());
      ps.setString(4, data.getTagFactorDefBo());

      return ps.executeUpdate();
    }
  }

  public int delete(String tagBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_pkg_tag_factor WHERE tag_bo=?")) {
      ps.setString(1, tagBo);

      return ps.executeUpdate();
    }
  }

  public List<PkgTagFactor> selectByTag(String tagBo) throws SQLException {
    ArrayList<PkgTagFactor> result = new ArrayList<PkgTagFactor>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE tag_bo=? ")) {
      ps.setString(1, tagBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public PkgTagFactor selectByPK(String tagBo, String tagFactorDefBo) throws SQLException {
    PkgTagFactor result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE tag_bo=? AND tag_factor_def_bo=?")) {
      ps.setString(1, tagBo);
      ps.setString(2, tagFactorDefBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgTagFactor convert(ResultSet rs) throws SQLException {
    PkgTagFactor data = new PkgTagFactor();

    int index = 1;
    data.setTagBo(rs.getString(index++));
    data.setTagFactorDefBo(rs.getString(index++));
    data.setDriverArgs(rs.getString(index++));
    data.setScript(rs.getString(index++));

    return data;
  }
}
