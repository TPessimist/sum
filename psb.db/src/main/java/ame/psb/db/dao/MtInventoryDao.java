package ame.psb.db.dao;

import ame.psb.db.MtInventory;
import ame.psb.db.ViewMtInventory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class MtInventoryDao {

  private static final String SQL_INS = "INSERT INTO zd_mt_inventory(inventory_bo,state_name,picked_count,available_time,valid_from,valid_to,mins_in_process) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_mt_inventory SET state_name=?,picked_count=?,available_time=?,valid_from=?,valid_to=?,mins_in_process=? WHERE inventory_bo=?";

  private static final String SQL_SEL = "SELECT inventory_bo,state_name,picked_count,available_time,valid_from,valid_to,mins_in_process,status_bo,inventory_id,inventory_description,qty_on_hand,receive_date_time,modified_date_time,sup_sn,prd_date,eff_date,item_bo,item_name,item_description FROM view_mt_inventory ";

  private final Connection conn;

  public MtInventoryDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(MtInventory data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getInventoryBo());
      ps.setString(2, data.getStateName());
      ps.setInt(3, data.getPickedCount());
      DateUtils.setDateTz(ps, 4, data.getAvailableTime());
      DateUtils.setDateTz(ps, 5, data.getValidFrom());
      DateUtils.setDateTz(ps, 6, data.getValidTo());
      ps.setBigDecimal(7, data.getMinsInProcess());

      return ps.executeUpdate();
    }
  }

  public int insert(List<MtInventory> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (MtInventory data : dataList) {
        ps.setString(1, data.getInventoryBo());
        ps.setString(2, data.getStateName());
        ps.setInt(3, data.getPickedCount());
        DateUtils.setDateTz(ps, 4, data.getAvailableTime());
        DateUtils.setDateTz(ps, 5, data.getValidFrom());
        DateUtils.setDateTz(ps, 6, data.getValidTo());
        ps.setBigDecimal(7, data.getMinsInProcess());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(MtInventory data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getStateName());
      ps.setInt(2, data.getPickedCount());
      DateUtils.setDateTz(ps, 3, data.getAvailableTime());
      DateUtils.setDateTz(ps, 4, data.getValidFrom());
      DateUtils.setDateTz(ps, 5, data.getValidTo());
      ps.setBigDecimal(6, data.getMinsInProcess());
      ps.setString(7, data.getInventoryBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<MtInventory> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (MtInventory data : dataList) {
        ps.setString(1, data.getStateName());
        ps.setInt(2, data.getPickedCount());
        DateUtils.setDateTz(ps, 3, data.getAvailableTime());
        DateUtils.setDateTz(ps, 4, data.getValidFrom());
        DateUtils.setDateTz(ps, 5, data.getValidTo());
        ps.setBigDecimal(6, data.getMinsInProcess());
        ps.setString(7, data.getInventoryBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String inventoryBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_mt_inventory WHERE inventory_bo=?")) {
      ps.setString(1, inventoryBo);

      return ps.executeUpdate();
    }
  }

  public List<ViewMtInventory> selectAll() throws SQLException {
    ArrayList<ViewMtInventory> result = new ArrayList<ViewMtInventory>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ViewMtInventory> selectByItemTime(String item) throws SQLException {
    ArrayList<ViewMtInventory> result = new ArrayList<ViewMtInventory>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE item_bo =? and state_name= 'PICK' and available_time > '2021-04-10 16:00:00' ORDER BY available_time ")) {
      ps.setString(1, item);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ViewMtInventory selectByPK(String inventoryBo) throws SQLException {
    ViewMtInventory result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE inventory_bo=?")) {
      ps.setString(1, inventoryBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ViewMtInventory convert(ResultSet rs) throws SQLException {
    ViewMtInventory data = new ViewMtInventory();

    int index = 1;
    data.setInventoryBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setPickedCount(rs.getInt(index++));
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

    return data;
  }
}
