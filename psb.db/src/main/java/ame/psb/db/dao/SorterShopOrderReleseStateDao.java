package ame.psb.db.dao;

import ame.psb.db.SorterShopOrderReleseState;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SorterShopOrderReleseStateDao {

  private static final String SQL_INS = "INSERT INTO zr_sorter_shop_order_relese_state(shop_order,job,type,state,message,spare_value,spare_value2,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_sorter_shop_order_relese_state SET job=?,type=?,state=?,message=?,spare_value=?,spare_value2=?,update_user=?,update_time=? WHERE shop_order=?";

  private static final String SQL_SEL = "SELECT shop_order,job,type,state,message,spare_value,spare_value2,update_user,update_time FROM zr_sorter_shop_order_relese_state ";

  private final Connection conn;

  public SorterShopOrderReleseStateDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SorterShopOrderReleseState data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getShopOrder());
      ps.setString(2, data.getJob());
      ps.setString(3, data.getType());
      ps.setString(4, data.getState());
      ps.setString(5, data.getMessage());
      ps.setString(6, data.getSpareValue());
      ps.setString(7, data.getSpareValue2());
      ps.setString(8, data.getUpdateUser());
      DateUtils.setDateTz(ps, 9, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SorterShopOrderReleseState> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SorterShopOrderReleseState data : dataList) {
        ps.setString(1, data.getShopOrder());
        ps.setString(2, data.getJob());
        ps.setString(3, data.getType());
        ps.setString(4, data.getState());
        ps.setString(5, data.getMessage());
        ps.setString(6, data.getSpareValue());
        ps.setString(7, data.getSpareValue2());
        ps.setString(8, data.getUpdateUser());
        DateUtils.setDateTz(ps, 9, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SorterShopOrderReleseState data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getJob());
      ps.setString(2, data.getType());
      ps.setString(3, data.getState());
      ps.setString(4, data.getMessage());
      ps.setString(5, data.getSpareValue());
      ps.setString(6, data.getSpareValue2());
      ps.setString(7, data.getUpdateUser());
      DateUtils.setDateTz(ps, 8, data.getUpdateTime());
      ps.setString(9, data.getShopOrder());

      return ps.executeUpdate();
    }
  }

  public int update(List<SorterShopOrderReleseState> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SorterShopOrderReleseState data : dataList) {
        ps.setString(1, data.getJob());
        ps.setString(2, data.getType());
        ps.setString(3, data.getState());
        ps.setString(4, data.getMessage());
        ps.setString(5, data.getSpareValue());
        ps.setString(6, data.getSpareValue2());
        ps.setString(7, data.getUpdateUser());
        DateUtils.setDateTz(ps, 8, data.getUpdateTime());
        ps.setString(9, data.getShopOrder());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String shopOrder) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_sorter_shop_order_relese_state WHERE shop_order=?")) {
      ps.setString(1, shopOrder);

      return ps.executeUpdate();
    }
  }

  public List<SorterShopOrderReleseState> selectAll() throws SQLException {
    ArrayList<SorterShopOrderReleseState> result = new ArrayList<SorterShopOrderReleseState>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SorterShopOrderReleseState> selectSorterRelese(String job) throws SQLException {
    ArrayList<SorterShopOrderReleseState> result = new ArrayList<SorterShopOrderReleseState>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE state= 'WAIT' AND job =?")) {
      ps.setString(1, job);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SorterShopOrderReleseState selectByPK(String shopOrder) throws SQLException {
    SorterShopOrderReleseState result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order=?")) {
      ps.setString(1, shopOrder);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SorterShopOrderReleseState convert(ResultSet rs) throws SQLException {
    SorterShopOrderReleseState data = new SorterShopOrderReleseState();

    int index = 1;
    data.setShopOrder(rs.getString(index++));
    data.setJob(rs.getString(index++));
    data.setType(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setMessage(rs.getString(index++));
    data.setSpareValue(rs.getString(index++));
    data.setSpareValue2(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
