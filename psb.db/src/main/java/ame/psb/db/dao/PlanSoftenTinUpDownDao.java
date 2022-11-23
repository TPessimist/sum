package ame.psb.db.dao;

import ame.psb.db.PlanSoftenTinUpDown;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PlanSoftenTinUpDownDao {

  private static final String SQL_INS = "INSERT INTO zd_plan_soften_tin_up_down(id,slot_id,inventory_bo,item_bo,item_name,inventory_id,resource,expire_time,type,item_description,update_user,create_time,content1,content2,replacement_quantity) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_plan_soften_tin_up_down SET slot_id=?,inventory_bo=?,item_bo=?,item_name=?,inventory_id=?,resource=?,expire_time=?,type=?,item_description=?,update_user=?,create_time=?,content1=?,content2=?,replacement_quantity=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,slot_id,inventory_bo,item_bo,item_name,inventory_id,resource,expire_time,type,item_description,update_user,create_time,content1,content2,replacement_quantity FROM zd_plan_soften_tin_up_down ";

  private final Connection conn;

  public PlanSoftenTinUpDownDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PlanSoftenTinUpDown data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSlotId());
      ps.setString(3, data.getInventoryBo());
      ps.setString(4, data.getItemBo());
      ps.setString(5, data.getItemName());
      ps.setString(6, data.getInventoryId());
      ps.setString(7, data.getResource());
      DateUtils.setDateTz(ps, 8, data.getExpireTime());
      ps.setString(9, data.getType());
      ps.setString(10, data.getItemDescription());
      ps.setString(11, data.getUpdateUser());
      DateUtils.setDateTz(ps, 12, data.getCreateTime());
      ps.setString(13, data.getContent1());
      ps.setString(14, data.getContent2());
      ps.setBigDecimal(15, data.getReplacementQuantity());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PlanSoftenTinUpDown> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PlanSoftenTinUpDown data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSlotId());
        ps.setString(3, data.getInventoryBo());
        ps.setString(4, data.getItemBo());
        ps.setString(5, data.getItemName());
        ps.setString(6, data.getInventoryId());
        ps.setString(7, data.getResource());
        DateUtils.setDateTz(ps, 8, data.getExpireTime());
        ps.setString(9, data.getType());
        ps.setString(10, data.getItemDescription());
        ps.setString(11, data.getUpdateUser());
        DateUtils.setDateTz(ps, 12, data.getCreateTime());
        ps.setString(13, data.getContent1());
        ps.setString(14, data.getContent2());
        ps.setBigDecimal(15, data.getReplacementQuantity());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PlanSoftenTinUpDown data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSlotId());
      ps.setString(2, data.getInventoryBo());
      ps.setString(3, data.getItemBo());
      ps.setString(4, data.getItemName());
      ps.setString(5, data.getInventoryId());
      ps.setString(6, data.getResource());
      DateUtils.setDateTz(ps, 7, data.getExpireTime());
      ps.setString(8, data.getType());
      ps.setString(9, data.getItemDescription());
      ps.setString(10, data.getUpdateUser());
      DateUtils.setDateTz(ps, 11, data.getCreateTime());
      ps.setString(12, data.getContent1());
      ps.setString(13, data.getContent2());
      ps.setBigDecimal(14, data.getReplacementQuantity());
      ps.setString(15, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<PlanSoftenTinUpDown> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PlanSoftenTinUpDown data : dataList) {
        ps.setString(1, data.getSlotId());
        ps.setString(2, data.getInventoryBo());
        ps.setString(3, data.getItemBo());
        ps.setString(4, data.getItemName());
        ps.setString(5, data.getInventoryId());
        ps.setString(6, data.getResource());
        DateUtils.setDateTz(ps, 7, data.getExpireTime());
        ps.setString(8, data.getType());
        ps.setString(9, data.getItemDescription());
        ps.setString(10, data.getUpdateUser());
        DateUtils.setDateTz(ps, 11, data.getCreateTime());
        ps.setString(12, data.getContent1());
        ps.setString(13, data.getContent2());
        ps.setBigDecimal(14, data.getReplacementQuantity());
        ps.setString(15, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_plan_soften_tin_up_down WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<PlanSoftenTinUpDown> selectAll() throws SQLException {
    ArrayList<PlanSoftenTinUpDown> result = new ArrayList<PlanSoftenTinUpDown>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PlanSoftenTinUpDown selectByPK(String id) throws SQLException {
    PlanSoftenTinUpDown result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PlanSoftenTinUpDown selectByInventoryBo(String inventoryBo) throws SQLException {
    PlanSoftenTinUpDown result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE inventory_bo=?")) {
      ps.setString(1, inventoryBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PlanSoftenTinUpDown selectByInventoryAndSlot(String inventoryBo, String slotId)
      throws SQLException {
    PlanSoftenTinUpDown result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE inventory_bo=? AND slot_id =?")) {
      ps.setString(1, inventoryBo);
      ps.setString(2, slotId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  //根据槽位号查询所有上料记录
  public List<PlanSoftenTinUpDown> selectBySlotId(String slotId) throws SQLException {
    ArrayList<PlanSoftenTinUpDown> result = new ArrayList<PlanSoftenTinUpDown>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE slot_id=? order by create_time desc ")) {
      ps.setString(1, slotId);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private PlanSoftenTinUpDown convert(ResultSet rs) throws SQLException {
    PlanSoftenTinUpDown data = new PlanSoftenTinUpDown();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSlotId(rs.getString(index++));
    data.setInventoryBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setInventoryId(rs.getString(index++));
    data.setResource(rs.getString(index++));
    data.setExpireTime(DateUtils.getDateTz(rs, index++));
    data.setType(rs.getString(index++));
    data.setItemDescription(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setCreateTime(DateUtils.getDateTz(rs, index++));
    data.setContent1(rs.getString(index++));
    data.setContent2(rs.getString(index++));
    data.setReplacementQuantity(rs.getBigDecimal(index++));

    return data;
  }
}
