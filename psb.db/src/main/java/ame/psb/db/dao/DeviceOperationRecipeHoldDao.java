package ame.psb.db.dao;

import ame.psb.db.DeviceOperationRecipeHold;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class DeviceOperationRecipeHoldDao {

  private static final String SQL_INS = "INSERT INTO zd_device_operation_recipe_hold(item_group_bo,operation_bo,count,dc_count,updated_time,updated_user) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_device_operation_recipe_hold SET count=?,dc_count=?,updated_time=?,updated_user=? WHERE item_group_bo=? AND operation_bo=?";

  private static final String SQL_SEL = "SELECT item_group_bo,operation_bo,count,dc_count,updated_time,updated_user FROM zd_device_operation_recipe_hold ";

  private final Connection conn;

  public DeviceOperationRecipeHoldDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DeviceOperationRecipeHold data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getOperationBo());
      ps.setInt(3, data.getCount());
      ps.setInt(4, data.getDcCount());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getUpdatedUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DeviceOperationRecipeHold> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DeviceOperationRecipeHold data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getOperationBo());
        ps.setInt(3, data.getCount());
        ps.setInt(4, data.getDcCount());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getUpdatedUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DeviceOperationRecipeHold data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getCount());
      ps.setInt(2, data.getDcCount());
      DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
      ps.setString(4, data.getUpdatedUser());
      ps.setString(5, data.getItemGroupBo());
      ps.setString(6, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<DeviceOperationRecipeHold> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DeviceOperationRecipeHold data : dataList) {
        ps.setInt(1, data.getCount());
        ps.setInt(2, data.getDcCount());
        DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
        ps.setString(4, data.getUpdatedUser());
        ps.setString(5, data.getItemGroupBo());
        ps.setString(6, data.getOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemGroupBo, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_device_operation_recipe_hold WHERE item_group_bo=? AND operation_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      return ps.executeUpdate();
    }
  }

  public List<DeviceOperationRecipeHold> selectAll() throws SQLException {
    ArrayList<DeviceOperationRecipeHold> result = new ArrayList<DeviceOperationRecipeHold>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public DeviceOperationRecipeHold selectByPK(String itemGroupBo, String operationBo)
      throws SQLException {
    DeviceOperationRecipeHold result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? AND operation_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private DeviceOperationRecipeHold convert(ResultSet rs) throws SQLException {
    DeviceOperationRecipeHold data = new DeviceOperationRecipeHold();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setCount(rs.getInt(index++));
    data.setDcCount(rs.getInt(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));

    return data;
  }
}
