package ame.psb.db.dao;

import ame.psb.db.PkgLabelCheck;
import ame.psb.db.PkgTempLabelCheck;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgLabelCheckDao {

  private static final String SQL_INS = "INSERT INTO zr_pkg_labelcheck(label_temp_info,sfc_name,item_group_bo,label_reel_info,label_box_info,container_bo,label_in_info,label_out_info,pkg_container_bo,updated_user,updated_time,flag,check_time,check_user,reel_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_pkg_labelcheck SET sfc_name=?,item_group_bo=?,label_reel_info=?,label_box_info=?,container_bo=?,label_in_info=?,label_out_info=?,pkg_container_bo=?,updated_user=?,updated_time=?,flag=?,check_time=?,check_user=? WHERE label_temp_info=?";

  private static final String SQL_SEL = "SELECT label_temp_info,sfc_name,item_group_bo,label_reel_info,label_box_info,container_bo,label_in_info,label_out_info,pkg_container_bo,updated_user,updated_time,flag,check_time,check_user FROM zr_pkg_labelcheck ";

  private static final String SQL_UPD_CHECK = "UPDATE zr_pkg_labelcheck SET flag=? WHERE label_temp_info=?";

  private static final String SQL_UPD_OUT = "UPDATE zr_pkg_labelcheck SET label_in_info=?,label_out_info=?,pkg_container_bo=? WHERE label_box_info=?";

  private final Connection conn;

  public PkgLabelCheckDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgLabelCheck data) throws SQLException {
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
      ps.setString(15, data.getReelId());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PkgLabelCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PkgLabelCheck data : dataList) {
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
        ps.setString(15, data.getReelId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PkgLabelCheck data) throws SQLException {
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

  public int updateForOut(PkgLabelCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_OUT)) {

      ps.setString(1, data.getLabelInInfo());
      ps.setString(2, data.getLabelOutInfo());
      ps.setString(3, data.getPkgContainerBo());

      ps.setString(4, data.getLabelBoxInfo());

      return ps.executeUpdate();
    }
  }

  public int update(List<PkgLabelCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PkgLabelCheck data : dataList) {
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


  public int update(PkgTempLabelCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_CHECK)) {
      ps.setString(1, data.getFlag());
      ps.setString(2, data.getLabelTempInfo());

      return ps.executeUpdate();
    }
  }

  public int delete(String labelTempInfo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_labelcheck WHERE label_temp_info=?")) {
      ps.setString(1, labelTempInfo);

      return ps.executeUpdate();
    }
  }

  public List<PkgLabelCheck> selectAll() throws SQLException {
    ArrayList<PkgLabelCheck> result = new ArrayList<PkgLabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public PkgLabelCheck selectAllOrderByTime() throws SQLException {
    PkgLabelCheck result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "ORDER BY updated_time DESC")) {

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgLabelCheck selectAllOrderByTimeOut() throws SQLException {
    PkgLabelCheck result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "ORDER BY check_time DESC")) {

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgLabelCheck selectByCustlot(String Custlot) throws SQLException {
    PkgLabelCheck result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE label_box_info like ? ORDER BY updated_time DESC")) {
      ps.setString(1, "%" + Custlot + "%");

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgLabelCheck selectByPKFlag(String labelTempInfo, String Flag) throws SQLException {
    PkgLabelCheck result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE label_temp_info=? and Flag =?")) {
      ps.setString(1, labelTempInfo);
      ps.setString(2, Flag);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgLabelCheck selectByPK(String labelTempInfo) throws SQLException {
    PkgLabelCheck result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE label_temp_info=?")) {
      ps.setString(1, labelTempInfo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgLabelCheck selectByIn(String inInfo) throws SQLException {
    PkgLabelCheck result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE label_in_info=?")) {
      ps.setString(1, inInfo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgLabelCheck selectByIN(String inInfo) throws SQLException {
    PkgLabelCheck result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE label_in_info like ?")) {
      ps.setString(1, "%" + inInfo + "%");

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgLabelCheck selectByBox(String boxInfo) throws SQLException {
    PkgLabelCheck result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE label_box_info like ?")) {
      ps.setString(1, "%" + boxInfo + "%");

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgLabelCheck selectByReel(String reelInfo) throws SQLException {
    PkgLabelCheck result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE label_reel_info like ?")) {
      ps.setString(1, "%" + reelInfo + "%");

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public PkgLabelCheck selectByContainerBo(String container) throws SQLException {
    PkgLabelCheck result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE container_bo=?")) {
      ps.setString(1, container);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<PkgLabelCheck> selectByContainerBoMore(String container) throws SQLException {
    ArrayList<PkgLabelCheck> result = new ArrayList<PkgLabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE container_bo=?")) {
      ps.setString(1, container);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgLabelCheck> selectByPkgContainerBo(String pkgContainer) throws SQLException {
    ArrayList<PkgLabelCheck> result = new ArrayList<PkgLabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE pkg_container_bo=?")) {
      ps.setString(1, pkgContainer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgLabelCheck> selectByPkgOutInfo(String Outid) throws SQLException {
    ArrayList<PkgLabelCheck> result = new ArrayList<PkgLabelCheck>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE label_out_info like ?")) {
      ps.setString(1, "%" + Outid + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgLabelCheck> selectByOutInfo(String outInfo) throws SQLException {
    ArrayList<PkgLabelCheck> result = new ArrayList<PkgLabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE label_out_info = ?")) {
      ps.setString(1, outInfo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgLabelCheck> selectByPkgInInfoL(String Inid) throws SQLException {
    ArrayList<PkgLabelCheck> result = new ArrayList<PkgLabelCheck>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE label_in_info like ?")) {
      ps.setString(1, "%" + Inid + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgLabelCheck> selectByPkgInInfo(String Inid) throws SQLException {
    ArrayList<PkgLabelCheck> result = new ArrayList<PkgLabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE label_in_info = ?")) {
      ps.setString(1, Inid);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public PkgLabelCheck selectByWaferNew(String reelId) throws SQLException {
    PkgLabelCheck result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE reel_id = ?")) {
      ps.setString(1, reelId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<PkgLabelCheck> selectByWafer(String wafer) throws SQLException {
    ArrayList<PkgLabelCheck> result = new ArrayList<PkgLabelCheck>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE label_temp_info like ?")) {
      ps.setString(1, "%" + wafer + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgLabelCheck> selectBySfc(String sfcName) throws SQLException {
    List<PkgLabelCheck> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where sfc_name =?")) {
      ps.setString(1, sfcName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    } catch (Exception ex) {
      ex.printStackTrace();
      return result;
    }
  }

  private PkgLabelCheck convert(ResultSet rs) throws SQLException {
    PkgLabelCheck data = new PkgLabelCheck();

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
