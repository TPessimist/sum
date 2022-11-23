package ame.psb.db.dao;

import ame.psb.db.PkgLabelCheckUnpack;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgLabelCheckUnpackDao {

  private static final String SQL_INS = "INSERT INTO zr_pkg_labelcheck_unpack(label_temp_info,sfc_name,item_group_bo,label_reel_info,label_box_info,container_bo,label_in_info,label_out_info,pkg_container_bo,updated_user,updated_time,flag,check_time,check_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_pkg_labelcheck_unpack SET sfc_name=?,item_group_bo=?,label_reel_info=?,label_box_info=?,container_bo=?,label_in_info=?,label_out_info=?,pkg_container_bo=?,updated_user=?,updated_time=?,flag=?,check_time=?,check_user=? WHERE label_temp_info=?";

  private static final String SQL_SEL = "SELECT label_temp_info,sfc_name,item_group_bo,label_reel_info,label_box_info,container_bo,label_in_info,label_out_info,pkg_container_bo,updated_user,updated_time,flag,check_time,check_user FROM zr_pkg_labelcheck_unpack ";

  private final Connection conn;

  public PkgLabelCheckUnpackDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgLabelCheckUnpack data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getLabelTempInfo());
      ps.setString(2, data.getSfcName());
      ps.setString(3, data.getItemGroupBo());
      ps.setString(4, data.getLabelReelInfo());
      ps.setString(5, data.getLabelBoxInfo());
      ps.setString(6, data.getContainerBo());
      ps.setString(7, data.getLabelInInfo());
      ps.setString(8, data.getLabelOutInfo());
      ps.setString(9, data.getPkgContainerBo());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
      ps.setString(12, data.getFlag());
      DateUtils.setDateTz(ps, 13, data.getCheckTime());
      ps.setString(14, data.getCheckUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PkgLabelCheckUnpack> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PkgLabelCheckUnpack data : dataList) {
        ps.setString(1, data.getLabelTempInfo());
        ps.setString(2, data.getSfcName());
        ps.setString(3, data.getItemGroupBo());
        ps.setString(4, data.getLabelReelInfo());
        ps.setString(5, data.getLabelBoxInfo());
        ps.setString(6, data.getContainerBo());
        ps.setString(7, data.getLabelInInfo());
        ps.setString(8, data.getLabelOutInfo());
        ps.setString(9, data.getPkgContainerBo());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
        ps.setString(12, data.getFlag());
        DateUtils.setDateTz(ps, 13, data.getCheckTime());
        ps.setString(14, data.getCheckUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PkgLabelCheckUnpack data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcName());
      ps.setString(2, data.getItemGroupBo());
      ps.setString(3, data.getLabelReelInfo());
      ps.setString(4, data.getLabelBoxInfo());
      ps.setString(5, data.getContainerBo());
      ps.setString(6, data.getLabelInInfo());
      ps.setString(7, data.getLabelOutInfo());
      ps.setString(8, data.getPkgContainerBo());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
      ps.setString(11, data.getFlag());
      DateUtils.setDateTz(ps, 12, data.getCheckTime());
      ps.setString(13, data.getCheckUser());
      ps.setString(14, data.getLabelTempInfo());

      return ps.executeUpdate();
    }
  }

  public int update(List<PkgLabelCheckUnpack> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PkgLabelCheckUnpack data : dataList) {
        ps.setString(1, data.getSfcName());
        ps.setString(2, data.getItemGroupBo());
        ps.setString(3, data.getLabelReelInfo());
        ps.setString(4, data.getLabelBoxInfo());
        ps.setString(5, data.getContainerBo());
        ps.setString(6, data.getLabelInInfo());
        ps.setString(7, data.getLabelOutInfo());
        ps.setString(8, data.getPkgContainerBo());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
        ps.setString(11, data.getFlag());
        DateUtils.setDateTz(ps, 12, data.getCheckTime());
        ps.setString(13, data.getCheckUser());
        ps.setString(14, data.getLabelTempInfo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String labelTempInfo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_labelcheck_unpack WHERE label_temp_info=?")) {
      ps.setString(1, labelTempInfo);

      return ps.executeUpdate();
    }
  }

  public List<PkgLabelCheckUnpack> selectAll() throws SQLException {
    ArrayList<PkgLabelCheckUnpack> result = new ArrayList<PkgLabelCheckUnpack>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PkgLabelCheckUnpack selectByPK(String labelTempInfo) throws SQLException {
    PkgLabelCheckUnpack result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE label_temp_info=?")) {
      ps.setString(1, labelTempInfo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgLabelCheckUnpack convert(ResultSet rs) throws SQLException {
    PkgLabelCheckUnpack data = new PkgLabelCheckUnpack();

    int index = 1;
    data.setLabelTempInfo(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setLabelReelInfo(rs.getString(index++));
    data.setLabelBoxInfo(rs.getString(index++));
    data.setContainerBo(rs.getString(index++));
    data.setLabelInInfo(rs.getString(index++));
    data.setLabelOutInfo(rs.getString(index++));
    data.setPkgContainerBo(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setFlag(rs.getString(index++));
    data.setCheckTime(DateUtils.getDateTz(rs, index++));
    data.setCheckUser(rs.getString(index++));

    return data;
  }
}
