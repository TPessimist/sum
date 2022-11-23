package ame.hrs.db.dao;

import ame.psb.db.conf.MySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author cc
 * @Description 人事系统的dao层
 * @createTime 2022年05月07日 09:22:00
 */
public class HrmEmployeeDao {

  private static final String SQL_SEL = "select WXWORK_USERID from HRS.HRM_EMPLOYEE_INFO ";

  Connection conn = MySql.mySqlDB();

  public String selectWxWorkUserId(String wxWorkUserId, String userId) throws Exception {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE EMPLOYEE_NUMBER=? ")) {
      ps.setString(1, wxWorkUserId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        userId = rs.getString(1);
      }
    }
    return userId;
  }

}
