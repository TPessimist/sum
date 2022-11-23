package ame.psb.db.dao;

import ame.psb.db.RmsPattern;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RmsPatternDao {

  private static final String SQL_INS = "INSERT INTO zd_rms_pattern(id,recipe_pattern,updated_user,updated_time) VALUES (?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_rms_pattern SET recipe_pattern=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,recipe_pattern,updated_user,updated_time FROM zd_rms_pattern ";

  private Connection conn;

  public RmsPatternDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RmsPattern data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getRecipePattern());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int update(RmsPattern data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getRecipePattern());
      ps.setString(2, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
      ps.setString(4, data.getId());

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_rms_pattern WHERE id=?")) {
      ps.setString(1, id);
      return ps.executeUpdate();
    }
  }

  public RmsPattern selectByPK(String id) throws SQLException {
    RmsPattern recipe = null;

    PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?");
    ps.setString(1, id);

    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      recipe = convert(rs);
    }

    return recipe;
  }

  public List<RmsPattern> selectAll() throws SQLException {
    ArrayList<RmsPattern> patterns = new ArrayList<RmsPattern>();

    PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " ORDER BY id");

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      patterns.add(convert(rs));
    }

    return patterns;
  }

  private RmsPattern convert(ResultSet rs) throws SQLException {
    RmsPattern data = new RmsPattern();
    data.setId(rs.getString(1));
    data.setRecipePattern(rs.getString(2));
    data.setUpdatedUser(rs.getString(3));
    data.setUpdatedTime(DateUtils.getDateTz(rs, 4));
    return data;
  }
}
