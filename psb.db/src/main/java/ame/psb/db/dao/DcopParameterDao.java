package ame.psb.db.dao;

import ame.psb.db.DcopParameter;
import ame.psb.db.ViewDcopParameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DcopParameterDao {

  private static final String SQL_INS = "INSERT INTO zd_dcop_parameter(dcop_bo,dc_parameter_bo,warn_ucl,warn_lcl,alarm_ucl,alarm_lcl,verify,target_value,spc_display_template,spc_query_template,compare_dcop_bo,compare_dc_group_bo, POINT, VERIFICATION_TYPE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_dcop_parameter SET warn_ucl=?,warn_lcl=?,alarm_ucl=?,alarm_lcl=?,verify=?,target_value=?,spc_display_template=?,spc_query_template=?,compare_dcop_bo=?,compare_dc_group_bo=?, POINT = ?, VERIFICATION_TYPE =? WHERE dcop_bo=? and dc_parameter_bo=?";

  private static final String SQL_SEL = "SELECT dcop_bo,dc_parameter_bo,warn_ucl,warn_lcl,alarm_ucl,alarm_lcl,verify,target_value,spc_display_template,spc_query_template,dc_group,collection_type,dc_group_bo,parameter_name,data_type,parameter_description,die_count,check_flag,compare_dcop_bo,compare_dc_group_bo, POINT, VERIFICATION_TYPE FROM view_dcop_parameter ";

  private final Connection conn;

  public DcopParameterDao(Connection conn) {
    this.conn = conn;
  }

  public void insert(List<ViewDcopParameter> datas) throws SQLException {
    for (DcopParameter data : datas) {
      try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
        ps.setString(1, data.getDcopBo());
        ps.setString(2, data.getDcParameterBo());
        ps.setBigDecimal(3, data.getWarnUcl());
        ps.setBigDecimal(4, data.getWarnLcl());
        ps.setBigDecimal(5, data.getAlarmUcl());
        ps.setBigDecimal(6, data.getAlarmLcl());
        ps.setString(7, data.getVerify());
        ps.setBigDecimal(8, data.getTargetValue());
        ps.setString(9, data.getSpcDisplayTemplate());
        ps.setString(10, data.getSpcQueryTemplate());
        ps.setString(11, data.getCompareDcopBo());
        ps.setString(12, data.getCompareDcGroupBo());
        ps.setBigDecimal(13, data.getPoint());
        ps.setString(14, data.getVerificationtype());

        ps.executeUpdate();
        //return ps.executeUpdate();
      }

    }

  }

  public void insertDcopParameterList(List<DcopParameter> datas) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DcopParameter data : datas) {
        ps.setString(1, data.getDcopBo());
        ps.setString(2, data.getDcParameterBo());
        ps.setBigDecimal(3, data.getWarnUcl());
        ps.setBigDecimal(4, data.getWarnLcl());
        ps.setBigDecimal(5, data.getAlarmUcl());
        ps.setBigDecimal(6, data.getAlarmLcl());
        ps.setString(7, data.getVerify());
        ps.setBigDecimal(8, data.getTargetValue());
        ps.setString(9, data.getSpcDisplayTemplate());
        ps.setString(10, data.getSpcQueryTemplate());
        ps.setString(11, data.getCompareDcopBo());
        ps.setString(12, data.getCompareDcGroupBo());
        ps.setBigDecimal(13, data.getPoint());
        ps.setString(14, data.getVerificationtype());
        ps.addBatch();
      }
      ps.executeBatch();
    }
  }

  public int insert(DcopParameter data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getDcopBo());
      ps.setString(2, data.getDcParameterBo());
      ps.setBigDecimal(3, data.getWarnUcl());
      ps.setBigDecimal(4, data.getWarnLcl());
      ps.setBigDecimal(5, data.getAlarmUcl());
      ps.setBigDecimal(6, data.getAlarmLcl());
      ps.setString(7, data.getVerify());
      ps.setBigDecimal(8, data.getTargetValue());
      ps.setString(9, data.getSpcDisplayTemplate());
      ps.setString(10, data.getSpcQueryTemplate());
      ps.setString(11, data.getCompareDcopBo());
      ps.setString(12, data.getCompareDcGroupBo());
      ps.setBigDecimal(13, data.getPoint());
      ps.setString(14, data.getVerificationtype());

      return ps.executeUpdate();
    }
  }

  public int update(DcopParameter data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getWarnUcl());
      ps.setBigDecimal(2, data.getWarnLcl());
      ps.setBigDecimal(3, data.getAlarmUcl());
      ps.setBigDecimal(4, data.getAlarmLcl());
      ps.setString(5, data.getVerify());
      ps.setBigDecimal(6, data.getTargetValue());
      ps.setString(7, data.getSpcDisplayTemplate());
      ps.setString(8, data.getSpcQueryTemplate());
      ps.setString(9, data.getCompareDcopBo());
      ps.setString(10, data.getCompareDcGroupBo());
      ps.setBigDecimal(11, data.getPoint());
      ps.setString(12, data.getVerificationtype());
      ps.setString(13, data.getDcopBo());
      ps.setString(14, data.getDcParameterBo());
      return ps.executeUpdate();
    }
  }

  public List<ViewDcopParameter> selectByDcop(String dcopBo) throws SQLException {
    ArrayList<ViewDcopParameter> result = new ArrayList<ViewDcopParameter>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE dcop_bo=? ORDER BY dc_parameter_bo")) {
      ps.setString(1, dcopBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewDcopParameter> selectByItemGroupBoAndOperationBo(String itemGroupBo, String operationBo) throws SQLException {
    ArrayList<ViewDcopParameter> result = new ArrayList<ViewDcopParameter>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO=? and OPERATION_BO = ? and STATE_NAME = 'ENABLE' ORDER BY dc_parameter_bo")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewDcopParameter selectByDcopAnddcparameterBo(String dcopBo,String dcparameterBo) throws SQLException {
    ViewDcopParameter result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE dcop_bo=? and  dc_parameter_bo = ?")) {
      ps.setString(1, dcopBo);
      ps.setString(2, dcparameterBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  /*
   * cc
   *
   * */
  public List<ViewDcopParameter> selectByCompareDcopBo(String compareDcopBo,
      String compareDcGroupBo) throws SQLException {
    ArrayList<ViewDcopParameter> result = new ArrayList<ViewDcopParameter>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE compare_dcop_bo=? and compare_dc_group_bo=? ")) {
      ps.setString(1, compareDcopBo);
      ps.setString(2, compareDcGroupBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ViewDcopParameter> selectByItemGroup(String itemGroupBo) throws SQLException {
    ArrayList<ViewDcopParameter> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO=? ORDER BY dc_parameter_bo")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewDcopParameter convert(ResultSet rs) throws SQLException {
    ViewDcopParameter data = new ViewDcopParameter();

    int index = 1;
    data.setDcopBo(rs.getString(index++));
    data.setDcParameterBo(rs.getString(index++));
    data.setWarnUcl(rs.getBigDecimal(index++));
    data.setWarnLcl(rs.getBigDecimal(index++));
    data.setAlarmUcl(rs.getBigDecimal(index++));
    data.setAlarmLcl(rs.getBigDecimal(index++));
    data.setVerify(rs.getString(index++));
    data.setTargetValue(rs.getBigDecimal(index++));
    data.setSpcDisplayTemplate(rs.getString(index++));
    data.setSpcQueryTemplate(rs.getString(index++));
    data.setDcGroup(rs.getString(index++));
    data.setCollectionType(rs.getString(index++));
    data.setDcGroupBo(rs.getString(index++));
    data.setParameterName(rs.getString(index++));
    data.setDataType(rs.getString(index++));
    data.setParameterDescription(rs.getString(index++));
    data.setDieCount(rs.getBigDecimal(index++));
    data.setCheckFlag(rs.getString(index++));
    data.setCompareDcopBo(rs.getString(index++));
    data.setCompareDcGroupBo(rs.getString(index++));
    data.setPoint(rs.getBigDecimal(index++));
    data.setVerificationtype(rs.getString(index++));

    return data;
  }

  public int selectByItemGroupBo(String itemGroupBoTo) throws SQLException {
    String selSql = "select count(1) from zd_dcop where item_group_bo = ?";
    int count = 0;
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, itemGroupBoTo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        count = rs.getInt(1);
      }
      return count;
    }
  }

  public List<DcopParameter> selectByDcopBo(String itemGroupBoFrom) throws SQLException {
    String selSql = "select * from zd_dcop_parameter where dcop_bo in (select id from zd_dcop where item_group_bo = ? order by id) order by dcop_bo";
    ArrayList<DcopParameter> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, itemGroupBoFrom);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        DcopParameter data = new DcopParameter();
        data.setDcopBo(rs.getString("dcop_bo"));
        data.setDcParameterBo(rs.getString("dc_parameter_bo"));
        data.setWarnUcl(rs.getBigDecimal("warn_ucl"));
        data.setWarnLcl(rs.getBigDecimal("warn_lcl"));
        data.setAlarmUcl(rs.getBigDecimal("alarm_ucl"));
        data.setAlarmLcl(rs.getBigDecimal("alarm_lcl"));
        data.setVerify(rs.getString("verify"));
        data.setTargetValue(rs.getBigDecimal("target_value"));
        data.setSpcDisplayTemplate(rs.getString("spc_display_template"));
        data.setSpcQueryTemplate(rs.getString("spc_query_template"));
        result.add(data);
      }
      return result;
    }
  }

  public List<DcopParameter> selectByDcopBo2(String itemGroupBoFrom) throws SQLException {
    String selSql = "select * from zd_dcop_parameter where dcop_bo in (select id from zd_dcop where item_group_bo = ? and STATE_NAME != 'DISABLE' order by id) order by dcop_bo";
    ArrayList<DcopParameter> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, itemGroupBoFrom);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        DcopParameter data = new DcopParameter();
        data.setDcopBo(rs.getString("dcop_bo"));
        data.setDcParameterBo(rs.getString("dc_parameter_bo"));
        data.setWarnUcl(rs.getBigDecimal("warn_ucl"));
        data.setWarnLcl(rs.getBigDecimal("warn_lcl"));
        data.setAlarmUcl(rs.getBigDecimal("alarm_ucl"));
        data.setAlarmLcl(rs.getBigDecimal("alarm_lcl"));
        data.setVerify(rs.getString("verify"));
        data.setTargetValue(rs.getBigDecimal("target_value"));
        data.setSpcDisplayTemplate(rs.getString("spc_display_template"));
        data.setSpcQueryTemplate(rs.getString("spc_query_template"));
        result.add(data);
      }
      return result;
    }
  }
}