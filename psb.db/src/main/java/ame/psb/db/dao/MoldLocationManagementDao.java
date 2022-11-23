package ame.psb.db.dao;

import ame.psb.db.MoldLocationManagement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class MoldLocationManagementDao {

  private static final String SQL_INS = "INSERT INTO zd_mold_location_management(batch_id,location,shop_order,device,operation,state_name,update_user,updated_time,reserve1,reserve2,reserve3,relation) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_mold_location_management SET shop_order=?,device=?,operation=?,state_name=?,update_user=?,updated_time=?,reserve1=?,reserve2=?,reserve3=?,relation=? WHERE batch_id=? AND location=?";

  private static final String SQL_SEL = "SELECT batch_id,location,shop_order,device,operation,state_name,update_user,updated_time,reserve1,reserve2,reserve3,relation FROM zd_mold_location_management ";

  private final Connection conn;

  public MoldLocationManagementDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(MoldLocationManagement data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getBatchId());
      ps.setString(2, data.getLocation());
      ps.setString(3, data.getShopOrder());
      ps.setString(4, data.getDevice());
      ps.setString(5, data.getOperation());
      ps.setString(6, data.getStateName());
      ps.setString(7, data.getUpdateUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getReserve1());
      ps.setString(10, data.getReserve2());
      ps.setString(11, data.getReserve3());
      ps.setString(12, data.getRelation());

      return ps.executeUpdate();
    }
  }

  public int insert(List<MoldLocationManagement> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (MoldLocationManagement data : dataList) {
        ps.setString(1, data.getBatchId());
        ps.setString(2, data.getLocation());
        ps.setString(3, data.getShopOrder());
        ps.setString(4, data.getDevice());
        ps.setString(5, data.getOperation());
        ps.setString(6, data.getStateName());
        ps.setString(7, data.getUpdateUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getReserve1());
        ps.setString(10, data.getReserve2());
        ps.setString(11, data.getReserve3());
        ps.setString(12, data.getRelation());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(MoldLocationManagement data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getShopOrder());
      ps.setString(2, data.getDevice());
      ps.setString(3, data.getOperation());
      ps.setString(4, data.getStateName());
      ps.setString(5, data.getUpdateUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getReserve1());
      ps.setString(8, data.getReserve2());
      ps.setString(9, data.getReserve3());
      ps.setString(10, data.getRelation());
      ps.setString(11, data.getBatchId());
      ps.setString(12, data.getLocation());

      return ps.executeUpdate();
    }
  }

  public int update(List<MoldLocationManagement> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (MoldLocationManagement data : dataList) {
        ps.setString(1, data.getShopOrder());
        ps.setString(2, data.getDevice());
        ps.setString(3, data.getOperation());
        ps.setString(4, data.getStateName());
        ps.setString(5, data.getUpdateUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getReserve1());
        ps.setString(8, data.getReserve2());
        ps.setString(9, data.getReserve3());
        ps.setString(10, data.getRelation());
        ps.setString(11, data.getBatchId());
        ps.setString(12, data.getLocation());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String batchId, String location) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_mold_location_management WHERE batch_id=? AND location=?")) {
      ps.setString(1, batchId);
      ps.setString(2, location);

      return ps.executeUpdate();
    }
  }

  public List<MoldLocationManagement> selectAll() throws SQLException {
    ArrayList<MoldLocationManagement> result = new ArrayList<MoldLocationManagement>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public MoldLocationManagement selectByPK(String batchId, String location) throws SQLException {
    MoldLocationManagement result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE batch_id=? AND location=?")) {
      ps.setString(1, batchId);
      ps.setString(2, location);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<MoldLocationManagement> select(Where where) throws SQLException {
    ArrayList<MoldLocationManagement> result = new ArrayList<MoldLocationManagement>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public MoldLocationManagement selectByBatchId(String batchId) throws SQLException {
    MoldLocationManagement result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE batch_id=? ")) {
      ps.setString(1, batchId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<MoldLocationManagement> selectByShopOrder(String shopOrder) throws SQLException {
    ArrayList<MoldLocationManagement> result = new ArrayList<MoldLocationManagement>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where shop_order=? ")) {
      ps.setString(1, shopOrder);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<MoldLocationManagement> selectByLocation(String location) throws SQLException {
    ArrayList<MoldLocationManagement> result = new ArrayList<MoldLocationManagement>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where location=? ")) {
      ps.setString(1, location);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private MoldLocationManagement convert(ResultSet rs) throws SQLException {
    MoldLocationManagement data = new MoldLocationManagement();

    int index = 1;
    data.setBatchId(rs.getString(index++));
    data.setLocation(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setDevice(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setReserve1(rs.getString(index++));
    data.setReserve2(rs.getString(index++));
    data.setReserve3(rs.getString(index++));
    data.setRelation(rs.getString(index++));

    return data;
  }
}
