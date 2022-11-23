package ame.psb.db.dao;

import ame.psb.db.DashboardLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class DashboardLayoutDao {

  private static final String SQL_INS = "INSERT INTO zd_dashboard_layout(id,state,name,layout_data,memo,reserve1,reserve2,reserve3,updated_time,updated_user) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_dashboard_layout SET state=?,name=?,layout_data=?,memo=?,reserve1=?,reserve2=?,reserve3=?,updated_time=?,updated_user=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,state,name,layout_data,memo,reserve1,reserve2,reserve3,updated_time,updated_user FROM zd_dashboard_layout ";

  private final Connection conn;

  public DashboardLayoutDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DashboardLayout data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getState());
      ps.setString(3, data.getName());
      ps.setString(4, data.getLayoutData());
      ps.setString(5, data.getMemo());
      ps.setString(6, data.getReserve1());
      ps.setString(7, data.getReserve2());
      ps.setString(8, data.getReserve3());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getUpdatedUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DashboardLayout> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DashboardLayout data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getState());
        ps.setString(3, data.getName());
        ps.setString(4, data.getLayoutData());
        ps.setString(5, data.getMemo());
        ps.setString(6, data.getReserve1());
        ps.setString(7, data.getReserve2());
        ps.setString(8, data.getReserve3());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getUpdatedUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DashboardLayout data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getState());
      ps.setString(2, data.getName());
      ps.setString(3, data.getLayoutData());
      ps.setString(4, data.getMemo());
      ps.setString(5, data.getReserve1());
      ps.setString(6, data.getReserve2());
      ps.setString(7, data.getReserve3());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getUpdatedUser());
      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<DashboardLayout> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DashboardLayout data : dataList) {
        ps.setString(1, data.getState());
        ps.setString(2, data.getName());
        ps.setString(3, data.getLayoutData());
        ps.setString(4, data.getMemo());
        ps.setString(5, data.getReserve1());
        ps.setString(6, data.getReserve2());
        ps.setString(7, data.getReserve3());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getUpdatedUser());
        ps.setString(10, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_dashboard_layout WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<DashboardLayout> selectAll() throws SQLException {
    ArrayList<DashboardLayout> result = new ArrayList<DashboardLayout>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<DashboardLayout> selectAllActive() throws SQLException {
    ArrayList<DashboardLayout> result = new ArrayList<DashboardLayout>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where state = 'Y' ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public DashboardLayout selectActiveByName(String name) throws SQLException {
    DashboardLayout result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where state = 'Y' and name = ? ")) {

      ps.setString(1, name);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public DashboardLayout selectByPK(String id) throws SQLException {
    DashboardLayout result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private DashboardLayout convert(ResultSet rs) throws SQLException {
    DashboardLayout data = new DashboardLayout();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setName(rs.getString(index++));
    data.setLayoutData(rs.getString(index++));
    data.setMemo(rs.getString(index++));
    data.setReserve1(rs.getString(index++));
    data.setReserve2(rs.getString(index++));
    data.setReserve3(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));

    return data;
  }
}
