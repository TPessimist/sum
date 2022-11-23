package ame.psb.db.dao;

import ame.psb.db.SfcNotify;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class SfcNotifyDao {

  private static final String SQL_INS = "INSERT INTO zr_sfc_notify(id,sfc_bo,operation_bo,hold_code,hold_comment,state_name,notify_user,notify_comment,notify_time,notified_user,notified_time,notified_comment,created_time,created_user,move_in_time,move_in_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_sfc_notify SET sfc_bo=?,operation_bo=?,hold_code=?,hold_comment=?,state_name=?,notify_user=?,notify_comment=?,notify_time=?,notified_user=?,notified_time=?,notified_comment=?,created_time=?,created_user=?,move_in_time=?,move_in_user=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sfc_bo,operation_bo,hold_code,hold_comment,state_name,notify_user,notify_comment,notify_time,notified_user,notified_time,notified_comment,created_time,created_user,move_in_time,move_in_user FROM zr_sfc_notify ";

  private final Connection conn;

  public SfcNotifyDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SfcNotify data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getHoldCode());
      ps.setString(5, data.getHoldComment());
      ps.setString(6, data.getStateName());
      ps.setString(7, data.getNotifyUser());
      ps.setString(8, data.getNotifyComment());
      DateUtils.setDateTz(ps, 9, data.getNotifyTime());
      ps.setString(10, data.getNotifiedUser());
      DateUtils.setDateTz(ps, 11, data.getNotifiedTime());
      ps.setString(12, data.getNotifiedComment());
      DateUtils.setDateTz(ps, 13, data.getCreatedTime());
      ps.setString(14, data.getCreatedUser());
      DateUtils.setDateTz(ps, 15, data.getMoveInTime());
      ps.setString(16, data.getMoveInUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SfcNotify> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SfcNotify data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getHoldCode());
        ps.setString(5, data.getHoldComment());
        ps.setString(6, data.getStateName());
        ps.setString(7, data.getNotifyUser());
        ps.setString(8, data.getNotifyComment());
        DateUtils.setDateTz(ps, 9, data.getNotifyTime());
        ps.setString(10, data.getNotifiedUser());
        DateUtils.setDateTz(ps, 11, data.getNotifiedTime());
        ps.setString(12, data.getNotifiedComment());
        DateUtils.setDateTz(ps, 13, data.getCreatedTime());
        ps.setString(14, data.getCreatedUser());
        DateUtils.setDateTz(ps, 15, data.getMoveInTime());
        ps.setString(16, data.getMoveInUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SfcNotify data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getHoldCode());
      ps.setString(4, data.getHoldComment());
      ps.setString(5, data.getStateName());
      ps.setString(6, data.getNotifyUser());
      ps.setString(7, data.getNotifyComment());
      DateUtils.setDateTz(ps, 8, data.getNotifyTime());
      ps.setString(9, data.getNotifiedUser());
      DateUtils.setDateTz(ps, 10, data.getNotifiedTime());
      ps.setString(11, data.getNotifiedComment());
      DateUtils.setDateTz(ps, 12, data.getCreatedTime());
      ps.setString(13, data.getCreatedUser());
      DateUtils.setDateTz(ps, 14, data.getMoveInTime());
      ps.setString(15, data.getMoveInUser());
      ps.setString(16, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<SfcNotify> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SfcNotify data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getHoldCode());
        ps.setString(4, data.getHoldComment());
        ps.setString(5, data.getStateName());
        ps.setString(6, data.getNotifyUser());
        ps.setString(7, data.getNotifyComment());
        DateUtils.setDateTz(ps, 8, data.getNotifyTime());
        ps.setString(9, data.getNotifiedUser());
        DateUtils.setDateTz(ps, 10, data.getNotifiedTime());
        ps.setString(11, data.getNotifiedComment());
        DateUtils.setDateTz(ps, 12, data.getCreatedTime());
        ps.setString(13, data.getCreatedUser());
        DateUtils.setDateTz(ps, 14, data.getMoveInTime());
        ps.setString(15, data.getMoveInUser());
        ps.setString(16, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_sfc_notify WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<SfcNotify> selectAll() throws SQLException {
    ArrayList<SfcNotify> result = new ArrayList<SfcNotify>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<SfcNotify> select(Where where) throws SQLException {
    ArrayList<SfcNotify> result = new ArrayList<SfcNotify>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<SfcNotify> selectActiveByResource(String resourceBo) throws SQLException {
    ArrayList<SfcNotify> result = new ArrayList<SfcNotify>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE state_name in ('NEW', 'NOTIFIED', 'WAIT') and  operation_bo in (select operation_parent from view_operation_resource WHERE resource_bo=?   )  ORDER BY sfc_bo")) {

      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<SfcNotify> selectActiveByOperation(String operationBo) throws SQLException {
    ArrayList<SfcNotify> result = new ArrayList<SfcNotify>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE state_name in ('NEW', 'NOTIFIED', 'WAIT') and  operation_bo=? ORDER BY sfc_bo")) {

      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<SfcNotify> selectActiveBySfcBo(String sfcBo) throws SQLException {
    ArrayList<SfcNotify> result = new ArrayList<SfcNotify>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE state_name in ('NEW', 'NOTIFIED', 'WAIT') and sfc_bo=? ")) {

      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<SfcNotify> selectInitBySfcBo(String sfcBo) throws SQLException {
    ArrayList<SfcNotify> result = new ArrayList<SfcNotify>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE state_name = 'INIT' and sfc_bo=? ")) {

      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public SfcNotify selectByPK(String id) throws SQLException {
    SfcNotify result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private SfcNotify convert(ResultSet rs) throws SQLException {
    SfcNotify data = new SfcNotify();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setHoldCode(rs.getString(index++));
    data.setHoldComment(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setNotifyUser(rs.getString(index++));
    data.setNotifyComment(rs.getString(index++));
    data.setNotifyTime(DateUtils.getDateTz(rs, index++));
    data.setNotifiedUser(rs.getString(index++));
    data.setNotifiedTime(DateUtils.getDateTz(rs, index++));
    data.setNotifiedComment(rs.getString(index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));
    data.setCreatedUser(rs.getString(index++));
    data.setMoveInTime(DateUtils.getDateTz(rs, index++));
    data.setMoveInUser(rs.getString(index++));

    return data;
  }
}
