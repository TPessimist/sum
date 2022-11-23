package ame.psb.db.dao;

import ame.psb.db.SamplingPlan;
import ame.psb.db.ViewSamplingPlan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class SamplingPlanDao {

  private static final String SQL_INS = "INSERT INTO zd_sampling_plan(id,customer_bo,item_group_bo,item_bo,lot_type,measurement_operation_bo,sampling_ratio_nmrtr,reset_cardinality,sampling_type,begin_qty,center_qty,end_qty,position,interval_qty,dc_group_bo,updated_user,updated_time,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_sampling_plan SET customer_bo=?,item_group_bo=?,item_bo=?,lot_type=?,measurement_operation_bo=?,sampling_ratio_nmrtr=?,reset_cardinality=?,sampling_type=?,begin_qty=?,center_qty=?,end_qty=?,position=?,interval_qty=?,dc_group_bo=?,updated_user=?,updated_time=?,status=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,customer_bo,item_group_bo,item_bo,lot_type,measurement_operation_bo,sampling_ratio_nmrtr,reset_cardinality,sampling_type,begin_qty,center_qty,end_qty,position,interval_qty,dc_group_bo,reset_total,updated_user,updated_time, measurement_operation, customer_name, item_name, device_name, dc_group, status FROM view_sampling_plan ";

  private final Connection conn;

  public SamplingPlanDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SamplingPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getCustomerBo());
      ps.setString(3, data.getItemGroupBo());
      ps.setString(4, data.getItemBo());
      ps.setString(5, data.getLotType());
      ps.setString(6, data.getMeasurementOperationBo());
      if (data.getSamplingRatioNmrtr() != null && data.getSamplingRatioNmrtr() > 0) {
        ps.setInt(7, data.getSamplingRatioNmrtr());
      } else {
        ps.setNull(7, Types.INTEGER);
      }
      if (data.getResetCardinality() != null && data.getResetCardinality() > 0) {
        ps.setInt(8, data.getResetCardinality());
      } else {
        ps.setNull(8, Types.INTEGER);
      }
      ps.setString(9, data.getSamplingType());
      if (data.getBeginQty() != null && data.getBeginQty() > 0) {
        ps.setInt(10, data.getBeginQty());
      } else {
        ps.setNull(10, Types.INTEGER);
      }
      if (data.getCenterQty() != null && data.getCenterQty() > 0) {
        ps.setInt(11, data.getCenterQty());
      } else {
        ps.setNull(11, Types.INTEGER);
      }
      if (data.getEndQty() != null && data.getEndQty() > 0) {
        ps.setInt(12, data.getEndQty());
      } else {
        ps.setNull(12, Types.INTEGER);
      }
      ps.setString(13, data.getPosition());
      if (data.getIntervalQty() != null && data.getIntervalQty() > 0) {
        ps.setInt(14, data.getIntervalQty());
      } else {
        ps.setNull(14, Types.INTEGER);
      }
      ps.setString(15, data.getDcGroupBo());
      ps.setString(16, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 17, data.getUpdatedTime());
      ps.setString(18, data.getStatus());
      return ps.executeUpdate();
    }
  }

  public int insert(List<SamplingPlan> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SamplingPlan data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getCustomerBo());
        ps.setString(3, data.getItemGroupBo());
        ps.setString(4, data.getItemBo());
        ps.setString(5, data.getLotType());
        ps.setString(6, data.getMeasurementOperationBo());
        if (data.getSamplingRatioNmrtr() != null && data.getSamplingRatioNmrtr() > 0) {
          ps.setInt(7, data.getSamplingRatioNmrtr());
        } else {
          ps.setNull(7, Types.INTEGER);
        }
        if (data.getResetCardinality() != null && data.getResetCardinality() > 0) {
          ps.setInt(8, data.getResetCardinality());
        } else {
          ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, data.getSamplingType());
        if (data.getBeginQty() != null && data.getBeginQty() > 0) {
          ps.setInt(10, data.getBeginQty());
        } else {
          ps.setNull(10, Types.INTEGER);
        }
        if (data.getCenterQty() != null && data.getCenterQty() > 0) {
          ps.setInt(11, data.getCenterQty());
        } else {
          ps.setNull(11, Types.INTEGER);
        }
        if (data.getEndQty() != null && data.getEndQty() > 0) {
          ps.setInt(12, data.getEndQty());
        } else {
          ps.setNull(12, Types.INTEGER);
        }
        ps.setString(13, data.getPosition());
        if (data.getIntervalQty() != null && data.getIntervalQty() > 0) {
          ps.setInt(14, data.getIntervalQty());
        } else {
          ps.setNull(14, Types.INTEGER);
        }
        ps.setString(15, data.getDcGroupBo());
        ps.setString(16, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 17, data.getUpdatedTime());
        ps.setString(18, data.getStatus());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SamplingPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomerBo());
      ps.setString(2, data.getItemGroupBo());
      ps.setString(3, data.getItemBo());
      ps.setString(4, data.getLotType());
      ps.setString(5, data.getMeasurementOperationBo());
      if (data.getSamplingRatioNmrtr() != null && data.getSamplingRatioNmrtr() > 0) {
        ps.setInt(6, data.getSamplingRatioNmrtr());
      } else {
        ps.setNull(6, Types.INTEGER);
      }
      if (data.getResetCardinality() != null && data.getResetCardinality() > 0) {
        ps.setInt(7, data.getResetCardinality());
      } else {
        ps.setNull(7, Types.INTEGER);
      }
      ps.setString(8, data.getSamplingType());
      if (data.getBeginQty() != null && data.getBeginQty() > 0) {
        ps.setInt(9, data.getBeginQty());
      } else {
        ps.setNull(9, Types.INTEGER);
      }
      if (data.getCenterQty() != null && data.getCenterQty() > 0) {
        ps.setInt(10, data.getCenterQty());
      } else {
        ps.setNull(10, Types.INTEGER);
      }
      if (data.getEndQty() != null && data.getEndQty() > 0) {
        ps.setInt(11, data.getEndQty());
      } else {
        ps.setNull(11, Types.INTEGER);
      }
      ps.setString(12, data.getPosition());
      if (data.getIntervalQty() != null && data.getIntervalQty() > 0) {
        ps.setInt(13, data.getIntervalQty());
      } else {
        ps.setNull(13, Types.INTEGER);
      }
      ps.setString(14, data.getDcGroupBo());
      ps.setString(15, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 16, data.getUpdatedTime());
      ps.setString(17, data.getStatus());
      ps.setString(18, data.getId());
      return ps.executeUpdate();
    }
  }

  public int update(List<SamplingPlan> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SamplingPlan data : dataList) {
        ps.setString(1, data.getCustomerBo());
        ps.setString(2, data.getItemGroupBo());
        ps.setString(3, data.getItemBo());
        ps.setString(4, data.getLotType());
        ps.setString(5, data.getMeasurementOperationBo());
        if (data.getSamplingRatioNmrtr() != null && data.getSamplingRatioNmrtr() > 0) {
          ps.setInt(6, data.getSamplingRatioNmrtr());
        } else {
          ps.setNull(6, Types.INTEGER);
        }
        if (data.getResetCardinality() != null && data.getResetCardinality() > 0) {
          ps.setInt(7, data.getResetCardinality());
        } else {
          ps.setNull(7, Types.INTEGER);
        }
        ps.setString(8, data.getSamplingType());
        if (data.getBeginQty() != null && data.getBeginQty() > 0) {
          ps.setInt(9, data.getBeginQty());
        } else {
          ps.setNull(9, Types.INTEGER);
        }
        if (data.getCenterQty() != null && data.getCenterQty() > 0) {
          ps.setInt(10, data.getCenterQty());
        } else {
          ps.setNull(10, Types.INTEGER);
        }
        if (data.getEndQty() != null && data.getEndQty() > 0) {
          ps.setInt(11, data.getEndQty());
        } else {
          ps.setNull(11, Types.INTEGER);
        }
        ps.setString(12, data.getPosition());
        if (data.getIntervalQty() != null && data.getIntervalQty() > 0) {
          ps.setInt(13, data.getIntervalQty());
        } else {
          ps.setNull(13, Types.INTEGER);
        }
        ps.setString(14, data.getDcGroupBo());
        ps.setString(15, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 16, data.getUpdatedTime());
        ps.setString(17, data.getStatus());
        ps.setString(18, data.getId());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateResetCount(String id, int resetCount) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_sampling_plan SET reset_total=?,updated_time=? WHERE id=?")) {
      ps.setInt(1, resetCount);
      DateUtils.setDateTz(ps, 2, new Date());
      ps.setString(3, id);
      return ps.executeUpdate();
    }
  }

    /*public int delete(String id) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_sampling_plan WHERE id=?")) {
            ps.setString(1, id);

            return ps.executeUpdate();
        }
    }*/

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_sampling_plan SET status='D' WHERE id=?")) {
      ps.setString(1, id);
      return ps.executeUpdate();
    }
  }

  @Deprecated
  public List<SamplingPlan> selectAll() throws SQLException {
    ArrayList<SamplingPlan> result = new ArrayList<SamplingPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE status<>'D'")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewSamplingPlan selectByPK(String id) throws SQLException {
    ViewSamplingPlan result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id=? AND status<>'D'")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewSamplingPlan selectAllStatusByPK(String id) throws SQLException {
    ViewSamplingPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewSamplingPlan selectBymultiKey(String lotType, String operationBo, String customerBo,
      String deviceBo, String itemBo, String dcGroupBo) throws SQLException {
    ViewSamplingPlan result = null;
    String sql = SQL_SEL
        + "WHERE status <> 'D' AND lot_type = ? AND measurement_operation_bo=? AND dc_group_bo=?";
    if (customerBo != null && !"".equals(customerBo)) {
      sql += " AND customer_bo=?";
    } else {
      sql += " AND customer_bo IS NULL";
    }
    if (deviceBo != null && !"".equals(deviceBo)) {
      sql += " AND item_group_bo=?";
    } else {
      sql += " AND item_group_bo IS NULL";
    }
    if (itemBo != null && !"".equals(itemBo)) {
      sql += " AND item_bo=?";
    } else {
      sql += " AND item_bo IS NULL";
    }

    try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
      int index = 1;
      ps.setString(index++, lotType);
      ps.setString(index++, operationBo);
      ps.setString(index++, dcGroupBo);

      if (customerBo != null && !"".equals(customerBo)) {
        ps.setString(index++, customerBo);
      }
      if (deviceBo != null && !"".equals(deviceBo)) {
        ps.setString(index++, deviceBo);
      }
      if (itemBo != null && !"".equals(itemBo)) {
        ps.setString(index++, itemBo);
      }

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewSamplingPlan> select(Where where) throws SQLException {
    ArrayList<ViewSamplingPlan> result = new ArrayList<ViewSamplingPlan>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<SamplingPlan> select(String itemGroupBo, String customerBo) throws SQLException {
    ArrayList<SamplingPlan> result = new ArrayList<>();
    String selSql = "select * from zd_sampling_plan where item_group_bo = ? and customer_bo = ?";
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, customerBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        SamplingPlan data = new SamplingPlan();
        data.setId(rs.getString("id"));
        data.setCustomerBo(rs.getString("customer_bo"));
        data.setItemGroupBo(rs.getString("item_group_bo"));
        data.setItemBo(rs.getString("item_bo"));
        data.setLotType(rs.getString("lot_type"));
        data.setMeasurementOperationBo(rs.getString("measurement_operation_bo"));
        data.setSamplingRatioNmrtr(rs.getInt("sampling_ratio_nmrtr"));
        data.setResetCardinality(rs.getInt("reset_cardinality"));
        data.setSamplingType(rs.getString("sampling_type"));
        data.setBeginQty(rs.getInt("begin_qty"));
        data.setCenterQty(rs.getInt("center_qty"));
        data.setEndQty(rs.getInt("end_qty"));
        data.setPosition(rs.getString("position"));
        data.setIntervalQty(rs.getInt("interval_qty"));
        data.setDcGroupBo(rs.getString("dc_group_bo"));
        data.setStatus(rs.getString("status"));
        data.setResetTotal(rs.getInt("reset_total"));
        data.setUpdatedUser(rs.getString("updated_user"));
        data.setUpdatedTime(rs.getDate("updated_time"));
        result.add(data);
      }
      return result;
    }
  }


  public List<SamplingPlan> selectByItemGroupBo(String itemGroupBo) throws SQLException {
    ArrayList<SamplingPlan> result = new ArrayList<>();
    String selSql = "select * from zd_sampling_plan where item_group_bo = ? ";
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        SamplingPlan data = new SamplingPlan();
        data.setId(rs.getString("id"));
        data.setCustomerBo(rs.getString("customer_bo"));
        data.setItemGroupBo(rs.getString("item_group_bo"));
        data.setItemBo(rs.getString("item_bo"));
        data.setLotType(rs.getString("lot_type"));
        data.setMeasurementOperationBo(rs.getString("measurement_operation_bo"));
        data.setSamplingRatioNmrtr(rs.getInt("sampling_ratio_nmrtr"));
        data.setResetCardinality(rs.getInt("reset_cardinality"));
        data.setSamplingType(rs.getString("sampling_type"));
        data.setBeginQty(rs.getInt("begin_qty"));
        data.setCenterQty(rs.getInt("center_qty"));
        data.setEndQty(rs.getInt("end_qty"));
        data.setPosition(rs.getString("position"));
        data.setIntervalQty(rs.getInt("interval_qty"));
        data.setDcGroupBo(rs.getString("dc_group_bo"));
        data.setStatus(rs.getString("status"));
        data.setResetTotal(rs.getInt("reset_total"));
        data.setUpdatedUser(rs.getString("updated_user"));
        data.setUpdatedTime(rs.getDate("updated_time"));
        result.add(data);
      }
      return result;
    }
  }

  public List<ViewSamplingPlan> select(String lotType, String operationBo, String customer)
      throws SQLException {
    ArrayList<ViewSamplingPlan> result = new ArrayList<ViewSamplingPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE lot_type = ? AND measurement_operation_bo=? AND (customer_name=? or customer_name is null) and status = 'Y'")) {
      ps.setString(1, lotType);
      ps.setString(2, operationBo);
      ps.setString(3, customer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSamplingPlan> selectByItemGroupAndOperationBo(String itemGroupBo,
      String operationBo) throws SQLException {
    ArrayList<ViewSamplingPlan> result = new ArrayList<ViewSamplingPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE ITEM_GROUP_BO = ? AND MEASUREMENT_OPERATION_BO = ? AND CUSTOMER_BO IS NULL AND ITEM_BO IS NULL  and STATUS = 'Y'")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSamplingPlan> selectByItemGroupAndOperationBoAndDcGroupBo(String itemGroupBo,
      String operationBo, String dcGroupBo) throws SQLException {
    ArrayList<ViewSamplingPlan> result = new ArrayList<ViewSamplingPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE ITEM_GROUP_BO = ? AND MEASUREMENT_OPERATION_BO = ?  and DC_GROUP_BO =? AND CUSTOMER_BO IS NULL AND ITEM_BO IS NULL  and STATUS = 'Y'")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, dcGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSamplingPlan> selectByItemGroupAndOperationBo1(String itemGroupBo,
      String operationBo) throws SQLException {
    ArrayList<ViewSamplingPlan> result = new ArrayList<ViewSamplingPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE ITEM_GROUP_BO = ? AND MEASUREMENT_OPERATION_BO = ? AND CUSTOMER_BO IS NULL AND ITEM_BO IS NULL  and STATUS = 'Y'")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSamplingPlan> select(String lotType, String operationBo, String customer,
      String deviceBo, String itemBo) throws SQLException {
    ArrayList<ViewSamplingPlan> result = new ArrayList<ViewSamplingPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE lot_type = ? AND measurement_operation_bo=? AND (customer_name=? or customer_name is null) AND (item_group_bo=? or item_group_bo is null) AND (item_bo=? or item_bo is null) and status = 'Y'")) {
      ps.setString(1, lotType);
      ps.setString(2, operationBo);
      ps.setString(3, customer);
      ps.setString(4, deviceBo);
      ps.setString(5, itemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewSamplingPlan convert(ResultSet rs) throws SQLException {
    ViewSamplingPlan data = new ViewSamplingPlan();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setCustomerBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setLotType(rs.getString(index++));
    data.setMeasurementOperationBo(rs.getString(index++));
    data.setSamplingRatioNmrtr(rs.getInt(index++));
    data.setResetCardinality(rs.getInt(index++));
    data.setSamplingType(rs.getString(index++));
    data.setBeginQty(rs.getInt(index++));
    data.setCenterQty(rs.getInt(index++));
    data.setEndQty(rs.getInt(index++));
    data.setPosition(rs.getString(index++));
    data.setIntervalQty(rs.getInt(index++));
    data.setDcGroupBo(rs.getString(index++));
    data.setResetTotal(rs.getInt(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setMeasurementOperation(rs.getString(index++));
    data.setCustomerName(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setDcGroup(rs.getString(index++));
    data.setStatus(rs.getString(index++));
    return data;
  }

  public int selectByItemGroupBoAndCustomerBo(String deviceToBo, String customerToBo)
      throws SQLException {
    String selSql = "select count(1) from zd_sampling_plan where customer_bo = ? and item_group_bo = ?";
    int count = 0;
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, customerToBo);
      ps.setString(2, deviceToBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        count = rs.getInt(1);
      }
      return count;
    }
  }
}
