package ame.psb.db.dao;

import ame.psb.db.ChartSetUp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ChartSetUpDao {

  private static final String SQL_INS = "INSERT INTO zd_chart_setup(operation,dc_group,dc_parameter,tolerance,point,chart_id,tooling1,tooling2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_chart_setup SET chart_id=?,tooling1=?,tooling2=?,updated_user=?,updated_time=? WHERE operation=? AND dc_group=? AND dc_parameter=? AND tolerance=? AND point=?";

  private static final String SQL_SEL = "SELECT operation,dc_group,dc_parameter,tolerance,point,chart_id,tooling1,tooling2,updated_user,updated_time FROM zd_chart_setup ";

  private final Connection conn;

  public ChartSetUpDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ChartSetUp data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getOperation());
      ps.setString(2, data.getDcGroup());
      ps.setString(3, data.getDcParameter());
      ps.setString(4, data.getTolerance());
      ps.setString(5, data.getPoint());
      ps.setString(6, data.getChartId());
      ps.setString(7, data.getTooling1());
      ps.setString(8, data.getTooling2());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ChartSetUp> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ChartSetUp data : dataList) {
        ps.setString(1, data.getOperation());
        ps.setString(2, data.getDcGroup());
        ps.setString(3, data.getDcParameter());
        ps.setString(4, data.getTolerance());
        ps.setString(5, data.getPoint());
        ps.setString(6, data.getChartId());
        ps.setString(7, data.getTooling1());
        ps.setString(8, data.getTooling2());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ChartSetUp data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getChartId());
      ps.setString(2, data.getTooling1());
      ps.setString(3, data.getTooling2());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getOperation());
      ps.setString(7, data.getDcGroup());
      ps.setString(8, data.getDcParameter());
      ps.setString(9, data.getTolerance());
      ps.setString(10, data.getPoint());

      return ps.executeUpdate();
    }
  }

  public int update(List<ChartSetUp> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ChartSetUp data : dataList) {
        ps.setString(1, data.getChartId());
        ps.setString(2, data.getTooling1());
        ps.setString(3, data.getTooling2());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getOperation());
        ps.setString(7, data.getDcGroup());
        ps.setString(8, data.getDcParameter());
        ps.setString(9, data.getTolerance());
        ps.setString(10, data.getPoint());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String operation, String dcGroup, String dcParameter, String tolerance,
      String point) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_chart_setup WHERE operation=? AND dc_group=? AND dc_parameter=? AND tolerance=? AND point=?")) {
      ps.setString(1, operation);
      ps.setString(2, dcGroup);
      ps.setString(3, dcParameter);
      ps.setString(4, tolerance);
      ps.setString(5, point);

      return ps.executeUpdate();
    }
  }

  public List<ChartSetUp> selectAll() throws SQLException {
    ArrayList<ChartSetUp> result = new ArrayList<ChartSetUp>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ChartSetUp selectByPK(String operation, String dcGroup, String dcParameter,
      String tolerance, String point) throws SQLException {
    ChartSetUp result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE operation=? AND dc_group=? AND dc_parameter=? AND tolerance=? AND point=?")) {
      ps.setString(1, operation);
      ps.setString(2, dcGroup);
      ps.setString(3, dcParameter);
      ps.setString(4, tolerance);
      ps.setString(5, point);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ChartSetUp convert(ResultSet rs) throws SQLException {
    ChartSetUp data = new ChartSetUp();

    int index = 1;
    data.setOperation(rs.getString(index++));
    data.setDcGroup(rs.getString(index++));
    data.setDcParameter(rs.getString(index++));
    data.setTolerance(rs.getString(index++));
    data.setPoint(rs.getString(index++));
    data.setChartId(rs.getString(index++));
    data.setTooling1(rs.getString(index++));
    data.setTooling2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
