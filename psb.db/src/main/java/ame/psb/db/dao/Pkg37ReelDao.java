package ame.psb.db.dao;

import ame.psb.db.Pkg37Reel;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class Pkg37ReelDao {

  private static final String SQL_UPD_STATE = "UPDATE zr_pkg_37_reel SET state_name=?  WHERE reel_id=?  ";

  private static final String SQL_INS = "INSERT INTO zr_pkg_37_reel(reel_id,sfc_bo,state_name,job_id,reel_seq,die_qty,resource_bo,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_pkg_37_reel SET state_name=?,job_id=?,reel_seq=?,die_qty=?,resource_bo=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE reel_id=? AND sfc_bo=?";

  private static final String SQL_SEL = "SELECT reel_id,sfc_bo,state_name,job_id,reel_seq,die_qty,resource_bo,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_pkg_37_reel ";

  private final Connection conn;

  public Pkg37ReelDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Pkg37Reel data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getReelId());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getJobId());
      ps.setBigDecimal(5, data.getReelSeq());
      ps.setBigDecimal(6, data.getDieQty());
      ps.setString(7, data.getResourceBo());
      ps.setString(8, data.getReversedField1());
      ps.setString(9, data.getReversedField2());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Pkg37Reel> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Pkg37Reel data : dataList) {
        ps.setString(1, data.getReelId());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getStateName());
        ps.setString(4, data.getJobId());
        ps.setBigDecimal(5, data.getReelSeq());
        ps.setBigDecimal(6, data.getDieQty());
        ps.setString(7, data.getResourceBo());
        ps.setString(8, data.getReversedField1());
        ps.setString(9, data.getReversedField2());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Pkg37Reel data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getStateName());
      ps.setString(2, data.getJobId());
      ps.setBigDecimal(3, data.getReelSeq());
      ps.setBigDecimal(4, data.getDieQty());
      ps.setString(5, data.getResourceBo());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getReelId());
      ps.setString(11, data.getSfcBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<Pkg37Reel> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Pkg37Reel data : dataList) {
        ps.setString(1, data.getStateName());
        ps.setString(2, data.getJobId());
        ps.setBigDecimal(3, data.getReelSeq());
        ps.setBigDecimal(4, data.getDieQty());
        ps.setString(5, data.getResourceBo());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getReelId());
        ps.setString(11, data.getSfcBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }


  public int updateState(Pkg37Reel data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_STATE)) {
      ps.setString(1, data.getStateName());
      ps.setString(2, data.getReelId());

      return ps.executeUpdate();
    }
  }

  public void changeState(Pkg37Reel pkg37Reel) throws SQLException {
    updateState(pkg37Reel);
  }

  public int delete(String reelId, String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_37_reel WHERE reel_id=? AND sfc_bo=?")) {
      ps.setString(1, reelId);
      ps.setString(2, sfcBo);

      return ps.executeUpdate();
    }
  }

  public int updateContainer(String Container) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "UPDATE zr_pkg_37_reel SET reversed_field1 = NULL WHERE reversed_field1=?")) {
      ps.setString(1, Container);

      return ps.executeUpdate();
    }
  }

  public List<Pkg37Reel> selectAll() throws SQLException {
    ArrayList<Pkg37Reel> result = new ArrayList<Pkg37Reel>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Pkg37Reel> selectByReelId(String reelId) throws SQLException {
    ArrayList<Pkg37Reel> result = new ArrayList<Pkg37Reel>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where reel_id = ?")) {
      ps.setString(1, reelId);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Pkg37Reel selectByPK(String reelId, String sfcBo) throws SQLException {
    Pkg37Reel result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE reel_id=? AND sfc_bo=?")) {
      ps.setString(1, reelId);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public Pkg37Reel selectBySfcBoLastReel(String sfcBo) throws SQLException {
    Pkg37Reel result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? ORDER  BY reel_seq DESC ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public Pkg37Reel selectLastReelNotBatch(String sfcBo) throws SQLException {
    Pkg37Reel result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE sfc_bo=? AND state_name !='CHANGED_LABEL_STATE' ORDER BY reel_seq DESC ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public List<Pkg37Reel> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<Pkg37Reel> result = new ArrayList<Pkg37Reel>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where sfc_bo = ? order by reel_id")) {
      ps.setString(1, sfcBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Pkg37Reel> selectBySfcAndState(String sfcBo) throws SQLException {
    ArrayList<Pkg37Reel> result = new ArrayList<Pkg37Reel>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " where sfc_bo = ? and state_name not in('REPLACED','SCRAP_STATE') order by reel_id")) {
      ps.setString(1, sfcBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Pkg37Reel> selectBySfcState(String sfcBo) throws SQLException {
    ArrayList<Pkg37Reel> result = new ArrayList<Pkg37Reel>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " where sfc_bo = ? and (state_name = 'UNLOAD_STATE' or state_name = 'CHANGED_LABEL_STATE') order by reel_id ,reel_seq ")) {
      ps.setString(1, sfcBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public Pkg37Reel selectByReel(String reelId) throws SQLException {
    Pkg37Reel result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where reel_id = ?")) {
      ps.setString(1, reelId);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<Pkg37Reel> selectBySfcAndSeq(String sfcBo, BigDecimal reelSeq) throws SQLException {
    ArrayList<Pkg37Reel> result = new ArrayList<Pkg37Reel>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " where sfc_bo=? and reel_seq > ? and state_name not in('SCRAP_STATE','CHANGED_LABEL_STATE') ")) {
      ps.setString(1, sfcBo);
      ps.setBigDecimal(2, reelSeq);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Pkg37Reel> selectByStateName(String stateName, String sfcBo) throws SQLException {
    ArrayList<Pkg37Reel> result = new ArrayList<Pkg37Reel>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where state_name = ? and sfc_bo = ? ")) {
      ps.setString(1, stateName);
      ps.setString(2, sfcBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public Pkg37Reel selectByContainer(String containerBo) throws SQLException { //根据容器查询
    Pkg37Reel result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where reversed_field1 = ?")) {
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private Pkg37Reel convert(ResultSet rs) throws SQLException {
    Pkg37Reel data = new Pkg37Reel();

    int index = 1;
    data.setReelId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setJobId(rs.getString(index++));
    data.setReelSeq(rs.getBigDecimal(index++));
    data.setDieQty(rs.getBigDecimal(index++));
    data.setResourceBo(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
