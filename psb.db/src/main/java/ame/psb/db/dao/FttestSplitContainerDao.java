package ame.psb.db.dao;

import ame.psb.db.FttestSplitContainer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FttestSplitContainerDao {

  private static final String SQL_INS = "INSERT INTO zr_fttest_split_container(id,shop_order_bo,sfc_bo,container_bo,marking_code,reverse_field1,reverse_field2,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_fttest_split_container SET shop_order_bo=?,sfc_bo=?,container_bo=?,marking_code=?,reverse_field1=?,reverse_field2=?,update_user=?,update_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,shop_order_bo,sfc_bo,container_bo,marking_code,reverse_field1,reverse_field2,update_user,update_time FROM zr_fttest_split_container ";

  private final Connection conn;

  public FttestSplitContainerDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FttestSplitContainer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getShopOrderBo());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getContainerBo());
      ps.setString(5, data.getMarkingCode());
      ps.setString(6, data.getReverseField1());
      ps.setString(7, data.getReverseField2());
      ps.setString(8, data.getUpdateUser());
      DateUtils.setDateTz(ps, 9, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FttestSplitContainer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FttestSplitContainer data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getShopOrderBo());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getContainerBo());
        ps.setString(5, data.getMarkingCode());
        ps.setString(6, data.getReverseField1());
        ps.setString(7, data.getReverseField2());
        ps.setString(8, data.getUpdateUser());
        DateUtils.setDateTz(ps, 9, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FttestSplitContainer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getShopOrderBo());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getContainerBo());
      ps.setString(4, data.getMarkingCode());
      ps.setString(5, data.getReverseField1());
      ps.setString(6, data.getReverseField2());
      ps.setString(7, data.getUpdateUser());
      DateUtils.setDateTz(ps, 8, data.getUpdateTime());
      ps.setString(9, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FttestSplitContainer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FttestSplitContainer data : dataList) {
        ps.setString(1, data.getShopOrderBo());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getContainerBo());
        ps.setString(4, data.getMarkingCode());
        ps.setString(5, data.getReverseField1());
        ps.setString(6, data.getReverseField2());
        ps.setString(7, data.getUpdateUser());
        DateUtils.setDateTz(ps, 8, data.getUpdateTime());
        ps.setString(9, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_fttest_split_container WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<FttestSplitContainer> selectAll() throws SQLException {
    ArrayList<FttestSplitContainer> result = new ArrayList<FttestSplitContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FttestSplitContainer> selectByMarkingCode(String markingCode) throws SQLException {
    ArrayList<FttestSplitContainer> result = new ArrayList<FttestSplitContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE marking_code=?")) {
      ps.setString(1, markingCode);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<FttestSplitContainer> selectByContainerBo(String containerBo) throws SQLException {
    ArrayList<FttestSplitContainer> result = new ArrayList<FttestSplitContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE container_bo=?")) {
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FttestSplitContainer> selectByShopOrderBo(String shopOrderrBo) throws SQLException {
    ArrayList<FttestSplitContainer> result = new ArrayList<FttestSplitContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order_bo=?")) {
      ps.setString(1, shopOrderrBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public FttestSplitContainer selectByPK(String id) throws SQLException {
    FttestSplitContainer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FttestSplitContainer convert(ResultSet rs) throws SQLException {
    FttestSplitContainer data = new FttestSplitContainer();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setContainerBo(rs.getString(index++));
    data.setMarkingCode(rs.getString(index++));
    data.setReverseField1(rs.getString(index++));
    data.setReverseField2(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
