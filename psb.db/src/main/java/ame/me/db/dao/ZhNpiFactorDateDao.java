package ame.me.db.dao;

import ame.me.db.ZhNpiFactorDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZhNpiFactorDateDao {

  private static final String SQL_INS = "INSERT INTO zh_npi_factor_data(handle,factor_name,factor_value,updated_user,updated_time,factor_Type) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_npi_factor_data SET factor_value=?,updated_user=?,updated_time=? WHERE handle=? AND factor_name=? AND factor_Type =?";

  private static final String SQL_SEL = "SELECT handle,factor_name,factor_value,updated_user,updated_time,factor_Type FROM zh_npi_factor_data ";

  private final Connection conn;

  public ZhNpiFactorDateDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZhNpiFactorDate data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getFactorName());
      ps.setString(3, data.getFactorValue());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getFactorType());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZhNpiFactorDate> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZhNpiFactorDate data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getFactorName());
        ps.setString(3, data.getFactorValue());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getFactorType());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZhNpiFactorDate data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFactorValue());
      ps.setString(2, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
      ps.setString(4, data.getHandle());
      ps.setString(5, data.getFactorName());
      ps.setString(6, data.getFactorType());

      return ps.executeUpdate();
    }
  }


  public int update(List<ZhNpiFactorDate> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZhNpiFactorDate data : dataList) {
        ps.setString(1, data.getFactorValue());
        ps.setString(2, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
        ps.setString(4, data.getHandle());
        ps.setString(5, data.getFactorName());
        ps.setString(6, data.getFactorType());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle, String factorName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zh_npi_factor_data WHERE handle=? AND factor_name=?")) {
      ps.setString(1, handle);
      ps.setString(2, factorName);

      return ps.executeUpdate();
    }
  }

  public List<ZhNpiFactorDate> selectAll() throws SQLException {
    ArrayList<ZhNpiFactorDate> result = new ArrayList<ZhNpiFactorDate>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZhNpiFactorDate> selectByHandle(String handle) throws SQLException {
    ArrayList<ZhNpiFactorDate> result = new ArrayList<ZhNpiFactorDate>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZhNpiFactorDate> selectByHandleAndFactorType(String handle, String factorType)
      throws SQLException {
    ArrayList<ZhNpiFactorDate> result = new ArrayList<ZhNpiFactorDate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE handle=?  and factor_Type = ?")) {
      ps.setString(1, handle);
      ps.setString(2, factorType);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ZhNpiFactorDate selectByPK(String handle, String factorName) throws SQLException {
    ZhNpiFactorDate result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE handle=? AND factor_name=? ")) {
      ps.setString(1, handle);
      ps.setString(2, factorName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ZhNpiFactorDate selectByPK(String handle, String factorName, String factorType)
      throws SQLException {
    ZhNpiFactorDate result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE handle=? AND factor_name=? and factor_Type = ?")) {
      ps.setString(1, handle);
      ps.setString(2, factorName);
      ps.setString(3, factorType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ZhNpiFactorDate selectByPKFactorName(String handle, String factorName)
      throws SQLException {
    ZhNpiFactorDate result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE handle=? AND factor_name=?")) {
      ps.setString(1, handle);
      ps.setString(2, factorName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZhNpiFactorDate convert(ResultSet rs) throws SQLException {
    ZhNpiFactorDate data = new ZhNpiFactorDate();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setFactorName(rs.getString(index++));
    data.setFactorValue(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setFactorType(rs.getString(index++));
    return data;
  }
}
