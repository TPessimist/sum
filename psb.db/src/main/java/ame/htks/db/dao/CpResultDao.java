package ame.htks.db.dao;

import ame.htks.db.CpResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CpResultDao {

  private static final String SQL_INS = "INSERT INTO zh_cp_result(id,wafer_id,customer,device_name,customer_lot,index_x,index_y,wafer_size,of_direction,pass_qty,total_qty,fail_qty,start_time,end_time,updated_time,operation_bo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_cp_result SET wafer_id=?,customer=?,device_name=?,customer_lot=?,index_x=?,index_y=?,wafer_size=?,of_direction=?,pass_qty=?,total_qty=?,fail_qty=?,start_time=?,end_time=?,updated_time=?,operation_bo=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,wafer_id,customer,device_name,customer_lot,index_x,index_y,wafer_size,of_direction,pass_qty,total_qty,fail_qty,start_time,end_time,updated_time,operation_bo FROM zh_cp_result ";

  private final Connection conn;

  public CpResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CpResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getWaferId());
      ps.setString(3, data.getCustomer());
      ps.setString(4, data.getDeviceName());
      ps.setString(5, data.getCustomerLot());
      ps.setInt(6, data.getIndexX());
      ps.setInt(7, data.getIndexY());
      ps.setInt(8, data.getWaferSize());
      ps.setInt(9, data.getOfDirection());
      ps.setInt(10, data.getPassQty());
      ps.setInt(11, data.getTotalQty());
      ps.setInt(12, data.getFailQty());
      ps.setTimestamp(13, new Timestamp(data.getStartTime().getTime()));
      ps.setTimestamp(14, new Timestamp(data.getEndTime().getTime()));
      ps.setTimestamp(15, new Timestamp(data.getUpdatedTime().getTime()));
      ps.setString(16, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CpResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CpResult data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getWaferId());
        ps.setString(3, data.getCustomer());
        ps.setString(4, data.getDeviceName());
        ps.setString(5, data.getCustomerLot());
        ps.setInt(6, data.getIndexX());
        ps.setInt(7, data.getIndexY());
        ps.setInt(8, data.getWaferSize());
        ps.setInt(9, data.getOfDirection());
        ps.setInt(10, data.getPassQty());
        ps.setInt(11, data.getTotalQty());
        ps.setInt(12, data.getFailQty());
        ps.setTimestamp(13, new Timestamp(data.getStartTime().getTime()));
        ps.setTimestamp(14, new Timestamp(data.getEndTime().getTime()));
        ps.setTimestamp(15, new Timestamp(data.getUpdatedTime().getTime()));
        ps.setString(16, data.getOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CpResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getWaferId());
      ps.setString(2, data.getCustomer());
      ps.setString(3, data.getDeviceName());
      ps.setString(4, data.getCustomerLot());
      ps.setInt(5, data.getIndexX());
      ps.setInt(6, data.getIndexY());
      ps.setInt(7, data.getWaferSize());
      ps.setInt(8, data.getOfDirection());
      ps.setInt(9, data.getPassQty());
      ps.setInt(10, data.getTotalQty());
      ps.setInt(11, data.getFailQty());
      ps.setTimestamp(12, new Timestamp(data.getStartTime().getTime()));
      ps.setTimestamp(13, new Timestamp(data.getEndTime().getTime()));
      ps.setTimestamp(14, new Timestamp(data.getUpdatedTime().getTime()));
      ps.setString(15, data.getOperationBo());
      ps.setString(16, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<CpResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CpResult data : dataList) {
        ps.setString(1, data.getWaferId());
        ps.setString(2, data.getCustomer());
        ps.setString(3, data.getDeviceName());
        ps.setString(4, data.getCustomerLot());
        ps.setInt(5, data.getIndexX());
        ps.setInt(6, data.getIndexY());
        ps.setInt(7, data.getWaferSize());
        ps.setInt(8, data.getOfDirection());
        ps.setInt(9, data.getPassQty());
        ps.setInt(10, data.getTotalQty());
        ps.setInt(11, data.getFailQty());
        ps.setTimestamp(12, new Timestamp(data.getStartTime().getTime()));
        ps.setTimestamp(13, new Timestamp(data.getEndTime().getTime()));
        ps.setTimestamp(14, new Timestamp(data.getUpdatedTime().getTime()));
        ps.setString(15, data.getOperationBo());
        ps.setString(16, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zh_cp_result WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int delete(String customerItemBO, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zh_cp_result WHERE id=? and operation_bo=?")) {
      ps.setString(1, customerItemBO);
      ps.setString(2, operationBo);

      return ps.executeUpdate();
    }
  }

  public List<CpResult> selectAll() throws SQLException {
    ArrayList<CpResult> result = new ArrayList<CpResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public CpResult selectByPK(String id) throws SQLException {
    CpResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private CpResult convert(ResultSet rs) throws SQLException {
    CpResult data = new CpResult();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setWaferId(rs.getString(index++));
    data.setCustomer(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setCustomerLot(rs.getString(index++));
    data.setIndexX(rs.getInt(index++));
    data.setIndexY(rs.getInt(index++));
    data.setWaferSize(rs.getInt(index++));
    data.setOfDirection(rs.getInt(index++));
    data.setPassQty(rs.getInt(index++));
    data.setTotalQty(rs.getInt(index++));
    data.setFailQty(rs.getInt(index++));
    data.setStartTime(rs.getTimestamp(index++));
    data.setEndTime(rs.getTimestamp(index++));
    data.setUpdatedTime(rs.getTimestamp(index++));
    data.setOperationBo(rs.getString(index++));

    return data;
  }
}
