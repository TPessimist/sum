package ame.psb.db.dao;

import ame.psb.db.ViewHoldSfcDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class HoldSfcDetailDao {

  private static final String SQL_SEL = "SELECT handle,hold_log_bo,sfc_bo,original_status_bo,hold_status_bo,released_date_time,released_by_bo,release_comments,reason_code_bo,hold_type,comments,created_date_time,modified_date_time,user_bo,txn_id,sfc_name,state_name,customer_itemset_bo,priority,dpt_no,lot_type,item_qty,shop_order_bo,item_bo,item_name,device_bo,device_name,package_bo,package_name,router_bo,router_name,sfc_qty,customer,status_bo FROM view_hold_sfc_detail ";

  private final Connection conn;

  public HoldSfcDetailDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewHoldSfcDetail> selectAll() throws SQLException {
    ArrayList<ViewHoldSfcDetail> result = new ArrayList<ViewHoldSfcDetail>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewHoldSfcDetail> selectByHoldLog(String holdLogBo) throws SQLException {
    ArrayList<ViewHoldSfcDetail> result = new ArrayList<ViewHoldSfcDetail>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE hold_log_bo=?")) {
      ps.setString(1, holdLogBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewHoldSfcDetail> selectByWaferOperation(String waferBo, String operationBo)
      throws SQLException {
    ArrayList<ViewHoldSfcDetail> result = new ArrayList<ViewHoldSfcDetail>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? AND operation_bo=?")) {
      ps.setString(1, waferBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewHoldSfcDetail> selectBySfcComments(String sfcBo, String comments)
      throws SQLException {
    ArrayList<ViewHoldSfcDetail> result = new ArrayList<ViewHoldSfcDetail>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND comments=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, comments);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewHoldSfcDetail> selectBySfc(String sfcBo)
      throws SQLException {
    ArrayList<ViewHoldSfcDetail> result = new ArrayList<ViewHoldSfcDetail>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE sfc_bo=? AND dpt_no = 'C' AND reason_code IN ('HG04','HA_FT_68_PE','HA_FT_68_QE') AND released_by_bo IS NULL ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewHoldSfcDetail convert(ResultSet rs) throws SQLException {
    ViewHoldSfcDetail data = new ViewHoldSfcDetail();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setHoldLogBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setOriginalStatusBo(rs.getString(index++));
    data.setHoldStatusBo(rs.getString(index++));
    data.setReleasedDateTime(DateUtils.getDateTz(rs, index++));
    data.setReleasedByBo(rs.getString(index++));
    data.setReleaseComments(rs.getString(index++));
    data.setReasonCodeBo(rs.getString(index++));
    data.setHoldType(rs.getString(index++));
    data.setComments(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setUserBo(rs.getString(index++));
    data.setTxnId(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCustomerItemsetBo(rs.getString(index++));
    data.setPriority(rs.getBigDecimal(index++));
    data.setDptNo(rs.getString(index++));
    data.setLotType(rs.getString(index++));
    data.setItemQty(rs.getBigDecimal(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setDeviceBo(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setPackageBo(rs.getString(index++));
    data.setPackageName(rs.getString(index++));
    data.setRouterBo(rs.getString(index++));
    data.setRouterName(rs.getString(index++));
    data.setSfcQty(rs.getBigDecimal(index++));
    data.setCustomer(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));

    return data;
  }
}
