package ame.psb.db.dao;

import ame.psb.db.InventoryAssyData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryAssyDataDao {

  private static final String SQL_INS = "INSERT INTO inventory_assy_data(handle,inventory_bo,sequence,data_field,data_attr) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE inventory_assy_data SET inventory_bo=?,sequence=?,data_field=?,data_attr=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,inventory_bo,sequence,data_field,data_attr FROM inventory_assy_data ";

  private final Connection conn;

  public InventoryAssyDataDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(InventoryAssyData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getInventoryBo());
      ps.setBigDecimal(3, data.getSequence());
      ps.setString(4, data.getDataField());
      ps.setString(5, data.getDataAttr());

      return ps.executeUpdate();
    }
  }

  public int insert(List<InventoryAssyData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (InventoryAssyData data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getInventoryBo());
        ps.setBigDecimal(3, data.getSequence());
        ps.setString(4, data.getDataField());
        ps.setString(5, data.getDataAttr());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(InventoryAssyData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getInventoryBo());
      ps.setBigDecimal(2, data.getSequence());
      ps.setString(3, data.getDataField());
      ps.setString(4, data.getDataAttr());
      ps.setString(5, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<InventoryAssyData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (InventoryAssyData data : dataList) {
        ps.setString(1, data.getInventoryBo());
        ps.setBigDecimal(2, data.getSequence());
        ps.setString(3, data.getDataField());
        ps.setString(4, data.getDataAttr());
        ps.setString(5, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM inventory_assy_data WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<InventoryAssyData> selectAll() throws SQLException {
    ArrayList<InventoryAssyData> result = new ArrayList<InventoryAssyData>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<InventoryAssyData> selectById(String inventory) throws SQLException {
    ArrayList<InventoryAssyData> result = new ArrayList<InventoryAssyData>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE inventory_bo=?")) {
      ps.setString(1, inventory);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public InventoryAssyData selectBySeq(String inventory) throws SQLException {
    InventoryAssyData result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE inventory_bo=? order by sequence desc")) {
      ps.setString(1, inventory);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public InventoryAssyData selectByPK(String handle) throws SQLException {
    InventoryAssyData result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public InventoryAssyData selectBy(String inventory, String field) throws SQLException {
    InventoryAssyData result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE inventory_bo=? AND data_field=?")) {
      ps.setString(1, inventory);
      ps.setString(2, field);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private InventoryAssyData convert(ResultSet rs) throws SQLException {
    InventoryAssyData data = new InventoryAssyData();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setInventoryBo(rs.getString(index++));
    data.setSequence(rs.getBigDecimal(index++));
    data.setDataField(rs.getString(index++));
    data.setDataAttr(rs.getString(index++));

    return data;
  }
}
