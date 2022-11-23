package ame.psb.db.dao;

import ame.psb.db.ZhOaApproval;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZhOaApprovalDao {

  private static final String SQL_INS = "INSERT INTO zh_oa_approval(request_id,form_name,form_status,customer,customer_device,device,customer_lot,wafer_list,scheduled_start_date,scheduled_comp_date,remark,created_date_time,create_user,updated_time,first_make_flag,department,update_user,leader_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_oa_approval SET form_name=?,form_status=?,customer=?,customer_device=?,device=?,wafer_list=?,scheduled_start_date=?,scheduled_comp_date=?,remark=?,created_date_time=?,create_user=?,updated_time=?,first_make_flag=?,department=?,update_user=?,leader_user=? WHERE request_id=? AND customer_lot=?";

  private static final String SQL_SEL = "SELECT request_id,form_name,form_status,customer,customer_device,device,customer_lot,wafer_list,scheduled_start_date,scheduled_comp_date,remark,created_date_time,create_user,updated_time,first_make_flag,department,update_user,leader_user FROM zh_oa_approval ";

  private final Connection conn;

  public ZhOaApprovalDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZhOaApproval data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getRequestId());
      ps.setString(2, data.getFormName());
      ps.setString(3, data.getFormStatus());
      ps.setString(4, data.getCustomer());
      ps.setString(5, data.getCustomerDevice());
      ps.setString(6, data.getDevice());
      ps.setString(7, data.getCustomerLot());
      ps.setString(8, data.getWaferList());
      DateUtils.setDateTz(ps, 9, data.getScheduledStartDate());
      DateUtils.setDateTz(ps, 10, data.getScheduledCompDate());
      ps.setString(11, data.getRemark());
      DateUtils.setDateTz(ps, 12, data.getCreatedDateTime());
      ps.setString(13, data.getCreateUser());
      DateUtils.setDateTz(ps, 14, data.getUpdatedTime());
      ps.setBoolean(15, data.getFirstMakeFlag());
      ps.setString(16, data.getDepartment());
      ps.setString(17, data.getUpdateUser());
      ps.setString(18, data.getLeaderUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZhOaApproval> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZhOaApproval data : dataList) {
        ps.setString(1, data.getRequestId());
        ps.setString(2, data.getFormName());
        ps.setString(3, data.getFormStatus());
        ps.setString(4, data.getCustomer());
        ps.setString(5, data.getCustomerDevice());
        ps.setString(6, data.getDevice());
        ps.setString(7, data.getCustomerLot());
        ps.setString(8, data.getWaferList());
        DateUtils.setDateTz(ps, 9, data.getScheduledStartDate());
        DateUtils.setDateTz(ps, 10, data.getScheduledCompDate());
        ps.setString(11, data.getRemark());
        DateUtils.setDateTz(ps, 12, data.getCreatedDateTime());
        ps.setString(13, data.getCreateUser());
        DateUtils.setDateTz(ps, 14, data.getUpdatedTime());
        ps.setBoolean(15, data.getFirstMakeFlag());
        ps.setString(16, data.getDepartment());
        ps.setString(17, data.getUpdateUser());
        ps.setString(18, data.getLeaderUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZhOaApproval data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFormName());
      ps.setString(2, data.getFormStatus());
      ps.setString(3, data.getCustomer());
      ps.setString(4, data.getCustomerDevice());
      ps.setString(5, data.getDevice());
      ps.setString(6, data.getWaferList());
      DateUtils.setDateTz(ps, 7, data.getScheduledStartDate());
      DateUtils.setDateTz(ps, 8, data.getScheduledCompDate());
      ps.setString(9, data.getRemark());
      DateUtils.setDateTz(ps, 10, data.getCreatedDateTime());
      ps.setString(11, data.getCreateUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
      ps.setBoolean(13, data.getFirstMakeFlag());
      ps.setString(14, data.getDepartment());
      ps.setString(15, data.getUpdateUser());
      ps.setString(16, data.getLeaderUser());
      ps.setString(17, data.getRequestId());
      ps.setString(18, data.getCustomerLot());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZhOaApproval> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZhOaApproval data : dataList) {
        ps.setString(1, data.getFormName());
        ps.setString(2, data.getFormStatus());
        ps.setString(3, data.getCustomer());
        ps.setString(4, data.getCustomerDevice());
        ps.setString(5, data.getDevice());
        ps.setString(6, data.getWaferList());
        DateUtils.setDateTz(ps, 7, data.getScheduledStartDate());
        DateUtils.setDateTz(ps, 8, data.getScheduledCompDate());
        ps.setString(9, data.getRemark());
        DateUtils.setDateTz(ps, 10, data.getCreatedDateTime());
        ps.setString(11, data.getCreateUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
        ps.setBoolean(13, data.getFirstMakeFlag());
        ps.setString(14, data.getDepartment());
        ps.setString(15, data.getUpdateUser());
        ps.setString(16, data.getLeaderUser());
        ps.setString(17, data.getRequestId());
        ps.setString(18, data.getCustomerLot());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String requestId, String customerLot) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zh_oa_approval WHERE request_id=? AND customer_lot=?")) {
      ps.setString(1, requestId);
      ps.setString(2, customerLot);

      return ps.executeUpdate();
    }
  }

  public List<ZhOaApproval> selectAll() throws SQLException {
    ArrayList<ZhOaApproval> result = new ArrayList<ZhOaApproval>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZhOaApproval selectByPK(String requestId, String customerLot) throws SQLException {
    ZhOaApproval result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE request_id=? AND customer_lot=?")) {
      ps.setString(1, requestId);
      ps.setString(2, customerLot);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  //一个机种只会有一条首次制样的记录 --cc
  public ZhOaApproval selectByDeviceAndFlag(String device, boolean firstMakeFlag)
      throws SQLException {
    ZhOaApproval result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE device=? AND first_make_flag=? ")) {
      ps.setString(1, device);
      ps.setBoolean(2, firstMakeFlag);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZhOaApproval convert(ResultSet rs) throws SQLException {
    ZhOaApproval data = new ZhOaApproval();

    int index = 1;
    data.setRequestId(rs.getString(index++));
    data.setFormName(rs.getString(index++));
    data.setFormStatus(rs.getString(index++));
    data.setCustomer(rs.getString(index++));
    data.setCustomerDevice(rs.getString(index++));
    data.setDevice(rs.getString(index++));
    data.setCustomerLot(rs.getString(index++));
    data.setWaferList(rs.getString(index++));
    data.setScheduledStartDate(DateUtils.getDateTz(rs, index++));
    data.setScheduledCompDate(DateUtils.getDateTz(rs, index++));
    data.setRemark(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setCreateUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setFirstMakeFlag(rs.getBoolean(index++));
    data.setDepartment(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setLeaderUser(rs.getString(index++));

    return data;
  }
}
