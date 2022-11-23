package ame.psb.db.dao;

import ame.psb.db.ItemGroupInStockOperation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ItemGroupInStockOperationDao {

  private static final String SQL_INS = "INSERT INTO zd_item_group_instock_operation(item_group_bo,operation_bo,instock_type,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_item_group_instock_operation SET reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE item_group_bo=? AND operation_bo=? AND instock_type=?";

  private static final String SQL_SEL = "SELECT item_group_bo,operation_bo,instock_type,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_item_group_instock_operation ";

  private final Connection conn;

  public ItemGroupInStockOperationDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ItemGroupInStockOperation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getInstockType());
      ps.setString(4, data.getReversedField1());
      ps.setString(5, data.getReversedField2());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ItemGroupInStockOperation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ItemGroupInStockOperation data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getInstockType());
        ps.setString(4, data.getReversedField1());
        ps.setString(5, data.getReversedField2());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ItemGroupInStockOperation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getReversedField1());
      ps.setString(2, data.getReversedField2());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getItemGroupBo());
      ps.setString(6, data.getOperationBo());
      ps.setString(7, data.getInstockType());

      return ps.executeUpdate();
    }
  }

  public int update(List<ItemGroupInStockOperation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ItemGroupInStockOperation data : dataList) {
        ps.setString(1, data.getReversedField1());
        ps.setString(2, data.getReversedField2());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getItemGroupBo());
        ps.setString(6, data.getOperationBo());
        ps.setString(7, data.getInstockType());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemGroupBo, String operationBo, String instockType)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_item_group_instock_operation WHERE item_group_bo=? AND operation_bo=? AND instock_type=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, instockType);

      return ps.executeUpdate();
    }
  }

  public List<ItemGroupInStockOperation> selectAll() throws SQLException {
    ArrayList<ItemGroupInStockOperation> result = new ArrayList<ItemGroupInStockOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public  List<ItemGroupInStockOperation>  selectByPKItemGroupBo(String itemGroupBo) throws SQLException {
    List<ItemGroupInStockOperation> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? ")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs)) ;
      }
      return result;
    }
  }
  public ItemGroupInStockOperation selectByPK(String itemGroupBo, String operationBo,
      String instockType) throws SQLException {
    ItemGroupInStockOperation result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? AND operation_bo=? AND instock_type=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, instockType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ItemGroupInStockOperation convert(ResultSet rs) throws SQLException {
    ItemGroupInStockOperation data = new ItemGroupInStockOperation();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setInstockType(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
