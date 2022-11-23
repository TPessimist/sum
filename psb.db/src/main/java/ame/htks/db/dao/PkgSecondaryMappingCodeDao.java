package ame.htks.db.dao;

import ame.htks.db.PkgSecondaryMappingCode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PkgSecondaryMappingCodeDao {

  private static final String SQL_SEL = "SELECT product,device,bin_code_list,mapping_code,update_user,update_time FROM zh_pkg_secondary_mapping_code ";

  private final Connection conn;

  public PkgSecondaryMappingCodeDao(Connection conn) {
    this.conn = conn;
  }

  public List<PkgSecondaryMappingCode> selectAll() throws SQLException {
    ArrayList<PkgSecondaryMappingCode> result = new ArrayList<PkgSecondaryMappingCode>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public PkgSecondaryMappingCode selectByPK(String product, String device, String binCodeList)
      throws SQLException {
    PkgSecondaryMappingCode result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE product=? AND device=? AND bin_code_list=?")) {
      ps.setString(1, product);
      ps.setString(2, device);
      ps.setString(3, binCodeList);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgSecondaryMappingCode convert(ResultSet rs) throws SQLException {
    PkgSecondaryMappingCode data = new PkgSecondaryMappingCode();

    int index = 1;
    data.setProduct(rs.getString(index++));
    data.setDevice(rs.getString(index++));
    data.setBinCodeList(rs.getString(index++));
    data.setMappingCode(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(rs.getString(index++));

    return data;
  }
}
