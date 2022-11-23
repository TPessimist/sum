package ame.psb.db.dao;

import ame.psb.db.ViewMcsLayoutCfs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ViewMcsLayoutCfsDao {

  private static final String SQL_SEL = "SELECT resource_bo,next_resource_bo,bay_bo,comment,updated_time,updated_user,attribute,value,created_date_time,modified_date_time FROM view_mcs_layout_cfs ";

  private final Connection conn;

  public ViewMcsLayoutCfsDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewMcsLayoutCfs> selectAll() throws SQLException {
    ArrayList<ViewMcsLayoutCfs> result = new ArrayList<ViewMcsLayoutCfs>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ViewMcsLayoutCfs> selectByBayAndAttribute(String bayBo, String attribute)
      throws SQLException {
    ArrayList<ViewMcsLayoutCfs> result = new ArrayList<ViewMcsLayoutCfs>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where bay_bo = ? and attribute = ?")) {
      ps.setString(1, bayBo);
      ps.setString(2, attribute);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewMcsLayoutCfs> selectByBayAndAttributeAndValue(String bayBo, String attribute,
      String value) throws SQLException {
    ArrayList<ViewMcsLayoutCfs> result = new ArrayList<ViewMcsLayoutCfs>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where bay_bo = ? and attribute = ? and value = ? ")) {
      ps.setString(1, bayBo);
      ps.setString(2, attribute);
      ps.setString(3, value);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewMcsLayoutCfs> selectByBayAndAttributeAndValue(String bayBo, String attribute,
      String value, String resourceType) throws SQLException {
    ArrayList<ViewMcsLayoutCfs> result = new ArrayList<ViewMcsLayoutCfs>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "where bay_bo = ? and attribute = ? and value = ? and RESOURCE_TYPE = ?")) {
      ps.setString(1, bayBo);
      ps.setString(2, attribute);
      ps.setString(3, value);
      ps.setString(4, resourceType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewMcsLayoutCfs> selectByBayAndAttributeAndValueAndFullNext(String bayBo,
      String attribute, String value) throws SQLException {
    ArrayList<ViewMcsLayoutCfs> result = new ArrayList<ViewMcsLayoutCfs>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "where bay_bo = ? and attribute = ? and value = ? and NEXT_RESOURCE_BO != 'NULL' and RESOURCE_TYPE = 'EXCHANGE' ")) {
      ps.setString(1, bayBo);
      ps.setString(2, attribute);
      ps.setString(3, value);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewMcsLayoutCfs> selectAllNcdOhb() throws SQLException {
    ArrayList<ViewMcsLayoutCfs> result = new ArrayList<ViewMcsLayoutCfs>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "where RESOURCE_TYPE  = 'OHB' AND ATTRIBUTE  = 'MCS_SYS_NAME' AND VALUE  = 'NCD' ")) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ViewMcsLayoutCfs> select01Start(String bayBo, String attribute, String value)
      throws SQLException {
    ArrayList<ViewMcsLayoutCfs> result = new ArrayList<ViewMcsLayoutCfs>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "where bay_bo = ? and attribute = ? and value = ? and comment = 'START'")) {
      ps.setString(1, bayBo);
      ps.setString(2, attribute);
      ps.setString(3, value);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewMcsLayoutCfs> selectByBayAndAttribute(String bayBo, String attribute,
      String value) throws SQLException {
    ArrayList<ViewMcsLayoutCfs> result = new ArrayList<ViewMcsLayoutCfs>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where bay_bo = ? and attribute = ? and value = ?")) {
      ps.setString(1, bayBo);
      ps.setString(2, attribute);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ViewMcsLayoutCfs> selectByResourceAndBayAndAttribute(String resource_bo, String bayBo,
      String attribute) throws SQLException {
    ArrayList<ViewMcsLayoutCfs> result = new ArrayList<ViewMcsLayoutCfs>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where resource_bo =? and bay_bo = ? and attribute = ?")) {
      ps.setString(1, resource_bo);
      ps.setString(2, bayBo);
      ps.setString(3, attribute);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewMcsLayoutCfs convert(ResultSet rs) throws SQLException {
    ViewMcsLayoutCfs data = new ViewMcsLayoutCfs();

    int index = 1;
    data.setResourceBo(rs.getString(index++));
    data.setNextResourceBo(rs.getString(index++));
    data.setBayBo(rs.getString(index++));
    data.setComment(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setAttribute(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
