package ame.psb.db.dao;

import ame.psb.db.DcopResultState;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class DcopResultStateDao {

  private static final String SQL_INS = "INSERT INTO zr_dcop_result_state(id,sfc_bo,item_group_bo,operation_bo,dcop_group_bo,dcop_result_state,dcop_result_bo,update_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_dcop_result_state SET sfc_bo=?,item_group_bo=?,operation_bo=?,dcop_group_bo=?,dcop_result_state=?,dcop_result_bo=?,update_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sfc_bo,item_group_bo,operation_bo,dcop_group_bo,dcop_result_state,dcop_result_bo,update_time FROM zr_dcop_result_state ";

  private final Connection conn;

  public DcopResultStateDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DcopResultState data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getItemGroupBo());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getDcopGroupBo());
      ps.setString(6, data.getDcopResultState());
      ps.setString(7, data.getDcopResultBo());
      DateUtils.setDateTz(ps, 8, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DcopResultState> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DcopResultState data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getItemGroupBo());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getDcopGroupBo());
        ps.setString(6, data.getDcopResultState());
        ps.setString(7, data.getDcopResultBo());
        DateUtils.setDateTz(ps, 8, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DcopResultState data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getItemGroupBo());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getDcopGroupBo());
      ps.setString(5, data.getDcopResultState());
      ps.setString(6, data.getDcopResultBo());
      DateUtils.setDateTz(ps, 7, data.getUpdateTime());
      ps.setString(8, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<DcopResultState> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DcopResultState data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getItemGroupBo());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getDcopGroupBo());
        ps.setString(5, data.getDcopResultState());
        ps.setString(6, data.getDcopResultBo());
        DateUtils.setDateTz(ps, 7, data.getUpdateTime());
        ps.setString(8, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_dcop_result_state WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<DcopResultState> selectAll() throws SQLException {
    ArrayList<DcopResultState> result = new ArrayList<DcopResultState>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public DcopResultState selectByPK(String id) throws SQLException {
    DcopResultState result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<DcopResultState> selectBySfcOperation(String sfcBo, String operationBo)
      throws SQLException {
    ArrayList<DcopResultState> result = new ArrayList<DcopResultState>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND operation_bo =?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private DcopResultState convert(ResultSet rs) throws SQLException {
    DcopResultState data = new DcopResultState();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setDcopGroupBo(rs.getString(index++));
    data.setDcopResultState(rs.getString(index++));
    data.setDcopResultBo(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
