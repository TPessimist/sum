package ame.psb.db.dao;

import ame.psb.db.WaferDeductionRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class WaferDeductionRecordDao { //ZR_WAFER_DEDUCTION_RECORD的数据操作层

  private static final String SQL_INS = "INSERT INTO zr_wafer_deduction_record(uuid,shop_order,sap_order,issue_by,item_type,wafer,wafer_lot,wafer_id,product,sap_product,qty,comment,description,value,sendtime,code,message,operation) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_wafer_deduction_record SET shop_order=?,sap_order=?,issue_by=?,item_type=?,wafer=?,wafer_lot=?,wafer_id=?,product=?,sap_product=?,qty=?,comment=?,description=?,value=?,sendtime=?,code=?,message=?,operation=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,shop_order,sap_order,issue_by,item_type,wafer,wafer_lot,wafer_id,product,sap_product,qty,comment,description,value,sendtime,code,message,operation FROM zr_wafer_deduction_record ";

  private final Connection conn;

  public WaferDeductionRecordDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(WaferDeductionRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getShopOrder());
      ps.setString(3, data.getSapOrder());
      ps.setString(4, data.getIssueBy());
      ps.setString(5, data.getItemType());
      ps.setString(6, data.getWafer());
      ps.setString(7, data.getWaferLot());
      ps.setString(8, data.getWaferId());
      ps.setString(9, data.getProduct());
      ps.setString(10, data.getSapProduct());
      ps.setString(11, data.getQty());
      ps.setString(12, data.getComment());
      ps.setString(13, data.getDescription());
      ps.setString(14, data.getValue());
      DateUtils.setDateTz(ps, 15, data.getSendtime());
      ps.setString(16, data.getCode());
      ps.setString(17, data.getMessage());
      ps.setString(18, data.getOperation());

      return ps.executeUpdate();
    }
  }

  public int insert(List<WaferDeductionRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (WaferDeductionRecord data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getShopOrder());
        ps.setString(3, data.getSapOrder());
        ps.setString(4, data.getIssueBy());
        ps.setString(5, data.getItemType());
        ps.setString(6, data.getWafer());
        ps.setString(7, data.getWaferLot());
        ps.setString(8, data.getWaferId());
        ps.setString(9, data.getProduct());
        ps.setString(10, data.getSapProduct());
        ps.setString(11, data.getQty());
        ps.setString(12, data.getComment());
        ps.setString(13, data.getDescription());
        ps.setString(14, data.getValue());
        DateUtils.setDateTz(ps, 15, data.getSendtime());
        ps.setString(16, data.getCode());
        ps.setString(17, data.getMessage());
        ps.setString(18, data.getOperation());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(WaferDeductionRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getShopOrder());
      ps.setString(2, data.getSapOrder());
      ps.setString(3, data.getIssueBy());
      ps.setString(4, data.getItemType());
      ps.setString(5, data.getWafer());
      ps.setString(6, data.getWaferLot());
      ps.setString(7, data.getWaferId());
      ps.setString(8, data.getProduct());
      ps.setString(9, data.getSapProduct());
      ps.setString(10, data.getQty());
      ps.setString(11, data.getComment());
      ps.setString(12, data.getDescription());
      ps.setString(13, data.getValue());
      DateUtils.setDateTz(ps, 14, data.getSendtime());
      ps.setString(15, data.getCode());
      ps.setString(16, data.getMessage());
      ps.setString(17, data.getOperation());
      ps.setString(18, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<WaferDeductionRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (WaferDeductionRecord data : dataList) {
        ps.setString(1, data.getShopOrder());
        ps.setString(2, data.getSapOrder());
        ps.setString(3, data.getIssueBy());
        ps.setString(4, data.getItemType());
        ps.setString(5, data.getWafer());
        ps.setString(6, data.getWaferLot());
        ps.setString(7, data.getWaferId());
        ps.setString(8, data.getProduct());
        ps.setString(9, data.getSapProduct());
        ps.setString(10, data.getQty());
        ps.setString(11, data.getComment());
        ps.setString(12, data.getDescription());
        ps.setString(13, data.getValue());
        DateUtils.setDateTz(ps, 14, data.getSendtime());
        ps.setString(15, data.getCode());
        ps.setString(16, data.getMessage());
        ps.setString(17, data.getOperation());
        ps.setString(18, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_wafer_deduction_record WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public int deleteByShopOrderAndWafer(String shopOrder, String wafer) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_wafer_deduction_record WHERE shop_order=? and wafer=?")) {
      ps.setString(1, shopOrder);
      ps.setString(2, wafer);

      return ps.executeUpdate();
    }
  }

  public List<WaferDeductionRecord> selectAll() throws SQLException {
    ArrayList<WaferDeductionRecord> result = new ArrayList<WaferDeductionRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public WaferDeductionRecord selectByPK(String uuid) throws SQLException {
    WaferDeductionRecord result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<WaferDeductionRecord> selectByWafer(String wafer)
      throws SQLException { //根据wafer查询是否有扣账请求记录
    ArrayList<WaferDeductionRecord> result = new ArrayList<WaferDeductionRecord>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE wafer=? AND CODE='S' ")) {
      ps.setString(1, wafer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<WaferDeductionRecord> selectByShopOrderAndWafer(String shopOrder, String wafer)
      throws SQLException { //根据工单和wafer查询是否有扣账请求记录
    ArrayList<WaferDeductionRecord> result = new ArrayList<WaferDeductionRecord>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE shop_order=? AND wafer=? AND CODE='S' ")) {
      ps.setString(1, shopOrder);
      ps.setString(2, wafer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<WaferDeductionRecord> selectByFoWafer(String shopOrder, String wafer)
      throws SQLException { //根据工单和wafer查询是否有扣账请求记录
    ArrayList<WaferDeductionRecord> result = new ArrayList<WaferDeductionRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE shop_order=? AND wafer=? AND CODE='S' AND operation='FDA-DA' ")) {
      ps.setString(1, shopOrder);
      ps.setString(2, wafer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<WaferDeductionRecord> selectByShopOrder(String shopOrder) throws SQLException {
    ArrayList<WaferDeductionRecord> result = new ArrayList<WaferDeductionRecord>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE shop_order=? AND CODE='S' ")) {
      ps.setString(1, shopOrder);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<WaferDeductionRecord> selectBySfc(String sfc, String date)
      throws SQLException { //根据生产批号和时间查询
    ArrayList<WaferDeductionRecord> result = new ArrayList<WaferDeductionRecord>();

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE description=? and sendtime=? ")) {
      ps.setString(1, sfc);
      ps.setString(2, date);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<WaferDeductionRecord> selectBySfcAndCode(String sfc)
      throws SQLException { //根据生产批号查询扣账成功的记录
    ArrayList<WaferDeductionRecord> result = new ArrayList<WaferDeductionRecord>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE description=? AND CODE='S' ")) {
      ps.setString(1, sfc);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private WaferDeductionRecord convert(ResultSet rs) throws SQLException {
    WaferDeductionRecord data = new WaferDeductionRecord();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setSapOrder(rs.getString(index++));
    data.setIssueBy(rs.getString(index++));
    data.setItemType(rs.getString(index++));
    data.setWafer(rs.getString(index++));
    data.setWaferLot(rs.getString(index++));
    data.setWaferId(rs.getString(index++));
    data.setProduct(rs.getString(index++));
    data.setSapProduct(rs.getString(index++));
    data.setQty(rs.getString(index++));
    data.setComment(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setSendtime(DateUtils.getDateTz(rs, index++));
    data.setCode(rs.getString(index++));
    data.setMessage(rs.getString(index++));
    data.setOperation(rs.getString(index++));

    return data;
  }
}
