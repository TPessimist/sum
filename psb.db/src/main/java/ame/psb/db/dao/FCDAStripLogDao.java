package ame.psb.db.dao;

import ame.psb.db.FCDAStripLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FCDAStripLogDao {

  private static final String SQL_INS = "INSERT INTO zr_fcda_strip_log(id,strip_id,magazine_id,resource_name,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_fcda_strip_log SET strip_id=?,magazine_id=?,resource_name=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,strip_id,magazine_id,resource_name,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_fcda_strip_log ";

  private final Connection conn;

  public FCDAStripLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FCDAStripLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getStripId());
      ps.setString(3, data.getMagazineId());
      ps.setString(4, data.getResourceName());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FCDAStripLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FCDAStripLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getStripId());
        ps.setString(3, data.getMagazineId());
        ps.setString(4, data.getResourceName());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FCDAStripLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getStripId());
      ps.setString(2, data.getMagazineId());
      ps.setString(3, data.getResourceName());
      ps.setString(4, data.getReversedField1());
      ps.setString(5, data.getReversedField2());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FCDAStripLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FCDAStripLog data : dataList) {
        ps.setString(1, data.getStripId());
        ps.setString(2, data.getMagazineId());
        ps.setString(3, data.getResourceName());
        ps.setString(4, data.getReversedField1());
        ps.setString(5, data.getReversedField2());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_fcda_strip_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<FCDAStripLog> selectAll() throws SQLException {
    ArrayList<FCDAStripLog> result = new ArrayList<FCDAStripLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FCDAStripLog selectByPK(String id) throws SQLException {
    FCDAStripLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FCDAStripLog selectByPKStripId(String stripId) throws SQLException {
    FCDAStripLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE STRIP_ID=?")) {
      ps.setString(1, stripId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FCDAStripLog convert(ResultSet rs) throws SQLException {
    FCDAStripLog data = new FCDAStripLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setStripId(rs.getString(index++));
    data.setMagazineId(rs.getString(index++));
    data.setResourceName(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
