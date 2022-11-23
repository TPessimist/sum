package ame.psb.db.dao;

import ame.psb.db.RouterOperationChangeLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RouterOperationChangeLogDao {

  private static final String SQL_INS = "INSERT INTO zd_router_operation_change_log(id,customer_id,device_name,router_name,package_name,device_bo,router_bo,package_bo,change_type,pdm_flag,reserve_field1,reserve_field2,log_user,log_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_router_operation_change_log SET customer_id=?,device_name=?,router_name=?,package_name=?,device_bo=?,router_bo=?,package_bo=?,change_type=?,pdm_flag=?,reserve_field1=?,reserve_field2=?,log_user=?,log_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,customer_id,device_name,router_name,package_name,device_bo,router_bo,package_bo,change_type,pdm_flag,reserve_field1,reserve_field2,log_user,log_time FROM zd_router_operation_change_log ";

  private final Connection conn;

  public RouterOperationChangeLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RouterOperationChangeLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getCustomerId());
      ps.setString(3, data.getDeviceName());
      ps.setString(4, data.getRouterName());
      ps.setString(5, data.getPackageName());
      ps.setString(6, data.getDeviceBo());
      ps.setString(7, data.getRouterBo());
      ps.setString(8, data.getPackageBo());
      ps.setString(9, data.getChangeType());
      ps.setString(10, data.getPdmFlag());
      ps.setString(11, data.getReserveField1());
      ps.setString(12, data.getReserveField2());
      ps.setString(13, data.getLogUser());
      DateUtils.setDateTz(ps, 14, data.getLogTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RouterOperationChangeLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RouterOperationChangeLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getCustomerId());
        ps.setString(3, data.getDeviceName());
        ps.setString(4, data.getRouterName());
        ps.setString(5, data.getPackageName());
        ps.setString(6, data.getDeviceBo());
        ps.setString(7, data.getRouterBo());
        ps.setString(8, data.getPackageBo());
        ps.setString(9, data.getChangeType());
        ps.setString(10, data.getPdmFlag());
        ps.setString(11, data.getReserveField1());
        ps.setString(12, data.getReserveField2());
        ps.setString(13, data.getLogUser());
        DateUtils.setDateTz(ps, 14, data.getLogTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RouterOperationChangeLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomerId());
      ps.setString(2, data.getDeviceName());
      ps.setString(3, data.getRouterName());
      ps.setString(4, data.getPackageName());
      ps.setString(5, data.getDeviceBo());
      ps.setString(6, data.getRouterBo());
      ps.setString(7, data.getPackageBo());
      ps.setString(8, data.getChangeType());
      ps.setString(9, data.getPdmFlag());
      ps.setString(10, data.getReserveField1());
      ps.setString(11, data.getReserveField2());
      ps.setString(12, data.getLogUser());
      DateUtils.setDateTz(ps, 13, data.getLogTime());
      ps.setString(14, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<RouterOperationChangeLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RouterOperationChangeLog data : dataList) {
        ps.setString(1, data.getCustomerId());
        ps.setString(2, data.getDeviceName());
        ps.setString(3, data.getRouterName());
        ps.setString(4, data.getPackageName());
        ps.setString(5, data.getDeviceBo());
        ps.setString(6, data.getRouterBo());
        ps.setString(7, data.getPackageBo());
        ps.setString(8, data.getChangeType());
        ps.setString(9, data.getPdmFlag());
        ps.setString(10, data.getReserveField1());
        ps.setString(11, data.getReserveField2());
        ps.setString(12, data.getLogUser());
        DateUtils.setDateTz(ps, 13, data.getLogTime());
        ps.setString(14, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_router_operation_change_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<RouterOperationChangeLog> selectAll() throws SQLException {
    ArrayList<RouterOperationChangeLog> result = new ArrayList<RouterOperationChangeLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public RouterOperationChangeLog selectByPK(String id) throws SQLException {
    RouterOperationChangeLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private RouterOperationChangeLog convert(ResultSet rs) throws SQLException {
    RouterOperationChangeLog data = new RouterOperationChangeLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setCustomerId(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setRouterName(rs.getString(index++));
    data.setPackageName(rs.getString(index++));
    data.setDeviceBo(rs.getString(index++));
    data.setRouterBo(rs.getString(index++));
    data.setPackageBo(rs.getString(index++));
    data.setChangeType(rs.getString(index++));
    data.setPdmFlag(rs.getString(index++));
    data.setReserveField1(rs.getString(index++));
    data.setReserveField2(rs.getString(index++));
    data.setLogUser(rs.getString(index++));
    data.setLogTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
