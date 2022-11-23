package ame.psb.db.dao;

import ame.psb.db.LabelBuyOff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class LabelBuyOffDao {

  private static final String SQL_INS = "INSERT INTO zd_label_buyoff(label_id,combine_type,buyoff_container,buyoff_operation,buyoff_flag,pe1_approved,pe1_comment,pe1_picture_path,pe1_user,pe1_updated_time,pe2_approved,pe2_comment,pe2_picture_path,pe2_user,pe2_updated_time,qe_approved,qe_comment,qe_picture_path,qe_user,qe_updated_time,reversed_field1,reversed_field2,reversed_field3) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_label_buyoff SET buyoff_container=?,buyoff_operation=?,buyoff_flag=?,pe1_approved=?,pe1_comment=?,pe1_picture_path=?,pe1_user=?,pe1_updated_time=?,pe2_approved=?,pe2_comment=?,pe2_picture_path=?,pe2_user=?,pe2_updated_time=?,qe_approved=?,qe_comment=?,qe_picture_path=?,qe_user=?,qe_updated_time=?,reversed_field1=?,reversed_field2=?,reversed_field3=? WHERE label_id=? AND combine_type=?";

  private static final String SQL_SEL = "SELECT label_id,combine_type,buyoff_container,buyoff_operation,buyoff_flag,pe1_approved,pe1_comment,pe1_picture_path,pe1_user,pe1_updated_time,pe2_approved,pe2_comment,pe2_picture_path,pe2_user,pe2_updated_time,qe_approved,qe_comment,qe_picture_path,qe_user,qe_updated_time,reversed_field1,reversed_field2,reversed_field3 FROM zd_label_buyoff ";

  private final Connection conn;

  public LabelBuyOffDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(LabelBuyOff data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
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

      return ps.executeUpdate();
    }
  }

  public int insert(List<LabelBuyOff> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (LabelBuyOff data : dataList) {
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

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(LabelBuyOff data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getBuyoffContainer());
      ps.setString(2, data.getBuyoffOperation());
      ps.setString(3, data.getBuyoffFlag());
      ps.setString(4, data.getPe1Approved());
      ps.setString(5, data.getPe1Comment());
      ps.setString(6, data.getPe1PicturePath());
      ps.setString(7, data.getPe1User());
      DateUtils.setDateTz(ps, 8, data.getPe1UpdatedTime());
      ps.setString(9, data.getPe2Approved());
      ps.setString(10, data.getPe2Comment());
      ps.setString(11, data.getPe2PicturePath());
      ps.setString(12, data.getPe2User());
      DateUtils.setDateTz(ps, 13, data.getPe2UpdatedTime());
      ps.setString(14, data.getQeApproved());
      ps.setString(15, data.getQeComment());
      ps.setString(16, data.getQePicturePath());
      ps.setString(17, data.getQeUser());
      DateUtils.setDateTz(ps, 18, data.getQeUpdatedTime());
      ps.setString(19, data.getReversedField1());
      ps.setString(20, data.getReversedField2());
      ps.setString(21, data.getReversedField3());
      ps.setString(22, data.getLabelId());
      ps.setString(23, data.getCombineType());

      return ps.executeUpdate();
    }
  }

  public int update(List<LabelBuyOff> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (LabelBuyOff data : dataList) {
        ps.setString(1, data.getBuyoffContainer());
        ps.setString(2, data.getBuyoffOperation());
        ps.setString(3, data.getBuyoffFlag());
        ps.setString(4, data.getPe1Approved());
        ps.setString(5, data.getPe1Comment());
        ps.setString(6, data.getPe1PicturePath());
        ps.setString(7, data.getPe1User());
        DateUtils.setDateTz(ps, 8, data.getPe1UpdatedTime());
        ps.setString(9, data.getPe2Approved());
        ps.setString(10, data.getPe2Comment());
        ps.setString(11, data.getPe2PicturePath());
        ps.setString(12, data.getPe2User());
        DateUtils.setDateTz(ps, 13, data.getPe2UpdatedTime());
        ps.setString(14, data.getQeApproved());
        ps.setString(15, data.getQeComment());
        ps.setString(16, data.getQePicturePath());
        ps.setString(17, data.getQeUser());
        DateUtils.setDateTz(ps, 18, data.getQeUpdatedTime());
        ps.setString(19, data.getReversedField1());
        ps.setString(20, data.getReversedField2());
        ps.setString(21, data.getReversedField3());
        ps.setString(22, data.getLabelId());
        ps.setString(23, data.getCombineType());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String labelId, String combineType) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_label_buyoff WHERE label_id=? AND combine_type=?")) {
      ps.setString(1, labelId);
      ps.setString(2, combineType);

      return ps.executeUpdate();
    }
  }

  public List<LabelBuyOff> selectAll() throws SQLException {
    ArrayList<LabelBuyOff> result = new ArrayList<LabelBuyOff>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public LabelBuyOff selectByPK(String labelId, String combineType) throws SQLException {
    LabelBuyOff result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE label_id=? AND combine_type=?")) {
      ps.setString(1, labelId);
      ps.setString(2, combineType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public LabelBuyOff selectBylabelIdAndContainer(String labelId, String container)
      throws SQLException {
    LabelBuyOff result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE label_id=? AND buyoff_container=?")) {
      ps.setString(1, labelId);
      ps.setString(2, container);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<LabelBuyOff> selectByLabel(String labelId) throws SQLException {
    ArrayList<LabelBuyOff> result = new ArrayList<LabelBuyOff>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE label_id=?")) {
      ps.setString(1, labelId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<LabelBuyOff> selectByContainer(String container) throws SQLException {
    ArrayList<LabelBuyOff> result = new ArrayList<LabelBuyOff>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE buyoff_container=?")) {
      ps.setString(1, container);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<LabelBuyOff> selectByLabelAndContainer(String labelId, String container)
      throws SQLException { //通过标签和容器查询所有记录进行统一buyoff
    ArrayList<LabelBuyOff> result = new ArrayList<LabelBuyOff>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE label_id=? AND buyoff_container=? ")) {
      ps.setString(1, labelId);
      ps.setString(2, container);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private LabelBuyOff convert(ResultSet rs) throws SQLException {
    LabelBuyOff data = new LabelBuyOff();

    int index = 1;
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

    return data;
  }
}
