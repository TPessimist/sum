package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FtSblValueLog;
import uia.utils.dao.DateUtils;

public class FtSblValueLogDao {

  private static final String SQL_INS = "INSERT INTO zr_ft_sbl_value_log(uuid,sfc_bo,item_group_bo,operation_bo,nc_code_bo,nc_code_value,sbl_param_bo,sbl_value,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_ft_sbl_value_log SET sfc_bo=?,item_group_bo=?,operation_bo=?,nc_code_bo=?,nc_code_value=?,sbl_param_bo=?,sbl_value=?,updated_user=?,updated_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,sfc_bo,item_group_bo,operation_bo,nc_code_bo,nc_code_value,sbl_param_bo,sbl_value,updated_user,updated_time FROM zr_ft_sbl_value_log ";

  private final Connection conn;

  public FtSblValueLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FtSblValueLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getItemGroupBo());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getNcCodeBo());
      ps.setString(6, data.getNcCodeValue());
      ps.setString(7, data.getSblParamBo());
      ps.setString(8, data.getSblValue());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FtSblValueLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FtSblValueLog data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getItemGroupBo());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getNcCodeBo());
        ps.setString(6, data.getNcCodeValue());
        ps.setString(7, data.getSblParamBo());
        ps.setString(8, data.getSblValue());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FtSblValueLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getItemGroupBo());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getNcCodeBo());
      ps.setString(5, data.getNcCodeValue());
      ps.setString(6, data.getSblParamBo());
      ps.setString(7, data.getSblValue());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<FtSblValueLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FtSblValueLog data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getItemGroupBo());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getNcCodeBo());
        ps.setString(5, data.getNcCodeValue());
        ps.setString(6, data.getSblParamBo());
        ps.setString(7, data.getSblValue());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_ft_sbl_value_log WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<FtSblValueLog> selectAll() throws SQLException {
    ArrayList<FtSblValueLog> result = new ArrayList<FtSblValueLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FtSblValueLog selectByPK(String uuid) throws SQLException {
    FtSblValueLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FtSblValueLog convert(ResultSet rs) throws SQLException {
    FtSblValueLog data = new FtSblValueLog();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setNcCodeBo(rs.getString(index++));
    data.setNcCodeValue(rs.getString(index++));
    data.setSblParamBo(rs.getString(index++));
    data.setSblValue(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
