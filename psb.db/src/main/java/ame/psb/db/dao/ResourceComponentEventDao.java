package ame.psb.db.dao;

import ame.psb.db.ResourceComponentEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ResourceComponentEventDao {

  private static final String SQL_INS = "INSERT INTO zr_resource_component_event(id,resource_bo,component_id,event_name,event_message,event_time,event_user,wafer_id,sfc) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_resource_component_event SET resource_bo=?,component_id=?,event_name=?,event_message=?,event_time=?,event_user=?,wafer_id=?,sfc=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resource_bo,component_id,event_name,event_message,event_time,event_user,wafer_id,sfc FROM zr_resource_component_event ";

  private final Connection conn;

  public ResourceComponentEventDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ResourceComponentEvent data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getComponentId());
      ps.setString(4, data.getEventName());
      ps.setString(5, data.getEventMessage());
      DateUtils.setDateTz(ps, 6, data.getEventTime());
      ps.setString(7, data.getEventUser());
      ps.setString(8, data.getWaferId());
      ps.setString(9, data.getSfc());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ResourceComponentEvent> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ResourceComponentEvent data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getComponentId());
        ps.setString(4, data.getEventName());
        ps.setString(5, data.getEventMessage());
        DateUtils.setDateTz(ps, 6, data.getEventTime());
        ps.setString(7, data.getEventUser());
        ps.setString(8, data.getWaferId());
        ps.setString(9, data.getSfc());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ResourceComponentEvent data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getComponentId());
      ps.setString(3, data.getEventName());
      ps.setString(4, data.getEventMessage());
      DateUtils.setDateTz(ps, 5, data.getEventTime());
      ps.setString(6, data.getEventUser());
      ps.setString(7, data.getWaferId());
      ps.setString(8, data.getSfc());
      ps.setString(9, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ResourceComponentEvent> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ResourceComponentEvent data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getComponentId());
        ps.setString(3, data.getEventName());
        ps.setString(4, data.getEventMessage());
        DateUtils.setDateTz(ps, 5, data.getEventTime());
        ps.setString(6, data.getEventUser());
        ps.setString(7, data.getWaferId());
        ps.setString(8, data.getSfc());
        ps.setString(9, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_resource_component_event WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ResourceComponentEvent> selectAll() throws SQLException {
    ArrayList<ResourceComponentEvent> result = new ArrayList<ResourceComponentEvent>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public ResourceComponentEvent selectByPK(String id) throws SQLException {
    ResourceComponentEvent result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private ResourceComponentEvent convert(ResultSet rs) throws SQLException {
    ResourceComponentEvent data = new ResourceComponentEvent();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setComponentId(rs.getString(index++));
    data.setEventName(rs.getString(index++));
    data.setEventMessage(rs.getString(index++));
    data.setEventTime(DateUtils.getDateTz(rs, index++));
    data.setEventUser(rs.getString(index++));
    data.setWaferId(rs.getString(index++));
    data.setSfc(rs.getString(index++));

    return data;
  }
}
