package ame.psb.db.dao;

import ame.psb.db.FoProductMaintain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FoProductMaintainDao {

  private static final String SQL_INS = "INSERT INTO zd_fo_product_maintain(id,sfc_name,shop_order,resource,material_description,material_po,wafer_id,sfc_remain_numbers,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_fo_product_maintain SET sfc_name=?,shop_order=?,resource=?,material_description=?,material_po=?,wafer_id=?,sfc_remain_numbers=?,update_user=?,update_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sfc_name,shop_order,resource,material_description,material_po,wafer_id,sfc_remain_numbers,update_user,update_time FROM zd_fo_product_maintain ";

  private final Connection conn;

  public FoProductMaintainDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FoProductMaintain data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcName());
      ps.setString(3, data.getShopOrder());
      ps.setString(4, data.getResource());
      ps.setString(5, data.getMaterialDescription());
      ps.setString(6, data.getMaterialPo());
      ps.setString(7, data.getWaferId());
      ps.setInt(8, data.getSfcRemainNumbers());
      ps.setString(9, data.getUpdateUser());
      DateUtils.setDateTz(ps, 10, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FoProductMaintain> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FoProductMaintain data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfcName());
        ps.setString(3, data.getShopOrder());
        ps.setString(4, data.getResource());
        ps.setString(5, data.getMaterialDescription());
        ps.setString(6, data.getMaterialPo());
        ps.setString(7, data.getWaferId());
        ps.setInt(8, data.getSfcRemainNumbers());
        ps.setString(9, data.getUpdateUser());
        DateUtils.setDateTz(ps, 10, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FoProductMaintain data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcName());
      ps.setString(2, data.getShopOrder());
      ps.setString(3, data.getResource());
      ps.setString(4, data.getMaterialDescription());
      ps.setString(5, data.getMaterialPo());
      ps.setString(6, data.getWaferId());
      ps.setInt(7, data.getSfcRemainNumbers());
      ps.setString(8, data.getUpdateUser());
      DateUtils.setDateTz(ps, 9, data.getUpdateTime());
      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FoProductMaintain> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FoProductMaintain data : dataList) {
        ps.setString(1, data.getSfcName());
        ps.setString(2, data.getShopOrder());
        ps.setString(3, data.getResource());
        ps.setString(4, data.getMaterialDescription());
        ps.setString(5, data.getMaterialPo());
        ps.setString(6, data.getWaferId());
        ps.setInt(7, data.getSfcRemainNumbers());
        ps.setString(8, data.getUpdateUser());
        DateUtils.setDateTz(ps, 9, data.getUpdateTime());
        ps.setString(10, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_fo_product_maintain WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<FoProductMaintain> selectAll() throws SQLException {
    ArrayList<FoProductMaintain> result = new ArrayList<FoProductMaintain>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FoProductMaintain selectByPK(String id) throws SQLException {
    FoProductMaintain result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<FoProductMaintain> selectByResource(String resource) throws SQLException {
    ArrayList<FoProductMaintain> result = new ArrayList<FoProductMaintain>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where resource=? ")) {
      ps.setString(1, resource);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FoProductMaintain> selectByUpWafer(String upWafer) throws SQLException {
    ArrayList<FoProductMaintain> result = new ArrayList<FoProductMaintain>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where wafer_id=? ")) {
      ps.setString(1, upWafer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FoProductMaintain> selectBySfcName(String sfcName) throws SQLException {
    ArrayList<FoProductMaintain> result = new ArrayList<FoProductMaintain>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where sfc_name=? ")) {
      ps.setString(1, sfcName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FoProductMaintain> selectByMaterialPo(String materialPo) throws SQLException {
    ArrayList<FoProductMaintain> result = new ArrayList<FoProductMaintain>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where material_po=? ")) {
      ps.setString(1, materialPo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private FoProductMaintain convert(ResultSet rs) throws SQLException {
    FoProductMaintain data = new FoProductMaintain();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setResource(rs.getString(index++));
    data.setMaterialDescription(rs.getString(index++));
    data.setMaterialPo(rs.getString(index++));
    data.setWaferId(rs.getString(index++));
    data.setSfcRemainNumbers(rs.getInt(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
