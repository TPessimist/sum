package ame.psb.db.dao;

import ame.psb.db.NewLotAaSetting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class NewLotAaSettingDao {

  private static final String SQL_INS = "INSERT INTO zd_aa_new_lot_setting(customer_bo,department_bo,lot_type,operation_bo,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_aa_new_lot_setting SET reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE customer_bo=? AND department_bo=? AND lot_type=? AND operation_bo=?";

  private static final String SQL_SEL = "SELECT customer_bo,department_bo,lot_type,operation_bo,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_aa_new_lot_setting ";

  private final Connection conn;

  public NewLotAaSettingDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(NewLotAaSetting data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerBo());
      ps.setString(2, data.getDepartmentBo());
      ps.setString(3, data.getLotType());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<NewLotAaSetting> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (NewLotAaSetting data : dataList) {
        ps.setString(1, data.getCustomerBo());
        ps.setString(2, data.getDepartmentBo());
        ps.setString(3, data.getLotType());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(NewLotAaSetting data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getReversedField1());
      ps.setString(2, data.getReversedField2());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getCustomerBo());
      ps.setString(6, data.getDepartmentBo());
      ps.setString(7, data.getLotType());
      ps.setString(8, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<NewLotAaSetting> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (NewLotAaSetting data : dataList) {
        ps.setString(1, data.getReversedField1());
        ps.setString(2, data.getReversedField2());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getCustomerBo());
        ps.setString(6, data.getDepartmentBo());
        ps.setString(7, data.getLotType());
        ps.setString(8, data.getOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerBo, String departmentBo, String lotType, String operationBo)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_aa_new_lot_setting WHERE customer_bo=? AND department_bo=? AND lot_type=? AND operation_bo=?")) {
      ps.setString(1, customerBo);
      ps.setString(2, departmentBo);
      ps.setString(3, lotType);
      ps.setString(4, operationBo);

      return ps.executeUpdate();
    }
  }

  public List<NewLotAaSetting> selectAll() throws SQLException {
    ArrayList<NewLotAaSetting> result = new ArrayList<NewLotAaSetting>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public NewLotAaSetting selectByPK(String customerBo, String departmentBo, String lotType,
      String operationBo) throws SQLException {
    NewLotAaSetting result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE customer_bo=? AND department_bo=? AND lot_type=? AND operation_bo=?")) {
      ps.setString(1, customerBo);
      ps.setString(2, departmentBo);
      ps.setString(3, lotType);
      ps.setString(4, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public NewLotAaSetting selectByCustomerAndDepartmentAndLotType(String customerBo,
      String departmentBo, String lotType) throws SQLException {
    NewLotAaSetting result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_bo=? AND department_bo=? AND lot_type=? ")) {
      ps.setString(1, customerBo);
      ps.setString(2, departmentBo);
      ps.setString(3, lotType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private NewLotAaSetting convert(ResultSet rs) throws SQLException {
    NewLotAaSetting data = new NewLotAaSetting();

    int index = 1;
    data.setCustomerBo(rs.getString(index++));
    data.setDepartmentBo(rs.getString(index++));
    data.setLotType(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
