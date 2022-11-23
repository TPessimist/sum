package ame.psb.db.dao;

import ame.psb.db.SfcMemo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SfcMemoDao {

  private static final String SQL_INS = "INSERT INTO ZR_SFC_MEMO(id,sfc_bo,sfc,created_time,owner,memo,expired_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_sfc_memo SET sfc_bo=?,sfc=?,created_time=?,owner=?,memo=?,expired_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sfc_bo,sfc,created_time,owner,memo,expired_time FROM zr_sfc_memo ";

  Connection conn;

  public SfcMemoDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SfcMemo memo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, memo.getId());
      ps.setString(2, memo.getSfcBo());
      ps.setString(3, memo.getSfc());
      DateUtils.setDateTz(ps, 4, memo.getCreatedTime());
      ps.setString(5, memo.getOwner());
      ps.setString(6, memo.getMemo());
      DateUtils.setDateTz(ps, 7, memo.getExpiredTime());

      return ps.executeUpdate();
    }
  }

  public List<SfcMemo> selectBySfcName(String sfc) throws SQLException {
    ArrayList<SfcMemo> result = new ArrayList<SfcMemo>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc=? ORDER BY created_time")) {
      ps.setString(1, sfc);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<SfcMemo> selectBySfcParent(String sfc) throws SQLException {
    ArrayList<SfcMemo> result = new ArrayList<SfcMemo>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc like ? ORDER BY created_time")) {
      ps.setString(1, sfc + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }


  public List<SfcMemo> selectByOwner(String owner) throws SQLException {
    ArrayList<SfcMemo> result = new ArrayList<SfcMemo>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE owner = ? ORDER BY created_time")) {
      ps.setString(1, owner);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public SfcMemo selectById(String id) throws SQLException {
    SfcMemo result = new SfcMemo();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id = ? ")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public SfcMemo selectBySfc(String sfc) throws SQLException {
    SfcMemo result = new SfcMemo();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc = ? ")) {
      ps.setString(1, sfc);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public SfcMemo selectBySfcBo(String sfc) throws SQLException {
    SfcMemo result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo = ? ")) {
      ps.setString(1, sfc);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public int update(SfcMemo data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getSfc());
      DateUtils.setDateTz(ps, 3, data.getCreatedTime());
      ps.setString(4, data.getOwner());
      ps.setString(5, data.getMemo());
      DateUtils.setDateTz(ps, 6, data.getExpiredTime());
      ps.setString(7, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<SfcMemo> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SfcMemo data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getSfc());
        DateUtils.setDateTz(ps, 3, data.getCreatedTime());
        ps.setString(4, data.getOwner());
        ps.setString(5, data.getMemo());
        DateUtils.setDateTz(ps, 6, data.getExpiredTime());
        ps.setString(7, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  private SfcMemo convert(ResultSet rs) throws SQLException {
    SfcMemo memo = new SfcMemo();
    memo.setId(rs.getString(1));
    memo.setSfcBo(rs.getString(2));
    memo.setSfc(rs.getString(3));
    memo.setCreatedTime(DateUtils.getDateTz(rs, 4));
    memo.setOwner(rs.getString(5));
    memo.setMemo(rs.getString(6));
    memo.setExpiredTime(DateUtils.getDateTz(rs, 7));
    return memo;
  }
}
