package ame.psb.db.dao;

import ame.psb.db.PkgInStockContainerSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgInStockContainerSfcDao {

  private static final String SQL_INS = "INSERT INTO zd_pkg_in_stock_container_sfc(container_bo,sfc_bo,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_pkg_in_stock_container_sfc SET reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE container_bo=? AND sfc_bo=?";

  private static final String SQL_SEL = "SELECT container_bo,sfc_bo,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_pkg_in_stock_container_sfc ";

  private final Connection conn;

  public PkgInStockContainerSfcDao(Connection conn) {
    this.conn = conn;
  }

  public int insertOrUpdate(PkgInStockContainerSfc data) throws SQLException {
    PkgInStockContainerSfc pkgInStockContainerSfc = selectByPK(data.getContainerBo(),
        data.getSfcBo());
    if (null != pkgInStockContainerSfc) {
      return update(data);
    } else {
      return insert(data);
    }
  }

  public int insert(PkgInStockContainerSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getContainerBo());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getReversedField1());
      ps.setString(4, data.getReversedField2());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PkgInStockContainerSfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PkgInStockContainerSfc data : dataList) {
        ps.setString(1, data.getContainerBo());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getReversedField1());
        ps.setString(4, data.getReversedField2());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PkgInStockContainerSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getReversedField1());
      ps.setString(2, data.getReversedField2());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getContainerBo());
      ps.setString(6, data.getSfcBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<PkgInStockContainerSfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PkgInStockContainerSfc data : dataList) {
        ps.setString(1, data.getReversedField1());
        ps.setString(2, data.getReversedField2());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getContainerBo());
        ps.setString(6, data.getSfcBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String containerBo, String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_pkg_in_stock_container_sfc WHERE container_bo=? AND sfc_bo=?")) {
      ps.setString(1, containerBo);
      ps.setString(2, sfcBo);

      return ps.executeUpdate();
    }
  }

  public List<PkgInStockContainerSfc> selectAll() throws SQLException {
    ArrayList<PkgInStockContainerSfc> result = new ArrayList<PkgInStockContainerSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PkgInStockContainerSfc selectByPK(String containerBo, String sfcBo) throws SQLException {
    PkgInStockContainerSfc result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE container_bo=? AND sfc_bo=?")) {
      ps.setString(1, containerBo);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgInStockContainerSfc convert(ResultSet rs) throws SQLException {
    PkgInStockContainerSfc data = new PkgInStockContainerSfc();

    int index = 1;
    data.setContainerBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
