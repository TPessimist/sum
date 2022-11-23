package ame.me.db.dao;

import ame.me.db.ItemGroupMember;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemGroupMemberDao {

  private static final String SQL_SEL = "SELECT handle,item_group_bo,item_bo FROM item_group_member ";

  private static final String SQL_INS = "INSERT INTO WIP.ITEM_GROUP_MEMBER (HANDLE, ITEM_GROUP_BO, ITEM_BO)VALUES(?,?,?)";

  private final Connection conn;

  public ItemGroupMemberDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ItemGroupMember data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getItemGroupBo());
      ps.setString(3, data.getItemBo());
      return ps.executeUpdate();
    }
  }

  public List<ItemGroupMember> selectAll() throws SQLException {
    ArrayList<ItemGroupMember> result = new ArrayList<ItemGroupMember>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ItemGroupMember selectByPK(String handle) throws SQLException {
    ItemGroupMember result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ItemGroupMember> selectByItemGroupBo(String itemGroupBo) throws SQLException {
    ArrayList<ItemGroupMember> result = new ArrayList<ItemGroupMember>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE	item_group_bo=?")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ItemGroupMember selectByItemBo(String itemBo) throws SQLException {
    ItemGroupMember result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE item_bo=?")) {
      ps.setString(1, itemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ItemGroupMember convert(ResultSet rs) throws SQLException {
    ItemGroupMember data = new ItemGroupMember();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));

    return data;
  }


}