package ame.psb.db.dao;

import ame.psb.db.UserLeave;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class UserLeaveDao {

  private static final String SQL_INS = "INSERT INTO zr_user_leave(id,op_user,leader_user,department,area,reason,leave_time,back_time,flag,value,content) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_user_leave SET op_user=?,leader_user=?,department=?,area=?,reason=?,leave_time=?,back_time=?,flag=?,value=?,content=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,op_user,leader_user,department,area,reason,leave_time,back_time,flag,value,content FROM zr_user_leave ";

  private final Connection conn;

  public UserLeaveDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(UserLeave data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getOpUser());
      ps.setString(3, data.getLeaderUser());
      ps.setString(4, data.getDepartment());
      ps.setString(5, data.getArea());
      ps.setString(6, data.getReason());
      DateUtils.setDateTz(ps, 7, data.getLeaveTime());
      DateUtils.setDateTz(ps, 8, data.getBackTime());
      ps.setString(9, data.getFlag());
      ps.setString(10, data.getValue());
      ps.setString(11, data.getContent());

      return ps.executeUpdate();
    }
  }

  public int insert(List<UserLeave> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (UserLeave data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getOpUser());
        ps.setString(3, data.getLeaderUser());
        ps.setString(4, data.getDepartment());
        ps.setString(5, data.getArea());
        ps.setString(6, data.getReason());
        DateUtils.setDateTz(ps, 7, data.getLeaveTime());
        DateUtils.setDateTz(ps, 8, data.getBackTime());
        ps.setString(9, data.getFlag());
        ps.setString(10, data.getValue());
        ps.setString(11, data.getContent());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(UserLeave data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getOpUser());
      ps.setString(2, data.getLeaderUser());
      ps.setString(3, data.getDepartment());
      ps.setString(4, data.getArea());
      ps.setString(5, data.getReason());
      DateUtils.setDateTz(ps, 6, data.getLeaveTime());
      DateUtils.setDateTz(ps, 7, data.getBackTime());
      ps.setString(8, data.getFlag());
      ps.setString(9, data.getValue());
      ps.setString(10, data.getContent());
      ps.setString(11, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<UserLeave> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (UserLeave data : dataList) {
        ps.setString(1, data.getOpUser());
        ps.setString(2, data.getLeaderUser());
        ps.setString(3, data.getDepartment());
        ps.setString(4, data.getArea());
        ps.setString(5, data.getReason());
        DateUtils.setDateTz(ps, 6, data.getLeaveTime());
        DateUtils.setDateTz(ps, 7, data.getBackTime());
        ps.setString(8, data.getFlag());
        ps.setString(9, data.getValue());
        ps.setString(10, data.getContent());
        ps.setString(11, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_user_leave WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<UserLeave> selectAll() throws SQLException {
    ArrayList<UserLeave> result = new ArrayList<UserLeave>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public UserLeave selectByPK(String id) throws SQLException {
    UserLeave result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<UserLeave> selectByUser(String user) throws SQLException {
    ArrayList<UserLeave> result = new ArrayList<UserLeave>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE OP_USER =? ORDER BY LEAVE_TIME DESC")) {
      ps.setString(1, user);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<UserLeave> selectByLeaveTime(String bTime, String eTime, String user)
      throws SQLException {
    ArrayList<UserLeave> result = new ArrayList<UserLeave>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE ((ADD_SECONDS (TO_TIMESTAMP (LEAVE_TIME), 3600*8)) BETWEEN ? AND ? ) AND OP_USER =?")) {
      ps.setString(1, bTime);
      ps.setString(2, eTime);
      ps.setString(3, user);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<UserLeave> selectByUserCard(String user) throws SQLException {
    ArrayList<UserLeave> result = new ArrayList<UserLeave>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE OP_USER =? AND reason = 'Card' AND flag = 'N' ORDER BY LEAVE_TIME DESC")) {
      ps.setString(1, user);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public UserLeave selectByUserCard1(String user) throws SQLException {
    UserLeave result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE OP_USER =? AND reason = 'Card' ORDER BY LEAVE_TIME DESC for update")) {
      ps.setString(1, user);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public List<UserLeave> selectByDptAreaFlag(String dpt, String area) throws SQLException {
    ArrayList<UserLeave> result = new ArrayList<UserLeave>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE department =? AND area =? AND flag = 'N' ORDER BY LEAVE_TIME DESC")) {
      ps.setString(1, dpt);
      ps.setString(2, area);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private UserLeave convert(ResultSet rs) throws SQLException {
    UserLeave data = new UserLeave();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setOpUser(rs.getString(index++));
    data.setLeaderUser(rs.getString(index++));
    data.setDepartment(rs.getString(index++));
    data.setArea(rs.getString(index++));
    data.setReason(rs.getString(index++));
    data.setLeaveTime(DateUtils.getDateTz(rs, index++));
    data.setBackTime(DateUtils.getDateTz(rs, index++));
    data.setFlag(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setContent(rs.getString(index++));

    return data;
  }
}
