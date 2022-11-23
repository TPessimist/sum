package ame.psb.db.dao;

import ame.psb.db.ViewZrPkgContainer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ykq
 */
public class ViewZrPkgContainerDao {

  private static final String SQL_SEL = "SELECT  TOP 1 id,container_name,packing_plan_bo,item_group_bo,operation_bo,item_level,container_type,pkg_container_bo,curr_step,state_name,customer_itemset_bo,customer_item_bo,item_bo,good_bad,packing_time,packing_user,good_die,bad_die1,bad_die2,dn_no,container_seq_id,customer_itemset_names,customer_item_names,flag_customer_special_package,flag_split_by_customer_itemset,seq,container_weight,container_volume FROM view_zr_pkg_container ";

  private static final String SQL_SEL_All = "SELECT  id,container_name,packing_plan_bo,item_group_bo,operation_bo,item_level,container_type,pkg_container_bo,curr_step,state_name,customer_itemset_bo,customer_item_bo,item_bo,good_bad,packing_time,packing_user,good_die,bad_die1,bad_die2,dn_no,container_seq_id,customer_itemset_names,customer_item_names,flag_customer_special_package,flag_split_by_customer_itemset,seq,container_weight,container_volume FROM view_zr_pkg_container ";

  private final Connection conn;

  public ViewZrPkgContainerDao(Connection conn) {
    this.conn = conn;
  }

  /**
   * 包装报表 查询
   *
   * @param id            容器编号
   * @param containerName 箱号
   * @param seq           唯一码
   * @return
   * @throws SQLException
   */
  public ViewZrPkgContainer selectAll(String id, String containerName, String seq)
      throws SQLException {
    ViewZrPkgContainer result = new ViewZrPkgContainer();
    String sql = "";
    if (!id.equals(null) && !id.equals("")) {
      sql = "  WHERE ID = ? ORDER BY PRINT_TIME DESC";
    } else if (!containerName.equals(null) && !containerName.equals("")) {
      sql = "  WHERE CONTAINER_NAME = ? ORDER BY PRINT_TIME DESC ";
    } else if (!seq.equals(null) && !seq.equals("")) {
      sql = "  WHERE SEQ = ? ORDER BY PRINT_TIME DESC ";
    }
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + sql)) {
      if (!id.equals(null) && !id.equals("")) {
        ps.setString(1, id);
      } else if (!containerName.equals(null) && !containerName.equals("")) {
        ps.setString(1, containerName);
      } else if (!seq.equals(null) && !seq.equals("")) {
        ps.setString(1, seq);
      }
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewZrPkgContainer selectById(String id) throws SQLException {
    ViewZrPkgContainer result = new ViewZrPkgContainer();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE ID = ? ORDER BY PRINT_TIME DESC")) {
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewZrPkgContainer> selectByIdList(String id) throws SQLException {
    List<ViewZrPkgContainer> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_All + " WHERE ID = ? ORDER BY PRINT_TIME DESC")) {
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewZrPkgContainer selectByContainerbo(String pkgContainerBo) throws SQLException {
    ViewZrPkgContainer result = new ViewZrPkgContainer();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE pkg_container_bo = ? ORDER BY PRINT_TIME DESC")) {
      ps.setString(1, pkgContainerBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewZrPkgContainer> selectByContainerboAll(String pkgContainerBo)
      throws SQLException {
    List<ViewZrPkgContainer> result = new ArrayList<ViewZrPkgContainer>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_All + " WHERE pkg_container_bo = ? ORDER BY PRINT_TIME DESC")) {
      ps.setString(1, pkgContainerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewZrPkgContainer convert(ResultSet rs) throws SQLException {
    ViewZrPkgContainer data = new ViewZrPkgContainer();
    int index = 1;
    data.setId(rs.getString(index++));
    data.setContainerName(rs.getString(index++));
    data.setPackingPlanBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setItemLevel(rs.getString(index++));
    data.setContainerType(rs.getString(index++));
    data.setPkgContainerBo(rs.getString(index++));
    data.setCurrStep(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCustomerItemsetBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setGoodBad(rs.getString(index++));
    data.setPackingTime(rs.getString(index++));
    data.setPackingUser(rs.getString(index++));
    data.setGoodDie(rs.getInt(index++));
    data.setBadDie1(rs.getInt(index++));
    data.setBadDie2(rs.getInt(index++));
    data.setDnNo(rs.getString(index++));
    data.setContainerSeqId(rs.getString(index++));
    data.setCustomerItemsetNames(rs.getString(index++));
    data.setCustomerItemNames(rs.getString(index++));
    data.setFlagCustomerSpecialPackage(rs.getString(index++));
    data.setFlagSplitByCustomerItemset(rs.getString(index++));
    data.setSeq(rs.getString(index++));
    data.setContainerWeight(rs.getString(index++));
    data.setContainerVolume(rs.getString(index++));
    return data;
  }
}
