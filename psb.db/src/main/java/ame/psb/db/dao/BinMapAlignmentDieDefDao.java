package ame.psb.db.dao;

import ame.psb.db.BinMapAlignmentDieDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.Where;

public class BinMapAlignmentDieDefDao {

  private static final String SQL_INS = "INSERT INTO zd_binmap_alignment_die_def(id,binmap_rule_bo,sequence,x_coordinate,y_coordinate) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_binmap_alignment_die_def SET binmap_rule_bo=?,sequence=?,x_coordinate=?,y_coordinate=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,binmap_rule_bo,sequence,x_coordinate,y_coordinate FROM zd_binmap_alignment_die_def ";

  private final Connection conn;

  public BinMapAlignmentDieDefDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BinMapAlignmentDieDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getBinmapRuleBo());
      ps.setInt(3, data.getSequence());
      ps.setInt(4, data.getxCoordinate());
      ps.setInt(5, data.getyCoordinate());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BinMapAlignmentDieDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BinMapAlignmentDieDef data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getBinmapRuleBo());
        ps.setInt(3, data.getSequence());
        ps.setInt(4, data.getxCoordinate());
        ps.setInt(5, data.getyCoordinate());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BinMapAlignmentDieDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getBinmapRuleBo());
      ps.setInt(2, data.getSequence());
      ps.setInt(3, data.getxCoordinate());
      ps.setInt(4, data.getyCoordinate());
      ps.setString(5, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<BinMapAlignmentDieDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BinMapAlignmentDieDef data : dataList) {
        ps.setString(1, data.getBinmapRuleBo());
        ps.setInt(2, data.getSequence());
        ps.setInt(3, data.getxCoordinate());
        ps.setInt(4, data.getyCoordinate());
        ps.setString(5, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_binmap_alignment_die_def WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByRule(String ruleName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_binmap_alignment_die_def WHERE binmap_rule_bo=?")) {
      ps.setString(1, ruleName);

      return ps.executeUpdate();
    }
  }

  public List<BinMapAlignmentDieDef> selectAll() throws SQLException {
    ArrayList<BinMapAlignmentDieDef> result = new ArrayList<BinMapAlignmentDieDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public BinMapAlignmentDieDef selectByPK(String id) throws SQLException {
    BinMapAlignmentDieDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<BinMapAlignmentDieDef> selectByRule(String rule_bo) throws SQLException {
    ArrayList<BinMapAlignmentDieDef> result = new ArrayList<BinMapAlignmentDieDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE binmap_rule_bo=?")) {
      ps.setString(1, rule_bo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private BinMapAlignmentDieDef convert(ResultSet rs) throws SQLException {
    BinMapAlignmentDieDef data = new BinMapAlignmentDieDef();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setBinmapRuleBo(rs.getString(index++));
    data.setSequence(rs.getInt(index++));
    data.setxCoordinate(rs.getInt(index++));
    data.setyCoordinate(rs.getInt(index++));

    return data;
  }

  public List<BinMapAlignmentDieDef> select(Where where) throws SQLException {
    List<BinMapAlignmentDieDef> list = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convert(rs));
      }
      return list;
    }
  }
}
