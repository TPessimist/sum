package ame.psb.db.dao;

import ame.psb.db.BadDieManageDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class BadDieManageDefDao {

  private static final String SQL_INS = "INSERT INTO zd_binmap_bad_die_manage_def(id,binmap_rule_bo,deffect_code,non_recyclable,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_binmap_bad_die_manage_def SET binmap_rule_bo=?,deffect_code=?,non_recyclable=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,binmap_rule_bo,deffect_code,non_recyclable,updated_user,updated_time FROM zd_binmap_bad_die_manage_def ";

  private final Connection conn;

  public BadDieManageDefDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BadDieManageDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getBinmapRuleBo());
      ps.setString(3, data.getDeffectCode());
      ps.setString(4, data.getNonRecyclable());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BadDieManageDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BadDieManageDef data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getBinmapRuleBo());
        ps.setString(3, data.getDeffectCode());
        ps.setString(4, data.getNonRecyclable());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BadDieManageDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getBinmapRuleBo());
      ps.setString(2, data.getDeffectCode());
      ps.setString(3, data.getNonRecyclable());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<BadDieManageDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BadDieManageDef data : dataList) {
        ps.setString(1, data.getBinmapRuleBo());
        ps.setString(2, data.getDeffectCode());
        ps.setString(3, data.getNonRecyclable());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_binmap_bad_die_manage_def WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByMapRuleBo(String mapRuleBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_binmap_bad_die_manage_def WHERE binmap_rule_bo=?")) {
      ps.setString(1, mapRuleBo);

      return ps.executeUpdate();
    }
  }

  public List<BadDieManageDef> selectAll() throws SQLException {
    ArrayList<BadDieManageDef> result = new ArrayList<BadDieManageDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public BadDieManageDef selectByPK(String id) throws SQLException {
    BadDieManageDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<BadDieManageDef> selectByRule(String binmapRuleBo) throws SQLException {
    ArrayList<BadDieManageDef> result = new ArrayList<BadDieManageDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE binmap_rule_bo=?")) {
      ps.setString(1, binmapRuleBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public BadDieManageDef selectDefValue(String binmapRuleBo, String deffectCode)
      throws SQLException {
    BadDieManageDef result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE binmap_rule_bo=? AND deffect_code=?")) {
      ps.setString(1, binmapRuleBo);
      ps.setString(2, deffectCode);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private BadDieManageDef convert(ResultSet rs) throws SQLException {
    BadDieManageDef data = new BadDieManageDef();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setBinmapRuleBo(rs.getString(index++));
    data.setDeffectCode(rs.getString(index++));
    data.setNonRecyclable(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    return data;
  }

  public List<BadDieManageDef> select(Where where) throws SQLException {
    List<BadDieManageDef> list = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convert(rs));
      }
      return list;
    }
  }
}
