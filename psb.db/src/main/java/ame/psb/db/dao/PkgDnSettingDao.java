package ame.psb.db.dao;

import ame.psb.db.PkgDnSetting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgDnSettingDao {

  private static final String SQL_INS = "INSERT INTO zd_pkg_dn_setting(item_group_bo,action_name,label_bo,label_tag_name,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_pkg_dn_setting SET reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE item_group_bo=? AND action_name=? AND label_bo=? AND label_tag_name=?";

  private static final String SQL_SEL = "SELECT item_group_bo,action_name,label_bo,label_tag_name,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_pkg_dn_setting ";

  private final Connection conn;

  public PkgDnSettingDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgDnSetting data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getActionName());
      ps.setString(3, data.getLabelBo());
      ps.setString(4, data.getLabelTagName());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PkgDnSetting> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PkgDnSetting data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getActionName());
        ps.setString(3, data.getLabelBo());
        ps.setString(4, data.getLabelTagName());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PkgDnSetting data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getReversedField1());
      ps.setString(2, data.getReversedField2());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getItemGroupBo());
      ps.setString(6, data.getActionName());
      ps.setString(7, data.getLabelBo());
      ps.setString(8, data.getLabelTagName());

      return ps.executeUpdate();
    }
  }

  public int update(List<PkgDnSetting> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PkgDnSetting data : dataList) {
        ps.setString(1, data.getReversedField1());
        ps.setString(2, data.getReversedField2());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getItemGroupBo());
        ps.setString(6, data.getActionName());
        ps.setString(7, data.getLabelBo());
        ps.setString(8, data.getLabelTagName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemGroupBo, String actionName, String labelBo, String labelTagName)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_pkg_dn_setting WHERE item_group_bo=? AND action_name=? AND label_bo=? AND label_tag_name=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, actionName);
      ps.setString(3, labelBo);
      ps.setString(4, labelTagName);

      return ps.executeUpdate();
    }
  }

  public int deleteByItemGroupBo(String itemGroupBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_pkg_dn_setting WHERE item_group_bo=? ")) {
      ps.setString(1, itemGroupBo);

      return ps.executeUpdate();
    }
  }

  public List<PkgDnSetting> selectAll() throws SQLException {
    ArrayList<PkgDnSetting> result = new ArrayList<PkgDnSetting>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgDnSetting> selectByItemGroupAndActionName(String itemGroupBo, String actionName)
      throws SQLException {
    ArrayList<PkgDnSetting> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE ITEM_GROUP_BO = ? and ACTION_NAME = ? ")) {

      ps.setString(1, itemGroupBo);
      ps.setString(2, actionName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgDnSetting> selectByItemGroup(String itemGroupBo) throws SQLException {
    ArrayList<PkgDnSetting> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE ITEM_GROUP_BO = ? ")) {

      ps.setString(1, itemGroupBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PkgDnSetting selectByPK(String itemGroupBo, String actionName, String labelBo,
      String labelTagName) throws SQLException {
    PkgDnSetting result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? AND action_name=? AND label_bo=? AND label_tag_name=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, actionName);
      ps.setString(3, labelBo);
      ps.setString(4, labelTagName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<PkgDnSetting> selectByItemGroupBo(String itemGroupBo, String actionName)
      throws SQLException {//按机种查所有记录
    ArrayList<PkgDnSetting> result = new ArrayList<PkgDnSetting>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? AND ACTION_NAME=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, actionName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private PkgDnSetting convert(ResultSet rs) throws SQLException {
    PkgDnSetting data = new PkgDnSetting();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setLabelBo(rs.getString(index++));
    data.setLabelTagName(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
