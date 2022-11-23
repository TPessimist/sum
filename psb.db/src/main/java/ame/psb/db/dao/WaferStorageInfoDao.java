package ame.psb.db.dao;

import ame.psb.db.WaferStorageInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class WaferStorageInfoDao {

  private static final String SQL_INS = "INSERT INTO zr_wafer_storage_info(id,wafer_storage_bo,remain_wafer_carrier_bo,normal_wafer_carrier_bo,remain_wafer_done_flag,normal_wafer_done_flag,reverse_field1,reverse_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_wafer_storage_info SET wafer_storage_bo=?,remain_wafer_carrier_bo=?,normal_wafer_carrier_bo=?,remain_wafer_done_flag=?,normal_wafer_done_flag=?,reverse_field1=?,reverse_field2=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,wafer_storage_bo,remain_wafer_carrier_bo,normal_wafer_carrier_bo,remain_wafer_done_flag,normal_wafer_done_flag,reverse_field1,reverse_field2,updated_user,updated_time FROM zr_wafer_storage_info ";

  private final Connection conn;

  public WaferStorageInfoDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(WaferStorageInfo data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getWaferStorageBo());
      ps.setString(3, data.getRemainWaferCarrierBo());
      ps.setString(4, data.getNormalWaferCarrierBo());
      ps.setString(5, data.getRemainWaferDoneFlag());
      ps.setString(6, data.getNormalWaferDoneFlag());
      ps.setString(7, data.getReverseField1());
      ps.setString(8, data.getReverseField2());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<WaferStorageInfo> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (WaferStorageInfo data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getWaferStorageBo());
        ps.setString(3, data.getRemainWaferCarrierBo());
        ps.setString(4, data.getNormalWaferCarrierBo());
        ps.setString(5, data.getRemainWaferDoneFlag());
        ps.setString(6, data.getNormalWaferDoneFlag());
        ps.setString(7, data.getReverseField1());
        ps.setString(8, data.getReverseField2());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(WaferStorageInfo data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getWaferStorageBo());
      ps.setString(2, data.getRemainWaferCarrierBo());
      ps.setString(3, data.getNormalWaferCarrierBo());
      ps.setString(4, data.getRemainWaferDoneFlag());
      ps.setString(5, data.getNormalWaferDoneFlag());
      ps.setString(6, data.getReverseField1());
      ps.setString(7, data.getReverseField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<WaferStorageInfo> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (WaferStorageInfo data : dataList) {
        ps.setString(1, data.getWaferStorageBo());
        ps.setString(2, data.getRemainWaferCarrierBo());
        ps.setString(3, data.getNormalWaferCarrierBo());
        ps.setString(4, data.getRemainWaferDoneFlag());
        ps.setString(5, data.getNormalWaferDoneFlag());
        ps.setString(6, data.getReverseField1());
        ps.setString(7, data.getReverseField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_wafer_storage_info WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<WaferStorageInfo> selectAll() throws SQLException {
    ArrayList<WaferStorageInfo> result = new ArrayList<WaferStorageInfo>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public WaferStorageInfo selectByPK(String id) throws SQLException {
    WaferStorageInfo result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public WaferStorageInfo selectByStorageBo(String waferStorageBo)
      throws SQLException {
    WaferStorageInfo result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "WHERE wafer_storage_bo=?  and remain_wafer_done_flag = 'ENABLE'  ")) {
      ps.setString(1, waferStorageBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public WaferStorageInfo selectByStorageBo2(String waferStorageBo)
      throws SQLException {
    WaferStorageInfo result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "WHERE wafer_storage_bo=?  and normal_wafer_done_flag = 'ENABLE'  ")) {
      ps.setString(1, waferStorageBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  /*
   * cc
   * 根据bo和remain_flag != CANCEL
   * remain_wafer_carrier_bo,normal_wafer_carrier_bo
   * */
  public WaferStorageInfo selectByStorageBoAndFlag(String waferStorageBo)
      throws SQLException {
    WaferStorageInfo result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "WHERE wafer_storage_bo=? and remain_wafer_done_flag = 'ENABLE' ")) {
      ps.setString(1, waferStorageBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  /*
   * cc
   * 根据bo和normal_flag != CANCEL
   * */
  public WaferStorageInfo selectByStorageBoAndNomalFlag(String waferStorageBo)
      throws SQLException {
    WaferStorageInfo result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "WHERE wafer_storage_bo=?  and normal_wafer_done_flag = 'ENABLE' ")) {
      ps.setString(1, waferStorageBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  /*
   * cc
   * */
  public WaferStorageInfo selectByNormalCarrierBoAndFlag(String normalCarrierBo, String flag)
      throws SQLException {
    WaferStorageInfo result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE normal_wafer_carrier_bo=? and normal_wafer_done_flag = ? ")) {
      ps.setString(1, normalCarrierBo);
      ps.setString(2, flag);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  /*
   * cc
   * */
  public WaferStorageInfo selectByRemainCarrierBoAndFlag(String remainCarrierBo, String flag)
      throws SQLException {
    WaferStorageInfo result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE remain_wafer_carrier_bo=? and remain_wafer_done_flag = ? ")) {
      ps.setString(1, remainCarrierBo);
      ps.setString(2, flag);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public List<WaferStorageInfo> selectByNormalCarrierBo(String normalCarrierBo)
      throws SQLException {
    ArrayList<WaferStorageInfo> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where NORMAL_WAFER_CARRIER_BO = ?")) {
      ps.setString(1, normalCarrierBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  private WaferStorageInfo convert(ResultSet rs) throws SQLException {
    WaferStorageInfo data = new WaferStorageInfo();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setWaferStorageBo(rs.getString(index++));
    data.setRemainWaferCarrierBo(rs.getString(index++));
    data.setNormalWaferCarrierBo(rs.getString(index++));
    data.setRemainWaferDoneFlag(rs.getString(index++));
    data.setNormalWaferDoneFlag(rs.getString(index++));
    data.setReverseField1(rs.getString(index++));
    data.setReverseField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
