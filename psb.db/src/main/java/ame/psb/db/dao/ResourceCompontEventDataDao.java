package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ResourceCompontEventData;
import uia.utils.dao.DateUtils;

public class ResourceCompontEventDataDao {

  private static final String SQL_INS = "INSERT INTO zr_resource_component_event_data(uuid,id,resource_bo,wafer_id,sfc,component_id,event_name,event_message,beging_time,end_time,event_time,event_user,operation_bo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_resource_component_event_data SET id=?,resource_bo=?,wafer_id=?,sfc=?,component_id=?,event_name=?,event_message=?,beging_time=?,end_time=?,event_time=?,event_user=?,operation_bo=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,id,resource_bo,wafer_id,sfc,component_id,event_name,event_message,beging_time,end_time,event_time,event_user,operation_bo FROM zr_resource_component_event_data ";

  private final Connection conn;

  public ResourceCompontEventDataDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ResourceCompontEventData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getId());
      ps.setString(3, data.getResourceBo());
      ps.setString(4, data.getWaferId());
      ps.setString(5, data.getSfc());
      ps.setString(6, data.getComponentId());
      ps.setString(7, data.getEventName());
      ps.setString(8, data.getEventMessage());
      DateUtils.setDateTz(ps, 9, data.getBegingTime());
      DateUtils.setDateTz(ps, 10, data.getEndTime());
      DateUtils.setDateTz(ps, 11, data.getEventTime());
      ps.setString(12, data.getEventUser());
      ps.setString(13, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ResourceCompontEventData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ResourceCompontEventData data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getId());
        ps.setString(3, data.getResourceBo());
        ps.setString(4, data.getWaferId());
        ps.setString(5, data.getSfc());
        ps.setString(6, data.getComponentId());
        ps.setString(7, data.getEventName());
        ps.setString(8, data.getEventMessage());
        DateUtils.setDateTz(ps, 9, data.getBegingTime());
        DateUtils.setDateTz(ps, 10, data.getEndTime());
        DateUtils.setDateTz(ps, 11, data.getEventTime());
        ps.setString(12, data.getEventUser());
        ps.setString(13, data.getOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ResourceCompontEventData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getWaferId());
      ps.setString(4, data.getSfc());
      ps.setString(5, data.getComponentId());
      ps.setString(6, data.getEventName());
      ps.setString(7, data.getEventMessage());
      DateUtils.setDateTz(ps, 8, data.getBegingTime());
      DateUtils.setDateTz(ps, 9, data.getEndTime());
      DateUtils.setDateTz(ps, 10, data.getEventTime());
      ps.setString(11, data.getEventUser());
      ps.setString(12, data.getOperationBo());
      ps.setString(13, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<ResourceCompontEventData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ResourceCompontEventData data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getWaferId());
        ps.setString(4, data.getSfc());
        ps.setString(5, data.getComponentId());
        ps.setString(6, data.getEventName());
        ps.setString(7, data.getEventMessage());
        DateUtils.setDateTz(ps, 8, data.getBegingTime());
        DateUtils.setDateTz(ps, 9, data.getEndTime());
        DateUtils.setDateTz(ps, 10, data.getEventTime());
        ps.setString(11, data.getEventUser());
        ps.setString(12, data.getOperationBo());
        ps.setString(13, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_resource_component_event_data WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<ResourceCompontEventData> selectAll() throws SQLException {
    ArrayList<ResourceCompontEventData> result = new ArrayList<ResourceCompontEventData>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ResourceCompontEventData selectByPK(String uuid) throws SQLException {
    ResourceCompontEventData result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ResourceCompontEventData selectByResourceBoAndWaferIdAndSfcName(String resourceBo,
      String waferId, String sfcName, String compOnent, String eventMessage, String operationBo)
      throws SQLException {
    ResourceCompontEventData result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE resource_bo=?and wafer_id =? and sfc = ? and COMPONENT_ID= ? and EVENT_MESSAGE = ? and OPERATION_BO = ?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, waferId);
      ps.setString(3, sfcName);
      ps.setString(4, compOnent);
      ps.setString(5, eventMessage);
      ps.setString(6, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ResourceCompontEventData convert(ResultSet rs) throws SQLException {
    ResourceCompontEventData data = new ResourceCompontEventData();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setWaferId(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setComponentId(rs.getString(index++));
    data.setEventName(rs.getString(index++));
    data.setEventMessage(rs.getString(index++));
    data.setBegingTime(DateUtils.getDateTz(rs, index++));
    data.setEndTime(DateUtils.getDateTz(rs, index++));
    data.setEventTime(DateUtils.getDateTz(rs, index++));
    data.setEventUser(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));

    return data;
  }
}
