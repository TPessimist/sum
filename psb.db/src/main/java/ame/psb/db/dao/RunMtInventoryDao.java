package ame.psb.db.dao;

import ame.psb.db.RunMtInventory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunMtInventoryDao {

  private static final String SQL_INS = "INSERT INTO zr_mt_inventory(id,inventory_bo,action_name,count,valid_from,valid_to,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_mt_inventory SET inventory_bo=?,action_name=?,count=?,valid_from=?,valid_to=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,inventory_bo,action_name,count,valid_from,valid_to,updated_user,updated_time FROM zr_mt_inventory ";

  private final Connection conn;

  public RunMtInventoryDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunMtInventory data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getInventoryBo());
      ps.setString(3, data.getActionName());
      ps.setBigDecimal(4, data.getCount());
      DateUtils.setDateTz(ps, 5, data.getValidFrom());
      DateUtils.setDateTz(ps, 6, data.getValidTo());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunMtInventory> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunMtInventory data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getInventoryBo());
        ps.setString(3, data.getActionName());
        ps.setBigDecimal(4, data.getCount());
        DateUtils.setDateTz(ps, 5, data.getValidFrom());
        DateUtils.setDateTz(ps, 6, data.getValidTo());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunMtInventory data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getInventoryBo());
      ps.setString(2, data.getActionName());
      ps.setBigDecimal(3, data.getCount());
      DateUtils.setDateTz(ps, 3, data.getValidFrom());
      DateUtils.setDateTz(ps, 5, data.getValidTo());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunMtInventory> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunMtInventory data : dataList) {
        ps.setString(1, data.getInventoryBo());
        ps.setString(2, data.getActionName());
        ps.setBigDecimal(3, data.getCount());
        DateUtils.setDateTz(ps, 3, data.getValidFrom());
        DateUtils.setDateTz(ps, 5, data.getValidTo());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_mt_inventory WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<RunMtInventory> selectAll() throws SQLException {
    ArrayList<RunMtInventory> result = new ArrayList<RunMtInventory>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public RunMtInventory selectByPK(String id) throws SQLException {
    RunMtInventory result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private RunMtInventory convert(ResultSet rs) throws SQLException {
    RunMtInventory data = new RunMtInventory();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setInventoryBo(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setCount(rs.getBigDecimal(index++));
    data.setValidFrom(DateUtils.getDateTz(rs, index++));
    data.setValidTo(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
