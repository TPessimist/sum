package ame.psb.db.dao;

import ame.psb.db.CarrierClean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class CarrierCleanDao {

  private static final String SQL_INS = "INSERT INTO zr_carrier_clean(id,subid,name,carrier_tool,state_name,type,clean_user,start_time,end_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_carrier_clean SET subid=?,name=?,carrier_tool=?,state_name=?,type=?,clean_user=?,start_time=?,end_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,subid,name,carrier_tool,state_name,type,clean_user,start_time,end_time FROM zr_carrier_clean ";

  private final Connection conn;

  public CarrierCleanDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CarrierClean data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSubId());
      ps.setString(3, data.getName());
      ps.setString(4, data.getCarrierTool());
      ps.setString(5, data.getStateName());
      ps.setString(6, data.getType());
      ps.setString(7, data.getCleanUser());
      DateUtils.setDateTz(ps, 8, data.getStartTime());
      DateUtils.setDateTz(ps, 9, data.getEndTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CarrierClean> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CarrierClean data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSubId());
        ps.setString(3, data.getName());
        ps.setString(4, data.getCarrierTool());
        ps.setString(5, data.getStateName());
        ps.setString(6, data.getType());
        ps.setString(7, data.getCleanUser());
        DateUtils.setDateTz(ps, 8, data.getStartTime());
        DateUtils.setDateTz(ps, 9, data.getEndTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CarrierClean data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSubId());
      ps.setString(2, data.getName());
      ps.setString(3, data.getCarrierTool());
      ps.setString(4, data.getStateName());
      ps.setString(5, data.getType());
      ps.setString(6, data.getCleanUser());
      DateUtils.setDateTz(ps, 7, data.getStartTime());
      DateUtils.setDateTz(ps, 8, data.getEndTime());
      ps.setString(9, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<CarrierClean> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CarrierClean data : dataList) {
        ps.setString(1, data.getSubId());
        ps.setString(2, data.getName());
        ps.setString(3, data.getCarrierTool());
        ps.setString(4, data.getStateName());
        ps.setString(5, data.getType());
        ps.setString(6, data.getCleanUser());
        DateUtils.setDateTz(ps, 7, data.getStartTime());
        DateUtils.setDateTz(ps, 8, data.getEndTime());
        ps.setString(9, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_carrier_clean WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<CarrierClean> selectAll() throws SQLException {
    ArrayList<CarrierClean> result = new ArrayList<CarrierClean>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<CarrierClean> selectByUser(String user) throws SQLException {
    ArrayList<CarrierClean> result = new ArrayList<CarrierClean>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE clean_user=?")) {
      ps.setString(1, user);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public CarrierClean selectByPK(String id) throws SQLException {
    CarrierClean result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<CarrierClean> selectByNameLike(String name) throws SQLException {
    ArrayList<CarrierClean> result = new ArrayList<CarrierClean>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE name like ?")) {
      ps.setString(1, name);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<CarrierClean> selectByName(String name) throws SQLException {
    ArrayList<CarrierClean> result = new ArrayList<CarrierClean>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE name=?")) {
      ps.setString(1, name);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<CarrierClean> select(Where where) throws SQLException {
    ArrayList<CarrierClean> result = new ArrayList<CarrierClean>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private CarrierClean convert(ResultSet rs) throws SQLException {
    CarrierClean data = new CarrierClean();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSubId(rs.getString(index++));
    data.setName(rs.getString(index++));
    data.setCarrierTool(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setType(rs.getString(index++));
    data.setCleanUser(rs.getString(index++));
    data.setStartTime(DateUtils.getDateTz(rs, index++));
    data.setEndTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}