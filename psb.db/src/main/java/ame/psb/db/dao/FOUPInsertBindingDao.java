package ame.psb.db.dao;

import ame.psb.db.FOUPInsertBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FOUPInsertBindingDao {

  private static final String SQL_INS = "INSERT INTO zr_foup_insert_binding(id,foup_id,foup_insert_id,flag,created_user,created_time,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_foup_insert_binding SET foup_id=?,foup_insert_id=?,flag=?,created_user=?,created_time=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,foup_id,foup_insert_id,flag,created_user,created_time,updated_user,updated_time FROM zr_foup_insert_binding ";

  private final Connection conn;

  public FOUPInsertBindingDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FOUPInsertBinding data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getFoupId());
      ps.setString(3, data.getFoupInsertId());
      ps.setString(4, data.getFlag());
      ps.setString(5, data.getCreatedUser());
      DateUtils.setDateTz(ps, 6, data.getCreatedTime());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FOUPInsertBinding> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FOUPInsertBinding data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getFoupId());
        ps.setString(3, data.getFoupInsertId());
        ps.setString(4, data.getFlag());
        ps.setString(5, data.getCreatedUser());
        DateUtils.setDateTz(ps, 6, data.getCreatedTime());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FOUPInsertBinding data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFoupId());
      ps.setString(2, data.getFoupInsertId());
      ps.setString(3, data.getFlag());
      ps.setString(4, data.getCreatedUser());
      DateUtils.setDateTz(ps, 5, data.getCreatedTime());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FOUPInsertBinding> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FOUPInsertBinding data : dataList) {
        ps.setString(1, data.getFoupId());
        ps.setString(2, data.getFoupInsertId());
        ps.setString(3, data.getFlag());
        ps.setString(4, data.getCreatedUser());
        DateUtils.setDateTz(ps, 5, data.getCreatedTime());
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
        .prepareStatement("DELETE FROM zr_foup_insert_binding WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<FOUPInsertBinding> selectAll() throws SQLException {
    ArrayList<FOUPInsertBinding> result = new ArrayList<FOUPInsertBinding>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public FOUPInsertBinding selectByPK(String id) throws SQLException {
    FOUPInsertBinding result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public FOUPInsertBinding selectActiveByFoup(String foupId) throws SQLException {
    FOUPInsertBinding result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE foup_id=? and flag = 'Y' ")) {
      ps.setString(1, foupId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public FOUPInsertBinding selectActiveByInsert(String insertId) throws SQLException {
    FOUPInsertBinding result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE foup_insert_id=? and flag = 'Y' ")) {
      ps.setString(1, insertId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }


  private FOUPInsertBinding convert(ResultSet rs) throws SQLException {
    FOUPInsertBinding data = new FOUPInsertBinding();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setFoupId(rs.getString(index++));
    data.setFoupInsertId(rs.getString(index++));
    data.setFlag(rs.getString(index++));
    data.setCreatedUser(rs.getString(index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
