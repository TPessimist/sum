package ame.psb.db.dao;

import ame.psb.db.BladeChange;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class BladeChangeDao {

  private static final String SQL_INS = "INSERT INTO zr_blade_change(uuid,resource_id,zone,system_zone,actual_zone,zone_flag,ztwo,system_ztwo,actual_ztwo,ztwo_flag,old_zone,old_zone_flag,old_ztwo,old_ztwo_flag,id_flag,content1,content2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_blade_change SET resource_id=?,zone=?,system_zone=?,actual_zone=?,zone_flag=?,ztwo=?,system_ztwo=?,actual_ztwo=?,ztwo_flag=?,old_zone=?,old_zone_flag=?,old_ztwo=?,old_ztwo_flag=?,id_flag=?,content1=?,content2=?,updated_user=?,updated_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,resource_id,zone,system_zone,actual_zone,zone_flag,ztwo,system_ztwo,actual_ztwo,ztwo_flag,old_zone,old_zone_flag,old_ztwo,old_ztwo_flag,id_flag,content1,content2,updated_user,updated_time FROM zr_blade_change ";

  private final Connection conn;

  public BladeChangeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BladeChange data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getResourceId());
      ps.setString(3, data.getZone());
      ps.setBigDecimal(4, data.getSystemZone());
      ps.setBigDecimal(5, data.getActualZone());
      ps.setString(6, data.getZoneFlag());
      ps.setString(7, data.getZtwo());
      ps.setBigDecimal(8, data.getSystemZtwo());
      ps.setBigDecimal(9, data.getActualZtwo());
      ps.setString(10, data.getZtwoFlag());
      ps.setString(11, data.getOldZone());
      ps.setString(12, data.getOldZoneFlag());
      ps.setString(13, data.getOldZtwo());
      ps.setString(14, data.getOldZtwoFlag());
      ps.setString(15, data.getIdFlag());
      ps.setString(16, data.getContent1());
      ps.setString(17, data.getContent2());
      ps.setString(18, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 19, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BladeChange> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BladeChange data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getResourceId());
        ps.setString(3, data.getZone());
        ps.setBigDecimal(4, data.getSystemZone());
        ps.setBigDecimal(5, data.getActualZone());
        ps.setString(6, data.getZoneFlag());
        ps.setString(7, data.getZtwo());
        ps.setBigDecimal(8, data.getSystemZtwo());
        ps.setBigDecimal(9, data.getActualZtwo());
        ps.setString(10, data.getZtwoFlag());
        ps.setString(11, data.getOldZone());
        ps.setString(12, data.getOldZoneFlag());
        ps.setString(13, data.getOldZtwo());
        ps.setString(14, data.getOldZtwoFlag());
        ps.setString(15, data.getIdFlag());
        ps.setString(16, data.getContent1());
        ps.setString(17, data.getContent2());
        ps.setString(18, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 19, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BladeChange data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceId());
      ps.setString(2, data.getZone());
      ps.setBigDecimal(3, data.getSystemZone());
      ps.setBigDecimal(4, data.getActualZone());
      ps.setString(5, data.getZoneFlag());
      ps.setString(6, data.getZtwo());
      ps.setBigDecimal(7, data.getSystemZtwo());
      ps.setBigDecimal(8, data.getActualZtwo());
      ps.setString(9, data.getZtwoFlag());
      ps.setString(10, data.getOldZone());
      ps.setString(11, data.getOldZoneFlag());
      ps.setString(12, data.getOldZtwo());
      ps.setString(13, data.getOldZtwoFlag());
      ps.setString(14, data.getIdFlag());
      ps.setString(15, data.getContent1());
      ps.setString(16, data.getContent2());
      ps.setString(17, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 18, data.getUpdatedTime());
      ps.setString(19, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<BladeChange> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BladeChange data : dataList) {
        ps.setString(1, data.getResourceId());
        ps.setString(2, data.getZone());
        ps.setBigDecimal(3, data.getSystemZone());
        ps.setBigDecimal(4, data.getActualZone());
        ps.setString(5, data.getZoneFlag());
        ps.setString(6, data.getZtwo());
        ps.setBigDecimal(7, data.getSystemZtwo());
        ps.setBigDecimal(8, data.getActualZtwo());
        ps.setString(9, data.getZtwoFlag());
        ps.setString(10, data.getOldZone());
        ps.setString(11, data.getOldZoneFlag());
        ps.setString(12, data.getOldZtwo());
        ps.setString(13, data.getOldZtwoFlag());
        ps.setString(14, data.getIdFlag());
        ps.setString(15, data.getContent1());
        ps.setString(16, data.getContent2());
        ps.setString(17, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 18, data.getUpdatedTime());
        ps.setString(19, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_blade_change WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<BladeChange> selectAll() throws SQLException {
    ArrayList<BladeChange> result = new ArrayList<BladeChange>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<BladeChange> selectByResource(String resource) throws SQLException {
    ArrayList<BladeChange> result = new ArrayList<BladeChange>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE resource_id=? and (id_flag is null or id_flag ='FAIL') order by updated_time desc ")) {
      ps.setString(1, resource);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public BladeChange selectByPK(String uuid) throws SQLException {
    BladeChange result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public BladeChange selectByResourceTop(String resource, String content1) throws SQLException {
    BladeChange result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE resource_id=? AND content1 =? order by updated_time desc")) {
      ps.setString(1, resource);
      ps.setString(2, content1);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public BladeChange selectByResourceTopSucess(String resource, String content1)
      throws SQLException {
    BladeChange result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE resource_id=? AND content1 =? AND id_flag = 'SUCESS'order by updated_time desc")) {
      ps.setString(1, resource);
      ps.setString(2, content1);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  private BladeChange convert(ResultSet rs) throws SQLException {
    BladeChange data = new BladeChange();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setResourceId(rs.getString(index++));
    data.setZone(rs.getString(index++));
    data.setSystemZone(rs.getBigDecimal(index++));
    data.setActualZone(rs.getBigDecimal(index++));
    data.setZoneFlag(rs.getString(index++));
    data.setZtwo(rs.getString(index++));
    data.setSystemZtwo(rs.getBigDecimal(index++));
    data.setActualZtwo(rs.getBigDecimal(index++));
    data.setZtwoFlag(rs.getString(index++));
    data.setOldZone(rs.getString(index++));
    data.setOldZoneFlag(rs.getString(index++));
    data.setOldZtwo(rs.getString(index++));
    data.setOldZtwoFlag(rs.getString(index++));
    data.setIdFlag(rs.getString(index++));
    data.setContent1(rs.getString(index++));
    data.setContent2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
