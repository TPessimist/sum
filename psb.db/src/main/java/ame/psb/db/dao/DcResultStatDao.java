package ame.psb.db.dao;

import ame.psb.db.DcResultStat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DcResultStatDao {

  private static final String SQL_INS = "INSERT INTO zr_dc_result_stat(id,dc_result_bo,dc_parameter_bo,stat_target,customer_item_bo,group_id,dc_value_type,dc_value) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_dc_result_stat SET dc_result_bo=?,dc_parameter_bo=?,stat_target=?,customer_item_bo=?,group_id=?,dc_value_type=?,dc_value=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,dc_result_bo,dc_parameter_bo,stat_target,customer_item_bo,group_id,dc_value_type,dc_value FROM zr_dc_result_stat ";

  private final Connection conn;

  public DcResultStatDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DcResultStat data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getDcResultBo());
      ps.setString(3, data.getDcParameterBo());
      ps.setString(4, data.getStatTarget());
      ps.setString(5, data.getCustomerItemBo());
      ps.setString(6, data.getGroupId());
      ps.setString(7, data.getDcValueType());
      ps.setBigDecimal(8, data.getDcValue());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DcResultStat> data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DcResultStat stat : data) {
        ps.setString(1, stat.getId());
        ps.setString(2, stat.getDcResultBo());
        ps.setString(3, stat.getDcParameterBo());
        ps.setString(4, stat.getStatTarget());
        ps.setString(5, stat.getCustomerItemBo());
        ps.setString(6, stat.getGroupId());
        ps.setString(7, stat.getDcValueType());
        ps.setBigDecimal(8, stat.getDcValue());
        ps.addBatch();
      }

      return ps.executeBatch().length;
    }
  }

  public int update(DcResultStat data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDcResultBo());
      ps.setString(2, data.getDcParameterBo());
      ps.setString(3, data.getStatTarget());
      ps.setString(4, data.getCustomerItemBo());
      ps.setString(5, data.getGroupId());
      ps.setString(6, data.getDcValueType());
      ps.setBigDecimal(7, data.getDcValue());
      ps.setString(8, data.getId());

      return ps.executeUpdate();
    }
  }

  public List<DcResultStat> selectAll() throws SQLException {
    ArrayList<DcResultStat> result = new ArrayList<DcResultStat>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public DcResultStat selectByPK(String id) throws SQLException {
    DcResultStat result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private DcResultStat convert(ResultSet rs) throws SQLException {
    DcResultStat data = new DcResultStat();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDcResultBo(rs.getString(index++));
    data.setDcParameterBo(rs.getString(index++));
    data.setStatTarget(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setGroupId(rs.getString(index++));
    data.setDcValueType(rs.getString(index++));
    data.setDcValue(rs.getBigDecimal(index++));

    return data;
  }
}
