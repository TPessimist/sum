package ame.psb.db.dao;

import ame.psb.db.Dcop;
import ame.psb.db.ViewDcop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class DcopDao {

  private static final String SQL_INS = "INSERT INTO zd_dcop(id,operation_bo,dc_group_bo,item_group_bo,wafer_selector,die_count,dc_count,updated_user,updated_time,hold_operation_bo,state_name,check_flag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_dcop SET operation_bo=?,dc_group_bo=?,item_group_bo=?,wafer_selector=?,die_count=?,dc_count=?,updated_user=?,updated_time=?,hold_operation_bo=?,state_name=?,check_flag=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,operation_bo,dc_group_bo,item_group_bo,wafer_selector,die_count,dc_count,updated_user,updated_time,hold_operation_bo,state_name,dc_group_name,dc_group_description,item_group_name,operation_name,hold_operation_name,check_flag FROM view_dcop ";

  private final Connection conn;

  public DcopDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Dcop data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getDcGroupBo());
      ps.setString(4, data.getItemGroupBo());
      ps.setString(5, data.getWaferSelector());
      ps.setInt(6, data.getDieCount());
      ps.setInt(7, data.getDcCount());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getHoldOperationBo());
      ps.setString(11, data.getStateName());
      ps.setString(12, data.getCheckFlag());

      return ps.executeUpdate();
    }
  }

  public void insert(List<Dcop> dataList) throws SQLException {
    String sqlInsert = "INSERT INTO zd_dcop(id,operation_bo,dc_group_bo,item_group_bo,wafer_selector,die_count,dc_count,item_bo,updated_user,updated_time,hold_operation_bo,state_name,check_flag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    try (PreparedStatement ps = this.conn.prepareStatement(sqlInsert)) {
      for (Dcop data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getDcGroupBo());
        ps.setString(4, data.getItemGroupBo());
        ps.setString(5, data.getWaferSelector());
        ps.setInt(6, data.getDieCount());
        ps.setInt(7, data.getDcCount());
        ps.setString(8, data.getItemBo());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
        ps.setString(11, data.getHoldOperationBo());
        ps.setString(12, data.getStateName());
        ps.setString(13, data.getCheckFlag());

        ps.addBatch();
      }
      ps.executeBatch();
    }
  }

  public int update(Dcop data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getOperationBo());
      ps.setString(2, data.getDcGroupBo());
      ps.setString(3, data.getItemGroupBo());
      ps.setString(4, data.getWaferSelector());
      ps.setInt(5, data.getDieCount());
      ps.setInt(6, data.getDcCount());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getHoldOperationBo());
      ps.setString(10, data.getStateName());
      ps.setString(11, data.getCheckFlag());
      ps.setString(12, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<Dcop> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Dcop data : dataList) {
        ps.setString(1, data.getOperationBo());
        ps.setString(2, data.getDcGroupBo());
        ps.setString(3, data.getItemGroupBo());
        ps.setString(4, data.getWaferSelector());
        ps.setInt(5, data.getDieCount());
        ps.setInt(6, data.getDcCount());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getHoldOperationBo());
        ps.setString(10, data.getStateName());
        ps.setString(11, data.getCheckFlag());
        ps.setString(12, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public ViewDcop selectByPK(String id) throws SQLException {
    ViewDcop result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public List<ViewDcop> selectAll() throws SQLException {
    ArrayList<ViewDcop> result = new ArrayList<ViewDcop>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewDcop> select(Where where) throws SQLException {
    ArrayList<ViewDcop> result = new ArrayList<ViewDcop>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewDcop> select(String operationBo, String itemGroupBo) throws SQLException {
    ArrayList<ViewDcop> result = new ArrayList<ViewDcop>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE operation_bo=? AND item_group_bo=? ORDER BY id")) {
      ps.setString(1, operationBo);
      ps.setString(2, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewDcop> select(String operationBo, String itemGroupBo, String dcGroupBo,
      String stateName) throws SQLException {
    ArrayList<ViewDcop> result = new ArrayList<ViewDcop>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE operation_bo=? AND item_group_bo=? AND dc_group_bo=? AND state_name=? ORDER BY id")) {
      ps.setString(1, operationBo);
      ps.setString(2, itemGroupBo);
      ps.setString(3, dcGroupBo);
      ps.setString(4, stateName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewDcop> selectByAll(String operationBo, String itemGroupBo, String dcGroupBo)
      throws SQLException {
    ArrayList<ViewDcop> result = new ArrayList<ViewDcop>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE operation_bo=? AND item_group_bo=? AND dc_group_bo=?  ORDER BY id")) {
      ps.setString(1, operationBo);
      ps.setString(2, itemGroupBo);
      ps.setString(3, dcGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewDcop> selectByItemGroupBo(String itemGroupBo)
      throws SQLException {
    ArrayList<ViewDcop> result = new ArrayList<ViewDcop>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? ORDER BY id")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewDcop convert(ResultSet rs) throws SQLException {
    ViewDcop data = new ViewDcop();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDcGroupBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setWaferSelector(rs.getString(index++));
    data.setDieCount(rs.getInt(index++));
    data.setDcCount(rs.getInt(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setHoldOperationBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setDcGroupName(rs.getString(index++));
    data.setDcGroupDescription(rs.getString(index++));
    data.setItemGroupName(rs.getString(index++));
    data.setOperationName(rs.getString(index++));
    data.setHoldOperationName(rs.getString(index++));
    data.setCheckFlag(rs.getString(index++));
    return data;
  }

  public List<Dcop> select(String itemGroupBoFrom) throws SQLException {
    String selSql = "select * from zd_dcop where item_group_bo=?  ORDER BY id";
    ArrayList<Dcop> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, itemGroupBoFrom);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Dcop data = new Dcop();
        data.setId(rs.getString("id"));
        data.setOperationBo(rs.getString("operation_bo"));
        data.setDcGroupBo(rs.getString("dc_group_bo"));
        data.setItemGroupBo(rs.getString("item_group_bo"));
        data.setWaferSelector(rs.getString("wafer_selector"));
        data.setDieCount(rs.getInt("die_count"));
        data.setDcCount(rs.getInt("dc_count"));
        data.setItemBo(rs.getString("item_bo"));
        data.setUpdatedUser(rs.getString("updated_user"));
        data.setUpdatedTime(rs.getDate("updated_time"));
        data.setHoldOperationBo(rs.getString("hold_operation_bo"));
        data.setStateName(rs.getString("state_name"));
        data.setCheckFlag(rs.getString("check_flag"));

        result.add(data);
      }
      return result;
    }
  }

  public List<Dcop> selectNoDisable(String itemGroupBoFrom) throws SQLException {
    String selSql = "select * from zd_dcop where item_group_bo=? AND STATE_NAME != 'DISABLE' ORDER BY id";
    ArrayList<Dcop> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, itemGroupBoFrom);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Dcop data = new Dcop();
        data.setId(rs.getString("id"));
        data.setOperationBo(rs.getString("operation_bo"));
        data.setDcGroupBo(rs.getString("dc_group_bo"));
        data.setItemGroupBo(rs.getString("item_group_bo"));
        data.setWaferSelector(rs.getString("wafer_selector"));
        data.setDieCount(rs.getInt("die_count"));
        data.setDcCount(rs.getInt("dc_count"));
        data.setItemBo(rs.getString("item_bo"));
        data.setUpdatedUser(rs.getString("updated_user"));
        data.setUpdatedTime(rs.getDate("updated_time"));
        data.setHoldOperationBo(rs.getString("hold_operation_bo"));
        data.setStateName(rs.getString("state_name"));
        data.setCheckFlag(rs.getString("check_flag"));
        result.add(data);
      }
      return result;
    }
  }
}