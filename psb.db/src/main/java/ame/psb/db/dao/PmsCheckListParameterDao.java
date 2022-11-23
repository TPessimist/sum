package ame.psb.db.dao;

import ame.psb.db.ViewPmsCheckListParameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PmsCheckListParameterDao {

  private static final String SQL_SEL = "SELECT handle,site,checklist_bo,check_list,revision,enabled,parameter_name,parameter_desc FROM view_pms_checklist_parameter ";

  private final Connection conn;

  public PmsCheckListParameterDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewPmsCheckListParameter> selectAll() throws SQLException {
    ArrayList<ViewPmsCheckListParameter> result = new ArrayList<ViewPmsCheckListParameter>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewPmsCheckListParameter> selectByCheck(String checkList, String revision)
      throws SQLException {
    ArrayList<ViewPmsCheckListParameter> result = new ArrayList<ViewPmsCheckListParameter>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE check_list=? and revision=?")) {
      ps.setString(1, checkList);
      ps.setString(2, revision);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewPmsCheckListParameter convert(ResultSet rs) throws SQLException {
    ViewPmsCheckListParameter data = new ViewPmsCheckListParameter();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setChecklistBo(rs.getString(index++));
    data.setCheckList(rs.getString(index++));
    data.setRevision(rs.getString(index++));
    data.setEnabled(rs.getString(index++));
    data.setParameterName(rs.getString(index++));
    data.setParameterDesc(rs.getString(index++));

    return data;
  }
}