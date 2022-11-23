package ame.me.db.dao;

import ame.me.db.CertReqUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CertReqUserDao {

  private static final String SQL_SEL = "SELECT handle,certification_bo,user_group_bo,certified_object_gbo,created_date_time,modified_date_time,user_bo,user_id,employee_number FROM view_cert_req_user ";

  private final Connection conn;

  public CertReqUserDao(Connection conn) {
    this.conn = conn;
  }

  public List<CertReqUser> selectAll() throws SQLException {
    ArrayList<CertReqUser> result = new ArrayList<CertReqUser>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<CertReqUser> selectCertified(String gbo, String userBo) throws SQLException {
    ArrayList<CertReqUser> result = new ArrayList<CertReqUser>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE certified_object_gbo=? AND user_bo=? ORDER BY certification_bo")) {
      ps.setString(1, gbo);
      ps.setString(2, userBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<CertReqUser> selectResCertified(String gbo) throws SQLException {
    ArrayList<CertReqUser> result = new ArrayList<CertReqUser>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE certified_object_gbo=? ORDER BY certification_bo")) {
      ps.setString(1, gbo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private CertReqUser convert(ResultSet rs) throws SQLException {
    CertReqUser data = new CertReqUser();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setCertificationBo(rs.getString(index++));
    data.setUserGroupBo(rs.getString(index++));
    data.setCertifiedObjectGbo(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setUserBo(rs.getString(index++));
    data.setUserId(rs.getString(index++));
    data.setEmployeeNumber(rs.getString(index++));

    return data;
  }
}
