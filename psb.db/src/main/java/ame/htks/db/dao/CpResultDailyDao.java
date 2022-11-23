package ame.htks.db.dao;

import ame.htks.db.CpResultDaily;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CpResultDailyDao {

  private static final String SQL_INS = "INSERT INTO zh_cp_result_daily(id,wafer_id,customer,device_name,customer_lot,index_x,index_y,wafer_size,of_direction,pass_qty,total_qty,fail_qty,start_time,end_time,updated_time,operation_bo,run_sfc_item_bo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_cp_result_daily SET id=?,customer=?,device_name=?,customer_lot=?,index_x=?,index_y=?,wafer_size=?,of_direction=?,pass_qty=?,total_qty=?,fail_qty=?,start_time=?,end_time=?,run_sfc_item_bo=? WHERE wafer_id=? AND updated_time=? AND operation_bo=?";

  private static final String SQL_SEL = "SELECT id,wafer_id,customer,device_name,customer_lot,index_x,index_y,wafer_size,of_direction,pass_qty,total_qty,fail_qty,start_time,end_time,updated_time,operation_bo,run_sfc_item_bo FROM zh_cp_result_daily ";

  private final Connection conn;

  public CpResultDailyDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CpResultDaily data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getWaferId());
      ps.setString(3, data.getCustomer());
      ps.setString(4, data.getDeviceName());
      ps.setString(5, data.getCustomerLot());
      ps.setString(6, data.getIndexX());
      ps.setString(7, data.getIndexY());
      ps.setString(8, data.getWaferSize());
      ps.setString(9, data.getOfDirection());
      ps.setString(10, data.getPassQty());
      ps.setString(11, data.getTotalQty());
      ps.setString(12, data.getFailQty());
      DateUtils.setDateTz(ps, 13, data.getStartTime());
      DateUtils.setDateTz(ps, 14, data.getEndTime());
      DateUtils.setDateTz(ps, 15, data.getUpdatedTime());
      ps.setString(16, data.getOperationBo());
      ps.setString(17, data.getRunSfcItemBo());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CpResultDaily> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CpResultDaily data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getWaferId());
        ps.setString(3, data.getCustomer());
        ps.setString(4, data.getDeviceName());
        ps.setString(5, data.getCustomerLot());
        ps.setString(6, data.getIndexX());
        ps.setString(7, data.getIndexY());
        ps.setString(8, data.getWaferSize());
        ps.setString(9, data.getOfDirection());
        ps.setString(10, data.getPassQty());
        ps.setString(11, data.getTotalQty());
        ps.setString(12, data.getFailQty());
        DateUtils.setDateTz(ps, 13, data.getStartTime());
        DateUtils.setDateTz(ps, 14, data.getEndTime());
        DateUtils.setDateTz(ps, 15, data.getUpdatedTime());
        ps.setString(16, data.getOperationBo());
        ps.setString(17, data.getRunSfcItemBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CpResultDaily data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getCustomer());
      ps.setString(3, data.getDeviceName());
      ps.setString(4, data.getCustomerLot());
      ps.setString(5, data.getIndexX());
      ps.setString(6, data.getIndexY());
      ps.setString(7, data.getWaferSize());
      ps.setString(8, data.getOfDirection());
      ps.setString(9, data.getPassQty());
      ps.setString(10, data.getTotalQty());
      ps.setString(11, data.getFailQty());
      DateUtils.setDateTz(ps, 12, data.getStartTime());
      DateUtils.setDateTz(ps, 13, data.getEndTime());
      ps.setString(14, data.getRunSfcItemBo());
      ps.setString(15, data.getWaferId());
      DateUtils.setDateTz(ps, 16, data.getUpdatedTime());
      ps.setString(17, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<CpResultDaily> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CpResultDaily data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getCustomer());
        ps.setString(3, data.getDeviceName());
        ps.setString(4, data.getCustomerLot());
        ps.setString(5, data.getIndexX());
        ps.setString(6, data.getIndexY());
        ps.setString(7, data.getWaferSize());
        ps.setString(8, data.getOfDirection());
        ps.setString(9, data.getPassQty());
        ps.setString(10, data.getTotalQty());
        ps.setString(11, data.getFailQty());
        DateUtils.setDateTz(ps, 12, data.getStartTime());
        DateUtils.setDateTz(ps, 13, data.getEndTime());
        ps.setString(14, data.getRunSfcItemBo());
        ps.setString(15, data.getWaferId());
        DateUtils.setDateTz(ps, 16, data.getUpdatedTime());
        ps.setString(17, data.getOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String waferId, Date updatedTime, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zh_cp_result_daily WHERE wafer_id=? AND updated_time=? AND operation_bo=?")) {
      ps.setString(1, waferId);
      DateUtils.setDateTz(ps, 2, updatedTime);
      ps.setString(3, operationBo);

      return ps.executeUpdate();
    }
  }

  public List<CpResultDaily> selectAll() throws SQLException {
    ArrayList<CpResultDaily> result = new ArrayList<CpResultDaily>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public CpResultDaily selectByPK(String waferId, Date updatedTime, String operationBo)
      throws SQLException {
    CpResultDaily result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE wafer_id=? AND updated_time=? AND operation_bo=?")) {
      ps.setString(1, waferId);
      DateUtils.setDateTz(ps, 2, updatedTime);
      ps.setString(3, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private CpResultDaily convert(ResultSet rs) throws SQLException {
    CpResultDaily data = new CpResultDaily();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setWaferId(rs.getString(index++));
    data.setCustomer(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setCustomerLot(rs.getString(index++));
    data.setIndexX(rs.getString(index++));
    data.setIndexY(rs.getString(index++));
    data.setWaferSize(rs.getString(index++));
    data.setOfDirection(rs.getString(index++));
    data.setPassQty(rs.getString(index++));
    data.setTotalQty(rs.getString(index++));
    data.setFailQty(rs.getString(index++));
    data.setStartTime(DateUtils.getDateTz(rs, index++));
    data.setEndTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setOperationBo(rs.getString(index++));
    data.setRunSfcItemBo(rs.getString(index++));

    return data;
  }
}
