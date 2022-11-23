package ame.psb.db.dao;

import ame.psb.db.Ts81MarkingCodeRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class Ts81MarkingCodeRecordDao {

  private static final String SQL_INS = "INSERT INTO zd_ts81_marking_code_record(uuid,shop_order,marking_code,updated_user,updated_time) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_ts81_marking_code_record SET shop_order=?,marking_code=?,updated_user=?,updated_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,shop_order,marking_code,updated_user,updated_time FROM zd_ts81_marking_code_record ";

  private final Connection conn;

  public Ts81MarkingCodeRecordDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Ts81MarkingCodeRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getShopOrder());
      ps.setString(3, data.getMarkingCode());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Ts81MarkingCodeRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Ts81MarkingCodeRecord data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getShopOrder());
        ps.setString(3, data.getMarkingCode());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Ts81MarkingCodeRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getShopOrder());
      ps.setString(2, data.getMarkingCode());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<Ts81MarkingCodeRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Ts81MarkingCodeRecord data : dataList) {
        ps.setString(1, data.getShopOrder());
        ps.setString(2, data.getMarkingCode());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_ts81_marking_code_record WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<Ts81MarkingCodeRecord> selectAll() throws SQLException {
    ArrayList<Ts81MarkingCodeRecord> result = new ArrayList<Ts81MarkingCodeRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Ts81MarkingCodeRecord selectByPK(String uuid) throws SQLException {
    Ts81MarkingCodeRecord result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private Ts81MarkingCodeRecord convert(ResultSet rs) throws SQLException {
    Ts81MarkingCodeRecord data = new Ts81MarkingCodeRecord();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setMarkingCode(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
