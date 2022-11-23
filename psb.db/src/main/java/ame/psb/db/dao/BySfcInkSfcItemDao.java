package ame.psb.db.dao;

import ame.psb.db.BySfcInkSfcItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class BySfcInkSfcItemDao {

  private static final String SQL_INS = "INSERT INTO zd_by_sfc_ink_sfc_item(id,sfc_name,map_rule_name,ink_rule_name,by_sfc_ink,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_by_sfc_ink_sfc_item SET sfc_name=?,by_sfc_ink=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=? AND map_rule_name=? AND ink_rule_name=?";

  private static final String SQL_SEL = "SELECT id,sfc_name,map_rule_name,ink_rule_name,by_sfc_ink,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_by_sfc_ink_sfc_item ";

  private final Connection conn;

  public BySfcInkSfcItemDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BySfcInkSfcItem data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcName());
      ps.setString(3, data.getMapRuleName());
      ps.setString(4, data.getInkRuleName());
      ps.setString(5, data.getBySfcInk());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BySfcInkSfcItem> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BySfcInkSfcItem data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfcName());
        ps.setString(3, data.getMapRuleName());
        ps.setString(4, data.getInkRuleName());
        ps.setString(5, data.getBySfcInk());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BySfcInkSfcItem data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcName());
      ps.setString(2, data.getBySfcInk());
      ps.setString(3, data.getReversedField1());
      ps.setString(4, data.getReversedField2());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getId());
      ps.setString(8, data.getMapRuleName());
      ps.setString(9, data.getInkRuleName());

      return ps.executeUpdate();
    }
  }

  public int update(List<BySfcInkSfcItem> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BySfcInkSfcItem data : dataList) {
        ps.setString(1, data.getSfcName());
        ps.setString(2, data.getBySfcInk());
        ps.setString(3, data.getReversedField1());
        ps.setString(4, data.getReversedField2());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getId());
        ps.setString(8, data.getMapRuleName());
        ps.setString(9, data.getInkRuleName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id, String mapRuleName, String inkRuleName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_by_sfc_ink_sfc_item WHERE id=? AND map_rule_name=? AND ink_rule_name=?")) {
      ps.setString(1, id);
      ps.setString(2, mapRuleName);
      ps.setString(3, inkRuleName);

      return ps.executeUpdate();
    }
  }

  public List<BySfcInkSfcItem> selectAll() throws SQLException {
    ArrayList<BySfcInkSfcItem> result = new ArrayList<BySfcInkSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<BySfcInkSfcItem> selectById(String id) throws SQLException {
    ArrayList<BySfcInkSfcItem> result = new ArrayList<BySfcInkSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where id = ? ")) {
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public BySfcInkSfcItem selectByPK(String id, String mapRuleName, String inkRuleName)
      throws SQLException {
    BySfcInkSfcItem result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id=? AND map_rule_name=? AND ink_rule_name=?")) {
      ps.setString(1, id);
      ps.setString(2, mapRuleName);
      ps.setString(3, inkRuleName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private BySfcInkSfcItem convert(ResultSet rs) throws SQLException {
    BySfcInkSfcItem data = new BySfcInkSfcItem();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setMapRuleName(rs.getString(index++));
    data.setInkRuleName(rs.getString(index++));
    data.setBySfcInk(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
