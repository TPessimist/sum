package ame.psb.db.dao;

import ame.psb.db.FcResrceSlotPlating;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FcResrceSlotPlatingDao {

  private static final String SQL_INS = "INSERT INTO fc_resrce_slot_plating(resource_no,slot_no,slot_name,plating_name,updated_user,updated_time,bath_acid_flag,bath_tin_flag) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE fc_resrce_slot_plating SET slot_name=?,updated_user=?,updated_time=?,bath_acid_flag=?,bath_tin_flag=? WHERE resource_no=? AND slot_no=? AND plating_name=?";

  private static final String SQL_SEL = "SELECT resource_no,slot_no,slot_name,plating_name,updated_user,updated_time,bath_acid_flag,bath_tin_flag FROM fc_resrce_slot_plating ";

  private final Connection conn;

  public FcResrceSlotPlatingDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FcResrceSlotPlating data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResourceNo());
      ps.setString(2, data.getSlotNo());
      ps.setString(3, data.getSlotName());
      ps.setString(4, data.getPlatingName());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setBoolean(7, data.isBathAcidFlag());
      ps.setBoolean(8, data.isBathTinFlag());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FcResrceSlotPlating> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FcResrceSlotPlating data : dataList) {
        ps.setString(1, data.getResourceNo());
        ps.setString(2, data.getSlotNo());
        ps.setString(3, data.getSlotName());
        ps.setString(4, data.getPlatingName());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setBoolean(7, data.isBathAcidFlag());
        ps.setBoolean(8, data.isBathTinFlag());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FcResrceSlotPlating data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSlotName());
      ps.setString(2, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
      ps.setBoolean(4, data.isBathAcidFlag());
      ps.setBoolean(5, data.isBathTinFlag());

      ps.setString(6, data.getResourceNo());
      ps.setString(7, data.getSlotNo());
      ps.setString(8, data.getPlatingName());

      return ps.executeUpdate();
    }
  }

  public int update(List<FcResrceSlotPlating> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FcResrceSlotPlating data : dataList) {
        ps.setString(1, data.getSlotName());
        ps.setString(2, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
        ps.setBoolean(4, data.isBathAcidFlag());
        ps.setBoolean(5, data.isBathTinFlag());

        ps.setString(6, data.getResourceNo());
        ps.setString(7, data.getSlotNo());
        ps.setString(8, data.getPlatingName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resourceNo, String slotNo, String platingName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM fc_resrce_slot_plating WHERE resource_no=? AND slot_no=? AND plating_name=?")) {
      ps.setString(1, resourceNo);
      ps.setString(2, slotNo);
      ps.setString(3, platingName);

      return ps.executeUpdate();
    }
  }

  public int delete(String resourceNo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM fc_resrce_slot_plating WHERE resource_no=?")) {
      ps.setString(1, resourceNo);

      return ps.executeUpdate();
    }
  }

  public List<FcResrceSlotPlating> selectAll() throws SQLException {
    ArrayList<FcResrceSlotPlating> result = new ArrayList<FcResrceSlotPlating>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FcResrceSlotPlating selectByPK(String resourceNo, String slotNo, String platingName)
      throws SQLException {
    FcResrceSlotPlating result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_no=? AND slot_no=? AND plating_name=?")) {
      ps.setString(1, resourceNo);
      ps.setString(2, slotNo);
      ps.setString(3, platingName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FcResrceSlotPlating selectByPK2(String resourceNo, String slotName, String platingName)
      throws SQLException {
    FcResrceSlotPlating result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_no=? AND slot_name=? AND plating_name=?")) {
      ps.setString(1, resourceNo);
      ps.setString(2, slotName);
      ps.setString(3, platingName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FcResrceSlotPlating selectBySlot(String slotNo) throws SQLException {
    FcResrceSlotPlating result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE slot_no=?")) {
      ps.setString(1, slotNo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FcResrceSlotPlating selectByAcid(String resourceNo, String slotNo) throws SQLException {
    FcResrceSlotPlating result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_no=? AND slot_no=? AND bath_acid_flag=TRUE")) {
      ps.setString(1, resourceNo);
      ps.setString(2, slotNo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FcResrceSlotPlating selectByTin(String resourceNo) throws SQLException {
    FcResrceSlotPlating result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_no=? AND bath_tin_flag=TRUE")) {
      ps.setString(1, resourceNo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<FcResrceSlotPlating> selectByResrce(String resource) throws SQLException {
    ArrayList<FcResrceSlotPlating> result = new ArrayList<FcResrceSlotPlating>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where resource_no = ?")) {
      ps.setString(1, resource);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FcResrceSlotPlating> selectByResrce() throws SQLException {
    ArrayList<FcResrceSlotPlating> result = new ArrayList<FcResrceSlotPlating>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FcResrceSlotPlating> selectBySlot(String resource, String slotNo)
      throws SQLException {
    ArrayList<FcResrceSlotPlating> result = new ArrayList<FcResrceSlotPlating>();
    System.out.println(resource + "<===>" + slotNo);
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where resource_no = ? and slot_no = ?")) {
      ps.setString(1, resource);
      ps.setString(2, slotNo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private FcResrceSlotPlating convert(ResultSet rs) throws SQLException {
    FcResrceSlotPlating data = new FcResrceSlotPlating();

    int index = 1;
    data.setResourceNo(rs.getString(index++));
    data.setSlotNo(rs.getString(index++));
    data.setSlotName(rs.getString(index++));
    data.setPlatingName(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setBathAcidFlag(rs.getBoolean(index++));
    data.setBathTinFlag(rs.getBoolean(index++));
    return data;
  }
}
