package ame.psb.db.dao;

import ame.psb.db.HoldReleaseSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoldReleaseSfcDao {

  private static final String SQL_INS = "INSERT INTO zr_hold_release_sfc(hold_release_bo,sfc_bo,action_name,result_router_bo) VALUES (?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_hold_release_sfc SET action_name=?,result_router_bo=? WHERE hold_release_bo=? AND sfc_bo=?";

  private static final String SQL_SEL = "SELECT hold_release_bo,sfc_bo,action_name,result_router_bo FROM zr_hold_release_sfc ";

  private final Connection conn;

  public HoldReleaseSfcDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(HoldReleaseSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHoldReleaseBo());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getActionName());
      ps.setString(4, data.getResultRouterBo());

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_hold_release_sfc WHERE hold_release_bo=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int update(HoldReleaseSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getActionName());
      ps.setString(2, data.getResultRouterBo());
      ps.setString(3, data.getHoldReleaseBo());
      ps.setString(4, data.getSfcBo());

      return ps.executeUpdate();
    }
  }

  public List<HoldReleaseSfc> selectAll() throws SQLException {
    ArrayList<HoldReleaseSfc> result = new ArrayList<HoldReleaseSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<HoldReleaseSfc> selectByRelease(String holdReleaseBo) throws SQLException {
    ArrayList<HoldReleaseSfc> result = new ArrayList<HoldReleaseSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE hold_release_bo=?")) {
      ps.setString(1, holdReleaseBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public HoldReleaseSfc selectByReleaseAndSfc(String releaseBo, String sfcBo) throws SQLException {
    HoldReleaseSfc result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE hold_release_bo=? AND sfc_bo=?")) {
      ps.setString(1, releaseBo);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<HoldReleaseSfc> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<HoldReleaseSfc> result = new ArrayList<HoldReleaseSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private HoldReleaseSfc convert(ResultSet rs) throws SQLException {
    HoldReleaseSfc data = new HoldReleaseSfc();

    data.setHoldReleaseBo(rs.getString(1));
    data.setSfcBo(rs.getString(2));
    data.setActionName(rs.getString(3));
    data.setResultRouterBo(rs.getString(4));

    return data;
  }
}