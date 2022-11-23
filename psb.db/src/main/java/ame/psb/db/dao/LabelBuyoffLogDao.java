package ame.psb.db.dao;

import ame.psb.db.LabelBuyoffLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class LabelBuyoffLogDao {

  private static final String SQL_INS = "INSERT INTO zd_label_buyoff_log(uuid,label_id,combine_type,buyoff_container,buyoff_operation,buyoff_flag,pe1_approved,pe1_comment,pe1_picture_path,pe1_user,pe1_updated_time,pe2_approved,pe2_comment,pe2_picture_path,pe2_user,pe2_updated_time,qe_approved,qe_comment,qe_picture_path,qe_user,qe_updated_time,reversed_field1,reversed_field2,reversed_field3,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_label_buyoff_log SET label_id=?,combine_type=?,buyoff_container=?,buyoff_operation=?,buyoff_flag=?,pe1_approved=?,pe1_comment=?,pe1_picture_path=?,pe1_user=?,pe1_updated_time=?,pe2_approved=?,pe2_comment=?,pe2_picture_path=?,pe2_user=?,pe2_updated_time=?,qe_approved=?,qe_comment=?,qe_picture_path=?,qe_user=?,qe_updated_time=?,reversed_field1=?,reversed_field2=?,reversed_field3=?,updated_user=?,updated_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,label_id,combine_type,buyoff_container,buyoff_operation,buyoff_flag,pe1_approved,pe1_comment,pe1_picture_path,pe1_user,pe1_updated_time,pe2_approved,pe2_comment,pe2_picture_path,pe2_user,pe2_updated_time,qe_approved,qe_comment,qe_picture_path,qe_user,qe_updated_time,reversed_field1,reversed_field2,reversed_field3,updated_user,updated_time FROM zd_label_buyoff_log ";

  private final Connection conn;

  public LabelBuyoffLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(LabelBuyoffLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getLabelId());
      ps.setString(3, data.getCombineType());
      ps.setString(4, data.getBuyoffContainer());
      ps.setString(5, data.getBuyoffOperation());
      ps.setString(6, data.getBuyoffFlag());
      ps.setString(7, data.getPe1Approved());
      ps.setString(8, data.getPe1Comment());
      ps.setString(9, data.getPe1PicturePath());
      ps.setString(10, data.getPe1User());
      DateUtils.setDateTz(ps, 11, data.getPe1UpdatedTime());
      ps.setString(12, data.getPe2Approved());
      ps.setString(13, data.getPe2Comment());
      ps.setString(14, data.getPe2PicturePath());
      ps.setString(15, data.getPe2User());
      DateUtils.setDateTz(ps, 16, data.getPe2UpdatedTime());
      ps.setString(17, data.getQeApproved());
      ps.setString(18, data.getQeComment());
      ps.setString(19, data.getQePicturePath());
      ps.setString(20, data.getQeUser());
      DateUtils.setDateTz(ps, 21, data.getQeUpdatedTime());
      ps.setString(22, data.getReversedField1());
      ps.setString(23, data.getReversedField2());
      ps.setString(24, data.getReversedField3());
      ps.setString(25, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 26, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<LabelBuyoffLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (LabelBuyoffLog data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getLabelId());
        ps.setString(3, data.getCombineType());
        ps.setString(4, data.getBuyoffContainer());
        ps.setString(5, data.getBuyoffOperation());
        ps.setString(6, data.getBuyoffFlag());
        ps.setString(7, data.getPe1Approved());
        ps.setString(8, data.getPe1Comment());
        ps.setString(9, data.getPe1PicturePath());
        ps.setString(10, data.getPe1User());
        DateUtils.setDateTz(ps, 11, data.getPe1UpdatedTime());
        ps.setString(12, data.getPe2Approved());
        ps.setString(13, data.getPe2Comment());
        ps.setString(14, data.getPe2PicturePath());
        ps.setString(15, data.getPe2User());
        DateUtils.setDateTz(ps, 16, data.getPe2UpdatedTime());
        ps.setString(17, data.getQeApproved());
        ps.setString(18, data.getQeComment());
        ps.setString(19, data.getQePicturePath());
        ps.setString(20, data.getQeUser());
        DateUtils.setDateTz(ps, 21, data.getQeUpdatedTime());
        ps.setString(22, data.getReversedField1());
        ps.setString(23, data.getReversedField2());
        ps.setString(24, data.getReversedField3());
        ps.setString(25, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 26, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(LabelBuyoffLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getLabelId());
      ps.setString(2, data.getCombineType());
      ps.setString(3, data.getBuyoffContainer());
      ps.setString(4, data.getBuyoffOperation());
      ps.setString(5, data.getBuyoffFlag());
      ps.setString(6, data.getPe1Approved());
      ps.setString(7, data.getPe1Comment());
      ps.setString(8, data.getPe1PicturePath());
      ps.setString(9, data.getPe1User());
      DateUtils.setDateTz(ps, 10, data.getPe1UpdatedTime());
      ps.setString(11, data.getPe2Approved());
      ps.setString(12, data.getPe2Comment());
      ps.setString(13, data.getPe2PicturePath());
      ps.setString(14, data.getPe2User());
      DateUtils.setDateTz(ps, 15, data.getPe2UpdatedTime());
      ps.setString(16, data.getQeApproved());
      ps.setString(17, data.getQeComment());
      ps.setString(18, data.getQePicturePath());
      ps.setString(19, data.getQeUser());
      DateUtils.setDateTz(ps, 20, data.getQeUpdatedTime());
      ps.setString(21, data.getReversedField1());
      ps.setString(22, data.getReversedField2());
      ps.setString(23, data.getReversedField3());
      ps.setString(24, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 25, data.getUpdatedTime());
      ps.setString(26, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<LabelBuyoffLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (LabelBuyoffLog data : dataList) {
        ps.setString(1, data.getLabelId());
        ps.setString(2, data.getCombineType());
        ps.setString(3, data.getBuyoffContainer());
        ps.setString(4, data.getBuyoffOperation());
        ps.setString(5, data.getBuyoffFlag());
        ps.setString(6, data.getPe1Approved());
        ps.setString(7, data.getPe1Comment());
        ps.setString(8, data.getPe1PicturePath());
        ps.setString(9, data.getPe1User());
        DateUtils.setDateTz(ps, 10, data.getPe1UpdatedTime());
        ps.setString(11, data.getPe2Approved());
        ps.setString(12, data.getPe2Comment());
        ps.setString(13, data.getPe2PicturePath());
        ps.setString(14, data.getPe2User());
        DateUtils.setDateTz(ps, 15, data.getPe2UpdatedTime());
        ps.setString(16, data.getQeApproved());
        ps.setString(17, data.getQeComment());
        ps.setString(18, data.getQePicturePath());
        ps.setString(19, data.getQeUser());
        DateUtils.setDateTz(ps, 20, data.getQeUpdatedTime());
        ps.setString(21, data.getReversedField1());
        ps.setString(22, data.getReversedField2());
        ps.setString(23, data.getReversedField3());
        ps.setString(24, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 25, data.getUpdatedTime());
        ps.setString(26, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_label_buyoff_log WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<LabelBuyoffLog> selectAll() throws SQLException {
    ArrayList<LabelBuyoffLog> result = new ArrayList<LabelBuyoffLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public LabelBuyoffLog selectByPK(String uuid) throws SQLException {
    LabelBuyoffLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public LabelBuyoffLog selectByLabelAndCombineType(String labelId,String combineType) throws SQLException {
    LabelBuyoffLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE label_id=? AND combine_type=? ORDER BY updated_time DESC ")) {
      ps.setString(1, labelId);
      ps.setString(2, combineType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public LabelBuyoffLog selectByContainer(String containerBo) throws SQLException {
    LabelBuyoffLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE buyoff_container=? ")) {
      ps.setString(1, containerBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private LabelBuyoffLog convert(ResultSet rs) throws SQLException {
    LabelBuyoffLog data = new LabelBuyoffLog();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setLabelId(rs.getString(index++));
    data.setCombineType(rs.getString(index++));
    data.setBuyoffContainer(rs.getString(index++));
    data.setBuyoffOperation(rs.getString(index++));
    data.setBuyoffFlag(rs.getString(index++));
    data.setPe1Approved(rs.getString(index++));
    data.setPe1Comment(rs.getString(index++));
    data.setPe1PicturePath(rs.getString(index++));
    data.setPe1User(rs.getString(index++));
    data.setPe1UpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setPe2Approved(rs.getString(index++));
    data.setPe2Comment(rs.getString(index++));
    data.setPe2PicturePath(rs.getString(index++));
    data.setPe2User(rs.getString(index++));
    data.setPe2UpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setQeApproved(rs.getString(index++));
    data.setQeComment(rs.getString(index++));
    data.setQePicturePath(rs.getString(index++));
    data.setQeUser(rs.getString(index++));
    data.setQeUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setReversedField3(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
