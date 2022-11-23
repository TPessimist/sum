package ame.me.db.dao;

import ame.me.db.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {

  private static final String SQL_SEL = "SELECT " +
      "handle," +
      "change_stamp,site,item,description,status_bo," +
      "item_type,erp_gtin,eff_start_seq,eff_end_seq,lot_size,quantity_restriction," +
      "router_bo,bom_bo,component_group_bo,item_group_bo,last_released_date,assy_data_type_bo,pre_assembled,revision,current_revision,"
      +
      "eff_start_date,eff_end_date,selector_activity_bo,selector_note,assign_serial_at_release," +
      "created_date_time,modified_date_time," +
      "drawing_name,maximum_usage,use_comp_from_drawing,panel," +
      "removal_assy_data_type_bo,inv_assy_data_type_bo,original_status_bo,qty_multiplier," +
      "create_trackable_sfc,mask_group_bo,transfer_item_group_bo,unit_of_measure,hold_id," +
      "collect_parent_serial,req_serial_change,is_collector,inc_batch_number," +
      "time_sensitive,max_shelf_life,max_shelf_life_units,max_floor_life,max_floor_life_units,notes,tb_comp_type,"
      +
      "consumption_tol,erp_backflushing,storage_location_bo,erp_putaway_storloc,use_order_id_rel1 FROM item ";

  private Connection conn;

  public ItemDao(Connection conn) {
    this.conn = conn;
  }

  public Item selectByPK(String itemBo) throws SQLException {
    Item item = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE handle=? ")) {
      ps.setString(1, itemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public Item selectByItem(String itemName) throws SQLException {
    Item item = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE item = ? ")) {
      ps.setString(1, itemName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public List<Item> selectByPK1(String itemBo) throws SQLException {
    ArrayList<Item> result = new ArrayList<Item>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE item LIKE ? ")) {
      ps.setString(1, "%" + itemBo + "%");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public int updateItemGroupBoByPrimaryKeyItem(String bomBo, String item) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE item SET BOM_BO=? WHERE item=?")) {
      ps.setString(1, bomBo);
      ps.setString(2, item);
      return ps.executeUpdate();
    }
  }

  public int kissMyItemGroup(String handle, String itemGroupBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE item SET item_group_bo=? WHERE handle=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, handle);
      return ps.executeUpdate();
    }
  }

  public List<Item> selectByDeviceBo(String deviceBo) throws SQLException {
    List<Item> items = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE item_group_bo=? ")) {
      ps.setString(1, deviceBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(this.convert(rs));
      }
    }
    return items;
  }

  public int UpdateByHandle(String bomBo, String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE item SET BOM_BO =? WHERE handle=?")) {
      ps.setString(1, bomBo);
      ps.setString(2, handle);
      return ps.executeUpdate();
    }
  }

  public Item selectByName(String site, String itemName) throws SQLException {
    Item item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? AND item=? AND current_revision='true' ")) {
      ps.setString(1, site);
      ps.setString(2, itemName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }
  
  public Item selectByName(String site, String itemName, String revision) throws SQLException {
    Item item = null;
    if (revision == null || revision.trim().length() == 0) {
      return this.selectByName(site, itemName);
    }

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? AND item=? AND revision=? ")) {
      ps.setString(1, site);
      ps.setString(2, itemName);
      ps.setString(3, revision);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public List<Item> selectByNamePrefix(String site, String namePrefix) throws SQLException {
    ArrayList<Item> result = new ArrayList<Item>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? AND item LIKE ? ORDER BY item")) {
      ps.setString(1, site);
      ps.setString(2, namePrefix + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<Item> selectAll(String site) throws SQLException {
    ArrayList<Item> result = new ArrayList<Item>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? ORDER BY item")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<Item> selectByType(String site, String itemType) throws SQLException {
    ArrayList<Item> result = new ArrayList<Item>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? AND item_type=? ORDER BY item")) {
      ps.setString(1, site);
      ps.setString(2, itemType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<Item> selectByType(String site, String itemType, String namePrefix)
      throws SQLException {
    ArrayList<Item> result = new ArrayList<Item>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE site=? AND item_type=? AND item LIKE ? ORDER BY item")) {
      ps.setString(1, site);
      ps.setString(2, itemType);
      ps.setString(3, namePrefix + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<Item> selectManufactured(String site) throws SQLException {
    ArrayList<Item> result = new ArrayList<Item>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? AND item_type in ('M','B') ORDER BY item")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<Item> selectManufacturedByNamePrefix(String site, String namePrefix)
      throws SQLException {
    ArrayList<Item> result = new ArrayList<Item>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE site=? AND item_type in ('M','B') AND item LIKE ? ORDER BY item")) {
      ps.setString(1, site);
      ps.setString(2, namePrefix + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  private Item convert(ResultSet rs) throws SQLException {
    Item data = new Item();
    data.setHandle(rs.getString(1));
    data.setChangeStamp(rs.getInt(2));
    data.setSite(rs.getString(3));
    data.setItem(rs.getString(4));
    data.setDescription(rs.getString(5));
    data.setStatusBo(rs.getString(6));
    data.setItemType(rs.getString(7));
    data.setErpGtin(rs.getString(8));
    data.setEffStartSeq(rs.getInt(9));
    data.setEffEndSeq(rs.getInt(10));
    data.setLotSize(rs.getInt(11));
    data.setQuantityRestriction(rs.getString(12));
    data.setRouterBo(rs.getString(13));
    data.setBomBo(rs.getString(14));
    data.setComponentGroupBo(rs.getString(15));
    data.setItemGroupBo(rs.getString(16));
    data.setLastReleasedDate(rs.getTimestamp(17));
    data.setAssyDataTypeBo(rs.getString(18));
    data.setPreAssembled(rs.getString(19));
    data.setRevision(rs.getString(20));
    data.setCurrentRevision(rs.getString(21));
    data.setEffStartDate(rs.getTimestamp(22));
    data.setEffEndDate(rs.getTimestamp(23));
    data.setSelectorActivityBo(rs.getString(24));
    data.setSelectorNote(rs.getString(25));
    data.setAssignSerialAtRelease(rs.getString(26));
    data.setCreatedDateTime(rs.getTimestamp(27));
    data.setModifiedDateTime(rs.getTimestamp(28));
    data.setDrawingName(rs.getString(29));
    data.setMaximumUsage(rs.getInt(30));
    data.setUseCompFromDrawing(rs.getString(31));
    data.setPanel(rs.getString(32));
    data.setRemovalAssyDataTypeBo(rs.getString(33));
    data.setInvAssyDataTypeBo(rs.getString(34));
    data.setOriginalStatusBo(rs.getString(35));
    data.setQtyMultiplier(rs.getInt(36));
    data.setCreateTrackableSfc(rs.getString(37));
    data.setMaskGroupBo(rs.getString(38));
    data.setTransferItemGroupBo(rs.getString(39));
    data.setUnitOfMeasure(rs.getString(40));
    data.setHoldId(rs.getInt(41));
    data.setCollectParentSerial(rs.getString(42));
    data.setReqSerialChange(rs.getString(43));
    data.setIsCollector(rs.getString(44));
    data.setIncBatchNumber(rs.getString(45));
    data.setTimeSensitive(rs.getString(46));
    data.setMaxShelfLife(rs.getInt(47));
    data.setMaxShelfLifeUnits(rs.getString(48));
    data.setMaxFloorLife(rs.getInt(49));
    data.setMaxFloorLifeUnits(rs.getString(50));
    data.setNotes(rs.getString(51));
    data.setTbCompType(rs.getString(52));
    data.setConsumptionTol(rs.getInt(53));
    data.setErpBackflushing(rs.getString(54));
    data.setStorageLocationBo(rs.getString(55));
    data.setErpPutawayStorloc(rs.getString(56));
    data.setUseOrderIdRel1(rs.getString(57));
    return data;
  }
}
