package ame.me.db.dao;

import ame.me.db.ReasonCode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class ReasonCodeDao {

  private static final String SQL_INS = "INSERT INTO reason_code(handle,site,reason_code,description,category,status_bo,message_type_bo,modified_date_time,created_date_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE reason_code SET site=?,reason_code=?,description=?,category=?,status_bo=?,message_type_bo=?,modified_date_time=?,created_date_time=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,site,reason_code,description,category,status_bo,message_type_bo,modified_date_time,created_date_time FROM reason_code ";

  private final Connection conn;

  public ReasonCodeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ReasonCode data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getReasonCode());
      ps.setString(4, data.getDescription());
      ps.setString(5, data.getCategory());
      ps.setString(6, data.getStatusBo());
      ps.setString(7, data.getMessageTypeBo());
      DateUtils.setDateTz(ps, 8, data.getModifiedDateTime());
      DateUtils.setDateTz(ps, 9, data.getCreatedDateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ReasonCode> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ReasonCode data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getSite());
        ps.setString(3, data.getReasonCode());
        ps.setString(4, data.getDescription());
        ps.setString(5, data.getCategory());
        ps.setString(6, data.getStatusBo());
        ps.setString(7, data.getMessageTypeBo());
        DateUtils.setDateTz(ps, 8, data.getModifiedDateTime());
        DateUtils.setDateTz(ps, 9, data.getCreatedDateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ReasonCode data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSite());
      ps.setString(2, data.getReasonCode());
      ps.setString(3, data.getDescription());
      ps.setString(4, data.getCategory());
      ps.setString(5, data.getStatusBo());
      ps.setString(6, data.getMessageTypeBo());
      DateUtils.setDateTz(ps, 7, data.getModifiedDateTime());
      DateUtils.setDateTz(ps, 8, data.getCreatedDateTime());
      ps.setString(9, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<ReasonCode> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ReasonCode data : dataList) {
        ps.setString(1, data.getSite());
        ps.setString(2, data.getReasonCode());
        ps.setString(3, data.getDescription());
        ps.setString(4, data.getCategory());
        ps.setString(5, data.getStatusBo());
        ps.setString(6, data.getMessageTypeBo());
        DateUtils.setDateTz(ps, 7, data.getModifiedDateTime());
        DateUtils.setDateTz(ps, 8, data.getCreatedDateTime());
        ps.setString(9, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM reason_code WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<ReasonCode> selectAll() throws SQLException {
    ArrayList<ReasonCode> result = new ArrayList<ReasonCode>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ReasonCode selectByPK(String handle) throws SQLException {
    ReasonCode result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ReasonCode> select(Where where) throws SQLException {
    ArrayList<ReasonCode> result = new ArrayList<ReasonCode>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  private ReasonCode convert(ResultSet rs) throws SQLException {
    ReasonCode data = new ReasonCode();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setReasonCode(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setCategory(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setMessageTypeBo(rs.getString(index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
