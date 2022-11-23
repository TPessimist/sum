package ame.me.db.dao;

import ame.me.db.UserCert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class UserCertDao {

  private static final String SQL_SEL = "SELECT handle,user_bo,certification_bo,expiration_date,certification_authority_bo,certification_date,warning_alarm_sent,expiration_alarm_sent,status_bo,extension_expiration_date,comments,extensions,extension_alarm_sent,created_date_time,modified_date_time,user_id,employee_number,hire_date,termination_date,certification,cert_desc,cert_status_bo FROM view_user_cert ";

  private static final String SQL_UPD = "update user_cert SET STATUS_BO = ? WHERE USER_BO = ? AND CERTIFICATION_BO = ?";

  private static final String SQL_INS = "INSERT INTO user_cert(handle,user_bo,certification_bo,expiration_date,certification_authority_bo,certification_date,warning_alarm_sent,expiration_alarm_sent,status_bo,extension_expiration_date,comments,extensions,extension_alarm_sent,created_date_time,modified_date_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD2 = "UPDATE user_cert SET user_bo=?,certification_bo=?,expiration_date=?,certification_authority_bo=?,certification_date=?,warning_alarm_sent=?,expiration_alarm_sent=?,status_bo=?,extension_expiration_date=?,comments=?,extensions=?,extension_alarm_sent=?,created_date_time=?,modified_date_time=? WHERE handle=?";


  private final Connection conn;

  public UserCertDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(UserCert data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getUserBo());
      ps.setString(3, data.getCertificationBo());
      DateUtils.setDateTz(ps, 4, data.getExpirationDate());
      ps.setString(5, data.getCertificationAuthorityBo());
      DateUtils.setDateTz(ps, 6, data.getCertificationDate());
      ps.setString(7, data.getWarningAlarmSent());
      ps.setString(8, data.getExpirationAlarmSent());
      ps.setString(9, data.getStatusBo());
      DateUtils.setDateTz(ps, 10, data.getExtensionExpirationDate());
      ps.setString(11, data.getComments());
      ps.setBigDecimal(12, data.getExtensions());
      ps.setString(13, data.getExtensionAlarmSent());
      DateUtils.setDateTz(ps, 14, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 15, data.getModifiedDateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<UserCert> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (UserCert data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getUserBo());
        ps.setString(3, data.getCertificationBo());
        DateUtils.setDateTz(ps, 4, data.getExpirationDate());
        ps.setString(5, data.getCertificationAuthorityBo());
        DateUtils.setDateTz(ps, 6, data.getCertificationDate());
        ps.setString(7, data.getWarningAlarmSent());
        ps.setString(8, data.getExpirationAlarmSent());
        ps.setString(9, data.getStatusBo());
        DateUtils.setDateTz(ps, 10, data.getExtensionExpirationDate());
        ps.setString(11, data.getComments());
        ps.setBigDecimal(12, data.getExtensions());
        ps.setString(13, data.getExtensionAlarmSent());
        DateUtils.setDateTz(ps, 14, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 15, data.getModifiedDateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(UserCert data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD2)) {
      ps.setString(1, data.getUserBo());
      ps.setString(2, data.getCertificationBo());
      DateUtils.setDateTz(ps, 3, data.getExpirationDate());
      ps.setString(4, data.getCertificationAuthorityBo());
      DateUtils.setDateTz(ps, 5, data.getCertificationDate());
      ps.setString(6, data.getWarningAlarmSent());
      ps.setString(7, data.getExpirationAlarmSent());
      ps.setString(8, data.getStatusBo());
      DateUtils.setDateTz(ps, 9, data.getExtensionExpirationDate());
      ps.setString(10, data.getComments());
      ps.setBigDecimal(11, data.getExtensions());
      ps.setString(12, data.getExtensionAlarmSent());
      DateUtils.setDateTz(ps, 13, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 14, data.getModifiedDateTime());
      ps.setString(15, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<UserCert> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD2)) {
      for (UserCert data : dataList) {
        ps.setString(1, data.getUserBo());
        ps.setString(2, data.getCertificationBo());
        DateUtils.setDateTz(ps, 3, data.getExpirationDate());
        ps.setString(4, data.getCertificationAuthorityBo());
        DateUtils.setDateTz(ps, 5, data.getCertificationDate());
        ps.setString(6, data.getWarningAlarmSent());
        ps.setString(7, data.getExpirationAlarmSent());
        ps.setString(8, data.getStatusBo());
        DateUtils.setDateTz(ps, 9, data.getExtensionExpirationDate());
        ps.setString(10, data.getComments());
        ps.setBigDecimal(11, data.getExtensions());
        ps.setString(12, data.getExtensionAlarmSent());
        DateUtils.setDateTz(ps, 13, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 14, data.getModifiedDateTime());
        ps.setString(15, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM user_cert WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public int deleteByUser(String user) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM user_cert WHERE user_bo=?")) {
      ps.setString(1, user);
      return ps.executeUpdate();
    }
  }

  public UserCert selectByPkg(String handle) throws SQLException {
    UserCert result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=? ")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<UserCert> selectByUser(String userBo) throws SQLException {
    ArrayList<UserCert> result = new ArrayList<UserCert>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE user_bo=? ORDER BY certification_bo")) {
      ps.setString(1, userBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public int update(String statusBo, String userBo, String certificationBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, statusBo);
      ps.setString(2, userBo);
      ps.setString(3, certificationBo);
      return ps.executeUpdate();
    }
  }

  public UserCert selectByUserAndCert(String userBo, String certificationBo) throws SQLException {
    UserCert result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE user_bo=? AND certification_bo=? AND status_bo = 'StatusBO:1020,801' ORDER BY MODIFIED_DATE_TIME DESC ")) {
      ps.setString(1, userBo);
      ps.setString(2, certificationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private UserCert convert(ResultSet rs) throws SQLException {
    UserCert data = new UserCert();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setUserBo(rs.getString(index++));
    data.setCertificationBo(rs.getString(index++));
    data.setExpirationDate(DateUtils.getDateTz(rs, index++));
    data.setCertificationAuthorityBo(rs.getString(index++));
    data.setCertificationDate(DateUtils.getDateTz(rs, index++));
    data.setWarningAlarmSent(rs.getString(index++));
    data.setExpirationAlarmSent(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setExtensionExpirationDate(DateUtils.getDateTz(rs, index++));
    data.setComments(rs.getString(index++));
    data.setExtensions(rs.getBigDecimal(index++));
    data.setExtensionAlarmSent(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setUserId(rs.getString(index++));
    data.setEmployeeNumber(rs.getString(index++));
    data.setHireDate(rs.getString(index++));
    data.setTerminationDate(rs.getString(index++));
    data.setCertification(rs.getString(index++));
    data.setCertDesc(rs.getString(index++));
    data.setCertStatusBo(rs.getString(index++));

    return data;
  }
}
