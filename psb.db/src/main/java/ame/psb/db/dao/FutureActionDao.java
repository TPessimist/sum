package ame.psb.db.dao;

import ame.psb.db.FutureAction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FutureActionDao {

  private static final String SQL_INS = "INSERT INTO zd_future_action(id,state_name,customer_bo,item_group_bo,item_bo,shop_order_bo,sfc_bo,operation_bo,action_name,action_content,chk_type,chk_qty,chk_from,chk_to,step_seq,action_comment,updated_user,updated_time,customer_lot,wafer_id,lot_type,department,upload_path,CUSTOMER_DEVICE,CAPABILITY_CONTENT,OA_ID,FAB_LOT_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_future_action SET state_name=?,customer_bo=?,item_group_bo=?,item_bo=?,shop_order_bo=?,sfc_bo=?,operation_bo=?,action_name=?,action_content=?,chk_type=?,chk_qty=?,chk_from=?,chk_to=?,step_seq=?,action_comment=?,updated_user=?,updated_time=?,customer_lot=?,wafer_id=?,lot_type=?,department=?,upload_path=? ,CUSTOMER_DEVICE = ?,CAPABILITY_CONTENT=?,OA_ID =?,FAB_LOT_ID=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,state_name,customer_bo,item_group_bo,item_bo,shop_order_bo,sfc_bo,operation_bo,action_name,action_content,chk_type,chk_qty,chk_from,chk_to,step_seq,action_comment,updated_user,updated_time,customer_lot,wafer_id,lot_type,department,upload_path,CUSTOMER_DEVICE,CAPABILITY_CONTENT,OA_ID,FAB_LOT_ID FROM zd_future_action ";

  private static final String SQL_UPD2 = "UPDATE ZD_FUTURE_ACTION SET STATE_NAME = ? WHERE ID=?";
  private final Connection conn;

  public FutureActionDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FutureAction data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getStateName());
      ps.setString(3, data.getCustomerBo());
      ps.setString(4, data.getItemGroupBo());
      ps.setString(5, data.getItemBo());
      ps.setString(6, data.getShopOrderBo());
      ps.setString(7, data.getSfcBo());
      ps.setString(8, data.getOperationBo());
      ps.setString(9, data.getActionName());
      ps.setString(10, data.getActionContent());
      ps.setString(11, data.getChkType());
      ps.setInt(12, data.getChkQty());
      DateUtils.setDateTz(ps, 13, data.getChkFrom());
      DateUtils.setDateTz(ps, 14, data.getChkTo());
      ps.setInt(15, data.getStepSeq());
      ps.setString(16, data.getActionComment());
      ps.setString(17, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 18, data.getUpdatedTime());
      ps.setString(19, data.getCustomerLot());
      ps.setString(20, data.getWaferId());
      ps.setString(21, data.getLotType());
      ps.setString(22, data.getDepartment());
      ps.setString(23, data.getUploadPath());
      ps.setString(24, data.getCustomerDevice());
      ps.setString(25, data.getCapAbilityContent());
      ps.setString(26, data.getOaId());
      ps.setString(27, data.getFabLotId());

      return ps.executeUpdate();
    }
  }

  public int update(FutureAction data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getStateName());
      ps.setString(2, data.getCustomerBo());
      ps.setString(3, data.getItemGroupBo());
      ps.setString(4, data.getItemBo());
      ps.setString(5, data.getShopOrderBo());
      ps.setString(6, data.getSfcBo());
      ps.setString(7, data.getOperationBo());
      ps.setString(8, data.getActionName());
      ps.setString(9, data.getActionContent());
      ps.setString(10, data.getChkType());
      ps.setInt(11, data.getChkQty());
      DateUtils.setDateTz(ps, 12, data.getChkFrom());
      DateUtils.setDateTz(ps, 13, data.getChkTo());
      ps.setInt(14, data.getStepSeq());
      ps.setString(15, data.getActionComment());
      ps.setString(16, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 17, data.getUpdatedTime());
      ps.setString(18, data.getCustomerLot());
      ps.setString(19, data.getWaferId());
      ps.setString(20, data.getLotType());
      ps.setString(21, data.getDepartment());
      ps.setString(22, data.getUploadPath());
      ps.setString(23, data.getCustomerDevice());
      ps.setString(24, data.getCapAbilityContent());
      ps.setString(25, data.getOaId());
      ps.setString(26, data.getFabLotId());
      ps.setString(27, data.getId());
      return ps.executeUpdate();
    }
  }

  public List<FutureAction> selectAll() throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public FutureAction selectByPK(String id) throws SQLException {
    FutureAction result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public List<FutureAction> selectByPKId(String id) throws SQLException {
    List<FutureAction> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE id=?")) {
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectByOaIdAndStateName(String oaId)
      throws SQLException {
    List<FutureAction> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + " WHERE oa_id=? and state_name in ('OA_ENABLE', 'OA_CANCEL')")) {
      ps.setString(1, oaId);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE sfc_bo=? ORDER BY operation_bo")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOnlineBySfc(String sfcBo) throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE sfc_bo=? AND state_name='ENABLE' ORDER BY operation_bo")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectFutureBySfc(String sfcBo, int currentStepSeq)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE sfc_bo=? AND state_name='ENABLE' AND step_seq>=? ORDER BY operation_bo")) {
      ps.setString(1, sfcBo);
      ps.setInt(2, currentStepSeq);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectBySfc(String sfcBo, String operationBo) throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE sfc_bo=? AND operation_bo=? ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOnlineBySfc(String sfcBo, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE sfc_bo=? AND operation_bo=? AND state_name='ENABLE' ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public FutureAction selectBySfcAndOperationBoAndActionName(String sfcBo, String operationBo,
      String actionName) throws SQLException {
    FutureAction result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE sfc_bo=? AND operation_bo=? AND ACTION_NAME=? AND state_name='ENABLE' ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);
      ps.setString(3, actionName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public List<FutureAction> selectOnlineHoldBySfc(String sfcBo, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE sfc_bo=? AND operation_bo=? AND ACTION_NAME='HOLD' AND state_name='ENABLE' ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOaBySfc(String sfcBo, String operationBo) throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE sfc_bo=? AND operation_bo=? AND state_name in ('OA_ENABLE', 'OA_CANCEL')  ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectByShopOrder(String shopOrderBo) throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE shop_order_bo=? ORDER BY operation_bo")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectByShopOrder(String shopOrderBo, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE shop_order_bo=? AND operation_bo=? ")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOnlineByShopOrder(String shopOrderBo, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE shop_order_bo=? AND operation_bo=? AND state_name='ENABLE' ")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOnlineHoldByShopOrder(String shopOrderBo, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE shop_order_bo=? AND operation_bo=? AND ACTION_NAME='HOLD' AND state_name='ENABLE' ")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOaByShopOrder(String shopOrderBo, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE shop_order_bo=? AND operation_bo=? AND state_name in ('OA_ENABLE', 'OA_CANCEL')  ")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectByItem(String itemBo) throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE item_bo=? ORDER BY operation_bo")) {
      ps.setString(1, itemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectByItem(String itemBo, String operationBo) throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE item_bo=? AND operation_bo=? ")) {
      ps.setString(1, itemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOnlineByItem(String itemBo, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE item_bo=? AND operation_bo=? AND state_name='ENABLE' ")) {
      ps.setString(1, itemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOnlineHoldByItem(String itemBo, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE item_bo=? AND operation_bo=? AND ACTION_NAME='HOLD' AND state_name='ENABLE' ")) {
      ps.setString(1, itemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOaByItem(String itemBo, String operationBo) throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE item_bo=? AND operation_bo=? AND state_name in ('OA_ENABLE', 'OA_CANCEL')  ")) {
      ps.setString(1, itemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectByItemGroup(String itemGroupBo) throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE item_group_bo=? ORDER BY operation_bo")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectByItemGroup(String itemGroupBo, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE item_group_bo=? AND operation_bo=? ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOnlineByItemGroup(String itemGroupBo, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE item_group_bo=? AND operation_bo=? AND state_name='ENABLE' ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectByItemGroupAndOperationAndComment(String itemGroupBo,
      String operationBo, String actionComment) throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + " WHERE item_group_bo=? AND operation_bo=? AND action_comment=? AND state_name='ENABLE' ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, actionComment);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOnlineHoldByItemGroup(String itemGroupBo, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE item_group_bo=? AND operation_bo=? AND ACTION_NAME='HOLD' AND state_name='ENABLE' ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOnlineHoldByCustomerDevice(String customerDevice,
      String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE CUSTOMER_DEVICE=? AND operation_bo=? AND ACTION_NAME='HOLD' AND state_name='ENABLE' ")) {
      ps.setString(1, customerDevice);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOaByItemGroup(String itemGroupBo, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE item_group_bo=? AND operation_bo=? AND state_name in ('OA_ENABLE', 'OA_CANCEL')  ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOaByFabLotId(String fab_lot_id, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE FAB_LOT_ID =? AND operation_bo=? AND state_name in ('OA_ENABLE', 'OA_CANCEL')  ")) {
      ps.setString(1, fab_lot_id);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOaByCustomerDeviceOa(String customerDevice, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE CUSTOMER_DEVICE =? AND operation_bo=? AND state_name in ('OA_ENABLE', 'OA_CANCEL')  ")) {
      ps.setString(1, customerDevice);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectByCustomer(String customerBo) throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE customer_bo=? ORDER BY operation_bo")) {
      ps.setString(1, customerBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectByCustomer(String customerBo, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE customer_bo=? AND operation_bo=? ")) {
      ps.setString(1, customerBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOnlineByCustomer(String customerBo, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE customer_bo=? AND operation_bo=? AND state_name='ENABLE' ")) {
      ps.setString(1, customerBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  //selectOnlineByFabLotId

  public List<FutureAction> selectOnlineByFabLotId(String fabLotId, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE FAB_LOT_ID=? AND operation_bo=? AND state_name='ENABLE' ")) {
      ps.setString(1, fabLotId);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOnlineHoldByCustomer(String customerBo, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE customer_bo=? AND operation_bo=? AND ACTION_NAME='HOLD' AND state_name='ENABLE' ")) {
      ps.setString(1, customerBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOaByCustomer(String customerBo, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE customer_bo=? AND operation_bo=? AND state_name in ('OA_ENABLE', 'OA_CANCEL')  ")) {
      ps.setString(1, customerBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectByCustomerLot(String customerLot) throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE customer_lot=? ORDER BY operation_bo")) {
      ps.setString(1, customerLot);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectByCustomerLot(String customerLot, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE customer_lot=? AND operation_bo=? ")) {
      ps.setString(1, customerLot);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOnlineByCustomerLot(String customerLot, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE customer_lot=? AND operation_bo=? AND state_name='ENABLE' ")) {
      ps.setString(1, customerLot);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOnlineHoldByCustomerLot(String customerLot, String operationBo,
      String actionComment)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE customer_lot=? AND operation_bo=? AND action_name='HOLD' AND action_comment=? AND state_name='ENABLE' ")) {
      ps.setString(1, customerLot);
      ps.setString(2, operationBo);
      ps.setString(3, actionComment);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOaByCustomerLot(String customerLot, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE customer_lot=? AND operation_bo=? AND state_name in ('OA_ENABLE', 'OA_CANCEL')  ")) {
      ps.setString(1, customerLot);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectByWaferId(String waferId) throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE wafer_id=? ORDER BY operation_bo")) {
      ps.setString(1, waferId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectByCustomerDevice(String CustomerDevice) throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE CUSTOMER_DEVICE=? ORDER BY operation_bo")) {
      ps.setString(1, CustomerDevice);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectByWaferId(String waferId, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE wafer_id=? AND operation_bo=? ")) {
      ps.setString(1, waferId);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOnlineByWaferId(String waferId, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE wafer_id=? AND operation_bo=? AND  state_name='ENABLE'")) {
      ps.setString(1, waferId);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public FutureAction selectByPK2(String waferId, String operationBo)
      throws SQLException {
    FutureAction result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + " WHERE wafer_id=? AND operation_bo=? AND state_name='ENABLE' ")) {
      ps.setString(1, waferId);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public FutureAction selectByWaferIdAndOperation(String waferId, String operationBo,
      String actionComment)
      throws SQLException {
    FutureAction result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + " WHERE wafer_id=? AND operation_bo=? AND action_comment=? AND state_name='ENABLE' ")) {
      ps.setString(1, waferId);
      ps.setString(2, operationBo);
      ps.setString(3, actionComment);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public List<FutureAction> selectByWaferIdOnLine(String waferId)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE wafer_id=? AND state_name in ('OA_ENABLE', 'OA_CANCEL')  ")) {
      ps.setString(1, waferId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<FutureAction> selectOaByWaferId(String waferId, String operationBo)
      throws SQLException {
    ArrayList<FutureAction> result = new ArrayList<FutureAction>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE wafer_id=? AND operation_bo=? AND state_name in ('OA_ENABLE', 'OA_CANCEL')  ")) {
      ps.setString(1, waferId);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  private FutureAction convert(ResultSet rs) throws SQLException {
    FutureAction data = new FutureAction();

    data.setId(rs.getString(1));
    data.setStateName(rs.getString(2));
    data.setCustomerBo(rs.getString(3));
    data.setItemGroupBo(rs.getString(4));
    data.setItemBo(rs.getString(5));
    data.setShopOrderBo(rs.getString(6));
    data.setSfcBo(rs.getString(7));
    data.setOperationBo(rs.getString(8));
    data.setActionName(rs.getString(9));
    data.setActionContent(rs.getString(10));
    data.setChkType(rs.getString(11));
    data.setChkQty(rs.getInt(12));
    data.setChkFrom(DateUtils.getDateTz(rs, 13));
    data.setChkTo(DateUtils.getDateTz(rs, 14));
    data.setStepSeq(rs.getInt(15));
    data.setActionComment(rs.getString(16));
    data.setUpdatedUser(rs.getString(17));
    data.setUpdatedTime(DateUtils.getDateTz(rs, 18));
    data.setCustomerLot(rs.getString(19));
    data.setWaferId(rs.getString(20));
    data.setLotType(rs.getString(21));
    data.setDepartment(rs.getString(22));
    data.setUploadPath(rs.getString(23));
    data.setCustomerDevice(rs.getString(24));
    data.setCapAbilityContent(rs.getString(25));
    data.setOaId(rs.getString(26));
    data.setFabLotId(rs.getString(27));
    return data;
  }

  public int selectByItemGroupBo(String itemGroupBoTo, String customerToBo) throws SQLException {
    String selSql = "select count(1) from zd_future_action where customer_bo = ? and  item_group_bo = ?";
    int count = 0;
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, customerToBo);
      ps.setString(2, itemGroupBoTo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        count = rs.getInt(1);
      }
      return count;
    }
  }

  public List<FutureAction> selectByItemGroupBoAndCustomerBo(String itemGroupBoFrom)
      throws SQLException {
    String selSql = SQL_SEL + "where item_group_bo = ?";
    List<FutureAction> list = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, itemGroupBoFrom);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(this.convert(rs));
      }
      return list;
    }
  }


  public int updateBatchStateName(String stateName, List<String> ids) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD2)) {
      for (String id : ids) {

        ps.setString(1, stateName);
        ps.setString(2, id);
        ps.addBatch();

      }
      return ps.executeBatch().length;
    }
  }

  public List<FutureAction> selectByFabLotId(String fabLotId) throws SQLException {
    List<FutureAction> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE fab_lot_id=?")) {
      ps.setString(1, fabLotId);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public void insertBatch(List<FutureAction> list) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FutureAction data : list) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getStateName());
        ps.setString(3, data.getCustomerBo());
        ps.setString(4, data.getItemGroupBo());
        ps.setString(5, data.getItemBo());
        ps.setString(6, data.getShopOrderBo());
        ps.setString(7, data.getSfcBo());
        ps.setString(8, data.getOperationBo());
        ps.setString(9, data.getActionName());
        ps.setString(10, data.getActionContent());
        ps.setString(11, data.getChkType());
        ps.setInt(12, data.getChkQty());
        DateUtils.setDateTz(ps, 13, data.getChkFrom());
        DateUtils.setDateTz(ps, 14, data.getChkTo());
        ps.setInt(15, data.getStepSeq());
        ps.setString(16, data.getActionComment());
        ps.setString(17, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 18, data.getUpdatedTime());
        ps.setString(19, data.getCustomerLot());
        ps.setString(20, data.getWaferId());
        ps.setString(21, data.getLotType());
        ps.setString(22, data.getDepartment());
        ps.setString(23, data.getUploadPath());
        ps.setString(24, data.getCustomerDevice());
        ps.setString(25, data.getCapAbilityContent());
        ps.setString(26, data.getOaId());
        ps.setString(27, data.getFabLotId());
        ps.addBatch();
      }
      ps.executeBatch();
    }
  }
}
