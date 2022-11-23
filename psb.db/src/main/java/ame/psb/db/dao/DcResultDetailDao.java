package ame.psb.db.dao;

import ame.psb.db.DcResultDetail;
import ame.psb.db.ViewDcResultDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DcResultDetailDao {

  private static final String SQL_INS = "INSERT INTO zr_dc_result_detail(dc_result_bo,customer_item_bo,die_count,dc_count,state_name) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_dc_result_detail SET die_count=?,dc_count=?,state_name=? WHERE dc_result_bo=? AND customer_item_bo=?";

  private static final String SQL_SEL = "SELECT dc_result_bo,customer_item_bo,die_count,dc_count,state_name,sfc_bo,dc_plan_bo,dcop_bo,dpt_no,customer_item_name FROM view_dc_result_detail ";

  private final Connection conn;

  public DcResultDetailDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DcResultDetail data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getDcResultBo());
      ps.setString(2, data.getCustomerItemBo());
      ps.setInt(3, data.getDieCount());
      ps.setInt(4, data.getDcCount());
      ps.setString(5, data.getStateName());

      return ps.executeUpdate();
    }
  }

  public int update(DcResultDetail data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getDieCount());
      ps.setInt(2, data.getDcCount());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getDcResultBo());
      ps.setString(5, data.getCustomerItemBo());

      return ps.executeUpdate();
    }
  }

  public List<ViewDcResultDetail> selectByResult(String dcResultBo) throws SQLException {
    ArrayList<ViewDcResultDetail> result = new ArrayList<ViewDcResultDetail>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE dc_result_bo=? ORDER BY customer_item_bo")) {
      ps.setString(1, dcResultBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewDcResultDetail> selectByPlan(String dcPlanBo) throws SQLException {
    ArrayList<ViewDcResultDetail> result = new ArrayList<ViewDcResultDetail>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE dc_plan_bo=? ORDER BY customer_item_bo")) {
      ps.setString(1, dcPlanBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewDcResultDetail selectByPlan(String dcPlanBo, String customerItemBo)
      throws SQLException {
    ViewDcResultDetail result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE dc_plan_bo=? AND customer_item_bo=?")) {
      ps.setString(1, dcPlanBo);
      ps.setString(2, customerItemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewDcResultDetail selectByPK(String dcResultBo, String customerItemBo)
      throws SQLException {
    ViewDcResultDetail result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE dc_result_bo=? AND customer_item_bo=?")) {
      ps.setString(1, dcResultBo);
      ps.setString(2, customerItemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ViewDcResultDetail convert(ResultSet rs) throws SQLException {
    ViewDcResultDetail data = new ViewDcResultDetail();

    int index = 1;
    data.setDcResultBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setDieCount(rs.getInt(index++));
    data.setDcCount(rs.getInt(index++));
    data.setStateName(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setDcPlanBo(rs.getString(index++));
    data.setDcopBo(rs.getString(index++));
    data.setDptNo(rs.getString(index++));
    data.setCustomerItemName(rs.getString(index++));

    return data;
  }
}
