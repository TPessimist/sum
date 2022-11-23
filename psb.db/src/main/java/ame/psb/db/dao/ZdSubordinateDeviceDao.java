package ame.psb.db.dao;

import ame.psb.db.ZdSubordinateDevice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZdSubordinateDeviceDao {

  private static final String SQL_INS = "INSERT INTO zd_subordinate_device(id,master_device_bo,assistant_device_bo,subordinate_type,reverse_field1,reverse_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_subordinate_device SET id=?,subordinate_type=?,reverse_field1=?,reverse_field2=?,updated_user=?,updated_time=? WHERE master_device_bo=? AND assistant_device_bo=?";

  private static final String SQL_SEL = "SELECT id,master_device_bo,assistant_device_bo,subordinate_type,reverse_field1,reverse_field2,updated_user,updated_time FROM zd_subordinate_device ";

  private final Connection conn;

  public ZdSubordinateDeviceDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdSubordinateDevice data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getMasterDeviceBo());
      ps.setString(3, data.getAssistantDeviceBo());
      ps.setString(4, data.getSubordinateType());
      ps.setString(5, data.getReverseField1());
      ps.setString(6, data.getReverseField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdSubordinateDevice> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdSubordinateDevice data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getMasterDeviceBo());
        ps.setString(3, data.getAssistantDeviceBo());
        ps.setString(4, data.getSubordinateType());
        ps.setString(5, data.getReverseField1());
        ps.setString(6, data.getReverseField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZdSubordinateDevice data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSubordinateType());
      ps.setString(3, data.getReverseField1());
      ps.setString(4, data.getReverseField2());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getMasterDeviceBo());
      ps.setString(8, data.getAssistantDeviceBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZdSubordinateDevice> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZdSubordinateDevice data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSubordinateType());
        ps.setString(3, data.getReverseField1());
        ps.setString(4, data.getReverseField2());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getMasterDeviceBo());
        ps.setString(8, data.getAssistantDeviceBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String masterDeviceBo, String assistantDeviceBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_subordinate_device WHERE master_device_bo=? AND assistant_device_bo=?")) {
      ps.setString(1, masterDeviceBo);
      ps.setString(2, assistantDeviceBo);

      return ps.executeUpdate();
    }
  }

  public List<ZdSubordinateDevice> selectAll() throws SQLException {
    ArrayList<ZdSubordinateDevice> result = new ArrayList<ZdSubordinateDevice>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZdSubordinateDevice selectByPK(String masterDeviceBo, String assistantDeviceBo)
      throws SQLException {
    ZdSubordinateDevice result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE master_device_bo=? AND assistant_device_bo=?")) {
      ps.setString(1, masterDeviceBo);
      ps.setString(2, assistantDeviceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZdSubordinateDevice> selectByPKByMasterDeviceBo(String masterDeviceBo)
      throws SQLException {
    List<ZdSubordinateDevice> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE master_device_bo=? ")) {
      ps.setString(1, masterDeviceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ZdSubordinateDevice selectByAssistantDeviceBo(String assistantDeviceBo)
      throws SQLException {
    ZdSubordinateDevice result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE assistant_device_bo=? ")) {
      ps.setString(1, assistantDeviceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ZdSubordinateDevice selectByAssistantDeviceBo(String assistantDeviceBo, String type)
      throws SQLException {
    ZdSubordinateDevice result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE assistant_device_bo=? and SUBORDINATE_TYPE =?  ")) {
      ps.setString(1, assistantDeviceBo);
      ps.setString(2, type);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZdSubordinateDevice> selectBymasterDeviceBo(String masterDeviceBo, String type)
      throws SQLException {
    List<ZdSubordinateDevice> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE master_device_bo=? and SUBORDINATE_TYPE =? ")) {
      ps.setString(1, masterDeviceBo);
      ps.setString(2, type);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ZdSubordinateDevice convert(ResultSet rs) throws SQLException {
    ZdSubordinateDevice data = new ZdSubordinateDevice();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setMasterDeviceBo(rs.getString(index++));
    data.setAssistantDeviceBo(rs.getString(index++));
    data.setSubordinateType(rs.getString(index++));
    data.setReverseField1(rs.getString(index++));
    data.setReverseField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
