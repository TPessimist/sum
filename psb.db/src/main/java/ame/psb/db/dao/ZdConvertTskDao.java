package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ZdConvertTsk;
import uia.utils.dao.DateUtils;

public class ZdConvertTskDao {

  private static final String SQL_INS = "INSERT INTO zd_convert_tsk(id,device_bo,convert_type,combine_operation_bo,from_operation_bo,use_operation_bo,template_id,updated_time,updated_user) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_convert_tsk SET device_bo=?,convert_type=?,combine_operation_bo=?,from_operation_bo=?,use_operation_bo=?,template_id=?,updated_time=?,updated_user=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,device_bo,convert_type,combine_operation_bo,from_operation_bo,use_operation_bo,template_id,updated_time,updated_user FROM zd_convert_tsk ";

  private final Connection conn;

  public ZdConvertTskDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdConvertTsk data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getDeviceBo());
      ps.setString(3, data.getConvertType());
      ps.setString(4, data.getCombineOperationBo());
      ps.setString(5, data.getFromOperationBo());
      ps.setString(6, data.getUseOperationBo());
      ps.setString(7, data.getTemplateId());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getUpdatedUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdConvertTsk> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdConvertTsk data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getDeviceBo());
        ps.setString(3, data.getConvertType());
        ps.setString(4, data.getCombineOperationBo());
        ps.setString(5, data.getFromOperationBo());
        ps.setString(6, data.getUseOperationBo());
        ps.setString(7, data.getTemplateId());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getUpdatedUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZdConvertTsk data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDeviceBo());
      ps.setString(2, data.getConvertType());
      ps.setString(3, data.getCombineOperationBo());
      ps.setString(4, data.getFromOperationBo());
      ps.setString(5, data.getUseOperationBo());
      ps.setString(6, data.getTemplateId());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getUpdatedUser());
      ps.setString(9, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZdConvertTsk> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZdConvertTsk data : dataList) {
        ps.setString(1, data.getDeviceBo());
        ps.setString(2, data.getConvertType());
        ps.setString(3, data.getCombineOperationBo());
        ps.setString(4, data.getFromOperationBo());
        ps.setString(5, data.getUseOperationBo());
        ps.setString(6, data.getTemplateId());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getUpdatedUser());
        ps.setString(9, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_convert_tsk WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ZdConvertTsk> selectAll() throws SQLException {
    ArrayList<ZdConvertTsk> result = new ArrayList<ZdConvertTsk>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ZdConvertTsk selectByPK(String id) throws SQLException {
    ZdConvertTsk result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ZdConvertTsk selectByCombinePK(String deviceBo, String combineOperationBo,
      String convertType)
      throws SQLException {
    ZdConvertTsk result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE device_bo=? AND combine_operation_bo = ? AND convert_type = ?")) {
      ps.setString(1, deviceBo);
      ps.setString(2, combineOperationBo);
      ps.setString(3, convertType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ZdConvertTsk selectByAcquirePK(String deviceBo, String fromOperationBo, String convertType)
      throws SQLException {
    ZdConvertTsk result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE device_bo=? AND from_operation_bo = ? AND convert_type = ?")) {
      ps.setString(1, deviceBo);
      ps.setString(2, fromOperationBo);
      ps.setString(3, convertType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZdConvertTsk> selectByDevice(String deviceBo) throws SQLException {
    ArrayList<ZdConvertTsk> result = new ArrayList<ZdConvertTsk>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE device_bo=?")) {
      ps.setString(1, deviceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ZdConvertTsk selectByDevicePK(String deviceBo, String useOperationBo) throws SQLException {
    ZdConvertTsk result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE device_bo=? and use_operation_bo=?")) {
      ps.setString(1, deviceBo);
      ps.setString(2, useOperationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZdConvertTsk convert(ResultSet rs) throws SQLException {
    ZdConvertTsk data = new ZdConvertTsk();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDeviceBo(rs.getString(index++));
    data.setConvertType(rs.getString(index++));
    data.setCombineOperationBo(rs.getString(index++));
    data.setFromOperationBo(rs.getString(index++));
    data.setUseOperationBo(rs.getString(index++));
    data.setTemplateId(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));

    return data;
  }
}
