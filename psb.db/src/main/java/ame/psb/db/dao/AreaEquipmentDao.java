package ame.psb.db.dao;

import ame.psb.db.AreaEquipment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class AreaEquipmentDao {

  private static final String SQL_SEL = "SELECT resource,area,handle,maintenance_people,department,leader,update_user,created_date_time,modified_date_time,state_name,content2 FROM zd_area_equipment ";

  private static final String SQL_UPD = "UPDATE zd_area_equipment SET area=?,handle=?,maintenance_people=?,department=?,leader=?,update_user=?,created_date_time=?,modified_date_time=?,state_name=?,content2=? WHERE resource=?";

  private static final String SQL_INS = "INSERT INTO zd_area_equipment(resource,area,handle,maintenance_people,department,leader,update_user,created_date_time,modified_date_time,state_name,content2) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private final Connection conn;

  public AreaEquipmentDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(AreaEquipment data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResource());
      ps.setString(2, data.getArea());
      ps.setString(3, data.getHandle());
      ps.setString(4, data.getMaintenancePeople());
      ps.setString(5, data.getDepartment());
      ps.setString(6, data.getLeader());
      ps.setString(7, data.getUpdateUser());
      DateUtils.setDateTz(ps, 8, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 9, data.getModifiedDateTime());
      ps.setString(10, data.getStateName());
      ps.setString(11, data.getContent2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<AreaEquipment> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (AreaEquipment data : dataList) {
        ps.setString(1, data.getResource());
        ps.setString(2, data.getArea());
        ps.setString(3, data.getHandle());
        ps.setString(4, data.getMaintenancePeople());
        ps.setString(5, data.getDepartment());
        ps.setString(6, data.getLeader());
        ps.setString(7, data.getUpdateUser());
        DateUtils.setDateTz(ps, 8, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 9, data.getModifiedDateTime());
        ps.setString(10, data.getStateName());
        ps.setString(11, data.getContent2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(AreaEquipment data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {

      ps.setString(1, data.getArea());
      ps.setString(2, data.getHandle());
      ps.setString(3, data.getMaintenancePeople());
      ps.setString(4, data.getDepartment());
      ps.setString(5, data.getLeader());
      ps.setString(6, data.getUpdateUser());
      DateUtils.setDateTz(ps, 7, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 8, data.getModifiedDateTime());
      ps.setString(9, data.getStateName());
      ps.setString(10, data.getContent2());
      ps.setString(11, data.getResource());

      return ps.executeUpdate();
    }
  }

  public int update(List<AreaEquipment> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (AreaEquipment data : dataList) {
        ps.setString(1, data.getArea());
        ps.setString(2, data.getHandle());
        ps.setString(3, data.getMaintenancePeople());
        ps.setString(4, data.getDepartment());
        ps.setString(5, data.getLeader());
        ps.setString(6, data.getUpdateUser());
        DateUtils.setDateTz(ps, 7, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 8, data.getModifiedDateTime());
        ps.setString(9, data.getStateName());
        ps.setString(10, data.getContent2());
        ps.setString(11, data.getResource());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public List<AreaEquipment> selectAll() throws SQLException {
    ArrayList<AreaEquipment> result = new ArrayList<AreaEquipment>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_area_equipment WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  //by 设备查询
  public List<AreaEquipment> selectByResource(String resource) throws SQLException {
    ArrayList<AreaEquipment> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource=? AND state_name= 'ENABLE' ")) {
      ps.setString(1, resource);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  //by 区域查询
  public List<AreaEquipment> selectByArea(String area) throws SQLException {
    ArrayList<AreaEquipment> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE area=? AND state_name= 'ENABLE' ")) {
      ps.setString(1, area);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<AreaEquipment> selectByAreaAndResource(String area, String resource)
      throws SQLException {
    ArrayList<AreaEquipment> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE area=? AND resource=? AND state_name= 'ENABLE' ")) {
      ps.setString(1, area);
      ps.setString(2, resource);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  private AreaEquipment convert(ResultSet rs) throws SQLException {
    AreaEquipment data = new AreaEquipment();

    int index = 1;
    data.setResource(rs.getString(index++));
    data.setArea(rs.getString(index++));
    data.setHandle(rs.getString(index++));
    data.setMaintenancePeople(rs.getString(index++));
    data.setDepartment(rs.getString(index++));
    data.setLeader(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setStateName(rs.getString(index++));
    data.setContent2(rs.getString(index++));

    return data;
  }
}
