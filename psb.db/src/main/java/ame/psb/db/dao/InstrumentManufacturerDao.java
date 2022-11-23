package ame.psb.db.dao;

import ame.psb.db.InstrumentManufacturer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstrumentManufacturerDao {

  private static final String SQL_INS = "INSERT INTO zd_instrument_manufacturer(instrumentid,name,alias,manufacturer,model,calculate_range,instrument_precision,tolerance,acceptable_standard,factory_number,machine_number,input_date,check_cycle,check_mode,check_date,deadline,user_department,custodian,belong_department,check_state,days,calculate_unit,remarks,job_number,email,state_description,reserve_field1,reserve_field2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_instrument_manufacturer SET name=?,alias=?,manufacturer=?,model=?,calculate_range=?,instrument_precision=?,tolerance=?,acceptable_standard=?,factory_number=?,machine_number=?,input_date=?,check_cycle=?,check_mode=?,check_date=?,deadline=?,user_department=?,custodian=?,belong_department=?,check_state=?,days=?,calculate_unit=?,remarks=?,job_number=?,email=?,state_description=?,reserve_field1=?,reserve_field2=? WHERE instrumentid=?";

  private static final String SQL_SEL = "SELECT instrumentid,name,alias,manufacturer,model,calculate_range,instrument_precision,tolerance,acceptable_standard,factory_number,machine_number,input_date,check_cycle,check_mode,check_date,deadline,user_department,custodian,belong_department,check_state,days,calculate_unit,remarks,job_number,email,state_description,reserve_field1,reserve_field2 FROM zd_instrument_manufacturer ";

  private final Connection conn;

  public InstrumentManufacturerDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(InstrumentManufacturer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
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

      return ps.executeUpdate();
    }
  }

  public int insert(List<InstrumentManufacturer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (InstrumentManufacturer data : dataList) {
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

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(InstrumentManufacturer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getName());
      ps.setString(2, data.getAlias());
      ps.setString(3, data.getManufacturer());
      ps.setString(4, data.getModel());
      ps.setString(5, data.getCalculateRange());
      ps.setString(6, data.getInstrumentPrecision());
      ps.setString(7, data.getTolerance());
      ps.setString(8, data.getAcceptableStandard());
      ps.setString(9, data.getFactoryNumber());
      ps.setString(10, data.getMachineNumber());
      ps.setString(11, data.getInputDate());
      ps.setString(12, data.getCheckCycle());
      ps.setString(13, data.getCheckMode());
      ps.setString(14, data.getCheckDate());
      ps.setString(15, data.getDeadline());
      ps.setString(16, data.getUserDepartment());
      ps.setString(17, data.getCustodian());
      ps.setString(18, data.getBelongDepartment());
      ps.setString(19, data.getCheckState());
      ps.setString(20, data.getDays());
      ps.setString(21, data.getCalculateUnit());
      ps.setString(22, data.getRemarks());
      ps.setString(23, data.getJobNumber());
      ps.setString(24, data.getEmail());
      ps.setString(25, data.getStateDescription());
      ps.setString(26, data.getReserveField1());
      ps.setString(27, data.getReserveField2());
      ps.setString(28, data.getInstrumentid());

      return ps.executeUpdate();
    }
  }

  public int update(List<InstrumentManufacturer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (InstrumentManufacturer data : dataList) {
        ps.setString(1, data.getName());
        ps.setString(2, data.getAlias());
        ps.setString(3, data.getManufacturer());
        ps.setString(4, data.getModel());
        ps.setString(5, data.getCalculateRange());
        ps.setString(6, data.getInstrumentPrecision());
        ps.setString(7, data.getTolerance());
        ps.setString(8, data.getAcceptableStandard());
        ps.setString(9, data.getFactoryNumber());
        ps.setString(10, data.getMachineNumber());
        ps.setString(11, data.getInputDate());
        ps.setString(12, data.getCheckCycle());
        ps.setString(13, data.getCheckMode());
        ps.setString(14, data.getCheckDate());
        ps.setString(15, data.getDeadline());
        ps.setString(16, data.getUserDepartment());
        ps.setString(17, data.getCustodian());
        ps.setString(18, data.getBelongDepartment());
        ps.setString(19, data.getCheckState());
        ps.setString(20, data.getDays());
        ps.setString(21, data.getCalculateUnit());
        ps.setString(22, data.getRemarks());
        ps.setString(23, data.getJobNumber());
        ps.setString(24, data.getEmail());
        ps.setString(25, data.getStateDescription());
        ps.setString(26, data.getReserveField1());
        ps.setString(27, data.getReserveField2());
        ps.setString(28, data.getInstrumentid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String instrumentid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_instrument_manufacturer WHERE instrumentid=?")) {
      ps.setString(1, instrumentid);

      return ps.executeUpdate();
    }
  }

  public List<InstrumentManufacturer> selectAll() throws SQLException {
    ArrayList<InstrumentManufacturer> result = new ArrayList<InstrumentManufacturer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public InstrumentManufacturer selectByPK(String instrumentid) throws SQLException {
    InstrumentManufacturer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE instrumentid=?")) {
      ps.setString(1, instrumentid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<InstrumentManufacturer> selectByJobNumber(String jobNumber) throws SQLException {
    ArrayList<InstrumentManufacturer> result = new ArrayList<InstrumentManufacturer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE job_number=?")) {
      ps.setString(1, jobNumber);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private InstrumentManufacturer convert(ResultSet rs) throws SQLException {
    InstrumentManufacturer data = new InstrumentManufacturer();

    int index = 1;
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

    return data;
  }
}
