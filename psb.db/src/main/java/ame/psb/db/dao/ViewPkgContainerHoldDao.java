package ame.psb.db.dao;

import ame.psb.db.ViewPkgContainerHold;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class ViewPkgContainerHoldDao {

  private static final String SQL_SEL = "SELECT id,container_name,packing_plan_bo,item_group_bo,operation_bo,item_level,container_type,pkg_container_bo,curr_step,state_name,customer_itemset_bo,customer_item_bo,item_bo,good_bad,packing_time,item_name,operation_name,packing_user,good_die,bad_die1,bad_die2,dn_no,container_seq_id,customer_itemset_names,customer_item_names,flag_customer_special_package,flag_split_by_customer_itemset,hold_detail_bo,hold_context_g_bo,hold_log_bo,hold_status,original_status,reason_code_bo,released,released_by_bo,released_date_time,release_comments,sfc_bo,hold_id,user_bo,comments,date_time FROM view_pkg_container_hold ";

  private final Connection conn;

  public ViewPkgContainerHoldDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewPkgContainerHold> selectAll() throws SQLException {
    ArrayList<ViewPkgContainerHold> result = new ArrayList<ViewPkgContainerHold>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainerHold> select(Where where) throws SQLException {
    ArrayList<ViewPkgContainerHold> result = new ArrayList<ViewPkgContainerHold>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<ViewPkgContainerHold> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<ViewPkgContainerHold> result = new ArrayList<ViewPkgContainerHold>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where sfc_bo=? ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  private ViewPkgContainerHold convert(ResultSet rs) throws SQLException {
    ViewPkgContainerHold data = new ViewPkgContainerHold();

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
    data.setPackingTime(DateUtils.getDateTz(rs, index++));
    data.setItemName(rs.getString(index++));
    data.setOperationName(rs.getString(index++));
    data.setPackingUser(rs.getString(index++));
    data.setGoodDie(rs.getBigDecimal(index++));
    data.setBadDie1(rs.getBigDecimal(index++));
    data.setBadDie2(rs.getBigDecimal(index++));
    data.setDnNo(rs.getString(index++));
    data.setContainerSeqId(rs.getString(index++));
    data.setCustomerItemsetNames(rs.getString(index++));
    data.setCustomerItemNames(rs.getString(index++));
    data.setFlagCustomerSpecialPackage(rs.getString(index++));
    data.setFlagSplitByCustomerItemset(rs.getString(index++));
    data.setHoldDetailBo(rs.getString(index++));
    data.setHoldContextGBo(rs.getString(index++));
    data.setHoldLogBo(rs.getString(index++));
    data.setHoldStatus(rs.getString(index++));
    data.setOriginalStatus(rs.getString(index++));
    data.setReasonCodeBo(rs.getString(index++));
    data.setReleased(rs.getString(index++));
    data.setReleasedByBo(rs.getString(index++));
    data.setReleasedDateTime(rs.getString(index++));
    data.setReleaseComments(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setHoldId(rs.getBigDecimal(index++));
    data.setUserBo(rs.getString(index++));
    data.setComments(rs.getString(index++));
    data.setDateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
