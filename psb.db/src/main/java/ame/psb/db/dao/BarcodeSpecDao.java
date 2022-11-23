package ame.psb.db.dao;

import ame.psb.db.BarcodeSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class BarcodeSpecDao {

  private static final String SQL_INS = "INSERT INTO zd_barcode_spec(barcode_id,item,spec,usage_limit,limit_type,updated_time,updated_user) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_barcode_spec SET item=?,spec=?,usage_limit=?,limit_type=?,updated_time=?,updated_user=? WHERE barcode_id=?";

  private static final String SQL_SEL = "SELECT barcode_id,item,spec,usage_limit,limit_type,updated_time,updated_user FROM zd_barcode_spec ";

  private final Connection conn;

  public BarcodeSpecDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BarcodeSpec data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getBarcodeId());
      ps.setString(2, data.getItem());
      ps.setString(3, data.getSpec());
      ps.setString(4, data.getUsageLimit());
      ps.setString(5, data.getLimitType());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getUpdatedUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BarcodeSpec> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BarcodeSpec data : dataList) {
        ps.setString(1, data.getBarcodeId());
        ps.setString(2, data.getItem());
        ps.setString(3, data.getSpec());
        ps.setString(4, data.getUsageLimit());
        ps.setString(5, data.getLimitType());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getUpdatedUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BarcodeSpec data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItem());
      ps.setString(2, data.getSpec());
      ps.setString(3, data.getUsageLimit());
      ps.setString(4, data.getLimitType());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getUpdatedUser());
      ps.setString(7, data.getBarcodeId());

      return ps.executeUpdate();
    }
  }

  public int update(List<BarcodeSpec> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BarcodeSpec data : dataList) {
        ps.setString(1, data.getItem());
        ps.setString(2, data.getSpec());
        ps.setString(3, data.getUsageLimit());
        ps.setString(4, data.getLimitType());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getUpdatedUser());
        ps.setString(7, data.getBarcodeId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String barcodeId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_barcode_spec WHERE barcode_id=?")) {
      ps.setString(1, barcodeId);

      return ps.executeUpdate();
    }
  }

  public List<BarcodeSpec> selectAll() throws SQLException {
    ArrayList<BarcodeSpec> result = new ArrayList<BarcodeSpec>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public BarcodeSpec selectByPK(String barcodeId) throws SQLException {
    BarcodeSpec result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE barcode_id=?")) {
      ps.setString(1, barcodeId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private BarcodeSpec convert(ResultSet rs) throws SQLException {
    BarcodeSpec data = new BarcodeSpec();

    int index = 1;
    data.setBarcodeId(rs.getString(index++));
    data.setItem(rs.getString(index++));
    data.setSpec(rs.getString(index++));
    data.setUsageLimit(rs.getString(index++));
    data.setLimitType(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));

    return data;
  }
}
