package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.ZdInventory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZdInventoryDao {

  private static final String SQL_INS = "INSERT INTO zd_inventory(inventory_bo,type,state_name,resource_slot_id,parent_inventory_bo,picked_user,updated_user,updated_time,install_user,install_time,valid_to,resource) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_inventory SET type=?,state_name=?,resource_slot_id=?,parent_inventory_bo=?,picked_user=?,updated_user=?,updated_time=?,install_user=?,install_time=?,valid_to=?,resource=? WHERE inventory_bo=?";

  private static final String SQL_SEL = "SELECT inventory_bo,type,state_name,resource_slot_id,parent_inventory_bo,picked_user,updated_user,updated_time,install_user,install_time,valid_to,resource FROM zd_inventory ";

  private final Connection conn;

  public ZdInventoryDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdInventory data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getInventoryBo());
      ps.setString(2, data.getType());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getResourceSlotId());
      ps.setString(5, data.getParentInventoryBo());
      ps.setString(6, data.getPickedUser());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getInstallUser());
      DateUtils.setDateTz(ps, 10, data.getInstallTime());
      DateUtils.setDateTz(ps, 11, data.getValidTo());
      ps.setString(12, data.getResource());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdInventory> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdInventory data : dataList) {
        ps.setString(1, data.getInventoryBo());
        ps.setString(2, data.getType());
        ps.setString(3, data.getStateName());
        ps.setString(4, data.getResourceSlotId());
        ps.setString(5, data.getParentInventoryBo());
        ps.setString(6, data.getPickedUser());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getInstallUser());
        DateUtils.setDateTz(ps, 10, data.getInstallTime());
        DateUtils.setDateTz(ps, 11, data.getValidTo());
        ps.setString(12, data.getResource());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZdInventory data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getType());
      ps.setString(2, data.getStateName());
      ps.setString(3, data.getResourceSlotId());
      ps.setString(4, data.getParentInventoryBo());
      ps.setString(5, data.getPickedUser());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getInstallUser());
      DateUtils.setDateTz(ps, 9, data.getInstallTime());
      DateUtils.setDateTz(ps, 10, data.getValidTo());
      ps.setString(11, data.getResource());
      ps.setString(12, data.getInventoryBo());

      return ps.executeUpdate();
    }
  }

  public int update(ZdInventory data, Date lastUpdatedTime) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD + " and updated_time=?")) {
      ps.setString(1, data.getType());
      ps.setString(2, data.getStateName());
      ps.setString(3, data.getResourceSlotId());
      ps.setString(4, data.getParentInventoryBo());
      ps.setString(5, data.getPickedUser());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getInstallUser());
      DateUtils.setDateTz(ps, 9, data.getInstallTime());
      DateUtils.setDateTz(ps, 10, data.getValidTo());
      ps.setString(11, data.getResource());
      ps.setString(12, data.getInventoryBo());
      DateUtils.setDateTz(ps, 13, lastUpdatedTime);

      return ps.executeUpdate();
    }
  }

  public int update(List<ZdInventory> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZdInventory data : dataList) {
        ps.setString(1, data.getType());
        ps.setString(2, data.getStateName());
        ps.setString(3, data.getResourceSlotId());
        ps.setString(4, data.getParentInventoryBo());
        ps.setString(5, data.getPickedUser());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getInstallUser());
        DateUtils.setDateTz(ps, 9, data.getInstallTime());
        DateUtils.setDateTz(ps, 10, data.getValidTo());
        ps.setString(11, data.getResource());
        ps.setString(12, data.getInventoryBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String inventoryBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_inventory WHERE inventory_bo=?")) {
      ps.setString(1, inventoryBo);

      return ps.executeUpdate();
    }
  }

  public List<ZdInventory> selectAll() throws SQLException {
    ArrayList<ZdInventory> result = new ArrayList<ZdInventory>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ZdInventory> selectBySlotBo(String slotBo) throws SQLException {
    ArrayList<ZdInventory> result = new ArrayList<ZdInventory>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_slot_id=?")) {
      ps.setString(1, slotBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ZdInventory> selectByResource(String resource) throws SQLException {
    ArrayList<ZdInventory> result = new ArrayList<ZdInventory>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource=?")) {
      ps.setString(1, resource);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  /*
   * resource_slot_id
   * type:TOOLING
   * */
  public List<ZdInventory> selectByTypeAndSlotNo(String type, String slotBo, String stateName)
      throws SQLException {
    ArrayList<ZdInventory> result = new ArrayList<ZdInventory>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE type=? and resource_slot_id=? AND state_name=? ")) {
      ps.setString(1, type);
      ps.setString(2, slotBo);
      ps.setString(3, stateName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public ZdInventory selectByPK(String inventoryBo) throws SQLException {
    ZdInventory result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE inventory_bo=?")) {
      ps.setString(1, inventoryBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public List<ZdInventory> selectAnotherMaskId(String pattern) throws SQLException {
    ArrayList<ZdInventory> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE inventory_bo like ? ")) {
      ps.setString(1, pattern);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ZdInventory selectByIdAndState(String inventoryBo, String stateName) throws SQLException {
    ZdInventory result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE inventory_bo=? AND state_name=?")) {
      ps.setString(1, inventoryBo);
      ps.setString(2, stateName);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public List<ZdInventory> selectByPK2(String inventoryBo) throws SQLException {
    ArrayList<ZdInventory> result = new ArrayList<ZdInventory>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE inventory_bo=?")) {
      ps.setString(1, inventoryBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        ZdInventory carrier = this.convert(rs);
        carrier.setInventoryBo(Env.trimHandle(rs.getString(1)));
        carrier.setResourceSlotId(Env.trimHandle(rs.getString(4)));
        result.add(carrier);
      }
      return result;
    }
  }

  public List<ZdInventory> selectByType(String type, String stateName) throws SQLException {
    List<ZdInventory> result = new ArrayList<ZdInventory>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE type=? AND state_name=?")) {
      ps.setString(1, type);
      ps.setString(2, stateName);

      ps.setMaxRows(200);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ZdInventory> selectByType(String type) throws SQLException {
    List<ZdInventory> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE type=? ")) {
      ps.setString(1, type);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public ZdInventory selectByResourceSlot(String type, String stateName, String resourceSlot)
      throws SQLException {
    ZdInventory result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE type=? and state_name=? and resource_slot_id like ?")) {
      ps.setString(1, type);
      ps.setString(2, stateName);
      ps.setString(3, "%" + resourceSlot + "%");
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public List<ZdInventory> selectOnlineCarriers() throws SQLException {
    List<ZdInventory> result = new ArrayList<ZdInventory>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE type='FOUP' AND state_name='USING' AND resource_slot_id is not null")) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  private ZdInventory convert(ResultSet rs) throws SQLException {
    ZdInventory data = new ZdInventory();

    int index = 1;
    data.setInventoryBo(rs.getString(index++));
    data.setType(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setResourceSlotId(rs.getString(index++));
    data.setParentInventoryBo(rs.getString(index++));
    data.setPickedUser(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setInstallUser(rs.getString(index++));
    data.setInstallTime(DateUtils.getDateTz(rs, index++));
    data.setValidTo(DateUtils.getDateTz(rs, index++));
    data.setResource(rs.getString(index++));

    return data;
  }
}
