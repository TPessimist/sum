package ame.psb.db.dao;

import ame.psb.db.ViewPkgLabelTag;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PkgLabelTagDao {

  private static final String SQL_INS = "INSERT INTO zd_pkg_label_tag(label_bo,tag_bo) VALUES (?,?)";

  private static final String SQL_SEL = "SELECT label_bo,tag_bo,value_pattern,value_script,description,value_type,tag_type FROM view_pkg_label_tag ";

  private final Connection conn;

  public PkgLabelTagDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(String labelBo, String tagBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, labelBo);
      ps.setString(2, tagBo);

      return ps.executeUpdate();
    }
  }

  public int delete(String labelBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_pkg_label_tag WHERE label_bo=?")) {
      ps.setString(1, labelBo);

      return ps.executeUpdate();
    }
  }

  public int delete(String labelBo, String tagBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_pkg_label_tag WHERE label_bo=? AND tag_bo=?")) {
      ps.setString(1, labelBo);
      ps.setString(2, tagBo);

      return ps.executeUpdate();
    }
  }

  public List<ViewPkgLabelTag> selectByLabel(String labelBo) throws SQLException {
    ArrayList<ViewPkgLabelTag> result = new ArrayList<ViewPkgLabelTag>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE label_bo=? ORDER BY tag_bo")) {
      ps.setString(1, labelBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ViewPkgLabelTag> selectByTag(String tagBo) throws SQLException {
    ArrayList<ViewPkgLabelTag> result = new ArrayList<ViewPkgLabelTag>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE tag_bo=? ORDER BY label_bo")) {
      ps.setString(1, tagBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public ViewPkgLabelTag selectByPK(String labelBo, String tagBo) throws SQLException {
    ViewPkgLabelTag result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE label_bo=? AND tag_bo=?")) {
      ps.setString(1, labelBo);
      ps.setString(2, tagBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private ViewPkgLabelTag convert(ResultSet rs) throws SQLException {
    ViewPkgLabelTag data = new ViewPkgLabelTag();

    int index = 1;
    data.setLabelBo(rs.getString(index++));
    data.setTagBo(rs.getString(index++));
    data.setValuePattern(rs.getString(index++));
    data.setValueScript(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setValueType(rs.getString(index++));
    data.setTagType(rs.getString(index++));

    return data;
  }
}
