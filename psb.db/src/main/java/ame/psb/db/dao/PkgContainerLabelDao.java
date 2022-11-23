package ame.psb.db.dao;

import ame.psb.db.PkgContainerLabel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgContainerLabelDao {

  private static final String SQL_INS = "INSERT INTO zr_pkg_container_label(container_bo,label_bo,print_qty,print_content,state_name,created_user,created_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_pkg_container_label SET print_qty=?,print_content=?,state_name=?,created_user=?,created_time=? WHERE container_bo=? AND label_bo=?";

  private static final String SQL_SEL = "SELECT container_bo,label_bo,print_qty,print_content,state_name,created_user,created_time FROM zr_pkg_container_label ";

  private final Connection conn;

  public PkgContainerLabelDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgContainerLabel data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getContainerBo());
      ps.setString(2, data.getLabelBo());
      ps.setBigDecimal(3, data.getPrintQty());
      ps.setString(4, data.getPrintContent());
      ps.setString(5, data.getStateName());
      ps.setString(6, data.getCreatedUser());
      DateUtils.setDateTz(ps, 7, data.getCreatedTime());

      return ps.executeUpdate();
    }
  }

  public int update(PkgContainerLabel data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getPrintQty());
      ps.setString(2, data.getPrintContent());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getCreatedUser());
      DateUtils.setDateTz(ps, 5, data.getCreatedTime());
      ps.setString(6, data.getContainerBo());
      ps.setString(7, data.getLabelBo());

      return ps.executeUpdate();
    }
  }

  public int delete(String containerBo, String labelBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_pkg_container_label WHERE container_bo=? AND label_bo=?")) {
      ps.setString(1, containerBo);
      ps.setString(2, labelBo);

      return ps.executeUpdate();
    }
  }

  public List<PkgContainerLabel> selectAll() throws SQLException {
    ArrayList<PkgContainerLabel> result = new ArrayList<PkgContainerLabel>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgContainerLabel> select(String containerBo) throws SQLException {
    ArrayList<PkgContainerLabel> result = new ArrayList<PkgContainerLabel>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE container_bo=? ORDER BY label_bo")) {
      ps.setString(1, containerBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public PkgContainerLabel selectByPK(String containerBo, String labelBo) throws SQLException {
    PkgContainerLabel result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE container_bo=? AND label_bo=?")) {
      ps.setString(1, containerBo);
      ps.setString(2, labelBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgContainerLabel convert(ResultSet rs) throws SQLException {
    PkgContainerLabel data = new PkgContainerLabel();

    int index = 1;
    data.setContainerBo(rs.getString(index++));
    data.setLabelBo(rs.getString(index++));
    data.setPrintQty(rs.getBigDecimal(index++));
    data.setPrintContent(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCreatedUser(rs.getString(index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
