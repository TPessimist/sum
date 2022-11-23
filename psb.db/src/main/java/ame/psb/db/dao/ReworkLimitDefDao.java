package ame.psb.db.dao;

import ame.psb.db.ReworkLimitDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.Where;

public class ReworkLimitDefDao {

  private static final String SQL_INS = "INSERT INTO zd_rework_limit_def(item_group,operation,rework_router,limit_times,update_time,update_user) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_rework_limit_def SET limit_times=?,update_time=?,update_user=? WHERE item_group=? AND operation=? AND rework_router=?";

  private static final String SQL_SEL = "SELECT item_group,operation,rework_router,limit_times,update_time,update_user FROM zd_rework_limit_def ";

  private final Connection conn;

  public ReworkLimitDefDao(Connection conn) {
    this.conn = conn;
  }

  public List<ReworkLimitDef> select(Where where) throws SQLException {
    ArrayList<ReworkLimitDef> result = new ArrayList<ReworkLimitDef>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public int insert(ReworkLimitDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroup());
      ps.setString(2, data.getOperation());
      ps.setString(3, data.getReworkRouter());
      ps.setInt(4, data.getLimitTimes());
      ps.setTimestamp(5, new Timestamp(data.getUpdateTime().getTime()));
      ps.setString(6, data.getUpdateUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ReworkLimitDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ReworkLimitDef data : dataList) {
        ps.setString(1, data.getItemGroup());
        ps.setString(2, data.getOperation());
        ps.setString(3, data.getReworkRouter());
        ps.setInt(4, data.getLimitTimes());
        ps.setTimestamp(5, new Timestamp(data.getUpdateTime().getTime()));
        ps.setString(6, data.getUpdateUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ReworkLimitDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getLimitTimes());
      ps.setTimestamp(2, new Timestamp(data.getUpdateTime().getTime()));
      ps.setString(3, data.getUpdateUser());
      ps.setString(4, data.getItemGroup());
      ps.setString(5, data.getOperation());
      ps.setString(6, data.getReworkRouter());

      return ps.executeUpdate();
    }
  }

  public int update(List<ReworkLimitDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ReworkLimitDef data : dataList) {
        ps.setInt(1, data.getLimitTimes());
        ps.setTimestamp(2, new Timestamp(data.getUpdateTime().getTime()));
        ps.setString(3, data.getUpdateUser());
        ps.setString(4, data.getItemGroup());
        ps.setString(5, data.getOperation());
        ps.setString(6, data.getReworkRouter());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemGroup, String operation, String reworkRouter) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_rework_limit_def WHERE item_group=? AND operation=? AND rework_router=?")) {
      ps.setString(1, itemGroup);
      ps.setString(2, operation);
      ps.setString(3, reworkRouter);

      return ps.executeUpdate();
    }
  }

  public List<ReworkLimitDef> selectAll() throws SQLException {
    ArrayList<ReworkLimitDef> result = new ArrayList<ReworkLimitDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ReworkLimitDef selectByPK(String itemGroup, String operation, String reworkRouter)
      throws SQLException {
    ReworkLimitDef result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group=? AND operation=? AND rework_router=?")) {
      ps.setString(1, itemGroup);
      ps.setString(2, operation);
      ps.setString(3, reworkRouter);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ReworkLimitDef convert(ResultSet rs) throws SQLException {
    ReworkLimitDef data = new ReworkLimitDef();

    int index = 1;
    data.setItemGroup(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setReworkRouter(rs.getString(index++));
    data.setLimitTimes(rs.getInt(index++));
    data.setUpdateTime(rs.getTimestamp(index++));
    data.setUpdateUser(rs.getString(index++));

    return data;
  }

  public int selectCountByItemGroup(String itemGroupTo) throws SQLException {
    String selSql = "select count(1) from zd_rework_limit_def where item_group = ? ";
    int count = 0;
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, itemGroupTo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        count = rs.getInt(1);
      }
      return count;
    }
  }
}
