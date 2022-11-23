package ame.psb.db.dao;

import ame.psb.db.RmsMatrix;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RmsMatrixDao {

  private static final String SQL_INS = "INSERT INTO zd_rms_matrix(id,matrix_name,updated_user,updated_time) VALUES (?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_rms_matrix SET matrix_name=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,matrix_name,updated_user,updated_time FROM zd_rms_matrix ";

  private Connection conn;

  public RmsMatrixDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RmsMatrix data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getMatrixName());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int update(RmsMatrix data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getMatrixName());
      ps.setString(2, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
      ps.setString(4, data.getId());

      return ps.executeUpdate();
    }
  }

  public RmsMatrix selectByPK(String id) throws SQLException {
    RmsMatrix result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }
    return result;
  }

  public List<RmsMatrix> selectAll() throws SQLException {
    ArrayList<RmsMatrix> result = new ArrayList<RmsMatrix>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  private RmsMatrix convert(ResultSet rs) throws SQLException {
    RmsMatrix data = new RmsMatrix();
    data.setId(rs.getString(1));
    data.setMatrixName(rs.getString(2));
    data.setUpdatedUser(rs.getString(3));
    data.setUpdatedTime(DateUtils.getDateTz(rs, 4));
    return data;
  }

}
