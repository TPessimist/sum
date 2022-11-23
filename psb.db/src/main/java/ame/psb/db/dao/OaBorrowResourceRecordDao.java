package ame.psb.db.dao;

import ame.psb.db.OaBorrowResourceRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class OaBorrowResourceRecordDao {

  private static final String SQL_INS = "INSERT INTO zd_oa_borrow_resource_record(id,request_id,resource_bo,applicant,pmc_user,expect_begin_time,expect_end_time,state_name,actual_begin_time,actual_end_time,borrow_type,comment,note,description,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_oa_borrow_resource_record SET request_id=?,resource_bo=?,applicant=?,pmc_user=?,expect_begin_time=?,expect_end_time=?,state_name=?,actual_begin_time=?,actual_end_time=?,borrow_type=?,comment=?,note=?,description=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,request_id,resource_bo,applicant,pmc_user,expect_begin_time,expect_end_time,state_name,actual_begin_time,actual_end_time,borrow_type,comment,note,description,updated_user,updated_time FROM zd_oa_borrow_resource_record ";

  private final Connection conn;

  public OaBorrowResourceRecordDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(OaBorrowResourceRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getRequestId());
      ps.setString(3, data.getResourceBo());
      ps.setString(4, data.getApplicant());
      ps.setString(5, data.getPmcUser());
      DateUtils.setDateTz(ps, 6, data.getExpectBeginTime());
      DateUtils.setDateTz(ps, 7, data.getExpectEndTime());
      ps.setString(8, data.getStateName());
      DateUtils.setDateTz(ps, 9, data.getActualBeginTime());
      DateUtils.setDateTz(ps, 10, data.getActualEndTime());
      ps.setString(11, data.getBorrowType());
      ps.setString(12, data.getComment());
      ps.setString(13, data.getNote());
      ps.setString(14, data.getDescription());
      ps.setString(15, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 16, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<OaBorrowResourceRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (OaBorrowResourceRecord data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getRequestId());
        ps.setString(3, data.getResourceBo());
        ps.setString(4, data.getApplicant());
        ps.setString(5, data.getPmcUser());
        DateUtils.setDateTz(ps, 6, data.getExpectBeginTime());
        DateUtils.setDateTz(ps, 7, data.getExpectEndTime());
        ps.setString(8, data.getStateName());
        DateUtils.setDateTz(ps, 9, data.getActualBeginTime());
        DateUtils.setDateTz(ps, 10, data.getActualEndTime());
        ps.setString(11, data.getBorrowType());
        ps.setString(12, data.getComment());
        ps.setString(13, data.getNote());
        ps.setString(14, data.getDescription());
        ps.setString(15, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 16, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(OaBorrowResourceRecord data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getRequestId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getApplicant());
      ps.setString(4, data.getPmcUser());
      DateUtils.setDateTz(ps, 5, data.getExpectBeginTime());
      DateUtils.setDateTz(ps, 6, data.getExpectEndTime());
      ps.setString(7, data.getStateName());
      DateUtils.setDateTz(ps, 8, data.getActualBeginTime());
      DateUtils.setDateTz(ps, 9, data.getActualEndTime());
      ps.setString(10, data.getBorrowType());
      ps.setString(11, data.getComment());
      ps.setString(12, data.getNote());
      ps.setString(13, data.getDescription());
      ps.setString(14, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 15, data.getUpdatedTime());
      ps.setString(16, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<OaBorrowResourceRecord> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (OaBorrowResourceRecord data : dataList) {
        ps.setString(1, data.getRequestId());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getApplicant());
        ps.setString(4, data.getPmcUser());
        DateUtils.setDateTz(ps, 5, data.getExpectBeginTime());
        DateUtils.setDateTz(ps, 6, data.getExpectEndTime());
        ps.setString(7, data.getStateName());
        DateUtils.setDateTz(ps, 8, data.getActualBeginTime());
        DateUtils.setDateTz(ps, 9, data.getActualEndTime());
        ps.setString(10, data.getBorrowType());
        ps.setString(11, data.getComment());
        ps.setString(12, data.getNote());
        ps.setString(13, data.getDescription());
        ps.setString(14, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 15, data.getUpdatedTime());
        ps.setString(16, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_oa_borrow_resource_record WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<OaBorrowResourceRecord> selectAll() throws SQLException {
    ArrayList<OaBorrowResourceRecord> result = new ArrayList<OaBorrowResourceRecord>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public OaBorrowResourceRecord selectByPK(String id) throws SQLException {
    OaBorrowResourceRecord result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public OaBorrowResourceRecord selectByRequestId(String requestId) throws SQLException {
    OaBorrowResourceRecord result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE request_id=?")) {
      ps.setString(1, requestId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<OaBorrowResourceRecord> selectByStateName(String stateName) throws SQLException {
    ArrayList<OaBorrowResourceRecord> result = new ArrayList<OaBorrowResourceRecord>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE state_name = ? ORDER BY expect_begin_time ASC")) {
      ps.setString(1, stateName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OaBorrowResourceRecord> selectByResourceBo(String resourceBo) throws SQLException {
    ArrayList<OaBorrowResourceRecord> result = new ArrayList<OaBorrowResourceRecord>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo = ? AND state_name != 'DONE' ")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private OaBorrowResourceRecord convert(ResultSet rs) throws SQLException {
    OaBorrowResourceRecord data = new OaBorrowResourceRecord();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setRequestId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setApplicant(rs.getString(index++));
    data.setPmcUser(rs.getString(index++));
    data.setExpectBeginTime(DateUtils.getDateTz(rs, index++));
    data.setExpectEndTime(DateUtils.getDateTz(rs, index++));
    data.setStateName(rs.getString(index++));
    data.setActualBeginTime(DateUtils.getDateTz(rs, index++));
    data.setActualEndTime(DateUtils.getDateTz(rs, index++));
    data.setBorrowType(rs.getString(index++));
    data.setComment(rs.getString(index++));
    data.setNote(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
