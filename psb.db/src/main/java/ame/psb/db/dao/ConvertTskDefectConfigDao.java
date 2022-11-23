package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ConvertTskDefectConfig;

public class ConvertTskDefectConfigDao {

  private static final String SQL_INS = "INSERT INTO zd_convert_tsk_defect_config(id,convert_id,binmap_rule_bo,symbol,defect,convert_symbol,convert_defect) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_convert_tsk_defect_config SET convert_id=?,binmap_rule_bo=?,symbol=?,defect=?,convert_symbol=?,convert_defect=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,convert_id,binmap_rule_bo,symbol,defect,convert_symbol,convert_defect FROM zd_convert_tsk_defect_config ";

  private final Connection conn;

  public ConvertTskDefectConfigDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ConvertTskDefectConfig data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getConvertId());
      ps.setString(3, data.getBinmapRuleBo());
      ps.setString(4, data.getSymbol());
      ps.setInt(5, data.getDefect());
      ps.setString(6, data.getConvertSymbol());
      ps.setInt(7, data.getConvertDefect());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ConvertTskDefectConfig> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ConvertTskDefectConfig data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getConvertId());
        ps.setString(3, data.getBinmapRuleBo());
        ps.setString(4, data.getSymbol());
        ps.setInt(5, data.getDefect());
        ps.setString(6, data.getConvertSymbol());
        ps.setInt(7, data.getConvertDefect());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ConvertTskDefectConfig data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getConvertId());
      ps.setString(2, data.getBinmapRuleBo());
      ps.setString(3, data.getSymbol());
      ps.setInt(4, data.getDefect());
      ps.setString(5, data.getConvertSymbol());
      ps.setInt(6, data.getConvertDefect());
      ps.setString(7, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ConvertTskDefectConfig> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ConvertTskDefectConfig data : dataList) {
        ps.setString(1, data.getConvertId());
        ps.setString(2, data.getBinmapRuleBo());
        ps.setString(3, data.getSymbol());
        ps.setInt(4, data.getDefect());
        ps.setString(5, data.getConvertSymbol());
        ps.setInt(6, data.getConvertDefect());
        ps.setString(7, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_convert_tsk_defect_config WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByConvertId(String convertId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_convert_tsk_defect_config WHERE convert_id=?")) {
      ps.setString(1, convertId);

      return ps.executeUpdate();
    }
  }

  public List<ConvertTskDefectConfig> selectAll() throws SQLException {
    ArrayList<ConvertTskDefectConfig> result = new ArrayList<ConvertTskDefectConfig>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ConvertTskDefectConfig> selectByConvertId(String convertId) throws SQLException {
    ArrayList<ConvertTskDefectConfig> result = new ArrayList<ConvertTskDefectConfig>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE convert_id=?")) {
      ps.setString(1, convertId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ConvertTskDefectConfig selectByPK(String id) throws SQLException {
    ConvertTskDefectConfig result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ConvertTskDefectConfig convert(ResultSet rs) throws SQLException {
    ConvertTskDefectConfig data = new ConvertTskDefectConfig();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setConvertId(rs.getString(index++));
    data.setBinmapRuleBo(rs.getString(index++));
    data.setSymbol(rs.getString(index++));
    data.setDefect(rs.getInt(index++));
    data.setConvertSymbol(rs.getString(index++));
    data.setConvertDefect(rs.getInt(index++));

    return data;
  }
}
