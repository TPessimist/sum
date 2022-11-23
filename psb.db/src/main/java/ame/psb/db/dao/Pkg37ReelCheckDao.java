package ame.psb.db.dao;

import ame.psb.db.Pkg37ReelCheck;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class Pkg37ReelCheckDao {

  private static final String SQL_INS = "INSERT INTO zr_pkg_37_reel_check(uuid,reel_id,container_bo,state_name,description,sfc_bo,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_pkg_37_reel_check SET reel_id=?,container_bo=?,state_name=?,description=?,sfc_bo=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,reel_id,container_bo,state_name,description,sfc_bo,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_pkg_37_reel_check ";

  private final Connection conn;

  public Pkg37ReelCheckDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Pkg37ReelCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getReelId());
      ps.setString(3, data.getContainerBo());
      ps.setString(4, data.getStateName());
      ps.setString(5, data.getDescription());
      ps.setString(6, data.getSfcBo());
      ps.setString(7, data.getReversedField1());
      ps.setString(8, data.getReversedField2());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Pkg37ReelCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Pkg37ReelCheck data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getReelId());
        ps.setString(3, data.getContainerBo());
        ps.setString(4, data.getStateName());
        ps.setString(5, data.getDescription());
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

  public int update(Pkg37ReelCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getReelId());
      ps.setString(2, data.getContainerBo());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getDescription());
      ps.setString(5, data.getSfcBo());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<Pkg37ReelCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Pkg37ReelCheck data : dataList) {
        ps.setString(1, data.getReelId());
        ps.setString(2, data.getContainerBo());
        ps.setString(3, data.getStateName());
        ps.setString(4, data.getDescription());
        ps.setString(5, data.getSfcBo());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_37_reel_check WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<Pkg37ReelCheck> selectAll() throws SQLException {
    ArrayList<Pkg37ReelCheck> result = new ArrayList<Pkg37ReelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Pkg37ReelCheck selectByPK(String uuid) throws SQLException {
    Pkg37ReelCheck result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public Pkg37ReelCheck selectByReelId(String reelId) throws SQLException { //按照唯一码查询比对记录
    Pkg37ReelCheck result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE reel_id=? and container_bo is not null ")) {
      ps.setString(1, reelId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public Pkg37ReelCheck selectByContainerBo(String containerBo) throws SQLException {//按照容器查询比对记录
    Pkg37ReelCheck result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE container_bo=? ")) {
      ps.setString(1, containerBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private Pkg37ReelCheck convert(ResultSet rs) throws SQLException {
    Pkg37ReelCheck data = new Pkg37ReelCheck();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setReelId(rs.getString(index++));
    data.setContainerBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
