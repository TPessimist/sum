package ame.psb.db.dao;

import ame.psb.db.BinMapBadDieDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.Where;

public class BinMapBadDieDefDao {

  private static final String SQL_INS = "INSERT INTO zd_binmap_bad_die_def(id,binmap_rule_bo,sequence,value,deffect_code,non_recyclable) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_binmap_bad_die_def SET binmap_rule_bo=?,sequence=?,value=?,deffect_code=?,non_recyclable=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,binmap_rule_bo,sequence,value,deffect_code,non_recyclable FROM zd_binmap_bad_die_def ";

  private final Connection conn;

  public BinMapBadDieDefDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BinMapBadDieDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getBinmapRuleBo());
      ps.setInt(3, data.getSequence());
      ps.setString(4, data.getValue());
      ps.setString(5, data.getDeffectCode());
      ps.setString(6, data.getNonRecyclable());
      return ps.executeUpdate();
    }
  }

  public int insert(List<BinMapBadDieDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BinMapBadDieDef data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getBinmapRuleBo());
        ps.setInt(3, data.getSequence());
        ps.setString(4, data.getValue());
        ps.setString(5, data.getDeffectCode());
        ps.setString(6, data.getNonRecyclable());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BinMapBadDieDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getBinmapRuleBo());
      ps.setInt(2, data.getSequence());
      ps.setString(3, data.getValue());
      ps.setString(4, data.getDeffectCode());
      ps.setString(5, data.getNonRecyclable());
      ps.setString(6, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<BinMapBadDieDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BinMapBadDieDef data : dataList) {
        ps.setString(1, data.getBinmapRuleBo());
        ps.setInt(2, data.getSequence());
        ps.setString(3, data.getValue());
        ps.setString(4, data.getDeffectCode());
        ps.setString(5, data.getNonRecyclable());
        ps.setString(6, data.getId());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_binmap_bad_die_def WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByRule(String ruleName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_binmap_bad_die_def WHERE binmap_rule_bo=?")) {
      ps.setString(1, ruleName);

      return ps.executeUpdate();
    }
  }

  public List<BinMapBadDieDef> selectAll() throws SQLException {
    ArrayList<BinMapBadDieDef> result = new ArrayList<BinMapBadDieDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public BinMapBadDieDef selectByPK(String id) throws SQLException {
    BinMapBadDieDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<BinMapBadDieDef> selectByRule(String rule_bo) throws SQLException {
    ArrayList<BinMapBadDieDef> result = new ArrayList<BinMapBadDieDef>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE binmap_rule_bo=?  ORDER BY \"SEQUENCE\" ")) {
      ps.setString(1, rule_bo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private BinMapBadDieDef convert(ResultSet rs) throws SQLException {
    BinMapBadDieDef data = new BinMapBadDieDef();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setBinmapRuleBo(rs.getString(index++));
    data.setSequence(rs.getInt(index++));
    data.setValue(rs.getString(index++));
    data.setDeffectCode(rs.getString(index++));
    data.setNonRecyclable(rs.getString(index++));

    return data;
  }

  public List<BinMapBadDieDef> select(Where where) throws SQLException {
    List<BinMapBadDieDef> list = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convert(rs));
      }
      return list;
    }
  }
}
