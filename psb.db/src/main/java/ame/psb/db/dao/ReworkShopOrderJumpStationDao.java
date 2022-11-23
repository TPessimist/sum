package ame.psb.db.dao;

import ame.psb.db.ReworkShopOrderJumpStation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ReworkShopOrderJumpStationDao {

  private static final String SQL_INS = "INSERT INTO zr_remork_shop_order_jump_station(sfc_bo,shop_order_bo,operation_bo,type,shop_order_name,table_name,state_name,message,update_user,update_time,reverse1,reverse2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_remork_shop_order_jump_station SET operation_bo=?,type=?,shop_order_name=?,table_name=?,state_name=?,message=?,update_user=?,update_time=?,reverse1=?,reverse2=? WHERE sfc_bo=? AND shop_order_bo=?";

  private static final String SQL_SEL = "SELECT sfc_bo,shop_order_bo,operation_bo,type,shop_order_name,table_name,state_name,message,update_user,update_time,reverse1,reverse2 FROM zr_remork_shop_order_jump_station ";

  private final Connection conn;

  public ReworkShopOrderJumpStationDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ReworkShopOrderJumpStation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getShopOrderBo());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getType());
      ps.setString(5, data.getShopOrderName());
      ps.setString(6, data.getTableName());
      ps.setString(7, data.getStateName());
      ps.setString(8, data.getMessage());
      ps.setString(9, data.getUpdateUser());
      DateUtils.setDateTz(ps, 10, data.getUpdateTime());
      ps.setString(11, data.getReverse1());
      ps.setString(12, data.getReverse2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ReworkShopOrderJumpStation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ReworkShopOrderJumpStation data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getShopOrderBo());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getType());
        ps.setString(5, data.getShopOrderName());
        ps.setString(6, data.getTableName());
        ps.setString(7, data.getStateName());
        ps.setString(8, data.getMessage());
        ps.setString(9, data.getUpdateUser());
        DateUtils.setDateTz(ps, 10, data.getUpdateTime());
        ps.setString(11, data.getReverse1());
        ps.setString(12, data.getReverse2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ReworkShopOrderJumpStation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getOperationBo());
      ps.setString(2, data.getType());
      ps.setString(3, data.getShopOrderName());
      ps.setString(4, data.getTableName());
      ps.setString(5, data.getStateName());
      ps.setString(6, data.getMessage());
      ps.setString(7, data.getUpdateUser());
      DateUtils.setDateTz(ps, 8, data.getUpdateTime());
      ps.setString(9, data.getReverse1());
      ps.setString(10, data.getReverse2());
      ps.setString(11, data.getSfcBo());
      ps.setString(12, data.getShopOrderBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ReworkShopOrderJumpStation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ReworkShopOrderJumpStation data : dataList) {
        ps.setString(1, data.getOperationBo());
        ps.setString(2, data.getType());
        ps.setString(3, data.getShopOrderName());
        ps.setString(4, data.getTableName());
        ps.setString(5, data.getStateName());
        ps.setString(6, data.getMessage());
        ps.setString(7, data.getUpdateUser());
        DateUtils.setDateTz(ps, 8, data.getUpdateTime());
        ps.setString(9, data.getReverse1());
        ps.setString(10, data.getReverse2());
        ps.setString(11, data.getSfcBo());
        ps.setString(12, data.getShopOrderBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String sfcBo, String shopOrderBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_remork_shop_order_jump_station WHERE sfc_bo=? AND shop_order_bo=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, shopOrderBo);

      return ps.executeUpdate();
    }
  }

  public List<ReworkShopOrderJumpStation> selectAll() throws SQLException {
    ArrayList<ReworkShopOrderJumpStation> result = new ArrayList<ReworkShopOrderJumpStation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ReworkShopOrderJumpStation selectByPK(String sfcBo, String shopOrderBo)
      throws SQLException {
    ReworkShopOrderJumpStation result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND shop_order_bo=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ReworkShopOrderJumpStation> selectByState(String stateName) throws SQLException {
    ArrayList<ReworkShopOrderJumpStation> result = new ArrayList<ReworkShopOrderJumpStation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where state_name=? ")) {
      ps.setString(1, stateName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ReworkShopOrderJumpStation convert(ResultSet rs) throws SQLException {
    ReworkShopOrderJumpStation data = new ReworkShopOrderJumpStation();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setType(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setTableName(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setMessage(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setReverse1(rs.getString(index++));
    data.setReverse2(rs.getString(index++));

    return data;
  }
}
