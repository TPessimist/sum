package ame.psb.db.dao;

import ame.psb.db.RunOaWoChange;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunOaWoChangeDao {

  private static final String SQL_INS = "INSERT INTO zr_run_oa_wo_change(oa_id,customer_name,shop_order,wafer_id,action_name,operation_bo,label_position,before_content,after_content,updated_user,updated_time,state_name) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_run_oa_wo_change SET operation_bo=?,label_position=?,before_content=?,after_content=?,updated_user=?,updated_time=?,state_name=? WHERE oa_id=? AND customer_name=? AND shop_order=? AND wafer_id=? AND action_name=?";

  private static final String SQL_SEL = "SELECT oa_id,customer_name,shop_order,wafer_id,action_name,operation_bo,label_position,before_content,after_content,updated_user,updated_time,state_name FROM zr_run_oa_wo_change ";

  private final Connection conn;

  public RunOaWoChangeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunOaWoChange data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getOaId());
      ps.setString(2, data.getCustomerName());
      ps.setString(3, data.getShopOrder());
      ps.setString(4, data.getWaferId());
      ps.setString(5, data.getActionName());
      ps.setString(6, data.getOperationBo());
      ps.setString(7, data.getLabelPosition());
      ps.setString(8, data.getBeforeContent());
      ps.setString(9, data.getAfterContent());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
      ps.setString(12, data.getStateName());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunOaWoChange> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunOaWoChange data : dataList) {
        ps.setString(1, data.getOaId());
        ps.setString(2, data.getCustomerName());
        ps.setString(3, data.getShopOrder());
        ps.setString(4, data.getWaferId());
        ps.setString(5, data.getActionName());
        ps.setString(6, data.getOperationBo());
        ps.setString(7, data.getLabelPosition());
        ps.setString(8, data.getBeforeContent());
        ps.setString(9, data.getAfterContent());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
        ps.setString(12, data.getStateName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunOaWoChange data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getOperationBo());
      ps.setString(2, data.getLabelPosition());
      ps.setString(3, data.getBeforeContent());
      ps.setString(4, data.getAfterContent());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getStateName());
      ps.setString(8, data.getOaId());
      ps.setString(9, data.getCustomerName());
      ps.setString(10, data.getShopOrder());
      ps.setString(11, data.getWaferId());
      ps.setString(12, data.getActionName());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunOaWoChange> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunOaWoChange data : dataList) {
        ps.setString(1, data.getOperationBo());
        ps.setString(2, data.getLabelPosition());
        ps.setString(3, data.getBeforeContent());
        ps.setString(4, data.getAfterContent());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getStateName());
        ps.setString(8, data.getOaId());
        ps.setString(9, data.getCustomerName());
        ps.setString(10, data.getShopOrder());
        ps.setString(11, data.getWaferId());
        ps.setString(12, data.getActionName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String oaId, String customerName, String shopOrder, String waferId,
      String actionName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_run_oa_wo_change WHERE oa_id=? AND customer_name=? AND shop_order=? AND wafer_id=? AND action_name=?")) {
      ps.setString(1, oaId);
      ps.setString(2, customerName);
      ps.setString(3, shopOrder);
      ps.setString(4, waferId);
      ps.setString(5, actionName);

      return ps.executeUpdate();
    }
  }

  public List<RunOaWoChange> selectAll() throws SQLException {
    ArrayList<RunOaWoChange> result = new ArrayList<RunOaWoChange>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public RunOaWoChange selectByPK(String oaId, String customerName, String shopOrder,
      String waferId, String actionName) throws SQLException {
    RunOaWoChange result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE oa_id=? AND customer_name=? AND shop_order=? AND wafer_id=? AND action_name=?")) {
      ps.setString(1, oaId);
      ps.setString(2, customerName);
      ps.setString(3, shopOrder);
      ps.setString(4, waferId);
      ps.setString(5, actionName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<RunOaWoChange> queryRunOaWoChangeRecordByShopOrderAndStateName(String shopOrder)
      throws SQLException {
    ArrayList<RunOaWoChange> result = new ArrayList<>();

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE  shop_order = ? AND state_name = 'PROCESSING' ")) {
      ps.setString(1, shopOrder);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public RunOaWoChange queryRunOaWoChangeRecordByWaferId(String shopOrder, String waferId,
      String actionName) throws SQLException {
    RunOaWoChange result = null;

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE shop_order = ? AND wafer_id = ? AND action_name = ? order by updated_time desc")) {
      ps.setString(1, shopOrder);
      ps.setString(2, waferId);
      ps.setString(3, actionName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private RunOaWoChange convert(ResultSet rs) throws SQLException {
    RunOaWoChange data = new RunOaWoChange();

    int index = 1;
    data.setOaId(rs.getString(index++));
    data.setCustomerName(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setWaferId(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setLabelPosition(rs.getString(index++));
    data.setBeforeContent(rs.getString(index++));
    data.setAfterContent(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setStateName(rs.getString(index++));

    return data;
  }
}
