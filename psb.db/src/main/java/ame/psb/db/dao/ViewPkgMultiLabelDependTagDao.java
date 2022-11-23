package ame.psb.db.dao;

import ame.psb.db.ViewPkgMultiLabelDependTag;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ViewPkgMultiLabelDependTagDao {

  private static final String SQL_SEL = "SELECT label_bo,tag_bo,reserve_field1,reserve_field2,updated_user,updated_time,value_pattern,value_script,description,value_type,tag_type FROM view_pkg_multilabel_depend_tag ";

  private final Connection conn;

  public ViewPkgMultiLabelDependTagDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewPkgMultiLabelDependTag> selectAll() throws SQLException {
    ArrayList<ViewPkgMultiLabelDependTag> result = new ArrayList<ViewPkgMultiLabelDependTag>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewPkgMultiLabelDependTag> selectByLabelBo(String labelBo) throws SQLException {
    ArrayList<ViewPkgMultiLabelDependTag> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where LABEL_BO = ? ")) {
      ps.setString(1, labelBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewPkgMultiLabelDependTag convert(ResultSet rs) throws SQLException {
    ViewPkgMultiLabelDependTag data = new ViewPkgMultiLabelDependTag();

    int index = 1;
    data.setLabelBo(rs.getString(index++));
    data.setTagBo(rs.getString(index++));
    data.setReserveField1(rs.getString(index++));
    data.setReserveField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setValuePattern(rs.getString(index++));
    data.setValueScript(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setValueType(rs.getString(index++));
    data.setTagType(rs.getString(index++));

    return data;
  }
}
