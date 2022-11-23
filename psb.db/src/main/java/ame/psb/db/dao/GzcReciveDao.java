package ame.psb.db.dao;

import ame.psb.db.GzcRecive;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class GzcReciveDao {

  private static final String SQL_INS = "INSERT INTO zr_gzc_recive(inventory_id,type,flag,charg,rsnum,content,value,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_gzc_recive SET flag=?,charg=?,rsnum=?,content=?,value=?,update_user=?,update_time=? WHERE inventory_id=? AND type=?";

  private static final String SQL_SEL = "SELECT inventory_id,type,flag,charg,rsnum,content,value,update_user,update_time FROM zr_gzc_recive ";

  private final Connection conn;

  public GzcReciveDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(GzcRecive data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getInventoryId());
      ps.setString(2, data.getType());
      ps.setString(3, data.getFlag());
      ps.setString(4, data.getCharg());
      ps.setString(5, data.getRsnum());
      ps.setString(6, data.getContent());
      ps.setString(7, data.getValue());
      ps.setString(8, data.getUpdateUser());
      DateUtils.setDateTz(ps, 9, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<GzcRecive> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (GzcRecive data : dataList) {
        ps.setString(1, data.getInventoryId());
        ps.setString(2, data.getType());
        ps.setString(3, data.getFlag());
        ps.setString(4, data.getCharg());
        ps.setString(5, data.getRsnum());
        ps.setString(6, data.getContent());
        ps.setString(7, data.getValue());
        ps.setString(8, data.getUpdateUser());
        DateUtils.setDateTz(ps, 9, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(GzcRecive data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFlag());
      ps.setString(2, data.getCharg());
      ps.setString(3, data.getRsnum());
      ps.setString(4, data.getContent());
      ps.setString(5, data.getValue());
      ps.setString(6, data.getUpdateUser());
      DateUtils.setDateTz(ps, 7, data.getUpdateTime());
      ps.setString(8, data.getInventoryId());
      ps.setString(9, data.getType());

      return ps.executeUpdate();
    }
  }

  public int update(List<GzcRecive> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (GzcRecive data : dataList) {
        ps.setString(1, data.getFlag());
        ps.setString(2, data.getCharg());
        ps.setString(3, data.getRsnum());
        ps.setString(4, data.getContent());
        ps.setString(5, data.getValue());
        ps.setString(6, data.getUpdateUser());
        DateUtils.setDateTz(ps, 7, data.getUpdateTime());
        ps.setString(8, data.getInventoryId());
        ps.setString(9, data.getType());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String inventoryId, String type) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_gzc_recive WHERE inventory_id=? AND type=?")) {
      ps.setString(1, inventoryId);
      ps.setString(2, type);

      return ps.executeUpdate();
    }
  }

  public List<GzcRecive> selectAll() throws SQLException {
    ArrayList<GzcRecive> result = new ArrayList<GzcRecive>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<GzcRecive> selectOutWaitCreate() throws SQLException {
    ArrayList<GzcRecive> result = new ArrayList<GzcRecive>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT TOP 50  * FROM ZR_GZC_RECIVE WHERE flag= '0' AND (type='CONTROL_OUT' OR type='CONTROL') ORDER BY update_time")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<GzcRecive> selectOutWaitCreate2() throws SQLException {
    ArrayList<GzcRecive> result = new ArrayList<GzcRecive>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT TOP 50  * FROM ZR_GZC_RECIVE WHERE flag= '0' AND type='CONTROL' ORDER BY update_time")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public GzcRecive selectByPK(String inventoryId, String type) throws SQLException {
    GzcRecive result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE inventory_id=? AND type=?")) {
      ps.setString(1, inventoryId);
      ps.setString(2, type);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private GzcRecive convert(ResultSet rs) throws SQLException {
    GzcRecive data = new GzcRecive();

    int index = 1;
    data.setInventoryId(rs.getString(index++));
    data.setType(rs.getString(index++));
    data.setFlag(rs.getString(index++));
    data.setCharg(rs.getString(index++));
    data.setRsnum(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
