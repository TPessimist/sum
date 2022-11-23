package ame.psb.db.dao;

import ame.psb.db.OaOperationJump;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class OaOperationJumpDao {

  private static final String SQL_INS = "INSERT INTO zd_oa_operation_jump(id,sfc_bo,operation_bo,next_operation_bo,expiration_time,update_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_oa_operation_jump SET sfc_bo=?,operation_bo=?,next_operation_bo=?,expiration_time=?,update_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sfc_bo,operation_bo,next_operation_bo,expiration_time,update_time FROM zd_oa_operation_jump ";

  private final Connection conn;

  public OaOperationJumpDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(OaOperationJump data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getNextOperationBo());
      DateUtils.setDateTz(ps, 5, data.getExpirationTime());
      DateUtils.setDateTz(ps, 6, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<OaOperationJump> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (OaOperationJump data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getNextOperationBo());
        DateUtils.setDateTz(ps, 5, data.getExpirationTime());
        DateUtils.setDateTz(ps, 6, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(OaOperationJump data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getNextOperationBo());
      DateUtils.setDateTz(ps, 4, data.getExpirationTime());
      DateUtils.setDateTz(ps, 5, data.getUpdateTime());
      ps.setString(6, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<OaOperationJump> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (OaOperationJump data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getNextOperationBo());
        DateUtils.setDateTz(ps, 4, data.getExpirationTime());
        DateUtils.setDateTz(ps, 5, data.getUpdateTime());
        ps.setString(6, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_oa_operation_jump WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<OaOperationJump> selectAll() throws SQLException {
    ArrayList<OaOperationJump> result = new ArrayList<OaOperationJump>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OaOperationJump> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<OaOperationJump> result = new ArrayList<OaOperationJump>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public OaOperationJump selectByPK(String id) throws SQLException {
    OaOperationJump result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private OaOperationJump convert(ResultSet rs) throws SQLException {
    OaOperationJump data = new OaOperationJump();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setNextOperationBo(rs.getString(index++));
    data.setExpirationTime(DateUtils.getDateTz(rs, index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
