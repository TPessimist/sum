package ame.me.db.dao;

import ame.me.db.ZdFcBatchNumber;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZdFcBatchNumberDao {

  private static final String SQL_INS = "INSERT INTO zd_fc_batch_number(id,shop_order_bo,shop_order_name,batch_qty,custom_fields1,custom_fields2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_fc_batch_number SET id=?,shop_order_name=?,batch_qty=?,custom_fields1=?,custom_fields2=?,updated_user=?,updated_time=? WHERE shop_order_bo=?";

  private static final String SQL_SEL = "SELECT id,shop_order_bo,shop_order_name,batch_qty,custom_fields1,custom_fields2,updated_user,updated_time FROM zd_fc_batch_number ";

  private final Connection conn;

  public ZdFcBatchNumberDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdFcBatchNumber data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getShopOrderBo());
      ps.setString(3, data.getShopOrderName());
      ps.setString(4, data.getBatchQty());
      ps.setString(5, data.getCustomFields1());
      ps.setString(6, data.getCustomFields2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdFcBatchNumber> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdFcBatchNumber data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getShopOrderBo());
        ps.setString(3, data.getShopOrderName());
        ps.setString(4, data.getBatchQty());
        ps.setString(5, data.getCustomFields1());
        ps.setString(6, data.getCustomFields2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZdFcBatchNumber data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getShopOrderName());
      ps.setString(3, data.getBatchQty());
      ps.setString(4, data.getCustomFields1());
      ps.setString(5, data.getCustomFields2());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getShopOrderBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZdFcBatchNumber> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZdFcBatchNumber data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getShopOrderName());
        ps.setString(3, data.getBatchQty());
        ps.setString(4, data.getCustomFields1());
        ps.setString(5, data.getCustomFields2());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getShopOrderBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String shopOrderBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_fc_batch_number WHERE shop_order_bo=?")) {
      ps.setString(1, shopOrderBo);

      return ps.executeUpdate();
    }
  }

  public List<ZdFcBatchNumber> selectAll() throws SQLException {
    ArrayList<ZdFcBatchNumber> result = new ArrayList<ZdFcBatchNumber>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZdFcBatchNumber selectByPK(String shopOrderBo) throws SQLException {
    ZdFcBatchNumber result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order_bo=?")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZdFcBatchNumber convert(ResultSet rs) throws SQLException {
    ZdFcBatchNumber data = new ZdFcBatchNumber();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setBatchQty(rs.getString(index++));
    data.setCustomFields1(rs.getString(index++));
    data.setCustomFields2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
