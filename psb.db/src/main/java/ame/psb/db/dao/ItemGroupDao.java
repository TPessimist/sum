package ame.psb.db.dao;

import ame.psb.db.ItemGroup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ItemGroupDao {

  private static final String SQL_INS = "INSERT INTO item_group(handle,change_stamp,site,item_group,description,router_bo,bom_bo,mask_group_bo,created_date_time,modified_date_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE item_group SET change_stamp=?,site=?,item_group=?,description=?,router_bo=?,bom_bo=?,mask_group_bo=?,created_date_time=?,modified_date_time=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,change_stamp,site,item_group,description,router_bo,bom_bo,mask_group_bo,created_date_time,modified_date_time FROM item_group ";

  private final Connection conn;

  public ItemGroupDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ItemGroup data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setBigDecimal(2, data.getChangeStamp());
      ps.setString(3, data.getSite());
      ps.setString(4, data.getItemGroup());
      ps.setString(5, data.getDescription());
      ps.setString(6, data.getRouterBo());
      ps.setString(7, data.getBomBo());
      ps.setString(8, data.getMaskGroupBo());
      DateUtils.setDateTz(ps, 9, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 10, data.getModifiedDateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ItemGroup> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ItemGroup data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setBigDecimal(2, data.getChangeStamp());
        ps.setString(3, data.getSite());
        ps.setString(4, data.getItemGroup());
        ps.setString(5, data.getDescription());
        ps.setString(6, data.getRouterBo());
        ps.setString(7, data.getBomBo());
        ps.setString(8, data.getMaskGroupBo());
        DateUtils.setDateTz(ps, 9, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 10, data.getModifiedDateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ItemGroup data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getChangeStamp());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getItemGroup());
      ps.setString(4, data.getDescription());
      ps.setString(5, data.getRouterBo());
      ps.setString(6, data.getBomBo());
      ps.setString(7, data.getMaskGroupBo());
      DateUtils.setDateTz(ps, 8, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 9, data.getModifiedDateTime());
      ps.setString(10, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<ItemGroup> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ItemGroup data : dataList) {
        ps.setBigDecimal(1, data.getChangeStamp());
        ps.setString(2, data.getSite());
        ps.setString(3, data.getItemGroup());
        ps.setString(4, data.getDescription());
        ps.setString(5, data.getRouterBo());
        ps.setString(6, data.getBomBo());
        ps.setString(7, data.getMaskGroupBo());
        DateUtils.setDateTz(ps, 8, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 9, data.getModifiedDateTime());
        ps.setString(10, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM item_group WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<ItemGroup> selectAll() throws SQLException {
    ArrayList<ItemGroup> result = new ArrayList<ItemGroup>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ItemGroup selectByPK(String handle) throws SQLException {
    ItemGroup result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ItemGroup convert(ResultSet rs) throws SQLException {
    ItemGroup data = new ItemGroup();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setChangeStamp(rs.getBigDecimal(index++));
    data.setSite(rs.getString(index++));
    data.setItemGroup(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setRouterBo(rs.getString(index++));
    data.setBomBo(rs.getString(index++));
    data.setMaskGroupBo(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
