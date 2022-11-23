package ame.psb.db.dao;

import ame.psb.db.GoldenWaferCheck;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class GoldenWaferCheckDao {

  private static final String SQL_INS = "INSERT INTO zr_golden_wafer_check(id,resource_bo,device_name,min_value,max_value,content,value,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_golden_wafer_check SET resource_bo=?,device_name=?,min_value=?,max_value=?,content=?,value=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resource_bo,device_name,min_value,max_value,content,value,updated_user,updated_time FROM zr_golden_wafer_check ";

  private final Connection conn;

  public GoldenWaferCheckDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(GoldenWaferCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getDeviceName());
      ps.setBigDecimal(4, data.getMinValue());
      ps.setBigDecimal(5, data.getMaxValue());
      ps.setString(6, data.getContent());
      ps.setString(7, data.getValue());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<GoldenWaferCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (GoldenWaferCheck data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getDeviceName());
        ps.setBigDecimal(4, data.getMinValue());
        ps.setBigDecimal(5, data.getMaxValue());
        ps.setString(6, data.getContent());
        ps.setString(7, data.getValue());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(GoldenWaferCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getDeviceName());
      ps.setBigDecimal(3, data.getMinValue());
      ps.setBigDecimal(4, data.getMaxValue());
      ps.setString(5, data.getContent());
      ps.setString(6, data.getValue());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<GoldenWaferCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (GoldenWaferCheck data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getDeviceName());
        ps.setBigDecimal(3, data.getMinValue());
        ps.setBigDecimal(4, data.getMaxValue());
        ps.setString(5, data.getContent());
        ps.setString(6, data.getValue());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_golden_wafer_check WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<GoldenWaferCheck> selectAll() throws SQLException {
    ArrayList<GoldenWaferCheck> result = new ArrayList<GoldenWaferCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<GoldenWaferCheck> selectByResource(String resource) throws SQLException {
    ArrayList<GoldenWaferCheck> result = new ArrayList<GoldenWaferCheck>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? order by updated_time desc")) {
      ps.setString(1, resource);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public GoldenWaferCheck selectByPK(String id) throws SQLException {
    GoldenWaferCheck result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public GoldenWaferCheck selectByNew(String resource) throws SQLException {
    GoldenWaferCheck result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? order by updated_time desc")) {
      ps.setString(1, resource);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private GoldenWaferCheck convert(ResultSet rs) throws SQLException {
    GoldenWaferCheck data = new GoldenWaferCheck();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setMinValue(rs.getBigDecimal(index++));
    data.setMaxValue(rs.getBigDecimal(index++));
    data.setContent(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
