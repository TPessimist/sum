package ame.me.db.dao;

import ame.me.db.ItemBomOperation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBomOperationDao {

  private static final String SQL_SEL = "SELECT item_bo,operation_bo,bom_bo,bom_component_bo,bom_component_item_bo,site,item_description,bom_description,item,item_type,item_status_bo,component_group_bo,qty,bom_operation_bo FROM view_item_bom_operation ";

  private final Connection conn;

  public ItemBomOperationDao(Connection conn) {
    this.conn = conn;
  }

  public List<ItemBomOperation> select(String itemBo, String operationBo) throws SQLException {
    ArrayList<ItemBomOperation> result = new ArrayList<ItemBomOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_bo=? AND operation_bo=? ORDER BY bom_component_item_bo")) {
      ps.setString(1, itemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ItemBomOperation> select(String itemBo) throws SQLException {
    ArrayList<ItemBomOperation> result = new ArrayList<ItemBomOperation>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_bo=? ORDER BY bom_component_item_bo")) {
      ps.setString(1, itemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ItemBomOperation convert(ResultSet rs) throws SQLException {
    ItemBomOperation data = new ItemBomOperation();

    int index = 1;
    data.setItemBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setBomBo(rs.getString(index++));
    data.setBomComponentBo(rs.getString(index++));
    data.setBomComponentItemBo(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setItemDescription(rs.getString(index++));
    data.setBomDescription(rs.getString(index++));
    data.setItem(rs.getString(index++));
    data.setItemType(rs.getString(index++));
    data.setItemStatusBo(rs.getString(index++));
    data.setComponentGroupBo(rs.getString(index++));
    data.setQty(rs.getBigDecimal(index++));
    data.setBomOperationBo(rs.getString(index++));

    return data;
  }
}
