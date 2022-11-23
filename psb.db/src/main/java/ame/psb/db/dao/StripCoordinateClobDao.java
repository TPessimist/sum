package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.StripCoordinateClob;

public class StripCoordinateClobDao {

  private static final String SQL_INS = "INSERT INTO zr_strip_coordinate_clob(strip_id,content,create_user,create_time,physical_wafer_id) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_strip_coordinate_clob SET content=?,create_user=?,create_time=?,physical_wafer_id=? WHERE strip_id=?";

  private static final String SQL_SEL = "SELECT strip_id,content,create_user,create_time,physical_wafer_id FROM zr_strip_coordinate_clob ";

  private final Connection conn;

  public StripCoordinateClobDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(StripCoordinateClob data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getStripId());
      ps.setString(2, data.getContent());
      ps.setString(3, data.getCreateUser());
      ps.setTimestamp(4, new Timestamp(data.getCreateTime().getTime()));
      ps.setString(5, data.getPhysicalWaferId());

      return ps.executeUpdate();
    }
  }

  public int insert(List<StripCoordinateClob> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (StripCoordinateClob data : dataList) {
        ps.setString(1, data.getStripId());
        ps.setString(2, data.getContent());
        ps.setString(3, data.getCreateUser());
        ps.setTimestamp(4, new Timestamp(data.getCreateTime().getTime()));
        ps.setString(5, data.getPhysicalWaferId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(StripCoordinateClob data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getContent());
      ps.setString(2, data.getCreateUser());
      ps.setTimestamp(3, new Timestamp(data.getCreateTime().getTime()));
      ps.setString(4, data.getPhysicalWaferId());
      ps.setString(5, data.getStripId());

      return ps.executeUpdate();
    }
  }

  public int update(List<StripCoordinateClob> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (StripCoordinateClob data : dataList) {
        ps.setString(1, data.getContent());
        ps.setString(2, data.getCreateUser());
        ps.setTimestamp(3, new Timestamp(data.getCreateTime().getTime()));
        ps.setString(4, data.getPhysicalWaferId());
        ps.setString(5, data.getStripId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String stripId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_strip_coordinate_clob WHERE strip_id=?")) {
      ps.setString(1, stripId);

      return ps.executeUpdate();
    }
  }

  public List<StripCoordinateClob> selectAll() throws SQLException {
    ArrayList<StripCoordinateClob> result = new ArrayList<StripCoordinateClob>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public StripCoordinateClob selectByPK(String stripId) throws SQLException {
    StripCoordinateClob result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE strip_id=?")) {
      ps.setString(1, stripId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private StripCoordinateClob convert(ResultSet rs) throws SQLException {
    StripCoordinateClob data = new StripCoordinateClob();

    int index = 1;
    data.setStripId(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setCreateUser(rs.getString(index++));
    data.setCreateTime(rs.getTimestamp(index++));
    data.setPhysicalWaferId(rs.getString(index++));

    return data;
  }
}
