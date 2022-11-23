package ame.psb.db.dao;

import ame.psb.db.MtBindOperation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class MtBindOperationDao {

  private static final String SQL_INS = "INSERT INTO zd_mt_bind_operaton(bom_component_item_bo,start_operation_bo,end_operation_bo,updated_user,updated_time) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_mt_bind_operaton SET updated_user=?,updated_time=? WHERE bom_component_item_bo=? AND start_operation_bo=? AND end_operation_bo=?";

  private static final String SQL_SEL = "SELECT bom_component_item_bo,start_operation_bo,end_operation_bo,updated_user,updated_time FROM zd_mt_bind_operaton ";

  private final Connection conn;

  public MtBindOperationDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(MtBindOperation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getBomComponentItemBo());
      ps.setString(2, data.getStartOperationBo());
      ps.setString(3, data.getEndOperationBo());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<MtBindOperation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (MtBindOperation data : dataList) {
        ps.setString(1, data.getBomComponentItemBo());
        ps.setString(2, data.getStartOperationBo());
        ps.setString(3, data.getEndOperationBo());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(MtBindOperation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 2, data.getUpdatedTime());
      ps.setString(3, data.getBomComponentItemBo());
      ps.setString(4, data.getStartOperationBo());
      ps.setString(5, data.getEndOperationBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<MtBindOperation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (MtBindOperation data : dataList) {
        ps.setString(1, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 2, data.getUpdatedTime());
        ps.setString(3, data.getBomComponentItemBo());
        ps.setString(4, data.getStartOperationBo());
        ps.setString(5, data.getEndOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String bomComponentItemBo, String startOperationBo, String endOperationBo)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_mt_bind_operaton WHERE bom_component_item_bo=? AND start_operation_bo=? AND end_operation_bo=?")) {
      ps.setString(1, bomComponentItemBo);
      ps.setString(2, startOperationBo);
      ps.setString(3, endOperationBo);

      return ps.executeUpdate();
    }
  }

  public List<MtBindOperation> selectAll() throws SQLException {
    ArrayList<MtBindOperation> result = new ArrayList<MtBindOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public MtBindOperation selectByPK(String bomComponentItemBo, String startOperationBo,
      String endOperationBo) throws SQLException {
    MtBindOperation result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE bom_component_item_bo=? AND start_operation_bo=? AND end_operation_bo=?")) {
      ps.setString(1, bomComponentItemBo);
      ps.setString(2, startOperationBo);
      ps.setString(3, endOperationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private MtBindOperation convert(ResultSet rs) throws SQLException {
    MtBindOperation data = new MtBindOperation();

    int index = 1;
    data.setBomComponentItemBo(rs.getString(index++));
    data.setStartOperationBo(rs.getString(index++));
    data.setEndOperationBo(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
