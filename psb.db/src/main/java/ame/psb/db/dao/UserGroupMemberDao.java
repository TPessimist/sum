package ame.psb.db.dao;

import ame.psb.db.UserGroupMember;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserGroupMemberDao {

  private static final String SQL_INS = "INSERT INTO user_group_member(handle,user_group_bo,user_or_group_gbo) VALUES (?,?,?)";

  private static final String SQL_UPD = "UPDATE user_group_member SET user_group_bo=?,user_or_group_gbo=? WHERE handle=?";


  private static final String SQL_SEL = "SELECT handle,user_group_bo,user_or_group_gbo FROM user_group_member ";

  private final Connection conn;

  public UserGroupMemberDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(UserGroupMember data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getUserGroupBo());
      ps.setString(3, data.getUserOrGroupGbo());

      return ps.executeUpdate();
    }
  }

  public int insert(List<UserGroupMember> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (UserGroupMember data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getUserGroupBo());
        ps.setString(3, data.getUserOrGroupGbo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(UserGroupMember data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getUserGroupBo());
      ps.setString(2, data.getUserOrGroupGbo());
      ps.setString(3, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<UserGroupMember> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (UserGroupMember data : dataList) {
        ps.setString(1, data.getUserGroupBo());
        ps.setString(2, data.getUserOrGroupGbo());
        ps.setString(3, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM user_group_member WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public int deleteByUser(String user) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM user_group_member WHERE user_or_group_gbo=?")) {
      ps.setString(1, user);
      return ps.executeUpdate();
    }
  }

  /*
   * cc
   * 根据权限名称删除数据
   * */
  public int deleteByUserGroupBo(String userGroupBo, String userOrGroupGbo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "DELETE FROM user_group_member WHERE user_group_bo=? and user_or_group_gbo=?")) {
      ps.setString(1, userGroupBo);
      ps.setString(2, userOrGroupGbo);

      return ps.executeUpdate();
    }
  }

  public List<UserGroupMember> selectAll() throws SQLException {
    ArrayList<UserGroupMember> result = new ArrayList<UserGroupMember>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public UserGroupMember selectByPK(String handle) throws SQLException {
    UserGroupMember result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public UserGroupMember selectByUser(String userGroupBo, String userBo) throws SQLException {
    UserGroupMember result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE user_group_bo = ? and user_or_group_gbo = ?")) {
      ps.setString(1, userGroupBo);
      ps.setString(2, userBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<UserGroupMember> selectByUserGroup(String userGroupBo) throws SQLException {
    ArrayList<UserGroupMember> result = new ArrayList<UserGroupMember>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE user_group_bo = ?")) {
      ps.setString(1, userGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  /*
   * cc
   * @param：userOrGroupGbo
   * @desc：根据用户id查找所有权限
   * */
  public List<UserGroupMember> selectByUserGroupBo(String userOrGroupGbo) throws SQLException {
    ArrayList<UserGroupMember> result = new ArrayList<UserGroupMember>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE user_or_group_gbo = ?")) {
      ps.setString(1, userOrGroupGbo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  private UserGroupMember convert(ResultSet rs) throws SQLException {
    UserGroupMember data = new UserGroupMember();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setUserGroupBo(rs.getString(index++));
    data.setUserOrGroupGbo(rs.getString(index++));

    return data;
  }
}
