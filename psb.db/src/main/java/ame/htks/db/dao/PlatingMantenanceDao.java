package ame.htks.db.dao;

import ame.htks.db.PlatingMantenance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PlatingMantenanceDao {

  private static final String SQL_INS = "INSERT INTO zh_plating_resource_mantenance(resource_bo,desc,father_resource_bo,tank_type,tank_size,replacement_cycle_hours,empty_flag,last_replace_time,limit_times,current_times,remarks,limit_ah,current_ah,update_time,update_user,current_hours) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_plating_resource_mantenance SET desc=?,father_resource_bo=?,tank_type=?,tank_size=?,replacement_cycle_hours=?,empty_flag=?,last_replace_time=?,limit_times=?,current_times=?,remarks=?,limit_ah=?,current_ah=?,update_time=?,update_user=?,current_hours=? WHERE resource_bo=?";

  private static final String SQL_SEL = "SELECT resource_bo,desc,father_resource_bo,tank_type,tank_size,replacement_cycle_hours,empty_flag,last_replace_time,limit_times,current_times,remarks,limit_ah,current_ah,update_time,update_user,current_hours FROM zh_plating_resource_mantenance ";

  private final Connection conn;

  public PlatingMantenanceDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PlatingMantenance data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getDesc());
      ps.setString(3, data.getFatherResourceBo());
      ps.setString(4, data.getTankType());
      ps.setBigDecimal(5, data.getTankSize());
      ps.setBigDecimal(6, data.getReplacementCycleHours());
      ps.setString(7, data.getEmptyFlag());
      ps.setTimestamp(8, data.getLastReplaceTime() == null ? null
          : new Timestamp(data.getLastReplaceTime().getTime()));
      ps.setBigDecimal(9, data.getLimitTimes());
      ps.setBigDecimal(10, data.getCurrentTimes());
      ps.setString(11, data.getRemarks());
      ps.setBigDecimal(12, data.getLimitAh());
      ps.setBigDecimal(13, data.getCurrentAh());
      ps.setTimestamp(14, new Timestamp(data.getUpdateTime().getTime()));
      ps.setString(15, data.getUpdateUser());
      ps.setBigDecimal(16, data.getCurrentHours());
      return ps.executeUpdate();
    }
  }

  public int insert(List<PlatingMantenance> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PlatingMantenance data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getDesc());
        ps.setString(3, data.getFatherResourceBo());
        ps.setString(4, data.getTankType());
        ps.setBigDecimal(5, data.getTankSize());
        ps.setBigDecimal(6, data.getReplacementCycleHours());
        ps.setString(7, data.getEmptyFlag());
        ps.setTimestamp(8, data.getLastReplaceTime() == null ? null
            : new Timestamp(data.getLastReplaceTime().getTime()));
        ps.setBigDecimal(9, data.getLimitTimes());
        ps.setBigDecimal(10, data.getCurrentTimes());
        ps.setString(11, data.getRemarks());
        ps.setBigDecimal(12, data.getLimitAh());
        ps.setBigDecimal(13, data.getCurrentAh());
        ps.setTimestamp(14, new Timestamp(data.getUpdateTime().getTime()));
        ps.setString(15, data.getUpdateUser());
        ps.setBigDecimal(16, data.getCurrentHours());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PlatingMantenance data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDesc());
      ps.setString(2, data.getFatherResourceBo());
      ps.setString(3, data.getTankType());
      ps.setBigDecimal(4, data.getTankSize());
      ps.setBigDecimal(5, data.getReplacementCycleHours());
      ps.setString(6, data.getEmptyFlag());
      ps.setTimestamp(7, data.getLastReplaceTime() == null ? null
          : new Timestamp(data.getLastReplaceTime().getTime()));
      ps.setBigDecimal(8, data.getLimitTimes());
      ps.setBigDecimal(9, data.getCurrentTimes());
      ps.setString(10, data.getRemarks());
      ps.setBigDecimal(11, data.getLimitAh());
      ps.setBigDecimal(12, data.getCurrentAh());
      ps.setTimestamp(13, new Timestamp(data.getUpdateTime().getTime()));
      ps.setString(14, data.getUpdateUser());
      ps.setBigDecimal(15, data.getCurrentHours());
      ps.setString(16, data.getResourceBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<PlatingMantenance> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PlatingMantenance data : dataList) {
        ps.setString(1, data.getDesc());
        ps.setString(2, data.getFatherResourceBo());
        ps.setString(3, data.getTankType());
        ps.setBigDecimal(4, data.getTankSize());
        ps.setBigDecimal(5, data.getReplacementCycleHours());
        ps.setString(6, data.getEmptyFlag());
        ps.setTimestamp(7, data.getLastReplaceTime() == null ? null
            : new Timestamp(data.getLastReplaceTime().getTime()));
        ps.setBigDecimal(8, data.getLimitTimes());
        ps.setBigDecimal(9, data.getCurrentTimes());
        ps.setString(10, data.getRemarks());
        ps.setBigDecimal(11, data.getLimitAh());
        ps.setBigDecimal(12, data.getCurrentAh());
        ps.setTimestamp(13, new Timestamp(data.getUpdateTime().getTime()));
        ps.setString(14, data.getUpdateUser());
        ps.setBigDecimal(15, data.getCurrentHours());
        ps.setString(16, data.getResourceBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resourceBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zh_plating_resource_mantenance WHERE resource_bo=?")) {
      ps.setString(1, resourceBo);

      return ps.executeUpdate();
    }
  }

  public List<PlatingMantenance> selectAll() throws SQLException {
    ArrayList<PlatingMantenance> result = new ArrayList<PlatingMantenance>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PlatingMantenance selectByPK(String resourceBo) throws SQLException {
    PlatingMantenance result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_bo=?")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PlatingMantenance selectByPart(String resourceBo) throws SQLException {
    PlatingMantenance result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo like ? AND TANK_TYPE = '阴极'")) {
      ps.setString(1, resourceBo + "%");

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PlatingMantenance convert(ResultSet rs) throws SQLException {
    PlatingMantenance data = new PlatingMantenance();

    int index = 1;
    data.setResourceBo(rs.getString(index++));
    data.setDesc(rs.getString(index++));
    data.setFatherResourceBo(rs.getString(index++));
    data.setTankType(rs.getString(index++));
    data.setTankSize(rs.getBigDecimal(index++));
    data.setReplacementCycleHours(rs.getBigDecimal(index++));
    data.setEmptyFlag(rs.getString(index++));
    data.setLastReplaceTime(rs.getTimestamp(index++));
    data.setLimitTimes(rs.getBigDecimal(index++));
    data.setCurrentTimes(rs.getBigDecimal(index++));
    data.setRemarks(rs.getString(index++));
    data.setLimitAh(rs.getBigDecimal(index++));
    data.setCurrentAh(rs.getBigDecimal(index++));
    data.setUpdateTime(rs.getTimestamp(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setCurrentHours(rs.getBigDecimal(index++));

    return data;
  }
}