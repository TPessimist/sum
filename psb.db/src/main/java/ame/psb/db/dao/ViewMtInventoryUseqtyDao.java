package ame.psb.db.dao;

import ame.psb.db.ViewMtInventoryUseqty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ViewMtInventoryUseqtyDao {

  private static final String SQL_SEL = "SELECT inventory_bo,state_name,picked_count,available_time,valid_from,valid_to,mins_in_process,status_bo,inventory_id,inventory_description,qty_on_hand,receive_date_time,modified_date_time,sup_sn,prd_date,eff_date,item_bo,item_name,item_description,use_qty,update_user,update_time,update_log FROM view_mt_inventory_useqty ";

  private final Connection conn;

  public ViewMtInventoryUseqtyDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewMtInventoryUseqty> selectAll() throws SQLException {
    ArrayList<ViewMtInventoryUseqty> result = new ArrayList<ViewMtInventoryUseqty>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewMtInventoryUseqty selectByPK(String inventoryBo) throws SQLException {
    ViewMtInventoryUseqty result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE inventory_bo=?")) {
      ps.setString(1, inventoryBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ViewMtInventoryUseqty convert(ResultSet rs) throws SQLException {
    ViewMtInventoryUseqty data = new ViewMtInventoryUseqty();

    int index = 1;
    data.setInventoryBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setPickedCount(rs.getBigDecimal(index++));
    data.setAvailableTime(DateUtils.getDateTz(rs, index++));
    data.setValidFrom(DateUtils.getDateTz(rs, index++));
    data.setValidTo(DateUtils.getDateTz(rs, index++));
    data.setMinsInProcess(rs.getBigDecimal(index++));
    data.setStatusBo(rs.getString(index++));
    data.setInventoryId(rs.getString(index++));
    data.setInventoryDescription(rs.getString(index++));
    data.setQtyOnHand(rs.getBigDecimal(index++));
    data.setReceiveDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setSupSn(rs.getString(index++));
    data.setPrdDate(rs.getString(index++));
    data.setEffDate(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setItemDescription(rs.getString(index++));
    data.setUseQty(rs.getBigDecimal(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setUpdateLog(rs.getString(index++));

    return data;
  }
}
