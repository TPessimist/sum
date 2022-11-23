package ame.sap.db.dao;

import ame.sap.db.Picture68PlatGroup;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class Picture68PlatGroupDao {

  private static final String SQL_INS = "INSERT INTO zr_68_picture_plat_group(group_id,group_seq,device_name,state_name,root_sfc,sfc_bo,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_68_picture_plat_group SET device_name=?,state_name=?,root_sfc=?,sfc_bo=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE group_id=? AND group_seq=?";

  private static final String SQL_SEL = "SELECT group_id,group_seq,device_name,state_name,root_sfc,sfc_bo,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_68_picture_plat_group ";

  private final Connection conn;

  public Picture68PlatGroupDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Picture68PlatGroup data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getGroupId());
      ps.setBigDecimal(2, data.getGroupSeq());
      ps.setString(3, data.getDeviceName());
      ps.setString(4, data.getStateName());
      ps.setString(5, data.getRootSfc());
      ps.setString(6, data.getSfcBo());
      ps.setString(7, data.getReversedField1());
      ps.setString(8, data.getReversedField2());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Picture68PlatGroup> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Picture68PlatGroup data : dataList) {
        ps.setString(1, data.getGroupId());
        ps.setBigDecimal(2, data.getGroupSeq());
        ps.setString(3, data.getDeviceName());
        ps.setString(4, data.getStateName());
        ps.setString(5, data.getRootSfc());
        ps.setString(6, data.getSfcBo());
        ps.setString(7, data.getReversedField1());
        ps.setString(8, data.getReversedField2());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Picture68PlatGroup data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDeviceName());
      ps.setString(2, data.getStateName());
      ps.setString(3, data.getRootSfc());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getGroupId());
      ps.setBigDecimal(10, data.getGroupSeq());

      return ps.executeUpdate();
    }
  }

  public int update(List<Picture68PlatGroup> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Picture68PlatGroup data : dataList) {
        ps.setString(1, data.getDeviceName());
        ps.setString(2, data.getStateName());
        ps.setString(3, data.getRootSfc());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getGroupId());
        ps.setBigDecimal(10, data.getGroupSeq());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String groupId, BigDecimal groupSeq) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_68_picture_plat_group WHERE group_id=? AND group_seq=?")) {
      ps.setString(1, groupId);
      ps.setBigDecimal(2, groupSeq);

      return ps.executeUpdate();
    }
  }

  public List<Picture68PlatGroup> selectAll() throws SQLException {
    ArrayList<Picture68PlatGroup> result = new ArrayList<Picture68PlatGroup>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Picture68PlatGroup selectByPK(String groupId, BigDecimal groupSeq) throws SQLException {
    Picture68PlatGroup result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE group_id=? AND group_seq=?")) {
      ps.setString(1, groupId);
      ps.setBigDecimal(2, groupSeq);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public List<Picture68PlatGroup> selectByTopGroup(String deviceName) throws SQLException {
    ArrayList<Picture68PlatGroup> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "  where state_name = 'WAIT' and device_name = ? ")) {
      ps.setString(1, deviceName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Picture68PlatGroup> selectByGroupId(String groupId) throws SQLException {
    ArrayList<Picture68PlatGroup> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "  where group_id = ? order by GROUP_ID, GROUP_SEQ ")) {
      ps.setString(1, groupId);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Picture68PlatGroup selectByRootSfc(String rootSfcName) throws SQLException {
    Picture68PlatGroup result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE root_sfc = ? ")) {
      ps.setString(1, rootSfcName);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private Picture68PlatGroup convert(ResultSet rs) throws SQLException {
    Picture68PlatGroup data = new Picture68PlatGroup();

    int index = 1;
    data.setGroupId(rs.getString(index++));
    data.setGroupSeq(rs.getBigDecimal(index++));
    data.setDeviceName(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setRootSfc(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
