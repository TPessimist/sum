package ame.psb.db.dao;

import ame.psb.db.PkgLabel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class PkgLabelDao {

  private static final String SQL_INS = "INSERT INTO zd_pkg_label(id,label_name,description,template_id,printer_id,updated_user,updated_time,label_type) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_pkg_label SET label_name=?,description=?,template_id=?,printer_id=?,updated_user=?,updated_time=?,label_type=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,label_name,description,template_id,printer_id,updated_user,updated_time,label_type FROM zd_pkg_label ";

  private final Connection conn;

  public PkgLabelDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgLabel data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getLabelName());
      ps.setString(3, data.getDescription());
      ps.setString(4, data.getTemplateId());
      ps.setString(5, data.getPrinterId());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getLabelType());
      return ps.executeUpdate();
    }
  }

  public int update(PkgLabel data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getLabelName());
      ps.setString(2, data.getDescription());
      ps.setString(3, data.getTemplateId());
      ps.setString(4, data.getPrinterId());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getLabelType());
      ps.setString(8, data.getId());

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_pkg_label WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<PkgLabel> selectAll() throws SQLException {
    ArrayList<PkgLabel> result = new ArrayList<PkgLabel>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "ORDER BY id")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgLabel> select(Where where) throws SQLException {
    ArrayList<PkgLabel> result = new ArrayList<PkgLabel>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public PkgLabel selectByPK(String id) throws SQLException {
    PkgLabel result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgLabel selectByName(String labelName) throws SQLException {
    PkgLabel result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE label_name=?")) {
      ps.setString(1, labelName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<PkgLabel> selectByNamePrefix(String labelName) throws SQLException {
    ArrayList<PkgLabel> result = new ArrayList<PkgLabel>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE label_name like ?")) {
      ps.setString(1, labelName + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private PkgLabel convert(ResultSet rs) throws SQLException {
    PkgLabel data = new PkgLabel();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setLabelName(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setTemplateId(rs.getString(index++));
    data.setPrinterId(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setLabelType(rs.getString(index++));
    return data;
  }
}
