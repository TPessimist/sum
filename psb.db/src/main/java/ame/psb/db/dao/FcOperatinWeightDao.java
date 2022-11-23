package ame.psb.db.dao;

import ame.psb.db.FcOperatinWeight;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FcOperatinWeightDao {

  private static final String SQL_INS = "INSERT INTO zd_fc_operation_weight(uuid,shop_order_bo,shop_order,operation_bo,erserve1,erserve2,update_user,update_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_fc_operation_weight SET shop_order_bo=?,shop_order=?,operation_bo=?,erserve1=?,erserve2=?,update_user=?,update_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,shop_order_bo,shop_order,operation_bo,erserve1,erserve2,update_user,update_time FROM zd_fc_operation_weight ";

  private final Connection conn;

  public FcOperatinWeightDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FcOperatinWeight data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getShopOrderBo());
      ps.setString(3, data.getShopOrder());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getErserve1());
      ps.setString(6, data.getErserve2());
      ps.setString(7, data.getUpdateUser());
      DateUtils.setDateTz(ps, 8, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FcOperatinWeight> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FcOperatinWeight data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getShopOrderBo());
        ps.setString(3, data.getShopOrder());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getErserve1());
        ps.setString(6, data.getErserve2());
        ps.setString(7, data.getUpdateUser());
        DateUtils.setDateTz(ps, 8, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FcOperatinWeight data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getShopOrderBo());
      ps.setString(2, data.getShopOrder());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getErserve1());
      ps.setString(5, data.getErserve2());
      ps.setString(6, data.getUpdateUser());
      DateUtils.setDateTz(ps, 7, data.getUpdateTime());
      ps.setString(8, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<FcOperatinWeight> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FcOperatinWeight data : dataList) {
        ps.setString(1, data.getShopOrderBo());
        ps.setString(2, data.getShopOrder());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getErserve1());
        ps.setString(5, data.getErserve2());
        ps.setString(6, data.getUpdateUser());
        DateUtils.setDateTz(ps, 7, data.getUpdateTime());
        ps.setString(8, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_fc_operation_weigh WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<FcOperatinWeight> selectAll() throws SQLException {
    ArrayList<FcOperatinWeight> result = new ArrayList<FcOperatinWeight>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public FcOperatinWeight selectByPKCombine(String shopOrderBo, String operationBo)
      throws SQLException {
    FcOperatinWeight result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE SHOP_ORDER_BO = ? AND OPERATION_BO = ?")) {
      ps.setString(1, shopOrderBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public FcOperatinWeight selectByPK(String uuid) throws SQLException {
    FcOperatinWeight result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FcOperatinWeight selectByPKShopOrder(String shopOrder) throws SQLException {
    FcOperatinWeight result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order_bo = ?")) {
      ps.setString(1, shopOrder);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FcOperatinWeight selectByPKShopOrderAndoperationBo(String shopOrder, String operationBo)
      throws SQLException {
    FcOperatinWeight result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE SHOP_ORDER_BO = ? and OPERATION_BO = ?")) {
      ps.setString(1, shopOrder);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FcOperatinWeight convert(ResultSet rs) throws SQLException {
    FcOperatinWeight data = new FcOperatinWeight();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setErserve1(rs.getString(index++));
    data.setErserve2(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
