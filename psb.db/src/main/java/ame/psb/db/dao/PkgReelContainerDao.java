package ame.psb.db.dao;

import ame.psb.db.PkgReelContainer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgReelContainerDao {

  private static final String SQL_INS = "INSERT INTO zr_pkg_reel_container(container_bo,reel_seq,type,memo,updated_user,updated_time,seq) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_pkg_reel_container SET reel_seq=?,type=?,memo=?,updated_user=?,updated_time=?,seq=? WHERE container_bo=?";

  private static final String SQL_SEL = "SELECT container_bo,reel_seq,type,memo,updated_user,updated_time,seq FROM zr_pkg_reel_container ";

  private final Connection conn;

  public PkgReelContainerDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgReelContainer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getContainerBo());
      ps.setString(2, data.getReelSeq());
      ps.setString(3, data.getType());
      ps.setString(4, data.getMemo());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setBigDecimal(7, data.getSeq());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PkgReelContainer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PkgReelContainer data : dataList) {
        ps.setString(1, data.getContainerBo());
        ps.setString(2, data.getReelSeq());
        ps.setString(3, data.getType());
        ps.setString(4, data.getMemo());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setBigDecimal(7, data.getSeq());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PkgReelContainer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getReelSeq());
      ps.setString(2, data.getType());
      ps.setString(3, data.getMemo());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setBigDecimal(6, data.getSeq());
      ps.setString(7, data.getContainerBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<PkgReelContainer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PkgReelContainer data : dataList) {
        ps.setString(1, data.getReelSeq());
        ps.setString(2, data.getType());
        ps.setString(3, data.getMemo());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setBigDecimal(6, data.getSeq());
        ps.setString(7, data.getContainerBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String containerBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_reel_container WHERE container_bo=?")) {
      ps.setString(1, containerBo);

      return ps.executeUpdate();
    }
  }

  public List<PkgReelContainer> selectAll() throws SQLException {
    ArrayList<PkgReelContainer> result = new ArrayList<PkgReelContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PkgReelContainer selectByPK(String containerBo) throws SQLException {
    PkgReelContainer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE container_bo=?")) {
      ps.setString(1, containerBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgReelContainer selectByReelSeq(String reeId) throws SQLException {
    PkgReelContainer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE REEL_SEQ=?")) {
      ps.setString(1, reeId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgReelContainer convert(ResultSet rs) throws SQLException {
    PkgReelContainer data = new PkgReelContainer();

    int index = 1;
    data.setContainerBo(rs.getString(index++));
    data.setReelSeq(rs.getString(index++));
    data.setType(rs.getString(index++));
    data.setMemo(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setSeq(rs.getBigDecimal(index++));

    return data;
  }
}
