package ame.psb.db.dao;

import ame.psb.db.DeviceOperationBuyoff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.CancelSfc;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class CancelSfcDao {

  private static final String SQL_INS = "INSERT INTO zr_cancel_sfc(item_group_bo,item_group_name,item_bo,item_name,shop_order_bo,shop_order_name,state,modify_user,modify_time,created_user,created_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_cancel_sfc SET item_group_bo=?,item_group_name=?,item_bo=?,item_name=?,shop_order_name=?,state=?,modify_user=?,modify_time=?,created_user=?,created_time=? WHERE shop_order_bo=?";

  private static final String SQL_SEL = "SELECT item_group_bo,item_group_name,item_bo,item_name,shop_order_bo,shop_order_name,state,modify_user,modify_time,created_user,created_time FROM zr_cancel_sfc ";

  private final Connection conn;

  public CancelSfcDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CancelSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getItemGroupName());
      ps.setString(3, data.getItemBo());
      ps.setString(4, data.getItemName());
      ps.setString(5, data.getShopOrderBo());
      ps.setString(6, data.getShopOrderName());
      ps.setString(7, data.getState());
      ps.setString(8, data.getModifyUser());
      DateUtils.setDateTz(ps, 9, data.getModifyTime());
      ps.setString(10, data.getCreatedUser());
      DateUtils.setDateTz(ps, 11, data.getCreatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CancelSfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CancelSfc data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getItemGroupName());
        ps.setString(3, data.getItemBo());
        ps.setString(4, data.getItemName());
        ps.setString(5, data.getShopOrderBo());
        ps.setString(6, data.getShopOrderName());
        ps.setString(7, data.getState());
        ps.setString(8, data.getModifyUser());
        DateUtils.setDateTz(ps, 9, data.getModifyTime());
        ps.setString(10, data.getCreatedUser());
        DateUtils.setDateTz(ps, 11, data.getCreatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CancelSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getItemGroupName());
      ps.setString(3, data.getItemBo());
      ps.setString(4, data.getItemName());
      ps.setString(5, data.getShopOrderName());
      ps.setString(6, data.getState());
      ps.setString(7, data.getModifyUser());
      DateUtils.setDateTz(ps, 8, data.getModifyTime());
      ps.setString(9, data.getCreatedUser());
      DateUtils.setDateTz(ps, 10, data.getCreatedTime());
      ps.setString(11, data.getShopOrderBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<CancelSfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CancelSfc data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getItemGroupName());
        ps.setString(3, data.getItemBo());
        ps.setString(4, data.getItemName());
        ps.setString(5, data.getShopOrderName());
        ps.setString(6, data.getState());
        ps.setString(7, data.getModifyUser());
        DateUtils.setDateTz(ps, 8, data.getModifyTime());
        ps.setString(9, data.getCreatedUser());
        DateUtils.setDateTz(ps, 10, data.getCreatedTime());
        ps.setString(11, data.getShopOrderBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String shopOrderBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_cancel_sfc WHERE shop_order_bo=?")) {
      ps.setString(1, shopOrderBo);

      return ps.executeUpdate();
    }
  }

  public List<CancelSfc> select(Where where) throws SQLException {
    List<CancelSfc> result = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<CancelSfc> selectAll() throws SQLException {
    ArrayList<CancelSfc> result = new ArrayList<CancelSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public CancelSfc selectByPK(String shopOrderBo) throws SQLException {
    CancelSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order_bo=?")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private CancelSfc convert(ResultSet rs) throws SQLException {
    CancelSfc data = new CancelSfc();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setItemGroupName(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setModifyUser(rs.getString(index++));
    data.setModifyTime(DateUtils.getDateTz(rs, index++));
    data.setCreatedUser(rs.getString(index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
