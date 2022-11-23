package ame.psb.db.dao;

import ame.psb.db.PkgContainer;
import ame.psb.db.ViewPkgContainer;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class PkgContainerDao {

  private static final String SQL_INS = "INSERT INTO zr_pkg_container(id,container_name,packing_plan_bo,item_group_bo,operation_bo,item_level,container_type,pkg_container_bo,curr_step,state_name,customer_itemset_bo,customer_item_bo,item_bo,good_bad,packing_time,packing_user,good_die,bad_die1,bad_die2,dn_no,container_seq_id,customer_itemset_names,customer_item_names,flag_customer_special_package,flag_split_by_customer_itemset) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_pkg_container SET container_name=?,packing_plan_bo=?,item_group_bo=?,operation_bo=?,item_level=?,container_type=?,pkg_container_bo=?,curr_step=?,state_name=?,customer_itemset_bo=?,customer_item_bo=?,item_bo=?,good_bad=?,packing_time=?,packing_user=?,good_die=?,bad_die1=?,bad_die2=?,dn_no=?,container_seq_id=?,customer_itemset_names=?,customer_item_names=?,flag_customer_special_package=?,flag_split_by_customer_itemset=? WHERE id=?";

  private static final String SQL_UPD_AA = "UPDATE zr_pkg_container SET FLAG_CUSTOMER_SPECIAL_PACKAGE=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,container_name,packing_plan_bo,item_group_bo,operation_bo,item_level,container_type,pkg_container_bo,curr_step,state_name,customer_itemset_bo,customer_item_bo,item_bo,good_bad,packing_time,item_name,operation_name,packing_user,good_die,bad_die1,bad_die2,dn_no,container_seq_id,customer_itemset_names,customer_item_names ,flag_customer_special_package,flag_split_by_customer_itemset, CONTAINER_WEIGHT,CONTAINER_VOLUME,PASS_USER FROM view_pkg_container ";

  private static final String SQL_SEL_FOR_SEQ = "SELECT id, container_name,packing_plan_bo,item_group_bo,operation_bo,item_level,container_type,pkg_container_bo,curr_step,state_name,customer_itemset_bo,customer_item_bo,item_bo,good_bad,packing_time,item_name,operation_name,packing_user,good_die,bad_die1,bad_die2,dn_no,SEQ,customer_itemset_names,customer_item_names ,flag_customer_special_package,flag_split_by_customer_itemset,CONTAINER_WEIGHT,CONTAINER_VOLUME,PASS_USER from view_pkg_container_PRINT  ";


  private static final String SQL_SEL_FORUPDATE = "SELECT id,container_name,packing_plan_bo,item_group_bo,operation_bo,item_level,container_type,pkg_container_bo,curr_step,state_name,customer_itemset_bo,customer_item_bo,item_bo,good_bad,packing_time,packing_user,good_die,bad_die1,bad_die2,dn_no,container_seq_id,customer_itemset_names,customer_item_names,flag_customer_special_package,flag_split_by_customer_itemset, CONTAINER_WEIGHT,CONTAINER_VOLUME,PASS_USER FROM zr_pkg_container WHERE id=? ";

  private static final String SQL_SEL_FORCHECK = "SELECT id,container_name,packing_plan_bo,item_group_bo,operation_bo,item_level,container_type,pkg_container_bo,curr_step,state_name,customer_itemset_bo,customer_item_bo,item_bo,good_bad,packing_time,packing_user,good_die,bad_die1,bad_die2,dn_no,container_seq_id,customer_itemset_names,customer_item_names,flag_customer_special_package,flag_split_by_customer_itemset, CONTAINER_WEIGHT,CONTAINER_VOLUME,PASS_USER FROM zr_pkg_container ";


  private static final String SQL_SEL_MAX = "select max(IFNULL(to_number(flag_customer_special_package),0)) from zr_pkg_container  where customer_itemset_names like ?  and state_name!='UNPACK'";

  private static final String SQL_SEL_FORTRAY = "SELECT id,container_name,packing_plan_bo,item_group_bo,operation_bo,item_level,container_type,pkg_container_bo,curr_step,state_name,customer_itemset_bo,customer_item_bo,item_bo,good_bad,packing_time,packing_user,good_die,bad_die1,bad_die2,dn_no,container_seq_id,customer_itemset_names,customer_item_names,flag_customer_special_package,flag_split_by_customer_itemset FROM zr_pkg_container  ";

  private static final String SQL_SEL_SHOP_ORDER = "SELECT ID FROM ZR_PKG_CONTAINER WHERE CURR_STEP LIKE '%OQC,#%' AND STATE_NAME = 'WAIT' AND PKG_CONTAINER_BO IS NULL ";

  private static final String SQL_SEL_37 = "SELECT id FROM ZR_PKG_CONTAINER WHERE ITEM_GROUP_BO LIKE '%X37A%' AND CONTAINER_TYPE = 'T' AND PACKING_TIME BETWEEN add_seconds(CURRENT_TIMESTAMP, -360000) AND CURRENT_TIMESTAMP AND CONTAINER_NAME IS NOT NULL AND STATE_NAME != 'UNPACK'";


  private final Connection conn;

  public PkgContainerDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgContainer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getContainerName());
      ps.setString(3, data.getPackingPlanBo());
      ps.setString(4, data.getItemGroupBo());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getItemLevel());
      ps.setString(7, data.getContainerType());
      ps.setString(8, data.getPkgContainerBo());
      ps.setString(9, data.getBoxStep());
      ps.setString(10, data.getStateName());
      ps.setString(11, data.getCustomerItemLotBo());
      ps.setString(12, data.getCustomerItemBo());
      ps.setString(13, data.getItemBo());
      ps.setString(14, data.getGoodBad());
      if (null == data.getPackingTime()) {
        data.setPackingTime(new Date());
      }
      DateUtils.setDateTz(ps, 15, data.getPackingTime());
      ps.setString(16, data.getPackingUser());
      ps.setInt(17, data.getGoodDie());
      ps.setInt(18, data.getBadDie1());
      ps.setInt(19, data.getBadDie2());
      ps.setString(20, data.getDnNo());
      ps.setString(21, data.getContainerSeqId());
      ps.setString(22, data.getCustomerItemLotNames());
      ps.setString(23, data.getCustomerItemNames());
      ps.setString(24, data.getFlagCustomerSpecialPackage());
      ps.setString(25, data.getFlagSplitByCustomerItemset());

      return ps.executeUpdate();
    }
  }

  public int update(PkgContainer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getContainerName());
      ps.setString(2, data.getPackingPlanBo());
      ps.setString(3, data.getItemGroupBo());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getItemLevel());
      ps.setString(6, data.getContainerType());
      ps.setString(7, data.getPkgContainerBo());
      ps.setString(8, data.getBoxStep());
      ps.setString(9, data.getStateName());
      ps.setString(10, data.getCustomerItemLotBo());
      ps.setString(11, data.getCustomerItemBo());
      ps.setString(12, data.getItemBo());
      ps.setString(13, data.getGoodBad());
      DateUtils.setDateTz(ps, 14, data.getPackingTime());
      ps.setString(15, data.getPackingUser());
      ps.setInt(16, data.getGoodDie());
      ps.setInt(17, data.getBadDie1());
      ps.setInt(18, data.getBadDie2());
      ps.setString(19, data.getDnNo());
      ps.setString(20, data.getContainerSeqId());
      ps.setString(21, data.getCustomerItemLotNames());
      ps.setString(22, data.getCustomerItemNames());
      ps.setString(23, data.getFlagCustomerSpecialPackage());
      ps.setString(24, data.getFlagSplitByCustomerItemset());
      ps.setString(25, data.getId());

      return ps.executeUpdate();
    }
  }

  public int updateAA(String mainbatchId2, String containerid) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_AA)) {
      ps.setString(1, mainbatchId2);
      ps.setString(2, containerid);
      return ps.executeUpdate();
    }
  }

  public int updateWeght(String containerName, BigDecimal weight, String containerVolume)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_pkg_container SET CONTAINER_WEIGHT =? ,CONTAINER_VOLUME = ? WHERE container_name = ?")) {
      ps.setBigDecimal(1, weight);
      ps.setString(2, containerVolume);
      ps.setString(3, containerName);
      return ps.executeUpdate();
    }
  }

  public int updateWeight(String id, BigDecimal weight)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_pkg_container SET CONTAINER_WEIGHT =?   WHERE id = ?")) {
      ps.setBigDecimal(1, weight);
      ps.setString(2, id);
      return ps.executeUpdate();
    }
  }

  public int updateVolume(String id, String volume)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_pkg_container SET CONTAINER_VOLUME =?   WHERE id = ?")) {
      ps.setString(1, volume);
      ps.setString(2, id);
      return ps.executeUpdate();
    }
  }

  public int updatePassUser(String id, String passUser) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_pkg_container SET PASS_USER = ? WHERE id = ?")) {
      ps.setString(1, passUser);
      ps.setString(2, id);
      return ps.executeUpdate();
    }
  }

  public int update(String id, String name, String seqId) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_pkg_container SET container_name=?,container_seq_id=? WHERE id=?")) {
      ps.setString(1, name);
      ps.setString(2, seqId);
      ps.setString(3, id);

      return ps.executeUpdate();
    }
  }

  public int updateCustOperation(String id, String custOperation) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_pkg_container SET curr_step=? WHERE id=?")) {
      ps.setString(1, custOperation);
      ps.setString(2, id);

      return ps.executeUpdate();
    }
  }

  public int updateStateName(String id, String stateName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_pkg_container SET STATE_NAME=? WHERE id=?")) {
      ps.setString(1, stateName);
      ps.setString(2, id);

      return ps.executeUpdate();
    }
  }

  public int packing(String sourceContainerBo, String targetContainerBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_pkg_container SET pkg_container_bo=? WHERE id=?")) {
      ps.setString(1, targetContainerBo);
      ps.setString(2, sourceContainerBo);

      return ps.executeUpdate();
    }
  }

  public int unpacking(String targetContainerBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_pkg_container SET pkg_container_bo=null WHERE pkg_container_bo=?")) {
      ps.setString(1, targetContainerBo);

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_container WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ViewPkgContainer> select(Where where) throws SQLException {
    ArrayList<ViewPkgContainer> result = new ArrayList<ViewPkgContainer>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
    }
    return result;
  }

  public List<String> selectSO() throws SQLException {
    ArrayList<String> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_SHOP_ORDER)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(rs.getString(1));
      }
    }
    return result;
  }


  public List<ViewPkgContainer> selectAmbiguous(String sfcName) throws SQLException {
    ArrayList<ViewPkgContainer> result = new ArrayList<ViewPkgContainer>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where container_name like ?")) {
      ps.setString(1, "%" + sfcName + "%");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
    }
    return result;
  }

  public ViewPkgContainer selectContainerName(String containerName) throws SQLException {
    ViewPkgContainer result = new ViewPkgContainer();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where container_name = ?")) {
      ps.setString(1, containerName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result = convertView(rs);
      }
    }
    return result;
  }

  public double selectContainerNameq(String containerName) throws SQLException {
    double result = 0;
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT CONTAINER_WEIGHT FROM view_pkg_container WHERE CONTAINER_NAME = ?")) {
      ps.setString(1, containerName);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = rs.getDouble(1);
      }

    }
    return result;
  }

  public List<ViewPkgContainer> selectByPkg(String containerBo) throws SQLException {
    ArrayList<ViewPkgContainer> result = new ArrayList<ViewPkgContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE pkg_container_bo=? and state_name != 'UNPACK' ORDER BY id")) {
      ps.setString(1, containerBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainer> selectByDn(String dn) throws SQLException {
    ArrayList<ViewPkgContainer> result = new ArrayList<ViewPkgContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE dn_no = ? and state_name not in ('UNPACK','UNPACK_DN')  ORDER BY id")) {
      ps.setString(1, dn);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainer> selectReelByDn(String dn) throws SQLException {
    ArrayList<ViewPkgContainer> result = new ArrayList<ViewPkgContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE dn_no = ? and state_name not in ('UNPACK','UNPACK_DN') and container_type='T' ORDER BY id")) {
      ps.setString(1, dn);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainer> selectOutContainerByDn(String dn) throws SQLException {
    ArrayList<ViewPkgContainer> result = new ArrayList<ViewPkgContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE dn_no = ? and state_name not in ('UNPACK','UNPACK_DN') and container_type = 'C' ORDER BY id")) {
      ps.setString(1, dn);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainer> selectByItemSetBo(String containerBo) throws SQLException {
    ArrayList<ViewPkgContainer> result = new ArrayList<ViewPkgContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE CUSTOMER_ITEMSET_BO=? and state_name != 'UNPACK' ORDER BY id")) {
      ps.setString(1, containerBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainer> selectByContainerNameAndContainerBo(String containerName)
      throws SQLException {
    ArrayList<ViewPkgContainer> result = new ArrayList<ViewPkgContainer>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE container_name=? OR pkg_container_bo=? ORDER BY id")) {
      ps.setString(1, containerName);
      ps.setString(2, containerName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainer> selectByItemGroupBo(String itemGroupBo) throws SQLException {
    ArrayList<ViewPkgContainer> result = new ArrayList<ViewPkgContainer>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE item_group_bo=? AND state_name !='UNPACK' ORDER BY id ")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainer> selectWaiting(String operationBo) throws SQLException {
    ArrayList<ViewPkgContainer> result = new ArrayList<ViewPkgContainer>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE curr_step=? AND state_name='WAIT' ORDER BY id")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainer> selectWaitingByOperationItem(String operationBo, String itemBo)
      throws SQLException {
    ArrayList<ViewPkgContainer> result = new ArrayList<ViewPkgContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE curr_step=? AND state_name='WAIT' AND item_bo=? ORDER BY id")) {
      ps.setString(1, operationBo);
      ps.setString(2, itemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainer> selectWaitingByOperationItemLot(String operationBo,
      String customerItemLotBo) throws SQLException {
    ArrayList<ViewPkgContainer> result = new ArrayList<ViewPkgContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE curr_step=? AND state_name='WAIT' AND customer_itemset_bo=? ORDER BY id")) {
      ps.setString(1, operationBo);
      ps.setString(2, customerItemLotBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainer> selectWaitingByOperationSfcItem(String operationBo,
      String customerItemBo) throws SQLException {
    ArrayList<ViewPkgContainer> result = new ArrayList<ViewPkgContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE curr_step=? AND state_name='WAIT' AND customer_item_bo=? ORDER BY id")) {
      ps.setString(1, operationBo);
      ps.setString(2, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainer> selectByFlagSplitByCustomerItemset(
      String flagSplitByCustomerItemset) throws SQLException {
    ArrayList<ViewPkgContainer> result = new ArrayList<ViewPkgContainer>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE flag_split_by_customer_itemset = ? ORDER BY id")) {
      ps.setString(1, flagSplitByCustomerItemset);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  public PkgContainer selectByLotAndSeq(String lot, String seq) throws SQLException {
    PkgContainer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_FORCHECK
        + "WHERE customer_itemset_names LIKE ? AND container_seq_id = ? AND state_name != 'UNPACK' ")) {
      ps.setString(1, "%" + lot + "%");
      ps.setString(2, seq);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<PkgContainer> selectByDnNo(String dnNo) throws SQLException {
    List<PkgContainer> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_FORCHECK + "WHERE dn_no = ? ")) {
      ps.setString(1, dnNo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgContainer> selectPkgContainers() throws SQLException {
    List<PkgContainer> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_FORCHECK)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgContainer> selectByLotsAndSeq(String lot, String seq) throws SQLException {
    ArrayList<PkgContainer> result = new ArrayList<PkgContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_FORCHECK
        + "WHERE customer_itemset_names LIKE ? AND container_seq_id = ? AND state_name != 'UNPACK' AND container_type = 'C' ")) {
      ps.setString(1, "%" + lot + "%");
      ps.setString(2, seq);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgContainer> selectByLotName(String lotName) throws SQLException {
    ArrayList<PkgContainer> result = new ArrayList<PkgContainer>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_FORCHECK + "WHERE customer_itemset_names LIKE ? ")) {
      ps.setString(1, "%" + lotName + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgContainer> selectByItemName(String itemName) throws SQLException {
    ArrayList<PkgContainer> result = new ArrayList<PkgContainer>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_FORCHECK + "WHERE customer_item_names LIKE ? ")) {
      ps.setString(1, "%" + itemName + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public PkgContainer selectBySeq(String seq) throws SQLException {
    PkgContainer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_FORCHECK + "WHERE container_seq_id = ? AND state_name != 'UNPACK' ")) {
      ps.setString(1, seq);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgContainer selectByContainerName(String containerName) throws SQLException {
    PkgContainer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_FORCHECK + "WHERE container_name = ? AND state_name != 'UNPACK'")) {
      ps.setString(1, containerName);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ArrayList<PkgContainer> selectByContainerNameLike(String containerName)
      throws SQLException {
    ArrayList<PkgContainer> result = new ArrayList<PkgContainer>();
    containerName = "%" + containerName + "%";
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_FORCHECK + "WHERE container_name like  ? AND state_name != 'UNPACK'")) {
      ps.setString(1, containerName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ArrayList<PkgContainer> selectByContainerNameList(String containerName)
      throws SQLException {
    ArrayList<PkgContainer> result = new ArrayList<PkgContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_FORCHECK + "WHERE container_name = ? AND state_name != 'UNPACK'")) {
      ps.setString(1, containerName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ArrayList<PkgContainer> selectBystateNameList(String stateName)
      throws SQLException {
    ArrayList<PkgContainer> result = new ArrayList<PkgContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_FORCHECK + "WHERE  state_name = ?  ORDER BY CURR_STEP")) {
      ps.setString(1, stateName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  public ArrayList<PkgContainer> selectContainerNameAndState(String containerName)
          throws SQLException {
    ArrayList<PkgContainer> result = new ArrayList<PkgContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(
            SQL_SEL_FORCHECK + "WHERE CONTAINER_NAME=? and state_name = 'WAIT_HANDOVER'")) {
      ps.setString(1, containerName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PkgContainer selectForUpdate(String id) throws SQLException {
    PkgContainer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_FORUPDATE)) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewPkgContainer selectByPK(String id) throws SQLException {
    ViewPkgContainer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convertView(rs);
      }
      return result;
    }
  }

  public ViewPkgContainer selectByPKSEQ(String id) throws SQLException {
    ViewPkgContainer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_FOR_SEQ + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convertView(rs);
      }
      return result;
    }
  }

  public List<String> selectPkg37Containers() throws SQLException {
    List<String> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_37)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(rs.getString(1));
      }
      return result;
    }
  }

  //ADD WHERE flag_Split_By_Customer_ItemSet=?
  public ViewPkgContainer selectByflagSplitByCustomerItemSet(String flagSplitByCustomerItemSet)
      throws SQLException {
    ViewPkgContainer result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE flag_Split_By_Customer_ItemSet=?")) {
      ps.setString(1, flagSplitByCustomerItemSet);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convertView(rs);
      }
      return result;
    }
  }


  public List<ViewPkgContainer> selectAll() throws SQLException {
    ArrayList<ViewPkgContainer> result = new ArrayList<ViewPkgContainer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }


  //MARK add
  public String selectMaxFlagSplitByCustomerItemSet(String lot) throws SQLException {

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_MAX)) {

      ps.setString(1, lot);
      System.out.println(SQL_SEL_MAX);

      ResultSet rs = ps.executeQuery();
      String maxId = "";
      while (rs.next()) {
        maxId = rs.getString(1);
      }
      if (maxId == null) {
        return "0";
      }
      return maxId;
    }
  }


  //MARK add
  public String selectCustomerItemSet(String id) throws SQLException {

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_FORUPDATE)) {

      ps.setString(1, id);
      System.out.println(SQL_SEL_FORUPDATE);

      ResultSet rs = ps.executeQuery();
      String customerLot = "";
      while (rs.next()) {
        customerLot = rs.getString(22);
      }
      return customerLot;
    }
  }

  public Container selectByContainerBo(String containerBo) throws Exception {

    if (null != containerBo) {
      Container container = new Container();
      container.selfContainer = selectByPKSEQ(containerBo);

      if (null == container.selfContainer.getContainerSeqId()) {
        container.selfContainer.setContainerSeqId(" ");
      }
      containerBo = container.selfContainer.getPkgContainerBo();

      if (null != containerBo) {
        container.outContainer = selectByContainerBo(containerBo);
      }

      return container;
    }
    return null;
  }

  private ViewPkgContainer convertView(ResultSet rs) throws SQLException {
    ViewPkgContainer data = new ViewPkgContainer();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setContainerName(rs.getString(index++));
    data.setPackingPlanBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setItemLevel(rs.getString(index++));
    data.setContainerType(rs.getString(index++));
    data.setPkgContainerBo(rs.getString(index++));
    data.setBoxStep(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCustomerItemLotBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setGoodBad(rs.getString(index++));
    data.setPackingTime(DateUtils.getDateTz(rs, index++));
    data.setItemName(rs.getString(index++));
    data.setOperationName(rs.getString(index++));
    data.setPackingUser(rs.getString(index++));
    data.setGoodDie(rs.getInt(index++));
    data.setBadDie1(rs.getInt(index++));
    data.setBadDie2(rs.getInt(index++));
    data.setDnNo(rs.getString(index++));
    data.setContainerSeqId(rs.getString(index++));
    data.setCustomerItemLotNames(rs.getString(index++));
    data.setCustomerItemNames(rs.getString(index++));
    data.setFlagCustomerSpecialPackage(rs.getString(index++));
    data.setFlagSplitByCustomerItemset(rs.getString(index++));
    data.setContainerWeight(rs.getString(index++));
    data.setContainerVolume(rs.getString(index++));
    data.setPassUser(rs.getString(index++));

    return data;
  }

  private PkgContainer convert(ResultSet rs) throws SQLException {
    PkgContainer data = new PkgContainer();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setContainerName(rs.getString(index++));
    data.setPackingPlanBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setItemLevel(rs.getString(index++));
    data.setContainerType(rs.getString(index++));
    data.setPkgContainerBo(rs.getString(index++));
    data.setBoxStep(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCustomerItemLotBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setGoodBad(rs.getString(index++));
    data.setPackingTime(DateUtils.getDateTz(rs, index++));
    data.setPackingUser(rs.getString(index++));
    data.setGoodDie(rs.getInt(index++));
    data.setBadDie1(rs.getInt(index++));
    data.setBadDie2(rs.getInt(index++));
    data.setDnNo(rs.getString(index++));
    data.setContainerSeqId(rs.getString(index++));
    data.setCustomerItemLotNames(rs.getString(index++));
    data.setCustomerItemNames(rs.getString(index++));
    data.setFlagCustomerSpecialPackage(rs.getString(index++));
    data.setFlagSplitByCustomerItemset(rs.getString(index++));
    data.setContainerWeight(rs.getString(index++));
    data.setContainerVolume(rs.getString(index++));
    data.setPassUser(rs.getString(index++));

    return data;
  }

  public static class Container {

    public ViewPkgContainer selfContainer;
    public Container outContainer;
  }


}
