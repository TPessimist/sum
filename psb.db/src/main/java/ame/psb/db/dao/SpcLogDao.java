package ame.psb.db.dao;

import ame.psb.db.SpcLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SpcLogDao {

  private static final String SQL_INS = "INSERT INTO zr_spc_log(id,sfc_bos,device_name,operation_bo,dc_group,parameter_name,display_template,query_template,message,create_date_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_spc_log SET sfc_bos=?,device_name=?,operation_bo=?,dc_group=?,parameter_name=?,display_template=?,query_template=?,message=?,create_date_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sfc_bos,device_name,operation_bo,dc_group,parameter_name,display_template,query_template,message,create_date_time FROM zr_spc_log ";

  private final Connection conn;

  public SpcLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SpcLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcBos());
      ps.setString(3, data.getDeviceName());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getDcGroup());
      ps.setString(6, data.getParameterName());
      ps.setString(7, data.getDisplayTemplate());
      ps.setString(8, data.getQueryTemplate());
      ps.setString(9, data.getMessage());
      ps.setTimestamp(10, new Timestamp(data.getCreateDateTime().getTime()));

      return ps.executeUpdate();
    }
  }

  public int insert(List<SpcLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SpcLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfcBos());
        ps.setString(3, data.getDeviceName());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getDcGroup());
        ps.setString(6, data.getParameterName());
        ps.setString(7, data.getDisplayTemplate());
        ps.setString(8, data.getQueryTemplate());
        ps.setString(9, data.getMessage());
        ps.setTimestamp(10, new Timestamp(data.getCreateDateTime().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SpcLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBos());
      ps.setString(2, data.getDeviceName());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getDcGroup());
      ps.setString(5, data.getParameterName());
      ps.setString(6, data.getDisplayTemplate());
      ps.setString(7, data.getQueryTemplate());
      ps.setString(8, data.getMessage());
      ps.setTimestamp(9, new Timestamp(data.getCreateDateTime().getTime()));
      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<SpcLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SpcLog data : dataList) {
        ps.setString(1, data.getSfcBos());
        ps.setString(2, data.getDeviceName());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getDcGroup());
        ps.setString(5, data.getParameterName());
        ps.setString(6, data.getDisplayTemplate());
        ps.setString(7, data.getQueryTemplate());
        ps.setString(8, data.getMessage());
        ps.setTimestamp(9, new Timestamp(data.getCreateDateTime().getTime()));
        ps.setString(10, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_spc_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<SpcLog> selectAll() throws SQLException {
    ArrayList<SpcLog> result = new ArrayList<SpcLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public SpcLog selectByPK(String id) throws SQLException {
    SpcLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SpcLog convert(ResultSet rs) throws SQLException {
    SpcLog data = new SpcLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcBos(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDcGroup(rs.getString(index++));
    data.setParameterName(rs.getString(index++));
    data.setDisplayTemplate(rs.getString(index++));
    data.setQueryTemplate(rs.getString(index++));
    data.setMessage(rs.getString(index++));
    data.setCreateDateTime(rs.getTimestamp(index++));

    return data;
  }
}
