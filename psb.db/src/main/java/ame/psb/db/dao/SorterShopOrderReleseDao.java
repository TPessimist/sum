package ame.psb.db.dao;

import ame.psb.db.SorterShopOrderRelese;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SorterShopOrderReleseDao {

  private static final String SQL_INS = "INSERT INTO zr_sorter_shop_order_relese(shop_order,carrier_id,wafer_id,slot_id,content1,content2) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_sorter_shop_order_relese SET slot_id=?,content1=?,content2=?,carrier_id=? WHERE shop_order=? AND wafer_id=?";

  private static final String SQL_SEL = "SELECT shop_order,carrier_id,wafer_id,slot_id,content1,content2 FROM zr_sorter_shop_order_relese ";

  private final Connection conn;

  public SorterShopOrderReleseDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SorterShopOrderRelese data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getShopOrder());
      ps.setString(2, data.getCarrierId());
      ps.setString(3, data.getWaferId());
      ps.setString(4, data.getSlotId());
      ps.setString(5, data.getContent1());
      ps.setString(6, data.getContent2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SorterShopOrderRelese> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SorterShopOrderRelese data : dataList) {
        ps.setString(1, data.getShopOrder());
        ps.setString(2, data.getCarrierId());
        ps.setString(3, data.getWaferId());
        ps.setString(4, data.getSlotId());
        ps.setString(5, data.getContent1());
        ps.setString(6, data.getContent2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SorterShopOrderRelese data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSlotId());
      ps.setString(2, data.getContent1());
      ps.setString(3, data.getContent2());
      ps.setString(4, data.getCarrierId());
      ps.setString(5, data.getShopOrder());
      ps.setString(6, data.getWaferId());

      return ps.executeUpdate();
    }
  }

  public int update(List<SorterShopOrderRelese> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SorterShopOrderRelese data : dataList) {
        ps.setString(1, data.getSlotId());
        ps.setString(2, data.getContent1());
        ps.setString(3, data.getContent2());
        ps.setString(4, data.getCarrierId());
        ps.setString(5, data.getShopOrder());
        ps.setString(6, data.getWaferId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String shopOrder, String carrierId, String waferId) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_sorter_shop_order_relese WHERE shop_order=? AND carrier_id=? AND wafer_id=?")) {
      ps.setString(1, shopOrder);
      ps.setString(2, carrierId);
      ps.setString(3, waferId);

      return ps.executeUpdate();
    }
  }

  public List<SorterShopOrderRelese> selectAll() throws SQLException {
    ArrayList<SorterShopOrderRelese> result = new ArrayList<SorterShopOrderRelese>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SorterShopOrderRelese> selectByShopOrder(String shopOrder) throws SQLException {
    ArrayList<SorterShopOrderRelese> result = new ArrayList<SorterShopOrderRelese>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order=?")) {
      ps.setString(1, shopOrder);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SorterShopOrderRelese selectByPK(String shopOrder, String waferId) throws SQLException {
    SorterShopOrderRelese result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE shop_order=? AND wafer_id=?")) {
      ps.setString(1, shopOrder);
      ps.setString(2, waferId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SorterShopOrderRelese convert(ResultSet rs) throws SQLException {
    SorterShopOrderRelese data = new SorterShopOrderRelese();

    int index = 1;
    data.setShopOrder(rs.getString(index++));
    data.setCarrierId(rs.getString(index++));
    data.setWaferId(rs.getString(index++));
    data.setSlotId(rs.getString(index++));
    data.setContent1(rs.getString(index++));
    data.setContent2(rs.getString(index++));

    return data;
  }
}
