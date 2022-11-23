package ame.psb.db.dao;

import ame.psb.db.HoldReleaseSfcItem;
import ame.psb.db.ViewHoldReleaseSfcItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class HoldReleaseSfcItemDao {

  private static final String SQL_INS = "INSERT INTO zr_hold_release_sfc_item(hold_release_bo,customer_item_bo,sfc_bo,action_name,result_carrier_bo,result_sfc_bo,result_slot_no,result_router_bo,nc_code,status,operation_bo,action_name_group) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_hold_release_sfc_item SET sfc_bo=?,action_name=?,result_carrier_bo=?,result_sfc_bo=?,result_slot_no=?,result_router_bo=?,nc_code=?,status=?,operation_bo=?,action_name_group=? WHERE hold_release_bo=? AND customer_item_bo=?";

  private static final String SQL_SEL = "SELECT hold_release_bo,customer_item_bo,sfc_bo,action_name,result_carrier_bo,result_sfc_bo,result_slot_no,result_router_bo,nc_code,status,operation_bo,action_name_group FROM zr_hold_release_sfc_item ";

  private static final String SQL_SEL_VIEW = "SELECT id,plan_name,plan_time,state_name,oa,oa_form_no,release_type,carrier_bo,hold_release_bo,customer_item_bo,sfc_bo,slot_no,action_name,result_carrier_bo,result_sfc_bo,result_slot_no,result_router_bo,nc_code,status,updated_user,item_state_name,memo,operation_bo,action_name_group FROM view_hold_release_sfc_item ";

  private final Connection conn;

  public HoldReleaseSfcItemDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(HoldReleaseSfcItem data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHoldReleaseBo());
      ps.setString(2, data.getCustomerItemBo());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getActionName());
      ps.setString(5, data.getResultCarrierBo());
      ps.setString(6, data.getResultSfcBo());
      ps.setInt(7, data.getResultSlotNo());
      ps.setString(8, data.getResultRouterBo());
      ps.setString(9, data.getNcCode());
      ps.setString(10, data.getStatus());
      ps.setString(11, data.getOperationBo());
      ps.setString(12, data.getActionNameGroup());

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_hold_release_sfc_item WHERE hold_release_bo=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int update(HoldReleaseSfcItem data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getActionName());
      ps.setString(3, data.getResultCarrierBo());
      ps.setString(4, data.getResultSfcBo());
      ps.setInt(5, data.getResultSlotNo());
      ps.setString(6, data.getResultRouterBo());
      ps.setString(7, data.getNcCode());
      ps.setString(8, data.getStatus());
      ps.setString(9, data.getOperationBo());
      ps.setString(10, data.getActionNameGroup());
      ps.setString(11, data.getHoldReleaseBo());
      ps.setString(12, data.getCustomerItemBo());

      return ps.executeUpdate();
    }
  }

  public int updateSplitResult(String resultCarrierBo, String resultSfcBo, int resultSlotNo,
      String releaseBo, String customerItemBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_hold_release_sfc_item SET RESULT_CARRIER_BO=?, RESULT_SFC_BO=?, RESULT_SLOT_NO=?, STATUS='S' WHERE HOLD_RELEASE_BO=? AND CUSTOMER_ITEM_BO=?")) {
      ps.setString(1, resultCarrierBo);
      ps.setString(2, resultSfcBo);
      ps.setInt(3, resultSlotNo);
      ps.setString(4, releaseBo);
      ps.setString(5, customerItemBo);

      return ps.executeUpdate();
    }
  }

  public int updateStatusBySfc(String status, String releaseBo, String sfcBo)
      throws SQLException {//status R/S/C -> RELEASE/SPLIT/COMPLETE
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_hold_release_sfc_item SET STATUS=? WHERE HOLD_RELEASE_BO=? AND SFC_BO=?")) {
      ps.setString(1, status);
      ps.setString(2, releaseBo);
      ps.setString(3, sfcBo);

      return ps.executeUpdate();
    }
  }

  public int updateStatus(String status, String releaseBo, String customerItemBo)
      throws SQLException {//status S/C -> SPLIT/COMPLETE
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_hold_release_sfc_item SET STATUS=? WHERE HOLD_RELEASE_BO=? AND CUSTOMER_ITEM_BO=?")) {
      ps.setString(1, status);
      ps.setString(2, releaseBo);
      ps.setString(3, customerItemBo);

      return ps.executeUpdate();
    }
  }

  public int updateStatusByAction(String status, String releaseBo, String sfcBo, String actionName)
      throws SQLException {//status S/C -> SPLIT/COMPLETE
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_hold_release_sfc_item SET STATUS=? WHERE HOLD_RELEASE_BO=? AND SFC_BO=? AND ACTION_NAME=?")) {
      ps.setString(1, status);
      ps.setString(2, releaseBo);
      ps.setString(3, sfcBo);
      ps.setString(4, actionName);

      return ps.executeUpdate();
    }
  }

  public int updateStatusByNcCode(String status, String releaseBo, String sfcBo, String ncCode)
      throws SQLException {//status S/C -> SPLIT/COMPLETE
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_hold_release_sfc_item SET STATUS=? WHERE HOLD_RELEASE_BO=? AND SFC_BO=? AND NC_CODE=?")) {
      ps.setString(1, status);
      ps.setString(2, releaseBo);
      ps.setString(3, sfcBo);
      ps.setString(4, ncCode);

      return ps.executeUpdate();
    }
  }

  public int updateRerun(String holdReleaseBo, String resultSfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_hold_release_sfc_item SET action_name = ACTION_NAME||'-1' WHERE hold_release_bo=? AND result_sfc_bo=? AND ACTION_NAME in('RERUN_HOLE','RERUN_NG','RERUN_WHOLE','RERUN') ")) {
      ps.setString(1, holdReleaseBo);
      ps.setString(2, resultSfcBo);

      return ps.executeUpdate();
    }
  }

  public List<HoldReleaseSfcItem> selectAll() throws SQLException {
    ArrayList<HoldReleaseSfcItem> result = new ArrayList<HoldReleaseSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<HoldReleaseSfcItem> select(String holdReleaseBo) throws SQLException {
    ArrayList<HoldReleaseSfcItem> result = new ArrayList<HoldReleaseSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE hold_release_bo=?")) {
      ps.setString(1, holdReleaseBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<HoldReleaseSfcItem> selectByCarrier(String carrier) throws SQLException {
    ArrayList<HoldReleaseSfcItem> result = new ArrayList<HoldReleaseSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE result_carrier_bo=?")) {
      ps.setString(1, carrier);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewHoldReleaseSfcItem> selectBy(String holdReleaseBo, String sfcBo)
      throws SQLException {
    ArrayList<ViewHoldReleaseSfcItem> result = new ArrayList<ViewHoldReleaseSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_VIEW + " WHERE hold_release_bo=? and sfc_bo=?")) {
      ps.setString(1, holdReleaseBo);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public int deleteByReleaseBo(String hold_release_bo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_hold_release_sfc_item WHERE hold_release_bo=?")) {
      ps.setString(1, hold_release_bo);

      return ps.executeUpdate();
    }
  }

  public List<ViewHoldReleaseSfcItem> selectByID(String id) throws SQLException {
    ArrayList<ViewHoldReleaseSfcItem> result = new ArrayList<ViewHoldReleaseSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_VIEW + " WHERE id=? ")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewHoldReleaseSfcItem> selectByWafers(String waferId) throws SQLException {
    ArrayList<ViewHoldReleaseSfcItem> result = new ArrayList<ViewHoldReleaseSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_VIEW
        + " WHERE CUSTOMER_ITEM_BO =?  AND ACTION_NAME = 'RERUN' AND (STATE_NAME = 'CONFIRMED' OR STATE_NAME = 'DOWN' ) ")) {
      ps.setString(1, waferId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewHoldReleaseSfcItem> selectRerunNgByCustomerItemBoAndOperationBo(
      String customerItemBo, String operationBo)
      throws SQLException {
    ArrayList<ViewHoldReleaseSfcItem> result = new ArrayList<ViewHoldReleaseSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_VIEW
        + " WHERE CUSTOMER_ITEM_BO =?  "
        + "AND OPERATION_BO =? "
        + "AND ACTION_NAME in ( 'RERUN_NG', 'RERUN_NG-1' ) "
        + "AND (STATE_NAME = 'CONFIRMED' OR STATE_NAME = 'DONE' ) ")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewHoldReleaseSfcItem> selectrRunningByCarrier(String carrierBo)
      throws SQLException {
    ArrayList<ViewHoldReleaseSfcItem> result = new ArrayList<ViewHoldReleaseSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_VIEW
        + " WHERE carrier_bo=? AND state_name IN('EDIT','SIGNING','SIGNED') ORDER BY SFC_BO, SLOT_NO")) {
      ps.setString(1, carrierBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewHoldReleaseSfcItem> selectrBySfc(String sfcBo) throws SQLException {
    ArrayList<ViewHoldReleaseSfcItem> result = new ArrayList<ViewHoldReleaseSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_VIEW + " WHERE sfc_bo=? AND state_name = 'CONFIRMED' ORDER BY plan_time DESC ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }


  public List<ViewHoldReleaseSfcItem> selectrBySfcCarrier(String sfcBo, String carrier)
      throws SQLException {
    ArrayList<ViewHoldReleaseSfcItem> result = new ArrayList<ViewHoldReleaseSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_VIEW
        + " WHERE sfc_bo=? AND result_carrier_bo=? AND state_name = 'CONFIRMED' ORDER BY plan_time DESC ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, carrier);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewHoldReleaseSfcItem> selectrDoneRerunSfc(String sfcBo, String id)
      throws SQLException {
    ArrayList<ViewHoldReleaseSfcItem> result = new ArrayList<ViewHoldReleaseSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_VIEW
        + " WHERE result_sfc_bo =? AND ACTION_NAME in('RERUN_HOLE','RERUN_NG','RERUN_WHOLE','RERUN') AND id = ? ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, id);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public ViewHoldReleaseSfcItem selectrRecentDoneSfc(String sfcBo) throws SQLException {
    ViewHoldReleaseSfcItem result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_VIEW
        + " WHERE result_sfc_bo =? AND state_name in('CONFIRMED','DONE') ORDER BY PLAN_TIME DESC LIMIT 1 ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convertView(rs);
      }
      return result;
    }
  }

  public ViewHoldReleaseSfcItem selectLastByCustomerItemBoAndOperationBo(
      String customerItemBo, String operationBo) throws SQLException {
    ViewHoldReleaseSfcItem result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_VIEW
        + " WHERE customer_item_bo =? AND operation_bo =? AND (STATE_NAME = 'CONFIRMED' OR STATE_NAME = 'DONE' ) "
        + "ORDER BY UPDATED_TIME DESC LIMIT 1 ")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convertView(rs);
      }
      return result;
    }
  }

  public List<ViewHoldReleaseSfcItem> selectrByResultSfc(String resultSfcBo, String id)
      throws SQLException {
    ArrayList<ViewHoldReleaseSfcItem> result = new ArrayList<ViewHoldReleaseSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_VIEW
            + " WHERE result_sfc_bo=? AND HOLD_RELEASE_BO = ? ORDER BY SFC_BO, SLOT_NO")) {
      ps.setString(1, resultSfcBo);
      ps.setString(2, id);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewHoldReleaseSfcItem> selectrByResultCarrier(String resultCarrierBo)
      throws SQLException {
    ArrayList<ViewHoldReleaseSfcItem> result = new ArrayList<ViewHoldReleaseSfcItem>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_VIEW + " WHERE result_carrier_bo=?  ORDER BY plan_time DESC")) {
      ps.setString(1, resultCarrierBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewHoldReleaseSfcItem> selectrRunningBySfc(String sfcBo) throws SQLException {
    ArrayList<ViewHoldReleaseSfcItem> result = new ArrayList<ViewHoldReleaseSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_VIEW
        + " WHERE sfc_bo=? AND state_name IN('EDIT','SIGNING','SIGNED') ORDER BY SFC_BO, SLOT_NO")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewHoldReleaseSfcItem> selectrRunningByWafer(String waferid) throws SQLException {
    ArrayList<ViewHoldReleaseSfcItem> result = new ArrayList<ViewHoldReleaseSfcItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_VIEW
        + " WHERE CUSTOMER_ITEM_BO = ? and (action_name = 'DRB' or action_name = 'RELEASE') ")) {
      ps.setString(1, waferid);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  private HoldReleaseSfcItem convert(ResultSet rs) throws SQLException {
    HoldReleaseSfcItem data = new HoldReleaseSfcItem();

    data.setHoldReleaseBo(rs.getString(1));
    data.setCustomerItemBo(rs.getString(2));
    data.setSfcBo(rs.getString(3));
    data.setActionName(rs.getString(4));
    data.setResultCarrierBo(rs.getString(5));
    data.setResultSfcBo(rs.getString(6));
    data.setResultSlotNo(rs.getInt(7));
    data.setResultRouterBo(rs.getString(8));
    data.setNcCode(rs.getString(9));
    data.setStatus(rs.getString(10));
    data.setOperationBo(rs.getString(11));
    data.setActionNameGroup(rs.getString(12));

    return data;
  }

  private ViewHoldReleaseSfcItem convertView(ResultSet rs) throws SQLException {
    ViewHoldReleaseSfcItem data = new ViewHoldReleaseSfcItem();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setPlanName(rs.getString(index++));
    data.setPlanTime(DateUtils.getDateTz(rs, index++));
    data.setStateName(rs.getString(index++));
    data.setOa(rs.getString(index++));
    data.setOaFormNo(rs.getString(index++));
    data.setReleaseType(rs.getString(index++));
    data.setCarrierBo(rs.getString(index++));
    data.setHoldReleaseBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setSlotNo(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setResultCarrierBo(rs.getString(index++));
    data.setResultSfcBo(rs.getString(index++));
    data.setResultSlotNo(rs.getInt(index++));
    data.setResultRouterBo(rs.getString(index++));
    data.setNcCode(rs.getString(index++));
    data.setStatus(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setActionNameGroup(rs.getString(index++));

    return data;
  }
}