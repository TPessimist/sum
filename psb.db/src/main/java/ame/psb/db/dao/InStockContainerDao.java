package ame.psb.db.dao;

import ame.psb.db.InStockContainer;
import ame.psb.db.ViewPkgContainer;
import ame.psb.db.conf.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.SapOnOffUtil;

public class InStockContainerDao {

  private static final String SQL_INS = "INSERT INTO zd_instock_container(id,action_name,state,content,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_instock_container SET action_name=?,state=?,content=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,action_name,state,content,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_instock_container ";

  private static final String SQL_SEL_TOP = "SELECT top ? id,action_name,state,content,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_instock_container ";

  private final Connection conn;

  public InStockContainerDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(String containerId, String actionName, String user, String stateName,
      String reversedField) throws SQLException {
    if (SapOnOffUtil.SAP_ON_FLAG && !SapOnOffUtil.SAP_IN_STOCK_FLAG) {
      throw new SQLException("当前时间段不允许入库");
    }

    //调用job卡控特殊时间段内不可入库
    if (!SapOnOffUtil.isSapInstockTime()) {
      throw new SQLException("注意：当前时间段不允许入库");
    }

    //调用job卡控特殊时间段内不可入库
    try (Connection conn = DB.create()) {
      ViewPkgContainer viewPkgContainer = new PkgContainerDao(conn).selectByPK(containerId);
      if (viewPkgContainer != null && viewPkgContainer.getCustomerItemLotNames() != null
          && viewPkgContainer.getCustomerItemLotNames().split(",").length > 1) {
        String shopOrderName = viewPkgContainer.getCustomerItemLotNames().split(",")[1];

        if (!SapOnOffUtil.isPermitTime() && shopOrderName.startsWith("A")) {
          throw new SQLException("注意：当前时间段不允许入库");
        }
      }
    }

    InStockContainer inStockContainer = selectByPK(containerId);
    if (null != inStockContainer) {
      return 0;
    }

    InStockContainer data = new InStockContainer();
    data.setId(containerId);
    data.setActionName(actionName);
    data.setState(stateName);
    data.setUpdatedUser(user);
    data.setUpdatedTime(new Date());

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getActionName());
      ps.setString(3, data.getState());
      ps.setString(4, data.getContent());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }


  public int insert(String containerId, String actionName, String user, String content)
      throws SQLException {
    if (SapOnOffUtil.SAP_ON_FLAG && !SapOnOffUtil.SAP_IN_STOCK_FLAG) {
      throw new SQLException("当前时间段不允许入库");
    }
    //调用job卡控特殊时间段内不可入库
    if (!SapOnOffUtil.isSapInstockTime()) {
      throw new SQLException("注意：当前时间段不允许入库");
    }

    //调用job卡控特殊时间段内不可入库
    try (Connection conn = DB.create()) {
      ViewPkgContainer viewPkgContainer = new PkgContainerDao(conn).selectByPK(containerId);
      if (viewPkgContainer != null && viewPkgContainer.getCustomerItemLotNames() != null
          && viewPkgContainer.getCustomerItemLotNames().split(",").length > 1) {
        String shopOrderName = viewPkgContainer.getCustomerItemLotNames().split(",")[1];

        if (!SapOnOffUtil.isPermitTime() && shopOrderName.startsWith("A")) {
          throw new SQLException("注意：当前时间段不允许入库");
        }
      }
    }

    InStockContainer data = new InStockContainer();
    data.setId(containerId);
    data.setActionName(actionName);
    data.setState("WAIT");
    data.setUpdatedUser(user);
    data.setUpdatedTime(new Date());
    data.setContent(content);

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getActionName());
      ps.setString(3, data.getState());
      ps.setString(4, data.getContent());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(InStockContainer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getActionName());
      ps.setString(3, data.getState());
      ps.setString(4, data.getContent());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<InStockContainer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (InStockContainer data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getActionName());
        ps.setString(3, data.getState());
        ps.setString(4, data.getContent());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(InStockContainer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getActionName());
      ps.setString(2, data.getState());
      ps.setString(3, data.getContent());
      ps.setString(4, data.getReversedField1());
      ps.setString(5, data.getReversedField2());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<InStockContainer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (InStockContainer data : dataList) {
        ps.setString(1, data.getActionName());
        ps.setString(2, data.getState());
        ps.setString(3, data.getContent());
        ps.setString(4, data.getReversedField1());
        ps.setString(5, data.getReversedField2());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_instock_container WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<InStockContainer> selectByState(String state) throws SQLException {
    ArrayList<InStockContainer> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where state  = ?")) {
      ps.setString(1, state);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<InStockContainer> selectByStateAndActionName(String state, String actionName)
      throws SQLException {
    ArrayList<InStockContainer> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where state  = ? and ACTION_NAME = ? ")) {
      ps.setString(1, state);
      ps.setString(2, actionName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<InStockContainer> selectByStateAndActionNameAndLimit(String state, String actionName,
      int limit)
      throws SQLException {
    ArrayList<InStockContainer> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_TOP + "where state  = ? and ACTION_NAME = ? ")) {
      ps.setInt(1, limit);
      ps.setString(2, state);
      ps.setString(3, actionName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<InStockContainer> selectAll() throws SQLException {
    ArrayList<InStockContainer> result = new ArrayList<InStockContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public InStockContainer selectByPK(String id) throws SQLException {
    InStockContainer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private InStockContainer convert(ResultSet rs) throws SQLException {
    InStockContainer data = new InStockContainer();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
