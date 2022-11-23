package ame.psb.db.dao;

import ame.psb.db.ResourceToolControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ResourceToolControlDao {

  private static final String SQL_INS = "INSERT INTO zr_resource_tool_control(inventory_bo,resource_slot_id,resource_bo,type,state,updated_user,updated_time,reverse_field2) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_resource_tool_control SET resource_slot_id=?,resource_bo=?,type=?,state=?,updated_user=?,updated_time=?,reverse_field2=? WHERE inventory_bo=?";

  private static final String SQL_SEL = "SELECT inventory_bo,resource_slot_id,resource_bo,type,state,updated_user,updated_time,reverse_field2 FROM zr_resource_tool_control ";

  private final Connection conn;

  public ResourceToolControlDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ResourceToolControl data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getInventoryBo());
      ps.setString(2, data.getResourceSlotId());
      ps.setString(3, data.getResourceBo());
      ps.setString(4, data.getType());
      ps.setString(5, data.getState());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getReverseField2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ResourceToolControl> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ResourceToolControl data : dataList) {
        ps.setString(1, data.getInventoryBo());
        ps.setString(2, data.getResourceSlotId());
        ps.setString(3, data.getResourceBo());
        ps.setString(4, data.getType());
        ps.setString(5, data.getState());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getReverseField2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ResourceToolControl data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceSlotId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getType());
      ps.setString(4, data.getState());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getReverseField2());
      ps.setString(8, data.getInventoryBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ResourceToolControl> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ResourceToolControl data : dataList) {
        ps.setString(1, data.getResourceSlotId());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getType());
        ps.setString(4, data.getState());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getReverseField2());
        ps.setString(8, data.getInventoryBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String inventoryBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_resource_tool_control WHERE inventory_bo=?")) {
      ps.setString(1, inventoryBo);

      return ps.executeUpdate();
    }
  }

  public List<ResourceToolControl> selectAll() throws SQLException {
    ArrayList<ResourceToolControl> result = new ArrayList<ResourceToolControl>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ResourceToolControl selectByPK(String inventoryBo) throws SQLException {
    ResourceToolControl result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE inventory_bo=?")) {
      ps.setString(1, inventoryBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ResourceToolControl selectByInventory(String inventoryBo, String state)
      throws SQLException {
    ResourceToolControl result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE inventory_bo=? and state= ? ")) {
      ps.setString(1, inventoryBo);
      ps.setString(2, state);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ResourceToolControl convert(ResultSet rs) throws SQLException {
    ResourceToolControl data = new ResourceToolControl();

    int index = 1;
    data.setInventoryBo(rs.getString(index++));
    data.setResourceSlotId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setType(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setReverseField2(rs.getString(index++));

    return data;
  }
}
