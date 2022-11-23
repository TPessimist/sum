package ame.psb.db.dao;

import ame.psb.db.Picture68RunSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class Picture68RunSfcDao {

  private static final String SQL_INS = "INSERT INTO zr_68_picture_2d_run_sfc(sfc_bo,group_id,group_seq,root_sfc,picture_flag,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_68_picture_2d_run_sfc SET group_id=?,group_seq=?,root_sfc=?,picture_flag=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE sfc_bo=?";

  private static final String SQL_SEL = "SELECT sfc_bo,group_id,group_seq,root_sfc,picture_flag,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_68_picture_2d_run_sfc ";

  private final Connection conn;

  public Picture68RunSfcDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Picture68RunSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getGroupId());
      ps.setBigDecimal(3, data.getGroupSeq());
      ps.setString(4, data.getRootSfc());
      ps.setString(5, data.getPictureFlag());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Picture68RunSfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Picture68RunSfc data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getGroupId());
        ps.setBigDecimal(3, data.getGroupSeq());
        ps.setString(4, data.getRootSfc());
        ps.setString(5, data.getPictureFlag());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Picture68RunSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getGroupId());
      ps.setBigDecimal(2, data.getGroupSeq());
      ps.setString(3, data.getRootSfc());
      ps.setString(4, data.getPictureFlag());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getSfcBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<Picture68RunSfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Picture68RunSfc data : dataList) {
        ps.setString(1, data.getGroupId());
        ps.setBigDecimal(2, data.getGroupSeq());
        ps.setString(3, data.getRootSfc());
        ps.setString(4, data.getPictureFlag());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getSfcBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_68_picture_2d_run_sfc WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      return ps.executeUpdate();
    }
  }

  public List<Picture68RunSfc> selectAll() throws SQLException {
    ArrayList<Picture68RunSfc> result = new ArrayList<Picture68RunSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Picture68RunSfc> selectNoPicture() throws SQLException {
    ArrayList<Picture68RunSfc> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where picture_flag = 'WAIT'")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Picture68RunSfc selectByPK(String sfcBo) throws SQLException {
    Picture68RunSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private Picture68RunSfc convert(ResultSet rs) throws SQLException {
    Picture68RunSfc data = new Picture68RunSfc();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setGroupId(rs.getString(index++));
    data.setGroupSeq(rs.getBigDecimal(index++));
    data.setRootSfc(rs.getString(index++));
    data.setPictureFlag(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
