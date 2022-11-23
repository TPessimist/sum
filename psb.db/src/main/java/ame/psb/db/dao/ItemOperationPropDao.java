package ame.psb.db.dao;

import ame.psb.db.ItemOperationProp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import uia.utils.dao.DateUtils;

public class ItemOperationPropDao {

  private static final String SQL_INS = "INSERT INTO zd_item_operation_prop(item_bo,operation_bo,prop_name,prop_value,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_item_operation_prop SET prop_value=?,updated_user=?,updated_time=? WHERE item_bo=? AND operation_bo=? AND prop_name=?";

  private static final String SQL_SEL = "SELECT item_bo,operation_bo,prop_name,prop_value,updated_user,updated_time FROM zd_item_operation_prop ";

  private final Connection conn;

  public ItemOperationPropDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ItemOperationProp data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getPropName());
      ps.setString(4, data.getPropValue());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int update(ItemOperationProp data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getPropValue());
      ps.setString(2, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
      ps.setString(4, data.getItemBo());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getPropName());

      return ps.executeUpdate();
    }
  }

  public int delete(String itemBo, String operationBo, String propName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_item_operation_prop WHERE item_bo=? AND operation_bo=? AND prop_name=?")) {
      ps.setString(1, itemBo);
      ps.setString(2, operationBo);
      ps.setString(3, propName);

      return ps.executeUpdate();
    }
  }

  public Map<String, String> select(String itemBo, String operationBo) throws SQLException {
    Map<String, String> result = new TreeMap<String, String>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_bo=? AND operation_bo=?")) {
      ps.setString(1, itemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.put(rs.getString(3), rs.getString(4));
      }
      return result;
    }
  }

  public ItemOperationProp selectByPK(String itemBo, String operationBo, String propName)
      throws SQLException {
    ItemOperationProp result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_bo=? AND operation_bo=? AND prop_name=?")) {
      ps.setString(1, itemBo);
      ps.setString(2, operationBo);
      ps.setString(3, propName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ItemOperationProp> selectByPKAll(String itemBo, String operationBo)
      throws SQLException {
    List<ItemOperationProp> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_bo=? AND operation_bo=?")) {
      ps.setString(1, itemBo);
      ps.setString(2, operationBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  public List<ItemOperationProp> selectByOperationBo(String operationBo)
      throws SQLException {
    List<ItemOperationProp> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE  operation_bo=?")) {
      ps.setString(1, operationBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  public List<ItemOperationProp> selectByPKList(String itemBo) throws SQLException {
    List<ItemOperationProp> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE item_bo=? ")) {
      ps.setString(1, itemBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ItemOperationProp convert(ResultSet rs) throws SQLException {
    ItemOperationProp data = new ItemOperationProp();

    int index = 1;
    data.setItemBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setPropName(rs.getString(index++));
    data.setPropValue(rs.getString(index++));

    return data;
  }
}
