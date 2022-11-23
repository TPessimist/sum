package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.PmcLocationData;
import uia.utils.dao.DateUtils;

public class PmcLocationDataDao {

  private static final String SQL_INS = "INSERT INTO zd_pmc_location_data(batch_id,location_data,shop_order_bo,location_state,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_pmc_location_data SET shop_order_bo=?,location_state=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE batch_id=? AND location_data=?";

  private static final String SQL_SEL = "SELECT batch_id,location_data,shop_order_bo,location_state,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_pmc_location_data ";

  private final Connection conn;

  public PmcLocationDataDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PmcLocationData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getBatchId());
      ps.setString(2, data.getLocationData());
      ps.setString(3, data.getShopOrderBo());
      ps.setString(4, data.getLocationState());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PmcLocationData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PmcLocationData data : dataList) {
        ps.setString(1, data.getBatchId());
        ps.setString(2, data.getLocationData());
        ps.setString(3, data.getShopOrderBo());
        ps.setString(4, data.getLocationState());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PmcLocationData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getShopOrderBo());
      ps.setString(2, data.getLocationState());
      ps.setString(3, data.getReversedField1());
      ps.setString(4, data.getReversedField2());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getBatchId());
      ps.setString(8, data.getLocationData());

      return ps.executeUpdate();
    }
  }

  public int update(List<PmcLocationData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PmcLocationData data : dataList) {
        ps.setString(1, data.getShopOrderBo());
        ps.setString(2, data.getLocationState());
        ps.setString(3, data.getReversedField1());
        ps.setString(4, data.getReversedField2());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getBatchId());
        ps.setString(8, data.getLocationData());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String batchId, String locationData) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_pmc_location_data WHERE batch_id=? AND location_data=?")) {
      ps.setString(1, batchId);
      ps.setString(2, locationData);

      return ps.executeUpdate();
    }
  }

  public List<PmcLocationData> selectAll() throws SQLException {
    ArrayList<PmcLocationData> result = new ArrayList<PmcLocationData>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PmcLocationData selectByPK(String batchId, String locationData) throws SQLException {
    PmcLocationData result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE batch_id=? AND location_data=?")) {
      ps.setString(1, batchId);
      ps.setString(2, locationData);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }
  public List<PmcLocationData> selectByShopOrderBo(String shopOrderBo) throws SQLException {
    List<PmcLocationData> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE  SHOP_ORDER_BO=?")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  public List<PmcLocationData> selectByPKLocationData(String locationData) throws SQLException {
    List<PmcLocationData> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE  location_data=?")) {
      ps.setString(1, locationData);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PmcLocationData> selectByPKBatchId(String batchId) throws SQLException {
    List<PmcLocationData> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE batch_id=? ")) {
      ps.setString(1, batchId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private PmcLocationData convert(ResultSet rs) throws SQLException {
    PmcLocationData data = new PmcLocationData();

    int index = 1;
    data.setBatchId(rs.getString(index++));
    data.setLocationData(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setLocationState(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
