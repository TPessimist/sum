package ame.psb.db.dao;

import ame.psb.db.PkgTagFactorDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class PkgTagFactorDefDao {

  private static final String SQL_INS = "INSERT INTO zd_pkg_tag_factor_def(id,driver_class,driver_args_def,category,description,param_type,result_type) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_pkg_tag_factor_def SET driver_class=?,driver_args_def=?,category=?,description=?,param_type=?,result_type=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,driver_class,driver_args_def,category,description,param_type,result_type FROM zd_pkg_tag_factor_def ";

  private final Connection conn;

  public PkgTagFactorDefDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgTagFactorDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getDriverClass());
      ps.setString(3, data.getDriverArgsDef());
      ps.setString(4, data.getCategory());
      ps.setString(5, data.getDescription());
      ps.setString(6, data.getParamType());
      ps.setString(7, data.getResultType());

      return ps.executeUpdate();
    }
  }

  public int update(PkgTagFactorDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDriverClass());
      ps.setString(2, data.getDriverArgsDef());
      ps.setString(3, data.getCategory());
      ps.setString(4, data.getDescription());
      ps.setString(5, data.getParamType());
      ps.setString(6, data.getResultType());
      ps.setString(7, data.getId());

      return ps.executeUpdate();
    }
  }

  public Map<String, PkgTagFactorDef> selectAll() throws SQLException {
    TreeMap<String, PkgTagFactorDef> result = new TreeMap<String, PkgTagFactorDef>();

    PreparedStatement ps = this.conn.prepareStatement(SQL_SEL);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      PkgTagFactorDef f = convert(rs);
      result.put(f.getId(), f);
    }

    return result;
  }

  public PkgTagFactorDef selectByPK(String id) throws SQLException {
    PkgTagFactorDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgTagFactorDef convert(ResultSet rs) throws SQLException {
    PkgTagFactorDef data = new PkgTagFactorDef();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDriverClass(rs.getString(index++));
    data.setDriverArgsDef(rs.getString(index++));
    data.setCategory(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setParamType(rs.getString(index++));
    data.setResultType(rs.getString(index++));

    return data;
  }
}
