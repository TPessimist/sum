package ame.psb.db.dao;

import ame.psb.db.ZrUploadLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ZrUploadLogDao {

  private static final String SQL_SEL1 = "SELECT id,subid,value,group_name FROM zr_upload_log ";

  private Connection conn;

  public ZrUploadLogDao(Connection conn) {
    this.conn = conn;
  }

  public ZrUploadLog selectByPK(String id, String subid) throws SQLException {
    ZrUploadLog lookup = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL1 + "WHERE id=? AND subid=? ")) {
      ps.setString(1, id);
      ps.setString(2, subid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = this.convert(rs);
      }
    }
    return lookup;
  }

  public ZrUploadLog selectByPK2(String id, String value) throws SQLException {
    ZrUploadLog lookup = null;

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL1 + "WHERE id=? AND value=?")) {
      ps.setString(1, id);
      ps.setString(2, value);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = this.convert(rs);
      }
    }
    return lookup;
  }

  public ZrUploadLog selectByDetail(String id, String value, String groupName) throws SQLException {
    ZrUploadLog lookup = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id=? AND value=? AND group_name=?")) {
      ps.setString(1, id);
      ps.setString(2, value);
      ps.setString(3, groupName);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = this.convert(rs);
      }
    }
    return lookup;
  }

  public ZrUploadLog selectByPKDetail(String id, String subid, String groupName)
      throws SQLException {
    ZrUploadLog lookup = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id=? AND SUBID=? AND group_name=?")) {
      ps.setString(1, id);
      ps.setString(2, subid);
      ps.setString(3, groupName);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = this.convert(rs);
      }
    }
    return lookup;
  }

  public List<ZrUploadLog> selectByGroup(String id, String groupName) throws SQLException {
    List<ZrUploadLog> lookupList = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id=? AND group_name=?")) {
      ps.setString(1, id);
      ps.setString(2, groupName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        lookupList.add(this.convert(rs));
      }
    }
    return lookupList;
  }

  public List<ZrUploadLog> select(String id) throws SQLException {
    ArrayList<ZrUploadLog> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id=? ORDER BY subid")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ZrUploadLog> selectByGroupName(String groupName) throws SQLException {
    ArrayList<ZrUploadLog> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE group_name=?")) {
      ps.setString(1, groupName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public int insert(String id, String subid, String value) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("INSERT INTO zr_upload_log(id,subid,value) VALUES(?,?,?)");
    ps.setString(1, id);
    ps.setString(2, subid);
    ps.setString(3, value);
    return ps.executeUpdate();
  }

  public int insert(String id, String subid, String value, String groupName) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("INSERT INTO zr_upload_log(id,subid,value,group_name) VALUES(?,?,?,?)");
    ps.setString(1, id);
    ps.setString(2, subid);
    ps.setString(3, value);
    ps.setString(4, groupName);
    return ps.executeUpdate();
  }

  public int insert(ZrUploadLog lk) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("INSERT INTO zr_upload_log(id,subid,value,group_name) VALUES(?,?,?,?)");
    ps.setString(1, lk.getId());
    ps.setString(2, lk.getSubid());
    ps.setString(3, lk.getValue());
    ps.setString(4, lk.getGroupName());
    return ps.executeUpdate();
  }

  public int insert(List<ZrUploadLog> lookups) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("INSERT INTO zr_upload_log(id,subid,value,group_name) VALUES(?,?,?,?)");
    for (ZrUploadLog lk : lookups) {
      ps.setString(1, lk.getId());
      ps.setString(2, lk.getSubid());
      ps.setString(3, lk.getValue());
      ps.setString(4, lk.getGroupName());
      ps.addBatch();
    }
    return ps.executeBatch().length;
  }

  public int update(String id, String subid, String value) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_upload_log SET value=? WHERE id=? AND subid=?");
    ps.setString(1, value);
    ps.setString(2, id);
    ps.setString(3, subid);
    return ps.executeUpdate();
  }

  public int updateDetail(String id, String subid, String value, String groupName)
      throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_upload_log SET value=?, group_name=? WHERE id=? AND subid=?");
    ps.setString(1, value);
    ps.setString(2, groupName);
    ps.setString(3, id);
    ps.setString(4, subid);
    return ps.executeUpdate();
  }

  public int updateGroupName(String id, String subid, String groupName) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_upload_log SET GROUP_NAME=? WHERE id=? AND subid=?");
    ps.setString(1, groupName);
    ps.setString(2, id);
    ps.setString(3, subid);
    return ps.executeUpdate();
  }

  public int deleteById(String id) throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement("delete from zr_upload_log WHERE id=?");
    ps.setString(1, id);
    return ps.executeUpdate();
  }

  public int delete(String id, String subid) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("delete from zr_upload_log WHERE id=? and subid=?");
    ps.setString(1, id);
    ps.setString(2, subid);
    return ps.executeUpdate();
  }

  private ZrUploadLog convert(ResultSet rs) throws SQLException {
    ZrUploadLog data = new ZrUploadLog();
    data.setId(rs.getString(1));
    data.setSubid(rs.getString(2));
    data.setValue(rs.getString(3));
    data.setGroupName(rs.getString(4));
    return data;
  }
}
