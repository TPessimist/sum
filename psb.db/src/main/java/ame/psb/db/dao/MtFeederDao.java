package ame.psb.db.dao;

import ame.psb.db.MtFeeder;
import ame.psb.db.ViewMtFeeder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class MtFeederDao {

  private static final String SQL_INS = "INSERT INTO zd_mt_feeder(id,inventory_bo,feed_qty,available_qty,created_time,created_user,resource_bo,slot_name,valid_to,qty_strict,sub_resource_bo,install_time,add_time,life_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_mt_feeder SET inventory_bo=?,feed_qty=?,available_qty=?,created_time=?,created_user=?,resource_bo=?,slot_name=?,valid_to=?,qty_strict=?,sub_resource_bo=?,install_time=?,add_time=?,life_time = ? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,inventory_bo,feed_qty,available_qty,created_time,created_user,resource_bo,slot_name,valid_to,qty_strict,slot_type,slot_state_name,site,inventory_id,item_bo,item_name,item_revision,item_group_bo,item_description,sub_resource_bo,install_time,add_time, life_time FROM view_mt_feeder ";

  private final Connection conn;

  public MtFeederDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(MtFeeder data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getInventoryBo());
      ps.setBigDecimal(3, data.getFeedQty());
      ps.setBigDecimal(4, data.getAvailableQty());
      DateUtils.setDateTz(ps, 5, data.getCreatedTime());
      ps.setString(6, data.getCreatedUser());
      ps.setString(7, data.getResourceBo());
      ps.setString(8, data.getSlotName());
      DateUtils.setDateTz(ps, 9, data.getValidTo());
      ps.setString(10, data.getQtyStrict());
      ps.setString(11, data.getSubResourceBo());
      DateUtils.setDateTz(ps, 12, data.getInstallTime());
      DateUtils.setDateTz(ps, 13, data.getAddTime());
      DateUtils.setDateTz(ps, 14, data.getLifeTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<MtFeeder> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (MtFeeder data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getInventoryBo());
        ps.setBigDecimal(3, data.getFeedQty());
        ps.setBigDecimal(4, data.getAvailableQty());
        DateUtils.setDateTz(ps, 5, data.getCreatedTime());
        ps.setString(6, data.getCreatedUser());
        ps.setString(7, data.getResourceBo());
        ps.setString(8, data.getSlotName());
        DateUtils.setDateTz(ps, 9, data.getValidTo());
        ps.setString(10, data.getQtyStrict());
        ps.setString(11, data.getSubResourceBo());
        DateUtils.setDateTz(ps, 12, data.getInstallTime());
        DateUtils.setDateTz(ps, 13, data.getAddTime());
        DateUtils.setDateTz(ps, 14, data.getLifeTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(MtFeeder data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getInventoryBo());
      ps.setBigDecimal(2, data.getFeedQty());
      ps.setBigDecimal(3, data.getAvailableQty());
      DateUtils.setDateTz(ps, 4, data.getCreatedTime());
      ps.setString(5, data.getCreatedUser());
      ps.setString(6, data.getResourceBo());
      ps.setString(7, data.getSlotName());
      DateUtils.setDateTz(ps, 8, data.getValidTo());
      ps.setString(9, data.getQtyStrict());
      ps.setString(10, data.getSubResourceBo());
      DateUtils.setDateTz(ps, 11, data.getInstallTime());
      DateUtils.setDateTz(ps, 12, data.getAddTime());
      DateUtils.setDateTz(ps, 13, data.getLifeTime());
      ps.setString(14, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<MtFeeder> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (MtFeeder data : dataList) {
        ps.setString(1, data.getInventoryBo());
        ps.setBigDecimal(2, data.getFeedQty());
        ps.setBigDecimal(3, data.getAvailableQty());
        DateUtils.setDateTz(ps, 4, data.getCreatedTime());
        ps.setString(5, data.getCreatedUser());
        ps.setString(6, data.getResourceBo());
        ps.setString(7, data.getSlotName());
        DateUtils.setDateTz(ps, 8, data.getValidTo());
        ps.setString(9, data.getQtyStrict());
        ps.setString(10, data.getSubResourceBo());
        DateUtils.setDateTz(ps, 11, data.getInstallTime());
        DateUtils.setDateTz(ps, 12, data.getAddTime());
        DateUtils.setDateTz(ps, 13, data.getLifeTime());
        ps.setString(14, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_mt_feeder WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ViewMtFeeder> selectByResource(String resourceBo) throws SQLException {
    ArrayList<ViewMtFeeder> result = new ArrayList<ViewMtFeeder>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? ORDER BY slot_name,created_time,id")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ViewMtFeeder> selectByFcSlot(String resourceBo) throws SQLException {
    ArrayList<ViewMtFeeder> result = new ArrayList<ViewMtFeeder>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? ORDER BY created_time desc")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewMtFeeder> selectByResourceItem(String resourceBo, String itemBo)
      throws SQLException {
    ArrayList<ViewMtFeeder> result = new ArrayList<ViewMtFeeder>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE resource_bo=? AND item_bo=? ORDER BY slot_name,created_time,id")) {
      ps.setString(1, resourceBo);
      ps.setString(2, itemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewMtFeeder selectIgnoreSlot(String resourceBo, String inventoryBo) throws SQLException {
    ViewMtFeeder result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE resource_bo=? AND inventory_bo=? AND slot_name is null ORDER BY created_time,id")) {
      ps.setString(1, resourceBo);
      ps.setString(2, inventoryBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewMtFeeder> selectByResourceBoAndInventoryBo(String resourceBo, String inventoryBo) throws SQLException {
    List<ViewMtFeeder> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE resource_bo=? AND inventory_bo=?  ORDER BY created_time,id")) {
      ps.setString(1, resourceBo);
      ps.setString(2, inventoryBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewMtFeeder selectBySlot(String resourceBo, String inventoryBo, String slotName)
      throws SQLException {
    ViewMtFeeder result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE resource_bo=? AND inventory_bo=? AND slot_name=? ORDER BY created_time,id")) {
      ps.setString(1, resourceBo);
      ps.setString(2, inventoryBo);
      ps.setString(3, slotName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewMtFeeder selectBySlot(String resourceBo, String slotName) throws SQLException {
    ViewMtFeeder result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE resource_bo=? AND slot_name=? ORDER BY created_time,id")) {
      ps.setString(1, resourceBo);
      ps.setString(2, slotName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewMtFeeder> selectBySlot(String slotBo) throws SQLException {
    ArrayList<ViewMtFeeder> result = new ArrayList<ViewMtFeeder>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE slot_name=? ORDER BY created_time,id")) {
      ps.setString(1, slotBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewMtFeeder selectByPK(String id) throws SQLException {
    ViewMtFeeder result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewMtFeeder selectByInventoryBo(String inventoryBo) throws SQLException {
    ViewMtFeeder result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE INVENTORY_BO=?")) {
      ps.setString(1, inventoryBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  private ViewMtFeeder convert(ResultSet rs) throws SQLException {
    ViewMtFeeder data = new ViewMtFeeder();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setInventoryBo(rs.getString(index++));
    data.setFeedQty(rs.getBigDecimal(index++));
    data.setAvailableQty(rs.getBigDecimal(index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));
    data.setCreatedUser(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setSlotName(rs.getString(index++));
    data.setValidTo(DateUtils.getDateTz(rs, index++));
    data.setQtyStrict(rs.getString(index++));

    data.setSlotType(rs.getString(index++));
    data.setSlotStateName(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setInventoryId(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setItemRevision(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setItemDescription(rs.getString(index++));
    data.setSubResourceBo(rs.getString(index++));

    data.setInstallTime(DateUtils.getDateTz(rs, index++));
    data.setAddTime(DateUtils.getDateTz(rs, index++));
    data.setLifeTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
