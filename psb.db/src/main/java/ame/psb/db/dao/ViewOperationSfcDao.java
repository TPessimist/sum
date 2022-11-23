package ame.psb.db.dao;

import ame.psb.db.ViewOperationSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ViewOperationSfcDao {

  private static final String SQL_SEL = "SELECT sfc_bo,sfc_name,state_name,current_run,customer_itemset_bo,priority,dpt_no,lot_type,item_qty,shop_order_bo,shop_order_name,item_bo,item_name,device_bo,device_name,package_bo,package_name,router_bo,router_name,sfc_qty,customer,status_bo,customer_itemset_name,remark,customer_itemset_name_orig,carrier_bo,carrier_name,carrier_state_name,curr_seq,sfc_type,created_date_time,resource_slot_id,batch_id,run_sfc_id,run_carrier_bo,resource_bo,recipe_name,begin_time,end_time,run_user,operation_bo FROM view_operation_sfc ";

  private final Connection conn;

  public ViewOperationSfcDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewOperationSfc> selectAll() throws SQLException {
    ArrayList<ViewOperationSfc> result = new ArrayList<ViewOperationSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewOperationSfc> selectByOperationAndTime(String operationBo, Date start, Date end)
      throws SQLException { //按照站点和时间查询站点生产信息
    ArrayList<ViewOperationSfc> result = new ArrayList<ViewOperationSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE replace(operation_bo,',A',',#') =? and BEGIN_TIME between ? and ?  ORDER BY begin_time")) {

      ps.setString(1, operationBo);
      DateUtils.setDateTz(ps, 2, start);
      DateUtils.setDateTz(ps, 3, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewOperationSfc> selectBySfcAndOperation(String sfcBo, String operationBo)
      throws SQLException { //按照站点和时间查询站点生产信息
    ArrayList<ViewOperationSfc> result = new ArrayList<ViewOperationSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE sfc_bo=? and  operation_bo=? ORDER BY begin_time desc limit 1")) {

      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  private ViewOperationSfc convert(ResultSet rs) throws SQLException {
    ViewOperationSfc data = new ViewOperationSfc();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCurrentRun(rs.getString(index++));
    data.setCustomerItemsetBo(rs.getString(index++));
    data.setPriority(rs.getBigDecimal(index++));
    data.setDptNo(rs.getString(index++));
    data.setLotType(rs.getString(index++));
    data.setItemQty(rs.getBigDecimal(index++));
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
    data.setSfcQty(rs.getBigDecimal(index++));
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
    data.setRunSfcId(rs.getString(index++));
    data.setRunCarrierBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setRecipeName(rs.getString(index++));
    data.setBeginTime(DateUtils.getDateTz(rs, index++));
    data.setEndTime(DateUtils.getDateTz(rs, index++));
    data.setRunUser(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));

    return data;
  }
}
