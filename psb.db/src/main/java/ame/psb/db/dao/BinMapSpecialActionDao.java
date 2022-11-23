package ame.psb.db.dao;

import ame.psb.db.BinMapSpecialAction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BinMapSpecialActionDao {

  private static final String SQL_INS = "INSERT INTO zd_binmap_special_action(target_object,target_level,state_name,operation_bo,action_name,action_content,action_comment,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_binmap_special_action SET state_name=?,action_content=?,action_comment=?,updated_user=?,updated_time=? WHERE target_object=? AND target_level=? AND operation_bo=? AND action_name=?";

  private static final String SQL_SEL = "SELECT target_object,target_level,state_name,operation_bo,action_name,action_content,action_comment,updated_user,updated_time FROM zd_binmap_special_action ";

  private final Connection conn;

  public BinMapSpecialActionDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BinMapSpecialAction data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getTargetObject());
      ps.setString(2, data.getTargetLevel());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getActionName());
      ps.setString(6, data.getActionContent());
      ps.setString(7, data.getActionComment());
      ps.setString(8, data.getUpdatedUser());
      ps.setTimestamp(9, new Timestamp(data.getUpdatedTime().getTime()));

      return ps.executeUpdate();
    }
  }

  public int insert(List<BinMapSpecialAction> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BinMapSpecialAction data : dataList) {
        ps.setString(1, data.getTargetObject());
        ps.setString(2, data.getTargetLevel());
        ps.setString(3, data.getStateName());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getActionName());
        ps.setString(6, data.getActionContent());
        ps.setString(7, data.getActionComment());
        ps.setString(8, data.getUpdatedUser());
        ps.setTimestamp(9, new Timestamp(data.getUpdatedTime().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BinMapSpecialAction data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getStateName());
      ps.setString(2, data.getActionContent());
      ps.setString(3, data.getActionComment());
      ps.setString(4, data.getUpdatedUser());
      ps.setTimestamp(5, new Timestamp(data.getUpdatedTime().getTime()));
      ps.setString(6, data.getTargetObject());
      ps.setString(7, data.getTargetLevel());
      ps.setString(8, data.getOperationBo());
      ps.setString(9, data.getActionName());

      return ps.executeUpdate();
    }
  }

  public int update(List<BinMapSpecialAction> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BinMapSpecialAction data : dataList) {
        ps.setString(1, data.getStateName());
        ps.setString(2, data.getActionContent());
        ps.setString(3, data.getActionComment());
        ps.setString(4, data.getUpdatedUser());
        ps.setTimestamp(5, new Timestamp(data.getUpdatedTime().getTime()));
        ps.setString(6, data.getTargetObject());
        ps.setString(7, data.getTargetLevel());
        ps.setString(8, data.getOperationBo());
        ps.setString(9, data.getActionName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String targetObject, String targetLevel, String operationBo, String actionName)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_binmap_special_action WHERE target_object=? AND target_level=? AND operation_bo=? AND action_name=?")) {
      ps.setString(1, targetObject);
      ps.setString(2, targetLevel);
      ps.setString(3, operationBo);
      ps.setString(4, actionName);

      return ps.executeUpdate();
    }
  }

  public List<BinMapSpecialAction> selectAll() throws SQLException {
    ArrayList<BinMapSpecialAction> result = new ArrayList<BinMapSpecialAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public BinMapSpecialAction selectByPK(String targetObject, String targetLevel, String operationBo,
      String actionName) throws SQLException {
    BinMapSpecialAction result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE target_object=? AND target_level=? AND operation_bo=? AND action_name=?")) {
      ps.setString(1, targetObject);
      ps.setString(2, targetLevel);
      ps.setString(3, operationBo);
      ps.setString(4, actionName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<BinMapSpecialAction> selectByOperation(String operationBo) throws SQLException {
    List<BinMapSpecialAction> results = new ArrayList<BinMapSpecialAction>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE operation_bo=? AND state_name = 'ENABLE' ")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        results.add(convert(rs));
      }
      return results;
    }
  }

  private BinMapSpecialAction convert(ResultSet rs) throws SQLException {
    BinMapSpecialAction data = new BinMapSpecialAction();

    int index = 1;
    data.setTargetObject(rs.getString(index++));
    data.setTargetLevel(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setActionContent(rs.getString(index++));
    data.setActionComment(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(rs.getTimestamp(index++));

    return data;
  }
}
