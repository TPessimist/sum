package ame.psb.db.dao;

import ame.psb.db.DcResultRawSub;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class DcResultRawSubDao {

  private static final String SQL_INS = "INSERT INTO zr_dc_result_raw_sub(id,dc_result_bo,dc_result_raw_bo,group_id,dc_parameter_bo,dc_value,dc_value_sub,dc_value_sub_result,dc_sub_result_bo,dc_time,customer_item_bo,state_name) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_dc_result_raw_sub SET dc_result_bo=?,dc_result_raw_bo=?,group_id=?,dc_parameter_bo=?,dc_value=?,dc_value_sub=?,dc_value_sub_result=?,dc_sub_result_bo=?,dc_time=?,customer_item_bo=?,state_name=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,dc_result_bo,dc_result_raw_bo,group_id,dc_parameter_bo,dc_value,dc_value_sub,dc_value_sub_result,dc_sub_result_bo,dc_time,customer_item_bo,state_name FROM zr_dc_result_raw_sub ";

  private final Connection conn;

  public DcResultRawSubDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DcResultRawSub data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getDcResultBo());
      ps.setString(3, data.getDcResultRawBo());
      ps.setString(4, data.getGroupId());
      ps.setString(5, data.getDcParameterBo());
      ps.setBigDecimal(6, data.getDcValue());
      ps.setBigDecimal(7, data.getDcValueSub());
      ps.setString(8, data.getDcValueSubResult());
      ps.setString(9, data.getDcSubResultBo());
      DateUtils.setDateTz(ps, 10, data.getDcTime());
      ps.setString(11, data.getCustomerItemBo());
      ps.setString(12, data.getStateName());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DcResultRawSub> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DcResultRawSub data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getDcResultBo());
        ps.setString(3, data.getDcResultRawBo());
        ps.setString(4, data.getGroupId());
        ps.setString(5, data.getDcParameterBo());
        ps.setBigDecimal(6, data.getDcValue());
        ps.setBigDecimal(7, data.getDcValueSub());
        ps.setString(8, data.getDcValueSubResult());
        ps.setString(9, data.getDcSubResultBo());
        DateUtils.setDateTz(ps, 10, data.getDcTime());
        ps.setString(11, data.getCustomerItemBo());
        ps.setString(12, data.getStateName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DcResultRawSub data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDcResultBo());
      ps.setString(2, data.getDcResultRawBo());
      ps.setString(3, data.getGroupId());
      ps.setString(4, data.getDcParameterBo());
      ps.setBigDecimal(5, data.getDcValue());
      ps.setBigDecimal(6, data.getDcValueSub());
      ps.setString(7, data.getDcValueSubResult());
      ps.setString(8, data.getDcSubResultBo());
      DateUtils.setDateTz(ps, 9, data.getDcTime());
      ps.setString(10, data.getCustomerItemBo());
      ps.setString(11, data.getStateName());
      ps.setString(12, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<DcResultRawSub> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DcResultRawSub data : dataList) {
        ps.setString(1, data.getDcResultBo());
        ps.setString(2, data.getDcResultRawBo());
        ps.setString(3, data.getGroupId());
        ps.setString(4, data.getDcParameterBo());
        ps.setBigDecimal(5, data.getDcValue());
        ps.setBigDecimal(6, data.getDcValueSub());
        ps.setString(7, data.getDcValueSubResult());
        ps.setString(8, data.getDcSubResultBo());
        DateUtils.setDateTz(ps, 9, data.getDcTime());
        ps.setString(10, data.getCustomerItemBo());
        ps.setString(11, data.getStateName());
        ps.setString(12, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_dc_result_raw_sub WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<DcResultRawSub> selectAll() throws SQLException {
    ArrayList<DcResultRawSub> result = new ArrayList<DcResultRawSub>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public DcResultRawSub selectByPK(String id) throws SQLException {
    DcResultRawSub result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private DcResultRawSub convert(ResultSet rs) throws SQLException {
    DcResultRawSub data = new DcResultRawSub();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDcResultBo(rs.getString(index++));
    data.setDcResultRawBo(rs.getString(index++));
    data.setGroupId(rs.getString(index++));
    data.setDcParameterBo(rs.getString(index++));
    data.setDcValue(rs.getBigDecimal(index++));
    data.setDcValueSub(rs.getBigDecimal(index++));
    data.setDcValueSubResult(rs.getString(index++));
    data.setDcSubResultBo(rs.getString(index++));
    data.setDcTime(DateUtils.getDateTz(rs, index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));

    return data;
  }
}
