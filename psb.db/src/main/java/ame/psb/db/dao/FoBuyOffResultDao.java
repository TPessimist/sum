package ame.psb.db.dao;

import ame.psb.db.FoBuyOffResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FoBuyOffResultDao {

  private static final String SQL_INS = "INSERT INTO zr_fo_buyoff_result(id,item_group_bo,operation_bo,operation,hold_type,sfc_bo,state,updated_user,updated_time,reverse_field1,reverse_field2) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_fo_buyoff_result SET item_group_bo=?,operation_bo=?,operation=?,hold_type=?,sfc_bo=?,state=?,updated_user=?,updated_time=?,reverse_field1=?,reverse_field2=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,item_group_bo,operation_bo,operation,hold_type,sfc_bo,state,updated_user,updated_time,reverse_field1,reverse_field2 FROM zr_fo_buyoff_result ";

  private final Connection conn;

  public FoBuyOffResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FoBuyOffResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getItemGroupBo());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getOperation());
      ps.setString(5, data.getHoldType());
      ps.setString(6, data.getSfcBo());
      ps.setString(7, data.getState());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getReverseField1());
      ps.setString(11, data.getReverseField2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FoBuyOffResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FoBuyOffResult data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getItemGroupBo());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getOperation());
        ps.setString(5, data.getHoldType());
        ps.setString(6, data.getSfcBo());
        ps.setString(7, data.getState());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getReverseField1());
        ps.setString(11, data.getReverseField2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FoBuyOffResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getOperation());
      ps.setString(4, data.getHoldType());
      ps.setString(5, data.getSfcBo());
      ps.setString(6, data.getState());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getReverseField1());
      ps.setString(10, data.getReverseField2());
      ps.setString(11, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FoBuyOffResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FoBuyOffResult data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getOperation());
        ps.setString(4, data.getHoldType());
        ps.setString(5, data.getSfcBo());
        ps.setString(6, data.getState());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getReverseField1());
        ps.setString(10, data.getReverseField2());
        ps.setString(11, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_fo_buyoff_result WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<FoBuyOffResult> selectAll() throws SQLException {
    ArrayList<FoBuyOffResult> result = new ArrayList<FoBuyOffResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FoBuyOffResult> selectAllByState() throws SQLException {
    ArrayList<FoBuyOffResult> result = new ArrayList<FoBuyOffResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE state='NEW' ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public FoBuyOffResult selectBySfcAndItemGroup(String itemGroupBo, String sfcBo,
      String operationBo) throws SQLException {
    FoBuyOffResult result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + " WHERE item_group_bo=? and sfc_bo=? and operation_bo=? and state='NEW' ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, sfcBo);
      ps.setString(3, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FoBuyOffResult selectByPK(String id) throws SQLException {
    FoBuyOffResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FoBuyOffResult convert(ResultSet rs) throws SQLException {
    FoBuyOffResult data = new FoBuyOffResult();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setHoldType(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setReverseField1(rs.getString(index++));
    data.setReverseField2(rs.getString(index++));

    return data;
  }
}
