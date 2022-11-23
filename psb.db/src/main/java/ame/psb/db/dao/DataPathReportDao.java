package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.DataPathReport;
import uia.utils.dao.DateUtils;

public class DataPathReportDao {

  private static final String SQL_INS = "INSERT INTO zr_data_path_report(id,file_path,nums,operation_bo,sfc_bo,wafer_bo,state_name,created_time,created_user, file_type) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_data_path_report SET file_path=?,nums=?,operation_bo=?,sfc_bo=?,wafer_bo=?,state_name=?,created_time=?,created_user=?,file_type=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,file_path,nums,operation_bo,sfc_bo,wafer_bo,state_name,created_time,created_user,file_type FROM zr_data_path_report ";

  private final Connection conn;

  public DataPathReportDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DataPathReport data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getFilePath());
      ps.setString(3, data.getNums());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getSfcBo());
      ps.setString(6, data.getWaferBo());
      ps.setString(7, data.getStateName());
      DateUtils.setDateTz(ps, 8, data.getCreatedTime());
      ps.setString(9, data.getCreatedUser());
      ps.setString(10, data.getFileType());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DataPathReport> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DataPathReport data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getFilePath());
        ps.setString(3, data.getNums());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getSfcBo());
        ps.setString(6, data.getWaferBo());
        ps.setString(7, data.getStateName());
        DateUtils.setDateTz(ps, 8, data.getCreatedTime());
        ps.setString(9, data.getCreatedUser());
        ps.setString(10, data.getFileType());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DataPathReport data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFilePath());
      ps.setString(2, data.getNums());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getSfcBo());
      ps.setString(5, data.getWaferBo());
      ps.setString(6, data.getStateName());
      DateUtils.setDateTz(ps, 7, data.getCreatedTime());
      ps.setString(8, data.getCreatedUser());
      ps.setString(9, data.getFileType());
      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<DataPathReport> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DataPathReport data : dataList) {
        ps.setString(1, data.getFilePath());
        ps.setString(2, data.getNums());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getSfcBo());
        ps.setString(5, data.getWaferBo());
        ps.setString(6, data.getStateName());
        DateUtils.setDateTz(ps, 7, data.getCreatedTime());
        ps.setString(8, data.getCreatedUser());
        ps.setString(9, data.getFileType());
        ps.setString(10, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_data_path_report WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int delete(String operationBo, String filePath, String waferBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "DELETE FROM zr_data_path_report WHERE operation_bo=? AND file_path=? AND wafer_bo=?")) {
      ps.setString(1, operationBo);
      ps.setString(2, filePath);
      ps.setString(3, waferBo);

      return ps.executeUpdate();
    }
  }

  public List<DataPathReport> selectAll() throws SQLException {
    ArrayList<DataPathReport> result = new ArrayList<DataPathReport>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public DataPathReport selectByPK(String id) throws SQLException {
    DataPathReport result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private DataPathReport convert(ResultSet rs) throws SQLException {
    DataPathReport data = new DataPathReport();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setFilePath(rs.getString(index++));
    data.setNums(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setWaferBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));
    data.setCreatedUser(rs.getString(index++));
    data.setFileType(rs.getString(index++));

    return data;
  }
}
