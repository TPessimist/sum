package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.ResourceRunBlock;
import ame.psb.db.ViewResourceRunBlock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ResourceRunBlockDao {

  private static final String SQL_INS = "INSERT INTO zd_resource_run_block(id,customer_bo,package_bo,item_group_bo,item_bo,router_bo,operation_bo,resource_bo,state_name,begin_time,end_time,recipe_name,action_comment,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_resource_run_block SET customer_bo=?,package_bo=?,item_group_bo=?,item_bo=?,router_bo=?,operation_bo=?,resource_bo=?,state_name=?,begin_time=?,end_time=?,recipe_name=?,action_comment=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,customer_bo,package_bo,item_group_bo,item_bo,router_bo,operation_bo,resource_bo,state_name,begin_time,end_time,recipe_name,action_comment,updated_user,updated_time,customer_name,package_name,item_group_name,item_name,router_name,operation_name,resource_name FROM view_resource_run_block ";

  private final Connection conn;

  public ResourceRunBlockDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ResourceRunBlock data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getCustomerBo());
      ps.setString(3, data.getPackageBo());
      ps.setString(4, data.getItemGroupBo());
      ps.setString(5, data.getItemBo());
      ps.setString(6, data.getRouterBo());
      ps.setString(7, data.getOperationBo());
      ps.setString(8, data.getResourceBo());
      ps.setString(9, data.getStateName());
      DateUtils.setDateTz(ps, 10, data.getBeginTime());
      DateUtils.setDateTz(ps, 11, data.getEndTime());
      ps.setString(12, data.getRecipeName());
      ps.setString(13, data.getActionComment());
      ps.setString(14, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 15, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int update(ResourceRunBlock data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomerBo());
      ps.setString(2, data.getPackageBo());
      ps.setString(3, data.getItemGroupBo());
      ps.setString(4, data.getItemBo());
      ps.setString(5, data.getRouterBo());
      ps.setString(6, data.getOperationBo());
      ps.setString(7, data.getResourceBo());
      ps.setString(8, data.getStateName());
      DateUtils.setDateTz(ps, 9, data.getBeginTime());
      DateUtils.setDateTz(ps, 10, data.getEndTime());
      ps.setString(11, data.getRecipeName());
      ps.setString(12, data.getActionComment());
      ps.setString(13, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 14, data.getUpdatedTime());
      ps.setString(15, data.getId());

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_resource_run_block WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ViewResourceRunBlock> selectByItem(String itemBo, String operationBo,
      String resourceBo) throws SQLException {
    ArrayList<ViewResourceRunBlock> result = new ArrayList<ViewResourceRunBlock>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ITEM_BO = ? and OPERATION_BO = ? and RESOURCE_BO = ?")) {
      ps.setString(1, itemBo);
      ps.setString(2, operationBo);
      ps.setString(3, resourceBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewResourceRunBlock> selectAll() throws SQLException {
    ArrayList<ViewResourceRunBlock> result = new ArrayList<ViewResourceRunBlock>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "ORDER BY resource_bo,customer_bo,package_bo,item_group_bo,item_bo,router_bo,operation_bo,state_name,begin_time")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewResourceRunBlock selectByPK(String id) throws SQLException {
    ViewResourceRunBlock result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewResourceRunBlock> selectByResource(String resource) throws SQLException {
    ArrayList<ViewResourceRunBlock> result = new ArrayList<ViewResourceRunBlock>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE resource_bo like ? ORDER BY resource_bo,customer_bo,package_bo,item_group_bo,item_bo,router_bo,operation_bo,state_name,begin_time")) {
      ps.setString(1, Env.genHandle("ResourceBO", resource + "%"));

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewResourceRunBlock> selectOnlineByResource(String resourceBo) throws SQLException {
    Date now = new Date();
    ArrayList<ViewResourceRunBlock> result = new ArrayList<ViewResourceRunBlock>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE state_name IN('ENABLE','OA') AND resource_bo=? AND begin_time<? AND (end_time is null OR end_time>?) ORDER BY customer_bo,package_bo,item_group_bo,item_bo,router_bo,operation_bo,begin_time")) {
      ps.setString(1, resourceBo);
      DateUtils.setDateTz(ps, 2, now);
      DateUtils.setDateTz(ps, 3, now);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewResourceRunBlock convert(ResultSet rs) throws SQLException {
    ViewResourceRunBlock data = new ViewResourceRunBlock();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setCustomerBo(rs.getString(index++));
    data.setPackageBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setRouterBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setBeginTime(DateUtils.getDateTz(rs, index++));
    data.setEndTime(DateUtils.getDateTz(rs, index++));
    data.setRecipeName(rs.getString(index++));
    data.setActionComment(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setCustomerName(rs.getString(index++));
    data.setPackageName(rs.getString(index++));
    data.setItemGroupName(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setRouterName(rs.getString(index++));
    data.setOperationName(rs.getString(index++));
    data.setResourceName(rs.getString(index++));

    return data;
  }

}
