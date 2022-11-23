package ame.psb.db.dao;

import ame.psb.db.CarrierComparison;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CarrierComparisonDao {

  private static final String SQL_INS = "INSERT INTO zd_carrier_comparison(carrier_bo,carrier_name,comparison_state,reason,carrier_state,use_state,carrier_qty,comparison_qty,reversed_field1,reversed_field2,created_user,created_time,modified_user,modified_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_carrier_comparison SET carrier_name=?,comparison_state=?,reason=?,carrier_state=?,use_state=?,carrier_qty=?,comparison_qty=?,reversed_field1=?,reversed_field2=?,created_user=?,created_time=?,modified_user=?,modified_time=? WHERE carrier_bo=?";

  private static final String SQL_SEL = "SELECT carrier_bo,carrier_name,comparison_state,reason,carrier_state,use_state,carrier_qty,comparison_qty,reversed_field1,reversed_field2,created_user,created_time,modified_user,modified_time FROM zd_carrier_comparison ";

  private final Connection conn;

  public CarrierComparisonDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CarrierComparison data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCarrierBo());
      ps.setString(2, data.getCarrierName());
      ps.setString(3, data.getComparisonState());
      ps.setString(4, data.getReason());
      ps.setString(5, data.getCarrierState());
      ps.setString(6, data.getUseState());
      ps.setBigDecimal(7, data.getCarrierQty());
      ps.setBigDecimal(8, data.getComparisonQty());
      ps.setString(9, data.getReversedField1());
      ps.setString(10, data.getReversedField2());
      ps.setString(11, data.getCreatedUser());
      DateUtils.setDateTz(ps, 12, data.getCreatedTime());
      ps.setString(13, data.getModifiedUser());
      DateUtils.setDateTz(ps, 14, data.getModifiedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CarrierComparison> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CarrierComparison data : dataList) {
        ps.setString(1, data.getCarrierBo());
        ps.setString(2, data.getCarrierName());
        ps.setString(3, data.getComparisonState());
        ps.setString(4, data.getReason());
        ps.setString(5, data.getCarrierState());
        ps.setString(6, data.getUseState());
        ps.setBigDecimal(7, data.getCarrierQty());
        ps.setBigDecimal(8, data.getComparisonQty());
        ps.setString(9, data.getReversedField1());
        ps.setString(10, data.getReversedField2());
        ps.setString(11, data.getCreatedUser());
        DateUtils.setDateTz(ps, 12, data.getCreatedTime());
        ps.setString(13, data.getModifiedUser());
        DateUtils.setDateTz(ps, 14, data.getModifiedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CarrierComparison data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCarrierName());
      ps.setString(2, data.getComparisonState());
      ps.setString(3, data.getReason());
      ps.setString(4, data.getCarrierState());
      ps.setString(5, data.getUseState());
      ps.setBigDecimal(6, data.getCarrierQty());
      ps.setBigDecimal(7, data.getComparisonQty());
      ps.setString(8, data.getReversedField1());
      ps.setString(9, data.getReversedField2());
      ps.setString(10, data.getCreatedUser());
      DateUtils.setDateTz(ps, 11, data.getCreatedTime());
      ps.setString(12, data.getModifiedUser());
      DateUtils.setDateTz(ps, 13, data.getModifiedTime());
      ps.setString(14, data.getCarrierBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<CarrierComparison> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CarrierComparison data : dataList) {
        ps.setString(1, data.getCarrierName());
        ps.setString(2, data.getComparisonState());
        ps.setString(3, data.getReason());
        ps.setString(4, data.getCarrierState());
        ps.setString(5, data.getUseState());
        ps.setBigDecimal(6, data.getCarrierQty());
        ps.setBigDecimal(7, data.getComparisonQty());
        ps.setString(8, data.getReversedField1());
        ps.setString(9, data.getReversedField2());
        ps.setString(10, data.getCreatedUser());
        DateUtils.setDateTz(ps, 11, data.getCreatedTime());
        ps.setString(12, data.getModifiedUser());
        DateUtils.setDateTz(ps, 13, data.getModifiedTime());
        ps.setString(14, data.getCarrierBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String carrierBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_carrier_comparison WHERE carrier_bo=?")) {
      ps.setString(1, carrierBo);

      return ps.executeUpdate();
    }
  }

  public List<CarrierComparison> selectAll() throws SQLException {
    ArrayList<CarrierComparison> result = new ArrayList<CarrierComparison>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public CarrierComparison selectByPK(String carrierBo) throws SQLException {
    CarrierComparison result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE carrier_bo=?")) {
      ps.setString(1, carrierBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public CarrierComparison selectByCarrierByTime(String carrierBo) throws SQLException {
    CarrierComparison result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE carrier_bo=? ORDER BY created_time DESC ")) {
      ps.setString(1, carrierBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private CarrierComparison convert(ResultSet rs) throws SQLException {
    CarrierComparison data = new CarrierComparison();

    int index = 1;
    data.setCarrierBo(rs.getString(index++));
    data.setCarrierName(rs.getString(index++));
    data.setComparisonState(rs.getString(index++));
    data.setReason(rs.getString(index++));
    data.setCarrierState(rs.getString(index++));
    data.setUseState(rs.getString(index++));
    data.setCarrierQty(rs.getBigDecimal(index++));
    data.setComparisonQty(rs.getBigDecimal(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setCreatedUser(rs.getString(index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedUser(rs.getString(index++));
    data.setModifiedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
