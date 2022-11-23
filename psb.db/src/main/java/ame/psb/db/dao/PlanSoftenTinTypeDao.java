package ame.psb.db.dao;

import ame.psb.db.PlanSoftenTinType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanSoftenTinTypeDao {

  private static final String SQL_INS = "INSERT INTO zd_plan_soften_tin_type(inventory_id,type,item_name,standards,suppiler,reversed1,reversed2) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_plan_soften_tin_type SET type=?,item_name=?,standards=?,suppiler=?,reversed1=?,reversed2=? WHERE inventory_id=?";

  private static final String SQL_SEL = "SELECT inventory_id,type,item_name,standards,suppiler,reversed1,reversed2 FROM zd_plan_soften_tin_type ";

  private final Connection conn;

  public PlanSoftenTinTypeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PlanSoftenTinType data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getInventoryId());
      ps.setString(2, data.getType());
      ps.setString(3, data.getItemName());
      ps.setString(4, data.getStandards());
      ps.setString(5, data.getSuppiler());
      ps.setString(6, data.getReversed1());
      ps.setString(7, data.getReversed2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PlanSoftenTinType> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PlanSoftenTinType data : dataList) {
        ps.setString(1, data.getInventoryId());
        ps.setString(2, data.getType());
        ps.setString(3, data.getItemName());
        ps.setString(4, data.getStandards());
        ps.setString(5, data.getSuppiler());
        ps.setString(6, data.getReversed1());
        ps.setString(7, data.getReversed2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PlanSoftenTinType data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getType());
      ps.setString(2, data.getItemName());
      ps.setString(3, data.getStandards());
      ps.setString(4, data.getSuppiler());
      ps.setString(5, data.getReversed1());
      ps.setString(6, data.getReversed2());
      ps.setString(7, data.getInventoryId());

      return ps.executeUpdate();
    }
  }

  public int update(List<PlanSoftenTinType> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PlanSoftenTinType data : dataList) {
        ps.setString(1, data.getType());
        ps.setString(2, data.getItemName());
        ps.setString(3, data.getStandards());
        ps.setString(4, data.getSuppiler());
        ps.setString(5, data.getReversed1());
        ps.setString(6, data.getReversed2());
        ps.setString(7, data.getInventoryId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String inventoryId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_plan_soften_tin_type WHERE inventory_id=?")) {
      ps.setString(1, inventoryId);

      return ps.executeUpdate();
    }
  }

  public List<PlanSoftenTinType> selectAll() throws SQLException {
    ArrayList<PlanSoftenTinType> result = new ArrayList<PlanSoftenTinType>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public PlanSoftenTinType selectByPK(String inventoryId) throws SQLException {
    PlanSoftenTinType result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE inventory_id=?")) {
      ps.setString(1, inventoryId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PlanSoftenTinType selectByType(String type) throws SQLException {
    PlanSoftenTinType result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE type=?")) {
      ps.setString(1, type);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PlanSoftenTinType convert(ResultSet rs) throws SQLException {
    PlanSoftenTinType data = new PlanSoftenTinType();

    int index = 1;
    data.setInventoryId(rs.getString(index++));
    data.setType(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setStandards(rs.getString(index++));
    data.setSuppiler(rs.getString(index++));
    data.setReversed1(rs.getString(index++));
    data.setReversed2(rs.getString(index++));

    return data;
  }
}
