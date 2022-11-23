package ame.psb.db.dao;

import ame.psb.db.InventoryFcPrint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryFcPrintDao {

  private static final String SQL_INS = "INSERT INTO zd_inventory_fc_print(item_id,item_name,item_qty,rewarm_time,end_time,print_id,label_id,spc_name,mod_name) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_inventory_fc_print SET item_name=?,item_qty=?,rewarm_time=?,end_time=?,print_id=?,label_id=?,spc_name=?,mod_name=? WHERE item_id=?";

  private static final String SQL_SEL = "SELECT item_id,item_name,item_qty,rewarm_time,end_time,print_id,label_id,spc_name,mod_name FROM zd_inventory_fc_print ";

  private final Connection conn;

  public InventoryFcPrintDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(InventoryFcPrint data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemId());
      ps.setString(2, data.getItemName());
      ps.setBigDecimal(3, data.getItemQty());
      ps.setString(4, data.getRewarmTime());
      ps.setString(5, data.getEndTime());
      ps.setString(6, data.getPrintId());
      ps.setString(7, data.getLabelId());
      ps.setString(8, data.getSpcName());
      ps.setString(9, data.getModName());

      return ps.executeUpdate();
    }
  }

  public int insert(List<InventoryFcPrint> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (InventoryFcPrint data : dataList) {
        ps.setString(1, data.getItemId());
        ps.setString(2, data.getItemName());
        ps.setBigDecimal(3, data.getItemQty());
        ps.setString(4, data.getRewarmTime());
        ps.setString(5, data.getEndTime());
        ps.setString(6, data.getPrintId());
        ps.setString(7, data.getLabelId());
        ps.setString(8, data.getSpcName());
        ps.setString(9, data.getModName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(InventoryFcPrint data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemName());
      ps.setBigDecimal(2, data.getItemQty());
      ps.setString(3, data.getRewarmTime());
      ps.setString(4, data.getEndTime());
      ps.setString(5, data.getPrintId());
      ps.setString(6, data.getLabelId());
      ps.setString(7, data.getSpcName());
      ps.setString(8, data.getModName());
      ps.setString(9, data.getItemId());

      return ps.executeUpdate();
    }
  }

  public int update(List<InventoryFcPrint> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (InventoryFcPrint data : dataList) {
        ps.setString(1, data.getItemName());
        ps.setBigDecimal(2, data.getItemQty());
        ps.setString(3, data.getRewarmTime());
        ps.setString(4, data.getEndTime());
        ps.setString(5, data.getPrintId());
        ps.setString(6, data.getLabelId());
        ps.setString(7, data.getSpcName());
        ps.setString(8, data.getModName());
        ps.setString(9, data.getItemId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_inventory_fc_print WHERE item_id=?")) {
      ps.setString(1, itemId);

      return ps.executeUpdate();
    }
  }

  public List<InventoryFcPrint> selectAll() throws SQLException {
    ArrayList<InventoryFcPrint> result = new ArrayList<InventoryFcPrint>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public InventoryFcPrint selectByPK(String itemId) throws SQLException {
    InventoryFcPrint result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE item_id=?")) {
      ps.setString(1, itemId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private InventoryFcPrint convert(ResultSet rs) throws SQLException {
    InventoryFcPrint data = new InventoryFcPrint();

    int index = 1;
    data.setItemId(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setItemQty(rs.getBigDecimal(index++));
    data.setRewarmTime(rs.getString(index++));
    data.setEndTime(rs.getString(index++));
    data.setPrintId(rs.getString(index++));
    data.setLabelId(rs.getString(index++));
    data.setSpcName(rs.getString(index++));
    data.setModName(rs.getString(index++));

    return data;
  }
}
