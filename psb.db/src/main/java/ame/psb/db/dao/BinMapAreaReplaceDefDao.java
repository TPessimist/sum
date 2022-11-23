package ame.psb.db.dao;

import ame.psb.db.BinMapAreaReplaceDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.Where;

public class BinMapAreaReplaceDefDao {

  private static final String SQL_INS = "INSERT INTO zd_binmap_area_replace_def(id,binmap_rule_bo,sequence,area_symbol,old_symbol,new_symbol) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_binmap_area_replace_def SET binmap_rule_bo=?,sequence=?,area_symbol=?,old_symbol=?,new_symbol=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,binmap_rule_bo,sequence,area_symbol,old_symbol,new_symbol FROM zd_binmap_area_replace_def ";

  private final Connection conn;

  public BinMapAreaReplaceDefDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BinMapAreaReplaceDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getBinmapRuleBo());
      ps.setInt(3, data.getSequence());
      ps.setString(4, data.getAreaSymbol());
      ps.setString(5, data.getOldSymbol());
      ps.setString(6, data.getNewSymbol());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BinMapAreaReplaceDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BinMapAreaReplaceDef data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getBinmapRuleBo());
        ps.setInt(3, data.getSequence());
        ps.setString(4, data.getAreaSymbol());
        ps.setString(5, data.getOldSymbol());
        ps.setString(6, data.getNewSymbol());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BinMapAreaReplaceDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getBinmapRuleBo());
      ps.setInt(2, data.getSequence());
      ps.setString(3, data.getAreaSymbol());
      ps.setString(4, data.getOldSymbol());
      ps.setString(5, data.getNewSymbol());
      ps.setString(6, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<BinMapAreaReplaceDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BinMapAreaReplaceDef data : dataList) {
        ps.setString(1, data.getBinmapRuleBo());
        ps.setInt(2, data.getSequence());
        ps.setString(3, data.getAreaSymbol());
        ps.setString(4, data.getOldSymbol());
        ps.setString(5, data.getNewSymbol());
        ps.setString(6, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_binmap_area_replace_def WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByRule(String ruleBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_binmap_area_replace_def WHERE binmap_rule_bo=?")) {
      ps.setString(1, ruleBo);

      return ps.executeUpdate();
    }
  }

  public List<BinMapAreaReplaceDef> selectAll() throws SQLException {
    ArrayList<BinMapAreaReplaceDef> result = new ArrayList<BinMapAreaReplaceDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<BinMapAreaReplaceDef> selectByRule(String ruleBo) throws SQLException {
    ArrayList<BinMapAreaReplaceDef> result = new ArrayList<BinMapAreaReplaceDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE binmap_rule_bo=? ")) {
      ps.setString(1, ruleBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public BinMapAreaReplaceDef selectByPK(String id) throws SQLException {
    BinMapAreaReplaceDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private BinMapAreaReplaceDef convert(ResultSet rs) throws SQLException {
    BinMapAreaReplaceDef data = new BinMapAreaReplaceDef();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setBinmapRuleBo(rs.getString(index++));
    data.setSequence(rs.getInt(index++));
    data.setAreaSymbol(rs.getString(index++));
    data.setOldSymbol(rs.getString(index++));
    data.setNewSymbol(rs.getString(index++));

    return data;
  }

  public List<BinMapAreaReplaceDef> select(Where where) throws SQLException {
    List<BinMapAreaReplaceDef> list = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convert(rs));
      }
      return list;
    }
  }
}
