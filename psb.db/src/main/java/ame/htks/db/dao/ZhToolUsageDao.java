package ame.htks.db.dao;

import ame.htks.db.ZhToolUsage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZhToolUsageDao {

  private static final String SQL_INS = "INSERT INTO zh_tool_usage(tool_number_bo,tool_limit_times,tool_usage,event_datetime,sum_usage,sum_limit_times,update_user,limit_clean_day_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_tool_usage SET tool_limit_times=?,tool_usage=?,event_datetime=?,sum_usage=?,sum_limit_times=?,update_user=?,limit_clean_day_time=? WHERE tool_number_bo=?";

  private static final String SQL_SEL = "SELECT tool_number_bo,tool_limit_times,tool_usage,event_datetime,sum_usage,sum_limit_times,update_user,limit_clean_day_time FROM zh_tool_usage ";

  private final Connection conn;

  public ZhToolUsageDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZhToolUsage data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getToolNumberBo());
      ps.setBigDecimal(2, data.getToolLimitTimes());
      ps.setBigDecimal(3, data.getToolUsage());
      DateUtils.setDateTz(ps, 4, data.getEventDatetime());
      ps.setBigDecimal(5, data.getSumUsage());
      ps.setBigDecimal(6, data.getSumLimitTimes());
      ps.setString(7, data.getUpdateUser());
      ps.setBigDecimal(8, data.getLimitCleanDayTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZhToolUsage> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZhToolUsage data : dataList) {
        ps.setString(1, data.getToolNumberBo());
        ps.setBigDecimal(2, data.getToolLimitTimes());
        ps.setBigDecimal(3, data.getToolUsage());
        DateUtils.setDateTz(ps, 4, data.getEventDatetime());
        ps.setBigDecimal(5, data.getSumUsage());
        ps.setBigDecimal(6, data.getSumLimitTimes());
        ps.setString(7, data.getUpdateUser());
        ps.setBigDecimal(8, data.getLimitCleanDayTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZhToolUsage data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getToolLimitTimes());
      ps.setBigDecimal(2, data.getToolUsage());
      DateUtils.setDateTz(ps, 3, data.getEventDatetime());
      ps.setBigDecimal(4, data.getSumUsage());
      ps.setBigDecimal(5, data.getSumLimitTimes());
      ps.setString(6, data.getUpdateUser());
      ps.setBigDecimal(7, data.getLimitCleanDayTime());
      ps.setString(8, data.getToolNumberBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZhToolUsage> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZhToolUsage data : dataList) {
        ps.setBigDecimal(1, data.getToolLimitTimes());
        ps.setBigDecimal(2, data.getToolUsage());
        DateUtils.setDateTz(ps, 3, data.getEventDatetime());
        ps.setBigDecimal(4, data.getSumUsage());
        ps.setBigDecimal(5, data.getSumLimitTimes());
        ps.setString(6, data.getUpdateUser());
        ps.setBigDecimal(7, data.getLimitCleanDayTime());
        ps.setString(8, data.getToolNumberBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String toolNumberBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zh_tool_usage WHERE tool_number_bo=?")) {
      ps.setString(1, toolNumberBo);

      return ps.executeUpdate();
    }
  }

  public List<ZhToolUsage> selectAll() throws SQLException {
    ArrayList<ZhToolUsage> result = new ArrayList<ZhToolUsage>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ZhToolUsage selectByPK(String toolNumberBo) throws SQLException {
    ZhToolUsage result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE tool_number_bo=?")) {
      ps.setString(1, toolNumberBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZhToolUsage convert(ResultSet rs) throws SQLException {
    ZhToolUsage data = new ZhToolUsage();

    int index = 1;
    data.setToolNumberBo(rs.getString(index++));
    data.setToolLimitTimes(rs.getBigDecimal(index++));
    data.setToolUsage(rs.getBigDecimal(index++));
    data.setEventDatetime(DateUtils.getDateTz(rs, index++));
    data.setSumUsage(rs.getBigDecimal(index++));
    data.setSumLimitTimes(rs.getBigDecimal(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setLimitCleanDayTime(rs.getBigDecimal(index++));

    return data;
  }
}
