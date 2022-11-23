package ame.psb.db.dao;

import ame.psb.db.HoldReleaseSfcItemState;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class HoldReleaseSfcItemStateDao {

  private static final String SQL_INS = "INSERT INTO zr_hold_release_sfc_item_state(sfc_bo,customer_item_bo,item_state_name,memo,updated_time,updated_user) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_hold_release_sfc_item_state SET customer_item_bo=?,item_state_name=?,memo=?,updated_time=?,updated_user=? WHERE sfc_bo=? AND customer_item_bo=?";

  private static final String SQL_SEL = "SELECT sfc_bo,customer_item_bo,item_state_name,memo,updated_time,updated_user,hold_release_bo,status FROM zr_hold_release_sfc_item_state ";

  private final Connection conn;

  public HoldReleaseSfcItemStateDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(HoldReleaseSfcItemState data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getCustomerItemBo());
      ps.setString(3, data.getItemStateName());
      ps.setString(4, data.getMemo());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getUpdatedUser());

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_hold_release_sfc_item_state WHERE hold_release_bo=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int insert(List<HoldReleaseSfcItemState> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (HoldReleaseSfcItemState data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getCustomerItemBo());
        ps.setString(3, data.getItemStateName());
        ps.setString(4, data.getMemo());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getUpdatedUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(HoldReleaseSfcItemState data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getItemStateName());
      ps.setString(3, data.getMemo());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getUpdatedUser());
      ps.setString(6, data.getSfcBo());
      ps.setString(7, data.getCustomerItemBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<HoldReleaseSfcItemState> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (HoldReleaseSfcItemState data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getItemStateName());
        ps.setString(3, data.getMemo());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getUpdatedUser());
        ps.setString(6, data.getSfcBo());
        ps.setString(7, data.getCustomerItemBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateHoldRelease(String holdReleaseBo, String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_hold_release_sfc_item_state SET hold_release_bo=? WHERE sfc_bo=? AND hold_release_bo IS NULL")) {
      ps.setString(1, holdReleaseBo);
      ps.setString(2, sfcBo);

      return ps.executeUpdate();
    }
  }

  public int updateStatus(String holdReleaseBo, String status) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_hold_release_sfc_item_state SET status=? WHERE hold_release_bo=?")) {
      ps.setString(1, status);
      ps.setString(2, holdReleaseBo);

      return ps.executeUpdate();
    }
  }

  public List<HoldReleaseSfcItemState> selectAll() throws SQLException {
    ArrayList<HoldReleaseSfcItemState> result = new ArrayList<HoldReleaseSfcItemState>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<HoldReleaseSfcItemState> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<HoldReleaseSfcItemState> result = new ArrayList<HoldReleaseSfcItemState>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND hold_release_bo IS NULL")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public HoldReleaseSfcItemState selectBySfcAndItem(String sfcBo, String customerItemBo)
      throws SQLException {
    HoldReleaseSfcItemState result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE sfc_bo=? AND customer_item_bo=? AND hold_release_bo IS NULL")) {
      ps.setString(1, sfcBo);
      ps.setString(2, customerItemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private HoldReleaseSfcItemState convert(ResultSet rs) throws SQLException {
    HoldReleaseSfcItemState data = new HoldReleaseSfcItemState();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setItemStateName(rs.getString(index++));
    data.setMemo(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setHoldReleaseBo(rs.getString(index++));
    data.setStatus(rs.getString(index++));

    return data;
  }
}