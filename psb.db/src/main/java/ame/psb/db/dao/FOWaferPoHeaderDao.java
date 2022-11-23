package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FOWaferPoHeader;
import uia.utils.dao.DateUtils;

public class FOWaferPoHeaderDao {

  private static final String SQL_INS = "INSERT INTO zr_fo_wafer_po_header(uuid,csp_wafer,csp_shop_order,csp_po,product_wafer,product_shop_order,product_po,result,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_fo_wafer_po_header SET csp_wafer=?,csp_shop_order=?,csp_po=?,product_wafer=?,product_shop_order=?,product_po=?,result=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,csp_wafer,csp_shop_order,csp_po,product_wafer,product_shop_order,product_po,result,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_fo_wafer_po_header ";

  private final Connection conn;

  public FOWaferPoHeaderDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FOWaferPoHeader data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getCspWafer());
      ps.setString(3, data.getCspShopOrder());
      ps.setString(4, data.getCspPo());
      ps.setString(5, data.getProductWafer());
      ps.setString(6, data.getProductShopOrder());
      ps.setString(7, data.getProductPo());
      ps.setString(8, data.getResult());
      ps.setString(9, data.getReversedField1());
      ps.setString(10, data.getReversedField2());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FOWaferPoHeader> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FOWaferPoHeader data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getCspWafer());
        ps.setString(3, data.getCspShopOrder());
        ps.setString(4, data.getCspPo());
        ps.setString(5, data.getProductWafer());
        ps.setString(6, data.getProductShopOrder());
        ps.setString(7, data.getProductPo());
        ps.setString(8, data.getResult());
        ps.setString(9, data.getReversedField1());
        ps.setString(10, data.getReversedField2());
        ps.setString(11, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FOWaferPoHeader data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCspWafer());
      ps.setString(2, data.getCspShopOrder());
      ps.setString(3, data.getCspPo());
      ps.setString(4, data.getProductWafer());
      ps.setString(5, data.getProductShopOrder());
      ps.setString(6, data.getProductPo());
      ps.setString(7, data.getResult());
      ps.setString(8, data.getReversedField1());
      ps.setString(9, data.getReversedField2());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
      ps.setString(12, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<FOWaferPoHeader> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FOWaferPoHeader data : dataList) {
        ps.setString(1, data.getCspWafer());
        ps.setString(2, data.getCspShopOrder());
        ps.setString(3, data.getCspPo());
        ps.setString(4, data.getProductWafer());
        ps.setString(5, data.getProductShopOrder());
        ps.setString(6, data.getProductPo());
        ps.setString(7, data.getResult());
        ps.setString(8, data.getReversedField1());
        ps.setString(9, data.getReversedField2());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
        ps.setString(12, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_fo_wafer_po_header WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<FOWaferPoHeader> selectAll() throws SQLException {
    ArrayList<FOWaferPoHeader> result = new ArrayList<FOWaferPoHeader>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FOWaferPoHeader selectByPK(String uuid) throws SQLException {
    FOWaferPoHeader result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<FOWaferPoHeader> selectByCspWafer(String cspWafer) throws SQLException {
    List<FOWaferPoHeader> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE csp_wafer=?")) {
      ps.setString(1, cspWafer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FOWaferPoHeader> selectByProductWafer(String productWafer) throws SQLException {
    List<FOWaferPoHeader> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE product_wafer=?")) {
      ps.setString(1, productWafer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private FOWaferPoHeader convert(ResultSet rs) throws SQLException {
    FOWaferPoHeader data = new FOWaferPoHeader();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setCspWafer(rs.getString(index++));
    data.setCspShopOrder(rs.getString(index++));
    data.setCspPo(rs.getString(index++));
    data.setProductWafer(rs.getString(index++));
    data.setProductShopOrder(rs.getString(index++));
    data.setProductPo(rs.getString(index++));
    data.setResult(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
