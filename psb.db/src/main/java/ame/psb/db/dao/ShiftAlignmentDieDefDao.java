package ame.psb.db.dao;

import ame.psb.db.ShiftAlignmentDieDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.Where;

public class ShiftAlignmentDieDefDao {

  private static final String SQL_INS = "INSERT INTO zd_shift_alignment_die_def(id,binmap_rule_bo,sequence,x_coordinate,y_coordinate,value) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_shift_alignment_die_def SET binmap_rule_bo=?,sequence=?,x_coordinate=?,y_coordinate=?,value=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,binmap_rule_bo,sequence,x_coordinate,y_coordinate,value FROM zd_shift_alignment_die_def ";

  private final Connection conn;

  public ShiftAlignmentDieDefDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ShiftAlignmentDieDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getBinmapRuleBo());
      ps.setInt(3, data.getSequence());
      ps.setInt(4, data.getxCoordinate());
      ps.setInt(5, data.getyCoordinate());
      ps.setString(6, data.getValue());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ShiftAlignmentDieDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ShiftAlignmentDieDef data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getBinmapRuleBo());
        ps.setInt(3, data.getSequence());
        ps.setInt(4, data.getxCoordinate());
        ps.setInt(5, data.getyCoordinate());
        ps.setString(6, data.getValue());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ShiftAlignmentDieDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getBinmapRuleBo());
      ps.setInt(2, data.getSequence());
      ps.setInt(3, data.getxCoordinate());
      ps.setInt(4, data.getyCoordinate());
      ps.setString(5, data.getValue());
      ps.setString(6, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ShiftAlignmentDieDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ShiftAlignmentDieDef data : dataList) {
        ps.setString(1, data.getBinmapRuleBo());
        ps.setInt(2, data.getSequence());
        ps.setInt(3, data.getxCoordinate());
        ps.setInt(4, data.getyCoordinate());
        ps.setString(5, data.getValue());
        ps.setString(6, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_shift_alignment_die_def WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByRule(String ruleName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_shift_alignment_die_def WHERE binmap_rule_bo=?")) {
      ps.setString(1, ruleName);

      return ps.executeUpdate();
    }
  }

  public List<ShiftAlignmentDieDef> selectAll() throws SQLException {
    ArrayList<ShiftAlignmentDieDef> result = new ArrayList<ShiftAlignmentDieDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ShiftAlignmentDieDef selectByPK(String id) throws SQLException {
    ShiftAlignmentDieDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ShiftAlignmentDieDef> selectByRule(String ruleName) throws SQLException {
    ArrayList<ShiftAlignmentDieDef> result = new ArrayList<ShiftAlignmentDieDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE binmap_rule_bo=?")) {
      ps.setString(1, ruleName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ShiftAlignmentDieDef> select(Where where) throws SQLException {
    List<ShiftAlignmentDieDef> list = new ArrayList<ShiftAlignmentDieDef>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convert(rs));
      }
      return list;
    }
  }

  private ShiftAlignmentDieDef convert(ResultSet rs) throws SQLException {
    ShiftAlignmentDieDef data = new ShiftAlignmentDieDef();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setBinmapRuleBo(rs.getString(index++));
    data.setSequence(rs.getInt(index++));
    data.setxCoordinate(rs.getInt(index++));
    data.setyCoordinate(rs.getInt(index++));
    data.setValue(rs.getString(index++));

    return data;
  }


}
