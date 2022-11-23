package ame.psb.db.dao;

import ame.psb.db.ViewFrameWaitProcess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class ViewFrameWaitProcessDao {

  private static final String SQL_SEL = "SELECT sfc_bo,state_name,current_run,customer_itemset_bo,priority,dpt_no,lot_type,item_qty,customer_itemset_name,remark,shop_order_bo,shop_order_name,item_bo,item_name,device_bo,device_name,package_bo,package_name,router_bo,router_name,sfc_name,sfc_qty,customer,status_bo,customer_itemset_name_orig,carrier_bo,carrier_name,carrier_state_name,curr_seq,sfc_type,created_date_time,resource_slot_id,batch_id,frame_item_bo,frame_item,frame_item_revision,frame_model,frame_spec,single_qty,compensation_value,operation_bo,needed_strip_qty,process_status,sequence FROM view_frame_wait_process ";

  private final Connection conn;

  public ViewFrameWaitProcessDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewFrameWaitProcess> select(Where where) throws SQLException {
    ArrayList<ViewFrameWaitProcess> result = new ArrayList<ViewFrameWaitProcess>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<ViewFrameWaitProcess> selectAll() throws SQLException {
    ArrayList<ViewFrameWaitProcess> result = new ArrayList<ViewFrameWaitProcess>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewFrameWaitProcess convert(ResultSet rs) throws SQLException {
    ViewFrameWaitProcess data = new ViewFrameWaitProcess();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCurrentRun(rs.getString(index++));
    data.setCustomerItemsetBo(rs.getString(index++));
    data.setPriority(rs.getBigDecimal(index++));
    data.setDptNo(rs.getString(index++));
    data.setLotType(rs.getString(index++));
    data.setItemQty(rs.getBigDecimal(index++));
    data.setCustomerItemsetName(rs.getString(index++));
    data.setRemark(rs.getString(index++));
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
    data.setSfcName(rs.getString(index++));
    data.setSfcQty(rs.getBigDecimal(index++));
    data.setCustomer(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setCustomerItemsetNameOrig(rs.getString(index++));
    data.setCarrierBo(rs.getString(index++));
    data.setCarrierName(rs.getString(index++));
    data.setCarrierStateName(rs.getString(index++));
    data.setCurrSeq(rs.getBigDecimal(index++));
    data.setSfcType(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setResourceSlotId(rs.getString(index++));
    data.setBatchId(rs.getString(index++));
    data.setFrameItemBo(rs.getString(index++));
    data.setFrameItem(rs.getString(index++));
    data.setFrameItemRevision(rs.getString(index++));
    data.setFrameModel(rs.getString(index++));
    data.setFrameSpec(rs.getString(index++));
    data.setSingleQty(rs.getString(index++));
    data.setCompensationValue(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setNeededStripQty(rs.getBigDecimal(index++));
    data.setProcessStatus(rs.getString(index++));
    data.setSequence(rs.getInt(index++));
    return data;
  }
}
