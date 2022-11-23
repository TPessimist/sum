package ame.psb.db.dao;

import ame.psb.db.SamplingResultDetail;
import ame.psb.db.ViewSamplingResultDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class SamplingResultDetailDao {

  private static final String SQL_INS = "INSERT INTO zr_sampling_result_detail(id,sampling_result_bo,customer_item_bo,position,status) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_sampling_result_detail SET sampling_result_bo=?,customer_item_bo=?,position=?,status=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sampling_result_bo,customer_item_bo,position,status FROM view_sampling_result_detail ";

  private final Connection conn;

  public SamplingResultDetailDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SamplingResultDetail data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSamplingResultBo());
      ps.setString(3, data.getCustomerItemBo());
      if (data.getPosition() != null && data.getPosition() > 0) {
        ps.setInt(4, data.getPosition());
      } else {
        ps.setNull(4, Types.INTEGER);
      }
      ps.setString(5, data.getStatus());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SamplingResultDetail> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SamplingResultDetail data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSamplingResultBo());
        ps.setString(3, data.getCustomerItemBo());
        if (data.getPosition() != null && data.getPosition() > 0) {
          ps.setInt(4, data.getPosition());
        } else {
          ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, data.getStatus());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SamplingResultDetail data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSamplingResultBo());
      ps.setString(2, data.getCustomerItemBo());
      ps.setInt(3, data.getPosition());
      ps.setString(4, data.getStatus());
      ps.setString(5, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<SamplingResultDetail> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SamplingResultDetail data : dataList) {
        ps.setString(1, data.getSamplingResultBo());
        ps.setString(2, data.getCustomerItemBo());
        if (data.getPosition() != null && data.getPosition() > 0) {
          ps.setInt(4, data.getPosition());
        } else {
          ps.setNull(4, Types.INTEGER);
        }
        ps.setString(4, data.getStatus());
        ps.setString(5, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int expire(String samplingResultBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_sampling_result_detail SET status='EXPIRED' WHERE sampling_result_bo = ?  AND status='WAIT'")) {
      ps.setString(1, samplingResultBo);
      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_sampling_result_detail WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<SamplingResultDetail> selectAll() throws SQLException {
    ArrayList<SamplingResultDetail> result = new ArrayList<SamplingResultDetail>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewSamplingResultDetail selectByPK(String id) throws SQLException {
    ViewSamplingResultDetail result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewSamplingResultDetail> selectBySamplingResult(String samplingResultBo)
      throws SQLException {
    ArrayList<ViewSamplingResultDetail> result = new ArrayList<ViewSamplingResultDetail>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sampling_result_bo=?")) {
      ps.setString(1, samplingResultBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  /*
   * cc
   * */
  public ViewSamplingResultDetail selectBySampBoAndCustomerItemBo(String samplingResultBo,
      String customerItemBo)
      throws SQLException {
    ViewSamplingResultDetail result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE sampling_result_bo=? and customer_item_bo=? and status='WAIT' ")) {
      ps.setString(1, samplingResultBo);
      ps.setString(2, customerItemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ViewSamplingResultDetail convert(ResultSet rs) throws SQLException {
    ViewSamplingResultDetail data = new ViewSamplingResultDetail();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSamplingResultBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setPosition(rs.getInt(index++));
    data.setStatus(rs.getString(index++));

    return data;
  }
}