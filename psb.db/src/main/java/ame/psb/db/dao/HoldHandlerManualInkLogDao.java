package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.HoldHandlerManualInkLog;
import uia.utils.dao.DateUtils;

public class HoldHandlerManualInkLogDao {

  private static final String SQL_INS = "INSERT INTO zr_hold_handler_manual_ink_log(id,ink_type,customer_agree_flag,customer_code,device_name,sfc_name,operation_name,lot_name,customer_mail_address,state_name,load_map_excel,upload_ink_excel,report_excel,updated_time,updated_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_hold_handler_manual_ink_log SET ink_type=?,customer_agree_flag=?,customer_code=?,device_name=?,sfc_name=?,operation_name=?,lot_name=?,customer_mail_address=?,state_name=?,load_map_excel=?,upload_ink_excel=?,report_excel=?,updated_time=?,updated_user=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,ink_type,customer_agree_flag,customer_code,device_name,sfc_name,operation_name,lot_name,customer_mail_address,state_name,load_map_excel,upload_ink_excel,report_excel,updated_time,updated_user FROM zr_hold_handler_manual_ink_log ";

  private final Connection conn;

  public HoldHandlerManualInkLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(HoldHandlerManualInkLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getInkType());
      ps.setString(3, data.getCustomerAgreeFlag());
      ps.setString(4, data.getCustomerCode());
      ps.setString(5, data.getDeviceName());
      ps.setString(6, data.getSfcName());
      ps.setString(7, data.getOperationName());
      ps.setString(8, data.getLotName());
      ps.setString(9, data.getCustomerMailAddress());
      ps.setString(10, data.getStateName());
      ps.setString(11, data.getLoadMapExcel());
      ps.setString(12, data.getUploadInkExcel());
      ps.setString(13, data.getReportExcel());
      DateUtils.setDateTz(ps, 14, data.getUpdatedTime());
      ps.setString(15, data.getUpdatedUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<HoldHandlerManualInkLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (HoldHandlerManualInkLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getInkType());
        ps.setString(3, data.getCustomerAgreeFlag());
        ps.setString(4, data.getCustomerCode());
        ps.setString(5, data.getDeviceName());
        ps.setString(6, data.getSfcName());
        ps.setString(7, data.getOperationName());
        ps.setString(8, data.getLotName());
        ps.setString(9, data.getCustomerMailAddress());
        ps.setString(10, data.getStateName());
        ps.setString(11, data.getLoadMapExcel());
        ps.setString(12, data.getUploadInkExcel());
        ps.setString(13, data.getReportExcel());
        DateUtils.setDateTz(ps, 14, data.getUpdatedTime());
        ps.setString(15, data.getUpdatedUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(HoldHandlerManualInkLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getInkType());
      ps.setString(2, data.getCustomerAgreeFlag());
      ps.setString(3, data.getCustomerCode());
      ps.setString(4, data.getDeviceName());
      ps.setString(5, data.getSfcName());
      ps.setString(6, data.getOperationName());
      ps.setString(7, data.getLotName());
      ps.setString(8, data.getCustomerMailAddress());
      ps.setString(9, data.getStateName());
      ps.setString(10, data.getLoadMapExcel());
      ps.setString(11, data.getUploadInkExcel());
      ps.setString(12, data.getReportExcel());
      DateUtils.setDateTz(ps, 13, data.getUpdatedTime());
      ps.setString(14, data.getUpdatedUser());
      ps.setString(15, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<HoldHandlerManualInkLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (HoldHandlerManualInkLog data : dataList) {
        ps.setString(1, data.getInkType());
        ps.setString(2, data.getCustomerAgreeFlag());
        ps.setString(3, data.getCustomerCode());
        ps.setString(4, data.getDeviceName());
        ps.setString(5, data.getSfcName());
        ps.setString(6, data.getOperationName());
        ps.setString(7, data.getLotName());
        ps.setString(8, data.getCustomerMailAddress());
        ps.setString(9, data.getStateName());
        ps.setString(10, data.getLoadMapExcel());
        ps.setString(11, data.getUploadInkExcel());
        ps.setString(12, data.getReportExcel());
        DateUtils.setDateTz(ps, 13, data.getUpdatedTime());
        ps.setString(14, data.getUpdatedUser());
        ps.setString(15, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_hold_handler_manual_ink_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<HoldHandlerManualInkLog> selectAll() throws SQLException {
    ArrayList<HoldHandlerManualInkLog> result = new ArrayList<HoldHandlerManualInkLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public HoldHandlerManualInkLog selectByPK(String id) throws SQLException {
    HoldHandlerManualInkLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private HoldHandlerManualInkLog convert(ResultSet rs) throws SQLException {
    HoldHandlerManualInkLog data = new HoldHandlerManualInkLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setInkType(rs.getString(index++));
    data.setCustomerAgreeFlag(rs.getString(index++));
    data.setCustomerCode(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setOperationName(rs.getString(index++));
    data.setLotName(rs.getString(index++));
    data.setCustomerMailAddress(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setLoadMapExcel(rs.getString(index++));
    data.setUploadInkExcel(rs.getString(index++));
    data.setReportExcel(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));

    return data;
  }
}
