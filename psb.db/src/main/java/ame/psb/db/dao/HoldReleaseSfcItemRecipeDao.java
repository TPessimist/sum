package ame.psb.db.dao;

import ame.psb.db.HoldReleaseSfcItemRecipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoldReleaseSfcItemRecipeDao {

  private static final String SQL_INS = "INSERT INTO zr_hold_release_sfc_item_recipe(hold_release_bo,customer_item_bo,step,operation_bo,recipe_name,capability) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_hold_release_sfc_item_recipe SET operation_bo=?,recipe_name=?,capability=? WHERE hold_release_bo=? AND customer_item_bo=? AND step=?";

  private static final String SQL_SEL = "SELECT hold_release_bo,customer_item_bo,step,operation_bo,recipe_name,capability FROM zr_hold_release_sfc_item_recipe ";

  private final Connection conn;

  public HoldReleaseSfcItemRecipeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(HoldReleaseSfcItemRecipe data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHoldReleaseBo());
      ps.setString(2, data.getCustomerItemBo());
      ps.setInt(3, data.getStep());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getRecipeName());
      ps.setString(6, data.getCapability());

      return ps.executeUpdate();
    }
  }

  public int insert(List<HoldReleaseSfcItemRecipe> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (HoldReleaseSfcItemRecipe data : dataList) {
        ps.setString(1, data.getHoldReleaseBo());
        ps.setString(2, data.getCustomerItemBo());
        ps.setInt(3, data.getStep());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getRecipeName());
        ps.setString(6, data.getCapability());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_hold_release_sfc_item_recipe WHERE hold_release_bo=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int update(HoldReleaseSfcItemRecipe data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getOperationBo());
      ps.setString(2, data.getRecipeName());
      ps.setString(3, data.getCapability());
      ps.setString(4, data.getHoldReleaseBo());
      ps.setString(5, data.getCustomerItemBo());
      ps.setInt(6, data.getStep());

      return ps.executeUpdate();
    }
  }

  public int update(List<HoldReleaseSfcItemRecipe> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (HoldReleaseSfcItemRecipe data : dataList) {
        ps.setString(1, data.getOperationBo());
        ps.setString(2, data.getRecipeName());
        ps.setString(3, data.getCapability());
        ps.setString(4, data.getHoldReleaseBo());
        ps.setString(5, data.getCustomerItemBo());
        ps.setInt(6, data.getStep());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String holdReleaseBo, String customerItemBo, int step) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_hold_release_sfc_item_recipe WHERE hold_release_bo=? AND customer_item_bo=? AND step=?")) {
      ps.setString(1, holdReleaseBo);
      ps.setString(2, customerItemBo);
      ps.setInt(3, step);

      return ps.executeUpdate();
    }
  }

  public List<HoldReleaseSfcItemRecipe> selectAll() throws SQLException {
    ArrayList<HoldReleaseSfcItemRecipe> result = new ArrayList<HoldReleaseSfcItemRecipe>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<HoldReleaseSfcItemRecipe> selectByWaferId(String holdReleaseBo, String customerItemBo)
      throws SQLException {
    ArrayList<HoldReleaseSfcItemRecipe> result = new ArrayList<HoldReleaseSfcItemRecipe>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE hold_release_bo=? AND customer_item_bo=?")) {
      ps.setString(1, holdReleaseBo);
      ps.setString(2, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public HoldReleaseSfcItemRecipe selectByPK(String holdReleaseBo, String customerItemBo, int step)
      throws SQLException {
    HoldReleaseSfcItemRecipe result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE hold_release_bo=? AND customer_item_bo=? AND step=?")) {
      ps.setString(1, holdReleaseBo);
      ps.setString(2, customerItemBo);
      ps.setInt(3, step);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private HoldReleaseSfcItemRecipe convert(ResultSet rs) throws SQLException {
    HoldReleaseSfcItemRecipe data = new HoldReleaseSfcItemRecipe();

    int index = 1;
    data.setHoldReleaseBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setStep(rs.getInt(index++));
    data.setOperationBo(rs.getString(index++));
    data.setRecipeName(rs.getString(index++));
    data.setCapability(rs.getString(index++));

    return data;
  }
}
