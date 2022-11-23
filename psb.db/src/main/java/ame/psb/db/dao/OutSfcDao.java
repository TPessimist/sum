package ame.psb.db.dao;

import ame.psb.db.OutSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class OutSfcDao {

  private static final String SQL_INS = "INSERT INTO zr_out_sfc(id,sfc_bo,state_name,pervious_state_name,flag,updated_user,updated_time,item_qty,wafer_list,customer_itemset) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_out_sfc SET sfc_bo=?,state_name=?,pervious_state_name=?,flag=?,updated_user=?,updated_time=?,item_qty=?,wafer_list=?,customer_itemset=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sfc_bo,state_name,pervious_state_name,flag,updated_user,updated_time,item_qty,wafer_list,customer_itemset FROM zr_out_sfc ";

  private static final String SQL_INS2 = "INSERT INTO zr_out_sfc(id,sfc_bo,state_name,pervious_state_name,flag,updated_user,updated_time,item_qty,wafer_list,customer_itemset,deliver_way,postage_payment,received_address,contact,telephone,sender_name,sender_phone,sap_matkl,express_number) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD2 = "UPDATE zr_out_sfc SET sfc_bo=?,state_name=?,pervious_state_name=?,flag=?,updated_user=?,updated_time=?,item_qty=?,wafer_list=?,customer_itemset=?,deliver_way=?,postage_payment=?,received_address=?,contact=?,telephone=?,sender_name=?,sender_phone=?,sap_matkl=?,express_number=? WHERE id=?";

  private static final String SQL_SEL2 = "SELECT id,sfc_bo,state_name,pervious_state_name,flag,updated_user,updated_time,item_qty,wafer_list,customer_itemset,deliver_way,postage_payment,received_address,contact,telephone,sender_name,sender_phone,sap_matkl,express_number FROM zr_out_sfc ";


  private static final String SQL_UPD_EXTRA = "UPDATE zr_out_sfc SET deliver_way=?,postage_payment=?,received_address=?,contact=?,telephone=?,sender_name=?,sender_phone=?,sap_matkl=?,express_number=? WHERE id=?";

  private static final String SQL_SEL_EXTRA = "SELECT deliver_way,postage_payment,received_address,contact,telephone,sender_name,sender_phone,sap_matkl,express_number FROM zr_out_sfc WHERE SFC_BO = ? AND flag = 'Y' ";
  private final Connection conn;

  public OutSfcDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(OutSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getPerviousStateName());
      ps.setString(5, data.getFlag());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setInt(8, data.getItemQty());
      ps.setString(9, data.getWaferList());
      ps.setString(10, data.getCustomerItemSet());

      return ps.executeUpdate();
    }
  }

  public int insert2(OutSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS2)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getPerviousStateName());
      ps.setString(5, data.getFlag());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setInt(8, data.getItemQty());
      ps.setString(9, data.getWaferList());
      ps.setString(10, data.getCustomerItemSet());
      ps.setString(11, data.getDeliverWay());
      ps.setString(12, data.getPostagePayment());
      ps.setString(13, data.getReceivedAddress());
      ps.setString(14, data.getContact());
      ps.setString(15, data.getTelephone());
      ps.setString(16, data.getSenderName());
      ps.setString(17, data.getSenderPhone());
      ps.setString(18, data.getSapMatkl());
      ps.setString(19, data.getExpressNumber());
      return ps.executeUpdate();
    }
  }

  public int insert(List<OutSfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (OutSfc data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getStateName());
        ps.setString(4, data.getPerviousStateName());
        ps.setString(5, data.getFlag());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setInt(8, data.getItemQty());
        ps.setString(9, data.getWaferList());
        ps.setString(10, data.getCustomerItemSet());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(OutSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getStateName());
      ps.setString(3, data.getPerviousStateName());
      ps.setString(4, data.getFlag());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setInt(7, data.getItemQty());
      ps.setString(8, data.getWaferList());
      ps.setString(9, data.getCustomerItemSet());
      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update2(OutSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD2)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getStateName());
      ps.setString(3, data.getPerviousStateName());
      ps.setString(4, data.getFlag());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setInt(7, data.getItemQty());
      ps.setString(8, data.getWaferList());
      ps.setString(9, data.getCustomerItemSet());
      ps.setString(10, data.getDeliverWay());
      ps.setString(11, data.getPostagePayment());
      ps.setString(12, data.getReceivedAddress());
      ps.setString(13, data.getContact());
      ps.setString(14, data.getTelephone());
      ps.setString(15, data.getSenderName());
      ps.setString(16, data.getSenderPhone());
      ps.setString(17, data.getSapMatkl());
      ps.setString(18, data.getExpressNumber());
      ps.setString(19, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<OutSfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (OutSfc data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getStateName());
        ps.setString(3, data.getPerviousStateName());
        ps.setString(4, data.getFlag());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setInt(7, data.getItemQty());
        ps.setString(8, data.getWaferList());
        ps.setString(9, data.getCustomerItemSet());
        ps.setString(10, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateExtra(OutSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_EXTRA)) {
      ps.setString(1, data.getDeliverWay());
      ps.setString(2, data.getPostagePayment());
      ps.setString(3, data.getReceivedAddress());
      ps.setString(4, data.getContact());
      ps.setString(5, data.getTelephone());
      ps.setString(6, data.getSenderName());
      ps.setString(7, data.getSenderPhone());
      ps.setString(8, data.getSapMatkl());
      ps.setString(9, data.getExpressNumber());
      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_out_sfc WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<OutSfc> selectAll() throws SQLException {
    ArrayList<OutSfc> result = new ArrayList<OutSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OutSfc> selectActive() throws SQLException {
    ArrayList<OutSfc> result = new ArrayList<OutSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE flag = 'Y' ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public OutSfc selectActiveBySfc(String sfcBo) throws SQLException {
    OutSfc result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? and flag = 'Y' ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public OutSfc selectExistsBySfc(String sfcBo) throws SQLException {
    OutSfc result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE sfc_bo=? and STATE_NAME = 'RESERVE_OUT' and flag = 'N' ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public OutSfc selectByPK(String id) throws SQLException {
    OutSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public OutSfc selectByPK2(String id) throws SQLException {
    OutSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL2 + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert2(rs);
      }
      return result;
    }
  }

  public OutSfc selectExtra(String sfcBo) throws SQLException {
    OutSfc result = new OutSfc();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_EXTRA)) {
      ps.setString(1, sfcBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.setSfcBo(sfcBo);
        result.setDeliverWay(rs.getString(1));
        result.setPostagePayment(rs.getString(2));
        result.setReceivedAddress(rs.getString(3));
        result.setContact(rs.getString(4));
        result.setTelephone(rs.getString(5));
        result.setSenderName(rs.getString(6));
        result.setSenderPhone(rs.getString(7));
        result.setSapMatkl(rs.getString(8));
        result.setExpressNumber(rs.getString(9));
      }
      return result;
    }
  }

  private OutSfc convert(ResultSet rs) throws SQLException {
    OutSfc data = new OutSfc();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setPerviousStateName(rs.getString(index++));
    data.setFlag(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setItemQty(rs.getInt(index++));
    data.setWaferList(rs.getString(index++));
    data.setCustomerItemSet(rs.getString(index++));

    return data;
  }

  private OutSfc convert2(ResultSet rs) throws SQLException {
    OutSfc data = new OutSfc();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setPerviousStateName(rs.getString(index++));
    data.setFlag(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setItemQty(rs.getInt(index++));
    data.setWaferList(rs.getString(index++));
    data.setCustomerItemSet(rs.getString(index++));
    data.setDeliverWay(rs.getString(index++));
    data.setPostagePayment(rs.getString(index++));
    data.setReceivedAddress(rs.getString(index++));
    data.setContact(rs.getString(index++));
    data.setTelephone(rs.getString(index++));
    data.setSenderName(rs.getString(index++));
    data.setSenderPhone(rs.getString(index++));
    data.setSapMatkl(rs.getString(index++));
    data.setExpressNumber(rs.getString(index++));

    return data;
  }


}
