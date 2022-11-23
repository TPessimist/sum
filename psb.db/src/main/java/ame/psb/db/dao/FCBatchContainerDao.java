package ame.psb.db.dao;

import ame.psb.db.FCBatchContainer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FCBatchContainerDao {

  private static final String SQL_INS = "INSERT INTO zr_fc_batch_container(shop_order_bo,batch_id,container_name,sfc_bo,customer_item_bo,grade,qty,gross_qty,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_fc_batch_container SET shop_order_bo=?,qty=?,gross_qty=?,updated_user=?,updated_time=? WHERE batch_id=? AND container_name=? AND sfc_bo=? AND customer_item_bo=? AND grade=?";

  private static final String SQL_SEL = "SELECT shop_order_bo,batch_id,container_name,sfc_bo,customer_item_bo,grade,qty,gross_qty,updated_user,updated_time FROM zr_fc_batch_container ";

  private final Connection conn;

  public FCBatchContainerDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FCBatchContainer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getShopOrderBo());
      ps.setString(2, data.getBatchId());
      ps.setString(3, data.getContainerName());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getCustomerItemBo());
      ps.setString(6, data.getGrade());
      ps.setBigDecimal(7, data.getQty());
      ps.setBigDecimal(8, data.getGrossQty());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FCBatchContainer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FCBatchContainer data : dataList) {
        ps.setString(1, data.getShopOrderBo());
        ps.setString(2, data.getBatchId());
        ps.setString(3, data.getContainerName());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getCustomerItemBo());
        ps.setString(6, data.getGrade());
        ps.setBigDecimal(7, data.getQty());
        ps.setBigDecimal(8, data.getGrossQty());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FCBatchContainer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getShopOrderBo());
      ps.setBigDecimal(2, data.getQty());
      ps.setBigDecimal(3, data.getGrossQty());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getBatchId());
      ps.setString(7, data.getContainerName());
      ps.setString(8, data.getSfcBo());
      ps.setString(9, data.getCustomerItemBo());
      ps.setString(10, data.getGrade());

      return ps.executeUpdate();
    }
  }

  public int update(List<FCBatchContainer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FCBatchContainer data : dataList) {
        ps.setString(1, data.getShopOrderBo());
        ps.setBigDecimal(2, data.getQty());
        ps.setBigDecimal(3, data.getGrossQty());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getBatchId());
        ps.setString(7, data.getContainerName());
        ps.setString(8, data.getSfcBo());
        ps.setString(9, data.getCustomerItemBo());
        ps.setString(10, data.getGrade());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String batchId, String containerName, String sfcBo, String customerItemBo,
      String grade) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_fc_batch_container WHERE batch_id=? AND container_name=? AND sfc_bo=? AND customer_item_bo=? AND grade=?")) {
      ps.setString(1, batchId);
      ps.setString(2, containerName);
      ps.setString(3, sfcBo);
      ps.setString(4, customerItemBo);
      ps.setString(5, grade);

      return ps.executeUpdate();
    }
  }

  public List<FCBatchContainer> selectAll() throws SQLException {
    ArrayList<FCBatchContainer> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FCBatchContainer> selectByBatchId(String batchId) throws SQLException {
    ArrayList<FCBatchContainer> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where batch_id = ?")) {
      ps.setString(1, batchId);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FCBatchContainer> selectByBatchContainerName(String CONTAINER_NAME)
      throws SQLException {
    ArrayList<FCBatchContainer> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where CONTAINER_NAME = ?")) {
      ps.setString(1, CONTAINER_NAME);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FCBatchContainer> selectByShopOrder(String shopOrderBo) throws SQLException {
    ArrayList<FCBatchContainer> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where SHOP_ORDER_BO = ?")) {
      ps.setString(1, shopOrderBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FCBatchContainer selectByPK(String batchId, String containerName, String sfcBo,
      String customerItemBo, String grade) throws SQLException {
    FCBatchContainer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE batch_id=? AND container_name=? AND sfc_bo=? AND customer_item_bo=? AND grade=?")) {
      ps.setString(1, batchId);
      ps.setString(2, containerName);
      ps.setString(3, sfcBo);
      ps.setString(4, customerItemBo);
      ps.setString(5, grade);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FCBatchContainer convert(ResultSet rs) throws SQLException {
    FCBatchContainer data = new FCBatchContainer();

    int index = 1;
    data.setShopOrderBo(rs.getString(index++));
    data.setBatchId(rs.getString(index++));
    data.setContainerName(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setGrade(rs.getString(index++));
    data.setQty(rs.getBigDecimal(index++));
    data.setGrossQty(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
