package ame.psb.db.dao;

import ame.psb.db.SorterMcsJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class SorterMcsJobDao {

  private static final String SQL_INS = "INSERT INTO zr_sorter_mcs_job(handle,resource_bo,operation_bo,job_id,customer_lot,wafer_size,carrier_porta,carrier_portb,carrier_portc,job_type,state_name,message,create_user,create_time,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_sorter_mcs_job SET resource_bo=?,operation_bo=?,job_id=?,customer_lot=?,wafer_size=?,carrier_porta=?,carrier_portb=?,carrier_portc=?,job_type=?,state_name=?,message=?,create_user=?,create_time=?,update_user=?,update_time=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,resource_bo,operation_bo,job_id,customer_lot,wafer_size,carrier_porta,carrier_portb,carrier_portc,job_type,state_name,message,create_user,create_time,update_user,update_time FROM zr_sorter_mcs_job ";


  private final Connection conn;

  public SorterMcsJobDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SorterMcsJob data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getJobId());
      ps.setString(5, data.getCustomerLot());
      ps.setBigDecimal(6, data.getWaferSize());
      ps.setString(7, data.getCarrierPorta());
      ps.setString(8, data.getCarrierPortb());
      ps.setString(9, data.getCarrierPortc());
      ps.setString(10, data.getJobType());
      ps.setString(11, data.getStateName());
      ps.setString(12, data.getMessage());
      ps.setString(13, data.getCreateUser());
      DateUtils.setDateTz(ps, 14, data.getCreateTime());
      ps.setString(15, data.getUpdateUser());
      DateUtils.setDateTz(ps, 16, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SorterMcsJob> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SorterMcsJob data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getJobId());
        ps.setString(5, data.getCustomerLot());
        ps.setBigDecimal(6, data.getWaferSize());
        ps.setString(7, data.getCarrierPorta());
        ps.setString(8, data.getCarrierPortb());
        ps.setString(9, data.getCarrierPortc());
        ps.setString(10, data.getJobType());
        ps.setString(11, data.getStateName());
        ps.setString(12, data.getMessage());
        ps.setString(13, data.getCreateUser());
        DateUtils.setDateTz(ps, 14, data.getCreateTime());
        ps.setString(15, data.getUpdateUser());
        DateUtils.setDateTz(ps, 16, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SorterMcsJob data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getJobId());
      ps.setString(4, data.getCustomerLot());
      ps.setBigDecimal(5, data.getWaferSize());
      ps.setString(6, data.getCarrierPorta());
      ps.setString(7, data.getCarrierPortb());
      ps.setString(8, data.getCarrierPortc());
      ps.setString(9, data.getJobType());
      ps.setString(10, data.getStateName());
      ps.setString(11, data.getMessage());
      ps.setString(12, data.getCreateUser());
      DateUtils.setDateTz(ps, 13, data.getCreateTime());
      ps.setString(14, data.getUpdateUser());
      DateUtils.setDateTz(ps, 15, data.getUpdateTime());
      ps.setString(16, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<SorterMcsJob> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SorterMcsJob data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getJobId());
        ps.setString(4, data.getCustomerLot());
        ps.setBigDecimal(5, data.getWaferSize());
        ps.setString(6, data.getCarrierPorta());
        ps.setString(7, data.getCarrierPortb());
        ps.setString(8, data.getCarrierPortc());
        ps.setString(9, data.getJobType());
        ps.setString(10, data.getStateName());
        ps.setString(11, data.getMessage());
        ps.setString(12, data.getCreateUser());
        DateUtils.setDateTz(ps, 13, data.getCreateTime());
        ps.setString(14, data.getUpdateUser());
        DateUtils.setDateTz(ps, 15, data.getUpdateTime());
        ps.setString(16, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_sorter_mcs_job WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }


  public int updateDown(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_sorter_mcs_job SET STATE_NAME = 'DOWN' WHERE handle=?")) {
      ps.setString(1, handle);
      return ps.executeUpdate();
    }
  }

  public int updateSorter(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_sorter_mcs_job SET STATE_NAME = 'SORTER' WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public int updateTransferring(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "UPDATE zr_sorter_mcs_job SET STATE_NAME = 'TRANSFERRING' WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }


  public List<SorterMcsJob> selectAll() throws SQLException {
    ArrayList<SorterMcsJob> result = new ArrayList<SorterMcsJob>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SorterMcsJob selectByPK(String handle) throws SQLException {
    SorterMcsJob result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public SorterMcsJob selectByResource(String resourceBo, String stateName) throws SQLException {
    SorterMcsJob result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? AND state_name=?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, stateName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public SorterMcsJob selectByResourceCarrier(String resourceBo, String carrier, String stateName)
      throws SQLException {
    SorterMcsJob result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE resource_bo=? AND carrier_porta =? AND state_name=? ORDER BY create_time DESC")) {
      ps.setString(1, resourceBo);
      ps.setString(2, carrier);
      ps.setString(3, stateName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<SorterMcsJob> select(Where where) throws SQLException {
    ArrayList<SorterMcsJob> result = new ArrayList<SorterMcsJob>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }


  public List<SorterMcsJob> selectByA(String carrierPortA, String stateName) throws SQLException {
    ArrayList<SorterMcsJob> result = new ArrayList<SorterMcsJob>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE carrier_porta =? AND state_name =? ORDER BY update_time DESC")) {
      ps.setString(1, carrierPortA);
      ps.setString(2, stateName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SorterMcsJob> selectByState(String stateName)
      throws SQLException {
    ArrayList<SorterMcsJob> result = new ArrayList<SorterMcsJob>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE state_name =? ORDER BY update_time")) {
      ps.setString(1, stateName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SorterMcsJob> selectByResource(String resourceBo) throws SQLException {
    ArrayList<SorterMcsJob> result = new ArrayList<SorterMcsJob>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE resource_bo=?")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private SorterMcsJob convert(ResultSet rs) throws SQLException {
    SorterMcsJob data = new SorterMcsJob();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setJobId(rs.getString(index++));
    data.setCustomerLot(rs.getString(index++));
    data.setWaferSize(rs.getBigDecimal(index++));
    data.setCarrierPorta(rs.getString(index++));
    data.setCarrierPortb(rs.getString(index++));
    data.setCarrierPortc(rs.getString(index++));
    data.setJobType(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setMessage(rs.getString(index++));
    data.setCreateUser(rs.getString(index++));
    data.setCreateTime(DateUtils.getDateTz(rs, index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
