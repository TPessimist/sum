package ame.me.db.dao;

import ame.me.db.ToolNumber;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

/**
 * @author Coffee
 */
public class ToolNumberDao {

  private static final String SQL_SEL = "SELECT handle,site,tool_number,tool_group_bo,description,status_bo,qty,location,calibration_type,calibration_date,calibration_period,calibration_period_type,exp_date,created_date_time,modified_date_time,erp_plant_maint_order,erp_equipment_number FROM tool_number ";

  private final Connection conn;

  public ToolNumberDao(Connection conn) {
    this.conn = conn;
  }

  public List<ToolNumber> selectAll() throws SQLException {
    ArrayList<ToolNumber> result = new ArrayList<ToolNumber>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ToolNumber> selectAllBySite(String Site) throws SQLException {
    ArrayList<ToolNumber> result = new ArrayList<ToolNumber>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE site=?")) {
      ps.setString(1, Site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ToolNumber> selectByCreatedTime(Date createdTime) throws SQLException {
    ArrayList<ToolNumber> result = new ArrayList<ToolNumber>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE created_date_time>?")) {

      DateUtils.setDateTz(ps, 1, createdTime);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ToolNumber> selectByToolGroupBo(String toolGroupBo) throws SQLException {
    Where where = new Where().eq("TOOL_GROUP_BO", toolGroupBo);
    return this.select(where);
  }

  public List<ToolNumber> select(Where where) throws SQLException {
    ArrayList<ToolNumber> result = new ArrayList<ToolNumber>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public ToolNumber selectByPK(String handle) throws SQLException {
    ToolNumber result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public ToolNumber selectByName(String site, String name) throws SQLException {
    ToolNumber result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? and tool_number=?")) {
      ps.setString(1, site);
      ps.setString(2, name);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }


  public int updateByHandle(String calibrationType, Date expDate,
      String handle) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        " UPDATE tool_number SET calibration_type=?,exp_date=? WHERE handle=? ")) {
      ps.setString(1, calibrationType);
      DateUtils.setDateTz(ps, 2, expDate);
      ps.setString(3, handle);
      return ps.executeUpdate();
    }
  }

  private ToolNumber convert(ResultSet rs) throws SQLException {
    ToolNumber data = new ToolNumber();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setToolNumber(rs.getString(index++));
    data.setToolGroupBo(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setQty(rs.getBigDecimal(index++));
    data.setLocation(rs.getString(index++));
    data.setCalibrationType(rs.getString(index++));
    data.setCalibrationDate(DateUtils.getDateTz(rs, index++));
    data.setCalibrationPeriod(rs.getBigDecimal(index++));
    data.setCalibrationPeriodType(rs.getString(index++));
    data.setExpDate(DateUtils.getDateTz(rs, index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setErpPlantMaintOrder(rs.getString(index++));
    data.setErpEquipmentNumber(rs.getString(index++));

    return data;
  }
}