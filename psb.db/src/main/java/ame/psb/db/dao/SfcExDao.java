package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.SfcEx;
import ame.psb.db.ViewSfcEx;
import ame.psb.db.ViewSfcPacked;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class SfcExDao {

  private static final String SQL_INS = "INSERT INTO zd_sfc(sfc_bo,state_name,current_run,customer_itemset_bo,priority,dpt_no,lot_type,item_qty,customer_itemset_name,remark,curr_seq,sfc_type,created_user,created_time,batch_id,handover_type) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_sfc SET state_name=?,current_run=?,customer_itemset_bo=?,priority=?,dpt_no=?,lot_type=?,item_qty=?,customer_itemset_name=?,remark=?,curr_seq=?,sfc_type=?,created_user=?,created_time=?,batch_id=?,handover_type=? WHERE sfc_bo=?";

  private static final String SQL_UPD2 = "UPDATE zd_sfc SET customer_itemset_name=?,remark=? WHERE sfc_bo=?";

  private static final String SQL_SEL_STD = "SELECT sfc_bo,state_name,current_run,customer_itemset_bo,priority,dpt_no,lot_type,item_qty,customer_itemset_name,remark,shop_order_bo,shop_order_name,item_bo,item_name,device_bo,device_name,package_bo,package_name,router_bo,router_name,sfc_name,sfc_qty,customer,status_bo,customer_itemset_name_orig,carrier_bo,carrier_name,carrier_state_name,curr_seq,sfc_type,created_date_time,resource_slot_id,batch_id,handover_type,itemset_name_orig FROM view_sfc ";

  private static final String SQL_SEL_PKG = "SELECT sfc_bo,sfc_name,state_name,current_run,customer_itemset_bo,priority,dpt_no,lot_type,item_qty,shop_order_bo,shop_order_name,item_bo,item_name,device_bo,device_name,package_bo,package_name,router_bo,router_name,sfc_qty,customer,status_bo,customer_itemset_name,remark,customer_itemset_name_orig,container_bo,container_state_name,curr_seq,sfc_type,pkg_container_bo,packing_time,operation_bo FROM view_sfc_packed ";

  private static final String SQL_SEL_VIEW_SFC = "SELECT SFC_BO,LOT_TYPE FROM view_sfc WHERE SHOP_ORDER_NAME =?";

  private Connection conn;

  public SfcExDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SfcEx sfc) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, sfc.getSfcBo());
      ps.setString(2, sfc.getStateName());
      ps.setString(3, sfc.getCurrentRun());
      ps.setString(4, sfc.getCustomerItemLotBo());
      ps.setInt(5, sfc.getHotLevel());
      ps.setString(6, sfc.getDptNo());
      ps.setString(7, sfc.getLotType());
      ps.setInt(8, sfc.getItemQty());
      ps.setString(9, sfc.getCustomerItemLotName());
      ps.setString(10, sfc.getRemark());
      ps.setInt(11, sfc.getCurrSeq());
      ps.setString(12, sfc.getSfcType());
      ps.setString(13, sfc.getCreatedUser());
      DateUtils.setDateTz(ps, 14, sfc.getCreatedTime());
      ps.setString(15, sfc.getBatchId());
      ps.setString(16, sfc.getHandoverType());
      return ps.executeUpdate();
    }
  }

  public int update(SfcEx sfc) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, sfc.getStateName());
      ps.setString(2, sfc.getCurrentRun());
      ps.setString(3, sfc.getCustomerItemLotBo());
      ps.setInt(4, sfc.getHotLevel());
      ps.setString(5, sfc.getDptNo());
      ps.setString(6, sfc.getLotType());
      ps.setInt(7, sfc.getItemQty());
      ps.setString(8, sfc.getCustomerItemLotName());
      ps.setString(9, sfc.getRemark());
      ps.setInt(10, sfc.getCurrSeq());
      ps.setString(11, sfc.getSfcType());
      ps.setString(12, sfc.getCreatedUser());
      DateUtils.setDateTz(ps, 13, sfc.getCreatedTime());
      ps.setString(14, sfc.getBatchId());
      ps.setString(15, sfc.getHandoverType());
      ps.setString(16, sfc.getSfcBo());
      return ps.executeUpdate();
    }
  }

  public int update(ViewSfcEx sfc) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, sfc.getStateName());
      ps.setString(2, sfc.getCurrentRun());
      ps.setString(3, sfc.getCustomerItemLotBo());
      ps.setInt(4, sfc.getHotLevel());
      ps.setString(5, sfc.getDptNo());
      ps.setString(6, sfc.getLotType());
      ps.setInt(7, sfc.getItemQty());
      ps.setString(8, sfc.getCustomerItemLotName());
      ps.setString(9, sfc.getRemark());
      ps.setInt(10, sfc.getCurrSeq());
      ps.setString(11, sfc.getSfcType());
      ps.setString(12, sfc.getCreatedUser());
      DateUtils.setDateTz(ps, 13, sfc.getCreatedDateTime());
      ps.setString(14, sfc.getBatchId());
      ps.setString(15, sfc.getHandoverType());
      ps.setString(16, sfc.getSfcBo());
      return ps.executeUpdate();
    }
  }

  public int updateForSfcMaintain(SfcEx sfc) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD2)) {
      ps.setString(1, sfc.getCustomerItemLotName());
      ps.setString(2, sfc.getRemark());
      ps.setString(3, sfc.getSfcBo());
      return ps.executeUpdate();
    }
  }

  public int updateForSfcBo(String batchId, String sfcbo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_sfc SET batch_id=? WHERE sfc_bo=?")) {
      ps.setString(1, batchId);
      ps.setString(2, sfcbo);
      return ps.executeUpdate();
    }
  }

  public int updateCurrSeq(String sfcBo, int currSeq) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_sfc SET curr_seq=? WHERE sfc_bo=?")) {
      ps.setInt(1, currSeq);
      ps.setString(2, sfcBo);
      return ps.executeUpdate();
    }
  }

  public int updatePriority(List<String> sfcBos) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_sfc SET PRIORITY = '3' WHERE sfc_bo = ?")) {
      for (String sfc : sfcBos) {
        ps.setString(1, Env.genSfcBo(sfc));
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public ViewSfcEx selectByPK(String id) throws SQLException {
    ViewSfcEx sfc = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_STD + "WHERE sfc_bo=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        sfc = this.convert(rs);
      }
    }
    return sfc;
  }

  public List<ViewSfcEx> select(Date begin, Date end) throws SQLException {
    ArrayList<ViewSfcEx> result = new ArrayList<ViewSfcEx>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_STD
        + "WHERE created_date_time BETWEEN ? AND ? ORDER BY created_date_time,sfc_name")) {
      DateUtils.setDateTz(ps, 1, begin);
      DateUtils.setDateTz(ps, 2, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewSfcEx> selectByBatchId(String batchId) throws SQLException {
    ArrayList<ViewSfcEx> result = new ArrayList<ViewSfcEx>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_STD + "WHERE batch_id = ?")) {
      ps.setString(1, batchId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewSfcEx> select(Where where) throws SQLException {
    ArrayList<ViewSfcEx> result = new ArrayList<ViewSfcEx>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL_STD)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewSfcEx> selectAll() throws SQLException {
    ArrayList<ViewSfcEx> result = new ArrayList<ViewSfcEx>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_STD + "ORDER BY sfc_name")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public ViewSfcEx selectByName(String sfcName) throws SQLException {
    ViewSfcEx sfc = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_STD + "WHERE sfc_name=?")) {
      ps.setString(1, sfcName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        sfc = this.convert(rs);
      }
    }
    return sfc;
  }

  public ViewSfcEx selectByDevice(String deviceBo) throws SQLException {
    ViewSfcEx sfc = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_STD + "WHERE device_bo=? ORDER BY created_date_time")) {
      ps.setString(1, deviceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        sfc = this.convert(rs);
      }
    }
    return sfc;
  }

  public List<ViewSfcEx> selectByItemGroupBo(String deviceBo) throws SQLException {
    ArrayList<ViewSfcEx> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_STD + "WHERE device_bo=? ORDER BY created_date_time")) {
      ps.setString(1, deviceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }


  public List<ViewSfcEx> selectByNamePrefix(String namePrefix) throws SQLException {
    ArrayList<ViewSfcEx> result = new ArrayList<ViewSfcEx>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_STD + "WHERE sfc_name like ? ORDER BY sfc_name")) {
      ps.setString(1, namePrefix + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;

  }

  public List<ViewSfcEx> selectByCarrier(String carrierBo) throws SQLException {
    ArrayList<ViewSfcEx> result = new ArrayList<ViewSfcEx>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_STD + "WHERE carrier_bo=? ORDER BY sfc_name")) {
      ps.setString(1, carrierBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewSfcEx> selectByShopOrder(String shopOrderBo) throws SQLException {
    ArrayList<ViewSfcEx> result = new ArrayList<ViewSfcEx>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_STD + "WHERE shop_order_bo=? ORDER BY sfc_name")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewSfcEx> selectByShopOrder(String shopOrderBo, String sfcType) throws SQLException {
    ArrayList<ViewSfcEx> result = new ArrayList<ViewSfcEx>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_STD
        + "WHERE shop_order_bo=? and SFC_TYPE = ? and state_name != 'CLOSE' ORDER BY sfc_name")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, sfcType);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewSfcEx> selectByShopOrderInLine(String shopOrderBo) throws SQLException {
    ArrayList<ViewSfcEx> result = new ArrayList<ViewSfcEx>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_STD
        + "WHERE shop_order_bo=? and state_name not in ('CLOSE','DELETE') ORDER BY sfc_name")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewSfcEx> selectByCustomerLot(String customerLotBo) throws SQLException {
    ArrayList<ViewSfcEx> result = new ArrayList<ViewSfcEx>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_STD + "WHERE customer_itemset_bo=? ORDER BY sfc_name")) {
      ps.setString(1, customerLotBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewSfcEx> selectByCustomerItemsetName(String customerLotName) throws SQLException {
    ArrayList<ViewSfcEx> result = new ArrayList<ViewSfcEx>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_STD
            + "WHERE customer_itemset_name=? and state_name !='CLOSE' ORDER BY sfc_name")) {
      ps.setString(1, customerLotName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewSfcEx> selectFCRootAndFCDAInspSfc(String shopOrderName) throws SQLException {
    ArrayList<ViewSfcEx> result = new ArrayList<ViewSfcEx>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_STD
        + "WHERE SHOP_ORDER_BO =? and STATE_NAME != 'CLOSE' and batch_id is null ORDER BY sfc_name")) {
      ps.setString(1, shopOrderName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewSfcPacked> selectPacked(String operationBo) throws SQLException {
    ArrayList<ViewSfcPacked> result = new ArrayList<ViewSfcPacked>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_PKG
        + " WHERE operation_bo=?   AND container_state_name<>'UNPACK' ORDER BY sfc_name")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convertPacked(rs));
      }
    }
    return result;

  }

  public List<ViewSfcPacked> selectPackedByDeviceAndOperation(String operationBo,
      String itemGroupBo) throws SQLException {
    ArrayList<ViewSfcPacked> result = new ArrayList<ViewSfcPacked>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_PKG
        + " WHERE operation_bo=? AND device_name=?  AND container_state_name<>'UNPACK' ORDER BY sfc_name")) {
      ps.setString(1, operationBo);
      ps.setString(2, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convertPacked(rs));
      }
    }
    return result;

  }

  public List<ViewSfcPacked> selectPackedByCustomer(String itemsetName) throws SQLException {
    ArrayList<ViewSfcPacked> result = new ArrayList<ViewSfcPacked>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_PKG
        + " WHERE customer = ? AND container_state_name<>'UNPACK' ORDER BY sfc_name")) {
      ps.setString(1, itemsetName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convertPacked(rs));
      }
    }
    return result;

  }



  /**
   * YKQ 根据sfc_bo修改对应的state_name
   *
   * @param id
   * @param stateName 状态
   * @return
   * @throws SQLException
   */
  public int changeState(String id, String stateName) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_sfc SET state_name=? WHERE sfc_bo=?");
    ps.setString(1, stateName);
    ps.setString(2, id);
    return ps.executeUpdate();
  }

  /**
   * XYH 根据sfc_bo修改批次交接类型的handover_type
   *
   * @param sfcBo        生产批号
   * @param handoverType 批次交接类型
   * @return
   * @throws SQLException
   */
  public int changeHandoverType(String sfcBo, String handoverType) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_sfc SET handover_type=? WHERE sfc_bo=?");
    ps.setString(1, handoverType);
    ps.setString(2, sfcBo);
    return ps.executeUpdate();
  }

  /**
   * YKQ 根据工单号查询对应
   *
   * @param id
   * @return
   * @throws SQLException
   */
  public HashMap<String, String> selectSfcBO(String id) throws SQLException {
    HashMap<String, String> result = new HashMap<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_VIEW_SFC)) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.put(rs.getString(1), rs.getString(2));
      }
    }
    return result;

  }

  public int changeState(String id, String stateName, String run) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_sfc SET state_name=?,current_run=? WHERE sfc_bo=?");
    ps.setString(1, stateName);
    ps.setString(2, run);
    ps.setString(3, id);
    return ps.executeUpdate();
  }

  private ViewSfcEx convert(ResultSet rs) throws SQLException {
    ViewSfcEx data = new ViewSfcEx();
    data.setSfcBo(rs.getString(1));
    data.setStateName(rs.getString(2));
    data.setCurrentRun(rs.getString(3));
    data.setCustomerItemLotBo(rs.getString(4));
    data.setHotLevel(rs.getInt(5));
    data.setDptNo(rs.getString(6));
    data.setLotType(rs.getString(7));
    data.setItemQty(rs.getInt(8));
    data.setCustomerItemLotName(rs.getString(9));
    data.setRemark(rs.getString(10));

    int i = 11;
    data.setShopOrderBo(rs.getString(i++));
    data.setShopOrderName(rs.getString(i++));
    data.setItemBo(rs.getString(i++));
    data.setItemName(rs.getString(i++));
    data.setDeviceBo(rs.getString(i++));
    data.setDeviceName(rs.getString(i++));
    data.setPackageBo(rs.getString(i++));
    data.setPackageName(rs.getString(i++));
    data.setRouterBo(rs.getString(i++));
    data.setRouterName(rs.getString(i++));
    data.setSfcName(rs.getString(i++));
    data.setSfcQty(rs.getInt(i++));
    data.setCustomer(rs.getString(i++));
    data.setStatusBo(rs.getString(i++));
    data.setCustomerItemLotNameOrig(rs.getString(i++));
    data.setCarrierBo(rs.getString(i++));
    data.setCarrierName(rs.getString(i++));
    data.setCarrierStateName(rs.getString(i++));
    data.setCurrSeq(rs.getInt(i++));
    data.setSfcType(rs.getString(i++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, i++));
    data.setResourceSlotId(rs.getString(i++));
    data.setBatchId(rs.getString(i++));
    data.setHandoverType(rs.getString(i++));
    data.setItemsetNameOrig(rs.getString(i++));
    return data;
  }

  private ViewSfcPacked convertPacked(ResultSet rs) throws SQLException {
    ViewSfcPacked data = new ViewSfcPacked();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCurrentRun(rs.getString(index++));
    data.setCustomerItemLotBo(rs.getString(index++));
    data.setHotLevel(rs.getInt(index++));
    data.setDptNo(rs.getString(index++));
    data.setLotType(rs.getString(index++));
    data.setItemQty(rs.getInt(index++));

    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setDeviceBo(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setPackageBo(rs.getString(index++));
    data.setPackageName(rs.getString(index++));
    data.setRouterBo(rs.getString(index++));
    data.setRouterName(rs.getString(index++));
    data.setSfcQty(rs.getInt(index++));
    data.setCustomer(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));

    data.setCustomerItemLotName(rs.getString(index++));
    data.setRemark(rs.getString(index++));

    data.setCustomerItemsetNameOrig(rs.getString(index++));
    data.setContainerBo(rs.getString(index++));
    data.setContainerStateName(rs.getString(index++));
    data.setCurrSeq(rs.getInt(index++));
    data.setSfcType(rs.getString(index++));
    data.setPkgContainerBo(rs.getString(index++));
    data.setPackingTime(DateUtils.getDateTz(rs, index++));
    data.setOperationBo(rs.getString(index++));

    return data;
  }
}
