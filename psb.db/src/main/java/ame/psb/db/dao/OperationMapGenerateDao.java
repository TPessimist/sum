package ame.psb.db.dao;

import ame.psb.db.OperationMapGenerate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class OperationMapGenerateDao {

  private static final String SQL_INS = "INSERT INTO zr_operation_map_generate(id,type,operation_bo,sfc_bo,customer_item_bo,file_name,updated_user,updated_date_time,mark_file_name,changed_dies,die_mark_modified,mark_modified_time,mark_user,repeat_map_check,slot_check,map_check,stdf_check,resource_name) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_operation_map_generate SET type=?,operation_bo=?,sfc_bo=?,customer_item_bo=?,file_name=?,updated_user=?,updated_date_time=?,mark_file_name=?,changed_dies=?,die_mark_modified=?,mark_modified_time=?,mark_user=?,repeat_map_check=?,slot_check=?,map_check=?,stdf_check=?,resource_name=? WHERE id=?";

  private static final String SQL_UPD_STDF = "UPDATE zr_operation_map_generate SET stdf_check=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,type,operation_bo,sfc_bo,customer_item_bo,file_name,updated_user,updated_date_time,mark_file_name,changed_dies,die_mark_modified,mark_modified_time,mark_user,repeat_map_check,slot_check,map_check,stdf_check,resource_name FROM zr_operation_map_generate ";

  private static final String SQL_SEL_GC_NEED = "SELECT id,type,operation_bo,sfc_bo,customer_item_bo,file_name,updated_user,updated_date_time,mark_file_name,changed_dies,die_mark_modified,mark_modified_time,mark_user,repeat_map_check,slot_check,map_check,stdf_check,resource_name FROM zr_operation_map_generate ";


  private final Connection conn;

  public OperationMapGenerateDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(OperationMapGenerate data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getType());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getCustomerItemBo());
      ps.setString(6, data.getFileName());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedDateTime());
      ps.setString(9, data.getMarkFileName());
      ps.setString(10, data.getChangedDies());
      ps.setString(11, data.getDieMarkModified());
      DateUtils.setDateTz(ps, 12, data.getMarkModifiedTime());
      ps.setString(13, data.getMarkUser());
      ps.setString(14, data.getRepeatMapCheck());
      ps.setString(15, data.getSlotCheck());
      ps.setString(16, data.getMapCheck());
      ps.setString(17, data.getStdfCheck());
      ps.setString(18, data.getResourceName());
      return ps.executeUpdate();
    }
  }

  public int insert(List<OperationMapGenerate> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (OperationMapGenerate data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getType());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getCustomerItemBo());
        ps.setString(6, data.getFileName());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedDateTime());
        ps.setString(9, data.getMarkFileName());
        ps.setString(10, data.getChangedDies());
        ps.setString(11, data.getDieMarkModified());
        DateUtils.setDateTz(ps, 12, data.getMarkModifiedTime());
        ps.setString(13, data.getMarkUser());
        ps.setString(14, data.getRepeatMapCheck());
        ps.setString(15, data.getSlotCheck());
        ps.setString(16, data.getMapCheck());
        ps.setString(17, data.getStdfCheck());
        ps.setString(18, data.getResourceName());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(OperationMapGenerate data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getType());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getCustomerItemBo());
      ps.setString(5, data.getFileName());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedDateTime());
      ps.setString(8, data.getMarkFileName());
      ps.setString(9, data.getChangedDies());
      ps.setString(10, data.getDieMarkModified());
      DateUtils.setDateTz(ps, 11, data.getMarkModifiedTime());
      ps.setString(12, data.getMarkUser());
      ps.setString(13, data.getRepeatMapCheck());
      ps.setString(14, data.getSlotCheck());
      ps.setString(15, data.getMapCheck());
      ps.setString(16, data.getStdfCheck());
      ps.setString(17, data.getResourceName());
      ps.setString(18, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(String id, String stdfCheck) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_STDF)) {
      ps.setString(1, stdfCheck);
      ps.setString(2, id);
      return ps.executeUpdate();
    }
  }

  public int update(List<OperationMapGenerate> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (OperationMapGenerate data : dataList) {
        ps.setString(1, data.getType());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getCustomerItemBo());
        ps.setString(5, data.getFileName());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedDateTime());
        ps.setString(8, data.getMarkFileName());
        ps.setString(9, data.getChangedDies());
        ps.setString(10, data.getDieMarkModified());
        DateUtils.setDateTz(ps, 11, data.getMarkModifiedTime());
        ps.setString(12, data.getMarkUser());
        ps.setString(13, data.getRepeatMapCheck());
        ps.setString(14, data.getSlotCheck());
        ps.setString(15, data.getMapCheck());
        ps.setString(16, data.getStdfCheck());
        ps.setString(17, data.getResourceName());
        ps.setString(18, data.getId());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_operation_map_generate WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int delete(String customerItemBo, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "DELETE FROM zr_operation_map_generate WHERE CUSTOMER_ITEM_BO=? AND OPERATION_BO=? ")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);

      return ps.executeUpdate();
    }
  }

  public List<OperationMapGenerate> select(String sfcBo, String operationBo) throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND operation_bo=? AND type = 'O' ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<OperationMapGenerate> selectByStdfSfc(String sfcBo) throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND STDF_CHECK in('1','2') AND type = 'O' ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OperationMapGenerate> selectByStdfWafer(String customerItemBo) throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE CUSTOMER_ITEM_BO=? AND STDF_CHECK in('1','2') AND type = 'O' ")) {
      ps.setString(1, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OperationMapGenerate> selectByLot(String waferLotNo, String operationBo)
      throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE customer_item_bo like ? AND operation_bo=? AND type = 'O' ")) {
      ps.setString(1, waferLotNo + "%");
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OperationMapGenerate> selectBackMap(String sfcBo, String operationBo)
      throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND operation_bo=? AND type = 'B' ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OperationMapGenerate> selectStdfCheckMap() throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE stdf_check in('9') AND type = 'O' ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OperationMapGenerate> selectCsvCheckMap() throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE stdf_check in('8') AND type = 'O' ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OperationMapGenerate> selectByLimited(Date start, Date end) throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE type = 'O' AND UPDATED_DATE_TIME between ? and ? ORDER BY UPDATED_DATE_TIME")) {
      DateUtils.setDateTz(ps, 1, start);
      DateUtils.setDateTz(ps, 2, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OperationMapGenerate> selectByCPLimited(Date start, Date end, String customer)
      throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE type = 'O' " +
            "  AND exists(SELECT 1 " +
            "               FROM view_sfc_item v " +
            "              WHERE v.id = CUSTOMER_ITEM_BO " +
            "                AND v.CUSTOMER = ? ) " +
            " AND OPERATION_BO = 'OperationBO:1020,WCP-TEST,#' AND UPDATED_DATE_TIME between ? and ? ORDER BY UPDATED_DATE_TIME")) {
      ps.setString(1, customer);
      DateUtils.setDateTz(ps, 2, start);
      DateUtils.setDateTz(ps, 3, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OperationMapGenerate> selectByStdfLimited() throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE type = 'O' " +
            "  AND exists(SELECT 1 " +
            "               FROM view_sfc_item v " +
            "              WHERE v.id = CUSTOMER_ITEM_BO " +
            "                AND v.CUSTOMER = ? ) " +
            " AND OPERATION_BO = 'OperationBO:1020,WCP-TEST,#' AND UPDATED_DATE_TIME between ? and ? ORDER BY UPDATED_DATE_TIME")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OperationMapGenerate> selectByWaferOperation(String customerItemBo,
      String operationBo)
      throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE customer_item_bo=? AND operation_bo=? AND type = 'O' ")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OperationMapGenerate> selectByLikeWaferOperation(String waferId, String operationBo)
      throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE customer_item_bo like ? AND operation_bo=? AND type = 'O' ")) {
      ps.setString(1, waferId + "%");
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public OperationMapGenerate selectByFirstWaferOperation(String customerItemBo, String operationBo)
      throws SQLException {
    OperationMapGenerate result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE customer_item_bo=? AND operation_bo=? AND type = 'B' ")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<OperationMapGenerate> selectByWaferOperation2(String customerItemBo,
      String operationBo)
      throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? AND operation_bo=? ")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OperationMapGenerate> selectAfterMoveInByWaferOperation(String customerItemBo,
      String operationBo,
      Date moveInTime) throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE customer_item_bo=? AND operation_bo=? AND updated_date_time>? AND type = 'O' ")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);
      DateUtils.setDateTz(ps, 3, moveInTime);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OperationMapGenerate> selectByWaferId(String customerItemBo) throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? AND type <> 'B' ")) {
      ps.setString(1, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OperationMapGenerate> selectByWaferIdFirstTime(String customerItemBo)
      throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE customer_item_bo=? AND type = 'O' ORDER BY UPDATED_DATE_TIME asc LIMIT 1")) {
      ps.setString(1, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OperationMapGenerate> selectIncomingByWaferId(String customerItemBo)
      throws SQLException {
    ArrayList<OperationMapGenerate> result = new ArrayList<OperationMapGenerate>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? and type = 'I' ")) {
      ps.setString(1, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public OperationMapGenerate selectByPK(String id) throws SQLException {
    OperationMapGenerate result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private OperationMapGenerate convert(ResultSet rs) throws SQLException {
    OperationMapGenerate data = new OperationMapGenerate();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setType(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setFileName(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setMarkFileName(rs.getString(index++));
    data.setChangedDies(rs.getString(index++));
    data.setDieMarkModified(rs.getString(index++));
    data.setMarkModifiedTime(DateUtils.getDateTz(rs, index++));
    data.setMarkUser(rs.getString(index++));
    data.setRepeatMapCheck(rs.getString(index++));
    data.setSlotCheck(rs.getString(index++));
    data.setMapCheck(rs.getString(index++));
    data.setStdfCheck(rs.getString(index++));
    data.setResourceName(rs.getString(index++));
    return data;
  }
}
