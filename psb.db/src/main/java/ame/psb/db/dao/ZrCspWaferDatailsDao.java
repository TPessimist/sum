package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ZrCspWaferDatails;
import uia.utils.dao.DateUtils;

public class ZrCspWaferDatailsDao {

  private static final String SQL_INS = "INSERT INTO zr_csp_wafer_details(uuid,details_id,wafet_name,qty,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_csp_wafer_details SET wafet_name=?,qty=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE uuid=? AND details_id=?";

  private static final String SQL_SEL = "SELECT uuid,details_id,wafet_name,qty,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_csp_wafer_details ";

  private final Connection conn;

  public ZrCspWaferDatailsDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZrCspWaferDatails data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getDetailsId());
      ps.setString(3, data.getWafetName());
      ps.setString(4, data.getQty());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZrCspWaferDatails> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZrCspWaferDatails data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getDetailsId());
        ps.setString(3, data.getWafetName());
        ps.setString(4, data.getQty());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZrCspWaferDatails data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getWafetName());
      ps.setString(2, data.getQty());
      ps.setString(3, data.getReversedField1());
      ps.setString(4, data.getReversedField2());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getUuid());
      ps.setString(8, data.getDetailsId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZrCspWaferDatails> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZrCspWaferDatails data : dataList) {
        ps.setString(1, data.getWafetName());
        ps.setString(2, data.getQty());
        ps.setString(3, data.getReversedField1());
        ps.setString(4, data.getReversedField2());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getUuid());
        ps.setString(8, data.getDetailsId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid, String detailsId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_csp_wafer_details WHERE uuid=? AND details_id=?")) {
      ps.setString(1, uuid);
      ps.setString(2, detailsId);

      return ps.executeUpdate();
    }
  }

  public List<ZrCspWaferDatails> selectAll() throws SQLException {
    ArrayList<ZrCspWaferDatails> result = new ArrayList<ZrCspWaferDatails>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZrCspWaferDatails selectByPK(String uuid, String detailsId) throws SQLException {
    ZrCspWaferDatails result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE uuid=? AND details_id=?")) {
      ps.setString(1, uuid);
      ps.setString(2, detailsId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZrCspWaferDatails> selectByDetailsId(String detailsId) throws SQLException {
    List<ZrCspWaferDatails> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE  details_id=?")) {
      ps.setString(1, detailsId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        ;
      }
      {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ZrCspWaferDatails convert(ResultSet rs) throws SQLException {
    ZrCspWaferDatails data = new ZrCspWaferDatails();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setDetailsId(rs.getString(index++));
    data.setWafetName(rs.getString(index++));
    data.setQty(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
