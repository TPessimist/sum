package ame.psb.db.dao;

import ame.psb.db.BinMapInkRuleDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.Where;

public class BinMapInkRuleDefDao {

  private static final String SQL_INS = "INSERT INTO zd_binmap_ink_rule_def(id,binmap_rule_bo,sequence,ink_config_class,config_json) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_binmap_ink_rule_def SET binmap_rule_bo=?,sequence=?,ink_config_class=?,config_json=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,binmap_rule_bo,sequence,ink_config_class,config_json FROM zd_binmap_ink_rule_def ";

  private final Connection conn;

  public BinMapInkRuleDefDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BinMapInkRuleDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getBinmapRuleBo());
      ps.setInt(3, data.getSequence());
      ps.setString(4, data.getInkConfigClass());
      ps.setString(5, data.getConfigJson());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BinMapInkRuleDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BinMapInkRuleDef data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getBinmapRuleBo());
        ps.setInt(3, data.getSequence());
        ps.setString(4, data.getInkConfigClass());
        ps.setString(5, data.getConfigJson());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BinMapInkRuleDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getBinmapRuleBo());
      ps.setInt(2, data.getSequence());
      ps.setString(3, data.getInkConfigClass());
      ps.setString(4, data.getConfigJson());
      ps.setString(5, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<BinMapInkRuleDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BinMapInkRuleDef data : dataList) {
        ps.setString(1, data.getBinmapRuleBo());
        ps.setInt(2, data.getSequence());
        ps.setString(3, data.getInkConfigClass());
        ps.setString(4, data.getConfigJson());
        ps.setString(5, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_binmap_ink_rule_def WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByRule(String ruleBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_binmap_ink_rule_def WHERE binmap_rule_bo=?")) {
      ps.setString(1, ruleBo);

      return ps.executeUpdate();
    }
  }

  public List<BinMapInkRuleDef> selectAll() throws SQLException {
    ArrayList<BinMapInkRuleDef> result = new ArrayList<BinMapInkRuleDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public BinMapInkRuleDef selectByPK(String id) throws SQLException {
    BinMapInkRuleDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<BinMapInkRuleDef> selectByRule(String ruleBo) throws SQLException {
    ArrayList<BinMapInkRuleDef> result = new ArrayList<BinMapInkRuleDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE binmap_rule_bo=?")) {
      ps.setString(1, ruleBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private BinMapInkRuleDef convert(ResultSet rs) throws SQLException {
    BinMapInkRuleDef data = new BinMapInkRuleDef();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setBinmapRuleBo(rs.getString(index++));
    data.setSequence(rs.getInt(index++));
    data.setInkConfigClass(rs.getString(index++));
    data.setConfigJson(rs.getString(index++));

    return data;
  }

  public List<BinMapInkRuleDef> select(Where where) throws SQLException {
    List<BinMapInkRuleDef> list = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convert(rs));
      }
      return list;
    }
  }
}
