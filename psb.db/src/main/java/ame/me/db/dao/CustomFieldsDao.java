package ame.me.db.dao;

import ame.me.db.CustomFields;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import uia.utils.dao.DateUtils;

public class CustomFieldsDao {

  private static String SQL_INS = "insert into CUSTOM_FIELDS(HANDLE,ATTRIBUTE,VALUE,CREATED_DATE_TIME,MODIFIED_DATE_TIME) values (?,?,?,?,?)";

  private static String SQL_SEL = "select HANDLE,ATTRIBUTE,VALUE,CREATED_DATE_TIME,MODIFIED_DATE_TIME from CUSTOM_FIELDS";

  private static String SQL_UPE = "UPDATE CUSTOM_FIELDS SET VALUE= ? , CREATED_DATE_TIME=?, MODIFIED_DATE_TIME= ?";

  private Connection conn;

  public CustomFieldsDao(Connection conn) {
    this.conn = conn;
  }

  public void insertOrUpdate(CustomFields cfs) throws SQLException {
    CustomFields select = select(cfs.getHandle(), cfs.getAttribute());
    if (null == select) {
      insertTime(cfs, new Date(), new Date());
    } else {
      updateTime(cfs, new Date(), new Date());
    }
  }

  public int insertTime(CustomFields cfs, Date createdDateTime, Date updatedDateTime)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, cfs.getHandle());
      ps.setString(2, cfs.getAttribute());
      ps.setString(3, cfs.getValue());
      DateUtils.setDateTz(ps, 4, createdDateTime);
      DateUtils.setDateTz(ps, 5, updatedDateTime);
      return ps.executeUpdate();
    }
  }

  public int insert(CustomFields cfs) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, cfs.getHandle());
      ps.setString(2, cfs.getAttribute());
      ps.setString(3, cfs.getValue());
      ps.setNull(4, Types.TIMESTAMP);
      ps.setNull(5, Types.TIMESTAMP);
      return ps.executeUpdate();
    }
  }

  public int update(CustomFields cfs) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_UPE + " WHERE HANDLE= ? AND ATTRIBUTE = ? ")) {
      ps.setString(1, cfs.getValue());
      ps.setNull(2, Types.TIMESTAMP);
      ps.setNull(3, Types.TIMESTAMP);
      ps.setString(4, cfs.getHandle());
      ps.setString(5, cfs.getAttribute());
      return ps.executeUpdate();
    }
  }

  public int updateTime(CustomFields cfs, Date createdDateTime, Date updatedDateTime)
      throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_UPE + " WHERE HANDLE= ? AND ATTRIBUTE = ? ")) {
      ps.setString(1, cfs.getValue());
      DateUtils.setDateTz(ps, 2, createdDateTime);
      DateUtils.setDateTz(ps, 3, updatedDateTime);
      ps.setString(4, cfs.getHandle());
      ps.setString(5, cfs.getAttribute());
      return ps.executeUpdate();
    }
  }

  public Map<String, CustomFields> select(String handle) throws SQLException {
    TreeMap<String, CustomFields> fields = new TreeMap<String, CustomFields>();

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE HANDLE=? ")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        CustomFields f = convert(rs);
        fields.put(f.getAttribute(), f);
      }
    }

    return fields;
  }

  public List<CustomFields> selectAll(String handle) throws SQLException {
    List<CustomFields> resule = new ArrayList<>();

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE HANDLE=? ")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        resule.add(convert(rs));
      }
    }
    return resule;
  }


  public List<CustomFields> selectByA(String attribute) throws SQLException {
    List<CustomFields> resule = new ArrayList<>();

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE ATTRIBUTE=? ")) {
      ps.setString(1, attribute);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        resule.add(convert(rs));
      }
    }
    return resule;
  }

  public CustomFields selectRow(String handle, String attribute, String value) throws SQLException {
    CustomFields f = null;

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE HANDLE=? AND ATTRIBUTE=? and value = ?")) {
      ps.setString(1, handle);
      ps.setString(2, attribute);
      ps.setString(3, value);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        f = convert(rs);
      }
    }

    return f;

  }

  public CustomFields select(String handle, String attribute) throws SQLException {
    CustomFields f = null;

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


  public List<CustomFields> selectByAttributeAndValue(String attribute, String value)
      throws SQLException {
    List<CustomFields> f = new ArrayList<CustomFields>();

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE ATTRIBUTE=? AND Value=?")) {
      ps.setString(1, attribute);
      ps.setString(2, value);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        f.add(convert(rs));
      }
    }

    return f;

  }

  public List<CustomFields> selectFoupPosition() throws SQLException {
    List<CustomFields> f = new ArrayList<CustomFields>();

    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " WHERE ATTRIBUTE='TYPE' AND Value in('LP','OHB','DMLP','STOCKER')")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        f.add(convert(rs));
      }
    }

    return f;

  }

  public List<CustomFields> selectPrompt(String handle, String attribute) throws SQLException {
    List<CustomFields> f = new ArrayList<CustomFields>();

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE HANDLE=? AND ATTRIBUTE like ?")) {
      ps.setString(1, handle);
      ps.setString(2, attribute + "%");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        f.add(convert(rs));
      }
    }

    return f;

  }


  public Map<String, CustomFields> select(String bo, String attribute, String value)
      throws SQLException {
    TreeMap<String, CustomFields> fields = new TreeMap<String, CustomFields>();

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE HANDLE LIKE ? AND ATTRIBUTE=? AND VALUE=?")) {
      ps.setString(1, bo + ":%");
      ps.setString(2, attribute);
      ps.setString(3, value);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        CustomFields f = convert(rs);
        fields.put(f.getHandle(), f);
      }
    }

    return fields;
  }

  private CustomFields convert(ResultSet rs) throws SQLException {
    CustomFields f = new CustomFields();
    f.setHandle(rs.getString(1));
    f.setAttribute(rs.getString(2));
    f.setValue(rs.getString(3));
    return f;
  }

  public boolean checkPkgOperation(String operationBo) throws Exception {
    CustomFields operation_type = select(operationBo.replace(",#", ",A"), "OPERATION_TYPE");
    if (null == operation_type && null == operation_type.getValue()) {
      return false;
    }

    if (!"I".equals(operation_type.getValue()) &&
        !"B".equals(operation_type.getValue()) &&
        !"C".equals(operation_type.getValue())
    ) {
      return false;
    }
    return true;
  }

  public boolean checkPkgOrPkgPassOperation(String operationBo) throws Exception {
    CustomFields operation_type = select(operationBo.replace(",#", ",A"), "OPERATION_TYPE");
    if (null == operation_type && null == operation_type.getValue()) {
      return false;
    }

    if (!"I".equals(operation_type.getValue()) &&
        !"B".equals(operation_type.getValue()) &&
        !"C".equals(operation_type.getValue()) &&
        !"XT".equals(operation_type.getValue()) &&
        !"XB".equals(operation_type.getValue()) &&
        !"XC".equals(operation_type.getValue()) &&
        !"X".equals(operation_type.getValue())
    ) {
      return false;
    }
    return true;
  }

  public boolean checkIntegrationOperation(String operationBo) throws Exception {
    CustomFields operation_type = select(operationBo.replace(",#", ",A"), "OPERATION_TYPE");
    if (null == operation_type && null == operation_type.getValue()) {
      return false;
    }

    if (!"I".equals(operation_type.getValue())) {
      return false;
    }
    return true;
  }

  public String selectCustomerByDevice(String deviceBo) throws SQLException {
    String selSql = "select distinct value from custom_fields where handle = ? and attribute = 'CUSTOMER' ";
    String result = "";
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, deviceBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result = rs.getString("value");
      }
      return result;
    }
  }
}
