package ame.psb.db.dao;

import ame.psb.db.Zr37JumpContainer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class Zr37JumpContainerDao {

  private static final String SQL_INS = "INSERT INTO zr_37jump_container(id,state_name,dn,dept,curr_step,insert_time,insert_user,update_time,update_user) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_37jump_container SET state_name=?,dn=?,dept=?,curr_step=?,insert_time=?,insert_user=?,update_time=?,update_user=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,state_name,dn,dept,curr_step,insert_time,insert_user,update_time,update_user FROM zr_37jump_container ";

  private final Connection conn;

  public Zr37JumpContainerDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Zr37JumpContainer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getStateName());
      ps.setString(3, data.getDn());
      ps.setString(4, data.getDept());
      ps.setString(5, data.getCurrStep());
      DateUtils.setDateTz(ps, 6, data.getInsertTime());
      ps.setString(7, data.getInsertUser());
      DateUtils.setDateTz(ps, 8, data.getUpdateTime());
      ps.setString(9, data.getUpdateUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Zr37JumpContainer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Zr37JumpContainer data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getStateName());
        ps.setString(3, data.getDn());
        ps.setString(4, data.getDept());
        ps.setString(5, data.getCurrStep());
        DateUtils.setDateTz(ps, 6, data.getInsertTime());
        ps.setString(7, data.getInsertUser());
        DateUtils.setDateTz(ps, 8, data.getUpdateTime());
        ps.setString(9, data.getUpdateUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Zr37JumpContainer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getStateName());
      ps.setString(2, data.getDn());
      ps.setString(3, data.getDept());
      ps.setString(4, data.getCurrStep());
      DateUtils.setDateTz(ps, 5, data.getInsertTime());
      ps.setString(6, data.getInsertUser());
      DateUtils.setDateTz(ps, 7, data.getUpdateTime());
      ps.setString(8, data.getUpdateUser());
      ps.setString(9, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<Zr37JumpContainer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Zr37JumpContainer data : dataList) {
        ps.setString(1, data.getStateName());
        ps.setString(2, data.getDn());
        ps.setString(3, data.getDept());
        ps.setString(4, data.getCurrStep());
        DateUtils.setDateTz(ps, 5, data.getInsertTime());
        ps.setString(6, data.getInsertUser());
        DateUtils.setDateTz(ps, 7, data.getUpdateTime());
        ps.setString(8, data.getUpdateUser());
        ps.setString(9, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_37jump_container WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByDn(String dn) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_37jump_container WHERE dn=?")) {
      ps.setString(1, dn);

      return ps.executeUpdate();
    }
  }

  public List<Zr37JumpContainer> selectAll() throws SQLException {
    ArrayList<Zr37JumpContainer> result = new ArrayList<Zr37JumpContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Zr37JumpContainer selectByPK(String id) throws SQLException {
    Zr37JumpContainer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<Zr37JumpContainer> selectWaitContainer() throws SQLException {
    ArrayList<Zr37JumpContainer> result = new ArrayList<Zr37JumpContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE STATE_NAME='WAIT' ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Zr37JumpContainer> selectByDn(String dn) throws SQLException {
    ArrayList<Zr37JumpContainer> result = new ArrayList<Zr37JumpContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE DN=? ")) {
      ps.setString(1, dn);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private Zr37JumpContainer convert(ResultSet rs) throws SQLException {
    Zr37JumpContainer data = new Zr37JumpContainer();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setDn(rs.getString(index++));
    data.setDept(rs.getString(index++));
    data.setCurrStep(rs.getString(index++));
    data.setInsertTime(DateUtils.getDateTz(rs, index++));
    data.setInsertUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setUpdateUser(rs.getString(index++));

    return data;
  }
}
