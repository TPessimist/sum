package ame.psb.db.dao;

import ame.psb.db.BaddieCspecRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class BaddieCspecRecordDao {

  private static final String SQL_INS = "INSERT INTO zd_baddie_cspec_record(shop_order,customer,lot,device,customer_device,code,comment,description,message,remarks,definition,flag,notes,update_user,update_time,item) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_baddie_cspec_record SET customer=?,lot=?,device=?,customer_device=?,code=?,comment=?,description=?,message=?,remarks=?,definition=?,flag=?,notes=?,update_user=?,update_time=?,item=? WHERE shop_order=?";

  private static final String SQL_SEL = "SELECT shop_order,customer,lot,device,customer_device,code,comment,description,message,remarks,definition,flag,notes,update_user,update_time,item FROM zd_baddie_cspec_record ";

  private final Connection conn;

  public BaddieCspecRecordDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BaddieCspecRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getShopOrder());
      ps.setString(2, data.getCustomer());
      ps.setString(3, data.getLot());
      ps.setString(4, data.getDevice());
      ps.setString(5, data.getCustomerDevice());
      ps.setString(6, data.getCode());
      ps.setString(7, data.getComment());
      ps.setString(8, data.getDescription());
      ps.setString(9, data.getMessage());
      ps.setString(10, data.getRemarks());
      ps.setString(11, data.getDefinition());
      ps.setString(12, data.getFlag());
      ps.setString(13, data.getNotes());
      ps.setString(14, data.getUpdateUser());
      DateUtils.setDateTz(ps, 15, data.getUpdateTime());
      ps.setString(16, data.getItem());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BaddieCspecRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BaddieCspecRecord data : dataList) {
        ps.setString(1, data.getShopOrder());
        ps.setString(2, data.getCustomer());
        ps.setString(3, data.getLot());
        ps.setString(4, data.getDevice());
        ps.setString(5, data.getCustomerDevice());
        ps.setString(6, data.getCode());
        ps.setString(7, data.getComment());
        ps.setString(8, data.getDescription());
        ps.setString(9, data.getMessage());
        ps.setString(10, data.getRemarks());
        ps.setString(11, data.getDefinition());
        ps.setString(12, data.getFlag());
        ps.setString(13, data.getNotes());
        ps.setString(14, data.getUpdateUser());
        DateUtils.setDateTz(ps, 15, data.getUpdateTime());
        ps.setString(16, data.getItem());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BaddieCspecRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomer());
      ps.setString(2, data.getLot());
      ps.setString(3, data.getDevice());
      ps.setString(4, data.getCustomerDevice());
      ps.setString(5, data.getCode());
      ps.setString(6, data.getComment());
      ps.setString(7, data.getDescription());
      ps.setString(8, data.getMessage());
      ps.setString(9, data.getRemarks());
      ps.setString(10, data.getDefinition());
      ps.setString(11, data.getFlag());
      ps.setString(12, data.getNotes());
      ps.setString(13, data.getUpdateUser());
      DateUtils.setDateTz(ps, 14, data.getUpdateTime());
      ps.setString(15, data.getItem());
      ps.setString(16, data.getShopOrder());

      return ps.executeUpdate();
    }
  }

  public int update(List<BaddieCspecRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BaddieCspecRecord data : dataList) {
        ps.setString(1, data.getCustomer());
        ps.setString(2, data.getLot());
        ps.setString(3, data.getDevice());
        ps.setString(4, data.getCustomerDevice());
        ps.setString(5, data.getCode());
        ps.setString(6, data.getComment());
        ps.setString(7, data.getDescription());
        ps.setString(8, data.getMessage());
        ps.setString(9, data.getRemarks());
        ps.setString(10, data.getDefinition());
        ps.setString(11, data.getFlag());
        ps.setString(12, data.getNotes());
        ps.setString(13, data.getUpdateUser());
        DateUtils.setDateTz(ps, 14, data.getUpdateTime());
        ps.setString(15, data.getItem());
        ps.setString(16, data.getShopOrder());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String shopOrder) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_baddie_cspec_record WHERE shop_order=?")) {
      ps.setString(1, shopOrder);

      return ps.executeUpdate();
    }
  }

  public List<BaddieCspecRecord> selectAll() throws SQLException {
    ArrayList<BaddieCspecRecord> result = new ArrayList<BaddieCspecRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public BaddieCspecRecord selectByPK(String shopOrder) throws SQLException {
    BaddieCspecRecord result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order=?")) {
      ps.setString(1, shopOrder);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private BaddieCspecRecord convert(ResultSet rs) throws SQLException {
    BaddieCspecRecord data = new BaddieCspecRecord();

    int index = 1;
    data.setShopOrder(rs.getString(index++));
    data.setCustomer(rs.getString(index++));
    data.setLot(rs.getString(index++));
    data.setDevice(rs.getString(index++));
    data.setCustomerDevice(rs.getString(index++));
    data.setCode(rs.getString(index++));
    data.setComment(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setMessage(rs.getString(index++));
    data.setRemarks(rs.getString(index++));
    data.setDefinition(rs.getString(index++));
    data.setFlag(rs.getString(index++));
    data.setNotes(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setItem(rs.getString(index++));

    return data;
  }
}
