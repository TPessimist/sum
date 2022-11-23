package ame.psb.db.dao;

import ame.psb.db.ZdSubordinateDifferenceOperation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZdSubordinateDifferenceOperationDao {

  private static final String SQL_INS = "INSERT INTO zd_subordinate_difference_operation(subordinate_difference_bo,operation_bo,difference_bo,describe,reverse_field1,reverse_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_subordinate_difference_operation SET describe=?,reverse_field1=?,reverse_field2=?,updated_user=?,updated_time=? WHERE subordinate_difference_bo=? AND operation_bo=? AND difference_bo=?";

  private static final String SQL_SEL = "SELECT subordinate_difference_bo,operation_bo,difference_bo,describe,reverse_field1,reverse_field2,updated_user,updated_time FROM zd_subordinate_difference_operation ";

  private final Connection conn;

  public ZdSubordinateDifferenceOperationDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdSubordinateDifferenceOperation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSubordinateDifferenceBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getDifferenceBo());
      ps.setString(4, data.getDescribe());
      ps.setString(5, data.getReverseField1());
      ps.setString(6, data.getReverseField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdSubordinateDifferenceOperation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdSubordinateDifferenceOperation data : dataList) {
        ps.setString(1, data.getSubordinateDifferenceBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getDifferenceBo());
        ps.setString(4, data.getDescribe());
        ps.setString(5, data.getReverseField1());
        ps.setString(6, data.getReverseField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZdSubordinateDifferenceOperation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDescribe());
      ps.setString(2, data.getReverseField1());
      ps.setString(3, data.getReverseField2());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getSubordinateDifferenceBo());
      ps.setString(7, data.getOperationBo());
      ps.setString(8, data.getDifferenceBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZdSubordinateDifferenceOperation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZdSubordinateDifferenceOperation data : dataList) {
        ps.setString(1, data.getDescribe());
        ps.setString(2, data.getReverseField1());
        ps.setString(3, data.getReverseField2());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getSubordinateDifferenceBo());
        ps.setString(7, data.getOperationBo());
        ps.setString(8, data.getDifferenceBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String subordinateDifferenceBo, String operationBo, String differenceBo)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_subordinate_difference_operation WHERE subordinate_difference_bo=? AND operation_bo=? AND difference_bo=?")) {
      ps.setString(1, subordinateDifferenceBo);
      ps.setString(2, operationBo);
      ps.setString(3, differenceBo);

      return ps.executeUpdate();
    }
  }

  public List<ZdSubordinateDifferenceOperation> selectAll() throws SQLException {
    ArrayList<ZdSubordinateDifferenceOperation> result = new ArrayList<ZdSubordinateDifferenceOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZdSubordinateDifferenceOperation> selectByDiffBoAndOperationBo(
      String subordinateDifferenceBo,
      String operationBo) throws SQLException {
    ArrayList<ZdSubordinateDifferenceOperation> result = new ArrayList<ZdSubordinateDifferenceOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE subordinate_difference_bo=? AND operation_bo=?")) {
      ps.setString(1, subordinateDifferenceBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZdSubordinateDifferenceOperation> selectByDiffByUUID(
      String subordinateDifferenceBo) throws SQLException {
    ArrayList<ZdSubordinateDifferenceOperation> result = new ArrayList<ZdSubordinateDifferenceOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE subordinate_difference_bo=? ")) {
      ps.setString(1, subordinateDifferenceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ZdSubordinateDifferenceOperation selectByPK(String subordinateDifferenceBo,
      String operationBo, String differenceBo) throws SQLException {
    ZdSubordinateDifferenceOperation result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE subordinate_difference_bo=? AND operation_bo=? AND difference_bo=?")) {
      ps.setString(1, subordinateDifferenceBo);
      ps.setString(2, operationBo);
      ps.setString(3, differenceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZdSubordinateDifferenceOperation convert(ResultSet rs) throws SQLException {
    ZdSubordinateDifferenceOperation data = new ZdSubordinateDifferenceOperation();

    int index = 1;
    data.setSubordinateDifferenceBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDifferenceBo(rs.getString(index++));
    data.setDescribe(rs.getString(index++));
    data.setReverseField1(rs.getString(index++));
    data.setReverseField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
