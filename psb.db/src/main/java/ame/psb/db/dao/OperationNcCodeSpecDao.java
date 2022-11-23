package ame.psb.db.dao;

import ame.psb.db.NcOperationCodeSpec;
import ame.psb.db.ViewOperationNcCodeSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class OperationNcCodeSpecDao {

  private static final String SQL_INS = "INSERT INTO zd_operation_nc_code_spec(nc_code_bo,item_group_bo,operation_bo,wafer_ucl,wafer_lcl,lot_ucl,lot_lcl,updated_user,updated_time,remarks,wafer_ucl_count,wafer_lcl_count,lot_ucl_count,lot_lcl_count) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_operation_nc_code_spec SET wafer_ucl=?,wafer_lcl=?,lot_ucl=?,lot_lcl=?,updated_user=?,updated_time=?, remarks = ?,wafer_ucl_count=?,wafer_lcl_count=?,lot_ucl_count=?,lot_lcl_count=? WHERE nc_code_bo=? AND item_group_bo=? AND operation_bo=?";

  private static final String SQL_SEL = "SELECT nc_code_bo,item_group_bo,operation_bo,wafer_ucl,wafer_lcl,lot_ucl,lot_lcl,updated_user,updated_time,remarks,nc_code_name,nc_code_desc,operation_name,device_name,device_desc,wafer_ucl_count,wafer_lcl_count,lot_ucl_count,lot_lcl_count FROM view_operation_nc_code_spec ";

  private final Connection conn;

  public OperationNcCodeSpecDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(NcOperationCodeSpec data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getNcCodeBo());
      ps.setString(2, data.getItemGroupBo());
      ps.setString(3, data.getOperationBo());
      ps.setBigDecimal(4, data.getWaferUcl());
      ps.setBigDecimal(5, data.getWaferLcl());
      ps.setBigDecimal(6, data.getLotUcl());
      ps.setBigDecimal(7, data.getLotLcl());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getRemarks());
      ps.setBigDecimal(11, data.getWaferUclCount());
      ps.setBigDecimal(12, data.getWaferLclCount());
      ps.setBigDecimal(13, data.getLotUclCount());
      ps.setBigDecimal(14, data.getLotLclCount());

      return ps.executeUpdate();
    }
  }

  public int insert(List<NcOperationCodeSpec> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (NcOperationCodeSpec data : dataList) {
        ps.setString(1, data.getNcCodeBo());
        ps.setString(2, data.getItemGroupBo());
        ps.setString(3, data.getOperationBo());
        ps.setBigDecimal(4, data.getWaferUcl());
        ps.setBigDecimal(5, data.getWaferLcl());
        ps.setBigDecimal(6, data.getLotUcl());
        ps.setBigDecimal(7, data.getLotLcl());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getRemarks());
        ps.setBigDecimal(11, data.getWaferUclCount());
        ps.setBigDecimal(12, data.getWaferLclCount());
        ps.setBigDecimal(13, data.getLotUclCount());
        ps.setBigDecimal(14, data.getLotLclCount());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(NcOperationCodeSpec data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getWaferUcl());
      ps.setBigDecimal(2, data.getWaferLcl());
      ps.setBigDecimal(3, data.getLotUcl());
      ps.setBigDecimal(4, data.getLotLcl());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getRemarks());
      ps.setBigDecimal(8, data.getWaferUclCount());
      ps.setBigDecimal(9, data.getWaferLclCount());
      ps.setBigDecimal(10, data.getLotUclCount());
      ps.setBigDecimal(11, data.getLotLclCount());
      ps.setString(12, data.getNcCodeBo());
      ps.setString(13, data.getItemGroupBo());
      ps.setString(14, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<NcOperationCodeSpec> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (NcOperationCodeSpec data : dataList) {
        ps.setBigDecimal(1, data.getWaferUcl());
        ps.setBigDecimal(2, data.getWaferLcl());
        ps.setBigDecimal(3, data.getLotUcl());
        ps.setBigDecimal(4, data.getLotLcl());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getRemarks());
        ps.setBigDecimal(8, data.getWaferUclCount());
        ps.setBigDecimal(9, data.getWaferLclCount());
        ps.setBigDecimal(10, data.getLotUclCount());
        ps.setBigDecimal(11, data.getLotLclCount());
        ps.setString(12, data.getNcCodeBo());
        ps.setString(13, data.getItemGroupBo());
        ps.setString(14, data.getOperationBo());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String ncCodeBo, String itemGroupBo, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_operation_nc_code_spec WHERE nc_code_bo=? AND item_group_bo=? AND operation_bo=?")) {
      ps.setString(1, ncCodeBo);
      ps.setString(2, itemGroupBo);
      ps.setString(3, operationBo);

      return ps.executeUpdate();
    }
  }

  public int reset(String itemGroupBo, String operationBo, String user, Date time)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_operation_nc_code_spec SET alarm_ucl=null,warn_ucl=null,updated_user=?,updated_time=? WHERE item_group_bo=? AND operation_bo=?")) {
      ps.setString(1, user);
      DateUtils.setDateTz(ps, 2, time);
      ps.setString(3, itemGroupBo);
      ps.setString(4, operationBo);
      return ps.executeUpdate();
    }
  }

  public int delete(String itemGroupBo, String operationBo, String user, Date time)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_operation_nc_code_spec WHERE item_group_bo=? AND operation_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      return ps.executeUpdate();
    }
  }

  public List<ViewOperationNcCodeSpec> select(String itemGroupBo, String operationBo)
      throws SQLException {
    ArrayList<ViewOperationNcCodeSpec> result = new ArrayList<ViewOperationNcCodeSpec>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? AND operation_bo=? ORDER BY nc_code_bo")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewOperationNcCodeSpec selectByPK(String ncCodeBo, String itemGroupBo, String operationBo)
      throws SQLException {
    ViewOperationNcCodeSpec result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE nc_code_bo=? AND item_group_bo=? AND operation_bo=?")) {
      ps.setString(1, ncCodeBo);
      ps.setString(2, itemGroupBo);
      ps.setString(3, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ViewOperationNcCodeSpec convert(ResultSet rs) throws SQLException {
    ViewOperationNcCodeSpec data = new ViewOperationNcCodeSpec();

    int index = 1;
    data.setNcCodeBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setWaferUcl(rs.getBigDecimal(index++));
    data.setWaferLcl(rs.getBigDecimal(index++));
    data.setLotUcl(rs.getBigDecimal(index++));
    data.setLotLcl(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(rs.getTimestamp(index++));
    data.setRemarks(rs.getString(index++));
    data.setNcCodeName(rs.getString(index++));
    data.setNcCodeDesc(rs.getString(index++));
    data.setOperationName(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setDeviceDesc(rs.getString(index++));
    data.setWaferUclCount(rs.getBigDecimal(index++));
    data.setWaferLclCount(rs.getBigDecimal(index++));
    data.setLotUclCount(rs.getBigDecimal(index++));
    data.setLotLclCount(rs.getBigDecimal(index++));

    return data;
  }

  private NcOperationCodeSpec convertOperationNcCodeSpec(ResultSet rs) throws SQLException {
    NcOperationCodeSpec data = new NcOperationCodeSpec();

    int index = 1;
    data.setNcCodeBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setWaferUcl(rs.getBigDecimal(index++));
    data.setWaferLcl(rs.getBigDecimal(index++));
    data.setLotUcl(rs.getBigDecimal(index++));
    data.setLotLcl(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(rs.getTimestamp(index++));
    data.setRemarks(rs.getString(index++));
    data.setWaferUclCount(rs.getBigDecimal(index++));
    data.setWaferLclCount(rs.getBigDecimal(index++));
    data.setLotUclCount(rs.getBigDecimal(index++));
    data.setLotLclCount(rs.getBigDecimal(index++));

    return data;
  }

  public int selectCountByItemGroupBo(String itemGroupBoTo) throws SQLException {
    String selSql = "select count(1) from zd_operation_nc_code_spec where item_group_bo = ?";
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

  public List<NcOperationCodeSpec> selectByItemGroupBo(String itemGroupBoFrom) throws SQLException {
    String selSql = "select nc_code_bo,item_group_bo,operation_bo,wafer_ucl,wafer_lcl,lot_ucl,lot_lcl,updated_user,updated_time,remarks,wafer_ucl_count,wafer_lcl_count,lot_ucl_count,lot_lcl_count from zd_operation_nc_code_spec where item_group_bo = ?";
    List<NcOperationCodeSpec> list = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, itemGroupBoFrom);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convertOperationNcCodeSpec(rs));
      }
      return list;
    }
  }

}
