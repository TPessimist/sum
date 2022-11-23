package ame.psb.db.dao;

import ame.psb.db.RmsPatternFactorDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class RmsPatternFactorDefDao {

  private static final String SQL = "SELECT id,driver_class,driver_args_def FROM zd_rms_pattern_factor_def ";

  private Connection conn;

  public RmsPatternFactorDefDao(Connection conn) {
    this.conn = conn;
  }

  public RmsPatternFactorDef selectByPK(String id) throws SQLException {
    RmsPatternFactorDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }
    return result;
  }

  public Map<String, RmsPatternFactorDef> selectAll() throws SQLException {
    TreeMap<String, RmsPatternFactorDef> result = new TreeMap<String, RmsPatternFactorDef>();
    PreparedStatement ps = this.conn.prepareStatement(SQL);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      RmsPatternFactorDef f = convert(rs);
      result.put(f.getId(), f);
    }
    return result;
  }

  private RmsPatternFactorDef convert(ResultSet rs) throws SQLException {
    RmsPatternFactorDef data = new RmsPatternFactorDef();
    data.setId(rs.getString(1));
    data.setDriverClass(rs.getString(2));
    data.setDriverArgsDef(rs.getString(3));
    return data;
  }

}
