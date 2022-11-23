package ame.psb.db.dao;

import ame.psb.db.Attachment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class AttachmentDao {

  private static final String SQL_INS = "INSERT INTO attachment(handle,site,attached_from_gbo,sequence,key_id,qty_req,created_date_time,modified_date_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE attachment SET site=?,attached_from_gbo=?,sequence=?,key_id=?,qty_req=?,created_date_time=?,modified_date_time=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,site,attached_from_gbo,sequence,key_id,qty_req,created_date_time,modified_date_time FROM attachment ";

  private final Connection conn;

  public AttachmentDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Attachment data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getAttachedFromGbo());
      ps.setBigDecimal(4, data.getSequence());
      ps.setBigDecimal(5, data.getKeyId());
      ps.setBigDecimal(6, data.getQtyReq());
      DateUtils.setDateTz(ps, 7, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 8, data.getModifiedDateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Attachment> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Attachment data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getSite());
        ps.setString(3, data.getAttachedFromGbo());
        ps.setBigDecimal(4, data.getSequence());
        ps.setBigDecimal(5, data.getKeyId());
        ps.setBigDecimal(6, data.getQtyReq());
        DateUtils.setDateTz(ps, 7, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 8, data.getModifiedDateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Attachment data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSite());
      ps.setString(2, data.getAttachedFromGbo());
      ps.setBigDecimal(3, data.getSequence());
      ps.setBigDecimal(4, data.getKeyId());
      ps.setBigDecimal(5, data.getQtyReq());
      DateUtils.setDateTz(ps, 6, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 7, data.getModifiedDateTime());
      ps.setString(8, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<Attachment> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Attachment data : dataList) {
        ps.setString(1, data.getSite());
        ps.setString(2, data.getAttachedFromGbo());
        ps.setBigDecimal(3, data.getSequence());
        ps.setBigDecimal(4, data.getKeyId());
        ps.setBigDecimal(5, data.getQtyReq());
        DateUtils.setDateTz(ps, 6, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 7, data.getModifiedDateTime());
        ps.setString(8, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM attachment WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<Attachment> selectAll() throws SQLException {
    ArrayList<Attachment> result = new ArrayList<Attachment>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Attachment selectByPrimaryKey(String handle) throws SQLException {
    Attachment result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public List<Attachment> selectByAttachedFromGbo(String attachedFromGbo) throws SQLException {
    List<Attachment> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ATTACHED_FROM_GBO =?")) {
      ps.setString(1, attachedFromGbo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Attachment> selectByPK(String handle) throws SQLException {
    List<Attachment> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private Attachment convert(ResultSet rs) throws SQLException {
    Attachment data = new Attachment();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setAttachedFromGbo(rs.getString(index++));
    data.setSequence(rs.getBigDecimal(index++));
    data.setKeyId(rs.getBigDecimal(index++));
    data.setQtyReq(rs.getBigDecimal(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
