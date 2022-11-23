package ame.psb.db.dao;

import ame.psb.db.ZrCpTestTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZrCpTestTimeDao {

  private static final String SQL_INS = "INSERT INTO zr_cp_test_time(customer_item_bo,operation_bo,date_time,cost_time,shop_order,sfc_name,tester_program,tester,device_name,updated_user) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_cp_test_time SET cost_time=?,shop_order=?,sfc_name=?,tester_program=?,tester=?,device_name=?,flag=?,cdp_status=?,updated_user=? WHERE customer_item_bo=? AND operation_bo=? AND date_time=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,operation_bo,date_time,cost_time,shop_order,sfc_name,tester_program,tester,device_name,flag,cdp_status,updated_user FROM zr_cp_test_time ";

  private final Connection conn;

  public ZrCpTestTimeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZrCpTestTime data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getOperationBo());
      DateUtils.setDateTz(ps, 3, data.getDateTime());
      ps.setBigDecimal(4, data.getCostTime());
      ps.setString(5, data.getShopOrder());
      ps.setString(6, data.getSfcName());
      ps.setString(7, data.getTesterProgram());
      ps.setString(8, data.getTester());
      ps.setString(9, data.getDeviceName());
      //ps.setString(10, data.getFlag());
      //ps.setString(11, data.getCdpStatus());
      ps.setString(10, data.getUpdatedUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZrCpTestTime> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZrCpTestTime data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getOperationBo());
        DateUtils.setDateTz(ps, 3, data.getDateTime());
        ps.setBigDecimal(4, data.getCostTime());
        ps.setString(5, data.getShopOrder());
        ps.setString(6, data.getSfcName());
        ps.setString(7, data.getTesterProgram());
        ps.setString(8, data.getTester());
        ps.setString(9, data.getDeviceName());
        //ps.setString(10, data.getFlag());
        //ps.setString(11, data.getCdpStatus());
        ps.setString(10, data.getUpdatedUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZrCpTestTime data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getCostTime());
      ps.setString(2, data.getShopOrder());
      ps.setString(3, data.getSfcName());
      ps.setString(4, data.getTesterProgram());
      ps.setString(5, data.getTester());
      ps.setString(6, data.getDeviceName());
      ps.setString(7, data.getFlag());
      ps.setString(8, data.getCdpStatus());
      ps.setString(9, data.getUpdatedUser());

      ps.setString(10, data.getCustomerItemBo());
      ps.setString(11, data.getOperationBo());
      DateUtils.setDateTz(ps, 12, data.getDateTime());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZrCpTestTime> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZrCpTestTime data : dataList) {
        ps.setBigDecimal(1, data.getCostTime());
        ps.setString(2, data.getShopOrder());
        ps.setString(3, data.getSfcName());
        ps.setString(4, data.getTesterProgram());
        ps.setString(5, data.getTester());
        ps.setString(6, data.getDeviceName());
        ps.setString(7, data.getFlag());
        ps.setString(8, data.getCdpStatus());
        ps.setString(9, data.getUpdatedUser());

        ps.setString(10, data.getCustomerItemBo());
        ps.setString(11, data.getOperationBo());
        DateUtils.setDateTz(ps, 12, data.getDateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerItemBo, String operationBo, Date dateTime) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_cp_test_time WHERE customer_item_bo=? AND operation_bo=? AND date_time=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);
      DateUtils.setDateTz(ps, 3, dateTime);

      return ps.executeUpdate();
    }
  }

  public List<ZrCpTestTime> selectAll() throws SQLException {
    ArrayList<ZrCpTestTime> result = new ArrayList<ZrCpTestTime>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZrCpTestTime selectByPK(String customerItemBo, String operationBo, Date dateTime)
      throws SQLException {
    ZrCpTestTime result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE customer_item_bo=? AND operation_bo=? AND date_time=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);
      DateUtils.setDateTz(ps, 3, dateTime);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ZrCpTestTime selectByActive(String customerItemBo, String operationBo)
      throws SQLException {
    ZrCpTestTime result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE customer_item_bo=? AND operation_bo=? ORDER BY DATE_TIME DESC LIMIT 1")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZrCpTestTime convert(ResultSet rs) throws SQLException {
    ZrCpTestTime data = new ZrCpTestTime();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDateTime(DateUtils.getDateTz(rs, index++));
    data.setCostTime(rs.getBigDecimal(index++));
    data.setShopOrder(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setTesterProgram(rs.getString(index++));
    data.setTester(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setFlag(rs.getString(index++));
    data.setCdpStatus(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));

    return data;
  }
}
