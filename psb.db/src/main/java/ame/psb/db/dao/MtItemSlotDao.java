package ame.psb.db.dao;

import ame.psb.db.MtItemSlot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MtItemSlotDao {

  private static final String SQL_INS = "INSERT INTO zd_mt_item_slot(item_bo,resource_bo,slot_name,inventory_max,state_name) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_mt_item_slot SET inventory_max=?,state_name=? WHERE item_bo=? AND resource_bo=? AND slot_name=?";

  private static final String SQL_SEL = "SELECT item_bo,resource_bo,slot_name,inventory_max,state_name FROM zd_mt_item_slot ";

  private final Connection conn;

  public MtItemSlotDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(MtItemSlot data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemBo());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getSlotName());
      ps.setInt(4, data.getInventoryMax());
      ps.setString(5, data.getStateName());

      return ps.executeUpdate();
    }
  }

  public int insert(List<MtItemSlot> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (MtItemSlot data : dataList) {
        ps.setString(1, data.getItemBo());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getSlotName());
        ps.setInt(4, data.getInventoryMax());
        ps.setString(5, data.getStateName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(MtItemSlot data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getInventoryMax());
      ps.setString(2, data.getStateName());
      ps.setString(3, data.getItemBo());
      ps.setString(4, data.getResourceBo());
      ps.setString(5, data.getSlotName());

      return ps.executeUpdate();
    }
  }

  public int update(List<MtItemSlot> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (MtItemSlot data : dataList) {
        ps.setInt(1, data.getInventoryMax());
        ps.setString(2, data.getStateName());
        ps.setString(3, data.getItemBo());
        ps.setString(4, data.getResourceBo());
        ps.setString(5, data.getSlotName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemBo, String resourceBo, String slotName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_mt_item_slot WHERE item_bo=? AND resource_bo=? AND slot_name=?")) {
      ps.setString(1, itemBo);
      ps.setString(2, resourceBo);
      ps.setString(3, slotName);

      return ps.executeUpdate();
    }
  }

  public List<MtItemSlot> selectAll() throws SQLException {
    ArrayList<MtItemSlot> result = new ArrayList<MtItemSlot>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public MtItemSlot selectByPK(String itemBo, String resourceBo, String slotName)
      throws SQLException {
    MtItemSlot result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_bo=? AND resource_bo=? AND slot_name=?")) {
      ps.setString(1, itemBo);
      ps.setString(2, resourceBo);
      ps.setString(3, slotName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private MtItemSlot convert(ResultSet rs) throws SQLException {
    MtItemSlot data = new MtItemSlot();

    int index = 1;
    data.setItemBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setSlotName(rs.getString(index++));
    data.setInventoryMax(rs.getInt(index++));
    data.setStateName(rs.getString(index++));

    return data;
  }
}
