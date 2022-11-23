package ame.psb.db.dao;

import ame.psb.db.ViewFrameProcess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class ViewFrameProcessDao {

  private static final String SQL_SEL = "SELECT sfc_bo,state_name,current_run,customer_itemset_bo,priority,dpt_no,lot_type,item_qty,shop_order_bo,item_bo,item_name,device_bo,device_name,package_bo,package_name,router_bo,router_name,customer,status_bo,customer_itemset_name,remark,customer_itemset_name_orig,carrier_bo,carrier_name,carrier_state_name,curr_seq,sfc_type,created_date_time,resource_slot_id,batch_id,id,shop_order,sfc,operation,device,sfc_qty,resrce,frame_item_bo,frame_item,frame_item_revision,frame_model,frame_spec,compensation_value,single_qty,origin_strip_qty,needed_strip_qty,reprint_strip_qty,process_start_date,process_complete_date,process_status,create_user,create_time,updated_user,updated_time FROM view_frame_process ";

  private final Connection conn;

  public ViewFrameProcessDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewFrameProcess> selectAll() throws SQLException {
    ArrayList<ViewFrameProcess> result = new ArrayList<ViewFrameProcess>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewFrameProcess> select(Where where) throws SQLException {
    ArrayList<ViewFrameProcess> result = new ArrayList<ViewFrameProcess>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public ViewFrameProcess getReprint(String resourceName) throws SQLException {
    ViewFrameProcess result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE RESRCE=? AND REPRINT_STRIP_QTY > 0")) {
      ps.setString(1, resourceName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ViewFrameProcess convert(ResultSet rs) throws SQLException {
    ViewFrameProcess data = new ViewFrameProcess();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCurrentRun(rs.getString(index++));
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
    data.setCustomer(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setCustomerItemsetName(rs.getString(index++));
    data.setRemark(rs.getString(index++));
    data.setCustomerItemsetNameOrig(rs.getString(index++));
    data.setCarrierBo(rs.getString(index++));
    data.setCarrierName(rs.getString(index++));
    data.setCarrierStateName(rs.getString(index++));
    data.setCurrSeq(rs.getBigDecimal(index++));
    data.setSfcType(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setResourceSlotId(rs.getString(index++));
    data.setBatchId(rs.getString(index++));
    data.setId(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setDevice(rs.getString(index++));
    data.setSfcQty(rs.getString(index++));
    data.setResrce(rs.getString(index++));
    data.setFrameItemBo(rs.getString(index++));
    data.setFrameItem(rs.getString(index++));
    data.setFrameItemRevision(rs.getString(index++));
    data.setFrameModel(rs.getString(index++));
    data.setFrameSpec(rs.getString(index++));
    data.setCompensationValue(rs.getString(index++));
    data.setSingleQty(rs.getString(index++));
    data.setOriginStripQty(rs.getString(index++));
    data.setNeededStripQty(rs.getString(index++));
    data.setReprintStripQty(rs.getString(index++));
    data.setProcessStartDate(DateUtils.getDateTz(rs, index++));
    data.setProcessCompleteDate(DateUtils.getDateTz(rs, index++));
    data.setProcessStatus(rs.getString(index++));
    data.setCreateUser(rs.getString(index++));
    data.setCreateTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
