package ame.psb.db.dao;

import ame.psb.db.OaPassCheck;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class OaPassCheckDao {

  private static final String SQL_INS = "INSERT INTO zr_oa_pass_check(id,oa_id,action_name,action_content,operation_bo,spare_value,spare_value2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_oa_pass_check SET oa_id=?,action_name=?,action_content=?,operation_bo=?,spare_value=?,spare_value2=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,oa_id,action_name,action_content,operation_bo,spare_value,spare_value2,updated_user,updated_time FROM zr_oa_pass_check ";

  private final Connection conn;

  public OaPassCheckDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(OaPassCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getOaId());
      ps.setString(3, data.getActionName());
      ps.setString(4, data.getActionContent());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getSpareValue());
      ps.setString(7, data.getSpareValue2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<OaPassCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (OaPassCheck data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getOaId());
        ps.setString(3, data.getActionName());
        ps.setString(4, data.getActionContent());
        ps.setString(5, data.getOperationBo());
        ps.setString(6, data.getSpareValue());
        ps.setString(7, data.getSpareValue2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(OaPassCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getOaId());
      ps.setString(2, data.getActionName());
      ps.setString(3, data.getActionContent());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getSpareValue());
      ps.setString(6, data.getSpareValue2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<OaPassCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (OaPassCheck data : dataList) {
        ps.setString(1, data.getOaId());
        ps.setString(2, data.getActionName());
        ps.setString(3, data.getActionContent());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getSpareValue());
        ps.setString(6, data.getSpareValue2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_oa_pass_check WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<OaPassCheck> selectAll() throws SQLException {
    ArrayList<OaPassCheck> result = new ArrayList<OaPassCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OaPassCheck> selectByRequest(String request) throws SQLException {
    ArrayList<OaPassCheck> result = new ArrayList<OaPassCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE oa_id=?")) {
      ps.setString(1, request);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OaPassCheck> selectByAction(String actionName, String actionContent)
      throws SQLException {
    ArrayList<OaPassCheck> result = new ArrayList<OaPassCheck>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE action_name=? AND action_content =? and spare_value= 'Wait'")) {
      ps.setString(1, actionName);
      ps.setString(2, actionContent);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public OaPassCheck selectByPK(String id) throws SQLException {
    OaPassCheck result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private OaPassCheck convert(ResultSet rs) throws SQLException {
    OaPassCheck data = new OaPassCheck();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setOaId(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setActionContent(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setSpareValue(rs.getString(index++));
    data.setSpareValue2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
