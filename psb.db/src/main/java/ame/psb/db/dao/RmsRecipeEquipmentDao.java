package ame.psb.db.dao;

import ame.psb.db.RmsRecipeEquipment;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RmsRecipeEquipmentDao {

  private static final String SQL_INS = "INSERT INTO rms_recipe_equipment(object_rrn,org_rrn,is_active,created,created_by,updated,updated_by,lock_version,recipe_name,equipment_id,programe_id,check_sum,hold_state,std_process_time,version,status,active_time,active_user,recipe_type,compare_flag,body,timestamp,level_number) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE rms_recipe_equipment SET org_rrn=?,is_active=?,created=?,created_by=?,updated=?,updated_by=?,lock_version=?,recipe_name=?,equipment_id=?,programe_id=?,check_sum=?,hold_state=?,std_process_time=?,version=?,status=?,active_time=?,active_user=?,recipe_type=?,compare_flag=?,body=?,timestamp=?,level_number=? WHERE object_rrn=?";

  private static final String SQL_SEL = "SELECT object_rrn,org_rrn,is_active,created,created_by,updated,updated_by,lock_version,recipe_name,equipment_id,programe_id,check_sum,hold_state,std_process_time,version,status,active_time,active_user,recipe_type,compare_flag,body,timestamp,level_number FROM rms_recipe_equipment ";

  private final Connection conn;

  public RmsRecipeEquipmentDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RmsRecipeEquipment data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setBigDecimal(1, data.getObjectRrn());
      ps.setBigDecimal(2, data.getOrgRrn());
      ps.setString(3, data.getIsActive());
      ps.setString(4, data.getCreated());
      ps.setString(5, data.getCreatedBy());
      ps.setString(6, data.getUpdated());
      ps.setString(7, data.getUpdatedBy());
      ps.setBigDecimal(8, data.getLockVersion());
      ps.setString(9, data.getRecipeName());
      ps.setString(10, data.getEquipmentId());
      ps.setString(11, data.getProgrameId());
      ps.setString(12, data.getCheckSum());
      ps.setString(13, data.getHoldState());
      ps.setBigDecimal(14, data.getStdProcessTime());
      ps.setBigDecimal(15, data.getVersion());
      ps.setString(16, data.getStatus());
      ps.setString(17, data.getActiveTime());
      ps.setString(18, data.getActiveUser());
      ps.setBigDecimal(19, data.getRecipeType());
      ps.setString(20, data.getCompareFlag());
      ps.setString(21, data.getBody());
      ps.setString(22, data.getTimestamp());
      ps.setBigDecimal(23, data.getLevelNumber());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RmsRecipeEquipment> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RmsRecipeEquipment data : dataList) {
        ps.setBigDecimal(1, data.getObjectRrn());
        ps.setBigDecimal(2, data.getOrgRrn());
        ps.setString(3, data.getIsActive());
        ps.setString(4, data.getCreated());
        ps.setString(5, data.getCreatedBy());
        ps.setString(6, data.getUpdated());
        ps.setString(7, data.getUpdatedBy());
        ps.setBigDecimal(8, data.getLockVersion());
        ps.setString(9, data.getRecipeName());
        ps.setString(10, data.getEquipmentId());
        ps.setString(11, data.getProgrameId());
        ps.setString(12, data.getCheckSum());
        ps.setString(13, data.getHoldState());
        ps.setBigDecimal(14, data.getStdProcessTime());
        ps.setBigDecimal(15, data.getVersion());
        ps.setString(16, data.getStatus());
        ps.setString(17, data.getActiveTime());
        ps.setString(18, data.getActiveUser());
        ps.setBigDecimal(19, data.getRecipeType());
        ps.setString(20, data.getCompareFlag());
        ps.setString(21, data.getBody());
        ps.setString(22, data.getTimestamp());
        ps.setBigDecimal(23, data.getLevelNumber());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RmsRecipeEquipment data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getOrgRrn());
      ps.setString(2, data.getIsActive());
      ps.setString(3, data.getCreated());
      ps.setString(4, data.getCreatedBy());
      ps.setString(5, data.getUpdated());
      ps.setString(6, data.getUpdatedBy());
      ps.setBigDecimal(7, data.getLockVersion());
      ps.setString(8, data.getRecipeName());
      ps.setString(9, data.getEquipmentId());
      ps.setString(10, data.getProgrameId());
      ps.setString(11, data.getCheckSum());
      ps.setString(12, data.getHoldState());
      ps.setBigDecimal(13, data.getStdProcessTime());
      ps.setBigDecimal(14, data.getVersion());
      ps.setString(15, data.getStatus());
      ps.setString(16, data.getActiveTime());
      ps.setString(17, data.getActiveUser());
      ps.setBigDecimal(18, data.getRecipeType());
      ps.setString(19, data.getCompareFlag());
      ps.setString(20, data.getBody());
      ps.setString(21, data.getTimestamp());
      ps.setBigDecimal(22, data.getLevelNumber());
      ps.setBigDecimal(23, data.getObjectRrn());

      return ps.executeUpdate();
    }
  }

  public int update(List<RmsRecipeEquipment> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RmsRecipeEquipment data : dataList) {
        ps.setBigDecimal(1, data.getOrgRrn());
        ps.setString(2, data.getIsActive());
        ps.setString(3, data.getCreated());
        ps.setString(4, data.getCreatedBy());
        ps.setString(5, data.getUpdated());
        ps.setString(6, data.getUpdatedBy());
        ps.setBigDecimal(7, data.getLockVersion());
        ps.setString(8, data.getRecipeName());
        ps.setString(9, data.getEquipmentId());
        ps.setString(10, data.getProgrameId());
        ps.setString(11, data.getCheckSum());
        ps.setString(12, data.getHoldState());
        ps.setBigDecimal(13, data.getStdProcessTime());
        ps.setBigDecimal(14, data.getVersion());
        ps.setString(15, data.getStatus());
        ps.setString(16, data.getActiveTime());
        ps.setString(17, data.getActiveUser());
        ps.setBigDecimal(18, data.getRecipeType());
        ps.setString(19, data.getCompareFlag());
        ps.setString(20, data.getBody());
        ps.setString(21, data.getTimestamp());
        ps.setBigDecimal(22, data.getLevelNumber());
        ps.setBigDecimal(23, data.getObjectRrn());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(BigDecimal objectRrn) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM rms_recipe_equipment WHERE object_rrn=?")) {
      ps.setBigDecimal(1, objectRrn);

      return ps.executeUpdate();
    }
  }

  public List<RmsRecipeEquipment> selectAll() throws SQLException {
    ArrayList<RmsRecipeEquipment> result = new ArrayList<RmsRecipeEquipment>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<RmsRecipeEquipment> selectByUpdated(Date updated) throws SQLException {
    ArrayList<RmsRecipeEquipment> result = new ArrayList<RmsRecipeEquipment>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where UPDATED >= ? ")) {

      ps.setDate(1, updated);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public List<RmsRecipeEquipment> selectByEquipmentId(String equipment) throws SQLException {
    ArrayList<RmsRecipeEquipment> result = new ArrayList<RmsRecipeEquipment>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where equipment_id = ? ")) {

      ps.setString(1, equipment);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public RmsRecipeEquipment selectByPK(BigDecimal objectRrn) throws SQLException {
    RmsRecipeEquipment result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE object_rrn=?")) {
      ps.setBigDecimal(1, objectRrn);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public Date selectMaxUpdated() throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT MAX(UPDATEd) FROM RMS_RECIPE_EQUIPMENT")) {
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        return rs.getDate(1) == null ? new Date(0) : rs.getDate(1);
      } else {
        return new Date(0);
      }
    }
  }

  private RmsRecipeEquipment convert(ResultSet rs) throws SQLException {
    RmsRecipeEquipment data = new RmsRecipeEquipment();

    int index = 1;
    data.setObjectRrn(rs.getBigDecimal(index++));
    data.setOrgRrn(rs.getBigDecimal(index++));
    data.setIsActive(rs.getString(index++));
    data.setCreated(rs.getString(index++));
    data.setCreatedBy(rs.getString(index++));
    data.setUpdated(rs.getString(index++));
    data.setUpdatedBy(rs.getString(index++));
    data.setLockVersion(rs.getBigDecimal(index++));
    data.setRecipeName(rs.getString(index++));
    data.setEquipmentId(rs.getString(index++));
    data.setProgrameId(rs.getString(index++));
    data.setCheckSum(rs.getString(index++));
    data.setHoldState(rs.getString(index++));
    data.setStdProcessTime(rs.getBigDecimal(index++));
    data.setVersion(rs.getBigDecimal(index++));
    data.setStatus(rs.getString(index++));
    data.setActiveTime(rs.getString(index++));
    data.setActiveUser(rs.getString(index++));
    data.setRecipeType(rs.getBigDecimal(index++));
    data.setCompareFlag(rs.getString(index++));
    data.setBody(rs.getString(index++));
    data.setTimestamp(rs.getString(index++));
    data.setLevelNumber(rs.getBigDecimal(index++));

    return data;
  }
}
