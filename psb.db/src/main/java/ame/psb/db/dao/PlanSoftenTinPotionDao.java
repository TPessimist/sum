package ame.psb.db.dao;

import ame.psb.db.PlanSoftenTinPotion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PlanSoftenTinPotionDao {

  private static final String SQL_INS = "INSERT INTO zd_plan_soften_tin_potion(item_bo,slot_id,item_name,replacement_time,replacement_quantity,type,update_user,status,update_time,content1,content2) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_plan_soften_tin_potion SET item_name=?,replacement_time=?,replacement_quantity=?,type=?,status=?,update_time=?,content1=?,content2=? WHERE item_bo=? AND slot_id=? AND update_user=?";

  private static final String SQL_SEL = "SELECT item_bo,slot_id,item_name,replacement_time,replacement_quantity,type,update_user,status,update_time,content1,content2 FROM zd_plan_soften_tin_potion ";

  private final Connection conn;

  public PlanSoftenTinPotionDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PlanSoftenTinPotion data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemBo());
      ps.setString(2, data.getSlotId());
      ps.setString(3, data.getItemName());
      ps.setBigDecimal(4, data.getReplacementTime());
      ps.setBigDecimal(5, data.getReplacementQuantity());
      ps.setString(6, data.getType());
      ps.setString(7, data.getUpdateUser());
      ps.setString(8, data.getStatus());
      DateUtils.setDateTz(ps, 9, data.getUpdateTime());
      ps.setString(10, data.getContent1());
      ps.setString(11, data.getContent2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PlanSoftenTinPotion> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PlanSoftenTinPotion data : dataList) {
        ps.setString(1, data.getItemBo());
        ps.setString(2, data.getSlotId());
        ps.setString(3, data.getItemName());
        ps.setBigDecimal(4, data.getReplacementTime());
        ps.setBigDecimal(5, data.getReplacementQuantity());
        ps.setString(6, data.getType());
        ps.setString(7, data.getUpdateUser());
        ps.setString(8, data.getStatus());
        DateUtils.setDateTz(ps, 9, data.getUpdateTime());
        ps.setString(10, data.getContent1());
        ps.setString(11, data.getContent2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PlanSoftenTinPotion data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemName());
      ps.setBigDecimal(2, data.getReplacementTime());
      ps.setBigDecimal(3, data.getReplacementQuantity());
      ps.setString(4, data.getType());
      ps.setString(5, data.getStatus());
      DateUtils.setDateTz(ps, 6, data.getUpdateTime());
      ps.setString(7, data.getContent1());
      ps.setString(8, data.getContent2());
      ps.setString(9, data.getItemBo());
      ps.setString(10, data.getSlotId());
      ps.setString(11, data.getUpdateUser());

      return ps.executeUpdate();
    }
  }

  public int update(List<PlanSoftenTinPotion> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PlanSoftenTinPotion data : dataList) {
        ps.setString(1, data.getItemName());
        ps.setBigDecimal(2, data.getReplacementTime());
        ps.setBigDecimal(3, data.getReplacementQuantity());
        ps.setString(4, data.getType());
        ps.setString(5, data.getStatus());
        DateUtils.setDateTz(ps, 6, data.getUpdateTime());
        ps.setString(7, data.getContent1());
        ps.setString(8, data.getContent2());
        ps.setString(9, data.getItemBo());
        ps.setString(10, data.getSlotId());
        ps.setString(11, data.getUpdateUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemBo, String slotId, String updateUser) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_plan_soften_tin_potion WHERE item_bo=? AND slot_id=? AND update_user=?")) {
      ps.setString(1, itemBo);
      ps.setString(2, slotId);
      ps.setString(3, updateUser);
      return ps.executeUpdate();
    }
  }

  public List<PlanSoftenTinPotion> selectAll() throws SQLException {
    ArrayList<PlanSoftenTinPotion> result = new ArrayList<PlanSoftenTinPotion>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PlanSoftenTinPotion selectByPK(String itemBo, String slotId, String updateUser)
      throws SQLException {
    PlanSoftenTinPotion result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_bo=? AND slot_id=? AND update_user=?")) {
      ps.setString(1, itemBo);
      ps.setString(2, slotId);
      ps.setString(3, updateUser);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<PlanSoftenTinPotion> selectByItemBoAndSlotId(String itemBo, String slotId)
      throws SQLException {
    ArrayList<PlanSoftenTinPotion> result = new ArrayList<PlanSoftenTinPotion>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE item_bo=? AND slot_id=? order by update_time desc ")) {
      ps.setString(1, itemBo);
      ps.setString(2, slotId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PlanSoftenTinPotion> selectBySlotId(String slotId) throws SQLException {
    ArrayList<PlanSoftenTinPotion> result = new ArrayList<PlanSoftenTinPotion>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE  slot_id=? order by update_time desc ")) {
      ps.setString(1, slotId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PlanSoftenTinPotion> selectByItemBo(String itemBo)
      throws SQLException {
    ArrayList<PlanSoftenTinPotion> result = new ArrayList<PlanSoftenTinPotion>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE item_bo=? order by update_time desc ")) {
      ps.setString(1, itemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private PlanSoftenTinPotion convert(ResultSet rs) throws SQLException {
    PlanSoftenTinPotion data = new PlanSoftenTinPotion();

    int index = 1;
    data.setItemBo(rs.getString(index++));
    data.setSlotId(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setReplacementTime(rs.getBigDecimal(index++));
    data.setReplacementQuantity(rs.getBigDecimal(index++));
    data.setType(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setStatus(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setContent1(rs.getString(index++));
    data.setContent2(rs.getString(index++));

    return data;
  }
}
