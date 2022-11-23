package ame.me.db.dao;

import ame.me.db.ToolGroup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ToolGroupDao {

  private static final String SQL_SEL = "SELECT handle,site,tool_group,description,status_bo,track_ctl,qty,location,time_based,erp,calibration_type,calibration_period,calibration_period_type,exp_date,created_date_time,modified_date_time FROM tool_group ";

  private final Connection conn;

  public ToolGroupDao(Connection conn) {
    this.conn = conn;
  }

  public List<ToolGroup> selectAll() throws SQLException {
    ArrayList<ToolGroup> result = new ArrayList<ToolGroup>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ToolGroup selectByPK(String handle) throws SQLException {
    ToolGroup result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ToolGroup convert(ResultSet rs) throws SQLException {
    ToolGroup data = new ToolGroup();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setToolGroup(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setTrackCtl(rs.getString(index++));
    data.setQty(rs.getBigDecimal(index++));
    data.setLocation(rs.getString(index++));
    data.setTimeBased(rs.getString(index++));
    data.setErp(rs.getString(index++));
    data.setCalibrationType(rs.getString(index++));
    data.setCalibrationPeriod(rs.getBigDecimal(index++));
    data.setCalibrationPeriodType(rs.getString(index++));
    data.setExpDate(rs.getTimestamp(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}