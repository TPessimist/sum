package ame.psb.db.dao;

import ame.psb.db.HoldSfc;
import ame.psb.db.ViewHoldSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class HoldSfcDao {

  private static final String SQL_INS = "INSERT INTO zr_hold_sfc(hold_detail_bo,carrier_bo,run_sfc_bo,ee_approved,hold_release_bo,updated_user,updated_time,department,upload_path) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_hold_sfc SET carrier_bo=?,run_sfc_bo=?,ee_approved=?,hold_release_bo=?,updated_user=?,updated_time=?,department=?,upload_path=? WHERE hold_detail_bo=?";

  private static final String SQL_SEL = "SELECT hold_detail_bo,carrier_bo,run_sfc_bo,ee_approved,hold_release_bo,department,hold_log_bo,sfc_bo,original_status_bo,hold_status_bo,released_date_time,released_by_bo,release_comments,reason_code_bo,hold_type,comments,created_date_time,modified_date_time,user_bo,txn_id,sfc_name,state_name,customer_itemset_bo,priority,dpt_no,lot_type,item_qty,shop_order_bo,item_bo,item_name,device_bo,device_name,package_bo,package_name,router_bo,router_name,sfc_qty,customer,status_bo,customer_itemset_name,shop_order_name,reason_code,reason_code_description,upload_path FROM view_hold_sfc ";

  //查询因盘点需求hold 住的 产品
  private static final String SQL_SQL2 = "SELECT * FROM VIEW_HOLD_SFC WHERE CARRIER_BO IN (SELECT id FROM zd_carrier WHERE state_name = 'HOLD' OR STATE_NAME = 'RUN_HOLD') AND COMMENTS = '因盘点需求' AND REASON_CODE = 'HA30' AND RELEASED_DATE_TIME IS NULL";
  private final Connection conn;

  public HoldSfcDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(HoldSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHoldDetailBo());
      ps.setString(2, data.getCarrierBo());
      ps.setString(3, data.getRunSfcBo());
      ps.setString(4, data.getEeApproved());
      ps.setString(5, data.getHoldReleaseBo());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getDepartment());
      ps.setString(9, data.getUploadPath());

      return ps.executeUpdate();
    }
  }


  public int update(HoldSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCarrierBo());
      ps.setString(2, data.getRunSfcBo());
      ps.setString(3, data.getEeApproved());
      ps.setString(4, data.getHoldReleaseBo());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getDepartment());
      ps.setString(8, data.getUploadPath());
      ps.setString(9, data.getHoldDetailBo());

      return ps.executeUpdate();
    }
  }

  public List<ViewHoldSfc> selectAll() throws SQLException {
    ArrayList<ViewHoldSfc> result = new ArrayList<ViewHoldSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }
//    public ViewHoldSfc selectDepartment(String holdDetailBo) throws SQLException {
//    	ViewHoldSfc result = null;
//        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE HOLD_DETAIL_BO = ?")) {
//        	ps.setString(1, holdDetailBo);
//
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                result = this.convert(rs);
//            }
//            return result;
//        }
//    }

  public List<ViewHoldSfc> select(Where where) throws SQLException {
    ArrayList<ViewHoldSfc> result = new ArrayList<ViewHoldSfc>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<ViewHoldSfc> selectByHoldLog(String holdLogBo) throws SQLException {
    ArrayList<ViewHoldSfc> result = new ArrayList<ViewHoldSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE hold_log_bo=?")) {
      ps.setString(1, holdLogBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ViewHoldSfc> selectByRelease(String holdReleaseBo) throws SQLException {
    ArrayList<ViewHoldSfc> result = new ArrayList<ViewHoldSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE hold_release_bo=?")) {
      ps.setString(1, holdReleaseBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public ViewHoldSfc selectByHoldDetail(String holdDetailBo) throws SQLException {
    ViewHoldSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE hold_detail_bo=?")) {
      ps.setString(1, holdDetailBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  /*
   * cc by生产片号和dcPlan_id查询
   * */
  public List<ViewHoldSfc> selectBySfcAndComments(String sfcBo, String comments)
      throws SQLException {
    ArrayList<ViewHoldSfc> result = new ArrayList<ViewHoldSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE sfc_Bo=? and comments LIKE ? ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, "%" + comments + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public ViewHoldSfc selectByLogSfc(String holdLogBo, String sfcBo) throws SQLException {
    ViewHoldSfc result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE hold_log_bo=? and sfc_Bo=?")) {
      ps.setString(1, holdLogBo);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public List<ViewHoldSfc> selectByReleaseSfc(String holdReleaseBo, String sfcBo)
      throws SQLException {
    ArrayList<ViewHoldSfc> result = new ArrayList<ViewHoldSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE hold_release_bo=? and sfc_Bo=?")) {
      ps.setString(1, holdReleaseBo);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ViewHoldSfc> selectByReasonCode(String reasonCode, String sfcBo) throws SQLException {
    ArrayList<ViewHoldSfc> result = new ArrayList<ViewHoldSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE reason_code=? and sfc_Bo=?")) {
      ps.setString(1, reasonCode);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ViewHoldSfc> selectNoReleaseByReason(String reasonCode)
      throws SQLException {
    ArrayList<ViewHoldSfc> result = new ArrayList<ViewHoldSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + " WHERE reason_code=? AND released_date_time is null")) {
      ps.setString(1, reasonCode);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ViewHoldSfc> selectByShopOrderAndReasonCode(String reasonCode, String shopOrderBo)
      throws SQLException {
    ArrayList<ViewHoldSfc> result = new ArrayList<ViewHoldSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE reason_code=? and shop_order_bo=?")) {
      ps.setString(1, reasonCode);
      ps.setString(2, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ViewHoldSfc> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<ViewHoldSfc> result = new ArrayList<ViewHoldSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE sfc_bo=? AND released_date_time is null")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ViewHoldSfc> selectBySfcAndReason(String sfcBo, String reasonCode)
      throws SQLException {
    ArrayList<ViewHoldSfc> result = new ArrayList<ViewHoldSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + " WHERE sfc_bo=? AND reason_code=? AND released_date_time is null")) {
      ps.setString(1, sfcBo);
      ps.setString(2, reasonCode);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  /*
   * cc
   * 需要最新的hold code
   * */
  public List<ViewHoldSfc> selectBySfc2(String sfcBo) throws SQLException {
    ArrayList<ViewHoldSfc> result = new ArrayList<ViewHoldSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + " WHERE sfc_bo=? AND released_date_time is null order by created_date_time desc limit '1'")) {  //created_date_time,modified_date_time
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ViewHoldSfc> selectAllBySfc(String sfcBo) throws SQLException {
    ArrayList<ViewHoldSfc> result = new ArrayList<ViewHoldSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE sfc_bo=? ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ViewHoldSfc> selectBonedHoldSfc() throws SQLException {
    List<ViewHoldSfc> list = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SQL2)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convert(rs));
      }
      return list;
    }
  }

  private ViewHoldSfc convert(ResultSet rs) throws SQLException {
    ViewHoldSfc data = new ViewHoldSfc();

    data.setHoldDetailBo(rs.getString(1));
    data.setCarrierBo(rs.getString(2));
    data.setRunSfcBo(rs.getString(3));
    data.setEeApproved(rs.getString(4));
    data.setHoldReleaseBo(rs.getString(5));
    data.setDepartment(rs.getString(6));

    int index = 7;
    data.setHoldLogBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setOriginalStatusBo(rs.getString(index++));
    data.setHoldStatusBo(rs.getString(index++));
    data.setReleasedDateTime(DateUtils.getDateTz(rs, index++));
    data.setReleasedByBo(rs.getString(index++));
    data.setReleaseComments(rs.getString(index++));
    data.setReasonCodeBo(rs.getString(index++));
    data.setHoldType(rs.getString(index++));
    data.setComments(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setUserBo(rs.getString(index++));
    data.setTxnId(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCustomerItemsetBo(rs.getString(index++));
    data.setPriority(rs.getBigDecimal(index++));
    data.setDptNo(rs.getString(index++));
    data.setLotType(rs.getString(index++));
    data.setItemQty(rs.getBigDecimal(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setDeviceBo(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setPackageBo(rs.getString(index++));
    data.setPackageName(rs.getString(index++));
    data.setRouterBo(rs.getString(index++));
    data.setRouterName(rs.getString(index++));
    data.setSfcQty(rs.getBigDecimal(index++));
    data.setCustomer(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setCustomerItemLotName(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setReason(rs.getString(index++));
    data.setReasonCodeDescription(rs.getString(index++));
    data.setUploadPath(rs.getString(index++));

    return data;
  }
}
