package ame.psb.db.dao;

import ame.psb.db.UserRfid;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class UserRfidDao {

  private static final String SQL_INS = "INSERT INTO zd_user_rfid(rf_id,user_id,value,content,updated_time) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_user_rfid SET user_id=?,value=?,content=?,updated_time=? WHERE rf_id=?";

  private static final String SQL_SEL = "SELECT rf_id,user_id,value,content,updated_time FROM zd_user_rfid ";

  private final Connection conn;

  public UserRfidDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(UserRfid data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getRfId());
      ps.setString(2, data.getUserId());
      ps.setString(3, data.getValue());
      ps.setString(4, data.getContent());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<UserRfid> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (UserRfid data : dataList) {
        ps.setString(1, data.getRfId());
        ps.setString(2, data.getUserId());
        ps.setString(3, data.getValue());
        ps.setString(4, data.getContent());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(UserRfid data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getUserId());
      ps.setString(2, data.getValue());
      ps.setString(3, data.getContent());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getRfId());

      return ps.executeUpdate();
    }
  }

  public int update(List<UserRfid> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (UserRfid data : dataList) {
        ps.setString(1, data.getUserId());
        ps.setString(2, data.getValue());
        ps.setString(3, data.getContent());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getRfId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String rfId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_user_rfid WHERE rf_id=?")) {
      ps.setString(1, rfId);

      return ps.executeUpdate();
    }
  }

  public List<UserRfid> selectAll() throws SQLException {
    ArrayList<UserRfid> result = new ArrayList<UserRfid>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public UserRfid selectByPK(String rfId) throws SQLException {
    UserRfid result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE rf_id=?")) {
      ps.setString(1, rfId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private UserRfid convert(ResultSet rs) throws SQLException {
    UserRfid data = new UserRfid();

    int index = 1;
    data.setRfId(rs.getString(index++));
    data.setUserId(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
