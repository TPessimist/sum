package ame.psb.db.dao;

import ame.psb.db.SorterMcsReserve;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SorterMcsReserveDao {

  private static final String SQL_INS = "INSERT INTO zr_sorter_mcs_reserve(id,carrier_bo,carrier_name,sfc_bo,sfc_name,job_id,job_type,state,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_sorter_mcs_reserve SET carrier_bo=?,carrier_name=?,sfc_bo=?,sfc_name=?,job_id=?,job_type=?,state=?,update_user=?,update_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,carrier_bo,carrier_name,sfc_bo,sfc_name,job_id,job_type,state,update_user,update_time FROM zr_sorter_mcs_reserve ";

  private final Connection conn;

  public SorterMcsReserveDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SorterMcsReserve data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getCarrierBo());
      ps.setString(3, data.getCarrierName());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getSfcName());
      ps.setString(6, data.getJobId());
      ps.setString(7, data.getJobType());
      ps.setString(8, data.getState());
      ps.setString(9, data.getUpdateUser());
      DateUtils.setDateTz(ps, 10, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SorterMcsReserve> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SorterMcsReserve data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getCarrierBo());
        ps.setString(3, data.getCarrierName());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getSfcName());
        ps.setString(6, data.getJobId());
        ps.setString(7, data.getJobType());
        ps.setString(8, data.getState());
        ps.setString(9, data.getUpdateUser());
        DateUtils.setDateTz(ps, 10, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SorterMcsReserve data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCarrierBo());
      ps.setString(2, data.getCarrierName());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getSfcName());
      ps.setString(5, data.getJobId());
      ps.setString(6, data.getJobType());
      ps.setString(7, data.getState());
      ps.setString(8, data.getUpdateUser());
      DateUtils.setDateTz(ps, 9, data.getUpdateTime());
      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<SorterMcsReserve> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SorterMcsReserve data : dataList) {
        ps.setString(1, data.getCarrierBo());
        ps.setString(2, data.getCarrierName());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getSfcName());
        ps.setString(5, data.getJobId());
        ps.setString(6, data.getJobType());
        ps.setString(7, data.getState());
        ps.setString(8, data.getUpdateUser());
        DateUtils.setDateTz(ps, 9, data.getUpdateTime());
        ps.setString(10, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_sorter_mcs_reserve WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<SorterMcsReserve> selectAll() throws SQLException {
    ArrayList<SorterMcsReserve> result = new ArrayList<SorterMcsReserve>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SorterMcsReserve selectByPK(String id) throws SQLException {
    SorterMcsReserve result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<SorterMcsReserve> selectByJobType(String jobType) throws SQLException {
    ArrayList<SorterMcsReserve> result = new ArrayList<SorterMcsReserve>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE job_type=? AND state = 'WAIT' ORDER BY update_time DESC ")) {
      ps.setString(1, jobType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SorterMcsReserve selectByValue(String sfcBo) throws SQLException {
    SorterMcsReserve result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL
                + "WHERE sfc_bo=? AND state = 'WAIT' ORDER BY update_time DESC ")) {
      ps.setString(1, sfcBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  private SorterMcsReserve convert(ResultSet rs) throws SQLException {
    SorterMcsReserve data = new SorterMcsReserve();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setCarrierBo(rs.getString(index++));
    data.setCarrierName(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setJobId(rs.getString(index++));
    data.setJobType(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
