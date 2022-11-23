package ame.htks.db.dao;

import ame.htks.db.OfficeAutomationApproval;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class OfficeAutomationApprovalDao {

  private static final String SQL_INS = "INSERT INTO zh_oa_approval(request_id,form_name,form_status,customer,customer_device,device,customer_lot,wafer_list,scheduled_start_date,scheduled_comp_date,remark,created_date_time,create_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_oa_approval SET form_name=?,form_status=?,customer=?,customer_device=?,device=?,customer_lot=?,wafer_list=?,scheduled_start_date=?,scheduled_comp_date=?,remark=?,created_date_time=?,create_user=?,updated_time=? WHERE request_id=?";

  private static final String SQL_SEL = "SELECT request_id,form_name,form_status,customer,customer_device,device,customer_lot,wafer_list,scheduled_start_date,scheduled_comp_date,remark,created_date_time,create_user,updated_time FROM zh_oa_approval ";

  private final Connection conn;

  public OfficeAutomationApprovalDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(OfficeAutomationApproval data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getRequestId());
      ps.setString(2, data.getFormName());
      ps.setString(3, data.getFormStatus());
      ps.setString(4, data.getCustomer());
      ps.setString(5, data.getCustomerDevice());
      ps.setString(6, data.getDevice());
      ps.setString(7, data.getCustomerLot());
      ps.setString(8, data.getWaferList());
      DateUtils.setDate(ps, 9, data.getScheduledStartDate());
      DateUtils.setDate(ps, 10, data.getScheduledCompDate());
      ps.setString(11, data.getRemark());
      DateUtils.setDate(ps, 12, data.getCreatedDateTime());
      ps.setString(13, data.getCreateUser());
      DateUtils.setDate(ps, 14, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<OfficeAutomationApproval> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (OfficeAutomationApproval data : dataList) {
        ps.setString(1, data.getRequestId());
        ps.setString(2, data.getFormName());
        ps.setString(3, data.getFormStatus());
        ps.setString(4, data.getCustomer());
        ps.setString(5, data.getCustomerDevice());
        ps.setString(6, data.getDevice());
        ps.setString(7, data.getCustomerLot());
        ps.setString(8, data.getWaferList());
        DateUtils.setDate(ps, 9, data.getScheduledStartDate());
        DateUtils.setDate(ps, 10, data.getScheduledCompDate());
        ps.setString(11, data.getRemark());
        DateUtils.setDate(ps, 12, data.getCreatedDateTime());
        ps.setString(13, data.getCreateUser());
        DateUtils.setDate(ps, 14, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(OfficeAutomationApproval data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFormName());
      ps.setString(2, data.getFormStatus());
      ps.setString(3, data.getCustomer());
      ps.setString(4, data.getCustomerDevice());
      ps.setString(5, data.getDevice());
      ps.setString(6, data.getCustomerLot());
      ps.setString(7, data.getWaferList());
      DateUtils.setDate(ps, 8, data.getScheduledStartDate());
      DateUtils.setDate(ps, 9, data.getScheduledCompDate());
      ps.setString(10, data.getRemark());
      DateUtils.setDate(ps, 11, data.getCreatedDateTime());
      ps.setString(12, data.getCreateUser());
      DateUtils.setDate(ps, 13, data.getUpdatedTime());
      ps.setString(14, data.getRequestId());

      return ps.executeUpdate();
    }
  }

  public int update(List<OfficeAutomationApproval> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (OfficeAutomationApproval data : dataList) {
        ps.setString(1, data.getFormName());
        ps.setString(2, data.getFormStatus());
        ps.setString(3, data.getCustomer());
        ps.setString(4, data.getCustomerDevice());
        ps.setString(5, data.getDevice());
        ps.setString(6, data.getCustomerLot());
        ps.setString(7, data.getWaferList());
        DateUtils.setDate(ps, 8, data.getScheduledStartDate());
        DateUtils.setDate(ps, 9, data.getScheduledCompDate());
        ps.setString(10, data.getRemark());
        DateUtils.setDate(ps, 11, data.getCreatedDateTime());
        ps.setString(12, data.getCreateUser());
        DateUtils.setDate(ps, 13, data.getUpdatedTime());
        ps.setString(14, data.getRequestId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String requestId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zh_oa_approval WHERE request_id=?")) {
      ps.setString(1, requestId);

      return ps.executeUpdate();
    }
  }

  public List<OfficeAutomationApproval> selectAll() throws SQLException {
    ArrayList<OfficeAutomationApproval> result = new ArrayList<OfficeAutomationApproval>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OfficeAutomationApproval> selectByCustomerLot(String customerLot)
      throws SQLException {
    ArrayList<OfficeAutomationApproval> result = new ArrayList<OfficeAutomationApproval>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE customer_lot=?")) {
      ps.setString(1, customerLot);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OfficeAutomationApproval> selectBuyoffByDevice(String device) throws SQLException {
    ArrayList<OfficeAutomationApproval> result = new ArrayList<OfficeAutomationApproval>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE device=? and status = 'BUYOFF' ")) {
      ps.setString(1, device);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public OfficeAutomationApproval selectByPK(String requestId) throws SQLException {
    OfficeAutomationApproval result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE request_id=?")) {
      ps.setString(1, requestId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private OfficeAutomationApproval convert(ResultSet rs) throws SQLException {
    OfficeAutomationApproval data = new OfficeAutomationApproval();

    int index = 1;
    data.setRequestId(rs.getString(index++));
    data.setFormName(rs.getString(index++));
    data.setFormStatus(rs.getString(index++));
    data.setCustomer(rs.getString(index++));
    data.setCustomerDevice(rs.getString(index++));
    data.setDevice(rs.getString(index++));
    data.setCustomerLot(rs.getString(index++));
    data.setWaferList(rs.getString(index++));
    data.setScheduledStartDate(rs.getTimestamp(index++));
    data.setScheduledCompDate(rs.getTimestamp(index++));
    data.setRemark(rs.getString(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));
    data.setCreateUser(rs.getString(index++));
    data.setUpdatedTime(rs.getTimestamp(index++));

    return data;
  }
}
