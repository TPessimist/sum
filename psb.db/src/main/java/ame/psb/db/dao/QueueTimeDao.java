package ame.psb.db.dao;

import ame.psb.db.QueueTime;
import ame.psb.db.ViewQueueTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class QueueTimeDao {

  private static final String SQL_INS = "INSERT INTO zd_queue_time (id,item_group_bo,item_bo,begin_operation_bo,begin_type,end_operation_bo,end_type,min_time,max_time,package_bo,status,updated_user,updated_time) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_queue_time SET min_time=?,max_time=?,status=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,item_group_bo,item_bo,begin_operation_bo,begin_type,end_operation_bo,end_type,min_time,max_time,package_bo,status,updated_user,updated_time,item_group_name,item_name,begin_operation,end_operation,package_name,customer_bo,customer_name FROM view_queue_time ";

  private Connection conn;

  public QueueTimeDao(Connection conn) {
    this.conn = conn;
  }

  public int isnert(QueueTime queueTime) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, queueTime.getId());
      ps.setString(2, queueTime.getItemGroupBo());
      ps.setString(3, queueTime.getItemBo());
      ps.setString(4, queueTime.getBeginOperationBo());
      ps.setString(5, queueTime.getBeginType());
      ps.setString(6, queueTime.getEndOperationBo());
      ps.setString(7, queueTime.getEndType());
      if (queueTime.getMinTime() != null && queueTime.getMinTime() > 0) {
        ps.setInt(8, queueTime.getMinTime());
      } else {
        ps.setNull(8, Types.INTEGER);
      }
      if (queueTime.getMaxTime() != null && queueTime.getMaxTime() > 0) {
        ps.setInt(9, queueTime.getMaxTime());
      } else {
        ps.setNull(9, Types.INTEGER);
      }
      ps.setString(10, queueTime.getPackageBo());
      ps.setString(11, queueTime.getStatus());
      ps.setString(12, queueTime.getUpdatedUser());
      DateUtils.setDateTz(ps, 13, queueTime.getUpdatedTime());
      return ps.executeUpdate();
    }
  }

  public int update(String id, Integer minTime, Integer maxTime, String status, String updatedUser,
      Date updatedTime) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      if (minTime != null && minTime > 0) {
        ps.setInt(1, minTime);
      } else {
        ps.setNull(1, Types.INTEGER);
      }
      if (maxTime != null && maxTime > 0) {
        ps.setInt(2, maxTime);
      } else {
        ps.setNull(2, Types.INTEGER);
      }
      ps.setString(3, status);
      ps.setString(4, updatedUser);
      DateUtils.setDateTz(ps, 5, updatedTime);
      ps.setString(6, id);
      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_queue_time SET status='D' WHERE id=?")) {
      ps.setString(1, id);
      return ps.executeUpdate();
    }
  }

  public boolean exists(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      return rs.next();
    }
  }

  public ViewQueueTime selectByPK(String id) throws SQLException {
    ViewQueueTime items = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        items = convert(rs);
      }
    }
    return items;
  }

  public List<ViewQueueTime> selectAll() throws SQLException {
    ArrayList<ViewQueueTime> items = new ArrayList<ViewQueueTime>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE status<>'D' ORDER BY item_group_bo,item_bo,begin_operation_bo,begin_type,end_operation_bo,end_type")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(convert(rs));
      }
    }
    return items;
  }

  public List<ViewQueueTime> selectByOperation(String operationBo) throws SQLException {
    ArrayList<ViewQueueTime> items = new ArrayList<ViewQueueTime>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE status<>'D' AND begin_operation_bo=? ORDER BY item_bo,begin_operation_bo,begin_type,end_operation_bo,end_type")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(convert(rs));
      }
    }
    return items;
  }

  public List<ViewQueueTime> selectByPackage(String packageBo) throws SQLException {
    ArrayList<ViewQueueTime> items = new ArrayList<ViewQueueTime>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE status<>'D' AND package_bo=? ORDER BY item_bo,begin_operation_bo,begin_type,end_operation_bo,end_type")) {
      ps.setString(1, packageBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(convert(rs));
      }
    }
    return items;
  }

  public List<ViewQueueTime> selectByItemGroup(String itemGroupBo) throws SQLException {
    ArrayList<ViewQueueTime> items = new ArrayList<ViewQueueTime>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE status<>'D' AND item_group_bo=? ORDER BY item_bo,begin_operation_bo,begin_type,end_operation_bo,end_type")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(convert(rs));
      }
    }
    return items;
  }

  public List<ViewQueueTime> selectByItem(String itemBo) throws SQLException {
    ArrayList<ViewQueueTime> result = new ArrayList<ViewQueueTime>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE status<>'D' AND item_bo=? ORDER BY begin_operation_bo,begin_type,end_operation_bo,end_type")) {
      ps.setString(1, itemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<ViewQueueTime> selectBeginByPackage(String packageBo, String beginOperationBo,
      String beginType) throws SQLException {
    ArrayList<ViewQueueTime> items = new ArrayList<ViewQueueTime>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE status='Y' AND package_bo=? AND begin_operation_bo=? AND begin_type=? ORDER BY end_operation_bo,end_type")) {
      ps.setString(1, packageBo);
      ps.setString(2, beginOperationBo);
      ps.setString(3, beginType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(convert(rs));
      }
    }
    return items;
  }

  public List<ViewQueueTime> selectBeginByItemGroup(String itemGroupBo, String beginOperationBo,
      String beginType) throws SQLException {
    ArrayList<ViewQueueTime> items = new ArrayList<ViewQueueTime>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE status='Y' AND item_group_bo=? AND begin_operation_bo=? AND begin_type=? ORDER BY end_operation_bo,end_type")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, beginOperationBo);
      ps.setString(3, beginType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(convert(rs));
      }
    }
    return items;

  }

  public List<ViewQueueTime> selectBeginByItem(String itemBo, String beginOperationBo,
      String beginType) throws SQLException {
    ArrayList<ViewQueueTime> items = new ArrayList<ViewQueueTime>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE status='Y' AND item_bo=? AND begin_operation_bo=? AND begin_type=? ORDER BY end_operation_bo,end_type")) {
      ps.setString(1, itemBo);
      ps.setString(2, beginOperationBo);
      ps.setString(3, beginType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(convert(rs));
      }
    }
    return items;
  }

  public List<ViewQueueTime> selectBeginByOperation(String beginOperationBo, String beginType)
      throws SQLException {
    ArrayList<ViewQueueTime> items = new ArrayList<ViewQueueTime>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE status='Y' AND begin_operation_bo=? AND begin_type=? AND item_group_bo is NULL AND item_bo is NULL AND package_bo is NULL  ORDER BY end_operation_bo,end_type")) {
      ps.setString(1, beginOperationBo);
      ps.setString(2, beginType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(convert(rs));
      }
    }
    return items;
  }

  private ViewQueueTime convert(ResultSet rs) throws SQLException {
    ViewQueueTime data = new ViewQueueTime();
    data.setId(rs.getString(1));
    data.setItemGroupBo(rs.getString(2));
    data.setItemBo(rs.getString(3));
    data.setBeginOperationBo(rs.getString(4));
    data.setBeginType(rs.getString(5));
    data.setEndOperationBo(rs.getString(6));
    data.setEndType(rs.getString(7));
    data.setMinTime(rs.getObject(8) == null ? null : rs.getInt(8));
    data.setMaxTime(rs.getObject(9) == null ? null : rs.getInt(9));
    data.setPackageBo(rs.getString(10));
    data.setStatus(rs.getString(11));
    data.setUpdatedUser(rs.getString(12));
    data.setUpdatedTime(DateUtils.getDateTz(rs, 13));
    data.setItemGroupName(rs.getString(14));
    data.setItemName(rs.getString(15));
    data.setBeginOperation(rs.getString(16));
    data.setEndOperation(rs.getString(17));
    data.setPackageName(rs.getString(18));
    data.setCustomerBo(rs.getString(19));
    data.setCustomerName(rs.getString(20));

    return data;
  }

  private QueueTime convertQueueTime(ResultSet rs) throws SQLException {
    QueueTime data = new ViewQueueTime();
    data.setId(rs.getString(1));
    data.setItemGroupBo(rs.getString(2));
    data.setItemBo(rs.getString(3));
    data.setBeginOperationBo(rs.getString(4));
    data.setBeginType(rs.getString(5));
    data.setEndOperationBo(rs.getString(6));
    data.setEndType(rs.getString(7));
    data.setMinTime(rs.getObject(8) == null ? null : rs.getInt(8));
    data.setMaxTime(rs.getObject(9) == null ? null : rs.getInt(9));
    data.setPackageBo(rs.getString(10));
    data.setStatus(rs.getString(11));
    data.setUpdatedUser(rs.getString(12));
    data.setUpdatedTime(DateUtils.getDateTz(rs, 13));

    return data;
  }

  public int selectCountByItemGroupBo(String itemGroupBoTo) throws SQLException {
    String selSql = "select count(1) from zd_queue_time where item_group_bo = ?";
    int count = 0;
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, itemGroupBoTo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        count = rs.getInt(1);
      }
    }
    return count;
  }

  public List<QueueTime> selectByItemGroupBo(String itemGroupBoFrom) throws SQLException {
    String selSql = "select id,item_group_bo,item_bo,begin_operation_bo,begin_type,end_operation_bo,end_type,min_time,max_time,package_bo,status,updated_user,updated_time from zd_queue_time where item_group_bo = ?";
    List<QueueTime> list = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, itemGroupBoFrom);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(this.convertQueueTime(rs));
      }
    }
    return list;

  }

  public void insertBatch(List<QueueTime> list) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (QueueTime queueTime : list) {
        ps.setString(1, queueTime.getId());
        ps.setString(2, queueTime.getItemGroupBo());
        ps.setString(3, queueTime.getItemBo());
        ps.setString(4, queueTime.getBeginOperationBo());
        ps.setString(5, queueTime.getBeginType());
        ps.setString(6, queueTime.getEndOperationBo());
        ps.setString(7, queueTime.getEndType());
        if (queueTime.getMinTime() != null && queueTime.getMinTime() > 0) {
          ps.setInt(8, queueTime.getMinTime());
        } else {
          ps.setNull(8, Types.INTEGER);
        }
        if (queueTime.getMaxTime() != null && queueTime.getMaxTime() > 0) {
          ps.setInt(9, queueTime.getMaxTime());
        } else {
          ps.setNull(9, Types.INTEGER);
        }
        ps.setString(10, queueTime.getPackageBo());
        ps.setString(11, queueTime.getStatus());
        ps.setString(12, queueTime.getUpdatedUser());
        DateUtils.setDateTz(ps, 13, queueTime.getUpdatedTime());
        ps.addBatch();
      }
      ps.executeBatch();
    }
  }
}
