package ame.psb.db.dao;

import ame.psb.db.Carrier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

/**
 * Carrier DAO
 * <p>
 * Carrier 與 SFC 建立 0..* 關聯。
 *
 * @author Kyle K. Lin
 */
public class CarrierDao {

  private static final String SQL_INS = "INSERT INTO zd_carrier(id,carrier_name,carrier_type,state_name,current_run,operation_bo,updated_user,updated_time,description,capacity,clean_cycle,buy_time,last_clean_time,max_usage,now_usage,time_flag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_carrier SET carrier_name=?,carrier_type=?,state_name=?,current_run=?,operation_bo=?,updated_user=?,updated_time=?,description=?,capacity=?,clean_cycle=?,buy_time=?,last_clean_time=?,max_usage=?,now_usage=?,time_flag=? WHERE id=?";

  private static final String SQL_UPD1 = "UPDATE zd_carrier SET id=?,carrier_type=?,state_name=?,current_run=?,operation_bo=?,updated_user=?,updated_time=?,description=?,capacity=?,clean_cycle=?,buy_time=?,last_clean_time=?,max_usage=?,now_usage=?,time_flag=? WHERE carrier_name=?";

  private static final String SQL_SEL1 = "SELECT id,carrier_name,carrier_type,state_name,current_run,operation_bo,updated_user,updated_time,description,capacity,clean_cycle,buy_time,last_clean_time,max_usage,now_usage,time_flag FROM zd_carrier ";

  private static final String SQL_SEL2 = "SELECT id,carrier_name,carrier_type,carrier_state_name as state_name,carrier_current_run as current_run,operation_bo,updated_user,updated_time,description,capacity,clean_cycle,buy_time,last_clean_time,max_usage,now_usage,time_flag FROM view_carrier ";

  private Connection conn;

  public CarrierDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Carrier data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getCarrierName());
      ps.setString(3, data.getCarrierType());
      ps.setString(4, data.getStateName());
      ps.setString(5, data.getCurrentRun());
      ps.setString(6, data.getOperationBo());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getDescription());
      //ps.setInt(10, data.getCapacity());
      //ps.setInt(11, data.getCleanCycle());
      ps.setLong(10, data.getCapacity());
      ps.setLong(11, data.getCleanCycle());
      DateUtils.setDateTz(ps, 12, data.getBuyTime());
      DateUtils.setDateTz(ps, 13, data.getLastCleanTime());
      ps.setInt(14, data.getMaxUsage());
      ps.setInt(15, data.getNowUsage());
      ps.setString(16, data.getTimeFlag());

      return ps.executeUpdate();
    }
  }

  public int update(Carrier data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCarrierName());
      ps.setString(2, data.getCarrierType());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getCurrentRun());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getDescription());
      //ps.setInt(9, data.getCapacity());
      //ps.setInt(10, data.getCleanCycle());
      ps.setLong(9, data.getCapacity());
      ps.setLong(10, data.getCleanCycle());
      DateUtils.setDateTz(ps, 11, data.getBuyTime());
      DateUtils.setDateTz(ps, 12, data.getLastCleanTime());
      ps.setInt(13, data.getMaxUsage());
      ps.setInt(14, data.getNowUsage());
      ps.setString(15, data.getTimeFlag());
      ps.setString(16, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<Carrier> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Carrier data : dataList) {
        ps.setString(1, data.getCarrierName());
        ps.setString(2, data.getCarrierType());
        ps.setString(3, data.getStateName());
        ps.setString(4, data.getCurrentRun());
        ps.setString(5, data.getOperationBo());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getDescription());
        //ps.setInt(9, data.getCapacity());
        //ps.setInt(10, data.getCleanCycle());
        ps.setLong(9, data.getCapacity());
        ps.setLong(10, data.getCleanCycle());
        DateUtils.setDateTz(ps, 11, data.getBuyTime());
        DateUtils.setDateTz(ps, 12, data.getLastCleanTime());
        ps.setInt(13, data.getMaxUsage());
        ps.setInt(14, data.getNowUsage());
        ps.setString(15, data.getTimeFlag());
        ps.setString(16, data.getId());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateByName(Carrier data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD1)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getCarrierType());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getCurrentRun());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getDescription());
      //ps.setInt(9, data.getCapacity());
      //ps.setInt(10, data.getCleanCycle());
      ps.setLong(9, data.getCapacity());
      ps.setLong(10, data.getCleanCycle());
      DateUtils.setDateTz(ps, 11, data.getBuyTime());
      DateUtils.setDateTz(ps, 12, data.getLastCleanTime());
      ps.setInt(13, data.getMaxUsage());
      ps.setInt(14, data.getNowUsage());
      ps.setString(15, data.getTimeFlag());
      ps.setString(16, data.getCarrierName());

      return ps.executeUpdate();
    }
  }

  public Carrier selectByPK(String id) throws SQLException {
    Carrier carrier = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL1 + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        carrier = convert(rs);
      }
    }
    return carrier;
  }

  public Carrier selectByName(String carrierName) throws SQLException {
    Carrier carrier = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL1 + "WHERE carrier_name=?")) {
      ps.setString(1, carrierName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        carrier = convert(rs);
      }
    }
    return carrier;
  }
  public List<Carrier> selectById() throws SQLException {
    ArrayList<Carrier> result = new ArrayList<Carrier>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL1 + "WHERE ID LIKE 'RC:%' AND id NOT IN (SELECT CARRIER_BO FROM ZD_CARRIER_REEL)")) {;

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }


  public Carrier selectByCarrier(String carrierName) throws SQLException {
    Carrier carrier = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL2 + "WHERE carrier_name=?")) {
      ps.setString(1, carrierName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        carrier = convert(rs);
      }
    }
    return carrier;
  }

  public Carrier selectBySfc(String sfcBo) throws SQLException {
    Carrier carrier = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL2 + "WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        carrier = convert(rs);
      }
    }
    return carrier;
  }

  public List<Carrier> selectAll() throws SQLException {
    ArrayList<Carrier> result = new ArrayList<Carrier>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL1 + "ORDER BY carrier_name")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<Carrier> selectByCarrierType(String carrierType) throws SQLException {
    ArrayList<Carrier> result = new ArrayList<Carrier>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "where carrier_type =? ORDER BY carrier_name")) {
      ps.setString(1, carrierType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<Carrier> selectByState(String stateName) throws SQLException {
    ArrayList<Carrier> result = new ArrayList<Carrier>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE state_name=? ORDER BY carrier_name")) {
      ps.setString(1, stateName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<Carrier> selectByStateAndCarrierType(String stateName, String carrierType)
      throws SQLException {
    ArrayList<Carrier> result = new ArrayList<Carrier>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL1 + "WHERE state_name=? and carrier_type =? ORDER BY carrier_name")) {
      ps.setString(1, stateName);
      ps.setString(2, carrierType);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public int changeState(String id, String stateName) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_carrier SET state_name=? WHERE id=?");
    ps.setString(1, stateName);
    ps.setString(2, id);
    return ps.executeUpdate();
  }

  public int changeByCarrier(String id, String stateName) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_carrier SET state_name=? WHERE CARRIER_NAME =?");
    ps.setString(1, stateName);
    ps.setString(2, id);
    return ps.executeUpdate();
  }

  public int changeState(String id, String stateName, String run) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_carrier SET state_name=?,current_run=? WHERE id=?");
    ps.setString(1, stateName);
    ps.setString(2, run);
    ps.setString(3, id);
    return ps.executeUpdate();
  }

  private Carrier convert(ResultSet rs) throws SQLException {
    Carrier data = new Carrier();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setCarrierName(rs.getString(index++));
    data.setCarrierType(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCurrentRun(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setDescription(rs.getString(index++));
    data.setCapacity(rs.getInt(index++));
    data.setCleanCycle(rs.getInt(index++));
    data.setBuyTime(DateUtils.getDateTz(rs, index++));
    data.setLastCleanTime(DateUtils.getDateTz(rs, index++));
    data.setMaxUsage(rs.getInt(index++));
    data.setNowUsage(rs.getInt(index++));
    data.setTimeFlag(rs.getString(index++));
    return data;
  }

}
