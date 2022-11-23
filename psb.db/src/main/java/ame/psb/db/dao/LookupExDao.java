package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.Lookup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LookupExDao {

  private static final String SQL_SEL1 = "SELECT id,subid,value,group_name FROM zd_lookup_ex ";
  private static final String SQL_UPD = "UPDATE zd_lookup_ex SET value=? WHERE id=? AND subid =?";
  private static final String SQL_UPD_GROUP = "UPDATE zd_lookup_ex SET value=? WHERE group_name=? AND subid =?";
  private static final String SQL_SEL = "SELECT distinct VS.SFC_NAME FROM ZD_LOOKUP_EX AS ZE INNER JOIN VIEW_SFC AS  VS ON ZE.ID=VS.SHOP_ORDER_BO ";
  private static Map<String, String> subIdToDescriptionMap;

  static {
    subIdToDescriptionMap = new HashMap<>();
    subIdToDescriptionMap.put("CUST_PART_NUM1", "客户机种名");
  }

  private Connection conn;

  public LookupExDao(Connection conn) {
    this.conn = conn;
  }

  public Lookup selectByPK(String id, String subid) throws SQLException {
    Lookup lookup = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL1 + "WHERE id=? AND subid=? ")) {
      ps.setString(1, id);
      ps.setString(2, subid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = convert(rs);
      }
    }
    return lookup;
  }

  public List<Lookup> selectBySubid(String subid) throws SQLException {
    ArrayList<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL1 + "WHERE subid=? ")) {
      ps.setString(1, subid);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public Lookup selectByValue(String value, String subid) throws SQLException {
    Lookup lookup = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE value=? AND subid=? ")) {
      ps.setString(1, value);
      ps.setString(2, subid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = convert(rs);
      }
    }
    return lookup;
  }

  public Lookup selectShopByValue(String excludeShopBo, String value, String subid)
      throws SQLException {
    Lookup lookup = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id not like ? AND value=? AND subid=? ")) {
      ps.setString(1, excludeShopBo + "%");
      ps.setString(2, value);
      ps.setString(3, subid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = convert(rs);
      }
    }
    return lookup;
  }

  public int deleteByPk(String id, String subid) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("delete from zd_lookup_ex WHERE id=? and subid=?");
    ps.setString(1, id);
    ps.setString(2, subid);
    return ps.executeUpdate();
  }

  public ArrayList<Lookup> selectBySubidAndValue(String subid, String value) throws SQLException {
    ArrayList<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE subid=? AND value=? ")) {
      ps.setString(1, subid);
      ps.setString(2, value);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public Lookup selectByGroup(String subid, String groupName) throws SQLException {
    Lookup lookup = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE subid=? AND group_name=?")) {
      ps.setString(1, subid);
      ps.setString(2, groupName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = convert(rs);
      }
    }
    return lookup;
  }

  public Lookup selectByPKAddress(String groupid, String subid) throws SQLException {
    Lookup lookup = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE group_name like ? AND subid=? ")) {
      ps.setString(1, groupid + "%");
      ps.setString(2, subid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = convert(rs);
      }
    }
    return lookup;
  }


  public Lookup selectByIdSubid(String id, String subid) throws SQLException {
    Lookup lookup = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id like ?  AND subid=? ")) {
      ps.setString(1, id + "%");
      ps.setString(2, subid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = convert(rs);
      }
    }
    return lookup;
  }

  public List<Lookup> selectStartWith(String id) throws SQLException {
    ArrayList<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id like ? ORDER BY id,subid")) {
      ps.setString(1, id + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<Lookup> selectOnlineOwner() throws SQLException {
    ArrayList<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL1 + "WHERE subid='OWNER' and value not like 'CLOSE%' ORDER BY value")) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<Lookup> select(String id) throws SQLException {
    ArrayList<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id=? and value is not null ORDER BY subid")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public String selectDcByDB(String date, String format) throws SQLException {
    String result = "";
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT to_char(?,?) from DUMMY ")) {
      ps.setString(1, date);
      ps.setString(2, format);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = rs.getString(1);
      }
      return result;
    }
  }

  public int insert(List<Lookup> lookups) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("INSERT INTO zd_lookup_ex(id,subid,value,group_name) VALUES(?,?,?,?)");
    for (Lookup lk : lookups) {
      ps.setString(1, lk.getId());
      ps.setString(2, lk.getSubid());
      ps.setString(3, lk.getValue());
      ps.setString(4, lk.getGroupName());
      ps.addBatch();
    }
    return ps.executeBatch().length;
  }

  public int insert(String id, String subid, String value, String groupName) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("INSERT INTO zd_lookup_ex(id,subid,value,group_name) VALUES(?,?,?,?)");
    ps.setString(1, id);
    ps.setString(2, subid);
    ps.setString(3, value);
    ps.setString(4, groupName);
    return ps.executeUpdate();
  }

  public int insert(Lookup lookup) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("INSERT INTO zd_lookup_ex(id,subid,value,group_name) VALUES(?,?,?,?)");
    ps.setString(1, lookup.getId());
    ps.setString(2, lookup.getSubid());
    ps.setString(3, lookup.getValue());
    ps.setString(4, lookup.getGroupName());
    return ps.executeUpdate();
  }

  public int update(String value, String id, String subid) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, value);
      ps.setString(2, id);
      ps.setString(3, subid);
      return ps.executeUpdate();
    }
  }

  public int updateByGroup(String value, String id, String subid) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_GROUP)) {
      ps.setString(1, value);
      ps.setString(2, id);
      ps.setString(3, subid);
      return ps.executeUpdate();
    }
  }

  private Lookup convert(ResultSet rs) throws SQLException {
    Lookup data = new Lookup();
    data.setId(rs.getString(1));
    data.setSubid(rs.getString(2));
    data.setValue(rs.getString(3));
    data.setGroupName(rs.getString(4));
    return data;
  }

  /**
   * WHERE
   *
   * @param param
   * @return
   * @throws SQLException
   */
  public List<String> selectLots(String param) throws SQLException {
    List<String> lots = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE  VS.DEVICE_NAME = ?  AND VS.STATE_NAME = 'WAIT'")) {
      ps.setString(1, param);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        lots.add(rs.getString("SFC_NAME"));
      }
      return lots;
    }
  }

  public Lookup selectByPKWithNullException(String id, String subid) throws SQLException {
    Lookup lookup = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL1 + "WHERE id=? AND subid=? ")) {
      ps.setString(1, id);
      ps.setString(2, subid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = convert(rs);
      }
    }
    String des =
        subIdToDescriptionMap.containsKey(subid) ? "(" + subIdToDescriptionMap.get(subid) + ")"
            : "";

    if (null == lookup) {
      throw new SQLException(Env.trimHandle(id) + "WO中" + subid + des + "资料未上传, 请联系工艺确认");
    }
    return lookup;
  }


  /**
   * @Param: [shopOrderBo]
   * @return: java.lang.String
   * @To:
   */
  public String selectCustomer(String shopOrderBo) {

    String result = null;

    return result;
  }

  /**
   * @Param: [shopOrderBo]
   * @return: java.lang.String
   * @To:
   */
  public String selectCustomerPo(String shopOrderBo) throws Exception {

    Lookup lookup = selectByPK(shopOrderBo, "CUSTOMER_PO");
    return null == lookup ? "" : lookup.getValue();
  }


  /**
   * @Param: [shopOrderBo]
   * @return: java.lang.String
   * @To:
   */
  public String selectCustomerDevice(String shopOrderBo) throws Exception {
    Lookup lookup = selectByPKWithNullException(shopOrderBo, "CUST_PART_NUM1");
    if ("NULL".equals(lookup.getValue())) {
      throw new Exception(shopOrderBo + "客户机种名为NULL");
    }
    return lookup.getValue();
  }

  /**
   * @Param: [shopOrderBo]
   * @return: java.lang.String
   * @To:
   */
  public String selectDc(String shopOrderBo) throws Exception {
    Lookup lookup = selectByPK(shopOrderBo, "ERP_CREATE_DATE");
    return null == lookup ? "" : lookup.getValue();
  }

}
