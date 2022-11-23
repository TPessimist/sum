package ame.psb.db.dao;

import ame.psb.db.BinMapGoodDieDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.Where;

public class BinMapGoodDieDefDao {

  private static final String SQL_INS = "INSERT INTO zd_binmap_good_die_def(id,binmap_rule_bo,sequence,value,grade) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_binmap_good_die_def SET binmap_rule_bo=?,sequence=?,value=?,grade=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,binmap_rule_bo,sequence,value,grade FROM zd_binmap_good_die_def ";

  private final Connection conn;

  public BinMapGoodDieDefDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BinMapGoodDieDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getBinmapRuleBo());
      ps.setInt(3, data.getSequence());
      ps.setString(4, data.getValue());
      ps.setString(5, data.getGrade());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BinMapGoodDieDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BinMapGoodDieDef data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getBinmapRuleBo());
        ps.setInt(3, data.getSequence());
        ps.setString(4, data.getValue());
        ps.setString(5, data.getGrade());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BinMapGoodDieDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getBinmapRuleBo());
      ps.setInt(2, data.getSequence());
      ps.setString(3, data.getValue());
      ps.setString(4, data.getGrade());
      ps.setString(5, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<BinMapGoodDieDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BinMapGoodDieDef data : dataList) {
        ps.setString(1, data.getBinmapRuleBo());
        ps.setInt(2, data.getSequence());
        ps.setString(3, data.getValue());
        ps.setString(4, data.getGrade());
        ps.setString(5, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_binmap_good_die_def WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByRule(String ruleName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_binmap_good_die_def WHERE binmap_rule_bo=?")) {
      ps.setString(1, ruleName);

      return ps.executeUpdate();
    }
  }

  public List<BinMapGoodDieDef> selectAll() throws SQLException {
    ArrayList<BinMapGoodDieDef> result = new ArrayList<BinMapGoodDieDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public BinMapGoodDieDef selectByPK(String id) throws SQLException {
    BinMapGoodDieDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<BinMapGoodDieDef> selectByRule(String rule_bo) throws SQLException {
    ArrayList<BinMapGoodDieDef> result = new ArrayList<BinMapGoodDieDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE binmap_rule_bo=?")) {
      ps.setString(1, rule_bo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private BinMapGoodDieDef convert(ResultSet rs) throws SQLException {
    BinMapGoodDieDef data = new BinMapGoodDieDef();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setBinmapRuleBo(rs.getString(index++));
    data.setSequence(rs.getInt(index++));
    data.setValue(rs.getString(index++));
    data.setGrade(rs.getString(index++));

    return data;
  }

  public List<BinMapGoodDieDef> select(Where where) throws SQLException {
    List<BinMapGoodDieDef> list = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convert(rs));
      }
      return list;
    }
  }
}
