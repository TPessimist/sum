package ame.psb.db.dao;

import ame.psb.db.ItemOperation;
import ame.psb.db.ViewItemOperation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ItemOperationDao {

  private static final String SQL_INS = "INSERT INTO zd_item_operation(item_bo,operation_bo,recipe_name,cycle_time,capability,yield_sfc,yield_sfc_item,updated_user,updated_time,yield_sfc_item_operation,DPT_OWNER) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_item_operation SET recipe_name=?,cycle_time=?,capability=?,yield_sfc=?,yield_sfc_item=?,updated_user=?,updated_time=? , yield_sfc_item_operation=? ,DPT_OWNER = ? WHERE item_bo=? AND operation_bo=?";

  private static final String SQL_SEL = "SELECT item_bo,operation_bo,recipe_name,cycle_time,capability,yield_sfc,yield_sfc_item,updated_user,updated_time,operation,item,router_bo,router,recipe_type,cycle_time_type,operation_type,yield_sfc_item_operation,DPT_OWNER FROM view_item_operation ";

  private Connection conn;

  public ItemOperationDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ItemOperation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getRecipeName());
      ps.setInt(4, data.getCycleTime());
      ps.setString(5, data.getCapability());
      ps.setBigDecimal(6, data.getYieldSfc());
      ps.setBigDecimal(7, data.getYieldSfcItem());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setBigDecimal(10, data.getYieldSfcItemOperation());
      ps.setString(11,data.getDptOwner());
      return ps.executeUpdate();
    }
  }

  public int update(ItemOperation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getRecipeName());
      ps.setInt(2, data.getCycleTime());
      ps.setString(3, data.getCapability());
      ps.setBigDecimal(4, data.getYieldSfc());
      ps.setBigDecimal(5, data.getYieldSfcItem());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setBigDecimal(8, data.getYieldSfcItemOperation());
      ps.setString(9, data.getDptOwner());
      ps.setString(10, data.getItemBo());
      ps.setString(11, data.getOperationBo());
      return ps.executeUpdate();
    }
  }

  public boolean exists(String itemBo, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE item_bo=? AND operation_bo=?")) {
      ps.setString(1, itemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      return rs.next();
    }
  }

  public ViewItemOperation selectByPK(String itemBo, String operationBo) throws SQLException {
    ViewItemOperation item = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE item_bo=? AND operation_bo=?")) {
      ps.setString(1, itemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = this.convert(rs);
      }
    }
    return item;
  }

  public List<ViewItemOperation> selectByItem(String itemBo) throws SQLException {
    ArrayList<ViewItemOperation> result = new ArrayList<ViewItemOperation>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE item_bo=? ORDER BY operation_bo")) {
      ps.setString(1, itemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewItemOperation> selectByItemAndType(String itemBo) throws SQLException {
    ArrayList<ViewItemOperation> result = new ArrayList<ViewItemOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE item_bo=? AND operation_type in ('I','B','C','XT','XB','XC') ORDER BY operation_bo")) {
      ps.setString(1, itemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewItemOperation> selectByItemPackage(String itemBo) throws SQLException {
    ArrayList<ViewItemOperation> result = new ArrayList<ViewItemOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE item_bo=? AND operation_type in ('I','B','XT') and operation_bo not like '%-TR%' ORDER BY operation_bo")) {
      ps.setString(1, itemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewItemOperation> selectByItemAndSpcificType(String itemBo, String type)
      throws SQLException {
    ArrayList<ViewItemOperation> result = new ArrayList<ViewItemOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " WHERE item_bo=? AND operation_type = ? AND operation_bo !='OperationBO:1020,CFC-FVI,#' ORDER BY operation_bo")) {
      ps.setString(1, itemBo);
      ps.setString(2, type);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewItemOperation> selectByOperation(String operationBo) throws SQLException {
    ArrayList<ViewItemOperation> result = new ArrayList<ViewItemOperation>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE operation_bo=? ORDER BY item_bo")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  private ViewItemOperation convert(ResultSet rs) throws SQLException {
    ViewItemOperation data = new ViewItemOperation();

    data.setItemBo(rs.getString(1));
    data.setOperationBo(rs.getString(2));
    data.setRecipeName(rs.getString(3));
    data.setCycleTime(rs.getInt(4));
    data.setCapability(rs.getString(5));
    data.setYieldSfc(rs.getBigDecimal(6));
    data.setYieldSfcItem(rs.getBigDecimal(7));

    data.setUpdatedUser(rs.getString(8));
    data.setUpdatedTime(DateUtils.getDateTz(rs, 9));
    data.setOperation(rs.getString(10));
    data.setItem(rs.getString(11));
    data.setRouterBo(rs.getString(12));
    data.setRouter(rs.getString(13));
    data.setRecipeType(rs.getString(14));
    data.setCycleTimeType(rs.getString(15));
    data.setOperationType(rs.getString(16));
    data.setYieldSfcItemOperation(rs.getBigDecimal(17));
    data.setDptOwner(rs.getString(18));

    return data;

  }

}
