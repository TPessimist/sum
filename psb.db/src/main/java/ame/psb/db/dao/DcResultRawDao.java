package ame.psb.db.dao;

import ame.psb.db.DcResultRaw;
import ame.psb.db.ViewDcResultRaw;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class DcResultRawDao {

  private static final String SQL_INS = "INSERT INTO zr_dc_result_raw(id,dc_result_bo,group_id,dc_parameter_bo,dc_value,dc_time,customer_item_bo,state_name,latest_Flag) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_INSTEXT = "INSERT INTO zr_dc_result_raw(id,dc_result_bo,group_id,dc_parameter_bo,dc_value_text,dc_time,customer_item_bo,state_name) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_dc_result_raw SET dc_result_bo=?,group_id=?,dc_parameter_bo=?,dc_value=?,dc_time=?,customer_item_bo=?,state_name=?,latest_Flag=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,dc_result_bo,group_id,dc_parameter_bo,dc_value,dc_time,customer_item_bo,state_name,latest_Flag FROM zr_dc_result_raw ";

  private static final String SQL_SEL_TEXT = "SELECT id,dc_result_bo,group_id,dc_parameter_bo,dc_value,dc_value_text,dc_time,customer_item_bo,state_name,latest_Flag FROM zr_dc_result_raw ";

  private static final String SQL_SEL_VIEW = "SELECT id,dc_result_bo,group_id,dc_parameter_bo,dc_value,dc_time,customer_item_bo,state_name,LATEST_FLAG FROM view_dc_result_raw ";

  private static final String SQL_SEL_VIEW_2 =
      "SELECT SFC_BO,SFC_NAME,CUSTOMER_ITEMSET_BO,CUSTOMER_ITEMSET_NAME,"
          + "ITEM_BO,ITEM_NAME,DEVICE_BO,DEVICE_NAME,PACKAGE_BO,PACKAGE_NAME,DC_RESULT_BO,DC_TIME,"
          + "RESOURCE_BO,OPERATION_BO,DC_DCOP_BO,STATE_NAME,ID,GROUP_ID,CUSTOMER_ITEM_BO,DC_VALUE,"
          + "DC_PARAMETER_BO,DC_VALUE_STATE,LATEST_FLAG FROM view_dc_result_raw ";


  private final Connection conn;

  public DcResultRawDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DcResultRaw data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getDcResultBo());
      ps.setString(3, data.getGroupId());
      ps.setString(4, data.getDcParameterBo());
      ps.setBigDecimal(5, data.getDcValue());
      DateUtils.setDateTz(ps, 6, data.getDcTime());
      ps.setString(7, data.getCustomerItemBo());
      ps.setString(8, data.getStateName());
      ps.setString(9, data.getLatestFlag());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DcResultRaw> data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DcResultRaw raw : data) {
        ps.setString(1, raw.getId());
        ps.setString(2, raw.getDcResultBo());
        ps.setString(3, raw.getGroupId());
        ps.setString(4, raw.getDcParameterBo());
        ps.setBigDecimal(5, raw.getDcValue());
        DateUtils.setDateTz(ps, 6, raw.getDcTime());
        ps.setString(7, raw.getCustomerItemBo());
        ps.setString(8, raw.getStateName());
        ps.setString(9, raw.getLatestFlag());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int insertText(List<DcResultRaw> data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INSTEXT)) {
      for (DcResultRaw raw : data) {
        ps.setString(1, raw.getId());
        ps.setString(2, raw.getDcResultBo());
        ps.setString(3, raw.getGroupId());
        ps.setString(4, raw.getDcParameterBo());
        ps.setString(5, raw.getDcValueText());
        DateUtils.setDateTz(ps, 6, raw.getDcTime());
        ps.setString(7, raw.getCustomerItemBo());
        ps.setString(8, raw.getStateName());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }


  public int update(DcResultRaw data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDcResultBo());
      ps.setString(2, data.getGroupId());
      ps.setString(3, data.getDcParameterBo());
      ps.setBigDecimal(4, data.getDcValue());
      DateUtils.setDateTz(ps, 5, data.getDcTime());
      ps.setString(6, data.getCustomerItemBo());
      ps.setString(7, data.getStateName());
      ps.setString(8, data.getStateName());
      ps.setString(9, data.getLatestFlag());

      return ps.executeUpdate();
    }
  }

  public int updateList(List<DcResultRaw> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DcResultRaw data : dataList) {
        ps.setString(1, data.getDcResultBo());
        ps.setString(2, data.getGroupId());
        ps.setString(3, data.getDcParameterBo());
        ps.setBigDecimal(4, data.getDcValue());
        DateUtils.setDateTz(ps, 5, data.getDcTime());
        ps.setString(6, data.getCustomerItemBo());
        ps.setString(7, data.getStateName());
        ps.setString(8, data.getLatestFlag());
        ps.setString(9, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateId(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE ZR_DC_RESULT_RAW SET DC_VALUE_STATE = 'R' WHERE ID = ?")) {
      ps.setString(1, id);
      return ps.executeUpdate();
    }
  }

  public List<DcResultRaw> selectByResult(String dcResultBo, Date data) throws SQLException {
    ArrayList<DcResultRaw> result = new ArrayList<DcResultRaw>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_TEXT
            + "WHERE dc_result_bo=? and DC_TIME between ? and CURRENT_TIMESTAMP ORDER BY dc_time,group_id,dc_parameter_bo")) {
      ps.setString(1, dcResultBo);
      DateUtils.setDateTz(ps, 2, data);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<DcResultRaw> selectByResult(String dcResultBo) throws SQLException {
    ArrayList<DcResultRaw> result = new ArrayList<DcResultRaw>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_TEXT + "WHERE dc_result_bo=? ORDER BY dc_time,group_id,dc_parameter_bo")) {
      ps.setString(1, dcResultBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  /*
   * cc
   * @param DC_PARAMETER_BO
   * @param GROUP_ID
   * TODO: 2022/3/18
   * */
  public DcResultRaw selectByGroupIdAndFlag(String groupId, String flag, String customerItemBo,
      String dcDcopBo)
      throws SQLException {
    DcResultRaw result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_VIEW_2
            + "WHERE group_id=? and latest_Flag=? and customer_item_bo=? and dc_dcop_bo=? order by dc_time desc")) {
      ps.setString(1, groupId);
      ps.setString(2, flag);
      ps.setString(3, customerItemBo);
      ps.setString(4, dcDcopBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convertAll(rs);
      }
      return result;
    }
  }

  /*
   * 根据flag查询是否有设置前置站点
   * */
  public List<DcResultRaw> selectByFlag(String flag) throws SQLException {
    ArrayList<DcResultRaw> result = new ArrayList<DcResultRaw>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_VIEW_2
            + "WHERE latest_Flag=? ORDER BY dc_time,group_id,dc_parameter_bo")) {
      ps.setString(1, flag);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertAll(rs));
      }
      return result;
    }
  }

  /*
   * @param customer_itemset_bo
   * @param item_name
   * @param device_name
   * @param dc_dcop_bo
   * @param dc_parameter_bo
   * @param latest_Flag
   * */
  public List<DcResultRaw> selectByParams(String customerItemSetBo, String itemName,
      String deviceName, String dcDcopBo, String dcParameterBo, String flag) throws SQLException {
    ArrayList<DcResultRaw> result = new ArrayList<DcResultRaw>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_VIEW_2
            + "WHERE customer_itemset_name=? and item_name=? and device_name=? and dc_dcop_bo=? and dc_parameter_bo=? and  latest_Flag=? ORDER BY dc_time,group_id,dc_parameter_bo")) {
      ps.setString(1, customerItemSetBo);
      ps.setString(2, itemName);
      ps.setString(3, deviceName);
      ps.setString(4, dcDcopBo);
      ps.setString(5, dcParameterBo);
      ps.setString(6, flag);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertAll(rs));
      }
      return result;
    }
  }

  public List<DcResultRaw> selectByResultNotR(String dcResultBo) throws SQLException {
    ArrayList<DcResultRaw> result = new ArrayList<DcResultRaw>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_TEXT
            + "WHERE dc_result_bo=? and  DC_VALUE_STATE IS  NULL  ORDER BY dc_time,group_id,dc_parameter_bo")) {
      ps.setString(1, dcResultBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<DcResultRaw> selectByResultCustomerItem(String dcResultBo, String customerItemBo)
      throws SQLException {
    ArrayList<DcResultRaw> result = new ArrayList<DcResultRaw>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE dc_result_bo=? AND customer_item_bo=?")) {
      ps.setString(1, dcResultBo);
      ps.setString(2, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertNoText(rs));
      }
      return result;
    }
  }

  public DcResultRaw selectBySfcAndParam(String sfcBo, String param) throws SQLException {
    DcResultRaw result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_VIEW + "WHERE sfc_bo=? AND dc_parameter_bo=? order by dc_time desc")) {
      ps.setString(1, sfcBo);
      ps.setString(2, param);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convertNoText(rs);
      }
      return result;
    }
  }


  public DcResultRaw selectByWaferAndDcop(String wafer, String dcop) throws SQLException {
    DcResultRaw result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_VIEW + "WHERE CUSTOMER_ITEM_BO=? AND DC_DCOP_BO=? order by dc_time desc")) {
      ps.setString(1, wafer);
      ps.setString(2, dcop);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convertNoText(rs);
      }
      return result;
    }
  }

  public DcResultRaw selectBySfcLikeAndParam(String sfcBo, String param) throws SQLException {
    DcResultRaw result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_VIEW + "WHERE sfc_bo like? AND dc_parameter_bo=? order by dc_time desc")) {
      ps.setString(1, "%" + sfcBo + "%");
      ps.setString(2, param);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convertNoText(rs);
      }
      return result;
    }
  }

  public List<DcResultRaw> selectLatestByResultCustomerItem(String dcResultBo,
      String customerItemBo) throws SQLException {
    ArrayList<DcResultRaw> result = new ArrayList<DcResultRaw>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE dc_result_bo=? AND customer_item_bo=? and dc_time in ( select max(DC_TIME) from ZR_DC_RESULT_RAW where dc_result_bo=? AND customer_item_bo=?)")) {
      ps.setString(1, dcResultBo);
      ps.setString(2, customerItemBo);
      ps.setString(3, dcResultBo);
      ps.setString(4, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertNoText(rs));
      }
      return result;
    }
  }

  public List<DcResultRaw> selectDate(String dcResultBo, String customerItemBo)
      throws SQLException {
    ArrayList<DcResultRaw> result = new ArrayList<DcResultRaw>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE dc_result_bo=? AND customer_item_bo=? ORDER BY dc_time DESC")) {
      ps.setString(1, dcResultBo);
      ps.setString(2, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertNoDate(rs));
      }
      return result;
    }
  }

  public List<DcResultRaw> selectByTime(String dcResultBo, String customerItemBo, String time)
      throws SQLException {
    ArrayList<DcResultRaw> result = new ArrayList<DcResultRaw>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_TEXT
        + "WHERE dc_result_bo=? AND customer_item_bo=? AND dc_time=? ORDER BY dc_time DESC")) {
      ps.setString(1, dcResultBo);
      ps.setString(2, customerItemBo);
      ps.setString(3, time);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewDcResultRaw convertAll(ResultSet rs) throws SQLException {
    ViewDcResultRaw data = new ViewDcResultRaw();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setCustomerItemsetBo(rs.getString(index++));
    data.setCustomerItemsetName(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setDeviceBo(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setPackageBo(rs.getString(index++));
    data.setPackageName(rs.getString(index++));
    data.setDcResultBo(rs.getString(index++));
    data.setDcTime(DateUtils.getDateTz(rs, index++));
    data.setResourceBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDcopBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setId(rs.getString(index++));
    data.setGroupId(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setDcValue(rs.getBigDecimal(index++));
    data.setDcParameterBo(rs.getString(index++));
    data.setLatestFlag(rs.getString(index++));
    data.setDcValuestate(rs.getString(index++));

    return data;
  }

  private DcResultRaw convert(ResultSet rs) throws SQLException {
    DcResultRaw data = new DcResultRaw();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDcResultBo(rs.getString(index++));
    data.setGroupId(rs.getString(index++));
    data.setDcParameterBo(rs.getString(index++));
    data.setDcValue(rs.getBigDecimal(index++));
    data.setDcValueText(rs.getString(index++));
    data.setDcTime(DateUtils.getDateTz(rs, index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setLatestFlag(rs.getString(index++));

    return data;
  }

  private DcResultRaw convertNoText(ResultSet rs) throws SQLException {
    DcResultRaw data = new DcResultRaw();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDcResultBo(rs.getString(index++));
    data.setGroupId(rs.getString(index++));
    data.setDcParameterBo(rs.getString(index++));
    data.setDcValue(rs.getBigDecimal(index++));
    data.setDcTime(DateUtils.getDateTz(rs, index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setLatestFlag(rs.getString(index++));

    return data;
  }

  private DcResultRaw convertNoDate(ResultSet rs) throws SQLException {
    DcResultRaw data = new DcResultRaw();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDcResultBo(rs.getString(index++));
    data.setGroupId(rs.getString(index++));
    data.setDcParameterBo(rs.getString(index++));
    data.setDcValue(rs.getBigDecimal(index++));
    data.setDcTime(DateUtils.getDate(rs, index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setLatestFlag(rs.getString(index++));

    return data;
  }
}