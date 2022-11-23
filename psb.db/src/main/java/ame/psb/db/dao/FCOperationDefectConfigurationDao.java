package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FCOperationDefectConfiguration;
import uia.utils.dao.DateUtils;

public class FCOperationDefectConfigurationDao {

  private static final String SQL_INS = "INSERT INTO zd_fc_operation_defect_configuration(package_name,configuration_type,seq,operation_bo,reversed_field1,reversed_field2,modify_user,modify_time,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_fc_operation_defect_configuration SET operation_bo=?,reversed_field1=?,reversed_field2=?,modify_user=?,modify_time=?,update_user=?,update_time=? WHERE package_name=? AND configuration_type=? AND seq=?";

  private static final String SQL_SEL = "SELECT package_name,configuration_type,seq,operation_bo,reversed_field1,reversed_field2,modify_user,modify_time,update_user,update_time FROM zd_fc_operation_defect_configuration ";

  private final Connection conn;

  public FCOperationDefectConfigurationDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FCOperationDefectConfiguration data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getPackageName());
      ps.setString(2, data.getConfigurationType());
      ps.setString(3, data.getSeq());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getModifyUser());
      DateUtils.setDateTz(ps, 8, data.getModifyTime());
      ps.setString(9, data.getUpdateUser());
      DateUtils.setDateTz(ps, 10, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FCOperationDefectConfiguration> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FCOperationDefectConfiguration data : dataList) {
        ps.setString(1, data.getPackageName());
        ps.setString(2, data.getConfigurationType());
        ps.setString(3, data.getSeq());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getModifyUser());
        DateUtils.setDateTz(ps, 8, data.getModifyTime());
        ps.setString(9, data.getUpdateUser());
        DateUtils.setDateTz(ps, 10, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FCOperationDefectConfiguration data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getOperationBo());
      ps.setString(2, data.getReversedField1());
      ps.setString(3, data.getReversedField2());
      ps.setString(4, data.getModifyUser());
      DateUtils.setDateTz(ps, 5, data.getModifyTime());
      ps.setString(6, data.getUpdateUser());
      DateUtils.setDateTz(ps, 7, data.getUpdateTime());
      ps.setString(8, data.getPackageName());
      ps.setString(9, data.getConfigurationType());
      ps.setString(10, data.getSeq());

      return ps.executeUpdate();
    }
  }

  public int update(List<FCOperationDefectConfiguration> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FCOperationDefectConfiguration data : dataList) {
        ps.setString(1, data.getOperationBo());
        ps.setString(2, data.getReversedField1());
        ps.setString(3, data.getReversedField2());
        ps.setString(4, data.getModifyUser());
        DateUtils.setDateTz(ps, 5, data.getModifyTime());
        ps.setString(6, data.getUpdateUser());
        DateUtils.setDateTz(ps, 7, data.getUpdateTime());
        ps.setString(8, data.getPackageName());
        ps.setString(9, data.getConfigurationType());
        ps.setString(10, data.getSeq());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String packageName, String configurationType, String seq) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_fc_operation_defect_configuration WHERE package_name=? AND configuration_type=? AND seq=?")) {
      ps.setString(1, packageName);
      ps.setString(2, configurationType);
      ps.setString(3, seq);

      return ps.executeUpdate();
    }
  }

  public int delete(String packageName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_fc_operation_defect_configuration WHERE package_name=? ")) {
      ps.setString(1, packageName);

      return ps.executeUpdate();
    }
  }

  public List<FCOperationDefectConfiguration> selectAll() throws SQLException {
    ArrayList<FCOperationDefectConfiguration> result = new ArrayList<FCOperationDefectConfiguration>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FCOperationDefectConfiguration selectByPK(String packageName, String configurationType,
      String seq) throws SQLException {
    FCOperationDefectConfiguration result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE package_name=? AND configuration_type=? AND seq=?")) {
      ps.setString(1, packageName);
      ps.setString(2, configurationType);
      ps.setString(3, seq);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<FCOperationDefectConfiguration> selectByPackageNameAndType(String packageName,
      String configurationType) throws SQLException {
    List<FCOperationDefectConfiguration> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE package_name=? AND configuration_type=? ")) {
      ps.setString(1, packageName);
      ps.setString(2, configurationType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FCOperationDefectConfiguration> selectByPackageName(String packageName)
      throws SQLException {
    List<FCOperationDefectConfiguration> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE package_name=? ")) {
      ps.setString(1, packageName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FCOperationDefectConfiguration> selectByPackageNameAndOperationBo(String packageName,
      String operationBo) throws SQLException {
    List<FCOperationDefectConfiguration> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE package_name=? and  operation_bo =? ")) {
      ps.setString(1, packageName);
      ps.setString(2, operationBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private FCOperationDefectConfiguration convert(ResultSet rs) throws SQLException {
    FCOperationDefectConfiguration data = new FCOperationDefectConfiguration();

    int index = 1;
    data.setPackageName(rs.getString(index++));
    data.setConfigurationType(rs.getString(index++));
    data.setSeq(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setModifyUser(rs.getString(index++));
    data.setModifyTime(DateUtils.getDateTz(rs, index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
