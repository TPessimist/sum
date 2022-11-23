package ame.psb.db.dao;

import ame.psb.db.TemporaryLeader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class TemporaryLeaderDao {

  private static final String SQL_INS = "INSERT INTO zr_temporary_leader(uuid,leader_id,temporary_leader_id,state_name,flag,content,value,start_time,end_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_temporary_leader SET leader_id=?,temporary_leader_id=?,state_name=?,flag=?,content=?,value=?,start_time=?,end_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,leader_id,temporary_leader_id,state_name,flag,content,value,start_time,end_time FROM zr_temporary_leader ";

  private final Connection conn;

  public TemporaryLeaderDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(TemporaryLeader data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getLeaderId());
      ps.setString(3, data.getTemporaryLeaderId());
      ps.setString(4, data.getStateName());
      ps.setString(5, data.getFlag());
      ps.setString(6, data.getContent());
      ps.setString(7, data.getValue());
      DateUtils.setDateTz(ps, 8, data.getStartTime());
      DateUtils.setDateTz(ps, 9, data.getEndTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<TemporaryLeader> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (TemporaryLeader data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getLeaderId());
        ps.setString(3, data.getTemporaryLeaderId());
        ps.setString(4, data.getStateName());
        ps.setString(5, data.getFlag());
        ps.setString(6, data.getContent());
        ps.setString(7, data.getValue());
        DateUtils.setDateTz(ps, 8, data.getStartTime());
        DateUtils.setDateTz(ps, 9, data.getEndTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(TemporaryLeader data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getLeaderId());
      ps.setString(2, data.getTemporaryLeaderId());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getFlag());
      ps.setString(5, data.getContent());
      ps.setString(6, data.getValue());
      DateUtils.setDateTz(ps, 7, data.getStartTime());
      DateUtils.setDateTz(ps, 8, data.getEndTime());
      ps.setString(9, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<TemporaryLeader> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (TemporaryLeader data : dataList) {
        ps.setString(1, data.getLeaderId());
        ps.setString(2, data.getTemporaryLeaderId());
        ps.setString(3, data.getStateName());
        ps.setString(4, data.getFlag());
        ps.setString(5, data.getContent());
        ps.setString(6, data.getValue());
        DateUtils.setDateTz(ps, 7, data.getStartTime());
        DateUtils.setDateTz(ps, 8, data.getEndTime());
        ps.setString(9, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_temporary_leader WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<TemporaryLeader> selectAll() throws SQLException {
    ArrayList<TemporaryLeader> result = new ArrayList<TemporaryLeader>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public TemporaryLeader selectByPK(String uuid) throws SQLException {
    TemporaryLeader result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public TemporaryLeader selectByLeaderStart(String leaderId) throws SQLException {
    TemporaryLeader result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE leader_id= ? AND state_name = 'Start' ")) {
      ps.setString(1, leaderId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public TemporaryLeader selectByTemporaryStart(String temporaryId) throws SQLException {
    TemporaryLeader result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE temporary_leader_id= ? AND state_name = 'Start' ")) {
      ps.setString(1, temporaryId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private TemporaryLeader convert(ResultSet rs) throws SQLException {
    TemporaryLeader data = new TemporaryLeader();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setLeaderId(rs.getString(index++));
    data.setTemporaryLeaderId(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setFlag(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setStartTime(DateUtils.getDateTz(rs, index++));
    data.setEndTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
