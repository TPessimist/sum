package ame.psb.db.dao;

import ame.psb.db.SortManipulation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SortManipulationDao {

  private static final String SQL_INS = "INSERT INTO zd_sort_manipulation(resource,foup_id1,foup_id2,foup_id3,foup_id4,eap_request,flag,log_user,log_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_sort_manipulation SET foup_id1=?,foup_id2=?,foup_id3=?,foup_id4=?,eap_request=?,flag=?,log_user=?,log_time=? WHERE resource=?";

  private static final String SQL_UPD2 = "UPDATE zd_sort_manipulation SET foup_id1=?,foup_id2=?,foup_id3=?,foup_id4=?,eap_request=?,flag=?,log_user=?,log_time=? WHERE resource=? and foup_id1=? and foup_id2=? and flag = 'Y' ";


  private static final String SQL_SEL = "SELECT resource,foup_id1,foup_id2,foup_id3,foup_id4,eap_request,flag,log_user,log_time FROM zd_sort_manipulation ";

  private final Connection conn;

  public SortManipulationDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SortManipulation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResource());
      ps.setString(2, data.getFoupId1());
      ps.setString(3, data.getFoupId2());
      ps.setString(4, data.getFoupId3());
      ps.setString(5, data.getFoupId4());
      ps.setString(6, data.getEapRequest());
      ps.setString(7, data.getFlag());
      ps.setString(8, data.getLogUser());
      DateUtils.setDateTz(ps, 9, data.getLogTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SortManipulation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SortManipulation data : dataList) {
        ps.setString(1, data.getResource());
        ps.setString(2, data.getFoupId1());
        ps.setString(3, data.getFoupId2());
        ps.setString(4, data.getFoupId3());
        ps.setString(5, data.getFoupId4());
        ps.setString(6, data.getEapRequest());
        ps.setString(7, data.getFlag());
        ps.setString(8, data.getLogUser());
        DateUtils.setDateTz(ps, 9, data.getLogTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SortManipulation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFoupId1());
      ps.setString(2, data.getFoupId2());
      ps.setString(3, data.getFoupId3());
      ps.setString(4, data.getFoupId4());
      ps.setString(5, data.getEapRequest());
      ps.setString(6, data.getFlag());
      ps.setString(7, data.getLogUser());
      DateUtils.setDateTz(ps, 8, data.getLogTime());
      ps.setString(9, data.getResource());

      return ps.executeUpdate();
    }
  }

  public int update2(SortManipulation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD2)) {
      ps.setString(1, data.getFoupId1());
      ps.setString(2, data.getFoupId2());
      ps.setString(3, data.getFoupId3());
      ps.setString(4, data.getFoupId4());
      ps.setString(5, data.getEapRequest());
      ps.setString(6, data.getFlag());
      ps.setString(7, data.getLogUser());
      DateUtils.setDateTz(ps, 8, data.getLogTime());
      ps.setString(9, data.getResource());
      ps.setString(10, data.getFoupId1());
      ps.setString(11, data.getFoupId2());

      return ps.executeUpdate();
    }
  }

  public int update(List<SortManipulation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SortManipulation data : dataList) {
        ps.setString(1, data.getFoupId1());
        ps.setString(2, data.getFoupId2());
        ps.setString(3, data.getFoupId3());
        ps.setString(4, data.getFoupId4());
        ps.setString(5, data.getEapRequest());
        ps.setString(6, data.getFlag());
        ps.setString(7, data.getLogUser());
        DateUtils.setDateTz(ps, 8, data.getLogTime());
        ps.setString(9, data.getResource());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resource) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_sort_manipulation WHERE resource=?")) {
      ps.setString(1, resource);

      return ps.executeUpdate();
    }
  }

  public List<SortManipulation> selectAll() throws SQLException {
    ArrayList<SortManipulation> result = new ArrayList<SortManipulation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SortManipulation selectByPK(String resource) throws SQLException {
    SortManipulation result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource=? and flag = 'Y' order by log_time desc")) {
      ps.setString(1, resource);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public SortManipulation selectByY() throws SQLException {
    SortManipulation result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE flag='Y'")) {

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SortManipulation convert(ResultSet rs) throws SQLException {
    SortManipulation data = new SortManipulation();

    int index = 1;
    data.setResource(rs.getString(index++));
    data.setFoupId1(rs.getString(index++));
    data.setFoupId2(rs.getString(index++));
    data.setFoupId3(rs.getString(index++));
    data.setFoupId4(rs.getString(index++));
    data.setEapRequest(rs.getString(index++));
    data.setFlag(rs.getString(index++));
    data.setLogUser(rs.getString(index++));
    data.setLogTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
