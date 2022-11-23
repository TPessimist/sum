package ame.psb.db.dao;

import static uia.utils.dao.DateUtils.getDateTz;
import static uia.utils.dao.DateUtils.setDateTz;

import ame.psb.db.FoMaintainLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoMaintainLogDao {

  private static final String SQL_INS = "INSERT INTO zd_fo_maintain_log(id,table_name,sfc_name,shop_order,resource,material_description,material_po,wafer_id,sfc_remain_numbers,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_fo_maintain_log SET table_name=?,sfc_name=?,shop_order=?,resource=?,material_description=?,material_po=?,wafer_id=?,sfc_remain_numbers=?,update_user=?,update_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,table_name,sfc_name,shop_order,resource,material_description,material_po,wafer_id,sfc_remain_numbers,update_user,update_time FROM zd_fo_maintain_log ";

  private final Connection conn;

  public FoMaintainLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FoMaintainLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getTableName());
      ps.setString(3, data.getSfcName());
      ps.setString(4, data.getShopOrder());
      ps.setString(5, data.getResource());
      ps.setString(6, data.getMaterialDescription());
      ps.setString(7, data.getMaterialPo());
      ps.setString(8, data.getWaferId());
      ps.setInt(9, data.getSfcRemainNumbers());
      ps.setString(10, data.getUpdateUser());
      setDateTz(ps, 11, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FoMaintainLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FoMaintainLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getTableName());
        ps.setString(3, data.getSfcName());
        ps.setString(4, data.getShopOrder());
        ps.setString(5, data.getResource());
        ps.setString(6, data.getMaterialDescription());
        ps.setString(7, data.getMaterialPo());
        ps.setString(8, data.getWaferId());
        ps.setInt(9, data.getSfcRemainNumbers());
        ps.setString(10, data.getUpdateUser());
        setDateTz(ps, 11, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FoMaintainLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getTableName());
      ps.setString(2, data.getSfcName());
      ps.setString(3, data.getShopOrder());
      ps.setString(4, data.getResource());
      ps.setString(5, data.getMaterialDescription());
      ps.setString(6, data.getMaterialPo());
      ps.setString(7, data.getWaferId());
      ps.setInt(8, data.getSfcRemainNumbers());
      ps.setString(9, data.getUpdateUser());
      setDateTz(ps, 10, data.getUpdateTime());
      ps.setString(11, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FoMaintainLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FoMaintainLog data : dataList) {
        ps.setString(1, data.getTableName());
        ps.setString(2, data.getSfcName());
        ps.setString(3, data.getShopOrder());
        ps.setString(4, data.getResource());
        ps.setString(5, data.getMaterialDescription());
        ps.setString(6, data.getMaterialPo());
        ps.setString(7, data.getWaferId());
        ps.setInt(8, data.getSfcRemainNumbers());
        ps.setString(9, data.getUpdateUser());
        setDateTz(ps, 10, data.getUpdateTime());
        ps.setString(11, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_fo_maintain_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<FoMaintainLog> selectAll() throws SQLException {
    ArrayList<FoMaintainLog> result = new ArrayList<FoMaintainLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FoMaintainLog selectByPK(String id) throws SQLException {
    FoMaintainLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FoMaintainLog selectByPK(String id, String tableName) throws SQLException {
    FoMaintainLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=? ")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FoMaintainLog convert(ResultSet rs) throws SQLException {
    FoMaintainLog data = new FoMaintainLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setTableName(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setResource(rs.getString(index++));
    data.setMaterialDescription(rs.getString(index++));
    data.setMaterialPo(rs.getString(index++));
    data.setWaferId(rs.getString(index++));
    data.setSfcRemainNumbers(rs.getInt(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(getDateTz(rs, index++));

    return data;
  }
}
