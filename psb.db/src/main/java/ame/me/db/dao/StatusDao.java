package ame.me.db.dao;

import ame.me.db.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StatusDao {

  private static final String SQL_INS = "INSERT INTO status(handle,change_stamp,site,status,status_group,status_description,default_status,created_date_time,modified_date_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE status SET change_stamp=?,site=?,status=?,status_group=?,status_description=?,default_status=?,created_date_time=?,modified_date_time=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,change_stamp,site,status,status_group,status_description,default_status,created_date_time,modified_date_time FROM status ";

  private final Connection conn;

  public StatusDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Status data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setBigDecimal(2, data.getChangeStamp());
      ps.setString(3, data.getSite());
      ps.setString(4, data.getStatus());
      ps.setString(5, data.getStatusGroup());
      ps.setString(6, data.getStatusDescription());
      ps.setString(7, data.getDefaultStatus());
      ps.setTimestamp(8, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setTimestamp(9, new Timestamp(data.getModifiedDateTime().getTime()));

      return ps.executeUpdate();
    }
  }

  public int insert(List<Status> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Status data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setBigDecimal(2, data.getChangeStamp());
        ps.setString(3, data.getSite());
        ps.setString(4, data.getStatus());
        ps.setString(5, data.getStatusGroup());
        ps.setString(6, data.getStatusDescription());
        ps.setString(7, data.getDefaultStatus());
        ps.setTimestamp(8, new Timestamp(data.getCreatedDateTime().getTime()));
        ps.setTimestamp(9, new Timestamp(data.getModifiedDateTime().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Status data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getChangeStamp());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getStatus());
      ps.setString(4, data.getStatusGroup());
      ps.setString(5, data.getStatusDescription());
      ps.setString(6, data.getDefaultStatus());
      ps.setTimestamp(7, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setTimestamp(8, new Timestamp(data.getModifiedDateTime().getTime()));
      ps.setString(9, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<Status> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Status data : dataList) {
        ps.setBigDecimal(1, data.getChangeStamp());
        ps.setString(2, data.getSite());
        ps.setString(3, data.getStatus());
        ps.setString(4, data.getStatusGroup());
        ps.setString(5, data.getStatusDescription());
        ps.setString(6, data.getDefaultStatus());
        ps.setTimestamp(7, new Timestamp(data.getCreatedDateTime().getTime()));
        ps.setTimestamp(8, new Timestamp(data.getModifiedDateTime().getTime()));
        ps.setString(9, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM status WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<Status> selectAll() throws SQLException {
    ArrayList<Status> result = new ArrayList<Status>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Status selectByPK(String handle) throws SQLException {
    Status result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private Status convert(ResultSet rs) throws SQLException {
    Status data = new Status();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setChangeStamp(rs.getBigDecimal(index++));
    data.setSite(rs.getString(index++));
    data.setStatus(rs.getString(index++));
    data.setStatusGroup(rs.getString(index++));
    data.setStatusDescription(rs.getString(index++));
    data.setDefaultStatus(rs.getString(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));
    data.setModifiedDateTime(rs.getTimestamp(index++));

    return data;
  }
}