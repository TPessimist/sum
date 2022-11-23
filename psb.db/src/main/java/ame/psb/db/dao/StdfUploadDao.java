package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.StdfUpload;
import uia.utils.dao.DateUtils;

public class StdfUploadDao {

  private static final String SQL_INS = "INSERT INTO zr_stdf_upload(id,file_path,state_name,created_time,processed_time,binmap_bo,operation_bo,sfc_bo,wafer_bo,device_bo,cust_lot_id,cust_wafer_id,cust_device_id,gross_die,rows,cols,notch,package_bo,share_folder,probe_resource_bo,test_resource_bo,report_id,stdf_lot_id,stdf_sub_lot_id,check_sum,file_type,prober_card,tsk_result) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_stdf_upload SET file_path=?,state_name=?,created_time=?,processed_time=?,binmap_bo=?,operation_bo=?,sfc_bo=?,wafer_bo=?,device_bo=?,cust_lot_id=?,cust_wafer_id=?,cust_device_id=?,gross_die=?,rows=?,cols=?,notch=?,package_bo=?,share_folder=?,probe_resource_bo=?,test_resource_bo=?,report_id=?,stdf_lot_id=?,stdf_sub_lot_id=?,check_sum=?,file_type=?,prober_card=?,tsk_result=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,file_path,state_name,created_time,processed_time,binmap_bo,operation_bo,sfc_bo,wafer_bo,device_bo,cust_lot_id,cust_wafer_id,cust_device_id,gross_die,rows,cols,notch,package_bo,share_folder,probe_resource_bo,test_resource_bo,report_id,stdf_lot_id,stdf_sub_lot_id,check_sum,file_type,prober_card,tsk_result FROM zr_stdf_upload ";

  private final Connection conn;

  public StdfUploadDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(StdfUpload data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getFilePath());
      ps.setString(3, data.getStateName());
      DateUtils.setDateTz(ps, 4, data.getCreatedTime());
      DateUtils.setDateTz(ps, 5, data.getProcessedTime());
      ps.setString(6, data.getBinmapBo());
      ps.setString(7, data.getOperationBo());
      ps.setString(8, data.getSfcBo());
      ps.setString(9, data.getWaferBo());
      ps.setString(10, data.getDeviceBo());
      ps.setString(11, data.getCustLotId());
      ps.setString(12, data.getCustWaferId());
      ps.setString(13, data.getCustDeviceId());
      ps.setInt(14, data.getGrossDie());
      ps.setInt(15, data.getRows());
      ps.setInt(16, data.getCols());
      ps.setString(17, data.getNotch());
      ps.setString(18, data.getPackageBo());
      ps.setString(19, data.getShareFolder());
      ps.setString(20, data.getProbeResourceBo());
      ps.setString(21, data.getTestResourceBo());
      ps.setString(22, data.getReportId());
      ps.setString(23, data.getStdfLotId());
      ps.setString(24, data.getStdfSubLotId());
      ps.setString(25, data.getCheckSum());
      ps.setString(26, data.getFileType());
      ps.setString(27, data.getProberCard());
      ps.setString(28, data.getTskResult());

      return ps.executeUpdate();
    }
  }

  public int insert(List<StdfUpload> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (StdfUpload data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getFilePath());
        ps.setString(3, data.getStateName());
        DateUtils.setDateTz(ps, 4, data.getCreatedTime());
        DateUtils.setDateTz(ps, 5, data.getProcessedTime());
        ps.setString(6, data.getBinmapBo());
        ps.setString(7, data.getOperationBo());
        ps.setString(8, data.getSfcBo());
        ps.setString(9, data.getWaferBo());
        ps.setString(10, data.getDeviceBo());
        ps.setString(11, data.getCustLotId());
        ps.setString(12, data.getCustWaferId());
        ps.setString(13, data.getCustDeviceId());
        ps.setInt(14, data.getGrossDie());
        ps.setInt(15, data.getRows());
        ps.setInt(16, data.getCols());
        ps.setString(17, data.getNotch());
        ps.setString(18, data.getPackageBo());
        ps.setString(19, data.getShareFolder());
        ps.setString(20, data.getProbeResourceBo());
        ps.setString(21, data.getTestResourceBo());
        ps.setString(22, data.getReportId());
        ps.setString(23, data.getStdfLotId());
        ps.setString(24, data.getStdfSubLotId());
        ps.setString(25, data.getCheckSum());
        ps.setString(26, data.getFileType());
        ps.setString(27, data.getProberCard());
        ps.setString(28, data.getTskResult());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(StdfUpload data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFilePath());
      ps.setString(2, data.getStateName());
      DateUtils.setDateTz(ps, 3, data.getCreatedTime());
      DateUtils.setDateTz(ps, 4, data.getProcessedTime());
      ps.setString(5, data.getBinmapBo());
      ps.setString(6, data.getOperationBo());
      ps.setString(7, data.getSfcBo());
      ps.setString(8, data.getWaferBo());
      ps.setString(9, data.getDeviceBo());
      ps.setString(10, data.getCustLotId());
      ps.setString(11, data.getCustWaferId());
      ps.setString(12, data.getCustDeviceId());
      ps.setInt(13, data.getGrossDie());
      ps.setInt(14, data.getRows());
      ps.setInt(15, data.getCols());
      ps.setString(16, data.getNotch());
      ps.setString(17, data.getPackageBo());
      ps.setString(18, data.getShareFolder());
      ps.setString(19, data.getProbeResourceBo());
      ps.setString(20, data.getTestResourceBo());
      ps.setString(21, data.getReportId());
      ps.setString(22, data.getStdfLotId());
      ps.setString(23, data.getStdfSubLotId());
      ps.setString(24, data.getCheckSum());
      ps.setString(25, data.getFileType());
      ps.setString(26, data.getProberCard());
      ps.setString(27, data.getTskResult());
      ps.setString(28, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<StdfUpload> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (StdfUpload data : dataList) {
        ps.setString(1, data.getFilePath());
        ps.setString(2, data.getStateName());
        DateUtils.setDateTz(ps, 3, data.getCreatedTime());
        DateUtils.setDateTz(ps, 4, data.getProcessedTime());
        ps.setString(5, data.getBinmapBo());
        ps.setString(6, data.getOperationBo());
        ps.setString(7, data.getSfcBo());
        ps.setString(8, data.getWaferBo());
        ps.setString(9, data.getDeviceBo());
        ps.setString(10, data.getCustLotId());
        ps.setString(11, data.getCustWaferId());
        ps.setString(12, data.getCustDeviceId());
        ps.setInt(13, data.getGrossDie());
        ps.setInt(14, data.getRows());
        ps.setInt(15, data.getCols());
        ps.setString(16, data.getNotch());
        ps.setString(17, data.getPackageBo());
        ps.setString(18, data.getShareFolder());
        ps.setString(19, data.getProbeResourceBo());
        ps.setString(20, data.getTestResourceBo());
        ps.setString(21, data.getReportId());
        ps.setString(22, data.getStdfLotId());
        ps.setString(23, data.getStdfSubLotId());
        ps.setString(24, data.getCheckSum());
        ps.setString(25, data.getFileType());
        ps.setString(26, data.getProberCard());
        ps.setString(27, data.getTskResult());
        ps.setString(28, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateGrossDie(int grossDie, String id)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE ZR_STDF_UPLOAD SET GROSS_DIE = ?,STATE_NAME = 'UPLOAD' WHERE id = ?")) {
      ps.setInt(1, grossDie);
      ps.setString(2, id);

      return ps.executeUpdate();
    }
  }

  public int updateProberCard(String proberCard, String id)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE ZR_STDF_UPLOAD SET PROBER_CARD = ? WHERE id = ?")) {
      ps.setString(1, proberCard);
      ps.setString(2, id);

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_stdf_upload WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int delete(String operationBo, String filePath, String waferBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "DELETE FROM zr_stdf_upload WHERE operation_bo=? AND file_path=? AND wafer_bo=?")) {
      ps.setString(1, operationBo);
      ps.setString(2, filePath);
      ps.setString(3, waferBo);

      return ps.executeUpdate();
    }
  }

  public List<StdfUpload> selectAll() throws SQLException {
    ArrayList<StdfUpload> result = new ArrayList<StdfUpload>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public StdfUpload selectByPK(String id) throws SQLException {
    StdfUpload result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<StdfUpload> selectGrossDie(String customerItemBo, String operationBo)
      throws SQLException {
    ArrayList<StdfUpload> result = new ArrayList<StdfUpload>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE WAFER_BO = ? AND OPERATION_BO = ?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public StdfUpload selectTestData(String customerItemBo, String operationBo, String filePath)
      throws SQLException {
    StdfUpload result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE WAFER_BO = ? AND OPERATION_BO = ? AND FILE_PATH = ? ")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, operationBo);
      ps.setString(3, filePath);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private StdfUpload convert(ResultSet rs) throws SQLException {
    StdfUpload data = new StdfUpload();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setFilePath(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));
    data.setProcessedTime(DateUtils.getDateTz(rs, index++));
    data.setBinmapBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setWaferBo(rs.getString(index++));
    data.setDeviceBo(rs.getString(index++));
    data.setCustLotId(rs.getString(index++));
    data.setCustWaferId(rs.getString(index++));
    data.setCustDeviceId(rs.getString(index++));
    data.setGrossDie(rs.getInt(index++));
    data.setRows(rs.getInt(index++));
    data.setCols(rs.getInt(index++));
    data.setNotch(rs.getString(index++));
    data.setPackageBo(rs.getString(index++));
    data.setShareFolder(rs.getString(index++));
    data.setProbeResourceBo(rs.getString(index++));
    data.setTestResourceBo(rs.getString(index++));
    data.setReportId(rs.getString(index++));
    data.setStdfLotId(rs.getString(index++));
    data.setStdfSubLotId(rs.getString(index++));
    data.setCheckSum(rs.getString(index++));
    data.setFileType(rs.getString(index++));
    data.setProberCard(rs.getString(index++));
    data.setTskResult(rs.getString(index++));

    return data;
  }
}
