package ame.psb.db.dao;

import ame.psb.db.PackageExt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class PackageExtDao {

  private static final String SQL_INS = "INSERT INTO zd_package_ext(package_bo,package_name,recipe_id,clamp,seal,create_user,create_time,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_package_ext SET package_name=?,recipe_id=?,clamp=?,seal=?,create_user=?,create_time=?,updated_user=?,updated_time=? WHERE package_bo=?";

  private static final String SQL_SEL = "SELECT package_bo,package_name,recipe_id,clamp,seal,create_user,create_time,updated_user,updated_time,package_row,package_col FROM VIEW_ZD_PACKAGE_EXT ";


  private final Connection conn;

  public PackageExtDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PackageExt data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getPackageBo());
      ps.setString(2, data.getPackageName());
      ps.setString(3, data.getRecipeId());
      ps.setString(4, data.getClamp());
      ps.setString(5, data.getSeal());
      ps.setString(6, data.getCreateUser());
      DateUtils.setDateTz(ps, 7, data.getCreateTime());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PackageExt> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PackageExt data : dataList) {
        ps.setString(1, data.getPackageBo());
        ps.setString(2, data.getPackageName());
        ps.setString(3, data.getRecipeId());
        ps.setString(4, data.getClamp());
        ps.setString(5, data.getSeal());
        ps.setString(6, data.getCreateUser());
        DateUtils.setDateTz(ps, 7, data.getCreateTime());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PackageExt data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getPackageName());
      ps.setString(2, data.getRecipeId());
      ps.setString(3, data.getClamp());
      ps.setString(4, data.getSeal());
      ps.setString(5, data.getCreateUser());
      DateUtils.setDateTz(ps, 6, data.getCreateTime());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getPackageBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<PackageExt> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PackageExt data : dataList) {
        ps.setString(1, data.getPackageName());
        ps.setString(2, data.getRecipeId());
        ps.setString(3, data.getClamp());
        ps.setString(4, data.getSeal());
        ps.setString(5, data.getCreateUser());
        DateUtils.setDateTz(ps, 6, data.getCreateTime());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getPackageBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String packageBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_package_ext WHERE package_bo=?")) {
      ps.setString(1, packageBo);

      return ps.executeUpdate();
    }
  }

  public List<PackageExt> selectAll() throws SQLException {
    ArrayList<PackageExt> result = new ArrayList<PackageExt>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PackageExt> select(Where where) throws SQLException {
    ArrayList<PackageExt> result = new ArrayList<PackageExt>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }


  public PackageExt selectByPK(String packageBo) throws SQLException {
    PackageExt result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE package_bo=?")) {
      ps.setString(1, packageBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PackageExt convert(ResultSet rs) throws SQLException {
    PackageExt data = new PackageExt();

    int index = 1;
    data.setPackageBo(rs.getString(index++));
    data.setPackageName(rs.getString(index++));
    data.setRecipeId(rs.getString(index++));
    data.setClamp(rs.getString(index++));
    data.setSeal(rs.getString(index++));
    data.setCreateUser(rs.getString(index++));
    data.setCreateTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setPackageRow(rs.getString(index++));
    data.setPackageCol(rs.getString(index++));

    return data;
  }
}
