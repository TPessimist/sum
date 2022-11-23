package ame.sap.db.dao;

import ame.sap.db.Picture682DWafer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class Picture682DWaferDao {

  private static final String SQL_INS = "INSERT INTO zr_68_picture_2d_wafer(item_group_bo,customer_item_bo,sfc_bo,wafer_count,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_68_picture_2d_wafer SET sfc_bo=?,wafer_count=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE item_group_bo=? AND customer_item_bo=?";

  private static final String SQL_SEL = "SELECT item_group_bo,customer_item_bo,sfc_bo,wafer_count,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_68_picture_2d_wafer ";

  private final Connection conn;

  public Picture682DWaferDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Picture682DWafer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getCustomerItemBo());
      ps.setString(3, data.getSfcBo());
      ps.setBigDecimal(4, data.getWaferCount());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Picture682DWafer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Picture682DWafer data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getCustomerItemBo());
        ps.setString(3, data.getSfcBo());
        ps.setBigDecimal(4, data.getWaferCount());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Picture682DWafer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setBigDecimal(2, data.getWaferCount());
      ps.setString(3, data.getReversedField1());
      ps.setString(4, data.getReversedField2());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getItemGroupBo());
      ps.setString(8, data.getCustomerItemBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<Picture682DWafer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Picture682DWafer data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setBigDecimal(2, data.getWaferCount());
        ps.setString(3, data.getReversedField1());
        ps.setString(4, data.getReversedField2());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getItemGroupBo());
        ps.setString(8, data.getCustomerItemBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemGroupBo, String customerItemBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_68_picture_2d_wafer WHERE item_group_bo=? AND customer_item_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, customerItemBo);

      return ps.executeUpdate();
    }
  }

  public List<Picture682DWafer> selectAll() throws SQLException {
    ArrayList<Picture682DWafer> result = new ArrayList<Picture682DWafer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Picture682DWafer> selectByItemGroupBo(String itemGroupBo) throws SQLException {
    ArrayList<Picture682DWafer> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where item_group_bo = ?")) {
      ps.setString(1, itemGroupBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Picture682DWafer selectByPK(String itemGroupBo, String customerItemBo)
      throws SQLException {
    Picture682DWafer result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? AND customer_item_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, customerItemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private Picture682DWafer convert(ResultSet rs) throws SQLException {
    Picture682DWafer data = new Picture682DWafer();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setWaferCount(rs.getBigDecimal(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
