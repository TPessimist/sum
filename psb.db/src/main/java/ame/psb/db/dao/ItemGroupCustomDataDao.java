package ame.psb.db.dao;

import ame.psb.db.ItemGroupCustomData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ItemGroupCustomDataDao {

  private static final String SQL_INS = "INSERT INTO zd_item_group_custom_data(item_group_bo,custom_name,custom_value,comment,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_item_group_custom_data SET custom_value=?,comment=?,updated_user=?,updated_time=? WHERE item_group_bo=? AND custom_name=?";

  private static final String SQL_SEL = "SELECT item_group_bo,custom_name,custom_value,comment,updated_user,updated_time FROM zd_item_group_custom_data ";

  private final Connection conn;

  public ItemGroupCustomDataDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ItemGroupCustomData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getCustomName());
      ps.setString(3, data.getCustomValue());
      ps.setString(4, data.getComment());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ItemGroupCustomData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ItemGroupCustomData data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getCustomName());
        ps.setString(3, data.getCustomValue());
        ps.setString(4, data.getComment());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ItemGroupCustomData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomValue());
      ps.setString(2, data.getComment());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getItemGroupBo());
      ps.setString(6, data.getCustomName());

      return ps.executeUpdate();
    }
  }

  public int update(List<ItemGroupCustomData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ItemGroupCustomData data : dataList) {
        ps.setString(1, data.getCustomValue());
        ps.setString(2, data.getComment());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getItemGroupBo());
        ps.setString(6, data.getCustomName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemGroupBo, String customName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_item_group_custom_data WHERE item_group_bo=? AND custom_name=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, customName);

      return ps.executeUpdate();
    }
  }

  public List<ItemGroupCustomData> selectAll() throws SQLException {
    ArrayList<ItemGroupCustomData> result = new ArrayList<ItemGroupCustomData>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ItemGroupCustomData selectByPK(String itemGroupBo, String customName) throws SQLException {
    ItemGroupCustomData result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? AND custom_name=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, customName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ItemGroupCustomData convert(ResultSet rs) throws SQLException {
    ItemGroupCustomData data = new ItemGroupCustomData();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setCustomName(rs.getString(index++));
    data.setCustomValue(rs.getString(index++));
    data.setComment(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
