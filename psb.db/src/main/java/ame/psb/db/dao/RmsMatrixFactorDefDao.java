package ame.psb.db.dao;

import ame.psb.db.RmsMatrixFactorDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class RmsMatrixFactorDefDao {

  private static final String SQL = "SELECT id,driver_class,driver_args_def FROM zd_rms_matrix_factor_def ";

  private Connection conn;

  public RmsMatrixFactorDefDao(Connection conn) {
    this.conn = conn;
  }

  /**
   * 搜尋所有 Recipe Factor 定義。
   *
   * @return 所有 Recipe Factor 定義。
   * @throws SQLException
   */
  public Map<String, RmsMatrixFactorDef> selectAll() throws SQLException {
    TreeMap<String, RmsMatrixFactorDef> result = new TreeMap<String, RmsMatrixFactorDef>();

    PreparedStatement ps = this.conn.prepareStatement(SQL);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      RmsMatrixFactorDef f = convert(rs);
      result.put(f.getId(), f);
    }

    return result;
  }

  private RmsMatrixFactorDef convert(ResultSet rs) throws SQLException {
    RmsMatrixFactorDef data = new RmsMatrixFactorDef();
    data.setId(rs.getString(1));
    data.setDriverClass(rs.getString(2));
    data.setDriverArgsDef(rs.getString(3));
    return data;
  }

}
