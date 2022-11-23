package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FCSpecialOperationDefectConfigure;
import uia.utils.dao.DateUtils;

public class FCSpecialOperationDefectConfigureDao {

  private static final String SQL_INS = "INSERT INTO zd_fc_special_operation_defect_configure(id,operation_bo,host_nc_code,last_nc_code,state_name,reversed_field1,reversed_field2,created_user,created_time,modified_user,modified_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_fc_special_operation_defect_configure SET operation_bo=?,host_nc_code=?,last_nc_code=?,state_name=?,reversed_field1=?,reversed_field2=?,created_user=?,created_time=?,modified_user=?,modified_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,operation_bo,host_nc_code,last_nc_code,state_name,reversed_field1,reversed_field2,created_user,created_time,modified_user,modified_time FROM zd_fc_special_operation_defect_configure ";

  private final Connection conn;

  public FCSpecialOperationDefectConfigureDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FCSpecialOperationDefectConfigure data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getHostNcCode());
      ps.setString(4, data.getLastNcCode());
      ps.setString(5, data.getStateName());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getCreatedUser());
      DateUtils.setDateTz(ps, 9, data.getCreatedTime());
      ps.setString(10, data.getModifiedUser());
      DateUtils.setDateTz(ps, 11, data.getModifiedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FCSpecialOperationDefectConfigure> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FCSpecialOperationDefectConfigure data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getHostNcCode());
        ps.setString(4, data.getLastNcCode());
        ps.setString(5, data.getStateName());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getCreatedUser());
        DateUtils.setDateTz(ps, 9, data.getCreatedTime());
        ps.setString(10, data.getModifiedUser());
        DateUtils.setDateTz(ps, 11, data.getModifiedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FCSpecialOperationDefectConfigure data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getOperationBo());
      ps.setString(2, data.getHostNcCode());
      ps.setString(3, data.getLastNcCode());
      ps.setString(4, data.getStateName());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getCreatedUser());
      DateUtils.setDateTz(ps, 8, data.getCreatedTime());
      ps.setString(9, data.getModifiedUser());
      DateUtils.setDateTz(ps, 10, data.getModifiedTime());
      ps.setString(11, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FCSpecialOperationDefectConfigure> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FCSpecialOperationDefectConfigure data : dataList) {
        ps.setString(1, data.getOperationBo());
        ps.setString(2, data.getHostNcCode());
        ps.setString(3, data.getLastNcCode());
        ps.setString(4, data.getStateName());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getCreatedUser());
        DateUtils.setDateTz(ps, 8, data.getCreatedTime());
        ps.setString(9, data.getModifiedUser());
        DateUtils.setDateTz(ps, 10, data.getModifiedTime());
        ps.setString(11, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_fc_special_operation_defect_configure WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<FCSpecialOperationDefectConfigure> selectAll() throws SQLException {
    ArrayList<FCSpecialOperationDefectConfigure> result = new ArrayList<FCSpecialOperationDefectConfigure>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FCSpecialOperationDefectConfigure selectByPK(String id) throws SQLException {
    FCSpecialOperationDefectConfigure result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<FCSpecialOperationDefectConfigure> selectByOperationBo(String OperationBo)
      throws SQLException {
    List<FCSpecialOperationDefectConfigure> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE OPERATION_BO=?")) {
      ps.setString(1, OperationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private FCSpecialOperationDefectConfigure convert(ResultSet rs) throws SQLException {
    FCSpecialOperationDefectConfigure data = new FCSpecialOperationDefectConfigure();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setHostNcCode(rs.getString(index++));
    data.setLastNcCode(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setCreatedUser(rs.getString(index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedUser(rs.getString(index++));
    data.setModifiedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
