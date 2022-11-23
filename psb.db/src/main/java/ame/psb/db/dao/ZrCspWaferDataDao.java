package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ZrCspWaferData;
import uia.utils.dao.DateUtils;

public class ZrCspWaferDataDao {

  private static final String SQL_INS = "INSERT INTO zr_csp_wafer_data(wafet_name,operation_bo,qty,details_id,resource_name,sfc_bo,shop_order_bo,state,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_csp_wafer_data SET qty=?,details_id=?,resource_name=?,sfc_bo=?,shop_order_bo=?,state=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE wafet_name=? AND operation_bo=?";

  private static final String SQL_SEL = "SELECT wafet_name,operation_bo,qty,details_id,resource_name,sfc_bo,shop_order_bo,state,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_csp_wafer_data ";

  private final Connection conn;

  public ZrCspWaferDataDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZrCspWaferData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getWafetName());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getQty());
      ps.setString(4, data.getDetailsId());
      ps.setString(5, data.getResourceName());
      ps.setString(6, data.getSfcBo());
      ps.setString(7, data.getShopOrderBo());
      ps.setString(8, data.getState());
      ps.setString(9, data.getReversedField1());
      ps.setString(10, data.getReversedField2());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZrCspWaferData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZrCspWaferData data : dataList) {
        ps.setString(1, data.getWafetName());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getQty());
        ps.setString(4, data.getDetailsId());
        ps.setString(5, data.getResourceName());
        ps.setString(6, data.getSfcBo());
        ps.setString(7, data.getShopOrderBo());
        ps.setString(8, data.getState());
        ps.setString(9, data.getReversedField1());
        ps.setString(10, data.getReversedField2());
        ps.setString(11, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZrCspWaferData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getQty());
      ps.setString(2, data.getDetailsId());
      ps.setString(3, data.getResourceName());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getShopOrderBo());
      ps.setString(6, data.getState());
      ps.setString(7, data.getReversedField1());
      ps.setString(8, data.getReversedField2());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
      ps.setString(11, data.getWafetName());
      ps.setString(12, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZrCspWaferData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZrCspWaferData data : dataList) {
        ps.setString(1, data.getQty());
        ps.setString(2, data.getDetailsId());
        ps.setString(3, data.getResourceName());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getShopOrderBo());
        ps.setString(6, data.getState());
        ps.setString(7, data.getReversedField1());
        ps.setString(8, data.getReversedField2());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
        ps.setString(11, data.getWafetName());
        ps.setString(12, data.getOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String wafetName, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_csp_wafer_data WHERE wafet_name=? AND operation_bo=?")) {
      ps.setString(1, wafetName);
      ps.setString(2, operationBo);

      return ps.executeUpdate();
    }
  }

  public List<ZrCspWaferData> selectAll() throws SQLException {
    ArrayList<ZrCspWaferData> result = new ArrayList<ZrCspWaferData>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZrCspWaferData selectByPK(String wafetName, String operationBo) throws SQLException {
    ZrCspWaferData result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE wafet_name=? AND operation_bo=?")) {
      ps.setString(1, wafetName);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZrCspWaferData> selectBySfcBo(String sfcBo) throws SQLException {
    List<ZrCspWaferData> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_bo =? ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ZrCspWaferData convert(ResultSet rs) throws SQLException {
    ZrCspWaferData data = new ZrCspWaferData();

    int index = 1;
    data.setWafetName(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setQty(rs.getString(index++));
    data.setDetailsId(rs.getString(index++));
    data.setResourceName(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
