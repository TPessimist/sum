package ame.psb.db.dao;

import ame.psb.db.InventoryResourcePosition;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class InventoryResourcePositionDao {

  private static final String SQL_INS = "INSERT INTO zd_inventory_resource_position(inventory_id,resource_slot_id,source_type,updated_user,updated_time) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_inventory_resource_position SET resource_slot_id=?,source_type=?,updated_user=?,updated_time=? WHERE inventory_id=?";

  private static final String SQL_SEL = "SELECT inventory_id,resource_slot_id,source_type,updated_user,updated_time FROM zd_inventory_resource_position ";

  private final Connection conn;

  public InventoryResourcePositionDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(InventoryResourcePosition data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getInventoryId());
      ps.setString(2, data.getResourceSlotId());
      ps.setString(3, data.getSourceType());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<InventoryResourcePosition> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (InventoryResourcePosition data : dataList) {
        ps.setString(1, data.getInventoryId());
        ps.setString(2, data.getResourceSlotId());
        ps.setString(3, data.getSourceType());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(InventoryResourcePosition data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceSlotId());
      ps.setString(2, data.getSourceType());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getInventoryId());

      return ps.executeUpdate();
    }
  }

  public int update(List<InventoryResourcePosition> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (InventoryResourcePosition data : dataList) {
        ps.setString(1, data.getResourceSlotId());
        ps.setString(2, data.getSourceType());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getInventoryId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String inventoryId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_inventory_resource_position WHERE inventory_id=?")) {
      ps.setString(1, inventoryId);

      return ps.executeUpdate();
    }
  }

  public List<InventoryResourcePosition> selectAll() throws SQLException {
    ArrayList<InventoryResourcePosition> result = new ArrayList<InventoryResourcePosition>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public InventoryResourcePosition selectByPK(String inventoryId) throws SQLException {
    InventoryResourcePosition result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE inventory_id=?")) {
      ps.setString(1, inventoryId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public InventoryResourcePosition selectByPosition(String position) throws SQLException {
    InventoryResourcePosition result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_slot_id=?")) {
      ps.setString(1, position);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private InventoryResourcePosition convert(ResultSet rs) throws SQLException {
    InventoryResourcePosition data = new InventoryResourcePosition();

    int index = 1;
    data.setInventoryId(rs.getString(index++));
    data.setResourceSlotId(rs.getString(index++));
    data.setSourceType(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
