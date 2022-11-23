package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ZrProductWaferData;
import uia.utils.dao.DateUtils;

public class ZrProductWaferDataDao {

  private static final String SQL_INS = "INSERT INTO zr_product_wafer_data(uuid,resource_name,wafet_name,qty,state,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_product_wafer_data SET resource_name=?,wafet_name=?,qty=?,state=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,resource_name,wafet_name,qty,state,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_product_wafer_data ";

  private final Connection conn;

  public ZrProductWaferDataDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZrProductWaferData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getResourceName());
      ps.setString(3, data.getWafetName());
      ps.setString(4, data.getQty());
      ps.setString(5, data.getState());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZrProductWaferData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZrProductWaferData data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getResourceName());
        ps.setString(3, data.getWafetName());
        ps.setString(4, data.getQty());
        ps.setString(5, data.getState());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZrProductWaferData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceName());
      ps.setString(2, data.getWafetName());
      ps.setString(3, data.getQty());
      ps.setString(4, data.getState());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZrProductWaferData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZrProductWaferData data : dataList) {
        ps.setString(1, data.getResourceName());
        ps.setString(2, data.getWafetName());
        ps.setString(3, data.getQty());
        ps.setString(4, data.getState());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_product_wafer_data WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<ZrProductWaferData> selectAll() throws SQLException {
    ArrayList<ZrProductWaferData> result = new ArrayList<ZrProductWaferData>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZrProductWaferData selectByPK(String uuid) throws SQLException {
    ZrProductWaferData result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZrProductWaferData> selectByWaferName(String waferName) throws SQLException {
    List<ZrProductWaferData> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE wafet_name =?")) {
      ps.setString(1, waferName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ZrProductWaferData convert(ResultSet rs) throws SQLException {
    ZrProductWaferData data = new ZrProductWaferData();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setResourceName(rs.getString(index++));
    data.setWafetName(rs.getString(index++));
    data.setQty(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
