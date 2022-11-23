package ame.psb.db.dao;

import ame.psb.db.BinMapInvalidDieDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.Where;

public class BinMapInvalidDieDefDao {

  private static final String SQL_INS = "INSERT INTO zd_binmap_invalid_die_def(id,binmap_rule_bo,sequence,value) VALUES (?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_binmap_invalid_die_def SET binmap_rule_bo=?,sequence=?,value=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,binmap_rule_bo,sequence,value FROM zd_binmap_invalid_die_def ";

  private final Connection conn;

  public BinMapInvalidDieDefDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BinMapInvalidDieDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getBinmapRuleBo());
      ps.setInt(3, data.getSequence());
      ps.setString(4, data.getValue());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BinMapInvalidDieDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BinMapInvalidDieDef data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getBinmapRuleBo());
        ps.setInt(3, data.getSequence());
        ps.setString(4, data.getValue());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BinMapInvalidDieDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getBinmapRuleBo());
      ps.setInt(2, data.getSequence());
      ps.setString(3, data.getValue());
      ps.setString(4, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<BinMapInvalidDieDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BinMapInvalidDieDef data : dataList) {
        ps.setString(1, data.getBinmapRuleBo());
        ps.setInt(2, data.getSequence());
        ps.setString(3, data.getValue());
        ps.setString(4, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_binmap_invalid_die_def WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByRule(String ruleName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_binmap_invalid_die_def WHERE binmap_rule_bo=?")) {
      ps.setString(1, ruleName);

      return ps.executeUpdate();
    }
  }

  public List<BinMapInvalidDieDef> selectAll() throws SQLException {
    ArrayList<BinMapInvalidDieDef> result = new ArrayList<BinMapInvalidDieDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public BinMapInvalidDieDef selectByPK(String id) throws SQLException {
    BinMapInvalidDieDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<BinMapInvalidDieDef> selectByRule(String rule_bo) throws SQLException {
    ArrayList<BinMapInvalidDieDef> result = new ArrayList<BinMapInvalidDieDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE binmap_rule_bo=?")) {
      ps.setString(1, rule_bo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private BinMapInvalidDieDef convert(ResultSet rs) throws SQLException {
    BinMapInvalidDieDef data = new BinMapInvalidDieDef();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setBinmapRuleBo(rs.getString(index++));
    data.setSequence(rs.getInt(index++));
    data.setValue(rs.getString(index++));

    return data;
  }

  public List<BinMapInvalidDieDef> select(Where where) throws SQLException {
    List<BinMapInvalidDieDef> list = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convert(rs));
      }
      return list;
    }
  }
}