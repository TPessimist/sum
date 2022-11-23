package ame.psb.db.dao;

import ame.psb.db.ZdSoftenLinePotion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

/*
 * @author:cc
 * */
public class ZdSoftenLinePotionDao {

  private static final String SQL_INS = "INSERT INTO zd_soften_line_potion(id,handle,resource,resource_slot_id,item_bo,inventory_bo,state_name,update_user,created_date_time,modified_date_time,content1,content2,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ";

  private static final String SQL_UPD = "UPDATE zd_soften_line_potion SET handle=?,resource=?, resource_slot_id=?,item_bo=?,inventory_bo=?,state_name=?,update_user=?,created_date_time=?,modified_date_time=?,content1=?,content2=?,status=? WHERE id=? ";

  private static final String SQL_SEL = "SELECT id,handle,resource,resource_slot_id,item_bo,inventory_bo,state_name,update_user,created_date_time,modified_date_time,content1,content2,status FROM zd_soften_line_potion ";

  private final Connection conn;

  public ZdSoftenLinePotionDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdSoftenLinePotion data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getHandle());
      ps.setString(3, data.getResource());
      ps.setString(4, data.getResourceSlotId());
      ps.setString(5, data.getItemBo());
      ps.setString(6, data.getInventoryBo());
      ps.setString(7, data.getStateName());
      ps.setString(8, data.getUpdateUser());
      DateUtils.setDateTz(ps, 9, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 10, data.getModifiedDateTime());
      ps.setString(11, data.getContent1());
      ps.setString(12, data.getContent2());
      ps.setString(13, data.getStatus());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdSoftenLinePotion> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdSoftenLinePotion data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getHandle());
        ps.setString(3, data.getResource());
        ps.setString(4, data.getResourceSlotId());
        ps.setString(5, data.getItemBo());
        ps.setString(6, data.getInventoryBo());
        ps.setString(7, data.getStateName());
        ps.setString(8, data.getUpdateUser());
        DateUtils.setDateTz(ps, 9, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 10, data.getModifiedDateTime());
        ps.setString(11, data.getContent1());
        ps.setString(12, data.getContent2());
        ps.setString(13, data.getStatus());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZdSoftenLinePotion data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getResource());
      ps.setString(3, data.getResourceSlotId());
      ps.setString(4, data.getItemBo());
      ps.setString(5, data.getInventoryBo());
      ps.setString(6, data.getStateName());
      ps.setString(7, data.getUpdateUser());
      DateUtils.setDateTz(ps, 8, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 9, data.getModifiedDateTime());
      ps.setString(10, data.getContent1());
      ps.setString(11, data.getContent2());
      ps.setString(12, data.getStatus());
      ps.setString(13, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZdSoftenLinePotion> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZdSoftenLinePotion data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getResource());
        ps.setString(3, data.getResourceSlotId());
        ps.setString(4, data.getItemBo());
        ps.setString(5, data.getInventoryBo());
        ps.setString(6, data.getStateName());
        ps.setString(7, data.getUpdateUser());
        DateUtils.setDateTz(ps, 8, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 9, data.getModifiedDateTime());
        ps.setString(10, data.getContent1());
        ps.setString(11, data.getContent2());
        ps.setString(12, data.getStatus());
        ps.setString(13, data.getId());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_soften_line_potion WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByResource(String resource) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_soften_line_potion WHERE resource=?")) {
      ps.setString(1, resource);

      return ps.executeUpdate();
    }
  }

  public List<ZdSoftenLinePotion> selectAll() throws SQLException {
    ArrayList<ZdSoftenLinePotion> result = new ArrayList<ZdSoftenLinePotion>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  /*
   * id：uuid
   * */
  public ZdSoftenLinePotion selectById(String id) throws SQLException {
    ZdSoftenLinePotion result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ZdSoftenLinePotion selectBySlotIdAndItemBo(String resource, String itemBo)
      throws SQLException {
    ZdSoftenLinePotion result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE resource=? and item_bo=? and state_name='WAIT' ")) {
      ps.setString(1, resource);
      ps.setString(2, itemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ZdSoftenLinePotion selectByPK(String inventoryBo) throws SQLException {
    ZdSoftenLinePotion result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE inventory_bo=?")) {
      ps.setString(1, inventoryBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  /*
   * id：uuid
   * */
  public ZdSoftenLinePotion selectByHandle(String handle) throws SQLException {
    ZdSoftenLinePotion result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE handle=? and state_name='WAIT' ")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  /*
   * 根据上机编号查询
   * */
  public List<ZdSoftenLinePotion> selectByResource(String resource) throws SQLException {
    ArrayList<ZdSoftenLinePotion> result = new ArrayList<ZdSoftenLinePotion>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + " WHERE resource=? order by created_date_time desc limit 100")) {
      ps.setString(1, resource);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZdSoftenLinePotion> selectByPk2(String resource) throws SQLException {
    ArrayList<ZdSoftenLinePotion> result = new ArrayList<ZdSoftenLinePotion>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL
                + " WHERE resource=? and inventory_bo is not null and state_name in ('RUNNING') ")) {
      ps.setString(1, resource);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ZdSoftenLinePotion selectOneByResourceAndItemBo(String resource, String itemBo)
      throws SQLException {
    ZdSoftenLinePotion result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE resource=? and item_bo=?")) {
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
   * WAIT状态下根据上机编号、料号查询
   * */
  public List<ZdSoftenLinePotion> selectByResourceAndItemBo(String resource, String itemBo)
      throws SQLException {
    ArrayList<ZdSoftenLinePotion> result = new ArrayList<ZdSoftenLinePotion>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE resource=? and item_bo=? and state_name='WAIT' ")) {
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
   * 根据槽位号和库存编号查询
   * */
  public ZdSoftenLinePotion selectBySlotIdAndInventoryBo(String resourceSlotId,
      String inventoryBo)
      throws SQLException {
    ZdSoftenLinePotion result = new ZdSoftenLinePotion();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE resource_slot_id=? and inventory_bo=?")) {
      ps.setString(1, resourceSlotId);
      ps.setString(2, inventoryBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZdSoftenLinePotion convert(ResultSet rs) throws SQLException {
    ZdSoftenLinePotion data = new ZdSoftenLinePotion();
    int index = 1;

    data.setId(rs.getString(index++));
    data.setHandle(rs.getString(index++));
    data.setResource(rs.getString(index++));
    data.setResourceSlotId(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setInventoryBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setContent1(rs.getString(index++));
    data.setContent2(rs.getString(index++));
    data.setStatus(rs.getString(index++));
    return data;
  }
}
