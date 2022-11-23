package ame.psb.db.dao;

import ame.psb.db.ZhMappingrecipeBom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZhMappingrecipeBomDao {

  private static final String SQL_INS = "INSERT INTO zh_mapping_recipe_bom(recipe,materiel,materiel_name,material_specifications,modle,consume_inch8,consume_inch12,wastage,unit,operation_hint,material_properties) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_mapping_recipe_bom SET materiel_name=?,material_specifications=?,modle=?,consume_inch8=?,consume_inch12=?,wastage=?,unit=?,material_properties=? WHERE recipe=? AND materiel=? AND operation_hint=?";

  private static final String SQL_SEL = "SELECT recipe,materiel,materiel_name,material_specifications,modle,consume_inch8,consume_inch12,wastage,unit,operation_hint,material_properties FROM zh_mapping_recipe_bom ";

  private final Connection conn;

  public ZhMappingrecipeBomDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZhMappingrecipeBom data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getRecipe());
      ps.setString(2, data.getMateriel());
      ps.setString(3, data.getMaterielName());
      ps.setString(4, data.getMaterialSpecifications());
      ps.setString(5, data.getModle());
      ps.setString(6, data.getConsumeInch8());
      ps.setString(7, data.getConsumeInch12());
      ps.setString(8, data.getWastage());
      ps.setString(9, data.getUnit());
      ps.setString(10, data.getOperationHint());
      ps.setString(11, data.getMaterialProperties());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZhMappingrecipeBom> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZhMappingrecipeBom data : dataList) {
        ps.setString(1, data.getRecipe());
        ps.setString(2, data.getMateriel());
        ps.setString(3, data.getMaterielName());
        ps.setString(4, data.getMaterialSpecifications());
        ps.setString(5, data.getModle());
        ps.setString(6, data.getConsumeInch8());
        ps.setString(7, data.getConsumeInch12());
        ps.setString(8, data.getWastage());
        ps.setString(9, data.getUnit());
        ps.setString(10, data.getOperationHint());
        ps.setString(11, data.getMaterialProperties());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZhMappingrecipeBom data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getMaterielName());
      ps.setString(2, data.getMaterialSpecifications());
      ps.setString(3, data.getModle());
      ps.setString(4, data.getConsumeInch8());
      ps.setString(5, data.getConsumeInch12());
      ps.setString(6, data.getWastage());
      ps.setString(7, data.getUnit());
      ps.setString(8, data.getMaterialProperties());
      ps.setString(9, data.getRecipe());
      ps.setString(10, data.getMateriel());
      ps.setString(11, data.getOperationHint());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZhMappingrecipeBom> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZhMappingrecipeBom data : dataList) {
        ps.setString(1, data.getMaterielName());
        ps.setString(2, data.getMaterialSpecifications());
        ps.setString(3, data.getModle());
        ps.setString(4, data.getConsumeInch8());
        ps.setString(5, data.getConsumeInch12());
        ps.setString(6, data.getWastage());
        ps.setString(7, data.getUnit());
        ps.setString(8, data.getMaterialProperties());
        ps.setString(9, data.getRecipe());
        ps.setString(10, data.getMateriel());
        ps.setString(11, data.getOperationHint());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String recipe, String materiel, String operationHint) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zh_mapping_recipe_bom WHERE recipe=? AND materiel=? AND operation_hint=?")) {
      ps.setString(1, recipe);
      ps.setString(2, materiel);
      ps.setString(3, operationHint);

      return ps.executeUpdate();
    }
  }

  public List<ZhMappingrecipeBom> selectByOperationAndRecipe(String Operation, String recipe)
      throws SQLException {
    ArrayList<ZhMappingrecipeBom> result = new ArrayList<ZhMappingrecipeBom>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where OPERATION_HINT = ? and RECIPE = ? ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZhMappingrecipeBom> selectAll() throws SQLException {
    ArrayList<ZhMappingrecipeBom> result = new ArrayList<ZhMappingrecipeBom>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ZhMappingrecipeBom selectByPK(String recipe, String materiel, String operationHint)
      throws SQLException {
    ZhMappingrecipeBom result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE recipe=? AND materiel=? AND operation_hint=?")) {
      ps.setString(1, recipe);
      ps.setString(2, materiel);
      ps.setString(3, operationHint);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZhMappingrecipeBom convert(ResultSet rs) throws SQLException {
    ZhMappingrecipeBom data = new ZhMappingrecipeBom();

    int index = 1;
    data.setRecipe(rs.getString(index++));
    data.setMateriel(rs.getString(index++));
    data.setMaterielName(rs.getString(index++));
    data.setMaterialSpecifications(rs.getString(index++));
    data.setModle(rs.getString(index++));
    data.setConsumeInch8(rs.getString(index++));
    data.setConsumeInch12(rs.getString(index++));
    data.setWastage(rs.getString(index++));
    data.setUnit(rs.getString(index++));
    data.setOperationHint(rs.getString(index++));
    data.setMaterialProperties(rs.getString(index++));

    return data;
  }
}
