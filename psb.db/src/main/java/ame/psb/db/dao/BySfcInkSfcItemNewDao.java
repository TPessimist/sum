package ame.psb.db.dao;

import ame.psb.db.BySfcInkSfcItemNew;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class BySfcInkSfcItemNewDao {

  private static final String SQL_INS = "INSERT INTO zd_by_sfc_ink_sfc_item_new(id,customer_item_bo,binmap_rule_bo,sequence,ink_rule_name,ink_config_json,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_by_sfc_ink_sfc_item_new SET customer_item_bo=?,binmap_rule_bo=?,sequence=?,ink_rule_name=?,ink_config_json=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,customer_item_bo,binmap_rule_bo,sequence,ink_rule_name,ink_config_json,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_by_sfc_ink_sfc_item_new ";

  private final Connection conn;

  public BySfcInkSfcItemNewDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BySfcInkSfcItemNew data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getCustomerItemBo());
      ps.setString(3, data.getBinmapRuleBo());
      ps.setBigDecimal(4, data.getSequence());
      ps.setString(5, data.getInkRuleName());
      ps.setString(6, data.getInkConfigJson());
      ps.setString(7, data.getReversedField1());
      ps.setString(8, data.getReversedField2());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BySfcInkSfcItemNew> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BySfcInkSfcItemNew data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getCustomerItemBo());
        ps.setString(3, data.getBinmapRuleBo());
        ps.setBigDecimal(4, data.getSequence());
        ps.setString(5, data.getInkRuleName());
        ps.setString(6, data.getInkConfigJson());
        ps.setString(7, data.getReversedField1());
        ps.setString(8, data.getReversedField2());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BySfcInkSfcItemNew data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getBinmapRuleBo());
      ps.setBigDecimal(3, data.getSequence());
      ps.setString(4, data.getInkRuleName());
      ps.setString(5, data.getInkConfigJson());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<BySfcInkSfcItemNew> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BySfcInkSfcItemNew data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getBinmapRuleBo());
        ps.setBigDecimal(3, data.getSequence());
        ps.setString(4, data.getInkRuleName());
        ps.setString(5, data.getInkConfigJson());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_by_sfc_ink_sfc_item_new WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<BySfcInkSfcItemNew> selectAll() throws SQLException {
    ArrayList<BySfcInkSfcItemNew> result = new ArrayList<BySfcInkSfcItemNew>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public BySfcInkSfcItemNew selectByPK(String id) throws SQLException {
    BySfcInkSfcItemNew result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public  List<BySfcInkSfcItemNew>  selectByByCustomerItemBoAndMaoRuleBoAndInkRuleName(String customerItemBo, String mapRuleBo, String inkRuleName) throws SQLException {
    ArrayList<BySfcInkSfcItemNew> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE CUSTOMER_ITEM_BO = ? AND BINMAP_RULE_BO = ? AND INK_RULE_NAME = ? and REVERSED_FIELD2 = 'ENABLE' ")) {
      ps.setString(1,customerItemBo);
      ps.setString(2,mapRuleBo);
      ps.setString(3,inkRuleName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<BySfcInkSfcItemNew> selectByCustomerCustomerItemBo(String customerItemBo) throws SQLException {
    ArrayList<BySfcInkSfcItemNew> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where CUSTOMER_ITEM_BO = ?")) {
        ps.setString(1, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }



  public List<BySfcInkSfcItemNew> selectByCustomerCustomerItemBoAndState(String customerItemBo, String state) throws SQLException {
    ArrayList<BySfcInkSfcItemNew> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where CUSTOMER_ITEM_BO = ? and REVERSED_FIELD2 = ?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, state);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<BySfcInkSfcItemNew> selectByCustomerCustomerItemBoAndBinMapRuleBoAndState(String customerItemBo, String binMapRuleBo,  String state) throws SQLException {
    ArrayList<BySfcInkSfcItemNew> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where CUSTOMER_ITEM_BO = ? and BINMAP_RULE_BO = ? and REVERSED_FIELD2 = ?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, binMapRuleBo);
      ps.setString(3, state);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private BySfcInkSfcItemNew convert(ResultSet rs) throws SQLException {
    BySfcInkSfcItemNew data = new BySfcInkSfcItemNew();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setBinmapRuleBo(rs.getString(index++));
    data.setSequence(rs.getBigDecimal(index++));
    data.setInkRuleName(rs.getString(index++));
    data.setInkConfigJson(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
