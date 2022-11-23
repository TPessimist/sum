package ame.psb.db.dao;

import ame.psb.db.AutoVerifyGoldenWafer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class AutoVerifyGoldenWaferDao {

  private static final String SQL_INS = "INSERT INTO zr_auto_verify_golden_wafer(id,resource_bo,golden_wafer,operation_bo,shop_order_bo,shop_order_name,device_bo,device_name,state_name,update_user,update_time,reserve1,reserve2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_auto_verify_golden_wafer SET resource_bo=?,golden_wafer=?,operation_bo=?,shop_order_bo=?,shop_order_name=?,device_bo=?,device_name=?,state_name=?,update_user=?,update_time=?,reserve1=?,reserve2=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resource_bo,golden_wafer,operation_bo,shop_order_bo,shop_order_name,device_bo,device_name,state_name,update_user,update_time,reserve1,reserve2 FROM zr_auto_verify_golden_wafer ";

  private final Connection conn;

  public AutoVerifyGoldenWaferDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(AutoVerifyGoldenWafer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getGoldenWafer());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getShopOrderBo());
      ps.setString(6, data.getShopOrderName());
      ps.setString(7, data.getDeviceBo());
      ps.setString(8, data.getDeviceName());
      ps.setString(9, data.getStateName());
      ps.setString(10, data.getUpdateUser());
      DateUtils.setDateTz(ps, 11, data.getUpdateTime());
      ps.setString(12, data.getReserve1());
      ps.setString(13, data.getReserve2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<AutoVerifyGoldenWafer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (AutoVerifyGoldenWafer data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getGoldenWafer());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getShopOrderBo());
        ps.setString(6, data.getShopOrderName());
        ps.setString(7, data.getDeviceBo());
        ps.setString(8, data.getDeviceName());
        ps.setString(9, data.getStateName());
        ps.setString(10, data.getUpdateUser());
        DateUtils.setDateTz(ps, 11, data.getUpdateTime());
        ps.setString(12, data.getReserve1());
        ps.setString(13, data.getReserve2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(AutoVerifyGoldenWafer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getGoldenWafer());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getShopOrderBo());
      ps.setString(5, data.getShopOrderName());
      ps.setString(6, data.getDeviceBo());
      ps.setString(7, data.getDeviceName());
      ps.setString(8, data.getStateName());
      ps.setString(9, data.getUpdateUser());
      DateUtils.setDateTz(ps, 10, data.getUpdateTime());
      ps.setString(11, data.getReserve1());
      ps.setString(12, data.getReserve2());
      ps.setString(13, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<AutoVerifyGoldenWafer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (AutoVerifyGoldenWafer data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getGoldenWafer());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getShopOrderBo());
        ps.setString(5, data.getShopOrderName());
        ps.setString(6, data.getDeviceBo());
        ps.setString(7, data.getDeviceName());
        ps.setString(8, data.getStateName());
        ps.setString(9, data.getUpdateUser());
        DateUtils.setDateTz(ps, 10, data.getUpdateTime());
        ps.setString(11, data.getReserve1());
        ps.setString(12, data.getReserve2());
        ps.setString(13, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateState(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "UPDATE zr_auto_verify_golden_wafer SET state_name='DELETE' WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_auto_verify_golden_wafer WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<AutoVerifyGoldenWafer> selectAll() throws SQLException {
    ArrayList<AutoVerifyGoldenWafer> result = new ArrayList<AutoVerifyGoldenWafer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<AutoVerifyGoldenWafer> select(Where where) throws SQLException {
    ArrayList<AutoVerifyGoldenWafer> result = new ArrayList<AutoVerifyGoldenWafer>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public AutoVerifyGoldenWafer selectByPK(String id) throws SQLException {
    AutoVerifyGoldenWafer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public AutoVerifyGoldenWafer selectByResourceAndWaferAndShopOrder(String resource,
      String goldenWafer, String operation, String shopOrderName, String stateName)
      throws SQLException {
    AutoVerifyGoldenWafer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE resource_bo=? and golden_wafer=? and operation_bo=? and shop_order_name=? and state_name=?")) {
      ps.setString(1, resource);
      ps.setString(2, goldenWafer);
      ps.setString(3, operation);
      ps.setString(4, shopOrderName);
      ps.setString(5, stateName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public AutoVerifyGoldenWafer selectByResourceAndState(String resource,
      String stateName) throws SQLException {
    AutoVerifyGoldenWafer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE resource_bo=? and state_name=?")) {
      ps.setString(1, resource);
      ps.setString(2, stateName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public AutoVerifyGoldenWafer selectByShopOrderAndState(String shopOrderName,
      String stateName) throws SQLException {
    AutoVerifyGoldenWafer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE shop_order_name=? and state_name=?")) {
      ps.setString(1, shopOrderName);
      ps.setString(2, stateName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public AutoVerifyGoldenWafer selectByWaferAndState(String goldenWafer,
      String stateName) throws SQLException {
    AutoVerifyGoldenWafer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE golden_wafer=? and state_name=?")) {
      ps.setString(1, goldenWafer);
      ps.setString(2, stateName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private AutoVerifyGoldenWafer convert(ResultSet rs) throws SQLException {
    AutoVerifyGoldenWafer data = new AutoVerifyGoldenWafer();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setGoldenWafer(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setDeviceBo(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setReserve1(rs.getString(index++));
    data.setReserve2(rs.getString(index++));

    return data;
  }
}
