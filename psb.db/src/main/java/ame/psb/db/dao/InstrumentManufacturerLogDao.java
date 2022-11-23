package ame.psb.db.dao;

import ame.psb.db.InstrumentManufacturerLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class InstrumentManufacturerLogDao {

  private static final String SQL_INS = "INSERT INTO zd_instrument_manufacturer_log(uuid,instrumentid,name,alias,manufacturer,model,calculate_range,instrument_precision,tolerance,acceptable_standard,factory_number,machine_number,input_date,check_cycle,check_mode,check_date,deadline,user_department,custodian,belong_department,check_state,days,calculate_unit,remarks,job_number,email,state_description,reserve_field1,reserve_field2,update_time,update_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_instrument_manufacturer_log SET instrumentid=?,name=?,alias=?,manufacturer=?,model=?,calculate_range=?,instrument_precision=?,tolerance=?,acceptable_standard=?,factory_number=?,machine_number=?,input_date=?,check_cycle=?,check_mode=?,check_date=?,deadline=?,user_department=?,custodian=?,belong_department=?,check_state=?,days=?,calculate_unit=?,remarks=?,job_number=?,email=?,state_description=?,reserve_field1=?,reserve_field2=?,update_time=?,update_user=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,instrumentid,name,alias,manufacturer,model,calculate_range,instrument_precision,tolerance,acceptable_standard,factory_number,machine_number,input_date,check_cycle,check_mode,check_date,deadline,user_department,custodian,belong_department,check_state,days,calculate_unit,remarks,job_number,email,state_description,reserve_field1,reserve_field2,update_time,update_user FROM zd_instrument_manufacturer_log ";

  private final Connection conn;

  public InstrumentManufacturerLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(InstrumentManufacturerLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getInstrumentid());
      ps.setString(3, data.getName());
      ps.setString(4, data.getAlias());
      ps.setString(5, data.getManufacturer());
      ps.setString(6, data.getModel());
      ps.setString(7, data.getCalculateRange());
      ps.setString(8, data.getInstrumentPrecision());
      ps.setString(9, data.getTolerance());
      ps.setString(10, data.getAcceptableStandard());
      ps.setString(11, data.getFactoryNumber());
      ps.setString(12, data.getMachineNumber());
      ps.setString(13, data.getInputDate());
      ps.setString(14, data.getCheckCycle());
      ps.setString(15, data.getCheckMode());
      ps.setString(16, data.getCheckDate());
      ps.setString(17, data.getDeadline());
      ps.setString(18, data.getUserDepartment());
      ps.setString(19, data.getCustodian());
      ps.setString(20, data.getBelongDepartment());
      ps.setString(21, data.getCheckState());
      ps.setString(22, data.getDays());
      ps.setString(23, data.getCalculateUnit());
      ps.setString(24, data.getRemarks());
      ps.setString(25, data.getJobNumber());
      ps.setString(26, data.getEmail());
      ps.setString(27, data.getStateDescription());
      ps.setString(28, data.getReserveField1());
      ps.setString(29, data.getReserveField2());
      DateUtils.setDateTz(ps, 30, data.getUpdateTime());
      ps.setString(31, data.getUpdateUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<InstrumentManufacturerLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (InstrumentManufacturerLog data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getInstrumentid());
        ps.setString(3, data.getName());
        ps.setString(4, data.getAlias());
        ps.setString(5, data.getManufacturer());
        ps.setString(6, data.getModel());
        ps.setString(7, data.getCalculateRange());
        ps.setString(8, data.getInstrumentPrecision());
        ps.setString(9, data.getTolerance());
        ps.setString(10, data.getAcceptableStandard());
        ps.setString(11, data.getFactoryNumber());
        ps.setString(12, data.getMachineNumber());
        ps.setString(13, data.getInputDate());
        ps.setString(14, data.getCheckCycle());
        ps.setString(15, data.getCheckMode());
        ps.setString(16, data.getCheckDate());
        ps.setString(17, data.getDeadline());
        ps.setString(18, data.getUserDepartment());
        ps.setString(19, data.getCustodian());
        ps.setString(20, data.getBelongDepartment());
        ps.setString(21, data.getCheckState());
        ps.setString(22, data.getDays());
        ps.setString(23, data.getCalculateUnit());
        ps.setString(24, data.getRemarks());
        ps.setString(25, data.getJobNumber());
        ps.setString(26, data.getEmail());
        ps.setString(27, data.getStateDescription());
        ps.setString(28, data.getReserveField1());
        ps.setString(29, data.getReserveField2());
        DateUtils.setDateTz(ps, 30, data.getUpdateTime());
        ps.setString(31, data.getUpdateUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(InstrumentManufacturerLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getInstrumentid());
      ps.setString(2, data.getName());
      ps.setString(3, data.getAlias());
      ps.setString(4, data.getManufacturer());
      ps.setString(5, data.getModel());
      ps.setString(6, data.getCalculateRange());
      ps.setString(7, data.getInstrumentPrecision());
      ps.setString(8, data.getTolerance());
      ps.setString(9, data.getAcceptableStandard());
      ps.setString(10, data.getFactoryNumber());
      ps.setString(11, data.getMachineNumber());
      ps.setString(12, data.getInputDate());
      ps.setString(13, data.getCheckCycle());
      ps.setString(14, data.getCheckMode());
      ps.setString(15, data.getCheckDate());
      ps.setString(16, data.getDeadline());
      ps.setString(17, data.getUserDepartment());
      ps.setString(18, data.getCustodian());
      ps.setString(19, data.getBelongDepartment());
      ps.setString(20, data.getCheckState());
      ps.setString(21, data.getDays());
      ps.setString(22, data.getCalculateUnit());
      ps.setString(23, data.getRemarks());
      ps.setString(24, data.getJobNumber());
      ps.setString(25, data.getEmail());
      ps.setString(26, data.getStateDescription());
      ps.setString(27, data.getReserveField1());
      ps.setString(28, data.getReserveField2());
      DateUtils.setDateTz(ps, 29, data.getUpdateTime());
      ps.setString(30, data.getUpdateUser());
      ps.setString(31, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<InstrumentManufacturerLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (InstrumentManufacturerLog data : dataList) {
        ps.setString(1, data.getInstrumentid());
        ps.setString(2, data.getName());
        ps.setString(3, data.getAlias());
        ps.setString(4, data.getManufacturer());
        ps.setString(5, data.getModel());
        ps.setString(6, data.getCalculateRange());
        ps.setString(7, data.getInstrumentPrecision());
        ps.setString(8, data.getTolerance());
        ps.setString(9, data.getAcceptableStandard());
        ps.setString(10, data.getFactoryNumber());
        ps.setString(11, data.getMachineNumber());
        ps.setString(12, data.getInputDate());
        ps.setString(13, data.getCheckCycle());
        ps.setString(14, data.getCheckMode());
        ps.setString(15, data.getCheckDate());
        ps.setString(16, data.getDeadline());
        ps.setString(17, data.getUserDepartment());
        ps.setString(18, data.getCustodian());
        ps.setString(19, data.getBelongDepartment());
        ps.setString(20, data.getCheckState());
        ps.setString(21, data.getDays());
        ps.setString(22, data.getCalculateUnit());
        ps.setString(23, data.getRemarks());
        ps.setString(24, data.getJobNumber());
        ps.setString(25, data.getEmail());
        ps.setString(26, data.getStateDescription());
        ps.setString(27, data.getReserveField1());
        ps.setString(28, data.getReserveField2());
        DateUtils.setDateTz(ps, 29, data.getUpdateTime());
        ps.setString(30, data.getUpdateUser());
        ps.setString(31, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_instrument_manufacturer_log WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<InstrumentManufacturerLog> selectAll() throws SQLException {
    ArrayList<InstrumentManufacturerLog> result = new ArrayList<InstrumentManufacturerLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public InstrumentManufacturerLog selectByPK(String uuid) throws SQLException {
    InstrumentManufacturerLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<InstrumentManufacturerLog> selectByInstrument(String instrumentid)
      throws SQLException { //查询日志
    ArrayList<InstrumentManufacturerLog> result = new ArrayList<InstrumentManufacturerLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE instrumentid=?")) {
      ps.setString(1, instrumentid);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private InstrumentManufacturerLog convert(ResultSet rs) throws SQLException {
    InstrumentManufacturerLog data = new InstrumentManufacturerLog();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setInstrumentid(rs.getString(index++));
    data.setName(rs.getString(index++));
    data.setAlias(rs.getString(index++));
    data.setManufacturer(rs.getString(index++));
    data.setModel(rs.getString(index++));
    data.setCalculateRange(rs.getString(index++));
    data.setInstrumentPrecision(rs.getString(index++));
    data.setTolerance(rs.getString(index++));
    data.setAcceptableStandard(rs.getString(index++));
    data.setFactoryNumber(rs.getString(index++));
    data.setMachineNumber(rs.getString(index++));
    data.setInputDate(rs.getString(index++));
    data.setCheckCycle(rs.getString(index++));
    data.setCheckMode(rs.getString(index++));
    data.setCheckDate(rs.getString(index++));
    data.setDeadline(rs.getString(index++));
    data.setUserDepartment(rs.getString(index++));
    data.setCustodian(rs.getString(index++));
    data.setBelongDepartment(rs.getString(index++));
    data.setCheckState(rs.getString(index++));
    data.setDays(rs.getString(index++));
    data.setCalculateUnit(rs.getString(index++));
    data.setRemarks(rs.getString(index++));
    data.setJobNumber(rs.getString(index++));
    data.setEmail(rs.getString(index++));
    data.setStateDescription(rs.getString(index++));
    data.setReserveField1(rs.getString(index++));
    data.setReserveField2(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setUpdateUser(rs.getString(index++));

    return data;
  }
}
