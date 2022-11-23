package ame.psb.db.dao;

import ame.psb.db.ResourceCarrierLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ResourceCarrierLogDao {

  private static final String SQL_INS = "INSERT INTO zd_resource_carrier_log(id,resource_bo,carrier_bo,resource_name,carrier_name,action,lp,reserve_field1,reserve_field2,log_user,log_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_resource_carrier_log SET resource_bo=?,carrier_bo=?,resource_name=?,carrier_name=?,action=?,lp=?,reserve_field1=?,reserve_field2=?,log_user=?,log_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resource_bo,carrier_bo,resource_name,carrier_name,action,lp,reserve_field1,reserve_field2,log_user,log_time FROM zd_resource_carrier_log ";

  private final Connection conn;

  public ResourceCarrierLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ResourceCarrierLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getCarrierBo());
      ps.setString(4, data.getResourceName());
      ps.setString(5, data.getCarrierName());
      ps.setString(6, data.getAction());
      ps.setString(7, data.getLp());
      ps.setString(8, data.getReserveField1());
      ps.setString(9, data.getReserveField2());
      ps.setString(10, data.getLogUser());
      DateUtils.setDateTz(ps, 11, data.getLogTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ResourceCarrierLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ResourceCarrierLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getCarrierBo());
        ps.setString(4, data.getResourceName());
        ps.setString(5, data.getCarrierName());
        ps.setString(6, data.getAction());
        ps.setString(7, data.getLp());
        ps.setString(8, data.getReserveField1());
        ps.setString(9, data.getReserveField2());
        ps.setString(10, data.getLogUser());
        DateUtils.setDateTz(ps, 11, data.getLogTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ResourceCarrierLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getCarrierBo());
      ps.setString(3, data.getResourceName());
      ps.setString(4, data.getCarrierName());
      ps.setString(5, data.getAction());
      ps.setString(6, data.getLp());
      ps.setString(7, data.getReserveField1());
      ps.setString(8, data.getReserveField2());
      ps.setString(9, data.getLogUser());
      DateUtils.setDateTz(ps, 10, data.getLogTime());
      ps.setString(11, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ResourceCarrierLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ResourceCarrierLog data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getCarrierBo());
        ps.setString(3, data.getResourceName());
        ps.setString(4, data.getCarrierName());
        ps.setString(5, data.getAction());
        ps.setString(6, data.getLp());
        ps.setString(7, data.getReserveField1());
        ps.setString(8, data.getReserveField2());
        ps.setString(9, data.getLogUser());
        DateUtils.setDateTz(ps, 10, data.getLogTime());
        ps.setString(11, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_resource_carrier_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ResourceCarrierLog> selectAll() throws SQLException {
    ArrayList<ResourceCarrierLog> result = new ArrayList<ResourceCarrierLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ResourceCarrierLog selectByPK(String id) throws SQLException {
    ResourceCarrierLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ResourceCarrierLog convert(ResultSet rs) throws SQLException {
    ResourceCarrierLog data = new ResourceCarrierLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setCarrierBo(rs.getString(index++));
    data.setResourceName(rs.getString(index++));
    data.setCarrierName(rs.getString(index++));
    data.setAction(rs.getString(index++));
    data.setLp(rs.getString(index++));
    data.setReserveField1(rs.getString(index++));
    data.setReserveField2(rs.getString(index++));
    data.setLogUser(rs.getString(index++));
    data.setLogTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
