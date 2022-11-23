package ame.psb.db.dao;

import ame.psb.db.FcResrcePlatingMantenance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FcResrcePlatingMantenanceDao {

  private static final String SQL_INS = "INSERT INTO fc_resrce_plating_mantenance(resource_no,slot_no,slot_name,plating_name,plating_density,slot_volume,slot_usage,p_lower_limit,p_upper_limit,plating_conc,package_spec,offer_value,replacement_cycle,real_cycle,c_lower_limit,c_upper_limit,c_point,stoste_conc,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE fc_resrce_plating_mantenance SET slot_name=?,plating_density=?,slot_volume=?,slot_usage=?,p_lower_limit=?,p_upper_limit=?,plating_conc=?,package_spec=?,offer_value=?,replacement_cycle=?,real_cycle=?,c_lower_limit=?,c_upper_limit=?,c_point=?,stoste_conc=?,updated_user=?,updated_time=? WHERE resource_no=? AND slot_no=? AND plating_name=?";

  private static final String SQL_SEL = "SELECT resource_no,slot_no,slot_name,plating_name,plating_density,slot_volume,slot_usage,p_lower_limit,p_upper_limit,plating_conc,package_spec,offer_value,replacement_cycle,real_cycle,c_lower_limit,c_upper_limit,c_point,stoste_conc,updated_user,updated_time FROM fc_resrce_plating_mantenance ";

  private static final String SQL_UPD_CYCLE = "UPDATE fc_resrce_plating_mantenance SET real_cycle=?,updated_user=?,updated_time=? WHERE resource_no=? AND slot_no=? AND plating_name=?";

  private final Connection conn;

  public FcResrcePlatingMantenanceDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FcResrcePlatingMantenance data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResourceNo());
      ps.setString(2, data.getSlotNo());
      ps.setString(3, data.getSlotName());
      ps.setString(4, data.getPlatingName());
      ps.setBigDecimal(5, data.getPlatingDensity());
      ps.setBigDecimal(6, data.getSlotVolume());
      ps.setBigDecimal(7, data.getSlotUsage());
      ps.setBigDecimal(8, data.getpLowerLimit());
      ps.setBigDecimal(9, data.getpUpperLimit());
      ps.setBigDecimal(10, data.getPlatingConc());
      ps.setString(11, data.getPackageSpec());
      ps.setBigDecimal(12, data.getOfferValue());
      ps.setBigDecimal(13, data.getReplacementCycle());
      ps.setBigDecimal(14, data.getRealCycle());

      ps.setBigDecimal(15, data.getcLowerLimit());
      ps.setBigDecimal(16, data.getcUpperLimit());
      ps.setBigDecimal(17, data.getcPoint());
      ps.setBigDecimal(18, data.getStosteConc());
      ps.setString(19, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 20, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FcResrcePlatingMantenance> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FcResrcePlatingMantenance data : dataList) {
        ps.setString(1, data.getResourceNo());
        ps.setString(2, data.getSlotNo());
        ps.setString(3, data.getSlotName());
        ps.setString(4, data.getPlatingName());
        ps.setBigDecimal(5, data.getPlatingDensity());
        ps.setBigDecimal(6, data.getSlotVolume());
        ps.setBigDecimal(7, data.getSlotUsage());
        ps.setBigDecimal(8, data.getpLowerLimit());
        ps.setBigDecimal(9, data.getpUpperLimit());
        ps.setBigDecimal(10, data.getPlatingConc());
        ps.setString(11, data.getPackageSpec());
        ps.setBigDecimal(12, data.getOfferValue());
        ps.setBigDecimal(13, data.getReplacementCycle());
        ps.setBigDecimal(14, data.getRealCycle());

        ps.setBigDecimal(15, data.getcLowerLimit());
        ps.setBigDecimal(16, data.getcUpperLimit());
        ps.setBigDecimal(17, data.getcPoint());
        ps.setBigDecimal(18, data.getStosteConc());
        ps.setString(19, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 20, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FcResrcePlatingMantenance data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSlotName());
      ps.setBigDecimal(2, data.getPlatingDensity());
      ps.setBigDecimal(3, data.getSlotVolume());
      ps.setBigDecimal(4, data.getSlotUsage());
      ps.setBigDecimal(5, data.getpLowerLimit());
      ps.setBigDecimal(6, data.getpUpperLimit());
      ps.setBigDecimal(7, data.getPlatingConc());
      ps.setString(8, data.getPackageSpec());
      ps.setBigDecimal(9, data.getOfferValue());
      ps.setBigDecimal(10, data.getReplacementCycle());
      ps.setBigDecimal(11, data.getRealCycle());

      ps.setBigDecimal(12, data.getcLowerLimit());
      ps.setBigDecimal(13, data.getcUpperLimit());
      ps.setBigDecimal(14, data.getcPoint());
      ps.setBigDecimal(15, data.getStosteConc());
      ps.setString(16, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 17, data.getUpdatedTime());
      ps.setString(18, data.getResourceNo());
      ps.setString(19, data.getSlotNo());
      ps.setString(20, data.getPlatingName());

      return ps.executeUpdate();
    }
  }

  public int updateCycle(FcResrcePlatingMantenance data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_CYCLE)) {

      ps.setBigDecimal(1, data.getRealCycle());
      ps.setString(2, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
      ps.setString(4, data.getResourceNo());
      ps.setString(5, data.getSlotNo());
      ps.setString(6, data.getPlatingName());

      return ps.executeUpdate();
    }
  }

  public int update(List<FcResrcePlatingMantenance> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FcResrcePlatingMantenance data : dataList) {
        ps.setString(1, data.getSlotName());
        ps.setBigDecimal(2, data.getPlatingDensity());
        ps.setBigDecimal(3, data.getSlotVolume());
        ps.setBigDecimal(4, data.getSlotUsage());
        ps.setBigDecimal(5, data.getpLowerLimit());
        ps.setBigDecimal(6, data.getpUpperLimit());
        ps.setBigDecimal(7, data.getPlatingConc());
        ps.setString(8, data.getPackageSpec());
        ps.setBigDecimal(9, data.getOfferValue());
        ps.setBigDecimal(10, data.getReplacementCycle());
        ps.setBigDecimal(11, data.getRealCycle());

        ps.setBigDecimal(12, data.getcLowerLimit());
        ps.setBigDecimal(13, data.getcUpperLimit());
        ps.setBigDecimal(14, data.getcPoint());
        ps.setBigDecimal(15, data.getStosteConc());
        ps.setString(16, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 17, data.getUpdatedTime());
        ps.setString(18, data.getResourceNo());
        ps.setString(19, data.getSlotNo());
        ps.setString(20, data.getPlatingName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resourceNo, String slotNo, String platingName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM fc_resrce_plating_mantenance WHERE resource_no=? AND slot_no=? AND plating_name=?")) {
      ps.setString(1, resourceNo);
      ps.setString(2, slotNo);
      ps.setString(3, platingName);

      return ps.executeUpdate();
    }
  }

  public int delete(String resourceNo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM fc_resrce_plating_mantenance WHERE resource_no=?")) {
      ps.setString(1, resourceNo);

      return ps.executeUpdate();
    }
  }

  public List<FcResrcePlatingMantenance> selectAll() throws SQLException {
    ArrayList<FcResrcePlatingMantenance> result = new ArrayList<FcResrcePlatingMantenance>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FcResrcePlatingMantenance selectByPK(String resourceNo, String slotNo, String platingName)
      throws SQLException {
    FcResrcePlatingMantenance result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_no=? AND slot_no=? AND plating_name=?")) {
      ps.setString(1, resourceNo);
      ps.setString(2, slotNo);
      ps.setString(3, platingName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<FcResrcePlatingMantenance> selectByResource(String resource) throws SQLException {
    ArrayList<FcResrcePlatingMantenance> result = new ArrayList<FcResrcePlatingMantenance>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_no=?")) {
      ps.setString(1, resource);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FcResrcePlatingMantenance> selectCycleBySlot(String slotNo) throws SQLException {
    ArrayList<FcResrcePlatingMantenance> result = new ArrayList<FcResrcePlatingMantenance>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE slot_no=?")) {
      ps.setString(1, slotNo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private FcResrcePlatingMantenance convert(ResultSet rs) throws SQLException {
    FcResrcePlatingMantenance data = new FcResrcePlatingMantenance();

    int index = 1;
    data.setResourceNo(rs.getString(index++));
    data.setSlotNo(rs.getString(index++));
    data.setSlotName(rs.getString(index++));
    data.setPlatingName(rs.getString(index++));
    data.setPlatingDensity(rs.getBigDecimal(index++));
    data.setSlotVolume(rs.getBigDecimal(index++));
    data.setSlotUsage(rs.getBigDecimal(index++));
    data.setpLowerLimit(rs.getBigDecimal(index++));
    data.setpUpperLimit(rs.getBigDecimal(index++));
    data.setPlatingConc(rs.getBigDecimal(index++));
    data.setPackageSpec(rs.getString(index++));
    data.setOfferValue(rs.getBigDecimal(index++));
    data.setReplacementCycle(rs.getBigDecimal(index++));
    data.setRealCycle(rs.getBigDecimal(index++));

    data.setcLowerLimit(rs.getBigDecimal(index++));
    data.setcUpperLimit(rs.getBigDecimal(index++));
    data.setcPoint(rs.getBigDecimal(index++));
    data.setStosteConc(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
