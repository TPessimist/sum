package ame.psb.db.dao;

import ame.psb.db.ViewPkgLabelMultiDependTag;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewPkgLabelMultiDependTagDao {

  private static final String SQL_SEL = "SELECT label_bo,tag_bo,value_pattern,value_script,description,value_type,tag_type FROM view_pkg_label_multi_depend_tag ";

  private final Connection conn;

  public ViewPkgLabelMultiDependTagDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewPkgLabelMultiDependTag> selectAll() throws SQLException {
    ArrayList<ViewPkgLabelMultiDependTag> result = new ArrayList<ViewPkgLabelMultiDependTag>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewPkgLabelMultiDependTag> selectByLabelBo(String labelBo) throws SQLException {
    ArrayList<ViewPkgLabelMultiDependTag> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where LABEL_BO = ? ")) {
      ps.setString(1, labelBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewPkgLabelMultiDependTag convert(ResultSet rs) throws SQLException {
    ViewPkgLabelMultiDependTag data = new ViewPkgLabelMultiDependTag();

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
