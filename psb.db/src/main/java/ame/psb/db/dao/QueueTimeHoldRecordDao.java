package ame.psb.db.dao;

import ame.psb.db.QueueTimeHoldRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class QueueTimeHoldRecordDao {

  private static final String SQL_INS = "INSERT INTO zr_queue_time_hold_record(id,table_name,content,sfc_bo,device_bo,operation_bo,dpt_no,state,result,update_user,created_time,update_time,reserve1,reserve2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_queue_time_hold_record SET table_name=?,content=?,sfc_bo=?,device_bo=?,operation_bo=?,dpt_no=?,state=?,result=?,update_user=?,created_time=?,update_time=?,reserve1=?,reserve2=? WHERE id=?";

  private static final String SQL_UPD_2 = "UPDATE zr_queue_time_hold_record SET content=?,state=?,result=?,update_time=?,reserve1=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,table_name,content,sfc_bo,device_bo,operation_bo,dpt_no,state,result,update_user,created_time,update_time,reserve1,reserve2 FROM zr_queue_time_hold_record ";

  private final Connection conn;

  public QueueTimeHoldRecordDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(QueueTimeHoldRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getTableName());
      ps.setString(3, data.getContent());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getDeviceBo());
      ps.setString(6, data.getOperationBo());
      ps.setString(7, data.getDptNo());
      ps.setString(8, data.getState());
      ps.setString(9, data.getResult());
      ps.setString(10, data.getUpdateUser());
      DateUtils.setDateTz(ps, 11, data.getCreatedTime());
      DateUtils.setDateTz(ps, 12, data.getUpdateTime());
      ps.setString(13, data.getReserve1());
      ps.setString(14, data.getReserve2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<QueueTimeHoldRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (QueueTimeHoldRecord data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getTableName());
        ps.setString(3, data.getContent());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getDeviceBo());
        ps.setString(6, data.getOperationBo());
        ps.setString(7, data.getDptNo());
        ps.setString(8, data.getState());
        ps.setString(9, data.getResult());
        ps.setString(10, data.getUpdateUser());
        DateUtils.setDateTz(ps, 11, data.getCreatedTime());
        DateUtils.setDateTz(ps, 12, data.getUpdateTime());
        ps.setString(13, data.getReserve1());
        ps.setString(14, data.getReserve2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(QueueTimeHoldRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getTableName());
      ps.setString(2, data.getContent());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getDeviceBo());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getDptNo());
      ps.setString(7, data.getState());
      ps.setString(8, data.getResult());
      ps.setString(9, data.getUpdateUser());
      DateUtils.setDateTz(ps, 10, data.getCreatedTime());
      DateUtils.setDateTz(ps, 11, data.getUpdateTime());
      ps.setString(12, data.getReserve1());
      ps.setString(13, data.getReserve2());
      ps.setString(14, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<QueueTimeHoldRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (QueueTimeHoldRecord data : dataList) {
        ps.setString(1, data.getTableName());
        ps.setString(2, data.getContent());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getDeviceBo());
        ps.setString(5, data.getOperationBo());
        ps.setString(6, data.getDptNo());
        ps.setString(7, data.getState());
        ps.setString(8, data.getResult());
        ps.setString(9, data.getUpdateUser());
        DateUtils.setDateTz(ps, 10, data.getCreatedTime());
        DateUtils.setDateTz(ps, 11, data.getUpdateTime());
        ps.setString(12, data.getReserve1());
        ps.setString(13, data.getReserve2());
        ps.setString(14, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateSection(String id, String content, String state, String result,
      Date updateTime, String oaId) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_2)) {
      ps.setString(1, content);
      ps.setString(2, state);
      ps.setString(3, result);
      DateUtils.setDateTz(ps, 4, updateTime);
      ps.setString(5, oaId);
      ps.setString(6, id);

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_queue_time_hold_record WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<QueueTimeHoldRecord> selectAll() throws SQLException {
    ArrayList<QueueTimeHoldRecord> result = new ArrayList<QueueTimeHoldRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<QueueTimeHoldRecord> selectByState(String state) throws SQLException {
    ArrayList<QueueTimeHoldRecord> result = new ArrayList<QueueTimeHoldRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE state=? ")) {
      ps.setString(1, state);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public QueueTimeHoldRecord selectByPK(String id) throws SQLException {
    QueueTimeHoldRecord result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public QueueTimeHoldRecord selectBySfcAndDevice(String sfcBo, String device, String operation,
      String state)
      throws SQLException {
    QueueTimeHoldRecord result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE sfc_bo=? and device_bo=? and operation_bo=? and state=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, device);
      ps.setString(3, operation);
      ps.setString(4, state);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private QueueTimeHoldRecord convert(ResultSet rs) throws SQLException {
    QueueTimeHoldRecord data = new QueueTimeHoldRecord();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setTableName(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setDeviceBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDptNo(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setResult(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setReserve1(rs.getString(index++));
    data.setReserve2(rs.getString(index++));

    return data;
  }
}
