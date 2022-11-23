package ame.psb.db.dao;

import ame.psb.db.InventoryUseqty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class InventoryUseqtyDao {

  private static final String SQL_INS = "INSERT INTO zr_inventory_useqty(inventory_bo,use_qty,update_user,update_time,update_log) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_inventory_useqty SET use_qty=?,update_user=?,update_time=?,update_log=? WHERE inventory_bo=?";

  private static final String SQL_SEL = "SELECT inventory_bo,use_qty,update_user,update_time,update_log FROM zr_inventory_useqty ";

  private final Connection conn;

  public InventoryUseqtyDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(InventoryUseqty data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getInventoryBo());
      ps.setBigDecimal(2, data.getUseQty());
      ps.setString(3, data.getUpdateUser());
      DateUtils.setDateTz(ps, 4, data.getUpdateTime());
      ps.setString(5, data.getUpdateLog());

      return ps.executeUpdate();
    }
  }

  public int insert(List<InventoryUseqty> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (InventoryUseqty data : dataList) {
        ps.setString(1, data.getInventoryBo());
        ps.setBigDecimal(2, data.getUseQty());
        ps.setString(3, data.getUpdateUser());
        DateUtils.setDateTz(ps, 4, data.getUpdateTime());
        ps.setString(5, data.getUpdateLog());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(InventoryUseqty data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getUseQty());
      ps.setString(2, data.getUpdateUser());
      DateUtils.setDateTz(ps, 3, data.getUpdateTime());
      ps.setString(4, data.getUpdateLog());
      ps.setString(5, data.getInventoryBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<InventoryUseqty> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (InventoryUseqty data : dataList) {
        ps.setBigDecimal(1, data.getUseQty());
        ps.setString(2, data.getUpdateUser());
        DateUtils.setDateTz(ps, 3, data.getUpdateTime());
        ps.setString(4, data.getUpdateLog());
        ps.setString(5, data.getInventoryBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String inventoryBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_inventory_useqty WHERE inventory_bo=?")) {
      ps.setString(1, inventoryBo);

      return ps.executeUpdate();
    }
  }

  public List<InventoryUseqty> selectAll() throws SQLException {
    ArrayList<InventoryUseqty> result = new ArrayList<InventoryUseqty>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public InventoryUseqty selectByPK(String inventoryBo) throws SQLException {
    InventoryUseqty result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE inventory_bo=?")) {
      ps.setString(1, inventoryBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private InventoryUseqty convert(ResultSet rs) throws SQLException {
    InventoryUseqty data = new InventoryUseqty();

    int index = 1;
    data.setInventoryBo(rs.getString(index++));
    data.setUseQty(rs.getBigDecimal(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setUpdateLog(rs.getString(index++));

    return data;
  }
}
