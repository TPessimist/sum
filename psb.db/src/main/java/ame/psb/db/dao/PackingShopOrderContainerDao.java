package ame.psb.db.dao;

import ame.psb.db.PackingShopOrderContainer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PackingShopOrderContainerDao {

  private static final String SQL_INS = "INSERT INTO zr_packing_shop_order_container(dn_num,shop_order,box_id,item_name,dn_qty,shop_order_qty,container_qty,container_name,sap_order,sap_item_name,cust_id,sap_cust_code,creator,item_group_name,deptno,werks,lot_type,route_version,plan_start_date,plan_end_date,erp_create_date,release_state,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_packing_shop_order_container SET item_name=?,dn_qty=?,shop_order_qty=?,container_qty=?,container_name=?,sap_order=?,sap_item_name=?,cust_id=?,sap_cust_code=?,creator=?,item_group_name=?,deptno=?,werks=?,lot_type=?,route_version=?,plan_start_date=?,plan_end_date=?,erp_create_date=?,release_state=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE dn_num=? AND shop_order=? AND box_id=?";

  private static final String SQL_SEL = "SELECT dn_num,shop_order,box_id,item_name,dn_qty,shop_order_qty,container_qty,container_name,sap_order,sap_item_name,cust_id,sap_cust_code,creator,item_group_name,deptno,werks,lot_type,route_version,plan_start_date,plan_end_date,erp_create_date,release_state,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_packing_shop_order_container ";

  private final Connection conn;

  public PackingShopOrderContainerDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PackingShopOrderContainer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getDnNum());
      ps.setString(2, data.getShopOrder());
      ps.setString(3, data.getBoxId());
      ps.setString(4, data.getItemName());
      ps.setBigDecimal(5, data.getDnQty());
      ps.setBigDecimal(6, data.getShopOrderQty());
      ps.setBigDecimal(7, data.getContainerQty());
      ps.setString(8, data.getContainerName());
      ps.setString(9, data.getSapOrder());
      ps.setString(10, data.getSapItemName());
      ps.setString(11, data.getCustId());
      ps.setString(12, data.getSapCustCode());
      ps.setString(13, data.getCreator());
      ps.setString(14, data.getItemGroupName());
      ps.setString(15, data.getDeptno());
      ps.setString(16, data.getWerks());
      ps.setString(17, data.getLotType());
      ps.setString(18, data.getRouteVersion());
      DateUtils.setDateTz(ps, 19, data.getPlanStartDate());
      DateUtils.setDateTz(ps, 20, data.getPlanEndDate());
      DateUtils.setDateTz(ps, 21, data.getErpCreateDate());
      ps.setString(22, data.getReleaseState());
      ps.setString(23, data.getReversedField1());
      ps.setString(24, data.getReversedField2());
      ps.setString(25, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 26, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PackingShopOrderContainer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PackingShopOrderContainer data : dataList) {
        ps.setString(1, data.getDnNum());
        ps.setString(2, data.getShopOrder());
        ps.setString(3, data.getBoxId());
        ps.setString(4, data.getItemName());
        ps.setBigDecimal(5, data.getDnQty());
        ps.setBigDecimal(6, data.getShopOrderQty());
        ps.setBigDecimal(7, data.getContainerQty());
        ps.setString(8, data.getContainerName());
        ps.setString(9, data.getSapOrder());
        ps.setString(10, data.getSapItemName());
        ps.setString(11, data.getCustId());
        ps.setString(12, data.getSapCustCode());
        ps.setString(13, data.getCreator());
        ps.setString(14, data.getItemGroupName());
        ps.setString(15, data.getDeptno());
        ps.setString(16, data.getWerks());
        ps.setString(17, data.getLotType());
        ps.setString(18, data.getRouteVersion());
        DateUtils.setDateTz(ps, 19, data.getPlanStartDate());
        DateUtils.setDateTz(ps, 20, data.getPlanEndDate());
        DateUtils.setDateTz(ps, 21, data.getErpCreateDate());
        ps.setString(22, data.getReleaseState());
        ps.setString(23, data.getReversedField1());
        ps.setString(24, data.getReversedField2());
        ps.setString(25, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 26, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PackingShopOrderContainer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemName());
      ps.setBigDecimal(2, data.getDnQty());
      ps.setBigDecimal(3, data.getShopOrderQty());
      ps.setBigDecimal(4, data.getContainerQty());
      ps.setString(5, data.getContainerName());
      ps.setString(6, data.getSapOrder());
      ps.setString(7, data.getSapItemName());
      ps.setString(8, data.getCustId());
      ps.setString(9, data.getSapCustCode());
      ps.setString(10, data.getCreator());
      ps.setString(11, data.getItemGroupName());
      ps.setString(12, data.getDeptno());
      ps.setString(13, data.getWerks());
      ps.setString(14, data.getLotType());
      ps.setString(15, data.getRouteVersion());
      DateUtils.setDateTz(ps, 16, data.getPlanStartDate());
      DateUtils.setDateTz(ps, 17, data.getPlanEndDate());
      DateUtils.setDateTz(ps, 18, data.getErpCreateDate());
      ps.setString(19, data.getReleaseState());
      ps.setString(20, data.getReversedField1());
      ps.setString(21, data.getReversedField2());
      ps.setString(22, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 23, data.getUpdatedTime());
      ps.setString(24, data.getDnNum());
      ps.setString(25, data.getShopOrder());
      ps.setString(26, data.getBoxId());

      return ps.executeUpdate();
    }
  }

  public int update(List<PackingShopOrderContainer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PackingShopOrderContainer data : dataList) {
        ps.setString(1, data.getItemName());
        ps.setBigDecimal(2, data.getDnQty());
        ps.setBigDecimal(3, data.getShopOrderQty());
        ps.setBigDecimal(4, data.getContainerQty());
        ps.setString(5, data.getContainerName());
        ps.setString(6, data.getSapOrder());
        ps.setString(7, data.getSapItemName());
        ps.setString(8, data.getCustId());
        ps.setString(9, data.getSapCustCode());
        ps.setString(10, data.getCreator());
        ps.setString(11, data.getItemGroupName());
        ps.setString(12, data.getDeptno());
        ps.setString(13, data.getWerks());
        ps.setString(14, data.getLotType());
        ps.setString(15, data.getRouteVersion());
        DateUtils.setDateTz(ps, 16, data.getPlanStartDate());
        DateUtils.setDateTz(ps, 17, data.getPlanEndDate());
        DateUtils.setDateTz(ps, 18, data.getErpCreateDate());
        ps.setString(19, data.getReleaseState());
        ps.setString(20, data.getReversedField1());
        ps.setString(21, data.getReversedField2());
        ps.setString(22, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 23, data.getUpdatedTime());
        ps.setString(24, data.getDnNum());
        ps.setString(25, data.getShopOrder());
        ps.setString(26, data.getBoxId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String dnNum, String shopOrder, String boxId) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_packing_shop_order_container WHERE dn_num=? AND shop_order=? AND box_id=?")) {
      ps.setString(1, dnNum);
      ps.setString(2, shopOrder);
      ps.setString(3, boxId);

      return ps.executeUpdate();
    }
  }

  public int updateDnNumByContainerName(String dnNum, String dnQty, String updatedUser,
      Date updatedTime, String containerName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_packing_shop_order_container SET dn_num = ?, dn_qty = ?, updated_user = ?, updated_time = ? WHERE container_name = ?")) {
      ps.setString(1, dnNum);
      ps.setString(2, dnQty);
      ps.setString(3, updatedUser);
      DateUtils.setDateTz(ps, 4, updatedTime);
      ps.setString(5, containerName);

      return ps.executeUpdate();
    }
  }

  public List<PackingShopOrderContainer> selectAll() throws SQLException {
    ArrayList<PackingShopOrderContainer> result = new ArrayList<PackingShopOrderContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<PackingShopOrderContainer> selectByDn(String dn) throws SQLException {
    ArrayList<PackingShopOrderContainer> result = new ArrayList<PackingShopOrderContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where dn_num = ? ")) {
      ps.setString(1, dn);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PackingShopOrderContainer> selectByShopOrder(String sp) throws SQLException {
    ArrayList<PackingShopOrderContainer> result = new ArrayList<PackingShopOrderContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where shop_order = ? ")) {
      ps.setString(1, sp);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public PackingShopOrderContainer selectByDnAndItem(String dn, String itemName)
      throws SQLException {
    PackingShopOrderContainer result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where dn_num = ? and item_name = ?")) {
      ps.setString(1, dn);
      ps.setString(2, itemName);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public PackingShopOrderContainer selectByContainerId(String containerId) throws SQLException {
    PackingShopOrderContainer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where box_id = ?")) {
      ps.setString(1, containerId);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PackingShopOrderContainer selectByReelId(String containerName) throws SQLException {
    PackingShopOrderContainer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where container_name = ?")) {
      ps.setString(1, containerName);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PackingShopOrderContainer selectByDnAndContainer(String dn, String containerName)
      throws SQLException {
    PackingShopOrderContainer result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where dn_num = ? and container_name = ?")) {
      ps.setString(1, dn);
      ps.setString(2, containerName);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PackingShopOrderContainer selectByPK(String dnNum, String shopOrder, String boxId)
      throws SQLException {
    PackingShopOrderContainer result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE dn_num=? AND shop_order=? AND box_id=?")) {
      ps.setString(1, dnNum);
      ps.setString(2, shopOrder);
      ps.setString(3, boxId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PackingShopOrderContainer convert(ResultSet rs) throws SQLException {
    PackingShopOrderContainer data = new PackingShopOrderContainer();

    int index = 1;
    data.setDnNum(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setBoxId(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setDnQty(rs.getBigDecimal(index++));
    data.setShopOrderQty(rs.getBigDecimal(index++));
    data.setContainerQty(rs.getBigDecimal(index++));
    data.setContainerName(rs.getString(index++));
    data.setSapOrder(rs.getString(index++));
    data.setSapItemName(rs.getString(index++));
    data.setCustId(rs.getString(index++));
    data.setSapCustCode(rs.getString(index++));
    data.setCreator(rs.getString(index++));
    data.setItemGroupName(rs.getString(index++));
    data.setDeptno(rs.getString(index++));
    data.setWerks(rs.getString(index++));
    data.setLotType(rs.getString(index++));
    data.setRouteVersion(rs.getString(index++));
    data.setPlanStartDate(DateUtils.getDateTz(rs, index++));
    data.setPlanEndDate(DateUtils.getDateTz(rs, index++));
    data.setErpCreateDate(DateUtils.getDateTz(rs, index++));
    data.setReleaseState(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
