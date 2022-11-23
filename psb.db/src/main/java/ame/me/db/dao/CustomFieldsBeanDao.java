package ame.me.db.dao;

import ame.me.db.CustomFieldsBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CustomFieldsBeanDao {

  private static String SQL_INS = "insert into CUSTOM_FIELDS(HANDLE,ATTRIBUTE,VALUE,CREATED_DATE_TIME,MODIFIED_DATE_TIME) values (?,?,?,?,?)";

  private static String SQL_SEL = "select HANDLE,ATTRIBUTE,VALUE,CREATED_DATE_TIME,MODIFIED_DATE_TIME from CUSTOM_FIELDS";

  private static String SQL_UPE = "UPDATE CUSTOM_FIELDS SET VALUE= ? , CREATED_DATE_TIME=?, MODIFIED_DATE_TIME= ?";

  private Connection conn;

  public CustomFieldsBeanDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CustomFieldsBean cfs) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, cfs.getHandle());
      ps.setString(2, cfs.getAttribute());
      ps.setString(3, cfs.getValue());
      DateUtils.setDateTz(ps, 4, cfs.getCreatedDateTime());
      DateUtils.setDateTz(ps, 5, cfs.getUpdatedDateTime());
      return ps.executeUpdate();
    }
  }

  public int update(CustomFieldsBean cfs) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_UPE + " WHERE HANDLE= ? AND ATTRIBUTE = ? ")) {
      ps.setString(1, cfs.getValue());
      DateUtils.setDateTz(ps, 2, cfs.getCreatedDateTime());
      DateUtils.setDateTz(ps, 3, cfs.getUpdatedDateTime());
      ps.setString(4, cfs.getHandle());
      ps.setString(5, cfs.getAttribute());
      return ps.executeUpdate();
    }
  }

  public List<CustomFieldsBean> selectBeanByAttribute(String attribute, String value)
      throws SQLException {
    CustomFieldsBean f = null;
    ArrayList<CustomFieldsBean> customFieldsBeans = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE ATTRIBUTE=? and VALUE =?")) {
      ps.setString(1, attribute);
      ps.setString(2, value);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        f = convert(rs);
        customFieldsBeans.add(f);
      }
    }
    return customFieldsBeans;
  }


  public CustomFieldsBean select(String handle, String attribute) throws SQLException {
    CustomFieldsBean f = null;

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE HANDLE=? AND ATTRIBUTE=?")) {
      ps.setString(1, handle);
      ps.setString(2, attribute);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        f = convert(rs);
      }
    }

    return f;

  }


  private CustomFieldsBean convert(ResultSet rs) throws SQLException {
    CustomFieldsBean f = new CustomFieldsBean();
    f.setHandle(rs.getString(1));
    f.setAttribute(rs.getString(2));
    f.setValue(rs.getString(3));
    f.setCreatedDateTime(DateUtils.getDateTz(rs, 4));
    f.setUpdatedDateTime(DateUtils.getDateTz(rs, 5));
    return f;
  }

}
