package ame.psb.db.dao;

import ame.psb.db.PkgTag;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class PkgTagDao {

  private static final String SQL_INS = "INSERT INTO zd_pkg_tag(id,value_pattern,value_script,description,value_type,updated_user,updated_time,tag_type) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_pkg_tag SET value_pattern=?,value_script=?,description=?,value_type=?,updated_user=?,updated_time=?,tag_type=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,value_pattern,value_script,description,value_type,updated_user,updated_time, tag_type FROM zd_pkg_tag ";

  private final Connection conn;

  public PkgTagDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgTag data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getValuePattern());
      ps.setString(3, data.getValueScript());
      ps.setString(4, data.getDescription());
      ps.setString(5, data.getValueType());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getTagType());

      return ps.executeUpdate();
    }
  }

  public int update(PkgTag data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getValuePattern());
      ps.setString(2, data.getValueScript());
      ps.setString(3, data.getDescription());
      ps.setString(4, data.getValueType());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getTagType());
      ps.setString(8, data.getId());

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_pkg_tag WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<PkgTag> selectAll() throws SQLException {
    ArrayList<PkgTag> result = new ArrayList<PkgTag>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgTag> select(Where where) throws SQLException {
    ArrayList<PkgTag> result = new ArrayList<PkgTag>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public PkgTag selectByPK(String id) throws SQLException {
    PkgTag result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgTag convert(ResultSet rs) throws SQLException {
    PkgTag data = new PkgTag();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setValuePattern(rs.getString(index++));
    data.setValueScript(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setValueType(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setTagType(rs.getString(index++));
    return data;
  }
}
