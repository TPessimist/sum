package ame.psb.db.dao;

import ame.psb.db.SpecialMaterialControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SpecialMaterialControlDao {

  private static final String SQL_INS = "INSERT INTO zr_special_material_control(id,resource_bo,item_bo,wafer_count,wafer_count_result,sfc_count,sfc_count_result,minutes,minutes_result,begin_time,end_time,state,updated_user,updated_time,dummy_shop_order_bo,reverse_field1,reverse_field2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_special_material_control SET resource_bo=?,item_bo=?,wafer_count=?,wafer_count_result=?,sfc_count=?,sfc_count_result=?,minutes=?,minutes_result=?,begin_time=?,end_time=?,state=?,updated_user=?,updated_time=?,dummy_shop_order_bo=?,reverse_field1=?,reverse_field2=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resource_bo,item_bo,wafer_count,wafer_count_result,sfc_count,sfc_count_result,minutes,minutes_result,begin_time,end_time,state,updated_user,updated_time,dummy_shop_order_bo,reverse_field1,reverse_field2 FROM zr_special_material_control ";

  private final Connection conn;

  public SpecialMaterialControlDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SpecialMaterialControl data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getItemBo());
      ps.setInt(4, data.getWaferCount());
      ps.setInt(5, data.getWaferCountResult());
      ps.setInt(6, data.getSfcCount());
      ps.setInt(7, data.getSfcCountResult());
      ps.setInt(8, data.getMinutes());
      ps.setInt(9, data.getMinutesResult());
      DateUtils.setDateTz(ps, 10, data.getBeginTime());
      DateUtils.setDateTz(ps, 11, data.getEndTime());
      ps.setString(12, data.getState());
      ps.setString(13, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 14, data.getUpdatedTime());
      ps.setString(15, data.getDummyShopOrderBo());
      ps.setString(16, data.getReverseField1());
      ps.setString(17, data.getReverseField2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SpecialMaterialControl> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SpecialMaterialControl data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getItemBo());
        ps.setInt(4, data.getWaferCount());
        ps.setInt(5, data.getWaferCountResult());
        ps.setInt(6, data.getSfcCount());
        ps.setInt(7, data.getSfcCountResult());
        ps.setInt(8, data.getMinutes());
        ps.setInt(9, data.getMinutesResult());
        DateUtils.setDateTz(ps, 10, data.getBeginTime());
        DateUtils.setDateTz(ps, 11, data.getEndTime());
        ps.setString(12, data.getState());
        ps.setString(13, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 14, data.getUpdatedTime());
        ps.setString(15, data.getDummyShopOrderBo());
        ps.setString(16, data.getReverseField1());
        ps.setString(17, data.getReverseField2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SpecialMaterialControl data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getItemBo());
      ps.setInt(3, data.getWaferCount());
      ps.setInt(4, data.getWaferCountResult());
      ps.setInt(5, data.getSfcCount());
      ps.setInt(6, data.getSfcCountResult());
      ps.setInt(7, data.getMinutes());
      ps.setInt(8, data.getMinutesResult());
      DateUtils.setDateTz(ps, 9, data.getBeginTime());
      DateUtils.setDateTz(ps, 10, data.getEndTime());
      ps.setString(11, data.getState());
      ps.setString(12, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 13, data.getUpdatedTime());
      ps.setString(14, data.getDummyShopOrderBo());
      ps.setString(15, data.getReverseField1());
      ps.setString(16, data.getReverseField2());
      ps.setString(17, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<SpecialMaterialControl> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SpecialMaterialControl data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getItemBo());
        ps.setInt(3, data.getWaferCount());
        ps.setInt(4, data.getWaferCountResult());
        ps.setInt(5, data.getSfcCount());
        ps.setInt(6, data.getSfcCountResult());
        ps.setInt(7, data.getMinutes());
        ps.setInt(8, data.getMinutesResult());
        DateUtils.setDateTz(ps, 9, data.getBeginTime());
        DateUtils.setDateTz(ps, 10, data.getEndTime());
        ps.setString(11, data.getState());
        ps.setString(12, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 13, data.getUpdatedTime());
        ps.setString(14, data.getDummyShopOrderBo());
        ps.setString(15, data.getReverseField1());
        ps.setString(16, data.getReverseField2());
        ps.setString(17, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_special_material_control WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<SpecialMaterialControl> selectAll() throws SQLException {
    ArrayList<SpecialMaterialControl> result = new ArrayList<SpecialMaterialControl>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SpecialMaterialControl selectByPK(String id) throws SQLException {
    SpecialMaterialControl result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  /*
   * by 机台检索
   * */
  public List<SpecialMaterialControl> selectByResource(String resource) throws SQLException {
    ArrayList<SpecialMaterialControl> result = new ArrayList<SpecialMaterialControl>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE resource_bo=? and state in ('NEW','RUNNING') ")) {
      ps.setString(1, resource);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  /*
   * by 机台检索
   * */
  public List<SpecialMaterialControl> selectByResourceAndState(String resource, String state)
      throws SQLException {
    ArrayList<SpecialMaterialControl> result = new ArrayList<SpecialMaterialControl>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE resource_bo=? and state = ? ")) {
      ps.setString(1, resource);
      ps.setString(2, state);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  /*
   * by 机台、物料和状态检索
   * */
  public List<SpecialMaterialControl> selectByResourceAndItemBoAndState(String resource,
      String itemBo)
      throws SQLException {
    ArrayList<SpecialMaterialControl> result = new ArrayList<SpecialMaterialControl>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE resource_bo=? and item_bo=? and state in ('NEW','RUNNING') ")) {
      ps.setString(1, resource);
      ps.setString(2, itemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  /*
   * by 机台、物料检索
   * */
  public SpecialMaterialControl selectByResourceAndItemBo(String resource, String itemBo)
      throws SQLException {
    SpecialMaterialControl result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE resource_bo=? and item_bo=? and state='NEW' ")) {
      ps.setString(1, resource);
      ps.setString(2, itemBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  /*
   * by 机台、dummy工单
   * */
  public SpecialMaterialControl selectByShopOrder(String dummyShopOrderBo, String state)
      throws SQLException {
    SpecialMaterialControl result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE dummy_shop_order_bo=? and state=? ")) {
      ps.setString(1, dummyShopOrderBo);
      ps.setString(2, state);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  /*
   * 机台只能装配一个工单
   * */
  public SpecialMaterialControl selectByShopOrder(String DummyshopOrderBo)
      throws SQLException {
    SpecialMaterialControl result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + " WHERE dummy_shop_order_bo=? and state in ('NEW','RUNNING') ")) {
      ps.setString(1, DummyshopOrderBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SpecialMaterialControl convert(ResultSet rs) throws SQLException {
    SpecialMaterialControl data = new SpecialMaterialControl();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setWaferCount(rs.getInt(index++));
    data.setWaferCountResult(rs.getInt(index++));
    data.setSfcCount(rs.getInt(index++));
    data.setSfcCountResult(rs.getInt(index++));
    data.setMinutes(rs.getInt(index++));
    data.setMinutesResult(rs.getInt(index++));
    data.setBeginTime(DateUtils.getDateTz(rs, index++));
    data.setEndTime(DateUtils.getDateTz(rs, index++));
    data.setState(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setDummyShopOrderBo(rs.getString(index++));
    data.setReverseField1(rs.getString(index++));
    data.setReverseField2(rs.getString(index++));

    return data;
  }
}
