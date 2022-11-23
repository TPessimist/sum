package ame.psb.db.dao;

import ame.psb.db.OperationReworkRule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.Where;

public class OperationReworkRuleDao {

  private static final String SQL_INS = "INSERT INTO zd_operation_rework_rule(item_group_bo,operation_bo,nccode_bo,comment,reworktype,updated_user,updated_time,state,rework_rule) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_operation_rework_rule SET nccode_bo=?,comment=?,reworktype=?,updated_user=?,updated_time=?,state=?,rework_rule=? WHERE item_group_bo=? AND operation_bo=?";

  private static final String SQL_SEL = "SELECT item_group_bo,operation_bo,nccode_bo,comment,reworktype,updated_user,updated_time,state,rework_rule FROM zd_operation_rework_rule ";

  private final Connection conn;

  public OperationReworkRuleDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(OperationReworkRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getNccodeBo());
      ps.setString(4, data.getComment());
      ps.setString(5, data.getReworktype());
      ps.setString(6, data.getUpdatedUser());
      ps.setTimestamp(7, new Timestamp(data.getUpdatedTime().getTime()));
      ps.setString(8, data.getState());
      ps.setString(9, data.getReworkRule());

      return ps.executeUpdate();
    }
  }

  public int insert(List<OperationReworkRule> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (OperationReworkRule data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getNccodeBo());
        ps.setString(4, data.getComment());
        ps.setString(5, data.getReworktype());
        ps.setString(6, data.getUpdatedUser());
        ps.setTimestamp(7, new Timestamp(data.getUpdatedTime().getTime()));
        ps.setString(8, data.getState());
        ps.setString(9, data.getReworkRule());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(OperationReworkRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getNccodeBo());
      ps.setString(2, data.getComment());
      ps.setString(3, data.getReworktype());
      ps.setString(4, data.getUpdatedUser());
      ps.setTimestamp(5, new Timestamp(data.getUpdatedTime().getTime()));
      ps.setString(6, data.getState());
      ps.setString(7, data.getReworkRule());
      ps.setString(8, data.getItemGroupBo());
      ps.setString(9, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<OperationReworkRule> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (OperationReworkRule data : dataList) {
        ps.setString(1, data.getNccodeBo());
        ps.setString(2, data.getComment());
        ps.setString(3, data.getReworktype());
        ps.setString(4, data.getUpdatedUser());
        ps.setTimestamp(5, new Timestamp(data.getUpdatedTime().getTime()));
        ps.setString(6, data.getState());
        ps.setString(7, data.getReworkRule());
        ps.setString(8, data.getItemGroupBo());
        ps.setString(9, data.getOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemGroupBo, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_operation_rework_rule WHERE item_group_bo=? AND operation_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      return ps.executeUpdate();
    }
  }

  public int deleteByRework(String itemGroupBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_operation_rework_rule WHERE item_group_bo = ? ")) {
      ps.setString(1, itemGroupBo);

      return ps.executeUpdate();
    }

  }

  public List<OperationReworkRule> selectAll() throws SQLException {
    ArrayList<OperationReworkRule> result = new ArrayList<OperationReworkRule>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public OperationReworkRule selectByPK(String itemGroupBo, String operationBo)
      throws SQLException {
    OperationReworkRule result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? AND operation_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public List<OperationReworkRule> selectByitemGroupBo(String itemGroupBo) throws SQLException {
    List<OperationReworkRule> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE item_group_bo=? ")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private OperationReworkRule convert(ResultSet rs) throws SQLException {
    OperationReworkRule data = new OperationReworkRule();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setNccodeBo(rs.getString(index++));
    data.setComment(rs.getString(index++));
    data.setReworktype(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(rs.getTimestamp(index++));
    data.setState(rs.getString(index++));
    data.setReworkRule(rs.getString(index++));

    return data;
  }

  public int selectCountByItemGroup(String itemGroupBoTo) throws SQLException {
    String selSql = "select count(1) from zd_operation_rework_rule where item_group_bo = ?";
    int count = 0;
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, itemGroupBoTo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        count = rs.getInt(1);
      }
      return count;
    }
  }

  public List<OperationReworkRule> select(Where where) throws SQLException {
    ArrayList<OperationReworkRule> result = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }
}
