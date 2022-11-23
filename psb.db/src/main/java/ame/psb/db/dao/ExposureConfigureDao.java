package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ExposureConfigure;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class ExposureConfigureDao {

  private static final String SQL_INS = "INSERT INTO zd_exposure_configure(wafer_inch,wafer_type,glue_type,wee_energy,wee_distance,wee_width,wep_energy,reversed_field1,reversed_field2,created_user,created_time,modified_user,modified_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_exposure_configure SET wafer_type=?,glue_type=?,wee_energy=?,wee_distance=?,wee_width=?,wep_energy=?,reversed_field1=?,reversed_field2=?,created_user=?,created_time=?,modified_user=?,modified_time=? WHERE wafer_inch=?";

  private static final String SQL_SEL = "SELECT wafer_inch,wafer_type,glue_type,wee_energy,wee_distance,wee_width,wep_energy,reversed_field1,reversed_field2,created_user,created_time,modified_user,modified_time FROM zd_exposure_configure ";

  private final Connection conn;

  public ExposureConfigureDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ExposureConfigure data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getWaferInch());
      ps.setString(2, data.getWaferType());
      ps.setString(3, data.getGlueType());
      ps.setString(4, data.getWeeEnergy());
      ps.setString(5, data.getWeeDistance());
      ps.setString(6, data.getWeeWidth());
      ps.setString(7, data.getWepEnergy());
      ps.setString(8, data.getReversedField1());
      ps.setString(9, data.getReversedField2());
      ps.setString(10, data.getCreatedUser());
      DateUtils.setDateTz(ps, 11, data.getCreatedTime());
      ps.setString(12, data.getModifiedUser());
      DateUtils.setDateTz(ps, 13, data.getModifiedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ExposureConfigure> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ExposureConfigure data : dataList) {
        ps.setString(1, data.getWaferInch());
        ps.setString(2, data.getWaferType());
        ps.setString(3, data.getGlueType());
        ps.setString(4, data.getWeeEnergy());
        ps.setString(5, data.getWeeDistance());
        ps.setString(6, data.getWeeWidth());
        ps.setString(7, data.getWepEnergy());
        ps.setString(8, data.getReversedField1());
        ps.setString(9, data.getReversedField2());
        ps.setString(10, data.getCreatedUser());
        DateUtils.setDateTz(ps, 11, data.getCreatedTime());
        ps.setString(12, data.getModifiedUser());
        DateUtils.setDateTz(ps, 13, data.getModifiedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ExposureConfigure data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getWaferType());
      ps.setString(2, data.getGlueType());
      ps.setString(3, data.getWeeEnergy());
      ps.setString(4, data.getWeeDistance());
      ps.setString(5, data.getWeeWidth());
      ps.setString(6, data.getWepEnergy());
      ps.setString(7, data.getReversedField1());
      ps.setString(8, data.getReversedField2());
      ps.setString(9, data.getCreatedUser());
      DateUtils.setDateTz(ps, 10, data.getCreatedTime());
      ps.setString(11, data.getModifiedUser());
      DateUtils.setDateTz(ps, 12, data.getModifiedTime());
      ps.setString(13, data.getWaferInch());

      return ps.executeUpdate();
    }
  }

  public int update(List<ExposureConfigure> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ExposureConfigure data : dataList) {
        ps.setString(1, data.getWaferType());
        ps.setString(2, data.getGlueType());
        ps.setString(3, data.getWeeEnergy());
        ps.setString(4, data.getWeeDistance());
        ps.setString(5, data.getWeeWidth());
        ps.setString(6, data.getWepEnergy());
        ps.setString(7, data.getReversedField1());
        ps.setString(8, data.getReversedField2());
        ps.setString(9, data.getCreatedUser());
        DateUtils.setDateTz(ps, 10, data.getCreatedTime());
        ps.setString(11, data.getModifiedUser());
        DateUtils.setDateTz(ps, 12, data.getModifiedTime());
        ps.setString(13, data.getWaferInch());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String waferInch) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_exposure_configure WHERE wafer_inch=?")) {
      ps.setString(1, waferInch);

      return ps.executeUpdate();
    }
  }


  public List<ExposureConfigure> selectAll() throws SQLException {
    ArrayList<ExposureConfigure> result = new ArrayList<ExposureConfigure>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ExposureConfigure> select(Where where) throws SQLException {
    List<ExposureConfigure> list = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convert(rs));
      }
      return list;
    }
  }

  public ExposureConfigure selectByPK(String waferInch) throws SQLException {
    ExposureConfigure result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE wafer_inch=?")) {
      ps.setString(1, waferInch);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ExposureConfigure convert(ResultSet rs) throws SQLException {
    ExposureConfigure data = new ExposureConfigure();

    int index = 1;
    data.setWaferInch(rs.getString(index++));
    data.setWaferType(rs.getString(index++));
    data.setGlueType(rs.getString(index++));
    data.setWeeEnergy(rs.getString(index++));
    data.setWeeDistance(rs.getString(index++));
    data.setWeeWidth(rs.getString(index++));
    data.setWepEnergy(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setCreatedUser(rs.getString(index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedUser(rs.getString(index++));
    data.setModifiedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
