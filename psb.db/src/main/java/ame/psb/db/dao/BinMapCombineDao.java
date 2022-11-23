package ame.psb.db.dao;

import ame.psb.db.BinMapCombine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class BinMapCombineDao {

  private static final String SQL_INS = "INSERT INTO zr_binmap_combine(id,prod_map_def_bo,sfc_bo,operation_bo,customer_item_bo,incoming_map_rule_bo,golden_map_rule_bo,cp_map_rule_bo,out_going_map_rule_bo,combined,yield,die_qty,defect_qty,die_grade_modified,golden_map_path,out_going_map_path,changed_dies,updated_user,updated_date_time,output_flag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_binmap_combine SET prod_map_def_bo=?,sfc_bo=?,operation_bo=?,customer_item_bo=?,incoming_map_rule_bo=?,golden_map_rule_bo=?,cp_map_rule_bo=?,out_going_map_rule_bo=?,combined=?,yield=?,die_qty=?,defect_qty=?,die_grade_modified=?,golden_map_path=?,out_going_map_path=?,changed_dies=?,updated_user=?,updated_date_time=?,output_flag=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,prod_map_def_bo,sfc_bo,operation_bo,customer_item_bo,incoming_map_rule_bo,golden_map_rule_bo,cp_map_rule_bo,out_going_map_rule_bo,combined,yield,die_qty,defect_qty,die_grade_modified,golden_map_path,out_going_map_path,changed_dies,updated_user,updated_date_time,output_flag FROM zr_binmap_combine ";

  private final Connection conn;

  public BinMapCombineDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BinMapCombine data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getProdMapDefBo());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getCustomerItemBo());
      ps.setString(6, data.getIncomingMapRuleBo());
      ps.setString(7, data.getGoldenMapRuleBo());
      ps.setString(8, data.getCpMapRuleBo());
      ps.setString(9, data.getOutGoingMapRuleBo());
      ps.setString(10, data.getCombined());
      ps.setBigDecimal(11, data.getYield());
      ps.setInt(12, data.getDieQty());
      ps.setInt(13, data.getDefectQty());
      ps.setString(14, data.getDieGradeModified());
      ps.setString(15, data.getGoldenMapPath());
      ps.setString(16, data.getOutGoingMapPath());
      ps.setString(17, data.getChangedDies());
      ps.setString(18, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 19, data.getUpdatedDateTime());
      ps.setBoolean(20, data.getOutputFlag());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BinMapCombine> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BinMapCombine data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getProdMapDefBo());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getCustomerItemBo());
        ps.setString(6, data.getIncomingMapRuleBo());
        ps.setString(7, data.getGoldenMapRuleBo());
        ps.setString(8, data.getCpMapRuleBo());
        ps.setString(9, data.getOutGoingMapRuleBo());
        ps.setString(10, data.getCombined());
        ps.setBigDecimal(11, data.getYield());
        ps.setInt(12, data.getDieQty());
        ps.setInt(13, data.getDefectQty());
        ps.setString(14, data.getDieGradeModified());
        ps.setString(15, data.getGoldenMapPath());
        ps.setString(16, data.getOutGoingMapPath());
        ps.setString(17, data.getChangedDies());
        ps.setString(18, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 19, data.getUpdatedDateTime());
        ps.setBoolean(20, data.getOutputFlag());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BinMapCombine data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getProdMapDefBo());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getCustomerItemBo());
      ps.setString(5, data.getIncomingMapRuleBo());
      ps.setString(6, data.getGoldenMapRuleBo());
      ps.setString(7, data.getCpMapRuleBo());
      ps.setString(8, data.getOutGoingMapRuleBo());
      ps.setString(9, data.getCombined());
      ps.setBigDecimal(10, data.getYield());
      ps.setInt(11, data.getDieQty());
      ps.setInt(12, data.getDefectQty());
      ps.setString(13, data.getDieGradeModified());
      ps.setString(14, data.getGoldenMapPath());
      ps.setString(15, data.getOutGoingMapPath());
      ps.setString(16, data.getChangedDies());
      ps.setString(17, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 18, data.getUpdatedDateTime());
      ps.setBoolean(19, data.getOutputFlag());
      ps.setString(20, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<BinMapCombine> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BinMapCombine data : dataList) {
        ps.setString(1, data.getProdMapDefBo());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getCustomerItemBo());
        ps.setString(5, data.getIncomingMapRuleBo());
        ps.setString(6, data.getGoldenMapRuleBo());
        ps.setString(7, data.getCpMapRuleBo());
        ps.setString(8, data.getOutGoingMapRuleBo());
        ps.setString(9, data.getCombined());
        ps.setBigDecimal(10, data.getYield());
        ps.setInt(11, data.getDieQty());
        ps.setInt(12, data.getDefectQty());
        ps.setString(13, data.getDieGradeModified());
        ps.setString(14, data.getGoldenMapPath());
        ps.setString(15, data.getOutGoingMapPath());
        ps.setString(16, data.getChangedDies());
        ps.setString(17, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 18, data.getUpdatedDateTime());
        ps.setBoolean(19, data.getOutputFlag());
        ps.setString(20, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_binmap_combine WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<BinMapCombine> selectAll() throws SQLException {
    ArrayList<BinMapCombine> result = new ArrayList<BinMapCombine>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<BinMapCombine> selectNotOutput() throws SQLException {
    ArrayList<BinMapCombine> result = new ArrayList<BinMapCombine>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE out_going_map_path is not null and output_flag = false and combined = 'Y' and OPERATION_BO != 'OperationBO:1020,BFI-MAP,#' ORDER BY CUSTOMER_ITEM_BO asc ")) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<BinMapCombine> select68NotOutput() throws SQLException {
    ArrayList<BinMapCombine> result = new ArrayList<BinMapCombine>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE out_going_map_path is not null " +
            "   and output_flag = false " +
            "   and combined = 'Y' " +
            "   AND CUSTOMER_ITEM_BO in(SELECT v.ID " +
            "                             FROM view_sfc_item v " +
            "                       INNER JOIN ZD_LOOKUP z " +
            "                          ON z.id = 'CUSTOMER_68' " +
            "                         AND z.value = v.CUSTOMER  ) " +
            "   and OPERATION_BO = 'OperationBO:1020,BFI-MAP,#' " +
            " ORDER BY UPDATED_DATE_TIME asc ")) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public BinMapCombine selectByPK(String id) throws SQLException {
    BinMapCombine result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  @Deprecated
  public List<BinMapCombine> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<BinMapCombine> result = new ArrayList<BinMapCombine>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<BinMapCombine> selectByWafer(String customerItemBo) throws SQLException {
    ArrayList<BinMapCombine> result = new ArrayList<BinMapCombine>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? order by updated_date_time desc ")) {
      ps.setString(1, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<BinMapCombine> selectCombineByWafer(String customerItemBo) throws SQLException {
    ArrayList<BinMapCombine> result = new ArrayList<BinMapCombine>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE customer_item_bo=? and out_going_map_path is not null and combined = 'Y' ")) {
      ps.setString(1, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<BinMapCombine> selectByDevice() throws SQLException {
    ArrayList<BinMapCombine> result = new ArrayList<BinMapCombine>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE OPERATION_BO = 'OperationBO:1020,BFI-MAP,#' " +
            "   AND CUSTOMER_ITEM_BO in(SELECT v.id " +
            "                             FROM view_sfc_item v " +
            "                            WHERE v.device_name in('XJX00208B','XJX002B8B','XJX002C8B')) ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  @Deprecated
  public BinMapCombine select(String sfcBo, String operationBo, String customerItemBo)
      throws SQLException {
    BinMapCombine result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND operation_bo=?  AND customer_item_bo=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);
      ps.setString(3, customerItemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public BinMapCombine select(String operationBo, String customerItemBo) throws SQLException {
    BinMapCombine result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE operation_bo=?  AND customer_item_bo=?")) {

      ps.setString(1, operationBo);
      ps.setString(2, customerItemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private BinMapCombine convert(ResultSet rs) throws SQLException {
    BinMapCombine data = new BinMapCombine();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setProdMapDefBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setIncomingMapRuleBo(rs.getString(index++));
    data.setGoldenMapRuleBo(rs.getString(index++));
    data.setCpMapRuleBo(rs.getString(index++));
    data.setOutGoingMapRuleBo(rs.getString(index++));
    data.setCombined(rs.getString(index++));
    data.setYield(rs.getBigDecimal(index++));
    data.setDieQty(rs.getInt(index++));
    data.setDefectQty(rs.getInt(index++));
    data.setDieGradeModified(rs.getString(index++));
    data.setGoldenMapPath(rs.getString(index++));
    data.setOutGoingMapPath(rs.getString(index++));
    data.setChangedDies(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setOutputFlag(rs.getBoolean(index++));
    return data;
  }
}
