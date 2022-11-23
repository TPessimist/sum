package ame.psb.db.dao;

import ame.psb.db.RouteEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RouteEventDao {

  private static final String SQL_INS = "INSERT INTO zr_route_event(id,event_time,event_owner,event_name,shop_order_bo,sfc_bo,customer_itemset_bo,customer_item_bo,state_name,carrier_bo,customer_bo,resource_bo,operation_bo,run_user,container_bo,hold_id,comment) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_SEL = "SELECT id,event_time,event_owner,event_name,shop_order_bo,sfc_bo,customer_itemset_bo,customer_item_bo,state_name,carrier_bo,customer_bo,operation_bo,run_user,container_bo,resource_bo,hold_id,comment FROM zr_route_event ";

  private static final String SQL_UPD = "UPDATE zr_route_event SET event_time=?,event_owner=?,event_name=?,shop_order_bo=?,sfc_bo=?,customer_itemset_bo=?,customer_item_bo=?,state_name=?,carrier_bo=?,customer_bo=?,resource_bo=?,operation_bo=?,run_user=?,container_bo=?,hold_id=?,comment=? WHERE id=?";

  private Connection conn;

  public RouteEventDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RouteEvent evt) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, evt.getId());
      DateUtils.setDateTz(ps, 2, evt.getEventTime());
      ps.setString(3, evt.getEventOwner());
      ps.setString(4, evt.getEventName());
      ps.setString(5, evt.getShopOrderBo());
      ps.setString(6, evt.getSfcBo());
      ps.setString(7, evt.getCustomerItemLotBo());
      ps.setString(8, evt.getCustomerItemBo());
      ps.setString(9, evt.getStateName());
      ps.setString(10, evt.getCarrierBo());
      ps.setString(11, evt.getCustomerBo());
      ps.setString(12, evt.getResourceBo());
      ps.setString(13, evt.getOperationBo());
      ps.setString(14, evt.getRunUser());
      ps.setString(15, evt.getContainerBo());
      ps.setBigDecimal(16, evt.getHoldId());
      ps.setString(17, evt.getComment());
      return ps.executeUpdate();
    }
  }

  public int insert(List<RouteEvent> events) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RouteEvent evt : events) {
        ps.setString(1, evt.getId());
        DateUtils.setDateTz(ps, 2, evt.getEventTime());
        ps.setString(3, evt.getEventOwner());
        ps.setString(4, evt.getEventName());
        ps.setString(5, evt.getShopOrderBo());
        ps.setString(6, evt.getSfcBo());
        ps.setString(7, evt.getCustomerItemLotBo());
        ps.setString(8, evt.getCustomerItemBo());
        ps.setString(9, evt.getStateName());
        ps.setString(10, evt.getCarrierBo());
        ps.setString(11, evt.getCustomerBo());
        ps.setString(12, evt.getResourceBo());
        ps.setString(13, evt.getOperationBo());
        ps.setString(14, evt.getRunUser());
        ps.setString(15, evt.getContainerBo());
        ps.setBigDecimal(16, evt.getHoldId());
        ps.setString(17, evt.getComment());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(List<RouteEvent> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RouteEvent data : dataList) {
        DateUtils.setDateTz(ps, 1, data.getEventTime());
        ps.setString(2, data.getEventOwner());
        ps.setString(3, data.getEventName());
        ps.setString(4, data.getShopOrderBo());
        ps.setString(5, data.getSfcBo());
        ps.setString(6, data.getCustomerItemLotBo());
        ps.setString(7, data.getCustomerItemBo());
        ps.setString(8, data.getStateName());
        ps.setString(9, data.getCarrierBo());
        ps.setString(10, data.getCustomerBo());
        ps.setString(11, data.getResourceBo());
        ps.setString(12, data.getOperationBo());
        ps.setString(13, data.getRunUser());
        ps.setString(14, data.getContainerBo());
        ps.setBigDecimal(15, data.getHoldId());
        ps.setString(16, data.getComment());
        ps.setString(17, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public List<RouteEvent> selectAll() throws SQLException {
    ArrayList<RouteEvent> result = new ArrayList<RouteEvent>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public RouteEvent selectByPK(String id) throws SQLException {
    RouteEvent result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public RouteEvent selectByHoldId(String holdId, String state) throws SQLException {
    RouteEvent result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE hold_Id=? AND event_name=? AND event_owner='SFC'")) {
      ps.setString(1, holdId);
      ps.setString(2, state);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public RouteEvent selectSfcLastEvent(String sfcBo, String eventName, String operationBo)
      throws SQLException {
    RouteEvent result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE sfc_bo=? AND event_name=? AND operation_bo=? AND event_owner='SFC' order by event_time desc")) {
      ps.setString(1, sfcBo);
      ps.setString(2, eventName);
      ps.setString(3, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<RouteEvent> selectByEventName(String sfcBo, String state) throws SQLException {
    List<RouteEvent> result = new ArrayList<RouteEvent>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE sfc_bo=? AND event_name=? AND event_owner='SFC'")) {
      ps.setString(1, sfcBo);
      ps.setString(2, state);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<RouteEvent> selectCount(String sfcBo, String holdId, String state)
      throws SQLException {
    List<RouteEvent> result = new ArrayList<RouteEvent>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE sfc_bo =? AND hold_id = ? AND event_owner='SFC_ITEM' AND event_name=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, holdId);
      ps.setString(3, state);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<RouteEvent> selectLast(String sfcBo, String state, int qty) throws SQLException {
    List<RouteEvent> result = new ArrayList<RouteEvent>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        "select top? * from zr_route_event WHERE sfc_bo =? AND event_name=? AND hold_id is null order by event_time desc ")) {
      ps.setInt(1, qty);
      ps.setString(2, sfcBo);
      ps.setString(3, state);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<RouteEvent> selectLastByWafer(String operation, String wafer) throws SQLException {
    List<RouteEvent> result = new ArrayList<RouteEvent>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE operation_bo =? AND customer_item_bo=?  order by event_time desc ")) {
      ps.setString(1, operation);
      ps.setString(2, wafer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<RouteEvent> selectByWaferEvent(String operation, String wafer, String eventName)
      throws SQLException {
    List<RouteEvent> result = new ArrayList<RouteEvent>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE operation_bo =? AND customer_item_bo=? and event_name =? order by event_time desc ")) {
      ps.setString(1, operation);
      ps.setString(2, wafer);
      ps.setString(3, eventName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<RouteEvent> selectByLotEvent(String lot, String eventName) throws SQLException {
    List<RouteEvent> result = new ArrayList<RouteEvent>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE customer_itemset_bo =? and event_name =? order by event_time desc ")) {
      ps.setString(1, lot);
      ps.setString(2, eventName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public Date selectEventTime(String execUser) throws SQLException {
    Date result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT max(EVENT_TIME) FROM ZR_ROUTE_EVENT WHERE RUN_USER LIKE ? OR RUN_USER LIKE ?")) {
      ps.setString(1, execUser + "%");
      ps.setString(2, "%;" + execUser + "%");

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = DateUtils.getDateTz(rs, 1);
      }
      return result;
    }
  }

  public RouteEvent selectLastHoldEventByOperation(String holdId, String operationBo)
      throws SQLException {
    RouteEvent result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE hold_id =? AND event_name ='hold' AND operation_bo=? order by event_time desc")) {
      ps.setString(1, holdId);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  private RouteEvent convert(ResultSet rs) throws SQLException {
    RouteEvent data = new RouteEvent();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setEventTime(DateUtils.getDateTz(rs, index++));
    data.setEventOwner(rs.getString(index++));
    data.setEventName(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setCustomerItemLotBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCarrierBo(rs.getString(index++));
    data.setCustomerBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setRunUser(rs.getString(index++));
    data.setContainerBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setHoldId(rs.getBigDecimal(index++));
    data.setComment(rs.getString(index++));

    return data;
  }

}
