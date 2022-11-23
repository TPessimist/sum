package ame.psb.db.dao;

import ame.psb.db.ReworkTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReworkTimeDao {

  private static final String SQL_INS = "INSERT INTO zr_rework_time(customer_item_bo,operation,rework_router,rework_time,update_time,update_user) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_rework_time SET rework_time=?,update_time=?,update_user=? WHERE customer_item_bo=? AND operation=? AND rework_router=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,operation,rework_router,rework_time,update_time,update_user FROM zr_rework_time ";

  private final Connection conn;

  public ReworkTimeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ReworkTime data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getOperation());
      ps.setString(3, data.getReworkRouter());
      ps.setInt(4, data.getReworkTime());
      ps.setTimestamp(5, new Timestamp(data.getUpdateTime().getTime()));
      ps.setString(6, data.getUpdateUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ReworkTime> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ReworkTime data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getOperation());
        ps.setString(3, data.getReworkRouter());
        ps.setInt(4, data.getReworkTime());
        ps.setTimestamp(5, new Timestamp(data.getUpdateTime().getTime()));
        ps.setString(6, data.getUpdateUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ReworkTime data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getReworkTime());
      ps.setTimestamp(2, new Timestamp(data.getUpdateTime().getTime()));
      ps.setString(3, data.getUpdateUser());
      ps.setString(4, data.getCustomerItemBo());
      ps.setString(5, data.getOperation());
      ps.setString(6, data.getReworkRouter());

      return ps.executeUpdate();
    }
  }

  public int update(List<ReworkTime> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ReworkTime data : dataList) {
        ps.setInt(1, data.getReworkTime());
        ps.setTimestamp(2, new Timestamp(data.getUpdateTime().getTime()));
        ps.setString(3, data.getUpdateUser());
        ps.setString(4, data.getCustomerItemBo());
        ps.setString(5, data.getOperation());
        ps.setString(6, data.getReworkRouter());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerItemBo, String operation, String reworkRouter)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_rework_time WHERE customer_item_bo=? AND operation=? AND rework_router=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operation);
      ps.setString(3, reworkRouter);

      return ps.executeUpdate();
    }
  }

  public List<ReworkTime> selectAll() throws SQLException {
    ArrayList<ReworkTime> result = new ArrayList<ReworkTime>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ReworkTime selectByPK(String customerItemBo, String operation, String reworkRouter)
      throws SQLException {
    ReworkTime result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE customer_item_bo=? AND operation=? AND rework_router=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operation);
      ps.setString(3, reworkRouter);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ReworkTime convert(ResultSet rs) throws SQLException {
    ReworkTime data = new ReworkTime();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setReworkRouter(rs.getString(index++));
    data.setReworkTime(rs.getInt(index++));
    data.setUpdateTime(rs.getTimestamp(index++));
    data.setUpdateUser(rs.getString(index++));

    return data;
  }
}

