package ame.psb.db.dao;

import ame.psb.db.ViewResourceHold;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ResourceHoldDao {

  private static final String SQL_SEL = "SELECT id,resource_bo,resource,operation_bo,operation,dcop_bo,dc_time,item_group,sfc_bo,sfc_name,updated_user,updated_time,state_name FROM View_Resource_Hold";

  private final Connection conn;

  public ResourceHoldDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewResourceHold> selectAll() throws SQLException {
    ArrayList<ViewResourceHold> result = new ArrayList<ViewResourceHold>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewResourceHold> selectByResource(String resourceBo, Date begin, Date end)
      throws SQLException {
    ArrayList<ViewResourceHold> result = new ArrayList<ViewResourceHold>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? AND updated_time BETWEEN ? AND ? ")) {
      ps.setString(1, resourceBo);
      DateUtils.setDateTz(ps, 2, begin);
      DateUtils.setDateTz(ps, 3, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewResourceHold convert(ResultSet rs) throws SQLException {
    ViewResourceHold data = new ViewResourceHold();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setResource(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setDcopBo(rs.getString(index++));
    data.setDcTime(rs.getTimestamp(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setItemGroup(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setStateName(rs.getString(index++));

    return data;
  }
}