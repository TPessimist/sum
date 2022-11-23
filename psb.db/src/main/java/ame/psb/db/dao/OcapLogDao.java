package ame.psb.db.dao;

import ame.psb.db.OcapLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class OcapLogDao {

  private static final String SQL_INS = "INSERT INTO zd_ocap_log(oa_id,action_name,content,operation_bo,operation,log_user,log_time,status,message) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_ocap_log SET action_name=?,content=?,operation_bo=?,operation=?,log_user=?,log_time=?,status=?,message=? WHERE oa_id=?";

  private static final String SQL_SEL = "SELECT oa_id,action_name,content,operation_bo,operation,log_user,log_time,status,message FROM zd_ocap_log ";

  private final Connection conn;

  public OcapLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(OcapLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getOaId());
      ps.setString(2, data.getActionName());
      ps.setString(3, data.getContent());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getOperation());
      ps.setString(6, data.getLogUser());
      DateUtils.setDateTz(ps, 7, data.getLogTime());
      ps.setString(8, data.getStatus());
      ps.setString(9, data.getMessage());

      return ps.executeUpdate();
    }
  }

  public int insert(List<OcapLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (OcapLog data : dataList) {
        ps.setString(1, data.getOaId());
        ps.setString(2, data.getActionName());
        ps.setString(3, data.getContent());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getOperation());
        ps.setString(6, data.getLogUser());
        DateUtils.setDateTz(ps, 7, data.getLogTime());
        ps.setString(8, data.getStatus());
        ps.setString(9, data.getMessage());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(OcapLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getActionName());
      ps.setString(2, data.getContent());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getOperation());
      ps.setString(5, data.getLogUser());
      DateUtils.setDateTz(ps, 6, data.getLogTime());
      ps.setString(7, data.getStatus());
      ps.setString(8, data.getMessage());
      ps.setString(9, data.getOaId());

      return ps.executeUpdate();
    }
  }

  public int update(List<OcapLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (OcapLog data : dataList) {
        ps.setString(1, data.getActionName());
        ps.setString(2, data.getContent());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getOperation());
        ps.setString(5, data.getLogUser());
        DateUtils.setDateTz(ps, 6, data.getLogTime());
        ps.setString(7, data.getStatus());
        ps.setString(8, data.getMessage());
        ps.setString(9, data.getOaId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String oaId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_ocap_log WHERE oa_id=?")) {
      ps.setString(1, oaId);

      return ps.executeUpdate();
    }
  }

  public List<OcapLog> selectAll() throws SQLException {
    ArrayList<OcapLog> result = new ArrayList<OcapLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public OcapLog selectByPK(String oaId) throws SQLException {
    OcapLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE oa_id=?")) {
      ps.setString(1, oaId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private OcapLog convert(ResultSet rs) throws SQLException {
    OcapLog data = new OcapLog();

    int index = 1;
    data.setOaId(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setLogUser(rs.getString(index++));
    data.setLogTime(DateUtils.getDateTz(rs, index++));
    data.setStatus(rs.getString(index++));
    data.setMessage(rs.getString(index++));

    return data;
  }
}
