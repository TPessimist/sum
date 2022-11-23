package ame.psb.db.dao;

import ame.psb.db.OperationReworkLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OperationReworkLogDao {

  private static final String SQL_INS = "INSERT INTO zr_operation_rework_log(item_group_bo,operation_bo,rework_rule_content,updated_user,updated_time, REWORK_SFC_BO, RESOURCE_NAME,fc_split_description) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_operation_rework_log SET updated_user=?,updated_time=?, FC_DC_GROUPS = ?, FC_FI_STATUS = ?,fc_split_description=? WHERE item_group_bo=? AND operation_bo=? AND rework_rule_content=?";

  private static final String SQL_SEL = "SELECT item_group_bo,operation_bo,rework_rule_content,updated_user,updated_time, REWORK_SFC_BO, FC_DC_GROUPS, FC_FI_STATUS,fc_split_description FROM zr_operation_rework_log ";

  private final Connection conn;

  public OperationReworkLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(OperationReworkLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getReworkRuleContent());
      ps.setString(4, data.getUpdatedUser());
      ps.setTimestamp(5, new Timestamp(data.getUpdatedTime().getTime()));
      ps.setString(6, data.getReworkSfcBo());
      ps.setString(7, data.getResourceName());
      ps.setString(8, data.getFcSplitDescription());

      return ps.executeUpdate();
    }
  }

  public int insert(List<OperationReworkLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (OperationReworkLog data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getReworkRuleContent());
        ps.setString(4, data.getUpdatedUser());
        ps.setTimestamp(5, new Timestamp(data.getUpdatedTime().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(OperationReworkLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getUpdatedUser());
      ps.setTimestamp(2, new Timestamp(data.getUpdatedTime().getTime()));
      ps.setString(3, data.getFcDcGroups());
      ps.setString(4, data.getFcFiStatus());
      ps.setString(5, data.getFcSplitDescription());
      ps.setString(6, data.getItemGroupBo());
      ps.setString(7, data.getOperationBo());
      ps.setString(8, data.getReworkRuleContent());

      return ps.executeUpdate();
    }
  }

  public int update(List<OperationReworkLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (OperationReworkLog data : dataList) {
        ps.setString(1, data.getUpdatedUser());
        ps.setTimestamp(2, new Timestamp(data.getUpdatedTime().getTime()));
        ps.setString(3, data.getFcDcGroups());
        ps.setString(4, data.getFcFiStatus());
        ps.setString(5, data.getFcSplitDescription());
        ps.setString(6, data.getItemGroupBo());
        ps.setString(7, data.getOperationBo());
        ps.setString(8, data.getReworkRuleContent());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemGroupBo, String operationBo, String reworkRuleContent)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_operation_rework_log WHERE item_group_bo=? AND operation_bo=? AND rework_rule_content=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, reworkRuleContent);

      return ps.executeUpdate();
    }
  }

  public List<OperationReworkLog> selectAll() throws SQLException {
    ArrayList<OperationReworkLog> result = new ArrayList<OperationReworkLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public OperationReworkLog selectByPK(String itemGroupBo, String operationBo,
      String reworkRuleContent) throws SQLException {
    OperationReworkLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? AND operation_bo=? AND rework_rule_content=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, reworkRuleContent);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public OperationReworkLog selectBySfc(String itemGroupBo, String operationBo,
      String reworkRuleContent) throws SQLException {
    OperationReworkLog result = null;
    reworkRuleContent = reworkRuleContent + "%";
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? AND operation_bo=? AND rework_rule_content like ?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, reworkRuleContent);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public OperationReworkLog selectByReworkSfc(String sfcBo) throws SQLException {
    OperationReworkLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE REWORK_SFC_BO = ? ")) {
      ps.setString(1, sfcBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<OperationReworkLog> selectByResourceNameAndTime(String resourceName, String date)
      throws SQLException {
    ArrayList<OperationReworkLog> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "where RESOURCE_NAME = ? and UPDATED_TIME > ? and FC_FI_STATUS = 'DONE' ")) {
      ps.setString(1, resourceName);
      ps.setString(2, date);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public OperationReworkLog selectBySfcAndOperationAndDesc(String sfcBo,
      String fcSplitDescription) throws SQLException {
    OperationReworkLog result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL
                + "WHERE REWORK_SFC_BO = ? and fc_split_description = ? order by updated_time desc ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, fcSplitDescription);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private OperationReworkLog convert(ResultSet rs) throws SQLException {
    OperationReworkLog data = new OperationReworkLog();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setReworkRuleContent(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(rs.getTimestamp(index++));
    data.setReworkSfcBo(rs.getString(index++));
    data.setFcDcGroups(rs.getString(index++));
    data.setFcFiStatus(rs.getString(index++));
    data.setFcSplitDescription(rs.getString(index++));

    return data;
  }
}
