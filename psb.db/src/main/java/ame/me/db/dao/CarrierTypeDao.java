package ame.me.db.dao;

import ame.me.db.CarrierType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CarrierTypeDao {

  private static final String SQL_SEL = "SELECT handle,site,carrier_type,description,capacity,row_size,column_size,sequence_priority,category,created_date_time,modified_date_time FROM carrier_type ";

  private final Connection conn;

  public CarrierTypeDao(Connection conn) {
    this.conn = conn;
  }

  public List<CarrierType> selectAll() throws SQLException {
    ArrayList<CarrierType> result = new ArrayList<CarrierType>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<CarrierType> selectAll(String site) throws SQLException {
    ArrayList<CarrierType> result = new ArrayList<CarrierType>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE SITE=?")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public CarrierType selectByPK(String handle) throws SQLException {
    CarrierType result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public CarrierType selectByName(String site, String Name) throws SQLException {
    CarrierType result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? and carrier_type=?")) {
      ps.setString(1, site);
      ps.setString(2, Name);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private CarrierType convert(ResultSet rs) throws SQLException {
    CarrierType data = new CarrierType();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setCarrierType(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setCapacity(rs.getBigDecimal(index++));
    data.setRowSize(rs.getBigDecimal(index++));
    data.setColumnSize(rs.getBigDecimal(index++));
    data.setSequencePriority(rs.getString(index++));
    data.setCategory(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}