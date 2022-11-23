package ame.psb.db.dao;

import com.google.common.base.Strings;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.HoldHandlerManualInk;
import uia.utils.dao.DateUtils;

public class HoldHandlerManualInkDao {

  private static final String SQL_INS = "INSERT INTO zr_hold_handler_manual_ink(id,ink_type,customer_agree_flag,customer_code,device_name,sfc_name,operation_name,lot_name,customer_mail_address,state_name,load_map_excel,upload_ink_excel,report_excel,updated_time,updated_user,apply_time,apply_user,hold_release_bo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_hold_handler_manual_ink SET ink_type=?,customer_agree_flag=?,customer_code=?,device_name=?,sfc_name=?,operation_name=?,lot_name=?,customer_mail_address=?,state_name=?,load_map_excel=?,upload_ink_excel=?,report_excel=?,updated_time=?,updated_user=?,apply_time=?,apply_user=?,hold_release_bo=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,ink_type,customer_agree_flag,customer_code,device_name,sfc_name,operation_name,lot_name,customer_mail_address,state_name,load_map_excel,upload_ink_excel,report_excel,updated_time,updated_user,apply_time,apply_user,hold_release_bo FROM zr_hold_handler_manual_ink ";

  private final Connection conn;

  public HoldHandlerManualInkDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(HoldHandlerManualInk data) throws SQLException {
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
      DateUtils.setDateTz(ps, 16, data.getApplyTime());
      ps.setString(17, data.getApplyUser());
      ps.setString(18, data.getHoldReleaseBo());

      return ps.executeUpdate();
    }
  }

  public int insert(List<HoldHandlerManualInk> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (HoldHandlerManualInk data : dataList) {
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
        DateUtils.setDateTz(ps, 16, data.getApplyTime());
        ps.setString(17, data.getApplyUser());
        ps.setString(18, data.getHoldReleaseBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(HoldHandlerManualInk data) throws SQLException {
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
      DateUtils.setDateTz(ps, 15, data.getApplyTime());
      ps.setString(16, data.getApplyUser());
      ps.setString(17, data.getHoldReleaseBo());
      ps.setString(18, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<HoldHandlerManualInk> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (HoldHandlerManualInk data : dataList) {
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
        DateUtils.setDateTz(ps, 15, data.getApplyTime());
        ps.setString(16, data.getApplyUser());
        ps.setString(17, data.getHoldReleaseBo());
        ps.setString(18, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_hold_handler_manual_ink WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<HoldHandlerManualInk> selectAll() throws SQLException {
    ArrayList<HoldHandlerManualInk> result = new ArrayList<HoldHandlerManualInk>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public HoldHandlerManualInk selectByPK(String id) throws SQLException {
    HoldHandlerManualInk result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public HoldHandlerManualInk selectByPK(String inkType, String sfcName) throws SQLException {
    HoldHandlerManualInk result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE ink_type = ? AND sfc_name = ? AND state_name not in('COMMIT','CANCEL')")) {
      ps.setString(1, inkType);
      ps.setString(2, sfcName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<HoldHandlerManualInk> selectByCheck(String sfcName, boolean containFinish)
      throws SQLException {
    ArrayList<HoldHandlerManualInk> result = new ArrayList<HoldHandlerManualInk>();

    String sql = SQL_SEL + "WHERE 1 = 1";
    if (!Strings.isNullOrEmpty(sfcName)) {
      sql += " AND sfc_name = '" + sfcName + "'  ";
    }
    if (!containFinish) {
      sql += " AND state_name not in('COMMIT','CANCEL') ";
    }
    try (PreparedStatement ps = this.conn.prepareStatement(sql)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private HoldHandlerManualInk convert(ResultSet rs) throws SQLException {
    HoldHandlerManualInk data = new HoldHandlerManualInk();

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
    data.setApplyTime(DateUtils.getDateTz(rs, index++));
    data.setApplyUser(rs.getString(index++));
    data.setHoldReleaseBo(rs.getString(index++));

    return data;
  }
}
