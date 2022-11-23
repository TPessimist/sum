package ame.psb.db.dao;

import ame.psb.db.ZrWlaNormal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZrWlaNormalDao {

  private static final String SQL_INS = "INSERT INTO zr_wla_normal(id,item_name,sfc_bo,shop_order,sap_shop_order,operation_bo,normal_flag,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_wla_normal SET item_name=?,sfc_bo=?,shop_order=?,sap_shop_order=?,operation_bo=?,normal_flag=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,item_name,sfc_bo,shop_order,sap_shop_order,operation_bo,normal_flag,updated_user,updated_time FROM zr_wla_normal ";

  private final Connection conn;

  public ZrWlaNormalDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZrWlaNormal data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getItemName());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getShopOrder());
      ps.setString(5, data.getSapShopOrder());
      ps.setString(6, data.getOperationBo());
      ps.setString(7, data.getNormalFlag());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZrWlaNormal> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZrWlaNormal data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getItemName());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getShopOrder());
        ps.setString(5, data.getSapShopOrder());
        ps.setString(6, data.getOperationBo());
        ps.setString(7, data.getNormalFlag());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZrWlaNormal data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemName());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getShopOrder());
      ps.setString(4, data.getSapShopOrder());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getNormalFlag());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZrWlaNormal> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZrWlaNormal data : dataList) {
        ps.setString(1, data.getItemName());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getShopOrder());
        ps.setString(4, data.getSapShopOrder());
        ps.setString(5, data.getOperationBo());
        ps.setString(6, data.getNormalFlag());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_wla_normal WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ZrWlaNormal> selectAll() throws SQLException {
    ArrayList<ZrWlaNormal> result = new ArrayList<ZrWlaNormal>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ZrWlaNormal selectByPK(String id) throws SQLException {
    ZrWlaNormal result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ZrWlaNormal selectByWafer(String itemName, String sfcBo) throws SQLException {
    ZrWlaNormal result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_name=? and sfc_bo=? ")) {
      ps.setString(1, itemName);
      ps.setString(2, sfcBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZrWlaNormal> selectBySfc(String SfcBo) throws SQLException {
    ArrayList<ZrWlaNormal> result = new ArrayList<ZrWlaNormal>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo = ? ORDER BY item_name asc")) {
      ps.setString(1, SfcBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ZrWlaNormal convert(ResultSet rs) throws SQLException {
    ZrWlaNormal data = new ZrWlaNormal();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setSapShopOrder(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setNormalFlag(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
