package ame.psb.db.dao;

import ame.psb.db.ViewSpcResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewSpcResultDao {

  private static final String SQL_SEL = "SELECT  ids,sfc_bo,sfc_name,customer_itemset_bo,customer_itemset_name,item_bo,item_name,device_bo,device_name,package_bo,package_name,dc_result_bo,dc_time,resource_bo,operation_bo,dc_dcop_bo,state_name,id,group_id,customer_item_bo,dc_value,dc_parameter_bo,dc_group_bo,dc_group,parameter_name,warn_ucl,warn_lcl,alarm_ucl,alarm_lcl,target_value,value_state FROM view_spc_result ";

  private static final String SQL_SEL_TOP = "SELECT top ? IDS ,DC_VALUE,DEVICE_NAME,SFC_NAME, CUSTOMER_ITEM_BO,GROUP_ID ,   OPERATION_BO,DC_GROUP,PARAMETER_NAME,DC_TIME, WARN_UCL,WARN_LCL,ALARM_UCL,ALARM_LCL,TARGET_VALUE , dc_dcop_bo  FROM view_spc_result ";


  private final Connection conn;

  public ViewSpcResultDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewSpcResult> selectAll() throws SQLException {
    ArrayList<ViewSpcResult> result = new ArrayList<ViewSpcResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
      ps.setMaxRows(ame.psb.db.conf.Hana.getMaxRow());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSpcResult> selectByDcparameter(int rorNum, String dcopBo, String operationBo,
      String deviceName, String dcGroupBo, String dcParaBo) throws SQLException {
    ArrayList<ViewSpcResult> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_TOP
        + " where DC_DCOP_BO = ? and OPERATION_BO = ? and DEVICE_NAME = ? and DC_GROUP_BO = ? and DC_PARAMETER_BO = ? order by dc_time desc, group_id asc ")) {
      ps.setMaxRows(ame.psb.db.conf.Hana.getMaxRow());
      ps.setInt(1, rorNum);
      ps.setString(2, dcopBo);
      ps.setString(3, operationBo);
      ps.setString(4, deviceName);
      ps.setString(5, dcGroupBo);
      ps.setString(6, dcParaBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert1(rs));
      }
      return result;
    }
  }

  public ViewSpcResult selectByDcparameter(int rorNum, String sfcBo, String operationBo,
      String dcParaBo, String dcGroup) throws SQLException {
    ViewSpcResult result = new ViewSpcResult();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_TOP
        + " WHERE  SFC_NAME = ? AND OPERATION_BO = ? AND  PARAMETER_NAME = ? AND DC_GROUP = ? ORDER BY DC_TIME DESC")) {
      ps.setMaxRows(ame.psb.db.conf.Hana.getMaxRow());
      ps.setInt(1, rorNum);
      ps.setString(2, sfcBo);
      ps.setString(3, operationBo);
      ps.setString(4, dcParaBo);
      ps.setString(5, dcGroup);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewSpcResult> selectSpecialSql(String sql) throws SQLException {
    ArrayList<ViewSpcResult> result = new ArrayList<ViewSpcResult>();
    System.out.println("sql=>" + sql);

    try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
      ps.setMaxRows(ame.psb.db.conf.Hana.getMaxRow());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewSpcResult convert1(ResultSet rs) throws SQLException {
    ViewSpcResult data = new ViewSpcResult();

    int index = 1;

    data.setIds(rs.getString(index++));
    data.setDcValue(rs.getBigDecimal(index++));
    data.setDeviceName(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setGroupId(rs.getBigDecimal(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDcGroup(rs.getString(index++));
    data.setParameterName(rs.getString(index++));
    data.setDcTime(rs.getTimestamp(index++));
    data.setWarnUcl(rs.getBigDecimal(index++));
    data.setWarnLcl(rs.getBigDecimal(index++));
    data.setAlarmUcl(rs.getBigDecimal(index++));
    data.setAlarmLcl(rs.getBigDecimal(index++));
    data.setTargetValue(rs.getBigDecimal(index++));
    data.setDcDcopBo(rs.getString(index++));

    return data;
  }

  private ViewSpcResult convert(ResultSet rs) throws SQLException {
    ViewSpcResult data = new ViewSpcResult();

    int index = 1;

    data.setIds(rs.getString(index++));
    data.setDcValue(rs.getBigDecimal(index++));
    data.setDeviceName(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setGroupId(rs.getBigDecimal(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDcGroup(rs.getString(index++));
    data.setParameterName(rs.getString(index++));
    data.setDcTime(rs.getTimestamp(index++));
    data.setWarnUcl(rs.getBigDecimal(index++));
    data.setWarnLcl(rs.getBigDecimal(index++));
    data.setAlarmUcl(rs.getBigDecimal(index++));
    data.setAlarmLcl(rs.getBigDecimal(index++));
    data.setTargetValue(rs.getBigDecimal(index++));

//        data.setSfcBo(rs.getString(index++));
//        data.setCustomerItemsetBo(rs.getString(index++));
//        data.setCustomerItemsetName(rs.getString(index++));
//        data.setItemBo(rs.getString(index++));
//        data.setItemName(rs.getString(index++));
//        data.setDeviceBo(rs.getString(index++));
//        data.setPackageBo(rs.getString(index++));
//        data.setPackageName(rs.getString(index++));
//        data.setDcResultBo(rs.getString(index++));
//        data.setResourceBo(rs.getString(index++));
//        data.setDcDcopBo(rs.getString(index++));
//        data.setStateName(rs.getString(index++));
//        data.setId(rs.getString(index++));
//        data.setDcParameterBo(rs.getString(index++));
//        data.setDcGroupBo(rs.getString(index++));
//        data.setValueState(rs.getString(index++));

    return data;
  }
}
