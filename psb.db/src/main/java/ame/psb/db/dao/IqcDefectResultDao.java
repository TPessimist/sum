package ame.psb.db.dao;

import ame.psb.db.IqcDefectResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class IqcDefectResultDao {

  private static final String SQL_INS = "INSERT INTO zr_iqc_defect_result(id,sfc_bo,appearance_category,appearance_wafer_list,appearance_result,micro_category,micro_wafer_list,micro_result,qty_category,bad_die_qty,total_die_qty,bad_die_yield,qty_wafer_list,qty_result,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_iqc_defect_result SET sfc_bo=?,appearance_category=?,appearance_wafer_list=?,appearance_result=?,micro_category=?,micro_wafer_list=?,micro_result=?,qty_category=?,bad_die_qty=?,total_die_qty=?,bad_die_yield=?,qty_wafer_list=?,qty_result=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sfc_bo,appearance_category,appearance_wafer_list,appearance_result,micro_category,micro_wafer_list,micro_result,qty_category,bad_die_qty,total_die_qty,bad_die_yield,qty_wafer_list,qty_result,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_iqc_defect_result ";

  private final Connection conn;

  public IqcDefectResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(IqcDefectResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getAppearanceCategory());
      ps.setString(4, data.getAppearanceWaferList());
      ps.setString(5, data.getAppearanceResult());
      ps.setString(6, data.getMicroCategory());
      ps.setString(7, data.getMicroWaferList());
      ps.setString(8, data.getMicroResult());
      ps.setString(9, data.getQtyCategory());
      ps.setBigDecimal(10, data.getBadDieQty());
      ps.setBigDecimal(11, data.getTotalDieQty());
      ps.setBigDecimal(12, data.getBadDieYield());
      ps.setString(13, data.getQtyWaferList());
      ps.setString(14, data.getQtyResult());
      ps.setString(15, data.getReversedField1());
      ps.setString(16, data.getReversedField2());
      ps.setString(17, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 18, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<IqcDefectResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (IqcDefectResult data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getAppearanceCategory());
        ps.setString(4, data.getAppearanceWaferList());
        ps.setString(5, data.getAppearanceResult());
        ps.setString(6, data.getMicroCategory());
        ps.setString(7, data.getMicroWaferList());
        ps.setString(8, data.getMicroResult());
        ps.setString(9, data.getQtyCategory());
        ps.setBigDecimal(10, data.getBadDieQty());
        ps.setBigDecimal(11, data.getTotalDieQty());
        ps.setBigDecimal(12, data.getBadDieYield());
        ps.setString(13, data.getQtyWaferList());
        ps.setString(14, data.getQtyResult());
        ps.setString(15, data.getReversedField1());
        ps.setString(16, data.getReversedField2());
        ps.setString(17, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 18, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(IqcDefectResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getAppearanceCategory());
      ps.setString(3, data.getAppearanceWaferList());
      ps.setString(4, data.getAppearanceResult());
      ps.setString(5, data.getMicroCategory());
      ps.setString(6, data.getMicroWaferList());
      ps.setString(7, data.getMicroResult());
      ps.setString(8, data.getQtyCategory());
      ps.setBigDecimal(9, data.getBadDieQty());
      ps.setBigDecimal(10, data.getTotalDieQty());
      ps.setBigDecimal(11, data.getBadDieYield());
      ps.setString(12, data.getQtyWaferList());
      ps.setString(13, data.getQtyResult());
      ps.setString(14, data.getReversedField1());
      ps.setString(15, data.getReversedField2());
      ps.setString(16, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 17, data.getUpdatedTime());
      ps.setString(18, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<IqcDefectResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (IqcDefectResult data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getAppearanceCategory());
        ps.setString(3, data.getAppearanceWaferList());
        ps.setString(4, data.getAppearanceResult());
        ps.setString(5, data.getMicroCategory());
        ps.setString(6, data.getMicroWaferList());
        ps.setString(7, data.getMicroResult());
        ps.setString(8, data.getQtyCategory());
        ps.setBigDecimal(9, data.getBadDieQty());
        ps.setBigDecimal(10, data.getTotalDieQty());
        ps.setBigDecimal(11, data.getBadDieYield());
        ps.setString(12, data.getQtyWaferList());
        ps.setString(13, data.getQtyResult());
        ps.setString(14, data.getReversedField1());
        ps.setString(15, data.getReversedField2());
        ps.setString(16, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 17, data.getUpdatedTime());
        ps.setString(18, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_iqc_defect_result WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<IqcDefectResult> selectAll() throws SQLException {
    ArrayList<IqcDefectResult> result = new ArrayList<IqcDefectResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<IqcDefectResult> selectBySfcBo(String sfcBo) throws SQLException {
    ArrayList<IqcDefectResult> result = new ArrayList<IqcDefectResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where sfc_bo = ? ")) {
      ps.setString(1, sfcBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public IqcDefectResult selectBySfcBoDesc(String sfcBo) throws SQLException {
    IqcDefectResult result = new IqcDefectResult();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where sfc_bo = ? ORDER BY updated_time DESC ")) {
      ps.setString(1, sfcBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public IqcDefectResult selectByPK(String id) throws SQLException {
    IqcDefectResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private IqcDefectResult convert(ResultSet rs) throws SQLException {
    IqcDefectResult data = new IqcDefectResult();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setAppearanceCategory(rs.getString(index++));
    data.setAppearanceWaferList(rs.getString(index++));
    data.setAppearanceResult(rs.getString(index++));
    data.setMicroCategory(rs.getString(index++));
    data.setMicroWaferList(rs.getString(index++));
    data.setMicroResult(rs.getString(index++));
    data.setQtyCategory(rs.getString(index++));
    data.setBadDieQty(rs.getBigDecimal(index++));
    data.setTotalDieQty(rs.getBigDecimal(index++));
    data.setBadDieYield(rs.getBigDecimal(index++));
    data.setQtyWaferList(rs.getString(index++));
    data.setQtyResult(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
