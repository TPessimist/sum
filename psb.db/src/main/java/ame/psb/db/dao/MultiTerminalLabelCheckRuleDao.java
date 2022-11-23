package ame.psb.db.dao;

import ame.psb.db.MultiTerminalLabelCheckRule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class MultiTerminalLabelCheckRuleDao {

  private static final String SQL_INS = "INSERT INTO zd_multi_terminal_label_check_rule(item_group_bo,container_type,terminal_name,label_bo,tag_bo,tag_type,tag_order,require_in_order,reserve_field1,reserve_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_multi_terminal_label_check_rule SET tag_type=?,tag_order=?,require_in_order=?,reserve_field1=?,reserve_field2=?,updated_user=?,updated_time=? WHERE item_group_bo=? AND container_type=? AND terminal_name=? AND label_bo=? AND tag_bo=?";

  private static final String SQL_SEL = "SELECT item_group_bo,container_type,terminal_name,label_bo,tag_bo,tag_type,tag_order,require_in_order,reserve_field1,reserve_field2,updated_user,updated_time FROM zd_multi_terminal_label_check_rule ";

  private final Connection conn;

  public MultiTerminalLabelCheckRuleDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(MultiTerminalLabelCheckRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getContainerType());
      ps.setString(3, data.getTerminalName());
      ps.setString(4, data.getLabelBo());
      ps.setString(5, data.getTagBo());
      ps.setString(6, data.getTagType());
      ps.setString(7, data.getTagOrder());
      ps.setString(8, data.getRequireInOrder());
      ps.setString(9, data.getReserveField1());
      ps.setString(10, data.getReserveField2());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<MultiTerminalLabelCheckRule> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (MultiTerminalLabelCheckRule data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getContainerType());
        ps.setString(3, data.getTerminalName());
        ps.setString(4, data.getLabelBo());
        ps.setString(5, data.getTagBo());
        ps.setString(6, data.getTagType());
        ps.setString(7, data.getTagOrder());
        ps.setString(8, data.getRequireInOrder());
        ps.setString(9, data.getReserveField1());
        ps.setString(10, data.getReserveField2());
        ps.setString(11, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(MultiTerminalLabelCheckRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getTagType());
      ps.setString(2, data.getTagOrder());
      ps.setString(3, data.getRequireInOrder());
      ps.setString(4, data.getReserveField1());
      ps.setString(5, data.getReserveField2());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getItemGroupBo());
      ps.setString(9, data.getContainerType());
      ps.setString(10, data.getTerminalName());
      ps.setString(11, data.getLabelBo());
      ps.setString(12, data.getTagBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<MultiTerminalLabelCheckRule> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (MultiTerminalLabelCheckRule data : dataList) {
        ps.setString(1, data.getTagType());
        ps.setString(2, data.getTagOrder());
        ps.setString(3, data.getRequireInOrder());
        ps.setString(4, data.getReserveField1());
        ps.setString(5, data.getReserveField2());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getItemGroupBo());
        ps.setString(9, data.getContainerType());
        ps.setString(10, data.getTerminalName());
        ps.setString(11, data.getLabelBo());
        ps.setString(12, data.getTagBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemGroupBo, String containerType, String terminalName, String labelBo,
      String tagBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_multi_terminal_label_check_rule WHERE item_group_bo=? AND container_type=? AND terminal_name=? AND label_bo=? AND tag_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, containerType);
      ps.setString(3, terminalName);
      ps.setString(4, labelBo);
      ps.setString(5, tagBo);

      return ps.executeUpdate();
    }
  }

  public int deleteByDevice(String itemGroupBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_multi_terminal_label_check_rule WHERE item_group_bo=?")) {
      ps.setString(1, itemGroupBo);

      return ps.executeUpdate();
    }
  }

  public List<MultiTerminalLabelCheckRule> selectAll() throws SQLException {
    ArrayList<MultiTerminalLabelCheckRule> result = new ArrayList<MultiTerminalLabelCheckRule>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public MultiTerminalLabelCheckRule selectByPK(String itemGroupBo, String containerType,
      String terminalName, String labelBo, String tagBo) throws SQLException {
    MultiTerminalLabelCheckRule result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE item_group_bo=? AND container_type=? AND terminal_name=? AND label_bo=? AND tag_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, containerType);
      ps.setString(3, terminalName);
      ps.setString(4, labelBo);
      ps.setString(5, tagBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<MultiTerminalLabelCheckRule> selectByItemGroupBoAndContainerType(String itemGroupBo,
      String containerType) throws SQLException {
    ArrayList<MultiTerminalLabelCheckRule> result = new ArrayList<MultiTerminalLabelCheckRule>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? and container_type=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, containerType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<MultiTerminalLabelCheckRule> selectReelRuleByItemGroupBo(String itemGroupBo)
      throws SQLException {
    ArrayList<MultiTerminalLabelCheckRule> result = new ArrayList<MultiTerminalLabelCheckRule>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? and container_type in('T','F') ")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<MultiTerminalLabelCheckRule> selectByItemGroupBoAndContainerTypeAndTerminal(
      String itemGroupBo, String containerType, String terminalName) throws SQLException {
    ArrayList<MultiTerminalLabelCheckRule> result = new ArrayList<MultiTerminalLabelCheckRule>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? and container_type=? and terminal_name=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, containerType);
      ps.setString(3, terminalName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<MultiTerminalLabelCheckRule> selectByItemGroupBo(String itemGroupBo)
      throws SQLException {
    ArrayList<MultiTerminalLabelCheckRule> result = new ArrayList<MultiTerminalLabelCheckRule>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE item_group_bo=? ")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private MultiTerminalLabelCheckRule convert(ResultSet rs) throws SQLException {
    MultiTerminalLabelCheckRule data = new MultiTerminalLabelCheckRule();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setContainerType(rs.getString(index++));
    data.setTerminalName(rs.getString(index++));
    data.setLabelBo(rs.getString(index++));
    data.setTagBo(rs.getString(index++));
    data.setTagType(rs.getString(index++));
    data.setTagOrder(rs.getString(index++));
    data.setRequireInOrder(rs.getString(index++));
    data.setReserveField1(rs.getString(index++));
    data.setReserveField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
