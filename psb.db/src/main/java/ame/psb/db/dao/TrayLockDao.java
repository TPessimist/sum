package ame.psb.db.dao;

import ame.psb.db.TrayLock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class TrayLockDao {

  private static final String SQL_INS = "INSERT INTO zr_tray_lock(container_bo,state_name,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_tray_lock SET state_name=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE container_bo=?";

  private static final String SQL_SEL = "SELECT container_bo,state_name,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_tray_lock ";

  private final Connection conn;

  public TrayLockDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(TrayLock data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getContainerBo());
      ps.setString(2, data.getStateName());
      ps.setString(3, data.getReversedField1());
      ps.setString(4, data.getReversedField2());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<TrayLock> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (TrayLock data : dataList) {
        ps.setString(1, data.getContainerBo());
        ps.setString(2, data.getStateName());
        ps.setString(3, data.getReversedField1());
        ps.setString(4, data.getReversedField2());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(TrayLock data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getStateName());
      ps.setString(2, data.getReversedField1());
      ps.setString(3, data.getReversedField2());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getContainerBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<TrayLock> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (TrayLock data : dataList) {
        ps.setString(1, data.getStateName());
        ps.setString(2, data.getReversedField1());
        ps.setString(3, data.getReversedField2());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getContainerBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String containerBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_tray_lock WHERE container_bo=?")) {
      ps.setString(1, containerBo);

      return ps.executeUpdate();
    }
  }

  public List<TrayLock> selectAll() throws SQLException {
    ArrayList<TrayLock> result = new ArrayList<TrayLock>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public TrayLock selectByPK(String containerBo) throws SQLException {
    TrayLock result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE container_bo=?")) {
      ps.setString(1, containerBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public void lock(String trayId, String user) throws SQLException {
    TrayLock trayLock = selectByPK(trayId);
    if (null == trayLock) {
      insert(new TrayLock(trayId, user));
    } else {
      trayLock.setStateName("LOCKED");
      trayLock.setUpdatedTime(new Date());
      update(trayLock);
    }
  }

  public void unLock(String trayId) throws SQLException {
    TrayLock trayLock = selectByPK(trayId);
    if (null != trayLock) {
      trayLock.setStateName("UNLOCKED");
      trayLock.setUpdatedTime(new Date());
      update(trayLock);
    }
  }

  private TrayLock convert(ResultSet rs) throws SQLException {
    TrayLock data = new TrayLock();

    int index = 1;
    data.setContainerBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
