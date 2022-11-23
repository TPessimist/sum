package ame.psb.db.dao;

import ame.psb.db.SpcAlarmData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SpcAlarmDataDao {

  private static final String SQL_INS = "INSERT INTO zr_spc_alarm_data(id_master,id,sfc,device_name,operation_bo,parameter_name,rulename,description,dc_position,usl,lsl,ucl,lcl,dc_value,created_date_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_spc_alarm_data SET id_master=?,sfc=?,device_name=?,operation_bo=?,parameter_name=?,description=?,dc_position=?,usl=?,lsl=?,ucl=?,lcl=?,dc_value=?,created_date_time=? WHERE id=? AND rulename=?";

  private static final String SQL_SEL = "SELECT id_master,id,sfc,device_name,operation_bo,parameter_name,rulename,description,dc_position,usl,lsl,ucl,lcl,dc_value,created_date_time FROM zr_spc_alarm_data ";

  private final Connection conn;

  public SpcAlarmDataDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SpcAlarmData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getIdMaster());
      ps.setString(2, data.getId());
      ps.setString(3, data.getSfc());
      ps.setString(4, data.getDeviceName());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getParameterName());
      ps.setString(7, data.getRulename());
      ps.setString(8, data.getDescription());
      ps.setBigDecimal(9, data.getDcPosition());
      ps.setBigDecimal(10, data.getUsl());
      ps.setBigDecimal(11, data.getLsl());
      ps.setBigDecimal(12, data.getUcl());
      ps.setBigDecimal(13, data.getLcl());
      ps.setBigDecimal(14, data.getDcValue());
      ps.setTimestamp(15, new Timestamp(data.getCreatedDateTime().getTime()));

      return ps.executeUpdate();
    }
  }

  public int insert(List<SpcAlarmData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SpcAlarmData data : dataList) {
        ps.setString(1, data.getIdMaster());
        ps.setString(2, data.getId());
        ps.setString(3, data.getSfc());
        ps.setString(4, data.getDeviceName());
        ps.setString(5, data.getOperationBo());
        ps.setString(6, data.getParameterName());
        ps.setString(7, data.getRulename());
        ps.setString(8, data.getDescription());
        ps.setBigDecimal(9, data.getDcPosition());
        ps.setBigDecimal(10, data.getUsl());
        ps.setBigDecimal(11, data.getLsl());
        ps.setBigDecimal(12, data.getUcl());
        ps.setBigDecimal(13, data.getLcl());
        ps.setBigDecimal(14, data.getDcValue());
        ps.setTimestamp(15, new Timestamp(data.getCreatedDateTime().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SpcAlarmData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getIdMaster());
      ps.setString(2, data.getSfc());
      ps.setString(3, data.getDeviceName());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getParameterName());
      ps.setString(6, data.getDescription());
      ps.setBigDecimal(7, data.getDcPosition());
      ps.setBigDecimal(8, data.getUsl());
      ps.setBigDecimal(9, data.getLsl());
      ps.setBigDecimal(10, data.getUcl());
      ps.setBigDecimal(11, data.getLcl());
      ps.setBigDecimal(12, data.getDcValue());
      ps.setTimestamp(13, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setString(14, data.getId());
      ps.setString(15, data.getRulename());

      return ps.executeUpdate();
    }
  }

  public int update(List<SpcAlarmData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SpcAlarmData data : dataList) {
        ps.setString(1, data.getIdMaster());
        ps.setString(2, data.getSfc());
        ps.setString(3, data.getDeviceName());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getParameterName());
        ps.setString(6, data.getDescription());
        ps.setBigDecimal(7, data.getDcPosition());
        ps.setBigDecimal(8, data.getUsl());
        ps.setBigDecimal(9, data.getLsl());
        ps.setBigDecimal(10, data.getUcl());
        ps.setBigDecimal(11, data.getLcl());
        ps.setBigDecimal(12, data.getDcValue());
        ps.setTimestamp(13, new Timestamp(data.getCreatedDateTime().getTime()));
        ps.setString(14, data.getId());
        ps.setString(15, data.getRulename());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id, String rulename) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_spc_alarm_data WHERE id=? AND rulename=?")) {
      ps.setString(1, id);
      ps.setString(2, rulename);

      return ps.executeUpdate();
    }
  }

  public List<SpcAlarmData> selectAll() throws SQLException {
    ArrayList<SpcAlarmData> result = new ArrayList<SpcAlarmData>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SpcAlarmData selectByPK(String id, String rulename) throws SQLException {
    SpcAlarmData result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=? AND rulename=?")) {
      ps.setString(1, id);
      ps.setString(2, rulename);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<SpcAlarmData> selectByMasterId(String masterId) throws SQLException {
    ArrayList<SpcAlarmData> result = new ArrayList<SpcAlarmData>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id_master=?")) {
      ps.setString(1, masterId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private SpcAlarmData convert(ResultSet rs) throws SQLException {
    SpcAlarmData data = new SpcAlarmData();

    int index = 1;
    data.setIdMaster(rs.getString(index++));
    data.setId(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setParameterName(rs.getString(index++));
    data.setRulename(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setDcPosition(rs.getBigDecimal(index++));
    data.setUsl(rs.getBigDecimal(index++));
    data.setLsl(rs.getBigDecimal(index++));
    data.setUcl(rs.getBigDecimal(index++));
    data.setLcl(rs.getBigDecimal(index++));
    data.setDcValue(rs.getBigDecimal(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));

    return data;
  }
}
