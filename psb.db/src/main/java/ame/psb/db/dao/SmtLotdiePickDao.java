package ame.psb.db.dao;

import ame.psb.db.SmtLotdiePick;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SmtLotdiePickDao {

  private static final String SQL_INS = "INSERT INTO zr_smt_lotdie_pick(sfc,lot,device,lot_type,content,value,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_smt_lotdie_pick SET lot=?,device=?,lot_type=?,content=?,value=?,updated_user=?,updated_time=? WHERE sfc=?";

  private static final String SQL_SEL = "SELECT sfc,lot,device,lot_type,content,value,updated_user,updated_time FROM zr_smt_lotdie_pick ";

  private final Connection conn;

  public SmtLotdiePickDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SmtLotdiePick data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfc());
      ps.setString(2, data.getLot());
      ps.setString(3, data.getDevice());
      ps.setString(4, data.getLotType());
      ps.setString(5, data.getContent());
      ps.setString(6, data.getValue());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SmtLotdiePick> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SmtLotdiePick data : dataList) {
        ps.setString(1, data.getSfc());
        ps.setString(2, data.getLot());
        ps.setString(3, data.getDevice());
        ps.setString(4, data.getLotType());
        ps.setString(5, data.getContent());
        ps.setString(6, data.getValue());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SmtLotdiePick data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getLot());
      ps.setString(2, data.getDevice());
      ps.setString(3, data.getLotType());
      ps.setString(4, data.getContent());
      ps.setString(5, data.getValue());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getSfc());

      return ps.executeUpdate();
    }
  }

  public int update(List<SmtLotdiePick> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SmtLotdiePick data : dataList) {
        ps.setString(1, data.getLot());
        ps.setString(2, data.getDevice());
        ps.setString(3, data.getLotType());
        ps.setString(4, data.getContent());
        ps.setString(5, data.getValue());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getSfc());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String sfc) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_smt_lotdie_pick WHERE sfc=?")) {
      ps.setString(1, sfc);

      return ps.executeUpdate();
    }
  }

  public List<SmtLotdiePick> selectAll() throws SQLException {
    ArrayList<SmtLotdiePick> result = new ArrayList<SmtLotdiePick>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SmtLotdiePick> selectByDevice(String device) throws SQLException {
    ArrayList<SmtLotdiePick> result = new ArrayList<SmtLotdiePick>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE device=?")) {
      ps.setString(1, device);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SmtLotdiePick> selectByDeviceAndTime(String lot, String date) throws SQLException {
    ArrayList<SmtLotdiePick> result = new ArrayList<SmtLotdiePick>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE device=? AND YEAR (ADD_SECONDS (TO_TIMESTAMP (MAX (updated_time)), 3600*8)) = YEAR(?) AND MONTH (ADD_SECONDS (TO_TIMESTAMP (MAX (updated_time)), 3600*8)) = MONTH (?) ")) {
      ps.setString(1, lot);
      ps.setString(2, date);
      ps.setString(3, date);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SmtLotdiePick> selectByLot(String lot) throws SQLException {
    ArrayList<SmtLotdiePick> result = new ArrayList<SmtLotdiePick>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE lot=?")) {
      ps.setString(1, lot);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public SmtLotdiePick selectByPK(String sfc) throws SQLException {
    SmtLotdiePick result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc=?")) {
      ps.setString(1, sfc);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<SmtLotdiePick> selectByLotAndTime(String lot, String beginDate, String endDate)
      throws SQLException {
    ArrayList<SmtLotdiePick> result = new ArrayList<SmtLotdiePick>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE lot =? AND updated_time >= ? AND updated_time <= ? ")) {
      ps.setString(1, lot);
      ps.setString(2, beginDate);
      ps.setString(3, endDate);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private SmtLotdiePick convert(ResultSet rs) throws SQLException {
    SmtLotdiePick data = new SmtLotdiePick();

    int index = 1;
    data.setSfc(rs.getString(index++));
    data.setLot(rs.getString(index++));
    data.setDevice(rs.getString(index++));
    data.setLotType(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
